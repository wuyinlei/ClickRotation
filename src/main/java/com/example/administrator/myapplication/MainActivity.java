package com.example.administrator.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView iv, iv2, iv3, iv4;
    int screenWidth;
    int screenHeigh;
    int width, height;
    private ScrollView mScrollView;
    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.icon);
        iv2 = (ImageView) findViewById(R.id.icon2);
        iv3 = (ImageView) findViewById(R.id.icon3);
        iv4 = (ImageView) findViewById(R.id.icon4);
        mScrollView = (ScrollView) findViewById(R.id.mScrollView);
        iv.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
        WindowManager manager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        screenWidth = manager.getDefaultDisplay().getWidth();
        screenHeigh = manager.getDefaultDisplay().getHeight();


        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AA.class);
                MainActivity.this.startActivity(intent);
            }
        });

        mScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                iv.setVisibility(View.GONE);
                iv2.setVisibility(View.GONE);
                iv3.setVisibility(View.GONE);
                iv4.setVisibility(View.GONE);
                return false;
            }
        });


    }


    private void panduanzhi() {
       /* if (isFirst) {
            isFirst = false;
            iv.setVisibility(View.VISIBLE);
            iv.setAlpha(0);
            iv2.setVisibility(View.VISIBLE);
            iv2.setAlpha(0);
            iv3.setVisibility(View.VISIBLE);
            iv3.setAlpha(0);
            iv4.setVisibility(View.VISIBLE);
            iv4.setAlpha(0);
        }
        else if (!isFirst){
            iv.setVisibility(View.VISIBLE);
            iv.setAlpha(255);
            iv2.setVisibility(View.VISIBLE);
            iv2.setAlpha(255);
            iv3.setVisibility(View.VISIBLE);
            iv3.setAlpha(255);
            iv4.setVisibility(View.VISIBLE);
            iv4.setAlpha(255);
        }*/

        iv.setVisibility(View.VISIBLE);
        iv2.setVisibility(View.VISIBLE);
        iv3.setVisibility(View.VISIBLE);
        iv4.setVisibility(View.VISIBLE);


        iv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                iv.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                width = iv.getWidth();
                height = iv.getHeight();

                //旋转360度
                ObjectAnimator.ofFloat(iv, "rotation", 0, 360F).setDuration(1200).start();
                //
                ObjectAnimator.ofFloat(iv, "x", -100, (screenWidth / 2) - width).setDuration(1200).start();
                ObjectAnimator.ofFloat(iv, "y", -100, (screenHeigh / 2) - height).setDuration(1200).start();


                ObjectAnimator.ofFloat(iv2, "rotation", -360f, 0).setDuration(1200).start();
                ObjectAnimator.ofFloat(iv2, "x", screenWidth, (screenWidth / 2)).setDuration(1200).start();
                ObjectAnimator.ofFloat(iv2, "y", -100, (screenHeigh / 2) - height).setDuration(1200).start();

                ObjectAnimator.ofFloat(iv3, "rotation", 0, 360F).setDuration(1200).start();
                ObjectAnimator.ofFloat(iv3, "x", -100, (screenWidth / 2) - width).setDuration(1200).start();
                ObjectAnimator.ofFloat(iv3, "y", screenHeigh, (screenHeigh / 2)).setDuration(1200).start();

                ObjectAnimator.ofFloat(iv4, "rotation", 0, 360F).setDuration(1200).start();
                ObjectAnimator.ofFloat(iv4, "x", screenWidth, screenWidth / 2).setDuration(1200).start();
                ObjectAnimator.ofFloat(iv4, "y", screenHeigh, screenHeigh / 2).setDuration(1200).start();

            }
        });




      /*  ObjectAnimator.ofFloat(iv,"rotation",0,360F).setDuration(1200).start();
        ObjectAnimator.ofFloat(iv,"x",-200,(screenWidth/2)-200).setDuration(1200).start();
        ObjectAnimator.ofFloat(iv,"y",-200,(screenHeigh/2)-200).setDuration(1200).start();

        ObjectAnimator.ofFloat(iv2,"rotation",0,360F).setDuration(1200).start();
        ObjectAnimator.ofFloat(iv2,"x",screenWidth-200,(screenWidth/2)).setDuration(1200).start();
        ObjectAnimator.ofFloat(iv2,"y",0,(screenHeigh/2)-200).setDuration(1200).start();

        ObjectAnimator.ofFloat(iv3,"rotation",0,360F).setDuration(1200).start();
        ObjectAnimator.ofFloat(iv3,"x",0,(screenWidth/2)-200).setDuration(1200).start();
        ObjectAnimator.ofFloat(iv3,"y",screenHeigh-200,(screenHeigh/2)).setDuration(1200).start();

        ObjectAnimator.ofFloat(iv4,"rotation",0,360F).setDuration(1200).start();
        ObjectAnimator.ofFloat(iv4,"x",screenWidth-200,screenWidth/2).setDuration(1200).start();
        ObjectAnimator.ofFloat(iv4,"y",screenHeigh-200,screenHeigh/2).setDuration(1200).start();*/



    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, AA.class);
        switch (v.getId()) {
            case R.id.button:

                panduanzhi();
                break;
            case R.id.icon:
                MainActivity.this.startActivity(intent);
                break;
            case R.id.icon2:
                MainActivity.this.startActivity(intent);
                break;
            case R.id.icon3:
                MainActivity.this.startActivity(intent);
                break;
            case R.id.icon4:
                MainActivity.this.startActivity(intent);
                break;
        }
    }
}

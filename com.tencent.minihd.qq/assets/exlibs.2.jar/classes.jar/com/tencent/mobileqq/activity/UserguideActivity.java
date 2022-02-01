package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import fmr;
import fms;

public class UserguideActivity
  extends UserguideBaseActivity
{
  static boolean jdField_a_of_type_Boolean = false;
  static boolean jdField_b_of_type_Boolean = false;
  static boolean c = false;
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new fms(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  private int a(int paramInt)
  {
    return (int)(this.jdField_a_of_type_Float * paramInt + 0.5F);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(SplashActivity paramSplashActivity)
  {
    return false;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    int i = ((Drawable)localObject).getIntrinsicWidth();
    int k = ((Drawable)localObject).getIntrinsicHeight();
    int n = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
    int i1 = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
    int m = (this.jdField_a_of_type_AndroidViewView.getHeight() - this.jdField_a_of_type_AndroidViewView.getPaddingTop() - this.jdField_a_of_type_AndroidViewView.getPaddingBottom() - i1) / 2;
    int j = a(90);
    float f;
    if (i1 < k)
    {
      f = i1 / k;
      i = 0;
    }
    for (;;)
    {
      n = (int)(j * f);
      if (this.jdField_a_of_type_Int == 0)
      {
        j = this.jdField_b_of_type_AndroidWidgetImageView.getWidth();
        k = this.jdField_b_of_type_AndroidWidgetImageView.getHeight();
        this.jdField_a_of_type_Int = j;
        this.jdField_b_of_type_Int = k;
      }
      for (;;)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = ((int)(j * f));
        ((FrameLayout.LayoutParams)localObject).height = ((int)(f * k));
        ((FrameLayout.LayoutParams)localObject).bottomMargin = (i + (m + n - ((FrameLayout.LayoutParams)localObject).height));
        ((FrameLayout.LayoutParams)localObject).gravity = 81;
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        if (n >= i) {
          break label246;
        }
        f = n / i;
        i = (i1 - (int)(k * f)) / 2;
        break;
        j = this.jdField_a_of_type_Int;
        k = this.jdField_b_of_type_Int;
      }
      label246:
      f = 1.0F;
      i = 0;
    }
  }
  
  private static boolean b()
  {
    return false;
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904059);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300658);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300659));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300660));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new fmr(this));
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.d("UserguideBaseActivity", 4, "UserguideActivity.doOnDestroy()");
    }
    System.gc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserguideActivity
 * JD-Core Version:    0.7.0.1
 */
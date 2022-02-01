package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.QLog;
import fmt;
import fmu;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class UserguideBaseActivity
  extends AppActivity
{
  public static final String a = "UserguideBaseActivity";
  protected int c;
  protected int d;
  public boolean d;
  protected boolean e = false;
  
  public UserguideBaseActivity()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    try
    {
      int m = this.c;
      int k = this.jdField_d_of_type_Int;
      int j;
      if (m * 720 >= 450 * k) {
        j = 600 * k / 720;
      }
      for (int i = k * 900 / 720;; i = m * 900 / 450)
      {
        m = (j - m) / 2;
        k = (i - k) / 2;
        if (m < 0) {
          return paramBitmap;
        }
        if (k >= 0) {
          break;
        }
        return paramBitmap;
        j = 600 * m / 450;
      }
      Bitmap localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, j, i, true);
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, m, k, this.c, this.jdField_d_of_type_Int);
      localBitmap1.recycle();
      return localBitmap2;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("UserguideBaseActivity", 2, "getFitScreenBitmap + " + localException.toString());
        return paramBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("UserguideBaseActivity", 2, "OutOfMemoryError + " + localOutOfMemoryError.toString());
      }
    }
    return paramBitmap;
  }
  
  public void a()
  {
    Intent localIntent = getIntent();
    UserguideActivity.a = false;
    if ((getAppRuntime() != null) && (getAppRuntime().isLogin()))
    {
      localIntent.setClass(this, SplashActivity.class);
      localIntent.putExtra("tab_index", 1);
    }
    for (;;)
    {
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      return;
      localIntent.setClass(this, LoginActivity.class);
    }
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserguideBaseActivity", 2, "fadeOut");
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968628);
    localAnimation.setAnimationListener(new fmt(this, paramView));
    paramView.startAnimation(localAnimation);
  }
  
  protected void a(View paramView, int paramInt)
  {
    Bitmap localBitmap = a(SkinUtils.a(getResources().getDrawable(paramInt)));
    paramView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserguideBaseActivity", 2, "fadeIn");
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968627);
    localAnimation.setAnimationListener(new fmu(this, paramView));
    paramView.startAnimation(localAnimation);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.c = getResources().getDisplayMetrics().widthPixels;
    this.jdField_d_of_type_Int = getResources().getDisplayMetrics().heightPixels;
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    this.jdField_d_of_type_Boolean = true;
    super.doOnDestroy();
  }
  
  public void finish()
  {
    if (isFinishing())
    {
      QLog.d("UserguideBaseActivity", 1, getClass() + " call finish again");
      return;
    }
    a("UserguideBaseActivity", "finish normalExist[" + this.jdField_d_of_type_Boolean + "] goToLoginScreenAlready[" + this.e + "]");
    if ((!this.jdField_d_of_type_Boolean) && (!this.e))
    {
      UserguideActivity.b = false;
      UserguideActivity.c = false;
      UserguideActivity.a = false;
      this.e = true;
      a();
    }
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserguideBaseActivity
 * JD-Core Version:    0.7.0.1
 */
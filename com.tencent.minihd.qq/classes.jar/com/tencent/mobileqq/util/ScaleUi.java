package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import java.lang.reflect.Field;

public class ScaleUi
{
  public static final float a = 0.85F;
  private static final int jdField_a_of_type_Int = 1024;
  private static ScaleUi jdField_a_of_type_ComTencentMobileqqUtilScaleUi;
  private static final int jdField_b_of_type_Int = 768;
  private static final int c = 160;
  private static final int d = 1;
  private DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  private DisplayMetrics jdField_b_of_type_AndroidUtilDisplayMetrics;
  
  private ScaleUi(Context paramContext)
  {
    this.b = new DisplayMetrics();
    this.jdField_a_of_type_AndroidUtilDisplayMetrics.setTo(paramContext.getResources().getDisplayMetrics());
    this.b.setTo(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    d(paramContext);
    b(paramContext);
  }
  
  public static float a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getFloat("screen_sacle", -1.0F);
  }
  
  public static ScaleUi a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilScaleUi == null) {
      throw new IllegalStateException("should call initialize firstly");
    }
    return jdField_a_of_type_ComTencentMobileqqUtilScaleUi;
  }
  
  public static Object a(Object paramObject, Class paramClass, String paramString)
  {
    Class localClass = paramClass;
    if (paramClass == null) {
      localClass = paramObject.getClass();
    }
    try
    {
      paramClass = localClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramObject = paramClass.get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      return null;
    }
    catch (NoSuchFieldException paramObject)
    {
      label31:
      break label31;
    }
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilScaleUi == null)
    {
      jdField_a_of_type_ComTencentMobileqqUtilScaleUi = new ScaleUi(paramContext);
      return;
    }
    jdField_a_of_type_ComTencentMobileqqUtilScaleUi.b(paramContext);
  }
  
  public static void a(Context paramContext, float paramFloat)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putFloat("screen_sacle", paramFloat).commit();
  }
  
  public static float b(Context paramContext)
  {
    int j = SizeMeasure.a(paramContext);
    Log.i("app2", "getTabNavBarAvailableHeight headTabHeight=" + j);
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    int k = localResources.getDimensionPixelSize(2131492899);
    int m = localResources.getDimensionPixelSize(2131492993);
    int i = localDisplayMetrics.heightPixels;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels) {
      i = localDisplayMetrics.widthPixels;
    }
    i -= m * 2 + k / 2;
    paramContext = LayoutInflater.from(paramContext).inflate(2130903370, null);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramContext.setPadding(0, 0, 0, k);
    ((ImageView)paramContext.findViewById(2131297979)).setBackgroundResource(2130842014);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(i, -2147483648));
    m = paramContext.getMeasuredHeight();
    int n = (int)(m / localDisplayMetrics.density);
    Log.i("app2", "getTabNavBarAvailableHeight itemHeight=" + m + " itemH4Dp=" + n + " paddingBottom" + k);
    float f = (i - j) / (n * 5);
    Log.i("app2", "getTabNavBarAvailableHeight dm=" + localDisplayMetrics.density + " newDensity=" + f);
    return f;
  }
  
  private void d(Context paramContext)
  {
    Log.i("app2", "original-->w=" + this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels + " h=" + this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels + " density=" + this.jdField_a_of_type_AndroidUtilDisplayMetrics.density + " dpi=" + this.jdField_a_of_type_AndroidUtilDisplayMetrics.densityDpi);
    int j = SizeMeasure.k(paramContext);
    int i = j;
    if (j <= 0)
    {
      i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
      if (this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels < this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels) {
        i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
      }
    }
    float f1;
    if (SizeMeasure.b)
    {
      f1 = a(paramContext);
      Log.i("app2", "screenScale=" + f1);
      if (f1 > 0.0F) {
        i = (int)(f1 * 1024.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density);
      }
    }
    for (;;)
    {
      f1 = i / 1024.0F;
      Log.i("app2", "app=" + f1 + " lanWidth=" + i);
      i = (int)(160.0F * f1);
      this.b.density = (f1 * 1.0F);
      this.b.densityDpi = i;
      this.b.scaledDensity = (this.b.density * paramContext.getResources().getConfiguration().fontScale);
      this.b.xdpi = i;
      this.b.ydpi = i;
      return;
      float f2 = b(paramContext);
      i = (int)(f2 / 1.0F * 1024.0F);
      f1 = i / (this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 1024.0F);
      Log.i("app2", "newDensity=" + f2 + " lanWidth=" + i + " screenScale=" + f1);
      if (f1 > 0.85F)
      {
        i = (int)(0.85F * 1024.0F * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density);
        f1 = 0.85F;
      }
      for (;;)
      {
        a(paramContext, f1);
        break;
      }
    }
  }
  
  public float a()
  {
    int i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels;
    if (this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels < this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels) {
      i = this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
    }
    return i / this.jdField_a_of_type_AndroidUtilDisplayMetrics.density / 1024.0F;
  }
  
  public void b(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getResources();
      DisplayMetrics localDisplayMetrics = paramContext.getDisplayMetrics();
      this.b.widthPixels = localDisplayMetrics.widthPixels;
      this.b.heightPixels = localDisplayMetrics.heightPixels;
      localDisplayMetrics.setTo(this.b);
      if ((Build.BRAND.equalsIgnoreCase("Xiaomi")) || (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")))
      {
        paramContext = a(paramContext, paramContext.getClass().getSuperclass(), "mTmpMetrics");
        if ((paramContext instanceof DisplayMetrics)) {
          ((DisplayMetrics)paramContext).setTo(this.b);
        }
      }
    }
  }
  
  public void c(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels = paramContext.widthPixels;
      this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels = paramContext.heightPixels;
      paramContext.setTo(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScaleUi
 * JD-Core Version:    0.7.0.1
 */
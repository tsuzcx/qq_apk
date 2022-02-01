package com.tencent.mobileqq.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SizeMeasure
{
  private static int jdField_a_of_type_Int = 0;
  public static final String a = "size_measure_screen_width";
  public static boolean a;
  private static int[] jdField_a_of_type_ArrayOfInt = { 72, 352, 600 };
  private static int b;
  public static boolean b;
  private static int c;
  private static int d;
  
  public static int a(Context paramContext)
  {
    if (jdField_a_of_type_Int == 0) {
      a(paramContext);
    }
    return jdField_a_of_type_Int;
  }
  
  public static int a(Context paramContext, View paramView)
  {
    int i = h(paramContext);
    if ((paramContext instanceof Activity)) {
      i = ((Activity)paramContext).getWindow().getDecorView().getWidth();
    }
    while (paramView == null) {
      return i;
    }
    paramContext = new Rect();
    paramView.getWindowVisibleDisplayFrame(paramContext);
    return paramContext.width();
  }
  
  public static void a(Context paramContext)
  {
    Object localObject = paramContext.getResources().getDisplayMetrics();
    int j = k(paramContext);
    Log.i("app2", "initPageSize savedScreenWidth=" + j);
    int i = j;
    if (j <= 0) {
      i = j(paramContext);
    }
    d = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    float f1 = ((DisplayMetrics)localObject).density;
    int m = (int)(i / f1 + 0.5F);
    localObject = jdField_a_of_type_ArrayOfInt;
    int n = localObject.length;
    j = 0;
    int k = 0;
    while (j < n)
    {
      k += localObject[j];
      j += 1;
    }
    float f2;
    if (m < 940)
    {
      jdField_a_of_type_Boolean = true;
      if (m < 720) {
        jdField_b_of_type_Boolean = true;
      }
      f1 = jdField_a_of_type_ArrayOfInt[1] / jdField_a_of_type_ArrayOfInt[0];
      f2 = jdField_a_of_type_ArrayOfInt[2] / jdField_a_of_type_ArrayOfInt[0];
      jdField_a_of_type_Int = (int)(i / (f2 + f1 + 1.0F));
      jdField_b_of_type_Int = (int)(jdField_a_of_type_Int * f1);
      ScaleUi.a(paramContext);
    }
    for (;;)
    {
      Log.i("app2", "navBarWidth=" + jdField_a_of_type_Int + " leftPaneWidth=" + jdField_b_of_type_Int + " rightPaneWidth=" + c);
      return;
      f2 = m / k;
      jdField_a_of_type_Int = (int)(jdField_a_of_type_ArrayOfInt[0] * f2 * f1 + 0.5F);
      jdField_b_of_type_Int = (int)(f2 * jdField_a_of_type_ArrayOfInt[1] * f1 + 0.5F);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  public static int b(Context paramContext)
  {
    if (jdField_b_of_type_Int == 0) {
      a(paramContext);
    }
    if (paramContext.getResources().getConfiguration().orientation == 1) {
      return h(paramContext) - jdField_a_of_type_Int;
    }
    return jdField_b_of_type_Int;
  }
  
  public static void b(Context paramContext)
  {
    if (jdField_a_of_type_Boolean) {
      ScaleUi.a().b(paramContext);
    }
  }
  
  public static int c(Context paramContext)
  {
    if (jdField_b_of_type_Int == 0) {
      a(paramContext);
    }
    return jdField_b_of_type_Int;
  }
  
  public static void c(Context paramContext)
  {
    if (jdField_a_of_type_Boolean) {
      ScaleUi.a().c(paramContext);
    }
  }
  
  public static int d(Context paramContext)
  {
    if ((jdField_b_of_type_Int == 0) || (jdField_a_of_type_Int == 0)) {
      a(paramContext);
    }
    return Math.max(h(paramContext), i(paramContext)) - jdField_a_of_type_Int - jdField_b_of_type_Int;
  }
  
  public static void d(Context paramContext)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().remove("size_measure_screen_width").commit();
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_Int = 0;
  }
  
  public static int e(Context paramContext)
  {
    if ((jdField_b_of_type_Int == 0) || (jdField_a_of_type_Int == 0)) {
      a(paramContext);
    }
    int i = h(paramContext);
    if (paramContext.getResources().getConfiguration().orientation == 1) {
      return i;
    }
    return i - jdField_a_of_type_Int - jdField_b_of_type_Int;
  }
  
  public static int f(Context paramContext)
  {
    if ((jdField_b_of_type_Int == 0) || (jdField_a_of_type_Int == 0)) {
      a(paramContext);
    }
    return k(paramContext) - jdField_a_of_type_Int - jdField_b_of_type_Int;
  }
  
  public static int g(Context paramContext)
  {
    if ((jdField_b_of_type_Int == 0) || (jdField_a_of_type_Int == 0)) {
      a(paramContext);
    }
    return d - jdField_a_of_type_Int;
  }
  
  public static int h(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public static int i(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  public static int j(Context paramContext)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i = Math.max(paramContext.widthPixels, paramContext.heightPixels);
    Log.i("app2", "addScreenWidthInPref--》widthPixels=" + paramContext.widthPixels + " heightPixels=" + paramContext.heightPixels);
    localSharedPreferences.edit().putInt("size_measure_screen_width", i).commit();
    return i;
  }
  
  public static int k(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("size_measure_screen_width", -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.SizeMeasure
 * JD-Core Version:    0.7.0.1
 */
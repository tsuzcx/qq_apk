package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class c
{
  private static float a = -1.0F;
  private static int b = -1;
  private static int c = -1;
  
  public static int a(Context paramContext)
  {
    if (b == -1) {
      b(paramContext);
    }
    return b;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return b(paramContext, 160.0F * paramFloat / 320.0F);
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    if (a == -1.0F) {
      b(paramContext);
    }
    return (int)(a * paramFloat + 0.5F);
  }
  
  private static void b(Context paramContext)
  {
    if (a < 0.0F)
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      a = localDisplayMetrics.density;
      b = localDisplayMetrics.heightPixels;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.c
 * JD-Core Version:    0.7.0.1
 */
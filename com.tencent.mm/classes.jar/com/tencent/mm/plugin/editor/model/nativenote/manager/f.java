package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public abstract class f
{
  private static float cPs = 3.4028235E+38F;
  private static float qQS = 3.4028235E+38F;
  private static int qQT = -1;
  public static float qQU = 48.0F;
  
  public static int FA(int paramInt)
  {
    return Math.round(paramInt / cDD());
  }
  
  public static int Fz(int paramInt)
  {
    return Math.round(paramInt * cDD());
  }
  
  private static float cDC()
  {
    try
    {
      if (cPs == 3.4028235E+38F) {
        cPs = getDisplayMetrics().density;
      }
      float f = cPs;
      return f;
    }
    finally {}
  }
  
  private static float cDD()
  {
    try
    {
      if (qQS == 3.4028235E+38F) {
        qQS = getDisplayMetrics().density * MMApplicationContext.getContext().getResources().getConfiguration().fontScale;
      }
      float f = qQS;
      return f;
    }
    finally {}
  }
  
  public static int cDE()
  {
    if (qQT == -1) {
      qQT = Math.round(cDC() * 30.0F);
    }
    return qQT;
  }
  
  private static DisplayMetrics getDisplayMetrics()
  {
    Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static float getTextSize()
  {
    return qQU;
  }
  
  public static void setTextSize(float paramFloat)
  {
    qQU = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ak;

public abstract class f
{
  private static float cBm = 3.4028235E+38F;
  private static float pBA = 3.4028235E+38F;
  private static int pBB = -1;
  public static float pBC = 48.0F;
  
  public static int BP(int paramInt)
  {
    return Math.round(paramInt * cfN());
  }
  
  public static int BQ(int paramInt)
  {
    return Math.round(paramInt / cfN());
  }
  
  private static float cfM()
  {
    try
    {
      if (cBm == 3.4028235E+38F) {
        cBm = getDisplayMetrics().density;
      }
      float f = cBm;
      return f;
    }
    finally {}
  }
  
  private static float cfN()
  {
    try
    {
      if (pBA == 3.4028235E+38F) {
        pBA = getDisplayMetrics().density * ak.getContext().getResources().getConfiguration().fontScale;
      }
      float f = pBA;
      return f;
    }
    finally {}
  }
  
  public static int cfO()
  {
    if (pBB == -1) {
      pBB = Math.round(cfM() * 30.0F);
    }
    return pBB;
  }
  
  private static DisplayMetrics getDisplayMetrics()
  {
    Display localDisplay = ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static float getTextSize()
  {
    return pBC;
  }
  
  public static void setTextSize(float paramFloat)
  {
    pBC = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */
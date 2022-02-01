package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.aj;

public abstract class f
{
  private static float cAF = 3.4028235E+38F;
  private static float puW = 3.4028235E+38F;
  private static int puX = -1;
  public static float puY = 48.0F;
  
  public static int BD(int paramInt)
  {
    return Math.round(paramInt * cey());
  }
  
  public static int BE(int paramInt)
  {
    return Math.round(paramInt / cey());
  }
  
  private static float cex()
  {
    try
    {
      if (cAF == 3.4028235E+38F) {
        cAF = getDisplayMetrics().density;
      }
      float f = cAF;
      return f;
    }
    finally {}
  }
  
  private static float cey()
  {
    try
    {
      if (puW == 3.4028235E+38F) {
        puW = getDisplayMetrics().density * aj.getContext().getResources().getConfiguration().fontScale;
      }
      float f = puW;
      return f;
    }
    finally {}
  }
  
  public static int cez()
  {
    if (puX == -1) {
      puX = Math.round(cex() * 30.0F);
    }
    return puX;
  }
  
  private static DisplayMetrics getDisplayMetrics()
  {
    Display localDisplay = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static float getTextSize()
  {
    return puY;
  }
  
  public static void setTextSize(float paramFloat)
  {
    puY = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */
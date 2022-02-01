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
  private static float eLo = 3.4028235E+38F;
  private static float xzv = 3.4028235E+38F;
  private static int xzw = -1;
  public static float xzx = 48.0F;
  
  public static int JO(int paramInt)
  {
    return Math.round(paramInt * dwA());
  }
  
  public static int JP(int paramInt)
  {
    return Math.round(paramInt / dwA());
  }
  
  private static float dwA()
  {
    try
    {
      if (xzv == 3.4028235E+38F) {
        xzv = getDisplayMetrics().density * MMApplicationContext.getContext().getResources().getConfiguration().fontScale;
      }
      float f = xzv;
      return f;
    }
    finally {}
  }
  
  public static int dwB()
  {
    if (xzw == -1) {
      xzw = Math.round(getDisplayDensity() * 30.0F);
    }
    return xzw;
  }
  
  private static float getDisplayDensity()
  {
    try
    {
      if (eLo == 3.4028235E+38F) {
        eLo = getDisplayMetrics().density;
      }
      float f = eLo;
      return f;
    }
    finally {}
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
    return xzx;
  }
  
  public static void setTextSize(float paramFloat)
  {
    xzx = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */
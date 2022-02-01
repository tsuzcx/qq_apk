package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ai;

public abstract class f
{
  private static float cpO = 3.4028235E+38F;
  private static float oRm = 3.4028235E+38F;
  private static int oRn = -1;
  public static float oRo = 48.0F;
  
  public static int AV(int paramInt)
  {
    return Math.round(paramInt * bZU());
  }
  
  public static int AW(int paramInt)
  {
    return Math.round(paramInt / bZU());
  }
  
  private static float bZT()
  {
    try
    {
      if (cpO == 3.4028235E+38F) {
        cpO = getDisplayMetrics().density;
      }
      float f = cpO;
      return f;
    }
    finally {}
  }
  
  private static float bZU()
  {
    try
    {
      if (oRm == 3.4028235E+38F) {
        oRm = getDisplayMetrics().density * ai.getContext().getResources().getConfiguration().fontScale;
      }
      float f = oRm;
      return f;
    }
    finally {}
  }
  
  public static int bZV()
  {
    if (oRn == -1) {
      oRn = Math.round(bZT() * 30.0F);
    }
    return oRn;
  }
  
  private static DisplayMetrics getDisplayMetrics()
  {
    Display localDisplay = ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static float getTextSize()
  {
    return oRo;
  }
  
  public static void setTextSize(float paramFloat)
  {
    oRo = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */
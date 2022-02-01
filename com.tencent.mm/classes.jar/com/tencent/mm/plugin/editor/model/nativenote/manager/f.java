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
  private static float csG = 3.4028235E+38F;
  private static float onM = 3.4028235E+38F;
  private static int onN = -1;
  public static float onO = 48.0F;
  
  public static int Ad(int paramInt)
  {
    return Math.round(paramInt * bSF());
  }
  
  public static int Ae(int paramInt)
  {
    return Math.round(paramInt / bSF());
  }
  
  private static float bSE()
  {
    try
    {
      if (csG == 3.4028235E+38F) {
        csG = getDisplayMetrics().density;
      }
      float f = csG;
      return f;
    }
    finally {}
  }
  
  private static float bSF()
  {
    try
    {
      if (onM == 3.4028235E+38F) {
        onM = getDisplayMetrics().density * aj.getContext().getResources().getConfiguration().fontScale;
      }
      float f = onM;
      return f;
    }
    finally {}
  }
  
  public static int bSG()
  {
    if (onN == -1) {
      onN = Math.round(bSE() * 30.0F);
    }
    return onN;
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
    return onO;
  }
  
  public static void setTextSize(float paramFloat)
  {
    onO = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */
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
  private static float cQj = 3.4028235E+38F;
  private static float usY = 3.4028235E+38F;
  private static int usZ = -1;
  public static float uta = 48.0F;
  
  public static int Jg(int paramInt)
  {
    return Math.round(paramInt * cSi());
  }
  
  public static int Jh(int paramInt)
  {
    return Math.round(paramInt / cSi());
  }
  
  private static float cSh()
  {
    try
    {
      if (cQj == 3.4028235E+38F) {
        cQj = getDisplayMetrics().density;
      }
      float f = cQj;
      return f;
    }
    finally {}
  }
  
  private static float cSi()
  {
    try
    {
      if (usY == 3.4028235E+38F) {
        usY = getDisplayMetrics().density * MMApplicationContext.getContext().getResources().getConfiguration().fontScale;
      }
      float f = usY;
      return f;
    }
    finally {}
  }
  
  public static int cSj()
  {
    if (usZ == -1) {
      usZ = Math.round(cSh() * 30.0F);
    }
    return usZ;
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
    return uta;
  }
  
  public static void setTextSize(float paramFloat)
  {
    uta = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.f
 * JD-Core Version:    0.7.0.1
 */
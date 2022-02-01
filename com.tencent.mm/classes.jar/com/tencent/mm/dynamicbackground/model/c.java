package com.tencent.mm.dynamicbackground.model;

import android.content.Context;
import android.graphics.Point;
import d.l;

@l(fNY={1, 1, 11}, fNZ={""}, fOa={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgCrashListener;", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "loadDynamicBgLibrary", "", "setEnableNativeDynamicBackground", "enable", "dynamicbg_release"})
public abstract interface c
  extends b
{
  public abstract boolean abe();
  
  public abstract void abf();
  
  public abstract void abg();
  
  public abstract float abp();
  
  public abstract Point cl(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.c
 * JD-Core Version:    0.7.0.1
 */
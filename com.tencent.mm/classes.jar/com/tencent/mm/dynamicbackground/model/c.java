package com.tencent.mm.dynamicbackground.model;

import android.content.Context;
import android.graphics.Point;
import d.l;

@l(fvt={1, 1, 11}, fvu={""}, fvv={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgCrashListener;", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "loadDynamicBgLibrary", "", "setEnableNativeDynamicBackground", "enable", "dynamicbg_release"})
public abstract interface c
  extends b
{
  public abstract boolean aaf();
  
  public abstract void aag();
  
  public abstract void aah();
  
  public abstract float aaq();
  
  public abstract Point cf(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.dynamicbackground.model;

import android.content.Context;
import android.graphics.Point;
import kotlin.l;

@l(iBK={1, 1, 11}, iBL={""}, iBM={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgCrashListener;", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "loadDynamicBgLibrary", "", "setEnableNativeDynamicBackground", "enable", "dynamicbg_release"})
public abstract interface c
  extends b
{
  public abstract float aAE();
  
  public abstract boolean aAt();
  
  public abstract void aAu();
  
  public abstract void aAv();
  
  public abstract Point au(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.c
 * JD-Core Version:    0.7.0.1
 */
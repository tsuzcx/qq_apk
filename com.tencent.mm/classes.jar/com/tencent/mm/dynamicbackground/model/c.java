package com.tencent.mm.dynamicbackground.model;

import android.content.Context;
import android.graphics.Point;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgCrashListener;", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "loadDynamicBgLibrary", "", "setEnableNativeDynamicBackground", "enable", "dynamicbg_release"}, k=1, mv={1, 1, 11})
public abstract interface c
  extends b
{
  public abstract boolean aTo();
  
  public abstract void aTp();
  
  public abstract void aTq();
  
  public abstract float aTz();
  
  public abstract Point bf(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.c
 * JD-Core Version:    0.7.0.1
 */
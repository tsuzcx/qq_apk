package com.tencent.mm.dynamicbackground.model;

import android.content.Context;
import android.graphics.Point;
import kotlin.l;

@l(hxD={1, 1, 11}, hxE={""}, hxF={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgCrashListener;", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "", "loadDynamicBgLibrary", "", "setEnableNativeDynamicBackground", "enable", "dynamicbg_release"})
public abstract interface c
  extends b
{
  public abstract boolean atB();
  
  public abstract void atC();
  
  public abstract void atD();
  
  public abstract float atM();
  
  public abstract Point az(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.c
 * JD-Core Version:    0.7.0.1
 */
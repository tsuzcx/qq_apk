package com.tencent.kinda.framework.api;

import android.app.Activity;
import com.tencent.mm.kernel.b.a;

public abstract interface IPluginWxKindaApi
  extends a
{
  public static final String CLASS = "com.tencent.kinda.framework.PluginWxKindaApi";
  
  public abstract boolean isKindaScene(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.api.IPluginWxKindaApi
 * JD-Core Version:    0.7.0.1
 */
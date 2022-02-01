package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.c;

public abstract interface ai
{
  public abstract void C(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void a(AppBrandRuntime paramAppBrandRuntime, AppBrandInitConfig paramAppBrandInitConfig);
  
  public abstract void a(AppBrandRuntime paramAppBrandRuntime, Object paramObject);
  
  public abstract AppBrandRuntime getActiveRuntime();
  
  public abstract Context getContext();
  
  public abstract int getStackSize();
  
  public abstract c getWindowAndroid();
  
  public abstract AppBrandRuntime v(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract boolean w(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void x(AppBrandRuntime paramAppBrandRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ai
 * JD-Core Version:    0.7.0.1
 */
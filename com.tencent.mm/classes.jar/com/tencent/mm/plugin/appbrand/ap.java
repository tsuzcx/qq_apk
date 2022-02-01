package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.c;

public abstract interface ap
{
  public abstract void A(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void E(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void a(AppBrandRuntime paramAppBrandRuntime, AppBrandInitConfig paramAppBrandInitConfig);
  
  public abstract void a(AppBrandRuntime paramAppBrandRuntime, Object paramObject, Runnable paramRunnable);
  
  public abstract AppBrandRuntime getActiveRuntime();
  
  public abstract Context getContext();
  
  public abstract int getStackSize();
  
  public abstract c getWindowAndroid();
  
  public abstract AppBrandRuntime y(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract boolean z(AppBrandRuntime paramAppBrandRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ap
 * JD-Core Version:    0.7.0.1
 */
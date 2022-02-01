package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.c;

public abstract interface ak
{
  public abstract void A(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void a(AppBrandRuntime paramAppBrandRuntime, AppBrandInitConfig paramAppBrandInitConfig);
  
  public abstract void a(AppBrandRuntime paramAppBrandRuntime, Object paramObject);
  
  public abstract AppBrandRuntime getActiveRuntime();
  
  public abstract Context getContext();
  
  public abstract int getStackSize();
  
  public abstract c getWindowAndroid();
  
  public abstract AppBrandRuntime u(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract boolean v(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void w(AppBrandRuntime paramAppBrandRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ak
 * JD-Core Version:    0.7.0.1
 */
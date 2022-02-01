package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.r.a.c;

public abstract interface ai
{
  public abstract boolean A(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void B(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void F(AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void a(AppBrandRuntime paramAppBrandRuntime, AppBrandInitConfig paramAppBrandInitConfig);
  
  public abstract void a(AppBrandRuntime paramAppBrandRuntime, Object paramObject);
  
  public abstract AppBrandRuntime getActiveRuntime();
  
  public abstract Context getContext();
  
  public abstract int getStackSize();
  
  public abstract c getWindowAndroid();
  
  public abstract AppBrandRuntime z(AppBrandRuntime paramAppBrandRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ai
 * JD-Core Version:    0.7.0.1
 */
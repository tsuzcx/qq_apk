package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;

public abstract interface aa
  extends b
{
  public abstract void a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig);
  
  public abstract void a(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2);
  
  public abstract void a(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable);
  
  public abstract void m(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.aa
 * JD-Core Version:    0.7.0.1
 */
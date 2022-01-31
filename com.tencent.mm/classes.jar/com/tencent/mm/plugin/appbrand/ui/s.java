package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i;

public abstract interface s
  extends b
{
  public abstract void a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig);
  
  public abstract void a(i parami1, i parami2);
  
  public abstract void a(i parami1, i parami2, Runnable paramRunnable);
  
  public abstract void j(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.s
 * JD-Core Version:    0.7.0.1
 */
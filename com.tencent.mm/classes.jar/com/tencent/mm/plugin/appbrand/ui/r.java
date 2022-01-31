package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.luggage.b.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public abstract interface r
  extends b
{
  public abstract void a(Activity paramActivity, AppBrandStatObject paramAppBrandStatObject);
  
  public abstract void a(i parami1, i parami2, Runnable paramRunnable);
  
  public abstract void b(i parami1, i parami2, Runnable paramRunnable);
  
  public abstract void h(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.r
 * JD-Core Version:    0.7.0.1
 */
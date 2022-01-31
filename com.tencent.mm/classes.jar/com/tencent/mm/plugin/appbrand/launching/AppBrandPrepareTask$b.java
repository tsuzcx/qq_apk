package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;

public abstract interface AppBrandPrepareTask$b<C extends AppBrandSysConfigLU>
  extends j
{
  public abstract void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle);
  
  public abstract void a(a parama);
  
  public abstract void aub();
  
  public abstract void ho(long paramLong);
  
  public abstract void nh(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b
 * JD-Core Version:    0.7.0.1
 */
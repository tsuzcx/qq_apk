package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;

public final class af
  implements AppBrandPrepareTask.b, com.tencent.mm.vending.e.a
{
  private AppBrandPrepareTask.b rdc;
  
  public af(AppBrandPrepareTask.b paramb)
  {
    this.rdc = paramb;
  }
  
  public final void a(AppBrandSysConfigWC paramAppBrandSysConfigWC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle)
  {
    AppBrandPrepareTask.b localb = this.rdc;
    if (localb != null) {
      localb.a(paramAppBrandSysConfigWC, paramAppBrandLaunchErrorAction, paramAppStartupPerformanceReportBundle);
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.version.a parama)
  {
    AppBrandPrepareTask.b localb = this.rdc;
    if (localb != null) {
      localb.a(parama);
    }
  }
  
  public final void dead()
  {
    this.rdc = null;
  }
  
  public final void iG(long paramLong)
  {
    AppBrandPrepareTask.b localb = this.rdc;
    if (localb != null) {
      localb.iG(paramLong);
    }
  }
  
  public final void ko(int paramInt)
  {
    AppBrandPrepareTask.b localb = this.rdc;
    if (localb != null) {
      localb.ko(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.af
 * JD-Core Version:    0.7.0.1
 */
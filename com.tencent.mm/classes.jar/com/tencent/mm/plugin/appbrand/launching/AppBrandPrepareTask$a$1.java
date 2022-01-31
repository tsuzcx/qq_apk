package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;

final class AppBrandPrepareTask$a$1
  implements d.b
{
  AppBrandPrepareTask$a$1(AppBrandPrepareTask.a parama, c paramc, AppBrandPrepareTask.PrepareParams paramPrepareParams) {}
  
  public final void alE()
  {
    if (this.gJs != null)
    {
      AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 1);
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, bk.UY());
      this.gJs.U(localPrepareResult);
    }
  }
  
  public final void b(AppBrandSysConfigWC paramAppBrandSysConfigWC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle)
  {
    if (this.gJs != null)
    {
      AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 2);
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, paramAppBrandSysConfigWC);
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, paramAppBrandLaunchErrorAction);
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, paramAppStartupPerformanceReportBundle);
      this.gJs.U(localPrepareResult);
      if (paramAppBrandSysConfigWC == null) {
        break label136;
      }
      paramAppBrandLaunchErrorAction = new AppBrandPrepareTask.a.1.1(this);
      if (AppBrandPrepareTask.PrepareParams.e(this.gJt)) {
        break label126;
      }
      paramAppBrandSysConfigWC = new f(paramAppBrandSysConfigWC.bFn, AppBrandPrepareTask.PrepareParams.c(this.gJt), paramAppBrandLaunchErrorAction, AppBrandPrepareTask.PrepareParams.f(this.gJt));
      if (paramAppBrandSysConfigWC.gKm != null) {
        e.post(new f.1(paramAppBrandSysConfigWC), "MicroMsg.AppBrand.Launching.ContactSilentSyncProcess");
      }
    }
    return;
    label126:
    paramAppBrandLaunchErrorAction.b(a.gCC);
    return;
    label136:
    s.sE(r.sx(AppBrandPrepareTask.PrepareParams.a(this.gJt)));
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    if (this.gJs != null)
    {
      AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
      AppBrandPrepareTask.PrepareResult.b(localPrepareResult, paramInt);
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 4);
      this.gJs.U(localPrepareResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.1
 * JD-Core Version:    0.7.0.1
 */
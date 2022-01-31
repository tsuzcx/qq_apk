package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandPrepareTask$a$1
  implements g.b
{
  AppBrandPrepareTask$a$1(AppBrandPrepareTask.a parama, c paramc, AppBrandPrepareTask.PrepareParams paramPrepareParams) {}
  
  public final void a(AppBrandSysConfigWC paramAppBrandSysConfigWC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle)
  {
    AppMethodBeat.i(131740);
    if (this.ika != null)
    {
      AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 2);
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, paramAppBrandSysConfigWC);
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, paramAppBrandLaunchErrorAction);
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, paramAppStartupPerformanceReportBundle);
      this.ika.ad(localPrepareResult);
      if (paramAppBrandSysConfigWC != null)
      {
        paramAppBrandSysConfigWC = new AppBrandPrepareTask.a.1.1(this);
        if (!AppBrandPrepareTask.PrepareParams.f(this.ikb))
        {
          paramAppBrandSysConfigWC = new i(AppBrandPrepareTask.PrepareParams.c(this.ikb), AppBrandPrepareTask.PrepareParams.d(this.ikb), paramAppBrandSysConfigWC, AppBrandPrepareTask.PrepareParams.g(this.ikb));
          if (paramAppBrandSysConfigWC.ilb != null)
          {
            d.post(new i.1(paramAppBrandSysConfigWC), "MicroMsg.AppBrand.Launching.ContactSilentSyncProcess");
            AppMethodBeat.o(131740);
          }
        }
        else
        {
          paramAppBrandSysConfigWC.b(a.ibE);
        }
        AppMethodBeat.o(131740);
        return;
      }
      s.Ay(q.As(AppBrandPrepareTask.PrepareParams.a(this.ikb)));
    }
    AppMethodBeat.o(131740);
  }
  
  public final void aGL()
  {
    AppMethodBeat.i(131737);
    if (this.ika != null)
    {
      AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 1);
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, bo.aoy());
      this.ika.ad(localPrepareResult);
    }
    AppMethodBeat.o(131737);
  }
  
  public final void aub()
  {
    AppMethodBeat.i(131739);
    if (this.ika != null)
    {
      AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 6);
      this.ika.ad(localPrepareResult);
    }
    AppMethodBeat.o(131739);
  }
  
  public final void ng(int paramInt)
  {
    AppMethodBeat.i(131741);
    AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
    AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 7);
    AppBrandPrepareTask.PrepareResult.c(localPrepareResult, paramInt);
    this.ika.ad(localPrepareResult);
    AppMethodBeat.o(131741);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    AppMethodBeat.i(131738);
    if (this.ika != null)
    {
      AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
      AppBrandPrepareTask.PrepareResult.b(localPrepareResult, paramInt);
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 4);
      this.ika.ad(localPrepareResult);
    }
    AppMethodBeat.o(131738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.1
 * JD-Core Version:    0.7.0.1
 */
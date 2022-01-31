package com.tencent.mm.plugin.appbrand.launching;

import a.l;
import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPrepareCallbackWrapper;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "referenced", "(Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;)V", "mDead", "", "mReferenced", "dead", "", "onDataTransferState", "state", "", "onDownloadProcess", "progress", "onDownloadStarted", "startTime", "", "onPrepareDone", "config", "errorAction", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;", "startupPerformanceReport", "Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;", "(Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;)V", "onSyncLaunchStart", "onVersionUpdateEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "tryOrThrows", "block", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class y<C extends AppBrandSysConfigLU>
  implements AppBrandPrepareTask.b<C>, com.tencent.mm.vending.e.a
{
  private volatile boolean gQl;
  private volatile AppBrandPrepareTask.b<C> ilQ;
  
  public y(AppBrandPrepareTask.b<C> paramb)
  {
    AppMethodBeat.i(134717);
    this.ilQ = paramb;
    AppMethodBeat.o(134717);
  }
  
  public final void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle)
  {
    AppMethodBeat.i(134712);
    try
    {
      AppBrandPrepareTask.b localb = this.ilQ;
      if (localb != null)
      {
        localb.a(paramC, paramAppBrandLaunchErrorAction, paramAppStartupPerformanceReportBundle);
        AppMethodBeat.o(134712);
        return;
      }
      AppMethodBeat.o(134712);
      return;
    }
    catch (Throwable paramC)
    {
      if (this.gQl)
      {
        d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + paramC + " when dead");
        AppMethodBeat.o(134712);
        return;
      }
      AppMethodBeat.o(134712);
      throw paramC;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.version.a parama)
  {
    AppMethodBeat.i(134715);
    try
    {
      AppBrandPrepareTask.b localb = this.ilQ;
      if (localb != null)
      {
        localb.a(parama);
        AppMethodBeat.o(134715);
        return;
      }
      AppMethodBeat.o(134715);
      return;
    }
    catch (Throwable parama)
    {
      if (this.gQl)
      {
        d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + parama + " when dead");
        AppMethodBeat.o(134715);
        return;
      }
      AppMethodBeat.o(134715);
      throw parama;
    }
  }
  
  public final void aub()
  {
    AppMethodBeat.i(134716);
    try
    {
      AppBrandPrepareTask.b localb = this.ilQ;
      if (localb != null)
      {
        localb.aub();
        AppMethodBeat.o(134716);
        return;
      }
      AppMethodBeat.o(134716);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.gQl)
      {
        d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + localThrowable + " when dead");
        AppMethodBeat.o(134716);
        return;
      }
      AppMethodBeat.o(134716);
      throw localThrowable;
    }
  }
  
  public final void dead()
  {
    this.ilQ = null;
    this.gQl = true;
  }
  
  public final void ho(long paramLong)
  {
    AppMethodBeat.i(134713);
    try
    {
      AppBrandPrepareTask.b localb = this.ilQ;
      if (localb != null)
      {
        localb.ho(paramLong);
        AppMethodBeat.o(134713);
        return;
      }
      AppMethodBeat.o(134713);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.gQl)
      {
        d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + localThrowable + " when dead");
        AppMethodBeat.o(134713);
        return;
      }
      AppMethodBeat.o(134713);
      throw localThrowable;
    }
  }
  
  public final void ng(int paramInt)
  {
    AppMethodBeat.i(134711);
    try
    {
      AppBrandPrepareTask.b localb = this.ilQ;
      if (localb != null)
      {
        localb.ng(paramInt);
        AppMethodBeat.o(134711);
        return;
      }
      AppMethodBeat.o(134711);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.gQl)
      {
        d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + localThrowable + " when dead");
        AppMethodBeat.o(134711);
        return;
      }
      AppMethodBeat.o(134711);
      throw localThrowable;
    }
  }
  
  public final void nh(int paramInt)
  {
    AppMethodBeat.i(134714);
    try
    {
      AppBrandPrepareTask.b localb = this.ilQ;
      if (localb != null)
      {
        localb.nh(paramInt);
        AppMethodBeat.o(134714);
        return;
      }
      AppMethodBeat.o(134714);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.gQl)
      {
        d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + localThrowable + " when dead");
        AppMethodBeat.o(134714);
        return;
      }
      AppMethodBeat.o(134714);
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.y
 * JD-Core Version:    0.7.0.1
 */
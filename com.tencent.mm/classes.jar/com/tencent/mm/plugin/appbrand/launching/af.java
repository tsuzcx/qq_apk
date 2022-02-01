package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.b;
import com.tencent.mm.vending.e.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPrepareCallbackWrapper;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "referenced", "(Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;)V", "mDead", "", "mReferenced", "dead", "", "onDataTransferState", "state", "", "onDownloadProcess", "progress", "onDownloadStarted", "startTime", "", "onLaunchTimeoutFallbackReloadRequested", "onPrepareDone", "config", "errorAction", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;", "startupPerformanceReport", "Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;", "(Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;)V", "onSyncAppidABTestStart", "onSyncJsApiInfoStart", "onSyncLaunchStart", "onVersionUpdateEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "passThroughInfo", "", "tryOrThrows", "block", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class af<C extends AppBrandSysConfigLU>
  implements AppBrandPrepareTask.b<C>, a
{
  private volatile boolean nuH;
  private volatile AppBrandPrepareTask.b<C> pWi;
  
  public af(AppBrandPrepareTask.b<C> paramb)
  {
    AppMethodBeat.i(50765);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.LaunchPrepareCallbackWrapper", "<init> hash=" + hashCode());
    this.pWi = paramb;
    AppMethodBeat.o(50765);
  }
  
  public final void Hi(long paramLong)
  {
    AppMethodBeat.i(50761);
    try
    {
      AppBrandPrepareTask.b localb = this.pWi;
      if (localb != null)
      {
        localb.Hi(paramLong);
        AppMethodBeat.o(50761);
        return;
      }
      AppMethodBeat.o(50761);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.nuH)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50761);
        return;
      }
      AppMethodBeat.o(50761);
      throw localThrowable;
    }
  }
  
  public final void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle)
  {
    AppMethodBeat.i(50760);
    try
    {
      AppBrandPrepareTask.b localb = this.pWi;
      if (localb != null)
      {
        localb.a(paramC, paramAppBrandLaunchErrorAction, paramAppStartupPerformanceReportBundle);
        AppMethodBeat.o(50760);
        return;
      }
      AppMethodBeat.o(50760);
      return;
    }
    catch (Throwable paramC)
    {
      if (this.nuH)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(paramC));
        AppMethodBeat.o(50760);
        return;
      }
      AppMethodBeat.o(50760);
      throw paramC;
    }
  }
  
  public final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(282392);
    try
    {
      AppBrandPrepareTask.b localb = this.pWi;
      if (localb != null)
      {
        localb.a(paramb, paramString);
        AppMethodBeat.o(282392);
        return;
      }
      AppMethodBeat.o(282392);
      return;
    }
    catch (Throwable paramb)
    {
      if (this.nuH)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(paramb));
        AppMethodBeat.o(282392);
        return;
      }
      AppMethodBeat.o(282392);
      throw paramb;
    }
  }
  
  public final void bDN()
  {
    AppMethodBeat.i(50764);
    try
    {
      AppBrandPrepareTask.b localb = this.pWi;
      if (localb != null)
      {
        localb.bDN();
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.nuH)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
      throw localThrowable;
    }
  }
  
  public final void bDO()
  {
    AppMethodBeat.i(282393);
    try
    {
      AppBrandPrepareTask.b localb = this.pWi;
      if (localb != null)
      {
        localb.bDO();
        AppMethodBeat.o(282393);
        return;
      }
      AppMethodBeat.o(282393);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.nuH)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(282393);
        return;
      }
      AppMethodBeat.o(282393);
      throw localThrowable;
    }
  }
  
  public final void bDP()
  {
    AppMethodBeat.i(282394);
    try
    {
      AppBrandPrepareTask.b localb = this.pWi;
      if (localb != null)
      {
        localb.bDP();
        AppMethodBeat.o(282394);
        return;
      }
      AppMethodBeat.o(282394);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.nuH)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(282394);
        return;
      }
      AppMethodBeat.o(282394);
      throw localThrowable;
    }
  }
  
  public final void bDQ()
  {
    AppMethodBeat.i(282395);
    try
    {
      AppBrandPrepareTask.b localb = this.pWi;
      if (localb != null)
      {
        localb.bDQ();
        AppMethodBeat.o(282395);
        return;
      }
      AppMethodBeat.o(282395);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.nuH)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(282395);
        return;
      }
      AppMethodBeat.o(282395);
      throw localThrowable;
    }
  }
  
  public final void dead()
  {
    AppMethodBeat.i(180618);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.LaunchPrepareCallbackWrapper", "dead() hash=" + hashCode());
    this.pWi = null;
    this.nuH = true;
    AppMethodBeat.o(180618);
  }
  
  public final void yL(int paramInt)
  {
    AppMethodBeat.i(50759);
    try
    {
      AppBrandPrepareTask.b localb = this.pWi;
      if (localb != null)
      {
        localb.yL(paramInt);
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.nuH)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
      throw localThrowable;
    }
  }
  
  public final void yM(int paramInt)
  {
    AppMethodBeat.i(50762);
    try
    {
      AppBrandPrepareTask.b localb = this.pWi;
      if (localb != null)
      {
        localb.yM(paramInt);
        AppMethodBeat.o(50762);
        return;
      }
      AppMethodBeat.o(50762);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.nuH)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50762);
        return;
      }
      AppMethodBeat.o(50762);
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.af
 * JD-Core Version:    0.7.0.1
 */
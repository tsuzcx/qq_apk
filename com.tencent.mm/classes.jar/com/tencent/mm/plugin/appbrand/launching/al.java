package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab.b;
import com.tencent.mm.vending.e.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPrepareCallbackWrapper;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "referenced", "(Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;)V", "mDead", "", "mReferenced", "dead", "", "onDataTransferState", "state", "", "onDownloadProcess", "progress", "onDownloadStarted", "startTime", "", "onLaunchTimeoutFallbackReloadRequested", "onPrepareDone", "config", "errorAction", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;", "startupPerformanceReport", "Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;", "(Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;)V", "onSyncJsApiInfoStart", "onSyncLaunchStart", "onVersionUpdateEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "passThroughInfo", "", "tryOrThrows", "block", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class al<C extends AppBrandSysConfigLU>
  implements AppBrandPrepareTask.b<C>, a
{
  private volatile boolean kBu;
  private volatile AppBrandPrepareTask.b<C> mVF;
  
  public al(AppBrandPrepareTask.b<C> paramb)
  {
    AppMethodBeat.i(50765);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.LaunchPrepareCallbackWrapper", "<init> hash=" + hashCode());
    this.mVF = paramb;
    AppMethodBeat.o(50765);
  }
  
  public final void AW(long paramLong)
  {
    AppMethodBeat.i(50761);
    try
    {
      AppBrandPrepareTask.b localb = this.mVF;
      if (localb != null)
      {
        localb.AW(paramLong);
        AppMethodBeat.o(50761);
        return;
      }
      AppMethodBeat.o(50761);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.kBu)
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
      AppBrandPrepareTask.b localb = this.mVF;
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
      if (this.kBu)
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
    AppMethodBeat.i(228695);
    try
    {
      AppBrandPrepareTask.b localb = this.mVF;
      if (localb != null)
      {
        localb.a(paramb, paramString);
        AppMethodBeat.o(228695);
        return;
      }
      AppMethodBeat.o(228695);
      return;
    }
    catch (Throwable paramb)
    {
      if (this.kBu)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(paramb));
        AppMethodBeat.o(228695);
        return;
      }
      AppMethodBeat.o(228695);
      throw paramb;
    }
  }
  
  public final void bsQ()
  {
    AppMethodBeat.i(50764);
    try
    {
      AppBrandPrepareTask.b localb = this.mVF;
      if (localb != null)
      {
        localb.bsQ();
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.kBu)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
      throw localThrowable;
    }
  }
  
  public final void bsR()
  {
    AppMethodBeat.i(228696);
    try
    {
      AppBrandPrepareTask.b localb = this.mVF;
      if (localb != null)
      {
        localb.bsR();
        AppMethodBeat.o(228696);
        return;
      }
      AppMethodBeat.o(228696);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.kBu)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(228696);
        return;
      }
      AppMethodBeat.o(228696);
      throw localThrowable;
    }
  }
  
  public final void bsS()
  {
    AppMethodBeat.i(228697);
    try
    {
      AppBrandPrepareTask.b localb = this.mVF;
      if (localb != null)
      {
        localb.bsS();
        AppMethodBeat.o(228697);
        return;
      }
      AppMethodBeat.o(228697);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.kBu)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(228697);
        return;
      }
      AppMethodBeat.o(228697);
      throw localThrowable;
    }
  }
  
  public final void dead()
  {
    AppMethodBeat.i(180618);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.LaunchPrepareCallbackWrapper", "dead() hash=" + hashCode());
    this.mVF = null;
    this.kBu = true;
    AppMethodBeat.o(180618);
  }
  
  public final void vy(int paramInt)
  {
    AppMethodBeat.i(50759);
    try
    {
      AppBrandPrepareTask.b localb = this.mVF;
      if (localb != null)
      {
        localb.vy(paramInt);
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.kBu)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
      throw localThrowable;
    }
  }
  
  public final void vz(int paramInt)
  {
    AppMethodBeat.i(50762);
    try
    {
      AppBrandPrepareTask.b localb = this.mVF;
      if (localb != null)
      {
        localb.vz(paramInt);
        AppMethodBeat.o(50762);
        return;
      }
      AppMethodBeat.o(50762);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.kBu)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.al
 * JD-Core Version:    0.7.0.1
 */
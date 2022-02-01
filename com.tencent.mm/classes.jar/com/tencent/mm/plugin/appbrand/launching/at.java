package com.tencent.mm.plugin.appbrand.launching;

import android.util.Log;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.y.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.e.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPrepareCallbackWrapper;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "referenced", "(Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;)V", "mDead", "", "mReferenced", "dead", "", "onDataTransferState", "state", "", "onDownloadProcess", "progress", "onDownloadStarted", "startTime", "", "onLaunchTimeoutFallbackReloadRequested", "onPrepareDone", "config", "errorAction", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;", "startupPerformanceReport", "Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;", "(Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;)V", "onSyncJsApiInfoStart", "onSyncLaunchStart", "onVersionUpdateEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "passThroughInfo", "", "tryOrThrows", "block", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class at<C extends AppBrandSysConfigLU>
  implements AppBrandPrepareTask.b<C>, a
{
  private volatile boolean jxE;
  private volatile AppBrandPrepareTask.b<C> lJX;
  
  public at(AppBrandPrepareTask.b<C> paramb)
  {
    AppMethodBeat.i(50765);
    ad.i("MicroMsg.LaunchPrepareCallbackWrapper", "<init> hash=" + hashCode());
    this.lJX = paramb;
    AppMethodBeat.o(50765);
  }
  
  public final void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle)
  {
    AppMethodBeat.i(50760);
    try
    {
      AppBrandPrepareTask.b localb = this.lJX;
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
      if (this.jxE)
      {
        ad.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(paramC));
        AppMethodBeat.o(50760);
        return;
      }
      AppMethodBeat.o(50760);
      throw paramC;
    }
  }
  
  public final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(189296);
    try
    {
      AppBrandPrepareTask.b localb = this.lJX;
      if (localb != null)
      {
        localb.a(paramb, paramString);
        AppMethodBeat.o(189296);
        return;
      }
      AppMethodBeat.o(189296);
      return;
    }
    catch (Throwable paramb)
    {
      if (this.jxE)
      {
        ad.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(paramb));
        AppMethodBeat.o(189296);
        return;
      }
      AppMethodBeat.o(189296);
      throw paramb;
    }
  }
  
  public final void aXo()
  {
    AppMethodBeat.i(50764);
    try
    {
      AppBrandPrepareTask.b localb = this.lJX;
      if (localb != null)
      {
        localb.aXo();
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jxE)
      {
        ad.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
      throw localThrowable;
    }
  }
  
  public final void aXp()
  {
    AppMethodBeat.i(189297);
    try
    {
      AppBrandPrepareTask.b localb = this.lJX;
      if (localb != null)
      {
        localb.aXp();
        AppMethodBeat.o(189297);
        return;
      }
      AppMethodBeat.o(189297);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jxE)
      {
        ad.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(189297);
        return;
      }
      AppMethodBeat.o(189297);
      throw localThrowable;
    }
  }
  
  public final void aXq()
  {
    AppMethodBeat.i(189298);
    try
    {
      AppBrandPrepareTask.b localb = this.lJX;
      if (localb != null)
      {
        localb.aXq();
        AppMethodBeat.o(189298);
        return;
      }
      AppMethodBeat.o(189298);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jxE)
      {
        ad.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(189298);
        return;
      }
      AppMethodBeat.o(189298);
      throw localThrowable;
    }
  }
  
  public final void dead()
  {
    AppMethodBeat.i(180618);
    ad.i("MicroMsg.LaunchPrepareCallbackWrapper", "dead() hash=" + hashCode());
    this.lJX = null;
    this.jxE = true;
    AppMethodBeat.o(180618);
  }
  
  public final void rC(int paramInt)
  {
    AppMethodBeat.i(50759);
    try
    {
      AppBrandPrepareTask.b localb = this.lJX;
      if (localb != null)
      {
        localb.rC(paramInt);
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jxE)
      {
        ad.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
      throw localThrowable;
    }
  }
  
  public final void rD(int paramInt)
  {
    AppMethodBeat.i(50762);
    try
    {
      AppBrandPrepareTask.b localb = this.lJX;
      if (localb != null)
      {
        localb.rD(paramInt);
        AppMethodBeat.o(50762);
        return;
      }
      AppMethodBeat.o(50762);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jxE)
      {
        ad.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50762);
        return;
      }
      AppMethodBeat.o(50762);
      throw localThrowable;
    }
  }
  
  public final void sC(long paramLong)
  {
    AppMethodBeat.i(50761);
    try
    {
      AppBrandPrepareTask.b localb = this.lJX;
      if (localb != null)
      {
        localb.sC(paramLong);
        AppMethodBeat.o(50761);
        return;
      }
      AppMethodBeat.o(50761);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jxE)
      {
        ad.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50761);
        return;
      }
      AppMethodBeat.o(50761);
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.at
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.launching;

import android.util.Log;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.e.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPrepareCallbackWrapper;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "referenced", "(Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;)V", "mDead", "", "mReferenced", "dead", "", "onDataTransferState", "state", "", "onDownloadProcess", "progress", "onDownloadStarted", "startTime", "", "onLaunchTimeoutFallbackReloadRequested", "onPrepareDone", "config", "errorAction", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;", "startupPerformanceReport", "Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;", "(Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;)V", "onSyncJsApiInfoStart", "onSyncLaunchStart", "onVersionUpdateEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "passThroughInfo", "", "tryOrThrows", "block", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class at<C extends AppBrandSysConfigLU>
  implements AppBrandPrepareTask.b<C>, a
{
  private volatile boolean jAD;
  private volatile AppBrandPrepareTask.b<C> lOx;
  
  public at(AppBrandPrepareTask.b<C> paramb)
  {
    AppMethodBeat.i(50765);
    ae.i("MicroMsg.LaunchPrepareCallbackWrapper", "<init> hash=" + hashCode());
    this.lOx = paramb;
    AppMethodBeat.o(50765);
  }
  
  public final void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle)
  {
    AppMethodBeat.i(50760);
    try
    {
      AppBrandPrepareTask.b localb = this.lOx;
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
      if (this.jAD)
      {
        ae.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(paramC));
        AppMethodBeat.o(50760);
        return;
      }
      AppMethodBeat.o(50760);
      throw paramC;
    }
  }
  
  public final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(223554);
    try
    {
      AppBrandPrepareTask.b localb = this.lOx;
      if (localb != null)
      {
        localb.a(paramb, paramString);
        AppMethodBeat.o(223554);
        return;
      }
      AppMethodBeat.o(223554);
      return;
    }
    catch (Throwable paramb)
    {
      if (this.jAD)
      {
        ae.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(paramb));
        AppMethodBeat.o(223554);
        return;
      }
      AppMethodBeat.o(223554);
      throw paramb;
    }
  }
  
  public final void aXJ()
  {
    AppMethodBeat.i(50764);
    try
    {
      AppBrandPrepareTask.b localb = this.lOx;
      if (localb != null)
      {
        localb.aXJ();
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jAD)
      {
        ae.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
      throw localThrowable;
    }
  }
  
  public final void aXK()
  {
    AppMethodBeat.i(223555);
    try
    {
      AppBrandPrepareTask.b localb = this.lOx;
      if (localb != null)
      {
        localb.aXK();
        AppMethodBeat.o(223555);
        return;
      }
      AppMethodBeat.o(223555);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jAD)
      {
        ae.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(223555);
        return;
      }
      AppMethodBeat.o(223555);
      throw localThrowable;
    }
  }
  
  public final void aXL()
  {
    AppMethodBeat.i(223556);
    try
    {
      AppBrandPrepareTask.b localb = this.lOx;
      if (localb != null)
      {
        localb.aXL();
        AppMethodBeat.o(223556);
        return;
      }
      AppMethodBeat.o(223556);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jAD)
      {
        ae.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(223556);
        return;
      }
      AppMethodBeat.o(223556);
      throw localThrowable;
    }
  }
  
  public final void dead()
  {
    AppMethodBeat.i(180618);
    ae.i("MicroMsg.LaunchPrepareCallbackWrapper", "dead() hash=" + hashCode());
    this.lOx = null;
    this.jAD = true;
    AppMethodBeat.o(180618);
  }
  
  public final void rF(int paramInt)
  {
    AppMethodBeat.i(50759);
    try
    {
      AppBrandPrepareTask.b localb = this.lOx;
      if (localb != null)
      {
        localb.rF(paramInt);
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jAD)
      {
        ae.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
      throw localThrowable;
    }
  }
  
  public final void rG(int paramInt)
  {
    AppMethodBeat.i(50762);
    try
    {
      AppBrandPrepareTask.b localb = this.lOx;
      if (localb != null)
      {
        localb.rG(paramInt);
        AppMethodBeat.o(50762);
        return;
      }
      AppMethodBeat.o(50762);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jAD)
      {
        ae.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50762);
        return;
      }
      AppMethodBeat.o(50762);
      throw localThrowable;
    }
  }
  
  public final void sP(long paramLong)
  {
    AppMethodBeat.i(50761);
    try
    {
      AppBrandPrepareTask.b localb = this.lOx;
      if (localb != null)
      {
        localb.sP(paramLong);
        AppMethodBeat.o(50761);
        return;
      }
      AppMethodBeat.o(50761);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jAD)
      {
        ae.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
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
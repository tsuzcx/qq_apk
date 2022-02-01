package com.tencent.mm.plugin.appbrand.launching;

import android.util.Log;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.v.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.e.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPrepareCallbackWrapper;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "referenced", "(Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;)V", "mDead", "", "mReferenced", "dead", "", "onDataTransferState", "state", "", "onDownloadProcess", "progress", "onDownloadStarted", "startTime", "", "onPrepareDone", "config", "errorAction", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;", "startupPerformanceReport", "Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;", "(Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;)V", "onSyncJsApiInfoStart", "onSyncLaunchStart", "onVersionUpdateEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "passThroughInfo", "", "tryOrThrows", "block", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class ar<C extends AppBrandSysConfigLU>
  implements AppBrandPrepareTask.b<C>, a
{
  private volatile boolean jex;
  private volatile AppBrandPrepareTask.b<C> lmM;
  
  public ar(AppBrandPrepareTask.b<C> paramb)
  {
    AppMethodBeat.i(50765);
    ac.i("MicroMsg.LaunchPrepareCallbackWrapper", "<init> hash=" + hashCode());
    this.lmM = paramb;
    AppMethodBeat.o(50765);
  }
  
  public final void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle)
  {
    AppMethodBeat.i(50760);
    try
    {
      AppBrandPrepareTask.b localb = this.lmM;
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
      if (this.jex)
      {
        ac.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(paramC));
        AppMethodBeat.o(50760);
        return;
      }
      AppMethodBeat.o(50760);
      throw paramC;
    }
  }
  
  public final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(187331);
    try
    {
      AppBrandPrepareTask.b localb = this.lmM;
      if (localb != null)
      {
        localb.a(paramb, paramString);
        AppMethodBeat.o(187331);
        return;
      }
      AppMethodBeat.o(187331);
      return;
    }
    catch (Throwable paramb)
    {
      if (this.jex)
      {
        ac.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(paramb));
        AppMethodBeat.o(187331);
        return;
      }
      AppMethodBeat.o(187331);
      throw paramb;
    }
  }
  
  public final void aUg()
  {
    AppMethodBeat.i(50764);
    try
    {
      AppBrandPrepareTask.b localb = this.lmM;
      if (localb != null)
      {
        localb.aUg();
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jex)
      {
        ac.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
      throw localThrowable;
    }
  }
  
  public final void aUh()
  {
    AppMethodBeat.i(187332);
    try
    {
      AppBrandPrepareTask.b localb = this.lmM;
      if (localb != null)
      {
        localb.aUh();
        AppMethodBeat.o(187332);
        return;
      }
      AppMethodBeat.o(187332);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jex)
      {
        ac.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(187332);
        return;
      }
      AppMethodBeat.o(187332);
      throw localThrowable;
    }
  }
  
  public final void dead()
  {
    AppMethodBeat.i(180618);
    ac.i("MicroMsg.LaunchPrepareCallbackWrapper", "dead() hash=" + hashCode());
    this.lmM = null;
    this.jex = true;
    AppMethodBeat.o(180618);
  }
  
  public final void qE(long paramLong)
  {
    AppMethodBeat.i(50761);
    try
    {
      AppBrandPrepareTask.b localb = this.lmM;
      if (localb != null)
      {
        localb.qE(paramLong);
        AppMethodBeat.o(50761);
        return;
      }
      AppMethodBeat.o(50761);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jex)
      {
        ac.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50761);
        return;
      }
      AppMethodBeat.o(50761);
      throw localThrowable;
    }
  }
  
  public final void rc(int paramInt)
  {
    AppMethodBeat.i(50759);
    try
    {
      AppBrandPrepareTask.b localb = this.lmM;
      if (localb != null)
      {
        localb.rc(paramInt);
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jex)
      {
        ac.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
      throw localThrowable;
    }
  }
  
  public final void rd(int paramInt)
  {
    AppMethodBeat.i(50762);
    try
    {
      AppBrandPrepareTask.b localb = this.lmM;
      if (localb != null)
      {
        localb.rd(paramInt);
        AppMethodBeat.o(50762);
        return;
      }
      AppMethodBeat.o(50762);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jex)
      {
        ac.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + Log.getStackTraceString(localThrowable));
        AppMethodBeat.o(50762);
        return;
      }
      AppMethodBeat.o(50762);
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ar
 * JD-Core Version:    0.7.0.1
 */
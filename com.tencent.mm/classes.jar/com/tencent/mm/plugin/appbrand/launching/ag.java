package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c;
import com.tencent.mm.vending.e.a;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPrepareCallbackWrapper;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "referenced", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;)V", "mDead", "", "mPrepareDoneCalled", "mReferenced", "mVersionUpdateCalled", "updateEventCompleteEnums", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "callDeadOnCompleteExcepted", "", "dead", "notifyAppRestartOnLaunchRequestedLatestVersion", "onDataTransferState", "state", "", "onDownloadProcess", "progress", "onDownloadStarted", "startTime", "", "onLaunchTimeoutFallbackReloadRequested", "onPrepareDone", "config", "errorAction", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;", "startupPerformanceReport", "Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;", "(Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;)V", "onSyncAppidABTestStart", "onSyncJsApiInfoStart", "onSyncLaunchStart", "onVersionUpdateEvent", "passThroughInfo", "", "tryOrThrows", "block", "Lkotlin/Function0;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ag<C extends AppBrandSysConfigLU>
  implements AppBrandPrepareTask.b<C>, a
{
  private volatile boolean qtq;
  private AppBrandRuntime qzz;
  private volatile AppBrandPrepareTask.b<C> taU;
  private volatile boolean taV;
  private volatile boolean taW;
  private final c[] taX;
  
  public ag(AppBrandRuntime paramAppBrandRuntime, AppBrandPrepareTask.b<C> paramb)
  {
    AppMethodBeat.i(320674);
    this.qzz = paramAppBrandRuntime;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.LaunchPrepareCallbackWrapper", s.X("<init> hash=", Integer.valueOf(hashCode())));
    paramAppBrandRuntime.keep((a)this);
    this.taU = paramb;
    this.taX = new c[] { c.syZ, c.szb, c.sza };
    AppMethodBeat.o(320674);
  }
  
  private final void cAn()
  {
    AppMethodBeat.i(320678);
    if (this.qtq)
    {
      AppMethodBeat.o(320678);
      return;
    }
    if ((this.taV) && (this.taW)) {
      dead();
    }
    AppMethodBeat.o(320678);
  }
  
  public final void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle)
  {
    AppMethodBeat.i(50760);
    try
    {
      AppBrandPrepareTask.b localb = this.taU;
      if (localb != null) {
        localb.a(paramC, paramAppBrandLaunchErrorAction, paramAppStartupPerformanceReportBundle);
      }
    }
    finally
    {
      while (this.qtq) {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", s.X("tryOfThrows when dead, get exception: ", android.util.Log.getStackTraceString(paramC)));
      }
      AppMethodBeat.o(50760);
    }
    this.taV = true;
    cAn();
    AppMethodBeat.o(50760);
  }
  
  public final void a(c paramc, String paramString)
  {
    AppMethodBeat.i(320690);
    try
    {
      AppBrandPrepareTask.b localb = this.taU;
      if (localb != null) {
        localb.a(paramc, paramString);
      }
    }
    finally
    {
      while (this.qtq) {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", s.X("tryOfThrows when dead, get exception: ", android.util.Log.getStackTraceString(paramString)));
      }
      AppMethodBeat.o(320690);
    }
    if (paramc == null)
    {
      AppMethodBeat.o(320690);
      return;
    }
    if (k.contains(this.taX, paramc))
    {
      this.taW = true;
      cAn();
    }
    AppMethodBeat.o(320690);
  }
  
  public final void cda()
  {
    AppMethodBeat.i(50764);
    try
    {
      AppBrandPrepareTask.b localb = this.taU;
      if (localb != null) {
        localb.cda();
      }
      AppMethodBeat.o(50764);
      return;
    }
    finally
    {
      if (this.qtq)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", s.X("tryOfThrows when dead, get exception: ", android.util.Log.getStackTraceString(localThrowable)));
        AppMethodBeat.o(50764);
        return;
      }
      AppMethodBeat.o(50764);
    }
  }
  
  public final void cdb()
  {
    AppMethodBeat.i(320694);
    try
    {
      AppBrandPrepareTask.b localb = this.taU;
      if (localb != null) {
        localb.cdb();
      }
      AppMethodBeat.o(320694);
      return;
    }
    finally
    {
      if (this.qtq)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", s.X("tryOfThrows when dead, get exception: ", android.util.Log.getStackTraceString(localThrowable)));
        AppMethodBeat.o(320694);
        return;
      }
      AppMethodBeat.o(320694);
    }
  }
  
  public final void cdc()
  {
    AppMethodBeat.i(320698);
    try
    {
      AppBrandPrepareTask.b localb = this.taU;
      if (localb != null) {
        localb.cdc();
      }
      AppMethodBeat.o(320698);
      return;
    }
    finally
    {
      if (this.qtq)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", s.X("tryOfThrows when dead, get exception: ", android.util.Log.getStackTraceString(localThrowable)));
        AppMethodBeat.o(320698);
        return;
      }
      AppMethodBeat.o(320698);
    }
  }
  
  public final void cdd()
  {
    AppMethodBeat.i(320699);
    try
    {
      AppBrandPrepareTask.b localb = this.taU;
      if (localb != null) {
        localb.cdd();
      }
      AppMethodBeat.o(320699);
      return;
    }
    finally
    {
      if (this.qtq)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", s.X("tryOfThrows when dead, get exception: ", android.util.Log.getStackTraceString(localThrowable)));
        AppMethodBeat.o(320699);
        return;
      }
      AppMethodBeat.o(320699);
    }
  }
  
  public final void cde()
  {
    AppMethodBeat.i(320704);
    try
    {
      AppBrandPrepareTask.b localb = this.taU;
      if (localb != null) {
        localb.cde();
      }
      AppMethodBeat.o(320704);
      return;
    }
    finally
    {
      if (this.qtq)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", s.X("tryOfThrows when dead, get exception: ", android.util.Log.getStackTraceString(localThrowable)));
        AppMethodBeat.o(320704);
        return;
      }
      AppMethodBeat.o(320704);
    }
  }
  
  public void dead()
  {
    AppMethodBeat.i(180618);
    StringBuilder localStringBuilder = new StringBuilder("dead() hash=").append(hashCode()).append(", appId:");
    Object localObject = this.qzz;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((AppBrandRuntime)localObject).mAppId)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.LaunchPrepareCallbackWrapper", localObject + ", mPrepareDoneCalled:" + this.taV + ", mVersionUpdateCalled:" + this.taW);
      localObject = this.qzz;
      if (localObject != null) {
        ((AppBrandRuntime)localObject).a((a)this);
      }
      this.qzz = null;
      this.taU = null;
      this.qtq = true;
      AppMethodBeat.o(180618);
      return;
    }
  }
  
  public final void jy(long paramLong)
  {
    AppMethodBeat.i(50761);
    try
    {
      AppBrandPrepareTask.b localb = this.taU;
      if (localb != null) {
        localb.jy(paramLong);
      }
      AppMethodBeat.o(50761);
      return;
    }
    finally
    {
      if (this.qtq)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", s.X("tryOfThrows when dead, get exception: ", android.util.Log.getStackTraceString(localThrowable)));
        AppMethodBeat.o(50761);
        return;
      }
      AppMethodBeat.o(50761);
    }
  }
  
  public final void yU(int paramInt)
  {
    AppMethodBeat.i(50759);
    try
    {
      AppBrandPrepareTask.b localb = this.taU;
      if (localb != null) {
        localb.yU(paramInt);
      }
      AppMethodBeat.o(50759);
      return;
    }
    finally
    {
      if (this.qtq)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", s.X("tryOfThrows when dead, get exception: ", android.util.Log.getStackTraceString(localThrowable)));
        AppMethodBeat.o(50759);
        return;
      }
      AppMethodBeat.o(50759);
    }
  }
  
  public final void yV(int paramInt)
  {
    AppMethodBeat.i(50762);
    try
    {
      AppBrandPrepareTask.b localb = this.taU;
      if (localb != null) {
        localb.yV(paramInt);
      }
      AppMethodBeat.o(50762);
      return;
    }
    finally
    {
      if (this.qtq)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.LaunchPrepareCallbackWrapper", s.X("tryOfThrows when dead, get exception: ", android.util.Log.getStackTraceString(localThrowable)));
        AppMethodBeat.o(50762);
        return;
      }
      AppMethodBeat.o(50762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ag
 * JD-Core Version:    0.7.0.1
 */
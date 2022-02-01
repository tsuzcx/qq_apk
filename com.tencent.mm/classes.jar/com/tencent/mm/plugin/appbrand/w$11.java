package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.sdk.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicBoolean;

final class w$11
  implements AppBrandPrepareTask.b<AppBrandSysConfigWC>
{
  private volatile bf qwa;
  
  w$11(w paramw, AppBrandPrepareTask paramAppBrandPrepareTask, long paramLong, AppBrandRuntime.b paramb) {}
  
  public final void a(c paramc, String paramString)
  {
    AppMethodBeat.i(316583);
    if ((this.qvY.qsE.get()) || (this.qwb.qwA)) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onVersionUpdateEvent(%s), task[%d] appId[%s]", new Object[] { paramc, Integer.valueOf(this.qwb.hashCode()), this.qvY.mAppId });
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(316583);
      return;
    }
    this.qvY.U(new w.11.4(this, paramc, paramString));
    AppMethodBeat.o(316583);
  }
  
  public final void cda()
  {
    AppMethodBeat.i(316567);
    if ((this.qvY.qsE.get()) || (this.qwb.qwA)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onSyncLaunchStart task[%d] appId[%s] interrupted[%b]", new Object[] { Integer.valueOf(this.qwb.hashCode()), this.qvY.mAppId, Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(316567);
      return;
    }
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.qvY.mAppId).tSC = true;
      p localp = w.p(this.qvY);
      if (localp != null) {
        localp.a(p.a.qtU);
      }
      AppMethodBeat.o(316567);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandRuntimeWC", "onSyncLaunchStart get QualitySession with appId[%s], e=%s", new Object[] { this.qvY.mAppId, localException });
      }
    }
  }
  
  public final void cdb()
  {
    AppMethodBeat.i(316568);
    if ((this.qvY.qsE.get()) || (this.qwb.qwA)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onSyncJsApiInfoStart task[%d] appId[%s] interrupted[%b]", new Object[] { Integer.valueOf(this.qwb.hashCode()), this.qvY.mAppId, Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(316568);
      return;
    }
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.qvY.mAppId).tSE = true;
      p localp = w.p(this.qvY);
      if (localp != null)
      {
        localp.a(p.a.qtW);
        AppMethodBeat.o(316568);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandRuntimeWC", "onSyncJsApiInfoStart get QualitySession with appId[%s], e=%s", new Object[] { this.qvY.mAppId, localException });
      }
      Log.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeBoostStrategy boost null!");
      AppMethodBeat.o(316568);
    }
  }
  
  public final void cdc()
  {
    AppMethodBeat.i(316572);
    if ((this.qvY.qsE.get()) || (this.qwb.qwA)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onSyncAppidABTestStart task[%d] appId[%s] interrupted[%b]", new Object[] { Integer.valueOf(this.qwb.hashCode()), this.qvY.mAppId, Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(316572);
      return;
    }
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.qvY.mAppId).tSF = true;
      p localp = w.p(this.qvY);
      if (localp != null)
      {
        localp.a(p.a.qtY);
        AppMethodBeat.o(316572);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandRuntimeWC", "onSyncAppidABTestStart get QualitySession with appId[%s], e=%s", new Object[] { this.qvY.mAppId, localException });
      }
      Log.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeBoostStrategy boost null!");
      AppMethodBeat.o(316572);
    }
  }
  
  public final void cdd()
  {
    AppMethodBeat.i(316587);
    if ((this.qvY.qsE.get()) || (this.qwb.qwA)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = this.qvY.getInitConfig().qYs;
      Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onLaunchTimeoutFallbackReloadRequested, task[%d], appId[%s], interrupted[%b], isBackupWxaAttrsAlreadyUsed[%b]", new Object[] { Integer.valueOf(this.qwb.hashCode()), this.qvY.mAppId, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (!bool2)) {
        break;
      }
      AppMethodBeat.o(316587);
      return;
    }
    this.qwa = bf.a(this.qvY, this.qwb);
    AppMethodBeat.o(316587);
  }
  
  public final void cde()
  {
    AppMethodBeat.i(316593);
    if ((this.qvY.qsE.get()) || (this.qwb.qwA)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| notifyAppRestartOnLaunchRequestedLatestVersion, task[%d], appId[%s], interrupted[%b]", new Object[] { Integer.valueOf(this.qwb.hashCode()), this.qvY.mAppId, Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(316593);
      return;
    }
    bg.v(this.qvY);
    AppMethodBeat.o(316593);
  }
  
  public final void jy(long paramLong)
  {
    AppMethodBeat.i(316574);
    if ((this.qvY.qsE.get()) || (this.qwb.qwA)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onDownloadStarted(%s) task[%d] appId[%s] interrupted[%b]", new Object[] { Util.formatUnixTime(paramLong), Integer.valueOf(this.qwb.hashCode()), this.qvY.mAppId, Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(316574);
      return;
    }
    this.qvY.qvA = true;
    if (w.q(this.qvY) != null) {
      w.q(this.qvY).tQp = true;
    }
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.qvY.mAppId).tSD = true;
      w.hY(this.qvY.qvA);
      p localp = w.p(this.qvY);
      if (localp != null) {
        localp.a(p.a.qtV);
      }
      AppMethodBeat.o(316574);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandRuntimeWC", "onSyncLaunchStart get QualitySession with appId[%s], e=%s", new Object[] { this.qvY.mAppId, localException });
      }
    }
  }
  
  public final void yU(int paramInt)
  {
    AppMethodBeat.i(316564);
    this.qvY.yU(paramInt);
    AppMethodBeat.o(316564);
  }
  
  public final void yV(int paramInt)
  {
    AppMethodBeat.i(316577);
    if ((this.qvY.qsE.get()) || (this.qwb.qwA)) {}
    for (int i = 1;; i = 0)
    {
      Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onDownloadProgress(%d), task[%d] appId[%s]  hasDownload[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.qwb.hashCode()), this.qvY.mAppId, Boolean.valueOf(this.qvY.qvA) });
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(316577);
      return;
    }
    w localw = this.qvY;
    localw.i(new AppBrandRuntime.4(localw, paramInt), 0L);
    AppMethodBeat.o(316577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.11
 * JD-Core Version:    0.7.0.1
 */
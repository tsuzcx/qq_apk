package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.y.b;
import com.tencent.mm.plugin.appbrand.jsapi.y.b.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class o$8
  implements AppBrandPrepareTask.b<AppBrandSysConfigWC>
{
  private volatile am jzD;
  
  o$8(o paramo, AppBrandPrepareTask paramAppBrandPrepareTask, long paramLong, AppBrandRuntime.b paramb) {}
  
  public final void a(final b paramb, final String paramString)
  {
    AppMethodBeat.i(187894);
    if ((this.jzB.isDestroyed()) || (this.jzE.jzS)) {}
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onVersionUpdateEvent(%s), task[%d] appId[%s]", new Object[] { paramb, Integer.valueOf(this.jzE.hashCode()), this.jzB.mAppId });
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(187894);
      return;
    }
    this.jzB.L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187888);
        b localb = paramb;
        c localc = o.8.this.jzB.aXe();
        String str = paramString;
        if (localc == null)
        {
          AppMethodBeat.o(187888);
          return;
        }
        ad.i("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), appId:%s, service:%d", new Object[] { localb.lkt, localc.getAppId(), Integer.valueOf(localc.hashCode()) });
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("state", localb.lkt);
        if (!TextUtils.isEmpty(str)) {}
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("passThroughInfo", new JSONObject(str));
          localHashMap.put("appContactInfo", localJSONObject);
          new b.a((byte)0).g(localc).A(localHashMap).bir();
          AppMethodBeat.o(187888);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ad.e("MicroMsg.AppBrand.Version.UpdateState[appversion]", "dispatch(%s), appId:%s, service:%d, put passThroughInfo get Exception:%s", new Object[] { localb.lkt, localc.getAppId(), Integer.valueOf(localc.hashCode()), localJSONException });
          }
        }
      }
    });
    AppMethodBeat.o(187894);
  }
  
  public final void aXo()
  {
    AppMethodBeat.i(187890);
    if ((this.jzB.isDestroyed()) || (this.jzE.jzS)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onSyncLaunchStart task[%d] appId[%s] interrupted[%b]", new Object[] { Integer.valueOf(this.jzE.hashCode()), this.jzB.mAppId, Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(187890);
      return;
    }
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.jzB.mAppId).mvD = true;
      k localk = o.j(this.jzB);
      if (localk != null) {
        localk.a(k.a.jyd);
      }
      AppMethodBeat.o(187890);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandRuntimeWC", "onSyncLaunchStart get QualitySession with appId[%s], e=%s", new Object[] { this.jzB.mAppId, localException });
      }
    }
  }
  
  public final void aXp()
  {
    AppMethodBeat.i(187891);
    if ((this.jzB.isDestroyed()) || (this.jzE.jzS)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onSyncJsApiInfoStart task[%d] appId[%s] interrupted[%b]", new Object[] { Integer.valueOf(this.jzE.hashCode()), this.jzB.mAppId, Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(187891);
      return;
    }
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.jzB.mAppId).mvF = true;
      k localk = o.j(this.jzB);
      if (localk != null)
      {
        localk.a(k.a.jyf);
        AppMethodBeat.o(187891);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandRuntimeWC", "onSyncJsApiInfoStart get QualitySession with appId[%s], e=%s", new Object[] { this.jzB.mAppId, localException });
      }
      ad.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeBoostStrategy boost null!");
      AppMethodBeat.o(187891);
    }
  }
  
  public final void aXq()
  {
    AppMethodBeat.i(187895);
    if ((this.jzB.isDestroyed()) || (this.jzE.jzS)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = this.jzB.aXc().jXK;
      ad.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onLaunchTimeoutFallbackReloadRequested, task[%d], appId[%s], interrupted[%b], isBackupWxaAttrsAlreadyUsed[%b]", new Object[] { Integer.valueOf(this.jzE.hashCode()), this.jzB.mAppId, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (!bool2)) {
        break;
      }
      AppMethodBeat.o(187895);
      return;
    }
    this.jzD = am.a(this.jzB, this.jzE);
    AppMethodBeat.o(187895);
  }
  
  public final void rC(int paramInt)
  {
    AppMethodBeat.i(187889);
    this.jzB.rC(paramInt);
    AppMethodBeat.o(187889);
  }
  
  public final void rD(int paramInt)
  {
    AppMethodBeat.i(187893);
    if ((this.jzB.isDestroyed()) || (this.jzE.jzS)) {}
    for (int i = 1;; i = 0)
    {
      ad.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onDownloadProgress(%d), task[%d] appId[%s]  hasDownload[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jzE.hashCode()), this.jzB.mAppId, Boolean.valueOf(this.jzB.jzn) });
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(187893);
      return;
    }
    o localo = this.jzB;
    localo.j(new AppBrandRuntime.2(localo, paramInt), 0L);
    AppMethodBeat.o(187893);
  }
  
  public final void sC(long paramLong)
  {
    AppMethodBeat.i(187892);
    if ((this.jzB.isDestroyed()) || (this.jzE.jzS)) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onDownloadStarted(%s) task[%d] appId[%s] interrupted[%b]", new Object[] { bt.Dc(paramLong), Integer.valueOf(this.jzE.hashCode()), this.jzB.mAppId, Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      AppMethodBeat.o(187892);
      return;
    }
    this.jzB.jzn = true;
    if (o.k(this.jzB) != null) {
      o.k(this.jzB).mtx = true;
    }
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.jzB.mAppId).mvE = true;
      o.fD(this.jzB.jzn);
      k localk = o.j(this.jzB);
      if (localk != null) {
        localk.a(k.a.jye);
      }
      AppMethodBeat.o(187892);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandRuntimeWC", "onSyncLaunchStart get QualitySession with appId[%s], e=%s", new Object[] { this.jzB.mAppId, localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.8
 * JD-Core Version:    0.7.0.1
 */
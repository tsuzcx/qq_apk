package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 317;
  public static final String NAME = "getWifiList";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144688);
    if (!d.lAG)
    {
      ae.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.h(paramInt, n("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final Context localContext = paramc.getContext();
    if (localContext == null)
    {
      ae.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, n("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    e.dG(localContext);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      ae.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.h(paramInt, n("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    Object localObject = new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(208355);
        ae.i("MicroMsg.JsApiGetWifiList", "onTimerExpired");
        e.bqc();
        if (!localAtomicBoolean.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d locald = e.bqb();
          c.a(c.this, paramc, paramInt, localContext, locald);
          localAtomicBoolean.set(true);
        }
        for (;;)
        {
          AppMethodBeat.o(208355);
          return false;
          ae.i("MicroMsg.JsApiGetWifiList", "onTimerExpired, hasCallback");
        }
      }
    };
    localObject = new aw(Looper.getMainLooper(), (aw.a)localObject, false);
    e.a(new b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d paramAnonymousd)
      {
        AppMethodBeat.i(208356);
        ae.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList");
        this.lAF.stopTimer();
        e.bqc();
        if (!localAtomicBoolean.get())
        {
          c.a(c.this, paramc, paramInt, localContext, paramAnonymousd);
          localAtomicBoolean.set(true);
          AppMethodBeat.o(208356);
          return;
        }
        ae.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList, hasCallback");
        AppMethodBeat.o(208356);
      }
    });
    if (paramJSONObject != null) {}
    for (long l = paramJSONObject.optLong("timeout", 10000L);; l = 10000L)
    {
      ae.i("MicroMsg.JsApiGetWifiList", "invoke, getWifiListAsyncTimeoutMills: ".concat(String.valueOf(l)));
      ((aw)localObject).ay(l, l);
      AppMethodBeat.o(144688);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.c
 * JD-Core Version:    0.7.0.1
 */
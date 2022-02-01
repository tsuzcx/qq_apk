package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
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
    if (!d.lwi)
    {
      ad.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.h(paramInt, m("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final Context localContext = paramc.getContext();
    if (localContext == null)
    {
      ad.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    e.dC(localContext);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      ad.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.h(paramInt, m("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    Object localObject = new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(195106);
        ad.i("MicroMsg.JsApiGetWifiList", "onTimerExpired");
        e.bps();
        if (!localAtomicBoolean.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d locald = e.bpr();
          c.a(c.this, paramc, paramInt, localContext, locald);
          localAtomicBoolean.set(true);
        }
        for (;;)
        {
          AppMethodBeat.o(195106);
          return false;
          ad.i("MicroMsg.JsApiGetWifiList", "onTimerExpired, hasCallback");
        }
      }
    };
    localObject = new av(Looper.getMainLooper(), (av.a)localObject, false);
    e.a(new b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d paramAnonymousd)
      {
        AppMethodBeat.i(195107);
        ad.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList");
        this.lwh.stopTimer();
        e.bps();
        if (!localAtomicBoolean.get())
        {
          c.a(c.this, paramc, paramInt, localContext, paramAnonymousd);
          localAtomicBoolean.set(true);
          AppMethodBeat.o(195107);
          return;
        }
        ad.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList, hasCallback");
        AppMethodBeat.o(195107);
      }
    });
    if (paramJSONObject != null) {}
    for (long l = paramJSONObject.optLong("timeout", 10000L);; l = 10000L)
    {
      ad.i("MicroMsg.JsApiGetWifiList", "invoke, getWifiListAsyncTimeoutMills: ".concat(String.valueOf(l)));
      ((av)localObject).az(l, l);
      AppMethodBeat.o(144688);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.c
 * JD-Core Version:    0.7.0.1
 */
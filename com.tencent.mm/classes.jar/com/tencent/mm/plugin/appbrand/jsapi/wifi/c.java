package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
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
    if (!d.kxS)
    {
      ad.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.h(paramInt, k("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final Context localContext = paramc.getContext();
    if (localContext == null)
    {
      ad.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, k("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    e.dv(localContext);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      ad.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.h(paramInt, k("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    Object localObject = new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(193705);
        ad.i("MicroMsg.JsApiGetWifiList", "onTimerExpired");
        e.beN();
        if (!localAtomicBoolean.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d locald = e.beM();
          c.a(c.this, paramc, paramInt, localContext, locald);
          localAtomicBoolean.set(true);
        }
        for (;;)
        {
          AppMethodBeat.o(193705);
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
        AppMethodBeat.i(193706);
        ad.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList");
        this.kxR.stopTimer();
        e.beN();
        if (!localAtomicBoolean.get())
        {
          c.a(c.this, paramc, paramInt, localContext, paramAnonymousd);
          localAtomicBoolean.set(true);
          AppMethodBeat.o(193706);
          return;
        }
        ad.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList, hasCallback");
        AppMethodBeat.o(193706);
      }
    });
    if (paramJSONObject != null) {}
    for (long l = paramJSONObject.optLong("timeout", 10000L);; l = 10000L)
    {
      ad.i("MicroMsg.JsApiGetWifiList", "invoke, getWifiListAsyncTimeoutMills: ".concat(String.valueOf(l)));
      ((av)localObject).av(l, l);
      AppMethodBeat.o(144688);
      return;
    }
  }
  
  public static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 321;
    private static final String NAME = "onGetWifiList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.c
 * JD-Core Version:    0.7.0.1
 */
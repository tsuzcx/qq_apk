package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
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
    if (!d.kZg)
    {
      ac.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.h(paramInt, k("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final Context localContext = paramc.getContext();
    if (localContext == null)
    {
      ac.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, k("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    e.dE(localContext);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      ac.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.h(paramInt, k("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    Object localObject = new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(204978);
        ac.i("MicroMsg.JsApiGetWifiList", "onTimerExpired");
        e.blH();
        if (!localAtomicBoolean.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d locald = e.blG();
          c.a(c.this, paramc, paramInt, localContext, locald);
          localAtomicBoolean.set(true);
        }
        for (;;)
        {
          AppMethodBeat.o(204978);
          return false;
          ac.i("MicroMsg.JsApiGetWifiList", "onTimerExpired, hasCallback");
        }
      }
    };
    localObject = new au(Looper.getMainLooper(), (au.a)localObject, false);
    e.a(new b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d paramAnonymousd)
      {
        AppMethodBeat.i(204979);
        ac.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList");
        this.kZf.stopTimer();
        e.blH();
        if (!localAtomicBoolean.get())
        {
          c.a(c.this, paramc, paramInt, localContext, paramAnonymousd);
          localAtomicBoolean.set(true);
          AppMethodBeat.o(204979);
          return;
        }
        ac.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList, hasCallback");
        AppMethodBeat.o(204979);
      }
    });
    if (paramJSONObject != null) {}
    for (long l = paramJSONObject.optLong("timeout", 10000L);; l = 10000L)
    {
      ac.i("MicroMsg.JsApiGetWifiList", "invoke, getWifiListAsyncTimeoutMills: ".concat(String.valueOf(l)));
      ((au)localObject).au(l, l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.c
 * JD-Core Version:    0.7.0.1
 */
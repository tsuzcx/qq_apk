package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 317;
  public static final String NAME = "getWifiList";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144688);
    if (!d.mHU)
    {
      Log.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramf.i(paramInt, n("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final Context localContext = paramf.getContext();
    if (localContext == null)
    {
      Log.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.i(paramInt, n("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    e.eb(localContext);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.isWifiEnabled())
    {
      Log.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramf.i(paramInt, n("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    Object localObject = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(215164);
        Log.i("MicroMsg.JsApiGetWifiList", "onTimerExpired");
        e.bLI();
        if (!localAtomicBoolean.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d locald = e.bLH();
          c.a(c.this, paramf, paramInt, localContext, locald);
          localAtomicBoolean.set(true);
        }
        for (;;)
        {
          AppMethodBeat.o(215164);
          return false;
          Log.i("MicroMsg.JsApiGetWifiList", "onTimerExpired, hasCallback");
        }
      }
    };
    localObject = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)localObject, false);
    e.a(new b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d paramAnonymousd)
      {
        AppMethodBeat.i(215165);
        Log.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList");
        this.mHT.stopTimer();
        e.bLI();
        if (!localAtomicBoolean.get())
        {
          c.a(c.this, paramf, paramInt, localContext, paramAnonymousd);
          localAtomicBoolean.set(true);
          AppMethodBeat.o(215165);
          return;
        }
        Log.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList, hasCallback");
        AppMethodBeat.o(215165);
      }
    });
    if (paramJSONObject != null) {}
    for (long l = paramJSONObject.optLong("timeout", 10000L);; l = 10000L)
    {
      Log.i("MicroMsg.JsApiGetWifiList", "invoke, getWifiListAsyncTimeoutMills: ".concat(String.valueOf(l)));
      ((MTimerHandler)localObject).startTimer(l);
      AppMethodBeat.o(144688);
      return;
    }
  }
  
  public static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 321;
    private static final String NAME = "onGetWifiList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.c
 * JD-Core Version:    0.7.0.1
 */
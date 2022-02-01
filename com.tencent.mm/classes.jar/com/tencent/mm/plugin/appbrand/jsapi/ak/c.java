package com.tencent.mm.plugin.appbrand.jsapi.ak;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 317;
  public static final String NAME = "getWifiList";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144688);
    if (!d.sNz)
    {
      Log.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramf.callback(paramInt, m("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final Context localContext = paramf.getContext();
    if (localContext == null)
    {
      Log.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.callback(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    g.eW(localContext);
    if (!com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cyv())
    {
      Log.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramf.callback(paramInt, m("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    Object localObject = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(325757);
        Log.i("MicroMsg.JsApiGetWifiList", "onTimerExpired");
        g.cyj();
        if (!localAtomicBoolean.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.ak.a.f localf = g.cyi();
          c.a(c.this, paramf, paramInt, localContext, localf);
          localAtomicBoolean.set(true);
        }
        for (;;)
        {
          AppMethodBeat.o(325757);
          return false;
          Log.i("MicroMsg.JsApiGetWifiList", "onTimerExpired, hasCallback");
        }
      }
    };
    localObject = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)localObject, false);
    g.a(new com.tencent.mm.plugin.appbrand.jsapi.ak.a.d()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.ak.a.f paramAnonymousf)
      {
        AppMethodBeat.i(325751);
        Log.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList");
        this.sNy.stopTimer();
        g.cyj();
        if (!localAtomicBoolean.get())
        {
          c.a(c.this, paramf, paramInt, localContext, paramAnonymousf);
          localAtomicBoolean.set(true);
          AppMethodBeat.o(325751);
          return;
        }
        Log.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList, hasCallback");
        AppMethodBeat.o(325751);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.c
 * JD-Core Version:    0.7.0.1
 */
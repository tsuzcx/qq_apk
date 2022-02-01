package com.tencent.mm.plugin.appbrand.jsapi.ah;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.az;
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
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144688);
    if (!d.pIH)
    {
      Log.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      parame.j(paramInt, m("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final Context localContext = parame.getContext();
    if (localContext == null)
    {
      Log.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      parame.j(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    f.eb(localContext);
    if (!com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYf())
    {
      Log.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      parame.j(paramInt, m("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144688);
      return;
    }
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    Object localObject = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(200417);
        Log.i("MicroMsg.JsApiGetWifiList", "onTimerExpired");
        f.bXT();
        if (!localAtomicBoolean.get())
        {
          com.tencent.mm.plugin.appbrand.jsapi.ah.a.e locale = f.bXS();
          c.a(c.this, parame, paramInt, localContext, locale);
          localAtomicBoolean.set(true);
        }
        for (;;)
        {
          AppMethodBeat.o(200417);
          return false;
          Log.i("MicroMsg.JsApiGetWifiList", "onTimerExpired, hasCallback");
        }
      }
    };
    localObject = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)localObject, false);
    f.a(new com.tencent.mm.plugin.appbrand.jsapi.ah.a.c()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.ah.a.e paramAnonymouse)
      {
        AppMethodBeat.i(200166);
        Log.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList");
        this.pIG.stopTimer();
        f.bXT();
        if (!localAtomicBoolean.get())
        {
          c.a(c.this, parame, paramInt, localContext, paramAnonymouse);
          localAtomicBoolean.set(true);
          AppMethodBeat.o(200166);
          return;
        }
        Log.i("MicroMsg.JsApiGetWifiList", "onGetWiFiList, hasCallback");
        AppMethodBeat.o(200166);
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
    extends az
  {
    private static final int CTRL_INDEX = 321;
    private static final String NAME = "onGetWifiList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.ak;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 316;
  public static final String NAME = "connectWifi";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144686);
    if (!d.sNz)
    {
      Log.e("MicroMsg.JsApiConnectWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramf.callback(paramInt, m("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("SSID")))
    {
      Log.e("MicroMsg.JsApiConnectWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.callback(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    Object localObject1 = paramf.getContext();
    if (localObject1 == null)
    {
      Log.e("MicroMsg.JsApiConnectWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.callback(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    g.eW((Context)localObject1);
    if (!com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cyv())
    {
      Log.e("MicroMsg.JsApiConnectWifi", "wifi is disable");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramf.callback(paramInt, m("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if (paramf.getAppState() != com.tencent.mm.plugin.appbrand.b.b.qKw)
    {
      Log.e("MicroMsg.JsApiConnectWifi", "current state :%s isn't foreground", new Object[] { paramf.getAppState() });
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12011));
      paramf.callback(paramInt, m("fail:weapp in background", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if (paramJSONObject.optBoolean("maunal", false))
    {
      localObject2 = new Intent("android.settings.WIFI_SETTINGS");
      if (Util.isIntentAvailable((Context)localObject1, (Intent)localObject2))
      {
        Log.i("MicroMsg.JsApiConnectWifi", "use manual");
        paramJSONObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramJSONObject.aYi(), "com/tencent/mm/plugin/appbrand/jsapi/wifi/JsApiConnectWifi", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)paramJSONObject.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/appbrand/jsapi/wifi/JsApiConnectWifi", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(0));
        paramf.callback(paramInt, m("ok", paramJSONObject));
        AppMethodBeat.o(144686);
        return;
      }
      Log.w("MicroMsg.JsApiConnectWifi", "jump2SysWifiSettingsIntent is unavailable");
    }
    Object localObject2 = (com.tencent.luggage.c.a.a)com.tencent.luggage.a.e.T(com.tencent.luggage.c.a.a.class);
    Object localObject3 = ((com.tencent.luggage.c.a.a)localObject2).aoc();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144682);
        paramf.getDialogContainer().b(this.sNq);
        AppMethodBeat.o(144682);
      }
    });
    com.tencent.mm.plugin.appbrand.jsapi.ak.a.b localb = com.tencent.mm.plugin.appbrand.jsapi.ak.a.b.sND;
    g.a(new com.tencent.mm.plugin.appbrand.jsapi.ak.a.c()
    {
      public final void aK(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(325755);
        g.a(null);
        MMHandlerThread.postToMainThread(new a.2.1(this));
        if (paramAnonymousString.equals("ok"))
        {
          if (paramAnonymousBoolean)
          {
            Log.i("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback] connect success, refresh ConnectivityCompat cache");
            ConnectivityCompat.Companion.getWiFiIpAddress(true);
          }
          paramAnonymousString = com.tencent.mm.plugin.appbrand.jsapi.ak.a.b.sND;
          paramAnonymousString = com.tencent.mm.plugin.appbrand.jsapi.ak.a.b.jS(this.sNt);
          Log.i("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]currentWifi:%s", new Object[] { paramAnonymousString });
          if (paramAnonymousString == null)
          {
            Log.e("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]currentWIfi is null");
            paramAnonymousString = new HashMap();
            localObject = a.a(this.sNu, paramf, paramAnonymousString, "fail:can't gain current wifi", paramAnonymousBoolean);
            paramf.callback(paramInt, a.this.m((String)localObject, paramAnonymousString));
            AppMethodBeat.o(325755);
            return;
          }
          try
          {
            localObject = new HashMap();
            ((HashMap)localObject).put("wifi", paramAnonymousString.aZh());
            ((HashMap)localObject).put("errCode", Integer.valueOf(0));
            paramf.callback(paramInt, a.this.m("ok", (Map)localObject));
            AppMethodBeat.o(325755);
            return;
          }
          catch (JSONException paramAnonymousString)
          {
            Log.e("MicroMsg.JsApiConnectWifi", "IConnectWiFiCallback is error");
            Log.printErrStackTrace("MicroMsg.JsApiConnectWifi", paramAnonymousString, "", new Object[0]);
            paramAnonymousString = new HashMap();
            paramAnonymousString.put("errCode", Integer.valueOf(12010));
            paramf.callback(paramInt, a.this.m("fail:parse json err", paramAnonymousString));
            AppMethodBeat.o(325755);
            return;
          }
        }
        Object localObject = new HashMap();
        if (paramAnonymousString.equals("duplicated request")) {
          ((HashMap)localObject).put("errCode", Integer.valueOf(12004));
        }
        for (;;)
        {
          Log.e("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]errCode:%d, errMsg:%s", new Object[] { ((HashMap)localObject).get("errCode"), paramAnonymousString });
          paramf.callback(paramInt, a.this.m("fail:".concat(String.valueOf(paramAnonymousString)), (Map)localObject));
          AppMethodBeat.o(325755);
          return;
          if (paramAnonymousString.equals("password error")) {
            ((HashMap)localObject).put("errCode", Integer.valueOf(12002));
          } else if (paramAnonymousString.equals("wifi config may be expired")) {
            ((HashMap)localObject).put("errCode", Integer.valueOf(12013));
          } else if (paramAnonymousString.equals("fail to connect wifi:time out")) {
            ((HashMap)localObject).put("errCode", Integer.valueOf(12003));
          } else {
            paramAnonymousString = a.a(this.sNu, paramf, (Map)localObject, paramAnonymousString, paramAnonymousBoolean);
          }
        }
      }
    });
    localObject1 = new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(144685);
        Log.d("MicroMsg.JsApiConnectWifi", "remove listener");
        g.a(null);
        k.b(paramf.getAppId(), this);
        AppMethodBeat.o(144685);
      }
    };
    k.a(paramf.getAppId(), (k.c)localObject1);
    localObject1 = paramJSONObject.optString("SSID");
    localObject2 = paramJSONObject.optString("BSSID");
    localObject3 = paramJSONObject.optString("password");
    long l = paramJSONObject.optLong("timeout", -1L);
    boolean bool = paramJSONObject.optBoolean("forceNewApi", false);
    if (((String)localObject1).equals(""))
    {
      Log.e("MicroMsg.JsApiConnectWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12008));
      paramf.callback(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    Log.i("MicroMsg.JsApiConnectWifi", "ssid:%s, bSsid:%s timeoutMs: %d, forceNewApi: %b is connecting", new Object[] { localObject1, localObject2, Long.valueOf(l), Boolean.valueOf(bool) });
    g.a((String)localObject1, (String)localObject2, (String)localObject3, l, bool);
    AppMethodBeat.o(144686);
  }
  
  public static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 322;
    private static final String NAME = "onWifiConnected";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.a
 * JD-Core Version:    0.7.0.1
 */
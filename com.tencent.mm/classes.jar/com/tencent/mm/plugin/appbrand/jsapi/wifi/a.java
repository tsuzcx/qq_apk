package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 316;
  public static final String NAME = "connectWifi";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144686);
    if (!d.mHU)
    {
      Log.e("MicroMsg.JsApiConnectWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramf.i(paramInt, n("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("SSID")))
    {
      Log.e("MicroMsg.JsApiConnectWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.i(paramInt, n("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    Object localObject1 = paramf.getContext();
    if (localObject1 == null)
    {
      Log.e("MicroMsg.JsApiConnectWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.i(paramInt, n("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.eb((Context)localObject1);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.isWifiEnabled())
    {
      Log.e("MicroMsg.JsApiConnectWifi", "wifi is disable");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramf.i(paramInt, n("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if (paramf.getAppState() != b.kQH)
    {
      Log.e("MicroMsg.JsApiConnectWifi", "current state :%s isn't foreground", new Object[] { paramf.getAppState() });
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12011));
      paramf.i(paramInt, n("fail:weapp in background", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if (paramJSONObject.optBoolean("maunal", false))
    {
      localObject2 = new Intent("android.settings.WIFI_SETTINGS");
      if (Util.isIntentAvailable((Context)localObject1, (Intent)localObject2))
      {
        Log.i("MicroMsg.JsApiConnectWifi", "use manual");
        paramJSONObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramJSONObject.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/wifi/JsApiConnectWifi", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)paramJSONObject.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/appbrand/jsapi/wifi/JsApiConnectWifi", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(0));
        paramf.i(paramInt, n("ok", paramJSONObject));
        AppMethodBeat.o(144686);
        return;
      }
      Log.w("MicroMsg.JsApiConnectWifi", "jump2SysWifiSettingsIntent is unavailable");
    }
    Object localObject2 = (com.tencent.luggage.c.a.a)com.tencent.luggage.a.e.M(com.tencent.luggage.c.a.a.class);
    final k localk = ((com.tencent.luggage.c.a.a)localObject2).aE((Context)localObject1);
    MMHandlerThread.postToMainThread(new a.1(this, paramf, localk));
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a()
    {
      public final void H(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(215162);
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.a(null);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(144683);
            if (a.2.this.mHM != null) {
              a.2.this.mHO.a(a.2.this.mHM);
            }
            AppMethodBeat.o(144683);
          }
        });
        if (paramAnonymousString3.equals("ok"))
        {
          Object localObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.bLG();
          paramAnonymousString3 = (String)localObject;
          if (localObject == null)
          {
            Log.i("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback] currentWiFi is null, use WifiConfiguration");
            paramAnonymousString3 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.getConfiguredNetworks();
            if (paramAnonymousString3 == null) {
              break label192;
            }
            localObject = paramAnonymousString3.iterator();
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              paramAnonymousString3 = (WifiConfiguration)((Iterator)localObject).next();
            } while (!Objects.equals(paramAnonymousString3.BSSID, paramAnonymousString2));
          }
          for (;;)
          {
            if (paramAnonymousString3 == null) {
              Log.w("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback] curWifiConfig is null");
            }
            if (paramAnonymousString3 != null) {
              break;
            }
            paramAnonymousString3 = null;
            Log.i("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]currentWifi:%s", new Object[] { paramAnonymousString3 });
            if (paramAnonymousString3 != null) {
              break label267;
            }
            Log.e("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]currentWIfi is null");
            paramAnonymousString1 = new HashMap();
            paramAnonymousString2 = a.a(this.mHP, paramAnonymousString1, "fail:can't gain current wifi");
            paramf.i(paramInt, a.this.n(paramAnonymousString2, paramAnonymousString1));
            AppMethodBeat.o(215162);
            return;
            paramAnonymousString3 = null;
            continue;
            label192:
            paramAnonymousString3 = null;
          }
          localObject = new c();
          ((c)localObject).mHX = Util.nullAs(paramAnonymousString1, "");
          ((c)localObject).mHY = Util.nullAs(paramAnonymousString2, "");
          if (2 == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.d(paramAnonymousString3)) {}
          for (boolean bool = true;; bool = false)
          {
            ((c)localObject).mIa = bool;
            ((c)localObject).mHZ = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.abK(paramAnonymousString2);
            paramAnonymousString3 = (String)localObject;
            break;
          }
          try
          {
            label267:
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("wifi", paramAnonymousString3.toJSONObject());
            paramAnonymousString1.put("errCode", Integer.valueOf(0));
            paramf.i(paramInt, a.this.n("ok", paramAnonymousString1));
            AppMethodBeat.o(215162);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            Log.e("MicroMsg.JsApiConnectWifi", "IConnectWiFiCallback is error");
            Log.printErrStackTrace("MicroMsg.JsApiConnectWifi", paramAnonymousString1, "", new Object[0]);
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("errCode", Integer.valueOf(12010));
            paramf.i(paramInt, a.this.n("fail:parse json err", paramAnonymousString1));
            AppMethodBeat.o(215162);
            return;
          }
        }
        paramAnonymousString1 = new HashMap();
        if (paramAnonymousString3.equals("duplicated request")) {
          paramAnonymousString1.put("errCode", Integer.valueOf(12004));
        }
        for (;;)
        {
          Log.e("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]errCode:%d, errMsg:%s", new Object[] { paramAnonymousString1.get("errCode"), paramAnonymousString3 });
          paramf.i(paramInt, a.this.n("fail:".concat(String.valueOf(paramAnonymousString3)), paramAnonymousString1));
          AppMethodBeat.o(215162);
          return;
          if (paramAnonymousString3.equals("password error")) {
            paramAnonymousString1.put("errCode", Integer.valueOf(12002));
          } else if (paramAnonymousString3.equals("wifi config may be expired")) {
            paramAnonymousString1.put("errCode", Integer.valueOf(12013));
          } else if (paramAnonymousString3.equals("fail to connect wifi:time out")) {
            paramAnonymousString1.put("errCode", Integer.valueOf(12003));
          } else {
            paramAnonymousString3 = a.a(this.mHP, paramAnonymousString1, paramAnonymousString3);
          }
        }
      }
    });
    localObject1 = new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(144685);
        Log.d("MicroMsg.JsApiConnectWifi", "remove listener");
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.a(null);
        h.b(paramf.getAppId(), this);
        AppMethodBeat.o(144685);
      }
    };
    h.a(paramf.getAppId(), (h.c)localObject1);
    localObject1 = paramJSONObject.optString("SSID");
    localObject2 = paramJSONObject.optString("BSSID");
    paramJSONObject = paramJSONObject.optString("password");
    if (((String)localObject1).equals(""))
    {
      Log.e("MicroMsg.JsApiConnectWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12008));
      paramf.i(paramInt, n("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    Log.i("MicroMsg.JsApiConnectWifi", "ssid:%s, bSsid:%s is connecting", new Object[] { localObject1, localObject2 });
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.I((String)localObject1, (String)localObject2, paramJSONObject);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.a
 * JD-Core Version:    0.7.0.1
 */
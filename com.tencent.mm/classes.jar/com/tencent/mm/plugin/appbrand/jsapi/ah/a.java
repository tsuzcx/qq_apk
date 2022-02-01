package com.tencent.mm.plugin.appbrand.jsapi.ah;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
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
  extends c
{
  public static final int CTRL_INDEX = 316;
  public static final String NAME = "connectWifi";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144686);
    if (!d.pIH)
    {
      Log.e("MicroMsg.JsApiConnectWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      parame.j(paramInt, m("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("SSID")))
    {
      Log.e("MicroMsg.JsApiConnectWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      parame.j(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    Object localObject1 = parame.getContext();
    if (localObject1 == null)
    {
      Log.e("MicroMsg.JsApiConnectWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      parame.j(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    f.eb((Context)localObject1);
    if (!com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYf())
    {
      Log.e("MicroMsg.JsApiConnectWifi", "wifi is disable");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      parame.j(paramInt, m("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if (parame.getAppState() != com.tencent.mm.plugin.appbrand.a.b.nKP)
    {
      Log.e("MicroMsg.JsApiConnectWifi", "current state :%s isn't foreground", new Object[] { parame.getAppState() });
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12011));
      parame.j(paramInt, m("fail:weapp in background", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if (paramJSONObject.optBoolean("maunal", false))
    {
      localObject2 = new Intent("android.settings.WIFI_SETTINGS");
      if (Util.isIntentAvailable((Context)localObject1, (Intent)localObject2))
      {
        Log.i("MicroMsg.JsApiConnectWifi", "use manual");
        paramJSONObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramJSONObject.aFh(), "com/tencent/mm/plugin/appbrand/jsapi/wifi/JsApiConnectWifi", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)paramJSONObject.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/appbrand/jsapi/wifi/JsApiConnectWifi", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(0));
        parame.j(paramInt, m("ok", paramJSONObject));
        AppMethodBeat.o(144686);
        return;
      }
      Log.w("MicroMsg.JsApiConnectWifi", "jump2SysWifiSettingsIntent is unavailable");
    }
    Object localObject2 = (com.tencent.luggage.c.a.a)com.tencent.luggage.a.e.K(com.tencent.luggage.c.a.a.class);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144682);
        parame.getDialogContainer().a(this.pIz);
        AppMethodBeat.o(144682);
      }
    });
    f.a(new com.tencent.mm.plugin.appbrand.jsapi.ah.a.b()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(198314);
        f.a(null);
        MMHandlerThread.postToMainThread(new a.2.1(this));
        if (paramAnonymousString3.equals("ok"))
        {
          Object localObject = f.bXR();
          paramAnonymousString3 = (String)localObject;
          if (localObject == null)
          {
            Log.i("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback] currentWiFi is null, use WifiConfiguration");
            paramAnonymousString3 = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYa();
            if (paramAnonymousString3 == null) {
              break label194;
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
              break label269;
            }
            Log.e("MicroMsg.JsApiConnectWifi", "[IConnectWiFiCallback]currentWIfi is null");
            paramAnonymousString1 = new HashMap();
            paramAnonymousString2 = a.a(this.pIC, paramAnonymousString1, "fail:can't gain current wifi", paramAnonymousBoolean);
            parame.j(paramInt, a.this.m(paramAnonymousString2, paramAnonymousString1));
            AppMethodBeat.o(198314);
            return;
            paramAnonymousString3 = null;
            continue;
            label194:
            paramAnonymousString3 = null;
          }
          localObject = new com.tencent.mm.plugin.appbrand.jsapi.ah.a.d();
          ((com.tencent.mm.plugin.appbrand.jsapi.ah.a.d)localObject).pIL = Util.nullAs(paramAnonymousString1, "");
          ((com.tencent.mm.plugin.appbrand.jsapi.ah.a.d)localObject).pIM = Util.nullAs(paramAnonymousString2, "");
          if (2 == com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.e.e(paramAnonymousString3)) {}
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.appbrand.jsapi.ah.a.d)localObject).pIO = bool;
            ((com.tencent.mm.plugin.appbrand.jsapi.ah.a.d)localObject).pIN = com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.e.ajF(paramAnonymousString2);
            paramAnonymousString3 = (String)localObject;
            break;
          }
          try
          {
            label269:
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("wifi", paramAnonymousString3.toJSONObject());
            paramAnonymousString1.put("errCode", Integer.valueOf(0));
            parame.j(paramInt, a.this.m("ok", paramAnonymousString1));
            AppMethodBeat.o(198314);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            Log.e("MicroMsg.JsApiConnectWifi", "IConnectWiFiCallback is error");
            Log.printErrStackTrace("MicroMsg.JsApiConnectWifi", paramAnonymousString1, "", new Object[0]);
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("errCode", Integer.valueOf(12010));
            parame.j(paramInt, a.this.m("fail:parse json err", paramAnonymousString1));
            AppMethodBeat.o(198314);
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
          parame.j(paramInt, a.this.m("fail:".concat(String.valueOf(paramAnonymousString3)), paramAnonymousString1));
          AppMethodBeat.o(198314);
          return;
          if (paramAnonymousString3.equals("password error")) {
            paramAnonymousString1.put("errCode", Integer.valueOf(12002));
          } else if (paramAnonymousString3.equals("wifi config may be expired")) {
            paramAnonymousString1.put("errCode", Integer.valueOf(12013));
          } else if (paramAnonymousString3.equals("fail to connect wifi:time out")) {
            paramAnonymousString1.put("errCode", Integer.valueOf(12003));
          } else {
            paramAnonymousString3 = a.a(this.pIC, paramAnonymousString1, paramAnonymousString3, paramAnonymousBoolean);
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
        f.a(null);
        k.b(parame.getAppId(), this);
        AppMethodBeat.o(144685);
      }
    };
    k.a(parame.getAppId(), (k.c)localObject1);
    localObject1 = paramJSONObject.optString("SSID");
    localObject2 = paramJSONObject.optString("BSSID");
    String str = paramJSONObject.optString("password");
    long l = paramJSONObject.optLong("timeout", -1L);
    boolean bool = paramJSONObject.optBoolean("forceNewApi", false);
    if (((String)localObject1).equals(""))
    {
      Log.e("MicroMsg.JsApiConnectWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12008));
      parame.j(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    Log.i("MicroMsg.JsApiConnectWifi", "ssid:%s, bSsid:%s timeoutMs: %d, forceNewApi: %b is connecting", new Object[] { localObject1, localObject2, Long.valueOf(l), Boolean.valueOf(bool) });
    f.a((String)localObject1, (String)localObject2, str, l, bool);
    AppMethodBeat.o(144686);
  }
  
  public static final class a
    extends az
  {
    private static final int CTRL_INDEX = 322;
    private static final String NAME = "onWifiConnected";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.a
 * JD-Core Version:    0.7.0.1
 */
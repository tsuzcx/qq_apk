package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 316;
  public static final String NAME = "connectWifi";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144686);
    if (!d.lwi)
    {
      ad.e("MicroMsg.JsApiConenctWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.h(paramInt, m("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("SSID")))
    {
      ad.e("MicroMsg.JsApiConenctWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    Object localObject1 = paramc.getContext();
    if (localObject1 == null)
    {
      ad.e("MicroMsg.JsApiConenctWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.dC((Context)localObject1);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      ad.e("MicroMsg.JsApiConenctWifi", "wifi is disable");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.h(paramInt, m("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if (paramc.aVD() != b.jKO)
    {
      ad.e("MicroMsg.JsApiConenctWifi", "current state :%s isn't foreground", new Object[] { paramc.aVD() });
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12011));
      paramc.h(paramInt, m("fail:weapp in background", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    if (paramJSONObject.optBoolean("maunal", false))
    {
      localObject2 = new Intent("android.settings.WIFI_SETTINGS");
      if (bt.aj((Context)localObject1, (Intent)localObject2))
      {
        ad.i("MicroMsg.JsApiConenctWifi", "use manual");
        paramJSONObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramJSONObject.ahp(), "com/tencent/mm/plugin/appbrand/jsapi/wifi/JsApiConnectWifi", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)paramJSONObject.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/appbrand/jsapi/wifi/JsApiConnectWifi", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(0));
        paramc.h(paramInt, m("ok", paramJSONObject));
        AppMethodBeat.o(144686);
        return;
      }
      ad.w("MicroMsg.JsApiConenctWifi", "jump2SysWifiSettingsIntent is unavailable");
    }
    Object localObject2 = (com.tencent.luggage.c.a.a)com.tencent.luggage.a.e.K(com.tencent.luggage.c.a.a.class);
    final k localk = ((com.tencent.luggage.c.a.a)localObject2).au((Context)localObject1);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(144682);
        paramc.aVE().b(localk);
        AppMethodBeat.o(144682);
      }
    });
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a()
    {
      public final void F(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(195104);
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.a(null);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(144683);
            if (a.2.this.lwa != null) {
              a.2.this.lwc.a(a.2.this.lwa);
            }
            AppMethodBeat.o(144683);
          }
        });
        if (paramAnonymousString3.equals("ok"))
        {
          Object localObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.bpq();
          paramAnonymousString3 = (String)localObject;
          if (localObject == null)
          {
            ad.i("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback] currentWiFi is null, use WifiConfiguration");
            paramAnonymousString3 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.getConfiguredNetworks();
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
              ad.w("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback] curWifiConfig is null");
            }
            if (paramAnonymousString3 != null) {
              break;
            }
            paramAnonymousString3 = null;
            ad.i("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWifi:%s", new Object[] { paramAnonymousString3 });
            if (paramAnonymousString3 != null) {
              break label267;
            }
            ad.e("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWIfi is null");
            paramAnonymousString1 = new HashMap();
            paramAnonymousString2 = a.a(this.lwd, paramAnonymousString1, "fail:can't gain current wifi");
            paramc.h(paramInt, a.this.m(paramAnonymousString2, paramAnonymousString1));
            AppMethodBeat.o(195104);
            return;
            paramAnonymousString3 = null;
            continue;
            label192:
            paramAnonymousString3 = null;
          }
          localObject = new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c();
          ((com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c)localObject).lwl = bt.bI(paramAnonymousString1, "");
          ((com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c)localObject).lwm = bt.bI(paramAnonymousString2, "");
          if (2 == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.d(paramAnonymousString3)) {}
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c)localObject).lwo = bool;
            ((com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c)localObject).lwn = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Rw(paramAnonymousString2);
            paramAnonymousString3 = (String)localObject;
            break;
          }
          try
          {
            label267:
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("wifi", paramAnonymousString3.toJSONObject());
            paramAnonymousString1.put("errCode", Integer.valueOf(0));
            paramc.h(paramInt, a.this.m("ok", paramAnonymousString1));
            AppMethodBeat.o(195104);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            ad.e("MicroMsg.JsApiConenctWifi", "IConnectWiFiCallback is error");
            ad.printErrStackTrace("MicroMsg.JsApiConenctWifi", paramAnonymousString1, "", new Object[0]);
            paramAnonymousString1 = new HashMap();
            paramAnonymousString1.put("errCode", Integer.valueOf(12010));
            paramc.h(paramInt, a.this.m("fail:parse json err", paramAnonymousString1));
            AppMethodBeat.o(195104);
            return;
          }
        }
        paramAnonymousString1 = new HashMap();
        if (paramAnonymousString3.equals("duplicated request")) {
          paramAnonymousString1.put("errCode", Integer.valueOf(12004));
        }
        for (;;)
        {
          ad.e("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]errCode:%d, errMsg:%s", new Object[] { paramAnonymousString1.get("errCode"), paramAnonymousString3 });
          paramc.h(paramInt, a.this.m("fail:".concat(String.valueOf(paramAnonymousString3)), paramAnonymousString1));
          AppMethodBeat.o(195104);
          return;
          if (paramAnonymousString3.equals("password error")) {
            paramAnonymousString1.put("errCode", Integer.valueOf(12002));
          } else if (paramAnonymousString3.equals("wifi config may be expired")) {
            paramAnonymousString1.put("errCode", Integer.valueOf(12013));
          } else if (paramAnonymousString3.equals("fail to connect wifi:time out")) {
            paramAnonymousString1.put("errCode", Integer.valueOf(12003));
          } else {
            paramAnonymousString3 = a.a(this.lwd, paramAnonymousString1, paramAnonymousString3);
          }
        }
      }
    });
    localObject1 = new g.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(144685);
        ad.d("MicroMsg.JsApiConenctWifi", "remove listener");
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.a(null);
        g.b(paramc.getAppId(), this);
        AppMethodBeat.o(144685);
      }
    };
    g.a(paramc.getAppId(), (g.c)localObject1);
    localObject1 = paramJSONObject.optString("SSID");
    localObject2 = paramJSONObject.optString("BSSID");
    paramJSONObject = paramJSONObject.optString("password");
    if (((String)localObject1).equals(""))
    {
      ad.e("MicroMsg.JsApiConenctWifi", "params is invalid");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12008));
      paramc.h(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(144686);
      return;
    }
    ad.i("MicroMsg.JsApiConenctWifi", "ssid:%s, bSsid:%s is connecting", new Object[] { localObject1, localObject2 });
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.G((String)localObject1, (String)localObject2, paramJSONObject);
    AppMethodBeat.o(144686);
  }
  
  public static final class a
    extends at
  {
    private static final int CTRL_INDEX = 322;
    private static final String NAME = "onWifiConnected";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.a
 * JD-Core Version:    0.7.0.1
 */
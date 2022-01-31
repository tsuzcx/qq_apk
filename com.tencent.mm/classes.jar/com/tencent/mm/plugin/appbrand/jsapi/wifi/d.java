package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 314;
  public static final String NAME = "startWifi";
  public static boolean gGR = false;
  public static BroadcastReceiver gGS = null;
  
  public final void a(final c paramc, final JSONObject paramJSONObject, int paramInt)
  {
    y.i("MicroMsg.JsApiStartWifi", "invoke startWifi");
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.C(paramInt, h("fail:context is null", paramJSONObject));
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.cp(paramJSONObject);
    if (!gGR)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.setPriority(2147483647);
      gGS = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          if (paramAnonymousIntent == null) {}
          int i;
          label88:
          do
          {
            do
            {
              return;
              paramAnonymousContext = paramAnonymousIntent.getAction();
            } while (TextUtils.isEmpty(paramAnonymousContext));
            y.i("MicroMsg.JsApiStartWifi", "actiong:%s", new Object[] { paramAnonymousContext });
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramAnonymousContext))
            {
              i = paramAnonymousIntent.getIntExtra("wifi_state", 0);
              y.i("MicroMsg.JsApiStartWifi", "wifiState" + i);
            }
            switch (i)
            {
            default: 
              if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramAnonymousContext)) {
                break label184;
              }
              paramAnonymousContext = paramAnonymousIntent.getParcelableExtra("networkInfo");
            }
          } while (paramAnonymousContext == null);
          paramAnonymousContext = (NetworkInfo)paramAnonymousContext;
          label125:
          int j;
          if (paramAnonymousContext.getState() == NetworkInfo.State.CONNECTED)
          {
            i = 1;
            if (paramAnonymousContext.getType() != 1) {
              break label191;
            }
            j = 1;
          }
          for (;;)
          {
            if ((i != 0) && (j != 0))
            {
              paramAnonymousContext = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.alo();
              y.i("MicroMsg.JsApiStartWifi", "[mWiFiEventReceiver]currentWifi:%s", new Object[] { paramAnonymousContext });
              if (paramAnonymousContext == null)
              {
                y.e("MicroMsg.JsApiStartWifi", "[CONNECTIVITY_ACTION]currentWIfi is null");
                return;
                d.p(paramc);
                break label88;
                label184:
                break;
                i = 0;
                break label125;
                label191:
                j = 0;
                continue;
              }
              try
              {
                paramAnonymousIntent = new a.a();
                HashMap localHashMap = new HashMap();
                localHashMap.put("wifi", paramAnonymousContext.rB());
                paramAnonymousIntent.b(paramc, 0).p(localHashMap).dispatch();
                return;
              }
              catch (JSONException paramAnonymousContext)
              {
                y.e("MicroMsg.JsApiStartWifi", "IConnectWiFiCallback is error");
                y.printErrStackTrace("MicroMsg.JsApiStartWifi", paramAnonymousContext, "", new Object[0]);
                return;
              }
            }
          }
          d.p(paramc);
        }
      };
      paramJSONObject.registerReceiver(gGS, localIntentFilter);
      gGR = true;
    }
    paramJSONObject = new g.b()
    {
      public final void onDestroy()
      {
        if (d.gGS != null)
        {
          y.i("MicroMsg.JsApiStartWifi", "unregisterReceiver");
          paramJSONObject.unregisterReceiver(d.gGS);
          d.gGR = false;
          d.gGS = null;
        }
        g.b(paramc.getAppId(), this);
      }
    };
    g.a(paramc.getAppId(), paramJSONObject);
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(0));
    paramc.C(paramInt, h("ok", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.d
 * JD-Core Version:    0.7.0.1
 */
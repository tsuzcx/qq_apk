package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 314;
  public static final String NAME = "startWifi";
  public static boolean lAG = false;
  public static BroadcastReceiver lAH = null;
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144691);
    ae.i("MicroMsg.JsApiStartWifi", "invoke startWifi");
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, n("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144691);
      return;
    }
    e.dG(paramJSONObject);
    if (!lAG)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.setPriority(2147483647);
      lAH = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(144689);
          if (paramAnonymousIntent == null)
          {
            AppMethodBeat.o(144689);
            return;
          }
          paramAnonymousContext = paramAnonymousIntent.getAction();
          if (TextUtils.isEmpty(paramAnonymousContext))
          {
            AppMethodBeat.o(144689);
            return;
          }
          ae.i("MicroMsg.JsApiStartWifi", "actiong:%s", new Object[] { paramAnonymousContext });
          int i;
          if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramAnonymousContext))
          {
            i = paramAnonymousIntent.getIntExtra("wifi_state", 0);
            ae.i("MicroMsg.JsApiStartWifi", "wifiState".concat(String.valueOf(i)));
          }
          label137:
          int j;
          switch (i)
          {
          default: 
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramAnonymousContext)) {
              break label299;
            }
            paramAnonymousContext = paramAnonymousIntent.getParcelableExtra("networkInfo");
            if (paramAnonymousContext == null) {
              break label299;
            }
            paramAnonymousContext = (NetworkInfo)paramAnonymousContext;
            if (paramAnonymousContext.getState() == NetworkInfo.State.CONNECTED)
            {
              i = 1;
              if (paramAnonymousContext.getType() != 1) {
                break label208;
              }
              j = 1;
            }
            break;
          }
          for (;;)
          {
            if ((i != 0) && (j != 0))
            {
              paramAnonymousContext = e.bqa();
              ae.i("MicroMsg.JsApiStartWifi", "[mWiFiEventReceiver]currentWifi:%s", new Object[] { paramAnonymousContext });
              if (paramAnonymousContext == null)
              {
                ae.e("MicroMsg.JsApiStartWifi", "[CONNECTIVITY_ACTION]currentWIfi is null");
                AppMethodBeat.o(144689);
                return;
                d.E(paramc);
                break;
                i = 0;
                break label137;
                label208:
                j = 0;
                continue;
              }
              try
              {
                paramAnonymousIntent = new a.a();
                HashMap localHashMap = new HashMap();
                localHashMap.put("wifi", paramAnonymousContext.toJSONObject());
                paramAnonymousIntent.b(paramc, 0).I(localHashMap).bja();
                AppMethodBeat.o(144689);
                return;
              }
              catch (JSONException paramAnonymousContext)
              {
                ae.e("MicroMsg.JsApiStartWifi", "IConnectWiFiCallback is error");
                ae.printErrStackTrace("MicroMsg.JsApiStartWifi", paramAnonymousContext, "", new Object[0]);
                AppMethodBeat.o(144689);
                return;
              }
            }
          }
          d.E(paramc);
          label299:
          AppMethodBeat.o(144689);
        }
      };
      paramJSONObject.registerReceiver(lAH, localIntentFilter);
      lAG = true;
    }
    paramJSONObject = new d.2(this, paramJSONObject, paramc);
    h.a(paramc.getAppId(), paramJSONObject);
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(0));
    paramc.h(paramInt, n("ok", paramJSONObject));
    AppMethodBeat.o(144691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends a
{
  public static final int CTRL_INDEX = 314;
  public static final String NAME = "startWifi";
  public static BroadcastReceiver ihA = null;
  public static boolean ihz = false;
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(94376);
    ab.i("MicroMsg.JsApiStartWifi", "invoke startWifi");
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, j("fail:context is null", paramJSONObject));
      AppMethodBeat.o(94376);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.cR(paramJSONObject);
    if (!ihz)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.setPriority(2147483647);
      ihA = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(94374);
          if (paramAnonymousIntent == null)
          {
            AppMethodBeat.o(94374);
            return;
          }
          paramAnonymousContext = paramAnonymousIntent.getAction();
          if (TextUtils.isEmpty(paramAnonymousContext))
          {
            AppMethodBeat.o(94374);
            return;
          }
          ab.i("MicroMsg.JsApiStartWifi", "actiong:%s", new Object[] { paramAnonymousContext });
          int i;
          if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramAnonymousContext))
          {
            i = paramAnonymousIntent.getIntExtra("wifi_state", 0);
            ab.i("MicroMsg.JsApiStartWifi", "wifiState".concat(String.valueOf(i)));
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
              paramAnonymousContext = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.aGr();
              ab.i("MicroMsg.JsApiStartWifi", "[mWiFiEventReceiver]currentWifi:%s", new Object[] { paramAnonymousContext });
              if (paramAnonymousContext == null)
              {
                ab.e("MicroMsg.JsApiStartWifi", "[CONNECTIVITY_ACTION]currentWIfi is null");
                AppMethodBeat.o(94374);
                return;
                d.z(paramc);
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
                paramAnonymousIntent.b(paramc, 0).x(localHashMap).aBz();
                AppMethodBeat.o(94374);
                return;
              }
              catch (JSONException paramAnonymousContext)
              {
                ab.e("MicroMsg.JsApiStartWifi", "IConnectWiFiCallback is error");
                ab.printErrStackTrace("MicroMsg.JsApiStartWifi", paramAnonymousContext, "", new Object[0]);
                AppMethodBeat.o(94374);
                return;
              }
            }
          }
          d.z(paramc);
          label299:
          AppMethodBeat.o(94374);
        }
      };
      paramJSONObject.registerReceiver(ihA, localIntentFilter);
      ihz = true;
    }
    paramJSONObject = new d.2(this, paramJSONObject, paramc);
    e.a(paramc.getAppId(), paramJSONObject);
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(0));
    paramc.h(paramInt, j("ok", paramJSONObject));
    AppMethodBeat.o(94376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.d
 * JD-Core Version:    0.7.0.1
 */
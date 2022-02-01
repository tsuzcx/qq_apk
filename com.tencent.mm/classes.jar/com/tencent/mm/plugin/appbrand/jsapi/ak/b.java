package com.tencent.mm.plugin.appbrand.jsapi.ak;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ak.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.vendor.MIUI;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends c
{
  public static final int CTRL_INDEX = 318;
  public static final String NAME = "getConnectedWifi";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144687);
    if (!d.sNz)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramf.callback(paramInt, m("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    Context localContext = paramf.getContext();
    if (localContext == null)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.callback(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    g.eW(localContext);
    if (!com.tencent.mm.plugin.appbrand.jsapi.ak.a.a.d.cyv())
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramf.callback(paramInt, m("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.ak.a.b.sND;
    boolean bool2 = com.tencent.mm.plugin.appbrand.jsapi.ak.a.b.cye();
    boolean bool1 = bool2;
    if (paramJSONObject != null) {
      bool1 = paramJSONObject.optBoolean("acceptIncompleteWiFiInfo", bool2);
    }
    localObject = com.tencent.mm.plugin.appbrand.jsapi.ak.a.b.sND;
    localObject = com.tencent.mm.plugin.appbrand.jsapi.ak.a.b.jS(bool1);
    if (localObject == null)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (!MIUI.isMIUI()) && (!com.tencent.mm.modelgeo.d.bJm()))
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12006));
        paramf.callback(paramInt, m("fail:may be not open GPS", paramJSONObject));
        Log.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
        AppMethodBeat.o(144687);
        return;
      }
      bool1 = i.a((Activity)localContext, paramf, "android.permission.ACCESS_FINE_LOCATION", 64, null, null);
      Log.i("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", new Object[] { Boolean.valueOf(bool1) });
      if (!bool1)
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12012));
        paramf.callback(paramInt, m("fail:may be not obtain GPS Perrmission", paramJSONObject));
        Log.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
        AppMethodBeat.o(144687);
        return;
      }
      Log.e("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.callback(paramInt, m("fail:currentWifi is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    ConnectivityManager localConnectivityManager = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
    if (localConnectivityManager == null)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.callback(paramInt, m("fail:connectivityManager is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    if (paramJSONObject != null) {}
    for (bool1 = paramJSONObject.optBoolean("checkNetInfo");; bool1 = false)
    {
      Log.i("MicroMsg.JsApiGetConnectedWifi", "checkNetInfo: ".concat(String.valueOf(bool1)));
      if ((bool1) || (localContext.getApplicationInfo().targetSdkVersion < 29) || (Build.VERSION.SDK_INT < 29))
      {
        paramJSONObject = localConnectivityManager.getActiveNetworkInfo();
        if (paramJSONObject == null)
        {
          Log.e("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
          paramJSONObject = new HashMap();
          paramJSONObject.put("errCode", Integer.valueOf(12010));
          paramf.callback(paramInt, m("fail:netInfo is null", paramJSONObject));
          AppMethodBeat.o(144687);
          return;
        }
        if (paramJSONObject.getDetailedState() != NetworkInfo.DetailedState.CONNECTED)
        {
          Log.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", new Object[] { paramJSONObject.getDetailedState() });
          paramJSONObject = new HashMap();
          paramJSONObject.put("errCode", Integer.valueOf(12010));
          paramf.callback(paramInt, m("fail:detailState is not connected", paramJSONObject));
          AppMethodBeat.o(144687);
          return;
        }
      }
      Log.i("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", new Object[] { localObject });
      try
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("wifi", ((e)localObject).aZh());
        paramJSONObject.put("errCode", Integer.valueOf(0));
        paramf.callback(paramInt, m("ok", paramJSONObject));
        AppMethodBeat.o(144687);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.JsApiGetConnectedWifi", paramJSONObject, "", new Object[0]);
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12010));
        paramf.callback(paramInt, m("fail:parse json err", paramJSONObject));
        AppMethodBeat.o(144687);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.b
 * JD-Core Version:    0.7.0.1
 */
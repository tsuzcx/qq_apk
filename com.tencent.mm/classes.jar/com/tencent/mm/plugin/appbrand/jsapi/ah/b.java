package com.tencent.mm.plugin.appbrand.jsapi.ah;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import com.tencent.luggage.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
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
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144687);
    if (!d.pIH)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      parame.j(paramInt, m("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    Context localContext = parame.getContext();
    if (localContext == null)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      parame.j(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    f.eb(localContext);
    if (!com.tencent.mm.plugin.appbrand.jsapi.ah.a.a.d.bYf())
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      parame.j(paramInt, m("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.ah.a.d locald = f.bXR();
    if (locald == null)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (!MIUI.isMIUI()) && (!((LocationManager)localContext.getSystemService("location")).isProviderEnabled("gps")))
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12006));
        parame.j(paramInt, m("fail:may be not open GPS", paramJSONObject));
        Log.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
        AppMethodBeat.o(144687);
        return;
      }
      bool = i.a((Activity)localContext, "android.permission.ACCESS_FINE_LOCATION", 64, null, null);
      Log.i("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12012));
        parame.j(paramInt, m("fail:may be not obtain GPS Perrmission", paramJSONObject));
        Log.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
        AppMethodBeat.o(144687);
        return;
      }
      Log.e("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      parame.j(paramInt, m("fail:currentWifi is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    ConnectivityManager localConnectivityManager = (ConnectivityManager)localContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      parame.j(paramInt, m("fail:connectivityManager is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    if (paramJSONObject != null) {}
    for (boolean bool = paramJSONObject.optBoolean("checkNetInfo");; bool = false)
    {
      Log.i("MicroMsg.JsApiGetConnectedWifi", "checkNetInfo: ".concat(String.valueOf(bool)));
      if ((bool) || (localContext.getApplicationInfo().targetSdkVersion < 29) || (Build.VERSION.SDK_INT < 29))
      {
        paramJSONObject = localConnectivityManager.getActiveNetworkInfo();
        if (paramJSONObject == null)
        {
          Log.e("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
          paramJSONObject = new HashMap();
          paramJSONObject.put("errCode", Integer.valueOf(12010));
          parame.j(paramInt, m("fail:netInfo is null", paramJSONObject));
          AppMethodBeat.o(144687);
          return;
        }
        if (paramJSONObject.getDetailedState() != NetworkInfo.DetailedState.CONNECTED)
        {
          Log.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", new Object[] { paramJSONObject.getDetailedState() });
          paramJSONObject = new HashMap();
          paramJSONObject.put("errCode", Integer.valueOf(12010));
          parame.j(paramInt, m("fail:detailState is not connected", paramJSONObject));
          AppMethodBeat.o(144687);
          return;
        }
      }
      Log.i("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", new Object[] { locald });
      try
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("wifi", locald.toJSONObject());
        paramJSONObject.put("errCode", Integer.valueOf(0));
        parame.j(paramInt, m("ok", paramJSONObject));
        AppMethodBeat.o(144687);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.JsApiGetConnectedWifi", paramJSONObject, "", new Object[0]);
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12010));
        parame.j(paramInt, m("fail:parse json err", paramJSONObject));
        AppMethodBeat.o(144687);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.b
 * JD-Core Version:    0.7.0.1
 */
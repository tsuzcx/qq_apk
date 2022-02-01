package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.vendor.MIUI;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 318;
  public static final String NAME = "getConnectedWifi";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144687);
    if (!d.mHU)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramf.i(paramInt, n("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    Object localObject = paramf.getContext();
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.i(paramInt, n("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    e.eb((Context)localObject);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.isWifiEnabled())
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramf.i(paramInt, n("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    paramJSONObject = e.bLG();
    if (paramJSONObject == null)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (!MIUI.isMIUI()) && (!((LocationManager)((Context)localObject).getSystemService("location")).isProviderEnabled("gps")))
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12006));
        paramf.i(paramInt, n("fail:may be not open GPS", paramJSONObject));
        Log.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
        AppMethodBeat.o(144687);
        return;
      }
      boolean bool = i.a((Activity)localObject, "android.permission.ACCESS_FINE_LOCATION", 64, null, null);
      Log.i("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12012));
        paramf.i(paramInt, n("fail:may be not obtain GPS Perrmission", paramJSONObject));
        Log.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
        AppMethodBeat.o(144687);
        return;
      }
      Log.e("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.i(paramInt, n("fail:currentWifi is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.i(paramInt, n("fail:connectivityManager is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.i(paramInt, n("fail:netInfo is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    if (((NetworkInfo)localObject).getDetailedState() != NetworkInfo.DetailedState.CONNECTED)
    {
      Log.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", new Object[] { ((NetworkInfo)localObject).getDetailedState() });
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.i(paramInt, n("fail:detailState is not connected", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    Log.i("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", new Object[] { paramJSONObject });
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("wifi", paramJSONObject.toJSONObject());
      ((HashMap)localObject).put("errCode", Integer.valueOf(0));
      paramf.i(paramInt, n("ok", (Map)localObject));
      AppMethodBeat.o(144687);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.JsApiGetConnectedWifi", paramJSONObject, "", new Object[0]);
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramf.i(paramInt, n("fail:parse json err", paramJSONObject));
      AppMethodBeat.o(144687);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.b
 * JD-Core Version:    0.7.0.1
 */
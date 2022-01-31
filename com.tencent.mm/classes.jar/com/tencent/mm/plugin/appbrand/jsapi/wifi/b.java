package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import com.tencent.luggage.j.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends a
{
  public static final int CTRL_INDEX = 318;
  public static final String NAME = "getConnectedWifi";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!d.gGR)
    {
      y.e("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.C(paramInt, h("fail:not invoke startWifi", paramJSONObject));
      return;
    }
    Object localObject = paramc.getContext();
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.C(paramInt, h("fail:context is null", paramJSONObject));
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.cp((Context)localObject);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      y.e("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.C(paramInt, h("fail:wifi is disable", paramJSONObject));
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.alo();
    if (paramJSONObject == null)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.sdk.g.b.zK()) && (!((LocationManager)((Context)localObject).getSystemService("location")).isProviderEnabled("gps")))
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12006));
        paramc.C(paramInt, h("fail:may be not open GPS", paramJSONObject));
        y.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
        return;
      }
      boolean bool = f.a((Activity)localObject, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      y.i("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12012));
        paramc.C(paramInt, h("fail:may be not obtain GPS Perrmission", paramJSONObject));
        y.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
        return;
      }
      y.e("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.C(paramInt, h("fail:currentWifi is null", paramJSONObject));
      return;
    }
    localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.C(paramInt, h("fail:connectivityManager is null", paramJSONObject));
      return;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.C(paramInt, h("fail:netInfo is null", paramJSONObject));
      return;
    }
    if (((NetworkInfo)localObject).getDetailedState() != NetworkInfo.DetailedState.CONNECTED)
    {
      y.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", new Object[] { ((NetworkInfo)localObject).getDetailedState() });
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.C(paramInt, h("fail:detailState is not connected", paramJSONObject));
      return;
    }
    y.i("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", new Object[] { paramJSONObject });
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("wifi", paramJSONObject.rB());
      ((HashMap)localObject).put("errCode", Integer.valueOf(0));
      paramc.C(paramInt, h("ok", (Map)localObject));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      y.printErrStackTrace("MicroMsg.JsApiGetConnectedWifi", paramJSONObject, "", new Object[0]);
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.C(paramInt, h("fail:parse json err", paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import com.tencent.luggage.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e;
import com.tencent.mm.sdk.platformtools.ad;
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
    AppMethodBeat.i(144687);
    if (!d.lwi)
    {
      ad.e("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.h(paramInt, m("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    Object localObject = paramc.getContext();
    if (localObject == null)
    {
      ad.e("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, m("fail:context is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    e.dC((Context)localObject);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      ad.e("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.h(paramInt, m("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    paramJSONObject = e.bpq();
    if (paramJSONObject == null)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.sdk.h.b.abk()) && (!((LocationManager)((Context)localObject).getSystemService("location")).isProviderEnabled("gps")))
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12006));
        paramc.h(paramInt, m("fail:may be not open GPS", paramJSONObject));
        ad.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
        AppMethodBeat.o(144687);
        return;
      }
      boolean bool = h.a((Activity)localObject, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      ad.i("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12012));
        paramc.h(paramInt, m("fail:may be not obtain GPS Perrmission", paramJSONObject));
        ad.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
        AppMethodBeat.o(144687);
        return;
      }
      ad.e("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, m("fail:currentWifi is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
    if (localObject == null)
    {
      ad.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, m("fail:connectivityManager is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      ad.e("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, m("fail:netInfo is null", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    if (((NetworkInfo)localObject).getDetailedState() != NetworkInfo.DetailedState.CONNECTED)
    {
      ad.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", new Object[] { ((NetworkInfo)localObject).getDetailedState() });
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, m("fail:detailState is not connected", paramJSONObject));
      AppMethodBeat.o(144687);
      return;
    }
    ad.i("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", new Object[] { paramJSONObject });
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("wifi", paramJSONObject.toJSONObject());
      ((HashMap)localObject).put("errCode", Integer.valueOf(0));
      paramc.h(paramInt, m("ok", (Map)localObject));
      AppMethodBeat.o(144687);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ad.printErrStackTrace("MicroMsg.JsApiGetConnectedWifi", paramJSONObject, "", new Object[0]);
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, m("fail:parse json err", paramJSONObject));
      AppMethodBeat.o(144687);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.luggage.j.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 317;
  public static final String NAME = "getWifiList";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!d.gGR)
    {
      y.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.C(paramInt, h("fail:not invoke startWifi", paramJSONObject));
      return;
    }
    Object localObject = paramc.getContext();
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.C(paramInt, h("fail:context is null", paramJSONObject));
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.cp((Context)localObject);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      y.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.C(paramInt, h("fail:wifi is disable", paramJSONObject));
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.alp();
    if (paramJSONObject.gio.equals("ok"))
    {
      try
      {
        y.i("MicroMsg.JsApiGetWifiList", "onGetWifiList size:%d", new Object[] { Integer.valueOf(paramJSONObject.gHb.size()) });
        if (paramJSONObject.gHb.size() != 0) {
          break label432;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!b.zK()) && (!((LocationManager)((Context)localObject).getSystemService("location")).isProviderEnabled("gps")))
        {
          paramJSONObject = new HashMap();
          paramJSONObject.put("errCode", Integer.valueOf(12006));
          paramc.C(paramInt, h("fail:may be not open GPS", paramJSONObject));
          y.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not open GPS");
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        y.printErrStackTrace("MicroMsg.JsApiGetWifiList", paramJSONObject, "", new Object[0]);
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12010));
        paramc.C(paramInt, h("fail:parse json err", paramJSONObject));
        return;
      }
      boolean bool = f.a((Activity)localObject, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      y.i("MicroMsg.JsApiGetWifiList", "checkLocation:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12012));
        paramc.C(paramInt, h("fail:may be not obtain GPS Perrmission", paramJSONObject));
        y.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not obtain GPS Perrmission");
        return;
      }
      label432:
      localObject = new HashMap();
      ((Map)localObject).put("errCode", Integer.valueOf(0));
      paramc.C(paramInt, h("ok", (Map)localObject));
      y.d("MicroMsg.JsApiGetWifiList", "onGetWifiList %s", new Object[] { paramJSONObject });
      localObject = new c.a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("wifiList", paramJSONObject.aln());
      ((c.a)localObject).b(paramc, 0).p(localHashMap).dispatch();
      return;
    }
    y.e("MicroMsg.JsApiGetWifiList", "error, mErrorMsg:%s", new Object[] { paramJSONObject.gio });
    localObject = new HashMap();
    ((Map)localObject).put("errCode", Integer.valueOf(12010));
    paramc.C(paramInt, h("fail:" + paramJSONObject.gio, (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.c
 * JD-Core Version:    0.7.0.1
 */
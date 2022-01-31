package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.luggage.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(94373);
    if (!d.ihz)
    {
      ab.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.h(paramInt, j("fail:not invoke startWifi", paramJSONObject));
      AppMethodBeat.o(94373);
      return;
    }
    Object localObject = paramc.getContext();
    if (localObject == null)
    {
      ab.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.h(paramInt, j("fail:context is null", paramJSONObject));
      AppMethodBeat.o(94373);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.cR((Context)localObject);
    if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled())
    {
      ab.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.h(paramInt, j("fail:wifi is disable", paramJSONObject));
      AppMethodBeat.o(94373);
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.aGs();
    if (paramJSONObject.hBF.equals("ok")) {
      try
      {
        ab.i("MicroMsg.JsApiGetWifiList", "onGetWifiList size:%d", new Object[] { Integer.valueOf(paramJSONObject.ihJ.size()) });
        if (paramJSONObject.ihJ.size() == 0)
        {
          if ((Build.VERSION.SDK_INT >= 23) && (!((LocationManager)((Context)localObject).getSystemService("location")).isProviderEnabled("gps")))
          {
            paramJSONObject = new HashMap();
            paramJSONObject.put("errCode", Integer.valueOf(12006));
            paramc.h(paramInt, j("fail:may be not open GPS", paramJSONObject));
            ab.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not open GPS");
            AppMethodBeat.o(94373);
            return;
          }
          boolean bool = g.a((Activity)localObject, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
          ab.i("MicroMsg.JsApiGetWifiList", "checkLocation:%b", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            paramJSONObject = new HashMap();
            paramJSONObject.put("errCode", Integer.valueOf(12012));
            paramc.h(paramInt, j("fail:may be not obtain GPS Perrmission", paramJSONObject));
            ab.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not obtain GPS Perrmission");
            AppMethodBeat.o(94373);
            return;
          }
        }
        localObject = new HashMap();
        ((Map)localObject).put("errCode", Integer.valueOf(0));
        paramc.h(paramInt, j("ok", (Map)localObject));
        ab.d("MicroMsg.JsApiGetWifiList", "onGetWifiList %s", new Object[] { paramJSONObject });
        localObject = new c.a();
        HashMap localHashMap = new HashMap();
        localHashMap.put("wifiList", paramJSONObject.aGq());
        ((c.a)localObject).b(paramc, 0).x(localHashMap).aBz();
        AppMethodBeat.o(94373);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        ab.printErrStackTrace("MicroMsg.JsApiGetWifiList", paramJSONObject, "", new Object[0]);
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12010));
        paramc.h(paramInt, j("fail:parse json err", paramJSONObject));
        AppMethodBeat.o(94373);
        return;
      }
    }
    ab.e("MicroMsg.JsApiGetWifiList", "error, mErrorMsg:%s", new Object[] { paramJSONObject.hBF });
    localObject = new HashMap();
    ((Map)localObject).put("errCode", Integer.valueOf(12010));
    paramc.h(paramInt, j("fail:" + paramJSONObject.hBF, (Map)localObject));
    AppMethodBeat.o(94373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.c
 * JD-Core Version:    0.7.0.1
 */
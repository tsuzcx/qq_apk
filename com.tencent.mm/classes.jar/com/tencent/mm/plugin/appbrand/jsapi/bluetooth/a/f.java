package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 182;
  private static final String NAME = "getBLEDeviceServices";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144499);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(136);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(138, 139);
      AppMethodBeat.o(144499);
      return;
    }
    ad.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.Pt(paramc.getAppId());
    if (localObject == null)
    {
      ad.e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, m("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(138, 141);
      AppMethodBeat.o(144499);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bjz())
    {
      ad.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, m("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(138, 145);
      AppMethodBeat.o(144499);
      return;
    }
    localObject = ((b)localObject).Pv(paramJSONObject.optString("deviceId"));
    paramJSONObject = new HashMap();
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      ad.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
      paramJSONObject.put("errCode", Integer.valueOf(10004));
      paramc.h(paramInt, m("fail:no service", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dN(138, 144);
      AppMethodBeat.o(144499);
      return;
    }
    paramJSONObject = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      e locale = (e)((Iterator)localObject).next();
      if (bt.isNullOrNil(locale.uuid)) {
        ad.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
      } else {
        try
        {
          if (locale.jsonObject == null)
          {
            locale.jsonObject = new JSONObject();
            locale.jsonObject.put("uuid", locale.uuid);
            locale.jsonObject.put("isPrimary", locale.kFz);
          }
          paramJSONObject.put(locale.jsonObject);
        }
        catch (JSONException localJSONException)
        {
          ad.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("errMsg", getName() + ":ok");
      ((JSONObject)localObject).put("services", paramJSONObject);
      ((JSONObject)localObject).put("errCode", 0);
      ad.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[] { ((JSONObject)localObject).toString() });
      paramc.h(paramInt, ((JSONObject)localObject).toString());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.ma(137);
      AppMethodBeat.o(144499);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.f
 * JD-Core Version:    0.7.0.1
 */
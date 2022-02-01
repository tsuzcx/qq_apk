package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
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
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lI(136);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(138, 139);
      AppMethodBeat.o(144499);
      return;
    }
    ad.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.HS(paramc.getAppId());
    if (localObject == null)
    {
      ad.e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, k("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(138, 141);
      AppMethodBeat.o(144499);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.aZd())
    {
      ad.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, k("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(138, 145);
      AppMethodBeat.o(144499);
      return;
    }
    paramJSONObject = paramJSONObject.optString("deviceId");
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject).aYI();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).jJb;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).jJk != null) {
        break label340;
      }
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorkers is null", new Object[0]);
    }
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.getServices())
    {
      localObject = new HashMap();
      if ((paramJSONObject != null) && (paramJSONObject.size() > 0)) {
        break label381;
      }
      ad.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
      ((Map)localObject).put("errCode", Integer.valueOf(10004));
      paramc.h(paramInt, k("fail:no service", (Map)localObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(138, 144);
      AppMethodBeat.o(144499);
      return;
      label340:
      paramJSONObject = (d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).jJk.get(paramJSONObject);
      if (paramJSONObject == null)
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorker is null", new Object[0]);
        break;
      }
    }
    label381:
    localObject = new JSONArray();
    paramJSONObject = paramJSONObject.iterator();
    while (paramJSONObject.hasNext())
    {
      e locale = (e)paramJSONObject.next();
      if (bt.isNullOrNil(locale.uuid)) {
        ad.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
      } else {
        try
        {
          if (locale.jsonObject == null)
          {
            locale.jsonObject = new JSONObject();
            locale.jsonObject.put("uuid", locale.uuid);
            locale.jsonObject.put("isPrimary", locale.bnd);
          }
          ((JSONArray)localObject).put(locale.jsonObject);
        }
        catch (JSONException localJSONException2)
        {
          ad.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", new Object[] { localJSONException2.getMessage() });
        }
      }
    }
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("errMsg", getName() + ":ok");
      paramJSONObject.put("services", localObject);
      paramJSONObject.put("errCode", 0);
      ad.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[] { paramJSONObject.toString() });
      paramc.h(paramInt, paramJSONObject.toString());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lI(137);
      AppMethodBeat.o(144499);
      return;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", localJSONException1, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  private static final int CTRL_INDEX = 182;
  private static final String NAME = "getBLEDeviceServices";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144499);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(136);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(138, 139);
      AppMethodBeat.o(144499);
      return;
    }
    Log.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", new Object[] { paramf.getAppId(), paramJSONObject.toString() });
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC(paramf.getAppId());
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.i(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(138, 141);
      AppMethodBeat.o(144499);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(138, 145);
      AppMethodBeat.o(144499);
      return;
    }
    paramJSONObject = paramJSONObject.optString("deviceId");
    localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject).bFg();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject).lMr;
      if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).lMA != null) {
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
      Log.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
      ((Map)localObject).put("errCode", Integer.valueOf(10004));
      paramf.i(paramInt, n("fail:no service", (Map)localObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(138, 144);
      AppMethodBeat.o(144499);
      return;
      label340:
      paramJSONObject = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d)((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c)localObject).lMA.get(paramJSONObject);
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
      if (Util.isNullOrNil(locale.uuid)) {
        Log.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
      } else {
        try
        {
          if (locale.jsonObject == null)
          {
            locale.jsonObject = new JSONObject();
            locale.jsonObject.put("uuid", locale.uuid);
            locale.jsonObject.put("isPrimary", locale.lNt);
          }
          ((JSONArray)localObject).put(locale.jsonObject);
        }
        catch (JSONException localJSONException2)
        {
          Log.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", new Object[] { localJSONException2.getMessage() });
        }
      }
    }
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("errMsg", getName() + ":ok");
      paramJSONObject.put("services", localObject);
      paramJSONObject.put("errCode", 0);
      Log.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[] { paramJSONObject.toString() });
      paramf.i(paramInt, paramJSONObject.toString());
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(137);
      AppMethodBeat.o(144499);
      return;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", localJSONException1, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.f
 * JD-Core Version:    0.7.0.1
 */
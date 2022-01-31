package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 182;
  private static final String NAME = "getBLEDeviceServices";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(94187);
    c.kS(136);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      c.df(138, 139);
      AppMethodBeat.o(94187);
      return;
    }
    ab.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    Object localObject = a.BU(paramc.getAppId());
    if (localObject == null)
    {
      ab.e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, j("fail:not init", paramJSONObject));
      c.df(138, 141);
      AppMethodBeat.o(94187);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aCw())
    {
      ab.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, j("fail:not available", paramJSONObject));
      c.df(138, 145);
      AppMethodBeat.o(94187);
      return;
    }
    localObject = ((b)localObject).BW(paramJSONObject.optString("deviceId"));
    paramJSONObject = new HashMap();
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      ab.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
      paramJSONObject.put("errCode", Integer.valueOf(10004));
      paramc.h(paramInt, j("fail:no service", paramJSONObject));
      c.df(138, 144);
      AppMethodBeat.o(94187);
      return;
    }
    paramJSONObject = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      e locale = (e)((Iterator)localObject).next();
      if (bo.isNullOrNil(locale.eAx)) {
        ab.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
      } else {
        try
        {
          if (locale.jsonObject == null)
          {
            locale.jsonObject = new JSONObject();
            locale.jsonObject.put("uuid", locale.eAx);
            locale.jsonObject.put("isPrimary", locale.hGM);
          }
          paramJSONObject.put(locale.jsonObject);
        }
        catch (JSONException localJSONException)
        {
          ab.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("errMsg", getName() + ":ok");
      ((JSONObject)localObject).put("services", paramJSONObject);
      ((JSONObject)localObject).put("errCode", 0);
      ab.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[] { ((JSONObject)localObject).toString() });
      paramc.h(paramInt, ((JSONObject)localObject).toString());
      c.kS(137);
      AppMethodBeat.o(94187);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h
 * JD-Core Version:    0.7.0.1
 */
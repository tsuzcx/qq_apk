package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    c.jdMethod_if(136);
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
      paramc.C(paramInt, h("fail:invalid data", null));
      c.bU(138, 139);
      return;
    }
    y.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    Object localObject = a.tV(paramc.getAppId());
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.C(paramInt, h("fail:not init", paramJSONObject));
      c.bU(138, 141);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB())
    {
      y.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.C(paramInt, h("fail:not available", paramJSONObject));
      c.bU(138, 145);
      return;
    }
    localObject = ((b)localObject).tX(paramJSONObject.optString("deviceId"));
    paramJSONObject = new HashMap();
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      y.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
      paramJSONObject.put("errCode", Integer.valueOf(10004));
      paramc.C(paramInt, h("fail:no service", paramJSONObject));
      c.bU(138, 144);
      return;
    }
    paramJSONObject = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      e locale = (e)((Iterator)localObject).next();
      if (bk.bl(locale.dCX)) {
        y.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
      } else {
        try
        {
          if (locale.gmI == null)
          {
            locale.gmI = new JSONObject();
            locale.gmI.put("uuid", locale.dCX);
            locale.gmI.put("isPrimary", locale.gmN);
          }
          paramJSONObject.put(locale.gmI);
        }
        catch (JSONException localJSONException)
        {
          y.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", new Object[] { localJSONException.getMessage() });
        }
      }
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("errMsg", getName() + ":ok");
      ((JSONObject)localObject).put("services", paramJSONObject);
      ((JSONObject)localObject).put("errCode", 0);
      y.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", new Object[] { ((JSONObject)localObject).toString() });
      paramc.C(paramInt, ((JSONObject)localObject).toString());
      c.jdMethod_if(137);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", paramJSONObject, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h
 * JD-Core Version:    0.7.0.1
 */
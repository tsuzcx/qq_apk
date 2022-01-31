package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 183;
  private static final String NAME = "getBLEDeviceCharacteristics";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    c.jdMethod_if(151);
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.C(paramInt, h("fail:invalid data", paramJSONObject));
      c.bU(153, 154);
      return;
    }
    y.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "appId:%s getBLEDeviceCharacteristics data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    Object localObject = a.tV(paramc.getAppId());
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.C(paramInt, h("fail:not init", paramJSONObject));
      c.bU(153, 156);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.aiB())
    {
      y.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.C(paramInt, h("fail:not available", paramJSONObject));
      c.bU(153, 158);
      return;
    }
    localObject = ((b)localObject).bx(paramJSONObject.optString("deviceId"), paramJSONObject.optString("serviceId"));
    paramJSONObject = new HashMap();
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      y.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found characteristic");
      paramJSONObject.put("errCode", Integer.valueOf(10005));
      paramc.C(paramInt, h("fail:no characteristic", paramJSONObject));
      c.bU(153, 159);
      return;
    }
    paramJSONObject = new JSONArray();
    localObject = ((List)localObject).iterator();
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c localc;
    if (((Iterator)localObject).hasNext()) {
      localc = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c)((Iterator)localObject).next();
    }
    for (;;)
    {
      try
      {
        if (localc.gmI == null)
        {
          localc.gmI = new JSONObject();
          localc.gmI.put("uuid", localc.dCX);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("read", localc.gmE);
          if (localc.gmF) {
            break label628;
          }
          if (!localc.gmG) {
            break label511;
          }
          break label628;
          localJSONObject.put("write", bool);
          localJSONObject.put("notify", localc.dVu);
          localJSONObject.put("indicate", localc.gmH);
          localc.gmI.put("properties", localJSONObject);
        }
        paramJSONObject.put(localc.gmI);
      }
      catch (JSONException localJSONException)
      {
        y.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "JSONException %s", new Object[] { localJSONException.getMessage() });
      }
      break;
      label511:
      boolean bool = false;
      continue;
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("errMsg", getName() + ":ok");
        ((JSONObject)localObject).put("characteristics", paramJSONObject);
        ((JSONObject)localObject).put("errCode", 0);
        y.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", new Object[] { ((JSONObject)localObject).toString() });
        paramc.C(paramInt, ((JSONObject)localObject).toString());
        c.jdMethod_if(152);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceCharacteristics", paramJSONObject, "", new Object[0]);
        }
      }
      label628:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.g
 * JD-Core Version:    0.7.0.1
 */
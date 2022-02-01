package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 183;
  private static final String NAME = "getBLEDeviceCharacteristics";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144498);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(151);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramc.h(paramInt, k("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(153, 154);
      AppMethodBeat.o(144498);
      return;
    }
    ac.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "appId:%s getBLEDeviceCharacteristics data %s", new Object[] { paramc.getAppId(), paramJSONObject.toString() });
    Object localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.LX(paramc.getAppId());
    if (localObject == null)
    {
      ac.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.h(paramInt, k("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(153, 156);
      AppMethodBeat.o(144498);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bfV())
    {
      ac.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.h(paramInt, k("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(153, 158);
      AppMethodBeat.o(144498);
      return;
    }
    localObject = ((b)localObject).cT(paramJSONObject.optString("deviceId"), paramJSONObject.optString("serviceId"));
    paramJSONObject = new HashMap();
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      ac.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found characteristic");
      paramJSONObject.put("errCode", Integer.valueOf(10005));
      paramc.h(paramInt, k("fail:no characteristic", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(153, 159);
      AppMethodBeat.o(144498);
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
        if (localc.jsonObject == null)
        {
          localc.jsonObject = new JSONObject();
          localc.jsonObject.put("uuid", localc.uuid);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("read", localc.kkr);
          if (localc.kks) {
            break label658;
          }
          if (!localc.kkt) {
            break label536;
          }
          break label658;
          localJSONObject.put("write", bool);
          localJSONObject.put("notify", localc.hnr);
          localJSONObject.put("indicate", localc.kku);
          localc.jsonObject.put("properties", localJSONObject);
        }
        paramJSONObject.put(localc.jsonObject);
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "JSONException %s", new Object[] { localJSONException.getMessage() });
      }
      break;
      label536:
      boolean bool = false;
      continue;
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("errMsg", getName() + ":ok");
        ((JSONObject)localObject).put("characteristics", paramJSONObject);
        ((JSONObject)localObject).put("errCode", 0);
        ac.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", new Object[] { ((JSONObject)localObject).toString() });
        paramc.h(paramInt, ((JSONObject)localObject).toString());
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(152);
        AppMethodBeat.o(144498);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceCharacteristics", paramJSONObject, "", new Object[0]);
        }
      }
      label658:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.d
 * JD-Core Version:    0.7.0.1
 */
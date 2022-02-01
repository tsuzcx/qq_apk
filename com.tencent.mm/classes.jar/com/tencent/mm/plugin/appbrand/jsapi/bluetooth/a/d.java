package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  private static final int CTRL_INDEX = 183;
  private static final String NAME = "getBLEDeviceCharacteristics";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144498);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(151);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.i(paramInt, n("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(153, 154);
      AppMethodBeat.o(144498);
      return;
    }
    Log.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "appId:%s getBLEDeviceCharacteristics data %s", new Object[] { paramf.getAppId(), paramJSONObject.toString() });
    Object localObject = a.ZC(paramf.getAppId());
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.i(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(153, 156);
      AppMethodBeat.o(144498);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(153, 158);
      AppMethodBeat.o(144498);
      return;
    }
    localObject = ((b)localObject).dn(paramJSONObject.optString("deviceId"), paramJSONObject.optString("serviceId"));
    paramJSONObject = new HashMap();
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found characteristic");
      paramJSONObject.put("errCode", Integer.valueOf(10005));
      paramf.i(paramInt, n("fail:no characteristic", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(153, 159);
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
          localJSONObject.put("read", localc.lNl);
          if (localc.lNm) {
            break label658;
          }
          if (!localc.lNn) {
            break label536;
          }
          break label658;
          localJSONObject.put("write", bool);
          localJSONObject.put("notify", localc.iDl);
          localJSONObject.put("indicate", localc.lNo);
          localc.jsonObject.put("properties", localJSONObject);
        }
        paramJSONObject.put(localc.jsonObject);
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "JSONException %s", new Object[] { localJSONException.getMessage() });
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
        Log.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", new Object[] { ((JSONObject)localObject).toString() });
        paramf.i(paramInt, ((JSONObject)localObject).toString());
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(152);
        AppMethodBeat.o(144498);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceCharacteristics", paramJSONObject, "", new Object[0]);
        }
      }
      label658:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.d
 * JD-Core Version:    0.7.0.1
 */
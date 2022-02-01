package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  private static final int CTRL_INDEX = 183;
  private static final String NAME = "getBLEDeviceCharacteristics";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144498);
    h.rG(151);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.callback(paramInt, a("fail:invalid data", a.e.rVz, paramJSONObject));
      h.fr(153, 154);
      AppMethodBeat.o(144498);
      return;
    }
    Log.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "appId:%s getBLEDeviceCharacteristics data %s", new Object[] { paramf.getAppId(), paramJSONObject.toString() });
    Object localObject = a.aan(paramf.getAppId());
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.callback(paramInt, a(a.c.rUE, paramJSONObject));
      h.fr(153, 156);
      AppMethodBeat.o(144498);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.cru())
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.callback(paramInt, a("fail:not available", a.c.rUF, paramJSONObject));
      h.fr(153, 158);
      AppMethodBeat.o(144498);
      return;
    }
    localObject = ((b)localObject).dP(paramJSONObject.optString("deviceId"), paramJSONObject.optString("serviceId"));
    paramJSONObject = new HashMap();
    if ((localObject == null) || (((List)localObject).size() <= 0))
    {
      Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found characteristic");
      paramJSONObject.put("errCode", Integer.valueOf(10005));
      paramf.callback(paramInt, a("fail:no characteristic", a.c.rVh, paramJSONObject));
      h.fr(153, 159);
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
        if (localc.rNs == null)
        {
          localc.rNs = new JSONObject();
          localc.rNs.put("uuid", localc.uuid);
          localc.rNs.put("handle", localc.rNr);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("read", localc.rNn);
          if (localc.rNo) {
            break label685;
          }
          if (!localc.rNp) {
            break label588;
          }
          break label685;
          localJSONObject.put("write", bool);
          localJSONObject.put("notify", localc.okL);
          localJSONObject.put("indicate", localc.rNq);
          localJSONObject.put("writeNoResponse", localc.rNp);
          localJSONObject.put("writeDefault", localc.rNo);
          localc.rNs.put("properties", localJSONObject);
        }
        paramJSONObject.put(localc.rNs);
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "JSONException %s", new Object[] { localJSONException.getMessage() });
      }
      break;
      label588:
      boolean bool = false;
      continue;
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("characteristics", paramJSONObject);
        ((JSONObject)localObject).put("errCode", 0);
        Log.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", new Object[] { ((JSONObject)localObject).toString() });
        paramf.callback(paramInt, a(null, a.e.rVt, (JSONObject)localObject));
        h.rG(152);
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
      label685:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.d
 * JD-Core Version:    0.7.0.1
 */
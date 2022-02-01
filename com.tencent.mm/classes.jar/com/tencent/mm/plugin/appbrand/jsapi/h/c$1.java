package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1
  implements a.a.a
{
  c.b oUc;
  c.a oUd;
  
  c$1(c paramc, e parame)
  {
    AppMethodBeat.i(144675);
    this.oUc = new c.b((byte)0);
    this.oUd = new c.a((byte)0);
    AppMethodBeat.o(144675);
  }
  
  public final void H(Map<String, JSONObject> paramMap)
  {
    AppMethodBeat.i(144676);
    Log.d("MicroMsg.JsApiStartBeaconDiscovery", "found device ibeacon %s", new Object[] { paramMap });
    JSONArray localJSONArray = new JSONArray();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      JSONObject localJSONObject = (JSONObject)paramMap.next();
      if (localJSONObject != null) {
        localJSONArray.put(localJSONObject);
      }
    }
    paramMap = new JSONObject();
    try
    {
      paramMap.put("beacons", localJSONArray);
      this.oUc.b(this.owM, this.owM.getComponentId()).agU(paramMap.toString()).bPO();
      AppMethodBeat.o(144676);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
  
  public final void jdMethod_if(boolean paramBoolean)
  {
    AppMethodBeat.i(144677);
    Log.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("available", paramBoolean);
      localJSONObject.put("discovering", false);
      Log.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
      this.oUd.b(this.owM, this.owM.getComponentId()).agU(localJSONObject.toString()).bPO();
      AppMethodBeat.o(144677);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.c.1
 * JD-Core Version:    0.7.0.1
 */
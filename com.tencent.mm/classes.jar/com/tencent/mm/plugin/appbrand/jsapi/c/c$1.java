package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1
  implements a.a.a
{
  c.b hMv;
  c.a hMw;
  
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1)
  {
    AppMethodBeat.i(94360);
    this.hMv = new c.b((byte)0);
    this.hMw = new c.a((byte)0);
    AppMethodBeat.o(94360);
  }
  
  public final void A(Map<String, JSONObject> paramMap)
  {
    AppMethodBeat.i(94361);
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
      this.hMv.b(this.hza, this.hza.aAN()).BN(paramMap.toString()).aBz();
      AppMethodBeat.o(94361);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
  
  public final void ed(boolean paramBoolean)
  {
    AppMethodBeat.i(94362);
    ab.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("available", paramBoolean);
      localJSONObject.put("discovering", false);
      ab.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
      this.hMw.b(this.hza, this.hza.aAN()).BN(localJSONObject.toString()).aBz();
      AppMethodBeat.o(94362);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.c.1
 * JD-Core Version:    0.7.0.1
 */
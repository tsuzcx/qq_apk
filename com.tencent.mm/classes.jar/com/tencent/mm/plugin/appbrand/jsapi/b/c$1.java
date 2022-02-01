package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1
  implements a.a.a
{
  c.b ksr;
  c.a kss;
  
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1)
  {
    AppMethodBeat.i(144675);
    this.ksr = new c.b((byte)0);
    this.kss = new c.a((byte)0);
    AppMethodBeat.o(144675);
  }
  
  public final void E(Map<String, JSONObject> paramMap)
  {
    AppMethodBeat.i(144676);
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
      this.ksr.b(this.jZx, this.jZx.aUT()).LO(paramMap.toString()).beN();
      AppMethodBeat.o(144676);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
  
  public final void gm(boolean paramBoolean)
  {
    AppMethodBeat.i(144677);
    ac.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("available", paramBoolean);
      localJSONObject.put("discovering", false);
      ac.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
      this.kss.b(this.jZx, this.jZx.aUT()).LO(localJSONObject.toString()).beN();
      AppMethodBeat.o(144677);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.c.1
 * JD-Core Version:    0.7.0.1
 */
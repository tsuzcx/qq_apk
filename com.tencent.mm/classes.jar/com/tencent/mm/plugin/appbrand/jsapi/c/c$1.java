package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1
  implements a.a.a
{
  c.b jRF;
  c.a jRG;
  
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1)
  {
    AppMethodBeat.i(144675);
    this.jRF = new c.b((byte)0);
    this.jRG = new c.a((byte)0);
    AppMethodBeat.o(144675);
  }
  
  public final void F(Map<String, JSONObject> paramMap)
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
      this.jRF.b(this.jza, this.jza.aOd()).HK(paramMap.toString()).aXQ();
      AppMethodBeat.o(144676);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
  
  public final void fQ(boolean paramBoolean)
  {
    AppMethodBeat.i(144677);
    ad.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("available", paramBoolean);
      localJSONObject.put("discovering", false);
      ad.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
      this.jRG.b(this.jza, this.jza.aOd()).HK(localJSONObject.toString()).aXQ();
      AppMethodBeat.o(144677);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.c.1
 * JD-Core Version:    0.7.0.1
 */
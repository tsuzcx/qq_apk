package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1
  implements a.a.a
{
  c.b grg = new c.b((byte)0);
  c.a grh = new c.a((byte)0);
  
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1) {}
  
  public final void cZ(boolean paramBoolean)
  {
    y.i("MicroMsg.JsApiStartBeaconDiscovery", "onBluetoothStateChange:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("available", paramBoolean);
      localJSONObject.put("discovering", false);
      y.d("MicroMsg.JsApiStartBeaconDiscovery", "OnBeaconServiceChangedEvent %s", new Object[] { localJSONObject.toString() });
      this.grh.b(this.ggE, this.ggE.ahJ()).tM(localJSONObject.toString()).dispatch();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiStartBeaconDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
  
  public final void u(Map<String, JSONObject> paramMap)
  {
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
      this.grg.b(this.ggE, this.ggE.ahJ()).tM(paramMap.toString()).dispatch();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiStartBeaconDiscovery", "put res JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.c.1
 * JD-Core Version:    0.7.0.1
 */
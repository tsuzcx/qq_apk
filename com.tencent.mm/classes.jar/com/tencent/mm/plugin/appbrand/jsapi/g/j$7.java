package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.r;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class j$7
  implements b.r
{
  j$7(j paramj, int paramInt, e parame) {}
  
  public final void a(b.n paramn)
  {
    j.d locald = new j.d((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.gkY);
      localJSONObject.put("latitude", paramn.latitude);
      localJSONObject.put("longitude", paramn.longitude);
      localJSONObject.put("name", paramn.name);
      locald.tM(localJSONObject.toString());
      this.gtq.b(locald);
      return;
    }
    catch (JSONException paramn)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramn });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.j.7
 * JD-Core Version:    0.7.0.1
 */
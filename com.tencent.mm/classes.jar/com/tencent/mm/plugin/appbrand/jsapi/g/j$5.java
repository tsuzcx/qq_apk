package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.o;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class j$5
  implements b.l
{
  j$5(j paramj, int paramInt, e parame) {}
  
  public final boolean b(b.o paramo)
  {
    j.c localc = new j.c((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.gkY);
      localJSONObject.put("data", paramo.data);
      localc.tM(localJSONObject.toString());
      this.gtq.b(localc);
      return false;
    }
    catch (JSONException paramo)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramo });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.j.5
 * JD-Core Version:    0.7.0.1
 */
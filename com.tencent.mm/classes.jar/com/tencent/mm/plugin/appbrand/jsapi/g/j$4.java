package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.o;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class j$4
  implements b.i
{
  j$4(j paramj, int paramInt, e parame) {}
  
  public final void a(b.o paramo)
  {
    j.a locala = new j.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.gkY);
      localJSONObject.put("data", paramo.data);
      locala.tM(localJSONObject.toString());
      this.gtq.b(locala);
      return;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.j.4
 * JD-Core Version:    0.7.0.1
 */
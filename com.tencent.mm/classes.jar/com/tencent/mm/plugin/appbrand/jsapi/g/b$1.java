package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.k;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class b$1
  implements b.k
{
  b$1(b paramb, int paramInt, e parame) {}
  
  public final void uf(String paramString)
  {
    b.a locala = new b.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.gkY);
      localJSONObject.put("data", paramString);
      locala.tM(localJSONObject.toString());
      this.gsr.b(locala);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiAddMapControls", "put JSON data error : %s", new Object[] { paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.b.1
 * JD-Core Version:    0.7.0.1
 */
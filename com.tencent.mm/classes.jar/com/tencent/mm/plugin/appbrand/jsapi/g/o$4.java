package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.q;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class o$4
  implements b.k
{
  o$4(o paramo, int paramInt, e parame) {}
  
  public final void a(b.q paramq)
  {
    AppMethodBeat.i(93855);
    o.a locala = new o.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.hEO);
      localJSONObject.put("data", paramq.data);
      locala.BN(localJSONObject.toString());
      this.hNZ.b(locala);
      AppMethodBeat.o(93855);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { paramq });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.o.4
 * JD-Core Version:    0.7.0.1
 */
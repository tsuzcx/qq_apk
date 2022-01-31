package com.tencent.mm.plugin.appbrand.jsapi.v.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.o.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$1
  implements b.k
{
  public b$1(b paramb, int paramInt, c paramc) {}
  
  public final void a(b.q paramq)
  {
    AppMethodBeat.i(155142);
    o.a locala = new o.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.hNS);
      localJSONObject.put("data", paramq.data);
      locala.BN(localJSONObject.toString());
      this.hza.b(locala);
      AppMethodBeat.o(155142);
      return;
    }
    catch (JSONException paramq)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { paramq });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b.1
 * JD-Core Version:    0.7.0.1
 */
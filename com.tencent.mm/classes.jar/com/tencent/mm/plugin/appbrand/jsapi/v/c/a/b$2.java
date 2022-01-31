package com.tencent.mm.plugin.appbrand.jsapi.v.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.o.d;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$2
  implements b.n
{
  public b$2(b paramb, int paramInt, c paramc) {}
  
  public final boolean b(b.q paramq)
  {
    AppMethodBeat.i(155143);
    o.d locald = new o.d();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.hNS);
      localJSONObject.put("data", paramq.data);
      locald.BN(localJSONObject.toString());
      this.hza.b(locald);
      AppMethodBeat.o(155143);
      return false;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b.2
 * JD-Core Version:    0.7.0.1
 */
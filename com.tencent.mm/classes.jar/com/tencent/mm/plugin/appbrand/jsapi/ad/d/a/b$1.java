package com.tencent.mm.plugin.appbrand.jsapi.ad.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.i.t.b;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$1
  implements b.l
{
  public b$1(b paramb, int paramInt, c paramc) {}
  
  public final void a(b.u paramu)
  {
    AppMethodBeat.i(139543);
    t.b localb = new t.b();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.kSZ);
      localJSONObject.put("data", paramu.data);
      localb.PQ(localJSONObject.toString());
      this.kxj.b(localb);
      AppMethodBeat.o(139543);
      return;
    }
    catch (JSONException paramu)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { paramu });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.d.a.b.1
 * JD-Core Version:    0.7.0.1
 */
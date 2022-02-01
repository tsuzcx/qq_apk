package com.tencent.mm.plugin.appbrand.jsapi.ad.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.i.t.f;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$2
  implements b.p
{
  public b$2(b paramb, int paramInt, c paramc) {}
  
  public final boolean b(b.u paramu)
  {
    AppMethodBeat.i(139544);
    t.f localf = new t.f();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.kSZ);
      localJSONObject.put("data", paramu.data);
      localf.PQ(localJSONObject.toString());
      this.kxj.b(localf);
      AppMethodBeat.o(139544);
      return true;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.d.a.b.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.ad.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.i.t.e;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$4
  implements b.o
{
  public b$4(b paramb, int paramInt, c paramc) {}
  
  public final boolean c(b.u paramu)
  {
    AppMethodBeat.i(139546);
    t.e locale = new t.e();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.kSZ);
      localJSONObject.put("data", paramu.data);
      locale.PQ(localJSONObject.toString());
      this.kxj.b(locale);
      AppMethodBeat.o(139546);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.d.a.b.4
 * JD-Core Version:    0.7.0.1
 */
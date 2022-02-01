package com.tencent.mm.plugin.appbrand.jsapi.aa.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.g.q.b;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$1
  implements b.k
{
  public b$1(b paramb, int paramInt, c paramc) {}
  
  public final void a(b.s params)
  {
    AppMethodBeat.i(139543);
    q.b localb = new q.b();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.jTj);
      localJSONObject.put("data", params.data);
      localb.HK(localJSONObject.toString());
      this.jza.b(localb);
      AppMethodBeat.o(139543);
      return;
    }
    catch (JSONException params)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { params });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d.a.b.1
 * JD-Core Version:    0.7.0.1
 */
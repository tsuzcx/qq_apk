package com.tencent.mm.plugin.appbrand.jsapi.aa.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.g.q.f;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$2
  implements b.o
{
  public b$2(b paramb, int paramInt, c paramc) {}
  
  public final boolean b(b.s params)
  {
    AppMethodBeat.i(139544);
    q.f localf = new q.f();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.jTj);
      localJSONObject.put("data", params.data);
      localf.HK(localJSONObject.toString());
      this.jza.b(localf);
      AppMethodBeat.o(139544);
      return true;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d.a.b.2
 * JD-Core Version:    0.7.0.1
 */
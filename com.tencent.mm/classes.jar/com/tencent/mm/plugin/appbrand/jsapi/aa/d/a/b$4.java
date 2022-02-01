package com.tencent.mm.plugin.appbrand.jsapi.aa.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.g.q.e;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$4
  implements b.n
{
  public b$4(b paramb, int paramInt, c paramc) {}
  
  public final boolean c(b.s params)
  {
    AppMethodBeat.i(139546);
    q.e locale = new q.e();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.jTj);
      localJSONObject.put("data", params.data);
      locale.HK(localJSONObject.toString());
      this.jza.b(locale);
      AppMethodBeat.o(139546);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d.a.b.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.aa.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.g.q.c;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$3
  implements b.l
{
  public b$3(b paramb, int paramInt, c paramc) {}
  
  public final void e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(139545);
    q.c localc = new q.c();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.jTj);
      localJSONObject.put("longitude", paramDouble1);
      localJSONObject.put("latitude", paramDouble2);
      localc.HK(localJSONObject.toString());
      this.jza.b(localc);
      AppMethodBeat.o(139545);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d.a.b.3
 * JD-Core Version:    0.7.0.1
 */
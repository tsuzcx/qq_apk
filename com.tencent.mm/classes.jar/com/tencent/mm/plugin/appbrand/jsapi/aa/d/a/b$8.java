package com.tencent.mm.plugin.appbrand.jsapi.aa.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.q.a;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$8
  implements b.q
{
  public b$8(b paramb, int paramInt, c paramc) {}
  
  public final void d(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(195105);
    q.a locala = new q.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.jTj);
      localJSONObject.put("longitude", paramDouble2);
      localJSONObject.put("latitude", paramDouble1);
      locala.HK(localJSONObject.toString());
      this.jza.b(locala);
      ad.v("MicroMsg.JsApiInsertXWebMap", "MapOnMapAnchorPointClick:%s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(195105);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.d.a.b.8
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.ad.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.i.t.a;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$8
  implements b.s
{
  public b$8(b paramb, int paramInt, c paramc) {}
  
  public final void d(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(220634);
    t.a locala = new t.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.kSZ);
      localJSONObject.put("longitude", paramDouble2);
      localJSONObject.put("latitude", paramDouble1);
      locala.PQ(localJSONObject.toString());
      this.kxj.b(locala);
      ae.v("MicroMsg.JsApiInsertXWebMap", "MapOnMapAnchorPointClick:%s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(220634);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.d.a.b.8
 * JD-Core Version:    0.7.0.1
 */
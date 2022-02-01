package com.tencent.mm.plugin.appbrand.jsapi.ad.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.i.t.c;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$3
  implements b.m
{
  public b$3(b paramb, int paramInt, c paramc) {}
  
  public final void e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(139545);
    t.c localc = new t.c();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.kSZ);
      localJSONObject.put("longitude", paramDouble1);
      localJSONObject.put("latitude", paramDouble2);
      localc.PQ(localJSONObject.toString());
      this.kxj.b(localc);
      AppMethodBeat.o(139545);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.d.a.b.3
 * JD-Core Version:    0.7.0.1
 */
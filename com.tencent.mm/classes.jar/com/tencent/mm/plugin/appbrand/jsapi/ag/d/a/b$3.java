package com.tencent.mm.plugin.appbrand.jsapi.ag.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.k.t.c;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$3
  implements b.m
{
  public b$3(b paramb, int paramInt, f paramf) {}
  
  public final void e(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(139545);
    t.c localc = new t.c();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.lYe);
      localJSONObject.put("longitude", paramDouble1);
      localJSONObject.put("latitude", paramDouble2);
      localc.Zh(localJSONObject.toString());
      this.lBw.a(localc, null);
      AppMethodBeat.o(139545);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.3
 * JD-Core Version:    0.7.0.1
 */
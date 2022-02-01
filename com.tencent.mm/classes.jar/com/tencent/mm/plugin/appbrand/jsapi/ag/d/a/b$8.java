package com.tencent.mm.plugin.appbrand.jsapi.ag.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.s;
import com.tencent.mm.plugin.appbrand.jsapi.k.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$8
  implements b.s
{
  public b$8(b paramb, int paramInt, f paramf) {}
  
  public final void d(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(215883);
    t.a locala = new t.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.lYe);
      localJSONObject.put("longitude", paramDouble2);
      localJSONObject.put("latitude", paramDouble1);
      locala.Zh(localJSONObject.toString());
      this.lBw.a(locala, null);
      Log.v("MicroMsg.JsApiInsertXWebMap", "MapOnMapAnchorPointClick:%s", new Object[] { localJSONObject.toString() });
      AppMethodBeat.o(215883);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.8
 * JD-Core Version:    0.7.0.1
 */
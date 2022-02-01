package com.tencent.mm.plugin.appbrand.jsapi.ag.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.k.t.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$1
  implements b.l
{
  public b$1(b paramb, int paramInt, f paramf) {}
  
  public final void a(b.u paramu)
  {
    AppMethodBeat.i(139543);
    t.b localb = new t.b();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.lYe);
      localJSONObject.put("data", paramu.data);
      localb.Zh(localJSONObject.toString());
      this.lBw.a(localb, null);
      AppMethodBeat.o(139543);
      return;
    }
    catch (JSONException paramu)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", new Object[] { paramu });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.1
 * JD-Core Version:    0.7.0.1
 */
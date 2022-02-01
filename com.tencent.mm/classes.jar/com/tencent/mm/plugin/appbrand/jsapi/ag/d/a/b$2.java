package com.tencent.mm.plugin.appbrand.jsapi.ag.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.k.t.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$2
  implements b.p
{
  public b$2(b paramb, int paramInt, f paramf) {}
  
  public final boolean b(b.u paramu)
  {
    AppMethodBeat.i(139544);
    t.f localf = new t.f();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.lYe);
      localJSONObject.put("data", paramu.data);
      localf.Zh(localJSONObject.toString());
      this.lBw.a(localf, null);
      AppMethodBeat.o(139544);
      return true;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.2
 * JD-Core Version:    0.7.0.1
 */
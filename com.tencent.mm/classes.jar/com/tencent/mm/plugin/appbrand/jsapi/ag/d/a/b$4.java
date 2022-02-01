package com.tencent.mm.plugin.appbrand.jsapi.ag.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.u;
import com.tencent.mm.plugin.appbrand.jsapi.k.t.e;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$4
  implements b.o
{
  public b$4(b paramb, int paramInt, f paramf) {}
  
  public final boolean c(b.u paramu)
  {
    AppMethodBeat.i(139546);
    t.e locale = new t.e();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.lYe);
      localJSONObject.put("data", paramu.data);
      locale.Zh(localJSONObject.toString());
      this.lBw.a(locale, null);
      AppMethodBeat.o(139546);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.4
 * JD-Core Version:    0.7.0.1
 */
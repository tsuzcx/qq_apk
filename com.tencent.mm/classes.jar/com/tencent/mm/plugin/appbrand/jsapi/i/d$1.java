package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.b.n;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

final class d$1
  implements b.n
{
  d$1(d paramd, int paramInt, c paramc) {}
  
  public final void PH(String paramString)
  {
    AppMethodBeat.i(143658);
    d.a locala = new d.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.kPr);
      localJSONObject.put("data", paramString);
      locala.Pi(localJSONObject.toString());
      this.kwd.b(locala);
      AppMethodBeat.o(143658);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiAddMapControls", "put JSON data error : %s", new Object[] { paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.d.1
 * JD-Core Version:    0.7.0.1
 */
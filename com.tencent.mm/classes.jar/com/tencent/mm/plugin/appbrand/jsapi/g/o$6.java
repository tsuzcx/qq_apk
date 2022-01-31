package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.l;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

final class o$6
  implements b.l
{
  o$6(o paramo, int paramInt, e parame) {}
  
  public final void aDm()
  {
    AppMethodBeat.i(93857);
    o.b localb = new o.b();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.hEO);
      localb.BN(localJSONObject.toString());
      this.hNZ.b(localb);
      AppMethodBeat.o(93857);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.o.6
 * JD-Core Version:    0.7.0.1
 */
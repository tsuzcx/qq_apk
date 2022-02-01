package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b.n;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

final class d$1
  implements b.n
{
  d$1(d paramd, int paramInt, f paramf) {}
  
  public final void ZQ(String paramString)
  {
    AppMethodBeat.i(143658);
    d.a locala = new d.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.lYe);
      localJSONObject.put("data", paramString);
      locala.Zh(localJSONObject.toString());
      this.lDL.a(locala, null);
      AppMethodBeat.o(143658);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiAddMapControls", "put JSON data error : %s", new Object[] { paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.d.1
 * JD-Core Version:    0.7.0.1
 */
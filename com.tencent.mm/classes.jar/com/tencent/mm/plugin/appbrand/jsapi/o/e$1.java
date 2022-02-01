package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b.n;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

final class e$1
  implements b.n
{
  e$1(e parame, int paramInt, f paramf) {}
  
  public final void aaD(String paramString)
  {
    AppMethodBeat.i(143658);
    e.a locala = new e.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mapId", this.sbv);
      localJSONObject.put("data", paramString);
      locala.ZR(localJSONObject.toString());
      this.rDf.a(locala, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.e.1
 * JD-Core Version:    0.7.0.1
 */
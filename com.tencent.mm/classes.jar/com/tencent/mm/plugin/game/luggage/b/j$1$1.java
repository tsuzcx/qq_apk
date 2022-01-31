package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.wepkg.model.g.a;
import org.json.JSONException;
import org.json.JSONObject;

final class j$1$1
  implements g.a
{
  j$1$1(j.1 param1) {}
  
  public final void ac(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(135873);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wepkg_info", paramJSONObject);
      label21:
      this.njL.lax.c(null, localJSONObject);
      AppMethodBeat.o(135873);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.j.1.1
 * JD-Core Version:    0.7.0.1
 */
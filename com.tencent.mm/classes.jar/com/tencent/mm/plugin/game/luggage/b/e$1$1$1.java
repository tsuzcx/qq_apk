package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.ui.base.p;
import org.json.JSONException;
import org.json.JSONObject;

final class e$1$1$1
  implements Runnable
{
  e$1$1$1(e.1.1 param1, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(154140);
    if (e.a(this.njJ.njH.njE) != null) {
      e.a(this.njJ.njH.njE).dismiss();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", 1);
      localJSONObject.put("localIds", this.njI);
      label64:
      this.njJ.njH.lax.c(null, localJSONObject);
      AppMethodBeat.o(154140);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.e.1.1.1
 * JD-Core Version:    0.7.0.1
 */
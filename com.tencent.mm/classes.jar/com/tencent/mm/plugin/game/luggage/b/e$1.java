package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.plugin.wepkg.model.e.a;
import org.json.JSONException;
import org.json.JSONObject;

final class e$1
  implements Runnable
{
  e$1(e parame, aw.a parama) {}
  
  public final void run()
  {
    com.tencent.mm.plugin.wepkg.model.e.a(new e.a()
    {
      public final void R(JSONObject paramAnonymousJSONObject)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("wepkg_info", paramAnonymousJSONObject);
          label16:
          e.1.this.iRN.e(null, localJSONObject);
          return;
        }
        catch (JSONException paramAnonymousJSONObject)
        {
          break label16;
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.e.1
 * JD-Core Version:    0.7.0.1
 */
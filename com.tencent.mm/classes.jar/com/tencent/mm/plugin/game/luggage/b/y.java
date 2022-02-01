package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public class y
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(83085);
    ae.i("MicroMsg.JsApiPublishHaowanEdition", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (paramContext == null)
    {
      parama.f("invalid_data", null);
      AppMethodBeat.o(83085);
      return;
    }
    paramString = paramContext.optString("postId");
    boolean bool = paramContext.optBoolean("compressImg", true);
    if (!bu.isNullOrNil(paramString)) {
      paramContext = ((d)com.tencent.mm.kernel.g.ab(d.class)).ami(paramString);
    }
    for (;;)
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("postId", paramContext);
        label88:
        parama.f(null, paramString);
        AppMethodBeat.o(83085);
        return;
        paramString = paramContext.optJSONArray("localIds");
        int i = paramContext.optInt("from");
        int j = paramContext.optInt("postType");
        paramContext = paramContext.optString("extra");
        paramContext = ((d)com.tencent.mm.kernel.g.ab(d.class)).a(i, j, paramString, paramContext, bool);
      }
      catch (JSONException paramContext)
      {
        break label88;
      }
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ced()
  {
    return 1;
  }
  
  public final String name()
  {
    return "publishHaowanEdition";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.y
 * JD-Core Version:    0.7.0.1
 */
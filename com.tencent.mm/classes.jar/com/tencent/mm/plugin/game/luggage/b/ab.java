package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class ab
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(83085);
    Log.i("MicroMsg.JsApiPublishHaowanEdition", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramContext == null)
    {
      parama.i("invalid_data", null);
      AppMethodBeat.o(83085);
      return;
    }
    paramString = paramContext.optString("postId");
    boolean bool = paramContext.optBoolean("compressImg", true);
    if (!Util.isNullOrNil(paramString)) {
      paramContext = ((d)g.af(d.class)).azm(paramString);
    }
    for (;;)
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("postId", paramContext);
        label88:
        parama.i(null, paramString);
        AppMethodBeat.o(83085);
        return;
        paramString = paramContext.optJSONArray("localIds");
        int i = paramContext.optInt("from");
        int j = paramContext.optInt("postType");
        String str = paramContext.optString("extra");
        int k = paramContext.optInt("sourceSceneId");
        paramContext = ((d)g.af(d.class)).a(i, j, paramString, str, bool, k);
      }
      catch (JSONException paramContext)
      {
        break label88;
      }
    }
  }
  
  public final void b(com.tencent.luggage.d.b<i>.a paramb) {}
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "publishHaowanEdition";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ab
 * JD-Core Version:    0.7.0.1
 */
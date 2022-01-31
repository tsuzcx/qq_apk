package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends bi<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(154152);
    ab.i("MicroMsg.JsApiPublishHaowanEdition", "invokeInMM");
    paramContext = b.BJ(paramString);
    if (paramContext == null)
    {
      parama.c("invalid_data", null);
      AppMethodBeat.o(154152);
      return;
    }
    paramString = paramContext.optString("postId");
    boolean bool = paramContext.optBoolean("compressImg", true);
    if (!bo.isNullOrNil(paramString)) {
      paramContext = ((c)g.E(c.class)).PM(paramString);
    }
    for (;;)
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("postId", paramContext);
        label88:
        parama.c(null, paramString);
        AppMethodBeat.o(154152);
        return;
        paramString = paramContext.optJSONArray("localIds");
        int i = paramContext.optInt("from");
        int j = paramContext.optInt("postType");
        paramContext = paramContext.optString("extra");
        paramContext = ((c)g.E(c.class)).a(i, j, paramString, paramContext, bool);
      }
      catch (JSONException paramContext)
      {
        break label88;
      }
    }
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "publishHaowanEdition";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.s
 * JD-Core Version:    0.7.0.1
 */
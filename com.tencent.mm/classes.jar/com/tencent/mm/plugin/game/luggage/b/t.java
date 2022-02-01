package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class t
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(83085);
    ad.i("MicroMsg.JsApiPublishHaowanEdition", "invokeInMM");
    paramContext = b.HG(paramString);
    if (paramContext == null)
    {
      parama.f("invalid_data", null);
      AppMethodBeat.o(83085);
      return;
    }
    paramString = paramContext.optString("postId");
    boolean bool = paramContext.optBoolean("compressImg", true);
    if (!bt.isNullOrNil(paramString)) {
      paramContext = ((c)g.ab(c.class)).abV(paramString);
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
        paramContext = ((c)g.ab(c.class)).a(i, j, paramString, paramContext, bool);
      }
      catch (JSONException paramContext)
      {
        break label88;
      }
    }
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bQV()
  {
    return 1;
  }
  
  public final String name()
  {
    return "publishHaowanEdition";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.t
 * JD-Core Version:    0.7.0.1
 */
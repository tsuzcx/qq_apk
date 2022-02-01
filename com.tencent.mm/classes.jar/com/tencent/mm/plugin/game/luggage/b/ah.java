package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class ah
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(83085);
    Log.i("MicroMsg.JsApiPublishHaowanEdition", "invokeInMM");
    paramContext = c.ZL(paramString);
    if (paramContext == null)
    {
      parama.j("invalid_data", null);
      AppMethodBeat.o(83085);
      return;
    }
    paramString = paramContext.optString("postId");
    boolean bool = paramContext.optBoolean("compressImg", true);
    if (!Util.isNullOrNil(paramString)) {
      paramContext = ((d)h.ax(d.class)).aFn(paramString);
    }
    for (;;)
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("postId", paramContext);
        label88:
        parama.j(null, paramString);
        AppMethodBeat.o(83085);
        return;
        paramString = paramContext.optJSONArray("localIds");
        int i = paramContext.optInt("from");
        int j = paramContext.optInt("postType");
        String str = paramContext.optString("extra");
        int k = paramContext.optInt("sourceSceneId");
        paramContext = ((d)h.ax(d.class)).a(i, j, paramString, str, bool, k);
      }
      catch (JSONException paramContext)
      {
        break label88;
      }
    }
  }
  
  public final void b(b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "publishHaowanEdition";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ah
 * JD-Core Version:    0.7.0.1
 */
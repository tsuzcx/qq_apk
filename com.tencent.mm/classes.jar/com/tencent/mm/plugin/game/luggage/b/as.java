package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class as
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(277169);
    Log.i("MicroMsg.GameLife.JsApiStartGameLifeConversation", "invokeInMM");
    paramString = c.ZL(paramString);
    if (paramString == null)
    {
      parama.j("invalid_params", null);
      AppMethodBeat.o(277169);
      return;
    }
    String str1 = paramString.optString("fromUserName");
    String str2 = paramString.optString("toUserName");
    int i = paramString.optInt("scene", 0);
    paramString = paramString.optString("ext_info");
    Log.i("MicroMsg.GameLife.JsApiStartGameLifeConversation", "fromUserName:[%s] toUserName:[%s], scene:[%d], extInfo:[%s]", new Object[] { str1, str2, Integer.valueOf(i), paramString });
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
    {
      parama.j("null_data", null);
      AppMethodBeat.o(277169);
      return;
    }
    if (Util.isNullOrNil(paramString)) {}
    for (paramString = null;; paramString = new com.tencent.mm.bx.b(paramString.getBytes()))
    {
      ((PluginGameLife)h.az(PluginGameLife.class)).enterChattingUI(paramContext, str1, str2, i, paramString);
      parama.j(null, null);
      AppMethodBeat.o(277169);
      return;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "startGameLifeConversation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.as
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class aj
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(186888);
    Log.i("MicroMsg.GameLife.JsApiStartGameLifeConversation", "invokeInMM");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramString == null)
    {
      parama.i("invalid_params", null);
      AppMethodBeat.o(186888);
      return;
    }
    String str1 = paramString.optString("fromUserName");
    String str2 = paramString.optString("toUserName");
    int i = paramString.optInt("scene", 0);
    paramString = paramString.optString("ext_info");
    Log.i("MicroMsg.GameLife.JsApiStartGameLifeConversation", "fromUserName:[%s] toUserName:[%s], scene:[%d], extInfo:[%s]", new Object[] { str1, str2, Integer.valueOf(i), paramString });
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
    {
      parama.i("null_data", null);
      AppMethodBeat.o(186888);
      return;
    }
    if (Util.isNullOrNil(paramString)) {}
    for (paramString = null;; paramString = new com.tencent.mm.bw.b(paramString.getBytes()))
    {
      ((PluginGameLife)g.ah(PluginGameLife.class)).enterChattingUI(paramContext, str1, str2, i, paramString);
      parama.i(null, null);
      AppMethodBeat.o(186888);
      return;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<i>.a paramb) {}
  
  public final int dTs()
  {
    return 2;
  }
  
  public final String name()
  {
    return "startGameLifeConversation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.aj
 * JD-Core Version:    0.7.0.1
 */
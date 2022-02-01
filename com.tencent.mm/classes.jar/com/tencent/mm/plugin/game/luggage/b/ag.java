package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class ag
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(193009);
    ae.i("MicroMsg.GameLife.JsApiStartGameLifeConversation", "invokeInMM");
    Object localObject = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (localObject == null)
    {
      parama.f("invalid_params", null);
      AppMethodBeat.o(193009);
      return;
    }
    paramString = ((JSONObject)localObject).optString("fromUserName");
    localObject = ((JSONObject)localObject).optString("toUserName");
    ae.i("MicroMsg.GameLife.JsApiStartGameLifeConversation", "fromUserName:[%s] toUserName:[%s]", new Object[] { paramString, localObject });
    if ((bu.isNullOrNil(paramString)) || (bu.isNullOrNil((String)localObject)))
    {
      parama.f("null_data", null);
      AppMethodBeat.o(193009);
      return;
    }
    ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).enterChattingUI(paramContext, paramString, (String)localObject);
    parama.f(null, null);
    AppMethodBeat.o(193009);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ced()
  {
    return 2;
  }
  
  public final String name()
  {
    return "startGameLifeConversation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ag
 * JD-Core Version:    0.7.0.1
 */
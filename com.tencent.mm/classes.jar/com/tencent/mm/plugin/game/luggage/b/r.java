package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public class r
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(186871);
    Log.i("MicroMsg.GameLife.JsApiInitGameLifeContact", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramContext == null)
    {
      parama.i("invalid_params", null);
      AppMethodBeat.o(186871);
      return;
    }
    paramContext = paramContext.optString("userName");
    Log.i("MicroMsg.GameLife.JsApiInitGameLifeContact", "userName:[%s]", new Object[] { paramContext });
    if (Util.isNullOrNil(paramContext))
    {
      parama.i("null_data", null);
      AppMethodBeat.o(186871);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.b)g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramContext, new b.c()
    {
      public final void aj(Map<String, a> paramAnonymousMap)
      {
        AppMethodBeat.i(186870);
        parama.i(null, null);
        AppMethodBeat.o(186870);
      }
    });
    AppMethodBeat.o(186871);
  }
  
  public final void b(com.tencent.luggage.d.b<i>.a paramb) {}
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "initGameLifeContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.r
 * JD-Core Version:    0.7.0.1
 */
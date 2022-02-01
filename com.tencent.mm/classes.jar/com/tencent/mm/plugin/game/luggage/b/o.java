package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import org.json.JSONObject;

public class o
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(192997);
    ae.i("MicroMsg.GameLife.JsApiInitGameLifeContact", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (paramContext == null)
    {
      parama.f("invalid_params", null);
      AppMethodBeat.o(192997);
      return;
    }
    paramContext = paramContext.optString("userName");
    ae.i("MicroMsg.GameLife.JsApiInitGameLifeContact", "userName:[%s]", new Object[] { paramContext });
    if (bu.isNullOrNil(paramContext))
    {
      parama.f("null_data", null);
      AppMethodBeat.o(192997);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramContext, new b.c()
    {
      public final void ah(Map<String, a> paramAnonymousMap)
      {
        AppMethodBeat.i(192996);
        parama.f(null, null);
        AppMethodBeat.o(192996);
      }
    });
    AppMethodBeat.o(192997);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ced()
  {
    return 1;
  }
  
  public final String name()
  {
    return "initGameLifeContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.o
 * JD-Core Version:    0.7.0.1
 */
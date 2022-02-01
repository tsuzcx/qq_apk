package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import org.json.JSONObject;

public class o
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(211608);
    ad.i("MicroMsg.GameLife.JsApiInitGameLifeContact", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.Pe(paramString);
    if (paramContext == null)
    {
      parama.f("invalid_params", null);
      AppMethodBeat.o(211608);
      return;
    }
    paramContext = paramContext.optString("userName");
    ad.i("MicroMsg.GameLife.JsApiInitGameLifeContact", "userName:[%s]", new Object[] { paramContext });
    if (bt.isNullOrNil(paramContext))
    {
      parama.f("null_data", null);
      AppMethodBeat.o(211608);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramContext, new b.c()
    {
      public final void ab(Map<String, a> paramAnonymousMap)
      {
        AppMethodBeat.i(211607);
        parama.f(null, null);
        AppMethodBeat.o(211607);
      }
    });
    AppMethodBeat.o(211608);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ccO()
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
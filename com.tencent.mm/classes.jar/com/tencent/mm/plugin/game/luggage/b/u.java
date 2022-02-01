package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public class u
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(277147);
    Log.i("MicroMsg.GameLife.JsApiInitGameLifeContact", "invokeInMM");
    paramContext = c.ZL(paramString);
    if (paramContext == null)
    {
      parama.j("invalid_params", null);
      AppMethodBeat.o(277147);
      return;
    }
    paramContext = paramContext.optString("userName");
    Log.i("MicroMsg.GameLife.JsApiInitGameLifeContact", "userName:[%s]", new Object[] { paramContext });
    if (Util.isNullOrNil(paramContext))
    {
      parama.j("null_data", null);
      AppMethodBeat.o(277147);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramContext, new b.c()
    {
      public final void onDone(Map<String, a> paramAnonymousMap)
      {
        AppMethodBeat.i(277123);
        parama.j(null, null);
        AppMethodBeat.o(277123);
      }
    });
    AppMethodBeat.o(277147);
  }
  
  public final void b(com.tencent.luggage.d.b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "initGameLifeContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.u
 * JD-Core Version:    0.7.0.1
 */
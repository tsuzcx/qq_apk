package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class ad
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(211618);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GameLife.JsApiSetBlackList", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.Pe(paramString);
    if (paramContext == null)
    {
      parama.f("invalid_params", null);
      AppMethodBeat.o(211618);
      return;
    }
    paramString = paramContext.optString("userName");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GameLife.JsApiSetBlackList", "userName:[%s]", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      parama.f("null_data", null);
      AppMethodBeat.o(211618);
      return;
    }
    if (!paramContext.has("switch"))
    {
      parama.f("switch_null", null);
      AppMethodBeat.o(211618);
      return;
    }
    try
    {
      boolean bool1 = paramContext.getBoolean("switch");
      boolean bool2 = paramContext.optBoolean("associateWxGameAccount", false);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GameLife.JsApiSetBlackList", "JsApiSetBlackList setBlack:%b,associateWxGameAccount:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, bool1, bool2, new b.b()
      {
        public final void mZ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(211617);
          if (paramAnonymousBoolean)
          {
            parama.f(null, null);
            AppMethodBeat.o(211617);
            return;
          }
          parama.f("setBlackList error", null);
          AppMethodBeat.o(211617);
        }
      });
      AppMethodBeat.o(211618);
      return;
    }
    catch (JSONException paramContext)
    {
      parama.f("switch_error", null);
      AppMethodBeat.o(211618);
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ccO()
  {
    return 1;
  }
  
  public final String name()
  {
    return "setBlackList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ad
 * JD-Core Version:    0.7.0.1
 */
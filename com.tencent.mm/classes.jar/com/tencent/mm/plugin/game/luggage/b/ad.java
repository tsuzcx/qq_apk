package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public class ad
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(193007);
    ae.i("MicroMsg.GameLife.JsApiSetBlackList", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (paramContext == null)
    {
      parama.f("invalid_params", null);
      AppMethodBeat.o(193007);
      return;
    }
    paramString = paramContext.optString("userName");
    ae.i("MicroMsg.GameLife.JsApiSetBlackList", "userName:[%s]", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      parama.f("null_data", null);
      AppMethodBeat.o(193007);
      return;
    }
    if (!paramContext.has("switch"))
    {
      parama.f("switch_null", null);
      AppMethodBeat.o(193007);
      return;
    }
    try
    {
      boolean bool1 = paramContext.getBoolean("switch");
      boolean bool2 = paramContext.optBoolean("associateWxGameAccount", false);
      ae.i("MicroMsg.GameLife.JsApiSetBlackList", "JsApiSetBlackList setBlack:%b,associateWxGameAccount:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, bool1, bool2, new b.b()
      {
        public final void nd(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(193006);
          if (paramAnonymousBoolean)
          {
            parama.f(null, null);
            AppMethodBeat.o(193006);
            return;
          }
          parama.f("setBlackList error", null);
          AppMethodBeat.o(193006);
        }
      });
      AppMethodBeat.o(193007);
      return;
    }
    catch (JSONException paramContext)
    {
      parama.f("switch_error", null);
      AppMethodBeat.o(193007);
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ced()
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
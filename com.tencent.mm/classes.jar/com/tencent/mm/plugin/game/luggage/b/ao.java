package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.gamelife.a.b.b;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class ao
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(277182);
    Log.i("MicroMsg.GameLife.JsApiSetBlackList", "invokeInMM");
    paramContext = c.ZL(paramString);
    if (paramContext == null)
    {
      parama.j("invalid_params", null);
      AppMethodBeat.o(277182);
      return;
    }
    paramString = paramContext.optString("userName");
    Log.i("MicroMsg.GameLife.JsApiSetBlackList", "userName:[%s]", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      parama.j("null_data", null);
      AppMethodBeat.o(277182);
      return;
    }
    if (!paramContext.has("switch"))
    {
      parama.j("switch_null", null);
      AppMethodBeat.o(277182);
      return;
    }
    try
    {
      boolean bool1 = paramContext.getBoolean("switch");
      boolean bool2 = paramContext.optBoolean("associateWxGameAccount", false);
      Log.i("MicroMsg.GameLife.JsApiSetBlackList", "JsApiSetBlackList setBlack:%b,associateWxGameAccount:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, bool1, bool2, new b.b()
      {
        public final void onDone(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(277150);
          if (paramAnonymousBoolean)
          {
            parama.j(null, null);
            AppMethodBeat.o(277150);
            return;
          }
          parama.j("setBlackList error", null);
          AppMethodBeat.o(277150);
        }
      });
      AppMethodBeat.o(277182);
      return;
    }
    catch (JSONException paramContext)
    {
      parama.j("switch_error", null);
      AppMethodBeat.o(277182);
    }
  }
  
  public final void b(com.tencent.luggage.d.b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "setBlackList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ao
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.gamelife.a.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class ag
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(186886);
    Log.i("MicroMsg.GameLife.JsApiSetBlackList", "invokeInMM");
    paramContext = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramContext == null)
    {
      parama.i("invalid_params", null);
      AppMethodBeat.o(186886);
      return;
    }
    paramString = paramContext.optString("userName");
    Log.i("MicroMsg.GameLife.JsApiSetBlackList", "userName:[%s]", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      parama.i("null_data", null);
      AppMethodBeat.o(186886);
      return;
    }
    if (!paramContext.has("switch"))
    {
      parama.i("switch_null", null);
      AppMethodBeat.o(186886);
      return;
    }
    try
    {
      boolean bool1 = paramContext.getBoolean("switch");
      boolean bool2 = paramContext.optBoolean("associateWxGameAccount", false);
      Log.i("MicroMsg.GameLife.JsApiSetBlackList", "JsApiSetBlackList setBlack:%b,associateWxGameAccount:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      ((com.tencent.mm.plugin.gamelife.a.b)g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, bool1, bool2, new b.b()
      {
        public final void mM(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(186885);
          if (paramAnonymousBoolean)
          {
            parama.i(null, null);
            AppMethodBeat.o(186885);
            return;
          }
          parama.i("setBlackList error", null);
          AppMethodBeat.o(186885);
        }
      });
      AppMethodBeat.o(186886);
      return;
    }
    catch (JSONException paramContext)
    {
      parama.i("switch_error", null);
      AppMethodBeat.o(186886);
    }
  }
  
  public final void b(com.tencent.luggage.d.b<i>.a paramb) {}
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "setBlackList";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ag
 * JD-Core Version:    0.7.0.1
 */
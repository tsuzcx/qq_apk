package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.luggage.e;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class r
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(83073);
    Log.i("MicroMsg.JsApiGetWePkgAuthResult", "invoke");
    if (((GameWebPage)paramb.eiY).iuh())
    {
      Log.i("MicroMsg.JsApiGetWePkgAuthResult", "gettingA8Key");
      paramb.a("auth_result_not_return", null);
      AppMethodBeat.o(83073);
      return;
    }
    String str = ((GameWebPage)paramb.eiY).dfU();
    boolean bool = ((GameWebPage)paramb.eiY).IwQ;
    if (Util.isNullOrNil(str)) {
      if (Util.isNullOrNil(e.ItK))
      {
        Log.i("MicroMsg.LuggageGameUinKeyHolder", "fullUrl is null");
        i = 0;
        if (i == 0) {
          break label260;
        }
        str = e.ItK;
      }
    }
    label260:
    for (int i = 1;; i = 0)
    {
      if (Util.isNullOrNil(str))
      {
        paramb.a("full_url_empty", null);
        AppMethodBeat.o(83073);
        return;
        if (a.fDV() <= 0)
        {
          i = 0;
          break;
        }
        if (System.currentTimeMillis() / 1000L - e.dX > a.fDV())
        {
          Log.i("MicroMsg.LuggageGameUinKeyHolder", "updateTime bigger that one hour");
          i = 0;
          break;
        }
        Log.d("MicroMsg.LuggageGameUinKeyHolder", "hasValidCache");
        i = 1;
        break;
      }
      HashMap localHashMap = new HashMap();
      if (bool) {
        localHashMap.put("set_cookie", Integer.valueOf(1));
      }
      for (;;)
      {
        if (i != 0) {
          localHashMap.put("used_cache_uinkey", Integer.valueOf(1));
        }
        localHashMap.put("full_url", str);
        paramb.d("", localHashMap);
        AppMethodBeat.o(83073);
        return;
        localHashMap.put("set_cookie", Integer.valueOf(0));
      }
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getWePkgAuthResult";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.r
 * JD-Core Version:    0.7.0.1
 */
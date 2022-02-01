package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.luggage.e;
import com.tencent.mm.plugin.game.luggage.f.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public class n
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(83073);
    ad.i("MicroMsg.JsApiGetWePkgAuthResult", "invoke");
    if (((g)paramb.chg).ePg())
    {
      ad.i("MicroMsg.JsApiGetWePkgAuthResult", "gettingA8Key");
      paramb.a("auth_result_not_return", null);
      AppMethodBeat.o(83073);
      return;
    }
    String str = ((g)paramb.chg).ePh();
    boolean bool = ((g)paramb.chg).tVw;
    if (bt.isNullOrNil(str)) {
      if (bt.isNullOrNil(e.tTn))
      {
        ad.i("MicroMsg.LuggageGameUinKeyHolder", "fullUrl is null");
        i = 0;
        if (i == 0) {
          break label260;
        }
        str = e.tTn;
      }
    }
    label260:
    for (int i = 1;; i = 0)
    {
      if (bt.isNullOrNil(str))
      {
        paramb.a("full_url_empty", null);
        AppMethodBeat.o(83073);
        return;
        if (a.cWT() <= 0)
        {
          i = 0;
          break;
        }
        if (System.currentTimeMillis() / 1000L - e.MX > a.cWT())
        {
          ad.i("MicroMsg.LuggageGameUinKeyHolder", "updateTime bigger that one hour");
          i = 0;
          break;
        }
        ad.d("MicroMsg.LuggageGameUinKeyHolder", "hasValidCache");
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
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getWePkgAuthResult";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public class l
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(com.tencent.luggage.d.a<f>.a parama)
  {
    AppMethodBeat.i(83073);
    ad.i("MicroMsg.JsApiGetWePkgAuthResult", "invoke");
    if (((f)parama.bZU).ekU())
    {
      ad.i("MicroMsg.JsApiGetWePkgAuthResult", "gettingA8Key");
      parama.a("auth_result_not_return", null);
      AppMethodBeat.o(83073);
      return;
    }
    String str = ((f)parama.bZU).ekV();
    boolean bool = ((f)parama.bZU).rQt;
    if (bt.isNullOrNil(str)) {
      if (bt.isNullOrNil(d.rOQ))
      {
        ad.i("MicroMsg.LuggageGameUinKeyHolder", "fullUrl is null");
        i = 0;
        if (i == 0) {
          break label260;
        }
        str = d.rOQ;
      }
    }
    label260:
    for (int i = 1;; i = 0)
    {
      if (bt.isNullOrNil(str))
      {
        parama.a("full_url_empty", null);
        AppMethodBeat.o(83073);
        return;
        if (com.tencent.mm.plugin.game.commlib.a.cBp() <= 0)
        {
          i = 0;
          break;
        }
        if (System.currentTimeMillis() / 1000L - d.Kk > com.tencent.mm.plugin.game.commlib.a.cBp())
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
        parama.c("", localHashMap);
        AppMethodBeat.o(83073);
        return;
        localHashMap.put("set_cookie", Integer.valueOf(0));
      }
    }
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getWePkgAuthResult";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */
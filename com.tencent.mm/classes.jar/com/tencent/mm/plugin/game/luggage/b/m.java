package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public class m
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(com.tencent.luggage.d.a<f>.a parama)
  {
    AppMethodBeat.i(83073);
    ac.i("MicroMsg.JsApiGetWePkgAuthResult", "invoke");
    if (((f)parama.bWR).eAq())
    {
      ac.i("MicroMsg.JsApiGetWePkgAuthResult", "gettingA8Key");
      parama.a("auth_result_not_return", null);
      AppMethodBeat.o(83073);
      return;
    }
    String str = ((f)parama.bWR).eAr();
    boolean bool = ((f)parama.bWR).sYk;
    if (bs.isNullOrNil(str)) {
      if (bs.isNullOrNil(d.sWG))
      {
        ac.i("MicroMsg.LuggageGameUinKeyHolder", "fullUrl is null");
        i = 0;
        if (i == 0) {
          break label260;
        }
        str = d.sWG;
      }
    }
    label260:
    for (int i = 1;; i = 0)
    {
      if (bs.isNullOrNil(str))
      {
        parama.a("full_url_empty", null);
        AppMethodBeat.o(83073);
        return;
        if (com.tencent.mm.plugin.game.commlib.a.cOy() <= 0)
        {
          i = 0;
          break;
        }
        if (System.currentTimeMillis() / 1000L - d.Lf > com.tencent.mm.plugin.game.commlib.a.cOy())
        {
          ac.i("MicroMsg.LuggageGameUinKeyHolder", "updateTime bigger that one hour");
          i = 0;
          break;
        }
        ac.d("MicroMsg.LuggageGameUinKeyHolder", "hasValidCache");
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
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getWePkgAuthResult";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */
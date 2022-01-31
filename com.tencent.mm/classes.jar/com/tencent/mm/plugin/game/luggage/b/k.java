package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class k
  extends bi<f>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(135876);
    ab.i("MicroMsg.JsApiGetWePkgAuthResult", "invoke");
    if (((f)parama.byE).daY())
    {
      ab.i("MicroMsg.JsApiGetWePkgAuthResult", "gettingA8Key");
      parama.a("auth_result_not_return", null);
      AppMethodBeat.o(135876);
      return;
    }
    String str1 = ((f)parama.byE).nji;
    boolean bool = ((f)parama.byE).njj;
    if ((bo.isNullOrNil(str1)) && (com.tencent.mm.plugin.game.luggage.b.bFl()))
    {
      str1 = com.tencent.mm.plugin.game.luggage.b.nji;
      if (com.tencent.mm.plugin.game.luggage.b.mHeaders == null) {
        bool = false;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (bo.isNullOrNil(str1))
      {
        parama.a("full_url_empty", null);
        AppMethodBeat.o(135876);
        return;
        localObject = "." + bo.aqm(com.tencent.mm.plugin.game.luggage.b.nji);
        String str2 = bo.aqm(com.tencent.mm.plugin.game.luggage.b.nji);
        c.jQ(ah.getContext());
        com.tencent.xweb.b localb = com.tencent.xweb.b.dYg();
        Iterator localIterator = com.tencent.mm.plugin.game.luggage.b.mHeaders.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          localb.setCookie(str2, str3 + "=" + (String)com.tencent.mm.plugin.game.luggage.b.mHeaders.get(str3));
        }
        localb.setCookie(str2, "httponly");
        localb.setCookie((String)localObject, "httponly");
        c.dYi();
        c.sync();
        ab.i("MicroMsg.LuggageGameUinKeyHolder", "setCookie, cookies:%s", new Object[] { localb.getCookie(str2) });
        bool = true;
        break;
      }
      Object localObject = new HashMap();
      if (bool) {
        ((HashMap)localObject).put("set_cookie", Integer.valueOf(1));
      }
      for (;;)
      {
        if (i != 0) {
          ((HashMap)localObject).put("used_cache_uinkey", Integer.valueOf(1));
        }
        ((HashMap)localObject).put("full_url", str1);
        parama.c("", (Map)localObject);
        AppMethodBeat.o(135876);
        return;
        ((HashMap)localObject).put("set_cookie", Integer.valueOf(0));
      }
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getWePkgAuthResult";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */
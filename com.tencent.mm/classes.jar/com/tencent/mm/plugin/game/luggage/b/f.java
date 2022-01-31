package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class f
  extends ax<d>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<d>.a parama)
  {
    y.i("MicroMsg.JsApiGetWePkgAuthResult", "invoke");
    if (((d)parama.big).caT())
    {
      y.i("MicroMsg.JsApiGetWePkgAuthResult", "gettingA8Key");
      parama.a("auth_result_not_return", null);
      return;
    }
    String str = ((d)parama.big).kMT;
    if (bk.bl(str))
    {
      parama.a("full_url_empty", null);
      return;
    }
    HashMap localHashMap = new HashMap();
    if (((d)parama.big).kMz) {
      localHashMap.put("set_cookie", Integer.valueOf(1));
    }
    for (;;)
    {
      localHashMap.put("full_url", str);
      parama.c("", localHashMap);
      return;
      localHashMap.put("set_cookie", Integer.valueOf(0));
    }
  }
  
  public final String name()
  {
    return "getWePkgAuthResult";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.f
 * JD-Core Version:    0.7.0.1
 */
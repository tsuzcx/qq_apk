package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.luggage.j.g;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class c$1
  implements c.a
{
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, int paramInt) {}
  
  public final void a(boolean paramBoolean, String paramString, Intent paramIntent)
  {
    y.i("MicroMsg.JsApiEnterContact", "page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap();
      String str = "";
      paramString = new HashMap();
      if (paramIntent != null)
      {
        paramString = bk.aM(paramIntent.getStringExtra("keyOutPagePath"), "");
        str = g.bi(paramString);
        paramString = g.bj(paramString);
      }
      localHashMap.put("path", str);
      localHashMap.put("query", paramString);
      y.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramString.toString() });
      this.gpS.C(this.dIS, this.gpT.h("ok", localHashMap));
      return;
    }
    this.gpS.C(this.dIS, this.gpT.h(paramString, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.c.1
 * JD-Core Version:    0.7.0.1
 */
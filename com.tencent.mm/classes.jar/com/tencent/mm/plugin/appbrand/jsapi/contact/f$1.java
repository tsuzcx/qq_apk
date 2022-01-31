package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class f$1
  implements f.a
{
  f$1(f paramf, c paramc, int paramInt) {}
  
  public final void a(boolean paramBoolean, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(131019);
    ab.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap();
      String str = "";
      paramString = new HashMap();
      if (paramIntent != null)
      {
        paramString = bo.bf(paramIntent.getStringExtra("keyOutPagePath"), "");
        str = h.cg(paramString);
        paramString = h.ch(paramString);
      }
      localHashMap.put("path", str);
      localHashMap.put("query", paramString);
      ab.i("MicroMsg.JsApiPrivateEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramString.toString() });
      this.hKB.h(this.bAX, this.hKQ.j("ok", localHashMap));
      AppMethodBeat.o(131019);
      return;
    }
    this.hKB.h(this.bAX, this.hKQ.j(paramString, null));
    AppMethodBeat.o(131019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.f.1
 * JD-Core Version:    0.7.0.1
 */
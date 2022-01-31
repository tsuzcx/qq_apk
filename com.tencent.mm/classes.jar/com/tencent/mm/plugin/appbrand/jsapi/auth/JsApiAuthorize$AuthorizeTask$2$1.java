package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.luggage.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.b.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

final class JsApiAuthorize$AuthorizeTask$2$1
  implements i.d
{
  JsApiAuthorize$AuthorizeTask$2$1(JsApiAuthorize.AuthorizeTask.2 param2) {}
  
  public final void a(int paramInt, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(130833);
    if (c.A(paramArrayList).size() > 0)
    {
      paramArrayList = (String)paramArrayList.get(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(130833);
      return;
      paramArrayList = "";
      break;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramArrayList);
      JsApiAuthorize.AuthorizeTask.a(this.hDN.hDK, 1, localArrayList);
      ab.i("MicroMsg.JsApiAuthorize", "click PositiveButton");
      AppMethodBeat.o(130833);
      return;
      localArrayList = new ArrayList();
      localArrayList.add(paramArrayList);
      JsApiAuthorize.AuthorizeTask.a(this.hDN.hDK, 2, localArrayList);
      ab.i("MicroMsg.JsApiAuthorize", "click NegativeButton");
      AppMethodBeat.o(130833);
      return;
      JsApiAuthorize.AuthorizeTask.f(this.hDN.hDK);
      ab.i("MicroMsg.JsApiAuthorize", "user cancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.2.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.config.a.g;
import com.tencent.mm.plugin.appbrand.widget.i.a.b;
import java.util.ArrayList;
import java.util.HashMap;

final class h$4
  implements a.b
{
  h$4(h paramh, a.f paramf) {}
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(141655);
    this.ivQ.getContainer().Ej(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("pagePath", paramString);
    localHashMap.put("text", ((a.g)this.ivR.cBy.get(paramInt)).text);
    localHashMap.put("index", Integer.valueOf(paramInt));
    this.ivQ.getCurrentPageView().b(new h.a().w(localHashMap));
    AppMethodBeat.o(141655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h.4
 * JD-Core Version:    0.7.0.1
 */
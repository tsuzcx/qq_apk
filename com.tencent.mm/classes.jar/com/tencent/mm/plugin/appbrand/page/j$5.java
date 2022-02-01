package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.g;
import com.tencent.mm.plugin.appbrand.config.a.h;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a.b;
import java.util.ArrayList;
import java.util.HashMap;

final class j$5
  implements a.b
{
  j$5(j paramj, a.g paramg) {}
  
  public final void al(int paramInt, String paramString)
  {
    AppMethodBeat.i(194485);
    this.kYG.getContainer().Ly(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("pagePath", paramString);
    localHashMap.put("text", ((a.h)this.kYH.iq.get(paramInt)).text);
    localHashMap.put("index", Integer.valueOf(paramInt));
    this.kYG.getCurrentPageView().b(new j.a().B(localHashMap));
    AppMethodBeat.o(194485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.tabbar.c;
import com.tencent.mm.plugin.appbrand.widget.tabbar.d;
import com.tencent.mm.sdk.platformtools.ad;

final class ae$14
  extends c
{
  ae$14(ae paramae) {}
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(47881);
    super.a(paramString, paramd);
    ad.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(47881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.14
 * JD-Core Version:    0.7.0.1
 */
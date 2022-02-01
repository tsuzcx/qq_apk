package com.tencent.mm.plugin.appbrand.widget.tabbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class a$6
  extends c
{
  a$6(a parama) {}
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(135510);
    super.a(paramString, paramd);
    ad.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(135510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.a.6
 * JD-Core Version:    0.7.0.1
 */
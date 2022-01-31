package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.i.c;
import com.tencent.mm.plugin.appbrand.widget.i.d;
import com.tencent.mm.sdk.platformtools.ab;

final class z$7
  extends c
{
  z$7(z paramz) {}
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(143501);
    super.a(paramString, paramd);
    ab.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(143501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z.7
 * JD-Core Version:    0.7.0.1
 */
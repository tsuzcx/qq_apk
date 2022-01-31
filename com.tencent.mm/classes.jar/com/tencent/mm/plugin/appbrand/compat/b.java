package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.sdk.b.a;

final class b
  implements com.tencent.mm.plugin.appbrand.compat.a.b
{
  public final void a(String paramString, h.a parama, h.b paramb)
  {
    AppMethodBeat.i(135460);
    fl localfl = new fl();
    localfl.ctw.op = 1;
    localfl.ctw.fileName = paramString;
    localfl.ctw.ctz = true;
    localfl.ctw.cie = true;
    localfl.ctw.ctA = parama;
    localfl.ctw.ctB = paramb;
    a.ymk.l(localfl);
    AppMethodBeat.o(135460);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(135461);
    fl localfl = new fl();
    localfl.ctw.op = 4;
    a.ymk.l(localfl);
    AppMethodBeat.o(135461);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(135462);
    fl localfl = new fl();
    localfl.ctw.op = 2;
    a.ymk.l(localfl);
    AppMethodBeat.o(135462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.compat.b
 * JD-Core Version:    0.7.0.1
 */
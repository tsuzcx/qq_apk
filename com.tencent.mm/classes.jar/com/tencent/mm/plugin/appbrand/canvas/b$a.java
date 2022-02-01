package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class b$a
  implements a
{
  private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> jSW;
  
  b$a(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    AppMethodBeat.i(144830);
    this.jSW = new WeakReference(parama);
    AppMethodBeat.o(144830);
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(144831);
    com.tencent.mm.plugin.appbrand.canvas.widget.a locala = (com.tencent.mm.plugin.appbrand.canvas.widget.a)this.jSW.get();
    if (locala == null)
    {
      AppMethodBeat.o(144831);
      return;
    }
    locala.bdk();
    AppMethodBeat.o(144831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.a
 * JD-Core Version:    0.7.0.1
 */
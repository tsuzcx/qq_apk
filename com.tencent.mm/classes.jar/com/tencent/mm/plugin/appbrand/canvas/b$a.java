package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class b$a
  implements a
{
  private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> hez;
  
  b$a(com.tencent.mm.plugin.appbrand.canvas.widget.a parama)
  {
    AppMethodBeat.i(103147);
    this.hez = new WeakReference(parama);
    AppMethodBeat.o(103147);
  }
  
  public final void invalidate()
  {
    AppMethodBeat.i(103148);
    com.tencent.mm.plugin.appbrand.canvas.widget.a locala = (com.tencent.mm.plugin.appbrand.canvas.widget.a)this.hez.get();
    if (locala == null)
    {
      AppMethodBeat.o(103148);
      return;
    }
    locala.axT();
    AppMethodBeat.o(103148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.b.a
 * JD-Core Version:    0.7.0.1
 */
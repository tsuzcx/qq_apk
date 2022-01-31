package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;

final class o$3
  implements Runnable
{
  o$3(o paramo, o.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(58398);
    if (this.fJB != null)
    {
      if (!(this.fJB instanceof o.f)) {
        break label53;
      }
      o.b(this.fJA).add(this.fJB);
    }
    for (;;)
    {
      o.a(this.fJA, null);
      AppMethodBeat.o(58398);
      return;
      label53:
      o.c(this.fJA).add(this.fJB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.report.model;

import android.support.v4.e.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

final class i$b
  implements k.a<i.a>
{
  private final Queue<i.a> cho;
  
  private i$b()
  {
    AppMethodBeat.i(132620);
    this.cho = new ConcurrentLinkedQueue();
    AppMethodBeat.o(132620);
  }
  
  public final boolean a(i.a parama)
  {
    AppMethodBeat.i(132622);
    boolean bool = this.cho.offer(parama);
    AppMethodBeat.o(132622);
    return bool;
  }
  
  public final i.a aLo()
  {
    AppMethodBeat.i(132621);
    i.a locala = (i.a)this.cho.poll();
    if (locala == null)
    {
      locala = new i.a((byte)0);
      AppMethodBeat.o(132621);
      return locala;
    }
    AppMethodBeat.o(132621);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i.b
 * JD-Core Version:    0.7.0.1
 */
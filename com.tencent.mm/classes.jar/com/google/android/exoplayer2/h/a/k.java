package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class k
  implements f, Comparator<g>
{
  private long aID;
  private final long bGC;
  private final TreeSet<g> bGD;
  
  public k(long paramLong)
  {
    AppMethodBeat.i(196063);
    this.bGC = paramLong;
    this.bGD = new TreeSet(this);
    AppMethodBeat.o(196063);
  }
  
  private void b(a parama, long paramLong)
  {
    AppMethodBeat.i(93003);
    while ((this.aID + paramLong > this.bGC) && (!this.bGD.isEmpty())) {
      try
      {
        parama.b((g)this.bGD.first());
      }
      catch (a.a locala) {}
    }
    AppMethodBeat.o(93003);
  }
  
  public final void a(a parama, long paramLong)
  {
    AppMethodBeat.i(92999);
    b(parama, paramLong);
    AppMethodBeat.o(92999);
  }
  
  public final void a(a parama, g paramg)
  {
    AppMethodBeat.i(93000);
    this.bGD.add(paramg);
    this.aID += paramg.length;
    b(parama, 0L);
    AppMethodBeat.o(93000);
  }
  
  public final void a(a parama, g paramg1, g paramg2)
  {
    AppMethodBeat.i(93002);
    c(paramg1);
    a(parama, paramg2);
    AppMethodBeat.o(93002);
  }
  
  public final void c(g paramg)
  {
    AppMethodBeat.i(93001);
    this.bGD.remove(paramg);
    this.aID -= paramg.length;
    AppMethodBeat.o(93001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.k
 * JD-Core Version:    0.7.0.1
 */
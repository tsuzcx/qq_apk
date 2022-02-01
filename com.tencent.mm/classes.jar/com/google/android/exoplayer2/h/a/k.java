package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class k
  implements f, Comparator<g>
{
  private final long bqg;
  private final TreeSet<g> bqh;
  private long bqi;
  
  public k(long paramLong)
  {
    AppMethodBeat.i(199231);
    this.bqg = paramLong;
    this.bqh = new TreeSet(this);
    AppMethodBeat.o(199231);
  }
  
  private void b(a parama, long paramLong)
  {
    AppMethodBeat.i(93003);
    while ((this.bqi + paramLong > this.bqg) && (!this.bqh.isEmpty())) {
      try
      {
        parama.b((g)this.bqh.first());
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
    this.bqh.add(paramg);
    this.bqi += paramg.aFL;
    b(parama, 0L);
    AppMethodBeat.o(93000);
  }
  
  public final void a(a parama, g paramg1, g paramg2)
  {
    AppMethodBeat.i(93002);
    b(parama, paramg1);
    a(parama, paramg2);
    AppMethodBeat.o(93002);
  }
  
  public final void b(a parama, g paramg)
  {
    AppMethodBeat.i(199234);
    this.bqh.remove(paramg);
    this.bqi -= paramg.aFL;
    AppMethodBeat.o(199234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.k
 * JD-Core Version:    0.7.0.1
 */
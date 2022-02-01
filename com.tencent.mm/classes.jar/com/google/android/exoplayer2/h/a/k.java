package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class k
  implements f, Comparator<g>
{
  private final long djK;
  private final TreeSet<g> djL;
  private long djM;
  
  public k(long paramLong)
  {
    AppMethodBeat.i(210321);
    this.djK = paramLong;
    this.djL = new TreeSet(this);
    AppMethodBeat.o(210321);
  }
  
  private void b(a parama, long paramLong)
  {
    AppMethodBeat.i(93003);
    while ((this.djM + paramLong > this.djK) && (!this.djL.isEmpty())) {
      try
      {
        parama.b((g)this.djL.first());
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
    this.djL.add(paramg);
    this.djM += paramg.length;
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
    AppMethodBeat.i(210324);
    this.djL.remove(paramg);
    this.djM -= paramg.length;
    AppMethodBeat.o(210324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.k
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class i
  implements d, Comparator<e>
{
  private final long bam;
  private final TreeSet<e> ban;
  private long bao;
  
  public i()
  {
    AppMethodBeat.i(151978);
    this.bam = 104857600L;
    this.ban = new TreeSet(this);
    AppMethodBeat.o(151978);
  }
  
  private void b(a parama, long paramLong)
  {
    AppMethodBeat.i(151983);
    while ((this.bao + paramLong > this.bam) && (!this.ban.isEmpty())) {
      try
      {
        parama.b((e)this.ban.first());
      }
      catch (a.a locala) {}
    }
    AppMethodBeat.o(151983);
  }
  
  public final void a(a parama, long paramLong)
  {
    AppMethodBeat.i(151979);
    b(parama, paramLong);
    AppMethodBeat.o(151979);
  }
  
  public final void a(a parama, e parame)
  {
    AppMethodBeat.i(151980);
    this.ban.add(parame);
    this.bao += parame.aPF;
    b(parama, 0L);
    AppMethodBeat.o(151980);
  }
  
  public final void a(a parama, e parame1, e parame2)
  {
    AppMethodBeat.i(151982);
    c(parame1);
    a(parama, parame2);
    AppMethodBeat.o(151982);
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(151981);
    this.ban.remove(parame);
    this.bao -= parame.aPF;
    AppMethodBeat.o(151981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.i
 * JD-Core Version:    0.7.0.1
 */
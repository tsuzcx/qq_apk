package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class h
  implements d, Comparator<f>
{
  private long aID;
  public volatile long bGC;
  private final TreeSet<f> bGD;
  
  public h(long paramLong)
  {
    AppMethodBeat.i(234689);
    this.bGC = paramLong;
    this.bGD = new TreeSet(this);
    AppMethodBeat.o(234689);
  }
  
  private void b(a parama, long paramLong)
  {
    AppMethodBeat.i(234693);
    while ((this.aID + paramLong > this.bGC) && (!this.bGD.isEmpty())) {
      parama.b((f)this.bGD.first());
    }
    AppMethodBeat.o(234693);
  }
  
  public final void a(a parama, long paramLong)
  {
    AppMethodBeat.i(234690);
    b(parama, paramLong);
    AppMethodBeat.o(234690);
  }
  
  public final void a(a parama, f paramf)
  {
    AppMethodBeat.i(234691);
    this.bGD.add(paramf);
    this.aID += paramf.length;
    b(parama, 0L);
    AppMethodBeat.o(234691);
  }
  
  public final void c(f paramf)
  {
    AppMethodBeat.i(234692);
    this.bGD.remove(paramf);
    this.aID -= paramf.length;
    AppMethodBeat.o(234692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.h
 * JD-Core Version:    0.7.0.1
 */
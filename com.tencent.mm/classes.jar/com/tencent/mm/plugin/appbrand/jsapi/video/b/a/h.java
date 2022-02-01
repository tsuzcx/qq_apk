package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class h
  implements d, Comparator<f>
{
  private long aGd;
  public volatile long byo;
  private final TreeSet<f> byp;
  
  public h(long paramLong)
  {
    AppMethodBeat.i(193834);
    this.byo = paramLong;
    this.byp = new TreeSet(this);
    AppMethodBeat.o(193834);
  }
  
  private void b(a parama, long paramLong)
  {
    AppMethodBeat.i(193838);
    while ((this.aGd + paramLong > this.byo) && (!this.byp.isEmpty())) {
      parama.b((f)this.byp.first());
    }
    AppMethodBeat.o(193838);
  }
  
  public final void a(a parama, long paramLong)
  {
    AppMethodBeat.i(193835);
    b(parama, paramLong);
    AppMethodBeat.o(193835);
  }
  
  public final void a(a parama, f paramf)
  {
    AppMethodBeat.i(193836);
    this.byp.add(paramf);
    this.aGd += paramf.length;
    b(parama, 0L);
    AppMethodBeat.o(193836);
  }
  
  public final void c(f paramf)
  {
    AppMethodBeat.i(193837);
    this.byp.remove(paramf);
    this.aGd -= paramf.length;
    AppMethodBeat.o(193837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.h
 * JD-Core Version:    0.7.0.1
 */
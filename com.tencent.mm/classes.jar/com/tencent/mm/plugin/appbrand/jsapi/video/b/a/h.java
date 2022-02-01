package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class h
  implements d, Comparator<f>
{
  public volatile long bqg;
  private final TreeSet<f> bqh;
  private long bqi;
  
  public h(long paramLong)
  {
    AppMethodBeat.i(230562);
    this.bqg = paramLong;
    this.bqh = new TreeSet(this);
    AppMethodBeat.o(230562);
  }
  
  private void b(a parama, long paramLong)
  {
    AppMethodBeat.i(230570);
    while ((this.bqi + paramLong > this.bqg) && (!this.bqh.isEmpty())) {
      parama.b((f)this.bqh.first());
    }
    AppMethodBeat.o(230570);
  }
  
  public final void a(a parama, long paramLong)
  {
    AppMethodBeat.i(230563);
    b(parama, paramLong);
    AppMethodBeat.o(230563);
  }
  
  public final void a(a parama, f paramf)
  {
    AppMethodBeat.i(230566);
    this.bqh.add(paramf);
    this.bqi += paramf.aFL;
    b(parama, 0L);
    AppMethodBeat.o(230566);
  }
  
  public final void c(f paramf)
  {
    AppMethodBeat.i(230568);
    this.bqh.remove(paramf);
    this.bqi -= paramf.aFL;
    AppMethodBeat.o(230568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.h
 * JD-Core Version:    0.7.0.1
 */
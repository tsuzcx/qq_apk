package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class h
  implements d, Comparator<f>
{
  private long aGT;
  public volatile long bvX;
  private final TreeSet<f> bvY;
  
  public h(long paramLong)
  {
    AppMethodBeat.i(194181);
    this.bvX = paramLong;
    this.bvY = new TreeSet(this);
    AppMethodBeat.o(194181);
  }
  
  private void b(a parama, long paramLong)
  {
    AppMethodBeat.i(194185);
    while ((this.aGT + paramLong > this.bvX) && (!this.bvY.isEmpty())) {
      parama.b((f)this.bvY.first());
    }
    AppMethodBeat.o(194185);
  }
  
  public final void a(a parama, long paramLong)
  {
    AppMethodBeat.i(194182);
    b(parama, paramLong);
    AppMethodBeat.o(194182);
  }
  
  public final void a(a parama, f paramf)
  {
    AppMethodBeat.i(194183);
    this.bvY.add(paramf);
    this.aGT += paramf.length;
    b(parama, 0L);
    AppMethodBeat.o(194183);
  }
  
  public final void c(f paramf)
  {
    AppMethodBeat.i(194184);
    this.bvY.remove(paramf);
    this.aGT -= paramf.length;
    AppMethodBeat.o(194184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.h
 * JD-Core Version:    0.7.0.1
 */
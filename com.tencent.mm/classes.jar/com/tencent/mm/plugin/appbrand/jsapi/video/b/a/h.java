package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class h
  implements d, Comparator<f>
{
  public volatile long djK;
  private final TreeSet<f> djL;
  private long djM;
  
  public h(long paramLong)
  {
    AppMethodBeat.i(328302);
    this.djK = paramLong;
    this.djL = new TreeSet(this);
    AppMethodBeat.o(328302);
  }
  
  private void b(a parama, long paramLong)
  {
    AppMethodBeat.i(328312);
    while ((this.djM + paramLong > this.djK) && (!this.djL.isEmpty())) {
      parama.b((f)this.djL.first());
    }
    AppMethodBeat.o(328312);
  }
  
  public final void a(a parama, long paramLong)
  {
    AppMethodBeat.i(328319);
    b(parama, paramLong);
    AppMethodBeat.o(328319);
  }
  
  public final void a(a parama, f paramf)
  {
    AppMethodBeat.i(328327);
    this.djL.add(paramf);
    this.djM += paramf.length;
    b(parama, 0L);
    AppMethodBeat.o(328327);
  }
  
  public final void c(f paramf)
  {
    AppMethodBeat.i(328333);
    this.djL.remove(paramf);
    this.djM -= paramf.length;
    AppMethodBeat.o(328333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.h
 * JD-Core Version:    0.7.0.1
 */
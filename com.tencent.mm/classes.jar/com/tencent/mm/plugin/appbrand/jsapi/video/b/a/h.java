package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import java.util.TreeSet;

public final class h
  implements d, Comparator<f>
{
  private long aIK;
  public volatile long bGl;
  private final TreeSet<f> bGm;
  
  public h(long paramLong)
  {
    AppMethodBeat.i(205993);
    this.bGl = paramLong;
    this.bGm = new TreeSet(this);
    AppMethodBeat.o(205993);
  }
  
  private void b(a parama, long paramLong)
  {
    AppMethodBeat.i(205997);
    while ((this.aIK + paramLong > this.bGl) && (!this.bGm.isEmpty())) {
      parama.b((f)this.bGm.first());
    }
    AppMethodBeat.o(205997);
  }
  
  public final void a(a parama, long paramLong)
  {
    AppMethodBeat.i(205994);
    b(parama, paramLong);
    AppMethodBeat.o(205994);
  }
  
  public final void a(a parama, f paramf)
  {
    AppMethodBeat.i(205995);
    this.bGm.add(paramf);
    this.aIK += paramf.length;
    b(parama, 0L);
    AppMethodBeat.o(205995);
  }
  
  public final void c(f paramf)
  {
    AppMethodBeat.i(205996);
    this.bGm.remove(paramf);
    this.aIK -= paramf.length;
    AppMethodBeat.o(205996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.h
 * JD-Core Version:    0.7.0.1
 */
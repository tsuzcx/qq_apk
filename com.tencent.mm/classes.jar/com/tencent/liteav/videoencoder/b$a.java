package com.tencent.liteav.videoencoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

class b$a
  extends TimerTask
{
  private WeakReference<b> a;
  
  public b$a(b paramb)
  {
    AppMethodBeat.i(67410);
    this.a = new WeakReference(paramb);
    AppMethodBeat.o(67410);
  }
  
  public void run()
  {
    AppMethodBeat.i(67411);
    if (this.a == null)
    {
      AppMethodBeat.o(67411);
      return;
    }
    b localb = (b)this.a.get();
    if (localb == null)
    {
      AppMethodBeat.o(67411);
      return;
    }
    if (b.i(localb) < b.j(localb))
    {
      int[] arrayOfInt = com.tencent.liteav.basic.util.b.a();
      b.k(localb);
      b.a(localb, b.l(localb) + arrayOfInt[0] / 10);
      float f = b.m(localb);
      b.b(localb, arrayOfInt[1] / 10 + f);
      b.c(localb, (float)(b.n(localb) + localb.b() * 100.0D / b.h(localb).fps));
      AppMethodBeat.o(67411);
      return;
    }
    if ((com.tencent.liteav.basic.e.b.a().a(b.l(localb) / b.j(localb), b.m(localb) / b.j(localb), b.n(localb) / b.j(localb))) && (com.tencent.liteav.basic.e.b.a().c() != 0)) {
      b.o(localb);
    }
    b.p(localb);
    AppMethodBeat.o(67411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.util.a;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

class b$a
  extends TimerTask
{
  private WeakReference<b> a;
  
  public b$a(b paramb)
  {
    this.a = new WeakReference(paramb);
  }
  
  public void run()
  {
    if (this.a == null) {}
    b localb;
    do
    {
      return;
      localb = (b)this.a.get();
    } while (localb == null);
    if (b.i(localb) < b.j(localb))
    {
      int[] arrayOfInt = a.a();
      b.k(localb);
      b.a(localb, b.l(localb) + arrayOfInt[0] / 10);
      float f = b.m(localb);
      b.b(localb, arrayOfInt[1] / 10 + f);
      b.c(localb, b.n(localb) + (float)(localb.b() * 100L / b.c(localb).fps));
      return;
    }
    if ((com.tencent.liteav.basic.e.b.a().a(b.l(localb) / b.j(localb), b.m(localb) / b.j(localb), b.n(localb) / b.j(localb))) && (com.tencent.liteav.basic.e.b.a().c() != 0)) {
      b.o(localb);
    }
    b.p(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.a
 * JD-Core Version:    0.7.0.1
 */
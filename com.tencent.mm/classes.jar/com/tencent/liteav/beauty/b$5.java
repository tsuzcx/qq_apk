package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.beauty.b.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

class b$5
  implements Runnable
{
  b$5(b paramb, float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3) {}
  
  public void run()
  {
    AppMethodBeat.i(66892);
    if (b.a(this.f) != null) {
      a.a().d();
    }
    if ((b.h(this.f) == null) && (b.i(this.f) == null))
    {
      if (b.a(this.f) != null)
      {
        b.a(this.f).d();
        b.a(this.f, null);
        AppMethodBeat.o(66892);
      }
    }
    else
    {
      if (b.a(this.f) == null)
      {
        b.a(this.f, b.f(this.f), b.g(this.f), b.j(this.f), b.h(this.f), b.k(this.f), b.i(this.f), b.l(this.f));
        AppMethodBeat.o(66892);
        return;
      }
      b.a(this.f).a(this.a, this.b, this.c, this.d, this.e);
    }
    AppMethodBeat.o(66892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.5
 * JD-Core Version:    0.7.0.1
 */
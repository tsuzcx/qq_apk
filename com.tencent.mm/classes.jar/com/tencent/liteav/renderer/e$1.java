package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

class e$1
  implements Runnable
{
  e$1(e parame, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    AppMethodBeat.i(67305);
    this.c.l = this.a;
    this.c.m = this.b;
    if (e.a(this.c) != null) {
      e.a(this.c).a(e.b(this.c)[0], false, 0, this.c.l, this.c.m, e.b(this.c)[1], e.b(this.c)[2], true);
    }
    AppMethodBeat.o(67305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.renderer.e.1
 * JD-Core Version:    0.7.0.1
 */
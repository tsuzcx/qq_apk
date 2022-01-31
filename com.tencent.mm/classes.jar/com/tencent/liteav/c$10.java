package com.tencent.liteav;

import com.tencent.liteav.videoencoder.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

class c$10
  implements Runnable
{
  c$10(c paramc, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    AppMethodBeat.i(146866);
    if ((this.a != 0) && (this.b != 0))
    {
      c.c(this.d).a = this.a;
      c.c(this.d).b = this.b;
      if (c.e(this.d) != null) {
        c.e(this.d).a(this.a, this.b);
      }
    }
    if ((this.c != 0) && (c.a(this.d) != null))
    {
      c.c(this.d).c = this.c;
      c.a(this.d).b(this.c);
    }
    AppMethodBeat.o(146866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.c.10
 * JD-Core Version:    0.7.0.1
 */
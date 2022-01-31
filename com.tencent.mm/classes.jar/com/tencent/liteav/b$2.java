package com.tencent.liteav;

import com.tencent.liteav.capturer.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public void run()
  {
    AppMethodBeat.i(67089);
    if (b.c(this.a) != -1)
    {
      b.a(this.a, b.c(this.a));
      b.b(this.a, -1);
    }
    if (b.d(this.a) != -1)
    {
      b.a(this.a).l = b.d(this.a);
      b.b(this.a).d(b.a(this.a).l);
      b.c(this.a, -1);
    }
    AppMethodBeat.o(67089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.b.2
 * JD-Core Version:    0.7.0.1
 */
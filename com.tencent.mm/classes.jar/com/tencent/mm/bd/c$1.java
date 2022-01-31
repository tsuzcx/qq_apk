package com.tencent.mm.bd;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements am.a
{
  c$1(c paramc) {}
  
  public final boolean tC()
  {
    y.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
    if (c.a(this.eyn) != null) {
      g.DO().dJT.c(c.a(this.eyn));
    }
    c.b(this.eyn);
    c.c(this.eyn);
    synchronized (c.d(this.eyn))
    {
      c.d(this.eyn).notifyAll();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bd.c.1
 * JD-Core Version:    0.7.0.1
 */
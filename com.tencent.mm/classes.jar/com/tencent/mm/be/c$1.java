package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$1
  implements ap.a
{
  c$1(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(78555);
    ab.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
    if (c.a(this.fOa) != null) {
      g.RK().eHt.a(c.a(this.fOa));
    }
    c.b(this.fOa);
    c.c(this.fOa);
    synchronized (c.d(this.fOa))
    {
      c.d(this.fOa).notifyAll();
      AppMethodBeat.o(78555);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.be.c.1
 * JD-Core Version:    0.7.0.1
 */
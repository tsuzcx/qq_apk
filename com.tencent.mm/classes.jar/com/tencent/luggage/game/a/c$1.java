package com.tencent.luggage.game.a;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.s;

final class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(140325);
    if (this.bzQ.bzI == null)
    {
      AppMethodBeat.o(140325);
      return;
    }
    synchronized (this.bzQ)
    {
      if (this.bzQ.bzI == null)
      {
        AppMethodBeat.o(140325);
        return;
      }
      if (this.bzQ.bzL == null)
      {
        AppMethodBeat.o(140325);
        return;
      }
      s locals = (s)this.bzQ.bzL.v(s.class);
      this.bzQ.bzI.bindTo(locals.getIsolatePtr(), locals.aGD());
      AppMethodBeat.o(140325);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.a.c.1
 * JD-Core Version:    0.7.0.1
 */
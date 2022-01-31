package com.tencent.luggage.game.a;

import com.tencent.magicbrush.handler.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.n;

final class c$c
  implements a
{
  private n bzR;
  
  private c$c(i parami)
  {
    AppMethodBeat.i(140329);
    this.bzR = ((n)parami.v(n.class));
    AppMethodBeat.o(140329);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(140330);
    this.bzR.post(paramRunnable);
    AppMethodBeat.o(140330);
  }
  
  public final boolean uB()
  {
    AppMethodBeat.i(140331);
    boolean bool = this.bzR.uB();
    AppMethodBeat.o(140331);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.a.c.c
 * JD-Core Version:    0.7.0.1
 */
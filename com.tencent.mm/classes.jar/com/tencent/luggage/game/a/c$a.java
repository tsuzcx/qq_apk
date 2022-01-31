package com.tencent.luggage.game.a;

import com.tencent.magicbrush.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.m.a;

public final class c$a
  extends b
  implements m.a
{
  c$a(c paramc, Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(140327);
    run();
    AppMethodBeat.o(140327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.a.c.a
 * JD-Core Version:    0.7.0.1
 */
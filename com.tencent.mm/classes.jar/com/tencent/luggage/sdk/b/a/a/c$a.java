package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.m.a;

final class c$a
  extends b
  implements m.a
{
  c$a(c paramc, Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(140711);
    run();
    AppMethodBeat.o(140711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */
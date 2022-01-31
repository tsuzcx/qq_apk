package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.m.a;

final class a$a
  extends b
  implements m.a
{
  a$a(a parama, Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(140701);
    run();
    AppMethodBeat.o(140701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */
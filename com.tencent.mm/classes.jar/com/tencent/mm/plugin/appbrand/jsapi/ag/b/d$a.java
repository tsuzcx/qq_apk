package com.tencent.mm.plugin.appbrand.jsapi.ag.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.l;
import com.tencent.mm.plugin.appbrand.m.m.a;

final class d$a
  extends l
  implements m.a
{
  d$a(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(215822);
    run();
    AppMethodBeat.o(215822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.a
 * JD-Core Version:    0.7.0.1
 */
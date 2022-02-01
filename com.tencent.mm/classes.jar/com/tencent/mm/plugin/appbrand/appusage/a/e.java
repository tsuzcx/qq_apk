package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"runOnWorkThread", "", "action", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final void v(a<x> parama)
  {
    AppMethodBeat.i(50331);
    p.h(parama, "action");
    m.bZn().postToWorker((Runnable)new a(parama));
    AppMethodBeat.o(50331);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50330);
      this.kXn.invoke();
      AppMethodBeat.o(50330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.e
 * JD-Core Version:    0.7.0.1
 */
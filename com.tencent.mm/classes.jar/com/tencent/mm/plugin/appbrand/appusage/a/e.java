package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"runOnWorkThread", "", "action", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final void t(a<z> parama)
  {
    AppMethodBeat.i(50331);
    p.h(parama, "action");
    m.bCj().postToWorker((Runnable)new a(parama));
    AppMethodBeat.o(50331);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50330);
      this.jUr.invoke();
      AppMethodBeat.o(50330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.e
 * JD-Core Version:    0.7.0.1
 */
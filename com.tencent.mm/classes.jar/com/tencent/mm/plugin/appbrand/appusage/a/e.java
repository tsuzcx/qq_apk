package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.l.a;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"runOnWorkThread", "", "action", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final void r(a<y> parama)
  {
    AppMethodBeat.i(50331);
    k.h(parama, "action");
    com.tencent.mm.plugin.appbrand.z.l.bxj().postToWorker((Runnable)new a(parama));
    AppMethodBeat.o(50331);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50330);
      this.jxd.invoke();
      AppMethodBeat.o(50330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.e
 * JD-Core Version:    0.7.0.1
 */
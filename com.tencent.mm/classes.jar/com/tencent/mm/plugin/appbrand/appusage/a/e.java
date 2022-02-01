package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"runOnWorkThread", "", "action", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final void s(a<z> parama)
  {
    AppMethodBeat.i(50331);
    p.h(parama, "action");
    m.bBp().postToWorker((Runnable)new a(parama));
    AppMethodBeat.o(50331);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50330);
      this.jQZ.invoke();
      AppMethodBeat.o(50330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.e
 * JD-Core Version:    0.7.0.1
 */
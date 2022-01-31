package com.tencent.mm.plugin.appbrand.appusage.a;

import a.f.a.a;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"runOnWorkThread", "", "action", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class e
{
  public static final void f(a<y> parama)
  {
    AppMethodBeat.i(134594);
    j.q(parama, "action");
    m.aNS().ac((Runnable)new a(parama));
    AppMethodBeat.o(134594);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(134593);
      this.hdx.invoke();
      AppMethodBeat.o(134593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.e
 * JD-Core Version:    0.7.0.1
 */
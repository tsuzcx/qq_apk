package com.tencent.mm.plugin.expt.hellhound;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.expt.a.b.b;
import com.tencent.mm.plugin.expt.a.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.a.d;
import com.tencent.mm.plugin.expt.hellhound.core.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  implements com.tencent.mm.plugin.expt.a.b
{
  private static final b.a lZA;
  
  static
  {
    AppMethodBeat.i(152251);
    lZA = new b.4();
    AppMethodBeat.o(152251);
  }
  
  public static void d(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(73338);
    if (paramg == null)
    {
      AppMethodBeat.o(73338);
      return;
    }
    if (!a.brn())
    {
      ab.w("HellhoundService", "habbyge-mali, IHellhoundService Close !!!");
      AppMethodBeat.o(73338);
      return;
    }
    ab.i("HellhoundService", "habbyge-mali, IHellhoundService Start !!!");
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.expt.a.b.class, new b());
    com.tencent.mm.plugin.expt.a.b localb = (com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.b.class);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.b.a.c.bsb();
    com.tencent.mm.sdk.b.a.ymk.b(((com.tencent.mm.plugin.expt.hellhound.a.b.a.c)localObject).maU);
    localObject = d.bsf();
    com.tencent.mm.sdk.b.a.ymk.b(((d)localObject).maX);
    localb.a(lZA);
    localb.a(new b.1());
    com.tencent.mm.plugin.expt.hellhound.core.a.brr();
    com.tencent.mm.plugin.expt.hellhound.core.a.a(new b.2());
    localb.a(new b.3());
    localb.g(paramg.bX);
    com.tencent.mm.plugin.expt.hellhound.a.a.c.s(104, "", "");
    AppMethodBeat.o(73338);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(73339);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.brr();
    if (com.tencent.mm.plugin.expt.hellhound.core.a.brs()) {
      locala.lZC.a(parama);
    }
    AppMethodBeat.o(73339);
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(152250);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.brr();
    if (com.tencent.mm.plugin.expt.hellhound.core.a.brs()) {
      locala.lZD.b(paramb);
    }
    AppMethodBeat.o(152250);
  }
  
  public final void a(b.c paramc)
  {
    AppMethodBeat.i(73340);
    com.tencent.mm.plugin.expt.hellhound.a.a.c.brV().maE = paramc;
    AppMethodBeat.o(73340);
  }
  
  public final void g(Application paramApplication)
  {
    AppMethodBeat.i(73341);
    com.tencent.mm.plugin.expt.hellhound.core.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.brr();
    ab.i("Hellhound", "habbyge-Hellhound.startMonitor()");
    if (com.tencent.mm.plugin.expt.hellhound.core.a.brs()) {
      locala.lZC.h(paramApplication);
    }
    AppMethodBeat.o(73341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b
 * JD-Core Version:    0.7.0.1
 */
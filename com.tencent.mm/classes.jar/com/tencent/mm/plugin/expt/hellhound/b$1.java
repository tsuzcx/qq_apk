package com.tencent.mm.plugin.expt.hellhound;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dr;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.b.d.c;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.g.e;
import com.tencent.mm.plugin.expt.hellhound.a.f.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.sdk.platformtools.ad;

final class b$1
  implements d.c
{
  public final void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(210298);
    ad.i("HABBYGE-MALI.HellhoundService", "frontToBackMMProcessEnd: %s, %d", new Object[] { paramString, Integer.valueOf(paramInt2) });
    paramInt1 = com.tencent.mm.d.j.eZ(String.valueOf(paramInt1));
    Object localObject = e.a.qPi;
    dr localdr = new dr();
    localdr.dXl = paramInt2;
    localdr = localdr.nb(((h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName).nc(paramString);
    localdr.egV = paramInt3;
    localdr.dYD = ((e.a)localObject).value;
    localObject = localdr.jS(paramLong);
    ((dr)localObject).eeA = paramInt1;
    e.crp().a((dr)localObject);
    ad.i("HABBYGE-MALI.HellFrontBackReport", "[进程尾部补偿8] frontback-pure-report [%s]", new Object[] { ((dr)localObject).RE() });
    com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(paramString, paramLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYD);
    com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a("UNDEFINED", paramLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYE);
    b.cpE();
    b.cpF();
    m.reset();
    l.reset();
    AppMethodBeat.o(210298);
  }
  
  public final void j(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210296);
    ad.i("HABBYGE-MALI.HellhoundService", "HellhoundService, backToFront: %s", new Object[] { paramString });
    com.tencent.mm.plugin.expt.hellhound.a.b.b.j.o(paramString, paramInt, paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramString, com.tencent.mm.d.j.eZ(String.valueOf(paramInt)), paramLong, e.a.qPh);
    b.cpE().a(paramString, paramInt, paramLong, 7);
    com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramString, Integer.valueOf(paramInt), 2);
    AppMethodBeat.o(210296);
  }
  
  public final void k(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210297);
    ad.i("HABBYGE-MALI.HellhoundService", "HellhoundService, frontToBack: %s", new Object[] { paramString });
    com.tencent.mm.plugin.expt.hellhound.a.b.b.j.n(paramString, paramInt, paramLong);
    com.tencent.mm.plugin.expt.hellhound.a.c.d.a(paramString, com.tencent.mm.d.j.eZ(String.valueOf(paramInt)), paramLong, e.a.qPi);
    com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu.a(paramString, paramLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.qYD);
    b.cpE().a(paramString, paramInt, paramLong, 8);
    com.tencent.mm.plugin.expt.hellhound.a.b.a.a(paramString, Integer.valueOf(paramInt), 3);
    AppMethodBeat.o(210297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.1
 * JD-Core Version:    0.7.0.1
 */
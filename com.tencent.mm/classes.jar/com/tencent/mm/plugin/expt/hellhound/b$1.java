package com.tencent.mm.plugin.expt.hellhound;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.expt.a.b.c;
import com.tencent.mm.plugin.expt.a.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class b$1
  implements b.c
{
  public final void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(152229);
    ab.i("HellhoundService", "habbyge-mali, frontToBackMMProcessEnd: " + paramString1 + "/" + paramInt1);
    int i = Integer.valueOf(paramString2).intValue();
    paramString2 = c.a.lZu;
    Object localObject = new y();
    ((y)localObject).cRR = paramInt1;
    paramString1 = ((y)localObject).fu(((h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName).fv(paramString1);
    paramString1.cTR = paramInt2;
    paramString1.cSH = paramString2.value;
    paramString1 = paramString1.by(paramLong);
    paramString1.cSJ = i;
    com.tencent.mm.plugin.expt.c.e.bsT().a(paramString1);
    ab.i("HellFrontBackReport", "habbyge-mali, [进程尾部补偿8] frontback-pure-report [%s]", new Object[] { paramString1.Fg() });
    paramString1 = b.brY();
    if (b.brZ())
    {
      ab.i("HellSessionMonitor", "habbyge-mali, HellSessionMonitor, handleMMProcessRestart: FALSE");
      AppMethodBeat.o(152229);
      return;
    }
    ab.i("HellSessionMonitor", "HABBYGE-MALI, handleMMProcessRestart");
    paramString2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsk();
    if ((paramString2 != null) && ((!paramString2.xkm.isEmpty()) || (!paramString2.xkk.isEmpty())))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.a.reset();
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.bsu();
      if ((localObject == null) || (((aux)localObject).fjy.isEmpty()))
      {
        AppMethodBeat.o(152229);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.reset();
      com.tencent.mm.sdk.g.d.ysm.execute(new com.tencent.mm.plugin.expt.hellhound.a.b.b.1(paramString1, paramString2, (aux)localObject));
    }
    AppMethodBeat.o(152229);
  }
  
  public final void ee(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152227);
    ab.i("HellhoundService", "habbyge-mali, HellhoundService, backToFront: ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.expt.hellhound.a.a.d.a(paramString1, Integer.valueOf(paramString2).intValue(), c.a.lZt);
    b.brY().cg(paramString1, 7);
    AppMethodBeat.o(152227);
  }
  
  public final void ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152228);
    ab.i("HellhoundService", "habbyge-mali, HellhoundService, frontToBack: ".concat(String.valueOf(paramString1)));
    com.tencent.mm.plugin.expt.hellhound.a.a.d.a(paramString1, Integer.valueOf(paramString2).intValue(), c.a.lZu);
    b.brY().cg(paramString1, 8);
    AppMethodBeat.o(152228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.1
 * JD-Core Version:    0.7.0.1
 */
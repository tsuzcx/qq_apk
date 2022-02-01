package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vending.g.b;

public final class e
  implements com.tencent.mm.ak.g
{
  private static int izu = 20;
  private static int izv = 20;
  private static int izw = 20;
  private static long izx = 4000000L;
  private static long izy = 200000L;
  public String izA = "";
  b izm;
  public String izz = "";
  
  public e() {}
  
  public e(String paramString1, String paramString2)
  {
    this.izz = paramString1;
    this.izA = paramString2;
  }
  
  public static void a(l paraml)
  {
    AppMethodBeat.i(63330);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJU, Integer.valueOf(paraml.iAs));
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJV, Integer.valueOf(paraml.iAt));
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJW, Integer.valueOf(paraml.iAu));
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJX, Long.valueOf(paraml.iAv));
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJY, Long.valueOf(paraml.iAw));
    AppMethodBeat.o(63330);
  }
  
  public static int aNQ()
  {
    AppMethodBeat.i(63326);
    com.tencent.mm.kernel.g.agS();
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GJU, Integer.valueOf(izu))).intValue();
    AppMethodBeat.o(63326);
    return i;
  }
  
  public static int aNR()
  {
    AppMethodBeat.i(63327);
    com.tencent.mm.kernel.g.agS();
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GJW, Integer.valueOf(izw))).intValue();
    AppMethodBeat.o(63327);
    return i;
  }
  
  public static long aNS()
  {
    AppMethodBeat.i(63328);
    com.tencent.mm.kernel.g.agS();
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GJY, Long.valueOf(izy))).longValue();
    AppMethodBeat.o(63328);
    return l;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(63329);
    ac.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.h)paramn).iAl;
      ac.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(paramString.dae), paramString.oxf, Integer.valueOf(paramString.iAs), Integer.valueOf(paramString.iAt), Integer.valueOf(paramString.iAu), Long.valueOf(paramString.iAv), Long.valueOf(paramString.iAw), paramString.iAx, paramString.iAy });
      if (paramString.dae == 0)
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJU, Integer.valueOf(paramString.iAs));
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJV, Integer.valueOf(paramString.iAt));
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJW, Integer.valueOf(paramString.iAu));
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJX, Long.valueOf(paramString.iAv));
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJY, Long.valueOf(paramString.iAw));
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(407L, 33L, 1L, false);
        com.tencent.mm.vending.g.g.a(this.izm, new Object[] { new e(paramString.iAy, paramString.iAx) });
        AppMethodBeat.o(63329);
        return;
      }
      com.tencent.mm.vending.g.g.fxn().eb(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(407L, 35L, 1L, false);
      AppMethodBeat.o(63329);
      return;
    }
    com.tencent.mm.vending.g.g.fxn().eb(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(407L, 34L, 1L, false);
    AppMethodBeat.o(63329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.e
 * JD-Core Version:    0.7.0.1
 */
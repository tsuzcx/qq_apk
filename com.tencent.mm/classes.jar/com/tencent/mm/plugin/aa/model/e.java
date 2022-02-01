package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.plugin.aa.model.cgi.h;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vending.g.b;

public final class e
  implements f
{
  private static long iVA = 200000L;
  private static int iVw = 20;
  private static int iVx = 20;
  private static int iVy = 20;
  private static long iVz = 4000000L;
  public String iVB = "";
  public String iVC = "";
  b iVo;
  
  public e() {}
  
  public e(String paramString1, String paramString2)
  {
    this.iVB = paramString1;
    this.iVC = paramString2;
  }
  
  public static void a(l paraml)
  {
    AppMethodBeat.i(63330);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQK, Integer.valueOf(paraml.iWv));
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQL, Integer.valueOf(paraml.iWw));
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQM, Integer.valueOf(paraml.iWx));
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQN, Long.valueOf(paraml.iWy));
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQO, Long.valueOf(paraml.iWz));
    AppMethodBeat.o(63330);
  }
  
  public static int aRB()
  {
    AppMethodBeat.i(63326);
    com.tencent.mm.kernel.g.ajS();
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQK, Integer.valueOf(iVw))).intValue();
    AppMethodBeat.o(63326);
    return i;
  }
  
  public static int aRC()
  {
    AppMethodBeat.i(63327);
    com.tencent.mm.kernel.g.ajS();
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQM, Integer.valueOf(iVy))).intValue();
    AppMethodBeat.o(63327);
    return i;
  }
  
  public static long aRD()
  {
    AppMethodBeat.i(63328);
    com.tencent.mm.kernel.g.ajS();
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQO, Long.valueOf(iVA))).longValue();
    AppMethodBeat.o(63328);
    return l;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(63329);
    ae.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((h)paramn).iWo;
      ae.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(paramString.dmy), paramString.phe, Integer.valueOf(paramString.iWv), Integer.valueOf(paramString.iWw), Integer.valueOf(paramString.iWx), Long.valueOf(paramString.iWy), Long.valueOf(paramString.iWz), paramString.iWA, paramString.iWB });
      if (paramString.dmy == 0)
      {
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQK, Integer.valueOf(paramString.iWv));
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQL, Integer.valueOf(paramString.iWw));
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQM, Integer.valueOf(paramString.iWx));
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQN, Long.valueOf(paramString.iWy));
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQO, Long.valueOf(paramString.iWz));
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 33L, 1L, false);
        com.tencent.mm.vending.g.g.a(this.iVo, new Object[] { new e(paramString.iWB, paramString.iWA) });
        AppMethodBeat.o(63329);
        return;
      }
      com.tencent.mm.vending.g.g.fSv().ef(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 35L, 1L, false);
      AppMethodBeat.o(63329);
      return;
    }
    com.tencent.mm.vending.g.g.fSv().ef(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(407L, 34L, 1L, false);
    AppMethodBeat.o(63329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.e
 * JD-Core Version:    0.7.0.1
 */
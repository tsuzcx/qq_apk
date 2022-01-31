package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vending.g.b;

public final class d
  implements com.tencent.mm.ai.f
{
  private static int gnH = 20;
  private static int gnI = 20;
  private static int gnJ = 20;
  private static long gnK = 4000000L;
  private static long gnL = 200000L;
  b gnD;
  public String gnM = "";
  public String gnN = "";
  
  public d() {}
  
  private d(String paramString1, String paramString2)
  {
    this.gnM = paramString1;
    this.gnN = paramString2;
  }
  
  public static int aoL()
  {
    AppMethodBeat.i(40598);
    g.RM();
    int i = ((Integer)g.RL().Ru().get(ac.a.yDH, Integer.valueOf(gnH))).intValue();
    AppMethodBeat.o(40598);
    return i;
  }
  
  public static int aoM()
  {
    AppMethodBeat.i(40599);
    g.RM();
    int i = ((Integer)g.RL().Ru().get(ac.a.yDJ, Integer.valueOf(gnJ))).intValue();
    AppMethodBeat.o(40599);
    return i;
  }
  
  public static long aoN()
  {
    AppMethodBeat.i(40600);
    g.RM();
    long l = ((Long)g.RL().Ru().get(ac.a.yDL, Long.valueOf(gnL))).longValue();
    AppMethodBeat.o(40600);
    return l;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(40601);
    ab.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.a.a.h)paramm).gox;
      ab.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(paramString.cnK), paramString.kNv, Integer.valueOf(paramString.wkk), Integer.valueOf(paramString.wkl), Integer.valueOf(paramString.wkm), Long.valueOf(paramString.wkn), Long.valueOf(paramString.wko), paramString.kNG, paramString.kNH });
      if (paramString.cnK == 0)
      {
        g.RM();
        g.RL().Ru().set(ac.a.yDH, Integer.valueOf(paramString.wkk));
        g.RM();
        g.RL().Ru().set(ac.a.yDI, Integer.valueOf(paramString.wkl));
        g.RM();
        g.RL().Ru().set(ac.a.yDJ, Integer.valueOf(paramString.wkm));
        g.RM();
        g.RL().Ru().set(ac.a.yDK, Long.valueOf(paramString.wkn));
        g.RM();
        g.RL().Ru().set(ac.a.yDL, Long.valueOf(paramString.wko));
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 33L, 1L, false);
        com.tencent.mm.vending.g.f.a(this.gnD, new Object[] { new d(paramString.kNH, paramString.kNG) });
        AppMethodBeat.o(40601);
        return;
      }
      com.tencent.mm.vending.g.f.dQn().cK(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 35L, 1L, false);
      AppMethodBeat.o(40601);
      return;
    }
    com.tencent.mm.vending.g.f.dQn().cK(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(407L, 34L, 1L, false);
    AppMethodBeat.o(40601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.d
 * JD-Core Version:    0.7.0.1
 */
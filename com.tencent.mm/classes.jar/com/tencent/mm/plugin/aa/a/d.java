package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vending.g.b;

public final class d
  implements com.tencent.mm.ah.f
{
  private static int eVK = 20;
  private static int eVL = 20;
  private static int eVM = 20;
  private static long eVN = 4000000L;
  private static long eVO = 200000L;
  b eVG;
  public String eVP = "";
  public String eVQ = "";
  
  public d() {}
  
  private d(String paramString1, String paramString2)
  {
    this.eVP = paramString1;
    this.eVQ = paramString2;
  }
  
  public static int Vn()
  {
    g.DQ();
    return ((Integer)g.DP().Dz().get(ac.a.utE, Integer.valueOf(eVK))).intValue();
  }
  
  public static int Vo()
  {
    g.DQ();
    return ((Integer)g.DP().Dz().get(ac.a.utG, Integer.valueOf(eVM))).intValue();
  }
  
  public static long Vp()
  {
    g.DQ();
    return ((Long)g.DP().Dz().get(ac.a.utI, Long.valueOf(eVO))).longValue();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.a.a.h)paramm).eWz;
      y.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(paramString.iHq), paramString.iHr, Integer.valueOf(paramString.srE), Integer.valueOf(paramString.srF), Integer.valueOf(paramString.srG), Long.valueOf(paramString.srH), Long.valueOf(paramString.srI), paramString.iHC, paramString.iHD });
      if (paramString.iHq == 0)
      {
        g.DQ();
        g.DP().Dz().c(ac.a.utE, Integer.valueOf(paramString.srE));
        g.DQ();
        g.DP().Dz().c(ac.a.utF, Integer.valueOf(paramString.srF));
        g.DQ();
        g.DP().Dz().c(ac.a.utG, Integer.valueOf(paramString.srG));
        g.DQ();
        g.DP().Dz().c(ac.a.utH, Long.valueOf(paramString.srH));
        g.DQ();
        g.DP().Dz().c(ac.a.utI, Long.valueOf(paramString.srI));
        com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 33L, 1L, false);
        com.tencent.mm.vending.g.f.a(this.eVG, new Object[] { new d(paramString.iHD, paramString.iHC) });
        return;
      }
      com.tencent.mm.vending.g.f.cKX().cg(Boolean.valueOf(false));
      com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 35L, 1L, false);
      return;
    }
    com.tencent.mm.vending.g.f.cKX().cg(Boolean.valueOf(false));
    com.tencent.mm.plugin.report.service.h.nFQ.a(407L, 34L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.d
 * JD-Core Version:    0.7.0.1
 */
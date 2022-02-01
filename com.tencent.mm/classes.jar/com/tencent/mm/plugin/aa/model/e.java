package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class e
  implements com.tencent.mm.an.i
{
  private static int mJD = 20;
  private static int mJE = 20;
  private static int mJF = 20;
  private static long mJG = 4000000L;
  private static long mJH = 200000L;
  public String mJI = "";
  public String mJJ = "";
  b mJv;
  
  public e() {}
  
  public e(String paramString1, String paramString2)
  {
    this.mJI = paramString1;
    this.mJJ = paramString2;
  }
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(63330);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmL, Integer.valueOf(paramo.mKG));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmM, Integer.valueOf(paramo.mKH));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmN, Integer.valueOf(paramo.mKI));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmO, Long.valueOf(paramo.mKJ));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmP, Long.valueOf(paramo.mKK));
    AppMethodBeat.o(63330);
  }
  
  public static int bwn()
  {
    AppMethodBeat.i(63326);
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmL, Integer.valueOf(mJD))).intValue();
    AppMethodBeat.o(63326);
    return i;
  }
  
  public static int bwo()
  {
    AppMethodBeat.i(63327);
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmN, Integer.valueOf(mJF))).intValue();
    AppMethodBeat.o(63327);
    return i;
  }
  
  public static long bwp()
  {
    AppMethodBeat.i(63328);
    com.tencent.mm.kernel.h.aHH();
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmP, Long.valueOf(mJH))).longValue();
    AppMethodBeat.o(63328);
    return l;
  }
  
  public static int bwq()
  {
    AppMethodBeat.i(271042);
    com.tencent.mm.kernel.h.aHH();
    int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VmQ, Integer.valueOf(2))).intValue();
    AppMethodBeat.o(271042);
    return i;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(63329);
    Log.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.i)paramq).mKz;
      Log.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s,response.default_mod:%s", new Object[] { Integer.valueOf(paramString.fwx), paramString.tVo, Integer.valueOf(paramString.mKG), Integer.valueOf(paramString.mKH), Integer.valueOf(paramString.mKI), Long.valueOf(paramString.mKJ), Long.valueOf(paramString.mKK), paramString.mKL, paramString.mKM, Integer.valueOf(paramString.RDA) });
      if (paramString.fwx == 0)
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmL, Integer.valueOf(paramString.mKG));
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmM, Integer.valueOf(paramString.mKH));
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmN, Integer.valueOf(paramString.mKI));
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmO, Long.valueOf(paramString.mKJ));
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmP, Long.valueOf(paramString.mKK));
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VmQ, Integer.valueOf(paramString.RDA));
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 33L, 1L, false);
        g.a(this.mJv, new Object[] { new e(paramString.mKM, paramString.mKL) });
        AppMethodBeat.o(63329);
        return;
      }
      g.ieE().eo(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 35L, 1L, false);
      AppMethodBeat.o(63329);
      return;
    }
    g.ieE().eo(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(407L, 34L, 1L, false);
    AppMethodBeat.o(63329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.e
 * JD-Core Version:    0.7.0.1
 */
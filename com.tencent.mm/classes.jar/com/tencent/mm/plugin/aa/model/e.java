package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.aa.model.cgi.h;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vending.g.b;

public final class e
  implements f
{
  private static int iSD = 20;
  private static int iSE = 20;
  private static int iSF = 20;
  private static long iSG = 4000000L;
  private static long iSH = 200000L;
  public String iSI = "";
  public String iSJ = "";
  b iSv;
  
  public e() {}
  
  public e(String paramString1, String paramString2)
  {
    this.iSI = paramString1;
    this.iSJ = paramString2;
  }
  
  public static void a(l paraml)
  {
    AppMethodBeat.i(63330);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwm, Integer.valueOf(paraml.iTC));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwn, Integer.valueOf(paraml.iTD));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwo, Integer.valueOf(paraml.iTE));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwp, Long.valueOf(paraml.iTF));
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwq, Long.valueOf(paraml.iTG));
    AppMethodBeat.o(63330);
  }
  
  public static int aRc()
  {
    AppMethodBeat.i(63326);
    com.tencent.mm.kernel.g.ajD();
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwm, Integer.valueOf(iSD))).intValue();
    AppMethodBeat.o(63326);
    return i;
  }
  
  public static int aRd()
  {
    AppMethodBeat.i(63327);
    com.tencent.mm.kernel.g.ajD();
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwo, Integer.valueOf(iSF))).intValue();
    AppMethodBeat.o(63327);
    return i;
  }
  
  public static long aRe()
  {
    AppMethodBeat.i(63328);
    com.tencent.mm.kernel.g.ajD();
    long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iwq, Long.valueOf(iSH))).longValue();
    AppMethodBeat.o(63328);
    return l;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(63329);
    ad.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((h)paramn).iTv;
      ad.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(paramString.dlw), paramString.paA, Integer.valueOf(paramString.iTC), Integer.valueOf(paramString.iTD), Integer.valueOf(paramString.iTE), Long.valueOf(paramString.iTF), Long.valueOf(paramString.iTG), paramString.iTH, paramString.iTI });
      if (paramString.dlw == 0)
      {
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwm, Integer.valueOf(paramString.iTC));
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwn, Integer.valueOf(paramString.iTD));
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwo, Integer.valueOf(paramString.iTE));
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwp, Long.valueOf(paramString.iTF));
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwq, Long.valueOf(paramString.iTG));
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 33L, 1L, false);
        com.tencent.mm.vending.g.g.a(this.iSv, new Object[] { new e(paramString.iTI, paramString.iTH) });
        AppMethodBeat.o(63329);
        return;
      }
      com.tencent.mm.vending.g.g.fOa().ee(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 35L, 1L, false);
      AppMethodBeat.o(63329);
      return;
    }
    com.tencent.mm.vending.g.g.fOa().ee(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(407L, 34L, 1L, false);
    AppMethodBeat.o(63329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.e
 * JD-Core Version:    0.7.0.1
 */
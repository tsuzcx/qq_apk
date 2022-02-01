package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vending.g.b;

public final class e
  implements com.tencent.mm.al.g
{
  private static int hZq = 20;
  private static int hZr = 20;
  private static int hZs = 20;
  private static long hZt = 4000000L;
  private static long hZu = 200000L;
  b hZi;
  public String hZv = "";
  public String hZw = "";
  
  public e() {}
  
  public e(String paramString1, String paramString2)
  {
    this.hZv = paramString1;
    this.hZw = paramString2;
  }
  
  public static void a(l paraml)
  {
    AppMethodBeat.i(63330);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fmf, Integer.valueOf(paraml.iap));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fmg, Integer.valueOf(paraml.iaq));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fmh, Integer.valueOf(paraml.iar));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fmi, Long.valueOf(paraml.ias));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fmj, Long.valueOf(paraml.iat));
    AppMethodBeat.o(63330);
  }
  
  public static int aHc()
  {
    AppMethodBeat.i(63326);
    com.tencent.mm.kernel.g.afC();
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fmf, Integer.valueOf(hZq))).intValue();
    AppMethodBeat.o(63326);
    return i;
  }
  
  public static int aHd()
  {
    AppMethodBeat.i(63327);
    com.tencent.mm.kernel.g.afC();
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fmh, Integer.valueOf(hZs))).intValue();
    AppMethodBeat.o(63327);
    return i;
  }
  
  public static long aHe()
  {
    AppMethodBeat.i(63328);
    com.tencent.mm.kernel.g.afC();
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fmj, Long.valueOf(hZu))).longValue();
    AppMethodBeat.o(63328);
    return l;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(63329);
    ad.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.h)paramn).iai;
      ad.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", new Object[] { Integer.valueOf(paramString.dcG), paramString.nTK, Integer.valueOf(paramString.iap), Integer.valueOf(paramString.iaq), Integer.valueOf(paramString.iar), Long.valueOf(paramString.ias), Long.valueOf(paramString.iat), paramString.iau, paramString.iav });
      if (paramString.dcG == 0)
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fmf, Integer.valueOf(paramString.iap));
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fmg, Integer.valueOf(paramString.iaq));
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fmh, Integer.valueOf(paramString.iar));
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fmi, Long.valueOf(paramString.ias));
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fmj, Long.valueOf(paramString.iat));
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(407L, 33L, 1L, false);
        com.tencent.mm.vending.g.g.a(this.hZi, new Object[] { new e(paramString.iav, paramString.iau) });
        AppMethodBeat.o(63329);
        return;
      }
      com.tencent.mm.vending.g.g.fhl().ea(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(407L, 35L, 1L, false);
      AppMethodBeat.o(63329);
      return;
    }
    com.tencent.mm.vending.g.g.fhl().ea(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(407L, 34L, 1L, false);
    AppMethodBeat.o(63329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.e
 * JD-Core Version:    0.7.0.1
 */
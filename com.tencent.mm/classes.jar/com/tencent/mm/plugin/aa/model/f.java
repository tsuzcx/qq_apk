package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.aa.model.cgi.i;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.protocal.protobuf.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class f
  implements com.tencent.mm.am.h
{
  private static int pGk = 20;
  private static int pGl = 20;
  private static int pGm = 20;
  private static long pGn = 4000000L;
  private static long pGo = 200000L;
  b pGe;
  private String pGp = "";
  private String pGq = "";
  public dus pGr;
  
  public f() {}
  
  public f(String paramString1, String paramString2)
  {
    this.pGp = paramString1;
    this.pGq = paramString2;
  }
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(63330);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acOg, Integer.valueOf(paramo.pHo));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acOh, Integer.valueOf(paramo.pHp));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acOi, Integer.valueOf(paramo.pHq));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acOj, Long.valueOf(paramo.pHr));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acOk, Long.valueOf(paramo.pHs));
    AppMethodBeat.o(63330);
  }
  
  public static int bVf()
  {
    AppMethodBeat.i(63326);
    com.tencent.mm.kernel.h.baF();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acOg, Integer.valueOf(pGk))).intValue();
    AppMethodBeat.o(63326);
    return i;
  }
  
  public static int bVg()
  {
    AppMethodBeat.i(63327);
    com.tencent.mm.kernel.h.baF();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acOi, Integer.valueOf(pGm))).intValue();
    AppMethodBeat.o(63327);
    return i;
  }
  
  public static long bVh()
  {
    AppMethodBeat.i(63328);
    com.tencent.mm.kernel.h.baF();
    long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acOk, Long.valueOf(pGo))).longValue();
    AppMethodBeat.o(63328);
    return l;
  }
  
  public static int bVi()
  {
    AppMethodBeat.i(268394);
    com.tencent.mm.kernel.h.baF();
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acOl, Integer.valueOf(2))).intValue();
    AppMethodBeat.o(268394);
    return i;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(63329);
    Log.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((i)paramp).pHh;
      Log.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s,response.default_mod:%s", new Object[] { Integer.valueOf(paramString.hAV), paramString.wYI, Integer.valueOf(paramString.pHo), Integer.valueOf(paramString.pHp), Integer.valueOf(paramString.pHq), Long.valueOf(paramString.pHr), Long.valueOf(paramString.pHs), paramString.pHt, paramString.pHu, Integer.valueOf(paramString.YAd) });
      if (paramString.hAV == 0)
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acOg, Integer.valueOf(paramString.pHo));
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acOh, Integer.valueOf(paramString.pHp));
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acOi, Integer.valueOf(paramString.pHq));
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acOj, Long.valueOf(paramString.pHr));
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acOk, Long.valueOf(paramString.pHs));
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acOl, Integer.valueOf(paramString.YAd));
        paramp = new f(paramString.pHu, paramString.pHt);
        paramp.pGr = paramString.ign;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 33L, 1L, false);
        g.a(this.pGe, new Object[] { paramp });
        AppMethodBeat.o(63329);
        return;
      }
      g.jJL().gM(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 35L, 1L, false);
      AppMethodBeat.o(63329);
      return;
    }
    g.jJL().gM(Boolean.FALSE);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(407L, 34L, 1L, false);
    AppMethodBeat.o(63329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.f
 * JD-Core Version:    0.7.0.1
 */
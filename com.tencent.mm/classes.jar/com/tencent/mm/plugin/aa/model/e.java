package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.n;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.g.b;

public final class e
  implements com.tencent.mm.ak.i
{
  private static int jSq = 20;
  private static int jSr = 20;
  private static int jSs = 20;
  private static long jSt = 4000000L;
  private static long jSu = 200000L;
  b jSi;
  public String jSv = "";
  public String jSw = "";
  
  public e() {}
  
  public e(String paramString1, String paramString2)
  {
    this.jSv = paramString1;
    this.jSw = paramString2;
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(63330);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYL, Integer.valueOf(paramn.jTs));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYM, Integer.valueOf(paramn.jTt));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYN, Integer.valueOf(paramn.jTu));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYO, Long.valueOf(paramn.jTv));
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYP, Long.valueOf(paramn.jTw));
    AppMethodBeat.o(63330);
  }
  
  public static int bmf()
  {
    AppMethodBeat.i(63326);
    com.tencent.mm.kernel.g.aAi();
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYL, Integer.valueOf(jSq))).intValue();
    AppMethodBeat.o(63326);
    return i;
  }
  
  public static int bmg()
  {
    AppMethodBeat.i(63327);
    com.tencent.mm.kernel.g.aAi();
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYN, Integer.valueOf(jSs))).intValue();
    AppMethodBeat.o(63327);
    return i;
  }
  
  public static long bmh()
  {
    AppMethodBeat.i(63328);
    com.tencent.mm.kernel.g.aAi();
    long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYP, Long.valueOf(jSu))).longValue();
    AppMethodBeat.o(63328);
    return l;
  }
  
  public static int bmi()
  {
    AppMethodBeat.i(212940);
    com.tencent.mm.kernel.g.aAi();
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYQ, Integer.valueOf(2))).intValue();
    AppMethodBeat.o(212940);
    return i;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63329);
    Log.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.aa.model.cgi.i)paramq).jTl;
      Log.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s,response.default_mod:%s", new Object[] { Integer.valueOf(paramString.dDN), paramString.qwn, Integer.valueOf(paramString.jTs), Integer.valueOf(paramString.jTt), Integer.valueOf(paramString.jTu), Long.valueOf(paramString.jTv), Long.valueOf(paramString.jTw), paramString.jTx, paramString.jTy, Integer.valueOf(paramString.KBJ) });
      if (paramString.dDN == 0)
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYL, Integer.valueOf(paramString.jTs));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYM, Integer.valueOf(paramString.jTt));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYN, Integer.valueOf(paramString.jTu));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYO, Long.valueOf(paramString.jTv));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYP, Long.valueOf(paramString.jTw));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYQ, Integer.valueOf(paramString.KBJ));
        h.CyF.idkeyStat(407L, 33L, 1L, false);
        com.tencent.mm.vending.g.g.a(this.jSi, new Object[] { new e(paramString.jTy, paramString.jTx) });
        AppMethodBeat.o(63329);
        return;
      }
      com.tencent.mm.vending.g.g.hdx().ej(Boolean.FALSE);
      h.CyF.idkeyStat(407L, 35L, 1L, false);
      AppMethodBeat.o(63329);
      return;
    }
    com.tencent.mm.vending.g.g.hdx().ej(Boolean.FALSE);
    h.CyF.idkeyStat(407L, 34L, 1L, false);
    AppMethodBeat.o(63329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.e
 * JD-Core Version:    0.7.0.1
 */
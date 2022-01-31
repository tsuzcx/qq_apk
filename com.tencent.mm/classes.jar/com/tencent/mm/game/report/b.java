package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.w;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class b
{
  private static LinkedList<com.tencent.mm.game.report.api.b> ezI;
  private static boolean ezJ;
  private static String ezK;
  private static String ezL;
  
  static
  {
    AppMethodBeat.i(59591);
    ezI = new LinkedList();
    ezK = "log_id";
    ezL = "log_ext";
    AppMethodBeat.o(59591);
  }
  
  private static void Ps()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(59589);
        if (ezJ)
        {
          ab.i("MicroMsg.ReportService", "tryDoScene isBusy");
          AppMethodBeat.o(59589);
          return;
        }
        if (bo.es(ezI))
        {
          ab.i("MicroMsg.ReportService", "waitingList is null");
          AppMethodBeat.o(59589);
          continue;
        }
        localb = (com.tencent.mm.game.report.api.b)ezI.remove(0);
      }
      finally {}
      com.tencent.mm.game.report.api.b localb;
      if (localb != null)
      {
        ezJ = true;
        com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
        locala.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        locala.funcId = 427;
        locala.reqCmdId = 0;
        locala.respCmdId = 0;
        aew localaew = new aew();
        localaew.wAb = d.whC;
        localaew.wAc = d.whB;
        localaew.wAd = d.whE;
        localaew.wAe = d.whF;
        localaew.wAf = aa.dsG();
        localaew.qst = localb.ezN;
        localaew.wAg = localb.ezO;
        locala.fsX = localaew;
        locala.fsY = new aex();
        w.a(locala.ado(), new b.1());
        AppMethodBeat.o(59589);
      }
      else
      {
        Ps();
        AppMethodBeat.o(59589);
      }
    }
  }
  
  public static void a(com.tencent.mm.game.report.api.b paramb)
  {
    AppMethodBeat.i(59587);
    if (ah.brt())
    {
      b(paramb);
      AppMethodBeat.o(59587);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(ezK, paramb.ezN);
    localBundle.putString(ezL, paramb.ezO);
    f.a("com.tencent.mm", localBundle, b.a.class, null);
    AppMethodBeat.o(59587);
  }
  
  private static void b(com.tencent.mm.game.report.api.b paramb)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(59588);
        if ((!g.RJ().QU()) || (a.QP()))
        {
          ab.w("MicroMsg.ReportService", "report, account not ready");
          AppMethodBeat.o(59588);
          return;
        }
        if (paramb == null)
        {
          AppMethodBeat.o(59588);
          continue;
        }
        ezI.add(paramb);
      }
      finally {}
      Ps();
      AppMethodBeat.o(59588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.game.report.b
 * JD-Core Version:    0.7.0.1
 */
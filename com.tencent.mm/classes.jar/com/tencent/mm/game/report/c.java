package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aad;
import com.tencent.mm.protocal.c.aae;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class c
{
  private static LinkedList<com.tencent.mm.game.report.api.d> dCr = new LinkedList();
  private static boolean dCs;
  private static String dCt = "log_id";
  private static String dCu = "log_ext";
  
  private static void BE()
  {
    com.tencent.mm.game.report.api.d locald;
    do
    {
      if (dCs)
      {
        y.i("MicroMsg.ReportService", "tryDoScene isBusy");
        return;
      }
      if (bk.dk(dCr))
      {
        y.i("MicroMsg.ReportService", "waitingList is null");
        return;
      }
      locald = (com.tencent.mm.game.report.api.d)dCr.remove(0);
    } while (locald == null);
    dCs = true;
    b.a locala = new b.a();
    locala.uri = "/cgi-bin/micromsg-bin/gamereportkv";
    locala.ecG = 427;
    locala.ecJ = 0;
    locala.ecK = 0;
    aad localaad = new aad();
    localaad.sEc = com.tencent.mm.protocal.d.soV;
    localaad.sEd = com.tencent.mm.protocal.d.soU;
    localaad.sEe = com.tencent.mm.protocal.d.soX;
    localaad.sEf = com.tencent.mm.protocal.d.soY;
    localaad.sEg = x.cqJ();
    localaad.nFr = locald.dCy;
    localaad.sEh = locald.dCz;
    locala.ecH = localaad;
    locala.ecI = new aae();
    w.a(locala.Kt(), new c.1());
  }
  
  public static void a(com.tencent.mm.game.report.api.d paramd)
  {
    if (ae.cqV())
    {
      if ((!g.DN().Dc()) || (a.CW())) {
        y.w("MicroMsg.ReportService", "report, account not ready");
      }
      while (paramd == null) {
        return;
      }
      dCr.add(paramd);
      BE();
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(dCt, paramd.dCy);
    localBundle.putString(dCu, paramd.dCz);
    f.a("com.tencent.mm", localBundle, c.a.class, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.game.report.c
 * JD-Core Version:    0.7.0.1
 */
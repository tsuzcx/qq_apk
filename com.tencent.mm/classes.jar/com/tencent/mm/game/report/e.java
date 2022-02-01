package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

final class e
{
  private static LinkedList<com.tencent.mm.game.report.api.b> grX;
  private static boolean grY;
  private static String grZ;
  private static String gsa;
  
  static
  {
    AppMethodBeat.i(108259);
    grX = new LinkedList();
    grZ = "log_id";
    gsa = "log_ext";
    AppMethodBeat.o(108259);
  }
  
  public static void a(com.tencent.mm.game.report.api.b paramb)
  {
    AppMethodBeat.i(108255);
    if (aj.cnC())
    {
      b(paramb);
      AppMethodBeat.o(108255);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(grZ, paramb.gsc);
    localBundle.putString(gsa, paramb.gsd);
    h.a("com.tencent.mm", localBundle, a.class, null);
    AppMethodBeat.o(108255);
  }
  
  private static void agE()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108257);
        if (grY)
        {
          ad.i("MicroMsg.ReportService", "tryDoScene isBusy");
          AppMethodBeat.o(108257);
          return;
        }
        if (bt.hj(grX))
        {
          ad.i("MicroMsg.ReportService", "waitingList is null");
          AppMethodBeat.o(108257);
          continue;
        }
        localb = (com.tencent.mm.game.report.api.b)grX.remove(0);
      }
      finally {}
      com.tencent.mm.game.report.api.b localb;
      if (localb != null)
      {
        grY = true;
        b.a locala = new b.a();
        locala.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        locala.funcId = 427;
        locala.hNO = 0;
        locala.respCmdId = 0;
        com.tencent.mm.game.report.c.a locala1 = new com.tencent.mm.game.report.c.a();
        locala1.gsM = d.Fne;
        locala1.gsN = d.Fnd;
        locala1.gsO = d.Fng;
        locala1.gsP = d.Fnh;
        locala1.gsQ = ac.fks();
        locala1.gsR = localb.gsc;
        locala1.gsS = localb.gsd;
        locala.hNM = locala1;
        locala.hNN = new com.tencent.mm.game.report.c.b();
        x.a(locala.aDC(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(108253);
            ad.i("MicroMsg.ReportService", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            e.Jy();
            e.access$100();
            AppMethodBeat.o(108253);
            return 0;
          }
        });
        AppMethodBeat.o(108257);
      }
      else
      {
        agE();
        AppMethodBeat.o(108257);
      }
    }
  }
  
  private static void b(com.tencent.mm.game.report.api.b paramb)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108256);
        if ((!g.ajA().aiK()) || (com.tencent.mm.kernel.a.aiE()))
        {
          ad.w("MicroMsg.ReportService", "report, account not ready");
          AppMethodBeat.o(108256);
          return;
        }
        if (paramb == null)
        {
          AppMethodBeat.o(108256);
          continue;
        }
        grX.add(paramb);
      }
      finally {}
      agE();
      AppMethodBeat.o(108256);
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

final class d
{
  private static LinkedList<com.tencent.mm.game.report.api.b> fUG;
  private static boolean fUH;
  private static String fUI;
  private static String fUJ;
  
  static
  {
    AppMethodBeat.i(108259);
    fUG = new LinkedList();
    fUI = "log_id";
    fUJ = "log_ext";
    AppMethodBeat.o(108259);
  }
  
  public static void a(com.tencent.mm.game.report.api.b paramb)
  {
    AppMethodBeat.i(108255);
    if (aj.cbv())
    {
      b(paramb);
      AppMethodBeat.o(108255);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(fUI, paramb.fUL);
    localBundle.putString(fUJ, paramb.fUM);
    h.a("com.tencent.mm", localBundle, a.class, null);
    AppMethodBeat.o(108255);
  }
  
  private static void acS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108257);
        if (fUH)
        {
          ad.i("MicroMsg.ReportService", "tryDoScene isBusy");
          AppMethodBeat.o(108257);
          return;
        }
        if (bt.gL(fUG))
        {
          ad.i("MicroMsg.ReportService", "waitingList is null");
          AppMethodBeat.o(108257);
          continue;
        }
        localb = (com.tencent.mm.game.report.api.b)fUG.remove(0);
      }
      finally {}
      com.tencent.mm.game.report.api.b localb;
      if (localb != null)
      {
        fUH = true;
        b.a locala = new b.a();
        locala.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        locala.funcId = 427;
        locala.reqCmdId = 0;
        locala.respCmdId = 0;
        com.tencent.mm.game.report.c.a locala1 = new com.tencent.mm.game.report.c.a();
        locala1.fVv = com.tencent.mm.protocal.d.CpF;
        locala1.fVw = com.tencent.mm.protocal.d.CpE;
        locala1.fVx = com.tencent.mm.protocal.d.CpH;
        locala1.fVy = com.tencent.mm.protocal.d.CpI;
        locala1.fVz = ac.eFu();
        locala1.fVA = localb.fUL;
        locala1.fVB = localb.fUM;
        locala.gUU = locala1;
        locala.gUV = new com.tencent.mm.game.report.c.b();
        x.a(locala.atI(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(108253);
            ad.i("MicroMsg.ReportService", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            d.acT();
            d.access$100();
            AppMethodBeat.o(108253);
            return 0;
          }
        });
        AppMethodBeat.o(108257);
      }
      else
      {
        acS();
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
        if ((!g.afz().aeI()) || (com.tencent.mm.kernel.a.aeC()))
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
        fUG.add(paramb);
      }
      finally {}
      acS();
      AppMethodBeat.o(108256);
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.d
 * JD-Core Version:    0.7.0.1
 */
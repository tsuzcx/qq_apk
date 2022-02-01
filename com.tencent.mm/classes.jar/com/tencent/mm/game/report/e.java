package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.game.report.c.c;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

final class e
{
  private static String guA;
  private static String guB;
  private static LinkedList<com.tencent.mm.game.report.api.b> guy;
  private static boolean guz;
  
  static
  {
    AppMethodBeat.i(108259);
    guy = new LinkedList();
    guA = "log_id";
    guB = "log_ext";
    AppMethodBeat.o(108259);
  }
  
  public static void a(com.tencent.mm.game.report.api.b paramb)
  {
    AppMethodBeat.i(108255);
    if (ak.cpe())
    {
      b(paramb);
      AppMethodBeat.o(108255);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(guA, paramb.guD);
    localBundle.putString(guB, paramb.guE);
    h.a("com.tencent.mm", localBundle, a.class, null);
    AppMethodBeat.o(108255);
  }
  
  private static void agS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108257);
        if (guz)
        {
          ae.i("MicroMsg.ReportService", "tryDoScene isBusy");
          AppMethodBeat.o(108257);
          return;
        }
        if (bu.ht(guy))
        {
          ae.i("MicroMsg.ReportService", "waitingList is null");
          AppMethodBeat.o(108257);
          continue;
        }
        localb = (com.tencent.mm.game.report.api.b)guy.remove(0);
      }
      finally {}
      com.tencent.mm.game.report.api.b localb;
      if (localb != null)
      {
        guz = true;
        b.a locala = new b.a();
        locala.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        locala.funcId = 427;
        locala.hQH = 0;
        locala.respCmdId = 0;
        c localc = new c();
        localc.gvo = com.tencent.mm.protocal.d.FFC;
        localc.gvp = com.tencent.mm.protocal.d.FFB;
        localc.gvq = com.tencent.mm.protocal.d.FFE;
        localc.gvr = com.tencent.mm.protocal.d.FFF;
        localc.gvs = ad.fom();
        localc.gvt = localb.guD;
        localc.gvu = localb.guE;
        locala.hQF = localc;
        locala.hQG = new com.tencent.mm.game.report.c.d();
        x.a(locala.aDS(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(108253);
            ae.i("MicroMsg.ReportService", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            e.JG();
            e.access$100();
            AppMethodBeat.o(108253);
            return 0;
          }
        });
        AppMethodBeat.o(108257);
      }
      else
      {
        agS();
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
        if ((!g.ajP().aiZ()) || (a.aiT()))
        {
          ae.w("MicroMsg.ReportService", "report, account not ready");
          AppMethodBeat.o(108256);
          return;
        }
        if (paramb == null)
        {
          AppMethodBeat.o(108256);
          continue;
        }
        guy.add(paramb);
      }
      finally {}
      agS();
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
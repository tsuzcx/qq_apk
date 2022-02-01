package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

final class d
{
  private static LinkedList<com.tencent.mm.game.report.api.b> fYB;
  private static boolean fYC;
  private static String fYD;
  private static String fYE;
  
  static
  {
    AppMethodBeat.i(108259);
    fYB = new LinkedList();
    fYD = "log_id";
    fYE = "log_ext";
    AppMethodBeat.o(108259);
  }
  
  public static void a(com.tencent.mm.game.report.api.b paramb)
  {
    AppMethodBeat.i(108255);
    if (ai.ciE())
    {
      b(paramb);
      AppMethodBeat.o(108255);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(fYD, paramb.fYG);
    localBundle.putString(fYE, paramb.fYH);
    h.a("com.tencent.mm", localBundle, a.class, null);
    AppMethodBeat.o(108255);
  }
  
  private static void adY()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108257);
        if (fYC)
        {
          ac.i("MicroMsg.ReportService", "tryDoScene isBusy");
          AppMethodBeat.o(108257);
          return;
        }
        if (bs.gY(fYB))
        {
          ac.i("MicroMsg.ReportService", "waitingList is null");
          AppMethodBeat.o(108257);
          continue;
        }
        localb = (com.tencent.mm.game.report.api.b)fYB.remove(0);
      }
      finally {}
      com.tencent.mm.game.report.api.b localb;
      if (localb != null)
      {
        fYC = true;
        b.a locala = new b.a();
        locala.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        locala.funcId = 427;
        locala.reqCmdId = 0;
        locala.respCmdId = 0;
        com.tencent.mm.game.report.c.a locala1 = new com.tencent.mm.game.report.c.a();
        locala1.fZq = com.tencent.mm.protocal.d.DHX;
        locala1.fZr = com.tencent.mm.protocal.d.DHW;
        locala1.fZs = com.tencent.mm.protocal.d.DHZ;
        locala1.fZt = com.tencent.mm.protocal.d.DIa;
        locala1.fZu = ab.eUO();
        locala1.fZv = localb.fYG;
        locala1.fZw = localb.fYH;
        locala.hvt = locala1;
        locala.hvu = new com.tencent.mm.game.report.c.b();
        x.a(locala.aAz(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(108253);
            ac.i("MicroMsg.ReportService", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            d.adZ();
            d.access$100();
            AppMethodBeat.o(108253);
            return 0;
          }
        });
        AppMethodBeat.o(108257);
      }
      else
      {
        adY();
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
        if ((!g.agP().afY()) || (com.tencent.mm.kernel.a.afS()))
        {
          ac.w("MicroMsg.ReportService", "report, account not ready");
          AppMethodBeat.o(108256);
          return;
        }
        if (paramb == null)
        {
          AppMethodBeat.o(108256);
          continue;
        }
        fYB.add(paramb);
      }
      finally {}
      adY();
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
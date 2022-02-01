package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

final class f
{
  private static LinkedList<com.tencent.mm.game.report.api.b> mtD;
  private static boolean mtE;
  private static String mtF;
  private static String mtG;
  
  static
  {
    AppMethodBeat.i(108259);
    mtD = new LinkedList();
    mtF = "log_id";
    mtG = "log_ext";
    AppMethodBeat.o(108259);
  }
  
  public static void a(com.tencent.mm.game.report.api.b paramb)
  {
    AppMethodBeat.i(108255);
    if (MMApplicationContext.isMMProcess())
    {
      b(paramb);
      AppMethodBeat.o(108255);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(mtF, paramb.mtI);
    localBundle.putString(mtG, paramb.mtJ);
    j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class, null);
    AppMethodBeat.o(108255);
  }
  
  private static void aXF()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108257);
        if (mtE)
        {
          Log.i("MicroMsg.ReportService", "tryDoScene isBusy");
          AppMethodBeat.o(108257);
          return;
        }
        if (Util.isNullOrNil(mtD))
        {
          Log.i("MicroMsg.ReportService", "waitingList is null");
          AppMethodBeat.o(108257);
          continue;
        }
        localb = (com.tencent.mm.game.report.api.b)mtD.remove(0);
      }
      finally {}
      com.tencent.mm.game.report.api.b localb;
      if (localb != null)
      {
        mtE = true;
        c.a locala = new c.a();
        locala.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        locala.funcId = 427;
        locala.otG = 0;
        locala.respCmdId = 0;
        com.tencent.mm.game.report.c.c localc = new com.tencent.mm.game.report.c.c();
        localc.mut = com.tencent.mm.protocal.d.Yxb;
        localc.muu = com.tencent.mm.protocal.d.Yxa;
        localc.muv = com.tencent.mm.protocal.d.Yxd;
        localc.muw = com.tencent.mm.protocal.d.Yxe;
        localc.mux = LocaleUtil.getApplicationLanguage();
        localc.muy = localb.mtI;
        localc.muz = localb.mtJ;
        locala.otE = localc;
        locala.otF = new com.tencent.mm.game.report.c.d();
        z.a(locala.bEF(), new z.a()
        {
          public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc, p paramAnonymousp)
          {
            AppMethodBeat.i(108253);
            Log.i("MicroMsg.ReportService", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            f.aAs();
            f.access$100();
            AppMethodBeat.o(108253);
            return 0;
          }
        });
        AppMethodBeat.o(108257);
      }
      else
      {
        aXF();
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
        if ((!h.baC().aZN()) || (com.tencent.mm.kernel.b.aZG()))
        {
          Log.w("MicroMsg.ReportService", "report, account not ready");
          AppMethodBeat.o(108256);
          return;
        }
        if (paramb == null)
        {
          AppMethodBeat.o(108256);
          continue;
        }
        mtD.add(paramb);
      }
      finally {}
      aXF();
      AppMethodBeat.o(108256);
    }
  }
  
  @a
  static class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.f
 * JD-Core Version:    0.7.0.1
 */
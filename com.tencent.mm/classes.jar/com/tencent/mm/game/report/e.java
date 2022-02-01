package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.game.report.c.c;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

final class e
{
  private static LinkedList<com.tencent.mm.game.report.api.b> hhn;
  private static boolean hho;
  private static String hhp;
  private static String hhq;
  
  static
  {
    AppMethodBeat.i(108259);
    hhn = new LinkedList();
    hhp = "log_id";
    hhq = "log_ext";
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
    localBundle.putInt(hhp, paramb.hhs);
    localBundle.putString(hhq, paramb.hht);
    h.a(MainProcessIPCService.dkO, localBundle, a.class, null);
    AppMethodBeat.o(108255);
  }
  
  private static void axe()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108257);
        if (hho)
        {
          Log.i("MicroMsg.ReportService", "tryDoScene isBusy");
          AppMethodBeat.o(108257);
          return;
        }
        if (Util.isNullOrNil(hhn))
        {
          Log.i("MicroMsg.ReportService", "waitingList is null");
          AppMethodBeat.o(108257);
          continue;
        }
        localb = (com.tencent.mm.game.report.api.b)hhn.remove(0);
      }
      finally {}
      com.tencent.mm.game.report.api.b localb;
      if (localb != null)
      {
        hho = true;
        d.a locala = new d.a();
        locala.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        locala.funcId = 427;
        locala.iLP = 0;
        locala.respCmdId = 0;
        c localc = new c();
        localc.hid = com.tencent.mm.protocal.d.KyJ;
        localc.hie = com.tencent.mm.protocal.d.KyI;
        localc.hif = com.tencent.mm.protocal.d.KyL;
        localc.hig = com.tencent.mm.protocal.d.KyM;
        localc.hih = LocaleUtil.getApplicationLanguage();
        localc.hii = localb.hhs;
        localc.hij = localb.hht;
        locala.iLN = localc;
        locala.iLO = new com.tencent.mm.game.report.c.d();
        aa.a(locala.aXF(), new aa.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
          {
            AppMethodBeat.i(108253);
            Log.i("MicroMsg.ReportService", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            e.TT();
            e.access$100();
            AppMethodBeat.o(108253);
            return 0;
          }
        });
        AppMethodBeat.o(108257);
      }
      else
      {
        axe();
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
        if ((!g.aAf().azp()) || (a.azj()))
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
        hhn.add(paramb);
      }
      finally {}
      axe();
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
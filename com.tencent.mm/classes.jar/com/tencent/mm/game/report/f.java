package com.tencent.mm.game.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.game.report.c.c;
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
  private static LinkedList<com.tencent.mm.game.report.api.b> jTl;
  private static boolean jTm;
  private static String jTn;
  private static String jTo;
  
  static
  {
    AppMethodBeat.i(108259);
    jTl = new LinkedList();
    jTn = "log_id";
    jTo = "log_ext";
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
    localBundle.putInt(jTn, paramb.jTq);
    localBundle.putString(jTo, paramb.jTr);
    j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class, null);
    AppMethodBeat.o(108255);
  }
  
  private static void aEB()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(108257);
        if (jTm)
        {
          Log.i("MicroMsg.ReportService", "tryDoScene isBusy");
          AppMethodBeat.o(108257);
          return;
        }
        if (Util.isNullOrNil(jTl))
        {
          Log.i("MicroMsg.ReportService", "waitingList is null");
          AppMethodBeat.o(108257);
          continue;
        }
        localb = (com.tencent.mm.game.report.api.b)jTl.remove(0);
      }
      finally {}
      com.tencent.mm.game.report.api.b localb;
      if (localb != null)
      {
        jTm = true;
        d.a locala = new d.a();
        locala.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        locala.funcId = 427;
        locala.lBW = 0;
        locala.respCmdId = 0;
        c localc = new c();
        localc.jUb = com.tencent.mm.protocal.d.RAx;
        localc.jUc = com.tencent.mm.protocal.d.RAw;
        localc.jUd = com.tencent.mm.protocal.d.RAz;
        localc.jUe = com.tencent.mm.protocal.d.RAA;
        localc.jUf = LocaleUtil.getApplicationLanguage();
        localc.jUg = localb.jTq;
        localc.jUh = localb.jTr;
        locala.lBU = localc;
        locala.lBV = new com.tencent.mm.game.report.c.d();
        aa.a(locala.bgN(), new aa.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
          {
            AppMethodBeat.i(108253);
            Log.i("MicroMsg.ReportService", "tryDoScene, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            f.Yy();
            f.access$100();
            AppMethodBeat.o(108253);
            return 0;
          }
        });
        AppMethodBeat.o(108257);
      }
      else
      {
        aEB();
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
        if ((!h.aHE().aGM()) || (com.tencent.mm.kernel.b.aGE()))
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
        jTl.add(paramb);
      }
      finally {}
      aEB();
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
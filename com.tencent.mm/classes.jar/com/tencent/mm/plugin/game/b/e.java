package com.tencent.mm.plugin.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.game.autogen.a.h;
import com.tencent.mm.plugin.game.autogen.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

public final class e
{
  public static void report(long paramLong)
  {
    AppMethodBeat.i(40884);
    Object localObject = com.tencent.mm.plugin.downloader.model.d.IF(paramLong);
    if (localObject == null)
    {
      Log.i("MicroMsg.ReportDownloadAppState", "report, info is null");
      AppMethodBeat.o(40884);
      return;
    }
    if (!((a)localObject).field_fromWeApp)
    {
      Log.i("MicroMsg.ReportDownloadAppState", "report,not from weApp, return");
      AppMethodBeat.o(40884);
      return;
    }
    if ((((a)localObject).field_status == 3) && (!u.agG(((a)localObject).field_filePath)))
    {
      Log.i("MicroMsg.ReportDownloadAppState", "download success, but file not exist");
      AppMethodBeat.o(40884);
      return;
    }
    h localh = new h();
    localh.lVG = ((a)localObject).field_appId;
    if (((a)localObject).field_status == 3) {
      localh.rVU = a.CzP;
    }
    for (;;)
    {
      localObject = new d.a();
      ((d.a)localObject).funcId = 2683;
      ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/reportappdownloadstatus";
      ((d.a)localObject).lBU = localh;
      ((d.a)localObject).lBV = new i();
      ((d.a)localObject).lBW = 0;
      ((d.a)localObject).respCmdId = 0;
      aa.a(((d.a)localObject).bgN(), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, q paramAnonymousq)
        {
          AppMethodBeat.i(40883);
          Log.i("MicroMsg.ReportDownloadAppState", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          AppMethodBeat.o(40883);
          return 0;
        }
      });
      AppMethodBeat.o(40884);
      return;
      if (((a)localObject).field_status == 4) {
        localh.rVU = a.DOWNLOAD_STATUS_FAILED;
      }
    }
  }
  
  static final class a
  {
    static int CzO = 0;
    static int CzP = 1;
    static int DOWNLOAD_STATUS_FAILED = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.e
 * JD-Core Version:    0.7.0.1
 */
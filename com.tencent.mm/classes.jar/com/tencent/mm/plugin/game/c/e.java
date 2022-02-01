package com.tencent.mm.plugin.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.game.b.a.h;
import com.tencent.mm.plugin.game.b.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

public final class e
{
  public static void report(long paramLong)
  {
    AppMethodBeat.i(40884);
    Object localObject = com.tencent.mm.plugin.downloader.model.d.Cw(paramLong);
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
    if ((((a)localObject).field_status == 3) && (!s.YS(((a)localObject).field_filePath)))
    {
      Log.i("MicroMsg.ReportDownloadAppState", "download success, but file not exist");
      AppMethodBeat.o(40884);
      return;
    }
    h localh = new h();
    localh.jfi = ((a)localObject).field_appId;
    if (((a)localObject).field_status == 3) {
      localh.oTW = a.xvV;
    }
    for (;;)
    {
      localObject = new d.a();
      ((d.a)localObject).funcId = 2683;
      ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/reportappdownloadstatus";
      ((d.a)localObject).iLN = localh;
      ((d.a)localObject).iLO = new i();
      ((d.a)localObject).iLP = 0;
      ((d.a)localObject).respCmdId = 0;
      aa.a(((d.a)localObject).aXF(), new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd, q paramAnonymousq)
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
        localh.oTW = a.DOWNLOAD_STATUS_FAILED;
      }
    }
  }
  
  static final class a
  {
    static int DOWNLOAD_STATUS_FAILED = 2;
    static int xvU = 0;
    static int xvV = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.e
 * JD-Core Version:    0.7.0.1
 */
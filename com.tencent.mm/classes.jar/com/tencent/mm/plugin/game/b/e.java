package com.tencent.mm.plugin.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.autogen.a.h;
import com.tencent.mm.plugin.game.autogen.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

public final class e
{
  public static void report(long paramLong)
  {
    AppMethodBeat.i(40884);
    Object localObject = d.la(paramLong);
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
    if ((((a)localObject).field_status == 3) && (!y.ZC(((a)localObject).field_filePath)))
    {
      Log.i("MicroMsg.ReportDownloadAppState", "download success, but file not exist");
      AppMethodBeat.o(40884);
      return;
    }
    h localh = new h();
    localh.oOI = ((a)localObject).field_appId;
    if (((a)localObject).field_status == 3) {
      localh.vhk = a.ItA;
    }
    for (;;)
    {
      localObject = new c.a();
      ((c.a)localObject).funcId = 2683;
      ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/reportappdownloadstatus";
      ((c.a)localObject).otE = localh;
      ((c.a)localObject).otF = new i();
      ((c.a)localObject).otG = 0;
      ((c.a)localObject).respCmdId = 0;
      z.a(((c.a)localObject).bEF(), new z.a()
      {
        public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
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
        localh.vhk = a.DOWNLOAD_STATUS_FAILED;
      }
    }
  }
  
  static final class a
  {
    static int DOWNLOAD_STATUS_FAILED = 2;
    static int ItA;
    static int Itz = 0;
    
    static
    {
      ItA = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.e
 * JD-Core Version:    0.7.0.1
 */
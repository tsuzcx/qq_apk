package com.tencent.mm.plugin.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.game.b.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;

public final class a
{
  public static void report(long paramLong)
  {
    AppMethodBeat.i(40884);
    Object localObject = com.tencent.mm.plugin.downloader.model.d.sc(paramLong);
    if (localObject == null)
    {
      ac.i("MicroMsg.ReportDownloadAppState", "report, info is null");
      AppMethodBeat.o(40884);
      return;
    }
    if (!((com.tencent.mm.plugin.downloader.g.a)localObject).field_fromWeApp)
    {
      ac.i("MicroMsg.ReportDownloadAppState", "report,not from weApp, return");
      AppMethodBeat.o(40884);
      return;
    }
    if ((((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 3) && (!i.eA(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath)))
    {
      ac.i("MicroMsg.ReportDownloadAppState", "download success, but file not exist");
      AppMethodBeat.o(40884);
      return;
    }
    c localc = new c();
    localc.hOf = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
    if (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 3) {
      localc.ndj = a.sWA;
    }
    for (;;)
    {
      localObject = new b.a();
      ((b.a)localObject).funcId = 2683;
      ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/reportappdownloadstatus";
      ((b.a)localObject).hvt = localc;
      ((b.a)localObject).hvu = new com.tencent.mm.plugin.game.b.a.d();
      ((b.a)localObject).reqCmdId = 0;
      ((b.a)localObject).respCmdId = 0;
      x.a(((b.a)localObject).aAz(), new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(40883);
          ac.i("MicroMsg.ReportDownloadAppState", "doCgi, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          AppMethodBeat.o(40883);
          return 0;
        }
      });
      AppMethodBeat.o(40884);
      return;
      if (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 4) {
        localc.ndj = a.DOWNLOAD_STATUS_FAILED;
      }
    }
  }
  
  static final class a
  {
    static int DOWNLOAD_STATUS_FAILED = 2;
    static int sWA;
    static int sWz = 0;
    
    static
    {
      sWA = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.a
 * JD-Core Version:    0.7.0.1
 */
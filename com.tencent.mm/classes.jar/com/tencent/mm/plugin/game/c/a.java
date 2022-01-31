package com.tencent.mm.plugin.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.protocal.protobuf.bto;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

public final class a
{
  public static void kk(long paramLong)
  {
    AppMethodBeat.i(111183);
    Object localObject = d.iJ(paramLong);
    if (localObject == null)
    {
      ab.i("MicroMsg.ReportDownloadAppState", "report, info is null");
      AppMethodBeat.o(111183);
      return;
    }
    if (!((com.tencent.mm.plugin.downloader.g.a)localObject).field_fromWeApp)
    {
      ab.i("MicroMsg.ReportDownloadAppState", "report,not from weApp, return");
      AppMethodBeat.o(111183);
      return;
    }
    if ((((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 3) && (!e.cN(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath)))
    {
      ab.i("MicroMsg.ReportDownloadAppState", "download success, but file not exist");
      AppMethodBeat.o(111183);
      return;
    }
    btn localbtn = new btn();
    localbtn.fKw = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
    if (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 3) {
      localbtn.jJS = a.a.njc;
    }
    for (;;)
    {
      localObject = new b.a();
      ((b.a)localObject).funcId = 2683;
      ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/reportappdownloadstatus";
      ((b.a)localObject).fsX = localbtn;
      ((b.a)localObject).fsY = new bto();
      ((b.a)localObject).reqCmdId = 0;
      ((b.a)localObject).respCmdId = 0;
      w.a(((b.a)localObject).ado(), new a.1());
      AppMethodBeat.o(111183);
      return;
      if (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 4) {
        localbtn.jJS = a.a.DOWNLOAD_STATUS_FAILED;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.a
 * JD-Core Version:    0.7.0.1
 */
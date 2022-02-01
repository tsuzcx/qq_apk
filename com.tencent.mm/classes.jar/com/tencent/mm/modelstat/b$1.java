package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class b$1
  implements Runnable
{
  b$1(b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(150975);
    Log.e("MicroMsg.ChattingOperationUitl", "check error:%s", new Object[] { this.oVd });
    log_13913 locallog_13913 = new log_13913();
    locallog_13913.scene_ = 1;
    locallog_13913.error_ = this.oVd;
    h.OAn.c(13913, locallog_13913);
    AppMethodBeat.o(150975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.b.1
 * JD-Core Version:    0.7.0.1
 */
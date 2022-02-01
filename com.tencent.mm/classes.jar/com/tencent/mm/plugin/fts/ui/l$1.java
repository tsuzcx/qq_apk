package com.tencent.mm.plugin.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kb;
import com.tencent.mm.sdk.platformtools.Log;

final class l$1
  implements Runnable
{
  l$1(int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(265535);
    kb localkb = new kb();
    localkb.ila = this.hli;
    localkb.sr(this.Hzg);
    localkb.bMH();
    Log.i("MicroMsg.FTS.FTSReportLogic", "24832 ,action = " + localkb.ila + ",actionInfo = " + localkb.iVn);
    AppMethodBeat.o(265535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.l.1
 * JD-Core Version:    0.7.0.1
 */
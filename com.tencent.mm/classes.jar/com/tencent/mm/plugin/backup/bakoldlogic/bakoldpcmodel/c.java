package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public int ltN;
  public int rTq;
  public int rTr;
  private int rTs;
  int rTt;
  int rTu;
  int rTv;
  public int rTw;
  
  private String getString()
  {
    AppMethodBeat.i(21884);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.rTq), Integer.valueOf(this.rTr), Integer.valueOf(this.ltN), Integer.valueOf(this.rTs), Integer.valueOf(this.rTt), Integer.valueOf(this.rTu), Integer.valueOf(this.rTv), Integer.valueOf(this.rTw) });
    AppMethodBeat.o(21884);
    return str;
  }
  
  private void reset()
  {
    this.rTq = 0;
    this.rTr = 0;
    this.ltN = 0;
    this.rTs = 0;
    this.rTt = 0;
    this.rTu = 0;
    this.rTv = 0;
    this.rTw = 0;
  }
  
  public final void bfq()
  {
    AppMethodBeat.i(21883);
    if (this.rTq == 0)
    {
      reset();
      AppMethodBeat.o(21883);
      return;
    }
    String str = getString();
    Log.i("MicroMsg.BakPCReportor", "report: %s", new Object[] { str });
    h.IzE.kvStat(11103, str);
    reset();
    AppMethodBeat.o(21883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c
 * JD-Core Version:    0.7.0.1
 */
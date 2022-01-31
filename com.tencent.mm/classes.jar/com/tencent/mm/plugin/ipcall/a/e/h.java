package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
  extends a
{
  private long nPL = 0L;
  public long nPM = 0L;
  public long nPN = 0L;
  public long nPO = 0L;
  private long nPp;
  public long nPq;
  
  protected final void bJP()
  {
    AppMethodBeat.i(21893);
    com.tencent.mm.plugin.report.service.h.qsU.e(12931, new Object[] { Long.valueOf(this.nPp), Long.valueOf(this.nPq), Long.valueOf(this.nPL), Long.valueOf(this.nPM), Long.valueOf(this.nPN), Long.valueOf(this.nPO) });
    AppMethodBeat.o(21893);
  }
  
  public final void reset()
  {
    this.nPp = 0L;
    this.nPq = 0L;
    this.nPL = 0L;
    this.nPM = 0L;
    this.nPN = 0L;
    this.nPO = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(21892);
    super.start();
    this.nPp = bo.aoy();
    AppMethodBeat.o(21892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.h
 * JD-Core Version:    0.7.0.1
 */
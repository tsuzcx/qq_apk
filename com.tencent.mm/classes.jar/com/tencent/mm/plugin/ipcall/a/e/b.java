package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends a
{
  private long nPp;
  public long nPq;
  public long nPr = 0L;
  public long nPs = 0L;
  public long nPt = 0L;
  
  protected final void bJP()
  {
    AppMethodBeat.i(21884);
    h.qsU.e(12930, new Object[] { Long.valueOf(this.nPp), Long.valueOf(this.nPq), Long.valueOf(this.nPr), Long.valueOf(this.nPs), Long.valueOf(this.nPt) });
    AppMethodBeat.o(21884);
  }
  
  public final void reset()
  {
    this.nPp = 0L;
    this.nPq = 0L;
    this.nPr = 0L;
    this.nPs = 0L;
    this.nPt = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(21883);
    super.start();
    this.nPp = bo.aoy();
    AppMethodBeat.o(21883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.b
 * JD-Core Version:    0.7.0.1
 */
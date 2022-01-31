package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class j
  extends a
{
  public long nPP = 0L;
  public long nPQ = 0L;
  public long nPR = 0L;
  private long nPp;
  public long nPq;
  
  protected final void bJP()
  {
    AppMethodBeat.i(21896);
    h.qsU.e(12934, new Object[] { Long.valueOf(this.nPp), Long.valueOf(this.nPq), Long.valueOf(this.nPP), Long.valueOf(this.nPQ), Long.valueOf(this.nPR) });
    AppMethodBeat.o(21896);
  }
  
  public final void reset()
  {
    this.nPp = 0L;
    this.nPq = 0L;
    this.nPP = 0L;
    this.nPQ = 0L;
    this.nPR = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(21895);
    super.start();
    this.nPp = bo.aoy();
    AppMethodBeat.o(21895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.j
 * JD-Core Version:    0.7.0.1
 */
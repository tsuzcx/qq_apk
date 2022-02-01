package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
  extends a
{
  public long sDK = 0L;
  public long sDL = 0L;
  public long sDM = 0L;
  private long sDk;
  public long sDl;
  
  protected final void bmJ()
  {
    AppMethodBeat.i(25511);
    h.vKh.f(12934, new Object[] { Long.valueOf(this.sDk), Long.valueOf(this.sDl), Long.valueOf(this.sDK), Long.valueOf(this.sDL), Long.valueOf(this.sDM) });
    AppMethodBeat.o(25511);
  }
  
  public final void reset()
  {
    this.sDk = 0L;
    this.sDl = 0L;
    this.sDK = 0L;
    this.sDL = 0L;
    this.sDM = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25510);
    super.start();
    this.sDk = bt.eGO();
    AppMethodBeat.o(25510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.j
 * JD-Core Version:    0.7.0.1
 */
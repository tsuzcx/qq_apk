package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;

public final class j
  extends a
{
  public long uZS = 0L;
  public long uZT = 0L;
  public long uZU = 0L;
  private long uZs;
  public long uZt;
  
  protected final void byD()
  {
    AppMethodBeat.i(25511);
    g.yxI.f(12934, new Object[] { Long.valueOf(this.uZs), Long.valueOf(this.uZt), Long.valueOf(this.uZS), Long.valueOf(this.uZT), Long.valueOf(this.uZU) });
    AppMethodBeat.o(25511);
  }
  
  public final void reset()
  {
    this.uZs = 0L;
    this.uZt = 0L;
    this.uZS = 0L;
    this.uZT = 0L;
    this.uZU = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25510);
    super.start();
    this.uZs = bu.fpO();
    AppMethodBeat.o(25510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.j
 * JD-Core Version:    0.7.0.1
 */
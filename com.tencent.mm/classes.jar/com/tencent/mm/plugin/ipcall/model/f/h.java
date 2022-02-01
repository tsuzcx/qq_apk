package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;

public final class h
  extends a
{
  private long uZO = 0L;
  public long uZP = 0L;
  public long uZQ = 0L;
  public long uZR = 0L;
  private long uZs;
  public long uZt;
  
  protected final void byD()
  {
    AppMethodBeat.i(25508);
    g.yxI.f(12931, new Object[] { Long.valueOf(this.uZs), Long.valueOf(this.uZt), Long.valueOf(this.uZO), Long.valueOf(this.uZP), Long.valueOf(this.uZQ), Long.valueOf(this.uZR) });
    AppMethodBeat.o(25508);
  }
  
  public final void reset()
  {
    this.uZs = 0L;
    this.uZt = 0L;
    this.uZO = 0L;
    this.uZP = 0L;
    this.uZQ = 0L;
    this.uZR = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25507);
    super.start();
    this.uZs = bu.fpO();
    AppMethodBeat.o(25507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.h
 * JD-Core Version:    0.7.0.1
 */
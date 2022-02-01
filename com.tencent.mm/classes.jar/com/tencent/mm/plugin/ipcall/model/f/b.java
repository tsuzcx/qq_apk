package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  extends a
{
  private long uZs;
  public long uZt;
  public long uZu = 0L;
  public long uZv = 0L;
  public long uZw = 0L;
  
  protected final void byD()
  {
    AppMethodBeat.i(25499);
    g.yxI.f(12930, new Object[] { Long.valueOf(this.uZs), Long.valueOf(this.uZt), Long.valueOf(this.uZu), Long.valueOf(this.uZv), Long.valueOf(this.uZw) });
    AppMethodBeat.o(25499);
  }
  
  public final void reset()
  {
    this.uZs = 0L;
    this.uZt = 0L;
    this.uZu = 0L;
    this.uZv = 0L;
    this.uZw = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25498);
    super.start();
    this.uZs = bu.fpO();
    AppMethodBeat.o(25498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.b
 * JD-Core Version:    0.7.0.1
 */
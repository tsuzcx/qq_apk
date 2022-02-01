package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
  extends a
{
  private long uNF;
  public long uNG;
  public long uOf = 0L;
  public long uOg = 0L;
  public long uOh = 0L;
  
  protected final void bxK()
  {
    AppMethodBeat.i(25511);
    g.yhR.f(12934, new Object[] { Long.valueOf(this.uNF), Long.valueOf(this.uNG), Long.valueOf(this.uOf), Long.valueOf(this.uOg), Long.valueOf(this.uOh) });
    AppMethodBeat.o(25511);
  }
  
  public final void reset()
  {
    this.uNF = 0L;
    this.uNG = 0L;
    this.uOf = 0L;
    this.uOg = 0L;
    this.uOh = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25510);
    super.start();
    this.uNF = bt.flT();
    AppMethodBeat.o(25510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.j
 * JD-Core Version:    0.7.0.1
 */
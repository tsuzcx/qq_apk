package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
  extends a
{
  private long uNF;
  public long uNG;
  private long uOb = 0L;
  public long uOc = 0L;
  public long uOd = 0L;
  public long uOe = 0L;
  
  protected final void bxK()
  {
    AppMethodBeat.i(25508);
    g.yhR.f(12931, new Object[] { Long.valueOf(this.uNF), Long.valueOf(this.uNG), Long.valueOf(this.uOb), Long.valueOf(this.uOc), Long.valueOf(this.uOd), Long.valueOf(this.uOe) });
    AppMethodBeat.o(25508);
  }
  
  public final void reset()
  {
    this.uNF = 0L;
    this.uNG = 0L;
    this.uOb = 0L;
    this.uOc = 0L;
    this.uOd = 0L;
    this.uOe = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25507);
    super.start();
    this.uNF = bt.flT();
    AppMethodBeat.o(25507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.h
 * JD-Core Version:    0.7.0.1
 */
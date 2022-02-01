package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends a
{
  private long uNF;
  public long uNG;
  public long uNU = 0L;
  public String uNV = "";
  public String uNW = "";
  public long uNX = 0L;
  public long uNY = 0L;
  public long uNZ = 0L;
  public String uOa = "";
  
  protected final void bxK()
  {
    AppMethodBeat.i(25506);
    com.tencent.mm.plugin.report.service.g.yhR.f(12933, new Object[] { Long.valueOf(this.uNF), Long.valueOf(this.uNG), Long.valueOf(this.uNU), this.uNV, this.uNW, Long.valueOf(this.uNX), Long.valueOf(this.uNY), Long.valueOf(this.uNZ), this.uOa });
    AppMethodBeat.o(25506);
  }
  
  public final void reset()
  {
    this.uNF = 0L;
    this.uNG = 0L;
    this.uNU = 0L;
    this.uNV = "";
    this.uNW = "";
    this.uNX = 0L;
    this.uNY = 0L;
    this.uNZ = 0L;
    this.uOa = "";
  }
  
  public final void start()
  {
    AppMethodBeat.i(25505);
    super.start();
    this.uNF = bt.flT();
    AppMethodBeat.o(25505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.g
 * JD-Core Version:    0.7.0.1
 */
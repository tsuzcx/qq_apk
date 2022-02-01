package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends a
{
  private long uNF;
  public long uNG;
  public long uNH = 0L;
  public long uNI = 0L;
  public long uNJ = 0L;
  
  protected final void bxK()
  {
    AppMethodBeat.i(25499);
    g.yhR.f(12930, new Object[] { Long.valueOf(this.uNF), Long.valueOf(this.uNG), Long.valueOf(this.uNH), Long.valueOf(this.uNI), Long.valueOf(this.uNJ) });
    AppMethodBeat.o(25499);
  }
  
  public final void reset()
  {
    this.uNF = 0L;
    this.uNG = 0L;
    this.uNH = 0L;
    this.uNI = 0L;
    this.uNJ = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25498);
    super.start();
    this.uNF = bt.flT();
    AppMethodBeat.o(25498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.b
 * JD-Core Version:    0.7.0.1
 */
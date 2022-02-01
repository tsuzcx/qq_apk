package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
  extends a
{
  private long sDG = 0L;
  public long sDH = 0L;
  public long sDI = 0L;
  public long sDJ = 0L;
  private long sDk;
  public long sDl;
  
  protected final void bmJ()
  {
    AppMethodBeat.i(25508);
    com.tencent.mm.plugin.report.service.h.vKh.f(12931, new Object[] { Long.valueOf(this.sDk), Long.valueOf(this.sDl), Long.valueOf(this.sDG), Long.valueOf(this.sDH), Long.valueOf(this.sDI), Long.valueOf(this.sDJ) });
    AppMethodBeat.o(25508);
  }
  
  public final void reset()
  {
    this.sDk = 0L;
    this.sDl = 0L;
    this.sDG = 0L;
    this.sDH = 0L;
    this.sDI = 0L;
    this.sDJ = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25507);
    super.start();
    this.sDk = bt.eGO();
    AppMethodBeat.o(25507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.h
 * JD-Core Version:    0.7.0.1
 */
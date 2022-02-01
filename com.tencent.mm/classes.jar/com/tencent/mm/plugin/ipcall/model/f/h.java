package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends a
{
  private long DRU;
  public long DRV;
  private long DSq = 0L;
  public long DSr = 0L;
  public long DSs = 0L;
  public long DSt = 0L;
  
  protected final void cig()
  {
    AppMethodBeat.i(25508);
    com.tencent.mm.plugin.report.service.h.IzE.a(12931, new Object[] { Long.valueOf(this.DRU), Long.valueOf(this.DRV), Long.valueOf(this.DSq), Long.valueOf(this.DSr), Long.valueOf(this.DSs), Long.valueOf(this.DSt) });
    AppMethodBeat.o(25508);
  }
  
  public final void reset()
  {
    this.DRU = 0L;
    this.DRV = 0L;
    this.DSq = 0L;
    this.DSr = 0L;
    this.DSs = 0L;
    this.DSt = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25507);
    super.start();
    this.DRU = Util.nowMilliSecond();
    AppMethodBeat.o(25507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.h
 * JD-Core Version:    0.7.0.1
 */
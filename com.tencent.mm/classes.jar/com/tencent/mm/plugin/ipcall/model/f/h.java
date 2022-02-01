package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends a
{
  private long JJA = 0L;
  public long JJB = 0L;
  public long JJC = 0L;
  public long JJD = 0L;
  private long JJe;
  public long JJf;
  
  protected final void cIX()
  {
    AppMethodBeat.i(25508);
    com.tencent.mm.plugin.report.service.h.OAn.b(12931, new Object[] { Long.valueOf(this.JJe), Long.valueOf(this.JJf), Long.valueOf(this.JJA), Long.valueOf(this.JJB), Long.valueOf(this.JJC), Long.valueOf(this.JJD) });
    AppMethodBeat.o(25508);
  }
  
  public final void reset()
  {
    this.JJe = 0L;
    this.JJf = 0L;
    this.JJA = 0L;
    this.JJB = 0L;
    this.JJC = 0L;
    this.JJD = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25507);
    super.start();
    this.JJe = Util.nowMilliSecond();
    AppMethodBeat.o(25507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  extends a
{
  private long DRU;
  public long DRV;
  public long DSu = 0L;
  public long DSv = 0L;
  public long DSw = 0L;
  
  protected final void cig()
  {
    AppMethodBeat.i(25511);
    h.IzE.a(12934, new Object[] { Long.valueOf(this.DRU), Long.valueOf(this.DRV), Long.valueOf(this.DSu), Long.valueOf(this.DSv), Long.valueOf(this.DSw) });
    AppMethodBeat.o(25511);
  }
  
  public final void reset()
  {
    this.DRU = 0L;
    this.DRV = 0L;
    this.DSu = 0L;
    this.DSv = 0L;
    this.DSw = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25510);
    super.start();
    this.DRU = Util.nowMilliSecond();
    AppMethodBeat.o(25510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.j
 * JD-Core Version:    0.7.0.1
 */
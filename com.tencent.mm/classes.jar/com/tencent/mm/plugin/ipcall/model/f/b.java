package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends a
{
  private long DRU;
  public long DRV;
  public long DRW = 0L;
  public long DRX = 0L;
  public long DRY = 0L;
  
  protected final void cig()
  {
    AppMethodBeat.i(25499);
    h.IzE.a(12930, new Object[] { Long.valueOf(this.DRU), Long.valueOf(this.DRV), Long.valueOf(this.DRW), Long.valueOf(this.DRX), Long.valueOf(this.DRY) });
    AppMethodBeat.o(25499);
  }
  
  public final void reset()
  {
    this.DRU = 0L;
    this.DRV = 0L;
    this.DRW = 0L;
    this.DRX = 0L;
    this.DRY = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25498);
    super.start();
    this.DRU = Util.nowMilliSecond();
    AppMethodBeat.o(25498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.b
 * JD-Core Version:    0.7.0.1
 */
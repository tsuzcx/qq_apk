package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends a
{
  private long sDk;
  public long sDl;
  public long sDm = 0L;
  public long sDn = 0L;
  public long sDo = 0L;
  
  protected final void bmJ()
  {
    AppMethodBeat.i(25499);
    h.vKh.f(12930, new Object[] { Long.valueOf(this.sDk), Long.valueOf(this.sDl), Long.valueOf(this.sDm), Long.valueOf(this.sDn), Long.valueOf(this.sDo) });
    AppMethodBeat.o(25499);
  }
  
  public final void reset()
  {
    this.sDk = 0L;
    this.sDl = 0L;
    this.sDm = 0L;
    this.sDn = 0L;
    this.sDo = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25498);
    super.start();
    this.sDk = bt.eGO();
    AppMethodBeat.o(25498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends a
{
  private long DRU;
  public long DRV;
  public long DSj = 0L;
  public String DSk = "";
  public String DSl = "";
  public long DSm = 0L;
  public long DSn = 0L;
  public long DSo = 0L;
  public String DSp = "";
  
  protected final void cig()
  {
    AppMethodBeat.i(25506);
    h.IzE.a(12933, new Object[] { Long.valueOf(this.DRU), Long.valueOf(this.DRV), Long.valueOf(this.DSj), this.DSk, this.DSl, Long.valueOf(this.DSm), Long.valueOf(this.DSn), Long.valueOf(this.DSo), this.DSp });
    AppMethodBeat.o(25506);
  }
  
  public final void reset()
  {
    this.DRU = 0L;
    this.DRV = 0L;
    this.DSj = 0L;
    this.DSk = "";
    this.DSl = "";
    this.DSm = 0L;
    this.DSn = 0L;
    this.DSo = 0L;
    this.DSp = "";
  }
  
  public final void start()
  {
    AppMethodBeat.i(25505);
    super.start();
    this.DRU = Util.nowMilliSecond();
    AppMethodBeat.o(25505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.g
 * JD-Core Version:    0.7.0.1
 */
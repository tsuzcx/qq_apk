package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends a
{
  public String sDA = "";
  public String sDB = "";
  public long sDC = 0L;
  public long sDD = 0L;
  public long sDE = 0L;
  public String sDF = "";
  private long sDk;
  public long sDl;
  public long sDz = 0L;
  
  protected final void bmJ()
  {
    AppMethodBeat.i(25506);
    h.vKh.f(12933, new Object[] { Long.valueOf(this.sDk), Long.valueOf(this.sDl), Long.valueOf(this.sDz), this.sDA, this.sDB, Long.valueOf(this.sDC), Long.valueOf(this.sDD), Long.valueOf(this.sDE), this.sDF });
    AppMethodBeat.o(25506);
  }
  
  public final void reset()
  {
    this.sDk = 0L;
    this.sDl = 0L;
    this.sDz = 0L;
    this.sDA = "";
    this.sDB = "";
    this.sDC = 0L;
    this.sDD = 0L;
    this.sDE = 0L;
    this.sDF = "";
  }
  
  public final void start()
  {
    AppMethodBeat.i(25505);
    super.start();
    this.sDk = bt.eGO();
    AppMethodBeat.o(25505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.g
 * JD-Core Version:    0.7.0.1
 */
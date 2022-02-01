package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
  extends a
{
  public long uZH = 0L;
  public String uZI = "";
  public String uZJ = "";
  public long uZK = 0L;
  public long uZL = 0L;
  public long uZM = 0L;
  public String uZN = "";
  private long uZs;
  public long uZt;
  
  protected final void byD()
  {
    AppMethodBeat.i(25506);
    com.tencent.mm.plugin.report.service.g.yxI.f(12933, new Object[] { Long.valueOf(this.uZs), Long.valueOf(this.uZt), Long.valueOf(this.uZH), this.uZI, this.uZJ, Long.valueOf(this.uZK), Long.valueOf(this.uZL), Long.valueOf(this.uZM), this.uZN });
    AppMethodBeat.o(25506);
  }
  
  public final void reset()
  {
    this.uZs = 0L;
    this.uZt = 0L;
    this.uZH = 0L;
    this.uZI = "";
    this.uZJ = "";
    this.uZK = 0L;
    this.uZL = 0L;
    this.uZM = 0L;
    this.uZN = "";
  }
  
  public final void start()
  {
    AppMethodBeat.i(25505);
    super.start();
    this.uZs = bu.fpO();
    AppMethodBeat.o(25505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.g
 * JD-Core Version:    0.7.0.1
 */
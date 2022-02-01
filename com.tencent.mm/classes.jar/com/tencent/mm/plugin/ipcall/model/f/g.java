package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends a
{
  private long yrS;
  public long yrT;
  public long ysh = 0L;
  public String ysi = "";
  public String ysj = "";
  public long ysk = 0L;
  public long ysl = 0L;
  public long ysm = 0L;
  public String ysn = "";
  
  protected final void bUV()
  {
    AppMethodBeat.i(25506);
    h.CyF.a(12933, new Object[] { Long.valueOf(this.yrS), Long.valueOf(this.yrT), Long.valueOf(this.ysh), this.ysi, this.ysj, Long.valueOf(this.ysk), Long.valueOf(this.ysl), Long.valueOf(this.ysm), this.ysn });
    AppMethodBeat.o(25506);
  }
  
  public final void reset()
  {
    this.yrS = 0L;
    this.yrT = 0L;
    this.ysh = 0L;
    this.ysi = "";
    this.ysj = "";
    this.ysk = 0L;
    this.ysl = 0L;
    this.ysm = 0L;
    this.ysn = "";
  }
  
  public final void start()
  {
    AppMethodBeat.i(25505);
    super.start();
    this.yrS = Util.nowMilliSecond();
    AppMethodBeat.o(25505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.g
 * JD-Core Version:    0.7.0.1
 */
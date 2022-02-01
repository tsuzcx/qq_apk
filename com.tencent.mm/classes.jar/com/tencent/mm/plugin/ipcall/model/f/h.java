package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends a
{
  private long yrS;
  public long yrT;
  private long yso = 0L;
  public long ysp = 0L;
  public long ysq = 0L;
  public long ysr = 0L;
  
  protected final void bUV()
  {
    AppMethodBeat.i(25508);
    com.tencent.mm.plugin.report.service.h.CyF.a(12931, new Object[] { Long.valueOf(this.yrS), Long.valueOf(this.yrT), Long.valueOf(this.yso), Long.valueOf(this.ysp), Long.valueOf(this.ysq), Long.valueOf(this.ysr) });
    AppMethodBeat.o(25508);
  }
  
  public final void reset()
  {
    this.yrS = 0L;
    this.yrT = 0L;
    this.yso = 0L;
    this.ysp = 0L;
    this.ysq = 0L;
    this.ysr = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25507);
    super.start();
    this.yrS = Util.nowMilliSecond();
    AppMethodBeat.o(25507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends a
{
  private long yrS;
  public long yrT;
  public long yrU = 0L;
  public long yrV = 0L;
  public long yrW = 0L;
  
  protected final void bUV()
  {
    AppMethodBeat.i(25499);
    h.CyF.a(12930, new Object[] { Long.valueOf(this.yrS), Long.valueOf(this.yrT), Long.valueOf(this.yrU), Long.valueOf(this.yrV), Long.valueOf(this.yrW) });
    AppMethodBeat.o(25499);
  }
  
  public final void reset()
  {
    this.yrS = 0L;
    this.yrT = 0L;
    this.yrU = 0L;
    this.yrV = 0L;
    this.yrW = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25498);
    super.start();
    this.yrS = Util.nowMilliSecond();
    AppMethodBeat.o(25498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.b
 * JD-Core Version:    0.7.0.1
 */
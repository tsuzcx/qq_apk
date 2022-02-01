package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  extends a
{
  private long yrS;
  public long yrT;
  public long yss = 0L;
  public long yst = 0L;
  public long ysu = 0L;
  
  protected final void bUV()
  {
    AppMethodBeat.i(25511);
    h.CyF.a(12934, new Object[] { Long.valueOf(this.yrS), Long.valueOf(this.yrT), Long.valueOf(this.yss), Long.valueOf(this.yst), Long.valueOf(this.ysu) });
    AppMethodBeat.o(25511);
  }
  
  public final void reset()
  {
    this.yrS = 0L;
    this.yrT = 0L;
    this.yss = 0L;
    this.yst = 0L;
    this.ysu = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25510);
    super.start();
    this.yrS = Util.nowMilliSecond();
    AppMethodBeat.o(25510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.j
 * JD-Core Version:    0.7.0.1
 */
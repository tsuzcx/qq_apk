package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  extends a
{
  public long JJE = 0L;
  public long JJF = 0L;
  public long JJG = 0L;
  private long JJe;
  public long JJf;
  
  protected final void cIX()
  {
    AppMethodBeat.i(25511);
    h.OAn.b(12934, new Object[] { Long.valueOf(this.JJe), Long.valueOf(this.JJf), Long.valueOf(this.JJE), Long.valueOf(this.JJF), Long.valueOf(this.JJG) });
    AppMethodBeat.o(25511);
  }
  
  public final void reset()
  {
    this.JJe = 0L;
    this.JJf = 0L;
    this.JJE = 0L;
    this.JJF = 0L;
    this.JJG = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25510);
    super.start();
    this.JJe = Util.nowMilliSecond();
    AppMethodBeat.o(25510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.j
 * JD-Core Version:    0.7.0.1
 */
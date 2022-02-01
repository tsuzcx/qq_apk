package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends a
{
  private long JJe;
  public long JJf;
  public long JJg = 0L;
  public long JJh = 0L;
  public long JJi = 0L;
  
  protected final void cIX()
  {
    AppMethodBeat.i(25499);
    h.OAn.b(12930, new Object[] { Long.valueOf(this.JJe), Long.valueOf(this.JJf), Long.valueOf(this.JJg), Long.valueOf(this.JJh), Long.valueOf(this.JJi) });
    AppMethodBeat.o(25499);
  }
  
  public final void reset()
  {
    this.JJe = 0L;
    this.JJf = 0L;
    this.JJg = 0L;
    this.JJh = 0L;
    this.JJi = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25498);
    super.start();
    this.JJe = Util.nowMilliSecond();
    AppMethodBeat.o(25498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.b
 * JD-Core Version:    0.7.0.1
 */
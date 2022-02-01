package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  extends a
{
  private long tKS;
  public long tKT;
  public long tKU = 0L;
  public long tKV = 0L;
  public long tKW = 0L;
  
  protected final void btF()
  {
    AppMethodBeat.i(25499);
    h.wUl.f(12930, new Object[] { Long.valueOf(this.tKS), Long.valueOf(this.tKT), Long.valueOf(this.tKU), Long.valueOf(this.tKV), Long.valueOf(this.tKW) });
    AppMethodBeat.o(25499);
  }
  
  public final void reset()
  {
    this.tKS = 0L;
    this.tKT = 0L;
    this.tKU = 0L;
    this.tKV = 0L;
    this.tKW = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25498);
    super.start();
    this.tKS = bs.eWj();
    AppMethodBeat.o(25498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.b
 * JD-Core Version:    0.7.0.1
 */
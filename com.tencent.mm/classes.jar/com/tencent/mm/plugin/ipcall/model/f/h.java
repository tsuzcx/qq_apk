package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public final class h
  extends a
{
  private long tKS;
  public long tKT;
  private long tLo = 0L;
  public long tLp = 0L;
  public long tLq = 0L;
  public long tLr = 0L;
  
  protected final void btF()
  {
    AppMethodBeat.i(25508);
    com.tencent.mm.plugin.report.service.h.wUl.f(12931, new Object[] { Long.valueOf(this.tKS), Long.valueOf(this.tKT), Long.valueOf(this.tLo), Long.valueOf(this.tLp), Long.valueOf(this.tLq), Long.valueOf(this.tLr) });
    AppMethodBeat.o(25508);
  }
  
  public final void reset()
  {
    this.tKS = 0L;
    this.tKT = 0L;
    this.tLo = 0L;
    this.tLp = 0L;
    this.tLq = 0L;
    this.tLr = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25507);
    super.start();
    this.tKS = bs.eWj();
    AppMethodBeat.o(25507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.h
 * JD-Core Version:    0.7.0.1
 */
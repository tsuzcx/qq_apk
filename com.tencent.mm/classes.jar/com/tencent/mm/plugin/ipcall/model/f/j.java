package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bs;

public final class j
  extends a
{
  private long tKS;
  public long tKT;
  public long tLs = 0L;
  public long tLt = 0L;
  public long tLu = 0L;
  
  protected final void btF()
  {
    AppMethodBeat.i(25511);
    h.wUl.f(12934, new Object[] { Long.valueOf(this.tKS), Long.valueOf(this.tKT), Long.valueOf(this.tLs), Long.valueOf(this.tLt), Long.valueOf(this.tLu) });
    AppMethodBeat.o(25511);
  }
  
  public final void reset()
  {
    this.tKS = 0L;
    this.tKT = 0L;
    this.tLs = 0L;
    this.tLt = 0L;
    this.tLu = 0L;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25510);
    super.start();
    this.tKS = bs.eWj();
    AppMethodBeat.o(25510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.j
 * JD-Core Version:    0.7.0.1
 */
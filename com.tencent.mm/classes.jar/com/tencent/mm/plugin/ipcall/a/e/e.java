package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class e
  extends a
{
  public long nPu = 0L;
  public long nPv = 0L;
  
  public final void bJP()
  {
    AppMethodBeat.i(21887);
    h.qsU.e(12935, new Object[] { Long.valueOf(this.nPu), Long.valueOf(this.nPv) });
    AppMethodBeat.o(21887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.e
 * JD-Core Version:    0.7.0.1
 */
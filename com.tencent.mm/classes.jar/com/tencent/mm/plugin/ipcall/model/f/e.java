package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public final class e
  extends a
{
  public long uZx = 0L;
  public long uZy = 0L;
  
  public final void byD()
  {
    AppMethodBeat.i(25502);
    g.yxI.f(12935, new Object[] { Long.valueOf(this.uZx), Long.valueOf(this.uZy) });
    AppMethodBeat.o(25502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.e
 * JD-Core Version:    0.7.0.1
 */
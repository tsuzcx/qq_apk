package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public final class e
  extends a
{
  public long uNK = 0L;
  public long uNL = 0L;
  
  public final void bxK()
  {
    AppMethodBeat.i(25502);
    g.yhR.f(12935, new Object[] { Long.valueOf(this.uNK), Long.valueOf(this.uNL) });
    AppMethodBeat.o(25502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.e
 * JD-Core Version:    0.7.0.1
 */
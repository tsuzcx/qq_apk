package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class e
  extends a
{
  public long yrX = 0L;
  public long yrY = 0L;
  
  public final void bUV()
  {
    AppMethodBeat.i(25502);
    h.CyF.a(12935, new Object[] { Long.valueOf(this.yrX), Long.valueOf(this.yrY) });
    AppMethodBeat.o(25502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.e
 * JD-Core Version:    0.7.0.1
 */
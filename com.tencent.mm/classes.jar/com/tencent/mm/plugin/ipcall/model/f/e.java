package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class e
  extends a
{
  public long DRZ = 0L;
  public long DSa = 0L;
  
  public final void cig()
  {
    AppMethodBeat.i(25502);
    h.IzE.a(12935, new Object[] { Long.valueOf(this.DRZ), Long.valueOf(this.DSa) });
    AppMethodBeat.o(25502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.e
 * JD-Core Version:    0.7.0.1
 */
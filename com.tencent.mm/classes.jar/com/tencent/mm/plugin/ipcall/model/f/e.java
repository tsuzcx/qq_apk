package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class e
  extends a
{
  public long sDp = 0L;
  public long sDq = 0L;
  
  public final void bmJ()
  {
    AppMethodBeat.i(25502);
    h.vKh.f(12935, new Object[] { Long.valueOf(this.sDp), Long.valueOf(this.sDq) });
    AppMethodBeat.o(25502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.e
 * JD-Core Version:    0.7.0.1
 */
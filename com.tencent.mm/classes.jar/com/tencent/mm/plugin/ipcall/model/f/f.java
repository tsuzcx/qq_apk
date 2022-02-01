package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class f
  extends a
{
  public int sDr = 0;
  public int sDs = 0;
  public int sDt = 0;
  public int sDu = 0;
  public int sDv = -9999;
  public String sDw = "";
  public int sDx = 0;
  public int sDy = 0;
  
  protected final void bmJ()
  {
    AppMethodBeat.i(25504);
    h.vKh.f(14182, new Object[] { Integer.valueOf(this.sDr), Integer.valueOf(this.sDs), Integer.valueOf(this.sDt), Integer.valueOf(this.sDu), Integer.valueOf(this.sDv), this.sDw, Integer.valueOf(this.sDx), Integer.valueOf(this.sDy) });
    AppMethodBeat.o(25504);
  }
  
  public final void reset()
  {
    this.sDr = 0;
    this.sDs = 0;
    this.sDt = 0;
    this.sDu = 0;
    this.sDv = -9999;
    this.sDw = "";
    this.sDx = 0;
    this.sDy = 0;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25503);
    super.start();
    AppMethodBeat.o(25503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.f
 * JD-Core Version:    0.7.0.1
 */
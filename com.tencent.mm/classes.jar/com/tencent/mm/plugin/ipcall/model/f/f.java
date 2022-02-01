package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class f
  extends a
{
  public int DSb = 0;
  public int DSc = 0;
  public int DSd = 0;
  public int DSe = 0;
  public int DSf = -9999;
  public String DSg = "";
  public int DSh = 0;
  public int DSi = 0;
  
  protected final void cig()
  {
    AppMethodBeat.i(25504);
    h.IzE.a(14182, new Object[] { Integer.valueOf(this.DSb), Integer.valueOf(this.DSc), Integer.valueOf(this.DSd), Integer.valueOf(this.DSe), Integer.valueOf(this.DSf), this.DSg, Integer.valueOf(this.DSh), Integer.valueOf(this.DSi) });
    AppMethodBeat.o(25504);
  }
  
  public final void reset()
  {
    this.DSb = 0;
    this.DSc = 0;
    this.DSd = 0;
    this.DSe = 0;
    this.DSf = -9999;
    this.DSg = "";
    this.DSh = 0;
    this.DSi = 0;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25503);
    super.start();
    AppMethodBeat.o(25503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.f
 * JD-Core Version:    0.7.0.1
 */
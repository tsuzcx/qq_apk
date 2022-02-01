package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public final class f
  extends a
{
  public int uZA = 0;
  public int uZB = 0;
  public int uZC = 0;
  public int uZD = -9999;
  public String uZE = "";
  public int uZF = 0;
  public int uZG = 0;
  public int uZz = 0;
  
  protected final void byD()
  {
    AppMethodBeat.i(25504);
    g.yxI.f(14182, new Object[] { Integer.valueOf(this.uZz), Integer.valueOf(this.uZA), Integer.valueOf(this.uZB), Integer.valueOf(this.uZC), Integer.valueOf(this.uZD), this.uZE, Integer.valueOf(this.uZF), Integer.valueOf(this.uZG) });
    AppMethodBeat.o(25504);
  }
  
  public final void reset()
  {
    this.uZz = 0;
    this.uZA = 0;
    this.uZB = 0;
    this.uZC = 0;
    this.uZD = -9999;
    this.uZE = "";
    this.uZF = 0;
    this.uZG = 0;
  }
  
  public final void start()
  {
    AppMethodBeat.i(25503);
    super.start();
    AppMethodBeat.o(25503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.f
 * JD-Core Version:    0.7.0.1
 */
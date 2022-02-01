package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public final class f
  extends a
{
  public int uNM = 0;
  public int uNN = 0;
  public int uNO = 0;
  public int uNP = 0;
  public int uNQ = -9999;
  public String uNR = "";
  public int uNS = 0;
  public int uNT = 0;
  
  protected final void bxK()
  {
    AppMethodBeat.i(25504);
    g.yhR.f(14182, new Object[] { Integer.valueOf(this.uNM), Integer.valueOf(this.uNN), Integer.valueOf(this.uNO), Integer.valueOf(this.uNP), Integer.valueOf(this.uNQ), this.uNR, Integer.valueOf(this.uNS), Integer.valueOf(this.uNT) });
    AppMethodBeat.o(25504);
  }
  
  public final void reset()
  {
    this.uNM = 0;
    this.uNN = 0;
    this.uNO = 0;
    this.uNP = 0;
    this.uNQ = -9999;
    this.uNR = "";
    this.uNS = 0;
    this.uNT = 0;
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
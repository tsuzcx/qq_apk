package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class f
  extends a
{
  public int nPA = -9999;
  public String nPB = "";
  public int nPC = 0;
  public int nPD = 0;
  public int nPw = 0;
  public int nPx = 0;
  public int nPy = 0;
  public int nPz = 0;
  
  protected final void bJP()
  {
    AppMethodBeat.i(21889);
    h.qsU.e(14182, new Object[] { Integer.valueOf(this.nPw), Integer.valueOf(this.nPx), Integer.valueOf(this.nPy), Integer.valueOf(this.nPz), Integer.valueOf(this.nPA), this.nPB, Integer.valueOf(this.nPC), Integer.valueOf(this.nPD) });
    AppMethodBeat.o(21889);
  }
  
  public final void reset()
  {
    this.nPw = 0;
    this.nPx = 0;
    this.nPy = 0;
    this.nPz = 0;
    this.nPA = -9999;
    this.nPB = "";
    this.nPC = 0;
    this.nPD = 0;
  }
  
  public final void start()
  {
    AppMethodBeat.i(21888);
    super.start();
    AppMethodBeat.o(21888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.f
 * JD-Core Version:    0.7.0.1
 */
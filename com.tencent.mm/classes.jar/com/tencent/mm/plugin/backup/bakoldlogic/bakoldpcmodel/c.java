package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
{
  public int hJc;
  public int nGA;
  public int nGu;
  public int nGv;
  private int nGw;
  int nGx;
  int nGy;
  int nGz;
  
  private String getString()
  {
    AppMethodBeat.i(21884);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.nGu), Integer.valueOf(this.nGv), Integer.valueOf(this.hJc), Integer.valueOf(this.nGw), Integer.valueOf(this.nGx), Integer.valueOf(this.nGy), Integer.valueOf(this.nGz), Integer.valueOf(this.nGA) });
    AppMethodBeat.o(21884);
    return str;
  }
  
  private void reset()
  {
    this.nGu = 0;
    this.nGv = 0;
    this.hJc = 0;
    this.nGw = 0;
    this.nGx = 0;
    this.nGy = 0;
    this.nGz = 0;
    this.nGA = 0;
  }
  
  public final void aCO()
  {
    AppMethodBeat.i(21883);
    if (this.nGu == 0)
    {
      reset();
      AppMethodBeat.o(21883);
      return;
    }
    String str = getString();
    ae.i("MicroMsg.BakPCReportor", "report: %s", new Object[] { str });
    g.yxI.kvStat(11103, str);
    reset();
    AppMethodBeat.o(21883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c
 * JD-Core Version:    0.7.0.1
 */
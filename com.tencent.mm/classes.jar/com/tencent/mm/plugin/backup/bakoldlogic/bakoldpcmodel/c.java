package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
{
  public int hnS;
  public int naC;
  public int naD;
  private int naE;
  int naF;
  int naG;
  int naH;
  public int naI;
  
  private String getString()
  {
    AppMethodBeat.i(21884);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.naC), Integer.valueOf(this.naD), Integer.valueOf(this.hnS), Integer.valueOf(this.naE), Integer.valueOf(this.naF), Integer.valueOf(this.naG), Integer.valueOf(this.naH), Integer.valueOf(this.naI) });
    AppMethodBeat.o(21884);
    return str;
  }
  
  private void reset()
  {
    this.naC = 0;
    this.naD = 0;
    this.hnS = 0;
    this.naE = 0;
    this.naF = 0;
    this.naG = 0;
    this.naH = 0;
    this.naI = 0;
  }
  
  public final void azv()
  {
    AppMethodBeat.i(21883);
    if (this.naC == 0)
    {
      reset();
      AppMethodBeat.o(21883);
      return;
    }
    String str = getString();
    ac.i("MicroMsg.BakPCReportor", "report: %s", new Object[] { str });
    h.wUl.kvStat(11103, str);
    reset();
    AppMethodBeat.o(21883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c
 * JD-Core Version:    0.7.0.1
 */
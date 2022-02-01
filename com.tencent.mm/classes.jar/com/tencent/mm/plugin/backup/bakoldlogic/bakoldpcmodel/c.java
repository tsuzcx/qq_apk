package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public int olm;
  public int veG;
  public int veH;
  private int veI;
  int veJ;
  int veK;
  int veL;
  public int veM;
  
  private String getString()
  {
    AppMethodBeat.i(21884);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.veG), Integer.valueOf(this.veH), Integer.valueOf(this.olm), Integer.valueOf(this.veI), Integer.valueOf(this.veJ), Integer.valueOf(this.veK), Integer.valueOf(this.veL), Integer.valueOf(this.veM) });
    AppMethodBeat.o(21884);
    return str;
  }
  
  private void reset()
  {
    this.veG = 0;
    this.veH = 0;
    this.olm = 0;
    this.veI = 0;
    this.veJ = 0;
    this.veK = 0;
    this.veL = 0;
    this.veM = 0;
  }
  
  public final void bDh()
  {
    AppMethodBeat.i(21883);
    if (this.veG == 0)
    {
      reset();
      AppMethodBeat.o(21883);
      return;
    }
    String str = getString();
    Log.i("MicroMsg.BakPCReportor", "report: %s", new Object[] { str });
    h.OAn.kvStat(11103, str);
    reset();
    AppMethodBeat.o(21883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c
 * JD-Core Version:    0.7.0.1
 */
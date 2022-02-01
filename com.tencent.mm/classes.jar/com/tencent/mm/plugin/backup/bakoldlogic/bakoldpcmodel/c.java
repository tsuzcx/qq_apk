package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public int iDM;
  public int oRr;
  public int oRs;
  private int oRt;
  int oRu;
  int oRv;
  int oRw;
  public int oRx;
  
  private String getString()
  {
    AppMethodBeat.i(21884);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.oRr), Integer.valueOf(this.oRs), Integer.valueOf(this.iDM), Integer.valueOf(this.oRt), Integer.valueOf(this.oRu), Integer.valueOf(this.oRv), Integer.valueOf(this.oRw), Integer.valueOf(this.oRx) });
    AppMethodBeat.o(21884);
    return str;
  }
  
  private void reset()
  {
    this.oRr = 0;
    this.oRs = 0;
    this.iDM = 0;
    this.oRt = 0;
    this.oRu = 0;
    this.oRv = 0;
    this.oRw = 0;
    this.oRx = 0;
  }
  
  public final void aWm()
  {
    AppMethodBeat.i(21883);
    if (this.oRr == 0)
    {
      reset();
      AppMethodBeat.o(21883);
      return;
    }
    String str = getString();
    Log.i("MicroMsg.BakPCReportor", "report: %s", new Object[] { str });
    h.CyF.kvStat(11103, str);
    reset();
    AppMethodBeat.o(21883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c
 * JD-Core Version:    0.7.0.1
 */
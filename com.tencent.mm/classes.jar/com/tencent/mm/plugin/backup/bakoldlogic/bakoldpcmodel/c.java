package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public int gNs;
  public int myB;
  public int myC;
  private int myD;
  int myE;
  int myF;
  int myG;
  public int myH;
  
  private String getString()
  {
    AppMethodBeat.i(21884);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.myB), Integer.valueOf(this.myC), Integer.valueOf(this.gNs), Integer.valueOf(this.myD), Integer.valueOf(this.myE), Integer.valueOf(this.myF), Integer.valueOf(this.myG), Integer.valueOf(this.myH) });
    AppMethodBeat.o(21884);
    return str;
  }
  
  private void reset()
  {
    this.myB = 0;
    this.myC = 0;
    this.gNs = 0;
    this.myD = 0;
    this.myE = 0;
    this.myF = 0;
    this.myG = 0;
    this.myH = 0;
  }
  
  public final void asE()
  {
    AppMethodBeat.i(21883);
    if (this.myB == 0)
    {
      reset();
      AppMethodBeat.o(21883);
      return;
    }
    String str = getString();
    ad.i("MicroMsg.BakPCReportor", "report: %s", new Object[] { str });
    h.vKh.kvStat(11103, str);
    reset();
    AppMethodBeat.o(21883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public int hGk;
  public int nAZ;
  public int nBa;
  private int nBb;
  int nBc;
  int nBd;
  int nBe;
  public int nBf;
  
  private String getString()
  {
    AppMethodBeat.i(21884);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.nAZ), Integer.valueOf(this.nBa), Integer.valueOf(this.hGk), Integer.valueOf(this.nBb), Integer.valueOf(this.nBc), Integer.valueOf(this.nBd), Integer.valueOf(this.nBe), Integer.valueOf(this.nBf) });
    AppMethodBeat.o(21884);
    return str;
  }
  
  private void reset()
  {
    this.nAZ = 0;
    this.nBa = 0;
    this.hGk = 0;
    this.nBb = 0;
    this.nBc = 0;
    this.nBd = 0;
    this.nBe = 0;
    this.nBf = 0;
  }
  
  public final void aCy()
  {
    AppMethodBeat.i(21883);
    if (this.nAZ == 0)
    {
      reset();
      AppMethodBeat.o(21883);
      return;
    }
    String str = getString();
    ad.i("MicroMsg.BakPCReportor", "report: %s", new Object[] { str });
    g.yhR.kvStat(11103, str);
    reset();
    AppMethodBeat.o(21883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c
 * JD-Core Version:    0.7.0.1
 */
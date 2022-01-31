package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public int dVU;
  public int hNH;
  public int hNI;
  private int hNJ;
  int hNK;
  int hNL;
  int hNM;
  public int hNN;
  
  private void reset()
  {
    this.hNH = 0;
    this.hNI = 0;
    this.dVU = 0;
    this.hNJ = 0;
    this.hNK = 0;
    this.hNL = 0;
    this.hNM = 0;
    this.hNN = 0;
  }
  
  public final void Ig()
  {
    if (this.hNH == 0)
    {
      reset();
      return;
    }
    String str = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.hNH), Integer.valueOf(this.hNI), Integer.valueOf(this.dVU), Integer.valueOf(this.hNJ), Integer.valueOf(this.hNK), Integer.valueOf(this.hNL), Integer.valueOf(this.hNM), Integer.valueOf(this.hNN) });
    y.i("MicroMsg.BakPCReportor", "report: %s", new Object[] { str });
    h.nFQ.aC(11103, str);
    reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c
 * JD-Core Version:    0.7.0.1
 */
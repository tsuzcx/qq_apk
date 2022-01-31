package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
{
  public int fme;
  public int jHj;
  public int jHk;
  private int jHl;
  int jHm;
  int jHn;
  int jHo;
  public int jHp;
  
  private String getString()
  {
    AppMethodBeat.i(17827);
    String str = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.jHj), Integer.valueOf(this.jHk), Integer.valueOf(this.fme), Integer.valueOf(this.jHl), Integer.valueOf(this.jHm), Integer.valueOf(this.jHn), Integer.valueOf(this.jHo), Integer.valueOf(this.jHp) });
    AppMethodBeat.o(17827);
    return str;
  }
  
  private void reset()
  {
    this.jHj = 0;
    this.jHk = 0;
    this.fme = 0;
    this.jHl = 0;
    this.jHm = 0;
    this.jHn = 0;
    this.jHo = 0;
    this.jHp = 0;
  }
  
  public final void abd()
  {
    AppMethodBeat.i(17826);
    if (this.jHj == 0)
    {
      reset();
      AppMethodBeat.o(17826);
      return;
    }
    String str = getString();
    ab.i("MicroMsg.BakPCReportor", "report: %s", new Object[] { str });
    h.qsU.kvStat(11103, str);
    reset();
    AppMethodBeat.o(17826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c
 * JD-Core Version:    0.7.0.1
 */
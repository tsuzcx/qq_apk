package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
  extends a
{
  public long nPE = 0L;
  public String nPF = "";
  public String nPG = "";
  public long nPH = 0L;
  public long nPI = 0L;
  public long nPJ = 0L;
  public String nPK = "";
  private long nPp;
  public long nPq;
  
  protected final void bJP()
  {
    AppMethodBeat.i(21891);
    h.qsU.e(12933, new Object[] { Long.valueOf(this.nPp), Long.valueOf(this.nPq), Long.valueOf(this.nPE), this.nPF, this.nPG, Long.valueOf(this.nPH), Long.valueOf(this.nPI), Long.valueOf(this.nPJ), this.nPK });
    AppMethodBeat.o(21891);
  }
  
  public final void reset()
  {
    this.nPp = 0L;
    this.nPq = 0L;
    this.nPE = 0L;
    this.nPF = "";
    this.nPG = "";
    this.nPH = 0L;
    this.nPI = 0L;
    this.nPJ = 0L;
    this.nPK = "";
  }
  
  public final void start()
  {
    AppMethodBeat.i(21890);
    super.start();
    this.nPp = bo.aoy();
    AppMethodBeat.o(21890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.g
 * JD-Core Version:    0.7.0.1
 */
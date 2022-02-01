package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  extends a
{
  private long tKS;
  public long tKT;
  public long tLh = 0L;
  public String tLi = "";
  public String tLj = "";
  public long tLk = 0L;
  public long tLl = 0L;
  public long tLm = 0L;
  public String tLn = "";
  
  protected final void btF()
  {
    AppMethodBeat.i(25506);
    h.wUl.f(12933, new Object[] { Long.valueOf(this.tKS), Long.valueOf(this.tKT), Long.valueOf(this.tLh), this.tLi, this.tLj, Long.valueOf(this.tLk), Long.valueOf(this.tLl), Long.valueOf(this.tLm), this.tLn });
    AppMethodBeat.o(25506);
  }
  
  public final void reset()
  {
    this.tKS = 0L;
    this.tKT = 0L;
    this.tLh = 0L;
    this.tLi = "";
    this.tLj = "";
    this.tLk = 0L;
    this.tLl = 0L;
    this.tLm = 0L;
    this.tLn = "";
  }
  
  public final void start()
  {
    AppMethodBeat.i(25505);
    super.start();
    this.tKS = bs.eWj();
    AppMethodBeat.o(25505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.f.g
 * JD-Core Version:    0.7.0.1
 */
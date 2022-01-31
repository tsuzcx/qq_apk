package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

public final class g
  extends a
{
  private long lrT;
  public long lrU;
  public long lsj = 0L;
  public String lsk = "";
  public String lsl = "";
  public long lsm = 0L;
  public long lsn = 0L;
  public long lso = 0L;
  public String lsp = "";
  
  protected final void bcI()
  {
    h.nFQ.f(12933, new Object[] { Long.valueOf(this.lrT), Long.valueOf(this.lrU), Long.valueOf(this.lsj), this.lsk, this.lsl, Long.valueOf(this.lsm), Long.valueOf(this.lsn), Long.valueOf(this.lso), this.lsp });
  }
  
  public final void reset()
  {
    this.lrT = 0L;
    this.lrU = 0L;
    this.lsj = 0L;
    this.lsk = "";
    this.lsl = "";
    this.lsm = 0L;
    this.lsn = 0L;
    this.lso = 0L;
    this.lsp = "";
  }
  
  public final void start()
  {
    super.start();
    this.lrT = bk.UY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.g
 * JD-Core Version:    0.7.0.1
 */
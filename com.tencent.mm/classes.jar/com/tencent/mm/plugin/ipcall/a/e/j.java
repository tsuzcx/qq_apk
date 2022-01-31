package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

public final class j
  extends a
{
  private long lrT;
  public long lrU;
  public long lsu = 0L;
  public long lsv = 0L;
  public long lsw = 0L;
  
  protected final void bcI()
  {
    h.nFQ.f(12934, new Object[] { Long.valueOf(this.lrT), Long.valueOf(this.lrU), Long.valueOf(this.lsu), Long.valueOf(this.lsv), Long.valueOf(this.lsw) });
  }
  
  public final void reset()
  {
    this.lrT = 0L;
    this.lrU = 0L;
    this.lsu = 0L;
    this.lsv = 0L;
    this.lsw = 0L;
  }
  
  public final void start()
  {
    super.start();
    this.lrT = bk.UY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.j
 * JD-Core Version:    0.7.0.1
 */
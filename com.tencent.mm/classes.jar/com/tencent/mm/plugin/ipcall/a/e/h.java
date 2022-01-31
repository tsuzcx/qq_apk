package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.sdk.platformtools.bk;

public final class h
  extends a
{
  private long lrT;
  public long lrU;
  private long lsq = 0L;
  public long lsr = 0L;
  public long lss = 0L;
  public long lst = 0L;
  
  protected final void bcI()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(12931, new Object[] { Long.valueOf(this.lrT), Long.valueOf(this.lrU), Long.valueOf(this.lsq), Long.valueOf(this.lsr), Long.valueOf(this.lss), Long.valueOf(this.lst) });
  }
  
  public final void reset()
  {
    this.lrT = 0L;
    this.lrU = 0L;
    this.lsq = 0L;
    this.lsr = 0L;
    this.lss = 0L;
    this.lst = 0L;
  }
  
  public final void start()
  {
    super.start();
    this.lrT = bk.UY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

public final class b
  extends a
{
  private long lrT;
  public long lrU;
  public long lrV = 0L;
  public long lrW = 0L;
  public long lrX = 0L;
  
  protected final void bcI()
  {
    h.nFQ.f(12930, new Object[] { Long.valueOf(this.lrT), Long.valueOf(this.lrU), Long.valueOf(this.lrV), Long.valueOf(this.lrW), Long.valueOf(this.lrX) });
  }
  
  public final void reset()
  {
    this.lrT = 0L;
    this.lrU = 0L;
    this.lrV = 0L;
    this.lrW = 0L;
    this.lrX = 0L;
  }
  
  public final void start()
  {
    super.start();
    this.lrT = bk.UY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.b
 * JD-Core Version:    0.7.0.1
 */
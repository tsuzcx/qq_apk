package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.report.service.h;

public final class l
{
  long[] fzl = new long[15];
  int fzm;
  int fzn;
  private int fzo = 0;
  boolean fzp;
  boolean fzq;
  int fzr;
  int mType;
  int mVersion;
  
  public l()
  {
    if (d.aaE()) {
      i = 1;
    }
    this.fzo = i;
  }
  
  final void e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    h localh = h.nFQ;
    int j = this.mVersion;
    int k = this.mType;
    long l = this.fzl[paramInt2];
    int m = this.fzm;
    int n = this.fzo;
    int i1 = this.fzn;
    if (this.fzp)
    {
      paramInt2 = 1;
      if (!this.fzq) {
        break label215;
      }
    }
    for (;;)
    {
      localh.f(13886, new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt1), "", "", Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.fzr) });
      return;
      paramInt2 = 0;
      break;
      label215:
      i = 0;
    }
  }
  
  public final void n(int paramInt, long paramLong)
  {
    if ((paramInt >= this.fzl.length) || (this.fzl[paramInt] != 0L)) {
      return;
    }
    this.fzl[paramInt] = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l
 * JD-Core Version:    0.7.0.1
 */
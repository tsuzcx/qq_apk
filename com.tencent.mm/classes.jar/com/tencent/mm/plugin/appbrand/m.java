package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.report.service.h;

public final class m
{
  int cO;
  long[] gQO;
  int gQP;
  private int gQQ;
  boolean gQR;
  boolean gQS;
  int gQT;
  int mScene;
  int mType;
  
  public m()
  {
    AppMethodBeat.i(128973);
    this.gQQ = 0;
    this.gQO = new long[15];
    if (e.aul()) {
      i = 1;
    }
    this.gQQ = i;
    AppMethodBeat.o(128973);
  }
  
  public final void C(int paramInt, long paramLong)
  {
    if ((paramInt >= this.gQO.length) || (this.gQO[paramInt] != 0L)) {
      return;
    }
    this.gQO[paramInt] = paramLong;
  }
  
  final void f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(128974);
    h localh = h.qsU;
    int j = this.cO;
    int k = this.mType;
    long l = this.gQO[paramInt2];
    int m = this.gQP;
    int n = this.gQQ;
    int i1 = this.mScene;
    if (this.gQR)
    {
      paramInt2 = 1;
      if (!this.gQS) {
        break label225;
      }
    }
    for (;;)
    {
      localh.e(13886, new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt1), "", "", Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.gQT) });
      AppMethodBeat.o(128974);
      return;
      paramInt2 = 0;
      break;
      label225:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m
 * JD-Core Version:    0.7.0.1
 */
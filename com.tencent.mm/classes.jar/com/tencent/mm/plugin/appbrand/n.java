package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.task.c;
import com.tencent.mm.plugin.report.service.g;

public final class n
{
  int cR;
  long[] jBL;
  int jBM;
  int jBN;
  boolean jBO;
  boolean jBP;
  int jBQ;
  int mScene;
  int mType;
  
  public n()
  {
    AppMethodBeat.i(43853);
    this.jBN = 0;
    this.jBL = new long[15];
    if (c.aYd()) {
      i = 1;
    }
    this.jBN = i;
    AppMethodBeat.o(43853);
  }
  
  public static void a(int paramInt, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(221988);
    a(paramInt, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.aDD, paramAppBrandInitConfigWC.dQv, paramAppBrandInitConfigWC.Ee());
    AppMethodBeat.o(221988);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(221989);
    int i = 369;
    if (paramBoolean) {
      i = 777;
    }
    try
    {
      g.yxI.idkeyStat(i, paramInt1, 1L, false);
      h.b(paramString, paramInt2, paramInt3, i, paramInt1);
      AppMethodBeat.o(221989);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(221989);
    }
  }
  
  public final void F(int paramInt, long paramLong)
  {
    if ((paramInt >= this.jBL.length) || (this.jBL[paramInt] != 0L)) {
      return;
    }
    this.jBL[paramInt] = paramLong;
  }
  
  final void g(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(43854);
    g localg = g.yxI;
    int j = this.cR;
    int k = this.mType;
    long l = this.jBL[paramInt2];
    int m = this.jBM;
    int n = this.jBN;
    int i1 = this.mScene;
    if (this.jBO)
    {
      paramInt2 = 1;
      if (!this.jBP) {
        break label225;
      }
    }
    for (;;)
    {
      localg.f(13886, new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt1), "", "", Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.jBQ) });
      AppMethodBeat.o(43854);
      return;
      paramInt2 = 0;
      break;
      label225:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n
 * JD-Core Version:    0.7.0.1
 */
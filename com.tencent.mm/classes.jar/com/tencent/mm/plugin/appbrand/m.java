package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.task.c;
import com.tencent.mm.plugin.report.service.g;

public final class m
{
  int cR;
  long[] jyL;
  int jyM;
  int jyN;
  boolean jyO;
  boolean jyP;
  int jyQ;
  int mScene;
  int mType;
  
  public m()
  {
    AppMethodBeat.i(43853);
    this.jyN = 0;
    this.jyL = new long[15];
    if (c.aXK()) {
      i = 1;
    }
    this.jyN = i;
    AppMethodBeat.o(43853);
  }
  
  public static void a(int paramInt, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(187880);
    a(paramInt, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.aDD, paramAppBrandInitConfigWC.dPf, paramAppBrandInitConfigWC.Eb());
    AppMethodBeat.o(187880);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(187881);
    int i = 369;
    if (paramBoolean) {
      i = 777;
    }
    try
    {
      g.yhR.idkeyStat(i, paramInt1, 1L, false);
      h.b(paramString, paramInt2, paramInt3, i, paramInt1);
      AppMethodBeat.o(187881);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(187881);
    }
  }
  
  public final void G(int paramInt, long paramLong)
  {
    if ((paramInt >= this.jyL.length) || (this.jyL[paramInt] != 0L)) {
      return;
    }
    this.jyL[paramInt] = paramLong;
  }
  
  final void g(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(43854);
    g localg = g.yhR;
    int j = this.cR;
    int k = this.mType;
    long l = this.jyL[paramInt2];
    int m = this.jyM;
    int n = this.jyN;
    int i1 = this.mScene;
    if (this.jyO)
    {
      paramInt2 = 1;
      if (!this.jyP) {
        break label225;
      }
    }
    for (;;)
    {
      localg.f(13886, new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt1), "", "", Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.jyQ) });
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m
 * JD-Core Version:    0.7.0.1
 */
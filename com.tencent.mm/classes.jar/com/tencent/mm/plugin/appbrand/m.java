package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.task.c;
import com.tencent.mm.plugin.report.service.h;

public final class m
{
  int cR;
  long[] jfF;
  int jfG;
  int jfH;
  boolean jfI;
  boolean jfJ;
  int jfK;
  int mScene;
  int mType;
  
  public m()
  {
    AppMethodBeat.i(43853);
    this.jfH = 0;
    this.jfF = new long[15];
    if (c.aUy()) {
      i = 1;
    }
    this.jfH = i;
    AppMethodBeat.o(43853);
  }
  
  public static void a(int paramInt, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(186224);
    a(paramInt, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.aBM, paramAppBrandInitConfigWC.joY, paramAppBrandInitConfigWC.CC());
    AppMethodBeat.o(186224);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(186225);
    int i = 369;
    if (paramBoolean) {
      i = 777;
    }
    try
    {
      h.wUl.idkeyStat(i, paramInt1, 1L, false);
      g.b(paramString, paramInt2, paramInt3, i, paramInt1);
      AppMethodBeat.o(186225);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(186225);
    }
  }
  
  public final void E(int paramInt, long paramLong)
  {
    if ((paramInt >= this.jfF.length) || (this.jfF[paramInt] != 0L)) {
      return;
    }
    this.jfF[paramInt] = paramLong;
  }
  
  final void g(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(43854);
    h localh = h.wUl;
    int j = this.cR;
    int k = this.mType;
    long l = this.jfF[paramInt2];
    int m = this.jfG;
    int n = this.jfH;
    int i1 = this.mScene;
    if (this.jfI)
    {
      paramInt2 = 1;
      if (!this.jfJ) {
        break label225;
      }
    }
    for (;;)
    {
      localh.f(13886, new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt1), "", "", Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.jfK) });
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
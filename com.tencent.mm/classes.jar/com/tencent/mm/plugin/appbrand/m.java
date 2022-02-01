package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.task.c;

public final class m
{
  int cR;
  long[] iFD;
  int iFE;
  int iFF;
  boolean iFG;
  boolean iFH;
  int iFI;
  int mScene;
  int mType;
  
  public m()
  {
    AppMethodBeat.i(43853);
    this.iFF = 0;
    this.iFD = new long[15];
    if (c.aNI()) {
      i = 1;
    }
    this.iFF = i;
    AppMethodBeat.o(43853);
  }
  
  public static void a(int paramInt, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(195525);
    a(paramInt, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.aAS, paramAppBrandInitConfigWC.iOP, paramAppBrandInitConfigWC.CZ());
    AppMethodBeat.o(195525);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(195526);
    int i = 369;
    if (paramBoolean) {
      i = 777;
    }
    try
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(i, paramInt1, 1L, false);
      com.tencent.mm.plugin.appbrand.report.h.b(paramString, paramInt2, paramInt3, i, paramInt1);
      AppMethodBeat.o(195526);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(195526);
    }
  }
  
  public final void F(int paramInt, long paramLong)
  {
    if ((paramInt >= this.iFD.length) || (this.iFD[paramInt] != 0L)) {
      return;
    }
    this.iFD[paramInt] = paramLong;
  }
  
  final void g(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(43854);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
    int j = this.cR;
    int k = this.mType;
    long l = this.iFD[paramInt2];
    int m = this.iFE;
    int n = this.iFF;
    int i1 = this.mScene;
    if (this.iFG)
    {
      paramInt2 = 1;
      if (!this.iFH) {
        break label225;
      }
    }
    for (;;)
    {
      localh.f(13886, new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt1), "", "", Long.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.iFI) });
      AppMethodBeat.o(43854);
      return;
      paramInt2 = 0;
      break;
      label225:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m
 * JD-Core Version:    0.7.0.1
 */
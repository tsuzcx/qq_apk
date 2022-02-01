package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.h;

public final class o
{
  int cR;
  long[] kCG;
  int kCH;
  int kCI;
  int kCJ;
  boolean kCK;
  boolean kCL;
  int kCM;
  int mScene;
  int mType;
  
  public o()
  {
    AppMethodBeat.i(43853);
    this.kCI = 0;
    this.kCJ = 0;
    this.kCG = new long[15];
    if (e.k(g.nPE))
    {
      i = 1;
      this.kCJ = i;
      if (!e.k(g.nPD)) {
        break label72;
      }
    }
    label72:
    for (int i = j;; i = 0)
    {
      this.kCI = i;
      AppMethodBeat.o(43853);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(int paramInt, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(226176);
    a(paramInt, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.appVersion, paramAppBrandInitConfigWC.eix, paramAppBrandInitConfigWC.NA());
    AppMethodBeat.o(226176);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(226177);
    int i = 369;
    if (paramBoolean) {
      i = 777;
    }
    try
    {
      h.CyF.idkeyStat(i, paramInt1, 1L, false);
      i.b(paramString, paramInt2, paramInt3, i, paramInt1);
      AppMethodBeat.o(226177);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(226177);
    }
  }
  
  public final void I(int paramInt, long paramLong)
  {
    if ((paramInt >= this.kCG.length) || (this.kCG[paramInt] != 0L)) {
      return;
    }
    this.kCG[paramInt] = paramLong;
  }
  
  final void g(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    AppMethodBeat.i(43854);
    int i;
    h localh;
    int k;
    int m;
    long l;
    int n;
    int i1;
    if (this.kCM == 1)
    {
      i = this.kCJ;
      localh = h.CyF;
      k = this.cR;
      m = this.mType;
      l = this.kCG[paramInt2];
      n = this.kCH;
      i1 = this.mScene;
      if (!this.kCK) {
        break label237;
      }
      paramInt2 = 1;
      label68:
      if (!this.kCL) {
        break label242;
      }
    }
    for (;;)
    {
      localh.a(13886, new Object[] { paramString, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), "", "", Long.valueOf(l), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.kCM) });
      AppMethodBeat.o(43854);
      return;
      i = this.kCI;
      break;
      label237:
      paramInt2 = 0;
      break label68;
      label242:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o
 * JD-Core Version:    0.7.0.1
 */
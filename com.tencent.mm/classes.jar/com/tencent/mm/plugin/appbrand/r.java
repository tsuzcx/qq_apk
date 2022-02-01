package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.task.n;

public final class r
{
  int aan;
  int mScene;
  int mType;
  long[] nvQ;
  int nvR;
  int nvS;
  int nvT;
  boolean nvU;
  boolean nvV;
  int nvW;
  
  public r()
  {
    AppMethodBeat.i(43853);
    this.nvS = 0;
    this.nvT = 0;
    this.nvQ = new long[15];
    if (com.tencent.mm.plugin.appbrand.task.h.j(n.qRT))
    {
      i = 1;
      this.nvT = i;
      if (!com.tencent.mm.plugin.appbrand.task.h.j(n.qRS)) {
        break label72;
      }
    }
    label72:
    for (int i = j;; i = 0)
    {
      this.nvS = i;
      AppMethodBeat.o(43853);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(int paramInt, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(280921);
    a(paramInt, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.appVersion, paramAppBrandInitConfigWC.cBI, paramAppBrandInitConfigWC.Qv());
    AppMethodBeat.o(280921);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(280922);
    int i = 369;
    if (paramBoolean) {
      i = 777;
    }
    try
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(i, paramInt1, 1L, false);
      j.b(paramString, paramInt2, paramInt3, i, paramInt1);
      AppMethodBeat.o(280922);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(280922);
    }
  }
  
  public final void I(int paramInt, long paramLong)
  {
    if ((paramInt >= this.nvQ.length) || (this.nvQ[paramInt] != 0L)) {
      return;
    }
    this.nvQ[paramInt] = paramLong;
  }
  
  final void h(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    AppMethodBeat.i(43854);
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    int k;
    int m;
    long l;
    int n;
    int i1;
    if (this.nvW == 1)
    {
      i = this.nvT;
      localh = com.tencent.mm.plugin.report.service.h.IzE;
      k = this.aan;
      m = this.mType;
      l = this.nvQ[paramInt2];
      n = this.nvR;
      i1 = this.mScene;
      if (!this.nvU) {
        break label237;
      }
      paramInt2 = 1;
      label68:
      if (!this.nvV) {
        break label242;
      }
    }
    for (;;)
    {
      localh.a(13886, new Object[] { paramString, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), "", "", Long.valueOf(l), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.nvW) });
      AppMethodBeat.o(43854);
      return;
      i = this.nvS;
      break;
      label237:
      paramInt2 = 0;
      break label68;
      label242:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r
 * JD-Core Version:    0.7.0.1
 */
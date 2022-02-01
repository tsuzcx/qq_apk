package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.task.l;

public final class r
{
  int bHI;
  int mScene;
  int mType;
  long[] quD;
  int quE;
  int quF;
  int quG;
  boolean quH;
  boolean quI;
  int quJ;
  
  public r()
  {
    AppMethodBeat.i(43853);
    this.quF = 0;
    this.quG = 0;
    this.quD = new long[15];
    if (com.tencent.mm.plugin.appbrand.task.h.j(l.tWx))
    {
      i = 1;
      this.quG = i;
      if (!com.tencent.mm.plugin.appbrand.task.h.j(l.tWw)) {
        break label72;
      }
    }
    label72:
    for (int i = j;; i = 0)
    {
      this.quF = i;
      AppMethodBeat.o(43853);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(int paramInt, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(316617);
    if (paramAppBrandInitConfigWC == null)
    {
      AppMethodBeat.o(316617);
      return;
    }
    a(paramInt, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.appVersion, paramAppBrandInitConfigWC.eul, paramAppBrandInitConfigWC.aqJ());
    AppMethodBeat.o(316617);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(316625);
    int i = 369;
    if (paramBoolean) {
      i = 777;
    }
    try
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(i, paramInt1, 1L, false);
      j.b(paramString, paramInt2, paramInt3, i, paramInt1);
      AppMethodBeat.o(316625);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(316625);
    }
  }
  
  public final void L(int paramInt, long paramLong)
  {
    if ((paramInt >= this.quD.length) || (this.quD[paramInt] != 0L)) {
      return;
    }
    this.quD[paramInt] = paramLong;
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
    if (this.quJ == 1)
    {
      i = this.quG;
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      k = this.bHI;
      m = this.mType;
      l = this.quD[paramInt2];
      n = this.quE;
      i1 = this.mScene;
      if (!this.quH) {
        break label237;
      }
      paramInt2 = 1;
      label68:
      if (!this.quI) {
        break label242;
      }
    }
    for (;;)
    {
      localh.b(13886, new Object[] { paramString, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramInt1), "", "", Long.valueOf(l), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.quJ) });
      AppMethodBeat.o(43854);
      return;
      i = this.quF;
      break;
      label237:
      paramInt2 = 0;
      break label68;
      label242:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r
 * JD-Core Version:    0.7.0.1
 */
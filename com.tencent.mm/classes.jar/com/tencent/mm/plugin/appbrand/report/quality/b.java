package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gv;
import com.tencent.mm.g.b.a.gv.a;
import com.tencent.mm.g.b.a.gz;
import com.tencent.mm.g.b.a.gz.a;
import com.tencent.mm.g.b.a.hh;
import com.tencent.mm.g.b.a.hn;
import com.tencent.mm.g.b.a.hn.a;
import com.tencent.mm.g.b.a.hx;
import com.tencent.mm.g.b.a.hx.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends c
{
  public static void QO(String paramString)
  {
    AppMethodBeat.i(48206);
    QualitySessionRuntime localQualitySessionRuntime = a.QN(paramString);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48206);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = localQualitySessionRuntime.lVz;
    if (DebuggerShell.baW()) {
      com.tencent.mm.plugin.appbrand.performance.c.b(paramString, "FirstRenderToGameInteractive", l2, l1);
    }
    AppMethodBeat.o(48206);
  }
  
  public static hh a(boolean paramBoolean, String paramString, i parami)
  {
    AppMethodBeat.i(48203);
    hh localhh = new hh();
    if (!paramBoolean)
    {
      paramString = a.QN(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48203);
        return null;
      }
      localhh.ot(paramString.appId);
      localhh.os(paramString.lht);
      localhh.eeN = paramString.lTR;
      localhh.eco = paramString.apptype;
      localhh.eaM = paramString.lVs;
      localhh.dHY = paramString.scene;
    }
    for (localhh.edd = paramString.btP();; localhh.edd = 1L)
    {
      a(localhh, parami);
      AppMethodBeat.o(48203);
      return localhh;
    }
  }
  
  private static void a(hh paramhh, i parami)
  {
    AppMethodBeat.i(48204);
    int i;
    if (parami != null) {
      switch (2.lUz[com.tencent.mm.plugin.appbrand.report.c.d(parami).ordinal()])
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      paramhh.eeQ = i;
      if ((parami instanceof ay)) {
        paramhh.ow(btJ());
      }
      AppMethodBeat.o(48204);
      return;
      i = 102;
      continue;
      i = 103;
      continue;
      i = 104;
      continue;
      i = 6;
      continue;
      i = 5;
      continue;
      i = 4;
      continue;
      i = 3;
      continue;
      i = 2;
      continue;
      i = 1;
    }
  }
  
  public static void a(d paramd, String paramString, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3)
  {
    AppMethodBeat.i(175062);
    if (!paramd.isRunning())
    {
      AppMethodBeat.o(175062);
      return;
    }
    hh localhh = new hh();
    Object localObject = a.QN(paramd.getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(175062);
      return;
    }
    localhh.ot(((QualitySessionRuntime)localObject).appId);
    localhh.os(((QualitySessionRuntime)localObject).lht);
    localhh.eeN = ((QualitySessionRuntime)localObject).lTR;
    localhh.eco = ((QualitySessionRuntime)localObject).apptype;
    localhh.eaM = ((QualitySessionRuntime)localObject).lVs;
    localhh.dHY = ((QualitySessionRuntime)localObject).scene;
    a(localhh, paramd.aUV());
    if ((paramd instanceof aa))
    {
      localObject = "WebView-wxConfigReady";
      localhh.ou((String)localObject);
      localhh.eeO = bs.nullAsNil(paramString).length();
      localhh.ov(paramd.aSt().aVS());
      if (!paramBoolean) {
        break label262;
      }
    }
    label262:
    for (long l = 1L;; l = 0L)
    {
      localhh.eeS = l;
      localhh.md(paramLong1);
      localhh.me(paramLong2);
      localhh.mc(localhh.edx - localhh.edw);
      localhh.eeT = paramLong3;
      localhh.aHZ();
      AppMethodBeat.o(175062);
      return;
      if (((o)paramd.getRuntime()).CC())
      {
        localObject = "GameMainContext-wxConfigReady";
        break;
      }
      localObject = "MainContext-wxConfigReady";
      break;
    }
  }
  
  public static void a(e parame, String paramString, long paramLong, com.tencent.mm.plugin.appbrand.report.c paramc)
  {
    long l = 0L;
    AppMethodBeat.i(48201);
    gz localgz = new gz();
    int i;
    if (parame != null) {
      i = 1;
    }
    while (i == 0)
    {
      parame = a.QN(paramString);
      if (parame == null)
      {
        AppMethodBeat.o(48201);
        return;
        i = 0;
      }
      else
      {
        localgz.om(parame.appId);
        localgz.ol(parame.lht);
        localgz.edZ = gz.a.iO(parame.lTR);
        localgz.eco = parame.apptype;
        localgz.eaM = parame.lVs;
        localgz.dHY = parame.scene;
        localgz.edd = parame.btP();
        if (parame.bYk) {
          l = 1L;
        }
        localgz.eea = l;
        localgz.lK(paramLong);
        localgz.SJ();
        localgz.lJ(localgz.edx - paramLong);
        switch (2.lUz[paramc.ordinal()])
        {
        default: 
          localgz.eaY = 2147483647L;
        }
      }
    }
    for (;;)
    {
      localgz.aHZ();
      AppMethodBeat.o(48201);
      return;
      localgz.edd = 1L;
      if (parame == e.lYs) {
        l = 1L;
      }
      localgz.eea = l;
      break;
      localgz.eaY = 1L;
      continue;
      localgz.eaY = 2L;
      continue;
      localgz.eaY = 3L;
      continue;
      localgz.eaY = 4L;
      continue;
      localgz.eaY = 5L;
      continue;
      localgz.eaY = 6L;
    }
  }
  
  public static void a(String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(48207);
    paramString = a.QN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(48207);
      return;
    }
    hn localhn = new hn();
    localhn.ecm = localhn.t("AppId", paramString.appId, true);
    localhn.dZT = localhn.t("InstanceId", paramString.lht, true);
    localhn.efT = hn.a.iZ(paramString.lTR);
    localhn.eco = paramString.apptype;
    localhn.eaM = paramString.lVs;
    localhn.dHY = paramString.scene;
    localhn.egi = paramString.lVF.get();
    localhn.SX();
    localhn.SY();
    localhn.SW();
    localhn.efU = paramm.fps;
    localhn.efV = Math.round(paramm.lVY);
    if (paramm.lVS == l.a.lVU) {}
    for (;;)
    {
      localhn.egd = i;
      localhn.ege = paramm.lVZ;
      localhn.egf = paramm.lWa;
      localhn.egg = paramm.lWb;
      localhn.efZ = paramm.bZn;
      localhn.ega = paramm.bZo;
      localhn.efX = paramm.bZm;
      localhn.efY = paramm.lWc;
      localhn.egb = (paramm.lWd / 1000);
      localhn.egc = paramm.jQW;
      localhn.efW = paramm.lWe;
      localhn.egh = paramm.lWf;
      localhn.egj = paramm.lWg;
      localhn.egk = paramm.lWh;
      localhn.egm = paramm.lWi;
      localhn.egn = paramm.lWj;
      localhn.ego = paramm.lWk;
      localhn.aHZ();
      AppMethodBeat.o(48207);
      return;
      if (paramm.lVS == l.a.lVV) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(48208);
    gv localgv = new gv();
    if (!paramBoolean)
    {
      paramString = a.QN(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48208);
        return;
      }
      localgv.ok(paramString.appId);
      localgv.oj(paramString.lht);
      localgv.edD = gv.a.iK(paramString.lTR);
      localgv.eco = paramString.apptype;
      localgv.dHY = paramString.scene;
    }
    localgv.lz(paramLong);
    localgv.SI();
    localgv.ly(localgv.edx - localgv.edw);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localgv.edE = paramLong;
      localgv.aHZ();
      AppMethodBeat.o(48208);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong, com.tencent.mm.plugin.appbrand.report.m paramm)
  {
    AppMethodBeat.i(48200);
    hx localhx = new hx();
    if (!paramBoolean)
    {
      paramString = a.QN(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48200);
        return;
      }
      localhx.oZ(paramString.appId);
      localhx.oY(paramString.lht);
      localhx.eiC = hx.a.jk(paramString.lTR);
      localhx.eco = paramString.apptype;
      localhx.eaM = paramString.lVs;
      localhx.dHY = paramString.scene;
      localhx.edd = paramString.btP();
      localhx.nz(paramLong);
      localhx.Tc();
      localhx.ny(localhx.edx - paramLong);
      switch (2.lUD[paramm.ordinal()])
      {
      default: 
        localhx.eaY = 2147483647L;
      }
    }
    for (;;)
    {
      localhx.eiD = btJ();
      localhx.pa(btJ());
      localhx.aHZ();
      AppMethodBeat.o(48200);
      return;
      localhx.edd = 1L;
      break;
      localhx.eaY = 2L;
      continue;
      localhx.eaY = 4L;
      continue;
      localhx.eaY = 3L;
    }
  }
  
  public static hh g(d paramd)
  {
    AppMethodBeat.i(48202);
    hh localhh = a(paramd.aUl(), paramd.getAppId(), paramd.aUV());
    if (localhh == null)
    {
      AppMethodBeat.o(48202);
      return null;
    }
    localhh.ov(paramd.aSt().aVS());
    AppMethodBeat.o(48202);
    return localhh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b
 * JD-Core Version:    0.7.0.1
 */
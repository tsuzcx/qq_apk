package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ia;
import com.tencent.mm.g.b.a.ia.a;
import com.tencent.mm.g.b.a.ie;
import com.tencent.mm.g.b.a.ie.a;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.g.b.a.it;
import com.tencent.mm.g.b.a.it.a;
import com.tencent.mm.g.b.a.jd;
import com.tencent.mm.g.b.a.jd.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends c
{
  public static void Vf(String paramString)
  {
    AppMethodBeat.i(48206);
    QualitySessionRuntime localQualitySessionRuntime = a.Ve(paramString);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48206);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = localQualitySessionRuntime.mAm;
    if (DebuggerShell.bfe()) {
      com.tencent.mm.plugin.appbrand.performance.c.b(paramString, "FirstRenderToGameInteractive", l2, l1);
    }
    AppMethodBeat.o(48206);
  }
  
  private static in a(boolean paramBoolean, String paramString, i parami)
  {
    AppMethodBeat.i(48203);
    in localin = new in();
    if (!paramBoolean)
    {
      paramString = a.Ve(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48203);
        return null;
      }
      localin.rs(paramString.appId);
      localin.rr(paramString.lIU);
      localin.exh = paramString.myD;
      localin.euA = paramString.apptype;
      localin.etb = paramString.mAf;
      localin.dWt = paramString.scene;
    }
    for (localin.evp = paramString.byN();; localin.evp = 1L)
    {
      a(localin, parami);
      AppMethodBeat.o(48203);
      return localin;
    }
  }
  
  private static void a(in paramin, i parami)
  {
    AppMethodBeat.i(48204);
    int i;
    if (parami != null) {
      switch (2.mzn[com.tencent.mm.plugin.appbrand.report.d.d(parami).ordinal()])
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      paramin.exk = i;
      if ((parami instanceof ax)) {
        paramin.rv(byH());
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
  
  public static void a(com.tencent.mm.plugin.appbrand.d paramd, String paramString, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3)
  {
    AppMethodBeat.i(175062);
    if (!paramd.isRunning())
    {
      AppMethodBeat.o(175062);
      return;
    }
    in localin = new in();
    Object localObject = a.Ve(paramd.getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(175062);
      return;
    }
    localin.rs(((QualitySessionRuntime)localObject).appId);
    localin.rr(((QualitySessionRuntime)localObject).lIU);
    localin.exh = ((QualitySessionRuntime)localObject).myD;
    localin.euA = ((QualitySessionRuntime)localObject).apptype;
    localin.etb = ((QualitySessionRuntime)localObject).mAf;
    localin.dWt = ((QualitySessionRuntime)localObject).scene;
    a(localin, paramd.aYB());
    if ((paramd instanceof z))
    {
      localObject = "WebView-wxConfigReady";
      localin.rt((String)localObject);
      localin.exi = bu.nullAsNil(paramString).length();
      localin.ru(paramd.aWe().aZK());
      if (!paramBoolean) {
        break label262;
      }
    }
    label262:
    for (long l = 1L;; l = 0L)
    {
      localin.exm = l;
      localin.on(paramLong1);
      localin.oo(paramLong2);
      localin.om(localin.evJ - localin.evI);
      localin.exn = paramLong3;
      localin.aLH();
      AppMethodBeat.o(175062);
      return;
      if (((p)paramd.getRuntime()).Ee())
      {
        localObject = "GameMainContext-wxConfigReady";
        break;
      }
      localObject = "MainContext-wxConfigReady";
      break;
    }
  }
  
  public static void a(e parame, String paramString, long paramLong, com.tencent.mm.plugin.appbrand.report.d paramd)
  {
    long l = 0L;
    AppMethodBeat.i(48201);
    ie localie = new ie();
    int i;
    if (parame != null) {
      i = 1;
    }
    while (i == 0)
    {
      parame = a.Ve(paramString);
      if (parame == null)
      {
        AppMethodBeat.o(48201);
        return;
        i = 0;
      }
      else
      {
        localie.rg(parame.appId);
        localie.rf(parame.lIU);
        localie.ewl = ie.a.jj(parame.myD);
        localie.euA = parame.apptype;
        localie.etb = parame.mAf;
        localie.dWt = parame.scene;
        localie.evp = parame.byN();
        if (parame.ciE) {
          l = 1L;
        }
        localie.ewm = l;
        localie.nQ(paramLong);
        localie.Vd();
        localie.nP(localie.evJ - paramLong);
        switch (2.mzn[paramd.ordinal()])
        {
        default: 
          localie.ebQ = 2147483647L;
        }
      }
    }
    for (;;)
    {
      localie.rh(V8.getV8Version());
      localie.aLH();
      AppMethodBeat.o(48201);
      return;
      localie.evp = 1L;
      if (parame == e.mDf) {
        l = 1L;
      }
      localie.ewm = l;
      break;
      localie.ebQ = 1L;
      continue;
      localie.ebQ = 2L;
      continue;
      localie.ebQ = 3L;
      continue;
      localie.ebQ = 4L;
      continue;
      localie.ebQ = 5L;
      continue;
      localie.ebQ = 6L;
    }
  }
  
  public static void a(String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(48207);
    paramString = a.Ve(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(48207);
      return;
    }
    it localit = new it();
    localit.euy = localit.t("AppId", paramString.appId, true);
    localit.esa = localit.t("InstanceId", paramString.lIU, true);
    localit.eys = it.a.jy(paramString.myD);
    localit.euA = paramString.apptype;
    localit.etb = paramString.mAf;
    localit.dWt = paramString.scene;
    localit.eyH = paramString.mAs.get();
    localit.Vs();
    localit.Vt();
    localit.Vr();
    localit.eyt = paramm.fps;
    localit.eyu = Math.round(paramm.mAK);
    if (paramm.mAE == l.a.mAG) {}
    for (;;)
    {
      localit.eyC = i;
      localit.eyD = paramm.mAL;
      localit.eyE = paramm.mAM;
      localit.eyF = paramm.mAN;
      localit.eyy = paramm.cjH;
      localit.eyz = paramm.cjI;
      localit.eyw = paramm.cjG;
      localit.eyx = paramm.mAO;
      localit.eyA = (paramm.mAP / 1000);
      localit.eyB = paramm.koB;
      localit.eyv = paramm.mAQ;
      localit.eyG = paramm.mAR;
      localit.eyI = paramm.mAS;
      localit.eyJ = paramm.mAT;
      localit.eyK = paramm.mAU;
      localit.eyL = paramm.mAV;
      localit.eyM = paramm.mAW;
      localit.aLH();
      AppMethodBeat.o(48207);
      return;
      if (paramm.mAE == l.a.mAH) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(48208);
    ia localia = new ia();
    if (!paramBoolean)
    {
      paramString = a.Ve(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48208);
        return;
      }
      localia.re(paramString.appId);
      localia.rd(paramString.lIU);
      localia.evP = ia.a.jf(paramString.myD);
      localia.euA = paramString.apptype;
      localia.dWt = paramString.scene;
    }
    localia.nF(paramLong);
    localia.Vc();
    localia.nE(localia.evJ - localia.evI);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localia.evQ = paramLong;
      localia.aLH();
      AppMethodBeat.o(48208);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong, n paramn)
  {
    AppMethodBeat.i(48200);
    jd localjd = new jd();
    if (!paramBoolean)
    {
      paramString = a.Ve(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48200);
        return;
      }
      localjd.sb(paramString.appId);
      localjd.sa(paramString.lIU);
      localjd.eBl = jd.a.jJ(paramString.myD);
      localjd.euA = paramString.apptype;
      localjd.etb = paramString.mAf;
      localjd.dWt = paramString.scene;
      localjd.evp = paramString.byN();
      localjd.pK(paramLong);
      localjd.Vx();
      localjd.pJ(localjd.evJ - paramLong);
      switch (2.mzr[paramn.ordinal()])
      {
      default: 
        localjd.ebQ = 2147483647L;
      }
    }
    for (;;)
    {
      localjd.eBm = byH();
      localjd.sc(byH());
      localjd.aLH();
      AppMethodBeat.o(48200);
      return;
      localjd.evp = 1L;
      break;
      localjd.ebQ = 2L;
      continue;
      localjd.ebQ = 4L;
      continue;
      localjd.ebQ = 3L;
    }
  }
  
  public static in l(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(48202);
    in localin = a(paramd.aXP(), paramd.getAppId(), paramd.aYB());
    if (localin == null)
    {
      AppMethodBeat.o(48202);
      return null;
    }
    localin.ru(paramd.aWe().aZK());
    AppMethodBeat.o(48202);
    return localin;
  }
  
  public static in r(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(222937);
    paramString = a(paramBoolean, paramString, null);
    AppMethodBeat.o(222937);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.mmv8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ot;
import com.tencent.mm.f.b.a.ot.a;
import com.tencent.mm.f.b.a.ox;
import com.tencent.mm.f.b.a.ox.a;
import com.tencent.mm.f.b.a.ph;
import com.tencent.mm.f.b.a.po;
import com.tencent.mm.f.b.a.po.a;
import com.tencent.mm.f.b.a.py;
import com.tencent.mm.f.b.a.py.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.r.a;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.p;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  extends d
{
  private static ph a(boolean paramBoolean, String paramString, i parami)
  {
    AppMethodBeat.i(48203);
    ph localph = new ph();
    if (!paramBoolean)
    {
      paramString = b.amO(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48203);
        return null;
      }
      localph.Gd(paramString.appId);
      localph.Gc(paramString.cBH);
      localph.gYM = paramString.qLQ;
      localph.gYN = paramString.apptype;
      localph.gYL = paramString.qNx;
      localph.gnP = paramString.scene;
    }
    for (localph.hcB = paramString.cir();; localph.hcB = 1L)
    {
      a(localph, parami);
      AppMethodBeat.o(48203);
      return localph;
    }
  }
  
  private static void a(ph paramph, i parami)
  {
    AppMethodBeat.i(48204);
    int i;
    if (parami != null) {
      switch (2.qMG[e.f(parami).ordinal()])
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      paramph.hew = i;
      if ((parami instanceof bd)) {
        paramph.Gg(cil());
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
  
  public static void a(g paramg, String paramString, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3)
  {
    AppMethodBeat.i(175062);
    if (!paramg.isRunning())
    {
      AppMethodBeat.o(175062);
      return;
    }
    ph localph = new ph();
    Object localObject = b.amO(paramg.getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(175062);
      return;
    }
    localph.Gd(((QualitySessionRuntime)localObject).appId);
    localph.Gc(((QualitySessionRuntime)localObject).cBH);
    localph.gYM = ((QualitySessionRuntime)localObject).qLQ;
    localph.gYN = ((QualitySessionRuntime)localObject).apptype;
    localph.gYL = ((QualitySessionRuntime)localObject).qNx;
    localph.gnP = ((QualitySessionRuntime)localObject).scene;
    a(localph, paramg.getJsRuntime());
    if ((paramg instanceof ad))
    {
      localObject = "WebView-wxConfigReady";
      localph.Ge((String)localObject);
      localph.heu = Util.nullAsNil(paramString).length();
      localph.Gf(paramg.bBP().bGg());
      if (!paramBoolean) {
        break label262;
      }
    }
    label262:
    for (long l = 1L;; l = 0L)
    {
      localph.hey = l;
      localph.BS(paramLong1);
      localph.BT(paramLong2);
      localph.BR(localph.hcV - localph.hcU);
      localph.hez = paramLong3;
      localph.bpa();
      AppMethodBeat.o(175062);
      return;
      if (((t)paramg.getRuntime()).Qv())
      {
        localObject = "GameMainContext-wxConfigReady";
        break;
      }
      localObject = "MainContext-wxConfigReady";
      break;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.task.n paramn, String paramString, long paramLong, e parame)
  {
    long l = 0L;
    AppMethodBeat.i(48201);
    ox localox = new ox();
    int i;
    if (paramn != null) {
      i = 1;
    }
    while (i == 0)
    {
      paramn = b.amO(paramString);
      if (paramn == null)
      {
        AppMethodBeat.o(48201);
        return;
        i = 0;
      }
      else
      {
        localox.FP(paramn.appId);
        localox.FO(paramn.cBH);
        localox.hdy = ox.a.ow(paramn.qLQ);
        localox.gYN = paramn.apptype;
        localox.gYL = paramn.qNx;
        localox.gnP = paramn.scene;
        localox.hcB = paramn.cir();
        if (paramn.csz) {
          l = 1L;
        }
        localox.hdz = l;
        localox.Bv(paramLong);
        localox.aoE();
        localox.Bu(localox.hcV - paramLong);
        switch (2.qMG[parame.ordinal()])
        {
        default: 
          localox.grp = 2147483647L;
        }
      }
    }
    for (;;)
    {
      localox.FQ(V8.getV8Version());
      localox.bpa();
      AppMethodBeat.o(48201);
      return;
      localox.hcB = 1L;
      if (paramn == com.tencent.mm.plugin.appbrand.task.n.qRT) {
        l = 1L;
      }
      localox.hdz = l;
      break;
      localox.grp = 1L;
      continue;
      localox.grp = 2L;
      continue;
      localox.grp = 3L;
      continue;
      localox.grp = 4L;
      continue;
      localox.grp = 5L;
      continue;
      localox.grp = 6L;
    }
  }
  
  public static void a(String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(48207);
    paramString = b.amO(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(48207);
      return;
    }
    po localpo = new po();
    localpo.gmF = localpo.z("AppId", paramString.appId, true);
    localpo.gfn = localpo.z("InstanceId", paramString.cBH, true);
    localpo.hfJ = po.a.oL(paramString.qLQ);
    localpo.gYN = paramString.apptype;
    localpo.gYL = paramString.qNx;
    localpo.gnP = paramString.scene;
    localpo.hfY = paramString.qNK.get();
    localpo.aoP();
    localpo.aoQ();
    localpo.aoO();
    localpo.hfK = paramn.fps;
    localpo.hfL = Math.round(paramn.qOd);
    if (paramn.qNX == m.a.qNZ) {}
    for (;;)
    {
      localpo.hfT = i;
      localpo.hfU = paramn.qOe;
      localpo.hfV = paramn.qOf;
      localpo.hfW = paramn.qOg;
      localpo.hfP = paramn.ctU;
      localpo.hfQ = paramn.ctV;
      localpo.hfN = paramn.ctT;
      localpo.hfO = paramn.qOh;
      localpo.hfR = (paramn.qOi / 1000);
      localpo.hfS = paramn.onh;
      localpo.hfM = paramn.qOj;
      localpo.hfX = paramn.qOk;
      localpo.hfZ = paramn.qOl;
      localpo.hga = paramn.qOm;
      localpo.hgb = paramn.qOn;
      localpo.hgc = paramn.qOo;
      localpo.hgd = paramn.qOp;
      localpo.hgh = paramn.cLc;
      localpo.hgi = paramn.cLd;
      localpo.hgj = paramn.qOq;
      localpo.bpa();
      AppMethodBeat.o(48207);
      return;
      if (paramn.qNX == m.a.qOa) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(48208);
    ot localot = new ot();
    if (!paramBoolean)
    {
      paramString = b.amO(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48208);
        return;
      }
      localot.FN(paramString.appId);
      localot.FM(paramString.cBH);
      localot.hdb = ot.a.os(paramString.qLQ);
      localot.gYN = paramString.apptype;
      localot.gnP = paramString.scene;
    }
    localot.Bk(paramLong);
    localot.aoD();
    localot.Bj(localot.hcV - localot.hcU);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localot.hdc = paramLong;
      localot.bpa();
      AppMethodBeat.o(48208);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong, p paramp)
  {
    AppMethodBeat.i(48200);
    py localpy = new py();
    if (!paramBoolean)
    {
      paramString = b.amO(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48200);
        return;
      }
      localpy.GU(paramString.appId);
      localpy.GT(paramString.cBH);
      localpy.hiN = py.a.oW(paramString.qLQ);
      localpy.gYN = paramString.apptype;
      localpy.gYL = paramString.qNx;
      localpy.gnP = paramString.scene;
      localpy.hcB = paramString.cir();
      localpy.Dv(paramLong);
      localpy.aoU();
      localpy.Du(localpy.hcV - paramLong);
      switch (2.qMK[paramp.ordinal()])
      {
      default: 
        localpy.grp = 2147483647L;
      }
    }
    for (;;)
    {
      localpy.hiO = cil();
      localpy.GV(cil());
      localpy.bpa();
      AppMethodBeat.o(48200);
      return;
      localpy.hcB = 1L;
      break;
      localpy.grp = 2L;
      continue;
      localpy.grp = 4L;
      continue;
      localpy.grp = 3L;
    }
  }
  
  public static void amP(String paramString)
  {
    AppMethodBeat.i(48206);
    QualitySessionRuntime localQualitySessionRuntime = b.amO(paramString);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48206);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = localQualitySessionRuntime.qNE;
    if (DebuggerShell.bLS()) {
      com.tencent.mm.plugin.appbrand.performance.c.b(paramString, "FirstRenderToGameInteractive", l2, l1);
    }
    AppMethodBeat.o(48206);
  }
  
  public final ph p(g paramg)
  {
    AppMethodBeat.i(48202);
    ph localph = a(paramg.bDU(), paramg.getAppId(), paramg.getJsRuntime());
    if (localph == null)
    {
      AppMethodBeat.o(48202);
      return null;
    }
    localph.Gf(paramg.bBP().bGg());
    AppMethodBeat.o(48202);
    return localph;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.c
 * JD-Core Version:    0.7.0.1
 */
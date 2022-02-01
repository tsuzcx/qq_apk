package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hy;
import com.tencent.mm.g.b.a.hy.a;
import com.tencent.mm.g.b.a.ic;
import com.tencent.mm.g.b.a.ic.a;
import com.tencent.mm.g.b.a.il;
import com.tencent.mm.g.b.a.ir;
import com.tencent.mm.g.b.a.ir.a;
import com.tencent.mm.g.b.a.jb;
import com.tencent.mm.g.b.a.jb.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends c
{
  public static void Uu(String paramString)
  {
    AppMethodBeat.i(48206);
    QualitySessionRuntime localQualitySessionRuntime = a.Ut(paramString);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48206);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = localQualitySessionRuntime.mvp;
    if (DebuggerShell.bew()) {
      com.tencent.mm.plugin.appbrand.performance.c.b(paramString, "FirstRenderToGameInteractive", l2, l1);
    }
    AppMethodBeat.o(48206);
  }
  
  public static il a(boolean paramBoolean, String paramString, i parami)
  {
    AppMethodBeat.i(48203);
    il localil = new il();
    if (!paramBoolean)
    {
      paramString = a.Ut(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48203);
        return null;
      }
      localil.qX(paramString.appId);
      localil.qW(paramString.lEv);
      localil.evA = paramString.mtG;
      localil.esT = paramString.apptype;
      localil.eru = paramString.mvi;
      localil.dVd = paramString.scene;
    }
    for (localil.etI = paramString.bxU();; localil.etI = 1L)
    {
      a(localil, parami);
      AppMethodBeat.o(48203);
      return localil;
    }
  }
  
  private static void a(il paramil, i parami)
  {
    AppMethodBeat.i(48204);
    int i;
    if (parami != null) {
      switch (b.2.muq[com.tencent.mm.plugin.appbrand.report.d.d(parami).ordinal()])
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      paramil.evD = i;
      if ((parami instanceof ay)) {
        paramil.ra(bxO());
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
    il localil = new il();
    Object localObject = a.Ut(paramd.getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(175062);
      return;
    }
    localil.qX(((QualitySessionRuntime)localObject).appId);
    localil.qW(((QualitySessionRuntime)localObject).lEv);
    localil.evA = ((QualitySessionRuntime)localObject).mtG;
    localil.esT = ((QualitySessionRuntime)localObject).apptype;
    localil.eru = ((QualitySessionRuntime)localObject).mvi;
    localil.dVd = ((QualitySessionRuntime)localObject).scene;
    a(localil, paramd.aYh());
    if ((paramd instanceof aa))
    {
      localObject = "WebView-wxConfigReady";
      localil.qY((String)localObject);
      localil.evB = bt.nullAsNil(paramString).length();
      localil.qZ(paramd.aVF().aZn());
      if (!paramBoolean) {
        break label262;
      }
    }
    label262:
    for (long l = 1L;; l = 0L)
    {
      localil.evF = l;
      localil.ob(paramLong1);
      localil.oc(paramLong2);
      localil.oa(localil.euc - localil.eub);
      localil.evG = paramLong3;
      localil.aLk();
      AppMethodBeat.o(175062);
      return;
      if (((o)paramd.getRuntime()).Eb())
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
    ic localic = new ic();
    int i;
    if (parame != null) {
      i = 1;
    }
    while (i == 0)
    {
      parame = a.Ut(paramString);
      if (parame == null)
      {
        AppMethodBeat.o(48201);
        return;
        i = 0;
      }
      else
      {
        localic.qL(parame.appId);
        localic.qK(parame.lEv);
        localic.euE = ic.a.jh(parame.mtG);
        localic.esT = parame.apptype;
        localic.eru = parame.mvi;
        localic.dVd = parame.scene;
        localic.etI = parame.bxU();
        if (parame.ciC) {
          l = 1L;
        }
        localic.euF = l;
        localic.nE(paramLong);
        localic.UX();
        localic.nD(localic.euc - paramLong);
        switch (b.2.muq[paramd.ordinal()])
        {
        default: 
          localic.eaw = 2147483647L;
        }
      }
    }
    for (;;)
    {
      localic.qM(V8.getV8Version());
      localic.aLk();
      AppMethodBeat.o(48201);
      return;
      localic.etI = 1L;
      if (parame == e.myh) {
        l = 1L;
      }
      localic.euF = l;
      break;
      localic.eaw = 1L;
      continue;
      localic.eaw = 2L;
      continue;
      localic.eaw = 3L;
      continue;
      localic.eaw = 4L;
      continue;
      localic.eaw = 5L;
      continue;
      localic.eaw = 6L;
    }
  }
  
  public static void a(String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(48207);
    paramString = a.Ut(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(48207);
      return;
    }
    ir localir = new ir();
    localir.esR = localir.t("AppId", paramString.appId, true);
    localir.eqt = localir.t("InstanceId", paramString.lEv, true);
    localir.ewI = ir.a.jw(paramString.mtG);
    localir.esT = paramString.apptype;
    localir.eru = paramString.mvi;
    localir.dVd = paramString.scene;
    localir.ewX = paramString.mvv.get();
    localir.Vk();
    localir.Vl();
    localir.Vj();
    localir.ewJ = paramm.fps;
    localir.ewK = Math.round(paramm.mvN);
    if (paramm.mvH == l.a.mvJ) {}
    for (;;)
    {
      localir.ewS = i;
      localir.ewT = paramm.mvO;
      localir.ewU = paramm.mvP;
      localir.ewV = paramm.mvQ;
      localir.ewO = paramm.cjF;
      localir.ewP = paramm.cjG;
      localir.ewM = paramm.cjE;
      localir.ewN = paramm.mvR;
      localir.ewQ = (paramm.mvS / 1000);
      localir.ewR = paramm.kll;
      localir.ewL = paramm.mvT;
      localir.ewW = paramm.mvU;
      localir.ewY = paramm.mvV;
      localir.ewZ = paramm.mvW;
      localir.exa = paramm.mvX;
      localir.exb = paramm.mvY;
      localir.exc = paramm.mvZ;
      localir.aLk();
      AppMethodBeat.o(48207);
      return;
      if (paramm.mvH == l.a.mvK) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(48208);
    hy localhy = new hy();
    if (!paramBoolean)
    {
      paramString = a.Ut(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48208);
        return;
      }
      localhy.qJ(paramString.appId);
      localhy.qI(paramString.lEv);
      localhy.eui = hy.a.jd(paramString.mtG);
      localhy.esT = paramString.apptype;
      localhy.dVd = paramString.scene;
    }
    localhy.nt(paramLong);
    localhy.UW();
    localhy.ns(localhy.euc - localhy.eub);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localhy.euj = paramLong;
      localhy.aLk();
      AppMethodBeat.o(48208);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong, n paramn)
  {
    AppMethodBeat.i(48200);
    jb localjb = new jb();
    if (!paramBoolean)
    {
      paramString = a.Ut(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48200);
        return;
      }
      localjb.rG(paramString.appId);
      localjb.rF(paramString.lEv);
      localjb.ezC = jb.a.jH(paramString.mtG);
      localjb.esT = paramString.apptype;
      localjb.eru = paramString.mvi;
      localjb.dVd = paramString.scene;
      localjb.etI = paramString.bxU();
      localjb.px(paramLong);
      localjb.Vp();
      localjb.pw(localjb.euc - paramLong);
      switch (b.2.muu[paramn.ordinal()])
      {
      default: 
        localjb.eaw = 2147483647L;
      }
    }
    for (;;)
    {
      localjb.ezD = bxO();
      localjb.rH(bxO());
      localjb.aLk();
      AppMethodBeat.o(48200);
      return;
      localjb.etI = 1L;
      break;
      localjb.eaw = 2L;
      continue;
      localjb.eaw = 4L;
      continue;
      localjb.eaw = 3L;
    }
  }
  
  public static il j(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(48202);
    il localil = a(paramd.aXu(), paramd.getAppId(), paramd.aYh());
    if (localil == null)
    {
      AppMethodBeat.o(48202);
      return null;
    }
    localil.qZ(paramd.aVF().aZn());
    AppMethodBeat.o(48202);
    return localil;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b
 * JD-Core Version:    0.7.0.1
 */
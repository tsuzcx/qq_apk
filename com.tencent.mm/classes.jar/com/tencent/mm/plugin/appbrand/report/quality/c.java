package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lv;
import com.tencent.mm.g.b.a.lv.a;
import com.tencent.mm.g.b.a.lz;
import com.tencent.mm.g.b.a.lz.a;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.g.b.a.mp;
import com.tencent.mm.g.b.a.mp.a;
import com.tencent.mm.g.b.a.mz;
import com.tencent.mm.g.b.a.mz.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.jsapi.q.a;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  extends d
{
  private static mj a(boolean paramBoolean, String paramString, i parami)
  {
    AppMethodBeat.i(48203);
    mj localmj = new mj();
    if (!paramBoolean)
    {
      paramString = b.aeU(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48203);
        return null;
      }
      localmj.zx(paramString.appId);
      localmj.zw(paramString.kEY);
      localmj.fbC = paramString.nJE;
      localmj.eYW = paramString.apptype;
      localmj.eXc = paramString.nLk;
      localmj.erW = paramString.scene;
    }
    for (localmj.eZK = paramString.bVg();; localmj.eZK = 1L)
    {
      a(localmj, parami);
      AppMethodBeat.o(48203);
      return localmj;
    }
  }
  
  private static void a(mj parammj, i parami)
  {
    AppMethodBeat.i(48204);
    int i;
    if (parami != null) {
      switch (2.nKu[e.d(parami).ordinal()])
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      parammj.fbF = i;
      if ((parami instanceof bb)) {
        parammj.zA(bVa());
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
    mj localmj = new mj();
    Object localObject = b.aeU(paramd.getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(175062);
      return;
    }
    localmj.zx(((QualitySessionRuntime)localObject).appId);
    localmj.zw(((QualitySessionRuntime)localObject).kEY);
    localmj.fbC = ((QualitySessionRuntime)localObject).nJE;
    localmj.eYW = ((QualitySessionRuntime)localObject).apptype;
    localmj.eXc = ((QualitySessionRuntime)localObject).nLk;
    localmj.erW = ((QualitySessionRuntime)localObject).scene;
    a(localmj, paramd.getJsRuntime());
    if ((paramd instanceof ac))
    {
      localObject = "WebView-wxConfigReady";
      localmj.zy((String)localObject);
      localmj.fbD = Util.nullAsNil(paramString).length();
      localmj.zz(paramd.bqZ().bvb());
      if (!paramBoolean) {
        break label262;
      }
    }
    label262:
    for (long l = 1L;; l = 0L)
    {
      localmj.fbH = l;
      localmj.vX(paramLong1);
      localmj.vY(paramLong2);
      localmj.vW(localmj.fae - localmj.fad);
      localmj.fbI = paramLong3;
      localmj.bfK();
      AppMethodBeat.o(175062);
      return;
      if (((q)paramd.getRuntime()).NA())
      {
        localObject = "GameMainContext-wxConfigReady";
        break;
      }
      localObject = "MainContext-wxConfigReady";
      break;
    }
  }
  
  public static void a(g paramg, String paramString, long paramLong, e parame)
  {
    long l = 0L;
    AppMethodBeat.i(48201);
    lz locallz = new lz();
    int i;
    if (paramg != null) {
      i = 1;
    }
    while (i == 0)
    {
      paramg = b.aeU(paramString);
      if (paramg == null)
      {
        AppMethodBeat.o(48201);
        return;
        i = 0;
      }
      else
      {
        locallz.zj(paramg.appId);
        locallz.zi(paramg.kEY);
        locallz.faG = lz.a.ml(paramg.nJE);
        locallz.eYW = paramg.apptype;
        locallz.eXc = paramg.nLk;
        locallz.erW = paramg.scene;
        locallz.eZK = paramg.bVg();
        if (paramg.cuy) {
          l = 1L;
        }
        locallz.faH = l;
        locallz.vA(paramLong);
        locallz.aiU();
        locallz.vz(locallz.fae - paramLong);
        switch (2.nKu[parame.ordinal()])
        {
        default: 
          locallz.evl = 2147483647L;
        }
      }
    }
    for (;;)
    {
      locallz.zk(V8.getV8Version());
      locallz.bfK();
      AppMethodBeat.o(48201);
      return;
      locallz.eZK = 1L;
      if (paramg == g.nPE) {
        l = 1L;
      }
      locallz.faH = l;
      break;
      locallz.evl = 1L;
      continue;
      locallz.evl = 2L;
      continue;
      locallz.evl = 3L;
      continue;
      locallz.evl = 4L;
      continue;
      locallz.evl = 5L;
      continue;
      locallz.evl = 6L;
    }
  }
  
  public static void a(String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(48207);
    paramString = b.aeU(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(48207);
      return;
    }
    mp localmp = new mp();
    localmp.eJx = localmp.x("AppId", paramString.appId, true);
    localmp.eWb = localmp.x("InstanceId", paramString.kEY, true);
    localmp.fcP = mp.a.mA(paramString.nJE);
    localmp.eYW = paramString.apptype;
    localmp.eXc = paramString.nLk;
    localmp.erW = paramString.scene;
    localmp.fde = paramString.nLx.get();
    localmp.aji();
    localmp.ajj();
    localmp.ajh();
    localmp.fcQ = paramn.fps;
    localmp.fcR = Math.round(paramn.nLP);
    if (paramn.nLJ == m.a.nLL) {}
    for (;;)
    {
      localmp.fcZ = i;
      localmp.fda = paramn.nLQ;
      localmp.fdb = paramn.nLR;
      localmp.fdc = paramn.nLS;
      localmp.fcV = paramn.cvE;
      localmp.fcW = paramn.cvF;
      localmp.fcT = paramn.cvD;
      localmp.fcU = paramn.nLT;
      localmp.fcX = (paramn.nLU / 1000);
      localmp.fcY = paramn.lsk;
      localmp.fcS = paramn.nLV;
      localmp.fdd = paramn.nLW;
      localmp.fdf = paramn.nLX;
      localmp.fdg = paramn.nLY;
      localmp.fdh = paramn.nLZ;
      localmp.fdi = paramn.nMa;
      localmp.fdj = paramn.nMb;
      localmp.bfK();
      AppMethodBeat.o(48207);
      return;
      if (paramn.nLJ == m.a.nLM) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(48208);
    lv locallv = new lv();
    if (!paramBoolean)
    {
      paramString = b.aeU(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48208);
        return;
      }
      locallv.zh(paramString.appId);
      locallv.zg(paramString.kEY);
      locallv.fak = lv.a.mh(paramString.nJE);
      locallv.eYW = paramString.apptype;
      locallv.erW = paramString.scene;
    }
    locallv.vp(paramLong);
    locallv.aiT();
    locallv.vo(locallv.fae - locallv.fad);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      locallv.fal = paramLong;
      locallv.bfK();
      AppMethodBeat.o(48208);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong, o paramo)
  {
    AppMethodBeat.i(48200);
    mz localmz = new mz();
    if (!paramBoolean)
    {
      paramString = b.aeU(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48200);
        return;
      }
      localmz.Aj(paramString.appId);
      localmz.Ai(paramString.kEY);
      localmz.ffI = mz.a.mL(paramString.nJE);
      localmz.eYW = paramString.apptype;
      localmz.eXc = paramString.nLk;
      localmz.erW = paramString.scene;
      localmz.eZK = paramString.bVg();
      localmz.xv(paramLong);
      localmz.ajn();
      localmz.xu(localmz.fae - paramLong);
      switch (2.nKy[paramo.ordinal()])
      {
      default: 
        localmz.evl = 2147483647L;
      }
    }
    for (;;)
    {
      localmz.ffJ = bVa();
      localmz.Ak(bVa());
      localmz.bfK();
      AppMethodBeat.o(48200);
      return;
      localmz.eZK = 1L;
      break;
      localmz.evl = 2L;
      continue;
      localmz.evl = 4L;
      continue;
      localmz.evl = 3L;
    }
  }
  
  public static void aeV(String paramString)
  {
    AppMethodBeat.i(48206);
    QualitySessionRuntime localQualitySessionRuntime = b.aeU(paramString);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48206);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = localQualitySessionRuntime.nLr;
    if (DebuggerShell.bAx()) {
      com.tencent.mm.plugin.appbrand.performance.c.b(paramString, "FirstRenderToGameInteractive", l2, l1);
    }
    AppMethodBeat.o(48206);
  }
  
  public final mj l(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(48202);
    mj localmj = a(paramd.bsW(), paramd.getAppId(), paramd.getJsRuntime());
    if (localmj == null)
    {
      AppMethodBeat.o(48202);
      return null;
    }
    localmj.zz(paramd.bqZ().bvb());
    AppMethodBeat.o(48202);
    return localmj;
  }
  
  public final mj r(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(227388);
    paramString = a(paramBoolean, paramString, null);
    AppMethodBeat.o(227388);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fd;
import com.tencent.mm.g.b.a.fd.a;
import com.tencent.mm.g.b.a.fh;
import com.tencent.mm.g.b.a.fh.a;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.g.b.a.fv;
import com.tencent.mm.g.b.a.fv.a;
import com.tencent.mm.g.b.a.gf;
import com.tencent.mm.g.b.a.gf.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends c
{
  public static void MF(String paramString)
  {
    AppMethodBeat.i(48206);
    QualitySessionRuntime localQualitySessionRuntime = a.ME(paramString);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(48206);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = localQualitySessionRuntime.ltF;
    if (DebuggerShell.aTY()) {
      com.tencent.mm.plugin.appbrand.performance.c.b(paramString, "FirstRenderToGameInteractive", l2, l1);
    }
    AppMethodBeat.o(48206);
  }
  
  public static fp a(boolean paramBoolean, String paramString, i parami)
  {
    AppMethodBeat.i(48203);
    fp localfp = new fp();
    if (!paramBoolean)
    {
      paramString = a.ME(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48203);
        return null;
      }
      localfp.lo(paramString.appId);
      localfp.ln(paramString.kGa);
      localfp.ecH = paramString.lrW;
      localfp.eai = paramString.apptype;
      localfp.dYT = paramString.lty;
      localfp.dKe = paramString.scene;
    }
    for (localfp.eaX = paramString.bmT();; localfp.eaX = 1L)
    {
      a(localfp, parami);
      AppMethodBeat.o(48203);
      return localfp;
    }
  }
  
  private static void a(fp paramfp, i parami)
  {
    AppMethodBeat.i(48204);
    int i;
    if (parami != null) {
      switch (2.lsF[com.tencent.mm.plugin.appbrand.report.c.d(parami).ordinal()])
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      paramfp.ecK = i;
      if ((parami instanceof bd)) {
        paramfp.lr(bmN());
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
    fp localfp = new fp();
    Object localObject = a.ME(paramd.getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(175062);
      return;
    }
    localfp.lo(((QualitySessionRuntime)localObject).appId);
    localfp.ln(((QualitySessionRuntime)localObject).kGa);
    localfp.ecH = ((QualitySessionRuntime)localObject).lrW;
    localfp.eai = ((QualitySessionRuntime)localObject).apptype;
    localfp.dYT = ((QualitySessionRuntime)localObject).lty;
    localfp.dKe = ((QualitySessionRuntime)localObject).scene;
    a(localfp, paramd.aOf());
    if ((paramd instanceof aa))
    {
      localObject = "WebView-wxConfigReady";
      localfp.lp((String)localObject);
      localfp.ecI = bt.nullAsNil(paramString).length();
      localfp.lq(paramd.aLC().aPa());
      if (!paramBoolean) {
        break label262;
      }
    }
    label262:
    for (long l = 1L;; l = 0L)
    {
      localfp.ecM = l;
      localfp.iB(paramLong1);
      localfp.iC(paramLong2);
      localfp.iA(localfp.ebr - localfp.ebq);
      localfp.ecN = paramLong3;
      localfp.aBj();
      AppMethodBeat.o(175062);
      return;
      if (((o)paramd.getRuntime()).CZ())
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
    fh localfh = new fh();
    int i;
    if (parame != null) {
      i = 1;
    }
    while (i == 0)
    {
      parame = a.ME(paramString);
      if (parame == null)
      {
        AppMethodBeat.o(48201);
        return;
        i = 0;
      }
      else
      {
        localfh.lh(parame.appId);
        localfh.lg(parame.kGa);
        localfh.ebT = fh.a.iQ(parame.lrW);
        localfh.eai = parame.apptype;
        localfh.dYT = parame.lty;
        localfh.dKe = parame.scene;
        localfh.eaX = parame.bmT();
        if (parame.cbn) {
          l = 1L;
        }
        localfh.ebU = l;
        localfh.ii(paramLong);
        localfh.RQ();
        localfh.ih(localfh.ebr - paramLong);
        switch (2.lsF[paramc.ordinal()])
        {
        default: 
          localfh.dZg = 2147483647L;
        }
      }
    }
    for (;;)
    {
      localfh.aBj();
      AppMethodBeat.o(48201);
      return;
      localfh.eaX = 1L;
      if (parame == e.lwy) {
        l = 1L;
      }
      localfh.ebU = l;
      break;
      localfh.dZg = 1L;
      continue;
      localfh.dZg = 2L;
      continue;
      localfh.dZg = 3L;
      continue;
      localfh.dZg = 4L;
      continue;
      localfh.dZg = 5L;
      continue;
      localfh.dZg = 6L;
    }
  }
  
  public static void a(String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(48207);
    paramString = a.ME(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(48207);
      return;
    }
    fv localfv = new fv();
    localfv.eag = localfv.t("AppId", paramString.appId, true);
    localfv.dYa = localfv.t("InstanceId", paramString.kGa, true);
    localfv.edN = fv.a.jb(paramString.lrW);
    localfv.eai = paramString.apptype;
    localfv.dYT = paramString.lty;
    localfv.dKe = paramString.scene;
    localfv.eec = paramString.ltL.get();
    localfv.Se();
    localfv.Sf();
    localfv.Sd();
    localfv.edO = paramm.fps;
    localfv.edP = Math.round(paramm.lue);
    if (paramm.ltY == l.a.lua) {}
    for (;;)
    {
      localfv.edX = i;
      localfv.edY = paramm.luf;
      localfv.edZ = paramm.lug;
      localfv.eea = paramm.luh;
      localfv.edT = paramm.ccq;
      localfv.edU = paramm.ccr;
      localfv.edR = paramm.ccp;
      localfv.edS = paramm.lui;
      localfv.edV = (paramm.luj / 1000);
      localfv.edW = paramm.jqE;
      localfv.edQ = paramm.luk;
      localfv.eeb = paramm.lul;
      localfv.eed = paramm.lum;
      localfv.eee = paramm.lun;
      localfv.eef = paramm.luo;
      localfv.eeg = paramm.lup;
      localfv.eeh = paramm.luq;
      localfv.aBj();
      AppMethodBeat.o(48207);
      return;
      if (paramm.ltY == l.a.lub) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(48208);
    fd localfd = new fd();
    if (!paramBoolean)
    {
      paramString = a.ME(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48208);
        return;
      }
      localfd.lf(paramString.appId);
      localfd.le(paramString.kGa);
      localfd.ebx = fd.a.iM(paramString.lrW);
      localfd.eai = paramString.apptype;
      localfd.dKe = paramString.scene;
    }
    localfd.hX(paramLong);
    localfd.RP();
    localfd.hW(localfd.ebr - localfd.ebq);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localfd.eby = paramLong;
      localfd.aBj();
      AppMethodBeat.o(48208);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong, n paramn)
  {
    AppMethodBeat.i(48200);
    gf localgf = new gf();
    if (!paramBoolean)
    {
      paramString = a.ME(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48200);
        return;
      }
      localgf.lU(paramString.appId);
      localgf.lT(paramString.kGa);
      localgf.egw = gf.a.jm(paramString.lrW);
      localgf.eai = paramString.apptype;
      localgf.dYT = paramString.lty;
      localgf.dKe = paramString.scene;
      localgf.eaX = paramString.bmT();
      localgf.jX(paramLong);
      localgf.Sj();
      localgf.jW(localgf.ebr - paramLong);
      switch (2.lsJ[paramn.ordinal()])
      {
      default: 
        localgf.dZg = 2147483647L;
      }
    }
    for (;;)
    {
      localgf.egx = bmN();
      localgf.lV(bmN());
      localgf.aBj();
      AppMethodBeat.o(48200);
      return;
      localgf.eaX = 1L;
      break;
      localgf.dZg = 2L;
      continue;
      localgf.dZg = 4L;
      continue;
      localgf.dZg = 3L;
    }
  }
  
  public static fp g(d paramd)
  {
    AppMethodBeat.i(48202);
    fp localfp = a(paramd.aNv(), paramd.getAppId(), paramd.aOf());
    if (localfp == null)
    {
      AppMethodBeat.o(48202);
      return null;
    }
    localfp.lq(paramd.aLC().aPa());
    AppMethodBeat.o(48202);
    return localfp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b
 * JD-Core Version:    0.7.0.1
 */
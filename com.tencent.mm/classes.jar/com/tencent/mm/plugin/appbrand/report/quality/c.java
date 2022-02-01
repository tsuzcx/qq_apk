package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.sm;
import com.tencent.mm.autogen.mmdata.rpt.sm.a;
import com.tencent.mm.autogen.mmdata.rpt.sq;
import com.tencent.mm.autogen.mmdata.rpt.sq.a;
import com.tencent.mm.autogen.mmdata.rpt.ta;
import com.tencent.mm.autogen.mmdata.rpt.th;
import com.tencent.mm.autogen.mmdata.rpt.th.a;
import com.tencent.mm.autogen.mmdata.rpt.tr;
import com.tencent.mm.autogen.mmdata.rpt.tr.a;
import com.tencent.mm.plugin.appbrand.appcache.AbsReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.plugin.appbrand.task.l;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  extends d
{
  private static ta a(boolean paramBoolean, String paramString, i parami)
  {
    AppMethodBeat.i(48203);
    ta localta = new ta();
    if (!paramBoolean)
    {
      paramString = b.afZ(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48203);
        return null;
      }
      localta.zs(paramString.appId);
      localta.zr(paramString.eup);
      localta.ine = paramString.tQx;
      localta.jax = paramString.apptype;
      localta.ind = paramString.tSh;
      localta.iqr = paramString.scene;
    }
    for (localta.jyp = paramString.cJi();; localta.jyp = 1L)
    {
      a(localta, parami);
      AppMethodBeat.o(48203);
      return localta;
    }
  }
  
  private static void a(ta paramta, i parami)
  {
    AppMethodBeat.i(48204);
    int i;
    if (parami != null) {
      switch (2.tRq[e.f(parami).ordinal()])
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      paramta.jAj = i;
      if ((parami instanceof bd)) {
        paramta.zv(cJc());
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
    ta localta = new ta();
    Object localObject = b.afZ(paramg.getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(175062);
      return;
    }
    localta.zs(((QualitySessionRuntime)localObject).appId);
    localta.zr(((QualitySessionRuntime)localObject).eup);
    localta.ine = ((QualitySessionRuntime)localObject).tQx;
    localta.jax = ((QualitySessionRuntime)localObject).apptype;
    localta.ind = ((QualitySessionRuntime)localObject).tSh;
    localta.iqr = ((QualitySessionRuntime)localObject).scene;
    a(localta, paramg.getJsRuntime());
    if ((paramg instanceof ad))
    {
      localObject = "WebView-wxConfigReady";
      localta.zt((String)localObject);
      localta.jAh = Util.nullAsNil(paramString).length();
      localta.zu(paramg.cbl().cfD());
      if (!paramBoolean) {
        break label294;
      }
    }
    label294:
    for (long l = 1L;; l = 0L)
    {
      localta.jAl = l;
      localta.fZ(paramLong1);
      localta.ga(paramLong2);
      localta.fY(localta.jyJ - localta.jyI);
      localta.jAm = paramLong3;
      if ((paramg.cbl() instanceof AbsReader)) {
        localta.zw(Util.nullAsNil(((AbsReader)paramg.cbl()).cfH().arl()));
      }
      localta.bMH();
      AppMethodBeat.o(175062);
      return;
      if (((w)paramg.getRuntime()).aqJ())
      {
        localObject = "GameMainContext-wxConfigReady";
        break;
      }
      localObject = "MainContext-wxConfigReady";
      break;
    }
  }
  
  public static void a(l paraml, String paramString, long paramLong, e parame)
  {
    long l = 0L;
    AppMethodBeat.i(48201);
    sq localsq = new sq();
    int i;
    if (paraml != null) {
      i = 1;
    }
    while (i == 0)
    {
      paraml = b.afZ(paramString);
      if (paraml == null)
      {
        AppMethodBeat.o(48201);
        return;
        i = 0;
      }
      else
      {
        localsq.zg(paraml.appId);
        localsq.zf(paraml.eup);
        localsq.jzl = sq.a.oM(paraml.tQx);
        localsq.jax = paraml.apptype;
        localsq.ind = paraml.tSh;
        localsq.iqr = paraml.scene;
        localsq.jyp = paraml.cJi();
        if (paraml.ekt) {
          l = 1L;
        }
        localsq.jzm = l;
        localsq.fK(paramLong);
        localsq.aIZ();
        localsq.fJ(localsq.jyJ - paramLong);
        switch (2.tRq[parame.ordinal()])
        {
        default: 
          localsq.ixD = 2147483647L;
        }
      }
    }
    for (;;)
    {
      localsq.zh(V8.getV8Version());
      localsq.bMH();
      AppMethodBeat.o(48201);
      return;
      localsq.jyp = 1L;
      if (paraml == l.tWx) {
        l = 1L;
      }
      localsq.jzm = l;
      break;
      localsq.ixD = 1L;
      continue;
      localsq.ixD = 2L;
      continue;
      localsq.ixD = 3L;
      continue;
      localsq.ixD = 4L;
      continue;
      localsq.ixD = 5L;
      continue;
      localsq.ixD = 6L;
    }
  }
  
  public static void a(String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(48207);
    paramString = b.afZ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(48207);
      return;
    }
    th localth = new th();
    localth.imT = localth.F("AppId", paramString.appId, true);
    localth.ilM = localth.F("InstanceId", paramString.eup, true);
    localth.jBy = th.a.oX(paramString.tQx);
    localth.jax = paramString.apptype;
    localth.ind = paramString.tSh;
    localth.iqr = paramString.scene;
    localth.jBN = paramString.tSu.get();
    localth.aJg();
    localth.aJh();
    localth.aJf();
    localth.jBz = paramm.fps;
    localth.jBA = Math.round(paramm.tSN);
    if (paramm.tSH == l.a.tSJ) {}
    for (;;)
    {
      localth.jBI = i;
      localth.jBJ = paramm.tSO;
      localth.jBK = paramm.tSP;
      localth.jBL = paramm.tSQ;
      localth.jBE = paramm.elO;
      localth.jBF = paramm.elP;
      localth.jBC = paramm.elN;
      localth.jBD = paramm.tSR;
      localth.jBG = (paramm.tSS / 1000);
      localth.jBH = paramm.rqQ;
      localth.jBB = paramm.tST;
      localth.jBM = paramm.tSU;
      localth.jBO = paramm.tSV;
      localth.jBP = paramm.tSW;
      localth.jBQ = paramm.tSX;
      localth.jBR = paramm.tSY;
      localth.jBS = paramm.tSZ;
      localth.jBW = paramm.eGy;
      localth.jBX = paramm.eGz;
      localth.jBY = paramm.tTa;
      localth.bMH();
      AppMethodBeat.o(48207);
      return;
      if (paramm.tSH == l.a.tSK) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(48208);
    sm localsm = new sm();
    if (!paramBoolean)
    {
      paramString = b.afZ(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48208);
        return;
      }
      localsm.ze(paramString.appId);
      localsm.zd(paramString.eup);
      localsm.jyP = sm.a.oI(paramString.tQx);
      localsm.jax = paramString.apptype;
      localsm.iqr = paramString.scene;
    }
    localsm.fz(paramLong);
    localsm.aIY();
    localsm.fy(localsm.jyJ - localsm.jyI);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localsm.jyQ = paramLong;
      localsm.bMH();
      AppMethodBeat.o(48208);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong, q paramq)
  {
    AppMethodBeat.i(48200);
    tr localtr = new tr();
    if (!paramBoolean)
    {
      paramString = b.afZ(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(48200);
        return;
      }
      localtr.zY(paramString.appId);
      localtr.zX(paramString.eup);
      localtr.jEG = tr.a.ph(paramString.tQx);
      localtr.jax = paramString.apptype;
      localtr.ind = paramString.tSh;
      localtr.iqr = paramString.scene;
      localtr.jyp = paramString.cJi();
      localtr.gG(paramLong);
      localtr.aJj();
      localtr.gF(localtr.jyJ - paramLong);
      switch (2.tRu[paramq.ordinal()])
      {
      default: 
        localtr.ixD = 2147483647L;
      }
    }
    for (;;)
    {
      localtr.jEH = cJc();
      localtr.zZ(cJc());
      localtr.bMH();
      AppMethodBeat.o(48200);
      return;
      localtr.jyp = 1L;
      break;
      localtr.ixD = 2L;
      continue;
      localtr.ixD = 4L;
      continue;
      localtr.ixD = 3L;
      continue;
      localtr.ixD = 5L;
    }
  }
  
  public final ta k(g paramg)
  {
    AppMethodBeat.i(48202);
    ta localta = a(paramg.cdi(), paramg.getAppId(), paramg.getJsRuntime());
    if (localta == null)
    {
      AppMethodBeat.o(48202);
      return null;
    }
    localta.zu(paramg.cbl().cfD());
    if ((paramg.cbl() instanceof AbsReader)) {
      localta.zw(Util.nullAsNil(((AbsReader)paramg.cbl()).cfH().arl()));
    }
    AppMethodBeat.o(48202);
    return localta;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.c
 * JD-Core Version:    0.7.0.1
 */
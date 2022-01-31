package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cd;
import com.tencent.mm.g.b.a.cd.a;
import com.tencent.mm.g.b.a.ch;
import com.tencent.mm.g.b.a.ch.a;
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.g.b.a.cm.a;
import com.tencent.mm.g.b.a.co;
import com.tencent.mm.g.b.a.co.a;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.g.b.a.ct.a;
import com.tencent.mm.g.b.a.cv;
import com.tencent.mm.g.b.a.cv.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.g;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends c
{
  public static void a(g paramg, String paramString, long paramLong, com.tencent.mm.plugin.appbrand.report.c paramc)
  {
    long l1 = 0L;
    AppMethodBeat.i(132688);
    ch localch = new ch();
    int i;
    if (paramg != null) {
      i = 1;
    }
    long l2;
    for (;;)
    {
      if (i == 0)
      {
        paramg = a.EM(paramString);
        if (paramg == null)
        {
          AppMethodBeat.o(132688);
          return;
          i = 0;
        }
        else
        {
          localch.hn(paramg.appId);
          localch.hm(paramg.ikX);
          localch.daW = ch.a.gU(paramg.iIF);
          localch.cZD = paramg.apptype;
          localch.cZB = paramg.iIG;
          localch.cRG = paramg.scene;
          if (paramg.iIQ)
          {
            l2 = 2L;
            localch.daa = l2;
            if (paramg.bAa) {
              l1 = 1L;
            }
            localch.daX = l1;
            label148:
            localch.eR(paramLong);
            localch.GZ();
            localch.eQ(localch.dav - paramLong);
            switch (b.1.iIq[paramc.ordinal()])
            {
            default: 
              localch.cYC = 2147483647L;
            }
          }
        }
      }
    }
    for (;;)
    {
      localch.ake();
      AppMethodBeat.o(132688);
      return;
      l2 = 0L;
      break;
      localch.daa = 1L;
      if (paramg == g.iKT) {
        l1 = 1L;
      }
      localch.daX = l1;
      break label148;
      localch.cYC = 1L;
      continue;
      localch.cYC = 2L;
      continue;
      localch.cYC = 3L;
      continue;
      localch.cYC = 4L;
      continue;
      localch.cYC = 5L;
      continue;
      localch.cYC = 6L;
    }
  }
  
  public static void a(String paramString, i parami)
  {
    AppMethodBeat.i(143521);
    paramString = a.EM(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(143521);
      return;
    }
    co localco = new co();
    localco.hK(paramString.appId);
    localco.hJ(paramString.ikX);
    localco.dbP = co.a.hb(paramString.iIF);
    localco.cZD = paramString.apptype;
    localco.cZB = paramString.iIG;
    localco.cRG = paramString.scene;
    localco.dce = paramString.iIO.get();
    localco.Hf();
    localco.Hg();
    localco.He();
    localco.dbQ = parami.fps;
    localco.dbR = Math.round(parami.iIX);
    int i;
    if (parami.iIS == h.a.iIU) {
      i = 1;
    }
    for (;;)
    {
      localco.dbZ = i;
      localco.dca = parami.iIY;
      localco.dcb = parami.iIZ;
      localco.dcc = parami.iJa;
      localco.dbV = parami.bAT;
      localco.dbW = parami.bAU;
      localco.dbT = parami.bAS;
      localco.dbU = parami.iJb;
      localco.dbX = (parami.iJc / 1000);
      localco.dbY = parami.hsW;
      localco.dbS = parami.iJd;
      localco.dcd = parami.iJe;
      localco.ake();
      AppMethodBeat.o(143521);
      return;
      if (parami.iIS == h.a.iIV) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public static void a(String paramString, AppBrandPreloadProfiler paramAppBrandPreloadProfiler)
  {
    AppMethodBeat.i(132686);
    ct localct = new ct();
    paramString = a.EM(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(132686);
      return;
    }
    localct.hV(paramString.appId);
    localct.hU(paramString.ikX);
    localct.ddd = ct.a.hh(paramString.iIF);
    localct.cZD = paramString.apptype;
    localct.cZB = paramString.iIG;
    localct.ft(paramAppBrandPreloadProfiler.aLI());
    localct.fu(paramAppBrandPreloadProfiler.aLH());
    localct.ake();
    AppMethodBeat.o(132686);
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(143522);
    cd localcd = new cd();
    if (!paramBoolean)
    {
      paramString = a.EM(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(143522);
        return;
      }
      localcd.hf(paramString.appId);
      localcd.he(paramString.ikX);
      localcd.daA = cd.a.gQ(paramString.iIF);
      localcd.cZD = paramString.apptype;
      localcd.cRG = paramString.scene;
    }
    localcd.eG(paramLong);
    localcd.GY();
    localcd.eF(localcd.dav - localcd.dau);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localcd.daB = paramLong;
      localcd.ake();
      AppMethodBeat.o(143522);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, long paramLong, j paramj)
  {
    AppMethodBeat.i(132687);
    cv localcv = new cv();
    long l;
    if (!paramBoolean)
    {
      paramString = a.EM(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(132687);
        return;
      }
      localcv.hZ(paramString.appId);
      localcv.hY(paramString.ikX);
      localcv.ddz = cv.a.hj(paramString.iIF);
      localcv.cZD = paramString.apptype;
      localcv.cZB = paramString.iIG;
      localcv.cRG = paramString.scene;
      if (paramString.iIQ)
      {
        l = 2L;
        localcv.daa = l;
        label116:
        localcv.fy(paramLong);
        localcv.Hi();
        localcv.fx(localcv.dav - paramLong);
        switch (b.1.iIp[paramj.ordinal()])
        {
        default: 
          localcv.cYC = 2147483647L;
        }
      }
    }
    for (;;)
    {
      localcv.ake();
      AppMethodBeat.o(132687);
      return;
      l = 0L;
      break;
      localcv.daa = 1L;
      break label116;
      localcv.cYC = 2L;
      continue;
      localcv.cYC = 4L;
      continue;
      localcv.cYC = 3L;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString1, long paramLong1, String paramString2, long paramLong2)
  {
    AppMethodBeat.i(132689);
    cm localcm = new cm();
    long l;
    if (!paramBoolean)
    {
      paramString1 = a.EM(paramString1);
      if (paramString1 == null)
      {
        AppMethodBeat.o(132689);
        return;
      }
      localcm.hC(paramString1.appId);
      localcm.hB(paramString1.ikX);
      localcm.dbC = cm.a.gZ(paramString1.iIF);
      localcm.cZD = paramString1.apptype;
      localcm.cZB = paramString1.iIG;
      localcm.cRG = paramString1.scene;
      if (paramString1.iIQ) {
        l = 2L;
      }
    }
    for (localcm.daa = l;; localcm.daa = 1L)
    {
      localcm.eZ(paramLong1);
      localcm.Hd();
      localcm.eY(localcm.dav - paramLong1);
      localcm.hD(paramString2);
      localcm.dbi = paramLong2;
      localcm.hE(WxaCommLibRuntimeReader.getVersionName());
      localcm.ake();
      AppMethodBeat.o(132689);
      return;
      l = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b
 * JD-Core Version:    0.7.0.1
 */
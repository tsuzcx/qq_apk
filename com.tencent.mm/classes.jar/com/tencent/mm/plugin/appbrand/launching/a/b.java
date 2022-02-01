package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.g.b.a.iz;
import com.tencent.mm.g.b.a.iz.b;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.launching.ax;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.eja;
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.ekg;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.c.a;

public final class b
  extends com.tencent.mm.plugin.appbrand.networking.b<bua>
{
  final String cmr;
  private String lIU;
  volatile boolean lOV;
  private final iz lQA;
  public volatile ax lQz;
  final com.tencent.mm.ak.b rr;
  
  public b(String paramString1, boolean paramBoolean, ehk paramehk, ekg paramekg, eja parameja, String paramString2, int paramInt, QualitySession paramQualitySession, String paramString3, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    super(paramString1, paramString3);
    AppMethodBeat.i(222801);
    this.lOV = false;
    this.cmr = paramString2;
    this.lQA = com.tencent.mm.plugin.appbrand.report.quality.f.f(paramQualitySession);
    iz localiz = this.lQA;
    iz.b localb;
    if (paramBoolean)
    {
      localb = iz.b.eAv;
      localiz.eAp = localb;
      this.lQA.ehL = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      this.lIU = paramQualitySession.lIU;
      paramQualitySession = new btz();
      paramQualitySession.ikm = paramString1;
      paramQualitySession.HgZ = paramehk;
      if (!paramBoolean) {
        break label318;
      }
    }
    label318:
    for (int i = 1;; i = 2)
    {
      paramQualitySession.GWF = i;
      paramQualitySession.Hhc = paramekg;
      paramQualitySession.Hhd = parameja;
      paramQualitySession.Hhh = paramString3;
      paramehk = new eij();
      paramehk.Hkr = paramInt;
      paramQualitySession.Hhb = paramehk;
      if ((paramQualitySession.HgZ.Scene == 1162) && (paramAppBrandLaunchFromNotifyReferrer != null))
      {
        paramehk = new ejj();
        paramehk.Imr = paramAppBrandLaunchFromNotifyReferrer.kbd;
        paramQualitySession.Hhi = paramehk;
      }
      paramehk = new b.a();
      paramehk.funcId = 1122;
      paramehk.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
      paramehk.hQF = paramQualitySession;
      paramehk.hQG = new bua();
      paramehk = paramehk.aDS();
      this.rr = paramehk;
      c(paramehk);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "<init> cgiHash[%d], username[%s] appId[%s] sync[%b] sessionId[%s] instanceId[%s] libVersion[%d] ", new Object[] { Integer.valueOf(hashCode()), paramString3, paramString1, Boolean.valueOf(paramBoolean), paramString2, this.lIU, Integer.valueOf(paramInt) });
      AppMethodBeat.o(222801);
      return;
      localb = iz.b.eAw;
      break;
    }
  }
  
  public static void a(btz parambtz)
  {
    AppMethodBeat.i(47398);
    try
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.geV.fYl)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "SrvDeviceInfo isLimit benchmarkLevel");
        parambtz.Hhf = -1;
        AppMethodBeat.o(47398);
        return;
      }
      parambtz.Hhf = com.tencent.mm.n.g.acL().getInt("ClientBenchmarkLevel", -1);
      if (parambtz.Hhf == 0) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DynamicConfig performanceLevel 0 illegal");
      }
      AppMethodBeat.o(47398);
      return;
    }
    catch (Exception parambtz)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", parambtz, "read performanceLevel", new Object[0]);
      AppMethodBeat.o(47398);
    }
  }
  
  public static void b(btz parambtz)
  {
    AppMethodBeat.i(47399);
    int i = parambtz.Hhb.Hkr;
    if (i > 0)
    {
      ag localag = j.aZz();
      if (localag != null)
      {
        af localaf = new af();
        localaf.field_key = "@LibraryAppId";
        localaf.field_version = i;
        if (localag.get(localaf, new String[] { "key", "version" }))
        {
          parambtz.Hhb.FNw = ((int)localaf.field_updateTime);
          parambtz.Hhb.IlJ = localaf.field_scene;
        }
      }
    }
    AppMethodBeat.o(47399);
  }
  
  private String getUserName()
  {
    return ((btz)this.rr.hQD.hQJ).Hhh;
  }
  
  public final com.tencent.mm.cm.f<a.a<bua>> aET()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47397);
        Object localObject1 = new a().a((btz)this.rr.hQD.hQJ, this.lOV, this);
        if (localObject1 != null)
        {
          AppMethodBeat.o(47397);
          return localObject1;
        }
        localObject1 = com.tencent.luggage.sdk.e.c.cqj;
        localObject1 = com.tencent.luggage.sdk.e.c.dq(this.lIU);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.a((com.tencent.luggage.sdk.e.b)localObject1);
          if (localObject1 != null)
          {
            final a.a locala = ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).uu(100);
            ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).jsn = this.lOV;
            if ((locala != null) && (locala.hQv != null) && (locala.errType == 0) && (locala.errCode == 0))
            {
              ((com.tencent.luggage.sdk.e.a)localObject1).cqb = true;
              localObject1 = com.tencent.mm.cm.g.c(new c.a() {});
              AppMethodBeat.o(47397);
              continue;
            }
            localObject2.cqb = false;
          }
        }
      }
      finally {}
      b(bsy());
      a(bsy());
      long l = bu.fpO();
      this.lQA.pu(l);
      com.tencent.mm.cm.f localf = super.aET();
      AppMethodBeat.o(47397);
    }
  }
  
  final int aWk()
  {
    return ((btz)this.rr.hQD.hQJ).HgZ.HeR;
  }
  
  public final com.tencent.mm.cm.f<a.a<bua>> beN()
  {
    AppMethodBeat.i(222803);
    if (!com.tencent.mm.plugin.appbrand.networking.a.ej(getAppId(), getUserName()))
    {
      com.tencent.mm.cm.f localf = com.tencent.mm.cm.g.c(new c.a() {});
      AppMethodBeat.o(222803);
      return localf;
    }
    AppMethodBeat.o(222803);
    return null;
  }
  
  public final void bsA()
  {
    AppMethodBeat.i(47396);
    com.tencent.mm.plugin.appbrand.utils.f.bCj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47391);
        b.this.lOV = false;
        b.this.aET();
        AppMethodBeat.o(47391);
      }
    });
    AppMethodBeat.o(47396);
  }
  
  final boolean bsx()
  {
    return ((btz)this.rr.hQD.hQJ).HgZ.Hkp > 0;
  }
  
  protected final btz bsy()
  {
    return (btz)this.rr.hQD.hQJ;
  }
  
  public final a.a<bua> bsz()
  {
    AppMethodBeat.i(222802);
    this.lOV = true;
    a.a locala = super.bsz();
    AppMethodBeat.o(222802);
    return locala;
  }
  
  final String getAppId()
  {
    return ((btz)this.rr.hQD.hQJ).ikm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.b
 * JD-Core Version:    0.7.0.1
 */
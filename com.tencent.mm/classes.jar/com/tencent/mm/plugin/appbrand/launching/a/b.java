package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.g.b.a.ix;
import com.tencent.mm.g.b.a.ix.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.launching.ax;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.protocal.protobuf.ehj;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.protocal.protobuf.eip;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.c.a;

public final class b
  extends com.tencent.mm.plugin.appbrand.networking.a<btg>
{
  final String cmp;
  private String lEv;
  volatile boolean lKu;
  public volatile ax lLZ;
  private final ix lMa;
  final com.tencent.mm.al.b rr;
  
  public b(String paramString1, boolean paramBoolean, eft parameft, eip parameip, ehj paramehj, String paramString2, int paramInt, QualitySession paramQualitySession, String paramString3, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    super(paramString1, paramString3);
    AppMethodBeat.i(188640);
    this.lKu = false;
    this.cmp = paramString2;
    this.lMa = com.tencent.mm.plugin.appbrand.report.quality.f.f(paramQualitySession);
    ix localix = this.lMa;
    ix.b localb;
    if (paramBoolean)
    {
      localb = ix.b.eyM;
      localix.eyG = localb;
      this.lMa.ega = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      this.lEv = paramQualitySession.lEv;
      paramQualitySession = new btf();
      paramQualitySession.iht = paramString1;
      paramQualitySession.GNz = parameft;
      if (!paramBoolean) {
        break label318;
      }
    }
    label318:
    for (int i = 1;; i = 2)
    {
      paramQualitySession.GDf = i;
      paramQualitySession.GNC = parameip;
      paramQualitySession.GND = paramehj;
      paramQualitySession.GNH = paramString3;
      parameft = new egs();
      parameft.GQQ = paramInt;
      paramQualitySession.GNB = parameft;
      if ((paramQualitySession.GNz.Scene == 1162) && (paramAppBrandLaunchFromNotifyReferrer != null))
      {
        parameft = new ehs();
        parameft.HSk = paramAppBrandLaunchFromNotifyReferrer.jXO;
        paramQualitySession.GNI = parameft;
      }
      parameft = new b.a();
      parameft.funcId = 1122;
      parameft.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
      parameft.hNM = paramQualitySession;
      parameft.hNN = new btg();
      parameft = parameft.aDC();
      this.rr = parameft;
      c(parameft);
      ad.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "<init> cgiHash[%d], username[%s] appId[%s] sync[%b] sessionId[%s] instanceId[%s] libVersion[%d] ", new Object[] { Integer.valueOf(hashCode()), paramString3, paramString1, Boolean.valueOf(paramBoolean), paramString2, this.lEv, Integer.valueOf(paramInt) });
      AppMethodBeat.o(188640);
      return;
      localb = ix.b.eyN;
      break;
    }
  }
  
  public static void a(btf parambtf)
  {
    AppMethodBeat.i(47398);
    try
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.gcN.fWf)
      {
        ad.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "SrvDeviceInfo isLimit benchmarkLevel");
        parambtf.GNF = -1;
        AppMethodBeat.o(47398);
        return;
      }
      parambtf.GNF = com.tencent.mm.n.g.acA().getInt("ClientBenchmarkLevel", -1);
      if (parambtf.GNF == 0) {
        ad.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DynamicConfig performanceLevel 0 illegal");
      }
      AppMethodBeat.o(47398);
      return;
    }
    catch (Exception parambtf)
    {
      ad.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", parambtf, "read performanceLevel", new Object[0]);
      AppMethodBeat.o(47398);
    }
  }
  
  public static void b(btf parambtf)
  {
    AppMethodBeat.i(47399);
    int i = parambtf.GNB.GQQ;
    if (i > 0)
    {
      af localaf = j.aZc();
      if (localaf != null)
      {
        com.tencent.mm.plugin.appbrand.appcache.ae localae = new com.tencent.mm.plugin.appbrand.appcache.ae();
        localae.field_key = "@LibraryAppId";
        localae.field_version = i;
        if (localaf.get(localae, new String[] { "key", "version" }))
        {
          parambtf.GNB.FuY = ((int)localae.field_updateTime);
          parambtf.GNB.HRC = localae.field_scene;
        }
      }
    }
    AppMethodBeat.o(47399);
  }
  
  public final com.tencent.mm.cn.f<a.a<btg>> aED()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47397);
        Object localObject1 = new a().a((btf)this.rr.hNK.hNQ, this.lKu, this);
        if (localObject1 != null)
        {
          AppMethodBeat.o(47397);
          return localObject1;
        }
        localObject1 = com.tencent.luggage.sdk.e.c.cpG;
        localObject1 = com.tencent.luggage.sdk.e.c.jdMethod_do(this.lEv);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.a((com.tencent.luggage.sdk.e.b)localObject1);
          if (localObject1 != null)
          {
            final a.a locala = ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).uo(100);
            ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).jpu = this.lKu;
            if ((locala != null) && (locala.hNC != null) && (locala.errType == 0) && (locala.errCode == 0))
            {
              ((com.tencent.luggage.sdk.e.a)localObject1).cpy = true;
              localObject1 = com.tencent.mm.cn.g.c(new c.a() {});
              AppMethodBeat.o(47397);
              continue;
            }
            localObject2.cpy = false;
          }
        }
      }
      finally {}
      b(brN());
      a(brN());
      long l = bt.flT();
      this.lMa.ph(l);
      com.tencent.mm.cn.f localf = super.aED();
      AppMethodBeat.o(47397);
    }
  }
  
  final int aVL()
  {
    return ((btf)this.rr.hNK.hNQ).GNz.GLq;
  }
  
  final boolean brM()
  {
    return ((btf)this.rr.hNK.hNQ).GNz.GQO > 0;
  }
  
  protected final btf brN()
  {
    return (btf)this.rr.hNK.hNQ;
  }
  
  public final a.a<btg> brO()
  {
    AppMethodBeat.i(188641);
    this.lKu = true;
    a.a locala = super.brO();
    AppMethodBeat.o(188641);
    return locala;
  }
  
  public final void brP()
  {
    AppMethodBeat.i(47396);
    com.tencent.mm.plugin.appbrand.utils.e.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47391);
        b.this.lKu = false;
        b.this.aED();
        AppMethodBeat.o(47391);
      }
    });
    AppMethodBeat.o(47396);
  }
  
  final String getAppId()
  {
    return ((btf)this.rr.hNK.hNQ).iht;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.b
 * JD-Core Version:    0.7.0.1
 */
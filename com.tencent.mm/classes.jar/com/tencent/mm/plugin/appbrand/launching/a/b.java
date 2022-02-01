package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.g.b.a.ht.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.launching.au;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.protocal.protobuf.ebo;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  extends com.tencent.mm.ak.c<bot>
{
  final String cbY;
  private String lht;
  public volatile boolean lnb;
  public volatile au loH;
  private final ht loI;
  final com.tencent.mm.ak.b rr;
  
  public b(String paramString1, boolean paramBoolean, dzp paramdzp, ecj paramecj, ebf paramebf, String paramString2, int paramInt, QualitySession paramQualitySession, String paramString3, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    AppMethodBeat.i(186856);
    this.lnb = false;
    this.cbY = paramString2;
    this.loI = com.tencent.mm.plugin.appbrand.report.quality.f.f(paramQualitySession);
    ht localht = this.loI;
    if (paramBoolean)
    {
      paramString2 = ht.b.ehM;
      localht.ehG = paramString2;
      this.loI.dQE = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      this.lht = paramQualitySession.lht;
      paramString2 = new bos();
      paramString2.hOf = paramString1;
      paramString2.FdV = paramdzp;
      if (!paramBoolean) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 2)
    {
      paramString2.ETI = i;
      paramString2.FdY = paramecj;
      paramString2.FdZ = paramebf;
      paramString2.Fed = paramString3;
      paramString1 = new eao();
      paramString1.Fho = paramInt;
      paramString2.FdX = paramString1;
      if ((paramString2.FdV.Scene == 1162) && (paramAppBrandLaunchFromNotifyReferrer != null))
      {
        paramString1 = new ebo();
        paramString1.GgX = paramAppBrandLaunchFromNotifyReferrer.jDN;
        paramString2.Fee = paramString1;
      }
      paramString1 = new b.a();
      paramString1.funcId = 1122;
      paramString1.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
      paramString1.hvt = paramString2;
      paramString1.hvu = new bot();
      paramString1 = paramString1.aAz();
      this.rr = paramString1;
      this.rr = paramString1;
      AppMethodBeat.o(186856);
      return;
      paramString2 = ht.b.ehN;
      break;
    }
  }
  
  public static void a(bos parambos)
  {
    AppMethodBeat.i(47398);
    try
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.fJm.fCR)
      {
        ac.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "SrvDeviceInfo isLimit benchmarkLevel");
        parambos.Feb = -1;
        AppMethodBeat.o(47398);
        return;
      }
      parambos.Feb = com.tencent.mm.m.g.ZY().getInt("ClientBenchmarkLevel", -1);
      if (parambos.Feb == 0) {
        ac.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DynamicConfig performanceLevel 0 illegal");
      }
      AppMethodBeat.o(47398);
      return;
    }
    catch (Exception parambos)
    {
      ac.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", parambos, "read performanceLevel", new Object[0]);
      AppMethodBeat.o(47398);
    }
  }
  
  public static void b(bos parambos)
  {
    AppMethodBeat.i(47399);
    int i = parambos.FdX.Fho;
    if (i > 0)
    {
      com.tencent.mm.plugin.appbrand.appcache.ae localae = j.aVH();
      if (localae != null)
      {
        ad localad = new ad();
        localad.field_key = "@LibraryAppId";
        localad.field_version = i;
        if (localae.get(localad, new String[] { "key", "version" }))
        {
          parambos.FdX.DPJ = ((int)localad.field_updateTime);
          parambos.FdX.Ggp = localad.field_scene;
        }
      }
    }
    AppMethodBeat.o(47399);
  }
  
  public final com.tencent.mm.cn.f<com.tencent.mm.ak.c.a<bot>> aBB()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47397);
        Object localObject1 = new a().a((bos)this.rr.hvr.hvw, this.lnb, this);
        if (localObject1 != null)
        {
          AppMethodBeat.o(47397);
          return localObject1;
        }
        localObject1 = com.tencent.luggage.sdk.e.c.cfq;
        localObject1 = com.tencent.luggage.sdk.e.c.cm(this.lht);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.a((com.tencent.luggage.sdk.e.b)localObject1);
          if (localObject1 != null)
          {
            final com.tencent.mm.ak.c.a locala = ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).tK(100);
            ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).iWl = this.lnb;
            if ((locala != null) && (locala.hvj != null) && (locala.errType == 0) && (locala.errCode == 0))
            {
              localObject1 = com.tencent.mm.cn.g.c(new com.tencent.mm.vending.g.c.a() {});
              AppMethodBeat.o(47397);
              continue;
            }
          }
        }
        b(bnV());
      }
      finally {}
      a(bnV());
      long l = bs.eWj();
      this.loI.nj(l);
      com.tencent.mm.cn.f localf = super.aBB();
      AppMethodBeat.o(47397);
    }
  }
  
  final int aSy()
  {
    return ((bos)this.rr.hvr.hvw).FdV.FbR;
  }
  
  final boolean bnU()
  {
    return ((bos)this.rr.hvr.hvw).FdV.Fhm > 0;
  }
  
  protected final bos bnV()
  {
    return (bos)this.rr.hvr.hvw;
  }
  
  public final void bnW()
  {
    AppMethodBeat.i(47396);
    com.tencent.mm.plugin.appbrand.utils.e.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47391);
        b.this.lnb = false;
        b.this.aBB();
        AppMethodBeat.o(47391);
      }
    });
    AppMethodBeat.o(47396);
  }
  
  final String getAppId()
  {
    return ((bos)this.rr.hvr.hvw).hOf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.b
 * JD-Core Version:    0.7.0.1
 */
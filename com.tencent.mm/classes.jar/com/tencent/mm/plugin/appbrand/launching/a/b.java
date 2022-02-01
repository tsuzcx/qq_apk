package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.b.a.mv;
import com.tencent.mm.g.b.a.mv.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.launching.aa;
import com.tencent.mm.plugin.appbrand.launching.ap;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.protocal.protobuf.fdx;
import com.tencent.mm.protocal.protobuf.fec;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class b
  extends com.tencent.mm.plugin.appbrand.networking.b<che>
{
  final String cym;
  private final String kEY;
  volatile boolean mWd;
  public volatile ap mXK;
  public aa mXL;
  private final mv mXM;
  final com.tencent.mm.ak.d rr;
  
  public b(String paramString1, boolean paramBoolean, fcc paramfcc, fez paramfez, fds paramfds, String paramString2, int paramInt, QualitySession paramQualitySession, String paramString3, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString4, acc paramacc)
  {
    super(paramString1, paramString3);
    AppMethodBeat.i(227124);
    this.mWd = false;
    this.cym = paramString2;
    this.mXM = com.tencent.mm.plugin.appbrand.report.quality.g.e(paramQualitySession);
    mv localmv = this.mXM;
    mv.b localb;
    int i;
    if (paramBoolean)
    {
      localb = mv.b.feS;
      localmv.feM = localb;
      this.mXM.eJb = com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType();
      this.kEY = paramQualitySession.kEY;
      paramQualitySession = new chd();
      paramQualitySession.jfi = paramString1;
      paramQualitySession.Mmn = paramfcc;
      if (!paramBoolean) {
        break label378;
      }
      i = 1;
      label102:
      paramQualitySession.Mbn = i;
      paramQualitySession.Mmq = paramfez;
      paramQualitySession.Mmr = paramfds;
      paramQualitySession.Mmv = paramString3;
      paramQualitySession.Mmu = this.kEY;
      paramfcc = new fdb();
      paramfcc.MqF = paramInt;
      paramQualitySession.Mmp = paramfcc;
      if ((paramQualitySession.Mmn.Scene == 1162) && (paramAppBrandLaunchFromNotifyReferrer != null))
      {
        paramfcc = new fec();
        paramfcc.Nzu = paramAppBrandLaunchFromNotifyReferrer.lek;
        paramQualitySession.Mmw = paramfcc;
      }
      if (1173 == paramQualitySession.Mmn.Scene)
      {
        if (!Util.isNullOrNil(paramString4)) {
          break label384;
        }
        Log.w("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "<init>, openMaterialMimeType is empty");
      }
    }
    for (;;)
    {
      paramQualitySession.KOF = ((acc)Objects.requireNonNull(paramacc));
      paramfcc = new d.a();
      paramfcc.funcId = 1122;
      paramfcc.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
      paramfcc.iLN = paramQualitySession;
      paramfcc.iLO = new che();
      paramfcc = paramfcc.aXF();
      this.rr = paramfcc;
      c(paramfcc);
      Log.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "<init> cgiHash[%d], username[%s] appId[%s] sync[%b] sessionId[%s] instanceId[%s] libVersion[%d], source:%s", new Object[] { Integer.valueOf(hashCode()), paramString3, paramString1, Boolean.valueOf(paramBoolean), paramString2, this.kEY, Integer.valueOf(paramInt), com.tencent.mm.ah.a.a(paramacc) });
      AppMethodBeat.o(227124);
      return;
      localb = mv.b.feT;
      break;
      label378:
      i = 2;
      break label102;
      label384:
      paramfcc = new fdx();
      paramfcc.LXZ = paramString4;
      paramQualitySession.Mmy = paramfcc;
    }
  }
  
  public static void a(chd paramchd)
  {
    AppMethodBeat.i(47398);
    try
    {
      if (ae.gKC.gDy)
      {
        Log.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "SrvDeviceInfo isLimit benchmarkLevel");
        paramchd.Mmt = -1;
        AppMethodBeat.o(47398);
        return;
      }
      paramchd.Mmt = com.tencent.mm.n.h.aqJ().getInt("ClientBenchmarkLevel", -1);
      if (paramchd.Mmt == 0) {
        Log.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DynamicConfig performanceLevel 0 illegal");
      }
      AppMethodBeat.o(47398);
      return;
    }
    catch (Exception paramchd)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", paramchd, "read performanceLevel", new Object[0]);
      AppMethodBeat.o(47398);
    }
  }
  
  public static void b(chd paramchd)
  {
    AppMethodBeat.i(47399);
    int i = paramchd.Mmp.MqF;
    if (i > 0)
    {
      ag localag = n.buQ();
      if (localag != null)
      {
        af localaf = new af();
        localaf.field_key = "@LibraryAppId";
        localaf.field_version = i;
        if (localag.get(localaf, new String[] { "key", "version" }))
        {
          paramchd.Mmp.KHb = ((int)localaf.field_updateTime);
          paramchd.Mmp.NyM = localaf.field_scene;
        }
      }
    }
    AppMethodBeat.o(47399);
  }
  
  private String getUserName()
  {
    return ((chd)this.rr.iLK.iLR).Mmv;
  }
  
  public final com.tencent.mm.co.f<com.tencent.mm.ak.c.a<che>> aYI()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47397);
        Object localObject1 = new a().a((chd)this.rr.iLK.iLR, this.mWd, this);
        if (localObject1 != null)
        {
          AppMethodBeat.o(47397);
          return localObject1;
        }
        localObject1 = com.tencent.luggage.sdk.e.c.cCC;
        localObject1 = com.tencent.luggage.sdk.e.c.dJ(this.kEY);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.a((com.tencent.luggage.sdk.e.b)localObject1);
          if (localObject1 != null)
          {
            final com.tencent.mm.ak.c.a locala = ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).yn(100);
            ((com.tencent.mm.plugin.appbrand.launching.d.g)localObject1).kqC = this.mWd;
            if ((locala != null) && (locala.iLC != null) && (locala.errType == 0) && (locala.errCode == 0))
            {
              ((com.tencent.luggage.sdk.e.a)localObject1).cCu = true;
              localObject1 = com.tencent.mm.co.g.c(new com.tencent.mm.vending.g.c.a() {});
              AppMethodBeat.o(47397);
              continue;
            }
            localObject2.cCu = false;
          }
        }
      }
      finally {}
      b(bNU());
      a(bNU());
      long l = Util.nowMilliSecond();
      this.mXM.xf(l);
      com.tencent.mm.co.f localf = super.aYI();
      AppMethodBeat.o(47397);
    }
  }
  
  public final com.tencent.mm.co.f<com.tencent.mm.ak.c.a<che>> bAe()
  {
    AppMethodBeat.i(227126);
    if (!com.tencent.mm.plugin.appbrand.networking.a.eA(getAppId(), getUserName()))
    {
      com.tencent.mm.co.f localf = com.tencent.mm.co.g.c(new com.tencent.mm.vending.g.c.a() {});
      AppMethodBeat.o(227126);
      return localf;
    }
    AppMethodBeat.o(227126);
    return null;
  }
  
  final boolean bNT()
  {
    return ((chd)this.rr.iLK.iLR).Mmn.MqD > 0;
  }
  
  protected final chd bNU()
  {
    return (chd)this.rr.iLK.iLR;
  }
  
  public final com.tencent.mm.ak.c.a<che> bNV()
  {
    AppMethodBeat.i(227125);
    this.mWd = true;
    com.tencent.mm.ak.c.a locala = super.bNV();
    AppMethodBeat.o(227125);
    return locala;
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(47396);
    com.tencent.mm.vending.h.d.LOGIC.arrange(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47391);
        b.this.mWd = false;
        b.this.aYI();
        AppMethodBeat.o(47391);
      }
    });
    AppMethodBeat.o(47396);
  }
  
  final int brf()
  {
    return ((chd)this.rr.iLK.iLR).Mmn.MjZ;
  }
  
  final String getAppId()
  {
    return ((chd)this.rr.iLK.iLR).jfi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.b
 * JD-Core Version:    0.7.0.1
 */
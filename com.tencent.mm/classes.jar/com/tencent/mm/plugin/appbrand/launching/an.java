package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.c;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.plugin.appbrand.appcache.bi.a;
import com.tencent.mm.plugin.appbrand.appcache.br;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;

public final class an
  extends am
{
  int dnt;
  int dtF;
  cvb lHm;
  int lHo;
  String lHp;
  int lJB;
  String lJC;
  String lJD;
  String lJE;
  ac lJz;
  
  an(u paramu)
  {
    super(new ac(paramu.lHm.duW, paramu.lHm.GDK, paramu.lHm.GDN));
    AppMethodBeat.i(174976);
    this.lHm = paramu.lHm;
    this.lHo = paramu.lHo;
    this.dnt = this.lHm.FKM;
    this.lJB = paramu.lHn;
    this.lJC = paramu.md5;
    this.lHp = paramu.lHp;
    this.lJD = paramu.lHr;
    this.lJE = paramu.lHq;
    this.lJz = new ac(paramu.lHm.duW, paramu.lHm.GDK, paramu.lHm.GDN);
    AppMethodBeat.o(174976);
  }
  
  public final String aWs()
  {
    AppMethodBeat.i(174978);
    String str = String.format(Locale.US, "pkgQueryKey %s, targetVersion %d, codeType %d, pkgType %d", new Object[] { this.lJz.toString(), Integer.valueOf(this.lHo), Integer.valueOf(this.dnt), Integer.valueOf(this.dtF) });
    AppMethodBeat.o(174978);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(174977);
    Object localObject = this.lJC;
    final String str1 = this.lHp;
    String str2 = this.lJD;
    String str3 = this.lJE;
    localObject = new a(this.dnt, str1)
    {
      private void RP(String paramAnonymousString)
      {
        AppMethodBeat.i(174973);
        long l = bt.HI();
        egj localegj = new egj();
        localegj.HRw = str1;
        localegj.FFN = an.this.lHo;
        localegj.HRv = this.lJG;
        j.aYX().a(an.this.lJz.toString(), localegj, 0);
        ad.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "downloadPkg, %s flush release url key[%s] cost[%d]", new Object[] { paramAnonymousString, an.this.lJz.toString(), Long.valueOf(bt.aO(l)) });
        AppMethodBeat.o(174973);
      }
      
      protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
      {
        AppMethodBeat.i(174972);
        an.this.c(paramAnonymousWxaPkgLoadProgress);
        AppMethodBeat.o(174972);
      }
      
      public final void baR()
      {
        AppMethodBeat.i(174974);
        RP("onPkgIncrementalUpdateFailed");
        AppMethodBeat.o(174974);
      }
      
      public final void baS()
      {
        AppMethodBeat.i(174975);
        RP("onPkgZstdDownloadFailed");
        AppMethodBeat.o(174975);
      }
      
      final String brq()
      {
        AppMethodBeat.i(174970);
        String str = an.this.aWs();
        AppMethodBeat.o(174970);
        return str;
      }
      
      final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
      {
        AppMethodBeat.i(174971);
        an.this.f(paramAnonymousWxaPkgWrappingInfo);
        an.this.g(paramAnonymousWxaPkgWrappingInfo);
        AppMethodBeat.o(174971);
      }
    };
    ad.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "%s downloadPkg, patch_url(%s), full_url(%s)", new Object[] { aWs(), str2, str1 });
    boolean bool;
    if (!bt.isNullOrNil(str2))
    {
      bool = s.a(this.lJz.toString(), this.lJB, this.lHo, str2, (bi.a)localObject);
      brs();
    }
    for (;;)
    {
      if (!bool) {
        ad.e("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "%s start downloadPkg failed", new Object[] { aWs() });
      }
      AppMethodBeat.o(174977);
      return;
      if (!bt.isNullOrNil(str3))
      {
        bool = br.a(str3, this.lJz.toString(), this.lHo, this.dnt, (bi.a)localObject);
        brt();
      }
      else
      {
        bool = bi.b(this.lJz.toString(), this.dnt, this.lHo, str1, (bi.a)localObject);
        brt();
      }
    }
  }
  
  abstract class a
    extends al
    implements b.b, b.c
  {
    a(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.an
 * JD-Core Version:    0.7.0.1
 */
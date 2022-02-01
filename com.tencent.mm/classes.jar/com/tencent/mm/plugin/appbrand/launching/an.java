package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.c;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Locale;

public final class an
  extends am
{
  int dov;
  int duK;
  cvv lLM;
  int lLO;
  String lLP;
  ad lNZ;
  int lOb;
  String lOc;
  String lOd;
  String lOe;
  
  an(u paramu)
  {
    super(new ad(paramu.lLM.dwb, paramu.lLM.GXn, paramu.lLM.GXq));
    AppMethodBeat.i(174976);
    this.lLM = paramu.lLM;
    this.lLO = paramu.lLO;
    this.dov = this.lLM.Gdl;
    this.lOb = paramu.lLN;
    this.lOc = paramu.md5;
    this.lLP = paramu.lLP;
    this.lOd = paramu.lLR;
    this.lOe = paramu.lLQ;
    this.lNZ = new ad(paramu.lLM.dwb, paramu.lLM.GXn, paramu.lLM.GXq);
    AppMethodBeat.o(174976);
  }
  
  public final String aWU()
  {
    AppMethodBeat.i(174978);
    String str = String.format(Locale.US, "pkgQueryKey %s, targetVersion %d, codeType %d, pkgType %d", new Object[] { this.lNZ.toString(), Integer.valueOf(this.lLO), Integer.valueOf(this.dov), Integer.valueOf(this.duK) });
    AppMethodBeat.o(174978);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(174977);
    Object localObject = this.lOc;
    final String str1 = this.lLP;
    String str2 = this.lOd;
    String str3 = this.lOe;
    localObject = new a(this.dov, str1)
    {
      private void Sy(String paramAnonymousString)
      {
        AppMethodBeat.i(174973);
        long l = bu.HQ();
        eia localeia = new eia();
        localeia.IlD = str1;
        localeia.FYj = an.this.lLO;
        localeia.IlC = this.lOg;
        j.aZu().a(an.this.lNZ.toString(), localeia, 0);
        ae.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "downloadPkg, %s flush release url key[%s] cost[%d]", new Object[] { paramAnonymousString, an.this.lNZ.toString(), Long.valueOf(bu.aO(l)) });
        AppMethodBeat.o(174973);
      }
      
      protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
      {
        AppMethodBeat.i(174972);
        an.this.c(paramAnonymousWxaPkgLoadProgress);
        AppMethodBeat.o(174972);
      }
      
      public final void bbq()
      {
        AppMethodBeat.i(174974);
        Sy("onPkgIncrementalUpdateFailed");
        AppMethodBeat.o(174974);
      }
      
      public final void bbr()
      {
        AppMethodBeat.i(174975);
        Sy("onPkgZstdDownloadFailed");
        AppMethodBeat.o(174975);
      }
      
      final String bsb()
      {
        AppMethodBeat.i(174970);
        String str = an.this.aWU();
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
    ae.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "%s downloadPkg, patch_url(%s), full_url(%s)", new Object[] { aWU(), str2, str1 });
    boolean bool;
    if (!bu.isNullOrNil(str2))
    {
      bool = s.a(this.lNZ.toString(), this.lOb, this.lLO, str2, (bj.a)localObject);
      bsd();
    }
    for (;;)
    {
      if (!bool) {
        ae.e("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "%s start downloadPkg failed", new Object[] { aWU() });
      }
      AppMethodBeat.o(174977);
      return;
      if (!bu.isNullOrNil(str3))
      {
        bool = bt.a(str3, this.lNZ.toString(), this.lLO, this.dov, (bj.a)localObject);
        bse();
      }
      else
      {
        bool = bj.b(this.lNZ.toString(), this.dov, this.lLO, str1, (bj.a)localObject);
        bse();
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
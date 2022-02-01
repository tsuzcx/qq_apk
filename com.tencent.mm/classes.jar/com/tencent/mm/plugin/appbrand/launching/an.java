package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.c;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bh.a;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;

public final class an
  extends am
{
  int deB;
  int dkC;
  ckp kII;
  int kIK;
  String kIL;
  ab kKV;
  int kKX;
  String kKY;
  String kKZ;
  String kLa;
  
  an(u paramu)
  {
    super(new ab(paramu.kII.dlB, paramu.kII.DyR, paramu.kII.DyU));
    AppMethodBeat.i(174976);
    this.kII = paramu.kII;
    this.kIK = paramu.kIK;
    this.deB = this.kII.CLK;
    this.kKX = paramu.kIJ;
    this.kKY = paramu.md5;
    this.kIL = paramu.kIL;
    this.kKZ = paramu.kIN;
    this.kLa = paramu.kIM;
    this.kKV = new ab(paramu.kII.dlB, paramu.kII.DyR, paramu.kII.DyU);
    AppMethodBeat.o(174976);
  }
  
  public final String aMu()
  {
    AppMethodBeat.i(174978);
    String str = String.format(Locale.US, "pkgQueryKey %s, targetVersion %d, codeType %d, pkgType %d", new Object[] { this.kKV.toString(), Integer.valueOf(this.kIK), Integer.valueOf(this.deB), Integer.valueOf(this.dkC) });
    AppMethodBeat.o(174978);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(174977);
    Object localObject = this.kKY;
    final String str1 = this.kIL;
    String str2 = this.kKZ;
    String str3 = this.kLa;
    localObject = new a(this.deB, str1)
    {
      private void Kk(String paramAnonymousString)
      {
        AppMethodBeat.i(174973);
        long l = bt.GC();
        duo localduo = new duo();
        localduo.EIX = str1;
        localduo.CHC = an.this.kIK;
        localduo.EIW = this.kLc;
        j.aOK().a(an.this.kKV.toString(), localduo, 0);
        ad.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "downloadPkg, %s flush release url key[%s] cost[%d]", new Object[] { paramAnonymousString, an.this.kKV.toString(), Long.valueOf(bt.aS(l)) });
        AppMethodBeat.o(174973);
      }
      
      public final void aQB()
      {
        AppMethodBeat.i(174974);
        Kk("onPkgIncrementalUpdateFailed");
        AppMethodBeat.o(174974);
      }
      
      public final void aQC()
      {
        AppMethodBeat.i(174975);
        Kk("onPkgZstdDownloadFailed");
        AppMethodBeat.o(174975);
      }
      
      final String bgJ()
      {
        AppMethodBeat.i(174970);
        String str = an.this.aMu();
        AppMethodBeat.o(174970);
        return str;
      }
      
      protected final void c(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
      {
        AppMethodBeat.i(174972);
        an.this.d(paramAnonymousWxaPkgLoadProgress);
        AppMethodBeat.o(174972);
      }
      
      final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
      {
        AppMethodBeat.i(174971);
        an.this.f(paramAnonymousWxaPkgWrappingInfo);
        an.this.g(paramAnonymousWxaPkgWrappingInfo);
        AppMethodBeat.o(174971);
      }
    };
    ad.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "%s downloadPkg, patch_url(%s), full_url(%s)", new Object[] { aMu(), str2, str1 });
    boolean bool;
    if (!bt.isNullOrNil(str2))
    {
      bool = s.a(this.kKV.toString(), this.kKX, this.kIK, str2, (bh.a)localObject);
      bgL();
    }
    for (;;)
    {
      if (!bool) {
        ad.e("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "%s start downloadPkg failed", new Object[] { aMu() });
      }
      AppMethodBeat.o(174977);
      return;
      if (!bt.isNullOrNil(str3))
      {
        bool = bp.a(str3, this.kKV.toString(), this.kIK, this.deB, (bh.a)localObject);
        bgM();
      }
      else
      {
        bool = bh.b(this.kKV.toString(), this.deB, this.kIK, str1, (bh.a)localObject);
        bgM();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.an
 * JD-Core Version:    0.7.0.1
 */
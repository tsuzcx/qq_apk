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
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Locale;

public final class an
  extends am
{
  int dbX;
  int dib;
  cpw lke;
  int lkg;
  String lkh;
  ab lmr;
  int lmt;
  String lmu;
  String lmv;
  String lmw;
  
  an(u paramu)
  {
    super(new ab(paramu.lke.djj, paramu.lke.EUn, paramu.lke.EUq));
    AppMethodBeat.i(174976);
    this.lke = paramu.lke;
    this.lkg = paramu.lkg;
    this.dbX = this.lke.Een;
    this.lmt = paramu.lkf;
    this.lmu = paramu.md5;
    this.lkh = paramu.lkh;
    this.lmv = paramu.lkj;
    this.lmw = paramu.lki;
    this.lmr = new ab(paramu.lke.djj, paramu.lke.EUn, paramu.lke.EUq);
    AppMethodBeat.o(174976);
  }
  
  public final String aTk()
  {
    AppMethodBeat.i(174978);
    String str = String.format(Locale.US, "pkgQueryKey %s, targetVersion %d, codeType %d, pkgType %d", new Object[] { this.lmr.toString(), Integer.valueOf(this.lkg), Integer.valueOf(this.dbX), Integer.valueOf(this.dib) });
    AppMethodBeat.o(174978);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(174977);
    Object localObject = this.lmu;
    final String str1 = this.lkh;
    String str2 = this.lmv;
    String str3 = this.lmw;
    localObject = new a(this.dbX, str1)
    {
      private void Or(String paramAnonymousString)
      {
        AppMethodBeat.i(174973);
        long l = bs.Gn();
        eaf localeaf = new eaf();
        localeaf.Ggj = str1;
        localeaf.Eae = an.this.lkg;
        localeaf.Ggi = this.lmy;
        j.aVC().a(an.this.lmr.toString(), localeaf, 0);
        ac.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "downloadPkg, %s flush release url key[%s] cost[%d]", new Object[] { paramAnonymousString, an.this.lmr.toString(), Long.valueOf(bs.aO(l)) });
        AppMethodBeat.o(174973);
      }
      
      public final void aXt()
      {
        AppMethodBeat.i(174974);
        Or("onPkgIncrementalUpdateFailed");
        AppMethodBeat.o(174974);
      }
      
      public final void aXu()
      {
        AppMethodBeat.i(174975);
        Or("onPkgZstdDownloadFailed");
        AppMethodBeat.o(174975);
      }
      
      protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
      {
        AppMethodBeat.i(174972);
        an.this.c(paramAnonymousWxaPkgLoadProgress);
        AppMethodBeat.o(174972);
      }
      
      final String bnD()
      {
        AppMethodBeat.i(174970);
        String str = an.this.aTk();
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
    ac.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "%s downloadPkg, patch_url(%s), full_url(%s)", new Object[] { aTk(), str2, str1 });
    boolean bool;
    if (!bs.isNullOrNil(str2))
    {
      bool = s.a(this.lmr.toString(), this.lmt, this.lkg, str2, (bh.a)localObject);
      bnF();
    }
    for (;;)
    {
      if (!bool) {
        ac.e("MicroMsg.LaunchPkgPrepareJobMultiPkgNewReleaseCode", "%s start downloadPkg failed", new Object[] { aTk() });
      }
      AppMethodBeat.o(174977);
      return;
      if (!bs.isNullOrNil(str3))
      {
        bool = bp.a(str3, this.lmr.toString(), this.lkg, this.dbX, (bh.a)localObject);
        bnG();
      }
      else
      {
        bool = bh.b(this.lmr.toString(), this.dbX, this.lkg, str1, (bh.a)localObject);
        bnG();
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
package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;

public final class ao
  extends am
{
  final String appId;
  final String chK;
  final int deB;
  int dkC;
  String dzL;
  String kLe;
  
  ao(u paramu)
  {
    super(new ab(paramu.kII.dlB, paramu.kII.DyR, paramu.kII.DyU));
    AppMethodBeat.i(174984);
    this.dzL = paramu.kIL;
    this.appId = paramu.kII.dlB;
    this.chK = paramu.kII.DyR;
    this.deB = paramu.kII.CLK;
    this.dkC = paramu.kII.DyU;
    this.kLe = new ab(this.appId, this.chK, this.dkC).toString();
    AppMethodBeat.o(174984);
  }
  
  public final String aMu()
  {
    AppMethodBeat.i(174986);
    String str = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[] { this.appId, this.chK, Integer.valueOf(this.deB), Integer.valueOf(this.dkC), this.kKV });
    AppMethodBeat.o(174986);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(174985);
    al local1 = new al(this.deB)
    {
      final String bgJ()
      {
        AppMethodBeat.i(174980);
        String str = ao.this.aMu();
        AppMethodBeat.o(174980);
        return str;
      }
      
      protected final void c(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
      {
        AppMethodBeat.i(174982);
        super.c(paramAnonymousWxaPkgLoadProgress);
        ao.this.d(paramAnonymousWxaPkgLoadProgress);
        AppMethodBeat.o(174982);
      }
      
      final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
      {
        AppMethodBeat.i(174981);
        ao.this.f(paramAnonymousWxaPkgWrappingInfo);
        ao.this.g(paramAnonymousWxaPkgWrappingInfo);
        AppMethodBeat.o(174981);
      }
    };
    ad.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewTestCode", "%s before download, url(%s)", new Object[] { aMu(), this.dzL });
    if (bt.isNullOrNil(this.dzL))
    {
      f(null);
      AppMethodBeat.o(174985);
      return;
    }
    if (!bh.a(this.kKV.toString(), this.deB, this.dzL, local1, new a.a()
    {
      public final String aPJ()
      {
        AppMethodBeat.i(174983);
        Object localObject = j.aOK().a(ao.this.kKV.toString(), ao.this.deB, new String[] { "versionMd5" });
        localObject = "_" + ((bb)localObject).field_versionMd5;
        AppMethodBeat.o(174983);
        return localObject;
      }
    }))
    {
      ad.e("MicroMsg.LaunchPkgPrepareJobMultiPkgNewTestCode", "%s start downloadPkg failed", new Object[] { aMu() });
      f(null);
      AppMethodBeat.o(174985);
      return;
    }
    bgM();
    AppMethodBeat.o(174985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ao
 * JD-Core Version:    0.7.0.1
 */
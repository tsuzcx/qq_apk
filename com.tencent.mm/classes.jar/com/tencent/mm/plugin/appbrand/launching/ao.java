package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Locale;

public final class ao
  extends am
{
  final String appId;
  final String coY;
  String dKY;
  final int dov;
  int duK;
  String lOi;
  
  ao(u paramu)
  {
    super(new ad(paramu.lLM.dwb, paramu.lLM.GXn, paramu.lLM.GXq));
    AppMethodBeat.i(174984);
    this.dKY = paramu.lLP;
    this.appId = paramu.lLM.dwb;
    this.coY = paramu.lLM.GXn;
    this.dov = paramu.lLM.Gdl;
    this.duK = paramu.lLM.GXq;
    this.lOi = new ad(this.appId, this.coY, this.duK).toString();
    AppMethodBeat.o(174984);
  }
  
  public final String aWU()
  {
    AppMethodBeat.i(174986);
    String str = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[] { this.appId, this.coY, Integer.valueOf(this.dov), Integer.valueOf(this.duK), this.lNZ });
    AppMethodBeat.o(174986);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(174985);
    al local1 = new al(this.dov)
    {
      protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
      {
        AppMethodBeat.i(174982);
        super.b(paramAnonymousWxaPkgLoadProgress);
        ao.this.c(paramAnonymousWxaPkgLoadProgress);
        AppMethodBeat.o(174982);
      }
      
      final String bsb()
      {
        AppMethodBeat.i(174980);
        String str = ao.this.aWU();
        AppMethodBeat.o(174980);
        return str;
      }
      
      final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
      {
        AppMethodBeat.i(174981);
        ao.this.f(paramAnonymousWxaPkgWrappingInfo);
        ao.this.g(paramAnonymousWxaPkgWrappingInfo);
        AppMethodBeat.o(174981);
      }
    };
    ae.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewTestCode", "%s before download, url(%s)", new Object[] { aWU(), this.dKY });
    if (bu.isNullOrNil(this.dKY))
    {
      f(null);
      AppMethodBeat.o(174985);
      return;
    }
    if (!bj.a(this.lNZ.toString(), this.dov, this.dKY, local1, new a.a()
    {
      public final String bav()
      {
        AppMethodBeat.i(174983);
        Object localObject = j.aZu().a(ao.this.lNZ.toString(), ao.this.dov, new String[] { "versionMd5" });
        localObject = "_" + ((bd)localObject).field_versionMd5;
        AppMethodBeat.o(174983);
        return localObject;
      }
    }))
    {
      ae.e("MicroMsg.LaunchPkgPrepareJobMultiPkgNewTestCode", "%s start downloadPkg failed", new Object[] { aWU() });
      f(null);
      AppMethodBeat.o(174985);
      return;
    }
    bse();
    AppMethodBeat.o(174985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ao
 * JD-Core Version:    0.7.0.1
 */
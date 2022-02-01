package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;

public final class ao
  extends am
{
  final String appId;
  final String coW;
  String dJJ;
  final int dnt;
  int dtF;
  String lJI;
  
  ao(u paramu)
  {
    super(new ac(paramu.lHm.duW, paramu.lHm.GDK, paramu.lHm.GDN));
    AppMethodBeat.i(174984);
    this.dJJ = paramu.lHp;
    this.appId = paramu.lHm.duW;
    this.coW = paramu.lHm.GDK;
    this.dnt = paramu.lHm.FKM;
    this.dtF = paramu.lHm.GDN;
    this.lJI = new ac(this.appId, this.coW, this.dtF).toString();
    AppMethodBeat.o(174984);
  }
  
  public final String aWs()
  {
    AppMethodBeat.i(174986);
    String str = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[] { this.appId, this.coW, Integer.valueOf(this.dnt), Integer.valueOf(this.dtF), this.lJz });
    AppMethodBeat.o(174986);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(174985);
    al local1 = new al(this.dnt)
    {
      protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
      {
        AppMethodBeat.i(174982);
        super.b(paramAnonymousWxaPkgLoadProgress);
        ao.this.c(paramAnonymousWxaPkgLoadProgress);
        AppMethodBeat.o(174982);
      }
      
      final String brq()
      {
        AppMethodBeat.i(174980);
        String str = ao.this.aWs();
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
    ad.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewTestCode", "%s before download, url(%s)", new Object[] { aWs(), this.dJJ });
    if (bt.isNullOrNil(this.dJJ))
    {
      f(null);
      AppMethodBeat.o(174985);
      return;
    }
    if (!bi.a(this.lJz.toString(), this.dnt, this.dJJ, local1, new a.a()
    {
      public final String aZW()
      {
        AppMethodBeat.i(174983);
        Object localObject = j.aYX().a(ao.this.lJz.toString(), ao.this.dnt, new String[] { "versionMd5" });
        localObject = "_" + ((bc)localObject).field_versionMd5;
        AppMethodBeat.o(174983);
        return localObject;
      }
    }))
    {
      ad.e("MicroMsg.LaunchPkgPrepareJobMultiPkgNewTestCode", "%s start downloadPkg failed", new Object[] { aWs() });
      f(null);
      AppMethodBeat.o(174985);
      return;
    }
    brt();
    AppMethodBeat.o(174985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ao
 * JD-Core Version:    0.7.0.1
 */
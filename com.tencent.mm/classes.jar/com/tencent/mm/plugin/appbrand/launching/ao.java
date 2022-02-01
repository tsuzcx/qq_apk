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
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Locale;

public final class ao
  extends am
{
  final String appId;
  final String ceF;
  final int dbX;
  int dib;
  String dxx;
  String lmA;
  
  ao(u paramu)
  {
    super(new ab(paramu.lke.djj, paramu.lke.EUn, paramu.lke.EUq));
    AppMethodBeat.i(174984);
    this.dxx = paramu.lkh;
    this.appId = paramu.lke.djj;
    this.ceF = paramu.lke.EUn;
    this.dbX = paramu.lke.Een;
    this.dib = paramu.lke.EUq;
    this.lmA = new ab(this.appId, this.ceF, this.dib).toString();
    AppMethodBeat.o(174984);
  }
  
  public final String aTk()
  {
    AppMethodBeat.i(174986);
    String str = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", new Object[] { this.appId, this.ceF, Integer.valueOf(this.dbX), Integer.valueOf(this.dib), this.lmr });
    AppMethodBeat.o(174986);
    return str;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(174985);
    al local1 = new al(this.dbX)
    {
      protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
      {
        AppMethodBeat.i(174982);
        super.b(paramAnonymousWxaPkgLoadProgress);
        ao.this.c(paramAnonymousWxaPkgLoadProgress);
        AppMethodBeat.o(174982);
      }
      
      final String bnD()
      {
        AppMethodBeat.i(174980);
        String str = ao.this.aTk();
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
    ac.i("MicroMsg.LaunchPkgPrepareJobMultiPkgNewTestCode", "%s before download, url(%s)", new Object[] { aTk(), this.dxx });
    if (bs.isNullOrNil(this.dxx))
    {
      f(null);
      AppMethodBeat.o(174985);
      return;
    }
    if (!bh.a(this.lmr.toString(), this.dbX, this.dxx, local1, new a.a()
    {
      public final String aWB()
      {
        AppMethodBeat.i(174983);
        Object localObject = j.aVC().a(ao.this.lmr.toString(), ao.this.dbX, new String[] { "versionMd5" });
        localObject = "_" + ((bb)localObject).field_versionMd5;
        AppMethodBeat.o(174983);
        return localObject;
      }
    }))
    {
      ac.e("MicroMsg.LaunchPkgPrepareJobMultiPkgNewTestCode", "%s start downloadPkg failed", new Object[] { aTk() });
      f(null);
      AppMethodBeat.o(174985);
      return;
    }
    bnG();
    AppMethodBeat.o(174985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ao
 * JD-Core Version:    0.7.0.1
 */
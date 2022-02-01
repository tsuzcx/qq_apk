package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.y;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.aa.b;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f.a;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

abstract class be
  extends bb<WxaPkgWrappingInfo>
  implements x
{
  final String appId;
  final int enterScene;
  final int gXn;
  final WxaAttributes.WxaVersionInfo jfa;
  final String kGa;
  private boolean kJV = false;
  private WxaPkgWrappingInfo kMn;
  private final int pkgVersion;
  
  be(String paramString1, int paramInt1, int paramInt2, int paramInt3, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, String paramString2)
  {
    this.appId = paramString1;
    this.gXn = paramInt1;
    this.pkgVersion = paramInt2;
    this.enterScene = paramInt3;
    this.jfa = paramWxaVersionInfo;
    this.kGa = paramString2;
  }
  
  static bxr a(bdp parambdp, com.tencent.luggage.sdk.e.b paramb)
  {
    int i = parambdp.DAL;
    boolean bool;
    Object localObject1;
    com.tencent.mm.al.c.a locala;
    label74:
    Iterator localIterator;
    Object localObject4;
    Object localObject3;
    if (paramb == null)
    {
      bool = true;
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: localOldPkgVersion = %d, parallelCgiLogic is null? = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (paramb == null) {
        break label392;
      }
      localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.kNZ;
      paramb = com.tencent.mm.plugin.appbrand.launching.d.c.a.b(paramb);
      if (paramb == null) {
        break label382;
      }
      locala = paramb.sT(100);
      if (locala != null) {
        break label230;
      }
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack is null");
      if ((locala == null) || (locala.gUK == null) || (locala.errType != 0) || (locala.errCode != 0)) {
        break label373;
      }
      localIterator = ((cbr)locala.gUK).DXV.iterator();
      localObject4 = null;
      paramb = null;
      localObject3 = null;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label312;
      }
      localObject1 = (bxr)localIterator.next();
      if (bt.isNullOrNil(parambdp.DyR)) {
        parambdp.DyR = "";
      }
      if (bt.isNullOrNil(((bxr)localObject1).DyR)) {
        ((bxr)localObject1).DyR = "";
      }
      if ((((bxr)localObject1).DyU == parambdp.DyU) && (parambdp.DyR.equals(((bxr)localObject1).DyR)))
      {
        if (((bxr)localObject1).Dto)
        {
          localObject3 = localObject1;
          continue;
          bool = false;
          break;
          label230:
          if (locala.gUK == null)
          {
            ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack.resp is null");
            break label74;
          }
          ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: (%d,%d)", new Object[] { Integer.valueOf(locala.errType), Integer.valueOf(locala.errCode) });
          break label74;
        }
        localObject2 = localObject1;
        if (!((bxr)localObject1).Dtn) {
          break label306;
        }
        localObject4 = localObject1;
        continue;
      }
      Object localObject2 = paramb;
      label306:
      paramb = (com.tencent.luggage.sdk.e.b)localObject2;
    }
    label312:
    ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: patchUrl = [%s], zstdUrl = [%s], url = [%s]", new Object[] { localObject4, localObject3, paramb });
    if (((cbr)locala.gUK).version == parambdp.CLL)
    {
      if (localObject4 != null) {
        return localObject4;
      }
      if (localObject3 != null) {
        return localObject3;
      }
      return paramb;
      label373:
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: check cgiBack fail");
    }
    for (;;)
    {
      return null;
      label382:
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preFetchGetDownloadInfoTask isnull");
      continue;
      label392:
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: parallelCgiLogic is null");
    }
  }
  
  private void bgS()
  {
    if (!this.kJV)
    {
      bgi();
      this.kJV = true;
    }
  }
  
  private WxaPkgWrappingInfo c(Callable<WxaPkgWrappingInfo> paramCallable)
  {
    if (paramCallable == this)
    {
      Assert.assertTrue("Why the hell you pass 'this' to this method", false);
      return null;
    }
    bgS();
    try
    {
      paramCallable = (WxaPkgWrappingInfo)paramCallable.call();
      bgq();
      return paramCallable;
    }
    catch (Exception paramCallable)
    {
      for (;;)
      {
        paramCallable = null;
      }
    }
  }
  
  private static void sQ(int paramInt)
  {
    if (paramInt > 0)
    {
      long l = bt.eGO();
      aa.b localb = aa.mQ(paramInt);
      ad.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bt.eGO() - l), localb.name() });
    }
  }
  
  final void a(WxaPkgIntegrityChecker.a parama)
  {
    int i = 2131755505;
    if (WxaPkgIntegrityChecker.a.iOh.equals(parama))
    {
      if (this.gXn == 1) {}
      for (parama = com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755505, new Object[0]);; parama = com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755583, new Object[] { com.tencent.mm.plugin.appbrand.appcache.e.qC(this.gXn) }))
      {
        if (this.gXn == 1)
        {
          com.tencent.mm.plugin.appbrand.task.f.bQ(this.appId, this.gXn);
          com.tencent.mm.plugin.appbrand.report.h.R(this.appId, 10, this.gXn + 1);
        }
        Kj(parama);
        return;
      }
    }
    if ((WxaPkgIntegrityChecker.a.iOj.equals(parama)) || (WxaPkgIntegrityChecker.a.iOi.equals(parama)))
    {
      if (this.gXn != 0) {}
      for (;;)
      {
        sP(i);
        if (this.gXn == 1) {
          com.tencent.mm.plugin.appbrand.report.h.R(this.appId, 10, this.gXn + 1);
        }
        com.tencent.mm.plugin.appbrand.task.f.bQ(this.appId, this.gXn);
        return;
        i = 2131755508;
      }
    }
    Kj(com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755580, new Object[] { Integer.valueOf(1), Integer.valueOf(parama.aQs()) }));
  }
  
  public WxaPkgWrappingInfo aVF()
  {
    Object localObject1 = WxaPkgIntegrityChecker.C(this.appId, this.gXn, this.pkgVersion);
    if (((Pair)localObject1).second != null)
    {
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.gXn), Integer.valueOf(this.pkgVersion) });
      ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).q(this.kGa, this.appId, this.pkgVersion);
      localObject1 = (WxaPkgWrappingInfo)((Pair)localObject1).second;
      return localObject1;
    }
    Object localObject3;
    Object localObject2;
    if (j.a.qD(this.gXn))
    {
      localObject3 = ((com.tencent.mm.plugin.appbrand.appcache.al)j.T(com.tencent.mm.plugin.appbrand.appcache.al.class)).z(this.appId, 1, this.pkgVersion);
      if (localObject3 != null)
      {
        localObject2 = new PLong();
        boolean bool = com.tencent.mm.plugin.appbrand.appcache.b.b.f.a((ak)localObject3, f.a.iQh, (PLong)localObject2);
        ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "decrypt ret %b, with appId(%s) version(%d)", new Object[] { Boolean.valueOf(bool), this.appId, Integer.valueOf(this.pkgVersion) });
        if (bool)
        {
          localObject1 = WxaPkgIntegrityChecker.C(this.appId, this.gXn, this.pkgVersion);
          if (((Pair)localObject1).second != null)
          {
            localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(((PLong)localObject2).value, 180L);
            return (WxaPkgWrappingInfo)((Pair)localObject1).second;
          }
          localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iQw;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.D(((PLong)localObject2).value, 181L);
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject2 = localObject1;
        if (WxaPkgIntegrityChecker.a.iOh.equals(((Pair)localObject1).first))
        {
          ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, manifest NULL, appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.gXn), Integer.valueOf(this.pkgVersion) });
          if (this.jfa.aAS > 0)
          {
            j.aOK().a(this.appId, this.jfa);
            if (j.aOK().a(this.appId, this.pkgVersion, this.gXn, new String[0]) == null)
            {
              ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, insert manifest fail again!!! appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.gXn), Integer.valueOf(this.pkgVersion) });
              a(WxaPkgIntegrityChecker.a.iOh);
              return null;
            }
            localObject2 = Pair.create(WxaPkgIntegrityChecker.a.iOk, null);
          }
        }
        else
        {
          if (!WxaPkgIntegrityChecker.a.iOk.equals(((Pair)localObject2).first)) {
            break label1332;
          }
          if (this.gXn != 0) {
            break label1307;
          }
          this.kMn = m.bD(this.appId, 1);
          try
          {
            localObject3 = new android.arch.a.c.a() {};
            localObject2 = (com.tencent.mm.plugin.appbrand.appcache.bb)((android.arch.a.c.a)localObject3).apply(null);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label692;
            }
            ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken, first query get NULL with appId[%s], retry", new Object[] { this.appId });
            j.aOK().a(this.appId, this.jfa);
            localObject2 = (com.tencent.mm.plugin.appbrand.appcache.bb)((android.arch.a.c.a)localObject3).apply(null);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label692;
            }
            throw new x.a.a().n(com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755583, new Object[] { com.tencent.mm.plugin.appbrand.appcache.e.qC(this.gXn) }), new Object[0]).o("get NULL record with md5", new Object[0]).bgA();
          }
          catch (x.a locala)
          {
            ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s, toast %s", new Object[] { this.appId, locala.getMessage(), locala.kJe });
            if (this.pkgVersion <= 0)
            {
              localObject2 = m.bD(this.appId, 1);
              localObject1 = localObject2;
              if (localObject2 != null) {
                break;
              }
            }
            if (!bt.isNullOrNil(locala.kJe)) {
              Kj(locala.kJe);
            }
            return null;
          }
        }
      }
      a(WxaPkgIntegrityChecker.a.iOh);
      return null;
      label692:
      bgS();
      long l1 = bt.eGO();
      int j = ((com.tencent.mm.plugin.appbrand.appcache.bb)localObject1).field_version;
      int i;
      label716:
      bdp localbdp;
      bxr localbxr;
      label778:
      Object localObject4;
      if (this.kMn == null)
      {
        i = 0;
        localbdp = com.tencent.mm.plugin.appbrand.appcache.h.a(this.appId, ((com.tencent.mm.plugin.appbrand.appcache.bb)localObject1).field_version, ((com.tencent.mm.plugin.appbrand.appcache.bb)localObject1).field_versionMd5, 0, i);
        localObject1 = com.tencent.luggage.sdk.e.c.ciu;
        localObject1 = com.tencent.luggage.sdk.e.c.cx(this.kGa);
        if (localObject1 != null)
        {
          localbxr = a(localbdp, (com.tencent.luggage.sdk.e.b)localObject1);
          if (localbxr != null) {
            break label899;
          }
          ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: hit parallel cgi but useless");
        }
        localObject2 = y.a(new com.tencent.mm.plugin.appbrand.appcache.h(localbdp));
        if ((localObject2 != null) && (((com.tencent.mm.al.c.a)localObject2).errType == 0) && (((com.tencent.mm.al.c.a)localObject2).errCode == 0)) {
          break label1131;
        }
        if ((localObject2 == null) || (((com.tencent.mm.al.c.a)localObject2).errCode != -1001)) {
          break label1030;
        }
        localObject1 = bc.getMMString(2131755579, new Object[0]);
        localObject4 = new x.a.a();
        if (localObject2 != null) {
          break label1091;
        }
      }
      label899:
      label1030:
      label1037:
      label1082:
      label1091:
      for (localObject2 = null;; localObject2 = String.format(Locale.US, "(%d, %d)", new Object[] { Integer.valueOf(((com.tencent.mm.al.c.a)localObject2).errType), Integer.valueOf(((com.tencent.mm.al.c.a)localObject2).errCode) }))
      {
        throw ((x.a.a)localObject4).o("fail get download url, resp %s", new Object[] { localObject2 }).n((String)localObject1, new Object[0]).bgA();
        i = this.kMn.pkgVersion;
        break label716;
        sQ(this.jfa.jfC);
        localObject1 = "";
        localObject2 = "";
        localObject4 = "";
        if (localbxr.Dtn) {
          localObject1 = localbxr.url;
        }
        for (;;)
        {
          localObject2 = c(new c(i, j, localbdp, (String)localObject1, (String)localObject2, (String)localObject4, (byte)0));
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (localbxr.md5.equals(((WxaPkgWrappingInfo)localObject2).md5)) {
              break;
            }
          }
          com.tencent.mm.plugin.appbrand.launching.d.b.lI(18);
          ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: fullback to nonParallelCgi");
          break label778;
          if (localbxr.Dto) {
            localObject2 = localbxr.url;
          } else {
            localObject4 = localbxr.url;
          }
        }
        if (localObject2 == null)
        {
          i = -1;
          if (localObject2 != null) {
            break label1082;
          }
        }
        for (j = -1;; j = ((com.tencent.mm.al.c.a)localObject2).errCode)
        {
          localObject1 = bc.getMMString(2131755577, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          break;
          i = ((com.tencent.mm.al.c.a)localObject2).errType;
          break label1037;
        }
      }
      label1131:
      long l2 = bt.eGO();
      as.a(as.b.kLC, this.appId, j, this.gXn, this.enterScene, l2 - l1);
      if (bt.isNullOrNil(((bdq)((com.tencent.mm.al.c.a)localObject2).gUK).url)) {
        throw new x.a.a().o("CgiGetDownloadURL return EMPTY url, ret = %d", new Object[] { Integer.valueOf(((bdq)((com.tencent.mm.al.c.a)localObject2).gUK).ret) }).bgA();
      }
      sQ(this.jfa.jfC);
      localObject2 = c(new c(i, j, localbdp, ((bdq)((com.tencent.mm.al.c.a)localObject2).gUK).dnK, ((bdq)((com.tencent.mm.al.c.a)localObject2).gUK).DAU, ((bdq)((com.tencent.mm.al.c.a)localObject2).gUK).url, (byte)0));
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      throw new x.a.a().o("Download Fail", new Object[0]).bgA();
      label1307:
      localObject1 = c(new a(0, null, (byte)0));
      if (localObject1 != null) {
        return localObject1;
      }
      label1332:
      a((WxaPkgIntegrityChecker.a)((Pair)localObject2).first);
      return null;
    }
  }
  
  public void bgi() {}
  
  public void bgq() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
  }
  
  final class a
    implements Callable<WxaPkgWrappingInfo>
  {
    private final String jnm;
    private final int kMp;
    
    private a(int paramInt, String paramString)
    {
      this.kMp = paramInt;
      this.jnm = paramString;
    }
    
    public final WxaPkgWrappingInfo aVF()
    {
      AppMethodBeat.i(47324);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      al local1 = new al(be.this.gXn)
      {
        final String bgJ()
        {
          AppMethodBeat.i(47320);
          String str = String.format(Locale.US, "NonIncremental %d", new Object[] { Integer.valueOf(be.a.a(be.a.this)) });
          AppMethodBeat.o(47320);
          return str;
        }
        
        protected final void c(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
        {
          AppMethodBeat.i(47322);
          ad.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "hy: onPkgUpdateProgress %s", new Object[] { paramAnonymousWxaPkgLoadProgress.toString() });
          if (paramAnonymousWxaPkgLoadProgress.progress >= 100)
          {
            AppMethodBeat.o(47322);
            return;
          }
          be.this.onDownloadProgress(paramAnonymousWxaPkgLoadProgress.progress);
          AppMethodBeat.o(47322);
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47321);
          this.jno.value = paramAnonymousWxaPkgWrappingInfo;
          localCountDownLatch.countDown();
          AppMethodBeat.o(47321);
        }
      };
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", new Object[] { be.this.appId, Integer.valueOf(be.this.gXn), Integer.valueOf(this.kMp) });
      if (j.a.nz(be.this.gXn))
      {
        final com.tencent.mm.plugin.appbrand.appcache.bb localbb = j.aOK().a(be.this.appId, be.this.gXn, new String[] { "versionMd5", "downloadURL" });
        if ((localbb == null) || (bt.isNullOrNil(localbb.field_downloadURL)))
        {
          ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d), record(%s)", new Object[] { be.this.appId, Integer.valueOf(be.this.gXn), localbb });
          be.this.a(WxaPkgIntegrityChecker.a.iOh);
          AppMethodBeat.o(47324);
          return null;
        }
        if (!bh.a(be.this.appId, be.this.gXn, localbb.field_downloadURL, local1, new a.a()
        {
          public final String aPJ()
          {
            AppMethodBeat.i(47323);
            String str = "_" + localbb.field_versionMd5;
            AppMethodBeat.o(47323);
            return str;
          }
        }))
        {
          ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { be.this.appId, Integer.valueOf(be.this.gXn), Integer.valueOf(this.kMp) });
          be.this.a(WxaPkgIntegrityChecker.a.iOl);
          AppMethodBeat.o(47324);
          return null;
        }
      }
      else if (!bh.a(be.this.appId, be.this.gXn, this.kMp, be.this.jfa.jfC, this.jnm, local1))
      {
        ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { be.this.appId, Integer.valueOf(be.this.gXn), Integer.valueOf(this.kMp) });
        be.this.a(WxaPkgIntegrityChecker.a.iOl);
        AppMethodBeat.o(47324);
        return null;
      }
      try
      {
        localCountDownLatch.await();
        localObject = (WxaPkgWrappingInfo)((i)localObject).value;
        AppMethodBeat.o(47324);
        return localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localException, "downloadNonIncremental semaphore exp ", new Object[0]);
        }
      }
    }
  }
  
  final class b
    implements Callable<WxaPkgWrappingInfo>
  {
    private final int kMp;
    private final String url;
    
    private b(int paramInt, String paramString)
    {
      this.kMp = paramInt;
      this.url = paramString;
    }
    
    final WxaPkgWrappingInfo bgT()
    {
      AppMethodBeat.i(47327);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      al local1 = new al(be.this.gXn)
      {
        final String bgJ()
        {
          return "Zstd";
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47326);
          this.jno.value = paramAnonymousWxaPkgWrappingInfo;
          localCountDownLatch.countDown();
          AppMethodBeat.o(47326);
        }
      };
      if (!bp.a(this.url, be.this.appId, this.kMp, 0, local1))
      {
        AppMethodBeat.o(47327);
        return null;
      }
      try
      {
        localCountDownLatch.await();
        localObject = (WxaPkgWrappingInfo)((i)localObject).value;
        AppMethodBeat.o(47327);
        return localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localInterruptedException, "doZstdJob semaphore exp ", new Object[0]);
        }
      }
    }
  }
  
  final class c
    implements Callable<WxaPkgWrappingInfo>
  {
    String kKZ;
    String kLa;
    private final int kMs;
    private final int kMt;
    private final bdp kMu;
    String url;
    
    private c(int paramInt1, int paramInt2, bdp parambdp, String paramString1, String paramString2, String paramString3)
    {
      this.kMs = paramInt1;
      this.kMt = paramInt2;
      this.kMu = parambdp;
      this.kKZ = paramString1;
      this.kLa = paramString2;
      this.url = paramString3;
    }
    
    private WxaPkgWrappingInfo bgU()
    {
      AppMethodBeat.i(47332);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      a locala = new a(be.this.gXn, (i)localObject, localCountDownLatch);
      if (!s.a(be.this.appId, this.kMs, this.kMt, this.kKZ, locala))
      {
        AppMethodBeat.o(47332);
        return null;
      }
      try
      {
        localCountDownLatch.await();
        localObject = (WxaPkgWrappingInfo)((i)localObject).value;
        AppMethodBeat.o(47332);
        return localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localInterruptedException, "downloadIncremental semaphore exp ", new Object[0]);
        }
      }
    }
    
    final class a
      extends al
      implements b.b
    {
      a()
      {
        super();
      }
      
      public final void aQB()
      {
        AppMethodBeat.i(47331);
        long l = bt.GC();
        duo localduo = new duo();
        localduo.EIX = be.c.this.url;
        localduo.CHC = be.c.c(be.c.this).CLL;
        localduo.EIW = be.c.c(be.c.this).kKY;
        j.aOK().a(be.this.appId, localduo, 0);
        ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "doIncrementalJob, onPkgIncrementalUpdateFailed flush release url appId[%s] cost[%d]", new Object[] { be.this.appId, Long.valueOf(bt.aS(l)) });
        AppMethodBeat.o(47331);
      }
      
      final String bgJ()
      {
        AppMethodBeat.i(47329);
        String str = String.format(Locale.US, "Incremental %d|%d", new Object[] { Integer.valueOf(be.c.a(be.c.this)), Integer.valueOf(be.c.b(be.c.this)) });
        AppMethodBeat.o(47329);
        return str;
      }
      
      final void e(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
      {
        AppMethodBeat.i(47330);
        this.jno.value = paramWxaPkgWrappingInfo;
        localCountDownLatch.countDown();
        AppMethodBeat.o(47330);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.be
 * JD-Core Version:    0.7.0.1
 */
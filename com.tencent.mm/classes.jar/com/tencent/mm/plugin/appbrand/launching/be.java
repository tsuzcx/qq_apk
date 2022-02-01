package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.y;
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
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  final int hxM;
  final WxaAttributes.WxaVersionInfo jFp;
  final String lht;
  private boolean llr = false;
  private WxaPkgWrappingInfo lnK;
  private final int pkgVersion;
  
  be(String paramString1, int paramInt1, int paramInt2, int paramInt3, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, String paramString2)
  {
    this.appId = paramString1;
    this.hxM = paramInt1;
    this.pkgVersion = paramInt2;
    this.enterScene = paramInt3;
    this.jFp = paramWxaVersionInfo;
    this.lht = paramString2;
  }
  
  static ccm a(bhh parambhh, com.tencent.luggage.sdk.e.b paramb)
  {
    int i = parambhh.EWh;
    boolean bool;
    Object localObject1;
    com.tencent.mm.ak.c.a locala;
    label74:
    Iterator localIterator;
    Object localObject4;
    Object localObject3;
    if (paramb == null)
    {
      bool = true;
      ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: localOldPkgVersion = %d, parallelCgiLogic is null? = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (paramb == null) {
        break label392;
      }
      localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.lpy;
      paramb = com.tencent.mm.plugin.appbrand.launching.d.c.a.b(paramb);
      if (paramb == null) {
        break label382;
      }
      locala = paramb.tK(100);
      if (locala != null) {
        break label230;
      }
      ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack is null");
      if ((locala == null) || (locala.hvj == null) || (locala.errType != 0) || (locala.errCode != 0)) {
        break label373;
      }
      localIterator = ((cgt)locala.hvj).FuP.iterator();
      localObject4 = null;
      paramb = null;
      localObject3 = null;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label312;
      }
      localObject1 = (ccm)localIterator.next();
      if (bs.isNullOrNil(parambhh.EUn)) {
        parambhh.EUn = "";
      }
      if (bs.isNullOrNil(((ccm)localObject1).EUn)) {
        ((ccm)localObject1).EUn = "";
      }
      if ((((ccm)localObject1).EUq == parambhh.EUq) && (parambhh.EUn.equals(((ccm)localObject1).EUn)))
      {
        if (((ccm)localObject1).EOs)
        {
          localObject3 = localObject1;
          continue;
          bool = false;
          break;
          label230:
          if (locala.hvj == null)
          {
            ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack.resp is null");
            break label74;
          }
          ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: (%d,%d)", new Object[] { Integer.valueOf(locala.errType), Integer.valueOf(locala.errCode) });
          break label74;
        }
        localObject2 = localObject1;
        if (!((ccm)localObject1).EOr) {
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
    ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: patchUrl = [%s], zstdUrl = [%s], url = [%s]", new Object[] { localObject4, localObject3, paramb });
    if (((cgt)locala.hvj).version == parambhh.Eeo)
    {
      if (localObject4 != null) {
        return localObject4;
      }
      if (localObject3 != null) {
        return localObject3;
      }
      return paramb;
      label373:
      ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: check cgiBack fail");
    }
    for (;;)
    {
      return null;
      label382:
      ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preFetchGetDownloadInfoTask isnull");
      continue;
      label392:
      ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: parallelCgiLogic is null");
    }
  }
  
  private void bnM()
  {
    if (!this.llr)
    {
      bnc();
      this.llr = true;
    }
  }
  
  private WxaPkgWrappingInfo c(Callable<WxaPkgWrappingInfo> paramCallable)
  {
    if (paramCallable == this)
    {
      Assert.assertTrue("Why the hell you pass 'this' to this method", false);
      return null;
    }
    bnM();
    try
    {
      paramCallable = (WxaPkgWrappingInfo)paramCallable.call();
      bnk();
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
  
  private static void tH(int paramInt)
  {
    if (paramInt > 0)
    {
      long l = bs.eWj();
      aa.b localb = aa.qF(paramInt);
      ac.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bs.eWj() - l), localb.name() });
    }
  }
  
  final void a(WxaPkgIntegrityChecker.a parama)
  {
    int i = 2131755505;
    if (WxaPkgIntegrityChecker.a.joq.equals(parama))
    {
      if (this.hxM == 1) {}
      for (parama = com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755505, new Object[0]);; parama = com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755583, new Object[] { com.tencent.mm.plugin.appbrand.appcache.e.rp(this.hxM) }))
      {
        if (this.hxM == 1)
        {
          com.tencent.mm.plugin.appbrand.task.f.bV(this.appId, this.hxM);
          g.Q(this.appId, 10, this.hxM + 1);
        }
        Oq(parama);
        return;
      }
    }
    if ((WxaPkgIntegrityChecker.a.jos.equals(parama)) || (WxaPkgIntegrityChecker.a.jor.equals(parama)))
    {
      if (this.hxM != 0) {}
      for (;;)
      {
        tG(i);
        if (this.hxM == 1) {
          g.Q(this.appId, 10, this.hxM + 1);
        }
        com.tencent.mm.plugin.appbrand.task.f.bV(this.appId, this.hxM);
        return;
        i = 2131755508;
      }
    }
    Oq(com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755580, new Object[] { Integer.valueOf(1), Integer.valueOf(parama.aXk()) }));
  }
  
  public WxaPkgWrappingInfo bcD()
  {
    Object localObject1 = WxaPkgIntegrityChecker.B(this.appId, this.hxM, this.pkgVersion);
    if (((Pair)localObject1).second != null)
    {
      ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.hxM), Integer.valueOf(this.pkgVersion) });
      ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).r(this.lht, this.appId, this.pkgVersion);
      localObject1 = (WxaPkgWrappingInfo)((Pair)localObject1).second;
      return localObject1;
    }
    Object localObject3;
    Object localObject2;
    if (j.a.rq(this.hxM))
    {
      localObject3 = ((com.tencent.mm.plugin.appbrand.appcache.al)j.T(com.tencent.mm.plugin.appbrand.appcache.al.class)).y(this.appId, 1, this.pkgVersion);
      if (localObject3 != null)
      {
        localObject2 = new PLong();
        boolean bool = com.tencent.mm.plugin.appbrand.appcache.b.b.f.a((ak)localObject3, f.a.jqr, (PLong)localObject2);
        ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "decrypt ret %b, with appId(%s) version(%d)", new Object[] { Boolean.valueOf(bool), this.appId, Integer.valueOf(this.pkgVersion) });
        if (bool)
        {
          localObject1 = WxaPkgIntegrityChecker.B(this.appId, this.hxM, this.pkgVersion);
          if (((Pair)localObject1).second != null)
          {
            localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((PLong)localObject2).value, 180L);
            return (WxaPkgWrappingInfo)((Pair)localObject1).second;
          }
          localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((PLong)localObject2).value, 181L);
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject2 = localObject1;
        if (WxaPkgIntegrityChecker.a.joq.equals(((Pair)localObject1).first))
        {
          ac.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, manifest NULL, appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.hxM), Integer.valueOf(this.pkgVersion) });
          if (this.jFp.aBM > 0)
          {
            j.aVC().a(this.appId, this.jFp);
            if (j.aVC().a(this.appId, this.pkgVersion, this.hxM, new String[0]) == null)
            {
              ac.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, insert manifest fail again!!! appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.hxM), Integer.valueOf(this.pkgVersion) });
              a(WxaPkgIntegrityChecker.a.joq);
              return null;
            }
            localObject2 = Pair.create(WxaPkgIntegrityChecker.a.jot, null);
          }
        }
        else
        {
          if (!WxaPkgIntegrityChecker.a.jot.equals(((Pair)localObject2).first)) {
            break label1332;
          }
          if (this.hxM != 0) {
            break label1307;
          }
          this.lnK = m.bH(this.appId, 1);
          try
          {
            localObject3 = new android.arch.a.c.a() {};
            localObject2 = (com.tencent.mm.plugin.appbrand.appcache.bb)((android.arch.a.c.a)localObject3).apply(null);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label692;
            }
            ac.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken, first query get NULL with appId[%s], retry", new Object[] { this.appId });
            j.aVC().a(this.appId, this.jFp);
            localObject2 = (com.tencent.mm.plugin.appbrand.appcache.bb)((android.arch.a.c.a)localObject3).apply(null);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label692;
            }
            throw new x.a.a().n(com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755583, new Object[] { com.tencent.mm.plugin.appbrand.appcache.e.rp(this.hxM) }), new Object[0]).o("get NULL record with md5", new Object[0]).bnu();
          }
          catch (x.a locala)
          {
            ac.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s, toast %s", new Object[] { this.appId, locala.getMessage(), locala.lkA });
            if (this.pkgVersion <= 0)
            {
              localObject2 = m.bH(this.appId, 1);
              localObject1 = localObject2;
              if (localObject2 != null) {
                break;
              }
            }
            if (!bs.isNullOrNil(locala.lkA)) {
              Oq(locala.lkA);
            }
            return null;
          }
        }
      }
      a(WxaPkgIntegrityChecker.a.joq);
      return null;
      label692:
      bnM();
      long l1 = bs.eWj();
      int j = ((com.tencent.mm.plugin.appbrand.appcache.bb)localObject1).field_version;
      int i;
      label716:
      bhh localbhh;
      ccm localccm;
      label778:
      Object localObject4;
      if (this.lnK == null)
      {
        i = 0;
        localbhh = h.a(this.appId, ((com.tencent.mm.plugin.appbrand.appcache.bb)localObject1).field_version, ((com.tencent.mm.plugin.appbrand.appcache.bb)localObject1).field_versionMd5, 0, i);
        localObject1 = com.tencent.luggage.sdk.e.c.cfq;
        localObject1 = com.tencent.luggage.sdk.e.c.cm(this.lht);
        if (localObject1 != null)
        {
          localccm = a(localbhh, (com.tencent.luggage.sdk.e.b)localObject1);
          if (localccm != null) {
            break label899;
          }
          ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: hit parallel cgi but useless");
        }
        localObject2 = y.a(new h(localbhh));
        if ((localObject2 != null) && (((com.tencent.mm.ak.c.a)localObject2).errType == 0) && (((com.tencent.mm.ak.c.a)localObject2).errCode == 0)) {
          break label1131;
        }
        if ((localObject2 == null) || (((com.tencent.mm.ak.c.a)localObject2).errCode != -1001)) {
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
      for (localObject2 = null;; localObject2 = String.format(Locale.US, "(%d, %d)", new Object[] { Integer.valueOf(((com.tencent.mm.ak.c.a)localObject2).errType), Integer.valueOf(((com.tencent.mm.ak.c.a)localObject2).errCode) }))
      {
        throw ((x.a.a)localObject4).o("fail get download url, resp %s", new Object[] { localObject2 }).n((String)localObject1, new Object[0]).bnu();
        i = this.lnK.pkgVersion;
        break label716;
        tH(this.jFp.jFR);
        localObject1 = "";
        localObject2 = "";
        localObject4 = "";
        if (localccm.EOr) {
          localObject1 = localccm.url;
        }
        for (;;)
        {
          localObject2 = c(new c(i, j, localbhh, (String)localObject1, (String)localObject2, (String)localObject4, (byte)0));
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (localccm.md5.equals(((WxaPkgWrappingInfo)localObject2).md5)) {
              break;
            }
          }
          com.tencent.mm.plugin.appbrand.launching.d.b.lA(18);
          ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: fullback to nonParallelCgi");
          break label778;
          if (localccm.EOs) {
            localObject2 = localccm.url;
          } else {
            localObject4 = localccm.url;
          }
        }
        if (localObject2 == null)
        {
          i = -1;
          if (localObject2 != null) {
            break label1082;
          }
        }
        for (j = -1;; j = ((com.tencent.mm.ak.c.a)localObject2).errCode)
        {
          localObject1 = bc.getMMString(2131755577, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          break;
          i = ((com.tencent.mm.ak.c.a)localObject2).errType;
          break label1037;
        }
      }
      label1131:
      long l2 = bs.eWj();
      as.a(as.b.lmY, this.appId, j, this.hxM, this.enterScene, l2 - l1);
      if (bs.isNullOrNil(((bhi)((com.tencent.mm.ak.c.a)localObject2).hvj).url)) {
        throw new x.a.a().o("CgiGetDownloadURL return EMPTY url, ret = %d", new Object[] { Integer.valueOf(((bhi)((com.tencent.mm.ak.c.a)localObject2).hvj).ret) }).bnu();
      }
      tH(this.jFp.jFR);
      localObject2 = c(new c(i, j, localbhh, ((bhi)((com.tencent.mm.ak.c.a)localObject2).hvj).dlt, ((bhi)((com.tencent.mm.ak.c.a)localObject2).hvj).EWq, ((bhi)((com.tencent.mm.ak.c.a)localObject2).hvj).url, (byte)0));
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      throw new x.a.a().o("Download Fail", new Object[0]).bnu();
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
  
  public void bnc() {}
  
  public void bnk() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
  }
  
  final class a
    implements Callable<WxaPkgWrappingInfo>
  {
    private final String jNy;
    private final int lnM;
    
    private a(int paramInt, String paramString)
    {
      this.lnM = paramInt;
      this.jNy = paramString;
    }
    
    public final WxaPkgWrappingInfo bcD()
    {
      AppMethodBeat.i(47324);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      al local1 = new al(be.this.hxM)
      {
        protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
        {
          AppMethodBeat.i(47322);
          ac.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "hy: onPkgUpdateProgress %s", new Object[] { paramAnonymousWxaPkgLoadProgress.toString() });
          if (paramAnonymousWxaPkgLoadProgress.progress >= 100)
          {
            AppMethodBeat.o(47322);
            return;
          }
          be.this.onDownloadProgress(paramAnonymousWxaPkgLoadProgress.progress);
          AppMethodBeat.o(47322);
        }
        
        final String bnD()
        {
          AppMethodBeat.i(47320);
          String str = String.format(Locale.US, "NonIncremental %d", new Object[] { Integer.valueOf(be.a.a(be.a.this)) });
          AppMethodBeat.o(47320);
          return str;
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47321);
          this.jNA.value = paramAnonymousWxaPkgWrappingInfo;
          localCountDownLatch.countDown();
          AppMethodBeat.o(47321);
        }
      };
      ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", new Object[] { be.this.appId, Integer.valueOf(be.this.hxM), Integer.valueOf(this.lnM) });
      if (j.a.on(be.this.hxM))
      {
        final com.tencent.mm.plugin.appbrand.appcache.bb localbb = j.aVC().a(be.this.appId, be.this.hxM, new String[] { "versionMd5", "downloadURL" });
        if ((localbb == null) || (bs.isNullOrNil(localbb.field_downloadURL)))
        {
          ac.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d), record(%s)", new Object[] { be.this.appId, Integer.valueOf(be.this.hxM), localbb });
          be.this.a(WxaPkgIntegrityChecker.a.joq);
          AppMethodBeat.o(47324);
          return null;
        }
        if (!bh.a(be.this.appId, be.this.hxM, localbb.field_downloadURL, local1, new a.a()
        {
          public final String aWB()
          {
            AppMethodBeat.i(47323);
            String str = "_" + localbb.field_versionMd5;
            AppMethodBeat.o(47323);
            return str;
          }
        }))
        {
          ac.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { be.this.appId, Integer.valueOf(be.this.hxM), Integer.valueOf(this.lnM) });
          be.this.a(WxaPkgIntegrityChecker.a.jou);
          AppMethodBeat.o(47324);
          return null;
        }
      }
      else if (!bh.a(be.this.appId, be.this.hxM, this.lnM, be.this.jFp.jFR, this.jNy, local1))
      {
        ac.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { be.this.appId, Integer.valueOf(be.this.hxM), Integer.valueOf(this.lnM) });
        be.this.a(WxaPkgIntegrityChecker.a.jou);
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
          ac.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localException, "downloadNonIncremental semaphore exp ", new Object[0]);
        }
      }
    }
  }
  
  final class b
    implements Callable<WxaPkgWrappingInfo>
  {
    private final int lnM;
    private final String url;
    
    private b(int paramInt, String paramString)
    {
      this.lnM = paramInt;
      this.url = paramString;
    }
    
    final WxaPkgWrappingInfo bnN()
    {
      AppMethodBeat.i(47327);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      al local1 = new al(be.this.hxM)
      {
        final String bnD()
        {
          return "Zstd";
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47326);
          this.jNA.value = paramAnonymousWxaPkgWrappingInfo;
          localCountDownLatch.countDown();
          AppMethodBeat.o(47326);
        }
      };
      if (!bp.a(this.url, be.this.appId, this.lnM, 0, local1))
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
          ac.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localInterruptedException, "doZstdJob semaphore exp ", new Object[0]);
        }
      }
    }
  }
  
  final class c
    implements Callable<WxaPkgWrappingInfo>
  {
    String lmv;
    String lmw;
    private final int lnP;
    private final int lnQ;
    private final bhh lnR;
    String url;
    
    private c(int paramInt1, int paramInt2, bhh parambhh, String paramString1, String paramString2, String paramString3)
    {
      this.lnP = paramInt1;
      this.lnQ = paramInt2;
      this.lnR = parambhh;
      this.lmv = paramString1;
      this.lmw = paramString2;
      this.url = paramString3;
    }
    
    private WxaPkgWrappingInfo bnO()
    {
      AppMethodBeat.i(47332);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      a locala = new a(be.this.hxM, (i)localObject, localCountDownLatch);
      if (!s.a(be.this.appId, this.lnP, this.lnQ, this.lmv, locala))
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
          ac.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localInterruptedException, "downloadIncremental semaphore exp ", new Object[0]);
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
      
      public final void aXt()
      {
        AppMethodBeat.i(47331);
        long l = bs.Gn();
        eaf localeaf = new eaf();
        localeaf.Ggj = be.c.this.url;
        localeaf.Eae = be.c.c(be.c.this).Eeo;
        localeaf.Ggi = be.c.c(be.c.this).lmu;
        j.aVC().a(be.this.appId, localeaf, 0);
        ac.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "doIncrementalJob, onPkgIncrementalUpdateFailed flush release url appId[%s] cost[%d]", new Object[] { be.this.appId, Long.valueOf(bs.aO(l)) });
        AppMethodBeat.o(47331);
      }
      
      final String bnD()
      {
        AppMethodBeat.i(47329);
        String str = String.format(Locale.US, "Incremental %d|%d", new Object[] { Integer.valueOf(be.c.a(be.c.this)), Integer.valueOf(be.c.b(be.c.this)) });
        AppMethodBeat.o(47329);
        return str;
      }
      
      final void e(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
      {
        AppMethodBeat.i(47330);
        this.jNA.value = paramWxaPkgWrappingInfo;
        localCountDownLatch.countDown();
        AppMethodBeat.o(47330);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.be
 * JD-Core Version:    0.7.0.1
 */
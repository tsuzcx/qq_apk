package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ab.b;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f.a;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.plugin.appbrand.appcache.br;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.launching.d.c.a;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

abstract class bh
  extends be<WxaPkgWrappingInfo>
  implements x
{
  final String appId;
  final int enterScene;
  final int hQh;
  final WxaAttributes.WxaVersionInfo jZu;
  final String lEv;
  private boolean lIz = false;
  private WxaPkgWrappingInfo lLc;
  private final int pkgVersion;
  
  bh(String paramString1, int paramInt1, int paramInt2, int paramInt3, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, String paramString2)
  {
    this.appId = paramString1;
    this.hQh = paramInt1;
    this.pkgVersion = paramInt2;
    this.enterScene = paramInt3;
    this.jZu = paramWxaVersionInfo;
    this.lEv = paramString2;
  }
  
  static chd a(blp paramblp, com.tencent.luggage.sdk.e.b paramb)
  {
    int i = paramblp.GFE;
    boolean bool;
    Object localObject1;
    com.tencent.mm.al.a.a locala;
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
      localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.lMR;
      paramb = c.a.b(paramb);
      if (paramb == null) {
        break label382;
      }
      locala = paramb.uo(100);
      if (locala != null) {
        break label230;
      }
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack is null");
      if ((locala == null) || (locala.hNC == null) || (locala.errType != 0) || (locala.errCode != 0)) {
        break label373;
      }
      localIterator = ((cls)locala.hNC).HeU.iterator();
      localObject4 = null;
      paramb = null;
      localObject3 = null;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label312;
      }
      localObject1 = (chd)localIterator.next();
      if (bt.isNullOrNil(paramblp.GDK)) {
        paramblp.GDK = "";
      }
      if (bt.isNullOrNil(((chd)localObject1).GDK)) {
        ((chd)localObject1).GDK = "";
      }
      if ((((chd)localObject1).GDN == paramblp.GDN) && (paramblp.GDK.equals(((chd)localObject1).GDK)))
      {
        if (((chd)localObject1).Gxw)
        {
          localObject3 = localObject1;
          continue;
          bool = false;
          break;
          label230:
          if (locala.hNC == null)
          {
            ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack.resp is null");
            break label74;
          }
          ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: (%d,%d)", new Object[] { Integer.valueOf(locala.errType), Integer.valueOf(locala.errCode) });
          break label74;
        }
        localObject2 = localObject1;
        if (!((chd)localObject1).Gxv) {
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
    if (((cls)locala.hNC).version == paramblp.FKN)
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
  
  private void brE()
  {
    if (!this.lIz)
    {
      bqN();
      this.lIz = true;
    }
  }
  
  private WxaPkgWrappingInfo c(Callable<WxaPkgWrappingInfo> paramCallable)
  {
    if (paramCallable == this)
    {
      Assert.assertTrue("Why the hell you pass 'this' to this method", false);
      return null;
    }
    brE();
    try
    {
      paramCallable = (WxaPkgWrappingInfo)paramCallable.call();
      bqW();
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
  
  private static void ul(int paramInt)
  {
    if (paramInt > 0)
    {
      long l = bt.flT();
      ab.b localb = ab.sD(paramInt);
      ad.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bt.flT() - l), localb.name() });
    }
  }
  
  final void a(WxaPkgIntegrityChecker.a parama)
  {
    int i = 2131755505;
    if (WxaPkgIntegrityChecker.a.jIm.equals(parama))
    {
      if (this.hQh == 1) {}
      for (parama = com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755505, new Object[0]);; parama = com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755583, new Object[] { com.tencent.mm.plugin.appbrand.appcache.e.rP(this.hQh) }))
      {
        if (this.hQh == 1)
        {
          com.tencent.mm.plugin.appbrand.task.f.bY(this.appId, this.hQh);
          com.tencent.mm.plugin.appbrand.report.h.S(this.appId, 10, this.hQh + 1);
        }
        RO(parama);
        return;
      }
    }
    if ((WxaPkgIntegrityChecker.a.jIo.equals(parama)) || (WxaPkgIntegrityChecker.a.jIn.equals(parama)))
    {
      if (this.hQh != 0) {}
      for (;;)
      {
        uk(i);
        if (this.hQh == 1) {
          com.tencent.mm.plugin.appbrand.report.h.S(this.appId, 10, this.hQh + 1);
        }
        com.tencent.mm.plugin.appbrand.task.f.bY(this.appId, this.hQh);
        return;
        i = 2131755508;
      }
    }
    RO(com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755580, new Object[] { Integer.valueOf(1), Integer.valueOf(parama.baI()) }));
  }
  
  public WxaPkgWrappingInfo bgh()
  {
    Object localObject1 = WxaPkgIntegrityChecker.D(this.appId, this.hQh, this.pkgVersion);
    if (((Pair)localObject1).second != null)
    {
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.hQh), Integer.valueOf(this.pkgVersion) });
      ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).s(this.lEv, this.appId, this.pkgVersion);
      localObject1 = (WxaPkgWrappingInfo)((Pair)localObject1).second;
    }
    Object localObject2;
    for (;;)
    {
      return localObject1;
      if (!j.a.rQ(this.hQh)) {
        break label1354;
      }
      Object localObject3 = ((am)j.T(am.class)).A(this.appId, 1, this.pkgVersion);
      if (localObject3 == null) {
        break label1354;
      }
      localObject2 = new PLong();
      boolean bool = com.tencent.mm.plugin.appbrand.appcache.b.b.f.a((com.tencent.mm.plugin.appbrand.appcache.al)localObject3, f.a.jKl, (PLong)localObject2);
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "decrypt ret %b, with appId(%s) version(%d)", new Object[] { Boolean.valueOf(bool), this.appId, Integer.valueOf(this.pkgVersion) });
      if (!bool) {
        break label1354;
      }
      localObject1 = WxaPkgIntegrityChecker.D(this.appId, this.hQh, this.pkgVersion);
      if (((Pair)localObject1).second != null)
      {
        localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((PLong)localObject2).value, 180L);
        return (WxaPkgWrappingInfo)((Pair)localObject1).second;
      }
      localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jKA;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((PLong)localObject2).value, 181L);
      label268:
      localObject2 = localObject1;
      if (WxaPkgIntegrityChecker.a.jIm.equals(((Pair)localObject1).first))
      {
        ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, manifest NULL, appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.hQh), Integer.valueOf(this.pkgVersion) });
        if (this.jZu.aDD > 0)
        {
          j.aYX().a(this.appId, this.jZu);
          if (j.aYX().a(this.appId, this.pkgVersion, this.hQh, new String[0]) == null)
          {
            ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, insert manifest fail again!!! appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.hQh), Integer.valueOf(this.pkgVersion) });
            a(WxaPkgIntegrityChecker.a.jIm);
            return null;
          }
          localObject2 = Pair.create(WxaPkgIntegrityChecker.a.jIp, null);
        }
      }
      else
      {
        if (!WxaPkgIntegrityChecker.a.jIp.equals(((Pair)localObject2).first)) {
          break label1340;
        }
        if (this.hQh != 0) {
          break label1315;
        }
        this.lLc = m.bK(this.appId, 1);
        try
        {
          localObject3 = new android.arch.a.c.a() {};
          localObject2 = (bc)((android.arch.a.c.a)localObject3).apply(null);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label695;
          }
          ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken, first query get NULL with appId[%s], retry", new Object[] { this.appId });
          j.aYX().a(this.appId, this.jZu);
          localObject2 = (bc)((android.arch.a.c.a)localObject3).apply(null);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label695;
          }
          throw new x.a.a().p(com.tencent.mm.plugin.appbrand.utils.e.getMMString(2131755583, new Object[] { com.tencent.mm.plugin.appbrand.appcache.e.rP(this.hQh) }), new Object[0]).q("get NULL record with md5", new Object[0]).brg();
        }
        catch (x.a locala)
        {
          ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s, toast %s", new Object[] { this.appId, locala.getMessage(), locala.lHI });
          if (this.pkgVersion <= 0)
          {
            localObject2 = m.bK(this.appId, 1);
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            if (!bt.isNullOrNil(locala.lHI)) {
              RO(locala.lHI);
            }
            return null;
          }
        }
      }
    }
    a(WxaPkgIntegrityChecker.a.jIm);
    return null;
    label695:
    brE();
    long l1 = bt.flT();
    int k = ((bc)localObject1).field_version;
    int i;
    label719:
    blp localblp;
    if (this.lLc == null)
    {
      i = 0;
      localblp = com.tencent.mm.plugin.appbrand.appcache.h.a(this.appId, ((bc)localObject1).field_version, ((bc)localObject1).field_versionMd5, 0, i);
      localObject1 = com.tencent.luggage.sdk.e.c.cpG;
      localObject1 = com.tencent.luggage.sdk.e.c.jdMethod_do(this.lEv);
      if (i != 0) {
        break label1357;
      }
    }
    label786:
    label1045:
    label1090:
    label1099:
    label1357:
    for (int j = 1;; j = 0)
    {
      chd localchd;
      Object localObject4;
      if (j != 0)
      {
        localchd = a(localblp, (com.tencent.luggage.sdk.e.b)localObject1);
        if (localchd == null) {
          ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: hit parallel cgi but useless");
        }
      }
      else
      {
        localObject2 = new com.tencent.mm.plugin.appbrand.appcache.h(localblp).brO();
        if ((localObject2 != null) && (((com.tencent.mm.al.a.a)localObject2).errType == 0) && (((com.tencent.mm.al.a.a)localObject2).errCode == 0)) {
          break label1139;
        }
        if ((localObject2 == null) || (((com.tencent.mm.al.a.a)localObject2).errCode != -1001)) {
          break label1038;
        }
        localObject1 = bf.getMMString(2131755579, new Object[0]);
        localObject4 = new x.a.a();
        if (localObject2 != null) {
          break label1099;
        }
      }
      for (localObject2 = null;; localObject2 = String.format(Locale.US, "(%d, %d)", new Object[] { Integer.valueOf(((com.tencent.mm.al.a.a)localObject2).errType), Integer.valueOf(((com.tencent.mm.al.a.a)localObject2).errCode) }))
      {
        throw ((x.a.a)localObject4).q("fail get download url, resp %s", new Object[] { localObject2 }).p((String)localObject1, new Object[0]).brg();
        i = this.lLc.pkgVersion;
        break label719;
        ul(this.jZu.kaa);
        localObject1 = "";
        localObject2 = "";
        localObject4 = "";
        if (localchd.Gxv) {
          localObject1 = localchd.url;
        }
        for (;;)
        {
          localObject2 = c(new c(i, k, localblp, (String)localObject1, (String)localObject2, (String)localObject4, (byte)0));
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (localchd.md5.equals(((WxaPkgWrappingInfo)localObject2).md5)) {
              break;
            }
          }
          com.tencent.mm.plugin.appbrand.launching.d.b.ma(18);
          ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: fullback to nonParallelCgi");
          break label786;
          if (localchd.Gxw) {
            localObject2 = localchd.url;
          } else {
            localObject4 = localchd.url;
          }
        }
        if (localObject2 == null)
        {
          i = -1;
          if (localObject2 != null) {
            break label1090;
          }
        }
        for (j = -1;; j = ((com.tencent.mm.al.a.a)localObject2).errCode)
        {
          localObject1 = bf.getMMString(2131755577, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          break;
          i = ((com.tencent.mm.al.a.a)localObject2).errType;
          break label1045;
        }
      }
      label1139:
      long l2 = bt.flT();
      au.a(au.b.lKj, this.appId, k, this.hQh, this.enterScene, l2 - l1);
      if (bt.isNullOrNil(((blq)((com.tencent.mm.al.a.a)localObject2).hNC).url)) {
        throw new x.a.a().q("CgiGetDownloadURL return EMPTY url, ret = %d", new Object[] { Integer.valueOf(((blq)((com.tencent.mm.al.a.a)localObject2).hNC).ret) }).brg();
      }
      ul(this.jZu.kaa);
      localObject2 = c(new c(i, k, localblp, ((blq)((com.tencent.mm.al.a.a)localObject2).hNC).dxg, ((blq)((com.tencent.mm.al.a.a)localObject2).hNC).GFN, ((blq)((com.tencent.mm.al.a.a)localObject2).hNC).url, (byte)0));
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      throw new x.a.a().q("Download Fail", new Object[0]).brg();
      localObject1 = c(new a(0, null, (byte)0));
      if (localObject1 != null) {
        return localObject1;
      }
      a((WxaPkgIntegrityChecker.a)((Pair)localObject2).first);
      return null;
      break label268;
    }
  }
  
  public void bqN() {}
  
  public void bqW() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
  }
  
  final class a
    implements Callable<WxaPkgWrappingInfo>
  {
    private final String khJ;
    private final int lLe;
    
    private a(int paramInt, String paramString)
    {
      this.lLe = paramInt;
      this.khJ = paramString;
    }
    
    public final WxaPkgWrappingInfo bgh()
    {
      AppMethodBeat.i(47324);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      al local1 = new al(bh.this.hQh)
      {
        protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
        {
          AppMethodBeat.i(47322);
          ad.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "hy: onPkgUpdateProgress %s", new Object[] { paramAnonymousWxaPkgLoadProgress.toString() });
          if (paramAnonymousWxaPkgLoadProgress.progress >= 100)
          {
            AppMethodBeat.o(47322);
            return;
          }
          bh.this.onDownloadProgress(paramAnonymousWxaPkgLoadProgress.progress);
          AppMethodBeat.o(47322);
        }
        
        final String brq()
        {
          AppMethodBeat.i(47320);
          String str = String.format(Locale.US, "NonIncremental %d", new Object[] { Integer.valueOf(bh.a.a(bh.a.this)) });
          AppMethodBeat.o(47320);
          return str;
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47321);
          this.khL.value = paramAnonymousWxaPkgWrappingInfo;
          localCountDownLatch.countDown();
          AppMethodBeat.o(47321);
        }
      };
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", new Object[] { bh.this.appId, Integer.valueOf(bh.this.hQh), Integer.valueOf(this.lLe) });
      if (j.a.oN(bh.this.hQh))
      {
        final bc localbc = j.aYX().a(bh.this.appId, bh.this.hQh, new String[] { "versionMd5", "downloadURL" });
        if ((localbc == null) || (bt.isNullOrNil(localbc.field_downloadURL)))
        {
          ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d), record(%s)", new Object[] { bh.this.appId, Integer.valueOf(bh.this.hQh), localbc });
          bh.this.a(WxaPkgIntegrityChecker.a.jIm);
          AppMethodBeat.o(47324);
          return null;
        }
        if (!bi.a(bh.this.appId, bh.this.hQh, localbc.field_downloadURL, local1, new com.tencent.mm.plugin.appbrand.appcache.a.a.a()
        {
          public final String aZW()
          {
            AppMethodBeat.i(47323);
            String str = "_" + localbc.field_versionMd5;
            AppMethodBeat.o(47323);
            return str;
          }
        }))
        {
          ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { bh.this.appId, Integer.valueOf(bh.this.hQh), Integer.valueOf(this.lLe) });
          bh.this.a(WxaPkgIntegrityChecker.a.jIq);
          AppMethodBeat.o(47324);
          return null;
        }
      }
      else if (!bi.a(bh.this.appId, bh.this.hQh, this.lLe, bh.this.jZu.kaa, this.khJ, local1))
      {
        ad.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { bh.this.appId, Integer.valueOf(bh.this.hQh), Integer.valueOf(this.lLe) });
        bh.this.a(WxaPkgIntegrityChecker.a.jIq);
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
    private final int lLe;
    private final String url;
    
    private b(int paramInt, String paramString)
    {
      this.lLe = paramInt;
      this.url = paramString;
    }
    
    final WxaPkgWrappingInfo brF()
    {
      AppMethodBeat.i(47327);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      al local1 = new al(bh.this.hQh)
      {
        final String brq()
        {
          return "Zstd";
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47326);
          this.khL.value = paramAnonymousWxaPkgWrappingInfo;
          localCountDownLatch.countDown();
          AppMethodBeat.o(47326);
        }
      };
      if (!br.a(this.url, bh.this.appId, this.lLe, 0, local1))
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
    String lJD;
    String lJE;
    private final int lLh;
    private final int lLi;
    private final blp lLj;
    String url;
    
    private c(int paramInt1, int paramInt2, blp paramblp, String paramString1, String paramString2, String paramString3)
    {
      this.lLh = paramInt1;
      this.lLi = paramInt2;
      this.lLj = paramblp;
      this.lJD = paramString1;
      this.lJE = paramString2;
      this.url = paramString3;
    }
    
    private WxaPkgWrappingInfo brG()
    {
      AppMethodBeat.i(47332);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      a locala = new a(bh.this.hQh, (i)localObject, localCountDownLatch);
      if (!s.a(bh.this.appId, this.lLh, this.lLi, this.lJD, locala))
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
      
      public final void baR()
      {
        AppMethodBeat.i(47331);
        long l = bt.HI();
        egj localegj = new egj();
        localegj.HRw = bh.c.this.url;
        localegj.FFN = bh.c.c(bh.c.this).FKN;
        localegj.HRv = bh.c.c(bh.c.this).lJC;
        j.aYX().a(bh.this.appId, localegj, 0);
        ad.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "doIncrementalJob, onPkgIncrementalUpdateFailed flush release url appId[%s] cost[%d]", new Object[] { bh.this.appId, Long.valueOf(bt.aO(l)) });
        AppMethodBeat.o(47331);
      }
      
      final String brq()
      {
        AppMethodBeat.i(47329);
        String str = String.format(Locale.US, "Incremental %d|%d", new Object[] { Integer.valueOf(bh.c.a(bh.c.this)), Integer.valueOf(bh.c.b(bh.c.this)) });
        AppMethodBeat.o(47329);
        return str;
      }
      
      final void e(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
      {
        AppMethodBeat.i(47330);
        this.khL.value = paramWxaPkgWrappingInfo;
        localCountDownLatch.countDown();
        AppMethodBeat.o(47330);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bh
 * JD-Core Version:    0.7.0.1
 */
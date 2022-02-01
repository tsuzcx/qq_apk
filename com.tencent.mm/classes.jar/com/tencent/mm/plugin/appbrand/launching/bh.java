package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.ac.b;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f.a;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.launching.d.c.a;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  final int hSZ;
  final WxaAttributes.WxaVersionInfo kcL;
  final String lIU;
  private boolean lMZ = false;
  private WxaPkgWrappingInfo lPC;
  private final int pkgVersion;
  
  bh(String paramString1, int paramInt1, int paramInt2, int paramInt3, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, String paramString2)
  {
    this.appId = paramString1;
    this.hSZ = paramInt1;
    this.pkgVersion = paramInt2;
    this.enterScene = paramInt3;
    this.kcL = paramWxaVersionInfo;
    this.lIU = paramString2;
  }
  
  static chx a(bmh parambmh, com.tencent.luggage.sdk.e.b paramb)
  {
    int i = parambmh.GZg;
    boolean bool;
    Object localObject1;
    com.tencent.mm.ak.a.a locala;
    label74:
    Iterator localIterator;
    Object localObject4;
    Object localObject3;
    if (paramb == null)
    {
      bool = true;
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: localOldPkgVersion = %d, parallelCgiLogic is null? = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (paramb == null) {
        break label392;
      }
      localObject1 = com.tencent.mm.plugin.appbrand.launching.d.c.lRr;
      paramb = c.a.b(paramb);
      if (paramb == null) {
        break label382;
      }
      locala = paramb.uu(100);
      if (locala != null) {
        break label230;
      }
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack is null");
      if ((locala == null) || (locala.hQv == null) || (locala.errType != 0) || (locala.errCode != 0)) {
        break label373;
      }
      localIterator = ((cmm)locala.hQv).Hyu.iterator();
      localObject4 = null;
      paramb = null;
      localObject3 = null;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label312;
      }
      localObject1 = (chx)localIterator.next();
      if (bu.isNullOrNil(parambmh.GXn)) {
        parambmh.GXn = "";
      }
      if (bu.isNullOrNil(((chx)localObject1).GXn)) {
        ((chx)localObject1).GXn = "";
      }
      if ((((chx)localObject1).GXq == parambmh.GXq) && (parambmh.GXn.equals(((chx)localObject1).GXn)))
      {
        if (((chx)localObject1).GQW)
        {
          localObject3 = localObject1;
          continue;
          bool = false;
          break;
          label230:
          if (locala.hQv == null)
          {
            ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack.resp is null");
            break label74;
          }
          ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: (%d,%d)", new Object[] { Integer.valueOf(locala.errType), Integer.valueOf(locala.errCode) });
          break label74;
        }
        localObject2 = localObject1;
        if (!((chx)localObject1).GQV) {
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
    ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: patchUrl = [%s], zstdUrl = [%s], url = [%s]", new Object[] { localObject4, localObject3, paramb });
    if (((cmm)locala.hQv).version == parambmh.Gdm)
    {
      if (localObject4 != null) {
        return localObject4;
      }
      if (localObject3 != null) {
        return localObject3;
      }
      return paramb;
      label373:
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: check cgiBack fail");
    }
    for (;;)
    {
      return null;
      label382:
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preFetchGetDownloadInfoTask isnull");
      continue;
      label392:
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: parallelCgiLogic is null");
    }
  }
  
  private void bsp()
  {
    if (!this.lMZ)
    {
      brx();
      this.lMZ = true;
    }
  }
  
  private WxaPkgWrappingInfo c(Callable<WxaPkgWrappingInfo> paramCallable)
  {
    if (paramCallable == this)
    {
      Assert.assertTrue("Why the hell you pass 'this' to this method", false);
      return null;
    }
    bsp();
    try
    {
      paramCallable = (WxaPkgWrappingInfo)paramCallable.call();
      brG();
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
  
  private static void ur(int paramInt)
  {
    if (paramInt > 0)
    {
      long l = bu.fpO();
      ac.b localb = ac.sQ(paramInt);
      ae.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bu.fpO() - l), localb.name() });
    }
  }
  
  final void a(WxaPkgIntegrityChecker.a parama)
  {
    int i = 2131755505;
    if (WxaPkgIntegrityChecker.a.jLn.equals(parama))
    {
      if (this.hSZ == 1) {}
      for (parama = com.tencent.mm.plugin.appbrand.utils.f.getMMString(2131755505, new Object[0]);; parama = com.tencent.mm.plugin.appbrand.utils.f.getMMString(2131755583, new Object[] { e.rS(this.hSZ) }))
      {
        if (this.hSZ == 1)
        {
          com.tencent.mm.plugin.appbrand.task.f.cc(this.appId, this.hSZ);
          com.tencent.mm.plugin.appbrand.report.h.S(this.appId, 10, this.hSZ + 1);
        }
        Sx(parama);
        return;
      }
    }
    if ((WxaPkgIntegrityChecker.a.jLp.equals(parama)) || (WxaPkgIntegrityChecker.a.jLo.equals(parama)))
    {
      if (this.hSZ != 0) {}
      for (;;)
      {
        uq(i);
        if (this.hSZ == 1) {
          com.tencent.mm.plugin.appbrand.report.h.S(this.appId, 10, this.hSZ + 1);
        }
        com.tencent.mm.plugin.appbrand.task.f.cc(this.appId, this.hSZ);
        return;
        i = 2131755508;
      }
    }
    Sx(com.tencent.mm.plugin.appbrand.utils.f.getMMString(2131755580, new Object[] { Integer.valueOf(1), Integer.valueOf(parama.bbh()) }));
  }
  
  public WxaPkgWrappingInfo bgP()
  {
    Object localObject1 = WxaPkgIntegrityChecker.D(this.appId, this.hSZ, this.pkgVersion);
    if (((Pair)localObject1).second != null)
    {
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.hSZ), Integer.valueOf(this.pkgVersion) });
      ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).s(this.lIU, this.appId, this.pkgVersion);
      localObject1 = (WxaPkgWrappingInfo)((Pair)localObject1).second;
    }
    Object localObject2;
    for (;;)
    {
      return localObject1;
      if (!j.a.rT(this.hSZ)) {
        break label1354;
      }
      Object localObject3 = ((an)j.T(an.class)).A(this.appId, 1, this.pkgVersion);
      if (localObject3 == null) {
        break label1354;
      }
      localObject2 = new PLong();
      boolean bool = com.tencent.mm.plugin.appbrand.appcache.b.b.f.a((am)localObject3, f.a.jNx, (PLong)localObject2);
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "decrypt ret %b, with appId(%s) version(%d)", new Object[] { Boolean.valueOf(bool), this.appId, Integer.valueOf(this.pkgVersion) });
      if (!bool) {
        break label1354;
      }
      localObject1 = WxaPkgIntegrityChecker.D(this.appId, this.hSZ, this.pkgVersion);
      if (((Pair)localObject1).second != null)
      {
        localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jNM;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((PLong)localObject2).value, 180L);
        return (WxaPkgWrappingInfo)((Pair)localObject1).second;
      }
      localObject3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jNM;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(((PLong)localObject2).value, 181L);
      label268:
      localObject2 = localObject1;
      if (WxaPkgIntegrityChecker.a.jLn.equals(((Pair)localObject1).first))
      {
        ae.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, manifest NULL, appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.hSZ), Integer.valueOf(this.pkgVersion) });
        if (this.kcL.aDD > 0)
        {
          j.aZu().a(this.appId, this.kcL);
          if (j.aZu().a(this.appId, this.pkgVersion, this.hSZ, new String[0]) == null)
          {
            ae.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, insert manifest fail again!!! appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.hSZ), Integer.valueOf(this.pkgVersion) });
            a(WxaPkgIntegrityChecker.a.jLn);
            return null;
          }
          localObject2 = Pair.create(WxaPkgIntegrityChecker.a.jLq, null);
        }
      }
      else
      {
        if (!WxaPkgIntegrityChecker.a.jLq.equals(((Pair)localObject2).first)) {
          break label1340;
        }
        if (this.hSZ != 0) {
          break label1315;
        }
        this.lPC = m.bN(this.appId, 1);
        try
        {
          localObject3 = new android.arch.a.c.a() {};
          localObject2 = (bd)((android.arch.a.c.a)localObject3).apply(null);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label695;
          }
          ae.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken, first query get NULL with appId[%s], retry", new Object[] { this.appId });
          j.aZu().a(this.appId, this.kcL);
          localObject2 = (bd)((android.arch.a.c.a)localObject3).apply(null);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label695;
          }
          throw new x.a.a().p(com.tencent.mm.plugin.appbrand.utils.f.getMMString(2131755583, new Object[] { e.rS(this.hSZ) }), new Object[0]).q("get NULL record with md5", new Object[0]).brQ();
        }
        catch (x.a locala)
        {
          ae.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s, toast %s", new Object[] { this.appId, locala.getMessage(), locala.lMi });
          if (this.pkgVersion <= 0)
          {
            localObject2 = m.bN(this.appId, 1);
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            if (!bu.isNullOrNil(locala.lMi)) {
              Sx(locala.lMi);
            }
            return null;
          }
        }
      }
    }
    a(WxaPkgIntegrityChecker.a.jLn);
    return null;
    label695:
    bsp();
    long l1 = bu.fpO();
    int k = ((bd)localObject1).field_version;
    int i;
    label719:
    bmh localbmh;
    if (this.lPC == null)
    {
      i = 0;
      localbmh = com.tencent.mm.plugin.appbrand.appcache.h.a(this.appId, ((bd)localObject1).field_version, ((bd)localObject1).field_versionMd5, 0, i);
      localObject1 = com.tencent.luggage.sdk.e.c.cqj;
      localObject1 = com.tencent.luggage.sdk.e.c.dq(this.lIU);
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
      chx localchx;
      Object localObject4;
      if (j != 0)
      {
        localchx = a(localbmh, (com.tencent.luggage.sdk.e.b)localObject1);
        if (localchx == null) {
          ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: hit parallel cgi but useless");
        }
      }
      else
      {
        localObject2 = new com.tencent.mm.plugin.appbrand.appcache.h(localbmh).bsz();
        if ((localObject2 != null) && (((com.tencent.mm.ak.a.a)localObject2).errType == 0) && (((com.tencent.mm.ak.a.a)localObject2).errCode == 0)) {
          break label1139;
        }
        if ((localObject2 == null) || (((com.tencent.mm.ak.a.a)localObject2).errCode != -1001)) {
          break label1038;
        }
        localObject1 = bf.getMMString(2131755579, new Object[0]);
        localObject4 = new x.a.a();
        if (localObject2 != null) {
          break label1099;
        }
      }
      for (localObject2 = null;; localObject2 = String.format(Locale.US, "(%d, %d)", new Object[] { Integer.valueOf(((com.tencent.mm.ak.a.a)localObject2).errType), Integer.valueOf(((com.tencent.mm.ak.a.a)localObject2).errCode) }))
      {
        throw ((x.a.a)localObject4).q("fail get download url, resp %s", new Object[] { localObject2 }).p((String)localObject1, new Object[0]).brQ();
        i = this.lPC.pkgVersion;
        break label719;
        ur(this.kcL.kdr);
        localObject1 = "";
        localObject2 = "";
        localObject4 = "";
        if (localchx.GQV) {
          localObject1 = localchx.url;
        }
        for (;;)
        {
          localObject2 = c(new c(i, k, localbmh, (String)localObject1, (String)localObject2, (String)localObject4, (byte)0));
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (localchx.md5.equals(((WxaPkgWrappingInfo)localObject2).md5)) {
              break;
            }
          }
          com.tencent.mm.plugin.appbrand.launching.d.b.md(18);
          ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: fullback to nonParallelCgi");
          break label786;
          if (localchx.GQW) {
            localObject2 = localchx.url;
          } else {
            localObject4 = localchx.url;
          }
        }
        if (localObject2 == null)
        {
          i = -1;
          if (localObject2 != null) {
            break label1090;
          }
        }
        for (j = -1;; j = ((com.tencent.mm.ak.a.a)localObject2).errCode)
        {
          localObject1 = bf.getMMString(2131755577, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          break;
          i = ((com.tencent.mm.ak.a.a)localObject2).errType;
          break label1045;
        }
      }
      label1139:
      long l2 = bu.fpO();
      au.a(au.b.lOJ, this.appId, k, this.hSZ, this.enterScene, l2 - l1);
      if (bu.isNullOrNil(((bmi)((com.tencent.mm.ak.a.a)localObject2).hQv).url)) {
        throw new x.a.a().q("CgiGetDownloadURL return EMPTY url, ret = %d", new Object[] { Integer.valueOf(((bmi)((com.tencent.mm.ak.a.a)localObject2).hQv).ret) }).brQ();
      }
      ur(this.kcL.kdr);
      localObject2 = c(new c(i, k, localbmh, ((bmi)((com.tencent.mm.ak.a.a)localObject2).hQv).dyl, ((bmi)((com.tencent.mm.ak.a.a)localObject2).hQv).GZp, ((bmi)((com.tencent.mm.ak.a.a)localObject2).hQv).url, (byte)0));
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      throw new x.a.a().q("Download Fail", new Object[0]).brQ();
      localObject1 = c(new a(0, null, (byte)0));
      if (localObject1 != null) {
        return localObject1;
      }
      a((WxaPkgIntegrityChecker.a)((Pair)localObject2).first);
      return null;
      break label268;
    }
  }
  
  public void brG() {}
  
  public void brx() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
  }
  
  final class a
    implements Callable<WxaPkgWrappingInfo>
  {
    private final String kkZ;
    private final int lPE;
    
    private a(int paramInt, String paramString)
    {
      this.lPE = paramInt;
      this.kkZ = paramString;
    }
    
    public final WxaPkgWrappingInfo bgP()
    {
      AppMethodBeat.i(47324);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      al local1 = new al(bh.this.hSZ)
      {
        protected final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
        {
          AppMethodBeat.i(47322);
          ae.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "hy: onPkgUpdateProgress %s", new Object[] { paramAnonymousWxaPkgLoadProgress.toString() });
          if (paramAnonymousWxaPkgLoadProgress.progress >= 100)
          {
            AppMethodBeat.o(47322);
            return;
          }
          bh.this.onDownloadProgress(paramAnonymousWxaPkgLoadProgress.progress);
          AppMethodBeat.o(47322);
        }
        
        final String bsb()
        {
          AppMethodBeat.i(47320);
          String str = String.format(Locale.US, "NonIncremental %d", new Object[] { Integer.valueOf(bh.a.a(bh.a.this)) });
          AppMethodBeat.o(47320);
          return str;
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47321);
          this.klb.value = paramAnonymousWxaPkgWrappingInfo;
          localCountDownLatch.countDown();
          AppMethodBeat.o(47321);
        }
      };
      ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", new Object[] { bh.this.appId, Integer.valueOf(bh.this.hSZ), Integer.valueOf(this.lPE) });
      if (j.a.oQ(bh.this.hSZ))
      {
        final bd localbd = j.aZu().a(bh.this.appId, bh.this.hSZ, new String[] { "versionMd5", "downloadURL" });
        if ((localbd == null) || (bu.isNullOrNil(localbd.field_downloadURL)))
        {
          ae.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d), record(%s)", new Object[] { bh.this.appId, Integer.valueOf(bh.this.hSZ), localbd });
          bh.this.a(WxaPkgIntegrityChecker.a.jLn);
          AppMethodBeat.o(47324);
          return null;
        }
        if (!bj.a(bh.this.appId, bh.this.hSZ, localbd.field_downloadURL, local1, new com.tencent.mm.plugin.appbrand.appcache.a.a.a()
        {
          public final String bav()
          {
            AppMethodBeat.i(47323);
            String str = "_" + localbd.field_versionMd5;
            AppMethodBeat.o(47323);
            return str;
          }
        }))
        {
          ae.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { bh.this.appId, Integer.valueOf(bh.this.hSZ), Integer.valueOf(this.lPE) });
          bh.this.a(WxaPkgIntegrityChecker.a.jLr);
          AppMethodBeat.o(47324);
          return null;
        }
      }
      else if (!bj.a(bh.this.appId, bh.this.hSZ, this.lPE, bh.this.kcL.kdr, this.kkZ, local1))
      {
        ae.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", new Object[] { bh.this.appId, Integer.valueOf(bh.this.hSZ), Integer.valueOf(this.lPE) });
        bh.this.a(WxaPkgIntegrityChecker.a.jLr);
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
          ae.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localException, "downloadNonIncremental semaphore exp ", new Object[0]);
        }
      }
    }
  }
  
  final class b
    implements Callable<WxaPkgWrappingInfo>
  {
    private final int lPE;
    private final String url;
    
    private b(int paramInt, String paramString)
    {
      this.lPE = paramInt;
      this.url = paramString;
    }
    
    final WxaPkgWrappingInfo bsq()
    {
      AppMethodBeat.i(47327);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      al local1 = new al(bh.this.hSZ)
      {
        final String bsb()
        {
          return "Zstd";
        }
        
        final void e(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
        {
          AppMethodBeat.i(47326);
          this.klb.value = paramAnonymousWxaPkgWrappingInfo;
          localCountDownLatch.countDown();
          AppMethodBeat.o(47326);
        }
      };
      if (!bt.a(this.url, bh.this.appId, this.lPE, 0, local1))
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
          ae.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localInterruptedException, "doZstdJob semaphore exp ", new Object[0]);
        }
      }
    }
  }
  
  final class c
    implements Callable<WxaPkgWrappingInfo>
  {
    String lOd;
    String lOe;
    private final int lPH;
    private final int lPI;
    private final bmh lPJ;
    String url;
    
    private c(int paramInt1, int paramInt2, bmh parambmh, String paramString1, String paramString2, String paramString3)
    {
      this.lPH = paramInt1;
      this.lPI = paramInt2;
      this.lPJ = parambmh;
      this.lOd = paramString1;
      this.lOe = paramString2;
      this.url = paramString3;
    }
    
    private WxaPkgWrappingInfo bsr()
    {
      AppMethodBeat.i(47332);
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      Object localObject = new i();
      a locala = new a(bh.this.hSZ, (i)localObject, localCountDownLatch);
      if (!s.a(bh.this.appId, this.lPH, this.lPI, this.lOd, locala))
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
          ae.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localInterruptedException, "downloadIncremental semaphore exp ", new Object[0]);
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
      
      public final void bbq()
      {
        AppMethodBeat.i(47331);
        long l = bu.HQ();
        eia localeia = new eia();
        localeia.IlD = bh.c.this.url;
        localeia.FYj = bh.c.c(bh.c.this).Gdm;
        localeia.IlC = bh.c.c(bh.c.this).lOc;
        j.aZu().a(bh.this.appId, localeia, 0);
        ae.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "doIncrementalJob, onPkgIncrementalUpdateFailed flush release url appId[%s] cost[%d]", new Object[] { bh.this.appId, Long.valueOf(bu.aO(l)) });
        AppMethodBeat.o(47331);
      }
      
      final String bsb()
      {
        AppMethodBeat.i(47329);
        String str = String.format(Locale.US, "Incremental %d|%d", new Object[] { Integer.valueOf(bh.c.a(bh.c.this)), Integer.valueOf(bh.c.b(bh.c.this)) });
        AppMethodBeat.o(47329);
        return str;
      }
      
      final void e(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
      {
        AppMethodBeat.i(47330);
        this.klb.value = paramWxaPkgWrappingInfo;
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
package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b
  implements Callable<WxaPkgWrappingInfo>
{
  public static int kkX = 0;
  public static int kkY = 1;
  final String appId;
  final int duK;
  final String id;
  String kid;
  int kkV;
  volatile String kkZ;
  String kla;
  volatile int pkgVersion;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.appId = paramString2;
    this.duK = paramInt1;
    this.pkgVersion = paramInt2;
    this.kkZ = paramString4;
    this.kkV = paramInt3;
    this.kid = paramString3;
    this.kla = paramString5;
  }
  
  private WxaPkgWrappingInfo Pq(String paramString)
  {
    AppMethodBeat.i(121402);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final com.tencent.mm.plugin.appbrand.y.i locali = new com.tencent.mm.plugin.appbrand.y.i();
    bj.a local1 = new bj.a() {};
    v.md(7);
    boolean bool;
    if ((this.duK == 10002) || (this.duK == 10102))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.pkgVersion) });
      if (!bu.isNullOrNil(paramString)) {
        bool = bt.a(paramString, this.appId, this.pkgVersion, this.duK, local1);
      }
    }
    while (!bool)
    {
      v.md(9);
      paramString = new el().oa(u.CK(this.id));
      paramString.ejC = u.CI(this.id);
      paramString.ejz = 4L;
      paramString = paramString.nZ(this.id);
      paramString.ejA = System.currentTimeMillis();
      paramString.ejB = 2L;
      paramString.ob(az.iW(ak.getContext())).aLH();
      a(WxaPkgIntegrityChecker.a.jLr);
      AppMethodBeat.o(121402);
      return null;
      bool = bj.b(this.appId, this.duK, this.pkgVersion, this.kkZ, local1);
      continue;
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[] { this.appId, Integer.valueOf(this.duK) });
      if (((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP() == null)
      {
        ae.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
        a(WxaPkgIntegrityChecker.a.jLr);
        AppMethodBeat.o(121402);
        return null;
      }
      paramString = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP().aS(this.appId, this.duK);
      if (bu.isNullOrNil(paramString))
      {
        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
        a(WxaPkgIntegrityChecker.a.jLn);
        AppMethodBeat.o(121402);
        return null;
      }
      bj.a(this.appId, this.duK, paramString, local1);
    }
    try
    {
      localCountDownLatch.await();
      paramString = (WxaPkgWrappingInfo)locali.value;
      AppMethodBeat.o(121402);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", paramString, "tryDownload semaphore exp ", new Object[0]);
      }
    }
  }
  
  private static void a(WxaPkgIntegrityChecker.a parama)
  {
    AppMethodBeat.i(121403);
    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecordError %s", new Object[] { parama.toString() });
    if (WxaPkgIntegrityChecker.a.jLn.equals(parama))
    {
      AppMethodBeat.o(121403);
      return;
    }
    if ((WxaPkgIntegrityChecker.a.jLp.equals(parama)) || (WxaPkgIntegrityChecker.a.jLo.equals(parama)))
    {
      AppMethodBeat.o(121403);
      return;
    }
    AppMethodBeat.o(121403);
  }
  
  public final WxaPkgWrappingInfo bgP()
  {
    int j = 1;
    AppMethodBeat.i(121401);
    Pair localPair = WxaPkgIntegrityChecker.D(this.appId, this.duK, this.pkgVersion);
    Object localObject1;
    if (localPair.second != null)
    {
      j.bgu().bB(this.appId, 29);
      localObject1 = (WxaPkgWrappingInfo)localPair.second;
      AppMethodBeat.o(121401);
      return localObject1;
    }
    j.bgu().bB(this.appId, 3);
    int i;
    Object localObject2;
    if (WxaPkgIntegrityChecker.a.jLq.equals(localPair.first))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", new Object[] { this.appId, Integer.valueOf(this.duK), Integer.valueOf(this.pkgVersion) });
      if ((this.duK != 10002) && (this.duK != 10102)) {
        break label1273;
      }
      bd localbd = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP().a(this.appId, this.duK, new String[] { "version", "versionMd5" });
      if (localbd == null)
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
        a((WxaPkgIntegrityChecker.a)localPair.first);
        AppMethodBeat.o(121401);
        return null;
      }
      if (this.duK == 10102)
      {
        i = 2;
        v.md(4);
        localObject1 = new el().oa(this.appId);
        ((el)localObject1).ejC = u.CI(this.id);
        ((el)localObject1).ejz = 13L;
        localObject1 = ((el)localObject1).nZ(this.id);
        ((el)localObject1).ejA = System.currentTimeMillis();
        ((el)localObject1).ejB = 2L;
        ((el)localObject1).ob(az.iW(ak.getContext())).aLH();
        if (TextUtils.isEmpty(this.kla)) {
          break label1267;
        }
        localObject1 = new bmi();
        ((bmi)localObject1).parseFrom(Base64.decode(this.kla, 0));
        if (!TextUtils.isEmpty(((bmi)localObject1).url)) {
          break label618;
        }
        localObject1 = null;
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label643;
        }
        localObject1 = y.a(((a)com.tencent.luggage.a.e.K(a.class)).a(this.appId, localbd.field_version, localbd.field_versionMd5, i));
        if ((localObject1 != null) && (((a.a)localObject1).errType == 0) && (((a.a)localObject1).errCode == 0)) {
          break label633;
        }
        v.md(6);
        localObject1 = new el().oa(this.appId);
        ((el)localObject1).ejC = u.CI(this.id);
        ((el)localObject1).ejz = 3L;
        localObject1 = ((el)localObject1).nZ(this.id);
        ((el)localObject1).ejA = System.currentTimeMillis();
        ((el)localObject1).ejB = 2L;
        ((el)localObject1).ob(az.iW(ak.getContext())).aLH();
        if ((this.kkV == 1) && (this.id != null) && (this.id.length() > 0))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("id", this.id);
          ((Bundle)localObject1).putInt("widgetState", 2105);
          h.a(com.tencent.mm.plugin.appbrand.dynamic.i.bgs().Pc(this.id), (Parcelable)localObject1, f.a.class, null);
        }
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail", new Object[0]);
        AppMethodBeat.o(121401);
        return null;
        i = 1;
        break;
        label618:
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "use preload download data", new Object[0]);
      }
      label633:
      localObject2 = (bmi)((a.a)localObject1).hQv;
      label643:
      if (localObject2 == null)
      {
        AppMethodBeat.o(121401);
        return null;
      }
      localObject1 = new el().oa(u.CK(this.id));
      ((el)localObject1).ejC = u.CI(this.id);
      ((el)localObject1).ejz = 3L;
      localObject1 = ((el)localObject1).nZ(this.id);
      ((el)localObject1).ejA = System.currentTimeMillis();
      ((el)localObject1).ejB = 1L;
      ((el)localObject1).ob(az.iW(ak.getContext())).aLH();
      localObject1 = ((bmi)localObject2).GZp;
      v.md(5);
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
      if (bu.isNullOrNil(((bmi)localObject2).url))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
        AppMethodBeat.o(121401);
        return null;
      }
      eia localeia = new eia();
      localObject2 = ((bmi)localObject2).url;
      this.kkZ = ((String)localObject2);
      localeia.IlD = ((String)localObject2);
      i = localbd.field_version;
      this.pkgVersion = i;
      localeia.FYj = i;
      localeia.IlC = localbd.field_versionMd5;
      ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP().a(this.appId, localeia, this.duK);
    }
    for (;;)
    {
      localObject1 = Pq((String)localObject1);
      if (localObject1 != null)
      {
        if (this.kkV == 1) {
          com.tencent.mm.plugin.report.service.g.yxI.f(14452, new Object[] { this.kid + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
        }
        AppMethodBeat.o(121401);
        return localObject1;
      }
      if (this.kkV == 1) {
        com.tencent.mm.plugin.report.service.g.yxI.f(14452, new Object[] { this.kid + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((this.duK == 10002) || (this.duK == 10102))
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP().Mj(this.appId);
        if ((localObject1 == null) || (localObject1.length <= 1)) {}
      }
      for (i = j;; i = j)
      {
        localObject2 = this.appId;
        int k = this.duK;
        j = i + 1;
        localObject2 = WxaPkgIntegrityChecker.D((String)localObject2, k, localObject1[i]);
        if ((localObject2 != null) && (((Pair)localObject2).first == WxaPkgIntegrityChecker.a.jLm) && (((Pair)localObject2).second != null))
        {
          localObject1 = (WxaPkgWrappingInfo)((Pair)localObject2).second;
          AppMethodBeat.o(121401);
          return localObject1;
          if (WxaPkgIntegrityChecker.a.jLm.equals(localPair.first)) {
            break;
          }
          ae.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[] { this.appId, Integer.valueOf(this.duK), Integer.valueOf(this.pkgVersion), Integer.valueOf(((WxaPkgIntegrityChecker.a)localPair.first).bbh()) });
          break;
        }
        if (j >= localObject1.length)
        {
          a((WxaPkgIntegrityChecker.a)localPair.first);
          AppMethodBeat.o(121401);
          return null;
        }
      }
      label1267:
      localObject1 = null;
      break;
      label1273:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.b
 * JD-Core Version:    0.7.0.1
 */
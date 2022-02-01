package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.y;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bh.a;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b
  implements Callable<WxaPkgWrappingInfo>
{
  public static int jnk = 0;
  public static int jnl = 1;
  final String appId;
  final int dkC;
  final String id;
  String jko;
  int jnh;
  volatile String jnm;
  String jnn;
  volatile int pkgVersion;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.appId = paramString2;
    this.dkC = paramInt1;
    this.pkgVersion = paramInt2;
    this.jnm = paramString4;
    this.jnh = paramInt3;
    this.jko = paramString3;
    this.jnn = paramString5;
  }
  
  private WxaPkgWrappingInfo Hk(String paramString)
  {
    AppMethodBeat.i(121402);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final com.tencent.mm.plugin.appbrand.aa.i locali = new com.tencent.mm.plugin.appbrand.aa.i();
    bh.a local1 = new bh.a() {};
    v.lI(7);
    boolean bool;
    if ((this.dkC == 10002) || (this.dkC == 10102))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.pkgVersion) });
      if (!bt.isNullOrNil(paramString)) {
        bool = bp.a(paramString, this.appId, this.pkgVersion, this.dkC, local1);
      }
    }
    while (!bool)
    {
      v.lI(9);
      paramString = new ca().iI(u.vd(this.id));
      paramString.dQy = u.vb(this.id);
      paramString.dQv = 4L;
      paramString = paramString.iH(this.id);
      paramString.dQw = System.currentTimeMillis();
      paramString.dQx = 2L;
      paramString.iJ(ay.iw(aj.getContext())).aBj();
      a(WxaPkgIntegrityChecker.a.iOl);
      AppMethodBeat.o(121402);
      return null;
      bool = bh.b(this.appId, this.dkC, this.pkgVersion, this.jnm, local1);
      continue;
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[] { this.appId, Integer.valueOf(this.dkC) });
      if (((e)g.ab(e.class)).aOk() == null)
      {
        ad.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
        a(WxaPkgIntegrityChecker.a.iOl);
        AppMethodBeat.o(121402);
        return null;
      }
      paramString = ((e)g.ab(e.class)).aOk().aJ(this.appId, this.dkC);
      if (bt.isNullOrNil(paramString))
      {
        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
        a(WxaPkgIntegrityChecker.a.iOh);
        AppMethodBeat.o(121402);
        return null;
      }
      bh.a(this.appId, this.dkC, paramString, local1);
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
        ad.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", paramString, "tryDownload semaphore exp ", new Object[0]);
      }
    }
  }
  
  private static void a(WxaPkgIntegrityChecker.a parama)
  {
    AppMethodBeat.i(121403);
    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecordError %s", new Object[] { parama.toString() });
    if (WxaPkgIntegrityChecker.a.iOh.equals(parama))
    {
      AppMethodBeat.o(121403);
      return;
    }
    if ((WxaPkgIntegrityChecker.a.iOj.equals(parama)) || (WxaPkgIntegrityChecker.a.iOi.equals(parama)))
    {
      AppMethodBeat.o(121403);
      return;
    }
    AppMethodBeat.o(121403);
  }
  
  public final WxaPkgWrappingInfo aVF()
  {
    int j = 1;
    AppMethodBeat.i(121401);
    Pair localPair = WxaPkgIntegrityChecker.C(this.appId, this.dkC, this.pkgVersion);
    Object localObject1;
    if (localPair.second != null)
    {
      j.aVk().bs(this.appId, 29);
      localObject1 = (WxaPkgWrappingInfo)localPair.second;
      AppMethodBeat.o(121401);
      return localObject1;
    }
    j.aVk().bs(this.appId, 3);
    int i;
    Object localObject2;
    if (WxaPkgIntegrityChecker.a.iOk.equals(localPair.first))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", new Object[] { this.appId, Integer.valueOf(this.dkC), Integer.valueOf(this.pkgVersion) });
      if ((this.dkC != 10002) && (this.dkC != 10102)) {
        break label1283;
      }
      bb localbb = ((e)g.ab(e.class)).aOk().a(this.appId, this.dkC, new String[] { "version", "versionMd5", "versionState" });
      if (localbb == null)
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
        a((WxaPkgIntegrityChecker.a)localPair.first);
        AppMethodBeat.o(121401);
        return null;
      }
      if (this.dkC == 10102)
      {
        i = 2;
        v.lI(4);
        localObject1 = new ca().iI(this.appId);
        ((ca)localObject1).dQy = u.vb(this.id);
        ((ca)localObject1).dQv = 13L;
        localObject1 = ((ca)localObject1).iH(this.id);
        ((ca)localObject1).dQw = System.currentTimeMillis();
        ((ca)localObject1).dQx = 2L;
        ((ca)localObject1).iJ(ay.iw(aj.getContext())).aBj();
        if (TextUtils.isEmpty(this.jnn)) {
          break label1277;
        }
        localObject1 = new bdq();
        ((bdq)localObject1).parseFrom(Base64.decode(this.jnn, 0));
        if (!TextUtils.isEmpty(((bdq)localObject1).url)) {
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
        localObject1 = y.a(new com.tencent.mm.plugin.appbrand.appcache.h(this.appId, localbb.field_version, localbb.field_versionMd5, i, (byte)0));
        if ((localObject1 != null) && (((c.a)localObject1).errType == 0) && (((c.a)localObject1).errCode == 0)) {
          break label633;
        }
        v.lI(6);
        localObject1 = new ca().iI(this.appId);
        ((ca)localObject1).dQy = u.vb(this.id);
        ((ca)localObject1).dQv = 3L;
        localObject1 = ((ca)localObject1).iH(this.id);
        ((ca)localObject1).dQw = System.currentTimeMillis();
        ((ca)localObject1).dQx = 2L;
        ((ca)localObject1).iJ(ay.iw(aj.getContext())).aBj();
        if ((this.jnh == 1) && (this.id != null) && (this.id.length() > 0))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("id", this.id);
          ((Bundle)localObject1).putInt("widgetState", 2105);
          com.tencent.mm.ipcinvoker.h.a(com.tencent.mm.plugin.appbrand.dynamic.i.aVi().GW(this.id), (Parcelable)localObject1, f.a.class, null);
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
      localObject2 = (bdq)((c.a)localObject1).gUK;
      label643:
      if (localObject2 == null)
      {
        AppMethodBeat.o(121401);
        return null;
      }
      localObject1 = new ca().iI(u.vd(this.id));
      ((ca)localObject1).dQy = u.vb(this.id);
      ((ca)localObject1).dQv = 3L;
      localObject1 = ((ca)localObject1).iH(this.id);
      ((ca)localObject1).dQw = System.currentTimeMillis();
      ((ca)localObject1).dQx = 1L;
      ((ca)localObject1).iJ(ay.iw(aj.getContext())).aBj();
      localObject1 = ((bdq)localObject2).DAU;
      v.lI(5);
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
      if (bt.isNullOrNil(((bdq)localObject2).url))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
        AppMethodBeat.o(121401);
        return null;
      }
      duo localduo = new duo();
      localObject2 = ((bdq)localObject2).url;
      this.jnm = ((String)localObject2);
      localduo.EIX = ((String)localObject2);
      i = localbb.field_version;
      this.pkgVersion = i;
      localduo.CHC = i;
      localduo.EIV = localbb.field_versionState;
      localduo.EIW = localbb.field_versionMd5;
      ((e)g.ab(e.class)).aOk().a(this.appId, localduo, this.dkC);
    }
    for (;;)
    {
      localObject1 = Hk((String)localObject1);
      if (localObject1 != null)
      {
        if (this.jnh == 1) {
          com.tencent.mm.plugin.report.service.h.vKh.f(14452, new Object[] { this.jko + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
        }
        AppMethodBeat.o(121401);
        return localObject1;
      }
      if (this.jnh == 1) {
        com.tencent.mm.plugin.report.service.h.vKh.f(14452, new Object[] { this.jko + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((this.dkC == 10002) || (this.dkC == 10102))
      {
        localObject1 = ((e)g.ab(e.class)).aOk().El(this.appId);
        if ((localObject1 == null) || (localObject1.length <= 1)) {}
      }
      for (i = j;; i = j)
      {
        localObject2 = this.appId;
        int k = this.dkC;
        j = i + 1;
        localObject2 = WxaPkgIntegrityChecker.C((String)localObject2, k, localObject1[i]);
        if ((localObject2 != null) && (((Pair)localObject2).first == WxaPkgIntegrityChecker.a.iOg) && (((Pair)localObject2).second != null))
        {
          localObject1 = (WxaPkgWrappingInfo)((Pair)localObject2).second;
          AppMethodBeat.o(121401);
          return localObject1;
          if (WxaPkgIntegrityChecker.a.iOg.equals(localPair.first)) {
            break;
          }
          ad.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[] { this.appId, Integer.valueOf(this.dkC), Integer.valueOf(this.pkgVersion), Integer.valueOf(((WxaPkgIntegrityChecker.a)localPair.first).aQs()) });
          break;
        }
        if (j >= localObject1.length)
        {
          a((WxaPkgIntegrityChecker.a)localPair.first);
          AppMethodBeat.o(121401);
          return null;
        }
      }
      label1277:
      localObject1 = null;
      break;
      label1283:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.b
 * JD-Core Version:    0.7.0.1
 */
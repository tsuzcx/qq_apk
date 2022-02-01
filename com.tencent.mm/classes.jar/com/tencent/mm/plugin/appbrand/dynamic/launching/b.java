package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ab;
import com.tencent.mm.an.c.a;
import com.tencent.mm.f.b.a.jw;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.appcache.bq.a;
import com.tencent.mm.plugin.appbrand.appcache.cb;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.protocal.protobuf.cgt;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b
  implements Callable<WxaPkgWrappingInfo>
{
  public static int ojs = 0;
  public static int ojt = 1;
  final String appId;
  final int fES;
  final String id;
  String jQi;
  int ojq;
  volatile String oju;
  String ojv;
  volatile int pkgVersion;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.appId = paramString2;
    this.fES = paramInt1;
    this.pkgVersion = paramInt2;
    this.oju = paramString4;
    this.ojq = paramInt3;
    this.jQi = paramString3;
    this.ojv = paramString5;
  }
  
  private static void a(WxaPkgIntegrityChecker.a parama)
  {
    AppMethodBeat.i(121403);
    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecordError %s", new Object[] { parama.toString() });
    if (WxaPkgIntegrityChecker.a.nHm.equals(parama))
    {
      AppMethodBeat.o(121403);
      return;
    }
    if ((WxaPkgIntegrityChecker.a.nHo.equals(parama)) || (WxaPkgIntegrityChecker.a.nHn.equals(parama)))
    {
      AppMethodBeat.o(121403);
      return;
    }
    AppMethodBeat.o(121403);
  }
  
  private WxaPkgWrappingInfo agp(String paramString)
  {
    AppMethodBeat.i(121402);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final com.tencent.mm.plugin.appbrand.ac.i locali = new com.tencent.mm.plugin.appbrand.ac.i();
    bq.a local1 = new bq.a() {};
    v.rE(7);
    boolean bool;
    if ((this.fES == 10002) || (this.fES == 10102))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.pkgVersion) });
      if (!Util.isNullOrNil(paramString)) {
        bool = cb.a(paramString, this.appId, this.pkgVersion, this.fES, local1);
      }
    }
    while (!bool)
    {
      v.rE(9);
      paramString = new jw().AS(u.SO(this.id));
      paramString.gyo = u.SM(this.id);
      paramString.gLX = 4L;
      paramString = paramString.AR(this.id);
      paramString.gLY = System.currentTimeMillis();
      paramString.gLZ = 2L;
      paramString.AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
      a(WxaPkgIntegrityChecker.a.nHq);
      AppMethodBeat.o(121402);
      return null;
      bool = bq.c(this.appId, this.fES, this.pkgVersion, this.oju, local1);
      continue;
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[] { this.appId, Integer.valueOf(this.fES) });
      if (((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.api.e.class)).bFb() == null)
      {
        Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
        a(WxaPkgIntegrityChecker.a.nHq);
        AppMethodBeat.o(121402);
        return null;
      }
      paramString = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.api.e.class)).bFb().bo(this.appId, this.fES);
      if (Util.isNullOrNil(paramString))
      {
        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
        a(WxaPkgIntegrityChecker.a.nHm);
        AppMethodBeat.o(121402);
        return null;
      }
      bq.c(this.appId, this.fES, 1, paramString, local1);
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
        Log.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", paramString, "tryDownload semaphore exp ", new Object[0]);
      }
    }
  }
  
  public final WxaPkgWrappingInfo bNE()
  {
    int j = 1;
    AppMethodBeat.i(121401);
    Pair localPair = WxaPkgIntegrityChecker.D(this.appId, this.fES, this.pkgVersion);
    Object localObject1;
    if (localPair.second != null)
    {
      com.tencent.mm.plugin.appbrand.dynamic.j.bNj().cb(this.appId, 29);
      localObject1 = (WxaPkgWrappingInfo)localPair.second;
      AppMethodBeat.o(121401);
      return localObject1;
    }
    com.tencent.mm.plugin.appbrand.dynamic.j.bNj().cb(this.appId, 3);
    int i;
    Object localObject2;
    if (WxaPkgIntegrityChecker.a.nHp.equals(localPair.first))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", new Object[] { this.appId, Integer.valueOf(this.fES), Integer.valueOf(this.pkgVersion) });
      if ((this.fES != 10002) && (this.fES != 10102)) {
        break label1264;
      }
      bh localbh = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.api.e.class)).bFb().c(this.appId, this.fES, new String[] { "version", "versionMd5" });
      if (localbh == null)
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
        a((WxaPkgIntegrityChecker.a)localPair.first);
        AppMethodBeat.o(121401);
        return null;
      }
      if (this.fES == 10102)
      {
        i = 2;
        v.rE(4);
        localObject1 = new jw().AS(this.appId);
        ((jw)localObject1).gyo = u.SM(this.id);
        ((jw)localObject1).gLX = 13L;
        localObject1 = ((jw)localObject1).AR(this.id);
        ((jw)localObject1).gLY = System.currentTimeMillis();
        ((jw)localObject1).gLZ = 2L;
        ((jw)localObject1).AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
        if (TextUtils.isEmpty(this.ojv)) {
          break label1258;
        }
        localObject1 = new cgt();
        ((cgt)localObject1).parseFrom(Base64.decode(this.ojv, 0));
        if (!TextUtils.isEmpty(((cgt)localObject1).url)) {
          break label614;
        }
        localObject1 = null;
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label639;
        }
        localObject1 = ab.c(((a)com.tencent.luggage.a.e.K(a.class)).a(this.appId, localbh.field_version, localbh.field_versionMd5, i));
        if ((localObject1 != null) && (((c.a)localObject1).errType == 0) && (((c.a)localObject1).errCode == 0)) {
          break label629;
        }
        v.rE(6);
        localObject1 = new jw().AS(this.appId);
        ((jw)localObject1).gyo = u.SM(this.id);
        ((jw)localObject1).gLX = 3L;
        localObject1 = ((jw)localObject1).AR(this.id);
        ((jw)localObject1).gLY = System.currentTimeMillis();
        ((jw)localObject1).gLZ = 2L;
        ((jw)localObject1).AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
        if ((this.ojq == 1) && (this.id != null) && (this.id.length() > 0))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("id", this.id);
          ((Bundle)localObject1).putInt("widgetState", 2105);
          com.tencent.mm.ipcinvoker.j.a(com.tencent.mm.plugin.appbrand.dynamic.i.bNh().agb(this.id), (Parcelable)localObject1, f.a.class, null);
        }
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail", new Object[0]);
        AppMethodBeat.o(121401);
        return null;
        i = 1;
        break;
        label614:
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "use preload download data", new Object[0]);
      }
      label629:
      localObject2 = (cgt)((c.a)localObject1).lBJ;
      label639:
      if (localObject2 == null)
      {
        AppMethodBeat.o(121401);
        return null;
      }
      localObject1 = new jw().AS(u.SO(this.id));
      ((jw)localObject1).gyo = u.SM(this.id);
      ((jw)localObject1).gLX = 3L;
      localObject1 = ((jw)localObject1).AR(this.id);
      ((jw)localObject1).gLY = System.currentTimeMillis();
      ((jw)localObject1).gLZ = 1L;
      ((jw)localObject1).AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
      localObject1 = ((cgt)localObject2).TnR;
      v.rE(5);
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
      if (Util.isNullOrNil(((cgt)localObject2).url))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
        AppMethodBeat.o(121401);
        return null;
      }
      fnt localfnt = new fnt();
      localObject2 = ((cgt)localObject2).url;
      this.oju = ((String)localObject2);
      localfnt.UMj = ((String)localObject2);
      i = localbh.field_version;
      this.pkgVersion = i;
      localfnt.RTb = i;
      localfnt.UMi = localbh.field_versionMd5;
      ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.api.e.class)).bFb().a(this.appId, localfnt, this.fES);
    }
    for (;;)
    {
      localObject1 = agp((String)localObject1);
      if (localObject1 != null)
      {
        if (this.ojq == 1) {
          com.tencent.mm.plugin.report.service.h.IzE.a(14452, new Object[] { this.jQi + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
        }
        AppMethodBeat.o(121401);
        return localObject1;
      }
      if (this.ojq == 1) {
        com.tencent.mm.plugin.report.service.h.IzE.a(14452, new Object[] { this.jQi + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((this.fES == 10002) || (this.fES == 10102))
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.api.e.class)).bFb().adb(this.appId);
        if ((localObject1 == null) || (localObject1.length <= 1)) {}
      }
      for (i = j;; i = j)
      {
        localObject2 = this.appId;
        int k = this.fES;
        j = i + 1;
        localObject2 = WxaPkgIntegrityChecker.D((String)localObject2, k, localObject1[i]);
        if ((localObject2 != null) && (((Pair)localObject2).first == WxaPkgIntegrityChecker.a.nHl) && (((Pair)localObject2).second != null))
        {
          localObject1 = (WxaPkgWrappingInfo)((Pair)localObject2).second;
          AppMethodBeat.o(121401);
          return localObject1;
          if (WxaPkgIntegrityChecker.a.nHl.equals(localPair.first)) {
            break;
          }
          Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[] { this.appId, Integer.valueOf(this.fES), Integer.valueOf(this.pkgVersion), Integer.valueOf(((WxaPkgIntegrityChecker.a)localPair.first).bHC()) });
          break;
        }
        if (j >= localObject1.length)
        {
          a((WxaPkgIntegrityChecker.a)localPair.first);
          AppMethodBeat.o(121401);
          return null;
        }
      }
      label1258:
      localObject1 = null;
      break;
      label1264:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.b
 * JD-Core Version:    0.7.0.1
 */
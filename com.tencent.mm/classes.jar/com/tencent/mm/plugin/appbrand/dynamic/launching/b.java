package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.kernel.g;
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
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.fcs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b
  implements Callable<WxaPkgWrappingInfo>
{
  public static int loI = 0;
  public static int loJ = 1;
  final String appId;
  final int dMe;
  String hes;
  final String id;
  int loG;
  volatile String loK;
  String loL;
  volatile int pkgVersion;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.appId = paramString2;
    this.dMe = paramInt1;
    this.pkgVersion = paramInt2;
    this.loK = paramString4;
    this.loG = paramInt3;
    this.hes = paramString3;
    this.loL = paramString5;
  }
  
  private WxaPkgWrappingInfo YB(String paramString)
  {
    AppMethodBeat.i(121402);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final com.tencent.mm.plugin.appbrand.ac.i locali = new com.tencent.mm.plugin.appbrand.ac.i();
    bj.a local1 = new bj.a() {};
    v.pl(7);
    boolean bool;
    if ((this.dMe == 10002) || (this.dMe == 10102))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.pkgVersion) });
      if (!Util.isNullOrNil(paramString)) {
        bool = bt.a(paramString, this.appId, this.pkgVersion, this.dMe, local1);
      }
    }
    while (!bool)
    {
      v.pl(9);
      paramString = new hr().vt(u.Lv(this.id));
      paramString.eBS = u.Lt(this.id);
      paramString.eMi = 4L;
      paramString = paramString.vs(this.id);
      paramString.eMj = System.currentTimeMillis();
      paramString.eMk = 2L;
      paramString.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
      a(WxaPkgIntegrityChecker.a.kNq);
      AppMethodBeat.o(121402);
      return null;
      bool = bj.c(this.appId, this.dMe, this.pkgVersion, this.loK, local1);
      continue;
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[] { this.appId, Integer.valueOf(this.dMe) });
      if (((com.tencent.mm.plugin.appbrand.api.e)g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub() == null)
      {
        Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
        a(WxaPkgIntegrityChecker.a.kNq);
        AppMethodBeat.o(121402);
        return null;
      }
      paramString = ((com.tencent.mm.plugin.appbrand.api.e)g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().aX(this.appId, this.dMe);
      if (Util.isNullOrNil(paramString))
      {
        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
        a(WxaPkgIntegrityChecker.a.kNm);
        AppMethodBeat.o(121402);
        return null;
      }
      bj.a(this.appId, this.dMe, paramString, local1);
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
  
  private static void a(WxaPkgIntegrityChecker.a parama)
  {
    AppMethodBeat.i(121403);
    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecordError %s", new Object[] { parama.toString() });
    if (WxaPkgIntegrityChecker.a.kNm.equals(parama))
    {
      AppMethodBeat.o(121403);
      return;
    }
    if ((WxaPkgIntegrityChecker.a.kNo.equals(parama)) || (WxaPkgIntegrityChecker.a.kNn.equals(parama)))
    {
      AppMethodBeat.o(121403);
      return;
    }
    AppMethodBeat.o(121403);
  }
  
  public final WxaPkgWrappingInfo bCi()
  {
    int j = 1;
    AppMethodBeat.i(121401);
    Pair localPair = WxaPkgIntegrityChecker.D(this.appId, this.dMe, this.pkgVersion);
    Object localObject1;
    if (localPair.second != null)
    {
      j.bBN().bG(this.appId, 29);
      localObject1 = (WxaPkgWrappingInfo)localPair.second;
      AppMethodBeat.o(121401);
      return localObject1;
    }
    j.bBN().bG(this.appId, 3);
    int i;
    Object localObject2;
    if (WxaPkgIntegrityChecker.a.kNp.equals(localPair.first))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", new Object[] { this.appId, Integer.valueOf(this.dMe), Integer.valueOf(this.pkgVersion) });
      if ((this.dMe != 10002) && (this.dMe != 10102)) {
        break label1273;
      }
      bd localbd = ((com.tencent.mm.plugin.appbrand.api.e)g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().a(this.appId, this.dMe, new String[] { "version", "versionMd5" });
      if (localbd == null)
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
        a((WxaPkgIntegrityChecker.a)localPair.first);
        AppMethodBeat.o(121401);
        return null;
      }
      if (this.dMe == 10102)
      {
        i = 2;
        v.pl(4);
        localObject1 = new hr().vt(this.appId);
        ((hr)localObject1).eBS = u.Lt(this.id);
        ((hr)localObject1).eMi = 13L;
        localObject1 = ((hr)localObject1).vs(this.id);
        ((hr)localObject1).eMj = System.currentTimeMillis();
        ((hr)localObject1).eMk = 2L;
        ((hr)localObject1).vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
        if (TextUtils.isEmpty(this.loL)) {
          break label1267;
        }
        localObject1 = new byz();
        ((byz)localObject1).parseFrom(Base64.decode(this.loL, 0));
        if (!TextUtils.isEmpty(((byz)localObject1).url)) {
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
        localObject1 = ab.a(((a)com.tencent.luggage.a.e.M(a.class)).a(this.appId, localbd.field_version, localbd.field_versionMd5, i));
        if ((localObject1 != null) && (((c.a)localObject1).errType == 0) && (((c.a)localObject1).errCode == 0)) {
          break label633;
        }
        v.pl(6);
        localObject1 = new hr().vt(this.appId);
        ((hr)localObject1).eBS = u.Lt(this.id);
        ((hr)localObject1).eMi = 3L;
        localObject1 = ((hr)localObject1).vs(this.id);
        ((hr)localObject1).eMj = System.currentTimeMillis();
        ((hr)localObject1).eMk = 2L;
        ((hr)localObject1).vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
        if ((this.loG == 1) && (this.id != null) && (this.id.length() > 0))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("id", this.id);
          ((Bundle)localObject1).putInt("widgetState", 2105);
          com.tencent.mm.ipcinvoker.h.a(com.tencent.mm.plugin.appbrand.dynamic.i.bBL().Yn(this.id), (Parcelable)localObject1, f.a.class, null);
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
      localObject2 = (byz)((c.a)localObject1).iLC;
      label643:
      if (localObject2 == null)
      {
        AppMethodBeat.o(121401);
        return null;
      }
      localObject1 = new hr().vt(u.Lv(this.id));
      ((hr)localObject1).eBS = u.Lt(this.id);
      ((hr)localObject1).eMi = 3L;
      localObject1 = ((hr)localObject1).vs(this.id);
      ((hr)localObject1).eMj = System.currentTimeMillis();
      ((hr)localObject1).eMk = 1L;
      ((hr)localObject1).vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
      localObject1 = ((byz)localObject2).Mep;
      v.pl(5);
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
      if (Util.isNullOrNil(((byz)localObject2).url))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
        AppMethodBeat.o(121401);
        return null;
      }
      fcs localfcs = new fcs();
      localObject2 = ((byz)localObject2).url;
      this.loK = ((String)localObject2);
      localfcs.NyF = ((String)localObject2);
      i = localbd.field_version;
      this.pkgVersion = i;
      localfcs.KSa = i;
      localfcs.NyE = localbd.field_versionMd5;
      ((com.tencent.mm.plugin.appbrand.api.e)g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().a(this.appId, localfcs, this.dMe);
    }
    for (;;)
    {
      localObject1 = YB((String)localObject1);
      if (localObject1 != null)
      {
        if (this.loG == 1) {
          com.tencent.mm.plugin.report.service.h.CyF.a(14452, new Object[] { this.hes + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
        }
        AppMethodBeat.o(121401);
        return localObject1;
      }
      if (this.loG == 1) {
        com.tencent.mm.plugin.report.service.h.CyF.a(14452, new Object[] { this.hes + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((this.dMe == 10002) || (this.dMe == 10102))
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.api.e)g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().Vs(this.appId);
        if ((localObject1 == null) || (localObject1.length <= 1)) {}
      }
      for (i = j;; i = j)
      {
        localObject2 = this.appId;
        int k = this.dMe;
        j = i + 1;
        localObject2 = WxaPkgIntegrityChecker.D((String)localObject2, k, localObject1[i]);
        if ((localObject2 != null) && (((Pair)localObject2).first == WxaPkgIntegrityChecker.a.kNl) && (((Pair)localObject2).second != null))
        {
          localObject1 = (WxaPkgWrappingInfo)((Pair)localObject2).second;
          AppMethodBeat.o(121401);
          return localObject1;
          if (WxaPkgIntegrityChecker.a.kNl.equals(localPair.first)) {
            break;
          }
          Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[] { this.appId, Integer.valueOf(this.dMe), Integer.valueOf(this.pkgVersion), Integer.valueOf(((WxaPkgIntegrityChecker.a)localPair.first).bwv()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.b
 * JD-Core Version:    0.7.0.1
 */
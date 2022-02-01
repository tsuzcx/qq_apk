package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.aa;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.mmdata.rpt.mn;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.appcache.bq.a;
import com.tencent.mm.plugin.appbrand.appcache.ca;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.protocal.protobuf.gks;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b
  implements Callable<WxaPkgWrappingInfo>
{
  public static int rmU = 0;
  public static int rmV = 1;
  final String appId;
  final int hJK;
  final String id;
  String mpa;
  volatile int pkgVersion;
  int rmS;
  volatile String rmW;
  String rmX;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.appId = paramString2;
    this.hJK = paramInt1;
    this.pkgVersion = paramInt2;
    this.rmW = paramString4;
    this.rmS = paramInt3;
    this.mpa = paramString3;
    this.rmX = paramString5;
  }
  
  private WxaPkgWrappingInfo Zl(String paramString)
  {
    AppMethodBeat.i(121402);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final k localk = new k();
    bq.a local1 = new bq.a() {};
    v.rG(7);
    boolean bool;
    if ((this.hJK == 10002) || (this.hJK == 10102))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.pkgVersion) });
      if (!Util.isNullOrNil(paramString)) {
        bool = ca.a(paramString, this.appId, this.pkgVersion, this.hJK, local1);
      }
    }
    while (!bool)
    {
      v.rG(9);
      paramString = new mn().uY(u.KQ(this.id));
      paramString.iKD = u.KO(this.id);
      paramString.jbJ = 4L;
      paramString = paramString.uX(this.id);
      paramString.jbK = System.currentTimeMillis();
      paramString.jbL = 2L;
      paramString.uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
      a(WxaPkgIntegrityChecker.a.qHd);
      AppMethodBeat.o(121402);
      return null;
      bool = bq.a(this.appId, this.hJK, this.pkgVersion, this.rmW, local1);
      continue;
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[] { this.appId, Integer.valueOf(this.hJK) });
      if (((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo() == null)
      {
        Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
        a(WxaPkgIntegrityChecker.a.qHd);
        AppMethodBeat.o(121402);
        return null;
      }
      paramString = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo().bF(this.appId, this.hJK);
      if (Util.isNullOrNil(paramString))
      {
        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
        a(WxaPkgIntegrityChecker.a.qGZ);
        AppMethodBeat.o(121402);
        return null;
      }
      bq.a(this.appId, this.hJK, 1, paramString, local1);
    }
    try
    {
      localCountDownLatch.await();
      paramString = (WxaPkgWrappingInfo)localk.value;
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
    if (WxaPkgIntegrityChecker.a.qGZ.equals(parama))
    {
      AppMethodBeat.o(121403);
      return;
    }
    if ((WxaPkgIntegrityChecker.a.qHb.equals(parama)) || (WxaPkgIntegrityChecker.a.qHa.equals(parama)))
    {
      AppMethodBeat.o(121403);
      return;
    }
    AppMethodBeat.o(121403);
  }
  
  public final WxaPkgWrappingInfo cnT()
  {
    int j = 1;
    AppMethodBeat.i(121401);
    Pair localPair = WxaPkgIntegrityChecker.H(this.appId, this.hJK, this.pkgVersion);
    Object localObject1;
    if (localPair.second != null)
    {
      com.tencent.mm.plugin.appbrand.dynamic.j.cny().cy(this.appId, 29);
      localObject1 = (WxaPkgWrappingInfo)localPair.second;
      AppMethodBeat.o(121401);
      return localObject1;
    }
    com.tencent.mm.plugin.appbrand.dynamic.j.cny().cy(this.appId, 3);
    int i;
    Object localObject2;
    if (WxaPkgIntegrityChecker.a.qHc.equals(localPair.first))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", new Object[] { this.appId, Integer.valueOf(this.hJK), Integer.valueOf(this.pkgVersion) });
      if ((this.hJK != 10002) && (this.hJK != 10102)) {
        break label1273;
      }
      bh localbh = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo().c(this.appId, this.hJK, new String[] { "version", "versionMd5" });
      if (localbh == null)
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
        a((WxaPkgIntegrityChecker.a)localPair.first);
        AppMethodBeat.o(121401);
        return null;
      }
      if (this.hJK == 10102)
      {
        i = 2;
        v.rG(4);
        localObject1 = new mn().uY(this.appId);
        ((mn)localObject1).iKD = u.KO(this.id);
        ((mn)localObject1).jbJ = 13L;
        localObject1 = ((mn)localObject1).uX(this.id);
        ((mn)localObject1).jbK = System.currentTimeMillis();
        ((mn)localObject1).jbL = 2L;
        ((mn)localObject1).uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
        if (TextUtils.isEmpty(this.rmX)) {
          break label1267;
        }
        localObject1 = new cwu();
        ((cwu)localObject1).parseFrom(Base64.decode(this.rmX, 0));
        if (!TextUtils.isEmpty(((cwu)localObject1).url)) {
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
        localObject1 = aa.c(((a)com.tencent.luggage.a.e.T(a.class)).a(this.appId, localbh.field_version, localbh.field_versionMd5, i));
        if ((localObject1 != null) && (((b.a)localObject1).errType == 0) && (((b.a)localObject1).errCode == 0)) {
          break label633;
        }
        v.rG(6);
        localObject1 = new mn().uY(this.appId);
        ((mn)localObject1).iKD = u.KO(this.id);
        ((mn)localObject1).jbJ = 3L;
        localObject1 = ((mn)localObject1).uX(this.id);
        ((mn)localObject1).jbK = System.currentTimeMillis();
        ((mn)localObject1).jbL = 2L;
        ((mn)localObject1).uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
        if ((this.rmS == 1) && (this.id != null) && (this.id.length() > 0))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("id", this.id);
          ((Bundle)localObject1).putInt("widgetState", 2105);
          com.tencent.mm.ipcinvoker.j.a(i.cnw().YX(this.id), (Parcelable)localObject1, f.a.class, null);
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
      localObject2 = (cwu)((b.a)localObject1).ott;
      label643:
      if (localObject2 == null)
      {
        AppMethodBeat.o(121401);
        return null;
      }
      localObject1 = new mn().uY(u.KQ(this.id));
      ((mn)localObject1).iKD = u.KO(this.id);
      ((mn)localObject1).jbJ = 3L;
      localObject1 = ((mn)localObject1).uX(this.id);
      ((mn)localObject1).jbK = System.currentTimeMillis();
      ((mn)localObject1).jbL = 1L;
      ((mn)localObject1).uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
      localObject1 = ((cwu)localObject2).aaBY;
      v.rG(5);
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
      if (Util.isNullOrNil(((cwu)localObject2).url))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
        AppMethodBeat.o(121401);
        return null;
      }
      gks localgks = new gks();
      localObject2 = ((cwu)localObject2).url;
      this.rmW = ((String)localObject2);
      localgks.acgD = ((String)localObject2);
      i = localbh.field_version;
      this.pkgVersion = i;
      localgks.YQB = i;
      localgks.acgC = localbh.field_versionMd5;
      ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo().a(this.appId, localgks, this.hJK);
    }
    for (;;)
    {
      localObject1 = Zl((String)localObject1);
      if (localObject1 != null)
      {
        if (this.rmS == 1) {
          com.tencent.mm.plugin.report.service.h.OAn.b(14452, new Object[] { this.mpa + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
        }
        AppMethodBeat.o(121401);
        return localObject1;
      }
      if (this.rmS == 1) {
        com.tencent.mm.plugin.report.service.h.OAn.b(14452, new Object[] { this.mpa + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((this.hJK == 10002) || (this.hJK == 10102))
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo().Vy(this.appId);
        if ((localObject1 == null) || (localObject1.length <= 1)) {}
      }
      for (i = j;; i = j)
      {
        localObject2 = this.appId;
        int k = this.hJK;
        j = i + 1;
        localObject2 = WxaPkgIntegrityChecker.H((String)localObject2, k, localObject1[i]);
        if ((localObject2 != null) && (((Pair)localObject2).first == WxaPkgIntegrityChecker.a.qGY) && (((Pair)localObject2).second != null))
        {
          localObject1 = (WxaPkgWrappingInfo)((Pair)localObject2).second;
          AppMethodBeat.o(121401);
          return localObject1;
          if (WxaPkgIntegrityChecker.a.qGY.equals(localPair.first)) {
            break;
          }
          Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[] { this.appId, Integer.valueOf(this.hJK), Integer.valueOf(this.pkgVersion), Integer.valueOf(((WxaPkgIntegrityChecker.a)localPair.first).cgZ()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.b
 * JD-Core Version:    0.7.0.1
 */
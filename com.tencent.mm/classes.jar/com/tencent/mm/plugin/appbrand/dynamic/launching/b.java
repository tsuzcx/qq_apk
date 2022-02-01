package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.g.b.a.do;
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
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b
  implements Callable<WxaPkgWrappingInfo>
{
  public static int jNw = 0;
  public static int jNx = 1;
  final String appId;
  final int dib;
  final String id;
  String jKB;
  int jNu;
  volatile String jNy;
  String jNz;
  volatile int pkgVersion;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.appId = paramString2;
    this.dib = paramInt1;
    this.pkgVersion = paramInt2;
    this.jNy = paramString4;
    this.jNu = paramInt3;
    this.jKB = paramString3;
    this.jNz = paramString5;
  }
  
  private WxaPkgWrappingInfo Lo(String paramString)
  {
    AppMethodBeat.i(121402);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
    bh.a local1 = new bh.a() {};
    v.lA(7);
    boolean bool;
    if ((this.dib == 10002) || (this.dib == 10102))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.pkgVersion) });
      if (!bs.isNullOrNil(paramString)) {
        bool = bp.a(paramString, this.appId, this.pkgVersion, this.dib, local1);
      }
    }
    while (!bool)
    {
      v.lA(9);
      paramString = new do().ly(u.zj(this.id));
      paramString.dSn = u.zh(this.id);
      paramString.dSk = 4L;
      paramString = paramString.lx(this.id);
      paramString.dSl = System.currentTimeMillis();
      paramString.dSm = 2L;
      paramString.lz(ax.iH(ai.getContext())).aHZ();
      a(WxaPkgIntegrityChecker.a.jou);
      AppMethodBeat.o(121402);
      return null;
      bool = bh.b(this.appId, this.dib, this.pkgVersion, this.jNy, local1);
      continue;
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[] { this.appId, Integer.valueOf(this.dib) });
      if (((e)g.ab(e.class)).aVa() == null)
      {
        ac.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
        a(WxaPkgIntegrityChecker.a.jou);
        AppMethodBeat.o(121402);
        return null;
      }
      paramString = ((e)g.ab(e.class)).aVa().aN(this.appId, this.dib);
      if (bs.isNullOrNil(paramString))
      {
        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
        a(WxaPkgIntegrityChecker.a.joq);
        AppMethodBeat.o(121402);
        return null;
      }
      bh.a(this.appId, this.dib, paramString, local1);
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
        ac.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", paramString, "tryDownload semaphore exp ", new Object[0]);
      }
    }
  }
  
  private static void a(WxaPkgIntegrityChecker.a parama)
  {
    AppMethodBeat.i(121403);
    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecordError %s", new Object[] { parama.toString() });
    if (WxaPkgIntegrityChecker.a.joq.equals(parama))
    {
      AppMethodBeat.o(121403);
      return;
    }
    if ((WxaPkgIntegrityChecker.a.jos.equals(parama)) || (WxaPkgIntegrityChecker.a.jor.equals(parama)))
    {
      AppMethodBeat.o(121403);
      return;
    }
    AppMethodBeat.o(121403);
  }
  
  public final WxaPkgWrappingInfo bcD()
  {
    int j = 1;
    AppMethodBeat.i(121401);
    Pair localPair = WxaPkgIntegrityChecker.B(this.appId, this.dib, this.pkgVersion);
    Object localObject1;
    if (localPair.second != null)
    {
      j.bci().bw(this.appId, 29);
      localObject1 = (WxaPkgWrappingInfo)localPair.second;
      AppMethodBeat.o(121401);
      return localObject1;
    }
    j.bci().bw(this.appId, 3);
    int i;
    Object localObject2;
    if (WxaPkgIntegrityChecker.a.jot.equals(localPair.first))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", new Object[] { this.appId, Integer.valueOf(this.dib), Integer.valueOf(this.pkgVersion) });
      if ((this.dib != 10002) && (this.dib != 10102)) {
        break label1267;
      }
      bb localbb = ((e)g.ab(e.class)).aVa().a(this.appId, this.dib, new String[] { "version", "versionMd5" });
      if (localbb == null)
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
        a((WxaPkgIntegrityChecker.a)localPair.first);
        AppMethodBeat.o(121401);
        return null;
      }
      if (this.dib == 10102)
      {
        i = 2;
        v.lA(4);
        localObject1 = new do().ly(this.appId);
        ((do)localObject1).dSn = u.zh(this.id);
        ((do)localObject1).dSk = 13L;
        localObject1 = ((do)localObject1).lx(this.id);
        ((do)localObject1).dSl = System.currentTimeMillis();
        ((do)localObject1).dSm = 2L;
        ((do)localObject1).lz(ax.iH(ai.getContext())).aHZ();
        if (TextUtils.isEmpty(this.jNz)) {
          break label1261;
        }
        localObject1 = new bhi();
        ((bhi)localObject1).parseFrom(Base64.decode(this.jNz, 0));
        if (!TextUtils.isEmpty(((bhi)localObject1).url)) {
          break label612;
        }
        localObject1 = null;
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label637;
        }
        localObject1 = y.a(new com.tencent.mm.plugin.appbrand.appcache.h(this.appId, localbb.field_version, localbb.field_versionMd5, i, (byte)0));
        if ((localObject1 != null) && (((c.a)localObject1).errType == 0) && (((c.a)localObject1).errCode == 0)) {
          break label627;
        }
        v.lA(6);
        localObject1 = new do().ly(this.appId);
        ((do)localObject1).dSn = u.zh(this.id);
        ((do)localObject1).dSk = 3L;
        localObject1 = ((do)localObject1).lx(this.id);
        ((do)localObject1).dSl = System.currentTimeMillis();
        ((do)localObject1).dSm = 2L;
        ((do)localObject1).lz(ax.iH(ai.getContext())).aHZ();
        if ((this.jNu == 1) && (this.id != null) && (this.id.length() > 0))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("id", this.id);
          ((Bundle)localObject1).putInt("widgetState", 2105);
          com.tencent.mm.ipcinvoker.h.a(com.tencent.mm.plugin.appbrand.dynamic.i.bcg().La(this.id), (Parcelable)localObject1, f.a.class, null);
        }
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail", new Object[0]);
        AppMethodBeat.o(121401);
        return null;
        i = 1;
        break;
        label612:
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "use preload download data", new Object[0]);
      }
      label627:
      localObject2 = (bhi)((c.a)localObject1).hvj;
      label637:
      if (localObject2 == null)
      {
        AppMethodBeat.o(121401);
        return null;
      }
      localObject1 = new do().ly(u.zj(this.id));
      ((do)localObject1).dSn = u.zh(this.id);
      ((do)localObject1).dSk = 3L;
      localObject1 = ((do)localObject1).lx(this.id);
      ((do)localObject1).dSl = System.currentTimeMillis();
      ((do)localObject1).dSm = 1L;
      ((do)localObject1).lz(ax.iH(ai.getContext())).aHZ();
      localObject1 = ((bhi)localObject2).EWq;
      v.lA(5);
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
      if (bs.isNullOrNil(((bhi)localObject2).url))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
        AppMethodBeat.o(121401);
        return null;
      }
      eaf localeaf = new eaf();
      localObject2 = ((bhi)localObject2).url;
      this.jNy = ((String)localObject2);
      localeaf.Ggj = ((String)localObject2);
      i = localbb.field_version;
      this.pkgVersion = i;
      localeaf.Eae = i;
      localeaf.Ggi = localbb.field_versionMd5;
      ((e)g.ab(e.class)).aVa().a(this.appId, localeaf, this.dib);
    }
    for (;;)
    {
      localObject1 = Lo((String)localObject1);
      if (localObject1 != null)
      {
        if (this.jNu == 1) {
          com.tencent.mm.plugin.report.service.h.wUl.f(14452, new Object[] { this.jKB + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
        }
        AppMethodBeat.o(121401);
        return localObject1;
      }
      if (this.jNu == 1) {
        com.tencent.mm.plugin.report.service.h.wUl.f(14452, new Object[] { this.jKB + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((this.dib == 10002) || (this.dib == 10102))
      {
        localObject1 = ((e)g.ab(e.class)).aVa().Io(this.appId);
        if ((localObject1 == null) || (localObject1.length <= 1)) {}
      }
      for (i = j;; i = j)
      {
        localObject2 = this.appId;
        int k = this.dib;
        j = i + 1;
        localObject2 = WxaPkgIntegrityChecker.B((String)localObject2, k, localObject1[i]);
        if ((localObject2 != null) && (((Pair)localObject2).first == WxaPkgIntegrityChecker.a.jop) && (((Pair)localObject2).second != null))
        {
          localObject1 = (WxaPkgWrappingInfo)((Pair)localObject2).second;
          AppMethodBeat.o(121401);
          return localObject1;
          if (WxaPkgIntegrityChecker.a.jop.equals(localPair.first)) {
            break;
          }
          ac.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[] { this.appId, Integer.valueOf(this.dib), Integer.valueOf(this.pkgVersion), Integer.valueOf(((WxaPkgIntegrityChecker.a)localPair.first).aXk()) });
          break;
        }
        if (j >= localObject1.length)
        {
          a((WxaPkgIntegrityChecker.a)localPair.first);
          AppMethodBeat.o(121401);
          return null;
        }
      }
      label1261:
      localObject1 = null;
      break;
      label1267:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.b
 * JD-Core Version:    0.7.0.1
 */
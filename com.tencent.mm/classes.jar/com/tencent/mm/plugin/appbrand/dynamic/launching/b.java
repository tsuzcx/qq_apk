package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.y;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.plugin.appbrand.appcache.bi.a;
import com.tencent.mm.plugin.appbrand.appcache.br;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b
  implements Callable<WxaPkgWrappingInfo>
{
  public static int khH = 0;
  public static int khI = 1;
  final String appId;
  final int dtF;
  final String id;
  String keN;
  int khF;
  volatile String khJ;
  String khK;
  volatile int pkgVersion;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.appId = paramString2;
    this.dtF = paramInt1;
    this.pkgVersion = paramInt2;
    this.khJ = paramString4;
    this.khF = paramInt3;
    this.keN = paramString3;
    this.khK = paramString5;
  }
  
  private WxaPkgWrappingInfo OI(String paramString)
  {
    AppMethodBeat.i(121402);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
    bi.a local1 = new bi.a() {};
    v.ma(7);
    boolean bool;
    if ((this.dtF == 10002) || (this.dtF == 10102))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.pkgVersion) });
      if (!bt.isNullOrNil(paramString)) {
        bool = br.a(paramString, this.appId, this.pkgVersion, this.dtF, local1);
      }
    }
    while (!bool)
    {
      v.ma(9);
      paramString = new ej().nF(u.Ci(this.id));
      paramString.ehS = u.Cg(this.id);
      paramString.ehP = 4L;
      paramString = paramString.nE(this.id);
      paramString.ehQ = System.currentTimeMillis();
      paramString.ehR = 2L;
      paramString.nG(ay.iR(aj.getContext())).aLk();
      a(WxaPkgIntegrityChecker.a.jIq);
      AppMethodBeat.o(121402);
      return null;
      bool = bi.b(this.appId, this.dtF, this.pkgVersion, this.khJ, local1);
      continue;
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[] { this.appId, Integer.valueOf(this.dtF) });
      if (((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu() == null)
      {
        ad.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
        a(WxaPkgIntegrityChecker.a.jIq);
        AppMethodBeat.o(121402);
        return null;
      }
      paramString = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu().aP(this.appId, this.dtF);
      if (bt.isNullOrNil(paramString))
      {
        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
        a(WxaPkgIntegrityChecker.a.jIm);
        AppMethodBeat.o(121402);
        return null;
      }
      bi.a(this.appId, this.dtF, paramString, local1);
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
    if (WxaPkgIntegrityChecker.a.jIm.equals(parama))
    {
      AppMethodBeat.o(121403);
      return;
    }
    if ((WxaPkgIntegrityChecker.a.jIo.equals(parama)) || (WxaPkgIntegrityChecker.a.jIn.equals(parama)))
    {
      AppMethodBeat.o(121403);
      return;
    }
    AppMethodBeat.o(121403);
  }
  
  public final WxaPkgWrappingInfo bgh()
  {
    int j = 1;
    AppMethodBeat.i(121401);
    Pair localPair = WxaPkgIntegrityChecker.D(this.appId, this.dtF, this.pkgVersion);
    Object localObject1;
    if (localPair.second != null)
    {
      j.bfM().by(this.appId, 29);
      localObject1 = (WxaPkgWrappingInfo)localPair.second;
      AppMethodBeat.o(121401);
      return localObject1;
    }
    j.bfM().by(this.appId, 3);
    int i;
    Object localObject2;
    if (WxaPkgIntegrityChecker.a.jIp.equals(localPair.first))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", new Object[] { this.appId, Integer.valueOf(this.dtF), Integer.valueOf(this.pkgVersion) });
      if ((this.dtF != 10002) && (this.dtF != 10102)) {
        break label1273;
      }
      bc localbc = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu().a(this.appId, this.dtF, new String[] { "version", "versionMd5" });
      if (localbc == null)
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
        a((WxaPkgIntegrityChecker.a)localPair.first);
        AppMethodBeat.o(121401);
        return null;
      }
      if (this.dtF == 10102)
      {
        i = 2;
        v.ma(4);
        localObject1 = new ej().nF(this.appId);
        ((ej)localObject1).ehS = u.Cg(this.id);
        ((ej)localObject1).ehP = 13L;
        localObject1 = ((ej)localObject1).nE(this.id);
        ((ej)localObject1).ehQ = System.currentTimeMillis();
        ((ej)localObject1).ehR = 2L;
        ((ej)localObject1).nG(ay.iR(aj.getContext())).aLk();
        if (TextUtils.isEmpty(this.khK)) {
          break label1267;
        }
        localObject1 = new blq();
        ((blq)localObject1).parseFrom(Base64.decode(this.khK, 0));
        if (!TextUtils.isEmpty(((blq)localObject1).url)) {
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
        localObject1 = y.a(((a)com.tencent.luggage.a.e.K(a.class)).a(this.appId, localbc.field_version, localbc.field_versionMd5, i));
        if ((localObject1 != null) && (((a.a)localObject1).errType == 0) && (((a.a)localObject1).errCode == 0)) {
          break label633;
        }
        v.ma(6);
        localObject1 = new ej().nF(this.appId);
        ((ej)localObject1).ehS = u.Cg(this.id);
        ((ej)localObject1).ehP = 3L;
        localObject1 = ((ej)localObject1).nE(this.id);
        ((ej)localObject1).ehQ = System.currentTimeMillis();
        ((ej)localObject1).ehR = 2L;
        ((ej)localObject1).nG(ay.iR(aj.getContext())).aLk();
        if ((this.khF == 1) && (this.id != null) && (this.id.length() > 0))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("id", this.id);
          ((Bundle)localObject1).putInt("widgetState", 2105);
          h.a(com.tencent.mm.plugin.appbrand.dynamic.i.bfK().Ou(this.id), (Parcelable)localObject1, f.a.class, null);
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
      localObject2 = (blq)((a.a)localObject1).hNC;
      label643:
      if (localObject2 == null)
      {
        AppMethodBeat.o(121401);
        return null;
      }
      localObject1 = new ej().nF(u.Ci(this.id));
      ((ej)localObject1).ehS = u.Cg(this.id);
      ((ej)localObject1).ehP = 3L;
      localObject1 = ((ej)localObject1).nE(this.id);
      ((ej)localObject1).ehQ = System.currentTimeMillis();
      ((ej)localObject1).ehR = 1L;
      ((ej)localObject1).nG(ay.iR(aj.getContext())).aLk();
      localObject1 = ((blq)localObject2).GFN;
      v.ma(5);
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
      if (bt.isNullOrNil(((blq)localObject2).url))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
        AppMethodBeat.o(121401);
        return null;
      }
      egj localegj = new egj();
      localObject2 = ((blq)localObject2).url;
      this.khJ = ((String)localObject2);
      localegj.HRw = ((String)localObject2);
      i = localbc.field_version;
      this.pkgVersion = i;
      localegj.FFN = i;
      localegj.HRv = localbc.field_versionMd5;
      ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu().a(this.appId, localegj, this.dtF);
    }
    for (;;)
    {
      localObject1 = OI((String)localObject1);
      if (localObject1 != null)
      {
        if (this.khF == 1) {
          com.tencent.mm.plugin.report.service.g.yhR.f(14452, new Object[] { this.keN + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
        }
        AppMethodBeat.o(121401);
        return localObject1;
      }
      if (this.khF == 1) {
        com.tencent.mm.plugin.report.service.g.yhR.f(14452, new Object[] { this.keN + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((this.dtF == 10002) || (this.dtF == 10102))
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu().LG(this.appId);
        if ((localObject1 == null) || (localObject1.length <= 1)) {}
      }
      for (i = j;; i = j)
      {
        localObject2 = this.appId;
        int k = this.dtF;
        j = i + 1;
        localObject2 = WxaPkgIntegrityChecker.D((String)localObject2, k, localObject1[i]);
        if ((localObject2 != null) && (((Pair)localObject2).first == WxaPkgIntegrityChecker.a.jIl) && (((Pair)localObject2).second != null))
        {
          localObject1 = (WxaPkgWrappingInfo)((Pair)localObject2).second;
          AppMethodBeat.o(121401);
          return localObject1;
          if (WxaPkgIntegrityChecker.a.jIl.equals(localPair.first)) {
            break;
          }
          ad.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[] { this.appId, Integer.valueOf(this.dtF), Integer.valueOf(this.pkgVersion), Integer.valueOf(((WxaPkgIntegrityChecker.a)localPair.first).baI()) });
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
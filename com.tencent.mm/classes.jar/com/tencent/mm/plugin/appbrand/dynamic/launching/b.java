package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.x;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.as.a;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.ba.a;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b
  implements Callable<WxaPkgWrappingInfo>
{
  public static int hqb = 0;
  public static int hqc = 1;
  final String appId;
  final int cvs;
  volatile int gXf;
  String hng;
  int hpZ;
  volatile String hqd;
  String hqe;
  final String id;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.appId = paramString2;
    this.cvs = paramInt1;
    this.gXf = paramInt2;
    this.hqd = paramString4;
    this.hpZ = paramInt3;
    this.hng = paramString3;
    this.hqe = paramString5;
  }
  
  private WxaPkgWrappingInfo Bm(String paramString)
  {
    AppMethodBeat.i(10921);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
    ba.a local1 = new ba.a() {};
    v.kS(7);
    boolean bool;
    if ((this.cvs == 10002) || (this.cvs == 10102))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.gXf) });
      if (!bo.isNullOrNil(paramString)) {
        bool = be.a(paramString, this.appId, this.gXf, this.cvs, local1);
      }
    }
    while (!bool)
    {
      v.kS(9);
      paramString = new af().fB(u.qn(this.id));
      paramString.cUl = u.qm(this.id);
      paramString.cUh = 4L;
      paramString = paramString.fA(this.id);
      paramString.cUi = System.currentTimeMillis();
      paramString.cUj = 2L;
      paramString.fC(com.tencent.mm.sdk.platformtools.at.gU(ah.getContext())).ake();
      a(as.a.gWx);
      AppMethodBeat.o(10921);
      return null;
      bool = ba.b(this.appId, this.cvs, this.gXf, this.hqd, local1);
      continue;
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[] { this.appId, Integer.valueOf(this.cvs) });
      if (((com.tencent.mm.plugin.appbrand.a.d)g.E(com.tencent.mm.plugin.appbrand.a.d.class)).we() == null)
      {
        ab.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
        a(as.a.gWx);
        AppMethodBeat.o(10921);
        return null;
      }
      paramString = ((com.tencent.mm.plugin.appbrand.a.d)g.E(com.tencent.mm.plugin.appbrand.a.d.class)).we().au(this.appId, this.cvs);
      if (bo.isNullOrNil(paramString))
      {
        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
        a(as.a.gWt);
        AppMethodBeat.o(10921);
        return null;
      }
      ba.a(this.appId, this.cvs, paramString, local1);
    }
    try
    {
      localCountDownLatch.await();
      paramString = (WxaPkgWrappingInfo)localj.value;
      AppMethodBeat.o(10921);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", paramString, "tryDownload semaphore exp ", new Object[0]);
      }
    }
  }
  
  private static void a(as.a parama)
  {
    AppMethodBeat.i(10922);
    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecordError %s", new Object[] { parama.toString() });
    if (as.a.gWt.equals(parama))
    {
      AppMethodBeat.o(10922);
      return;
    }
    if ((as.a.gWv.equals(parama)) || (as.a.gWu.equals(parama)))
    {
      AppMethodBeat.o(10922);
      return;
    }
    AppMethodBeat.o(10922);
  }
  
  public final WxaPkgWrappingInfo azY()
  {
    int j = 1;
    AppMethodBeat.i(10920);
    Pair localPair = as.F(this.appId, this.cvs, this.gXf);
    if (localPair.second != null)
    {
      com.tencent.mm.plugin.appbrand.dynamic.j.azD().ba(this.appId, 29);
      localObject1 = (WxaPkgWrappingInfo)localPair.second;
      AppMethodBeat.o(10920);
      return localObject1;
    }
    com.tencent.mm.plugin.appbrand.dynamic.j.azD().ba(this.appId, 3);
    int i;
    label613:
    label638:
    Object localObject2;
    if (as.a.gWw.equals(localPair.first))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", new Object[] { this.appId, Integer.valueOf(this.cvs), Integer.valueOf(this.gXf) });
      if ((this.cvs != 10002) && (this.cvs != 10102)) {
        break label1285;
      }
      com.tencent.mm.plugin.appbrand.appcache.at localat = ((com.tencent.mm.plugin.appbrand.a.d)g.E(com.tencent.mm.plugin.appbrand.a.d.class)).we().a(this.appId, this.cvs, new String[] { "version", "versionMd5", "versionState" });
      if (localat == null)
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
        a((as.a)localPair.first);
        AppMethodBeat.o(10920);
        return null;
      }
      if (this.cvs == 10102)
      {
        i = 2;
        v.kS(4);
        localObject1 = new af().fB(this.appId);
        ((af)localObject1).cUl = u.qm(this.id);
        ((af)localObject1).cUh = 13L;
        localObject1 = ((af)localObject1).fA(this.id);
        ((af)localObject1).cUi = System.currentTimeMillis();
        ((af)localObject1).cUj = 2L;
        ((af)localObject1).fC(com.tencent.mm.sdk.platformtools.at.gU(ah.getContext())).ake();
        if (TextUtils.isEmpty(this.hqe)) {
          break label1279;
        }
        localObject1 = new ast();
        ((ast)localObject1).parseFrom(Base64.decode(this.hqe, 0));
        if (!TextUtils.isEmpty(((ast)localObject1).url)) {
          break label613;
        }
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          localObject1 = x.a(new com.tencent.mm.plugin.appbrand.appcache.d(this.appId, localat.field_version, localat.field_versionMd5, i));
          if ((localObject1 == null) || (((a.a)localObject1).errType != 0) || (((a.a)localObject1).errCode != 0))
          {
            v.kS(6);
            localObject1 = new af().fB(this.appId);
            ((af)localObject1).cUl = u.qm(this.id);
            ((af)localObject1).cUh = 3L;
            localObject1 = ((af)localObject1).fA(this.id);
            ((af)localObject1).cUi = System.currentTimeMillis();
            ((af)localObject1).cUj = 2L;
            ((af)localObject1).fC(com.tencent.mm.sdk.platformtools.at.gU(ah.getContext())).ake();
            if ((this.hpZ == 1) && (this.id != null) && (this.id.length() > 0))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("id", this.id);
              ((Bundle)localObject1).putInt("widgetState", 2105);
              f.a(i.azB().AY(this.id), (Parcelable)localObject1, f.a.class, null);
            }
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail", new Object[0]);
            AppMethodBeat.o(10920);
            return null;
            i = 1;
            break;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "use preload download data", new Object[0]);
            continue;
          }
          localObject1 = (ast)((a.a)localObject1).fsN;
          if (localObject1 == null)
          {
            AppMethodBeat.o(10920);
            return null;
          }
          localObject2 = new af().fB(u.qn(this.id));
          ((af)localObject2).cUl = u.qm(this.id);
          ((af)localObject2).cUh = 3L;
          localObject2 = ((af)localObject2).fA(this.id);
          ((af)localObject2).cUi = System.currentTimeMillis();
          ((af)localObject2).cUj = 1L;
          ((af)localObject2).fC(com.tencent.mm.sdk.platformtools.at.gU(ah.getContext())).ake();
          localObject2 = ((ast)localObject1).xhL;
          v.kS(5);
          u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
          if (bo.isNullOrNil(((ast)localObject1).url))
          {
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
            AppMethodBeat.o(10920);
            return null;
          }
          czy localczy = new czy();
          localObject1 = ((ast)localObject1).url;
          this.hqd = ((String)localObject1);
          localczy.ygH = ((String)localObject1);
          i = localat.field_version;
          this.gXf = i;
          localczy.wwX = i;
          localczy.ygF = localat.field_versionState;
          localczy.ygG = localat.field_versionMd5;
          ((com.tencent.mm.plugin.appbrand.a.d)g.E(com.tencent.mm.plugin.appbrand.a.d.class)).we().a(this.appId, localczy, this.cvs);
        }
      }
    }
    label1285:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject1 = Bm((String)localObject1);
      if (localObject1 != null)
      {
        if (this.hpZ == 1) {
          h.qsU.e(14452, new Object[] { this.hng + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
        }
        AppMethodBeat.o(10920);
        return localObject1;
      }
      if (this.hpZ == 1) {
        h.qsU.e(14452, new Object[] { this.hng + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
      }
      if ((this.cvs == 10002) || (this.cvs == 10102))
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.a.d)g.E(com.tencent.mm.plugin.appbrand.a.d.class)).we().yE(this.appId);
        if ((localObject1 == null) || (localObject1.length <= 1)) {}
      }
      for (i = j;; i = j)
      {
        localObject2 = this.appId;
        int k = this.cvs;
        j = i + 1;
        localObject2 = as.F((String)localObject2, k, localObject1[i]);
        if ((localObject2 != null) && (((Pair)localObject2).first == as.a.gWs) && (((Pair)localObject2).second != null))
        {
          localObject1 = (WxaPkgWrappingInfo)((Pair)localObject2).second;
          AppMethodBeat.o(10920);
          return localObject1;
          if (as.a.gWs.equals(localPair.first)) {
            break;
          }
          ab.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[] { this.appId, Integer.valueOf(this.cvs), Integer.valueOf(this.gXf), Integer.valueOf(((as.a)localPair.first).awa()) });
          break;
        }
        if (j >= localObject1.length)
        {
          a((as.a)localPair.first);
          AppMethodBeat.o(10920);
          return null;
        }
      }
      break label638;
      label1279:
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.b
 * JD-Core Version:    0.7.0.1
 */
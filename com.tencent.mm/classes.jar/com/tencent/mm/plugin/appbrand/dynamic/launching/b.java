package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.x;
import com.tencent.mm.h.b.a.r;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.am.a;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.at.a;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.protocal.c.cmh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b
  implements Callable<WxaPkgWrappingInfo>
{
  public static int fWB = 0;
  public static int fWC = 1;
  final String appId;
  final int bOa;
  volatile int fEN;
  String fTF;
  volatile String fWD;
  String fWE;
  int fWz;
  final String id;
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.appId = paramString2;
    this.bOa = paramInt1;
    this.fEN = paramInt2;
    this.fWD = paramString4;
    this.fWz = paramInt3;
    this.fTF = paramString3;
    this.fWE = paramString5;
  }
  
  private static void a(am.a parama)
  {
    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecordError %s", new Object[] { parama.toString() });
    if (am.a.fEd.equals(parama)) {}
    while ((am.a.fEf.equals(parama)) || (!am.a.fEe.equals(parama))) {
      return;
    }
  }
  
  private WxaPkgWrappingInfo afu()
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject = new k();
    at.a local1 = new at.a() {};
    v.jdMethod_if(7);
    if ((this.bOa == 10002) || (this.bOa == 10102))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.fEN) });
      if (!at.b(this.appId, this.bOa, this.fEN, this.fWD, local1))
      {
        v.jdMethod_if(9);
        localObject = new r();
        ((r)localObject).cjv = u.jy(this.id);
        ((r)localObject).cjw = u.jx(this.id);
        ((r)localObject).cjs = 4L;
        ((r)localObject).cjr = this.id;
        ((r)localObject).cjt = System.currentTimeMillis();
        ((r)localObject).cju = 2L;
        ((r)localObject).cjy = aq.fH(ae.getContext());
        ((r)localObject).QX();
        a(am.a.fEh);
        return null;
      }
    }
    else
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", new Object[] { this.appId, Integer.valueOf(this.bOa) });
      if (((c)g.r(c.class)).aaG() == null)
      {
        y.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
        a(am.a.fEh);
        return null;
      }
      String str = ((c)g.r(c.class)).aaG().aj(this.appId, this.bOa);
      if (bk.bl(str))
      {
        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
        a(am.a.fEd);
        return null;
      }
      at.a(this.appId, this.bOa, str, local1);
    }
    try
    {
      localCountDownLatch.await();
      return (WxaPkgWrappingInfo)((k)localObject).value;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", localException, "tryDownload semaphore exp ", new Object[0]);
      }
    }
  }
  
  public final WxaPkgWrappingInfo aft()
  {
    int j = 1;
    Pair localPair = am.t(this.appId, this.bOa, this.fEN);
    Object localObject1;
    if (localPair.second != null)
    {
      j.aeZ().aI(this.appId, 29);
      localObject1 = (WxaPkgWrappingInfo)localPair.second;
      return localObject1;
    }
    j.aeZ().aI(this.appId, 3);
    Object localObject2;
    int i;
    if (am.a.fEg.equals(localPair.first))
    {
      u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", new Object[] { this.appId, Integer.valueOf(this.bOa), Integer.valueOf(this.fEN) });
      if ((this.bOa == 10002) || (this.bOa == 10102))
      {
        localObject2 = ((c)g.r(c.class)).aaG().a(this.appId, this.bOa, new String[] { "version", "versionMd5", "versionState" });
        if (localObject2 == null)
        {
          u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
          a((am.a)localPair.first);
          return null;
        }
        if (this.bOa == 10102)
        {
          i = 2;
          label226:
          v.jdMethod_if(4);
          localObject1 = new r();
          ((r)localObject1).cjv = this.appId;
          ((r)localObject1).cjw = u.jx(this.id);
          ((r)localObject1).cjs = 13L;
          ((r)localObject1).cjr = this.id;
          ((r)localObject1).cjt = System.currentTimeMillis();
          ((r)localObject1).cju = 2L;
          ((r)localObject1).cjy = aq.fH(ae.getContext());
          ((r)localObject1).QX();
          if (TextUtils.isEmpty(this.fWE)) {
            break label1218;
          }
          localObject1 = new ane();
          ((ane)localObject1).aH(Base64.decode(this.fWE, 0));
          if (!TextUtils.isEmpty(((ane)localObject1).url)) {
            break label593;
          }
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject1 = x.a(new com.tencent.mm.plugin.appbrand.appcache.b(this.appId, ((an)localObject2).field_version, ((an)localObject2).field_versionMd5, i));
        if ((localObject1 == null) || (((a.a)localObject1).errType != 0) || (((a.a)localObject1).errCode != 0))
        {
          v.jdMethod_if(6);
          localObject1 = new r();
          ((r)localObject1).cjv = this.appId;
          ((r)localObject1).cjw = u.jx(this.id);
          ((r)localObject1).cjs = 3L;
          ((r)localObject1).cjr = this.id;
          ((r)localObject1).cjt = System.currentTimeMillis();
          ((r)localObject1).cju = 2L;
          ((r)localObject1).cjy = aq.fH(ae.getContext());
          ((r)localObject1).QX();
          if ((this.fWz == 1) && (this.id != null) && (this.id.length() > 0))
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("id", this.id);
            ((Bundle)localObject1).putInt("widgetState", 2105);
            f.a(i.aeX().sX(this.id), (Parcelable)localObject1, f.a.class, null);
          }
          u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail", new Object[0]);
          return null;
          i = 1;
          break label226;
          label593:
          u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "use preload download data", new Object[0]);
          continue;
        }
        localObject1 = (ane)((a.a)localObject1).ecw;
      }
      for (;;)
      {
        if (localObject1 == null) {
          return null;
        }
        Object localObject3 = new r();
        ((r)localObject3).cjv = u.jy(this.id);
        ((r)localObject3).cjw = u.jx(this.id);
        ((r)localObject3).cjs = 3L;
        ((r)localObject3).cjr = this.id;
        ((r)localObject3).cjt = System.currentTimeMillis();
        ((r)localObject3).cju = 1L;
        ((r)localObject3).cjy = aq.fH(ae.getContext());
        ((r)localObject3).QX();
        v.jdMethod_if(5);
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
        if (bk.bl(((ane)localObject1).url))
        {
          u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
          return null;
        }
        localObject3 = new cmh();
        localObject1 = ((ane)localObject1).url;
        this.fWD = ((String)localObject1);
        ((cmh)localObject3).tZl = ((String)localObject1);
        i = ((an)localObject2).field_version;
        this.fEN = i;
        ((cmh)localObject3).sCy = i;
        ((cmh)localObject3).tZj = ((an)localObject2).field_versionState;
        ((cmh)localObject3).tZk = ((an)localObject2).field_versionMd5;
        ((c)g.r(c.class)).aaG().a(this.appId, (cmh)localObject3, this.bOa);
        localObject2 = afu();
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.fWz != 1) {
            break;
          }
          h.nFQ.f(14452, new Object[] { this.fTF + "-" + this.appId, Integer.valueOf(7), Long.valueOf(System.currentTimeMillis()) });
          return localObject2;
        }
        if (this.fWz == 1) {
          h.nFQ.f(14452, new Object[] { this.fTF + "-" + this.appId, Integer.valueOf(8), Long.valueOf(System.currentTimeMillis()) });
        }
        if ((this.bOa == 10002) || (this.bOa == 10102))
        {
          localObject1 = ((c)g.r(c.class)).aaG().ri(this.appId);
          if ((localObject1 == null) || (localObject1.length <= 1)) {}
        }
        for (i = j;; i = j)
        {
          localObject2 = this.appId;
          int k = this.bOa;
          j = i + 1;
          localObject2 = am.t((String)localObject2, k, localObject1[i]);
          if ((localObject2 != null) && (((Pair)localObject2).first == am.a.fEc) && (((Pair)localObject2).second != null))
          {
            return (WxaPkgWrappingInfo)((Pair)localObject2).second;
            if (am.a.fEc.equals(localPair.first)) {
              break;
            }
            y.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", new Object[] { this.appId, Integer.valueOf(this.bOa), Integer.valueOf(this.fEN), Integer.valueOf(((am.a)localPair.first).ack()) });
            break;
          }
          if (j >= localObject1.length)
          {
            a((am.a)localPair.first);
            return null;
          }
        }
      }
      label1218:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.b
 * JD-Core Version:    0.7.0.1
 */
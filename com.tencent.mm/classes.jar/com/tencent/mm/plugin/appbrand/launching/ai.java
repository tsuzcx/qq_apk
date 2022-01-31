package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.as.a;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f.a;
import com.tencent.mm.plugin.appbrand.appcache.d;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.x.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import java.util.concurrent.Callable;
import junit.framework.Assert;

abstract class ai
  extends ag<WxaPkgWrappingInfo>
  implements n
{
  final String appId;
  final int cxS;
  private final int gXf;
  final int hcr;
  final WxaAttributes.WxaVersionInfo hjJ;
  String hqd;
  private WxaPkgWrappingInfo imy;
  
  ai(String paramString, int paramInt1, int paramInt2, int paramInt3, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    this.appId = paramString;
    this.hcr = paramInt1;
    this.gXf = paramInt2;
    this.cxS = paramInt3;
    this.hqd = null;
    this.hjJ = paramWxaVersionInfo;
  }
  
  private WxaPkgWrappingInfo azY()
  {
    Object localObject1 = as.F(this.appId, this.hcr, this.gXf);
    if (((Pair)localObject1).second != null)
    {
      ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", new Object[] { this.appId, Integer.valueOf(this.hcr), Integer.valueOf(this.gXf) });
      try
      {
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)g.w(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).az(this.appId, this.gXf);
        localObject1 = (WxaPkgWrappingInfo)((Pair)localObject1).second;
        return localObject1;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localThrowable1, "checkReportOnLocalPkgFound, appId[%s], version[%d]", new Object[] { this.appId, Integer.valueOf(this.gXf) });
        }
      }
    }
    int i;
    Object localObject6;
    for (;;)
    {
      try
      {
        localObject2 = (com.tencent.mm.plugin.appbrand.appcache.b.d.a)g.w(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class);
        localObject4 = this.appId;
        i = this.gXf;
        localObject6 = new com.tencent.mm.plugin.appbrand.appcache.b.d.b();
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.b)localObject6).field_appId = ((String)localObject4);
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.b)localObject6).field_version = i;
        bool = ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)localObject2).get((c)localObject6, new String[0]);
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.b)localObject6).field_hitCount += 1;
        if (!bool) {
          continue;
        }
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)localObject2).update((c)localObject6, new String[0]);
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        boolean bool;
        ab.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", localThrowable2, "increaseHitCount, appId[%s], version[%d]", new Object[] { this.appId, Integer.valueOf(this.gXf) });
        continue;
        Object localObject4 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(localThrowable2.value, 181L);
      }
      if (!j.a.nk(this.hcr)) {
        break label1361;
      }
      localObject4 = ((af)g.w(af.class)).C(this.appId, 1, this.gXf);
      if (localObject4 == null) {
        break label1361;
      }
      localObject2 = new PLong();
      bool = f.a((ae)localObject4, f.a.gXK, (PLong)localObject2);
      ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "decrypt ret %b, with appId(%s) version(%d)", new Object[] { Boolean.valueOf(bool), this.appId, Integer.valueOf(this.gXf) });
      if (!bool) {
        break label1361;
      }
      localObject1 = as.F(this.appId, this.hcr, this.gXf);
      if (((Pair)localObject1).second == null) {
        continue;
      }
      localObject4 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(((PLong)localObject2).value, 180L);
      return (WxaPkgWrappingInfo)((Pair)localObject1).second;
      ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)localObject2).insert((c)localObject6);
    }
    label772:
    label927:
    label934:
    label1323:
    label1347:
    label1361:
    for (;;)
    {
      Object localObject3 = localObject1;
      if (as.a.gWt.equals(((Pair)localObject1).first))
      {
        ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, manifest NULL, appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.hcr), Integer.valueOf(this.gXf) });
        g.auM().a(this.appId, this.hjJ);
        if (g.auM().a(this.appId, this.gXf, this.hcr, new String[0]) != null) {
          break label760;
        }
        ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, insert manifest fail again!!! appId(%s) type(%d) version(%d)", new Object[] { this.appId, Integer.valueOf(this.hcr), Integer.valueOf(this.gXf) });
        localObject3 = localObject1;
      }
      for (;;)
      {
        for (;;)
        {
          if (!as.a.gWw.equals(((Pair)localObject3).first)) {
            break label1347;
          }
          if (this.hcr != 0) {
            break label1323;
          }
          this.imy = h.bl(this.appId, 1);
          try
          {
            localObject1 = g.auM().a(this.appId, 0, new String[] { "version", "versionMd5", "versionState" });
            if (localObject1 != null) {
              break label772;
            }
            throw new n.a.a().k(com.tencent.mm.plugin.appbrand.t.e.getMMString(2131296792, new Object[] { com.tencent.mm.plugin.appbrand.appcache.b.nj(this.hcr) }), new Object[0]).l("get NULL record with md5", new Object[0]).aGT();
          }
          catch (n.a locala)
          {
            ab.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s", new Object[] { this.appId, locala.getMessage() });
            if (this.gXf <= 0)
            {
              localObject3 = h.bl(this.appId, 1);
              localObject1 = localObject3;
              if (localObject3 != null) {
                break;
              }
            }
            if (!bo.isNullOrNil(locala.ili)) {
              ah.Do(locala.ili);
            }
            return null;
          }
        }
        label760:
        localObject3 = Pair.create(as.a.gWw, null);
        continue;
        long l1 = bo.aoy();
        int j = ((at)localObject1).field_version;
        if (this.imy == null)
        {
          i = 0;
          localObject3 = com.tencent.mm.ai.x.a(new d(this.appId, ((at)localObject1).field_version, ((at)localObject1).field_versionMd5, 0, i));
          if ((localObject3 != null) && (((a.a)localObject3).errType == 0) && (((a.a)localObject3).errCode == 0)) {
            break label1028;
          }
          if ((localObject3 == null) || (((a.a)localObject3).errCode != -1001)) {
            break label927;
          }
          localObject1 = ah.getMMString(2131296788, new Object[0]);
          localObject5 = new n.a.a();
          if (localObject3 != null) {
            break label988;
          }
        }
        label979:
        label988:
        for (localObject3 = null;; localObject3 = String.format(Locale.US, "(%d, %d)", new Object[] { Integer.valueOf(((a.a)localObject3).errType), Integer.valueOf(((a.a)localObject3).errCode) }))
        {
          throw ((n.a.a)localObject5).l("fail get download url, resp %s", new Object[] { localObject3 }).k((String)localObject1, new Object[0]).aGT();
          i = this.imy.gXf;
          break;
          if (localObject3 == null)
          {
            i = -1;
            if (localObject3 != null) {
              break label979;
            }
          }
          for (j = -1;; j = ((a.a)localObject3).errCode)
          {
            localObject1 = ah.getMMString(2131296786, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            break;
            i = ((a.a)localObject3).errType;
            break label934;
          }
        }
        long l2 = bo.aoy();
        z.a(z.b.imc, this.appId, j, this.hcr, this.cxS, l2 - l1);
        if (bo.isNullOrNil(((ast)((a.a)localObject3).fsN).url)) {
          throw new n.a.a().l("CgiGetDownloadURL return EMPTY url, ret = %d", new Object[] { Integer.valueOf(((ast)((a.a)localObject3).fsN).ret) }).aGT();
        }
        Object localObject5 = new czy();
        localObject6 = ((ast)((a.a)localObject3).fsN).url;
        this.hqd = ((String)localObject6);
        ((czy)localObject5).ygH = ((String)localObject6);
        ((czy)localObject5).wwX = ((at)localObject1).field_version;
        ((czy)localObject5).ygF = ((at)localObject1).field_versionState;
        ((czy)localObject5).ygG = ((at)localObject1).field_versionMd5;
        g.auM().a(this.appId, (czy)localObject5, 0);
        if (this.hjJ.hkh > 0)
        {
          l1 = bo.aoy();
          localObject1 = com.tencent.mm.plugin.appbrand.appcache.x.hp(this.hjJ.hkh);
          l2 = bo.aoy();
          ab.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", new Object[] { Integer.valueOf(this.hjJ.hkh), Long.valueOf(l2 - l1), ((x.b)localObject1).name() });
        }
        localObject3 = c(new ai.a(this, i, j, (ast)((a.a)localObject3).fsN, (byte)0));
        localObject1 = localObject3;
        if (localObject3 != null) {
          break;
        }
        throw new n.a.a().l("Download Fail", new Object[0]).aGT();
        localObject1 = c(new ai.b(this, 0, (byte)0));
        if (localObject1 != null) {
          return localObject1;
        }
      }
      a((as.a)((Pair)localObject3).first);
      return null;
    }
  }
  
  private WxaPkgWrappingInfo c(Callable<WxaPkgWrappingInfo> paramCallable)
  {
    if (paramCallable == this)
    {
      Assert.assertTrue("Why the hell you pass 'this' to this method", false);
      return null;
    }
    aGL();
    try
    {
      paramCallable = (WxaPkgWrappingInfo)paramCallable.call();
      aGQ();
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
  
  final void a(as.a parama)
  {
    int i = 2131296724;
    if (as.a.gWt.equals(parama))
    {
      if (this.hcr == 1) {}
      for (parama = com.tencent.mm.plugin.appbrand.t.e.getMMString(2131296724, new Object[0]);; parama = com.tencent.mm.plugin.appbrand.t.e.getMMString(2131296792, new Object[] { com.tencent.mm.plugin.appbrand.appcache.b.nj(this.hcr) }))
      {
        if (this.hcr == 1)
        {
          com.tencent.mm.plugin.appbrand.task.h.bt(this.appId, this.hcr);
          com.tencent.mm.plugin.appbrand.report.e.U(this.appId, 10, this.hcr + 1);
        }
        ah.Do(parama);
        return;
      }
    }
    if ((as.a.gWv.equals(parama)) || (as.a.gWu.equals(parama)))
    {
      if (this.hcr != 0) {}
      for (;;)
      {
        ah.oH(i);
        if (this.hcr == 1) {
          com.tencent.mm.plugin.appbrand.report.e.U(this.appId, 10, this.hcr + 1);
        }
        com.tencent.mm.plugin.appbrand.task.h.bt(this.appId, this.hcr);
        return;
        i = 2131296727;
      }
    }
    ah.Do(com.tencent.mm.plugin.appbrand.t.e.getMMString(2131296789, new Object[] { Integer.valueOf(1), Integer.valueOf(parama.awa()) }));
  }
  
  public void aGL() {}
  
  public void aGQ() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai
 * JD-Core Version:    0.7.0.1
 */
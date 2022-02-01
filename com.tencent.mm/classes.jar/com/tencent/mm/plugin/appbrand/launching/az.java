package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.e.a;
import com.tencent.luggage.sdk.e.b;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.d.c;
import com.tencent.mm.plugin.appbrand.launching.d.f;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;

@Deprecated
abstract class az
  extends aw<WxaPkgWrappingInfo>
  implements w
{
  static cye a(byy parambyy, b paramb)
  {
    int i = parambyy.Meg;
    boolean bool;
    Object localObject1;
    label74:
    label87:
    c.a locala;
    label111:
    Iterator localIterator;
    Object localObject4;
    Object localObject3;
    if (paramb == null)
    {
      bool = true;
      Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: localOldPkgVersion = %d, parallelCgiLogic is null? = %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (paramb == null) {
        break label455;
      }
      localObject1 = c.mYA;
      p.h(paramb, "parallelTasksCollection");
      localObject1 = (a)paramb.cCy.get(Integer.valueOf(1));
      if (localObject1 != null) {
        break label267;
      }
      paramb = null;
      if (paramb != null) {
        break label285;
      }
      Log.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getPreGetPkgDownloadInfo: ret == null!");
      paramb = null;
      if (paramb == null) {
        break label445;
      }
      locala = paramb.yn(100);
      if (locala != null) {
        break label293;
      }
      Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack is null");
      if ((locala == null) || (locala.iLC == null) || (locala.errType != 0) || (locala.errCode != 0)) {
        break label436;
      }
      localIterator = ((ddz)locala.iLC).MJa.iterator();
      localObject4 = null;
      paramb = null;
      localObject3 = null;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label375;
      }
      localObject1 = (cye)localIterator.next();
      if (Util.isNullOrNil(parambyy.MbW)) {
        parambyy.MbW = "";
      }
      if (Util.isNullOrNil(((cye)localObject1).MbW)) {
        ((cye)localObject1).MbW = "";
      }
      if ((((cye)localObject1).MbZ == parambyy.MbZ) && (parambyy.MbW.equals(((cye)localObject1).MbW)))
      {
        if (((cye)localObject1).LVm)
        {
          localObject3 = localObject1;
          continue;
          bool = false;
          break;
          label267:
          paramb = (b)localObject1;
          if (localObject1 != null) {
            break label74;
          }
          throw new t("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
          label285:
          paramb = (f)paramb;
          break label87;
          label293:
          if (locala.iLC == null)
          {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack.resp is null");
            break label111;
          }
          Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: (%d,%d)", new Object[] { Integer.valueOf(locala.errType), Integer.valueOf(locala.errCode) });
          break label111;
        }
        localObject2 = localObject1;
        if (!((cye)localObject1).LVl) {
          break label369;
        }
        localObject4 = localObject1;
        continue;
      }
      Object localObject2 = paramb;
      label369:
      paramb = (b)localObject2;
    }
    label375:
    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: patchUrl = [%s], zstdUrl = [%s], url = [%s]", new Object[] { localObject4, localObject3, paramb });
    if (((ddz)locala.iLC).version == parambyy.KXD)
    {
      if (localObject4 != null) {
        return localObject4;
      }
      if (localObject3 != null) {
        return localObject3;
      }
      return paramb;
      label436:
      Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: check cgiBack fail");
    }
    for (;;)
    {
      return null;
      label445:
      Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preFetchGetDownloadInfoTask isnull");
      continue;
      label455:
      Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: parallelCgiLogic is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.az
 * JD-Core Version:    0.7.0.1
 */
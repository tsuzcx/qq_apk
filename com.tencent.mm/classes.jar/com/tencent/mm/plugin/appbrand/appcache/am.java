package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public enum am
{
  public static Pair<am.a, WxaPkgWrappingInfo> cJ(boolean paramBoolean)
  {
    return o(paramBoolean, false);
  }
  
  public static Pair<am.a, WxaPkgWrappingInfo> o(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if ((paramBoolean1) && ((!paramBoolean2) || (ah.fDo != ah.a.fDs)))
    {
      localObject = (c)g.r(c.class);
      if (localObject != null)
      {
        localObject = ((c)localObject).aaG();
        if (localObject != null) {}
      }
      else
      {
        return Pair.create(am.a.fEc, ah.abW());
      }
      i = ((ar)localObject).ak("@LibraryAppId", 0);
      if (("@LibraryAppId".equals("@LibraryAppId")) && ((i < 0) || (ah.VERSION >= i))) {
        y.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", new Object[] { Integer.valueOf(ah.VERSION), "@LibraryAppId", Integer.valueOf(0), Integer.valueOf(i) });
      }
      for (localObject = ah.abW(); localObject != null; localObject = null)
      {
        y.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", new Object[] { Integer.valueOf(i), Integer.valueOf(ah.VERSION) });
        return Pair.create(am.a.fEc, localObject);
      }
    }
    if (paramBoolean1) {}
    for (int i = 0;; i = 999)
    {
      localObject = t("@LibraryAppId", i, -1);
      y.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), ah.fDo, ((Pair)localObject).first });
      return localObject;
    }
  }
  
  public static Pair<am.a, WxaPkgWrappingInfo> t(String paramString, int paramInt1, int paramInt2)
  {
    if ((!g.DN().dJH) || (((c)g.r(c.class)).aaG() == null))
    {
      y.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return Pair.create(am.a.fEh, null);
    }
    Object localObject1 = new String[6];
    localObject1[0] = "pkgPath";
    localObject1[1] = "versionMd5";
    localObject1[2] = "version";
    localObject1[3] = "createTime";
    localObject1[4] = "startTime";
    localObject1[5] = "endTime";
    if ((d.a.kq(paramInt1)) && (paramInt2 > 0)) {}
    for (localObject1 = ((c)g.r(c.class)).aaG().a(paramString, paramInt2, paramInt1, (String[])localObject1); localObject1 == null; localObject1 = ((c)g.r(c.class)).aaG().a(paramString, paramInt1, (String[])localObject1))
    {
      y.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return Pair.create(am.a.fEd, null);
    }
    if (paramInt1 == 999)
    {
      y.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg for dev_lib, time_scope[%d, %d]", new Object[] { Long.valueOf(((an)localObject1).field_startTime), Long.valueOf(((an)localObject1).field_endTime) });
      if ((((an)localObject1).field_endTime > 0L) && (((an)localObject1).field_endTime <= bk.UX())) {
        return Pair.create(am.a.fEe, null);
      }
    }
    String str1 = ((an)localObject1).field_pkgPath;
    Object localObject2 = ((an)localObject1).field_versionMd5;
    if (paramInt2 < 0) {}
    long l;
    for (int i = ((an)localObject1).field_version;; i = paramInt2)
    {
      l = ((an)localObject1).field_createTime;
      if ((!bk.bl(str1)) && (e.bK(str1))) {
        break;
      }
      y.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[] { str1, paramString, Integer.valueOf(paramInt1), Integer.valueOf(i) });
      return Pair.create(am.a.fEg, null);
    }
    String str2 = e.aeY(str1);
    if ((!bk.bl((String)localObject2)) && (!((String)localObject2).equals(str2)))
    {
      y.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "md5 mismatch | realMd5 = %s, manifestMd5 = %s, appId = %s, debugType = %d, version = %d", new Object[] { str2, localObject2, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return Pair.create(am.a.fEg, null);
    }
    localObject2 = WxaPkgWrappingInfo.rn(str1);
    if (localObject2 == null)
    {
      y.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "obtain wxPkg failed, appId = %s, debugType = %d, version = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return Pair.create(am.a.fEg, null);
    }
    ((WxaPkgWrappingInfo)localObject2).fEN = i;
    ((WxaPkgWrappingInfo)localObject2).fEO = l;
    ((WxaPkgWrappingInfo)localObject2).fCl = str1;
    ((WxaPkgWrappingInfo)localObject2).fEP = false;
    ((WxaPkgWrappingInfo)localObject2).fEM = paramInt1;
    ((WxaPkgWrappingInfo)localObject2).bIW = str2;
    y.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, startTime = %d, endTime = %d, return %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(((an)localObject1).field_startTime), Long.valueOf(((an)localObject1).field_endTime), localObject2 });
    return Pair.create(am.a.fEc, localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.am
 * JD-Core Version:    0.7.0.1
 */
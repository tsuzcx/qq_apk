package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public enum as
{
  public static Pair<as.a, WxaPkgWrappingInfo> F(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(59522);
    if ((!g.RJ().eHg) || (((d)g.E(d.class)).we() == null))
    {
      ab.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = Pair.create(as.a.gWx, null);
      AppMethodBeat.o(59522);
      return paramString;
    }
    Object localObject = new String[6];
    localObject[0] = "pkgPath";
    localObject[1] = "versionMd5";
    localObject[2] = "version";
    localObject[3] = "createTime";
    localObject[4] = "startTime";
    localObject[5] = "endTime";
    if ((j.a.nk(paramInt1)) && (paramInt2 > 0)) {}
    for (at localat = ((d)g.E(d.class)).we().a(paramString, paramInt2, paramInt1, (String[])localObject); localat == null; localat = ((d)g.E(d.class)).we().a(paramString, paramInt1, (String[])localObject))
    {
      ab.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = Pair.create(as.a.gWt, null);
      AppMethodBeat.o(59522);
      return paramString;
    }
    if (paramInt1 == 999)
    {
      ab.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg for dev_lib, time_scope[%d, %d]", new Object[] { Long.valueOf(localat.field_startTime), Long.valueOf(localat.field_endTime) });
      if ((localat.field_endTime > 0L) && (localat.field_endTime <= bo.aox()))
      {
        paramString = Pair.create(as.a.gWu, null);
        AppMethodBeat.o(59522);
        return paramString;
      }
    }
    String str1 = localat.field_pkgPath;
    String str3 = localat.field_versionMd5;
    if (paramInt2 < 0) {}
    long l;
    for (int i = localat.field_version;; i = paramInt2)
    {
      l = localat.field_createTime;
      localObject = null;
      if ((!bo.isNullOrNil(str1)) && (e.cN(str1))) {
        break;
      }
      ab.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[] { str1, paramString, Integer.valueOf(paramInt1), Integer.valueOf(i) });
      paramString = Pair.create(as.a.gWw, null);
      AppMethodBeat.o(59522);
      return paramString;
    }
    String str2 = e.avP(str1);
    if ((!bo.isNullOrNil(str3)) && (!str3.equals(str2)))
    {
      ab.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "md5 mismatch | realMd5 = %s, manifestMd5 = %s, appId = %s, debugType = %d, version = %d", new Object[] { str2, str3, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = Pair.create(as.a.gWw, null);
      AppMethodBeat.o(59522);
      return paramString;
    }
    if (!bo.isNullOrNil(paramString)) {
      if (!paramString.endsWith("__CODELIB__")) {
        break label557;
      }
    }
    label557:
    for (localObject = WxaPkgWrappingInfo.yM(str1); localObject == null; localObject = WxaPkgWrappingInfo.yL(str1))
    {
      ab.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "obtain wxPkg failed, appId = %s, debugType = %d, version = %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = Pair.create(as.a.gWw, null);
      AppMethodBeat.o(59522);
      return paramString;
    }
    ((WxaPkgWrappingInfo)localObject).gXf = i;
    ((WxaPkgWrappingInfo)localObject).gXg = l;
    ((WxaPkgWrappingInfo)localObject).gUy = str1;
    ((WxaPkgWrappingInfo)localObject).gXh = false;
    ((WxaPkgWrappingInfo)localObject).gXe = paramInt1;
    ((WxaPkgWrappingInfo)localObject).cqq = str2;
    ab.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, startTime = %d, endTime = %d, return %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Long.valueOf(localat.field_startTime), Long.valueOf(localat.field_endTime), localObject });
    paramString = Pair.create(as.a.gWs, localObject);
    AppMethodBeat.o(59522);
    return paramString;
  }
  
  private static WxaPkgWrappingInfo as(String paramString, int paramInt)
  {
    AppMethodBeat.i(59519);
    if (("@LibraryAppId".equals(paramString)) && ((paramInt < 0) || (an.VERSION >= paramInt)))
    {
      ab.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", new Object[] { Integer.valueOf(an.VERSION), paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
      paramString = an.avN();
      AppMethodBeat.o(59519);
      return paramString;
    }
    AppMethodBeat.o(59519);
    return null;
  }
  
  public static Pair<as.a, WxaPkgWrappingInfo> dL(boolean paramBoolean)
  {
    AppMethodBeat.i(59520);
    Pair localPair = p(paramBoolean, false);
    AppMethodBeat.o(59520);
    return localPair;
  }
  
  public static Pair<as.a, WxaPkgWrappingInfo> p(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(59521);
    Object localObject;
    if ((paramBoolean1) && ((!paramBoolean2) || (an.gVD != an.a.gVH)))
    {
      localObject = (d)g.E(d.class);
      if (localObject != null)
      {
        localObject = ((d)localObject).we();
        if (localObject != null) {}
      }
      else
      {
        localObject = Pair.create(as.a.gWs, an.avN());
        AppMethodBeat.o(59521);
        return localObject;
      }
      i = ((ay)localObject).av("@LibraryAppId", 0);
      localObject = as("@LibraryAppId", i);
      if (localObject != null)
      {
        ab.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", new Object[] { Integer.valueOf(i), Integer.valueOf(an.VERSION) });
        localObject = Pair.create(as.a.gWs, localObject);
        AppMethodBeat.o(59521);
        return localObject;
      }
    }
    if (paramBoolean1) {}
    for (int i = 0;; i = 999)
    {
      localObject = F("@LibraryAppId", i, -1);
      ab.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), an.gVD, ((Pair)localObject).first });
      AppMethodBeat.o(59521);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.as
 * JD-Core Version:    0.7.0.1
 */
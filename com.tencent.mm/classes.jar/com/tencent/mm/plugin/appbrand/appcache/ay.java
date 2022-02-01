package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibVersionUtils;", "", "()V", "TAG", "", "checkIsValid", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "getLatestValidPkgRecordForType", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorage;", "versionType", "", "toWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
{
  public static final ay qGe;
  
  static
  {
    AppMethodBeat.i(320253);
    qGe = new ay();
    AppMethodBeat.o(320253);
  }
  
  public static final bh a(bm parambm, int paramInt)
  {
    AppMethodBeat.i(320239);
    s.u(parambm, "<this>");
    Object localObject1 = "select * from " + parambm.qHw.getTableName() + " where appId=? and debugType=? and pkgPath!=? order by version desc";
    parambm = parambm.qHv.rawQuery((String)localObject1, new String[] { "@LibraryAppId", String.valueOf(paramInt), "" }, 2);
    if (parambm != null) {
      parambm = (Closeable)parambm;
    }
    try
    {
      localObject1 = (Cursor)parambm;
      if (((Cursor)localObject1).moveToFirst())
      {
        bh localbh = new bh();
        do
        {
          localbh.convertFrom((Cursor)localObject1);
          boolean bool = a(localbh);
          if (bool)
          {
            b.a(parambm, null);
            AppMethodBeat.o(320239);
            return localbh;
          }
        } while (((Cursor)localObject1).moveToNext());
        localObject1 = ah.aiuX;
        b.a(parambm, null);
        AppMethodBeat.o(320239);
        return null;
      }
      b.a(parambm, null);
      AppMethodBeat.o(320239);
      return null;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(320239);
        throw localThrowable;
      }
      finally
      {
        b.a(parambm, localThrowable);
        AppMethodBeat.o(320239);
      }
    }
  }
  
  private static boolean a(bh parambh)
  {
    AppMethodBeat.i(320245);
    if ((999 == parambh.field_debugType) && (parambh.field_endTime > 0L) && (parambh.field_endTime <= Util.nowSecond()))
    {
      Log.e("Luggage.WxaCommLibVersionUtils", s.X("checkIsValid BETA_LIBRARY expired, endTime:", Long.valueOf(parambh.field_endTime)));
      AppMethodBeat.o(320245);
      return false;
    }
    if (y.ZC(parambh.field_pkgPath)) {
      try
      {
        String str = WxaPkgWrappingInfo.n(new u(parambh.field_pkgPath));
        s.checkNotNull(str);
        if (s.p(str, parambh.field_versionMd5))
        {
          AppMethodBeat.o(320245);
          return true;
        }
      }
      catch (Exception localException)
      {
        Log.e("Luggage.WxaCommLibVersionUtils", "checkIsValid getFileMD5 failed " + localException + ", path:" + parambh.field_pkgPath + ", version:" + parambh.field_version + ", versionType:" + parambh.field_debugType);
        AppMethodBeat.o(320245);
        return false;
      }
    }
    AppMethodBeat.o(320245);
    return false;
  }
  
  public static final WxaPkgWrappingInfo b(bh parambh)
  {
    int j = 0;
    AppMethodBeat.i(320249);
    s.u(parambh, "<this>");
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    int i;
    if (parambh.field_debugType == 0)
    {
      i = parambh.field_version;
      localWxaPkgWrappingInfo.pkgVersion = i;
      localWxaPkgWrappingInfo.qHP = parambh.field_createTime;
      localWxaPkgWrappingInfo.qHO = parambh.field_debugType;
      localWxaPkgWrappingInfo.pkgPath = parambh.field_pkgPath;
      localWxaPkgWrappingInfo.qHQ = false;
      CharSequence localCharSequence = (CharSequence)parambh.field_versionMd5;
      if (localCharSequence != null)
      {
        i = j;
        if (localCharSequence.length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0) {
        break label131;
      }
    }
    label131:
    for (parambh = WxaPkgWrappingInfo.n(new u(localWxaPkgWrappingInfo.pkgPath));; parambh = parambh.field_versionMd5)
    {
      localWxaPkgWrappingInfo.md5 = parambh;
      AppMethodBeat.o(320249);
      return localWxaPkgWrappingInfo;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ay
 * JD-Core Version:    0.7.0.1
 */
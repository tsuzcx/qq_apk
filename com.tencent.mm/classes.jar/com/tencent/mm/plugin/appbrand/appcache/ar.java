package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.clw;
import com.tencent.mm.protocal.c.cmh;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ar
{
  public static final String[] fEB = { i.a(an.dUa, "AppBrandWxaPkgManifestRecord") };
  public final h fEC;
  public final ar.b fED;
  
  public ar(h paramh)
  {
    this.fEC = paramh;
    this.fED = new ar.b(paramh);
  }
  
  private boolean b(an paraman)
  {
    y.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", new Object[] { paraman.field_appId, Integer.valueOf(paraman.field_debugType), Integer.valueOf(paraman.field_version) });
    return this.fED.b(paraman);
  }
  
  private boolean c(an paraman)
  {
    y.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", new Object[] { paraman.field_appId, Integer.valueOf(paraman.field_version), Integer.valueOf(paraman.field_debugType) });
    return this.fED.c(paraman, an.fEl);
  }
  
  private boolean u(String paramString, int paramInt1, int paramInt2)
  {
    Locale localLocale = Locale.US;
    if (paramInt2 > 0) {}
    for (String str = "version=" + paramInt2;; str = "1=1")
    {
      str = String.format(localLocale, "where %s like '%s$%%' and %s=%d and %s", new Object[] { "appId", paramString, "debugType", Integer.valueOf(paramInt1), str });
      str = String.format(Locale.US, "delete from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", str });
      y.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return this.fEC.gk("AppBrandWxaPkgManifestRecord", str);
    }
  }
  
  public final an a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Object localObject1 = null;
    Object localObject2 = new StringBuilder();
    Object localObject3 = an.fEl;
    int j = localObject3.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject2).append(localObject3[i]).append("=? and ");
      i += 1;
    }
    ((StringBuilder)localObject2).append("1=1");
    localObject3 = this.fEC;
    if (bk.H(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((h)localObject3).a("AppBrandWxaPkgManifestRecord", paramVarArgs, ((StringBuilder)localObject2).toString(), new String[] { paramString, String.valueOf(paramInt1), String.valueOf(paramInt2) }, null, null, null, 2);
      if (localObject2 != null) {
        break;
      }
      return null;
    }
    paramVarArgs = localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      paramVarArgs = new an();
      paramVarArgs.d((Cursor)localObject2);
      paramVarArgs.field_appId = paramString;
    }
    ((Cursor)localObject2).close();
    return paramVarArgs;
  }
  
  public final an a(String paramString, int paramInt, String... paramVarArgs)
  {
    Object localObject2 = null;
    if (bk.bl(paramString)) {
      return null;
    }
    Object localObject1;
    label23:
    h localh;
    if (d.a.kq(paramInt))
    {
      localObject1 = "version desc";
      localh = this.fEC;
      if (!bk.H(paramVarArgs)) {
        break label178;
      }
      paramVarArgs = null;
    }
    label178:
    for (;;)
    {
      localObject1 = localh.query("AppBrandWxaPkgManifestRecord", paramVarArgs, String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null, (String)localObject1);
      if (localObject1 == null) {
        break;
      }
      paramVarArgs = localObject2;
      if (((Cursor)localObject1).moveToFirst())
      {
        paramVarArgs = new an();
        paramVarArgs.d((Cursor)localObject1);
        paramVarArgs.field_appId = paramString;
        paramVarArgs.field_debugType = paramInt;
      }
      ((Cursor)localObject1).close();
      return paramVarArgs;
      if (d.a.id(paramInt))
      {
        localObject1 = "createTime desc";
        break label23;
      }
      throw new RuntimeException("Illegal pkgType " + paramInt);
    }
  }
  
  final List<an> a(String paramString, int paramInt, ar.a parama, String... paramVarArgs)
  {
    if (bk.bl(paramString)) {
      return Collections.emptyList();
    }
    Object localObject = this.fEC;
    String str = String.format(Locale.US, "%s=? and %s=? ", new Object[] { "appId", "debugType" });
    parama = "version " + parama.name();
    parama = ((h)localObject).a("AppBrandWxaPkgManifestRecord", paramVarArgs, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, parama, 2);
    if (parama == null) {
      return Collections.emptyList();
    }
    if (!parama.moveToFirst())
    {
      parama.close();
      return Collections.emptyList();
    }
    paramVarArgs = new LinkedList();
    do
    {
      localObject = new an();
      ((an)localObject).d(parama);
      ((an)localObject).field_appId = paramString;
      ((an)localObject).field_debugType = paramInt;
      paramVarArgs.add(localObject);
    } while (parama.moveToNext());
    parama.close();
    return paramVarArgs;
  }
  
  public final boolean a(an paraman)
  {
    if ((!bk.bl(paraman.field_appId)) && (this.fED.a(paraman, an.fEl))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        u(paraman.field_appId, paraman.field_debugType, paraman.field_version);
      }
      return bool;
    }
  }
  
  final boolean a(clw paramclw, PInt paramPInt)
  {
    if ((paramclw.version < 0) || (bk.bl(paramclw.url)) || (bk.bl(paramclw.bIW)))
    {
      y.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[] { Integer.valueOf(paramclw.version), paramclw.url, paramclw.bIW });
      return false;
    }
    if (paramclw.tBf > 0)
    {
      int i = this.fEC.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[] { "appId", "debugType", "version" }), new String[] { "@LibraryAppId", "0", String.valueOf(paramclw.version) });
      y.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[] { Integer.valueOf(paramclw.version), Integer.valueOf(i) });
      paramPInt.value = i;
    }
    return a("@LibraryAppId", 0, paramclw.version, paramclw.bIW, paramclw.url);
  }
  
  public final boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (!d.a.kq(paramInt1)) {
      return false;
    }
    y.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, paramString3 });
    int i = ak(paramString1, paramInt1);
    if (paramInt2 < i)
    {
      y.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, newVersion( %d ) < curMaxVersion( %d ), skip", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i) });
      return false;
    }
    if (("@LibraryAppId".equals(paramString1)) && (paramInt2 == ah.VERSION))
    {
      y.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[] { Integer.valueOf(ah.VERSION) });
      return false;
    }
    an localan = a(paramString1, paramInt2, paramInt1, new String[0]);
    boolean bool1 = false;
    if (localan == null)
    {
      localan = new an();
      localan.field_appId = paramString1;
      localan.field_version = paramInt2;
      localan.field_versionMd5 = paramString2;
      localan.field_downloadURL = paramString3;
      localan.field_debugType = paramInt1;
      bool1 = b(localan);
      y.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", new Object[] { Boolean.valueOf(bool1), paramString1, Integer.valueOf(localan.field_version), localan.field_downloadURL, localan.field_versionMd5 });
      return bool1;
    }
    String str1 = localan.field_downloadURL;
    String str2 = localan.field_versionMd5;
    if (!bk.pm(localan.field_versionMd5).equals(paramString2))
    {
      localan.field_versionMd5 = paramString2;
      localan.field_version = paramInt2;
      localan.field_downloadURL = paramString3;
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        bool1 = c(localan);
      }
      if ((paramInt1 != 0) && (bool1)) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        y.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s", new Object[] { Boolean.valueOf(bool2), paramString1, Integer.valueOf(i), Integer.valueOf(paramInt2), str1, paramString3, str2, paramString2 });
        if ((paramInt1 == 0) || (!bool1)) {
          break label443;
        }
        return true;
        if ((bk.bl(paramString3)) || (paramString3.equals(localan.field_downloadURL))) {
          break label445;
        }
        localan.field_downloadURL = paramString3;
        paramInt1 = 1;
        break;
      }
      label443:
      return false;
      label445:
      paramInt1 = 0;
    }
  }
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, List<WxaAttributes.WxaVersionModuleInfo> paramList)
  {
    if ((bk.bl(paramString)) || (bk.dk(paramList))) {
      return false;
    }
    if (!d.a.kq(paramInt1)) {}
    for (int i = 1;; i = paramInt2)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append('{');
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        WxaAttributes.WxaVersionModuleInfo localWxaVersionModuleInfo = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(',').append(localWxaVersionModuleInfo.name).append("::").append(localWxaVersionModuleInfo.bIW);
      }
      ((StringBuilder)localObject1).append('}');
      y.i("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(i), ((StringBuilder)localObject1).toString() });
      localObject1 = String.format(Locale.US, "where %s like '%s$%%' and %s=%d and %s=%d", new Object[] { "appId", paramString, "debugType", Integer.valueOf(paramInt1), "version", Integer.valueOf(i) });
      localObject2 = String.format(Locale.US, "select count(*) from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", localObject1 });
      localObject2 = this.fEC.a((String)localObject2, null, 2);
      if (localObject2 == null)
      {
        paramInt2 = 0;
        if ((paramInt2 == 0) || (paramInt2 != paramList.size()))
        {
          localObject1 = String.format(Locale.US, "delete from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", localObject1 });
          this.fEC.gk("AppBrandWxaPkgManifestRecord", (String)localObject1);
          paramList = paramList.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!paramList.hasNext()) {
            break label429;
          }
          localObject1 = (WxaAttributes.WxaVersionModuleInfo)paramList.next();
          localObject2 = new s(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name).toString();
          if (d.a.kq(paramInt1))
          {
            a((String)localObject2, paramInt1, i, ((WxaAttributes.WxaVersionModuleInfo)localObject1).bIW, null);
            continue;
            if (((Cursor)localObject2).moveToFirst()) {}
            for (paramInt2 = ((Cursor)localObject2).getInt(0);; paramInt2 = 0)
            {
              ((Cursor)localObject2).close();
              break;
            }
          }
          else
          {
            a((String)localObject2, paramInt1, null, ((WxaAttributes.WxaVersionModuleInfo)localObject1).bIW, 0L, 0L);
          }
        }
        label429:
        return true;
      }
      return false;
    }
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    if (bk.bl(paramString1)) {
      y.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
    }
    an localan;
    int j;
    label299:
    label305:
    do
    {
      return false;
      y.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramString3, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      if (paramInt == 999) {
        paramString1 = "@LibraryAppId";
      }
      localan = a(paramString1, 1, paramInt, new String[0]);
      if (localan == null)
      {
        localan = new an();
        localan.field_appId = paramString1;
        localan.field_version = 1;
        localan.field_debugType = paramInt;
        localan.field_downloadURL = paramString2;
        localan.field_versionMd5 = paramString3;
        localan.field_versionState = 0;
        localan.field_startTime = paramLong1;
        localan.field_endTime = paramLong2;
        localan.field_createTime = bk.UX();
        b(localan);
        return true;
      }
      int i;
      if ((!bk.bl(paramString3)) && (!bk.bl(localan.field_versionMd5)) && (!paramString3.equals(localan.field_versionMd5)))
      {
        i = 1;
        if (paramString2.equals(localan.field_downloadURL)) {
          break label299;
        }
      }
      for (j = 1;; j = 0)
      {
        if (i == 0) {
          break label305;
        }
        localan.field_downloadURL = paramString2;
        e.deleteFile(localan.field_pkgPath);
        localan.field_pkgPath = null;
        localan.field_createTime = bk.UX();
        localan.field_versionMd5 = paramString3;
        localan.field_startTime = paramLong1;
        localan.field_endTime = paramLong2;
        c(localan);
        u(paramString1, paramInt, 1);
        return true;
        i = 0;
        break;
      }
    } while (j == 0);
    localan.field_downloadURL = paramString2;
    localan.field_startTime = paramLong1;
    localan.field_endTime = paramLong2;
    c(localan);
    return false;
  }
  
  public final boolean a(String paramString, WxaAttributes.d paramd)
  {
    if ((bk.bl(paramString)) || (paramd == null))
    {
      y.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramd });
      return false;
    }
    a(paramString, 0, paramd.cau, paramd.fRu);
    return a(paramString, 0, paramd.cau, paramd.fRr, null);
  }
  
  public final boolean a(String paramString, cmh paramcmh, int paramInt)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramcmh });
      return false;
    }
    return a(paramString, paramInt, paramcmh.sCy, paramcmh.tZk, paramcmh.tZl);
  }
  
  final List<an> acp()
  {
    Object localObject1 = new StringBuilder("debugType");
    ((StringBuilder)localObject1).append(" in (");
    Object localObject2 = d.fBT;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject1).append(localObject2[i]).append(',');
      i += 1;
    }
    ((StringBuilder)localObject1).append(-1).append(')');
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject1 = this.fEC.a("AppBrandWxaPkgManifestRecord", null, (String)localObject1, null, null, null, null, 2);
    if (localObject1 == null) {
      return null;
    }
    if (!((Cursor)localObject1).moveToFirst())
    {
      ((Cursor)localObject1).close();
      return null;
    }
    localObject2 = new ArrayList();
    do
    {
      an localan = new an();
      localan.d((Cursor)localObject1);
      ((List)localObject2).add(localan);
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  public final boolean ai(String paramString, int paramInt)
  {
    if ((bk.bl(paramString)) || (paramInt < 0)) {
      return false;
    }
    h localh = this.fEC;
    String str = String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" });
    paramString = localh.a("AppBrandWxaPkgManifestRecord", new String[] { "version" }, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, null, 2);
    if (paramString == null) {
      return false;
    }
    boolean bool = paramString.moveToFirst();
    paramString.close();
    return bool;
  }
  
  public final String aj(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt, new String[] { "downloadURL" });
    if (paramString == null) {
      return "";
    }
    return paramString.field_downloadURL;
  }
  
  public final int ak(String paramString, int paramInt)
  {
    if ((bk.bl(paramString)) || (!d.a.kq(paramInt))) {}
    do
    {
      return 0;
      paramString = a(paramString, paramInt, new String[] { "version" });
    } while (paramString == null);
    return paramString.field_version;
  }
  
  final int al(String paramString, int paramInt)
  {
    int i = 0;
    if (d.a.kq(0))
    {
      y.i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, pkgType %d, pkgVersion %d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
      i = this.fEC.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString, "0", String.valueOf(paramInt) });
    }
    return i;
  }
  
  public final int am(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    y.i("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    String str = String.format("%s=? and %s=?", new Object[] { "appId", "debugType" });
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    arrayOfString[1] = String.valueOf(paramInt);
    Object localObject = this.fEC.a("AppBrandWxaPkgManifestRecord", new String[] { "pkgPath" }, str, arrayOfString, null, null, null, 2);
    if (localObject == null) {
      return 0;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      return 0;
    }
    LinkedList localLinkedList = new LinkedList();
    do
    {
      localLinkedList.add(((Cursor)localObject).getString(0));
    } while (((Cursor)localObject).moveToNext());
    ((Cursor)localObject).close();
    localObject = localLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      e.deleteFile((String)((Iterator)localObject).next());
    }
    int i = this.fEC.delete("AppBrandWxaPkgManifestRecord", str, arrayOfString);
    u(paramString, paramInt, -1);
    return i;
  }
  
  public final void d(an paraman)
  {
    this.fED.a(paraman);
  }
  
  public final void d(List<String> paramList, List<Integer> paramList1)
  {
    if ((paramList.size() <= 0) || (paramList1.size() <= 0) || (paramList.size() != paramList1.size())) {
      return;
    }
    y.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = this.fEC.eV(Thread.currentThread().getId());
    int i = 0;
    while (i < paramList.size())
    {
      am((String)paramList.get(i), ((Integer)paramList1.get(i)).intValue());
      i += 1;
    }
    this.fEC.hI(l);
  }
  
  @SuppressLint({"DefaultLocale"})
  public final boolean d(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    boolean bool = true;
    if (bk.bl(paramString1)) {
      bool = false;
    }
    ContentValues localContentValues;
    do
    {
      return bool;
      if (d.a.id(paramInt1)) {
        paramInt2 = 1;
      }
      localContentValues = new ContentValues(1);
      localContentValues.put("pkgPath", paramString2);
    } while (this.fEC.update("AppBrandWxaPkgManifestRecord", localContentValues, String.format("%s=? and %s=? and %s=?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString1, String.valueOf(paramInt1), String.valueOf(paramInt2) }) > 0);
    return false;
  }
  
  public final boolean g(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, 0, paramInt, paramString2, null);
  }
  
  public final int[] ri(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    if (!d.a.kq(0)) {
      return null;
    }
    Object localObject = a(paramString, 0, ar.a.fEE, new String[] { "version" });
    if (bk.dk((List)localObject)) {
      return null;
    }
    paramString = new int[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      paramString[i] = ((an)((Iterator)localObject).next()).field_version;
      i += 1;
    }
    return paramString;
  }
  
  final boolean rj(String paramString)
  {
    h localh = this.fEC;
    String str = String.format("%s=?", new Object[] { "pkgPath" });
    paramString = localh.a("AppBrandWxaPkgManifestRecord", new String[] { "appId" }, str, new String[] { paramString }, null, null, null, 2);
    if (paramString == null) {
      return false;
    }
    boolean bool = paramString.moveToFirst();
    paramString.close();
    return bool;
  }
  
  @SuppressLint({"DefaultLocale"})
  final List<an> rk(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    if (d.a.kq(0)) {}
    for (Object localObject1 = String.format("order by %s desc", new Object[] { "version" });; localObject1 = String.format("order by %s desc", new Object[] { "createTime" }))
    {
      Object localObject3 = String.format("limit %d offset %d", new Object[] { Integer.valueOf(2147483647), Integer.valueOf(2) });
      Object localObject2 = this.fEC;
      localObject1 = String.format("%s=? and %s=? %s %s", new Object[] { "appId", "debugType", localObject1, localObject3 });
      localObject1 = ((h)localObject2).a("AppBrandWxaPkgManifestRecord", new String[] { "pkgPath", "version" }, (String)localObject1, new String[] { paramString, "0" }, null, null, null, 2);
      if (localObject1 == null) {
        break;
      }
      localObject2 = new ArrayList();
      if (((Cursor)localObject1).moveToFirst()) {
        do
        {
          localObject3 = new an();
          ((an)localObject3).field_appId = paramString;
          ((an)localObject3).field_debugType = 0;
          ((an)localObject3).d((Cursor)localObject1);
          ((List)localObject2).add(localObject3);
        } while (((Cursor)localObject1).moveToNext());
      }
      ((Cursor)localObject1).close();
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ar
 * JD-Core Version:    0.7.0.1
 */
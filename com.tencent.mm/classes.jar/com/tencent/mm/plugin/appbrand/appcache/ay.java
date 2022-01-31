package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaCodeLibInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.b.a;

public final class ay
  implements j
{
  public static final String[] gWT;
  public final f gWU;
  public final ay.b gWV;
  
  static
  {
    AppMethodBeat.i(101759);
    gWT = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(at.fkk, "AppBrandWxaPkgManifestRecord") };
    AppMethodBeat.o(101759);
  }
  
  public ay(f paramf)
  {
    AppMethodBeat.i(101727);
    this.gWU = paramf;
    this.gWV = new ay.b(paramf);
    AppMethodBeat.o(101727);
  }
  
  private boolean G(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101758);
    Locale localLocale = Locale.US;
    if (paramInt2 > 0) {}
    for (String str = "version=".concat(String.valueOf(paramInt2));; str = "1=1")
    {
      str = String.format(localLocale, "where %s like '%s$%%' and %s=%d and %s", new Object[] { "appId", paramString, "debugType", Integer.valueOf(paramInt1), str });
      str = String.format(Locale.US, "delete from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", str });
      ab.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      boolean bool = this.gWU.execSQL("AppBrandWxaPkgManifestRecord", str);
      AppMethodBeat.o(101758);
      return bool;
    }
  }
  
  private boolean b(at paramat)
  {
    AppMethodBeat.i(101749);
    ab.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", new Object[] { paramat.field_appId, Integer.valueOf(paramat.field_debugType), Integer.valueOf(paramat.field_version) });
    boolean bool = this.gWV.insert(paramat);
    AppMethodBeat.o(101749);
    return bool;
  }
  
  public final at a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    Object localObject1 = null;
    AppMethodBeat.i(101732);
    Object localObject2 = new StringBuilder();
    Object localObject3 = at.gWB;
    int j = localObject3.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject2).append(localObject3[i]).append("=? and ");
      i += 1;
    }
    ((StringBuilder)localObject2).append("1=1");
    if (j.a.kQ(paramInt2)) {
      paramInt1 = 1;
    }
    localObject3 = this.gWU;
    if (bo.Q(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject2 = ((f)localObject3).a("AppBrandWxaPkgManifestRecord", paramVarArgs, ((StringBuilder)localObject2).toString(), new String[] { paramString, String.valueOf(paramInt1), String.valueOf(paramInt2) }, null, null, null, 2);
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(101732);
      return null;
    }
    paramVarArgs = localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      paramVarArgs = new at();
      paramVarArgs.convertFrom((Cursor)localObject2);
      paramVarArgs.field_appId = paramString;
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(101732);
    return paramVarArgs;
  }
  
  public final at a(String paramString, int paramInt, String... paramVarArgs)
  {
    AppMethodBeat.i(101733);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101733);
      return null;
    }
    Object localObject;
    f localf;
    if (j.a.nk(paramInt))
    {
      localObject = "version desc";
      localf = this.gWU;
      if (!bo.Q(paramVarArgs)) {
        break label148;
      }
      paramVarArgs = null;
    }
    label148:
    for (;;)
    {
      localObject = localf.query("AppBrandWxaPkgManifestRecord", paramVarArgs, String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null, (String)localObject);
      if (localObject != null) {
        break label151;
      }
      AppMethodBeat.o(101733);
      return null;
      if (j.a.kQ(paramInt))
      {
        localObject = "createTime desc";
        break;
      }
      paramString = new RuntimeException("Illegal pkgType ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(101733);
      throw paramString;
    }
    label151:
    paramVarArgs = null;
    if (((Cursor)localObject).moveToFirst())
    {
      paramVarArgs = new at();
      paramVarArgs.convertFrom((Cursor)localObject);
      paramVarArgs.field_appId = paramString;
      paramVarArgs.field_debugType = paramInt;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(101733);
    return paramVarArgs;
  }
  
  final List<at> a(String paramString, int paramInt, ay.a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(101730);
    if (bo.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(101730);
      return paramString;
    }
    Object localObject = this.gWU;
    String str = String.format(Locale.US, "%s=? and %s=? ", new Object[] { "appId", "debugType" });
    parama = "version " + parama.name();
    parama = ((f)localObject).a("AppBrandWxaPkgManifestRecord", paramVarArgs, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, parama, 2);
    if (parama == null)
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(101730);
      return paramString;
    }
    if (!parama.moveToFirst())
    {
      parama.close();
      paramString = Collections.emptyList();
      AppMethodBeat.o(101730);
      return paramString;
    }
    paramVarArgs = new LinkedList();
    do
    {
      localObject = new at();
      ((at)localObject).convertFrom(parama);
      ((at)localObject).field_appId = paramString;
      ((at)localObject).field_debugType = paramInt;
      paramVarArgs.add(localObject);
    } while (parama.moveToNext());
    parama.close();
    AppMethodBeat.o(101730);
    return paramVarArgs;
  }
  
  public final boolean a(at paramat)
  {
    AppMethodBeat.i(101739);
    if ((!bo.isNullOrNil(paramat.field_appId)) && (this.gWV.delete(paramat, at.gWB))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        G(paramat.field_appId, paramat.field_debugType, paramat.field_version);
      }
      AppMethodBeat.o(101739);
      return bool;
    }
  }
  
  final boolean a(czn paramczn, PInt paramPInt)
  {
    AppMethodBeat.i(101735);
    if ((paramczn.version < 0) || (bo.isNullOrNil(paramczn.url)) || (bo.isNullOrNil(paramczn.cqq)))
    {
      ab.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[] { Integer.valueOf(paramczn.version), paramczn.url, paramczn.cqq });
      AppMethodBeat.o(101735);
      return false;
    }
    if (paramczn.xCO > 0)
    {
      int i = this.gWU.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[] { "appId", "debugType", "version" }), new String[] { "@LibraryAppId", "0", String.valueOf(paramczn.version) });
      ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[] { Integer.valueOf(paramczn.version), Integer.valueOf(i) });
      paramPInt.value = i;
    }
    boolean bool = a("@LibraryAppId", 0, paramczn.version, paramczn.cqq, paramczn.url);
    AppMethodBeat.o(101735);
    return bool;
  }
  
  public final boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(101743);
    if (!j.a.nk(paramInt1))
    {
      AppMethodBeat.o(101743);
      return false;
    }
    ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, paramString3 });
    int i = av(paramString1, paramInt1);
    if ((!bo.isNullOrNil(paramString1)) && (!paramString1.endsWith("__CODELIB__")) && (paramInt2 < i))
    {
      ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, newVersion( %d ) < curMaxVersion( %d ), skip", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i) });
      AppMethodBeat.o(101743);
      return false;
    }
    if (("@LibraryAppId".equals(paramString1)) && (paramInt2 == an.VERSION))
    {
      ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[] { Integer.valueOf(an.VERSION) });
      AppMethodBeat.o(101743);
      return false;
    }
    at localat = a(paramString1, paramInt2, paramInt1, new String[0]);
    boolean bool1 = false;
    if (localat == null)
    {
      localat = new at();
      localat.field_appId = paramString1;
      localat.field_version = paramInt2;
      localat.field_versionMd5 = paramString2;
      localat.field_downloadURL = paramString3;
      localat.field_debugType = paramInt1;
      bool1 = b(localat);
      ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", new Object[] { Boolean.valueOf(bool1), paramString1, Integer.valueOf(localat.field_version), localat.field_downloadURL, localat.field_versionMd5 });
      AppMethodBeat.o(101743);
      return bool1;
    }
    String str1 = localat.field_downloadURL;
    String str2 = localat.field_versionMd5;
    if (!bo.nullAsNil(localat.field_versionMd5).equals(paramString2))
    {
      localat.field_versionMd5 = paramString2;
      localat.field_version = paramInt2;
      localat.field_downloadURL = paramString3;
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        bool1 = c(localat);
      }
      if ((paramInt1 != 0) && (bool1)) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s", new Object[] { Boolean.valueOf(bool2), paramString1, Integer.valueOf(i), Integer.valueOf(paramInt2), str1, paramString3, str2, paramString2 });
        if ((paramInt1 == 0) || (!bool1)) {
          break label497;
        }
        AppMethodBeat.o(101743);
        return true;
        if ((bo.isNullOrNil(paramString3)) || (paramString3.equals(localat.field_downloadURL))) {
          break label505;
        }
        localat.field_downloadURL = paramString3;
        paramInt1 = 1;
        break;
      }
      label497:
      AppMethodBeat.o(101743);
      return false;
      label505:
      paramInt1 = 0;
    }
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(101738);
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
      AppMethodBeat.o(101738);
      return false;
    }
    ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramString3, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (paramInt == 999) {
      paramString1 = "@LibraryAppId";
    }
    at localat = a(paramString1, 1, paramInt, new String[0]);
    if (localat == null)
    {
      localat = new at();
      localat.field_appId = paramString1;
      localat.field_version = 1;
      localat.field_debugType = paramInt;
      localat.field_downloadURL = paramString2;
      localat.field_versionMd5 = paramString3;
      localat.field_versionState = 0;
      localat.field_startTime = paramLong1;
      localat.field_endTime = paramLong2;
      localat.field_createTime = bo.aox();
      b(localat);
      AppMethodBeat.o(101738);
      return true;
    }
    int i;
    if ((!bo.isNullOrNil(paramString3)) && (!bo.isNullOrNil(localat.field_versionMd5)) && (!paramString3.equals(localat.field_versionMd5)))
    {
      i = 1;
      if (bo.nullAsNil(paramString2).equals(bo.nullAsNil(localat.field_downloadURL))) {
        break label343;
      }
    }
    label343:
    for (int j = 1;; j = 0)
    {
      if (i == 0) {
        break label349;
      }
      localat.field_downloadURL = paramString2;
      e.deleteFile(localat.field_pkgPath);
      localat.field_pkgPath = null;
      localat.field_createTime = bo.aox();
      localat.field_versionMd5 = paramString3;
      localat.field_startTime = paramLong1;
      localat.field_endTime = paramLong2;
      c(localat);
      if (bo.Q(paramString1.split("$"))) {
        G(paramString1, paramInt, 1);
      }
      AppMethodBeat.o(101738);
      return true;
      i = 0;
      break;
    }
    label349:
    if (j != 0)
    {
      localat.field_downloadURL = paramString2;
      localat.field_startTime = paramLong1;
      localat.field_endTime = paramLong2;
      c(localat);
      AppMethodBeat.o(101738);
      return false;
    }
    AppMethodBeat.o(101738);
    return false;
  }
  
  public final boolean a(String paramString, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    AppMethodBeat.i(101746);
    if ((bo.isNullOrNil(paramString)) || (paramWxaVersionInfo == null))
    {
      ab.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramWxaVersionInfo });
      AppMethodBeat.o(101746);
      return false;
    }
    b(paramString, 0, paramWxaVersionInfo.bDc, paramWxaVersionInfo.moduleList);
    ax(paramWxaVersionInfo.hkg);
    if (!bo.isNullOrNil(paramWxaVersionInfo.hkk)) {
      b(paramString, "__WITHOUT_CODELIB__", paramWxaVersionInfo.bDc, 0, paramWxaVersionInfo.hkk, 12);
    }
    boolean bool = a(paramString, 0, paramWxaVersionInfo.bDc, paramWxaVersionInfo.hkd, null);
    AppMethodBeat.o(101746);
    return bool;
  }
  
  public final boolean a(String paramString, czy paramczy, int paramInt)
  {
    AppMethodBeat.i(101744);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramczy });
      AppMethodBeat.o(101744);
      return false;
    }
    boolean bool = a(paramString, paramInt, paramczy.wwX, paramczy.ygG, paramczy.ygH);
    AppMethodBeat.o(101744);
    return bool;
  }
  
  public final boolean at(String paramString, int paramInt)
  {
    AppMethodBeat.i(101737);
    if ((bo.isNullOrNil(paramString)) || (paramInt < 0))
    {
      AppMethodBeat.o(101737);
      return false;
    }
    f localf = this.gWU;
    String str = String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" });
    paramString = localf.a("AppBrandWxaPkgManifestRecord", new String[] { "version" }, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(101737);
      return false;
    }
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(101737);
    return bool;
  }
  
  public final String au(String paramString, int paramInt)
  {
    AppMethodBeat.i(101741);
    paramString = a(paramString, paramInt, new String[] { "downloadURL" });
    if (paramString == null)
    {
      AppMethodBeat.o(101741);
      return "";
    }
    paramString = paramString.field_downloadURL;
    AppMethodBeat.o(101741);
    return paramString;
  }
  
  public final int av(String paramString, int paramInt)
  {
    AppMethodBeat.i(101742);
    if ((bo.isNullOrNil(paramString)) || (!j.a.nk(paramInt)))
    {
      AppMethodBeat.o(101742);
      return 0;
    }
    paramString = a(paramString, paramInt, new String[] { "version" });
    if (paramString == null)
    {
      AppMethodBeat.o(101742);
      return 0;
    }
    paramInt = paramString.field_version;
    AppMethodBeat.o(101742);
    return paramInt;
  }
  
  final int aw(String paramString, int paramInt)
  {
    AppMethodBeat.i(101750);
    if (j.a.nk(0))
    {
      ab.i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, pkgType %d, pkgVersion %d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
      paramInt = this.gWU.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString, "0", String.valueOf(paramInt) });
      AppMethodBeat.o(101750);
      return paramInt;
    }
    AppMethodBeat.o(101750);
    return 0;
  }
  
  final List<at> awg()
  {
    AppMethodBeat.i(101740);
    Object localObject1 = new StringBuilder("debugType");
    ((StringBuilder)localObject1).append(" in (");
    Object localObject2 = j.gUe;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject1).append(localObject2[i]).append(',');
      i += 1;
    }
    ((StringBuilder)localObject1).append(-1).append(')');
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject1 = this.gWU.a("AppBrandWxaPkgManifestRecord", null, (String)localObject1, null, null, null, null, 2);
    if (localObject1 == null)
    {
      AppMethodBeat.o(101740);
      return null;
    }
    if (!((Cursor)localObject1).moveToFirst())
    {
      ((Cursor)localObject1).close();
      AppMethodBeat.o(101740);
      return null;
    }
    localObject2 = new ArrayList();
    do
    {
      at localat = new at();
      localat.convertFrom((Cursor)localObject1);
      ((List)localObject2).add(localat);
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    AppMethodBeat.o(101740);
    return localObject2;
  }
  
  final int ax(String paramString, int paramInt)
  {
    AppMethodBeat.i(101751);
    if (j.a.nk(0))
    {
      ab.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleListBelowVersion appId[%s] pkgType[%d] pkgVersion[%d]", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
      paramString = "'" + paramString + '$' + "%%'";
      paramInt = this.gWU.delete("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "%s like %s and %s=? and %s<?", new Object[] { "appId", paramString, "debugType", "version" }), new String[] { "0", String.valueOf(paramInt) });
      AppMethodBeat.o(101751);
      return paramInt;
    }
    AppMethodBeat.o(101751);
    return 0;
  }
  
  public final void ax(List<WxaAttributes.WxaCodeLibInfo> paramList)
  {
    AppMethodBeat.i(101748);
    if ((paramList != null) && (paramList.size() > 0))
    {
      ab.i("MicroMsg.AppBrandWxaPkgStorage", "updateCodeLibList size:%s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (WxaAttributes.WxaCodeLibInfo)paramList.next();
        Object localObject2 = ((WxaAttributes.WxaCodeLibInfo)localObject1).bsd;
        String str = ((WxaAttributes.WxaCodeLibInfo)localObject1).cqq;
        int i = ((WxaAttributes.WxaCodeLibInfo)localObject1).version;
        if ((!bo.isNullOrNil((String)localObject2)) && (!bo.isNullOrNil(str)))
        {
          localObject1 = new y((String)localObject2, "__CODELIB__").toString();
          localObject2 = yF((String)localObject1);
          if ((localObject2 != null) && (a.contains((int[])localObject2, i))) {
            ab.i("MicroMsg.AppBrandWxaPkgStorage", "already has this codeLib info version:%s", new Object[] { Integer.valueOf(i) });
          } else {
            a((String)localObject1, 0, i, str, null);
          }
        }
      }
    }
    AppMethodBeat.o(101748);
  }
  
  public final int ay(String paramString, int paramInt)
  {
    AppMethodBeat.i(101755);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101755);
      return 0;
    }
    ab.i("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    String str = String.format("%s=? and %s=?", new Object[] { "appId", "debugType" });
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    arrayOfString[1] = String.valueOf(paramInt);
    Object localObject = this.gWU.a("AppBrandWxaPkgManifestRecord", new String[] { "pkgPath" }, str, arrayOfString, null, null, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(101755);
      return 0;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(101755);
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
    int i = this.gWU.delete("AppBrandWxaPkgManifestRecord", str, arrayOfString);
    G(paramString, paramInt, -1);
    AppMethodBeat.o(101755);
    return i;
  }
  
  final List<at> b(String paramString, int paramInt, ay.a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(101731);
    if (bo.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(101731);
      return paramString;
    }
    Object localObject = this.gWU;
    String str = String.format(Locale.US, "%s=? and %s=? ", new Object[] { "appId", "version" });
    parama = "version " + parama.name();
    parama = ((f)localObject).a("AppBrandWxaPkgManifestRecord", paramVarArgs, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, parama, 2);
    if (parama == null)
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(101731);
      return paramString;
    }
    if (!parama.moveToFirst())
    {
      parama.close();
      paramString = Collections.emptyList();
      AppMethodBeat.o(101731);
      return paramString;
    }
    paramVarArgs = new LinkedList();
    do
    {
      localObject = new at();
      ((at)localObject).convertFrom(parama);
      ((at)localObject).field_appId = paramString;
      ((at)localObject).field_version = paramInt;
      paramVarArgs.add(localObject);
    } while (parama.moveToNext());
    parama.close();
    AppMethodBeat.o(101731);
    return paramVarArgs;
  }
  
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(101747);
    if (bo.isNullOrNil(paramString3))
    {
      ab.e("MicroMsg.AppBrandWxaPkgStorage", "updateWithoutCodeLibInfo withoutLibMd5 null appid:%s,modulename:%s!", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(101747);
      return;
    }
    paramString1 = new y(paramString1, paramString2, paramInt3).toString();
    if (paramInt2 == 0)
    {
      a(paramString1, paramInt2, paramInt1, paramString3, null);
      AppMethodBeat.o(101747);
      return;
    }
    a(paramString1, paramInt2, "", paramString3, 0L, 0L);
    AppMethodBeat.o(101747);
  }
  
  public final boolean b(String paramString, int paramInt1, int paramInt2, List<WxaAttributes.WxaVersionModuleInfo> paramList)
  {
    AppMethodBeat.i(101757);
    if ((bo.isNullOrNil(paramString)) || (bo.es(paramList)))
    {
      AppMethodBeat.o(101757);
      return false;
    }
    if (!j.a.nk(paramInt1)) {
      paramInt2 = 1;
    }
    for (;;)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append('{');
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        WxaAttributes.WxaVersionModuleInfo localWxaVersionModuleInfo = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(',').append(localWxaVersionModuleInfo.name).append("::").append(localWxaVersionModuleInfo.cqq);
      }
      ((StringBuilder)localObject1).append('}');
      ab.i("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((StringBuilder)localObject1).toString() });
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localObject1 = (WxaAttributes.WxaVersionModuleInfo)paramList.next();
        localObject2 = new y(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name).toString();
        if (j.a.nk(paramInt1)) {
          a((String)localObject2, paramInt1, paramInt2, ((WxaAttributes.WxaVersionModuleInfo)localObject1).cqq, null);
        }
        for (;;)
        {
          localObject2 = ((WxaAttributes.WxaVersionModuleInfo)localObject1).hkm;
          if ((bo.isNullOrNil(((WxaAttributes.WxaVersionModuleInfo)localObject1).name)) || (bo.isNullOrNil((String)localObject2))) {
            break;
          }
          b(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, paramInt2, paramInt1, (String)localObject2, 13);
          break;
          a((String)localObject2, paramInt1, null, ((WxaAttributes.WxaVersionModuleInfo)localObject1).cqq, 0L, 0L);
        }
      }
      AppMethodBeat.o(101757);
      return true;
    }
  }
  
  public final boolean c(at paramat)
  {
    AppMethodBeat.i(101753);
    ab.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", new Object[] { paramat.field_appId, Integer.valueOf(paramat.field_version), Integer.valueOf(paramat.field_debugType) });
    boolean bool = this.gWV.update(paramat, at.gWB);
    AppMethodBeat.o(101753);
    return bool;
  }
  
  public final void d(at paramat)
  {
    AppMethodBeat.i(101756);
    this.gWV.replace(paramat);
    AppMethodBeat.o(101756);
  }
  
  public final void d(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(101754);
    if ((paramList.size() <= 0) || (paramList1.size() <= 0) || (paramList.size() != paramList1.size()))
    {
      AppMethodBeat.o(101754);
      return;
    }
    ab.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = this.gWU.kr(Thread.currentThread().getId());
    int i = 0;
    while (i < paramList.size())
    {
      ay((String)paramList.get(i), ((Integer)paramList1.get(i)).intValue());
      i += 1;
    }
    this.gWU.nY(l);
    AppMethodBeat.o(101754);
  }
  
  @SuppressLint({"DefaultLocale"})
  public final boolean d(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(101752);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(101752);
      return false;
    }
    if (j.a.kQ(paramInt1)) {
      paramInt2 = 1;
    }
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("pkgPath", paramString2);
    if (this.gWU.update("AppBrandWxaPkgManifestRecord", localContentValues, String.format("%s=? and %s=? and %s=?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString1, String.valueOf(paramInt1), String.valueOf(paramInt2) }) > 0)
    {
      AppMethodBeat.o(101752);
      return true;
    }
    AppMethodBeat.o(101752);
    return false;
  }
  
  public final boolean h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(101745);
    boolean bool = a(paramString1, 0, paramInt, paramString2, null);
    AppMethodBeat.o(101745);
    return bool;
  }
  
  public final int[] yE(String paramString)
  {
    AppMethodBeat.i(101728);
    paramString = yF(paramString);
    AppMethodBeat.o(101728);
    return paramString;
  }
  
  public final int[] yF(String paramString)
  {
    AppMethodBeat.i(101729);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101729);
      return null;
    }
    if (!j.a.nk(0))
    {
      AppMethodBeat.o(101729);
      return null;
    }
    Object localObject = a(paramString, 0, ay.a.gWW, new String[] { "version" });
    if (bo.es((List)localObject))
    {
      AppMethodBeat.o(101729);
      return null;
    }
    paramString = new int[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      paramString[i] = ((at)((Iterator)localObject).next()).field_version;
      i += 1;
    }
    AppMethodBeat.o(101729);
    return paramString;
  }
  
  final boolean yG(String paramString)
  {
    AppMethodBeat.i(101734);
    f localf = this.gWU;
    String str = String.format("%s=?", new Object[] { "pkgPath" });
    paramString = localf.a("AppBrandWxaPkgManifestRecord", new String[] { "appId" }, str, new String[] { paramString }, null, null, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(101734);
      return false;
    }
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(101734);
    return bool;
  }
  
  @SuppressLint({"DefaultLocale"})
  final List<at> yH(String paramString)
  {
    AppMethodBeat.i(101736);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(101736);
      return null;
    }
    if (j.a.nk(0)) {}
    Object localObject3;
    for (Object localObject1 = String.format("order by %s desc", new Object[] { "version" });; localObject1 = String.format("order by %s desc", new Object[] { "createTime" }))
    {
      localObject3 = String.format("limit %d offset %d", new Object[] { Integer.valueOf(2147483647), Integer.valueOf(2) });
      localObject2 = this.gWU;
      localObject1 = String.format("%s=? and %s=? %s %s", new Object[] { "appId", "debugType", localObject1, localObject3 });
      localObject1 = ((f)localObject2).a("AppBrandWxaPkgManifestRecord", new String[] { "pkgPath", "version" }, (String)localObject1, new String[] { paramString, "0" }, null, null, null, 2);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(101736);
      return null;
    }
    Object localObject2 = new ArrayList();
    if (((Cursor)localObject1).moveToFirst()) {
      do
      {
        localObject3 = new at();
        ((at)localObject3).field_appId = paramString;
        ((at)localObject3).field_debugType = 0;
        ((at)localObject3).convertFrom((Cursor)localObject1);
        ((List)localObject2).add(localObject3);
      } while (((Cursor)localObject1).moveToNext());
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(101736);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ay
 * JD-Core Version:    0.7.0.1
 */
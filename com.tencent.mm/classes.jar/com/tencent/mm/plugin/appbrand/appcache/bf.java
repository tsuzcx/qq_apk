package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dud;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class bf
  implements j
{
  public static final String[] iOD;
  public final f iOE;
  public final bf.b iOF;
  
  static
  {
    AppMethodBeat.i(146044);
    iOD = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(bb.gLr, "AppBrandWxaPkgManifestRecord") };
    AppMethodBeat.o(146044);
  }
  
  public bf(f paramf)
  {
    AppMethodBeat.i(146012);
    this.iOE = paramf;
    this.iOF = new bf.b(paramf);
    AppMethodBeat.o(146012);
  }
  
  /* Error */
  private boolean c(bb parambb)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 72
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 78	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   10: ldc 80
    //   12: iconst_4
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc 37
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 82
    //   25: aastore
    //   26: dup
    //   27: iconst_2
    //   28: ldc 84
    //   30: aastore
    //   31: dup
    //   32: iconst_3
    //   33: ldc 86
    //   35: aastore
    //   36: invokestatic 90	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   39: astore 4
    //   41: aload_0
    //   42: getfield 56	com/tencent/mm/plugin/appbrand/appcache/bf:iOE	Lcom/tencent/mm/sdk/e/f;
    //   45: aload 4
    //   47: iconst_3
    //   48: anewarray 29	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: getfield 94	com/tencent/mm/plugin/appbrand/appcache/bb:field_appId	Ljava/lang/String;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: new 96	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   67: aload_1
    //   68: getfield 101	com/tencent/mm/plugin/appbrand/appcache/bb:field_debugType	I
    //   71: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: aastore
    //   78: dup
    //   79: iconst_2
    //   80: new 96	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   87: aload_1
    //   88: getfield 112	com/tencent/mm/plugin/appbrand/appcache/bb:field_version	I
    //   91: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: aastore
    //   98: invokeinterface 118 3 0
    //   103: astore 5
    //   105: aconst_null
    //   106: astore 4
    //   108: aload 5
    //   110: ifnull +45 -> 155
    //   113: aload 5
    //   115: invokeinterface 124 1 0
    //   120: ifeq +35 -> 155
    //   123: aload 5
    //   125: iconst_0
    //   126: invokeinterface 128 2 0
    //   131: istore_2
    //   132: iload_2
    //   133: ifle +22 -> 155
    //   136: aload 5
    //   138: ifnull +10 -> 148
    //   141: aload 5
    //   143: invokeinterface 131 1 0
    //   148: ldc 72
    //   150: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: iload_3
    //   154: ireturn
    //   155: iconst_0
    //   156: istore_3
    //   157: goto -21 -> 136
    //   160: astore 4
    //   162: ldc 72
    //   164: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload 4
    //   169: athrow
    //   170: astore_1
    //   171: aload 5
    //   173: ifnull +15 -> 188
    //   176: aload 4
    //   178: ifnull +29 -> 207
    //   181: aload 5
    //   183: invokeinterface 131 1 0
    //   188: ldc 72
    //   190: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_1
    //   194: athrow
    //   195: astore 5
    //   197: aload 4
    //   199: aload 5
    //   201: invokevirtual 135	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   204: goto -16 -> 188
    //   207: aload 5
    //   209: invokeinterface 131 1 0
    //   214: goto -26 -> 188
    //   217: astore_1
    //   218: goto -47 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	bf
    //   0	221	1	parambb	bb
    //   131	2	2	i	int
    //   1	156	3	bool	boolean
    //   39	68	4	str	String
    //   160	38	4	localThrowable1	java.lang.Throwable
    //   103	79	5	localCursor	Cursor
    //   195	13	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   113	132	160	java/lang/Throwable
    //   162	170	170	finally
    //   181	188	195	java/lang/Throwable
    //   113	132	217	finally
  }
  
  private boolean d(bb parambb)
  {
    AppMethodBeat.i(146034);
    ad.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", new Object[] { parambb.field_appId, Integer.valueOf(parambb.field_debugType), Integer.valueOf(parambb.field_version) });
    boolean bool = this.iOF.insert(parambb);
    AppMethodBeat.o(146034);
    return bool;
  }
  
  private boolean p(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(182783);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(182783);
      return false;
    }
    boolean bool = d(new ab(paramString1, "__PLUGINCODE__").toString(), 0, paramInt, paramString2, null);
    AppMethodBeat.o(182783);
    return bool;
  }
  
  public final boolean D(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146043);
    Locale localLocale = Locale.US;
    if (paramInt2 > 0) {}
    for (String str = "version=".concat(String.valueOf(paramInt2));; str = "1=1")
    {
      str = String.format(localLocale, "where %s like '%s$%%' and %s=%d and %s", new Object[] { "appId", paramString, "debugType", Integer.valueOf(paramInt1), str });
      str = String.format(Locale.US, "delete from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", str });
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      boolean bool = this.iOE.execSQL("AppBrandWxaPkgManifestRecord", str);
      AppMethodBeat.o(146043);
      return bool;
    }
  }
  
  public final int[] El(String paramString)
  {
    AppMethodBeat.i(205919);
    paramString = Em(paramString);
    AppMethodBeat.o(205919);
    return paramString;
  }
  
  public final int[] Em(String paramString)
  {
    AppMethodBeat.i(146014);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    if (!j.a.qD(0))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    Object localObject = a(paramString, 0, bf.a.iOI, new String[] { "version" });
    if (bt.gL((List)localObject))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    paramString = new int[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      paramString[i] = ((bb)((Iterator)localObject).next()).field_version;
      i += 1;
    }
    AppMethodBeat.o(146014);
    return paramString;
  }
  
  public final bb a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    bb localbb = null;
    AppMethodBeat.i(146017);
    Object localObject1 = new StringBuilder();
    Object localObject2 = bb.iOp;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject1).append(localObject2[i]).append("=? and ");
      i += 1;
    }
    ((StringBuilder)localObject1).append("1=1");
    if (j.a.nz(paramInt2)) {
      paramInt1 = 1;
    }
    localObject2 = this.iOE;
    if (bt.T(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject1 = ((f)localObject2).a("AppBrandWxaPkgManifestRecord", paramVarArgs, ((StringBuilder)localObject1).toString(), new String[] { paramString, String.valueOf(paramInt1), String.valueOf(paramInt2) }, null, null, null, 2);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(146017);
      return null;
    }
    paramVarArgs = localbb;
    if (((Cursor)localObject1).moveToFirst())
    {
      localbb = new bb();
      localbb.convertFrom((Cursor)localObject1);
      localbb.field_appId = paramString;
      paramVarArgs = localbb;
      if (paramInt1 > 0)
      {
        localbb.field_version = paramInt1;
        paramVarArgs = localbb;
      }
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(146017);
    return paramVarArgs;
  }
  
  public final bb a(String paramString, int paramInt, String... paramVarArgs)
  {
    Object localObject2 = null;
    AppMethodBeat.i(146018);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146018);
      return null;
    }
    String str;
    Object localObject1;
    String[] arrayOfString;
    f localf;
    if (j.a.qD(paramInt))
    {
      str = "version desc";
      localObject1 = String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" });
      arrayOfString = new String[2];
      arrayOfString[0] = paramString;
      arrayOfString[1] = String.valueOf(paramInt);
      localf = this.iOE;
      if (!bt.T(paramVarArgs)) {
        break label225;
      }
      paramVarArgs = null;
    }
    label225:
    for (;;)
    {
      localObject1 = localf.query("AppBrandWxaPkgManifestRecord", paramVarArgs, (String)localObject1, arrayOfString, null, null, str);
      if (localObject1 != null) {
        break label228;
      }
      AppMethodBeat.o(146018);
      return null;
      if (j.a.nz(paramInt))
      {
        str = "createTime desc";
        localObject1 = String.format(Locale.US, "%s=? and %s=? and %s=?", new Object[] { "appId", "debugType", "version" });
        arrayOfString = new String[3];
        arrayOfString[0] = paramString;
        arrayOfString[1] = String.valueOf(paramInt);
        arrayOfString[2] = "1";
        break;
      }
      paramString = new RuntimeException("Illegal pkgType ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(146018);
      throw paramString;
    }
    label228:
    paramVarArgs = localObject2;
    if (((Cursor)localObject1).moveToFirst())
    {
      paramVarArgs = new bb();
      paramVarArgs.convertFrom((Cursor)localObject1);
      paramVarArgs.field_appId = paramString;
      paramVarArgs.field_debugType = paramInt;
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(146018);
    return paramVarArgs;
  }
  
  final List<bb> a(String paramString, int paramInt, bf.a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(146015);
    if (bt.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146015);
      return paramString;
    }
    Object localObject = this.iOE;
    String str = String.format(Locale.US, "%s=? and %s=? ", new Object[] { "appId", "debugType" });
    parama = "version " + parama.name();
    parama = ((f)localObject).a("AppBrandWxaPkgManifestRecord", paramVarArgs, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, parama, 2);
    if (parama == null)
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146015);
      return paramString;
    }
    if (!parama.moveToFirst())
    {
      parama.close();
      paramString = Collections.emptyList();
      AppMethodBeat.o(146015);
      return paramString;
    }
    paramVarArgs = new LinkedList();
    do
    {
      localObject = new bb();
      ((bb)localObject).convertFrom(parama);
      ((bb)localObject).field_appId = paramString;
      ((bb)localObject).field_debugType = paramInt;
      paramVarArgs.add(localObject);
    } while (parama.moveToNext());
    parama.close();
    AppMethodBeat.o(146015);
    return paramVarArgs;
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, String paramString2, List<WxaAttributes.WxaWidgetInfo> paramList)
  {
    AppMethodBeat.i(177313);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (WxaAttributes.WxaWidgetInfo)paramList.next();
        int i = ((WxaAttributes.WxaWidgetInfo)localObject).deP;
        localObject = ((WxaAttributes.WxaWidgetInfo)localObject).jfP;
        String str = new ab(paramString1, paramString2, i).toString();
        ad.i("MicroMsg.AppBrandWxaPkgStorage", "multiPkg updatePkgInfoList pkgInfoKey:%s,pkgType:%d,codeType:%d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt2) });
        if (paramInt2 == 0) {
          d(str, paramInt2, paramInt1, (String)localObject, null);
        } else {
          a(str, paramInt2, "", (String)localObject, 0L, 0L);
        }
      }
    }
    AppMethodBeat.o(177313);
  }
  
  public final boolean a(bb parambb)
  {
    AppMethodBeat.i(146024);
    if ((!bt.isNullOrNil(parambb.field_appId)) && (this.iOF.delete(parambb, bb.iOp))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        D(parambb.field_appId, parambb.field_debugType, parambb.field_version);
      }
      AppMethodBeat.o(146024);
      return bool;
    }
  }
  
  final boolean a(dud paramdud, PInt paramPInt)
  {
    AppMethodBeat.i(146020);
    if ((paramdud.version < 0) || (bt.isNullOrNil(paramdud.url)) || (bt.isNullOrNil(paramdud.md5)))
    {
      ad.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[] { Integer.valueOf(paramdud.version), paramdud.url, paramdud.md5 });
      AppMethodBeat.o(146020);
      return false;
    }
    if (paramdud.DZz > 0)
    {
      int i = this.iOE.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[] { "appId", "debugType", "version" }), new String[] { "@LibraryAppId", "0", String.valueOf(paramdud.version) });
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[] { Integer.valueOf(paramdud.version), Integer.valueOf(i) });
      paramPInt.value = i;
    }
    boolean bool = d("@LibraryAppId", 0, paramdud.version, paramdud.md5, paramdud.url);
    AppMethodBeat.o(146020);
    return bool;
  }
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, List<WxaAttributes.WxaVersionModuleInfo> paramList)
  {
    AppMethodBeat.i(146042);
    if ((bt.isNullOrNil(paramString)) || (bt.gL(paramList)))
    {
      AppMethodBeat.o(146042);
      return false;
    }
    if (!j.a.qD(paramInt1)) {
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
        ((StringBuilder)localObject1).append(',').append(localWxaVersionModuleInfo.name).append("::").append(localWxaVersionModuleInfo.md5);
      }
      ((StringBuilder)localObject1).append('}');
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((StringBuilder)localObject1).toString() });
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localObject1 = (WxaAttributes.WxaVersionModuleInfo)paramList.next();
        localObject2 = new ab(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name).toString();
        if (j.a.qD(paramInt1)) {
          d((String)localObject2, paramInt1, paramInt2, ((WxaAttributes.WxaVersionModuleInfo)localObject1).md5, null);
        }
        for (;;)
        {
          localObject2 = ((WxaAttributes.WxaVersionModuleInfo)localObject1).jfG;
          if ((!bt.isNullOrNil(((WxaAttributes.WxaVersionModuleInfo)localObject1).name)) && (!bt.isNullOrNil((String)localObject2))) {
            b(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, paramInt2, paramInt1, (String)localObject2, 13);
          }
          a(paramString, paramInt2, paramInt1, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, ((WxaAttributes.WxaVersionModuleInfo)localObject1).jfN);
          break;
          a((String)localObject2, paramInt1, null, ((WxaAttributes.WxaVersionModuleInfo)localObject1).md5, 0L, 0L);
        }
      }
      AppMethodBeat.o(146042);
      return true;
    }
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(146023);
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
      AppMethodBeat.o(146023);
      return false;
    }
    ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramString3, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (paramInt == 999) {
      paramString1 = "@LibraryAppId";
    }
    bb localbb = a(paramString1, 1, paramInt, new String[0]);
    if (localbb == null)
    {
      localbb = new bb();
      localbb.field_appId = paramString1;
      localbb.field_version = 1;
      localbb.field_debugType = paramInt;
      localbb.field_downloadURL = paramString2;
      localbb.field_versionMd5 = paramString3;
      localbb.field_versionState = 0;
      localbb.field_startTime = paramLong1;
      localbb.field_endTime = paramLong2;
      localbb.field_createTime = bt.aGK();
      d(localbb);
      AppMethodBeat.o(146023);
      return true;
    }
    int i;
    if ((!bt.isNullOrNil(paramString3)) && (!bt.isNullOrNil(localbb.field_versionMd5)) && (!paramString3.equals(localbb.field_versionMd5)))
    {
      i = 1;
      if (bt.nullAsNil(paramString2).equals(bt.nullAsNil(localbb.field_downloadURL))) {
        break label351;
      }
    }
    label351:
    for (int j = 1;; j = 0)
    {
      if (i == 0) {
        break label357;
      }
      localbb.field_downloadURL = paramString2;
      i.deleteFile(localbb.field_pkgPath);
      localbb.field_pkgPath = null;
      localbb.field_createTime = bt.aGK();
      localbb.field_versionMd5 = paramString3;
      localbb.field_startTime = paramLong1;
      localbb.field_endTime = paramLong2;
      localbb.field_createTime = bt.aGK();
      e(localbb);
      if (bt.T(paramString1.split("$"))) {
        D(paramString1, paramInt, 1);
      }
      AppMethodBeat.o(146023);
      return true;
      i = 0;
      break;
    }
    label357:
    if (j != 0)
    {
      localbb.field_downloadURL = paramString2;
      localbb.field_startTime = paramLong1;
      localbb.field_endTime = paramLong2;
      e(localbb);
      AppMethodBeat.o(146023);
      return false;
    }
    AppMethodBeat.o(146023);
    return false;
  }
  
  public final boolean a(String paramString, WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    AppMethodBeat.i(146031);
    if ((bt.isNullOrNil(paramString)) || (paramWxaVersionInfo == null))
    {
      ad.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramWxaVersionInfo });
      AppMethodBeat.o(146031);
      return false;
    }
    a(paramString, 0, paramWxaVersionInfo.aAS, paramWxaVersionInfo.moduleList);
    aV(paramWxaVersionInfo.jfB);
    if ((!bt.isNullOrNil(paramWxaVersionInfo.jfG)) && (paramWxaVersionInfo.jfB != null) && (paramWxaVersionInfo.jfB.size() > 0)) {
      b(paramString, "__WITHOUT_PLUGINCODE__", paramWxaVersionInfo.aAS, 0, paramWxaVersionInfo.jfG, 12);
    }
    a(paramString, paramWxaVersionInfo.aAS, 0, "", paramWxaVersionInfo.huK);
    boolean bool = d(paramString, 0, paramWxaVersionInfo.aAS, paramWxaVersionInfo.jfy, null);
    AppMethodBeat.o(146031);
    return bool;
  }
  
  public final boolean a(String paramString, duo paramduo)
  {
    AppMethodBeat.i(177312);
    boolean bool = a(paramString, paramduo, 0);
    AppMethodBeat.o(177312);
    return bool;
  }
  
  public final boolean a(String paramString, duo paramduo, int paramInt)
  {
    AppMethodBeat.i(146029);
    if ((bt.isNullOrNil(paramString)) || (paramduo == null))
    {
      ad.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramduo });
      AppMethodBeat.o(146029);
      return false;
    }
    boolean bool = d(paramString, paramInt, paramduo.CHC, paramduo.EIW, paramduo.EIX);
    AppMethodBeat.o(146029);
    return bool;
  }
  
  public final boolean aI(String paramString, int paramInt)
  {
    AppMethodBeat.i(146022);
    if ((bt.isNullOrNil(paramString)) || (paramInt < 0))
    {
      AppMethodBeat.o(146022);
      return false;
    }
    f localf = this.iOE;
    String str = String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" });
    paramString = localf.a("AppBrandWxaPkgManifestRecord", new String[] { "version" }, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(146022);
      return false;
    }
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(146022);
    return bool;
  }
  
  public final String aJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(146026);
    paramString = a(paramString, paramInt, new String[] { "downloadURL" });
    if (paramString == null)
    {
      AppMethodBeat.o(146026);
      return "";
    }
    paramString = paramString.field_downloadURL;
    AppMethodBeat.o(146026);
    return paramString;
  }
  
  public final int aK(String paramString, int paramInt)
  {
    AppMethodBeat.i(146027);
    if ((bt.isNullOrNil(paramString)) || (!j.a.qD(paramInt)))
    {
      AppMethodBeat.o(146027);
      return 0;
    }
    paramString = a(paramString, paramInt, new String[] { "version" });
    if (paramString == null)
    {
      AppMethodBeat.o(146027);
      return 0;
    }
    paramInt = paramString.field_version;
    AppMethodBeat.o(146027);
    return paramInt;
  }
  
  final int aL(String paramString, int paramInt)
  {
    AppMethodBeat.i(146035);
    if (j.a.qD(0))
    {
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, pkgType %d, pkgVersion %d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
      paramInt = this.iOE.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString, "0", String.valueOf(paramInt) });
      AppMethodBeat.o(146035);
      return paramInt;
    }
    AppMethodBeat.o(146035);
    return 0;
  }
  
  final int aM(String paramString, int paramInt)
  {
    AppMethodBeat.i(146036);
    if (j.a.qD(0))
    {
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleListBelowVersion appId[%s] pkgType[%d] pkgVersion[%d]", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
      String str = "'" + paramString + '$' + "%%'";
      paramString = "'" + paramString + '$' + "__PLUGINCODE__'";
      paramInt = this.iOE.delete("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "%s like %s and %s != %s and %s=? and %s<?", new Object[] { "appId", str, "appId", paramString, "debugType", "version" }), new String[] { "0", String.valueOf(paramInt) });
      AppMethodBeat.o(146036);
      return paramInt;
    }
    AppMethodBeat.o(146036);
    return 0;
  }
  
  public final int aN(String paramString, int paramInt)
  {
    AppMethodBeat.i(146040);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146040);
      return 0;
    }
    ad.i("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    String str = String.format("%s=? and %s=?", new Object[] { "appId", "debugType" });
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    arrayOfString[1] = String.valueOf(paramInt);
    Object localObject = this.iOE.a("AppBrandWxaPkgManifestRecord", new String[] { "pkgPath" }, str, arrayOfString, null, null, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(146040);
      return 0;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(146040);
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
      i.deleteFile((String)((Iterator)localObject).next());
    }
    int i = this.iOE.delete("AppBrandWxaPkgManifestRecord", str, arrayOfString);
    D(paramString, paramInt, -1);
    AppMethodBeat.o(146040);
    return i;
  }
  
  public final void aV(List<WxaAttributes.WxaPluginCodeInfo> paramList)
  {
    AppMethodBeat.i(146033);
    if ((paramList != null) && (paramList.size() > 0))
    {
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "updatePluginCodeList size:%s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WxaAttributes.WxaPluginCodeInfo localWxaPluginCodeInfo = (WxaAttributes.WxaPluginCodeInfo)paramList.next();
        String str1 = localWxaPluginCodeInfo.provider;
        String str2 = localWxaPluginCodeInfo.md5;
        int i = localWxaPluginCodeInfo.version;
        if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2))) {
          p(str1, str2, i);
        }
      }
    }
    AppMethodBeat.o(146033);
  }
  
  final List<bb> b(String paramString, int paramInt, bf.a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(146016);
    if (bt.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146016);
      return paramString;
    }
    Object localObject = this.iOE;
    String str = String.format(Locale.US, "%s=? and %s=? ", new Object[] { "appId", "version" });
    parama = "version " + parama.name();
    parama = ((f)localObject).a("AppBrandWxaPkgManifestRecord", paramVarArgs, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, parama, 2);
    if (parama == null)
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146016);
      return paramString;
    }
    if (!parama.moveToFirst())
    {
      parama.close();
      paramString = Collections.emptyList();
      AppMethodBeat.o(146016);
      return paramString;
    }
    paramVarArgs = new LinkedList();
    do
    {
      localObject = new bb();
      ((bb)localObject).convertFrom(parama);
      ((bb)localObject).field_appId = paramString;
      ((bb)localObject).field_version = paramInt;
      paramVarArgs.add(localObject);
    } while (parama.moveToNext());
    parama.close();
    AppMethodBeat.o(146016);
    return paramVarArgs;
  }
  
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(146032);
    if (bt.isNullOrNil(paramString3))
    {
      ad.e("MicroMsg.AppBrandWxaPkgStorage", "updateWithoutPluginCodeInfo withoutLibMd5 null appid:%s,modulename:%s!", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(146032);
      return;
    }
    paramString1 = new ab(paramString1, paramString2, paramInt3).toString();
    if (paramInt2 == 0)
    {
      d(paramString1, paramInt2, paramInt1, paramString3, null);
      AppMethodBeat.o(146032);
      return;
    }
    a(paramString1, paramInt2, "", paramString3, 0L, 0L);
    AppMethodBeat.o(146032);
  }
  
  public final boolean b(final bb parambb)
  {
    AppMethodBeat.i(182784);
    if (j.a.nz(parambb.field_debugType)) {
      parambb.field_version = 1;
    }
    parambb = new a() {};
    long l = this.iOE.rb(Thread.currentThread().getId());
    parambb = parambb.invoke();
    this.iOE.mX(l);
    boolean bool = ((Boolean)parambb).booleanValue();
    AppMethodBeat.o(182784);
    return bool;
  }
  
  @SuppressLint({"DefaultLocale"})
  public final boolean d(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(146037);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(146037);
      return false;
    }
    if (j.a.nz(paramInt1)) {
      paramInt2 = 1;
    }
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("pkgPath", paramString2);
    if (this.iOE.update("AppBrandWxaPkgManifestRecord", localContentValues, String.format("%s=? and %s=? and %s=?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString1, String.valueOf(paramInt1), String.valueOf(paramInt2) }) > 0)
    {
      AppMethodBeat.o(146037);
      return true;
    }
    AppMethodBeat.o(146037);
    return false;
  }
  
  public final boolean d(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(146028);
    if (!j.a.qD(paramInt1))
    {
      AppMethodBeat.o(146028);
      return false;
    }
    ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, paramString3 });
    if (("@LibraryAppId".equals(paramString1)) && (paramInt2 == aw.VERSION))
    {
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[] { Integer.valueOf(aw.VERSION) });
      AppMethodBeat.o(146028);
      return false;
    }
    bb localbb = a(paramString1, paramInt2, paramInt1, new String[0]);
    boolean bool1 = false;
    if (localbb == null)
    {
      localbb = new bb();
      localbb.field_appId = paramString1;
      localbb.field_version = paramInt2;
      localbb.field_versionMd5 = paramString2;
      localbb.field_downloadURL = paramString3;
      localbb.field_debugType = paramInt1;
      bool1 = d(localbb);
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", new Object[] { Boolean.valueOf(bool1), paramString1, Integer.valueOf(localbb.field_version), localbb.field_downloadURL, localbb.field_versionMd5 });
      AppMethodBeat.o(146028);
      return bool1;
    }
    String str1 = localbb.field_downloadURL;
    String str2 = localbb.field_versionMd5;
    if (!bt.nullAsNil(localbb.field_versionMd5).equals(paramString2))
    {
      localbb.field_versionMd5 = paramString2;
      localbb.field_version = paramInt2;
      localbb.field_downloadURL = paramString3;
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        bool1 = e(localbb);
      }
      if ((paramInt1 != 0) && (bool1)) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s", new Object[] { Boolean.valueOf(bool2), paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt2), str1, paramString3, str2, paramString2 });
        if ((paramInt1 == 0) || (!bool1)) {
          break label430;
        }
        AppMethodBeat.o(146028);
        return true;
        if ((bt.isNullOrNil(paramString3)) || (paramString3.equals(localbb.field_downloadURL))) {
          break label438;
        }
        localbb.field_downloadURL = paramString3;
        paramInt1 = 1;
        break;
      }
      label430:
      AppMethodBeat.o(146028);
      return false;
      label438:
      paramInt1 = 0;
    }
  }
  
  public final void e(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(146039);
    if ((paramList.size() <= 0) || (paramList1.size() <= 0) || (paramList.size() != paramList1.size()))
    {
      AppMethodBeat.o(146039);
      return;
    }
    ad.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = this.iOE.rb(Thread.currentThread().getId());
    int i = 0;
    while (i < paramList.size())
    {
      aN((String)paramList.get(i), ((Integer)paramList1.get(i)).intValue());
      i += 1;
    }
    this.iOE.mX(l);
    AppMethodBeat.o(146039);
  }
  
  public final boolean e(bb parambb)
  {
    AppMethodBeat.i(146038);
    ad.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", new Object[] { parambb.field_appId, Integer.valueOf(parambb.field_version), Integer.valueOf(parambb.field_debugType) });
    boolean bool = this.iOF.update(parambb, bb.iOp);
    AppMethodBeat.o(146038);
    return bool;
  }
  
  public final void f(bb parambb)
  {
    AppMethodBeat.i(146041);
    this.iOF.replace(parambb);
    AppMethodBeat.o(146041);
  }
  
  public final boolean l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(146030);
    boolean bool = d(paramString1, 0, paramInt, paramString2, null);
    AppMethodBeat.o(146030);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bf
 * JD-Core Version:    0.7.0.1
 */
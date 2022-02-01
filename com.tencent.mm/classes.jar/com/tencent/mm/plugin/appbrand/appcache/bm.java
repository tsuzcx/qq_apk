package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.luggage.sdk.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.fni;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.u;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.g.a.a;

public final class bm
  implements j, s<bh>
{
  public static final String[] nHe;
  public final ISQLiteDatabaseEx nHI;
  private final bm.b nHJ;
  
  static
  {
    AppMethodBeat.i(146044);
    nHe = new String[] { MAutoStorage.getCreateSQLs(bh.lqK, "AppBrandWxaPkgManifestRecord") };
    AppMethodBeat.o(146044);
  }
  
  public bm(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    AppMethodBeat.i(146012);
    this.nHI = paramISQLiteDatabaseEx;
    this.nHJ = new bm.b(paramISQLiteDatabaseEx);
    AppMethodBeat.o(146012);
  }
  
  private boolean f(bh parambh)
  {
    AppMethodBeat.i(146034);
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", new Object[] { parambh.field_appId, Integer.valueOf(parambh.field_debugType), Integer.valueOf(parambh.field_version) });
    boolean bool = this.nHJ.insert(parambh);
    AppMethodBeat.o(146034);
    return bool;
  }
  
  private <T> T q(a<T> parama)
  {
    try
    {
      AppMethodBeat.i(232569);
      long l = this.nHI.beginTransaction(Thread.currentThread().getId());
      parama = parama.invoke();
      this.nHI.endTransaction(l);
      AppMethodBeat.o(232569);
      return parama;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private boolean s(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(182783);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(182783);
      return false;
    }
    boolean bool = d(new ae(paramString1, "__PLUGINCODE__").toString(), 0, paramInt, paramString2, null);
    AppMethodBeat.o(182783);
    return bool;
  }
  
  final int E(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(232584);
    if (j.a.za(paramInt1))
    {
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, versionType %d, pkgVersion %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramInt1 = this.nHI.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString, String.valueOf(paramInt1), String.valueOf(paramInt2) });
      AppMethodBeat.o(232584);
      return paramInt1;
    }
    AppMethodBeat.o(232584);
    return 0;
  }
  
  final int F(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(232587);
    if (j.a.za(paramInt1))
    {
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleListBelowVersion appId[%s] versionType[%d] pkgVersion[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      String str = "'" + paramString + '$' + "%%'";
      paramString = "'" + paramString + '$' + "__PLUGINCODE__'";
      paramInt1 = this.nHI.delete("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "%s like %s and %s != %s and %s=? and %s<?", new Object[] { "appId", str, "appId", paramString, "debugType", "version" }), new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) });
      AppMethodBeat.o(232587);
      return paramInt1;
    }
    AppMethodBeat.o(232587);
    return 0;
  }
  
  public final boolean G(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146043);
    Locale localLocale = Locale.US;
    if (paramInt2 > 0) {}
    for (String str = "version=".concat(String.valueOf(paramInt2));; str = "1=1")
    {
      str = String.format(localLocale, "where %s like '%s$%%' and %s=%d and %s", new Object[] { "appId", paramString, "debugType", Integer.valueOf(paramInt1), str });
      str = String.format(Locale.US, "delete from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", str });
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      boolean bool = this.nHI.execSQL("AppBrandWxaPkgManifestRecord", str);
      AppMethodBeat.o(146043);
      return bool;
    }
  }
  
  /* Error */
  public final List<bh> a(ae paramae, int paramInt, a parama)
  {
    // Byte code:
    //   0: ldc_w 265
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 265
    //   13: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: getfield 64	com/tencent/mm/plugin/appbrand/appcache/bm:nHI	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   22: astore 5
    //   24: getstatic 268	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   27: ldc_w 270
    //   30: iconst_2
    //   31: anewarray 5	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: ldc 177
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 179
    //   43: aastore
    //   44: invokestatic 226	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   47: astore 6
    //   49: aload_1
    //   50: invokevirtual 158	com/tencent/mm/plugin/appbrand/appcache/ae:toString	()Ljava/lang/String;
    //   53: astore_1
    //   54: new 198	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 272
    //   61: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_3
    //   65: invokevirtual 275	com/tencent/mm/plugin/appbrand/appcache/bm$a:name	()Ljava/lang/String;
    //   68: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload 5
    //   77: ldc 45
    //   79: aconst_null
    //   80: aload 6
    //   82: iconst_2
    //   83: anewarray 37	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: iload_2
    //   93: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   96: aastore
    //   97: aconst_null
    //   98: aconst_null
    //   99: aload_3
    //   100: iconst_2
    //   101: invokeinterface 279 9 0
    //   106: astore 5
    //   108: aload 5
    //   110: ifnull +17 -> 127
    //   113: aload 5
    //   115: invokeinterface 285 1 0
    //   120: istore 4
    //   122: iload 4
    //   124: ifeq +23 -> 147
    //   127: aload 5
    //   129: ifnull +10 -> 139
    //   132: aload 5
    //   134: invokeinterface 288 1 0
    //   139: ldc_w 265
    //   142: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aconst_null
    //   146: areturn
    //   147: aload 5
    //   149: invokeinterface 291 1 0
    //   154: ifeq +65 -> 219
    //   157: new 293	java/util/LinkedList
    //   160: dup
    //   161: invokespecial 294	java/util/LinkedList:<init>	()V
    //   164: astore_1
    //   165: new 39	com/tencent/mm/plugin/appbrand/appcache/bh
    //   168: dup
    //   169: invokespecial 295	com/tencent/mm/plugin/appbrand/appcache/bh:<init>	()V
    //   172: astore_3
    //   173: aload_3
    //   174: aload 5
    //   176: invokevirtual 299	com/tencent/mm/plugin/appbrand/appcache/bh:convertFrom	(Landroid/database/Cursor;)V
    //   179: aload_1
    //   180: aload_3
    //   181: invokevirtual 303	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   184: pop
    //   185: aload 5
    //   187: invokeinterface 306 1 0
    //   192: istore 4
    //   194: iload 4
    //   196: ifne -31 -> 165
    //   199: aload 5
    //   201: ifnull +10 -> 211
    //   204: aload 5
    //   206: invokeinterface 288 1 0
    //   211: ldc_w 265
    //   214: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: areturn
    //   219: aload 5
    //   221: ifnull +10 -> 231
    //   224: aload 5
    //   226: invokeinterface 288 1 0
    //   231: ldc_w 265
    //   234: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aconst_null
    //   238: areturn
    //   239: astore_3
    //   240: ldc_w 265
    //   243: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_3
    //   247: athrow
    //   248: astore_1
    //   249: aload 5
    //   251: ifnull +14 -> 265
    //   254: aload_3
    //   255: ifnull +38 -> 293
    //   258: aload 5
    //   260: invokeinterface 288 1 0
    //   265: ldc_w 265
    //   268: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: ldc_w 265
    //   277: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aconst_null
    //   281: areturn
    //   282: astore 5
    //   284: aload_3
    //   285: aload 5
    //   287: invokevirtual 310	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   290: goto -25 -> 265
    //   293: aload 5
    //   295: invokeinterface 288 1 0
    //   300: goto -35 -> 265
    //   303: astore_1
    //   304: aconst_null
    //   305: astore_3
    //   306: goto -57 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	bm
    //   0	309	1	paramae	ae
    //   0	309	2	paramInt	int
    //   0	309	3	parama	a
    //   120	75	4	bool	boolean
    //   22	237	5	localObject	Object
    //   282	12	5	localThrowable	java.lang.Throwable
    //   47	34	6	str	String
    // Exception table:
    //   from	to	target	type
    //   113	122	239	java/lang/Throwable
    //   147	165	239	java/lang/Throwable
    //   165	194	239	java/lang/Throwable
    //   240	248	248	finally
    //   18	108	273	java/lang/Throwable
    //   132	139	273	java/lang/Throwable
    //   204	211	273	java/lang/Throwable
    //   224	231	273	java/lang/Throwable
    //   265	273	273	java/lang/Throwable
    //   284	290	273	java/lang/Throwable
    //   293	300	273	java/lang/Throwable
    //   258	265	282	java/lang/Throwable
    //   113	122	303	finally
    //   147	165	303	finally
    //   165	194	303	finally
  }
  
  final List<bh> a(String paramString, int paramInt, a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(146015);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146015);
      return paramString;
    }
    Object localObject = this.nHI;
    String str = String.format(Locale.US, "%s=? and %s=? ", new Object[] { "appId", "debugType" });
    parama = "version " + parama.name();
    parama = ((ISQLiteDatabaseEx)localObject).query("AppBrandWxaPkgManifestRecord", paramVarArgs, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, parama, 2);
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
      localObject = new bh();
      ((bh)localObject).convertFrom(parama);
      ((bh)localObject).field_appId = paramString;
      ((bh)localObject).field_debugType = paramInt;
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
        int i = ((WxaAttributes.WxaWidgetInfo)localObject).fyH;
        localObject = ((WxaAttributes.WxaWidgetInfo)localObject).obR;
        String str = new ae(paramString1, paramString2, i).toString();
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "multiPkg updatePkgInfoList pkgInfoKey:%s,pkgType:%d,codeType:%d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(paramInt2) });
        if (paramInt2 == 0) {
          d(str, paramInt2, paramInt1, (String)localObject, null);
        } else {
          a(str, paramInt2, "", (String)localObject, 0L, 0L);
        }
      }
    }
    AppMethodBeat.o(177313);
  }
  
  final boolean a(fni paramfni, PInt paramPInt)
  {
    AppMethodBeat.i(146020);
    if ((paramfni.version < 0) || (Util.isNullOrNil(paramfni.url)) || (Util.isNullOrNil(paramfni.md5)))
    {
      Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[] { Integer.valueOf(paramfni.version), paramfni.url, paramfni.md5 });
      AppMethodBeat.o(146020);
      return false;
    }
    if (paramfni.TWD > 0)
    {
      int i = this.nHI.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[] { "appId", "debugType", "version" }), new String[] { "@LibraryAppId", "0", String.valueOf(paramfni.version) });
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[] { Integer.valueOf(paramfni.version), Integer.valueOf(i) });
      paramPInt.value = i;
    }
    boolean bool = d("@LibraryAppId", 0, paramfni.version, paramfni.md5, paramfni.url);
    AppMethodBeat.o(146020);
    return bool;
  }
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, List<WxaAttributes.WxaVersionModuleInfo> paramList)
  {
    AppMethodBeat.i(146042);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramList)))
    {
      AppMethodBeat.o(146042);
      return false;
    }
    if (!j.a.za(paramInt1)) {
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
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((StringBuilder)localObject1).toString() });
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localObject1 = (WxaAttributes.WxaVersionModuleInfo)paramList.next();
        localObject2 = new ae(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name).toString();
        if (j.a.za(paramInt1)) {
          d((String)localObject2, paramInt1, paramInt2, ((WxaAttributes.WxaVersionModuleInfo)localObject1).md5, null);
        }
        for (;;)
        {
          localObject2 = ((WxaAttributes.WxaVersionModuleInfo)localObject1).obG;
          if ((!Util.isNullOrNil(((WxaAttributes.WxaVersionModuleInfo)localObject1).name)) && (!Util.isNullOrNil((String)localObject2))) {
            b(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, paramInt2, paramInt1, (String)localObject2, 13);
          }
          a(paramString, paramInt2, paramInt1, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, ((WxaAttributes.WxaVersionModuleInfo)localObject1).obP);
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
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
      AppMethodBeat.o(146023);
      return false;
    }
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramString3, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if (paramInt == 999) {
      paramString1 = "@LibraryAppId";
    }
    bh localbh = b(paramString1, 1, paramInt, new String[0]);
    if (localbh == null)
    {
      localbh = new bh();
      localbh.field_appId = paramString1;
      localbh.field_version = 1;
      localbh.field_debugType = paramInt;
      localbh.field_downloadURL = paramString2;
      localbh.field_versionMd5 = paramString3;
      localbh.field_startTime = paramLong1;
      localbh.field_endTime = paramLong2;
      localbh.field_createTime = Util.nowSecond();
      f(localbh);
      AppMethodBeat.o(146023);
      return true;
    }
    int i;
    if ((!Util.isNullOrNil(paramString3)) && (!Util.isNullOrNil(localbh.field_versionMd5)) && (!paramString3.equals(localbh.field_versionMd5)))
    {
      i = 1;
      if (Util.nullAsNil(paramString2).equals(Util.nullAsNil(localbh.field_downloadURL))) {
        break label345;
      }
    }
    label345:
    for (int j = 1;; j = 0)
    {
      if (i == 0) {
        break label351;
      }
      localbh.field_downloadURL = paramString2;
      u.deleteFile(localbh.field_pkgPath);
      localbh.field_pkgPath = null;
      localbh.field_createTime = Util.nowSecond();
      localbh.field_versionMd5 = paramString3;
      localbh.field_startTime = paramLong1;
      localbh.field_endTime = paramLong2;
      localbh.field_createTime = Util.nowSecond();
      g(localbh);
      if (Util.isNullOrNil(paramString1.split("$"))) {
        G(paramString1, paramInt, 1);
      }
      AppMethodBeat.o(146023);
      return true;
      i = 0;
      break;
    }
    label351:
    if (j != 0)
    {
      localbh.field_downloadURL = paramString2;
      localbh.field_startTime = paramLong1;
      localbh.field_endTime = paramLong2;
      g(localbh);
      AppMethodBeat.o(146023);
      return false;
    }
    AppMethodBeat.o(146023);
    return false;
  }
  
  public final boolean a(final String paramString, final WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    AppMethodBeat.i(232566);
    paramWxaVersionInfo = new a() {};
    boolean bool = ((Boolean)Objects.requireNonNull(d.a("flushWxaAppVersionInfoV2 ".concat(String.valueOf(paramString)), new a() {}))).booleanValue();
    AppMethodBeat.o(232566);
    return bool;
  }
  
  public final boolean a(String paramString, fnt paramfnt, int paramInt)
  {
    AppMethodBeat.i(146029);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramfnt });
      AppMethodBeat.o(146029);
      return false;
    }
    boolean bool = d(paramString, paramInt, paramfnt.RTb, paramfnt.UMi, paramfnt.UMj);
    AppMethodBeat.o(146029);
    return bool;
  }
  
  public final int[] adb(String paramString)
  {
    AppMethodBeat.i(292774);
    paramString = adc(paramString);
    AppMethodBeat.o(292774);
    return paramString;
  }
  
  public final int[] adc(String paramString)
  {
    AppMethodBeat.i(146014);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    if (!j.a.za(0))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    Object localObject = a(paramString, 0, a.nHO, new String[] { "version" });
    if (Util.isNullOrNil((List)localObject))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    paramString = new int[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      paramString[i] = ((bh)((Iterator)localObject).next()).field_version;
      i += 1;
    }
    AppMethodBeat.o(146014);
    return paramString;
  }
  
  public final bh b(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    bh localbh = null;
    AppMethodBeat.i(146017);
    Object localObject1 = new StringBuilder();
    Object localObject2 = bh.nHu;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject1).append(localObject2[i]).append("=? and ");
      i += 1;
    }
    ((StringBuilder)localObject1).append("1=1");
    if (j.a.vB(paramInt2)) {
      paramInt1 = 1;
    }
    localObject2 = this.nHI;
    if (Util.isNullOrNil(paramVarArgs)) {
      paramVarArgs = null;
    }
    for (;;)
    {
      localObject1 = ((ISQLiteDatabaseEx)localObject2).query("AppBrandWxaPkgManifestRecord", paramVarArgs, ((StringBuilder)localObject1).toString(), new String[] { paramString, String.valueOf(paramInt1), String.valueOf(paramInt2) }, null, null, null, 2);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(146017);
      return null;
    }
    paramVarArgs = localbh;
    if (((Cursor)localObject1).moveToFirst())
    {
      localbh = new bh();
      localbh.convertFrom((Cursor)localObject1);
      localbh.field_appId = paramString;
      paramVarArgs = localbh;
      if (paramInt1 > 0)
      {
        localbh.field_version = paramInt1;
        paramVarArgs = localbh;
      }
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(146017);
    return paramVarArgs;
  }
  
  final List<bh> b(String paramString, int paramInt, a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(146016);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146016);
      return paramString;
    }
    Object localObject = this.nHI;
    String str = String.format(Locale.US, "%s=? and %s=? ", new Object[] { "appId", "version" });
    parama = "version " + parama.name();
    parama = ((ISQLiteDatabaseEx)localObject).query("AppBrandWxaPkgManifestRecord", paramVarArgs, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, parama, 2);
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
      localObject = new bh();
      ((bh)localObject).convertFrom(parama);
      ((bh)localObject).field_appId = paramString;
      ((bh)localObject).field_version = paramInt;
      paramVarArgs.add(localObject);
    } while (parama.moveToNext());
    parama.close();
    AppMethodBeat.o(146016);
    return paramVarArgs;
  }
  
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(146032);
    if (Util.isNullOrNil(paramString3))
    {
      Log.e("MicroMsg.AppBrandWxaPkgStorage", "updateWithoutPluginCodeInfo withoutLibMd5 null appid:%s,modulename:%s!", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(146032);
      return;
    }
    paramString1 = new ae(paramString1, paramString2, paramInt3).toString();
    if (paramInt2 == 0)
    {
      d(paramString1, paramInt2, paramInt1, paramString3, null);
      AppMethodBeat.o(146032);
      return;
    }
    a(paramString1, paramInt2, "", paramString3, 0L, 0L);
    AppMethodBeat.o(146032);
  }
  
  final ISQLiteDatabaseEx bHF()
  {
    return this.nHI;
  }
  
  public final void bc(List<WxaAttributes.WxaPluginCodeInfo> paramList)
  {
    AppMethodBeat.i(146033);
    if ((paramList != null) && (paramList.size() > 0))
    {
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "updatePluginCodeList size:%s", new Object[] { Integer.valueOf(paramList.size()) });
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WxaAttributes.WxaPluginCodeInfo localWxaPluginCodeInfo = (WxaAttributes.WxaPluginCodeInfo)paramList.next();
        String str1 = localWxaPluginCodeInfo.provider;
        String str2 = localWxaPluginCodeInfo.md5;
        int i = localWxaPluginCodeInfo.version;
        if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2))) {
          s(str1, str2, i);
        }
      }
    }
    AppMethodBeat.o(146033);
  }
  
  public final boolean bn(String paramString, int paramInt)
  {
    AppMethodBeat.i(146022);
    if ((Util.isNullOrNil(paramString)) || (paramInt < 0))
    {
      AppMethodBeat.o(146022);
      return false;
    }
    ISQLiteDatabaseEx localISQLiteDatabaseEx = this.nHI;
    String str = String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" });
    paramString = localISQLiteDatabaseEx.query("AppBrandWxaPkgManifestRecord", new String[] { "version" }, str, new String[] { paramString, String.valueOf(paramInt) }, null, null, null, 2);
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
  
  public final String bo(String paramString, int paramInt)
  {
    AppMethodBeat.i(146026);
    paramString = c(paramString, paramInt, new String[] { "downloadURL" });
    if (paramString == null)
    {
      AppMethodBeat.o(146026);
      return "";
    }
    paramString = paramString.field_downloadURL;
    AppMethodBeat.o(146026);
    return paramString;
  }
  
  public final int bp(String paramString, int paramInt)
  {
    AppMethodBeat.i(146027);
    if ((Util.isNullOrNil(paramString)) || (!j.a.za(paramInt)))
    {
      AppMethodBeat.o(146027);
      return 0;
    }
    paramString = c(paramString, paramInt, new String[] { "version" });
    if (paramString == null)
    {
      AppMethodBeat.o(146027);
      return 0;
    }
    paramInt = paramString.field_version;
    AppMethodBeat.o(146027);
    return paramInt;
  }
  
  /* Error */
  public final boolean bq(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 592
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 592
    //   16: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: iconst_0
    //   22: invokestatic 556	com/tencent/mm/plugin/appbrand/appcache/j$a:vB	(I)Z
    //   25: ifeq +5 -> 30
    //   28: iconst_1
    //   29: istore_2
    //   30: getstatic 268	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   33: ldc_w 594
    //   36: iconst_3
    //   37: anewarray 5	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: ldc 45
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc 177
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: ldc 181
    //   54: aastore
    //   55: invokestatic 226	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   58: astore 5
    //   60: aload_0
    //   61: getfield 64	com/tencent/mm/plugin/appbrand/appcache/bm:nHI	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   64: aload 5
    //   66: iconst_2
    //   67: anewarray 37	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: new 198	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 407	java/lang/StringBuilder:<init>	()V
    //   79: aload_1
    //   80: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: bipush 37
    //   85: invokevirtual 210	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   88: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: iload_2
    //   95: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   98: aastore
    //   99: iconst_2
    //   100: invokeinterface 598 4 0
    //   105: astore 7
    //   107: aconst_null
    //   108: astore 6
    //   110: aload 7
    //   112: invokeinterface 291 1 0
    //   117: ifeq +40 -> 157
    //   120: aload 7
    //   122: iconst_0
    //   123: invokeinterface 602 2 0
    //   128: istore_3
    //   129: iload_3
    //   130: ifle +27 -> 157
    //   133: iconst_1
    //   134: istore 4
    //   136: aload 7
    //   138: ifnull +10 -> 148
    //   141: aload 7
    //   143: invokeinterface 288 1 0
    //   148: ldc_w 592
    //   151: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iload 4
    //   156: ireturn
    //   157: iconst_0
    //   158: istore 4
    //   160: goto -24 -> 136
    //   163: astore 6
    //   165: ldc_w 592
    //   168: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload 6
    //   173: athrow
    //   174: astore 5
    //   176: aload 7
    //   178: ifnull +15 -> 193
    //   181: aload 6
    //   183: ifnull +71 -> 254
    //   186: aload 7
    //   188: invokeinterface 288 1 0
    //   193: ldc_w 592
    //   196: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload 5
    //   201: athrow
    //   202: astore 5
    //   204: ldc 81
    //   206: ldc_w 604
    //   209: iconst_3
    //   210: anewarray 5	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_1
    //   216: aastore
    //   217: dup
    //   218: iconst_1
    //   219: iconst_0
    //   220: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: aastore
    //   224: dup
    //   225: iconst_2
    //   226: iload_2
    //   227: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: aastore
    //   231: invokestatic 385	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: ldc_w 592
    //   237: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore 7
    //   244: aload 6
    //   246: aload 7
    //   248: invokevirtual 310	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   251: goto -58 -> 193
    //   254: aload 7
    //   256: invokeinterface 288 1 0
    //   261: goto -68 -> 193
    //   264: astore 5
    //   266: goto -90 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	bm
    //   0	269	1	paramString	String
    //   0	269	2	paramInt	int
    //   128	2	3	i	int
    //   134	25	4	bool	boolean
    //   58	7	5	str	String
    //   174	26	5	localObject1	Object
    //   202	1	5	localException	java.lang.Exception
    //   264	1	5	localObject2	Object
    //   108	1	6	localObject3	Object
    //   163	82	6	localThrowable1	java.lang.Throwable
    //   105	82	7	localCursor	Cursor
    //   242	13	7	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   110	129	163	java/lang/Throwable
    //   165	174	174	finally
    //   60	107	202	java/lang/Exception
    //   141	148	202	java/lang/Exception
    //   186	193	202	java/lang/Exception
    //   193	202	202	java/lang/Exception
    //   244	251	202	java/lang/Exception
    //   254	261	202	java/lang/Exception
    //   186	193	242	java/lang/Throwable
    //   110	129	264	finally
  }
  
  public final int br(String paramString, int paramInt)
  {
    AppMethodBeat.i(146040);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146040);
      return 0;
    }
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    String str = String.format("%s=? and %s=?", new Object[] { "appId", "debugType" });
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    arrayOfString[1] = String.valueOf(paramInt);
    Object localObject = this.nHI.query("AppBrandWxaPkgManifestRecord", new String[] { "pkgPath" }, str, arrayOfString, null, null, null, 2);
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
      u.deleteFile((String)((Iterator)localObject).next());
    }
    int i = this.nHI.delete("AppBrandWxaPkgManifestRecord", str, arrayOfString);
    G(paramString, paramInt, -1);
    AppMethodBeat.o(146040);
    return i;
  }
  
  public final bh c(String paramString, int paramInt, String... paramVarArgs)
  {
    Object localObject2 = null;
    AppMethodBeat.i(146018);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146018);
      return null;
    }
    String str;
    Object localObject1;
    String[] arrayOfString;
    ISQLiteDatabaseEx localISQLiteDatabaseEx;
    if (j.a.za(paramInt))
    {
      str = "version desc";
      localObject1 = String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" });
      arrayOfString = new String[2];
      arrayOfString[0] = paramString;
      arrayOfString[1] = String.valueOf(paramInt);
      localISQLiteDatabaseEx = this.nHI;
      if (!Util.isNullOrNil(paramVarArgs)) {
        break label225;
      }
      paramVarArgs = null;
    }
    label225:
    for (;;)
    {
      localObject1 = localISQLiteDatabaseEx.query("AppBrandWxaPkgManifestRecord", paramVarArgs, (String)localObject1, arrayOfString, null, null, str);
      if (localObject1 != null) {
        break label228;
      }
      AppMethodBeat.o(146018);
      return null;
      if (j.a.vB(paramInt))
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
      paramVarArgs = new bh();
      paramVarArgs.convertFrom((Cursor)localObject1);
      paramVarArgs.field_appId = paramString;
      paramVarArgs.field_debugType = paramInt;
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(146018);
    return paramVarArgs;
  }
  
  public final boolean c(bh parambh)
  {
    AppMethodBeat.i(146024);
    if ((!Util.isNullOrNil(parambh.field_appId)) && (this.nHJ.delete(parambh, bh.nHu))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        G(parambh.field_appId, parambh.field_debugType, parambh.field_version);
      }
      AppMethodBeat.o(146024);
      return bool;
    }
  }
  
  public final boolean d(final bh parambh)
  {
    AppMethodBeat.i(182784);
    if (j.a.vB(parambh.field_debugType)) {
      parambh.field_version = 1;
    }
    boolean bool = ((Boolean)q(new a() {})).booleanValue();
    AppMethodBeat.o(182784);
    return bool;
  }
  
  public final boolean d(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(146028);
    if (!j.a.za(paramInt1))
    {
      AppMethodBeat.o(146028);
      return false;
    }
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, paramString3 });
    if (("@LibraryAppId".equals(paramString1)) && (paramInt2 == bb.VERSION))
    {
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[] { Integer.valueOf(bb.VERSION) });
      AppMethodBeat.o(146028);
      return false;
    }
    bh localbh = b(paramString1, paramInt2, paramInt1, new String[0]);
    boolean bool1 = false;
    if (localbh == null)
    {
      localbh = new bh();
      localbh.field_appId = paramString1;
      localbh.field_version = paramInt2;
      localbh.field_versionMd5 = paramString2;
      localbh.field_NewMd5 = null;
      localbh.field_downloadURL = paramString3;
      localbh.field_debugType = paramInt1;
      bool1 = f(localbh);
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", new Object[] { Boolean.valueOf(bool1), paramString1, Integer.valueOf(localbh.field_version), localbh.field_downloadURL, localbh.field_versionMd5 });
      AppMethodBeat.o(146028);
      return bool1;
    }
    String str1 = localbh.field_downloadURL;
    String str2 = localbh.field_versionMd5;
    if (!Util.nullAsNil(localbh.field_versionMd5).equals(paramString2))
    {
      localbh.field_versionMd5 = paramString2;
      localbh.field_NewMd5 = null;
      localbh.field_version = paramInt2;
      localbh.field_downloadURL = paramString3;
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        bool1 = g(localbh);
      }
      if ((paramInt1 != 0) && (bool1)) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s", new Object[] { Boolean.valueOf(bool2), paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt2), str1, paramString3, str2, paramString2 });
        if ((paramInt1 == 0) || (!bool1)) {
          break label442;
        }
        AppMethodBeat.o(146028);
        return true;
        if ((Util.isNullOrNil(paramString3)) || (paramString3.equals(localbh.field_downloadURL))) {
          break label450;
        }
        localbh.field_downloadURL = paramString3;
        paramInt1 = 1;
        break;
      }
      label442:
      AppMethodBeat.o(146028);
      return false;
      label450:
      paramInt1 = 0;
    }
  }
  
  /* Error */
  public final boolean e(bh parambh)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc_w 659
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 268	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   11: ldc_w 661
    //   14: iconst_4
    //   15: anewarray 5	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: ldc 45
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: ldc 177
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: ldc 179
    //   32: aastore
    //   33: dup
    //   34: iconst_3
    //   35: ldc 181
    //   37: aastore
    //   38: invokestatic 226	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: astore 4
    //   43: aload_0
    //   44: getfield 64	com/tencent/mm/plugin/appbrand/appcache/bm:nHI	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   47: aload 4
    //   49: iconst_3
    //   50: anewarray 37	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: getfield 87	com/tencent/mm/plugin/appbrand/appcache/bh:field_appId	Ljava/lang/String;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: new 198	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 407	java/lang/StringBuilder:<init>	()V
    //   69: aload_1
    //   70: getfield 91	com/tencent/mm/plugin/appbrand/appcache/bh:field_debugType	I
    //   73: invokevirtual 664	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: new 198	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 407	java/lang/StringBuilder:<init>	()V
    //   89: aload_1
    //   90: getfield 100	com/tencent/mm/plugin/appbrand/appcache/bh:field_version	I
    //   93: invokevirtual 664	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: aastore
    //   100: invokeinterface 667 3 0
    //   105: astore 5
    //   107: aconst_null
    //   108: astore 4
    //   110: aload 5
    //   112: ifnull +46 -> 158
    //   115: aload 5
    //   117: invokeinterface 306 1 0
    //   122: ifeq +36 -> 158
    //   125: aload 5
    //   127: iconst_0
    //   128: invokeinterface 602 2 0
    //   133: istore_2
    //   134: iload_2
    //   135: ifle +23 -> 158
    //   138: aload 5
    //   140: ifnull +10 -> 150
    //   143: aload 5
    //   145: invokeinterface 288 1 0
    //   150: ldc_w 659
    //   153: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iload_3
    //   157: ireturn
    //   158: iconst_0
    //   159: istore_3
    //   160: goto -22 -> 138
    //   163: astore 4
    //   165: ldc_w 659
    //   168: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload 4
    //   173: athrow
    //   174: astore_1
    //   175: aload 5
    //   177: ifnull +15 -> 192
    //   180: aload 4
    //   182: ifnull +30 -> 212
    //   185: aload 5
    //   187: invokeinterface 288 1 0
    //   192: ldc_w 659
    //   195: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload_1
    //   199: athrow
    //   200: astore 5
    //   202: aload 4
    //   204: aload 5
    //   206: invokevirtual 310	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   209: goto -17 -> 192
    //   212: aload 5
    //   214: invokeinterface 288 1 0
    //   219: goto -27 -> 192
    //   222: astore_1
    //   223: goto -48 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	bm
    //   0	226	1	parambh	bh
    //   133	2	2	i	int
    //   1	159	3	bool	boolean
    //   41	68	4	str	String
    //   163	40	4	localThrowable1	java.lang.Throwable
    //   105	81	5	localCursor	Cursor
    //   200	13	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   115	134	163	java/lang/Throwable
    //   165	174	174	finally
    //   185	192	200	java/lang/Throwable
    //   115	134	222	finally
  }
  
  @SuppressLint({"DefaultLocale"})
  public final boolean f(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(146037);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(146037);
      return false;
    }
    if (j.a.vB(paramInt1)) {
      paramInt2 = 1;
    }
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("pkgPath", paramString2);
    if (this.nHI.update("AppBrandWxaPkgManifestRecord", localContentValues, String.format("%s=? and %s=? and %s=?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString1, String.valueOf(paramInt1), String.valueOf(paramInt2) }) > 0)
    {
      AppMethodBeat.o(146037);
      return true;
    }
    AppMethodBeat.o(146037);
    return false;
  }
  
  public final boolean g(bh parambh)
  {
    AppMethodBeat.i(146038);
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", new Object[] { parambh.field_appId, Integer.valueOf(parambh.field_version), Integer.valueOf(parambh.field_debugType) });
    if (TextUtils.isEmpty(parambh.field_appId))
    {
      AppMethodBeat.o(146038);
      return false;
    }
    if (j.a.vB(parambh.field_debugType)) {
      parambh.field_version = 1;
    }
    boolean bool = this.nHJ.updateNotify(parambh, true, bh.nHu);
    AppMethodBeat.o(146038);
    return bool;
  }
  
  public final String getTableName()
  {
    AppMethodBeat.i(232551);
    String str = this.nHJ.getTableName();
    AppMethodBeat.o(232551);
    return str;
  }
  
  public final void h(bh parambh)
  {
    AppMethodBeat.i(146041);
    this.nHJ.replace(parambh);
    AppMethodBeat.o(146041);
  }
  
  public final void h(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(146039);
    if ((paramList.size() <= 0) || (paramList1.size() <= 0) || (paramList.size() != paramList1.size()))
    {
      AppMethodBeat.o(146039);
      return;
    }
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = this.nHI.beginTransaction(Thread.currentThread().getId());
    int i = 0;
    while (i < paramList.size())
    {
      br((String)paramList.get(i), ((Integer)paramList1.get(i)).intValue());
      i += 1;
    }
    this.nHI.endTransaction(l);
    AppMethodBeat.o(146039);
  }
  
  public final boolean s(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(146030);
    boolean bool = d(paramString1, 0, paramInt, paramString2, null);
    AppMethodBeat.o(146030);
    return bool;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146011);
      nHO = new a("DESC", 0);
      nHP = new a("ASC", 1);
      nHQ = new a[] { nHO, nHP };
      AppMethodBeat.o(146011);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bm
 * JD-Core Version:    0.7.0.1
 */
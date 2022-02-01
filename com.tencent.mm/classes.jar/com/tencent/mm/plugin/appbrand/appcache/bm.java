package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.gkb;
import com.tencent.mm.protocal.protobuf.gks;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import junit.framework.Assert;
import kotlin.g.a.a;

public final class bm
  implements k, u<bh>
{
  public static final String[] qGS;
  public final ISQLiteDatabaseEx qHv;
  public final b qHw;
  
  static
  {
    AppMethodBeat.i(146044);
    qGS = new String[] { MAutoStorage.getCreateSQLs(bh.nVV, "AppBrandWxaPkgManifestRecord") };
    AppMethodBeat.o(146044);
  }
  
  public bm(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    AppMethodBeat.i(146012);
    this.qHv = paramISQLiteDatabaseEx;
    this.qHw = new b(paramISQLiteDatabaseEx);
    AppMethodBeat.o(146012);
  }
  
  private boolean f(bh parambh)
  {
    AppMethodBeat.i(146034);
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", new Object[] { parambh.field_appId, Integer.valueOf(parambh.field_debugType), Integer.valueOf(parambh.field_version) });
    boolean bool = this.qHw.insert(parambh);
    AppMethodBeat.o(146034);
    return bool;
  }
  
  private boolean x(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(182783);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(182783);
      return false;
    }
    boolean bool = d(new af(paramString1, "__PLUGINCODE__").toString(), 0, paramInt, paramString2, null);
    AppMethodBeat.o(182783);
    return bool;
  }
  
  final int I(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(320264);
    if (k.a.zn(paramInt1))
    {
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, versionType %d, pkgVersion %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramInt1 = this.qHv.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString, String.valueOf(paramInt1), String.valueOf(paramInt2) });
      AppMethodBeat.o(320264);
      return paramInt1;
    }
    AppMethodBeat.o(320264);
    return 0;
  }
  
  final int J(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(320266);
    if (k.a.zn(paramInt1))
    {
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleListBelowVersion appId[%s] versionType[%d] pkgVersion[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      String str = "'" + paramString + '$' + "%%'";
      paramString = "'" + paramString + '$' + "__PLUGINCODE__'";
      paramInt1 = this.qHv.delete("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "%s like %s and %s != %s and %s=? and %s<?", new Object[] { "appId", str, "appId", paramString, "debugType", "version" }), new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) });
      AppMethodBeat.o(320266);
      return paramInt1;
    }
    AppMethodBeat.o(320266);
    return 0;
  }
  
  public final boolean K(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146043);
    Locale localLocale = Locale.US;
    if (paramInt2 > 0) {}
    for (String str = "version=".concat(String.valueOf(paramInt2));; str = "1=1")
    {
      str = String.format(localLocale, "where %s like '%s$%%' and %s=%d and %s", new Object[] { "appId", paramString, "debugType", Integer.valueOf(paramInt1), str });
      str = String.format(Locale.US, "delete from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", str });
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      boolean bool = this.qHv.execSQL("AppBrandWxaPkgManifestRecord", str);
      AppMethodBeat.o(146043);
      return bool;
    }
  }
  
  public final int[] Vy(String paramString)
  {
    AppMethodBeat.i(370013);
    paramString = Vz(paramString);
    AppMethodBeat.o(370013);
    return paramString;
  }
  
  public final int[] Vz(String paramString)
  {
    AppMethodBeat.i(146014);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    if (!k.a.zn(0))
    {
      if (BuildInfo.DEBUG) {
        Assert.fail("invalid release pkgType 0");
      }
      AppMethodBeat.o(146014);
      return null;
    }
    Object localObject = a(paramString, 0, bm.a.qHD, new String[] { "version" });
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
  
  /* Error */
  public final List<bh> a(af paramaf, int paramInt, bm.a parama)
  {
    // Byte code:
    //   0: ldc_w 289
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 289
    //   13: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: getfield 62	com/tencent/mm/plugin/appbrand/appcache/bm:qHv	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   22: astore 5
    //   24: getstatic 292	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   27: ldc_w 294
    //   30: iconst_2
    //   31: anewarray 5	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: ldc 146
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 148
    //   43: aastore
    //   44: invokestatic 197	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   47: astore 6
    //   49: aload_1
    //   50: invokevirtual 128	com/tencent/mm/plugin/appbrand/appcache/af:toString	()Ljava/lang/String;
    //   53: astore_1
    //   54: new 169	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 296
    //   61: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_3
    //   65: invokevirtual 299	com/tencent/mm/plugin/appbrand/appcache/bm$a:name	()Ljava/lang/String;
    //   68: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload 5
    //   77: ldc 43
    //   79: aconst_null
    //   80: aload 6
    //   82: iconst_2
    //   83: anewarray 35	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: iload_2
    //   93: invokestatic 157	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   96: aastore
    //   97: aconst_null
    //   98: aconst_null
    //   99: aload_3
    //   100: iconst_2
    //   101: invokeinterface 303 9 0
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +16 -> 124
    //   111: aload_1
    //   112: invokeinterface 308 1 0
    //   117: istore 4
    //   119: iload 4
    //   121: ifeq +21 -> 142
    //   124: aload_1
    //   125: ifnull +9 -> 134
    //   128: aload_1
    //   129: invokeinterface 311 1 0
    //   134: ldc_w 289
    //   137: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aconst_null
    //   141: areturn
    //   142: aload_1
    //   143: invokeinterface 314 1 0
    //   148: ifeq +64 -> 212
    //   151: new 316	java/util/LinkedList
    //   154: dup
    //   155: invokespecial 317	java/util/LinkedList:<init>	()V
    //   158: astore_3
    //   159: new 37	com/tencent/mm/plugin/appbrand/appcache/bh
    //   162: dup
    //   163: invokespecial 318	com/tencent/mm/plugin/appbrand/appcache/bh:<init>	()V
    //   166: astore 5
    //   168: aload 5
    //   170: aload_1
    //   171: invokevirtual 322	com/tencent/mm/plugin/appbrand/appcache/bh:convertFrom	(Landroid/database/Cursor;)V
    //   174: aload_3
    //   175: aload 5
    //   177: invokevirtual 326	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   180: pop
    //   181: aload_1
    //   182: invokeinterface 329 1 0
    //   187: istore 4
    //   189: iload 4
    //   191: ifne -32 -> 159
    //   194: aload_1
    //   195: ifnull +9 -> 204
    //   198: aload_1
    //   199: invokeinterface 311 1 0
    //   204: ldc_w 289
    //   207: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_3
    //   211: areturn
    //   212: aload_1
    //   213: ifnull +9 -> 222
    //   216: aload_1
    //   217: invokeinterface 311 1 0
    //   222: ldc_w 289
    //   225: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_3
    //   231: aload_1
    //   232: ifnull +9 -> 241
    //   235: aload_1
    //   236: invokeinterface 311 1 0
    //   241: ldc_w 289
    //   244: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload_3
    //   248: athrow
    //   249: astore_1
    //   250: ldc_w 289
    //   253: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_1
    //   259: aload_3
    //   260: aload_1
    //   261: invokevirtual 335	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   264: goto -23 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	bm
    //   0	267	1	paramaf	af
    //   0	267	2	paramInt	int
    //   0	267	3	parama	bm.a
    //   117	73	4	bool	boolean
    //   22	154	5	localObject	Object
    //   47	34	6	str	String
    // Exception table:
    //   from	to	target	type
    //   111	119	230	finally
    //   142	159	230	finally
    //   159	189	230	finally
    //   18	107	249	finally
    //   128	134	249	finally
    //   198	204	249	finally
    //   216	222	249	finally
    //   241	249	249	finally
    //   259	264	249	finally
    //   235	241	258	finally
  }
  
  final List<bh> a(String paramString, int paramInt, bm.a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(146015);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146015);
      return paramString;
    }
    Object localObject = this.qHv;
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
        int i = ((WxaAttributes.WxaWidgetInfo)localObject).hDq;
        localObject = ((WxaAttributes.WxaWidgetInfo)localObject).rcF;
        String str = new af(paramString1, paramString2, i).toString();
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
  
  final boolean a(gkb paramgkb, PInt paramPInt)
  {
    AppMethodBeat.i(146020);
    if ((paramgkb.version < 0) || (Util.isNullOrNil(paramgkb.url)) || (Util.isNullOrNil(paramgkb.md5)))
    {
      Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[] { Integer.valueOf(paramgkb.version), paramgkb.url, paramgkb.md5 });
      AppMethodBeat.o(146020);
      return false;
    }
    if (paramgkb.abns > 0)
    {
      int i = this.qHv.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[] { "appId", "debugType", "version" }), new String[] { "@LibraryAppId", "0", String.valueOf(paramgkb.version) });
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[] { Integer.valueOf(paramgkb.version), Integer.valueOf(i) });
      paramPInt.value = i;
    }
    boolean bool = d("@LibraryAppId", 0, paramgkb.version, paramgkb.md5, paramgkb.url);
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
    if (!k.a.zn(paramInt1)) {
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
        localObject2 = new af(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name).toString();
        if (k.a.zn(paramInt1)) {
          d((String)localObject2, paramInt1, paramInt2, ((WxaAttributes.WxaVersionModuleInfo)localObject1).md5, null);
        }
        for (;;)
        {
          localObject2 = ((WxaAttributes.WxaVersionModuleInfo)localObject1).rct;
          if ((!Util.isNullOrNil(((WxaAttributes.WxaVersionModuleInfo)localObject1).name)) && (!Util.isNullOrNil((String)localObject2))) {
            b(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, paramInt2, paramInt1, (String)localObject2, 13);
          }
          a(paramString, paramInt2, paramInt1, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, ((WxaAttributes.WxaVersionModuleInfo)localObject1).rcD);
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
      y.deleteFile(localbh.field_pkgPath);
      localbh.field_pkgPath = null;
      localbh.field_createTime = Util.nowSecond();
      localbh.field_versionMd5 = paramString3;
      localbh.field_startTime = paramLong1;
      localbh.field_endTime = paramLong2;
      localbh.field_createTime = Util.nowSecond();
      g(localbh);
      if (Util.isNullOrNil(paramString1.split("$"))) {
        K(paramString1, paramInt, 1);
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
  
  public final boolean a(String paramString, gks paramgks, int paramInt)
  {
    AppMethodBeat.i(146029);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramgks });
      AppMethodBeat.o(146029);
      return false;
    }
    boolean bool = d(paramString, paramInt, paramgks.YQB, paramgks.acgC, paramgks.acgD);
    AppMethodBeat.o(146029);
    return bool;
  }
  
  /* Error */
  public final <T> T ai(a<T> parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 504
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 62	com/tencent/mm/plugin/appbrand/appcache/bm:qHv	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   12: invokestatic 510	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15: invokevirtual 513	java/lang/Thread:getId	()J
    //   18: invokeinterface 517 3 0
    //   23: lstore_2
    //   24: aload_1
    //   25: invokeinterface 522 1 0
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 62	com/tencent/mm/plugin/appbrand/appcache/bm:qHv	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   35: lload_2
    //   36: invokeinterface 526 3 0
    //   41: pop
    //   42: ldc_w 504
    //   45: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: areturn
    //   52: astore_1
    //   53: aload_0
    //   54: getfield 62	com/tencent/mm/plugin/appbrand/appcache/bm:qHv	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   57: lload_2
    //   58: invokeinterface 526 3 0
    //   63: pop
    //   64: ldc_w 504
    //   67: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	bm
    //   0	77	1	parama	a<T>
    //   23	35	2	l	long
    // Exception table:
    //   from	to	target	type
    //   24	31	52	finally
    //   2	24	72	finally
    //   31	48	72	finally
    //   53	72	72	finally
  }
  
  public final bh b(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    bh localbh = null;
    AppMethodBeat.i(146017);
    Object localObject1 = new StringBuilder();
    Object localObject2 = bh.qHh;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject1).append(localObject2[i]).append("=? and ");
      i += 1;
    }
    ((StringBuilder)localObject1).append("1=1");
    if (k.a.vK(paramInt2)) {
      paramInt1 = 1;
    }
    localObject2 = this.qHv;
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
  
  final List<bh> b(String paramString, int paramInt, bm.a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(146016);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146016);
      return paramString;
    }
    Object localObject = this.qHv;
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
    paramString1 = new af(paramString1, paramString2, paramInt3).toString();
    if (paramInt2 == 0)
    {
      d(paramString1, paramInt2, paramInt1, paramString3, null);
      AppMethodBeat.o(146032);
      return;
    }
    a(paramString1, paramInt2, "", paramString3, 0L, 0L);
    AppMethodBeat.o(146032);
  }
  
  public final boolean bE(String paramString, int paramInt)
  {
    AppMethodBeat.i(146022);
    if ((Util.isNullOrNil(paramString)) || (paramInt < 0))
    {
      AppMethodBeat.o(146022);
      return false;
    }
    ISQLiteDatabaseEx localISQLiteDatabaseEx = this.qHv;
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
  
  public final String bF(String paramString, int paramInt)
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
  
  public final int bG(String paramString, int paramInt)
  {
    AppMethodBeat.i(146027);
    if ((Util.isNullOrNil(paramString)) || (!k.a.zn(paramInt)))
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
  public final boolean bH(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 555
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 555
    //   16: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: iconst_0
    //   22: invokestatic 536	com/tencent/mm/plugin/appbrand/appcache/k$a:vK	(I)Z
    //   25: ifeq +5 -> 30
    //   28: iconst_1
    //   29: istore_2
    //   30: getstatic 292	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   33: ldc_w 557
    //   36: iconst_3
    //   37: anewarray 5	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: ldc 43
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc 146
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: ldc 150
    //   54: aastore
    //   55: invokestatic 197	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   58: astore 5
    //   60: aload_0
    //   61: getfield 62	com/tencent/mm/plugin/appbrand/appcache/bm:qHv	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   64: aload 5
    //   66: iconst_2
    //   67: anewarray 35	java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: new 169	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   79: aload_1
    //   80: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: bipush 37
    //   85: invokevirtual 181	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   88: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: iload_2
    //   95: invokestatic 157	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   98: aastore
    //   99: iconst_2
    //   100: invokeinterface 561 4 0
    //   105: astore 6
    //   107: aload 6
    //   109: invokeinterface 314 1 0
    //   114: ifeq +40 -> 154
    //   117: aload 6
    //   119: iconst_0
    //   120: invokeinterface 565 2 0
    //   125: istore_3
    //   126: iload_3
    //   127: ifle +27 -> 154
    //   130: iconst_1
    //   131: istore 4
    //   133: aload 6
    //   135: ifnull +10 -> 145
    //   138: aload 6
    //   140: invokeinterface 311 1 0
    //   145: ldc_w 555
    //   148: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: iload 4
    //   153: ireturn
    //   154: iconst_0
    //   155: istore 4
    //   157: goto -24 -> 133
    //   160: astore 5
    //   162: aload 6
    //   164: ifnull +10 -> 174
    //   167: aload 6
    //   169: invokeinterface 311 1 0
    //   174: ldc_w 555
    //   177: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload 5
    //   182: athrow
    //   183: astore 5
    //   185: ldc 80
    //   187: ldc_w 567
    //   190: iconst_3
    //   191: anewarray 5	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_1
    //   197: aastore
    //   198: dup
    //   199: iconst_1
    //   200: iconst_0
    //   201: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: aastore
    //   205: dup
    //   206: iconst_2
    //   207: iload_2
    //   208: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: aastore
    //   212: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: ldc_w 555
    //   218: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: iconst_0
    //   222: ireturn
    //   223: astore 6
    //   225: aload 5
    //   227: aload 6
    //   229: invokevirtual 335	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   232: goto -58 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	bm
    //   0	235	1	paramString	String
    //   0	235	2	paramInt	int
    //   125	2	3	i	int
    //   131	25	4	bool	boolean
    //   58	7	5	str	String
    //   160	21	5	localObject	Object
    //   183	43	5	localException	java.lang.Exception
    //   105	63	6	localCursor	Cursor
    //   223	5	6	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   107	126	160	finally
    //   60	107	183	java/lang/Exception
    //   138	145	183	java/lang/Exception
    //   174	183	183	java/lang/Exception
    //   225	232	183	java/lang/Exception
    //   167	174	223	finally
  }
  
  public final int bI(String paramString, int paramInt)
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
    Object localObject = this.qHv.query("AppBrandWxaPkgManifestRecord", new String[] { "pkgPath" }, str, arrayOfString, null, null, null, 2);
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
      y.deleteFile((String)((Iterator)localObject).next());
    }
    int i = this.qHv.delete("AppBrandWxaPkgManifestRecord", str, arrayOfString);
    K(paramString, paramInt, -1);
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
    if (k.a.zn(paramInt))
    {
      str = "version desc";
      localObject1 = String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" });
      arrayOfString = new String[2];
      arrayOfString[0] = paramString;
      arrayOfString[1] = String.valueOf(paramInt);
      localISQLiteDatabaseEx = this.qHv;
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
      if (k.a.vK(paramInt))
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
    if ((!Util.isNullOrNil(parambh.field_appId)) && (this.qHw.delete(parambh, bh.qHh))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        K(parambh.field_appId, parambh.field_debugType, parambh.field_version);
      }
      AppMethodBeat.o(146024);
      return bool;
    }
  }
  
  public final void cK(List<WxaAttributes.WxaPluginCodeInfo> paramList)
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
          x(str1, str2, i);
        }
      }
    }
    AppMethodBeat.o(146033);
  }
  
  public final List<bh> chb()
  {
    AppMethodBeat.i(320242);
    Object localObject = new StringBuilder("debugType");
    ((StringBuilder)localObject).append(" = 0");
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.qHv.query("AppBrandWxaPkgManifestRecord", null, (String)localObject, null, null, null, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(320242);
      return null;
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(320242);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    do
    {
      bh localbh = new bh();
      localbh.convertFrom((Cursor)localObject);
      localArrayList.add(localbh);
    } while (((Cursor)localObject).moveToNext());
    ((Cursor)localObject).close();
    AppMethodBeat.o(320242);
    return localArrayList;
  }
  
  public final boolean d(final bh parambh)
  {
    AppMethodBeat.i(182784);
    if (k.a.vK(parambh.field_debugType)) {
      parambh.field_version = 1;
    }
    boolean bool = ((Boolean)ai(new a() {})).booleanValue();
    AppMethodBeat.o(182784);
    return bool;
  }
  
  public final boolean d(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(146028);
    if (!k.a.zn(paramInt1))
    {
      if (BuildInfo.DEBUG) {
        Assert.fail("invalid pkgType ".concat(String.valueOf(paramInt1)));
      }
      AppMethodBeat.o(146028);
      return false;
    }
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, paramString3 });
    if (("@LibraryAppId".equals(paramString1)) && (paramInt2 == bc.VERSION))
    {
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[] { Integer.valueOf(bc.VERSION) });
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
          break label461;
        }
        AppMethodBeat.o(146028);
        return true;
        if ((Util.isNullOrNil(paramString3)) || (paramString3.equals(localbh.field_downloadURL))) {
          break label469;
        }
        localbh.field_downloadURL = paramString3;
        paramInt1 = 1;
        break;
      }
      label461:
      AppMethodBeat.o(146028);
      return false;
      label469:
      paramInt1 = 0;
    }
  }
  
  /* Error */
  public final boolean e(bh parambh)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc_w 652
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 292	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   11: ldc_w 654
    //   14: iconst_4
    //   15: anewarray 5	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: ldc 43
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: ldc 146
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: ldc 148
    //   32: aastore
    //   33: dup
    //   34: iconst_3
    //   35: ldc 150
    //   37: aastore
    //   38: invokestatic 197	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: astore 4
    //   43: aload_0
    //   44: getfield 62	com/tencent/mm/plugin/appbrand/appcache/bm:qHv	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   47: aload 4
    //   49: iconst_3
    //   50: anewarray 35	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: getfield 86	com/tencent/mm/plugin/appbrand/appcache/bh:field_appId	Ljava/lang/String;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: new 169	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   69: aload_1
    //   70: getfield 90	com/tencent/mm/plugin/appbrand/appcache/bh:field_debugType	I
    //   73: invokevirtual 657	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: new 169	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   89: aload_1
    //   90: getfield 99	com/tencent/mm/plugin/appbrand/appcache/bh:field_version	I
    //   93: invokevirtual 657	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: aastore
    //   100: invokeinterface 660 3 0
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +46 -> 155
    //   112: aload 4
    //   114: invokeinterface 329 1 0
    //   119: ifeq +36 -> 155
    //   122: aload 4
    //   124: iconst_0
    //   125: invokeinterface 565 2 0
    //   130: istore_2
    //   131: iload_2
    //   132: ifle +23 -> 155
    //   135: aload 4
    //   137: ifnull +10 -> 147
    //   140: aload 4
    //   142: invokeinterface 311 1 0
    //   147: ldc_w 652
    //   150: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: iload_3
    //   154: ireturn
    //   155: iconst_0
    //   156: istore_3
    //   157: goto -22 -> 135
    //   160: astore_1
    //   161: aload 4
    //   163: ifnull +10 -> 173
    //   166: aload 4
    //   168: invokeinterface 311 1 0
    //   173: ldc_w 652
    //   176: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_1
    //   180: athrow
    //   181: astore 4
    //   183: aload_1
    //   184: aload 4
    //   186: invokevirtual 335	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   189: goto -16 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	bm
    //   0	192	1	parambh	bh
    //   130	2	2	i	int
    //   1	156	3	bool	boolean
    //   41	126	4	localObject	Object
    //   181	4	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   112	131	160	finally
    //   166	173	181	finally
  }
  
  public final boolean f(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(146037);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(146037);
      return false;
    }
    if (k.a.vK(paramInt1)) {
      paramInt2 = 1;
    }
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("pkgPath", paramString2);
    if (this.qHv.update("AppBrandWxaPkgManifestRecord", localContentValues, String.format("%s=? and %s=? and %s=?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString1, String.valueOf(paramInt1), String.valueOf(paramInt2) }) > 0)
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
    if (k.a.vK(parambh.field_debugType)) {
      parambh.field_version = 1;
    }
    boolean bool = this.qHw.updateNotify(parambh, true, bh.qHh);
    AppMethodBeat.o(146038);
    return bool;
  }
  
  public final void h(bh parambh)
  {
    AppMethodBeat.i(146041);
    this.qHw.replace(parambh);
    AppMethodBeat.o(146041);
  }
  
  public final boolean u(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(146030);
    boolean bool = d(paramString1, 0, paramInt, paramString2, null);
    AppMethodBeat.o(146030);
    return bool;
  }
  
  public static final class b
    extends MAutoStorage<bh>
  {
    public b(ISQLiteDatabase paramISQLiteDatabase)
    {
      super(bh.nVV, "AppBrandWxaPkgManifestRecord", bh.INDEX_CREATE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.fch;
import com.tencent.mm.protocal.protobuf.fcs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.g.a.a;

public final class bh
  implements j
{
  public static final String[] kNI;
  public final ISQLiteDatabaseEx kNJ;
  public final b kNK;
  
  static
  {
    AppMethodBeat.i(146044);
    kNI = new String[] { MAutoStorage.getCreateSQLs(bd.iBg, "AppBrandWxaPkgManifestRecord") };
    AppMethodBeat.o(146044);
  }
  
  public bh(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    AppMethodBeat.i(146012);
    this.kNJ = paramISQLiteDatabaseEx;
    this.kNK = new b(paramISQLiteDatabaseEx);
    AppMethodBeat.o(146012);
  }
  
  /* Error */
  private boolean c(bd parambd)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 83
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 89	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   10: ldc 91
    //   12: iconst_4
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc 43
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 93
    //   25: aastore
    //   26: dup
    //   27: iconst_2
    //   28: ldc 95
    //   30: aastore
    //   31: dup
    //   32: iconst_3
    //   33: ldc 97
    //   35: aastore
    //   36: invokestatic 101	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   39: astore 4
    //   41: aload_0
    //   42: getfield 62	com/tencent/mm/plugin/appbrand/appcache/bh:kNJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   45: aload 4
    //   47: iconst_3
    //   48: anewarray 35	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: getfield 105	com/tencent/mm/plugin/appbrand/appcache/bd:field_appId	Ljava/lang/String;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: new 107	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   67: aload_1
    //   68: getfield 112	com/tencent/mm/plugin/appbrand/appcache/bd:field_debugType	I
    //   71: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: aastore
    //   78: dup
    //   79: iconst_2
    //   80: new 107	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   87: aload_1
    //   88: getfield 123	com/tencent/mm/plugin/appbrand/appcache/bd:field_version	I
    //   91: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: aastore
    //   98: invokeinterface 129 3 0
    //   103: astore 5
    //   105: aconst_null
    //   106: astore 4
    //   108: aload 5
    //   110: ifnull +45 -> 155
    //   113: aload 5
    //   115: invokeinterface 135 1 0
    //   120: ifeq +35 -> 155
    //   123: aload 5
    //   125: iconst_0
    //   126: invokeinterface 139 2 0
    //   131: istore_2
    //   132: iload_2
    //   133: ifle +22 -> 155
    //   136: aload 5
    //   138: ifnull +10 -> 148
    //   141: aload 5
    //   143: invokeinterface 142 1 0
    //   148: ldc 83
    //   150: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: iload_3
    //   154: ireturn
    //   155: iconst_0
    //   156: istore_3
    //   157: goto -21 -> 136
    //   160: astore 4
    //   162: ldc 83
    //   164: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload 4
    //   169: athrow
    //   170: astore_1
    //   171: aload 5
    //   173: ifnull +15 -> 188
    //   176: aload 4
    //   178: ifnull +29 -> 207
    //   181: aload 5
    //   183: invokeinterface 142 1 0
    //   188: ldc 83
    //   190: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_1
    //   194: athrow
    //   195: astore 5
    //   197: aload 4
    //   199: aload 5
    //   201: invokevirtual 146	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   204: goto -16 -> 188
    //   207: aload 5
    //   209: invokeinterface 142 1 0
    //   214: goto -26 -> 188
    //   217: astore_1
    //   218: goto -47 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	bh
    //   0	221	1	parambd	bd
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
  
  private boolean d(bd parambd)
  {
    AppMethodBeat.i(146034);
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", new Object[] { parambd.field_appId, Integer.valueOf(parambd.field_debugType), Integer.valueOf(parambd.field_version) });
    boolean bool = this.kNK.insert(parambd);
    AppMethodBeat.o(146034);
    return bool;
  }
  
  private boolean e(bd parambd)
  {
    AppMethodBeat.i(146038);
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", new Object[] { parambd.field_appId, Integer.valueOf(parambd.field_version), Integer.valueOf(parambd.field_debugType) });
    boolean bool = this.kNK.update(parambd, bd.kNu);
    AppMethodBeat.o(146038);
    return bool;
  }
  
  private boolean q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(182783);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(182783);
      return false;
    }
    boolean bool = d(new ad(paramString1, "__PLUGINCODE__").toString(), 0, paramInt, paramString2, null);
    AppMethodBeat.o(182783);
    return bool;
  }
  
  private <T> T r(a<T> parama)
  {
    try
    {
      AppMethodBeat.i(229813);
      long l = this.kNJ.beginTransaction(Thread.currentThread().getId());
      parama = parama.invoke();
      this.kNJ.endTransaction(l);
      AppMethodBeat.o(229813);
      return parama;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  final int E(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229814);
    if (j.a.vP(paramInt1))
    {
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, versionType %d, pkgVersion %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramInt1 = this.kNJ.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString, String.valueOf(paramInt1), String.valueOf(paramInt2) });
      AppMethodBeat.o(229814);
      return paramInt1;
    }
    AppMethodBeat.o(229814);
    return 0;
  }
  
  final int F(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229815);
    if (j.a.vP(paramInt1))
    {
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleListBelowVersion appId[%s] versionType[%d] pkgVersion[%d]", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      String str = "'" + paramString + '$' + "%%'";
      paramString = "'" + paramString + '$' + "__PLUGINCODE__'";
      paramInt1 = this.kNJ.delete("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "%s like %s and %s != %s and %s=? and %s<?", new Object[] { "appId", str, "appId", paramString, "debugType", "version" }), new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2) });
      AppMethodBeat.o(229815);
      return paramInt1;
    }
    AppMethodBeat.o(229815);
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
      boolean bool = this.kNJ.execSQL("AppBrandWxaPkgManifestRecord", str);
      AppMethodBeat.o(146043);
      return bool;
    }
  }
  
  public final int[] Vs(String paramString)
  {
    AppMethodBeat.i(258604);
    paramString = Vt(paramString);
    AppMethodBeat.o(258604);
    return paramString;
  }
  
  public final int[] Vt(String paramString)
  {
    AppMethodBeat.i(146014);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    if (!j.a.vP(0))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    Object localObject = a(paramString, 0, a.kNP, new String[] { "version" });
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
      paramString[i] = ((bd)((Iterator)localObject).next()).field_version;
      i += 1;
    }
    AppMethodBeat.o(146014);
    return paramString;
  }
  
  public final bd a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    bd localbd = null;
    AppMethodBeat.i(146017);
    Object localObject1 = new StringBuilder();
    Object localObject2 = bd.kNu;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject1).append(localObject2[i]).append("=? and ");
      i += 1;
    }
    ((StringBuilder)localObject1).append("1=1");
    if (j.a.sE(paramInt2)) {
      paramInt1 = 1;
    }
    localObject2 = this.kNJ;
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
    paramVarArgs = localbd;
    if (((Cursor)localObject1).moveToFirst())
    {
      localbd = new bd();
      localbd.convertFrom((Cursor)localObject1);
      localbd.field_appId = paramString;
      paramVarArgs = localbd;
      if (paramInt1 > 0)
      {
        localbd.field_version = paramInt1;
        paramVarArgs = localbd;
      }
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(146017);
    return paramVarArgs;
  }
  
  public final bd a(String paramString, int paramInt, String... paramVarArgs)
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
    if (j.a.vP(paramInt))
    {
      str = "version desc";
      localObject1 = String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" });
      arrayOfString = new String[2];
      arrayOfString[0] = paramString;
      arrayOfString[1] = String.valueOf(paramInt);
      localISQLiteDatabaseEx = this.kNJ;
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
      if (j.a.sE(paramInt))
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
      paramVarArgs = new bd();
      paramVarArgs.convertFrom((Cursor)localObject1);
      paramVarArgs.field_appId = paramString;
      paramVarArgs.field_debugType = paramInt;
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(146018);
    return paramVarArgs;
  }
  
  /* Error */
  public final List<bd> a(ad paramad, int paramInt, a parama)
  {
    // Byte code:
    //   0: ldc_w 378
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 378
    //   13: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: getfield 62	com/tencent/mm/plugin/appbrand/appcache/bh:kNJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   22: astore 5
    //   24: getstatic 89	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   27: ldc_w 362
    //   30: iconst_2
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: ldc 93
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 95
    //   43: aastore
    //   44: invokestatic 101	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   47: astore 6
    //   49: aload_1
    //   50: invokevirtual 195	com/tencent/mm/plugin/appbrand/appcache/ad:toString	()Ljava/lang/String;
    //   53: astore_1
    //   54: new 107	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 380
    //   61: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_3
    //   65: invokevirtual 383	com/tencent/mm/plugin/appbrand/appcache/bh$a:name	()Ljava/lang/String;
    //   68: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   93: invokestatic 244	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   96: aastore
    //   97: aconst_null
    //   98: aconst_null
    //   99: aload_3
    //   100: iconst_2
    //   101: invokeinterface 348 9 0
    //   106: astore 5
    //   108: aload 5
    //   110: ifnull +17 -> 127
    //   113: aload 5
    //   115: invokeinterface 386 1 0
    //   120: istore 4
    //   122: iload 4
    //   124: ifeq +23 -> 147
    //   127: aload 5
    //   129: ifnull +10 -> 139
    //   132: aload 5
    //   134: invokeinterface 142 1 0
    //   139: ldc_w 378
    //   142: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aconst_null
    //   146: areturn
    //   147: aload 5
    //   149: invokeinterface 351 1 0
    //   154: ifeq +65 -> 219
    //   157: new 388	java/util/LinkedList
    //   160: dup
    //   161: invokespecial 389	java/util/LinkedList:<init>	()V
    //   164: astore_1
    //   165: new 37	com/tencent/mm/plugin/appbrand/appcache/bd
    //   168: dup
    //   169: invokespecial 352	com/tencent/mm/plugin/appbrand/appcache/bd:<init>	()V
    //   172: astore_3
    //   173: aload_3
    //   174: aload 5
    //   176: invokevirtual 356	com/tencent/mm/plugin/appbrand/appcache/bd:convertFrom	(Landroid/database/Cursor;)V
    //   179: aload_1
    //   180: aload_3
    //   181: invokevirtual 393	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   184: pop
    //   185: aload 5
    //   187: invokeinterface 135 1 0
    //   192: istore 4
    //   194: iload 4
    //   196: ifne -31 -> 165
    //   199: aload 5
    //   201: ifnull +10 -> 211
    //   204: aload 5
    //   206: invokeinterface 142 1 0
    //   211: ldc_w 378
    //   214: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: areturn
    //   219: aload 5
    //   221: ifnull +10 -> 231
    //   224: aload 5
    //   226: invokeinterface 142 1 0
    //   231: ldc_w 378
    //   234: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aconst_null
    //   238: areturn
    //   239: astore_3
    //   240: ldc_w 378
    //   243: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_3
    //   247: athrow
    //   248: astore_1
    //   249: aload 5
    //   251: ifnull +14 -> 265
    //   254: aload_3
    //   255: ifnull +38 -> 293
    //   258: aload 5
    //   260: invokeinterface 142 1 0
    //   265: ldc_w 378
    //   268: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: ldc_w 378
    //   277: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aconst_null
    //   281: areturn
    //   282: astore 5
    //   284: aload_3
    //   285: aload 5
    //   287: invokevirtual 146	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   290: goto -25 -> 265
    //   293: aload 5
    //   295: invokeinterface 142 1 0
    //   300: goto -35 -> 265
    //   303: astore_1
    //   304: aconst_null
    //   305: astore_3
    //   306: goto -57 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	bh
    //   0	309	1	paramad	ad
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
  
  final List<bd> a(String paramString, int paramInt, a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(146015);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146015);
      return paramString;
    }
    Object localObject = this.kNJ;
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
      localObject = new bd();
      ((bd)localObject).convertFrom(parama);
      ((bd)localObject).field_appId = paramString;
      ((bd)localObject).field_debugType = paramInt;
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
        int i = ((WxaAttributes.WxaWidgetInfo)localObject).packageType;
        localObject = ((WxaAttributes.WxaWidgetInfo)localObject).lhj;
        String str = new ad(paramString1, paramString2, i).toString();
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
  
  public final boolean a(bd parambd)
  {
    AppMethodBeat.i(146024);
    if ((!Util.isNullOrNil(parambd.field_appId)) && (this.kNK.delete(parambd, bd.kNu))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        G(parambd.field_appId, parambd.field_debugType, parambd.field_version);
      }
      AppMethodBeat.o(146024);
      return bool;
    }
  }
  
  final boolean a(fch paramfch, PInt paramPInt)
  {
    AppMethodBeat.i(146020);
    if ((paramfch.version < 0) || (Util.isNullOrNil(paramfch.url)) || (Util.isNullOrNil(paramfch.md5)))
    {
      Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[] { Integer.valueOf(paramfch.version), paramfch.url, paramfch.md5 });
      AppMethodBeat.o(146020);
      return false;
    }
    if (paramfch.MKJ > 0)
    {
      int i = this.kNJ.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[] { "appId", "debugType", "version" }), new String[] { "@LibraryAppId", "0", String.valueOf(paramfch.version) });
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[] { Integer.valueOf(paramfch.version), Integer.valueOf(i) });
      paramPInt.value = i;
    }
    boolean bool = d("@LibraryAppId", 0, paramfch.version, paramfch.md5, paramfch.url);
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
    if (!j.a.vP(paramInt1)) {
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
        localObject2 = new ad(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name).toString();
        if (j.a.vP(paramInt1)) {
          d((String)localObject2, paramInt1, paramInt2, ((WxaAttributes.WxaVersionModuleInfo)localObject1).md5, null);
        }
        for (;;)
        {
          localObject2 = ((WxaAttributes.WxaVersionModuleInfo)localObject1).lha;
          if ((!Util.isNullOrNil(((WxaAttributes.WxaVersionModuleInfo)localObject1).name)) && (!Util.isNullOrNil((String)localObject2))) {
            b(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, paramInt2, paramInt1, (String)localObject2, 13);
          }
          a(paramString, paramInt2, paramInt1, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, ((WxaAttributes.WxaVersionModuleInfo)localObject1).lhh);
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
    bd localbd = a(paramString1, 1, paramInt, new String[0]);
    if (localbd == null)
    {
      localbd = new bd();
      localbd.field_appId = paramString1;
      localbd.field_version = 1;
      localbd.field_debugType = paramInt;
      localbd.field_downloadURL = paramString2;
      localbd.field_versionMd5 = paramString3;
      localbd.field_startTime = paramLong1;
      localbd.field_endTime = paramLong2;
      localbd.field_createTime = Util.nowSecond();
      d(localbd);
      AppMethodBeat.o(146023);
      return true;
    }
    int i;
    if ((!Util.isNullOrNil(paramString3)) && (!Util.isNullOrNil(localbd.field_versionMd5)) && (!paramString3.equals(localbd.field_versionMd5)))
    {
      i = 1;
      if (Util.nullAsNil(paramString2).equals(Util.nullAsNil(localbd.field_downloadURL))) {
        break label345;
      }
    }
    label345:
    for (int j = 1;; j = 0)
    {
      if (i == 0) {
        break label351;
      }
      localbd.field_downloadURL = paramString2;
      s.deleteFile(localbd.field_pkgPath);
      localbd.field_pkgPath = null;
      localbd.field_createTime = Util.nowSecond();
      localbd.field_versionMd5 = paramString3;
      localbd.field_startTime = paramLong1;
      localbd.field_endTime = paramLong2;
      localbd.field_createTime = Util.nowSecond();
      e(localbd);
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
      localbd.field_downloadURL = paramString2;
      localbd.field_startTime = paramLong1;
      localbd.field_endTime = paramLong2;
      e(localbd);
      AppMethodBeat.o(146023);
      return false;
    }
    AppMethodBeat.o(146023);
    return false;
  }
  
  public final boolean a(final String paramString, final WxaAttributes.WxaVersionInfo paramWxaVersionInfo)
  {
    AppMethodBeat.i(229812);
    paramWxaVersionInfo = new a() {};
    boolean bool = ((Boolean)Objects.requireNonNull(c.a("flushWxaAppVersionInfoV2 ".concat(String.valueOf(paramString)), new a() {}))).booleanValue();
    AppMethodBeat.o(229812);
    return bool;
  }
  
  public final boolean a(String paramString, fcs paramfcs, int paramInt)
  {
    AppMethodBeat.i(146029);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramfcs });
      AppMethodBeat.o(146029);
      return false;
    }
    boolean bool = d(paramString, paramInt, paramfcs.KSa, paramfcs.NyE, paramfcs.NyF);
    AppMethodBeat.o(146029);
    return bool;
  }
  
  public final boolean aW(String paramString, int paramInt)
  {
    AppMethodBeat.i(146022);
    if ((Util.isNullOrNil(paramString)) || (paramInt < 0))
    {
      AppMethodBeat.o(146022);
      return false;
    }
    ISQLiteDatabaseEx localISQLiteDatabaseEx = this.kNJ;
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
  
  public final String aX(String paramString, int paramInt)
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
  
  public final int aY(String paramString, int paramInt)
  {
    AppMethodBeat.i(146027);
    if ((Util.isNullOrNil(paramString)) || (!j.a.vP(paramInt)))
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
  
  public final int aZ(String paramString, int paramInt)
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
    Object localObject = this.kNJ.query("AppBrandWxaPkgManifestRecord", new String[] { "pkgPath" }, str, arrayOfString, null, null, null, 2);
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
      s.deleteFile((String)((Iterator)localObject).next());
    }
    int i = this.kNJ.delete("AppBrandWxaPkgManifestRecord", str, arrayOfString);
    G(paramString, paramInt, -1);
    AppMethodBeat.o(146040);
    return i;
  }
  
  final List<bd> b(String paramString, int paramInt, a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(146016);
    if (Util.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146016);
      return paramString;
    }
    Object localObject = this.kNJ;
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
      localObject = new bd();
      ((bd)localObject).convertFrom(parama);
      ((bd)localObject).field_appId = paramString;
      ((bd)localObject).field_version = paramInt;
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
    paramString1 = new ad(paramString1, paramString2, paramInt3).toString();
    if (paramInt2 == 0)
    {
      d(paramString1, paramInt2, paramInt1, paramString3, null);
      AppMethodBeat.o(146032);
      return;
    }
    a(paramString1, paramInt2, "", paramString3, 0L, 0L);
    AppMethodBeat.o(146032);
  }
  
  public final boolean b(final bd parambd)
  {
    AppMethodBeat.i(182784);
    if (j.a.sE(parambd.field_debugType)) {
      parambd.field_version = 1;
    }
    boolean bool = ((Boolean)r(new a() {})).booleanValue();
    AppMethodBeat.o(182784);
    return bool;
  }
  
  public final void be(List<WxaAttributes.WxaPluginCodeInfo> paramList)
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
          q(str1, str2, i);
        }
      }
    }
    AppMethodBeat.o(146033);
  }
  
  public final boolean d(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(146028);
    if (!j.a.vP(paramInt1))
    {
      AppMethodBeat.o(146028);
      return false;
    }
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, paramString3 });
    if (("@LibraryAppId".equals(paramString1)) && (paramInt2 == ay.VERSION))
    {
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[] { Integer.valueOf(ay.VERSION) });
      AppMethodBeat.o(146028);
      return false;
    }
    bd localbd = a(paramString1, paramInt2, paramInt1, new String[0]);
    boolean bool1 = false;
    if (localbd == null)
    {
      localbd = new bd();
      localbd.field_appId = paramString1;
      localbd.field_version = paramInt2;
      localbd.field_versionMd5 = paramString2;
      localbd.field_NewMd5 = null;
      localbd.field_downloadURL = paramString3;
      localbd.field_debugType = paramInt1;
      bool1 = d(localbd);
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", new Object[] { Boolean.valueOf(bool1), paramString1, Integer.valueOf(localbd.field_version), localbd.field_downloadURL, localbd.field_versionMd5 });
      AppMethodBeat.o(146028);
      return bool1;
    }
    String str1 = localbd.field_downloadURL;
    String str2 = localbd.field_versionMd5;
    if (!Util.nullAsNil(localbd.field_versionMd5).equals(paramString2))
    {
      localbd.field_versionMd5 = paramString2;
      localbd.field_NewMd5 = null;
      localbd.field_version = paramInt2;
      localbd.field_downloadURL = paramString3;
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        bool1 = e(localbd);
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
        if ((Util.isNullOrNil(paramString3)) || (paramString3.equals(localbd.field_downloadURL))) {
          break label450;
        }
        localbd.field_downloadURL = paramString3;
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
  
  @SuppressLint({"DefaultLocale"})
  public final boolean e(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(146037);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(146037);
      return false;
    }
    if (j.a.sE(paramInt1)) {
      paramInt2 = 1;
    }
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("pkgPath", paramString2);
    if (this.kNJ.update("AppBrandWxaPkgManifestRecord", localContentValues, String.format("%s=? and %s=? and %s=?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString1, String.valueOf(paramInt1), String.valueOf(paramInt2) }) > 0)
    {
      AppMethodBeat.o(146037);
      return true;
    }
    AppMethodBeat.o(146037);
    return false;
  }
  
  public final void f(bd parambd)
  {
    AppMethodBeat.i(146041);
    this.kNK.replace(parambd);
    AppMethodBeat.o(146041);
  }
  
  public final void f(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(146039);
    if ((paramList.size() <= 0) || (paramList1.size() <= 0) || (paramList.size() != paramList1.size()))
    {
      AppMethodBeat.o(146039);
      return;
    }
    Log.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = this.kNJ.beginTransaction(Thread.currentThread().getId());
    int i = 0;
    while (i < paramList.size())
    {
      aZ((String)paramList.get(i), ((Integer)paramList1.get(i)).intValue());
      i += 1;
    }
    this.kNJ.endTransaction(l);
    AppMethodBeat.o(146039);
  }
  
  public final boolean r(String paramString1, int paramInt, String paramString2)
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
      kNP = new a("DESC", 0);
      kNQ = new a("ASC", 1);
      kNR = new a[] { kNP, kNQ };
      AppMethodBeat.o(146011);
    }
    
    private a() {}
  }
  
  public static final class b
    extends MAutoStorage<bd>
  {
    public b(ISQLiteDatabase paramISQLiteDatabase)
    {
      super(bd.iBg, "AppBrandWxaPkgManifestRecord", bd.INDEX_CREATE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bh
 * JD-Core Version:    0.7.0.1
 */
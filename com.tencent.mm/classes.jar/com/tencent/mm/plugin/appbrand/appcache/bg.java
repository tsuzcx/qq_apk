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
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.e.e;
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

public final class bg
  implements j
{
  public static final String[] jII;
  public final f jIJ;
  public final b jIK;
  
  static
  {
    AppMethodBeat.i(146044);
    jII = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(bc.hEe, "AppBrandWxaPkgManifestRecord") };
    AppMethodBeat.o(146044);
  }
  
  public bg(f paramf)
  {
    AppMethodBeat.i(146012);
    this.jIJ = paramf;
    this.jIK = new b(paramf);
    AppMethodBeat.o(146012);
  }
  
  /* Error */
  private boolean c(bc parambc)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 73
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 79	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   10: ldc 81
    //   12: iconst_4
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: ldc 39
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 83
    //   25: aastore
    //   26: dup
    //   27: iconst_2
    //   28: ldc 85
    //   30: aastore
    //   31: dup
    //   32: iconst_3
    //   33: ldc 87
    //   35: aastore
    //   36: invokestatic 91	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   39: astore 4
    //   41: aload_0
    //   42: getfield 58	com/tencent/mm/plugin/appbrand/appcache/bg:jIJ	Lcom/tencent/mm/sdk/e/f;
    //   45: aload 4
    //   47: iconst_3
    //   48: anewarray 31	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: getfield 95	com/tencent/mm/plugin/appbrand/appcache/bc:field_appId	Ljava/lang/String;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: new 97	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   67: aload_1
    //   68: getfield 102	com/tencent/mm/plugin/appbrand/appcache/bc:field_debugType	I
    //   71: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: aastore
    //   78: dup
    //   79: iconst_2
    //   80: new 97	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   87: aload_1
    //   88: getfield 113	com/tencent/mm/plugin/appbrand/appcache/bc:field_version	I
    //   91: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: aastore
    //   98: invokeinterface 119 3 0
    //   103: astore 5
    //   105: aconst_null
    //   106: astore 4
    //   108: aload 5
    //   110: ifnull +45 -> 155
    //   113: aload 5
    //   115: invokeinterface 125 1 0
    //   120: ifeq +35 -> 155
    //   123: aload 5
    //   125: iconst_0
    //   126: invokeinterface 129 2 0
    //   131: istore_2
    //   132: iload_2
    //   133: ifle +22 -> 155
    //   136: aload 5
    //   138: ifnull +10 -> 148
    //   141: aload 5
    //   143: invokeinterface 132 1 0
    //   148: ldc 73
    //   150: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: iload_3
    //   154: ireturn
    //   155: iconst_0
    //   156: istore_3
    //   157: goto -21 -> 136
    //   160: astore 4
    //   162: ldc 73
    //   164: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload 4
    //   169: athrow
    //   170: astore_1
    //   171: aload 5
    //   173: ifnull +15 -> 188
    //   176: aload 4
    //   178: ifnull +29 -> 207
    //   181: aload 5
    //   183: invokeinterface 132 1 0
    //   188: ldc 73
    //   190: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_1
    //   194: athrow
    //   195: astore 5
    //   197: aload 4
    //   199: aload 5
    //   201: invokevirtual 136	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   204: goto -16 -> 188
    //   207: aload 5
    //   209: invokeinterface 132 1 0
    //   214: goto -26 -> 188
    //   217: astore_1
    //   218: goto -47 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	bg
    //   0	221	1	parambc	bc
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
  
  private boolean d(bc parambc)
  {
    AppMethodBeat.i(146034);
    ad.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", new Object[] { parambc.field_appId, Integer.valueOf(parambc.field_debugType), Integer.valueOf(parambc.field_version) });
    boolean bool = this.jIK.insert(parambc);
    AppMethodBeat.o(146034);
    return bool;
  }
  
  private <T> T p(a<T> parama)
  {
    AppMethodBeat.i(190878);
    long l = this.jIJ.xO(Thread.currentThread().getId());
    parama = parama.invoke();
    this.jIJ.sJ(l);
    AppMethodBeat.o(190878);
    return parama;
  }
  
  private boolean r(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(182783);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(182783);
      return false;
    }
    boolean bool = d(new ac(paramString1, "__PLUGINCODE__").toString(), 0, paramInt, paramString2, null);
    AppMethodBeat.o(182783);
    return bool;
  }
  
  public final boolean E(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146043);
    Locale localLocale = Locale.US;
    if (paramInt2 > 0) {}
    for (String str = "version=".concat(String.valueOf(paramInt2));; str = "1=1")
    {
      str = String.format(localLocale, "where %s like '%s$%%' and %s=%d and %s", new Object[] { "appId", paramString, "debugType", Integer.valueOf(paramInt1), str });
      str = String.format(Locale.US, "delete from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", str });
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      boolean bool = this.jIJ.execSQL("AppBrandWxaPkgManifestRecord", str);
      AppMethodBeat.o(146043);
      return bool;
    }
  }
  
  public final int[] LG(String paramString)
  {
    AppMethodBeat.i(221586);
    paramString = LH(paramString);
    AppMethodBeat.o(221586);
    return paramString;
  }
  
  public final int[] LH(String paramString)
  {
    AppMethodBeat.i(146014);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    if (!j.a.rQ(0))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    Object localObject = a(paramString, 0, a.jIN, new String[] { "version" });
    if (bt.hj((List)localObject))
    {
      AppMethodBeat.o(146014);
      return null;
    }
    paramString = new int[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      paramString[i] = ((bc)((Iterator)localObject).next()).field_version;
      i += 1;
    }
    AppMethodBeat.o(146014);
    return paramString;
  }
  
  public final bc a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    bc localbc = null;
    AppMethodBeat.i(146017);
    Object localObject1 = new StringBuilder();
    Object localObject2 = bc.jIu;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject1).append(localObject2[i]).append("=? and ");
      i += 1;
    }
    ((StringBuilder)localObject1).append("1=1");
    if (j.a.oN(paramInt2)) {
      paramInt1 = 1;
    }
    localObject2 = this.jIJ;
    if (bt.V(paramVarArgs)) {
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
    paramVarArgs = localbc;
    if (((Cursor)localObject1).moveToFirst())
    {
      localbc = new bc();
      localbc.convertFrom((Cursor)localObject1);
      localbc.field_appId = paramString;
      paramVarArgs = localbc;
      if (paramInt1 > 0)
      {
        localbc.field_version = paramInt1;
        paramVarArgs = localbc;
      }
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(146017);
    return paramVarArgs;
  }
  
  public final bc a(String paramString, int paramInt, String... paramVarArgs)
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
    if (j.a.rQ(paramInt))
    {
      str = "version desc";
      localObject1 = String.format(Locale.US, "%s=? and %s=?", new Object[] { "appId", "debugType" });
      arrayOfString = new String[2];
      arrayOfString[0] = paramString;
      arrayOfString[1] = String.valueOf(paramInt);
      localf = this.jIJ;
      if (!bt.V(paramVarArgs)) {
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
      if (j.a.oN(paramInt))
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
      paramVarArgs = new bc();
      paramVarArgs.convertFrom((Cursor)localObject1);
      paramVarArgs.field_appId = paramString;
      paramVarArgs.field_debugType = paramInt;
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(146018);
    return paramVarArgs;
  }
  
  /* Error */
  public final List<bc> a(ac paramac, int paramInt, a parama)
  {
    // Byte code:
    //   0: ldc_w 334
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 334
    //   13: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: getfield 58	com/tencent/mm/plugin/appbrand/appcache/bg:jIJ	Lcom/tencent/mm/sdk/e/f;
    //   22: astore 5
    //   24: getstatic 79	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   27: ldc_w 315
    //   30: iconst_2
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: ldc 83
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 85
    //   43: aastore
    //   44: invokestatic 91	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   47: astore 6
    //   49: aload_1
    //   50: invokevirtual 203	com/tencent/mm/plugin/appbrand/appcache/ac:toString	()Ljava/lang/String;
    //   53: astore_1
    //   54: new 97	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 336
    //   61: invokespecial 337	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: aload_3
    //   65: invokevirtual 340	com/tencent/mm/plugin/appbrand/appcache/bg$a:name	()Ljava/lang/String;
    //   68: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload 5
    //   77: ldc 39
    //   79: aconst_null
    //   80: aload 6
    //   82: iconst_2
    //   83: anewarray 31	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: iload_2
    //   93: invokestatic 217	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   96: aastore
    //   97: aconst_null
    //   98: aconst_null
    //   99: aload_3
    //   100: iconst_2
    //   101: invokeinterface 301 9 0
    //   106: astore 5
    //   108: aload 5
    //   110: ifnull +17 -> 127
    //   113: aload 5
    //   115: invokeinterface 343 1 0
    //   120: istore 4
    //   122: iload 4
    //   124: ifeq +23 -> 147
    //   127: aload 5
    //   129: ifnull +10 -> 139
    //   132: aload 5
    //   134: invokeinterface 132 1 0
    //   139: ldc_w 334
    //   142: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aconst_null
    //   146: areturn
    //   147: aload 5
    //   149: invokeinterface 304 1 0
    //   154: ifeq +65 -> 219
    //   157: new 345	java/util/LinkedList
    //   160: dup
    //   161: invokespecial 346	java/util/LinkedList:<init>	()V
    //   164: astore_1
    //   165: new 33	com/tencent/mm/plugin/appbrand/appcache/bc
    //   168: dup
    //   169: invokespecial 305	com/tencent/mm/plugin/appbrand/appcache/bc:<init>	()V
    //   172: astore_3
    //   173: aload_3
    //   174: aload 5
    //   176: invokevirtual 309	com/tencent/mm/plugin/appbrand/appcache/bc:convertFrom	(Landroid/database/Cursor;)V
    //   179: aload_1
    //   180: aload_3
    //   181: invokevirtual 350	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   184: pop
    //   185: aload 5
    //   187: invokeinterface 125 1 0
    //   192: istore 4
    //   194: iload 4
    //   196: ifne -31 -> 165
    //   199: aload 5
    //   201: ifnull +10 -> 211
    //   204: aload 5
    //   206: invokeinterface 132 1 0
    //   211: ldc_w 334
    //   214: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: areturn
    //   219: aload 5
    //   221: ifnull +10 -> 231
    //   224: aload 5
    //   226: invokeinterface 132 1 0
    //   231: ldc_w 334
    //   234: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aconst_null
    //   238: areturn
    //   239: astore_3
    //   240: ldc_w 334
    //   243: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_3
    //   247: athrow
    //   248: astore_1
    //   249: aload 5
    //   251: ifnull +14 -> 265
    //   254: aload_3
    //   255: ifnull +38 -> 293
    //   258: aload 5
    //   260: invokeinterface 132 1 0
    //   265: ldc_w 334
    //   268: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: ldc_w 334
    //   277: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aconst_null
    //   281: areturn
    //   282: astore 5
    //   284: aload_3
    //   285: aload 5
    //   287: invokevirtual 136	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   290: goto -25 -> 265
    //   293: aload 5
    //   295: invokeinterface 132 1 0
    //   300: goto -35 -> 265
    //   303: astore_1
    //   304: aconst_null
    //   305: astore_3
    //   306: goto -57 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	bg
    //   0	309	1	paramac	ac
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
  
  final List<bc> a(String paramString, int paramInt, a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(146015);
    if (bt.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146015);
      return paramString;
    }
    Object localObject = this.jIJ;
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
      localObject = new bc();
      ((bc)localObject).convertFrom(parama);
      ((bc)localObject).field_appId = paramString;
      ((bc)localObject).field_debugType = paramInt;
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
        int i = ((WxaAttributes.WxaWidgetInfo)localObject).dnF;
        localObject = ((WxaAttributes.WxaWidgetInfo)localObject).kan;
        String str = new ac(paramString1, paramString2, i).toString();
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
  
  public final boolean a(bc parambc)
  {
    AppMethodBeat.i(146024);
    if ((!bt.isNullOrNil(parambc.field_appId)) && (this.jIK.delete(parambc, bc.jIu))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        E(parambc.field_appId, parambc.field_debugType, parambc.field_version);
      }
      AppMethodBeat.o(146024);
      return bool;
    }
  }
  
  final boolean a(efy paramefy, PInt paramPInt)
  {
    AppMethodBeat.i(146020);
    if ((paramefy.version < 0) || (bt.isNullOrNil(paramefy.url)) || (bt.isNullOrNil(paramefy.md5)))
    {
      ad.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[] { Integer.valueOf(paramefy.version), paramefy.url, paramefy.md5 });
      AppMethodBeat.o(146020);
      return false;
    }
    if (paramefy.HgA > 0)
    {
      int i = this.jIJ.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[] { "appId", "debugType", "version" }), new String[] { "@LibraryAppId", "0", String.valueOf(paramefy.version) });
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[] { Integer.valueOf(paramefy.version), Integer.valueOf(i) });
      paramPInt.value = i;
    }
    boolean bool = d("@LibraryAppId", 0, paramefy.version, paramefy.md5, paramefy.url);
    AppMethodBeat.o(146020);
    return bool;
  }
  
  public final boolean a(String paramString, int paramInt1, int paramInt2, List<WxaAttributes.WxaVersionModuleInfo> paramList)
  {
    AppMethodBeat.i(146042);
    if ((bt.isNullOrNil(paramString)) || (bt.hj(paramList)))
    {
      AppMethodBeat.o(146042);
      return false;
    }
    if (!j.a.rQ(paramInt1)) {
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
        localObject2 = new ac(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name).toString();
        if (j.a.rQ(paramInt1)) {
          d((String)localObject2, paramInt1, paramInt2, ((WxaAttributes.WxaVersionModuleInfo)localObject1).md5, null);
        }
        for (;;)
        {
          localObject2 = ((WxaAttributes.WxaVersionModuleInfo)localObject1).kae;
          if ((!bt.isNullOrNil(((WxaAttributes.WxaVersionModuleInfo)localObject1).name)) && (!bt.isNullOrNil((String)localObject2))) {
            b(paramString, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, paramInt2, paramInt1, (String)localObject2, 13);
          }
          a(paramString, paramInt2, paramInt1, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name, ((WxaAttributes.WxaVersionModuleInfo)localObject1).kal);
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
    bc localbc = a(paramString1, 1, paramInt, new String[0]);
    if (localbc == null)
    {
      localbc = new bc();
      localbc.field_appId = paramString1;
      localbc.field_version = 1;
      localbc.field_debugType = paramInt;
      localbc.field_downloadURL = paramString2;
      localbc.field_versionMd5 = paramString3;
      localbc.field_startTime = paramLong1;
      localbc.field_endTime = paramLong2;
      localbc.field_createTime = bt.aQJ();
      d(localbc);
      AppMethodBeat.o(146023);
      return true;
    }
    int i;
    if ((!bt.isNullOrNil(paramString3)) && (!bt.isNullOrNil(localbc.field_versionMd5)) && (!paramString3.equals(localbc.field_versionMd5)))
    {
      i = 1;
      if (bt.nullAsNil(paramString2).equals(bt.nullAsNil(localbc.field_downloadURL))) {
        break label345;
      }
    }
    label345:
    for (int j = 1;; j = 0)
    {
      if (i == 0) {
        break label351;
      }
      localbc.field_downloadURL = paramString2;
      i.deleteFile(localbc.field_pkgPath);
      localbc.field_pkgPath = null;
      localbc.field_createTime = bt.aQJ();
      localbc.field_versionMd5 = paramString3;
      localbc.field_startTime = paramLong1;
      localbc.field_endTime = paramLong2;
      localbc.field_createTime = bt.aQJ();
      e(localbc);
      if (bt.V(paramString1.split("$"))) {
        E(paramString1, paramInt, 1);
      }
      AppMethodBeat.o(146023);
      return true;
      i = 0;
      break;
    }
    label351:
    if (j != 0)
    {
      localbc.field_downloadURL = paramString2;
      localbc.field_startTime = paramLong1;
      localbc.field_endTime = paramLong2;
      e(localbc);
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
    a(paramString, 0, paramWxaVersionInfo.aDD, paramWxaVersionInfo.moduleList);
    aU(paramWxaVersionInfo.jZZ);
    if ((!bt.isNullOrNil(paramWxaVersionInfo.kae)) && (paramWxaVersionInfo.jZZ != null) && (paramWxaVersionInfo.jZZ.size() > 0)) {
      b(paramString, "__WITHOUT_PLUGINCODE__", paramWxaVersionInfo.aDD, 0, paramWxaVersionInfo.kae, 12);
    }
    a(paramString, paramWxaVersionInfo.aDD, 0, "", paramWxaVersionInfo.ioH);
    boolean bool = d(paramString, 0, paramWxaVersionInfo.aDD, paramWxaVersionInfo.jZW, null);
    AppMethodBeat.o(146031);
    return bool;
  }
  
  public final boolean a(String paramString, egj paramegj)
  {
    AppMethodBeat.i(177312);
    boolean bool = a(paramString, paramegj, 0);
    AppMethodBeat.o(177312);
    return bool;
  }
  
  public final boolean a(String paramString, egj paramegj, int paramInt)
  {
    AppMethodBeat.i(146029);
    if ((bt.isNullOrNil(paramString)) || (paramegj == null))
    {
      ad.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[] { paramString, paramegj });
      AppMethodBeat.o(146029);
      return false;
    }
    boolean bool = d(paramString, paramInt, paramegj.FFN, paramegj.HRv, paramegj.HRw);
    AppMethodBeat.o(146029);
    return bool;
  }
  
  public final boolean aO(String paramString, int paramInt)
  {
    AppMethodBeat.i(146022);
    if ((bt.isNullOrNil(paramString)) || (paramInt < 0))
    {
      AppMethodBeat.o(146022);
      return false;
    }
    f localf = this.jIJ;
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
  
  public final String aP(String paramString, int paramInt)
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
  
  public final int aQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(146027);
    if ((bt.isNullOrNil(paramString)) || (!j.a.rQ(paramInt)))
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
  
  final int aR(String paramString, int paramInt)
  {
    AppMethodBeat.i(146035);
    if (j.a.rQ(0))
    {
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, pkgType %d, pkgVersion %d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
      paramInt = this.jIJ.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString, "0", String.valueOf(paramInt) });
      AppMethodBeat.o(146035);
      return paramInt;
    }
    AppMethodBeat.o(146035);
    return 0;
  }
  
  final int aS(String paramString, int paramInt)
  {
    AppMethodBeat.i(146036);
    if (j.a.rQ(0))
    {
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleListBelowVersion appId[%s] pkgType[%d] pkgVersion[%d]", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
      String str = "'" + paramString + '$' + "%%'";
      paramString = "'" + paramString + '$' + "__PLUGINCODE__'";
      paramInt = this.jIJ.delete("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "%s like %s and %s != %s and %s=? and %s<?", new Object[] { "appId", str, "appId", paramString, "debugType", "version" }), new String[] { "0", String.valueOf(paramInt) });
      AppMethodBeat.o(146036);
      return paramInt;
    }
    AppMethodBeat.o(146036);
    return 0;
  }
  
  public final int aT(String paramString, int paramInt)
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
    Object localObject = this.jIJ.a("AppBrandWxaPkgManifestRecord", new String[] { "pkgPath" }, str, arrayOfString, null, null, null, 2);
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
    int i = this.jIJ.delete("AppBrandWxaPkgManifestRecord", str, arrayOfString);
    E(paramString, paramInt, -1);
    AppMethodBeat.o(146040);
    return i;
  }
  
  public final void aU(List<WxaAttributes.WxaPluginCodeInfo> paramList)
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
          r(str1, str2, i);
        }
      }
    }
    AppMethodBeat.o(146033);
  }
  
  final List<bc> b(String paramString, int paramInt, a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(146016);
    if (bt.isNullOrNil(paramString))
    {
      paramString = Collections.emptyList();
      AppMethodBeat.o(146016);
      return paramString;
    }
    Object localObject = this.jIJ;
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
      localObject = new bc();
      ((bc)localObject).convertFrom(parama);
      ((bc)localObject).field_appId = paramString;
      ((bc)localObject).field_version = paramInt;
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
    paramString1 = new ac(paramString1, paramString2, paramInt3).toString();
    if (paramInt2 == 0)
    {
      d(paramString1, paramInt2, paramInt1, paramString3, null);
      AppMethodBeat.o(146032);
      return;
    }
    a(paramString1, paramInt2, "", paramString3, 0L, 0L);
    AppMethodBeat.o(146032);
  }
  
  public final boolean b(final bc parambc)
  {
    AppMethodBeat.i(182784);
    if (j.a.oN(parambc.field_debugType)) {
      parambc.field_version = 1;
    }
    boolean bool = ((Boolean)p(new a() {})).booleanValue();
    AppMethodBeat.o(182784);
    return bool;
  }
  
  public final boolean d(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(146028);
    if (!j.a.rQ(paramInt1))
    {
      AppMethodBeat.o(146028);
      return false;
    }
    ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, paramString3 });
    if (("@LibraryAppId".equals(paramString1)) && (paramInt2 == ax.VERSION))
    {
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[] { Integer.valueOf(ax.VERSION) });
      AppMethodBeat.o(146028);
      return false;
    }
    bc localbc = a(paramString1, paramInt2, paramInt1, new String[0]);
    boolean bool1 = false;
    if (localbc == null)
    {
      localbc = new bc();
      localbc.field_appId = paramString1;
      localbc.field_version = paramInt2;
      localbc.field_versionMd5 = paramString2;
      localbc.field_NewMd5 = null;
      localbc.field_downloadURL = paramString3;
      localbc.field_debugType = paramInt1;
      bool1 = d(localbc);
      ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", new Object[] { Boolean.valueOf(bool1), paramString1, Integer.valueOf(localbc.field_version), localbc.field_downloadURL, localbc.field_versionMd5 });
      AppMethodBeat.o(146028);
      return bool1;
    }
    String str1 = localbc.field_downloadURL;
    String str2 = localbc.field_versionMd5;
    if (!bt.nullAsNil(localbc.field_versionMd5).equals(paramString2))
    {
      localbc.field_versionMd5 = paramString2;
      localbc.field_NewMd5 = null;
      localbc.field_version = paramInt2;
      localbc.field_downloadURL = paramString3;
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        bool1 = e(localbc);
      }
      if ((paramInt1 != 0) && (bool1)) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        ad.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s", new Object[] { Boolean.valueOf(bool2), paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt2), str1, paramString3, str2, paramString2 });
        if ((paramInt1 == 0) || (!bool1)) {
          break label442;
        }
        AppMethodBeat.o(146028);
        return true;
        if ((bt.isNullOrNil(paramString3)) || (paramString3.equals(localbc.field_downloadURL))) {
          break label450;
        }
        localbc.field_downloadURL = paramString3;
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
  
  public final void e(List<String> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(146039);
    if ((paramList.size() <= 0) || (paramList1.size() <= 0) || (paramList.size() != paramList1.size()))
    {
      AppMethodBeat.o(146039);
      return;
    }
    ad.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = this.jIJ.xO(Thread.currentThread().getId());
    int i = 0;
    while (i < paramList.size())
    {
      aT((String)paramList.get(i), ((Integer)paramList1.get(i)).intValue());
      i += 1;
    }
    this.jIJ.sJ(l);
    AppMethodBeat.o(146039);
  }
  
  public final boolean e(bc parambc)
  {
    AppMethodBeat.i(146038);
    ad.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", new Object[] { parambc.field_appId, Integer.valueOf(parambc.field_version), Integer.valueOf(parambc.field_debugType) });
    boolean bool = this.jIK.update(parambc, bc.jIu);
    AppMethodBeat.o(146038);
    return bool;
  }
  
  @SuppressLint({"DefaultLocale"})
  public final boolean e(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(146037);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(146037);
      return false;
    }
    if (j.a.oN(paramInt1)) {
      paramInt2 = 1;
    }
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("pkgPath", paramString2);
    if (this.jIJ.update("AppBrandWxaPkgManifestRecord", localContentValues, String.format("%s=? and %s=? and %s=?", new Object[] { "appId", "debugType", "version" }), new String[] { paramString1, String.valueOf(paramInt1), String.valueOf(paramInt2) }) > 0)
    {
      AppMethodBeat.o(146037);
      return true;
    }
    AppMethodBeat.o(146037);
    return false;
  }
  
  public final void f(bc parambc)
  {
    AppMethodBeat.i(146041);
    this.jIK.replace(parambc);
    AppMethodBeat.o(146041);
  }
  
  public final boolean m(String paramString1, int paramInt, String paramString2)
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
      jIN = new a("DESC", 0);
      jIO = new a("ASC", 1);
      jIP = new a[] { jIN, jIO };
      AppMethodBeat.o(146011);
    }
    
    private a() {}
  }
  
  public static final class b
    extends com.tencent.mm.sdk.e.j<bc>
  {
    public b(e parame)
    {
      super(bc.hEe, "AppBrandWxaPkgManifestRecord", bc.INDEX_CREATE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bg
 * JD-Core Version:    0.7.0.1
 */
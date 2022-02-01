package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.plugin.appbrand.ab.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Arrays;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgIndexedWithDescStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestWithDescRecord;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "fileRecorded", "", "pkgPath", "", "getManifest", "appId", "version", "", "versionType", "columns", "", "(Ljava/lang/String;II[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestWithDescRecord;", "hasManifestRecord", "record", "insertOrUpdate", "select_keyBy_appId_debugType", "(Ljava/lang/String;I[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestWithDescRecord;", "select_keyBy_appId_versionType_versionDesc", "versionDesc", "(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestWithDescRecord;", "updateManifest", "Companion", "data-storage_release"})
public final class bg
  extends c<bi>
  implements s<bi>
{
  public static final String[] nHe;
  public static final a nHf;
  private final ISQLiteDatabaseEx nHd;
  
  static
  {
    AppMethodBeat.i(232476);
    nHf = new a((byte)0);
    String str = MAutoStorage.getCreateSQLs(bi.lqK, "AppBrandWxaPkgManifestRecordWithDesc");
    p.j(str, "MAutoStorage.getCreateSQ…ithDescRecord.TABLE_NAME)");
    nHe = new String[] { str };
    AppMethodBeat.o(232476);
  }
  
  public bg(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    super((ISQLiteDatabase)paramISQLiteDatabaseEx, bi.lqK, "AppBrandWxaPkgManifestRecordWithDesc", bi.INDEX_CREATE);
    AppMethodBeat.i(232475);
    this.nHd = paramISQLiteDatabaseEx;
    this.nHd.execSQL("AppBrandWxaPkgManifestRecordForDevPlugin", "DROP TABLE IF EXISTS ".concat(String.valueOf("AppBrandWxaPkgManifestRecordForDevPlugin")));
    AppMethodBeat.o(232475);
  }
  
  /* Error */
  private boolean a(bi parambi)
  {
    // Byte code:
    //   0: ldc 139
    //   2: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 142	com/tencent/mm/plugin/appbrand/appcache/bg$a:d	(Lcom/tencent/mm/plugin/appbrand/appcache/bi;)Z
    //   9: ifne +10 -> 19
    //   12: ldc 139
    //   14: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_1
    //   20: ifnonnull +6 -> 26
    //   23: invokestatic 145	kotlin/g/b/p:iCn	()V
    //   26: getstatic 148	com/tencent/mm/plugin/appbrand/appcache/bi:nDP	[Ljava/lang/String;
    //   29: astore 4
    //   31: aload 4
    //   33: ldc 150
    //   35: invokestatic 92	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   38: aload 4
    //   40: ldc 152
    //   42: checkcast 154	java/lang/CharSequence
    //   45: aconst_null
    //   46: aconst_null
    //   47: iconst_0
    //   48: aconst_null
    //   49: getstatic 158	com/tencent/mm/plugin/appbrand/appcache/bg$b:nHg	Lcom/tencent/mm/plugin/appbrand/appcache/bg$b;
    //   52: checkcast 160	kotlin/g/a/b
    //   55: bipush 30
    //   57: invokestatic 165	kotlin/a/e:a	([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/g/a/b;I)Ljava/lang/String;
    //   60: astore 4
    //   62: aload_1
    //   63: getfield 169	com/tencent/mm/plugin/appbrand/appcache/bi:field_appId	Ljava/lang/String;
    //   66: astore 5
    //   68: aload_1
    //   69: getfield 173	com/tencent/mm/plugin/appbrand/appcache/bi:field_debugType	I
    //   72: istore_2
    //   73: aload_1
    //   74: getfield 176	com/tencent/mm/plugin/appbrand/appcache/bi:field_versionDesc	Ljava/lang/String;
    //   77: astore 7
    //   79: aload_0
    //   80: getfield 115	com/tencent/mm/plugin/appbrand/appcache/bg:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   83: astore 6
    //   85: aload 6
    //   87: monitorenter
    //   88: aload_0
    //   89: getfield 115	com/tencent/mm/plugin/appbrand/appcache/bg:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   92: new 178	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 180
    //   98: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 187	com/tencent/mm/plugin/appbrand/appcache/bg:getTableName	()Ljava/lang/String;
    //   105: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 193
    //   110: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 4
    //   115: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: iconst_3
    //   122: anewarray 94	java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: aload 5
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: iload_2
    //   133: invokestatic 199	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   136: aastore
    //   137: dup
    //   138: iconst_2
    //   139: aload 7
    //   141: aastore
    //   142: iconst_2
    //   143: invokeinterface 203 4 0
    //   148: astore 4
    //   150: aload 4
    //   152: ifnull +146 -> 298
    //   155: aload 4
    //   157: checkcast 205	java/io/Closeable
    //   160: astore 7
    //   162: aload 7
    //   164: checkcast 207	android/database/Cursor
    //   167: astore 4
    //   169: aload 4
    //   171: invokeinterface 211 1 0
    //   176: ifeq +34 -> 210
    //   179: aload 4
    //   181: iconst_0
    //   182: invokeinterface 215 2 0
    //   187: istore_2
    //   188: iload_2
    //   189: ifle +21 -> 210
    //   192: iconst_1
    //   193: istore_3
    //   194: aload 7
    //   196: aconst_null
    //   197: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   200: aload 6
    //   202: monitorexit
    //   203: ldc 139
    //   205: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iload_3
    //   209: ireturn
    //   210: iconst_0
    //   211: istore_3
    //   212: goto -18 -> 194
    //   215: astore 5
    //   217: ldc 139
    //   219: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload 5
    //   224: athrow
    //   225: astore 4
    //   227: aload 7
    //   229: aload 5
    //   231: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   234: ldc 139
    //   236: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload 4
    //   241: athrow
    //   242: astore 4
    //   244: aload 6
    //   246: monitorexit
    //   247: ldc 139
    //   249: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload 4
    //   254: athrow
    //   255: astore 4
    //   257: ldc 222
    //   259: new 178	java/lang/StringBuilder
    //   262: dup
    //   263: ldc 224
    //   265: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   268: aload_1
    //   269: invokestatic 228	com/tencent/mm/plugin/appbrand/appcache/bg$a:e	(Lcom/tencent/mm/plugin/appbrand/appcache/bi;)Ljava/lang/String;
    //   272: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 230
    //   277: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 4
    //   282: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: ldc 139
    //   293: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: iconst_0
    //   297: ireturn
    //   298: aload 6
    //   300: monitorexit
    //   301: goto -10 -> 291
    //   304: astore 4
    //   306: aconst_null
    //   307: astore 5
    //   309: goto -82 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	bg
    //   0	312	1	parambi	bi
    //   72	117	2	i	int
    //   193	19	3	bool	boolean
    //   29	151	4	localObject1	Object
    //   225	15	4	localObject2	Object
    //   242	11	4	localObject3	Object
    //   255	26	4	localException	Exception
    //   304	1	4	localObject4	Object
    //   66	62	5	str	String
    //   215	15	5	localThrowable	java.lang.Throwable
    //   307	1	5	localObject5	Object
    //   83	216	6	localISQLiteDatabaseEx	ISQLiteDatabaseEx
    //   77	151	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   162	188	215	java/lang/Throwable
    //   217	225	225	finally
    //   88	150	242	finally
    //   155	162	242	finally
    //   194	200	242	finally
    //   227	242	242	finally
    //   79	88	255	java/lang/Exception
    //   200	208	255	java/lang/Exception
    //   244	255	255	java/lang/Exception
    //   298	301	255	java/lang/Exception
    //   162	188	304	finally
  }
  
  /* Error */
  private bi b(String paramString1, int paramInt, String paramString2, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 241
    //   2: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload 4
    //   7: ldc 242
    //   9: invokestatic 104	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: checkcast 154	java/lang/CharSequence
    //   16: astore 6
    //   18: aload 6
    //   20: ifnull +13 -> 33
    //   23: aload 6
    //   25: invokeinterface 246 1 0
    //   30: ifne +77 -> 107
    //   33: iconst_1
    //   34: istore 5
    //   36: iload 5
    //   38: ifne +32 -> 70
    //   41: aload_3
    //   42: checkcast 154	java/lang/CharSequence
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +13 -> 62
    //   52: aload 6
    //   54: invokeinterface 246 1 0
    //   59: ifne +54 -> 113
    //   62: iconst_1
    //   63: istore 5
    //   65: iload 5
    //   67: ifeq +52 -> 119
    //   70: ldc 222
    //   72: new 178	java/lang/StringBuilder
    //   75: dup
    //   76: ldc 248
    //   78: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 250
    //   87: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_3
    //   91: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: ldc 241
    //   102: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aconst_null
    //   106: areturn
    //   107: iconst_0
    //   108: istore 5
    //   110: goto -74 -> 36
    //   113: iconst_0
    //   114: istore 5
    //   116: goto -51 -> 65
    //   119: aload 4
    //   121: arraylength
    //   122: ifne +189 -> 311
    //   125: iconst_1
    //   126: istore 5
    //   128: iload 5
    //   130: ifeq +187 -> 317
    //   133: aconst_null
    //   134: astore 4
    //   136: getstatic 148	com/tencent/mm/plugin/appbrand/appcache/bi:nDP	[Ljava/lang/String;
    //   139: astore 6
    //   141: aload 6
    //   143: ldc 150
    //   145: invokestatic 92	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   148: aload 6
    //   150: ldc 152
    //   152: checkcast 154	java/lang/CharSequence
    //   155: aconst_null
    //   156: aconst_null
    //   157: iconst_0
    //   158: aconst_null
    //   159: getstatic 254	com/tencent/mm/plugin/appbrand/appcache/bg$d:nHi	Lcom/tencent/mm/plugin/appbrand/appcache/bg$d;
    //   162: checkcast 160	kotlin/g/a/b
    //   165: bipush 30
    //   167: invokestatic 165	kotlin/a/e:a	([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/g/a/b;I)Ljava/lang/String;
    //   170: astore 6
    //   172: aload_0
    //   173: getfield 115	com/tencent/mm/plugin/appbrand/appcache/bg:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   176: astore 7
    //   178: aload 7
    //   180: monitorenter
    //   181: aload_0
    //   182: getfield 115	com/tencent/mm/plugin/appbrand/appcache/bg:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   185: iconst_0
    //   186: aload_0
    //   187: invokevirtual 187	com/tencent/mm/plugin/appbrand/appcache/bg:getTableName	()Ljava/lang/String;
    //   190: aload 4
    //   192: aload 6
    //   194: aconst_null
    //   195: aconst_null
    //   196: aconst_null
    //   197: aconst_null
    //   198: invokestatic 260	android/database/sqlite/SQLiteQueryBuilder:buildQueryString	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   201: iconst_3
    //   202: anewarray 94	java/lang/String
    //   205: dup
    //   206: iconst_0
    //   207: aload_1
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: iload_2
    //   212: invokestatic 199	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   215: aastore
    //   216: dup
    //   217: iconst_2
    //   218: aload_3
    //   219: aastore
    //   220: iconst_2
    //   221: invokeinterface 203 4 0
    //   226: astore 4
    //   228: aload 4
    //   230: ifnull +114 -> 344
    //   233: aload 4
    //   235: checkcast 205	java/io/Closeable
    //   238: astore 8
    //   240: aconst_null
    //   241: astore 6
    //   243: aload 8
    //   245: checkcast 207	android/database/Cursor
    //   248: astore 4
    //   250: aload 4
    //   252: invokeinterface 211 1 0
    //   257: ifeq +76 -> 333
    //   260: new 72	com/tencent/mm/plugin/appbrand/appcache/bi
    //   263: dup
    //   264: invokespecial 262	com/tencent/mm/plugin/appbrand/appcache/bi:<init>	()V
    //   267: astore 9
    //   269: aload 9
    //   271: aload 4
    //   273: invokevirtual 266	com/tencent/mm/plugin/appbrand/appcache/bi:convertFrom	(Landroid/database/Cursor;)V
    //   276: aload 9
    //   278: aload_1
    //   279: putfield 169	com/tencent/mm/plugin/appbrand/appcache/bi:field_appId	Ljava/lang/String;
    //   282: aload 9
    //   284: iload_2
    //   285: putfield 173	com/tencent/mm/plugin/appbrand/appcache/bi:field_debugType	I
    //   288: aload 9
    //   290: aload_3
    //   291: putfield 176	com/tencent/mm/plugin/appbrand/appcache/bi:field_versionDesc	Ljava/lang/String;
    //   294: aload 8
    //   296: aconst_null
    //   297: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   300: aload 7
    //   302: monitorexit
    //   303: ldc 241
    //   305: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload 9
    //   310: areturn
    //   311: iconst_0
    //   312: istore 5
    //   314: goto -186 -> 128
    //   317: aload 4
    //   319: aload 4
    //   321: arraylength
    //   322: invokestatic 272	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   325: checkcast 273	[Ljava/lang/String;
    //   328: astore 4
    //   330: goto -194 -> 136
    //   333: getstatic 279	kotlin/x:aazN	Lkotlin/x;
    //   336: astore 4
    //   338: aload 8
    //   340: aconst_null
    //   341: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   344: aload 7
    //   346: monitorexit
    //   347: ldc 241
    //   349: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aconst_null
    //   353: areturn
    //   354: astore 6
    //   356: ldc 241
    //   358: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   361: aload 6
    //   363: athrow
    //   364: astore 4
    //   366: aload 8
    //   368: aload 6
    //   370: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   373: ldc 241
    //   375: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: aload 4
    //   380: athrow
    //   381: astore 4
    //   383: aload 7
    //   385: monitorexit
    //   386: ldc 241
    //   388: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   391: aload 4
    //   393: athrow
    //   394: astore 4
    //   396: ldc 222
    //   398: new 178	java/lang/StringBuilder
    //   401: dup
    //   402: ldc_w 281
    //   405: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   408: aload_1
    //   409: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 283
    //   415: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: iload_2
    //   419: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: ldc_w 288
    //   425: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_3
    //   429: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc_w 290
    //   435: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 4
    //   440: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   449: goto -102 -> 347
    //   452: astore 4
    //   454: goto -88 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	bg
    //   0	457	1	paramString1	String
    //   0	457	2	paramInt	int
    //   0	457	3	paramString2	String
    //   0	457	4	paramVarArgs	String[]
    //   34	279	5	i	int
    //   16	226	6	localObject	Object
    //   354	15	6	localThrowable	java.lang.Throwable
    //   176	208	7	localISQLiteDatabaseEx	ISQLiteDatabaseEx
    //   238	129	8	localCloseable	java.io.Closeable
    //   267	42	9	localbi	bi
    // Exception table:
    //   from	to	target	type
    //   243	294	354	java/lang/Throwable
    //   333	338	354	java/lang/Throwable
    //   356	364	364	finally
    //   181	228	381	finally
    //   233	240	381	finally
    //   294	300	381	finally
    //   338	344	381	finally
    //   366	381	381	finally
    //   172	181	394	java/lang/Exception
    //   300	308	394	java/lang/Exception
    //   344	347	394	java/lang/Exception
    //   383	394	394	java/lang/Exception
    //   243	294	452	finally
    //   333	338	452	finally
  }
  
  /* Error */
  private bi b(String paramString, int paramInt, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 292
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: ldc 242
    //   9: invokestatic 104	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: checkcast 154	java/lang/CharSequence
    //   16: astore 5
    //   18: aload 5
    //   20: ifnull +13 -> 33
    //   23: aload 5
    //   25: invokeinterface 246 1 0
    //   30: ifne +19 -> 49
    //   33: iconst_1
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +17 -> 55
    //   41: ldc_w 292
    //   44: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aconst_null
    //   48: areturn
    //   49: iconst_0
    //   50: istore 4
    //   52: goto -16 -> 36
    //   55: aload_3
    //   56: arraylength
    //   57: ifne +186 -> 243
    //   60: iconst_1
    //   61: istore 4
    //   63: iload 4
    //   65: ifeq +184 -> 249
    //   68: aconst_null
    //   69: astore_3
    //   70: ldc 152
    //   72: checkcast 154	java/lang/CharSequence
    //   75: astore 5
    //   77: getstatic 296	com/tencent/mm/plugin/appbrand/appcache/bg$c:nHh	Lcom/tencent/mm/plugin/appbrand/appcache/bg$c;
    //   80: checkcast 160	kotlin/g/a/b
    //   83: astore 6
    //   85: iconst_2
    //   86: anewarray 94	java/lang/String
    //   89: dup
    //   90: iconst_0
    //   91: ldc_w 297
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: ldc_w 299
    //   100: aastore
    //   101: aload 5
    //   103: aconst_null
    //   104: aconst_null
    //   105: iconst_0
    //   106: aconst_null
    //   107: aload 6
    //   109: bipush 30
    //   111: invokestatic 165	kotlin/a/e:a	([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/g/a/b;I)Ljava/lang/String;
    //   114: astore 5
    //   116: aload_0
    //   117: getfield 115	com/tencent/mm/plugin/appbrand/appcache/bg:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   120: astore 6
    //   122: aload 6
    //   124: monitorenter
    //   125: aload_0
    //   126: getfield 115	com/tencent/mm/plugin/appbrand/appcache/bg:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   129: iconst_0
    //   130: aload_0
    //   131: invokevirtual 187	com/tencent/mm/plugin/appbrand/appcache/bg:getTableName	()Ljava/lang/String;
    //   134: aload_3
    //   135: aload 5
    //   137: aconst_null
    //   138: aconst_null
    //   139: ldc_w 301
    //   142: ldc_w 303
    //   145: invokestatic 260	android/database/sqlite/SQLiteQueryBuilder:buildQueryString	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   148: iconst_2
    //   149: anewarray 94	java/lang/String
    //   152: dup
    //   153: iconst_0
    //   154: aload_1
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: iload_2
    //   159: invokestatic 199	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   162: aastore
    //   163: iconst_2
    //   164: invokeinterface 203 4 0
    //   169: astore_3
    //   170: aload_3
    //   171: ifnull +101 -> 272
    //   174: aload_3
    //   175: checkcast 205	java/io/Closeable
    //   178: astore 7
    //   180: aconst_null
    //   181: astore 5
    //   183: aload 7
    //   185: checkcast 207	android/database/Cursor
    //   188: astore_3
    //   189: aload_3
    //   190: invokeinterface 211 1 0
    //   195: ifeq +67 -> 262
    //   198: new 72	com/tencent/mm/plugin/appbrand/appcache/bi
    //   201: dup
    //   202: invokespecial 262	com/tencent/mm/plugin/appbrand/appcache/bi:<init>	()V
    //   205: astore 8
    //   207: aload 8
    //   209: aload_3
    //   210: invokevirtual 266	com/tencent/mm/plugin/appbrand/appcache/bi:convertFrom	(Landroid/database/Cursor;)V
    //   213: aload 8
    //   215: aload_1
    //   216: putfield 169	com/tencent/mm/plugin/appbrand/appcache/bi:field_appId	Ljava/lang/String;
    //   219: aload 8
    //   221: iload_2
    //   222: putfield 173	com/tencent/mm/plugin/appbrand/appcache/bi:field_debugType	I
    //   225: aload 7
    //   227: aconst_null
    //   228: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   231: aload 6
    //   233: monitorexit
    //   234: ldc_w 292
    //   237: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload 8
    //   242: areturn
    //   243: iconst_0
    //   244: istore 4
    //   246: goto -183 -> 63
    //   249: aload_3
    //   250: aload_3
    //   251: arraylength
    //   252: invokestatic 272	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   255: checkcast 273	[Ljava/lang/String;
    //   258: astore_3
    //   259: goto -189 -> 70
    //   262: getstatic 279	kotlin/x:aazN	Lkotlin/x;
    //   265: astore_3
    //   266: aload 7
    //   268: aconst_null
    //   269: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   272: aload 6
    //   274: monitorexit
    //   275: ldc_w 292
    //   278: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: aconst_null
    //   282: areturn
    //   283: astore 5
    //   285: ldc_w 292
    //   288: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload 5
    //   293: athrow
    //   294: astore_3
    //   295: aload 7
    //   297: aload 5
    //   299: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   302: ldc_w 292
    //   305: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload_3
    //   309: athrow
    //   310: astore_3
    //   311: aload 6
    //   313: monitorexit
    //   314: ldc_w 292
    //   317: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload_3
    //   321: athrow
    //   322: astore_3
    //   323: ldc 222
    //   325: new 178	java/lang/StringBuilder
    //   328: dup
    //   329: ldc_w 305
    //   332: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   335: aload_1
    //   336: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc_w 283
    //   342: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: iload_2
    //   346: invokevirtual 286	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: ldc 230
    //   351: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_3
    //   355: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: goto -89 -> 275
    //   367: astore_3
    //   368: goto -73 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	bg
    //   0	371	1	paramString	String
    //   0	371	2	paramInt	int
    //   0	371	3	paramVarArgs	String[]
    //   34	211	4	i	int
    //   16	166	5	localObject1	Object
    //   283	15	5	localThrowable	java.lang.Throwable
    //   83	229	6	localObject2	Object
    //   178	118	7	localCloseable	java.io.Closeable
    //   205	36	8	localbi	bi
    // Exception table:
    //   from	to	target	type
    //   183	225	283	java/lang/Throwable
    //   262	266	283	java/lang/Throwable
    //   285	294	294	finally
    //   125	170	310	finally
    //   174	180	310	finally
    //   225	231	310	finally
    //   266	272	310	finally
    //   295	310	310	finally
    //   116	125	322	java/lang/Exception
    //   231	240	322	java/lang/Exception
    //   272	275	322	java/lang/Exception
    //   311	322	322	java/lang/Exception
    //   183	225	367	finally
    //   262	266	367	finally
  }
  
  public final boolean b(bi parambi)
  {
    AppMethodBeat.i(232472);
    p.k(parambi, "record");
    if (!a.d(parambi))
    {
      Log.e("Luggage.WxaPkgIndexedWithDescStorage", "insertOrUpdate(" + a.e(parambi) + ") invalid record");
      AppMethodBeat.o(232472);
      return false;
    }
    for (;;)
    {
      Object localObject2;
      boolean bool;
      synchronized (this.nHd)
      {
        try
        {
          Object localObject1 = d.qQK;
          localObject1 = (ISQLiteDatabase)this.nHd;
          if (!(localObject1 instanceof ISQLiteDatabaseEx)) {
            break label393;
          }
          localObject2 = (ISQLiteDatabaseEx)localObject1;
          Object localObject3 = Thread.currentThread();
          p.j(localObject3, "Thread.currentThread()");
          long l = ((ISQLiteDatabaseEx)localObject2).beginTransaction(((Thread)localObject3).getId());
          if (a(parambi))
          {
            localObject2 = (IAutoDBItem)parambi;
            localObject3 = bi.nDP;
            bool = super.updateNotify((IAutoDBItem)localObject2, true, (String[])Arrays.copyOf((Object[])localObject3, localObject3.length));
            Log.i("Luggage.WxaPkgIndexedWithDescStorage", "updateNotify appid:" + parambi.field_appId + ",newMd5:" + parambi.field_NewMd5 + ", versionDesc:" + parambi.field_versionDesc + ", update ret:" + bool);
            localObject2 = x.aazN;
            ((ISQLiteDatabaseEx)localObject1).endTransaction(l);
            AppMethodBeat.o(232472);
            return bool;
          }
        }
        catch (Exception localException)
        {
          Log.e("Luggage.WxaPkgIndexedWithDescStorage", "insertOrUpdate(" + a.e(parambi) + "), exception:" + localException);
          parambi = x.aazN;
          AppMethodBeat.o(232472);
          return false;
        }
        bool = super.insertNotify((IAutoDBItem)parambi, true);
        Log.i("Luggage.WxaPkgIndexedWithDescStorage", "insertNotify appid:" + parambi.field_appId + ",newMd5:" + parambi.field_NewMd5 + ", versionDesc:" + parambi.field_versionDesc + ", insert ret:" + bool);
      }
      label393:
      if (a(parambi))
      {
        IAutoDBItem localIAutoDBItem = (IAutoDBItem)parambi;
        localObject2 = bi.nDP;
        bool = super.updateNotify(localIAutoDBItem, true, (String[])Arrays.copyOf((Object[])localObject2, localObject2.length));
        Log.i("Luggage.WxaPkgIndexedWithDescStorage", "updateNotify appid:" + parambi.field_appId + ",newMd5:" + parambi.field_NewMd5 + ", versionDesc:" + parambi.field_versionDesc + ", update ret:" + bool);
      }
      else
      {
        bool = super.insertNotify((IAutoDBItem)parambi, true);
        Log.i("Luggage.WxaPkgIndexedWithDescStorage", "insertNotify appid:" + parambi.field_appId + ",newMd5:" + parambi.field_NewMd5 + ", versionDesc:" + parambi.field_versionDesc + ", insert ret:" + bool);
      }
    }
  }
  
  public final boolean c(bi parambi)
  {
    AppMethodBeat.i(232473);
    p.k(parambi, "record");
    if (!a.d(parambi))
    {
      Log.e("Luggage.WxaPkgIndexedWithDescStorage", "update(" + a.e(parambi) + ") invalid record");
      AppMethodBeat.o(232473);
      return false;
    }
    synchronized (this.nHd)
    {
      parambi = (IAutoDBItem)parambi;
      String[] arrayOfString = bi.nDP;
      boolean bool = super.updateNotify(parambi, true, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length));
      AppMethodBeat.o(232473);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgIndexedWithDescStorage$Companion;", "", "()V", "TABLE_CREATE_SQLS", "", "", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "checkIsValid", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestWithDescRecord;", "print", "verbose", "data-storage_release"})
  public static final class a
  {
    static boolean d(bi parambi)
    {
      AppMethodBeat.i(232634);
      if (parambi != null)
      {
        CharSequence localCharSequence = (CharSequence)parambi.field_appId;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label80;
          }
          parambi = (CharSequence)parambi.field_versionDesc;
          if ((parambi != null) && (parambi.length() != 0)) {
            break label75;
          }
        }
        label75:
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label80;
          }
          AppMethodBeat.o(232634);
          return true;
          i = 0;
          break;
        }
      }
      label80:
      AppMethodBeat.o(232634);
      return false;
    }
    
    static String e(bi parambi)
    {
      AppMethodBeat.i(232638);
      if (parambi == null)
      {
        AppMethodBeat.o(232638);
        return "(null)";
      }
      parambi = j.a((Iterable)j.ag(new String[] { "appId:" + parambi.field_appId, "versionType:" + parambi.field_debugType, "versionDesc:" + parambi.field_versionDesc }), (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, null, 56);
      AppMethodBeat.o(232638);
      return parambi;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements b<String, String>
  {
    public static final b nHg;
    
    static
    {
      AppMethodBeat.i(232325);
      nHg = new b();
      AppMethodBeat.o(232325);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "invoke"})
  static final class c
    extends q
    implements b<String, String>
  {
    public static final c nHh;
    
    static
    {
      AppMethodBeat.i(232533);
      nHh = new c();
      AppMethodBeat.o(232533);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements b<String, String>
  {
    public static final d nHi;
    
    static
    {
      AppMethodBeat.i(232318);
      nHi = new d();
      AppMethodBeat.o(232318);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bg
 * JD-Core Version:    0.7.0.1
 */
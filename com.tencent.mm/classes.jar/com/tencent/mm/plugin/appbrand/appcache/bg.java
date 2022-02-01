package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.c;
import com.tencent.mm.plugin.appbrand.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgIndexedWithDescStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestWithDescRecord;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;)V", "fileRecorded", "", "pkgPath", "", "getManifest", "appId", "version", "", "versionType", "columns", "", "(Ljava/lang/String;II[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestWithDescRecord;", "hasManifestRecord", "record", "insertOrUpdate", "select_keyBy_appId_debugType", "(Ljava/lang/String;I[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestWithDescRecord;", "select_keyBy_appId_versionType_versionDesc", "versionDesc", "(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestWithDescRecord;", "updateManifest", "Companion", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg
  extends c<bi>
  implements u<bi>
{
  public static final a qGQ;
  public static final String[] qGS;
  private final ISQLiteDatabaseEx qGR;
  
  static
  {
    AppMethodBeat.i(320187);
    qGQ = new a((byte)0);
    String str = MAutoStorage.getCreateSQLs(bi.nVV, "AppBrandWxaPkgManifestRecordWithDesc");
    s.s(str, "getCreateSQLs(WxaPkgMani…ithDescRecord.TABLE_NAME)");
    qGS = new String[] { str };
    AppMethodBeat.o(320187);
  }
  
  public bg(ISQLiteDatabaseEx paramISQLiteDatabaseEx)
  {
    super((ISQLiteDatabase)paramISQLiteDatabaseEx, bi.nVV, "AppBrandWxaPkgManifestRecordWithDesc", bi.INDEX_CREATE);
    AppMethodBeat.i(320155);
    this.qGR = paramISQLiteDatabaseEx;
    this.qGR.execSQL("AppBrandWxaPkgManifestRecordForDevPlugin", s.X("DROP TABLE IF EXISTS ", "AppBrandWxaPkgManifestRecordForDevPlugin"));
    AppMethodBeat.o(320155);
  }
  
  /* Error */
  private boolean a(bi parambi)
  {
    // Byte code:
    //   0: ldc 130
    //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 133	com/tencent/mm/plugin/appbrand/appcache/bg$a:d	(Lcom/tencent/mm/plugin/appbrand/appcache/bi;)Z
    //   9: ifne +10 -> 19
    //   12: ldc 130
    //   14: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_1
    //   20: invokestatic 137	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   23: getstatic 140	com/tencent/mm/plugin/appbrand/appcache/bi:qDJ	[Ljava/lang/String;
    //   26: astore 4
    //   28: aload 4
    //   30: ldc 142
    //   32: invokestatic 89	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   35: aload 4
    //   37: checkcast 144	[Ljava/lang/Object;
    //   40: ldc 146
    //   42: checkcast 148	java/lang/CharSequence
    //   45: aconst_null
    //   46: aconst_null
    //   47: iconst_0
    //   48: aconst_null
    //   49: getstatic 154	com/tencent/mm/plugin/appbrand/appcache/bg$b:qGT	Lcom/tencent/mm/plugin/appbrand/appcache/bg$b;
    //   52: checkcast 156	kotlin/g/a/b
    //   55: bipush 30
    //   57: invokestatic 161	kotlin/a/k:a	([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/g/a/b;I)Ljava/lang/String;
    //   60: astore 5
    //   62: aload_1
    //   63: getfield 165	com/tencent/mm/plugin/appbrand/appcache/bi:field_appId	Ljava/lang/String;
    //   66: astore 6
    //   68: aload_1
    //   69: getfield 169	com/tencent/mm/plugin/appbrand/appcache/bi:field_debugType	I
    //   72: istore_2
    //   73: aload_1
    //   74: getfield 172	com/tencent/mm/plugin/appbrand/appcache/bi:field_versionDesc	Ljava/lang/String;
    //   77: astore 7
    //   79: aload_0
    //   80: getfield 112	com/tencent/mm/plugin/appbrand/appcache/bg:qGR	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   83: astore 4
    //   85: aload 4
    //   87: monitorenter
    //   88: aload_0
    //   89: getfield 112	com/tencent/mm/plugin/appbrand/appcache/bg:qGR	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   92: new 174	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 176
    //   98: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 183	com/tencent/mm/plugin/appbrand/appcache/bg:getTableName	()Ljava/lang/String;
    //   105: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: ldc 189
    //   110: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 5
    //   115: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: iconst_3
    //   122: anewarray 91	java/lang/String
    //   125: dup
    //   126: iconst_0
    //   127: aload 6
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
    //   148: astore 5
    //   150: aload 5
    //   152: ifnull +146 -> 298
    //   155: aload 5
    //   157: checkcast 205	java/io/Closeable
    //   160: astore 5
    //   162: aload 5
    //   164: checkcast 207	android/database/Cursor
    //   167: astore 6
    //   169: aload 6
    //   171: invokeinterface 211 1 0
    //   176: ifeq +34 -> 210
    //   179: aload 6
    //   181: iconst_0
    //   182: invokeinterface 215 2 0
    //   187: istore_2
    //   188: iload_2
    //   189: ifle +21 -> 210
    //   192: iconst_1
    //   193: istore_3
    //   194: aload 5
    //   196: aconst_null
    //   197: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   200: aload 4
    //   202: monitorexit
    //   203: ldc 130
    //   205: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iload_3
    //   209: ireturn
    //   210: iconst_0
    //   211: istore_3
    //   212: goto -18 -> 194
    //   215: astore 6
    //   217: ldc 130
    //   219: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload 6
    //   224: athrow
    //   225: astore 7
    //   227: aload 5
    //   229: aload 6
    //   231: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   234: ldc 130
    //   236: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload 7
    //   241: athrow
    //   242: astore 5
    //   244: aload 4
    //   246: monitorexit
    //   247: ldc 130
    //   249: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload 5
    //   254: athrow
    //   255: astore 4
    //   257: ldc 222
    //   259: new 174	java/lang/StringBuilder
    //   262: dup
    //   263: ldc 224
    //   265: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   268: aload_1
    //   269: invokestatic 228	com/tencent/mm/plugin/appbrand/appcache/bg$a:e	(Lcom/tencent/mm/plugin/appbrand/appcache/bi;)Ljava/lang/String;
    //   272: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 230
    //   277: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 4
    //   282: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: ldc 130
    //   293: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: iconst_0
    //   297: ireturn
    //   298: aload 4
    //   300: monitorexit
    //   301: goto -10 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	bg
    //   0	304	1	parambi	bi
    //   72	117	2	i	int
    //   193	19	3	bool	boolean
    //   26	219	4	localObject1	Object
    //   255	44	4	localException	Exception
    //   60	168	5	localObject2	Object
    //   242	11	5	localObject3	Object
    //   66	114	6	localObject4	Object
    //   215	15	6	localThrowable	java.lang.Throwable
    //   77	63	7	str	String
    //   225	15	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   162	188	215	finally
    //   217	225	225	finally
    //   88	150	242	finally
    //   155	162	242	finally
    //   194	200	242	finally
    //   227	242	242	finally
    //   79	88	255	java/lang/Exception
    //   200	208	255	java/lang/Exception
    //   244	255	255	java/lang/Exception
    //   298	301	255	java/lang/Exception
  }
  
  /* Error */
  private bi b(String paramString1, int paramInt, String paramString2, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 238
    //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload 4
    //   7: ldc 239
    //   9: invokestatic 101	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: checkcast 148	java/lang/CharSequence
    //   16: astore 6
    //   18: aload 6
    //   20: ifnull +13 -> 33
    //   23: aload 6
    //   25: invokeinterface 243 1 0
    //   30: ifne +77 -> 107
    //   33: iconst_1
    //   34: istore 5
    //   36: iload 5
    //   38: ifne +32 -> 70
    //   41: aload_3
    //   42: checkcast 148	java/lang/CharSequence
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +13 -> 62
    //   52: aload 6
    //   54: invokeinterface 243 1 0
    //   59: ifne +54 -> 113
    //   62: iconst_1
    //   63: istore 5
    //   65: iload 5
    //   67: ifeq +52 -> 119
    //   70: ldc 222
    //   72: new 174	java/lang/StringBuilder
    //   75: dup
    //   76: ldc 245
    //   78: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: ldc 247
    //   87: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_3
    //   91: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: ldc 238
    //   102: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   136: getstatic 140	com/tencent/mm/plugin/appbrand/appcache/bi:qDJ	[Ljava/lang/String;
    //   139: astore 6
    //   141: aload 6
    //   143: ldc 142
    //   145: invokestatic 89	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   148: aload 6
    //   150: checkcast 144	[Ljava/lang/Object;
    //   153: ldc 146
    //   155: checkcast 148	java/lang/CharSequence
    //   158: aconst_null
    //   159: aconst_null
    //   160: iconst_0
    //   161: aconst_null
    //   162: getstatic 253	com/tencent/mm/plugin/appbrand/appcache/bg$d:qGV	Lcom/tencent/mm/plugin/appbrand/appcache/bg$d;
    //   165: checkcast 156	kotlin/g/a/b
    //   168: bipush 30
    //   170: invokestatic 161	kotlin/a/k:a	([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/g/a/b;I)Ljava/lang/String;
    //   173: astore 7
    //   175: aload_0
    //   176: getfield 112	com/tencent/mm/plugin/appbrand/appcache/bg:qGR	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   179: astore 6
    //   181: aload 6
    //   183: monitorenter
    //   184: aload_0
    //   185: getfield 112	com/tencent/mm/plugin/appbrand/appcache/bg:qGR	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   188: iconst_0
    //   189: aload_0
    //   190: invokevirtual 183	com/tencent/mm/plugin/appbrand/appcache/bg:getTableName	()Ljava/lang/String;
    //   193: aload 4
    //   195: aload 7
    //   197: aconst_null
    //   198: aconst_null
    //   199: aconst_null
    //   200: aconst_null
    //   201: invokestatic 259	android/database/sqlite/SQLiteQueryBuilder:buildQueryString	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   204: iconst_3
    //   205: anewarray 91	java/lang/String
    //   208: dup
    //   209: iconst_0
    //   210: aload_1
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: iload_2
    //   215: invokestatic 199	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   218: aastore
    //   219: dup
    //   220: iconst_2
    //   221: aload_3
    //   222: aastore
    //   223: iconst_2
    //   224: invokeinterface 203 4 0
    //   229: astore 4
    //   231: aload 4
    //   233: ifnull +116 -> 349
    //   236: aload 4
    //   238: checkcast 205	java/io/Closeable
    //   241: astore 4
    //   243: aload 4
    //   245: checkcast 207	android/database/Cursor
    //   248: astore 7
    //   250: aload 7
    //   252: invokeinterface 211 1 0
    //   257: ifeq +76 -> 333
    //   260: new 69	com/tencent/mm/plugin/appbrand/appcache/bi
    //   263: dup
    //   264: invokespecial 261	com/tencent/mm/plugin/appbrand/appcache/bi:<init>	()V
    //   267: astore 8
    //   269: aload 8
    //   271: aload 7
    //   273: invokevirtual 265	com/tencent/mm/plugin/appbrand/appcache/bi:convertFrom	(Landroid/database/Cursor;)V
    //   276: aload 8
    //   278: aload_1
    //   279: putfield 165	com/tencent/mm/plugin/appbrand/appcache/bi:field_appId	Ljava/lang/String;
    //   282: aload 8
    //   284: iload_2
    //   285: putfield 169	com/tencent/mm/plugin/appbrand/appcache/bi:field_debugType	I
    //   288: aload 8
    //   290: aload_3
    //   291: putfield 172	com/tencent/mm/plugin/appbrand/appcache/bi:field_versionDesc	Ljava/lang/String;
    //   294: aload 4
    //   296: aconst_null
    //   297: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   300: aload 6
    //   302: monitorexit
    //   303: ldc 238
    //   305: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload 8
    //   310: areturn
    //   311: iconst_0
    //   312: istore 5
    //   314: goto -186 -> 128
    //   317: aload 4
    //   319: aload 4
    //   321: arraylength
    //   322: invokestatic 271	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   325: checkcast 272	[Ljava/lang/String;
    //   328: astore 4
    //   330: goto -194 -> 136
    //   333: getstatic 278	kotlin/ah:aiuX	Lkotlin/ah;
    //   336: astore 7
    //   338: aload 4
    //   340: aconst_null
    //   341: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   344: getstatic 278	kotlin/ah:aiuX	Lkotlin/ah;
    //   347: astore 4
    //   349: aload 6
    //   351: monitorexit
    //   352: ldc 238
    //   354: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: aconst_null
    //   358: areturn
    //   359: astore 7
    //   361: ldc 238
    //   363: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: aload 7
    //   368: athrow
    //   369: astore 8
    //   371: aload 4
    //   373: aload 7
    //   375: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   378: ldc 238
    //   380: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aload 8
    //   385: athrow
    //   386: astore 4
    //   388: aload 6
    //   390: monitorexit
    //   391: ldc 238
    //   393: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: aload 4
    //   398: athrow
    //   399: astore 4
    //   401: ldc 222
    //   403: new 174	java/lang/StringBuilder
    //   406: dup
    //   407: ldc_w 280
    //   410: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   413: aload_1
    //   414: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 282
    //   420: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: iload_2
    //   424: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   427: ldc_w 287
    //   430: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_3
    //   434: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   437: ldc_w 289
    //   440: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 4
    //   445: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: goto -102 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	bg
    //   0	457	1	paramString1	String
    //   0	457	2	paramInt	int
    //   0	457	3	paramString2	String
    //   0	457	4	paramVarArgs	String[]
    //   34	279	5	i	int
    //   173	164	7	localObject2	Object
    //   359	15	7	localThrowable	java.lang.Throwable
    //   267	42	8	localbi	bi
    //   369	15	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   243	294	359	finally
    //   333	338	359	finally
    //   361	369	369	finally
    //   184	231	386	finally
    //   236	243	386	finally
    //   294	300	386	finally
    //   338	349	386	finally
    //   371	386	386	finally
    //   175	184	399	java/lang/Exception
    //   300	308	399	java/lang/Exception
    //   349	352	399	java/lang/Exception
    //   388	399	399	java/lang/Exception
  }
  
  /* Error */
  private bi b(String paramString, int paramInt, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 291
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: ldc 239
    //   9: invokestatic 101	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: checkcast 148	java/lang/CharSequence
    //   16: astore 5
    //   18: aload 5
    //   20: ifnull +13 -> 33
    //   23: aload 5
    //   25: invokeinterface 243 1 0
    //   30: ifne +19 -> 49
    //   33: iconst_1
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +17 -> 55
    //   41: ldc_w 291
    //   44: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aconst_null
    //   48: areturn
    //   49: iconst_0
    //   50: istore 4
    //   52: goto -16 -> 36
    //   55: aload_3
    //   56: arraylength
    //   57: ifne +183 -> 240
    //   60: iconst_1
    //   61: istore 4
    //   63: iload 4
    //   65: ifeq +181 -> 246
    //   68: aconst_null
    //   69: astore_3
    //   70: ldc 146
    //   72: checkcast 148	java/lang/CharSequence
    //   75: astore 5
    //   77: getstatic 297	com/tencent/mm/plugin/appbrand/appcache/bg$c:qGU	Lcom/tencent/mm/plugin/appbrand/appcache/bg$c;
    //   80: checkcast 156	kotlin/g/a/b
    //   83: astore 6
    //   85: iconst_2
    //   86: anewarray 91	java/lang/String
    //   89: dup
    //   90: iconst_0
    //   91: ldc_w 298
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: ldc_w 300
    //   100: aastore
    //   101: aload 5
    //   103: aconst_null
    //   104: aconst_null
    //   105: iconst_0
    //   106: aconst_null
    //   107: aload 6
    //   109: bipush 30
    //   111: invokestatic 161	kotlin/a/k:a	([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/g/a/b;I)Ljava/lang/String;
    //   114: astore 6
    //   116: aload_0
    //   117: getfield 112	com/tencent/mm/plugin/appbrand/appcache/bg:qGR	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   120: astore 5
    //   122: aload 5
    //   124: monitorenter
    //   125: aload_0
    //   126: getfield 112	com/tencent/mm/plugin/appbrand/appcache/bg:qGR	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   129: iconst_0
    //   130: aload_0
    //   131: invokevirtual 183	com/tencent/mm/plugin/appbrand/appcache/bg:getTableName	()Ljava/lang/String;
    //   134: aload_3
    //   135: aload 6
    //   137: aconst_null
    //   138: aconst_null
    //   139: ldc_w 302
    //   142: ldc_w 304
    //   145: invokestatic 259	android/database/sqlite/SQLiteQueryBuilder:buildQueryString	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   148: iconst_2
    //   149: anewarray 91	java/lang/String
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
    //   171: ifnull +102 -> 273
    //   174: aload_3
    //   175: checkcast 205	java/io/Closeable
    //   178: astore_3
    //   179: aload_3
    //   180: checkcast 207	android/database/Cursor
    //   183: astore 6
    //   185: aload 6
    //   187: invokeinterface 211 1 0
    //   192: ifeq +67 -> 259
    //   195: new 69	com/tencent/mm/plugin/appbrand/appcache/bi
    //   198: dup
    //   199: invokespecial 261	com/tencent/mm/plugin/appbrand/appcache/bi:<init>	()V
    //   202: astore 7
    //   204: aload 7
    //   206: aload 6
    //   208: invokevirtual 265	com/tencent/mm/plugin/appbrand/appcache/bi:convertFrom	(Landroid/database/Cursor;)V
    //   211: aload 7
    //   213: aload_1
    //   214: putfield 165	com/tencent/mm/plugin/appbrand/appcache/bi:field_appId	Ljava/lang/String;
    //   217: aload 7
    //   219: iload_2
    //   220: putfield 169	com/tencent/mm/plugin/appbrand/appcache/bi:field_debugType	I
    //   223: aload_3
    //   224: aconst_null
    //   225: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   228: aload 5
    //   230: monitorexit
    //   231: ldc_w 291
    //   234: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload 7
    //   239: areturn
    //   240: iconst_0
    //   241: istore 4
    //   243: goto -180 -> 63
    //   246: aload_3
    //   247: aload_3
    //   248: arraylength
    //   249: invokestatic 271	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   252: checkcast 272	[Ljava/lang/String;
    //   255: astore_3
    //   256: goto -186 -> 70
    //   259: getstatic 278	kotlin/ah:aiuX	Lkotlin/ah;
    //   262: astore 6
    //   264: aload_3
    //   265: aconst_null
    //   266: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   269: getstatic 278	kotlin/ah:aiuX	Lkotlin/ah;
    //   272: astore_3
    //   273: aload 5
    //   275: monitorexit
    //   276: ldc_w 291
    //   279: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aconst_null
    //   283: areturn
    //   284: astore 6
    //   286: ldc_w 291
    //   289: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload 6
    //   294: athrow
    //   295: astore 7
    //   297: aload_3
    //   298: aload 6
    //   300: invokestatic 220	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   303: ldc_w 291
    //   306: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload 7
    //   311: athrow
    //   312: astore_3
    //   313: aload 5
    //   315: monitorexit
    //   316: ldc_w 291
    //   319: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: aload_3
    //   323: athrow
    //   324: astore_3
    //   325: ldc 222
    //   327: new 174	java/lang/StringBuilder
    //   330: dup
    //   331: ldc_w 306
    //   334: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: aload_1
    //   338: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: ldc_w 282
    //   344: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload_2
    //   348: invokevirtual 285	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: ldc 230
    //   353: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_3
    //   357: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: goto -90 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	bg
    //   0	369	1	paramString	String
    //   0	369	2	paramInt	int
    //   0	369	3	paramVarArgs	String[]
    //   34	208	4	i	int
    //   83	180	6	localObject2	Object
    //   284	15	6	localThrowable	java.lang.Throwable
    //   202	36	7	localbi	bi
    //   295	15	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   179	223	284	finally
    //   259	264	284	finally
    //   286	295	295	finally
    //   125	170	312	finally
    //   174	179	312	finally
    //   223	228	312	finally
    //   264	273	312	finally
    //   297	312	312	finally
    //   116	125	324	java/lang/Exception
    //   228	237	324	java/lang/Exception
    //   273	276	324	java/lang/Exception
    //   313	324	324	java/lang/Exception
  }
  
  public final boolean b(bi parambi)
  {
    AppMethodBeat.i(320197);
    s.u(parambi, "record");
    if (!a.d(parambi))
    {
      Log.e("Luggage.WxaPkgIndexedWithDescStorage", "insertOrUpdate(" + a.e(parambi) + ") invalid record");
      AppMethodBeat.o(320197);
      return false;
    }
    for (;;)
    {
      synchronized (this.qGR)
      {
        try
        {
          Object localObject1 = d.tVA;
          localObject1 = (ISQLiteDatabase)this.qGR;
          if ((localObject1 instanceof ISQLiteDatabaseEx))
          {
            long l = ((ISQLiteDatabaseEx)localObject1).beginTransaction(Thread.currentThread().getId());
            if (a(parambi))
            {
              localObject2 = (IAutoDBItem)parambi;
              String[] arrayOfString = bi.qDJ;
              bool = super.updateNotify((IAutoDBItem)localObject2, true, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length));
              Log.i("Luggage.WxaPkgIndexedWithDescStorage", "updateNotify appid:" + parambi.field_appId + ",newMd5:" + parambi.field_NewMd5 + ", versionDesc:" + parambi.field_versionDesc + ", update ret:" + bool);
              localObject2 = ah.aiuX;
              ((ISQLiteDatabaseEx)localObject1).endTransaction(l);
              AppMethodBeat.o(320197);
              return bool;
            }
            bool = super.insertNotify((IAutoDBItem)parambi, true);
            Log.i("Luggage.WxaPkgIndexedWithDescStorage", "insertNotify appid:" + parambi.field_appId + ",newMd5:" + parambi.field_NewMd5 + ", versionDesc:" + parambi.field_versionDesc + ", insert ret:" + bool);
            continue;
          }
          if (!a(parambi)) {
            break label481;
          }
        }
        catch (Exception localException)
        {
          Log.e("Luggage.WxaPkgIndexedWithDescStorage", "insertOrUpdate(" + a.e(parambi) + "), exception:" + localException);
          parambi = ah.aiuX;
          AppMethodBeat.o(320197);
          return false;
        }
        IAutoDBItem localIAutoDBItem = (IAutoDBItem)parambi;
        Object localObject2 = bi.qDJ;
        bool = super.updateNotify(localIAutoDBItem, true, (String[])Arrays.copyOf((Object[])localObject2, localObject2.length));
        Log.i("Luggage.WxaPkgIndexedWithDescStorage", "updateNotify appid:" + parambi.field_appId + ",newMd5:" + parambi.field_NewMd5 + ", versionDesc:" + parambi.field_versionDesc + ", update ret:" + bool);
      }
      label481:
      boolean bool = super.insertNotify((IAutoDBItem)parambi, true);
      Log.i("Luggage.WxaPkgIndexedWithDescStorage", "insertNotify appid:" + parambi.field_appId + ",newMd5:" + parambi.field_NewMd5 + ", versionDesc:" + parambi.field_versionDesc + ", insert ret:" + bool);
    }
  }
  
  public final boolean c(bi parambi)
  {
    AppMethodBeat.i(320202);
    s.u(parambi, "record");
    if (!a.d(parambi))
    {
      Log.e("Luggage.WxaPkgIndexedWithDescStorage", "update(" + a.e(parambi) + ") invalid record");
      AppMethodBeat.o(320202);
      return false;
    }
    synchronized (this.qGR)
    {
      parambi = (IAutoDBItem)parambi;
      String[] arrayOfString = bi.qDJ;
      boolean bool = super.updateNotify(parambi, true, (String[])Arrays.copyOf(arrayOfString, arrayOfString.length));
      AppMethodBeat.o(320202);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgIndexedWithDescStorage$Companion;", "", "()V", "TABLE_CREATE_SQLS", "", "", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "checkIsValid", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestWithDescRecord;", "print", "verbose", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static boolean d(bi parambi)
    {
      AppMethodBeat.i(320382);
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
          AppMethodBeat.o(320382);
          return true;
          i = 0;
          break;
        }
      }
      label80:
      AppMethodBeat.o(320382);
      return false;
    }
    
    static String e(bi parambi)
    {
      AppMethodBeat.i(320388);
      if (parambi == null)
      {
        AppMethodBeat.o(320388);
        return "(null)";
      }
      parambi = p.a((Iterable)p.al(new String[] { s.X("appId:", parambi.field_appId), s.X("versionType:", Integer.valueOf(parambi.field_debugType)), s.X("versionDesc:", parambi.field_versionDesc) }), (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, null, 56);
      AppMethodBeat.o(320388);
      return parambi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bg
 * JD-Core Version:    0.7.0.1
 */
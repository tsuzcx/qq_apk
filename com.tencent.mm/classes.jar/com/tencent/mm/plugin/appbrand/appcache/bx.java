package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.io;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionTemplateIdMappingStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionTemplateIdMappingStorage$MappingRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getValidPkgRecordsForTemplateIdAndMd5", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "templateId", "", "md5", "", "newMd5", "removeRecordsForAppIdAndVersionLessThan", "", "appId", "appVersion", "setTemplateId", "", "Companion", "MappingRecord", "data-storage_release"})
public final class bx
  extends MAutoStorage<b>
{
  public static final String[] lqL;
  public static final a nIC;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(232363);
    nIC = new a((byte)0);
    bx.b.a locala = b.nID;
    lqL = b.bHL();
    AppMethodBeat.o(232363);
  }
  
  public bx(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.bHK(), "WxaVersionTemplateIdMapping", io.INDEX_CREATE);
    AppMethodBeat.i(232362);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(232362);
  }
  
  /* Error */
  public final boolean b(String paramString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 100
    //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: checkcast 102	java/lang/CharSequence
    //   9: astore 7
    //   11: aload 7
    //   13: ifnull +13 -> 26
    //   16: aload 7
    //   18: invokeinterface 106 1 0
    //   23: ifne +18 -> 41
    //   26: iconst_1
    //   27: istore 5
    //   29: iload 5
    //   31: ifeq +16 -> 47
    //   34: ldc 100
    //   36: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: iconst_0
    //   40: ireturn
    //   41: iconst_0
    //   42: istore 5
    //   44: goto -15 -> 29
    //   47: ldc 108
    //   49: new 110	java/lang/StringBuilder
    //   52: dup
    //   53: ldc 112
    //   55: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: aload_1
    //   59: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 121
    //   64: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_2
    //   68: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc 126
    //   73: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: lload_3
    //   77: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: bipush 41
    //   82: invokevirtual 132	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   85: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: getfield 96	com/tencent/mm/plugin/appbrand/appcache/bx:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   95: astore 8
    //   97: aload 8
    //   99: monitorenter
    //   100: aload_0
    //   101: getfield 96	com/tencent/mm/plugin/appbrand/appcache/bx:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   104: new 110	java/lang/StringBuilder
    //   107: dup
    //   108: ldc 143
    //   110: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload_0
    //   114: invokevirtual 146	com/tencent/mm/plugin/appbrand/appcache/bx:getTableName	()Ljava/lang/String;
    //   117: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 148
    //   122: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: iconst_3
    //   129: anewarray 150	java/lang/String
    //   132: dup
    //   133: iconst_0
    //   134: aload_1
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: iload_2
    //   139: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   142: aastore
    //   143: dup
    //   144: iconst_2
    //   145: lload_3
    //   146: invokestatic 157	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   149: aastore
    //   150: invokeinterface 163 3 0
    //   155: astore 7
    //   157: aload 7
    //   159: ifnull +100 -> 259
    //   162: aload 7
    //   164: checkcast 165	java/io/Closeable
    //   167: astore 9
    //   169: aload 9
    //   171: checkcast 167	android/database/Cursor
    //   174: astore 7
    //   176: aload 7
    //   178: invokeinterface 171 1 0
    //   183: ifeq +34 -> 217
    //   186: aload 7
    //   188: iconst_0
    //   189: invokeinterface 175 2 0
    //   194: istore 5
    //   196: aload 9
    //   198: aconst_null
    //   199: invokestatic 180	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   202: iload 5
    //   204: ifle +61 -> 265
    //   207: aload 8
    //   209: monitorexit
    //   210: ldc 100
    //   212: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: iconst_1
    //   216: ireturn
    //   217: iconst_0
    //   218: istore 5
    //   220: goto -24 -> 196
    //   223: astore 7
    //   225: ldc 100
    //   227: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload 7
    //   232: athrow
    //   233: astore_1
    //   234: aload 9
    //   236: aload 7
    //   238: invokestatic 180	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   241: ldc 100
    //   243: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_1
    //   247: athrow
    //   248: astore_1
    //   249: aload 8
    //   251: monitorexit
    //   252: ldc 100
    //   254: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: aload_1
    //   258: athrow
    //   259: iconst_0
    //   260: istore 5
    //   262: goto -60 -> 202
    //   265: new 10	com/tencent/mm/plugin/appbrand/appcache/bx$b
    //   268: dup
    //   269: invokespecial 182	com/tencent/mm/plugin/appbrand/appcache/bx$b:<init>	()V
    //   272: astore 7
    //   274: aload 7
    //   276: aload_1
    //   277: putfield 186	com/tencent/mm/plugin/appbrand/appcache/bx$b:field_appId	Ljava/lang/String;
    //   280: aload 7
    //   282: iload_2
    //   283: putfield 190	com/tencent/mm/plugin/appbrand/appcache/bx$b:field_appVersion	I
    //   286: aload 7
    //   288: lload_3
    //   289: putfield 194	com/tencent/mm/plugin/appbrand/appcache/bx$b:field_templateId	J
    //   292: aload_0
    //   293: aload 7
    //   295: checkcast 196	com/tencent/mm/sdk/storage/IAutoDBItem
    //   298: iconst_1
    //   299: invokespecial 200	com/tencent/mm/sdk/storage/MAutoStorage:insertNotify	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;Z)Z
    //   302: istore 6
    //   304: aload 8
    //   306: monitorexit
    //   307: ldc 100
    //   309: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: iload 6
    //   314: ireturn
    //   315: astore_1
    //   316: aconst_null
    //   317: astore 7
    //   319: goto -85 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	bx
    //   0	322	1	paramString	String
    //   0	322	2	paramInt	int
    //   0	322	3	paramLong	long
    //   27	234	5	i	int
    //   302	11	6	bool	boolean
    //   9	178	7	localObject	Object
    //   223	14	7	localThrowable	java.lang.Throwable
    //   272	46	7	localb	b
    //   95	210	8	localISQLiteDatabase	ISQLiteDatabase
    //   167	68	9	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   169	196	223	java/lang/Throwable
    //   225	233	233	finally
    //   100	157	248	finally
    //   162	169	248	finally
    //   196	202	248	finally
    //   234	248	248	finally
    //   265	304	248	finally
    //   169	196	315	finally
  }
  
  public final int bt(String paramString, int paramInt)
  {
    AppMethodBeat.i(232360);
    ??? = (CharSequence)paramString;
    if ((??? == null) || (((CharSequence)???).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(232360);
      return 0;
    }
    synchronized (this.db)
    {
      paramInt = this.db.delete(getTableName(), "appId=? and appVersion<?", new String[] { paramString, String.valueOf(paramInt) });
      AppMethodBeat.o(232360);
      return paramInt;
    }
  }
  
  /* Error */
  public final java.util.List<bh> c(long paramLong, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: ldc 212
    //   8: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_3
    //   12: checkcast 102	java/lang/CharSequence
    //   15: astore 7
    //   17: aload 7
    //   19: ifnull +13 -> 32
    //   22: aload 7
    //   24: invokeinterface 106 1 0
    //   29: ifne +55 -> 84
    //   32: iconst_1
    //   33: istore 5
    //   35: iload 5
    //   37: ifeq +59 -> 96
    //   40: aload 4
    //   42: checkcast 102	java/lang/CharSequence
    //   45: astore 7
    //   47: aload 7
    //   49: ifnull +13 -> 62
    //   52: aload 7
    //   54: invokeinterface 106 1 0
    //   59: ifne +31 -> 90
    //   62: iconst_1
    //   63: istore 5
    //   65: iload 5
    //   67: ifeq +29 -> 96
    //   70: getstatic 218	kotlin/a/v:aaAd	Lkotlin/a/v;
    //   73: checkcast 220	java/util/List
    //   76: astore_3
    //   77: ldc 212
    //   79: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_3
    //   83: areturn
    //   84: iconst_0
    //   85: istore 5
    //   87: goto -52 -> 35
    //   90: iconst_0
    //   91: istore 5
    //   93: goto -28 -> 65
    //   96: aload_0
    //   97: getfield 96	com/tencent/mm/plugin/appbrand/appcache/bx:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   100: astore 9
    //   102: aload 9
    //   104: monitorenter
    //   105: aload_0
    //   106: getfield 96	com/tencent/mm/plugin/appbrand/appcache/bx:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   109: new 110	java/lang/StringBuilder
    //   112: dup
    //   113: ldc 222
    //   115: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   118: aload_0
    //   119: invokevirtual 146	com/tencent/mm/plugin/appbrand/appcache/bx:getTableName	()Ljava/lang/String;
    //   122: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 224
    //   127: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: iconst_1
    //   134: anewarray 150	java/lang/String
    //   137: dup
    //   138: iconst_0
    //   139: lload_1
    //   140: invokestatic 157	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   143: aastore
    //   144: invokeinterface 163 3 0
    //   149: astore 7
    //   151: aload 7
    //   153: ifnull +166 -> 319
    //   156: aload 7
    //   158: checkcast 165	java/io/Closeable
    //   161: astore 10
    //   163: aload 10
    //   165: checkcast 167	android/database/Cursor
    //   168: astore 7
    //   170: aload 7
    //   172: invokeinterface 171 1 0
    //   177: ifeq +100 -> 277
    //   180: new 226	java/util/LinkedList
    //   183: dup
    //   184: invokespecial 227	java/util/LinkedList:<init>	()V
    //   187: astore 11
    //   189: aload 11
    //   191: aload 7
    //   193: iconst_0
    //   194: invokeinterface 230 2 0
    //   199: invokevirtual 234	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   202: pop
    //   203: aload 7
    //   205: invokeinterface 237 1 0
    //   210: ifne -21 -> 189
    //   213: aload 11
    //   215: checkcast 220	java/util/List
    //   218: astore 7
    //   220: aload 7
    //   222: astore 6
    //   224: aload 10
    //   226: aconst_null
    //   227: invokestatic 180	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   230: aload 6
    //   232: checkcast 239	java/util/Collection
    //   235: astore 7
    //   237: aload 7
    //   239: ifnull +350 -> 589
    //   242: aload 7
    //   244: invokeinterface 242 1 0
    //   249: ifeq +76 -> 325
    //   252: goto +337 -> 589
    //   255: iload 5
    //   257: ifeq +74 -> 331
    //   260: getstatic 218	kotlin/a/v:aaAd	Lkotlin/a/v;
    //   263: checkcast 220	java/util/List
    //   266: astore_3
    //   267: aload 9
    //   269: monitorexit
    //   270: ldc 212
    //   272: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_3
    //   276: areturn
    //   277: aconst_null
    //   278: astore 6
    //   280: goto -56 -> 224
    //   283: astore 4
    //   285: ldc 212
    //   287: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload 4
    //   292: athrow
    //   293: astore_3
    //   294: aload 10
    //   296: aload 4
    //   298: invokestatic 180	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   301: ldc 212
    //   303: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_3
    //   307: athrow
    //   308: astore_3
    //   309: aload 9
    //   311: monitorexit
    //   312: ldc 212
    //   314: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload_3
    //   318: athrow
    //   319: aconst_null
    //   320: astore 6
    //   322: goto -92 -> 230
    //   325: iconst_0
    //   326: istore 5
    //   328: goto -73 -> 255
    //   331: new 226	java/util/LinkedList
    //   334: dup
    //   335: invokespecial 227	java/util/LinkedList:<init>	()V
    //   338: astore 10
    //   340: aload 6
    //   342: checkcast 244	java/lang/Iterable
    //   345: invokeinterface 248 1 0
    //   350: astore 11
    //   352: aload 11
    //   354: invokeinterface 253 1 0
    //   359: ifeq +185 -> 544
    //   362: aload 11
    //   364: invokeinterface 257 1 0
    //   369: checkcast 150	java/lang/String
    //   372: astore 6
    //   374: aload_0
    //   375: getfield 96	com/tencent/mm/plugin/appbrand/appcache/bx:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   378: astore 12
    //   380: new 110	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   387: aload 6
    //   389: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: ldc_w 260
    //   395: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: astore 13
    //   403: aload_3
    //   404: ifnonnull +172 -> 576
    //   407: ldc_w 261
    //   410: astore 6
    //   412: goto +183 -> 595
    //   415: aload 12
    //   417: ldc_w 263
    //   420: iconst_4
    //   421: anewarray 150	java/lang/String
    //   424: dup
    //   425: iconst_0
    //   426: aload 13
    //   428: aastore
    //   429: dup
    //   430: iconst_1
    //   431: aload 6
    //   433: aastore
    //   434: dup
    //   435: iconst_2
    //   436: aload 7
    //   438: aastore
    //   439: dup
    //   440: iconst_3
    //   441: ldc_w 261
    //   444: aastore
    //   445: invokeinterface 163 3 0
    //   450: astore 6
    //   452: aload 6
    //   454: ifnull -102 -> 352
    //   457: aload 6
    //   459: checkcast 165	java/io/Closeable
    //   462: astore 6
    //   464: aload 6
    //   466: checkcast 167	android/database/Cursor
    //   469: astore 7
    //   471: aload 7
    //   473: invokeinterface 171 1 0
    //   478: ifeq +27 -> 505
    //   481: new 265	com/tencent/mm/plugin/appbrand/appcache/bh
    //   484: dup
    //   485: invokespecial 266	com/tencent/mm/plugin/appbrand/appcache/bh:<init>	()V
    //   488: astore 12
    //   490: aload 12
    //   492: aload 7
    //   494: invokevirtual 270	com/tencent/mm/plugin/appbrand/appcache/bh:convertFrom	(Landroid/database/Cursor;)V
    //   497: aload 10
    //   499: aload 12
    //   501: invokevirtual 234	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   504: pop
    //   505: getstatic 276	kotlin/x:aazN	Lkotlin/x;
    //   508: astore 7
    //   510: aload 6
    //   512: aconst_null
    //   513: invokestatic 180	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   516: goto -164 -> 352
    //   519: astore 4
    //   521: ldc 212
    //   523: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   526: aload 4
    //   528: athrow
    //   529: astore_3
    //   530: aload 6
    //   532: aload 4
    //   534: invokestatic 180	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   537: ldc 212
    //   539: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: aload_3
    //   543: athrow
    //   544: aload 10
    //   546: checkcast 220	java/util/List
    //   549: astore_3
    //   550: aload 9
    //   552: monitorexit
    //   553: ldc 212
    //   555: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: aload_3
    //   559: areturn
    //   560: astore_3
    //   561: aload 8
    //   563: astore 4
    //   565: goto -35 -> 530
    //   568: astore_3
    //   569: aload 6
    //   571: astore 4
    //   573: goto -279 -> 294
    //   576: aload_3
    //   577: astore 6
    //   579: goto +16 -> 595
    //   582: aload 4
    //   584: astore 7
    //   586: goto -171 -> 415
    //   589: iconst_1
    //   590: istore 5
    //   592: goto -337 -> 255
    //   595: aload 4
    //   597: ifnonnull -15 -> 582
    //   600: ldc_w 261
    //   603: astore 7
    //   605: goto -190 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	this	bx
    //   0	608	1	paramLong	long
    //   0	608	3	paramString1	String
    //   0	608	4	paramString2	String
    //   33	558	5	i	int
    //   4	574	6	localObject1	Object
    //   15	589	7	localObject2	Object
    //   1	561	8	localObject3	Object
    //   100	451	9	localISQLiteDatabase	ISQLiteDatabase
    //   161	384	10	localObject4	Object
    //   187	176	11	localObject5	Object
    //   378	122	12	localObject6	Object
    //   401	26	13	str	String
    // Exception table:
    //   from	to	target	type
    //   163	189	283	java/lang/Throwable
    //   189	220	283	java/lang/Throwable
    //   285	293	293	finally
    //   105	151	308	finally
    //   156	163	308	finally
    //   224	230	308	finally
    //   230	237	308	finally
    //   242	252	308	finally
    //   260	267	308	finally
    //   294	308	308	finally
    //   331	352	308	finally
    //   352	403	308	finally
    //   415	452	308	finally
    //   457	464	308	finally
    //   510	516	308	finally
    //   530	544	308	finally
    //   544	550	308	finally
    //   464	505	519	java/lang/Throwable
    //   505	510	519	java/lang/Throwable
    //   521	529	529	finally
    //   464	505	560	finally
    //   505	510	560	finally
    //   163	189	568	finally
    //   189	220	568	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionTemplateIdMappingStorage$Companion;", "", "()V", "TABLE_CREATE", "", "", "[Ljava/lang/String;", "TAG", "data-storage_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionTemplateIdMappingStorage$MappingRecord;", "Lcom/tencent/mm/autogen/table/BaseWxaVersionTemplateIdMapping;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "data-storage_release"})
  public static final class b
    extends io
  {
    private static final IAutoDBItem.MAutoDBInfo lqK;
    private static final String[] lqL;
    public static final a nID;
    
    static
    {
      AppMethodBeat.i(232495);
      nID = new a((byte)0);
      Object localObject = io.aoY();
      p.j(localObject, "initAutoDBInfo(MappingRecord::class.java)");
      lqK = (IAutoDBItem.MAutoDBInfo)localObject;
      localObject = MAutoStorage.getCreateSQLs(lqK, "WxaVersionTemplateIdMapping");
      p.j(localObject, "MAutoStorage.getCreateSQLs(INFO, TABLE_NAME)");
      lqL = new String[] { localObject };
      AppMethodBeat.o(232495);
    }
    
    public final IAutoDBItem.MAutoDBInfo getDBInfo()
    {
      return lqK;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionTemplateIdMappingStorage$MappingRecord$Companion;", "", "()V", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getINFO", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE_CREATE", "", "", "getTABLE_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "data-storage_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bx
 * JD-Core Version:    0.7.0.1
 */
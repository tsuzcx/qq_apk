package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStats;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "checkReportOnLocalPkgFound", "", "appLaunchInstanceId", "", "appId", "version", "", "packageType", "packageKey", "checkReportOnLocalPkgFoundInternal", "delete", "", "pruneOutdatedRecords", "setSource", "source", "reportId", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.z.c<b>
{
  public static final String[] gLs;
  public static final a iQC;
  private final e db;
  
  static
  {
    AppMethodBeat.i(50208);
    iQC = new a((byte)0);
    gLs = new String[] { j.getCreateSQLs(b.gLr, "AppBrandWxaPkgPreDownloadStatistics2"), "DROP TABLE IF EXISTS AppBrandWxaPkgPreDownloadStatistics" };
    AppMethodBeat.o(50208);
  }
  
  public a(e parame)
  {
    super(parame, b.gLr, "AppBrandWxaPkgPreDownloadStatistics2", b.INDEX_CREATE);
    AppMethodBeat.i(50207);
    this.db = parame;
    AppMethodBeat.o(50207);
  }
  
  public final void a(final String paramString1, final String paramString2, final int paramInt1, final int paramInt2, final String paramString3)
  {
    AppMethodBeat.i(162171);
    com.tencent.mm.ad.c.b("MicroMsg.AppBrand.PredownloadGetCodeStatStorage__report", (d.g.a.a)new b(this, paramString1, paramString2, paramInt1, paramInt2, paramString3));
    AppMethodBeat.o(162171);
  }
  
  /* Error */
  public final void aQK()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 217
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 221	com/tencent/mm/plugin/appbrand/appcache/b/d/a:getAll	()Landroid/database/Cursor;
    //   11: checkcast 223	java/io/Closeable
    //   14: astore 4
    //   16: aload 4
    //   18: checkcast 225	android/database/Cursor
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +12 -> 35
    //   26: aload_2
    //   27: invokeinterface 228 1 0
    //   32: ifne +19 -> 51
    //   35: getstatic 234	d/y:JfV	Ld/y;
    //   38: astore_2
    //   39: aload 4
    //   41: aconst_null
    //   42: invokestatic 239	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   45: ldc 217
    //   47: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: return
    //   51: new 241	java/util/LinkedList
    //   54: dup
    //   55: invokespecial 242	java/util/LinkedList:<init>	()V
    //   58: astore 5
    //   60: new 64	com/tencent/mm/plugin/appbrand/appcache/b/d/b
    //   63: dup
    //   64: invokespecial 111	com/tencent/mm/plugin/appbrand/appcache/b/d/b:<init>	()V
    //   67: astore 6
    //   69: aload 6
    //   71: aload_2
    //   72: invokevirtual 246	com/tencent/mm/plugin/appbrand/appcache/b/d/b:convertFrom	(Landroid/database/Cursor;)V
    //   75: aload 5
    //   77: aload 6
    //   79: invokevirtual 250	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_2
    //   84: invokeinterface 253 1 0
    //   89: ifne -29 -> 60
    //   92: aload 5
    //   94: checkcast 255	java/lang/Iterable
    //   97: invokeinterface 259 1 0
    //   102: astore 5
    //   104: aload 5
    //   106: invokeinterface 264 1 0
    //   111: ifeq -76 -> 35
    //   114: aload 5
    //   116: invokeinterface 268 1 0
    //   121: checkcast 64	com/tencent/mm/plugin/appbrand/appcache/b/d/b
    //   124: astore 6
    //   126: new 270	com/tencent/mm/plugin/appbrand/appcache/ab
    //   129: dup
    //   130: aload 6
    //   132: getfield 115	com/tencent/mm/plugin/appbrand/appcache/b/d/b:field_appId	Ljava/lang/String;
    //   135: aload 6
    //   137: getfield 125	com/tencent/mm/plugin/appbrand/appcache/b/d/b:field_packageKey	Ljava/lang/String;
    //   140: aload 6
    //   142: getfield 122	com/tencent/mm/plugin/appbrand/appcache/b/d/b:field_packageType	I
    //   145: invokespecial 273	com/tencent/mm/plugin/appbrand/appcache/ab:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   148: astore_2
    //   149: invokestatic 277	com/tencent/mm/plugin/appbrand/app/j:aOK	()Lcom/tencent/mm/plugin/appbrand/appcache/bf;
    //   152: astore 7
    //   154: aload 7
    //   156: ifnull +96 -> 252
    //   159: aload 7
    //   161: aload_2
    //   162: invokevirtual 281	com/tencent/mm/plugin/appbrand/appcache/ab:toString	()Ljava/lang/String;
    //   165: aload 6
    //   167: getfield 119	com/tencent/mm/plugin/appbrand/appcache/b/d/b:field_version	I
    //   170: iconst_0
    //   171: iconst_1
    //   172: anewarray 62	java/lang/String
    //   175: dup
    //   176: iconst_0
    //   177: ldc_w 283
    //   180: aastore
    //   181: invokevirtual 288	com/tencent/mm/plugin/appbrand/appcache/bf:a	(Ljava/lang/String;II[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/bb;
    //   184: astore_2
    //   185: aload_2
    //   186: ifnull +27 -> 213
    //   189: aload_2
    //   190: getfield 293	com/tencent/mm/plugin/appbrand/appcache/bb:field_pkgPath	Ljava/lang/String;
    //   193: checkcast 105	java/lang/CharSequence
    //   196: astore_2
    //   197: aload_2
    //   198: ifnull +68 -> 266
    //   201: aload_2
    //   202: invokeinterface 109 1 0
    //   207: ifne +50 -> 257
    //   210: goto +56 -> 266
    //   213: aload_0
    //   214: aload 6
    //   216: checkcast 136	com/tencent/mm/sdk/e/c
    //   219: iconst_0
    //   220: anewarray 62	java/lang/String
    //   223: invokespecial 295	com/tencent/mm/plugin/appbrand/z/c:delete	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   226: pop
    //   227: goto -123 -> 104
    //   230: astore_3
    //   231: ldc 217
    //   233: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_3
    //   237: athrow
    //   238: astore_2
    //   239: aload 4
    //   241: aload_3
    //   242: invokestatic 239	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   245: ldc 217
    //   247: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_2
    //   251: athrow
    //   252: aconst_null
    //   253: astore_2
    //   254: goto -69 -> 185
    //   257: iconst_0
    //   258: istore_1
    //   259: goto +9 -> 268
    //   262: astore_2
    //   263: goto -24 -> 239
    //   266: iconst_1
    //   267: istore_1
    //   268: iload_1
    //   269: ifeq -165 -> 104
    //   272: goto -59 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	a
    //   258	11	1	i	int
    //   21	181	2	localObject1	Object
    //   238	13	2	localObject2	Object
    //   253	1	2	localObject3	Object
    //   262	1	2	localObject4	Object
    //   1	1	3	localObject5	Object
    //   230	12	3	localThrowable	java.lang.Throwable
    //   14	226	4	localCloseable	java.io.Closeable
    //   58	57	5	localObject6	Object
    //   67	148	6	localb	b
    //   152	8	7	localbf	com.tencent.mm.plugin.appbrand.appcache.bf
    // Exception table:
    //   from	to	target	type
    //   16	22	230	java/lang/Throwable
    //   26	35	230	java/lang/Throwable
    //   35	39	230	java/lang/Throwable
    //   51	60	230	java/lang/Throwable
    //   60	104	230	java/lang/Throwable
    //   104	154	230	java/lang/Throwable
    //   159	185	230	java/lang/Throwable
    //   189	197	230	java/lang/Throwable
    //   201	210	230	java/lang/Throwable
    //   213	227	230	java/lang/Throwable
    //   231	238	238	finally
    //   16	22	262	finally
    //   26	35	262	finally
    //   35	39	262	finally
    //   51	60	262	finally
    //   60	104	262	finally
    //   104	154	262	finally
    //   159	185	262	finally
    //   189	197	262	finally
    //   201	210	262	finally
    //   213	227	262	finally
  }
  
  public final void q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(50206);
    a(paramString1, paramString2, paramInt, 0, null);
    AppMethodBeat.o(50206);
  }
  
  public final boolean vv(String paramString)
  {
    AppMethodBeat.i(50203);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50203);
      return false;
    }
    if (this.db.delete("AppBrandWxaPkgPreDownloadStatistics2", "appId=?", new String[] { paramString }) > 0)
    {
      AppMethodBeat.o(50203);
      return true;
    }
    AppMethodBeat.o(50203);
    return false;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage$Companion;", "", "()V", "TABLE_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.a
 * JD-Core Version:    0.7.0.1
 */
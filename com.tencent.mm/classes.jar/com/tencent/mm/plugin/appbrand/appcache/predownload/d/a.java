package com.tencent.mm.plugin.appbrand.appcache.predownload.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStats;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "checkReportOnLocalPkgFound", "", "appLaunchInstanceId", "", "appId", "version", "", "packageType", "packageKey", "checkReportOnLocalPkgFoundInternal", "delete", "", "pruneOutdatedRecords", "setSource", "source", "reportId", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends c<b>
{
  public static final String[] iBh;
  public static final a kQz;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(50208);
    kQz = new a((byte)0);
    iBh = new String[] { MAutoStorage.getCreateSQLs(b.iBg, "AppBrandWxaPkgPreDownloadStatistics2"), "DROP TABLE IF EXISTS AppBrandWxaPkgPreDownloadStatistics" };
    AppMethodBeat.o(50208);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.iBg, "AppBrandWxaPkgPreDownloadStatistics2", b.INDEX_CREATE);
    AppMethodBeat.i(50207);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(50207);
  }
  
  public final void a(final String paramString1, final String paramString2, final int paramInt1, final int paramInt2, final String paramString3)
  {
    AppMethodBeat.i(162171);
    d.b("MicroMsg.AppBrand.PredownloadGetCodeStatStorage__report", (kotlin.g.a.a)new b(this, paramString1, paramString2, paramInt1, paramInt2, paramString3));
    AppMethodBeat.o(162171);
  }
  
  /* Error */
  public final void bwV()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 215
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 219	com/tencent/mm/plugin/appbrand/appcache/predownload/d/a:getAll	()Landroid/database/Cursor;
    //   11: checkcast 221	java/io/Closeable
    //   14: astore 4
    //   16: aload 4
    //   18: checkcast 223	android/database/Cursor
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +12 -> 35
    //   26: aload_2
    //   27: invokeinterface 226 1 0
    //   32: ifne +19 -> 51
    //   35: getstatic 232	kotlin/x:SXb	Lkotlin/x;
    //   38: astore_2
    //   39: aload 4
    //   41: aconst_null
    //   42: invokestatic 237	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   45: ldc 215
    //   47: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: return
    //   51: new 239	java/util/LinkedList
    //   54: dup
    //   55: invokespecial 240	java/util/LinkedList:<init>	()V
    //   58: astore 5
    //   60: new 63	com/tencent/mm/plugin/appbrand/appcache/predownload/d/b
    //   63: dup
    //   64: invokespecial 109	com/tencent/mm/plugin/appbrand/appcache/predownload/d/b:<init>	()V
    //   67: astore 6
    //   69: aload 6
    //   71: aload_2
    //   72: invokevirtual 244	com/tencent/mm/plugin/appbrand/appcache/predownload/d/b:convertFrom	(Landroid/database/Cursor;)V
    //   75: aload 5
    //   77: aload 6
    //   79: invokevirtual 248	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_2
    //   84: invokeinterface 251 1 0
    //   89: ifne -29 -> 60
    //   92: aload 5
    //   94: checkcast 253	java/lang/Iterable
    //   97: invokeinterface 257 1 0
    //   102: astore 5
    //   104: aload 5
    //   106: invokeinterface 262 1 0
    //   111: ifeq -76 -> 35
    //   114: aload 5
    //   116: invokeinterface 266 1 0
    //   121: checkcast 63	com/tencent/mm/plugin/appbrand/appcache/predownload/d/b
    //   124: astore 6
    //   126: new 268	com/tencent/mm/plugin/appbrand/appcache/ad
    //   129: dup
    //   130: aload 6
    //   132: getfield 113	com/tencent/mm/plugin/appbrand/appcache/predownload/d/b:field_appId	Ljava/lang/String;
    //   135: aload 6
    //   137: getfield 123	com/tencent/mm/plugin/appbrand/appcache/predownload/d/b:field_packageKey	Ljava/lang/String;
    //   140: aload 6
    //   142: getfield 120	com/tencent/mm/plugin/appbrand/appcache/predownload/d/b:field_packageType	I
    //   145: invokespecial 271	com/tencent/mm/plugin/appbrand/appcache/ad:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   148: astore_2
    //   149: invokestatic 275	com/tencent/mm/plugin/appbrand/app/n:buL	()Lcom/tencent/mm/plugin/appbrand/appcache/bh;
    //   152: astore 7
    //   154: aload 7
    //   156: ifnull +96 -> 252
    //   159: aload 7
    //   161: aload_2
    //   162: invokevirtual 279	com/tencent/mm/plugin/appbrand/appcache/ad:toString	()Ljava/lang/String;
    //   165: aload 6
    //   167: getfield 117	com/tencent/mm/plugin/appbrand/appcache/predownload/d/b:field_version	I
    //   170: iconst_0
    //   171: iconst_1
    //   172: anewarray 61	java/lang/String
    //   175: dup
    //   176: iconst_0
    //   177: ldc_w 281
    //   180: aastore
    //   181: invokevirtual 286	com/tencent/mm/plugin/appbrand/appcache/bh:a	(Ljava/lang/String;II[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appcache/bd;
    //   184: astore_2
    //   185: aload_2
    //   186: ifnull +27 -> 213
    //   189: aload_2
    //   190: getfield 291	com/tencent/mm/plugin/appbrand/appcache/bd:field_pkgPath	Ljava/lang/String;
    //   193: checkcast 103	java/lang/CharSequence
    //   196: astore_2
    //   197: aload_2
    //   198: ifnull +68 -> 266
    //   201: aload_2
    //   202: invokeinterface 107 1 0
    //   207: ifne +50 -> 257
    //   210: goto +56 -> 266
    //   213: aload_0
    //   214: aload 6
    //   216: checkcast 134	com/tencent/mm/sdk/storage/IAutoDBItem
    //   219: iconst_0
    //   220: anewarray 61	java/lang/String
    //   223: invokespecial 293	com/tencent/mm/plugin/appbrand/ab/c:delete	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
    //   226: pop
    //   227: goto -123 -> 104
    //   230: astore_3
    //   231: ldc 215
    //   233: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_3
    //   237: athrow
    //   238: astore_2
    //   239: aload 4
    //   241: aload_3
    //   242: invokestatic 237	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   245: ldc 215
    //   247: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   152	8	7	localbh	com.tencent.mm.plugin.appbrand.appcache.bh
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
  
  public final boolean gC(String paramString)
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage$Companion;", "", "()V", "TABLE_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.d.a
 * JD-Core Version:    0.7.0.1
 */
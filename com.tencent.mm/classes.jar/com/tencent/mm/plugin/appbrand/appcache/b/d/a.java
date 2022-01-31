package com.tencent.mm.plugin.appbrand.appcache.b.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStats;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "checkReportOnLocalPkgFound", "", "appId", "", "version", "", "delete", "", "increaseHitCount", "pruneOutdatedRecords", "setSource", "source", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.r.c<b>
{
  public static final String[] fkl;
  @Deprecated
  public static final a.a gYc;
  private final e db;
  
  static
  {
    AppMethodBeat.i(134478);
    gYc = new a.a((byte)0);
    fkl = new String[] { j.getCreateSQLs(b.fkk, "AppBrandWxaPkgPreDownloadStatistics") };
    AppMethodBeat.o(134478);
  }
  
  public a(e parame)
  {
    super(parame, b.fkk, "AppBrandWxaPkgPreDownloadStatistics", b.INDEX_CREATE);
    AppMethodBeat.i(134477);
    this.db = parame;
    AppMethodBeat.o(134477);
  }
  
  /* Error */
  public final void awo()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 97
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 99	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 101	java/util/LinkedList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 93	com/tencent/mm/plugin/appbrand/appcache/b/d/a:db	Lcom/tencent/mm/sdk/e/e;
    //   20: ldc 103
    //   22: aconst_null
    //   23: iconst_2
    //   24: invokeinterface 109 4 0
    //   29: astore 5
    //   31: aload 5
    //   33: ifnull +48 -> 81
    //   36: aload 5
    //   38: checkcast 111	java/io/Closeable
    //   41: astore 5
    //   43: aload 5
    //   45: checkcast 113	android/database/Cursor
    //   48: astore 6
    //   50: aload 6
    //   52: invokeinterface 117 1 0
    //   57: ifne +13 -> 70
    //   60: aload 6
    //   62: invokeinterface 120 1 0
    //   67: ifne +102 -> 169
    //   70: getstatic 126	a/y:BMg	La/y;
    //   73: astore 6
    //   75: aload 5
    //   77: aconst_null
    //   78: invokestatic 131	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   81: aload_3
    //   82: invokevirtual 135	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   85: astore_3
    //   86: aload_3
    //   87: invokeinterface 140 1 0
    //   92: ifeq +148 -> 240
    //   95: aload_3
    //   96: invokeinterface 144 1 0
    //   101: checkcast 146	a/o
    //   104: astore 4
    //   106: aload 4
    //   108: getfield 150	a/o:first	Ljava/lang/Object;
    //   111: checkcast 56	java/lang/String
    //   114: astore 5
    //   116: aload 4
    //   118: getfield 153	a/o:second	Ljava/lang/Object;
    //   121: checkcast 155	java/lang/Number
    //   124: invokevirtual 159	java/lang/Number:intValue	()I
    //   127: istore_1
    //   128: aload_0
    //   129: getfield 93	com/tencent/mm/plugin/appbrand/appcache/b/d/a:db	Lcom/tencent/mm/sdk/e/e;
    //   132: ldc 64
    //   134: new 161	java/lang/StringBuilder
    //   137: dup
    //   138: ldc 163
    //   140: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload 5
    //   145: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 172
    //   150: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload_1
    //   154: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokeinterface 183 3 0
    //   165: pop
    //   166: goto -80 -> 86
    //   169: aload_3
    //   170: new 146	a/o
    //   173: dup
    //   174: aload 6
    //   176: iconst_0
    //   177: invokeinterface 187 2 0
    //   182: aload 6
    //   184: iconst_1
    //   185: invokeinterface 191 2 0
    //   190: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   193: invokespecial 200	a/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   196: invokevirtual 204	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   199: pop
    //   200: aload 6
    //   202: invokeinterface 207 1 0
    //   207: istore_2
    //   208: iload_2
    //   209: ifne -40 -> 169
    //   212: goto -142 -> 70
    //   215: astore 4
    //   217: ldc 97
    //   219: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload 4
    //   224: athrow
    //   225: astore_3
    //   226: aload 5
    //   228: aload 4
    //   230: invokestatic 131	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   233: ldc 97
    //   235: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_3
    //   239: athrow
    //   240: ldc 97
    //   242: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: return
    //   246: astore_3
    //   247: goto -21 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	a
    //   127	27	1	i	int
    //   207	2	2	bool	boolean
    //   15	155	3	localObject1	Object
    //   225	14	3	localObject2	Object
    //   246	1	3	localObject3	Object
    //   1	116	4	localo	a.o
    //   215	14	4	localThrowable	java.lang.Throwable
    //   29	198	5	localObject4	Object
    //   48	153	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   43	70	215	java/lang/Throwable
    //   70	75	215	java/lang/Throwable
    //   169	208	215	java/lang/Throwable
    //   217	225	225	finally
    //   43	70	246	finally
    //   70	75	246	finally
    //   169	208	246	finally
  }
  
  public final void az(String paramString, int paramInt)
  {
    AppMethodBeat.i(134476);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(134476);
      return;
    }
    localObject = new b();
    ((b)localObject).field_appId = paramString;
    ((b)localObject).field_version = paramInt;
    ((b)localObject).field_hitCount = 0;
    ((b)localObject).field_source = 0;
    ((b)localObject).field_reportId = 0;
    boolean bool = get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    if (((b)localObject).field_source == 1) {
      if (((b)localObject).field_hitCount <= 0) {
        break label167;
      }
    }
    label167:
    for (paramInt = 57;; paramInt = 56)
    {
      paramString = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.cT(((b)localObject).field_reportId, paramInt);
      ((b)localObject).field_hitCount += 1;
      if (!bool) {
        break;
      }
      update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      AppMethodBeat.o(134476);
      return;
    }
    insert((com.tencent.mm.sdk.e.c)localObject);
    AppMethodBeat.o(134476);
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(134474);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(134474);
      return false;
    }
    paramString = "delete from AppBrandWxaPkgPreDownloadStatistics where appId='" + paramString + '\'';
    boolean bool = this.db.execSQL("AppBrandWxaPkgPreDownloadStatistics", paramString);
    AppMethodBeat.o(134474);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.a
 * JD-Core Version:    0.7.0.1
 */
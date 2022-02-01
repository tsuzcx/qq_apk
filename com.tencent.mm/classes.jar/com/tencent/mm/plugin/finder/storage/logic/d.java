package com.tencent.mm.plugin.finder.storage.logic;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.preload.c;
import com.tencent.mm.plugin.finder.preload.c.a;
import com.tencent.mm.plugin.finder.preload.c.b;
import com.tencent.mm.plugin.finder.preload.model.a.a;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMediaCacheLogic;", "", "()V", "TAG", "", "THREAD_TAG", "isOpenMultiBitRateDownload", "", "isOptFindBestVideo", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "memoryCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "checkFileFormat", "", "mediaId", "fileFormat", "deleteAll", "deleteBelowFileFormat", "originalMediaId", "findBestVideoToPlay", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "query", "isCheckFileExit", "queryByOriginalMediaId", "", "quickFindBestVideoToPlay", "replace", "cache", "store", "url", "codingFormat", "", "cacheSize", "totalSize", "state", "duration", "urlToken", "decodeKey", "syncMemoryCacheToDB", "updateMoovReady", "updateMoovReadyMemory", "updatePlayed", "hasPlayed", "updateProgress", "updateProgressMemory", "plugin-finder_release"})
public final class d
{
  private static final HashMap<String, av> AnL;
  private static final boolean AnM;
  public static final d AnN;
  public static final t wUY;
  private static final boolean zKT;
  private static final f zKf;
  
  static
  {
    AppMethodBeat.i(167109);
    AnN = new d();
    wUY = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getMediaCacheStorage();
    AnL = new HashMap(100);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    zKT = com.tencent.mm.plugin.finder.storage.d.dTw();
    locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dWs().aSr()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      AnM = bool;
      zKf = g.ar((kotlin.g.a.a)b.AnO);
      AppMethodBeat.o(167109);
      return;
    }
  }
  
  public static av a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(289301);
    p.k(paramString, "mediaId");
    paramString = bC(paramString, false);
    paramString.field_cacheSize = paramLong1;
    paramString.field_totalSize = paramLong2;
    paramString.field_state = paramInt;
    if (!paramString.field_moovReady)
    {
      c.a locala = c.zKl;
      if (c.a.a(paramString).zKm) {
        paramString.field_moovReady = true;
      }
    }
    AppMethodBeat.o(289301);
    return paramString;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(289308);
    p.k(paramString1, "mediaId");
    p.k(paramString2, "originalMediaId");
    p.k(paramString3, "url");
    p.k(paramString4, "fileFormat");
    av localav = new av();
    localav.field_mediaId = paramString1;
    localav.field_originMediaId = paramString2;
    localav.field_url = paramString3;
    localav.field_reqFormat = paramInt1;
    localav.field_cacheSize = paramLong1;
    localav.field_totalSize = paramLong2;
    localav.field_fileFormat = paramString4;
    localav.field_state = paramInt2;
    localav.field_duration = paramInt3;
    localav.field_urlToken = paramString5;
    localav.field_decodeKey = paramString6;
    boolean bool = d(localav);
    AppMethodBeat.o(289308);
    return bool;
  }
  
  public static void aET(String paramString)
  {
    AppMethodBeat.i(289303);
    p.k(paramString, "mediaId");
    com.tencent.mm.ae.d.c("FinderMediaCacheUpdateThread", (kotlin.g.a.a)new d(paramString));
    AppMethodBeat.o(289303);
  }
  
  public static List<av> aEV(String paramString)
  {
    AppMethodBeat.i(289307);
    p.k(paramString, "originalMediaId");
    Object localObject = wUY;
    p.k(paramString, "originMediaId");
    LinkedList localLinkedList = new LinkedList();
    paramString = "select *, rowid from FinderMediaCacheInfoV2  where originMediaId = '" + paramString + "' ";
    paramString = ((t)localObject).db.rawQuery(paramString, null);
    if (paramString != null)
    {
      paramString.moveToFirst();
      while (!paramString.isAfterLast())
      {
        localObject = new av();
        ((av)localObject).convertFrom(paramString);
        localLinkedList.add(localObject);
        paramString.moveToNext();
      }
      paramString.close();
    }
    paramString = (List)localLinkedList;
    AppMethodBeat.o(289307);
    return paramString;
  }
  
  public static av bC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(289305);
    p.k(paramString, "mediaId");
    if (((CharSequence)paramString).length() == 0) {}
    av localav;
    for (int i = 1; i != 0; i = 0)
    {
      localav = new av();
      localav.field_mediaId = paramString;
      AppMethodBeat.o(289305);
      return localav;
    }
    synchronized (AnL)
    {
      localav = (av)AnL.get(paramString);
      if (localav == null) {
        localav = wUY.aEJ(paramString);
      }
    }
    for (;;)
    {
      synchronized (AnL)
      {
        ((Map)AnL).put(paramString, localav);
        x localx = x.aazN;
        p.j(localav, "synchronized(memoryCache…        dbCache\n        }");
        if (paramBoolean)
        {
          if (((CharSequence)localav.getFilePath()).length() <= 0) {
            break label258;
          }
          i = 1;
          if ((i != 0) && (!u.agG(localav.getFilePath())))
          {
            localav.reset();
            localav.field_state = -2;
            d(localav);
            Log.i("Finder.MediaCacheLogic", "[query] mediaId=" + paramString + " not found file. state=" + localav.field_state + " filePath=" + localav.getFilePath());
          }
        }
        AppMethodBeat.o(289305);
        return localav;
        paramString = finally;
        AppMethodBeat.o(289305);
        throw paramString;
      }
      label258:
      i = 0;
    }
  }
  
  public static boolean byd()
  {
    AppMethodBeat.i(289309);
    int i = wUY.db.delete(wUY.getTableName(), "rowid >= ?", new String[] { "0" });
    Log.i("Finder.MediaCacheLogic", "[deleteAll] ret=".concat(String.valueOf(i)));
    synchronized (AnL)
    {
      AnL.clear();
      x localx = x.aazN;
      if (i >= 0)
      {
        AppMethodBeat.o(289309);
        return true;
      }
    }
    AppMethodBeat.o(289309);
    return false;
  }
  
  /* Error */
  private static aa c(long paramLong, csg paramcsg)
  {
    // Byte code:
    //   0: ldc_w 410
    //   3: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 416	java/lang/System:currentTimeMillis	()J
    //   9: lstore 5
    //   11: iconst_0
    //   12: istore 4
    //   14: iconst_0
    //   15: istore 7
    //   17: invokestatic 419	com/tencent/mm/plugin/finder/storage/logic/d:getPreloadModel	()Lcom/tencent/mm/plugin/finder/preload/model/a;
    //   20: lload_0
    //   21: aload_2
    //   22: invokevirtual 423	com/tencent/mm/plugin/finder/preload/model/a:a	(JLcom/tencent/mm/protocal/protobuf/csg;)Lcom/tencent/mm/plugin/finder/loader/aa;
    //   25: astore 10
    //   27: aload 10
    //   29: invokevirtual 428	com/tencent/mm/plugin/finder/loader/aa:aBv	()Ljava/lang/String;
    //   32: iconst_0
    //   33: invokestatic 178	com/tencent/mm/plugin/finder/storage/logic/d:bC	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/finder/model/av;
    //   36: astore 9
    //   38: aload 9
    //   40: invokevirtual 431	com/tencent/mm/plugin/finder/model/av:dKP	()I
    //   43: istore_3
    //   44: aload 9
    //   46: invokevirtual 434	com/tencent/mm/plugin/finder/model/av:dKO	()Z
    //   49: istore 8
    //   51: iload 8
    //   53: ifne +246 -> 299
    //   56: iload_3
    //   57: bipush 30
    //   59: if_icmpge +240 -> 299
    //   62: aload_2
    //   63: getfield 438	com/tencent/mm/protocal/protobuf/csg:mediaId	Ljava/lang/String;
    //   66: astore 11
    //   68: aload 11
    //   70: astore 9
    //   72: aload 11
    //   74: ifnonnull +8 -> 82
    //   77: ldc_w 439
    //   80: astore 9
    //   82: aload 9
    //   84: invokestatic 441	com/tencent/mm/plugin/finder/storage/logic/d:aEV	(Ljava/lang/String;)Ljava/util/List;
    //   87: checkcast 443	java/lang/Iterable
    //   90: new 10	com/tencent/mm/plugin/finder/storage/logic/d$c
    //   93: dup
    //   94: invokespecial 444	com/tencent/mm/plugin/finder/storage/logic/d$c:<init>	()V
    //   97: checkcast 446	java/util/Comparator
    //   100: invokestatic 451	kotlin/a/j:a	(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;
    //   103: checkcast 443	java/lang/Iterable
    //   106: invokeinterface 455 1 0
    //   111: astore 11
    //   113: aload 11
    //   115: invokeinterface 460 1 0
    //   120: ifeq +167 -> 287
    //   123: aload 11
    //   125: invokeinterface 463 1 0
    //   130: astore 9
    //   132: aload 9
    //   134: checkcast 180	com/tencent/mm/plugin/finder/model/av
    //   137: invokevirtual 434	com/tencent/mm/plugin/finder/model/av:dKO	()Z
    //   140: ifeq -27 -> 113
    //   143: aload 9
    //   145: checkcast 180	com/tencent/mm/plugin/finder/model/av
    //   148: astore 9
    //   150: aload 9
    //   152: ifnull +141 -> 293
    //   155: getstatic 467	com/tencent/mm/plugin/finder/preload/model/a:zKX	Lcom/tencent/mm/plugin/finder/preload/model/a$a;
    //   158: astore 11
    //   160: new 425	com/tencent/mm/plugin/finder/loader/aa
    //   163: dup
    //   164: aload_2
    //   165: aload 9
    //   167: getfield 232	com/tencent/mm/plugin/finder/model/av:field_fileFormat	Ljava/lang/String;
    //   170: invokestatic 473	com/tencent/mm/plugin/finder/preload/model/a$a:aDI	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/storage/u;
    //   173: aload 9
    //   175: getfield 229	com/tencent/mm/plugin/finder/model/av:field_reqFormat	I
    //   178: aconst_null
    //   179: bipush 8
    //   181: invokespecial 476	com/tencent/mm/plugin/finder/loader/aa:<init>	(Lcom/tencent/mm/protocal/protobuf/csg;Lcom/tencent/mm/plugin/finder/storage/u;ILjava/lang/String;I)V
    //   184: astore_2
    //   185: invokestatic 416	java/lang/System:currentTimeMillis	()J
    //   188: lload 5
    //   190: lsub
    //   191: lstore 5
    //   193: lload 5
    //   195: ldc2_w 477
    //   198: lcmp
    //   199: ifle +80 -> 279
    //   202: ldc_w 366
    //   205: new 271	java/lang/StringBuilder
    //   208: dup
    //   209: ldc_w 480
    //   212: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: lload 5
    //   217: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   220: ldc_w 485
    //   223: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: lload_0
    //   227: invokestatic 489	com/tencent/mm/ae/d:Fw	(J)Ljava/lang/String;
    //   230: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 491
    //   236: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 10
    //   241: invokevirtual 428	com/tencent/mm/plugin/finder/loader/aa:aBv	()Ljava/lang/String;
    //   244: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: bipush 32
    //   249: invokevirtual 494	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   252: ldc_w 496
    //   255: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: iload_3
    //   259: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: ldc_w 498
    //   265: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: iload 8
    //   270: invokevirtual 501	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   273: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 380	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: ldc_w 410
    //   282: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: aload_2
    //   286: areturn
    //   287: aconst_null
    //   288: astore 9
    //   290: goto -147 -> 143
    //   293: aload 10
    //   295: astore_2
    //   296: goto -111 -> 185
    //   299: invokestatic 416	java/lang/System:currentTimeMillis	()J
    //   302: lload 5
    //   304: lsub
    //   305: lstore 5
    //   307: lload 5
    //   309: ldc2_w 477
    //   312: lcmp
    //   313: ifle +80 -> 393
    //   316: ldc_w 366
    //   319: new 271	java/lang/StringBuilder
    //   322: dup
    //   323: ldc_w 480
    //   326: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   329: lload 5
    //   331: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   334: ldc_w 485
    //   337: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: lload_0
    //   341: invokestatic 489	com/tencent/mm/ae/d:Fw	(J)Ljava/lang/String;
    //   344: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 491
    //   350: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 10
    //   355: invokevirtual 428	com/tencent/mm/plugin/finder/loader/aa:aBv	()Ljava/lang/String;
    //   358: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: bipush 32
    //   363: invokevirtual 494	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   366: ldc_w 496
    //   369: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: iload_3
    //   373: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 498
    //   379: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: iload 8
    //   384: invokevirtual 501	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 380	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: ldc_w 410
    //   396: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: aload 10
    //   401: areturn
    //   402: astore_2
    //   403: iload 4
    //   405: istore_3
    //   406: invokestatic 416	java/lang/System:currentTimeMillis	()J
    //   409: lload 5
    //   411: lsub
    //   412: lstore 5
    //   414: lload 5
    //   416: ldc2_w 477
    //   419: lcmp
    //   420: ifle +80 -> 500
    //   423: ldc_w 366
    //   426: new 271	java/lang/StringBuilder
    //   429: dup
    //   430: ldc_w 480
    //   433: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   436: lload 5
    //   438: invokevirtual 483	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: ldc_w 485
    //   444: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: lload_0
    //   448: invokestatic 489	com/tencent/mm/ae/d:Fw	(J)Ljava/lang/String;
    //   451: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: ldc_w 491
    //   457: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload 10
    //   462: invokevirtual 428	com/tencent/mm/plugin/finder/loader/aa:aBv	()Ljava/lang/String;
    //   465: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: bipush 32
    //   470: invokevirtual 494	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   473: ldc_w 496
    //   476: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: iload_3
    //   480: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: ldc_w 498
    //   486: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload 7
    //   491: invokevirtual 501	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   494: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 380	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: ldc_w 410
    //   503: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   506: aload_2
    //   507: athrow
    //   508: astore_2
    //   509: goto -103 -> 406
    //   512: astore_2
    //   513: iload 8
    //   515: istore 7
    //   517: goto -111 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	paramLong	long
    //   0	520	2	paramcsg	csg
    //   43	437	3	i	int
    //   12	392	4	j	int
    //   9	428	5	l	long
    //   15	501	7	bool1	boolean
    //   49	465	8	bool2	boolean
    //   36	253	9	localObject1	Object
    //   25	436	10	localaa	aa
    //   66	93	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	44	402	finally
    //   44	51	508	finally
    //   62	68	512	finally
    //   82	113	512	finally
    //   113	143	512	finally
    //   143	150	512	finally
    //   155	185	512	finally
  }
  
  public static boolean d(av paramav)
  {
    AppMethodBeat.i(289300);
    p.k(paramav, "cache");
    paramav.field_updateTime = cm.bfE();
    ??? = wUY;
    Object localObject2 = paramav.field_mediaId;
    p.j(localObject2, "cache.field_mediaId");
    p.k(localObject2, "mediaId");
    localObject2 = "select *, rowid from FinderMediaCacheInfoV2  where mediaId = '" + (String)localObject2 + "' ";
    ??? = ((t)???).db.rawQuery((String)localObject2, null);
    p.j(???, "cursor");
    boolean bool1;
    boolean bool2;
    if (((Cursor)???).getCount() > 0)
    {
      bool1 = true;
      ((Cursor)???).close();
      if (!bool1) {
        break label259;
      }
      bool2 = wUY.c(paramav);
      ??? = wUY;
      localObject2 = paramav.field_mediaId;
      p.j(localObject2, "cache.field_mediaId");
      localObject2 = ((t)???).aEJ((String)localObject2);
    }
    for (;;)
    {
      Object localObject3;
      synchronized (AnL)
      {
        localObject3 = (Map)AnL;
        String str = paramav.field_mediaId;
        p.j(str, "cache.field_mediaId");
        ((Map)localObject3).put(str, localObject2);
        localObject2 = x.aazN;
        Log.i("Finder.MediaCacheLogic", "replaced[" + bool2 + "] isExist=" + bool1 + ' ' + paramav);
        AppMethodBeat.o(289300);
        return bool2;
        bool1 = false;
      }
      synchronized (AnL)
      {
        label259:
        localObject2 = (Map)AnL;
        localObject3 = paramav.field_mediaId;
        p.j(localObject3, "cache.field_mediaId");
        ((Map)localObject2).put(localObject3, paramav);
        localObject2 = x.aazN;
        bool2 = wUY.b(paramav);
      }
    }
  }
  
  public static boolean ee(String paramString, int paramInt)
  {
    AppMethodBeat.i(289304);
    p.k(paramString, "mediaId");
    t localt = wUY;
    av localav = bC(paramString, false);
    Object localObject;
    if (!localav.field_moovReady)
    {
      localObject = c.zKl;
      if (c.a.a(localav).zKm) {
        localav.field_moovReady = true;
      }
      Log.i("Finder.MediaCacheLogic", "update moov ready " + localav.field_mediaId + " moovReady:" + localav.field_moovReady + " audio:" + localav.field_audioBitrate + " video:" + localav.field_videoBitrate + " frameRate:" + localav.field_frameRate);
    }
    localav.field_cacheSize = 0L;
    localav.field_totalSize = 0L;
    localav.field_state = paramInt;
    if (paramInt >= 2)
    {
      localObject = (CharSequence)localav.field_fileFormat;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label329;
      }
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)localav.field_originMediaId;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label334;
        }
      }
    }
    label329:
    label334:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = localav.field_originMediaId;
        p.j(localObject, "this.field_originMediaId");
        String str = localav.field_fileFormat;
        p.j(str, "this.field_fileFormat");
        hm((String)localObject, str);
      }
      if (Log.getLogLevel() <= 1) {
        Log.d("Finder.MediaCacheLogic", "[updateProgress] mediaId=" + paramString + " cacheSize=0 totalSize=0 state=" + paramInt + " moovReady=" + localav.field_moovReady);
      }
      boolean bool = localt.c(localav);
      AppMethodBeat.o(289304);
      return bool;
      i = 0;
      break;
    }
  }
  
  private static com.tencent.mm.plugin.finder.preload.model.a getPreloadModel()
  {
    AppMethodBeat.i(289312);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)zKf.getValue();
    AppMethodBeat.o(289312);
    return locala;
  }
  
  public static av hl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(289302);
    p.k(paramString1, "mediaId");
    p.k(paramString2, "fileFormat");
    paramString1 = bC(paramString1, false);
    paramString1.field_moovReady = true;
    if ((p.h(paramString1.field_fileFormat, paramString2) ^ true))
    {
      paramString1.field_fileFormat = paramString2;
      if (TextUtils.isEmpty((CharSequence)paramString2)) {
        com.tencent.mm.plugin.report.service.h.IzE.p(1505L, 251L, 1L);
      }
    }
    AppMethodBeat.o(289302);
    return paramString1;
  }
  
  private static void hm(String paramString1, String arg1)
  {
    AppMethodBeat.i(289310);
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId is Empty.");
      AppMethodBeat.o(289310);
      return;
    }
    Object localObject2 = (Iterable)aEV(paramString1);
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label157:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      Object localObject4 = (av)localObject3;
      if (p.h(((av)localObject4).field_originMediaId, paramString1))
      {
        localObject4 = ((av)localObject4).field_fileFormat;
        p.j(localObject4, "it.field_fileFormat");
        if (???.compareTo((String)localObject4) >= 0) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label157;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (av)((Iterator)localObject1).next();
        if (!wUY.delete(((av)localObject2).systemRowid)) {}
      }
      else
      {
        synchronized (AnL)
        {
          AnL.remove(((av)localObject2).field_mediaId);
          Log.i("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId=" + paramString1 + " fileFormat=" + ((av)localObject2).field_fileFormat + " systemRowid" + ((av)localObject2).systemRowid);
        }
      }
    }
  }
  
  public final aa b(long paramLong, csg paramcsg)
  {
    AppMethodBeat.i(289311);
    p.k(paramcsg, "media");
    if (AnM)
    {
      paramcsg = c(paramLong, paramcsg);
      AppMethodBeat.o(289311);
      return paramcsg;
    }
    Object localObject2 = paramcsg.mediaId;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = ((Iterable)j.a((Iterable)aEV((String)localObject1), (Comparator)new a())).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!((av)localObject1).dKO());
    for (;;)
    {
      localObject1 = (av)localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.preload.model.a.zKX;
      paramcsg = new aa(paramcsg, a.a.aDI(((av)localObject1).field_fileFormat), ((av)localObject1).field_reqFormat, null, 8);
      AppMethodBeat.o(289311);
      return paramcsg;
      localObject1 = null;
    }
    paramcsg = getPreloadModel().a(paramLong, paramcsg);
    AppMethodBeat.o(289311);
    return paramcsg;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(286053);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((av)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((av)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(286053);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final b AnO;
    
    static
    {
      AppMethodBeat.i(288858);
      AnO = new b();
      AppMethodBeat.o(288858);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(288624);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((av)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((av)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(288624);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.d
 * JD-Core Version:    0.7.0.1
 */
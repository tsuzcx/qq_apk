package com.tencent.mm.plugin.finder.storage.logic;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.b;
import com.tencent.mm.plugin.finder.preload.model.a.a;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
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
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMediaCacheLogic;", "", "()V", "TAG", "", "THREAD_TAG", "isOpenMultiBitRateDownload", "", "isOptFindBestVideo", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "memoryCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "checkFileFormat", "", "mediaId", "fileFormat", "deleteAll", "deleteBelowFileFormat", "originalMediaId", "findBestVideoToPlay", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "query", "isCheckFileExit", "queryByOriginalMediaId", "", "quickFindBestVideoToPlay", "replace", "cache", "store", "url", "codingFormat", "", "cacheSize", "totalSize", "state", "duration", "urlToken", "decodeKey", "syncMemoryCacheToDB", "updateMoovReady", "updateMoovReadyMemory", "updatePlayed", "hasPlayed", "updateProgress", "updateProgressMemory", "plugin-finder_release"})
public final class d
{
  public static final w toc;
  private static final f uTP;
  private static final boolean uUD;
  private static final HashMap<String, at> vGP;
  private static final boolean vGQ;
  public static final d vGR;
  
  static
  {
    AppMethodBeat.i(167109);
    vGR = new d();
    toc = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaCacheStorage();
    vGP = new HashMap(100);
    c localc = c.vCb;
    uUD = c.dsh();
    localc = c.vCb;
    if (((Number)c.dvP().value()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      vGQ = bool;
      uTP = kotlin.g.ah((kotlin.g.a.a)b.vGS);
      AppMethodBeat.o(167109);
      return;
    }
  }
  
  public static at a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(252075);
    p.h(paramString, "mediaId");
    paramString = bv(paramString, false);
    paramString.field_cacheSize = paramLong1;
    paramString.field_totalSize = paramLong2;
    paramString.field_state = paramInt;
    if (!paramString.field_moovReady)
    {
      MediaPreloadCore.a locala = MediaPreloadCore.uTV;
      if (MediaPreloadCore.a.a(paramString).uTW) {
        paramString.field_moovReady = true;
      }
    }
    AppMethodBeat.o(252075);
    return paramString;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(252082);
    p.h(paramString1, "mediaId");
    p.h(paramString2, "originalMediaId");
    p.h(paramString3, "url");
    p.h(paramString4, "fileFormat");
    at localat = new at();
    localat.field_mediaId = paramString1;
    localat.field_originMediaId = paramString2;
    localat.field_url = paramString3;
    localat.field_reqFormat = paramInt1;
    localat.field_cacheSize = paramLong1;
    localat.field_totalSize = paramLong2;
    localat.field_fileFormat = paramString4;
    localat.field_state = paramInt2;
    localat.field_duration = paramInt3;
    localat.field_urlToken = paramString5;
    localat.field_decodeKey = paramString6;
    boolean bool = d(localat);
    AppMethodBeat.o(252082);
    return bool;
  }
  
  public static void avG(String paramString)
  {
    AppMethodBeat.i(252077);
    p.h(paramString, "mediaId");
    com.tencent.mm.ac.d.c("FinderMediaCacheUpdateThread", (kotlin.g.a.a)new d(paramString));
    AppMethodBeat.o(252077);
  }
  
  public static List<at> avI(String paramString)
  {
    AppMethodBeat.i(252081);
    p.h(paramString, "originalMediaId");
    Object localObject = toc;
    p.h(paramString, "originMediaId");
    LinkedList localLinkedList = new LinkedList();
    paramString = "select *, rowid from FinderMediaCacheInfoV2  where originMediaId = '" + paramString + "' ";
    paramString = ((w)localObject).db.rawQuery(paramString, null);
    if (paramString != null)
    {
      paramString.moveToFirst();
      while (!paramString.isAfterLast())
      {
        localObject = new at();
        ((at)localObject).convertFrom(paramString);
        localLinkedList.add(localObject);
        paramString.moveToNext();
      }
      paramString.close();
    }
    paramString = (List)localLinkedList;
    AppMethodBeat.o(252081);
    return paramString;
  }
  
  public static boolean bnU()
  {
    AppMethodBeat.i(252083);
    int i = toc.db.delete(toc.getTableName(), "rowid >= ?", new String[] { "0" });
    Log.i("Finder.MediaCacheLogic", "[deleteAll] ret=".concat(String.valueOf(i)));
    synchronized (vGP)
    {
      vGP.clear();
      x localx = x.SXb;
      if (i >= 0)
      {
        AppMethodBeat.o(252083);
        return true;
      }
    }
    AppMethodBeat.o(252083);
    return false;
  }
  
  public static at bv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(252079);
    p.h(paramString, "mediaId");
    if (((CharSequence)paramString).length() == 0) {}
    at localat;
    for (int i = 1; i != 0; i = 0)
    {
      localat = new at();
      localat.field_mediaId = paramString;
      AppMethodBeat.o(252079);
      return localat;
    }
    synchronized (vGP)
    {
      localat = (at)vGP.get(paramString);
      if (localat == null) {
        localat = toc.avt(paramString);
      }
    }
    for (;;)
    {
      synchronized (vGP)
      {
        ((Map)vGP).put(paramString, localat);
        x localx = x.SXb;
        p.g(localat, "synchronized(memoryCache…        dbCache\n        }");
        if (paramBoolean)
        {
          if (((CharSequence)localat.getFilePath()).length() <= 0) {
            break label258;
          }
          i = 1;
          if ((i != 0) && (!com.tencent.mm.vfs.s.YS(localat.getFilePath())))
          {
            localat.reset();
            localat.field_state = -2;
            d(localat);
            Log.i("Finder.MediaCacheLogic", "[query] mediaId=" + paramString + " not found file. state=" + localat.field_state + " filePath=" + localat.getFilePath());
          }
        }
        AppMethodBeat.o(252079);
        return localat;
        paramString = finally;
        AppMethodBeat.o(252079);
        throw paramString;
      }
      label258:
      i = 0;
    }
  }
  
  /* Error */
  private static com.tencent.mm.plugin.finder.loader.s c(long paramLong, cjl paramcjl)
  {
    // Byte code:
    //   0: ldc_w 409
    //   3: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 415	java/lang/System:currentTimeMillis	()J
    //   9: lstore 5
    //   11: iconst_0
    //   12: istore 4
    //   14: iconst_0
    //   15: istore 7
    //   17: invokestatic 418	com/tencent/mm/plugin/finder/storage/logic/d:getPreloadModel	()Lcom/tencent/mm/plugin/finder/preload/model/a;
    //   20: lload_0
    //   21: aload_2
    //   22: invokevirtual 422	com/tencent/mm/plugin/finder/preload/model/a:a	(JLcom/tencent/mm/protocal/protobuf/cjl;)Lcom/tencent/mm/plugin/finder/loader/s;
    //   25: astore 10
    //   27: aload 10
    //   29: invokevirtual 427	com/tencent/mm/plugin/finder/loader/s:auA	()Ljava/lang/String;
    //   32: iconst_0
    //   33: invokestatic 177	com/tencent/mm/plugin/finder/storage/logic/d:bv	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/finder/model/at;
    //   36: astore 9
    //   38: aload 9
    //   40: invokevirtual 430	com/tencent/mm/plugin/finder/model/at:dkP	()I
    //   43: istore_3
    //   44: aload 9
    //   46: invokevirtual 433	com/tencent/mm/plugin/finder/model/at:dkO	()Z
    //   49: istore 8
    //   51: iload 8
    //   53: ifne +246 -> 299
    //   56: iload_3
    //   57: bipush 30
    //   59: if_icmpge +240 -> 299
    //   62: aload_2
    //   63: getfield 437	com/tencent/mm/protocal/protobuf/cjl:mediaId	Ljava/lang/String;
    //   66: astore 11
    //   68: aload 11
    //   70: astore 9
    //   72: aload 11
    //   74: ifnonnull +8 -> 82
    //   77: ldc_w 438
    //   80: astore 9
    //   82: aload 9
    //   84: invokestatic 440	com/tencent/mm/plugin/finder/storage/logic/d:avI	(Ljava/lang/String;)Ljava/util/List;
    //   87: checkcast 442	java/lang/Iterable
    //   90: new 10	com/tencent/mm/plugin/finder/storage/logic/d$c
    //   93: dup
    //   94: invokespecial 443	com/tencent/mm/plugin/finder/storage/logic/d$c:<init>	()V
    //   97: checkcast 445	java/util/Comparator
    //   100: invokestatic 450	kotlin/a/j:a	(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;
    //   103: checkcast 442	java/lang/Iterable
    //   106: invokeinterface 454 1 0
    //   111: astore 11
    //   113: aload 11
    //   115: invokeinterface 459 1 0
    //   120: ifeq +167 -> 287
    //   123: aload 11
    //   125: invokeinterface 462 1 0
    //   130: astore 9
    //   132: aload 9
    //   134: checkcast 179	com/tencent/mm/plugin/finder/model/at
    //   137: invokevirtual 433	com/tencent/mm/plugin/finder/model/at:dkO	()Z
    //   140: ifeq -27 -> 113
    //   143: aload 9
    //   145: checkcast 179	com/tencent/mm/plugin/finder/model/at
    //   148: astore 9
    //   150: aload 9
    //   152: ifnull +141 -> 293
    //   155: getstatic 466	com/tencent/mm/plugin/finder/preload/model/a:uUH	Lcom/tencent/mm/plugin/finder/preload/model/a$a;
    //   158: astore 11
    //   160: new 424	com/tencent/mm/plugin/finder/loader/s
    //   163: dup
    //   164: aload_2
    //   165: aload 9
    //   167: getfield 231	com/tencent/mm/plugin/finder/model/at:field_fileFormat	Ljava/lang/String;
    //   170: invokestatic 472	com/tencent/mm/plugin/finder/preload/model/a$a:aus	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/storage/x;
    //   173: aload 9
    //   175: getfield 228	com/tencent/mm/plugin/finder/model/at:field_reqFormat	I
    //   178: aconst_null
    //   179: bipush 8
    //   181: invokespecial 475	com/tencent/mm/plugin/finder/loader/s:<init>	(Lcom/tencent/mm/protocal/protobuf/cjl;Lcom/tencent/mm/plugin/finder/storage/x;ILjava/lang/String;I)V
    //   184: astore_2
    //   185: invokestatic 415	java/lang/System:currentTimeMillis	()J
    //   188: lload 5
    //   190: lsub
    //   191: lstore 5
    //   193: lload 5
    //   195: ldc2_w 476
    //   198: lcmp
    //   199: ifle +80 -> 279
    //   202: ldc_w 338
    //   205: new 270	java/lang/StringBuilder
    //   208: dup
    //   209: ldc_w 479
    //   212: invokespecial 273	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: lload 5
    //   217: invokevirtual 482	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   220: ldc_w 484
    //   223: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: lload_0
    //   227: invokestatic 488	com/tencent/mm/ac/d:zs	(J)Ljava/lang/String;
    //   230: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 490
    //   236: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 10
    //   241: invokevirtual 427	com/tencent/mm/plugin/finder/loader/s:auA	()Ljava/lang/String;
    //   244: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: bipush 32
    //   249: invokevirtual 493	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   252: ldc_w 495
    //   255: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: iload_3
    //   259: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: ldc_w 497
    //   265: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: iload 8
    //   270: invokevirtual 500	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   273: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: ldc_w 409
    //   282: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: aload_2
    //   286: areturn
    //   287: aconst_null
    //   288: astore 9
    //   290: goto -147 -> 143
    //   293: aload 10
    //   295: astore_2
    //   296: goto -111 -> 185
    //   299: invokestatic 415	java/lang/System:currentTimeMillis	()J
    //   302: lload 5
    //   304: lsub
    //   305: lstore 5
    //   307: lload 5
    //   309: ldc2_w 476
    //   312: lcmp
    //   313: ifle +80 -> 393
    //   316: ldc_w 338
    //   319: new 270	java/lang/StringBuilder
    //   322: dup
    //   323: ldc_w 479
    //   326: invokespecial 273	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   329: lload 5
    //   331: invokevirtual 482	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   334: ldc_w 484
    //   337: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: lload_0
    //   341: invokestatic 488	com/tencent/mm/ac/d:zs	(J)Ljava/lang/String;
    //   344: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 490
    //   350: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload 10
    //   355: invokevirtual 427	com/tencent/mm/plugin/finder/loader/s:auA	()Ljava/lang/String;
    //   358: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: bipush 32
    //   363: invokevirtual 493	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   366: ldc_w 495
    //   369: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: iload_3
    //   373: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 497
    //   379: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: iload 8
    //   384: invokevirtual 500	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: ldc_w 409
    //   396: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: aload 10
    //   401: areturn
    //   402: astore_2
    //   403: iload 4
    //   405: istore_3
    //   406: invokestatic 415	java/lang/System:currentTimeMillis	()J
    //   409: lload 5
    //   411: lsub
    //   412: lstore 5
    //   414: lload 5
    //   416: ldc2_w 476
    //   419: lcmp
    //   420: ifle +80 -> 500
    //   423: ldc_w 338
    //   426: new 270	java/lang/StringBuilder
    //   429: dup
    //   430: ldc_w 479
    //   433: invokespecial 273	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   436: lload 5
    //   438: invokevirtual 482	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: ldc_w 484
    //   444: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: lload_0
    //   448: invokestatic 488	com/tencent/mm/ac/d:zs	(J)Ljava/lang/String;
    //   451: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: ldc_w 490
    //   457: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload 10
    //   462: invokevirtual 427	com/tencent/mm/plugin/finder/loader/s:auA	()Ljava/lang/String;
    //   465: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: bipush 32
    //   470: invokevirtual 493	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   473: ldc_w 495
    //   476: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: iload_3
    //   480: invokevirtual 405	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: ldc_w 497
    //   486: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload 7
    //   491: invokevirtual 500	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   494: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 353	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: ldc_w 409
    //   503: invokestatic 161	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	520	2	paramcjl	cjl
    //   43	437	3	i	int
    //   12	392	4	j	int
    //   9	428	5	l	long
    //   15	501	7	bool1	boolean
    //   49	465	8	bool2	boolean
    //   36	253	9	localObject1	Object
    //   25	436	10	locals	com.tencent.mm.plugin.finder.loader.s
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
  
  public static boolean d(at paramat)
  {
    AppMethodBeat.i(252074);
    p.h(paramat, "cache");
    paramat.field_updateTime = cl.aWA();
    ??? = toc;
    Object localObject2 = paramat.field_mediaId;
    p.g(localObject2, "cache.field_mediaId");
    p.h(localObject2, "mediaId");
    localObject2 = "select *, rowid from FinderMediaCacheInfoV2  where mediaId = '" + (String)localObject2 + "' ";
    ??? = ((w)???).db.rawQuery((String)localObject2, null);
    p.g(???, "cursor");
    boolean bool1;
    boolean bool2;
    if (((Cursor)???).getCount() > 0)
    {
      bool1 = true;
      ((Cursor)???).close();
      if (!bool1) {
        break label259;
      }
      bool2 = toc.c(paramat);
      ??? = toc;
      localObject2 = paramat.field_mediaId;
      p.g(localObject2, "cache.field_mediaId");
      localObject2 = ((w)???).avt((String)localObject2);
    }
    for (;;)
    {
      Object localObject3;
      synchronized (vGP)
      {
        localObject3 = (Map)vGP;
        String str = paramat.field_mediaId;
        p.g(str, "cache.field_mediaId");
        ((Map)localObject3).put(str, localObject2);
        localObject2 = x.SXb;
        Log.i("Finder.MediaCacheLogic", "replaced[" + bool2 + "] isExist=" + bool1 + ' ' + paramat);
        AppMethodBeat.o(252074);
        return bool2;
        bool1 = false;
      }
      synchronized (vGP)
      {
        label259:
        localObject2 = (Map)vGP;
        localObject3 = paramat.field_mediaId;
        p.g(localObject3, "cache.field_mediaId");
        ((Map)localObject2).put(localObject3, paramat);
        localObject2 = x.SXb;
        bool2 = toc.b(paramat);
      }
    }
  }
  
  public static boolean dH(String paramString, int paramInt)
  {
    AppMethodBeat.i(252078);
    p.h(paramString, "mediaId");
    w localw = toc;
    at localat = bv(paramString, false);
    Object localObject;
    if (!localat.field_moovReady)
    {
      localObject = MediaPreloadCore.uTV;
      if (MediaPreloadCore.a.a(localat).uTW) {
        localat.field_moovReady = true;
      }
      Log.i("Finder.MediaCacheLogic", "update moov ready " + localat.field_mediaId + " moovReady:" + localat.field_moovReady + " audio:" + localat.field_audioBitrate + " video:" + localat.field_videoBitrate + " frameRate:" + localat.field_frameRate);
    }
    localat.field_cacheSize = 0L;
    localat.field_totalSize = 0L;
    localat.field_state = paramInt;
    if (paramInt >= 2)
    {
      localObject = (CharSequence)localat.field_fileFormat;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label329;
      }
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)localat.field_originMediaId;
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
        localObject = localat.field_originMediaId;
        p.g(localObject, "this.field_originMediaId");
        String str = localat.field_fileFormat;
        p.g(str, "this.field_fileFormat");
        gV((String)localObject, str);
      }
      if (Log.getLogLevel() <= 1) {
        Log.d("Finder.MediaCacheLogic", "[updateProgress] mediaId=" + paramString + " cacheSize=0 totalSize=0 state=" + paramInt + " moovReady=" + localat.field_moovReady);
      }
      boolean bool = localw.c(localat);
      AppMethodBeat.o(252078);
      return bool;
      i = 0;
      break;
    }
  }
  
  public static at gU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(252076);
    p.h(paramString1, "mediaId");
    p.h(paramString2, "fileFormat");
    paramString1 = bv(paramString1, false);
    paramString1.field_moovReady = true;
    if ((p.j(paramString1.field_fileFormat, paramString2) ^ true))
    {
      paramString1.field_fileFormat = paramString2;
      if (TextUtils.isEmpty((CharSequence)paramString2)) {
        h.CyF.n(1505L, 251L, 1L);
      }
    }
    AppMethodBeat.o(252076);
    return paramString1;
  }
  
  private static void gV(String paramString1, String arg1)
  {
    AppMethodBeat.i(252084);
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId is Empty.");
      AppMethodBeat.o(252084);
      return;
    }
    Object localObject2 = (Iterable)avI(paramString1);
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label157:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      Object localObject4 = (at)localObject3;
      if (p.j(((at)localObject4).field_originMediaId, paramString1))
      {
        localObject4 = ((at)localObject4).field_fileFormat;
        p.g(localObject4, "it.field_fileFormat");
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
        localObject2 = (at)((Iterator)localObject1).next();
        if (!toc.delete(((at)localObject2).systemRowid)) {}
      }
      else
      {
        synchronized (vGP)
        {
          vGP.remove(((at)localObject2).field_mediaId);
          Log.i("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId=" + paramString1 + " fileFormat=" + ((at)localObject2).field_fileFormat + " systemRowid" + ((at)localObject2).systemRowid);
        }
      }
    }
  }
  
  private static com.tencent.mm.plugin.finder.preload.model.a getPreloadModel()
  {
    AppMethodBeat.i(252086);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)uTP.getValue();
    AppMethodBeat.o(252086);
    return locala;
  }
  
  public final com.tencent.mm.plugin.finder.loader.s b(long paramLong, cjl paramcjl)
  {
    AppMethodBeat.i(252085);
    p.h(paramcjl, "media");
    if (vGQ)
    {
      paramcjl = c(paramLong, paramcjl);
      AppMethodBeat.o(252085);
      return paramcjl;
    }
    Object localObject2 = paramcjl.mediaId;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = ((Iterable)j.a((Iterable)avI((String)localObject1), (Comparator)new a())).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!((at)localObject1).dkO());
    for (;;)
    {
      localObject1 = (at)localObject1;
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.finder.preload.model.a.uUH;
      paramcjl = new com.tencent.mm.plugin.finder.loader.s(paramcjl, a.a.aus(((at)localObject1).field_fileFormat), ((at)localObject1).field_reqFormat, null, 8);
      AppMethodBeat.o(252085);
      return paramcjl;
      localObject1 = null;
    }
    paramcjl = getPreloadModel().a(paramLong, paramcjl);
    AppMethodBeat.o(252085);
    return paramcjl;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(252069);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((at)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((at)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(252069);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final b vGS;
    
    static
    {
      AppMethodBeat.i(252071);
      vGS = new b();
      AppMethodBeat.o(252071);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(252072);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((at)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((at)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(252072);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.d
 * JD-Core Version:    0.7.0.1
 */
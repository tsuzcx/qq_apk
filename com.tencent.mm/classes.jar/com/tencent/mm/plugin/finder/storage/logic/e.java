package com.tencent.mm.plugin.finder.storage.logic;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.preload.f;
import com.tencent.mm.plugin.finder.preload.f.a;
import com.tencent.mm.plugin.finder.preload.f.b;
import com.tencent.mm.plugin.finder.preload.model.b.a;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMediaCacheLogic;", "", "()V", "TAG", "", "THREAD_TAG", "isOpenMultiBitRateDownload", "", "isOptFindBestVideo", "mediaCacheStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaCacheStorage;", "memoryCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "checkFileFormat", "", "mediaId", "fileFormat", "createTPMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "_finderMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "finderFeedId", "", "findBest", "deleteAll", "deleteBelowFileFormat", "originalMediaId", "findBestVideoToPlay", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedId", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "query", "isCheckFileExit", "queryByOriginalMediaId", "", "quickFindBestVideoToPlay", "replace", "cache", "store", "url", "codingFormat", "", "cacheSize", "totalSize", "state", "duration", "urlToken", "decodeKey", "syncMemoryCacheToDB", "updateMoovReady", "updateMoovReadyMemory", "updatePlayed", "hasPlayed", "updateProgress", "updateProgressMemory", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final com.tencent.mm.plugin.finder.storage.u ArE;
  private static final j EUE;
  private static final boolean EVA;
  public static final e FNF;
  private static final HashMap<String, az> FNG;
  private static final boolean FNH;
  
  static
  {
    AppMethodBeat.i(167109);
    FNF = new e();
    ArE = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaCacheStorage();
    FNG = new HashMap(100);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    EVA = com.tencent.mm.plugin.finder.storage.d.eRL();
    locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVd().bmg()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      FNH = bool;
      EUE = k.cm((kotlin.g.a.a)b.FNI);
      AppMethodBeat.o(167109);
      return;
    }
  }
  
  public static az a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(339500);
    s.u(paramString, "mediaId");
    paramString = bS(paramString, false);
    paramString.field_cacheSize = paramLong1;
    paramString.field_totalSize = paramLong2;
    paramString.field_state = paramInt;
    if (!paramString.field_moovReady)
    {
      f.a locala = f.EUC;
      if (f.a.a(paramString).EUK) {
        paramString.field_moovReady = true;
      }
    }
    AppMethodBeat.o(339500);
    return paramString;
  }
  
  public static com.tencent.mm.plugin.thumbplayer.a.b a(FinderMedia paramFinderMedia, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(339595);
    if (paramFinderMedia != null)
    {
      Object localObject2 = i.c(paramFinderMedia);
      if (paramBoolean) {}
      for (Object localObject1 = FNF.b(paramLong, (dji)localObject2);; localObject1 = getPreloadModel().a(paramLong, (dji)localObject2))
      {
        String str3 = ((com.tencent.mm.plugin.finder.loader.v)localObject1).aUt();
        String str4 = ((com.tencent.mm.plugin.finder.loader.v)localObject1).getPath();
        String str5 = ((com.tencent.mm.plugin.finder.loader.v)localObject1).getUrl();
        String str1 = ((com.tencent.mm.plugin.finder.loader.v)localObject1).eCf();
        String str2 = ((com.tencent.mm.plugin.finder.loader.v)localObject1).eCe();
        paramLong = paramFinderMedia.videoDuration;
        localObject1 = ((com.tencent.mm.plugin.finder.loader.v)localObject1).ExF.detail;
        Object localObject3 = new n((dji)localObject2, com.tencent.mm.plugin.finder.storage.v.FKZ, null, null, 12);
        localObject2 = ((n)localObject3).getPath();
        String str6 = ((n)localObject3).eCi();
        localObject3 = ((n)localObject3).eCg();
        paramFinderMedia = new com.tencent.mm.plugin.thumbplayer.a.b(str3, str4, str5, (int)paramFinderMedia.width, (int)paramFinderMedia.height);
        paramFinderMedia.decodeKey = str2;
        paramFinderMedia.msf = str1;
        paramFinderMedia.vYw = paramLong;
        paramFinderMedia.hVy = ((String)localObject1);
        paramFinderMedia.thumbPath = ((String)localObject2);
        paramFinderMedia.thumbUrl = str6;
        paramFinderMedia.msh = ((String)localObject3);
        AppMethodBeat.o(339595);
        return paramFinderMedia;
      }
    }
    AppMethodBeat.o(339595);
    return null;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, long paramLong1, long paramLong2, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(339566);
    s.u(paramString1, "mediaId");
    s.u(paramString2, "originalMediaId");
    s.u(paramString3, "url");
    s.u(paramString4, "fileFormat");
    az localaz = bS(paramString1, false);
    localaz.field_mediaId = paramString1;
    localaz.field_originMediaId = paramString2;
    localaz.field_url = paramString3;
    localaz.field_reqFormat = paramInt1;
    localaz.field_cacheSize = paramLong1;
    localaz.field_totalSize = paramLong2;
    localaz.field_fileFormat = paramString4;
    localaz.field_state = paramInt2;
    localaz.field_duration = paramInt3;
    localaz.field_urlToken = paramString5;
    localaz.field_decodeKey = paramString6;
    paramString1 = ah.aiuX;
    boolean bool = d(localaz);
    AppMethodBeat.o(339566);
    return bool;
  }
  
  public static void aAM(String paramString)
  {
    AppMethodBeat.i(339514);
    s.u(paramString, "mediaId");
    com.tencent.mm.ae.d.e("FinderMediaCacheUpdateThread", (kotlin.g.a.a)new d(paramString));
    AppMethodBeat.o(339514);
  }
  
  public static List<az> aAO(String paramString)
  {
    AppMethodBeat.i(339557);
    s.u(paramString, "originalMediaId");
    Object localObject = ArE;
    s.u(paramString, "originMediaId");
    LinkedList localLinkedList = new LinkedList();
    paramString = "select *, rowid from FinderMediaCacheInfoV2  where originMediaId = '" + paramString + "' ";
    paramString = ((com.tencent.mm.plugin.finder.storage.u)localObject).db.rawQuery(paramString, null);
    if (paramString != null)
    {
      paramString.moveToFirst();
      while (!paramString.isAfterLast())
      {
        localObject = new az();
        ((az)localObject).convertFrom(paramString);
        localLinkedList.add(localObject);
        paramString.moveToNext();
      }
      paramString.close();
    }
    paramString = (List)localLinkedList;
    AppMethodBeat.o(339557);
    return paramString;
  }
  
  public static az bS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(339539);
    s.u(paramString, "mediaId");
    if (((CharSequence)paramString).length() == 0) {}
    az localaz;
    for (int i = 1; i != 0; i = 0)
    {
      localaz = new az();
      localaz.field_mediaId = paramString;
      AppMethodBeat.o(339539);
      return localaz;
    }
    synchronized (FNG)
    {
      localaz = (az)FNG.get(paramString);
      Log.i("Finder.MediaCacheLogic", "[query] mediaId=" + paramString + " hit memory cache:" + localaz + ", memoryCache size:" + FNG.size());
      if (localaz == null)
      {
        localaz = ArE.aAC(paramString);
        Log.i("Finder.MediaCacheLogic", "[query] mediaId=" + paramString + " hit db cache:" + localaz + ", memoryCache size:" + FNG.size());
      }
    }
    for (;;)
    {
      synchronized (FNG)
      {
        ((Map)FNG).put(paramString, localaz);
        ah localah = ah.aiuX;
        if (paramBoolean)
        {
          if (((CharSequence)localaz.getFilePath()).length() <= 0) {
            break label347;
          }
          i = 1;
          if ((i != 0) && (!y.ZC(localaz.getFilePath())))
          {
            localaz.reset();
            localaz.field_state = -2;
            d(localaz);
            Log.i("Finder.MediaCacheLogic", "[query] mediaId=" + paramString + " not found file. cache:" + localaz + " filePath=" + localaz.getFilePath());
          }
        }
        AppMethodBeat.o(339539);
        return localaz;
        paramString = finally;
        AppMethodBeat.o(339539);
        throw paramString;
      }
      continue;
      label347:
      i = 0;
    }
  }
  
  public static boolean bwy()
  {
    AppMethodBeat.i(339573);
    int i = ArE.db.delete(ArE.getTableName(), "rowid >= ?", new String[] { "0" });
    Log.i("Finder.MediaCacheLogic", s.X("[deleteAll] ret=", Integer.valueOf(i)));
    synchronized (FNG)
    {
      FNG.clear();
      ah localah = ah.aiuX;
      if (i >= 0)
      {
        AppMethodBeat.o(339573);
        return true;
      }
    }
    AppMethodBeat.o(339573);
    return false;
  }
  
  /* Error */
  private static com.tencent.mm.plugin.finder.loader.v c(long paramLong, dji paramdji)
  {
    // Byte code:
    //   0: ldc_w 524
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   9: lstore 5
    //   11: iconst_0
    //   12: istore 4
    //   14: iconst_0
    //   15: istore 7
    //   17: invokestatic 314	com/tencent/mm/plugin/finder/storage/logic/e:getPreloadModel	()Lcom/tencent/mm/plugin/finder/preload/model/b;
    //   20: lload_0
    //   21: aload_2
    //   22: invokevirtual 318	com/tencent/mm/plugin/finder/preload/model/b:a	(JLcom/tencent/mm/protocal/protobuf/dji;)Lcom/tencent/mm/plugin/finder/loader/v;
    //   25: astore 10
    //   27: aload 10
    //   29: invokevirtual 237	com/tencent/mm/plugin/finder/loader/v:aUt	()Ljava/lang/String;
    //   32: iconst_0
    //   33: invokestatic 187	com/tencent/mm/plugin/finder/storage/logic/e:bS	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/finder/model/az;
    //   36: astore 9
    //   38: aload 9
    //   40: invokevirtual 533	com/tencent/mm/plugin/finder/model/az:eDy	()I
    //   43: istore_3
    //   44: aload 9
    //   46: invokevirtual 536	com/tencent/mm/plugin/finder/model/az:eDx	()Z
    //   49: istore 8
    //   51: iload 8
    //   53: ifne +368 -> 421
    //   56: iload_3
    //   57: bipush 30
    //   59: if_icmpge +362 -> 421
    //   62: aload_2
    //   63: getfield 540	com/tencent/mm/protocal/protobuf/dji:mediaId	Ljava/lang/String;
    //   66: astore 11
    //   68: aload 11
    //   70: astore 9
    //   72: aload 11
    //   74: ifnonnull +8 -> 82
    //   77: ldc_w 541
    //   80: astore 9
    //   82: aload 9
    //   84: invokestatic 543	com/tencent/mm/plugin/finder/storage/logic/e:aAO	(Ljava/lang/String;)Ljava/util/List;
    //   87: checkcast 545	java/lang/Iterable
    //   90: new 10	com/tencent/mm/plugin/finder/storage/logic/e$c
    //   93: dup
    //   94: invokespecial 546	com/tencent/mm/plugin/finder/storage/logic/e$c:<init>	()V
    //   97: checkcast 548	java/util/Comparator
    //   100: invokestatic 553	kotlin/a/p:a	(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;
    //   103: checkcast 545	java/lang/Iterable
    //   106: invokeinterface 557 1 0
    //   111: astore 11
    //   113: aload 11
    //   115: invokeinterface 562 1 0
    //   120: ifeq +146 -> 266
    //   123: aload 11
    //   125: invokeinterface 565 1 0
    //   130: astore 9
    //   132: aload 9
    //   134: checkcast 189	com/tencent/mm/plugin/finder/model/az
    //   137: invokevirtual 536	com/tencent/mm/plugin/finder/model/az:eDx	()Z
    //   140: ifeq -27 -> 113
    //   143: aload 9
    //   145: checkcast 189	com/tencent/mm/plugin/finder/model/az
    //   148: astore 9
    //   150: aload 9
    //   152: ifnonnull +120 -> 272
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_2
    //   158: astore 9
    //   160: aload_2
    //   161: ifnonnull +7 -> 168
    //   164: aload 10
    //   166: astore 9
    //   168: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   171: lload 5
    //   173: lsub
    //   174: lstore 5
    //   176: lload 5
    //   178: ldc2_w 566
    //   181: lcmp
    //   182: ifle +75 -> 257
    //   185: ldc_w 446
    //   188: new 383	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 569
    //   195: invokespecial 386	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: lload 5
    //   200: invokevirtual 572	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   203: ldc_w 574
    //   206: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: lload_0
    //   210: invokestatic 578	com/tencent/mm/ae/d:hF	(J)Ljava/lang/String;
    //   213: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 580
    //   219: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 10
    //   224: invokevirtual 237	com/tencent/mm/plugin/finder/loader/v:aUt	()Ljava/lang/String;
    //   227: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc_w 582
    //   233: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: iload_3
    //   237: invokevirtual 461	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: ldc_w 584
    //   243: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: iload 8
    //   248: invokevirtual 587	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   251: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 466	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: ldc_w 524
    //   260: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload 9
    //   265: areturn
    //   266: aconst_null
    //   267: astore 9
    //   269: goto -126 -> 143
    //   272: ldc_w 446
    //   275: ldc_w 589
    //   278: aload 9
    //   280: invokestatic 520	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   283: invokestatic 466	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: getstatic 593	com/tencent/mm/plugin/finder/preload/model/b:EVg	Lcom/tencent/mm/plugin/finder/preload/model/b$a;
    //   289: astore 11
    //   291: new 233	com/tencent/mm/plugin/finder/loader/v
    //   294: dup
    //   295: aload_2
    //   296: aload 9
    //   298: getfield 338	com/tencent/mm/plugin/finder/model/az:field_fileFormat	Ljava/lang/String;
    //   301: invokestatic 599	com/tencent/mm/plugin/finder/preload/model/b$a:azm	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/storage/v;
    //   304: aload 9
    //   306: getfield 335	com/tencent/mm/plugin/finder/model/az:field_reqFormat	I
    //   309: aconst_null
    //   310: bipush 8
    //   312: invokespecial 602	com/tencent/mm/plugin/finder/loader/v:<init>	(Lcom/tencent/mm/protocal/protobuf/dji;Lcom/tencent/mm/plugin/finder/storage/v;ILjava/lang/String;I)V
    //   315: astore_2
    //   316: goto -159 -> 157
    //   319: astore_2
    //   320: iload 8
    //   322: istore 7
    //   324: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   327: lload 5
    //   329: lsub
    //   330: lstore 5
    //   332: lload 5
    //   334: ldc2_w 566
    //   337: lcmp
    //   338: ifle +75 -> 413
    //   341: ldc_w 446
    //   344: new 383	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 569
    //   351: invokespecial 386	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: lload 5
    //   356: invokevirtual 572	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   359: ldc_w 574
    //   362: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: lload_0
    //   366: invokestatic 578	com/tencent/mm/ae/d:hF	(J)Ljava/lang/String;
    //   369: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc_w 580
    //   375: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload 10
    //   380: invokevirtual 237	com/tencent/mm/plugin/finder/loader/v:aUt	()Ljava/lang/String;
    //   383: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: ldc_w 582
    //   389: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: iload_3
    //   393: invokevirtual 461	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: ldc_w 584
    //   399: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: iload 7
    //   404: invokevirtual 587	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   407: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 466	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: ldc_w 524
    //   416: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: aload_2
    //   420: athrow
    //   421: invokestatic 530	java/lang/System:currentTimeMillis	()J
    //   424: lload 5
    //   426: lsub
    //   427: lstore 5
    //   429: lload 5
    //   431: ldc2_w 566
    //   434: lcmp
    //   435: ifle +75 -> 510
    //   438: ldc_w 446
    //   441: new 383	java/lang/StringBuilder
    //   444: dup
    //   445: ldc_w 569
    //   448: invokespecial 386	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   451: lload 5
    //   453: invokevirtual 572	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   456: ldc_w 574
    //   459: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: lload_0
    //   463: invokestatic 578	com/tencent/mm/ae/d:hF	(J)Ljava/lang/String;
    //   466: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc_w 580
    //   472: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload 10
    //   477: invokevirtual 237	com/tencent/mm/plugin/finder/loader/v:aUt	()Ljava/lang/String;
    //   480: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: ldc_w 582
    //   486: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload_3
    //   490: invokevirtual 461	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   493: ldc_w 584
    //   496: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: iload 8
    //   501: invokevirtual 587	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   504: invokevirtual 395	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 466	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: ldc_w 524
    //   513: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   516: aload 10
    //   518: areturn
    //   519: astore_2
    //   520: iload 4
    //   522: istore_3
    //   523: goto -199 -> 324
    //   526: astore_2
    //   527: goto -203 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	paramLong	long
    //   0	530	2	paramdji	dji
    //   43	480	3	i	int
    //   12	509	4	j	int
    //   9	443	5	l	long
    //   15	388	7	bool1	boolean
    //   49	451	8	bool2	boolean
    //   36	269	9	localObject1	Object
    //   25	492	10	localv	com.tencent.mm.plugin.finder.loader.v
    //   66	224	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   62	68	319	finally
    //   82	113	319	finally
    //   113	143	319	finally
    //   143	150	319	finally
    //   272	316	319	finally
    //   27	44	519	finally
    //   44	51	526	finally
  }
  
  public static boolean d(az paramaz)
  {
    AppMethodBeat.i(339494);
    s.u(paramaz, "cache");
    paramaz.field_updateTime = cn.bDw();
    ??? = ArE;
    Object localObject2 = paramaz.field_mediaId;
    s.s(localObject2, "cache.field_mediaId");
    s.u(localObject2, "mediaId");
    localObject2 = "select *, rowid from FinderMediaCacheInfoV2  where mediaId = '" + (String)localObject2 + "' ";
    ??? = ((com.tencent.mm.plugin.finder.storage.u)???).db.rawQuery((String)localObject2, null);
    boolean bool1;
    boolean bool2;
    if (((Cursor)???).getCount() > 0)
    {
      bool1 = true;
      ((Cursor)???).close();
      if (!bool1) {
        break label284;
      }
      Log.i("Finder.MediaCacheLogic", s.X("replace before cache:", paramaz));
      bool2 = ArE.c(paramaz);
      ??? = ArE;
      localObject2 = paramaz.field_mediaId;
      s.s(localObject2, "cache.field_mediaId");
      localObject2 = ((com.tencent.mm.plugin.finder.storage.u)???).aAC((String)localObject2);
      Log.i("Finder.MediaCacheLogic", s.X("replace after newCache:", localObject2));
    }
    for (;;)
    {
      Object localObject3;
      synchronized (FNG)
      {
        localObject3 = (Map)FNG;
        String str = paramaz.field_mediaId;
        s.s(str, "cache.field_mediaId");
        ((Map)localObject3).put(str, localObject2);
        localObject2 = ah.aiuX;
        Log.i("Finder.MediaCacheLogic", "replaced[" + bool2 + "] isExist=" + bool1 + ' ' + paramaz + ' ');
        AppMethodBeat.o(339494);
        return bool2;
        bool1 = false;
      }
      synchronized (FNG)
      {
        label284:
        localObject2 = (Map)FNG;
        localObject3 = paramaz.field_mediaId;
        s.s(localObject3, "cache.field_mediaId");
        ((Map)localObject2).put(localObject3, paramaz);
        localObject2 = ah.aiuX;
        bool2 = ArE.b(paramaz);
      }
    }
  }
  
  public static boolean eP(String paramString, int paramInt)
  {
    AppMethodBeat.i(339528);
    s.u(paramString, "mediaId");
    com.tencent.mm.plugin.finder.storage.u localu = ArE;
    az localaz = bS(paramString, false);
    Object localObject;
    if (!localaz.field_moovReady)
    {
      localObject = f.EUC;
      if (f.a.a(localaz).EUK) {
        localaz.field_moovReady = true;
      }
      Log.i("Finder.MediaCacheLogic", "update moov ready " + localaz.field_mediaId + " moovReady:" + localaz.field_moovReady + " audio:" + localaz.field_audioBitrate + " video:" + localaz.field_videoBitrate + " frameRate:" + localaz.field_frameRate);
    }
    localaz.field_cacheSize = 0L;
    localaz.field_totalSize = 0L;
    localaz.field_state = paramInt;
    if (paramInt >= 2)
    {
      localObject = (CharSequence)localaz.field_fileFormat;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label333;
      }
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)localaz.field_originMediaId;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label338;
        }
      }
    }
    label333:
    label338:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = localaz.field_originMediaId;
        s.s(localObject, "this.field_originMediaId");
        String str = localaz.field_fileFormat;
        s.s(str, "this.field_fileFormat");
        ih((String)localObject, str);
      }
      if (Log.getLogLevel() <= 1) {
        Log.d("Finder.MediaCacheLogic", "[updateProgress] mediaId=" + paramString + " cacheSize=0 totalSize=0 state=" + paramInt + " moovReady=" + localaz.field_moovReady);
      }
      paramString = ah.aiuX;
      boolean bool = localu.c(localaz);
      AppMethodBeat.o(339528);
      return bool;
      i = 0;
      break;
    }
  }
  
  private static com.tencent.mm.plugin.finder.preload.model.b getPreloadModel()
  {
    AppMethodBeat.i(339601);
    com.tencent.mm.plugin.finder.preload.model.b localb = (com.tencent.mm.plugin.finder.preload.model.b)EUE.getValue();
    AppMethodBeat.o(339601);
    return localb;
  }
  
  public static az ig(String paramString1, String paramString2)
  {
    AppMethodBeat.i(339509);
    s.u(paramString1, "mediaId");
    s.u(paramString2, "fileFormat");
    paramString1 = bS(paramString1, false);
    paramString1.field_moovReady = true;
    if (!s.p(paramString1.field_fileFormat, paramString2))
    {
      paramString1.field_fileFormat = paramString2;
      if (TextUtils.isEmpty((CharSequence)paramString2)) {
        com.tencent.mm.plugin.report.service.h.OAn.p(1505L, 251L, 1L);
      }
    }
    AppMethodBeat.o(339509);
    return paramString1;
  }
  
  private static void ih(String paramString1, String arg1)
  {
    AppMethodBeat.i(339582);
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId is Empty.");
      AppMethodBeat.o(339582);
      return;
    }
    Object localObject2 = (Iterable)aAO(paramString1);
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label157:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      Object localObject4 = (az)localObject3;
      if (s.p(((az)localObject4).field_originMediaId, paramString1))
      {
        localObject4 = ((az)localObject4).field_fileFormat;
        s.s(localObject4, "it.field_fileFormat");
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
        localObject2 = (az)((Iterator)localObject1).next();
        if (!ArE.delete(((az)localObject2).systemRowid)) {}
      }
      else
      {
        synchronized (FNG)
        {
          FNG.remove(((az)localObject2).field_mediaId);
          Log.i("Finder.MediaCacheLogic", "[deleteBelowFileFormat] originalMediaId=" + paramString1 + " fileFormat=" + ((az)localObject2).field_fileFormat + " systemRowid" + ((az)localObject2).systemRowid);
        }
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.loader.v b(long paramLong, dji paramdji)
  {
    AppMethodBeat.i(339645);
    s.u(paramdji, "media");
    if (FNH)
    {
      paramdji = c(paramLong, paramdji);
      AppMethodBeat.o(339645);
      return paramdji;
    }
    Object localObject2 = paramdji.mediaId;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = ((Iterable)p.a((Iterable)aAO((String)localObject1), (Comparator)new a())).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (((az)localObject1).eDx())
      {
        localObject1 = (az)localObject1;
        if (localObject1 != null) {
          break label157;
        }
      }
    }
    for (localObject1 = null;; localObject1 = new com.tencent.mm.plugin.finder.loader.v(paramdji, b.a.azm(((az)localObject1).field_fileFormat), ((az)localObject1).field_reqFormat, null, 8))
    {
      if (localObject1 != null) {
        break label205;
      }
      paramdji = getPreloadModel().a(paramLong, paramdji);
      AppMethodBeat.o(339645);
      return paramdji;
      localObject1 = null;
      break;
      label157:
      Log.i("Finder.MediaCacheLogic", s.X("findBestVideoToPlay hit PreLoadCompleted cache:", localObject1));
      localObject2 = com.tencent.mm.plugin.finder.preload.model.b.EVg;
    }
    label205:
    AppMethodBeat.o(339645);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class a<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(339460);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((az)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((az)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(339460);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.b>
  {
    public static final b FNI;
    
    static
    {
      AppMethodBeat.i(339464);
      FNI = new b();
      AppMethodBeat.o(339464);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class c<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(339467);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((az)paramT1).field_fileFormat.hashCode()), (Comparable)Integer.valueOf(((az)paramT2).field_fileFormat.hashCode()));
      AppMethodBeat.o(339467);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    d(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.e
 * JD-Core Version:    0.7.0.1
 */
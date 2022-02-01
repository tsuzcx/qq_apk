package com.tencent.mm.plugin.finder.storage.logic;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.u;
import d.g.b.w;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic$Companion;", "", "()V", "CARE_MEDIA_TYPE", "", "", "getCARE_MEDIA_TYPE", "()Ljava/util/List;", "CARE_MEDIA_TYPE$delegate", "Lkotlin/Lazy;", "TAG", "", "deleteFeed", "", "objectId", "", "deleteFeedByLocalId", "localId", "deleteGroupFeed", "", "getBySenderLocal", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "insertFeedList", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceType", "isFirstPage", "isNeedClear", "extraOp", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLocalSenderFeedExists", "replaceSenderFeed", "feedObject", "transformFinderMediaToLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaType", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "transformFinderObjectToTimeLineData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObject", "updateFeedCommentCount", "count", "feed", "plugin-finder_release"})
public final class b$a
{
  static
  {
    AppMethodBeat.i(167091);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "CARE_MEDIA_TYPE", "getCARE_MEDIA_TYPE()Ljava/util/List;")) };
    AppMethodBeat.o(167091);
  }
  
  public static bqs a(int paramInt, FinderMedia paramFinderMedia)
  {
    AppMethodBeat.i(167101);
    d.g.b.k.h(paramFinderMedia, "feedMedia");
    bqs localbqs = new bqs();
    localbqs.url = paramFinderMedia.url;
    localbqs.mediaType = paramInt;
    localbqs.thumbUrl = paramFinderMedia.thumbUrl;
    localbqs.videoDuration = paramFinderMedia.videoDuration;
    localbqs.mediaId = ah.dg(paramFinderMedia.url);
    localbqs.width = paramFinderMedia.width;
    localbqs.height = paramFinderMedia.height;
    localbqs.md5sum = paramFinderMedia.md5sum;
    localbqs.fileSize = paramFinderMedia.fileSize;
    localbqs.bitrate = paramFinderMedia.bitrate;
    localbqs.spec = paramFinderMedia.spec;
    localbqs.coverUrl = paramFinderMedia.coverUrl;
    localbqs.decodeKey = paramFinderMedia.decodeKey;
    localbqs.cover_url_token = paramFinderMedia.cover_url_token;
    localbqs.thumb_url_token = paramFinderMedia.thumb_url_token;
    localbqs.url_token = paramFinderMedia.url_token;
    AppMethodBeat.o(167101);
    return localbqs;
  }
  
  public static LinkedList<FinderItem> aee(String paramString)
  {
    AppMethodBeat.i(167095);
    d.g.b.k.h(paramString, "username");
    paramString = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().aee(paramString);
    AppMethodBeat.o(167095);
    return paramString;
  }
  
  public static List<Integer> cBp()
  {
    AppMethodBeat.i(167092);
    Object localObject = b.cBo();
    a locala = b.rFl;
    localObject = (List)((d.f)localObject).getValue();
    AppMethodBeat.o(167092);
    return localObject;
  }
  
  /* Error */
  public static void dB(List<Long> paramList)
  {
    // Byte code:
    //   0: ldc_w 463
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 464
    //   10: invokestatic 111	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   16: lstore 4
    //   18: ldc_w 426
    //   21: invokestatic 432	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   24: checkcast 426	com/tencent/mm/plugin/finder/PluginFinder
    //   27: invokevirtual 436	com/tencent/mm/plugin/finder/PluginFinder:getFeedStorage	()Lcom/tencent/mm/plugin/finder/storage/f;
    //   30: astore 11
    //   32: aload_0
    //   33: ldc_w 471
    //   36: invokestatic 111	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   39: invokestatic 476	android/os/SystemClock:uptimeMillis	()J
    //   42: lstore 6
    //   44: getstatic 405	com/tencent/mm/plugin/finder/storage/data/i:rEV	Lcom/tencent/mm/plugin/finder/storage/data/i$a;
    //   47: astore 10
    //   49: aload_0
    //   50: ldc_w 478
    //   53: invokestatic 111	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   56: aload_0
    //   57: checkcast 225	java/lang/Iterable
    //   60: invokestatic 482	d/a/j:k	(Ljava/lang/Iterable;)Ljava/util/HashSet;
    //   63: astore 12
    //   65: invokestatic 486	com/tencent/mm/plugin/finder/storage/data/i:cBi	()[Ljava/lang/Integer;
    //   68: astore 13
    //   70: aload 13
    //   72: arraylength
    //   73: istore_2
    //   74: iconst_0
    //   75: istore_1
    //   76: iload_1
    //   77: iload_2
    //   78: if_icmpge +226 -> 304
    //   81: aload 13
    //   83: iload_1
    //   84: aaload
    //   85: checkcast 488	java/lang/Number
    //   88: invokevirtual 491	java/lang/Number:intValue	()I
    //   91: istore_3
    //   92: getstatic 405	com/tencent/mm/plugin/finder/storage/data/i:rEV	Lcom/tencent/mm/plugin/finder/storage/data/i$a;
    //   95: astore 10
    //   97: iload_3
    //   98: invokestatic 495	com/tencent/mm/plugin/finder/storage/data/i$a:Ek	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   101: pop
    //   102: new 497	d/g/b/v$a
    //   105: dup
    //   106: invokespecial 498	d/g/b/v$a:<init>	()V
    //   109: astore 10
    //   111: aload 10
    //   113: iconst_0
    //   114: putfield 502	d/g/b/v$a:KUL	Z
    //   117: invokestatic 506	com/tencent/mm/plugin/finder/storage/data/i:cBh	()Lcom/tencent/mm/plugin/finder/storage/data/j;
    //   120: iload_3
    //   121: invokevirtual 511	com/tencent/mm/plugin/finder/storage/data/j:Em	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   124: getfield 517	com/tencent/mm/plugin/finder/storage/data/a:rEA	Lcom/tencent/mm/protocal/protobuf/ajy;
    //   127: getfield 522	com/tencent/mm/protocal/protobuf/ajy:uEi	Ljava/util/LinkedList;
    //   130: astore 14
    //   132: aload 14
    //   134: ifnull +54 -> 188
    //   137: aload 14
    //   139: checkcast 392	java/util/List
    //   142: iconst_0
    //   143: invokestatic 526	d/a/j:C	(Ljava/util/List;I)Ljava/lang/Object;
    //   146: checkcast 528	com/tencent/mm/protocal/protobuf/ake
    //   149: astore 14
    //   151: aload 14
    //   153: ifnull +35 -> 188
    //   156: aload 14
    //   158: getfield 531	com/tencent/mm/protocal/protobuf/ake:fBS	Ljava/util/LinkedList;
    //   161: astore 14
    //   163: aload 14
    //   165: ifnull +23 -> 188
    //   168: aload 14
    //   170: new 533	com/tencent/mm/plugin/finder/storage/data/i$a$b
    //   173: dup
    //   174: aload 10
    //   176: aload 12
    //   178: invokespecial 536	com/tencent/mm/plugin/finder/storage/data/i$a$b:<init>	(Ld/g/b/v$a;Ljava/util/HashSet;)V
    //   181: checkcast 538	d/g/a/b
    //   184: invokestatic 543	com/tencent/mm/ac/c:a	(Ljava/util/LinkedList;Ld/g/a/b;)Z
    //   187: pop
    //   188: aload 10
    //   190: getfield 502	d/g/b/v$a:KUL	Z
    //   193: ifeq +98 -> 291
    //   196: getstatic 548	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
    //   199: ifeq +77 -> 276
    //   202: new 333	java/lang/StringBuilder
    //   205: dup
    //   206: ldc_w 550
    //   209: invokespecial 338	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: astore 14
    //   214: invokestatic 506	com/tencent/mm/plugin/finder/storage/data/i:cBh	()Lcom/tencent/mm/plugin/finder/storage/data/j;
    //   217: iload_3
    //   218: invokevirtual 511	com/tencent/mm/plugin/finder/storage/data/j:Em	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   221: getfield 517	com/tencent/mm/plugin/finder/storage/data/a:rEA	Lcom/tencent/mm/protocal/protobuf/ajy;
    //   224: getfield 522	com/tencent/mm/protocal/protobuf/ajy:uEi	Ljava/util/LinkedList;
    //   227: astore 10
    //   229: aload 10
    //   231: ifnull +67 -> 298
    //   234: aload 10
    //   236: checkcast 392	java/util/List
    //   239: iconst_0
    //   240: invokestatic 526	d/a/j:C	(Ljava/util/List;I)Ljava/lang/Object;
    //   243: checkcast 528	com/tencent/mm/protocal/protobuf/ake
    //   246: astore 10
    //   248: aload 10
    //   250: ifnull +48 -> 298
    //   253: aload 10
    //   255: getfield 531	com/tencent/mm/protocal/protobuf/ake:fBS	Ljava/util/LinkedList;
    //   258: astore 10
    //   260: ldc_w 552
    //   263: aload 14
    //   265: aload 10
    //   267: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 372	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: getstatic 405	com/tencent/mm/plugin/finder/storage/data/i:rEV	Lcom/tencent/mm/plugin/finder/storage/data/i$a;
    //   279: astore 10
    //   281: invokestatic 506	com/tencent/mm/plugin/finder/storage/data/i:cBh	()Lcom/tencent/mm/plugin/finder/storage/data/j;
    //   284: iload_3
    //   285: invokevirtual 511	com/tencent/mm/plugin/finder/storage/data/j:Em	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   288: invokestatic 558	com/tencent/mm/plugin/finder/storage/data/i$a:a	(Lcom/tencent/mm/plugin/finder/storage/data/a;)V
    //   291: iload_1
    //   292: iconst_1
    //   293: iadd
    //   294: istore_1
    //   295: goto -219 -> 76
    //   298: aconst_null
    //   299: astore 10
    //   301: goto -41 -> 260
    //   304: new 560	android/util/LongSparseArray
    //   307: dup
    //   308: invokespecial 561	android/util/LongSparseArray:<init>	()V
    //   311: astore 13
    //   313: aload 11
    //   315: getfield 565	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/e/e;
    //   318: ldc_w 567
    //   321: aconst_null
    //   322: iconst_2
    //   323: invokeinterface 572 4 0
    //   328: checkcast 574	java/io/Closeable
    //   331: astore 12
    //   333: aconst_null
    //   334: astore 10
    //   336: aload 12
    //   338: checkcast 576	android/database/Cursor
    //   341: astore 14
    //   343: aload 14
    //   345: invokeinterface 579 1 0
    //   350: ifeq +73 -> 423
    //   353: aload 14
    //   355: ldc_w 581
    //   358: invokestatic 323	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   361: aload 14
    //   363: invokeinterface 584 1 0
    //   368: ifne +55 -> 423
    //   371: aload 14
    //   373: iconst_0
    //   374: invokeinterface 588 2 0
    //   379: lstore 8
    //   381: aload 13
    //   383: lload 8
    //   385: lload 8
    //   387: invokestatic 594	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   390: invokevirtual 598	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   393: goto -40 -> 353
    //   396: astore 10
    //   398: ldc_w 463
    //   401: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: aload 10
    //   406: athrow
    //   407: astore_0
    //   408: aload 12
    //   410: aload 10
    //   412: invokestatic 603	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   415: ldc_w 463
    //   418: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: aload_0
    //   422: athrow
    //   423: getstatic 609	d/y:KTp	Ld/y;
    //   426: astore 14
    //   428: aload 12
    //   430: aconst_null
    //   431: invokestatic 603	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   434: aload_0
    //   435: checkcast 225	java/lang/Iterable
    //   438: invokeinterface 238 1 0
    //   443: astore 10
    //   445: aload 10
    //   447: invokeinterface 244 1 0
    //   452: ifeq +71 -> 523
    //   455: aload 10
    //   457: invokeinterface 248 1 0
    //   462: checkcast 488	java/lang/Number
    //   465: invokevirtual 612	java/lang/Number:longValue	()J
    //   468: lstore 8
    //   470: getstatic 277	com/tencent/mm/plugin/finder/storage/data/d:rEF	Lcom/tencent/mm/plugin/finder/storage/data/d$a;
    //   473: astore 12
    //   475: lload 8
    //   477: invokestatic 616	com/tencent/mm/plugin/finder/storage/data/d$a:rC	(J)Z
    //   480: pop
    //   481: aload 13
    //   483: lload 8
    //   485: invokevirtual 620	android/util/LongSparseArray:indexOfKey	(J)I
    //   488: iflt -43 -> 445
    //   491: aload 11
    //   493: getfield 565	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/e/e;
    //   496: ldc_w 622
    //   499: ldc_w 624
    //   502: iconst_1
    //   503: anewarray 626	java/lang/String
    //   506: dup
    //   507: iconst_0
    //   508: lload 8
    //   510: invokestatic 629	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   513: aastore
    //   514: invokeinterface 633 4 0
    //   519: pop
    //   520: goto -75 -> 445
    //   523: getstatic 548	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
    //   526: ifeq +19 -> 545
    //   529: ldc_w 635
    //   532: ldc_w 637
    //   535: aload_0
    //   536: invokestatic 640	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   539: invokevirtual 643	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   542: invokestatic 645	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: ldc_w 635
    //   548: new 333	java/lang/StringBuilder
    //   551: dup
    //   552: ldc_w 647
    //   555: invokespecial 338	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   558: aload_0
    //   559: invokeinterface 413 1 0
    //   564: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: ldc_w 649
    //   570: invokevirtual 345	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokestatic 476	android/os/SystemClock:uptimeMillis	()J
    //   576: lload 6
    //   578: lsub
    //   579: invokevirtual 354	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   582: ldc_w 651
    //   585: invokevirtual 345	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokestatic 372	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: invokestatic 331	com/tencent/mm/plugin/finder/storage/logic/b:access$getTAG$cp	()Ljava/lang/String;
    //   597: new 333	java/lang/StringBuilder
    //   600: dup
    //   601: ldc_w 653
    //   604: invokespecial 338	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   607: aload_0
    //   608: invokeinterface 413 1 0
    //   613: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   616: ldc_w 655
    //   619: invokevirtual 345	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   625: lload 4
    //   627: lsub
    //   628: invokevirtual 354	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   631: ldc_w 651
    //   634: invokevirtual 345	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokestatic 372	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   643: ldc_w 463
    //   646: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   649: return
    //   650: astore_0
    //   651: goto -243 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	654	0	paramList	List<Long>
    //   75	220	1	i	int
    //   73	6	2	j	int
    //   91	194	3	k	int
    //   16	610	4	l1	long
    //   42	535	6	l2	long
    //   379	130	8	l3	long
    //   47	288	10	localObject1	Object
    //   396	15	10	localThrowable	java.lang.Throwable
    //   443	13	10	localIterator	java.util.Iterator
    //   30	462	11	localf	com.tencent.mm.plugin.finder.storage.f
    //   63	411	12	localObject2	Object
    //   68	414	13	localObject3	Object
    //   130	297	14	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   336	353	396	java/lang/Throwable
    //   353	393	396	java/lang/Throwable
    //   423	428	396	java/lang/Throwable
    //   398	407	407	finally
    //   336	353	650	finally
    //   353	393	650	finally
    //   423	428	650	finally
  }
  
  public static boolean h(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167100);
    d.g.b.k.h(paramFinderItem, "feedObject");
    long l2 = paramFinderItem.field_id;
    long l3 = paramFinderItem.getLocalId();
    com.tencent.mm.plugin.finder.storage.f localf = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage();
    long l1 = -1L;
    boolean bool;
    if (vd(l3)) {
      bool = localf.a(l3, paramFinderItem);
    }
    for (;;)
    {
      if (bool) {
        l1 = paramFinderItem.getLocalId();
      }
      ac.d(b.access$getTAG$cp(), "replace feedSucc %s, rowId %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
      AppMethodBeat.o(167100);
      return bool;
      d.g.b.k.h(paramFinderItem, "finder");
      if (l2 == 0L) {
        ac.m("Finder.FinderFeedStorage", "update svrId " + l2 + ' ' + paramFinderItem.info() + ' ' + bs.eWi(), new Object[0]);
      }
      ContentValues localContentValues = paramFinderItem.convertTo();
      localContentValues.remove("rowid");
      if (localf.db.update("FinderFeedItem", localContentValues, "id=?", new String[] { String.valueOf(l2) }) > 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static BaseFinderFeed i(FinderItem paramFinderItem)
  {
    Object localObject = null;
    AppMethodBeat.i(167102);
    d.g.b.k.h(paramFinderItem, "finderObject");
    BaseFinderFeed localBaseFinderFeed;
    int i;
    label122:
    label126:
    com.tencent.mm.plugin.finder.api.f localf;
    switch (paramFinderItem.getMediaType())
    {
    default: 
      localBaseFinderFeed = (BaseFinderFeed)new p(paramFinderItem);
      paramFinderItem = paramFinderItem.getFeedObject().contact;
      d.g.b.k.g(paramFinderItem, "finderObject.feedObject.contact");
      d.g.b.k.h(paramFinderItem, "$this$toLocal");
      if (!bs.isNullOrNil(paramFinderItem.username))
      {
        i = 1;
        if (i == 0) {
          break label436;
        }
        if (paramFinderItem == null) {
          break label441;
        }
        localf = new com.tencent.mm.plugin.finder.api.f();
        String str = paramFinderItem.username;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localf.setUsername((String)localObject);
        str = paramFinderItem.headUrl;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localf.adl((String)localObject);
        str = paramFinderItem.nickname;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localf.qj((String)localObject);
        localf.field_version = paramFinderItem.seq;
        str = paramFinderItem.signature;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localf.field_signature = ((String)localObject);
        localf.field_follow_Flag = paramFinderItem.followFlag;
        str = paramFinderItem.nickname;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localf.field_pyInitial = com.tencent.mm.platformtools.f.Fw((String)localObject);
        localf.field_followTime = paramFinderItem.followTime;
        str = paramFinderItem.coverImgUrl;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localf.field_coverImg = ((String)localObject);
        localf.field_spamStatus = paramFinderItem.spamStatus;
        localf.field_authInfo = paramFinderItem.authInfo;
      }
      break;
    }
    for (paramFinderItem = localf;; paramFinderItem = (FinderItem)localObject)
    {
      localBaseFinderFeed.contact = paramFinderItem;
      AppMethodBeat.o(167102);
      return localBaseFinderFeed;
      localBaseFinderFeed = (BaseFinderFeed)new m(paramFinderItem);
      break;
      localBaseFinderFeed = (BaseFinderFeed)new q(paramFinderItem);
      break;
      localBaseFinderFeed = (BaseFinderFeed)new s(paramFinderItem);
      break;
      localBaseFinderFeed = (BaseFinderFeed)new o(paramFinderItem);
      break;
      localBaseFinderFeed = (BaseFinderFeed)new p(paramFinderItem);
      break;
      localBaseFinderFeed = (BaseFinderFeed)new r(paramFinderItem);
      break;
      i = 0;
      break label122;
      label436:
      paramFinderItem = null;
      break label126;
      label441:
      ac.e("Finder.FinderContactEx", "error FinderContact username is null " + bs.eWi());
    }
  }
  
  public static boolean vd(long paramLong)
  {
    AppMethodBeat.i(167096);
    if (((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().uO(paramLong) != null)
    {
      AppMethodBeat.o(167096);
      return true;
    }
    AppMethodBeat.o(167096);
    return false;
  }
  
  public static FinderItem ve(long paramLong)
  {
    AppMethodBeat.i(167097);
    ac.d(b.access$getTAG$cp(), "get feed local id %s", new Object[] { Long.valueOf(paramLong) });
    FinderItem localFinderItem = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().uO(paramLong);
    AppMethodBeat.o(167097);
    return localFinderItem;
  }
  
  public static boolean vf(long paramLong)
  {
    AppMethodBeat.i(167098);
    boolean bool = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().uP(paramLong);
    ac.i(b.access$getTAG$cp(), "delete feed " + paramLong + " success " + bool);
    AppMethodBeat.o(167098);
    return bool;
  }
  
  public static boolean vg(long paramLong)
  {
    AppMethodBeat.i(167099);
    boolean bool = com.tencent.mm.plugin.finder.storage.f.a(((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage(), paramLong);
    ac.i(b.access$getTAG$cp(), "delete feed localId " + paramLong + " success " + bool);
    AppMethodBeat.o(167099);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.b.a
 * JD-Core Version:    0.7.0.1
 */
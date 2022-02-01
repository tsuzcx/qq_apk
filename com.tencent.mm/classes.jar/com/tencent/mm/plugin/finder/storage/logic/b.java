package com.tencent.mm.plugin.finder.storage.logic;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.model.j;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "Finder.FinderFeedLogic";
  private static final d.f qKF;
  public static final a qKG;
  
  static
  {
    AppMethodBeat.i(167103);
    qKG = new a((byte)0);
    TAG = "Finder.FinderFeedLogic";
    qKF = d.g.E((a)b.qKH);
    AppMethodBeat.o(167103);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic$Companion;", "", "()V", "CARE_MEDIA_TYPE", "", "", "getCARE_MEDIA_TYPE", "()Ljava/util/List;", "CARE_MEDIA_TYPE$delegate", "Lkotlin/Lazy;", "TAG", "", "deleteFeed", "", "objectId", "", "deleteFeedByLocalId", "localId", "deleteGroupFeed", "", "getBySenderLocal", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "insertFeedList", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceType", "isFirstPage", "isNeedClear", "extraOp", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLocalSenderFeedExists", "replaceSenderFeed", "feedObject", "transformFinderMediaToLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaType", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "transformFinderObjectToTimeLineData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObject", "updateFeedCommentCount", "count", "feed", "plugin-finder_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(167091);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "CARE_MEDIA_TYPE", "getCARE_MEDIA_TYPE()Ljava/util/List;")) };
      AppMethodBeat.o(167091);
    }
    
    public static LinkedList<FinderItem> Zw(String paramString)
    {
      AppMethodBeat.i(167095);
      d.g.b.k.h(paramString, "username");
      paramString = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().Zw(paramString);
      AppMethodBeat.o(167095);
      return paramString;
    }
    
    public static bmd a(int paramInt, FinderMedia paramFinderMedia)
    {
      AppMethodBeat.i(167101);
      d.g.b.k.h(paramFinderMedia, "feedMedia");
      bmd localbmd = new bmd();
      localbmd.url = paramFinderMedia.url;
      localbmd.mediaType = paramInt;
      localbmd.thumbUrl = paramFinderMedia.thumbUrl;
      localbmd.videoDuration = paramFinderMedia.videoDuration;
      localbmd.mediaId = ai.du(paramFinderMedia.url);
      localbmd.width = paramFinderMedia.width;
      localbmd.height = paramFinderMedia.height;
      localbmd.md5sum = paramFinderMedia.md5sum;
      localbmd.fileSize = paramFinderMedia.fileSize;
      localbmd.bitrate = paramFinderMedia.bitrate;
      localbmd.spec = paramFinderMedia.spec;
      localbmd.coverUrl = paramFinderMedia.coverUrl;
      localbmd.decodeKey = paramFinderMedia.decodeKey;
      localbmd.cover_url_token = paramFinderMedia.cover_url_token;
      localbmd.thumb_url_token = paramFinderMedia.thumb_url_token;
      localbmd.url_token = paramFinderMedia.url_token;
      AppMethodBeat.o(167101);
      return localbmd;
    }
    
    public static List<Integer> cqK()
    {
      AppMethodBeat.i(167092);
      Object localObject = b.cqJ();
      a locala = b.qKG;
      localObject = (List)((d.f)localObject).getValue();
      AppMethodBeat.o(167092);
      return localObject;
    }
    
    /* Error */
    public static void dz(List<Long> paramList)
    {
      // Byte code:
      //   0: ldc_w 463
      //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: ldc_w 464
      //   10: invokestatic 112	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   13: invokestatic 469	java/lang/System:currentTimeMillis	()J
      //   16: lstore 4
      //   18: ldc 114
      //   20: invokestatic 120	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   23: checkcast 114	com/tencent/mm/plugin/finder/PluginFinder
      //   26: invokevirtual 124	com/tencent/mm/plugin/finder/PluginFinder:getFeedStorage	()Lcom/tencent/mm/plugin/finder/storage/e;
      //   29: astore 11
      //   31: aload_0
      //   32: ldc_w 471
      //   35: invokestatic 112	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   38: invokestatic 476	android/os/SystemClock:uptimeMillis	()J
      //   41: lstore 6
      //   43: getstatic 426	com/tencent/mm/plugin/finder/storage/data/f:qKv	Lcom/tencent/mm/plugin/finder/storage/data/f$a;
      //   46: astore 10
      //   48: aload_0
      //   49: ldc_w 478
      //   52: invokestatic 112	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   55: aload_0
      //   56: checkcast 246	java/lang/Iterable
      //   59: invokestatic 482	d/a/j:l	(Ljava/lang/Iterable;)Ljava/util/HashSet;
      //   62: astore 12
      //   64: invokestatic 486	com/tencent/mm/plugin/finder/storage/data/f:cqI	()[Ljava/lang/Integer;
      //   67: astore 13
      //   69: aload 13
      //   71: arraylength
      //   72: istore_2
      //   73: iconst_0
      //   74: istore_1
      //   75: iload_1
      //   76: iload_2
      //   77: if_icmpge +226 -> 303
      //   80: aload 13
      //   82: iload_1
      //   83: aaload
      //   84: checkcast 488	java/lang/Number
      //   87: invokevirtual 491	java/lang/Number:intValue	()I
      //   90: istore_3
      //   91: getstatic 426	com/tencent/mm/plugin/finder/storage/data/f:qKv	Lcom/tencent/mm/plugin/finder/storage/data/f$a;
      //   94: astore 10
      //   96: iload_3
      //   97: invokestatic 495	com/tencent/mm/plugin/finder/storage/data/f$a:ahz	(I)Lcom/tencent/mm/plugin/finder/storage/data/g;
      //   100: pop
      //   101: new 497	d/g/b/v$a
      //   104: dup
      //   105: invokespecial 498	d/g/b/v$a:<init>	()V
      //   108: astore 10
      //   110: aload 10
      //   112: iconst_0
      //   113: putfield 502	d/g/b/v$a:Jhs	Z
      //   116: invokestatic 506	com/tencent/mm/plugin/finder/storage/data/f:fVf	()Lcom/tencent/mm/plugin/finder/storage/data/j;
      //   119: iload_3
      //   120: invokevirtual 511	com/tencent/mm/plugin/finder/storage/data/j:ahA	(I)Lcom/tencent/mm/plugin/finder/storage/data/g;
      //   123: getfield 517	com/tencent/mm/plugin/finder/storage/data/g:KXo	Lcom/tencent/mm/protocal/protobuf/aim;
      //   126: getfield 522	com/tencent/mm/protocal/protobuf/aim:tvP	Ljava/util/LinkedList;
      //   129: astore 14
      //   131: aload 14
      //   133: ifnull +54 -> 187
      //   136: aload 14
      //   138: checkcast 413	java/util/List
      //   141: iconst_0
      //   142: invokestatic 526	d/a/j:C	(Ljava/util/List;I)Ljava/lang/Object;
      //   145: checkcast 528	com/tencent/mm/protocal/protobuf/ais
      //   148: astore 14
      //   150: aload 14
      //   152: ifnull +35 -> 187
      //   155: aload 14
      //   157: getfield 531	com/tencent/mm/protocal/protobuf/ais:fyl	Ljava/util/LinkedList;
      //   160: astore 14
      //   162: aload 14
      //   164: ifnull +23 -> 187
      //   167: aload 14
      //   169: new 533	com/tencent/mm/plugin/finder/storage/data/f$a$c
      //   172: dup
      //   173: aload 10
      //   175: aload 12
      //   177: invokespecial 536	com/tencent/mm/plugin/finder/storage/data/f$a$c:<init>	(Ld/g/b/v$a;Ljava/util/HashSet;)V
      //   180: checkcast 538	d/g/a/b
      //   183: invokestatic 543	com/tencent/mm/ad/c:a	(Ljava/util/LinkedList;Ld/g/a/b;)Z
      //   186: pop
      //   187: aload 10
      //   189: getfield 502	d/g/b/v$a:Jhs	Z
      //   192: ifeq +98 -> 290
      //   195: getstatic 548	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
      //   198: ifeq +77 -> 275
      //   201: new 354	java/lang/StringBuilder
      //   204: dup
      //   205: ldc_w 550
      //   208: invokespecial 359	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   211: astore 14
      //   213: invokestatic 506	com/tencent/mm/plugin/finder/storage/data/f:fVf	()Lcom/tencent/mm/plugin/finder/storage/data/j;
      //   216: iload_3
      //   217: invokevirtual 511	com/tencent/mm/plugin/finder/storage/data/j:ahA	(I)Lcom/tencent/mm/plugin/finder/storage/data/g;
      //   220: getfield 517	com/tencent/mm/plugin/finder/storage/data/g:KXo	Lcom/tencent/mm/protocal/protobuf/aim;
      //   223: getfield 522	com/tencent/mm/protocal/protobuf/aim:tvP	Ljava/util/LinkedList;
      //   226: astore 10
      //   228: aload 10
      //   230: ifnull +67 -> 297
      //   233: aload 10
      //   235: checkcast 413	java/util/List
      //   238: iconst_0
      //   239: invokestatic 526	d/a/j:C	(Ljava/util/List;I)Ljava/lang/Object;
      //   242: checkcast 528	com/tencent/mm/protocal/protobuf/ais
      //   245: astore 10
      //   247: aload 10
      //   249: ifnull +48 -> 297
      //   252: aload 10
      //   254: getfield 531	com/tencent/mm/protocal/protobuf/ais:fyl	Ljava/util/LinkedList;
      //   257: astore 10
      //   259: ldc_w 552
      //   262: aload 14
      //   264: aload 10
      //   266: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   269: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   272: invokestatic 393	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   275: getstatic 426	com/tencent/mm/plugin/finder/storage/data/f:qKv	Lcom/tencent/mm/plugin/finder/storage/data/f$a;
      //   278: astore 10
      //   280: invokestatic 506	com/tencent/mm/plugin/finder/storage/data/f:fVf	()Lcom/tencent/mm/plugin/finder/storage/data/j;
      //   283: iload_3
      //   284: invokevirtual 511	com/tencent/mm/plugin/finder/storage/data/j:ahA	(I)Lcom/tencent/mm/plugin/finder/storage/data/g;
      //   287: invokestatic 558	com/tencent/mm/plugin/finder/storage/data/f$a:a	(Lcom/tencent/mm/plugin/finder/storage/data/g;)V
      //   290: iload_1
      //   291: iconst_1
      //   292: iadd
      //   293: istore_1
      //   294: goto -219 -> 75
      //   297: aconst_null
      //   298: astore 10
      //   300: goto -41 -> 259
      //   303: new 560	android/util/LongSparseArray
      //   306: dup
      //   307: invokespecial 561	android/util/LongSparseArray:<init>	()V
      //   310: astore 13
      //   312: aload 11
      //   314: getfield 565	com/tencent/mm/plugin/finder/storage/e:db	Lcom/tencent/mm/sdk/e/e;
      //   317: ldc_w 567
      //   320: aconst_null
      //   321: iconst_2
      //   322: invokeinterface 572 4 0
      //   327: checkcast 574	java/io/Closeable
      //   330: astore 12
      //   332: aconst_null
      //   333: astore 10
      //   335: aload 12
      //   337: checkcast 576	android/database/Cursor
      //   340: astore 14
      //   342: aload 14
      //   344: invokeinterface 579 1 0
      //   349: ifeq +73 -> 422
      //   352: aload 14
      //   354: ldc_w 581
      //   357: invokestatic 344	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   360: aload 14
      //   362: invokeinterface 584 1 0
      //   367: ifne +55 -> 422
      //   370: aload 14
      //   372: iconst_0
      //   373: invokeinterface 588 2 0
      //   378: lstore 8
      //   380: aload 13
      //   382: lload 8
      //   384: lload 8
      //   386: invokestatic 594	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   389: invokevirtual 598	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
      //   392: goto -40 -> 352
      //   395: astore 10
      //   397: ldc_w 463
      //   400: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   403: aload 10
      //   405: athrow
      //   406: astore_0
      //   407: aload 12
      //   409: aload 10
      //   411: invokestatic 603	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   414: ldc_w 463
      //   417: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   420: aload_0
      //   421: athrow
      //   422: getstatic 609	d/y:JfV	Ld/y;
      //   425: astore 14
      //   427: aload 12
      //   429: aconst_null
      //   430: invokestatic 603	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   433: aload_0
      //   434: checkcast 246	java/lang/Iterable
      //   437: invokeinterface 259 1 0
      //   442: astore 10
      //   444: aload 10
      //   446: invokeinterface 265 1 0
      //   451: ifeq +71 -> 522
      //   454: aload 10
      //   456: invokeinterface 269 1 0
      //   461: checkcast 488	java/lang/Number
      //   464: invokevirtual 612	java/lang/Number:longValue	()J
      //   467: lstore 8
      //   469: getstatic 298	com/tencent/mm/plugin/finder/storage/data/b:qKl	Lcom/tencent/mm/plugin/finder/storage/data/b$a;
      //   472: astore 12
      //   474: lload 8
      //   476: invokestatic 616	com/tencent/mm/plugin/finder/storage/data/b$a:nQ	(J)Z
      //   479: pop
      //   480: aload 13
      //   482: lload 8
      //   484: invokevirtual 620	android/util/LongSparseArray:indexOfKey	(J)I
      //   487: iflt -43 -> 444
      //   490: aload 11
      //   492: getfield 565	com/tencent/mm/plugin/finder/storage/e:db	Lcom/tencent/mm/sdk/e/e;
      //   495: ldc_w 622
      //   498: ldc_w 624
      //   501: iconst_1
      //   502: anewarray 626	java/lang/String
      //   505: dup
      //   506: iconst_0
      //   507: lload 8
      //   509: invokestatic 629	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   512: aastore
      //   513: invokeinterface 633 4 0
      //   518: pop
      //   519: goto -75 -> 444
      //   522: getstatic 548	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
      //   525: ifeq +19 -> 544
      //   528: ldc_w 635
      //   531: ldc_w 637
      //   534: aload_0
      //   535: invokestatic 640	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   538: invokevirtual 643	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   541: invokestatic 646	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   544: ldc_w 635
      //   547: new 354	java/lang/StringBuilder
      //   550: dup
      //   551: ldc_w 648
      //   554: invokespecial 359	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   557: aload_0
      //   558: invokeinterface 434 1 0
      //   563: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   566: ldc_w 650
      //   569: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   572: invokestatic 476	android/os/SystemClock:uptimeMillis	()J
      //   575: lload 6
      //   577: lsub
      //   578: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   581: ldc_w 652
      //   584: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   587: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   590: invokestatic 393	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   593: invokestatic 352	com/tencent/mm/plugin/finder/storage/logic/b:access$getTAG$cp	()Ljava/lang/String;
      //   596: new 354	java/lang/StringBuilder
      //   599: dup
      //   600: ldc_w 654
      //   603: invokespecial 359	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   606: aload_0
      //   607: invokeinterface 434 1 0
      //   612: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   615: ldc_w 656
      //   618: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   621: invokestatic 469	java/lang/System:currentTimeMillis	()J
      //   624: lload 4
      //   626: lsub
      //   627: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   630: ldc_w 652
      //   633: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   636: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   639: invokestatic 393	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   642: ldc_w 463
      //   645: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   648: return
      //   649: astore_0
      //   650: goto -243 -> 407
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	653	0	paramList	List<Long>
      //   74	220	1	i	int
      //   72	6	2	j	int
      //   90	194	3	k	int
      //   16	609	4	l1	long
      //   41	535	6	l2	long
      //   378	130	8	l3	long
      //   46	288	10	localObject1	Object
      //   395	15	10	localThrowable	java.lang.Throwable
      //   442	13	10	localIterator	java.util.Iterator
      //   29	462	11	locale	com.tencent.mm.plugin.finder.storage.e
      //   62	411	12	localObject2	Object
      //   67	414	13	localObject3	Object
      //   129	297	14	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   335	352	395	java/lang/Throwable
      //   352	392	395	java/lang/Throwable
      //   422	427	395	java/lang/Throwable
      //   397	406	406	finally
      //   335	352	649	finally
      //   352	392	649	finally
      //   422	427	649	finally
    }
    
    public static boolean g(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167100);
      d.g.b.k.h(paramFinderItem, "feedObject");
      long l2 = paramFinderItem.field_id;
      long l3 = paramFinderItem.getLocalId();
      com.tencent.mm.plugin.finder.storage.e locale = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage();
      long l1 = -1L;
      boolean bool;
      if (qF(l3)) {
        bool = locale.a(l3, paramFinderItem);
      }
      for (;;)
      {
        if (bool) {
          l1 = paramFinderItem.getLocalId();
        }
        ad.d(b.access$getTAG$cp(), "replace feedSucc %s, rowId %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
        AppMethodBeat.o(167100);
        return bool;
        d.g.b.k.h(paramFinderItem, "finder");
        if (l2 == 0L) {
          ad.m("Finder.FinderFeedStorage", "update svrId " + l2 + ' ' + paramFinderItem.info() + ' ' + bt.eGN(), new Object[0]);
        }
        ContentValues localContentValues = paramFinderItem.convertTo();
        localContentValues.remove("rowid");
        if (locale.db.update("FinderFeedItem", localContentValues, "id=?", new String[] { String.valueOf(l2) }) > 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    
    public static BaseFinderFeed h(FinderItem paramFinderItem)
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
        localBaseFinderFeed = (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.k(paramFinderItem);
        paramFinderItem = paramFinderItem.getFeedObject().contact;
        d.g.b.k.g(paramFinderItem, "finderObject.feedObject.contact");
        d.g.b.k.h(paramFinderItem, "$this$toLocal");
        if (!bt.isNullOrNil(paramFinderItem.username))
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
          localf.YQ((String)localObject);
          str = paramFinderItem.nickname;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localf.nd((String)localObject);
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
          localf.field_pyInitial = com.tencent.mm.platformtools.f.Bs((String)localObject);
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
        localBaseFinderFeed = (BaseFinderFeed)new i(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.l(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new n(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new j(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.k(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new m(paramFinderItem);
        break;
        i = 0;
        break label122;
        label436:
        paramFinderItem = null;
        break label126;
        label441:
        ad.e("Finder.FinderContactEx", "error FinderContact username is null " + bt.eGN());
      }
    }
    
    public static boolean qF(long paramLong)
    {
      AppMethodBeat.i(167096);
      if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().qy(paramLong) != null)
      {
        AppMethodBeat.o(167096);
        return true;
      }
      AppMethodBeat.o(167096);
      return false;
    }
    
    public static FinderItem qG(long paramLong)
    {
      AppMethodBeat.i(167097);
      ad.d(b.access$getTAG$cp(), "get feed local id %s", new Object[] { Long.valueOf(paramLong) });
      FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().qy(paramLong);
      AppMethodBeat.o(167097);
      return localFinderItem;
    }
    
    public static boolean qH(long paramLong)
    {
      AppMethodBeat.i(167098);
      boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().qz(paramLong);
      ad.i(b.access$getTAG$cp(), "delete feed " + paramLong + " success " + bool);
      AppMethodBeat.o(167098);
      return bool;
    }
    
    public static boolean qI(long paramLong)
    {
      AppMethodBeat.i(167099);
      boolean bool = com.tencent.mm.plugin.finder.storage.e.a(((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage(), paramLong);
      ad.i(b.access$getTAG$cp(), "delete feed localId " + paramLong + " success " + bool);
      AppMethodBeat.o(167099);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<List<? extends Integer>>
  {
    public static final b qKH;
    
    static
    {
      AppMethodBeat.i(167090);
      qKH = new b();
      AppMethodBeat.o(167090);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.b
 * JD-Core Version:    0.7.0.1
 */
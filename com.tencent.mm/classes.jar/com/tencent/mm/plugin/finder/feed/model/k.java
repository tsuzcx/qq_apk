package com.tencent.mm.plugin.finder.feed.model;

import android.app.Activity;
import android.os.Message;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.a.as;
import com.tencent.mm.plugin.findersdk.a.w;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "NOTIFY_BY_CLICK", "", "NOTIFY_SIGNAL", "PRELOAD_LIMIT", "REQUEASR_SIGNAL", "TAG", "", "TAG$1", "getData", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "firstItemPos", "lastItemPos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadedList", "Ljava/util/Vector;", "", "loadingList", "preLoaderMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderBatchSyncLoader;", "Lkotlin/collections/HashMap;", "singleFeedReporter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler;", "clearCache", "", "id", "type", "dispatchAttach", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dispatchDetach", "getCacheInfo", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "getEventObserver", "getOrRequestNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "userName", "keep", "target", "notify", "noticeInfos", "Lkotlin/Pair;", "notifyWithCache", "onAttach", "onDetach", "onEventHappen", "ev", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "preLoadFinderLiveNoticeInfo", "ids", "publishEvent", "nameList", "", "requestLoad", "feedId", "nonceId", "(Ljava/lang/Long;Ljava/lang/String;I)V", "requestSignNoticeInfo", "(Ljava/lang/Long;Ljava/lang/String;)V", "setUxInfo", "uxInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends com.tencent.mm.plugin.finder.event.base.d
  implements as, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  public static final a Bho;
  private static long Bhv;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> ATq;
  private final int BeR;
  private final int BeS;
  private Vector<Long> Bfi;
  private final int Bhp;
  private m<? super Integer, ? super Integer, ? extends LinkedList<cc>> Bhq;
  private final Vector<Long> Bhr;
  private n Bhs;
  private final HashMap<Integer, p<Long>> Bht;
  private final int Bhu;
  private Activity activity;
  private Fragment fragment;
  private final String mgf;
  private final kotlin.j rdm;
  
  static
  {
    AppMethodBeat.i(366134);
    Bho = new a((byte)0);
    Bhv = -1L;
    AppMethodBeat.o(366134);
  }
  
  public k(Activity paramActivity)
  {
    AppMethodBeat.i(366025);
    this.mgf = "FinderLiveNoticePreLoader";
    this.Bhp = 5;
    this.ATq = new CopyOnWriteArraySet();
    this.Bfi = new Vector();
    this.Bhr = new Vector();
    this.Bht = new HashMap();
    this.Bhu = 1;
    this.BeR = 2;
    this.BeS = 3;
    this.rdm = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.activity = paramActivity;
    Map localMap = (Map)this.Bht;
    com.tencent.mm.ui.component.b localb = com.tencent.mm.ui.component.k.aeZF.co(w.class);
    ((w)localb).av(paramActivity);
    localMap.put(Integer.valueOf(2), (p)localb);
    if ((paramActivity instanceof MMActivity)) {}
    for (paramActivity = (MMActivity)paramActivity;; paramActivity = null)
    {
      if (paramActivity != null) {
        this.Bhs = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).c(paramActivity);
      }
      AppMethodBeat.o(366025);
      return;
    }
  }
  
  public k(Fragment paramFragment)
  {
    AppMethodBeat.i(366032);
    this.mgf = "FinderLiveNoticePreLoader";
    this.Bhp = 5;
    this.ATq = new CopyOnWriteArraySet();
    this.Bfi = new Vector();
    this.Bhr = new Vector();
    this.Bht = new HashMap();
    this.Bhu = 1;
    this.BeR = 2;
    this.BeS = 3;
    this.rdm = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.fragment = paramFragment;
    Map localMap = (Map)this.Bht;
    com.tencent.mm.ui.component.b localb = com.tencent.mm.ui.component.k.aeZF.co(w.class);
    ((w)localb).w(paramFragment);
    localMap.put(Integer.valueOf(2), (p)localb);
    paramFragment = paramFragment.getActivity();
    if ((paramFragment instanceof MMActivity)) {}
    for (paramFragment = (MMActivity)paramFragment;; paramFragment = null)
    {
      if (paramFragment != null) {
        this.Bhs = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).c(paramFragment);
      }
      AppMethodBeat.o(366032);
      return;
    }
  }
  
  /* Error */
  private static final ah a(k paramk, ah.f paramf, com.tencent.mm.am.b.a parama)
  {
    // Byte code:
    //   0: ldc_w 273
    //   3: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 275
    //   10: invokestatic 167	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc_w 277
    //   17: invokestatic 167	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 174	com/tencent/mm/plugin/finder/feed/model/k:mgf	Ljava/lang/String;
    //   24: new 279	java/lang/StringBuilder
    //   27: dup
    //   28: ldc_w 281
    //   31: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: aload_2
    //   35: getfield 289	com/tencent/mm/am/b$a:errType	I
    //   38: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 295
    //   44: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: getfield 301	com/tencent/mm/am/b$a:errCode	I
    //   51: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc_w 303
    //   57: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokestatic 309	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   63: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_2
    //   73: getfield 289	com/tencent/mm/am/b$a:errType	I
    //   76: ifne +353 -> 429
    //   79: aload_2
    //   80: getfield 301	com/tencent/mm/am/b$a:errCode	I
    //   83: ifne +346 -> 429
    //   86: aload_2
    //   87: getfield 325	com/tencent/mm/am/b$a:ott	Lcom/tencent/mm/protocal/protobuf/esc;
    //   90: ifnull +339 -> 429
    //   93: aload_0
    //   94: getfield 174	com/tencent/mm/plugin/finder/feed/model/k:mgf	Ljava/lang/String;
    //   97: ldc_w 327
    //   100: aload_2
    //   101: getfield 325	com/tencent/mm/am/b$a:ott	Lcom/tencent/mm/protocal/protobuf/esc;
    //   104: checkcast 329	com/tencent/mm/protocal/protobuf/aub
    //   107: getfield 332	com/tencent/mm/protocal/protobuf/aub:ZEz	Ljava/util/LinkedList;
    //   110: invokevirtual 338	java/util/LinkedList:size	()I
    //   113: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: invokestatic 342	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokestatic 321	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_2
    //   123: getfield 325	com/tencent/mm/am/b$a:ott	Lcom/tencent/mm/protocal/protobuf/esc;
    //   126: checkcast 329	com/tencent/mm/protocal/protobuf/aub
    //   129: getfield 332	com/tencent/mm/protocal/protobuf/aub:ZEz	Ljava/util/LinkedList;
    //   132: astore_3
    //   133: aload_3
    //   134: ldc_w 344
    //   137: invokestatic 347	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   140: aload_3
    //   141: checkcast 349	java/lang/Iterable
    //   144: invokeinterface 353 1 0
    //   149: astore_3
    //   150: aload_3
    //   151: invokeinterface 359 1 0
    //   156: ifeq +126 -> 282
    //   159: aload_3
    //   160: invokeinterface 363 1 0
    //   165: checkcast 365	com/tencent/mm/protocal/protobuf/bqy
    //   168: astore 4
    //   170: aload_0
    //   171: getfield 188	com/tencent/mm/plugin/finder/feed/model/k:Bhr	Ljava/util/Vector;
    //   174: aload 4
    //   176: getfield 368	com/tencent/mm/protocal/protobuf/bqy:object_id	J
    //   179: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: invokevirtual 377	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   185: pop
    //   186: goto -36 -> 150
    //   189: astore_2
    //   190: aload_0
    //   191: getfield 174	com/tencent/mm/plugin/finder/feed/model/k:mgf	Ljava/lang/String;
    //   194: aload_2
    //   195: ldc_w 379
    //   198: iconst_0
    //   199: anewarray 381	java/lang/Object
    //   202: invokestatic 385	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: aload_0
    //   206: getfield 186	com/tencent/mm/plugin/finder/feed/model/k:Bfi	Ljava/util/Vector;
    //   209: astore_0
    //   210: aload_1
    //   211: getfield 391	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   214: checkcast 349	java/lang/Iterable
    //   217: astore_2
    //   218: new 393	java/util/ArrayList
    //   221: dup
    //   222: aload_2
    //   223: bipush 10
    //   225: invokestatic 398	kotlin/a/p:a	(Ljava/lang/Iterable;I)I
    //   228: invokespecial 400	java/util/ArrayList:<init>	(I)V
    //   231: checkcast 402	java/util/Collection
    //   234: astore_1
    //   235: aload_2
    //   236: invokeinterface 353 1 0
    //   241: astore_2
    //   242: aload_2
    //   243: invokeinterface 359 1 0
    //   248: ifeq +282 -> 530
    //   251: aload_1
    //   252: aload_2
    //   253: invokeinterface 363 1 0
    //   258: checkcast 404	kotlin/r
    //   261: getfield 407	kotlin/r:bsC	Ljava/lang/Object;
    //   264: checkcast 409	java/lang/Number
    //   267: invokevirtual 413	java/lang/Number:longValue	()J
    //   270: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   273: invokeinterface 414 2 0
    //   278: pop
    //   279: goto -37 -> 242
    //   282: new 334	java/util/LinkedList
    //   285: dup
    //   286: invokespecial 415	java/util/LinkedList:<init>	()V
    //   289: astore_3
    //   290: aload_2
    //   291: getfield 325	com/tencent/mm/am/b$a:ott	Lcom/tencent/mm/protocal/protobuf/esc;
    //   294: checkcast 329	com/tencent/mm/protocal/protobuf/aub
    //   297: getfield 418	com/tencent/mm/protocal/protobuf/aub:ZEA	Ljava/util/LinkedList;
    //   300: astore_2
    //   301: aload_2
    //   302: ldc_w 420
    //   305: invokestatic 347	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   308: aload_2
    //   309: checkcast 349	java/lang/Iterable
    //   312: invokeinterface 353 1 0
    //   317: astore_2
    //   318: aload_2
    //   319: invokeinterface 359 1 0
    //   324: ifeq +74 -> 398
    //   327: aload_2
    //   328: invokeinterface 363 1 0
    //   333: checkcast 422	com/tencent/mm/protocal/protobuf/avi
    //   336: astore 5
    //   338: getstatic 428	com/tencent/mm/plugin/finder/utils/aw:Gjk	Lcom/tencent/mm/plugin/finder/utils/aw;
    //   341: astore 4
    //   343: aload 5
    //   345: getfield 431	com/tencent/mm/protocal/protobuf/avi:YIZ	Ljava/lang/String;
    //   348: astore 4
    //   350: aload 5
    //   352: getfield 435	com/tencent/mm/protocal/protobuf/avi:ZFA	Lcom/tencent/mm/protocal/protobuf/bkk;
    //   355: astore 5
    //   357: aload 4
    //   359: ifnull -41 -> 318
    //   362: aload 5
    //   364: ifnull -46 -> 318
    //   367: getstatic 441	com/tencent/mm/plugin/finder/feed/model/j:BfL	Lcom/tencent/mm/plugin/finder/feed/model/j;
    //   370: astore 6
    //   372: aload 4
    //   374: aload 5
    //   376: invokestatic 445	com/tencent/mm/plugin/finder/feed/model/j:b	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/bkk;)V
    //   379: aload_3
    //   380: new 404	kotlin/r
    //   383: dup
    //   384: aload 4
    //   386: aload 5
    //   388: invokespecial 448	kotlin/r:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   391: invokevirtual 449	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   394: pop
    //   395: goto -77 -> 318
    //   398: aload_0
    //   399: invokespecial 451	com/tencent/mm/plugin/finder/feed/model/k:getHandler	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   402: aload_0
    //   403: getfield 197	com/tencent/mm/plugin/finder/feed/model/k:BeR	I
    //   406: invokevirtual 456	com/tencent/mm/sdk/platformtools/MMHandler:removeMessages	(I)V
    //   409: aload_0
    //   410: invokespecial 451	com/tencent/mm/plugin/finder/feed/model/k:getHandler	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   413: aload_0
    //   414: invokespecial 451	com/tencent/mm/plugin/finder/feed/model/k:getHandler	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   417: aload_0
    //   418: getfield 197	com/tencent/mm/plugin/finder/feed/model/k:BeR	I
    //   421: aload_3
    //   422: invokevirtual 460	com/tencent/mm/sdk/platformtools/MMHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   425: invokevirtual 464	com/tencent/mm/sdk/platformtools/MMHandler:sendMessage	(Landroid/os/Message;)Z
    //   428: pop
    //   429: aload_0
    //   430: getfield 186	com/tencent/mm/plugin/finder/feed/model/k:Bfi	Ljava/util/Vector;
    //   433: astore_0
    //   434: aload_1
    //   435: getfield 391	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   438: checkcast 349	java/lang/Iterable
    //   441: astore_2
    //   442: new 393	java/util/ArrayList
    //   445: dup
    //   446: aload_2
    //   447: bipush 10
    //   449: invokestatic 398	kotlin/a/p:a	(Ljava/lang/Iterable;I)I
    //   452: invokespecial 400	java/util/ArrayList:<init>	(I)V
    //   455: checkcast 402	java/util/Collection
    //   458: astore_1
    //   459: aload_2
    //   460: invokeinterface 353 1 0
    //   465: astore_2
    //   466: aload_2
    //   467: invokeinterface 359 1 0
    //   472: ifeq +34 -> 506
    //   475: aload_1
    //   476: aload_2
    //   477: invokeinterface 363 1 0
    //   482: checkcast 404	kotlin/r
    //   485: getfield 407	kotlin/r:bsC	Ljava/lang/Object;
    //   488: checkcast 409	java/lang/Number
    //   491: invokevirtual 413	java/lang/Number:longValue	()J
    //   494: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   497: invokeinterface 414 2 0
    //   502: pop
    //   503: goto -37 -> 466
    //   506: aload_0
    //   507: aload_1
    //   508: checkcast 466	java/util/List
    //   511: checkcast 402	java/util/Collection
    //   514: invokevirtual 470	java/util/Vector:removeAll	(Ljava/util/Collection;)Z
    //   517: pop
    //   518: getstatic 476	kotlin/ah:aiuX	Lkotlin/ah;
    //   521: astore_0
    //   522: ldc_w 273
    //   525: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload_0
    //   529: areturn
    //   530: aload_0
    //   531: aload_1
    //   532: checkcast 466	java/util/List
    //   535: checkcast 402	java/util/Collection
    //   538: invokevirtual 470	java/util/Vector:removeAll	(Ljava/util/Collection;)Z
    //   541: pop
    //   542: goto -24 -> 518
    //   545: astore_2
    //   546: aload_0
    //   547: getfield 186	com/tencent/mm/plugin/finder/feed/model/k:Bfi	Ljava/util/Vector;
    //   550: astore_0
    //   551: aload_1
    //   552: getfield 391	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   555: checkcast 349	java/lang/Iterable
    //   558: astore_3
    //   559: new 393	java/util/ArrayList
    //   562: dup
    //   563: aload_3
    //   564: bipush 10
    //   566: invokestatic 398	kotlin/a/p:a	(Ljava/lang/Iterable;I)I
    //   569: invokespecial 400	java/util/ArrayList:<init>	(I)V
    //   572: checkcast 402	java/util/Collection
    //   575: astore_1
    //   576: aload_3
    //   577: invokeinterface 353 1 0
    //   582: astore_3
    //   583: aload_3
    //   584: invokeinterface 359 1 0
    //   589: ifeq +34 -> 623
    //   592: aload_1
    //   593: aload_3
    //   594: invokeinterface 363 1 0
    //   599: checkcast 404	kotlin/r
    //   602: getfield 407	kotlin/r:bsC	Ljava/lang/Object;
    //   605: checkcast 409	java/lang/Number
    //   608: invokevirtual 413	java/lang/Number:longValue	()J
    //   611: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   614: invokeinterface 414 2 0
    //   619: pop
    //   620: goto -37 -> 583
    //   623: aload_0
    //   624: aload_1
    //   625: checkcast 466	java/util/List
    //   628: checkcast 402	java/util/Collection
    //   631: invokevirtual 470	java/util/Vector:removeAll	(Ljava/util/Collection;)Z
    //   634: pop
    //   635: ldc_w 273
    //   638: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   641: aload_2
    //   642: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	643	0	paramk	k
    //   0	643	1	paramf	ah.f
    //   0	643	2	parama	com.tencent.mm.am.b.a
    //   132	462	3	localObject1	Object
    //   168	217	4	localObject2	Object
    //   336	51	5	localObject3	Object
    //   370	1	6	localj	j
    // Exception table:
    //   from	to	target	type
    //   72	150	189	finally
    //   150	186	189	finally
    //   282	318	189	finally
    //   318	357	189	finally
    //   367	395	189	finally
    //   398	429	189	finally
    //   190	205	545	finally
  }
  
  private final void ak(LinkedList<r<Long, String>> paramLinkedList)
  {
    Object localObject3;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(366054);
        Log.i(this.mgf, s.X("request id size = ", Integer.valueOf(paramLinkedList.size())));
        localObject1 = (Iterable)paramLinkedList;
        paramLinkedList = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (r)localObject2;
        if ((!this.Bhr.contains(((r)localObject3).bsC)) && (((Number)((r)localObject3).bsC).longValue() != Bhv))
        {
          i = 1;
          if (i != 0) {
            paramLinkedList.add(localObject2);
          }
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
    Object localObject1 = new LinkedList((Collection)paramLinkedList);
    Log.i(this.mgf, s.X("idsToFillLoading id size = ", Integer.valueOf(((LinkedList)localObject1).size())));
    paramLinkedList = new ah.f();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    r localr;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localr = (r)localObject3;
      if (this.Bfi.contains(localr.bsC)) {
        break label668;
      }
      i = 1;
      label248:
      if (i == 0) {
        break label671;
      }
      ((Collection)localObject1).add(localObject3);
    }
    paramLinkedList.aqH = new LinkedList((Collection)localObject1);
    Log.i(this.mgf, s.X("real request id size = ", Integer.valueOf(((LinkedList)paramLinkedList.aqH).size())));
    if (!((Collection)paramLinkedList.aqH).isEmpty())
    {
      i = 1;
      label325:
      if (i != 0)
      {
        localObject1 = this.Bfi;
        localObject3 = (Iterable)paramLinkedList.aqH;
        localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject2).add(Long.valueOf(((Number)((r)((Iterator)localObject3).next()).bsC).longValue()));
        }
        ((Vector)localObject1).addAll((Collection)localObject2);
        localObject2 = (Iterable)paramLinkedList.aqH;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
      }
    }
    label668:
    label671:
    label687:
    label692:
    label695:
    for (;;)
    {
      label456:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localr = (r)localObject3;
        if (((Number)localr.bsC).longValue() == 0L) {
          break label692;
        }
        if (((CharSequence)localr.bsD).length() <= 0) {
          break label687;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label695;
        }
        ((Collection)localObject1).add(localObject3);
        break label456;
        paramLinkedList.aqH = new LinkedList((Collection)localObject1);
        if (!((Collection)paramLinkedList.aqH).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label630;
          }
          new com.tencent.mm.plugin.finder.cgi.g((List)paramLinkedList.aqH, 0, null, null, 30).bFJ().h(new k..ExternalSyntheticLambda0(this, paramLinkedList)).a((com.tencent.mm.vending.e.b)this);
          AppMethodBeat.o(366054);
        }
        for (;;)
        {
          return;
          i = 0;
          break;
          label630:
          Log.i(this.mgf, "idsToRequest is empty #1");
          AppMethodBeat.o(366054);
          continue;
          Log.i(this.mgf, "idsToRequest is empty #2");
          AppMethodBeat.o(366054);
        }
        i = 0;
        break label248;
        break;
        i = 0;
        break label325;
        for (;;)
        {
          if (i == 0) {
            break label692;
          }
          i = 1;
          break;
          i = 0;
        }
        i = 0;
      }
    }
  }
  
  private final MMHandler getHandler()
  {
    AppMethodBeat.i(366038);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(366038);
    return localMMHandler;
  }
  
  public final void a(final com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(366207);
    s.u(paramb, "ev");
    Log.i(this.mgf, s.X("onEventHappen ev: ", paramb));
    if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type != 9))
    {
      if (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 1) {
        Bhv = -1L;
      }
      if (Bhv != -1L)
      {
        Log.w(this.mgf, "isIgnorePreloadForFeedId");
        AppMethodBeat.o(366207);
        return;
      }
      final int i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOr;
      final int j = i + this.Bhp;
      Log.i(this.mgf, "onEventHappen :" + paramb + " firstItemPos:" + i + " lastItemPos:" + j);
      if (i > j)
      {
        AppMethodBeat.o(366207);
        return;
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, i, j, paramb));
    }
    p localp = (p)this.Bht.get(Integer.valueOf(1));
    if (localp != null) {
      localp.a(paramb);
    }
    AppMethodBeat.o(366207);
  }
  
  public final void a(Long paramLong, String paramString)
  {
    AppMethodBeat.i(366220);
    if ((paramLong != null) && (paramString != null))
    {
      paramLong = new LinkedList((Collection)kotlin.a.p.listOf(new r(Long.valueOf(((Number)paramLong).longValue()), paramString)));
      getHandler().sendMessage(getHandler().obtainMessage(this.Bhu, paramLong));
    }
    AppMethodBeat.o(366220);
  }
  
  public final void a(m<? super Integer, ? super Integer, ? extends LinkedList<cc>> paramm, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(366155);
    Log.i(this.mgf, "onAttach");
    this.Bhq = paramm;
    Iterator localIterator = ((Map)this.Bht).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((p)localEntry.getValue()).a(paramm, paramRecyclerView, ((Number)localEntry.getKey()).intValue());
    }
    paramm = this.Bhs;
    if (paramm != null) {
      paramm.q(paramRecyclerView);
    }
    AppMethodBeat.o(366155);
  }
  
  public final bkk avW(String paramString)
  {
    AppMethodBeat.i(366171);
    s.u(paramString, "userName");
    j localj = j.BfL;
    paramString = j.Sv(paramString);
    AppMethodBeat.o(366171);
    return paramString;
  }
  
  public final void avX(String paramString)
  {
    AppMethodBeat.i(366192);
    s.u(paramString, "userName");
    getHandler().removeMessages(this.BeS);
    getHandler().sendMessage(getHandler().obtainMessage(this.BeS, paramString));
    AppMethodBeat.o(366192);
  }
  
  public final com.tencent.mm.plugin.finder.event.base.d edV()
  {
    return (com.tencent.mm.plugin.finder.event.base.d)this;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(366197);
    this.ATq.add(parama);
    AppMethodBeat.o(366197);
  }
  
  public final q nE(long paramLong)
  {
    AppMethodBeat.i(366177);
    if (this.Bht.containsKey(Integer.valueOf(2)))
    {
      Object localObject = (p)this.Bht.get(Integer.valueOf(2));
      if (localObject == null)
      {
        AppMethodBeat.o(366177);
        return null;
      }
      localObject = ((p)localObject).fj(Long.valueOf(paramLong));
      AppMethodBeat.o(366177);
      return localObject;
    }
    AppMethodBeat.o(366177);
    return null;
  }
  
  public final void nF(long paramLong)
  {
    AppMethodBeat.i(366185);
    Log.i(this.mgf, "clearCache: id:" + paramLong + " type:2");
    p localp = (p)this.Bht.get(Integer.valueOf(2));
    if (localp != null) {
      localp.fi(Long.valueOf(paramLong));
    }
    AppMethodBeat.o(366185);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(366163);
    Log.i(this.mgf, "onDetach");
    this.Bhq = null;
    Object localObject = ((Map)this.Bht).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((p)((Map.Entry)((Iterator)localObject).next()).getValue()).onDetach();
    }
    localObject = this.Bhs;
    if (localObject != null) {
      ((n)localObject).onDetach();
    }
    this.Bhs = null;
    localObject = ((Iterable)this.ATq).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.ATq.clear();
    this.Bfi.clear();
    getHandler().removeMessages(this.Bhu);
    getHandler().removeMessages(this.BeR);
    this.Bhr.clear();
    this.fragment = null;
    this.activity = null;
    AppMethodBeat.o(366163);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader$Companion;", "", "()V", "TAG", "", "isIgnorePreloadForFeedId", "", "()J", "setIgnorePreloadForFeedId", "(J)V", "filterData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "firstItemPos", "", "lastItemPos", "nameList2Str", "nameList", "", "str2NameList", "str", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static LinkedList<cc> a(BaseFeedLoader<cc> paramBaseFeedLoader, int paramInt1, int paramInt2)
    {
      int k = 1;
      localObject = null;
      AppMethodBeat.i(366114);
      int j;
      int i;
      if (paramBaseFeedLoader == null)
      {
        j = 0;
        if (paramInt2 < j) {
          break label173;
        }
        i = j - 1;
        label29:
        Log.i("Finder.filterData", "filterData firstItemPos:" + paramInt1 + " lastItemPos:" + paramInt2);
        if (paramInt1 < 0) {
          break label193;
        }
        if (paramInt1 >= j) {
          break label188;
        }
        paramInt2 = 1;
        label71:
        if ((paramInt2 == 0) || (paramBaseFeedLoader == null)) {
          break label208;
        }
      }
      try
      {
        paramBaseFeedLoader = paramBaseFeedLoader.getDataListJustForAdapter();
        if (paramBaseFeedLoader == null) {
          break label208;
        }
        if (paramBaseFeedLoader.size() <= i) {
          break label198;
        }
        paramInt2 = k;
      }
      catch (Exception paramBaseFeedLoader)
      {
        for (;;)
        {
          label102:
          Log.printErrStackTrace("Finder.filterData", (Throwable)paramBaseFeedLoader, "filterData fail", new Object[0]);
          label173:
          label188:
          label193:
          label198:
          label208:
          paramBaseFeedLoader = localObject;
          continue;
          if (paramInt2 == 0) {}
        }
      }
      if (paramBaseFeedLoader != null)
      {
        paramBaseFeedLoader = kotlin.a.p.a((List)paramBaseFeedLoader, new kotlin.k.g(paramInt1, i));
        if (paramBaseFeedLoader == null) {}
      }
      for (paramBaseFeedLoader = new LinkedList((Collection)paramBaseFeedLoader);; paramBaseFeedLoader = null)
      {
        AppMethodBeat.o(366114);
        return paramBaseFeedLoader;
        DataBuffer localDataBuffer = paramBaseFeedLoader.getDataListJustForAdapter();
        if (localDataBuffer == null)
        {
          j = 0;
          break;
        }
        j = localDataBuffer.size();
        break;
        if (paramInt2 < paramInt1)
        {
          i = paramInt1;
          break label29;
        }
        i = paramInt2;
        break label29;
        paramInt2 = 0;
        break label71;
        paramInt2 = 0;
        break label71;
        paramInt2 = 0;
        break label235;
        paramBaseFeedLoader = null;
        break label102;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    b(k paramk)
    {
      super();
    }
    
    private static final boolean a(k paramk, Message paramMessage)
    {
      AppMethodBeat.i(366104);
      s.u(paramk, "this$0");
      s.u(paramMessage, "it");
      int i = paramMessage.what;
      if (i == k.f(paramk))
      {
        paramMessage = paramMessage.obj;
        if (paramMessage == null)
        {
          paramk = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<kotlin.Pair<kotlin.Long, kotlin.String>>");
          AppMethodBeat.o(366104);
          throw paramk;
        }
        k.a(paramk, (LinkedList)paramMessage);
      }
      for (;;)
      {
        AppMethodBeat.o(366104);
        return true;
        if (i == k.g(paramk))
        {
          paramk = paramMessage.obj;
          if (paramk == null)
          {
            paramk = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<kotlin.Pair<kotlin.String, com.tencent.mm.protocal.protobuf.FinderLiveNoticeInfo>>");
            AppMethodBeat.o(366104);
            throw paramk;
          }
          paramMessage = (Iterable)paramk;
          paramk = (Collection)new ArrayList(kotlin.a.p.a(paramMessage, 10));
          paramMessage = paramMessage.iterator();
          while (paramMessage.hasNext()) {
            paramk.add((String)((r)paramMessage.next()).bsC);
          }
          paramk = (List)paramk;
          if (!((Collection)paramk).isEmpty())
          {
            i = 1;
            label190:
            if (i == 0) {
              break label210;
            }
          }
          for (;;)
          {
            if (paramk == null) {
              break label213;
            }
            k.ge(paramk);
            break;
            i = 0;
            break label190;
            label210:
            paramk = null;
          }
        }
        else
        {
          label213:
          if (i == k.h(paramk))
          {
            paramk = paramMessage.obj;
            if (paramk == null)
            {
              paramk = new NullPointerException("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(366104);
              throw paramk;
            }
            k.ge(kotlin.a.p.listOf((String)paramk));
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(k paramk, int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      super();
    }
    
    private static final void a(LinkedList paramLinkedList, k paramk)
    {
      AppMethodBeat.i(366105);
      s.u(paramk, "this$0");
      Object localObject1 = new LinkedList();
      int i;
      if (paramLinkedList == null)
      {
        paramLinkedList = null;
        if (paramLinkedList != null)
        {
          if (((Collection)paramLinkedList).isEmpty()) {
            break label408;
          }
          i = 1;
          label44:
          if (i == 0) {
            break label413;
          }
        }
      }
      label408:
      label413:
      for (localObject1 = paramLinkedList;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          paramLinkedList = new LinkedList((Collection)paramLinkedList);
          k.c(paramk).removeMessages(k.f(paramk));
          k.c(paramk).sendMessage(k.c(paramk).obtainMessage(k.f(paramk), paramLinkedList));
        }
        AppMethodBeat.o(366105);
        return;
        Object localObject2 = (Iterable)paramLinkedList;
        paramLinkedList = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if ((localObject3 instanceof BaseFinderFeed)) {
            paramLinkedList.add(localObject3);
          }
        }
        localObject2 = (Iterable)paramLinkedList;
        paramLinkedList = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        label291:
        label294:
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)localObject3;
          j localj = j.BfL;
          if (j.Sv(localBaseFinderFeed.feedObject.getUserName()) != null)
          {
            i = 1;
            label246:
            if (i != 0) {
              ((LinkedList)localObject1).add(localBaseFinderFeed.feedObject.getUserName());
            }
            if (i != 0) {
              break label291;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label294;
            }
            paramLinkedList.add(localObject3);
            break;
            i = 0;
            break label246;
          }
        }
        paramLinkedList = (Iterable)paramLinkedList;
        localObject2 = (Collection)new ArrayList(kotlin.a.p.a(paramLinkedList, 10));
        Object localObject3 = paramLinkedList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          paramLinkedList = ((BaseFinderFeed)((Iterator)localObject3).next()).feedObject;
          long l = paramLinkedList.getExpectId();
          localObject1 = paramLinkedList.getObjectNonceId();
          paramLinkedList = (LinkedList)localObject1;
          if (localObject1 == null) {
            paramLinkedList = "";
          }
          ((Collection)localObject2).add(new r(Long.valueOf(l), paramLinkedList));
        }
        paramLinkedList = (List)localObject2;
        break;
        i = 0;
        break label44;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.k
 * JD-Core Version:    0.7.0.1
 */
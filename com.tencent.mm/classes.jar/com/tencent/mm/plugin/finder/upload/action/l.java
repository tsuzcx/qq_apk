package com.tencent.mm.plugin.finder.upload.action;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "feedCommentLikeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "feedMap", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "localFeedLikeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "Lkotlin/collections/HashMap;", "megaVideoMap", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "addSelf", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "likeList", "addSelfInto", "", "newList", "commentLikeCount", "", "feedId", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "scene", "doLike", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "isPrivate", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "doLikeComment", "objectNonceId", "", "comment", "isPoster", "doLikeLocalFeed", "localId", "doPost", "action", "friendLikeCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "friendLikeList", "isCommentLike", "isLike", "Lkotlin/Pair;", "isLocalFeedLike", "isMegaVideoLike", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "isWxScene", "likeCount", "likeLocalFeed", "likeAction", "showTips", "likeMegaVideoCount", "removeLikeCache", "removeLikeCommentCache", "removeLocalLikeFeed", "removeLongVideoLikeCache", "removeSelf", "removeSelfFrom", "removeUnuseAction", "restoreLocalLikeFeed", "saveLocalLikeFeed", "tryNext", "Companion", "ILikeActionCallback", "KeyData", "plugin-finder_release"})
public final class l
{
  private static final l ACi;
  public static final a ACj;
  public static final String TAG = "Finder.FinderLikeActionMgr";
  private final ConcurrentHashMap<Long, k> ABA;
  private final ConcurrentHashMap<Long, k> ABB;
  private final ConcurrentLinkedQueue<e> ABz;
  private final ConcurrentHashMap<Long, ConcurrentHashMap<c, n>> ACg;
  public final HashMap<Long, r> ACh;
  private com.tencent.mm.loader.g.d<m> Azm;
  private final Runnable Azn;
  
  static
  {
    AppMethodBeat.i(167823);
    ACj = new a((byte)0);
    TAG = "Finder.FinderLikeActionMgr";
    ACi = new l();
    AppMethodBeat.o(167823);
  }
  
  public l()
  {
    AppMethodBeat.i(167822);
    this.Azm = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_like_post_quene"));
    ecF();
    this.ABz = new ConcurrentLinkedQueue();
    this.ABA = new ConcurrentHashMap();
    this.ABB = new ConcurrentHashMap();
    this.ACg = new ConcurrentHashMap();
    this.ACh = new HashMap();
    this.Azn = ((Runnable)new f(this));
    AppMethodBeat.o(167822);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(167821);
    this.Azm.a((com.tencent.mm.loader.g.c)new m(parame), (com.tencent.mm.loader.g.f)new d(this, parame));
    AppMethodBeat.o(167821);
  }
  
  private static LinkedList<FinderCommentInfo> aW(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(275102);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    aX(localLinkedList);
    AppMethodBeat.o(275102);
    return localLinkedList;
  }
  
  /* Error */
  public static void aX(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    // Byte code:
    //   0: ldc_w 414
    //   3: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 415
    //   10: invokestatic 236	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: checkcast 357	java/lang/Iterable
    //   19: invokeinterface 366 1 0
    //   24: astore_2
    //   25: aload_2
    //   26: invokeinterface 372 1 0
    //   31: ifeq +81 -> 112
    //   34: aload_2
    //   35: invokeinterface 376 1 0
    //   40: astore_1
    //   41: aload_1
    //   42: checkcast 312	com/tencent/mm/protocal/protobuf/FinderCommentInfo
    //   45: getfield 418	com/tencent/mm/protocal/protobuf/FinderCommentInfo:username	Ljava/lang/String;
    //   48: invokestatic 423	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   51: invokestatic 427	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   54: ifeq -29 -> 25
    //   57: aload_1
    //   58: checkcast 312	com/tencent/mm/protocal/protobuf/FinderCommentInfo
    //   61: ifnonnull +38 -> 99
    //   64: new 312	com/tencent/mm/protocal/protobuf/FinderCommentInfo
    //   67: dup
    //   68: invokespecial 428	com/tencent/mm/protocal/protobuf/FinderCommentInfo:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: invokestatic 423	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   76: putfield 418	com/tencent/mm/protocal/protobuf/FinderCommentInfo:username	Ljava/lang/String;
    //   79: aload_1
    //   80: invokestatic 431	com/tencent/mm/model/z:bdb	()Ljava/lang/String;
    //   83: putfield 434	com/tencent/mm/protocal/protobuf/FinderCommentInfo:nickname	Ljava/lang/String;
    //   86: aload_1
    //   87: ldc_w 435
    //   90: putfield 438	com/tencent/mm/protocal/protobuf/FinderCommentInfo:headUrl	Ljava/lang/String;
    //   93: aload_0
    //   94: iconst_0
    //   95: aload_1
    //   96: invokevirtual 441	java/util/LinkedList:add	(ILjava/lang/Object;)V
    //   99: getstatic 447	kotlin/x:aazN	Lkotlin/x;
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: ldc_w 414
    //   108: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: return
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -57 -> 57
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: ldc_w 414
    //   123: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramLinkedList	LinkedList<FinderCommentInfo>
    //   40	74	1	localObject1	Object
    //   117	10	1	localObject2	Object
    //   24	11	2	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   15	25	117	finally
    //   25	57	117	finally
    //   57	99	117	finally
    //   99	103	117	finally
  }
  
  private static LinkedList<FinderCommentInfo> aY(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(275104);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    aZ(localLinkedList);
    AppMethodBeat.o(275104);
    return localLinkedList;
  }
  
  public static void aZ(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(275106);
    p.k(paramLinkedList, "newList");
    com.tencent.mm.ae.d.a(paramLinkedList, (kotlin.g.a.b)e.ACl);
    AppMethodBeat.o(275106);
  }
  
  private final void ecF()
  {
    AppMethodBeat.i(275113);
    Object localObject;
    try
    {
      localObject = ((PluginFinder)h.ag(PluginFinder.class)).getLocalLikeFeedStorage();
      ArrayList localArrayList = new ArrayList();
      localObject = ((s)localObject).db.rawQuery("select * from FinderLocalOperation", null);
      if (localObject != null)
      {
        while (((Cursor)localObject).moveToNext())
        {
          r localr = new r();
          localr.convertFrom((Cursor)localObject);
          localArrayList.add(localr);
        }
        ((Cursor)localObject).close();
      }
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace(TAG, localThrowable, "restoreLocalLikeFeed", new Object[0]);
      AppMethodBeat.o(275113);
      return;
    }
    Log.i(s.TAG, "getAllData size:" + localThrowable.size());
    Iterator localIterator = ((Iterable)localThrowable).iterator();
    while (localIterator.hasNext())
    {
      localObject = (r)localIterator.next();
      ((Map)this.ACh).put(Long.valueOf(((r)localObject).field_localId), localObject);
    }
    AppMethodBeat.o(275113);
  }
  
  public final o<Boolean, Boolean> Na(long paramLong)
  {
    AppMethodBeat.i(275111);
    boolean bool2 = this.ACh.containsKey(Long.valueOf(paramLong));
    Object localObject = (r)this.ACh.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (boolean bool1 = ((r)localObject).field_isPrivate;; bool1 = false)
    {
      Log.i(TAG, "isLocalFeedLike " + paramLong + ", " + bool2);
      localObject = new o(Boolean.valueOf(bool2), Boolean.valueOf(bool1));
      AppMethodBeat.o(275111);
      return localObject;
    }
  }
  
  /* Error */
  public final void a(long paramLong, com.tencent.mm.protocal.protobuf.bid parambid, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 557
    //   5: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_3
    //   9: ldc 238
    //   11: invokestatic 236	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: getstatic 144	com/tencent/mm/plugin/finder/upload/action/l:TAG	Ljava/lang/String;
    //   17: new 240	java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w 559
    //   24: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: lload_1
    //   28: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   31: ldc_w 561
    //   34: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 4
    //   39: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: ldc_w 563
    //   45: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 6
    //   50: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 565
    //   56: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 203	com/tencent/mm/plugin/finder/upload/action/l:ACh	Ljava/util/HashMap;
    //   63: lload_1
    //   64: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: invokevirtual 535	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   70: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   73: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 276	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iload 4
    //   81: ifeq +192 -> 273
    //   84: aload_0
    //   85: getfield 203	com/tencent/mm/plugin/finder/upload/action/l:ACh	Ljava/util/HashMap;
    //   88: lload_1
    //   89: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 535	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   95: ifeq +34 -> 129
    //   98: aload_0
    //   99: getfield 203	com/tencent/mm/plugin/finder/upload/action/l:ACh	Ljava/util/HashMap;
    //   102: lload_1
    //   103: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: invokevirtual 536	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 503	com/tencent/mm/plugin/finder/storage/r
    //   112: astore 8
    //   114: aload 8
    //   116: ifnull +13 -> 129
    //   119: aload 8
    //   121: getfield 540	com/tencent/mm/plugin/finder/storage/r:field_isPrivate	Z
    //   124: iload 6
    //   126: if_icmpeq +87 -> 213
    //   129: new 503	com/tencent/mm/plugin/finder/storage/r
    //   132: dup
    //   133: invokespecial 504	com/tencent/mm/plugin/finder/storage/r:<init>	()V
    //   136: astore 8
    //   138: aload 8
    //   140: lload_1
    //   141: putfield 527	com/tencent/mm/plugin/finder/storage/r:field_localId	J
    //   144: aload 8
    //   146: aload_3
    //   147: putfield 569	com/tencent/mm/plugin/finder/storage/r:field_contextObj	Lcom/tencent/mm/protocal/protobuf/bid;
    //   150: aload 8
    //   152: iconst_1
    //   153: putfield 573	com/tencent/mm/plugin/finder/storage/r:field_likeAction	I
    //   156: aload 8
    //   158: iconst_2
    //   159: putfield 576	com/tencent/mm/plugin/finder/storage/r:field_scene	I
    //   162: aload 8
    //   164: iload 5
    //   166: putfield 579	com/tencent/mm/plugin/finder/storage/r:field_showTips	Z
    //   169: aload 8
    //   171: iload 6
    //   173: putfield 540	com/tencent/mm/plugin/finder/storage/r:field_isPrivate	Z
    //   176: aload_0
    //   177: getfield 203	com/tencent/mm/plugin/finder/upload/action/l:ACh	Ljava/util/HashMap;
    //   180: checkcast 304	java/util/Map
    //   183: lload_1
    //   184: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   187: aload 8
    //   189: invokeinterface 322 3 0
    //   194: pop
    //   195: ldc_w 472
    //   198: invokestatic 478	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   201: checkcast 472	com/tencent/mm/plugin/finder/PluginFinder
    //   204: invokevirtual 482	com/tencent/mm/plugin/finder/PluginFinder:getLocalLikeFeedStorage	()Lcom/tencent/mm/plugin/finder/storage/s;
    //   207: aload 8
    //   209: invokevirtual 582	com/tencent/mm/plugin/finder/storage/s:a	(Lcom/tencent/mm/plugin/finder/storage/r;)Z
    //   212: pop
    //   213: getstatic 144	com/tencent/mm/plugin/finder/upload/action/l:TAG	Ljava/lang/String;
    //   216: new 240	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 584
    //   223: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: lload_1
    //   227: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   230: ldc_w 561
    //   233: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: iload 4
    //   238: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   241: ldc_w 563
    //   244: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: iload 6
    //   249: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   252: ldc_w 586
    //   255: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 276	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: ldc_w 557
    //   267: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_0
    //   271: monitorexit
    //   272: return
    //   273: aload_0
    //   274: getfield 203	com/tencent/mm/plugin/finder/upload/action/l:ACh	Ljava/util/HashMap;
    //   277: lload_1
    //   278: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   281: invokevirtual 535	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   284: ifeq -71 -> 213
    //   287: aload_0
    //   288: getfield 203	com/tencent/mm/plugin/finder/upload/action/l:ACh	Ljava/util/HashMap;
    //   291: lload_1
    //   292: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   295: invokevirtual 588	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   298: pop
    //   299: ldc_w 472
    //   302: invokestatic 478	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   305: checkcast 472	com/tencent/mm/plugin/finder/PluginFinder
    //   308: invokevirtual 482	com/tencent/mm/plugin/finder/PluginFinder:getLocalLikeFeedStorage	()Lcom/tencent/mm/plugin/finder/storage/s;
    //   311: astore_3
    //   312: aload_3
    //   313: getfield 488	com/tencent/mm/plugin/finder/storage/s:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   316: aload_3
    //   317: invokevirtual 591	com/tencent/mm/plugin/finder/storage/s:getTableName	()Ljava/lang/String;
    //   320: ldc_w 593
    //   323: iconst_1
    //   324: anewarray 595	java/lang/String
    //   327: dup
    //   328: iconst_0
    //   329: lload_1
    //   330: invokestatic 598	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   333: aastore
    //   334: invokeinterface 602 4 0
    //   339: istore 7
    //   341: getstatic 518	com/tencent/mm/plugin/finder/storage/s:TAG	Ljava/lang/String;
    //   344: new 240	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 604
    //   351: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: lload_1
    //   355: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   358: ldc_w 606
    //   361: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 7
    //   366: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 276	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: goto -162 -> 213
    //   378: astore_3
    //   379: aload_0
    //   380: monitorexit
    //   381: aload_3
    //   382: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	l
    //   0	383	1	paramLong	long
    //   0	383	3	parambid	com.tencent.mm.protocal.protobuf.bid
    //   0	383	4	paramBoolean1	boolean
    //   0	383	5	paramBoolean2	boolean
    //   0	383	6	paramBoolean3	boolean
    //   339	26	7	i	int
    //   112	96	8	localr	r
    // Exception table:
    //   from	to	target	type
    //   2	79	378	finally
    //   84	114	378	finally
    //   119	129	378	finally
    //   129	213	378	finally
    //   213	270	378	finally
    //   273	375	378	finally
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(167816);
    p.k(paramk, "action");
    k localk = (k)this.ABA.get(Long.valueOf(paramk.feedId));
    if (localk != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramk).append(" result ");
        if (paramk.ABL < localk.ABL) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if (paramk.ABL >= localk.ABL) {
          this.ABA.remove(Long.valueOf(paramk.feedId));
        }
        AppMethodBeat.o(167816);
        return;
      }
    }
    AppMethodBeat.o(167816);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(167817);
    p.k(paramn, "action");
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.ACg.get(Long.valueOf(paramn.feedId));
    if (localConcurrentHashMap != null)
    {
      c localc = new c(paramn.ACo.dYY().commentId, paramn.scene);
      n localn = (n)localConcurrentHashMap.get(localc);
      if (localn != null)
      {
        String str;
        StringBuilder localStringBuilder;
        if (BuildInfo.DEBUG)
        {
          str = TAG;
          localStringBuilder = new StringBuilder("removeLikeCommentCache ").append(paramn).append(" result ");
          if (paramn.ABL < localn.ABL) {
            break label163;
          }
        }
        label163:
        for (boolean bool = true;; bool = false)
        {
          Log.i(str, bool);
          if (paramn.ABL >= localn.ABL) {
            localConcurrentHashMap.remove(localc);
          }
          AppMethodBeat.o(167817);
          return;
        }
      }
      AppMethodBeat.o(167817);
      return;
    }
    AppMethodBeat.o(167817);
  }
  
  public final boolean a(long paramLong, am paramam, int paramInt)
  {
    AppMethodBeat.i(167814);
    p.k(paramam, "commentObj");
    if (paramLong == 0L)
    {
      if (paramam.dYY().likeFlag == 1)
      {
        AppMethodBeat.o(167814);
        return true;
      }
      AppMethodBeat.o(167814);
      return false;
    }
    boolean bool;
    Object localObject;
    if (paramam.dYY().likeFlag == 1)
    {
      bool = true;
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUh().aSr()).intValue() == 1) {
        break label299;
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (com.tencent.mm.plugin.finder.storage.d.dTj() != 1) {
        break label299;
      }
      localObject = (ConcurrentHashMap)this.ACg.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label291;
      }
      localObject = (n)((ConcurrentHashMap)localObject).get(new c(paramam.dYY().commentId, 1));
      if (localObject == null) {
        break label291;
      }
      bool = ((n)localObject).ACe;
      localObject = "" + " get from cache " + ((n)localObject).ACe + ' ';
    }
    for (;;)
    {
      if (BuildInfo.DEBUG) {
        Log.i(TAG, "isCommentLike test " + paramLong + " commentObj:" + paramam + " cache:" + (String)localObject + " likeFlag:" + paramam.dYY().likeFlag + " scene:" + paramInt + " result:" + bool);
      }
      AppMethodBeat.o(167814);
      return bool;
      bool = false;
      break;
      label291:
      localObject = "";
      continue;
      label299:
      localObject = (ConcurrentHashMap)this.ACg.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (n)((ConcurrentHashMap)localObject).get(new c(paramam.dYY().commentId, paramInt));
        if (localObject != null)
        {
          bool = ((n)localObject).ACe;
          localObject = "" + " get from cache " + ((n)localObject).ACe + ' ';
          continue;
        }
      }
      localObject = "";
    }
  }
  
  public final int b(long paramLong, am paramam, int paramInt)
  {
    AppMethodBeat.i(167815);
    p.k(paramam, "commentObj");
    if (paramLong == 0L)
    {
      paramInt = paramam.dYY().likeCount;
      AppMethodBeat.o(167815);
      return paramInt;
    }
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (paramam.dYY().likeFlag == 1)
    {
      bool1 = true;
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUh().aSr()).intValue() == 1) {
        break label187;
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (com.tencent.mm.plugin.finder.storage.d.dTj() != 1) {
        break label187;
      }
      localObject = (ConcurrentHashMap)this.ACg.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label180;
      }
      localObject = (n)((ConcurrentHashMap)localObject).get(new c(paramam.dYY().commentId, 1));
      if (localObject == null) {
        break label180;
      }
      bool2 = ((n)localObject).ACe;
    }
    for (;;)
    {
      if ((!bool1) || (bool1 == bool2)) {
        break label256;
      }
      paramInt = paramam.dYY().likeCount;
      AppMethodBeat.o(167815);
      return paramInt - 1;
      bool1 = false;
      break;
      label180:
      bool2 = bool1;
      continue;
      label187:
      localObject = (ConcurrentHashMap)this.ACg.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (n)((ConcurrentHashMap)localObject).get(new c(paramam.dYY().commentId, paramInt));
        if (localObject != null)
        {
          bool2 = ((n)localObject).ACe;
          continue;
        }
      }
      bool2 = bool1;
    }
    label256:
    if ((!bool1) && (bool1 != bool2))
    {
      paramInt = paramam.dYY().likeCount;
      AppMethodBeat.o(167815);
      return paramInt + 1;
    }
    paramInt = paramam.dYY().likeCount;
    AppMethodBeat.o(167815);
    return paramInt;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(275108);
    p.k(paramk, "action");
    k localk = (k)this.ABB.get(Long.valueOf(paramk.feedId));
    if (localk != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramk).append(" result ");
        if (paramk.ABL < localk.ABL) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if (paramk.ABL >= localk.ABL) {
          this.ABB.remove(Long.valueOf(paramk.feedId));
        }
        AppMethodBeat.o(275108);
        return;
      }
    }
    AppMethodBeat.o(275108);
  }
  
  public final void ebY()
  {
    AppMethodBeat.i(167818);
    e locale;
    boolean bool;
    do
    {
      if (this.ABz.size() <= 0)
      {
        AppMethodBeat.o(167818);
        return;
      }
      locale = (e)this.ABz.poll();
      bool = locale.isValid();
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.ABz.size());
    } while (!bool);
    p.j(locale, "action");
    a(locale);
    AppMethodBeat.o(167818);
  }
  
  public final o<Boolean, Boolean> r(FinderObject paramFinderObject)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(275099);
    p.k(paramFinderObject, "feed");
    boolean bool1;
    if (paramFinderObject.id == 0L)
    {
      if (paramFinderObject.likeFlag != 0)
      {
        bool1 = true;
        if (paramFinderObject.likeFlag != 2) {
          break label73;
        }
      }
      for (;;)
      {
        paramFinderObject = new o(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
        AppMethodBeat.o(275099);
        return paramFinderObject;
        bool1 = false;
        break;
        label73:
        bool2 = false;
      }
    }
    label98:
    String str;
    StringBuilder localStringBuilder;
    if (paramFinderObject.likeFlag != 0)
    {
      bool1 = true;
      if (paramFinderObject.likeFlag != 2) {
        break label271;
      }
      bool2 = bool3;
      localObject = (k)this.ABA.get(Long.valueOf(paramFinderObject.id));
      if (localObject != null)
      {
        bool1 = ((k)localObject).ACe;
        bool2 = ((k)localObject).ABX;
      }
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
        localObject = (k)this.ABA.get(Long.valueOf(paramFinderObject.id));
        if (localObject == null) {
          break label276;
        }
      }
    }
    label271:
    label276:
    for (Object localObject = Boolean.valueOf(((k)localObject).ACe);; localObject = null)
    {
      Log.i(str, localObject + " likeFlag:" + paramFinderObject.likeFlag + " result:" + bool1);
      paramFinderObject = new o(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      AppMethodBeat.o(275099);
      return paramFinderObject;
      bool1 = false;
      break;
      bool2 = false;
      break label98;
    }
  }
  
  public final int s(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167813);
    p.k(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.likeCount;
      AppMethodBeat.o(167813);
      return i;
    }
    boolean bool1;
    k localk;
    if (paramFinderObject.likeFlag != 0)
    {
      bool1 = true;
      localk = (k)this.ABA.get(Long.valueOf(paramFinderObject.id));
      if (localk == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool2 = localk.ACe;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label111;
      }
      i = paramFinderObject.likeCount;
      AppMethodBeat.o(167813);
      return i - 1;
      bool1 = false;
      break;
    }
    label111:
    if ((!bool1) && (bool2))
    {
      i = paramFinderObject.likeCount;
      AppMethodBeat.o(167813);
      return i + 1;
    }
    int i = paramFinderObject.likeCount;
    AppMethodBeat.o(167813);
    return i;
  }
  
  public final int t(FinderObject paramFinderObject)
  {
    int j = 1;
    AppMethodBeat.i(275100);
    p.k(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(275100);
      return i;
    }
    if (paramFinderObject.likeFlag == 1)
    {
      i = 1;
      k localk = (k)this.ABA.get(Long.valueOf(paramFinderObject.id));
      if (localk == null) {
        break label121;
      }
      if ((!localk.ACe) || (localk.ABX)) {
        break label116;
      }
    }
    for (;;)
    {
      if ((i == 0) || (i == j)) {
        break label126;
      }
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(275100);
      return i - 1;
      i = 0;
      break;
      label116:
      j = 0;
      continue;
      label121:
      j = i;
    }
    label126:
    if ((i == 0) && (i != j))
    {
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(275100);
      return i + 1;
    }
    int i = paramFinderObject.friendLikeCount;
    AppMethodBeat.o(275100);
    return i;
  }
  
  public final LinkedList<FinderCommentInfo> u(FinderObject paramFinderObject)
  {
    int j = 1;
    AppMethodBeat.i(275101);
    p.k(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      paramFinderObject = paramFinderObject.likeList;
      p.j(paramFinderObject, "feed.likeList");
      AppMethodBeat.o(275101);
      return paramFinderObject;
    }
    int i;
    if (paramFinderObject.likeFlag == 1)
    {
      i = 1;
      k localk = (k)this.ABA.get(Long.valueOf(paramFinderObject.id));
      if (localk == null) {
        break label138;
      }
      if ((!localk.ACe) || (localk.ABX)) {
        break label133;
      }
    }
    for (;;)
    {
      if ((i == 0) || (i == j)) {
        break label143;
      }
      paramFinderObject = paramFinderObject.likeList;
      p.j(paramFinderObject, "feed.likeList");
      paramFinderObject = aY(paramFinderObject);
      AppMethodBeat.o(275101);
      return paramFinderObject;
      i = 0;
      break;
      label133:
      j = 0;
      continue;
      label138:
      j = i;
    }
    label143:
    if ((i == 0) && (i != j))
    {
      paramFinderObject = paramFinderObject.likeList;
      p.j(paramFinderObject, "feed.likeList");
      paramFinderObject = aW(paramFinderObject);
      AppMethodBeat.o(275101);
      return paramFinderObject;
    }
    paramFinderObject = paramFinderObject.likeList;
    p.j(paramFinderObject, "feed.likeList");
    AppMethodBeat.o(275101);
    return paramFinderObject;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "", "onLikeFail", "", "errType", "", "errCode", "errMsg", "", "plugin-finder_release"})
  public static abstract interface b {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "", "id", "", "scene", "", "(JI)V", "getId", "()J", "getScene", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"})
  public static final class c
  {
    private final long id;
    private final int scene;
    
    public c(long paramLong, int paramInt)
    {
      this.id = paramLong;
      this.scene = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {
        paramObject = null;
      }
      for (;;)
      {
        paramObject = (c)paramObject;
        if (paramObject == null) {
          return false;
        }
        return (paramObject.id == this.id) && (paramObject.scene == this.scene);
      }
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(167809);
      int i = (this.id + '_' + this.scene).hashCode();
      AppMethodBeat.o(167809);
      return i;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/upload/action/LikeActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<m>
  {
    d(e parame) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<FinderCommentInfo, Boolean>
  {
    public static final e ACl;
    
    static
    {
      AppMethodBeat.i(254428);
      ACl = new e();
      AppMethodBeat.o(254428);
    }
    
    e()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(167811);
      this.ACk.ebY();
      AppMethodBeat.o(167811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.l
 * JD-Core Version:    0.7.0.1
 */
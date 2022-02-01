package com.tencent.mm.plugin.finder.upload.action;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "feedCommentLikeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "feedMap", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "localFeedLikeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "Lkotlin/collections/HashMap;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "addSelf", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "likeList", "addSelfInto", "", "newList", "commentLikeCount", "", "feedId", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "scene", "doLike", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "isPrivate", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doLikeComment", "objectNonceId", "", "comment", "isPoster", "doLikeLocalFeed", "localId", "doPost", "action", "friendLikeCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "friendLikeList", "isCommentLike", "isLike", "Lkotlin/Pair;", "isLocalFeedLike", "isWxScene", "likeCount", "likeLocalFeed", "likeAction", "showTips", "removeLikeCache", "removeLikeCommentCache", "removeLocalLikeFeed", "removeSelf", "removeSelfFrom", "removeUnuseAction", "restoreLocalLikeFeed", "saveLocalLikeFeed", "tryNext", "Companion", "ILikeActionCallback", "KeyData", "plugin-finder_release"})
public final class g
{
  public static final String TAG = "Finder.FinderLikeActionMgr";
  private static final g sVu;
  public static final a sVv;
  private com.tencent.mm.loader.g.d<h> sTM;
  private final Runnable sTN;
  private final ConcurrentLinkedQueue<e> sVc;
  private final ConcurrentHashMap<Long, f> sVd;
  private final ConcurrentHashMap<Long, ConcurrentHashMap<c, i>> sVs;
  public final HashMap<Long, com.tencent.mm.plugin.finder.storage.o> sVt;
  
  static
  {
    AppMethodBeat.i(167823);
    sVv = new a((byte)0);
    TAG = "Finder.FinderLikeActionMgr";
    sVu = new g();
    AppMethodBeat.o(167823);
  }
  
  public g()
  {
    AppMethodBeat.i(167822);
    this.sTM = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finder_action_like_post_quene"));
    cNy();
    this.sVc = new ConcurrentLinkedQueue();
    this.sVd = new ConcurrentHashMap();
    this.sVs = new ConcurrentHashMap();
    this.sVt = new HashMap();
    this.sTN = ((Runnable)new f(this));
    AppMethodBeat.o(167822);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(167821);
    this.sTM.a((com.tencent.mm.loader.g.c)new h(parame), (com.tencent.mm.loader.g.f)new d(this, parame));
    AppMethodBeat.o(167821);
  }
  
  private static LinkedList<FinderCommentInfo> ak(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(204996);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    al(localLinkedList);
    AppMethodBeat.o(204996);
    return localLinkedList;
  }
  
  public static void al(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(204997);
    d.g.b.p.h(paramLinkedList, "newList");
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!d.g.b.p.i(((FinderCommentInfo)localObject).username, v.aAC()));
    for (;;)
    {
      if ((FinderCommentInfo)localObject == null)
      {
        localObject = new FinderCommentInfo();
        ((FinderCommentInfo)localObject).username = v.aAC();
        ((FinderCommentInfo)localObject).nickname = v.aAE();
        ((FinderCommentInfo)localObject).headUrl = "";
        paramLinkedList.add(0, localObject);
      }
      AppMethodBeat.o(204997);
      return;
      localObject = null;
    }
  }
  
  private static LinkedList<FinderCommentInfo> am(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(204998);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    an(localLinkedList);
    AppMethodBeat.o(204998);
    return localLinkedList;
  }
  
  public static void an(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(204999);
    d.g.b.p.h(paramLinkedList, "newList");
    com.tencent.mm.ac.c.a(paramLinkedList, (d.g.a.b)e.sVx);
    AppMethodBeat.o(204999);
  }
  
  private final void cNy()
  {
    AppMethodBeat.i(205004);
    Object localObject;
    try
    {
      localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getLocalLikeFeedStorage();
      ArrayList localArrayList = new ArrayList();
      localObject = ((com.tencent.mm.plugin.finder.storage.p)localObject).db.rawQuery("select * from FinderLocalOperation", null);
      if (localObject != null)
      {
        while (((Cursor)localObject).moveToNext())
        {
          com.tencent.mm.plugin.finder.storage.o localo = new com.tencent.mm.plugin.finder.storage.o();
          localo.convertFrom((Cursor)localObject);
          localArrayList.add(localo);
        }
        ((Cursor)localObject).close();
      }
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace(TAG, localThrowable, "restoreLocalLikeFeed", new Object[0]);
      AppMethodBeat.o(205004);
      return;
    }
    ae.i(com.tencent.mm.plugin.finder.storage.p.TAG, "getAllData size:" + localThrowable.size());
    Iterator localIterator = ((Iterable)localThrowable).iterator();
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.mm.plugin.finder.storage.o)localIterator.next();
      ((Map)this.sVt).put(Long.valueOf(((com.tencent.mm.plugin.finder.storage.o)localObject).field_localId), localObject);
    }
    AppMethodBeat.o(205004);
  }
  
  /* Error */
  public final void a(long paramLong, com.tencent.mm.protocal.protobuf.arn paramarn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 511
    //   5: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_3
    //   9: ldc 228
    //   11: invokestatic 226	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: getstatic 136	com/tencent/mm/plugin/finder/upload/action/g:TAG	Ljava/lang/String;
    //   17: new 230	java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w 513
    //   24: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: lload_1
    //   28: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   31: ldc_w 515
    //   34: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 4
    //   39: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: ldc_w 517
    //   45: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 6
    //   50: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 519
    //   56: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sVt	Ljava/util/HashMap;
    //   63: lload_1
    //   64: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: invokevirtual 522	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   70: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   73: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 266	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iload 4
    //   81: ifeq +192 -> 273
    //   84: aload_0
    //   85: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sVt	Ljava/util/HashMap;
    //   88: lload_1
    //   89: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 522	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   95: ifeq +34 -> 129
    //   98: aload_0
    //   99: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sVt	Ljava/util/HashMap;
    //   102: lload_1
    //   103: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: invokevirtual 523	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 483	com/tencent/mm/plugin/finder/storage/o
    //   112: astore 8
    //   114: aload 8
    //   116: ifnull +13 -> 129
    //   119: aload 8
    //   121: getfield 527	com/tencent/mm/plugin/finder/storage/o:field_isPrivate	Z
    //   124: iload 6
    //   126: if_icmpeq +87 -> 213
    //   129: new 483	com/tencent/mm/plugin/finder/storage/o
    //   132: dup
    //   133: invokespecial 484	com/tencent/mm/plugin/finder/storage/o:<init>	()V
    //   136: astore 8
    //   138: aload 8
    //   140: lload_1
    //   141: putfield 507	com/tencent/mm/plugin/finder/storage/o:field_localId	J
    //   144: aload 8
    //   146: aload_3
    //   147: putfield 531	com/tencent/mm/plugin/finder/storage/o:field_contextObj	Lcom/tencent/mm/protocal/protobuf/arn;
    //   150: aload 8
    //   152: iconst_1
    //   153: putfield 535	com/tencent/mm/plugin/finder/storage/o:field_likeAction	I
    //   156: aload 8
    //   158: iconst_2
    //   159: putfield 538	com/tencent/mm/plugin/finder/storage/o:field_scene	I
    //   162: aload 8
    //   164: iload 5
    //   166: putfield 541	com/tencent/mm/plugin/finder/storage/o:field_showTips	Z
    //   169: aload 8
    //   171: iload 6
    //   173: putfield 527	com/tencent/mm/plugin/finder/storage/o:field_isPrivate	Z
    //   176: aload_0
    //   177: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sVt	Ljava/util/HashMap;
    //   180: checkcast 294	java/util/Map
    //   183: lload_1
    //   184: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   187: aload 8
    //   189: invokeinterface 312 3 0
    //   194: pop
    //   195: ldc_w 452
    //   198: invokestatic 458	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   201: checkcast 452	com/tencent/mm/plugin/finder/PluginFinder
    //   204: invokevirtual 462	com/tencent/mm/plugin/finder/PluginFinder:getLocalLikeFeedStorage	()Lcom/tencent/mm/plugin/finder/storage/p;
    //   207: aload 8
    //   209: invokevirtual 544	com/tencent/mm/plugin/finder/storage/p:a	(Lcom/tencent/mm/plugin/finder/storage/o;)Z
    //   212: pop
    //   213: getstatic 136	com/tencent/mm/plugin/finder/upload/action/g:TAG	Ljava/lang/String;
    //   216: new 230	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 546
    //   223: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: lload_1
    //   227: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   230: ldc_w 515
    //   233: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: iload 4
    //   238: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   241: ldc_w 517
    //   244: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: iload 6
    //   249: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   252: ldc_w 548
    //   255: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 266	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: ldc_w 511
    //   267: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_0
    //   271: monitorexit
    //   272: return
    //   273: aload_0
    //   274: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sVt	Ljava/util/HashMap;
    //   277: lload_1
    //   278: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   281: invokevirtual 522	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   284: ifeq -71 -> 213
    //   287: aload_0
    //   288: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sVt	Ljava/util/HashMap;
    //   291: lload_1
    //   292: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   295: invokevirtual 550	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   298: pop
    //   299: ldc_w 452
    //   302: invokestatic 458	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   305: checkcast 452	com/tencent/mm/plugin/finder/PluginFinder
    //   308: invokevirtual 462	com/tencent/mm/plugin/finder/PluginFinder:getLocalLikeFeedStorage	()Lcom/tencent/mm/plugin/finder/storage/p;
    //   311: astore_3
    //   312: aload_3
    //   313: getfield 468	com/tencent/mm/plugin/finder/storage/p:db	Lcom/tencent/mm/sdk/e/e;
    //   316: aload_3
    //   317: invokevirtual 553	com/tencent/mm/plugin/finder/storage/p:getTableName	()Ljava/lang/String;
    //   320: ldc_w 555
    //   323: iconst_1
    //   324: anewarray 557	java/lang/String
    //   327: dup
    //   328: iconst_0
    //   329: lload_1
    //   330: invokestatic 560	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   333: aastore
    //   334: invokeinterface 564 4 0
    //   339: istore 7
    //   341: getstatic 498	com/tencent/mm/plugin/finder/storage/p:TAG	Ljava/lang/String;
    //   344: new 230	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 566
    //   351: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: lload_1
    //   355: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   358: ldc_w 568
    //   361: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 7
    //   366: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 266	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: goto -162 -> 213
    //   378: astore_3
    //   379: aload_0
    //   380: monitorexit
    //   381: aload_3
    //   382: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	g
    //   0	383	1	paramLong	long
    //   0	383	3	paramarn	com.tencent.mm.protocal.protobuf.arn
    //   0	383	4	paramBoolean1	boolean
    //   0	383	5	paramBoolean2	boolean
    //   0	383	6	paramBoolean3	boolean
    //   339	26	7	i	int
    //   112	96	8	localo	com.tencent.mm.plugin.finder.storage.o
    // Exception table:
    //   from	to	target	type
    //   2	79	378	finally
    //   84	114	378	finally
    //   119	129	378	finally
    //   129	213	378	finally
    //   213	270	378	finally
    //   273	375	378	finally
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(167816);
    d.g.b.p.h(paramf, "action");
    f localf = (f)this.sVd.get(Long.valueOf(paramf.duw));
    if (localf != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (j.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramf).append(" result ");
        if (paramf.sVn < localf.sVn) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        ae.i(str, bool);
        if (paramf.sVn >= localf.sVn) {
          this.sVd.remove(Long.valueOf(paramf.duw));
        }
        AppMethodBeat.o(167816);
        return;
      }
    }
    AppMethodBeat.o(167816);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(167817);
    d.g.b.p.h(parami, "action");
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.sVs.get(Long.valueOf(parami.duw));
    if (localConcurrentHashMap != null)
    {
      c localc = new c(parami.sVA.cLl().commentId, parami.scene);
      i locali = (i)localConcurrentHashMap.get(localc);
      if (locali != null)
      {
        String str;
        StringBuilder localStringBuilder;
        if (j.DEBUG)
        {
          str = TAG;
          localStringBuilder = new StringBuilder("removeLikeCommentCache ").append(parami).append(" result ");
          if (parami.sVn < locali.sVn) {
            break label163;
          }
        }
        label163:
        for (boolean bool = true;; bool = false)
        {
          ae.i(str, bool);
          if (parami.sVn >= locali.sVn) {
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
  
  public final boolean a(long paramLong, ab paramab, int paramInt)
  {
    AppMethodBeat.i(167814);
    d.g.b.p.h(paramab, "commentObj");
    if (paramLong == 0L)
    {
      if (paramab.cLl().likeFlag == 1)
      {
        AppMethodBeat.o(167814);
        return true;
      }
      AppMethodBeat.o(167814);
      return false;
    }
    boolean bool;
    Object localObject;
    if (paramab.cLl().likeFlag == 1)
    {
      bool = true;
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cJa().value()).intValue() == 1) {
        break label299;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cIj() != 1) {
        break label299;
      }
      localObject = (ConcurrentHashMap)this.sVs.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label291;
      }
      localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramab.cLl().commentId, 1));
      if (localObject == null) {
        break label291;
      }
      bool = ((i)localObject).sVp;
      localObject = "" + " get from cache " + ((i)localObject).sVp + ' ';
    }
    for (;;)
    {
      if (j.DEBUG) {
        ae.i(TAG, "isCommentLike test " + paramLong + " commentObj:" + paramab + " cache:" + (String)localObject + " likeFlag:" + paramab.cLl().likeFlag + " scene:" + paramInt + " result:" + bool);
      }
      AppMethodBeat.o(167814);
      return bool;
      bool = false;
      break;
      label291:
      localObject = "";
      continue;
      label299:
      localObject = (ConcurrentHashMap)this.sVs.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramab.cLl().commentId, paramInt));
        if (localObject != null)
        {
          bool = ((i)localObject).sVp;
          localObject = "" + " get from cache " + ((i)localObject).sVp + ' ';
          continue;
        }
      }
      localObject = "";
    }
  }
  
  public final int b(long paramLong, ab paramab, int paramInt)
  {
    AppMethodBeat.i(167815);
    d.g.b.p.h(paramab, "commentObj");
    if (paramLong == 0L)
    {
      paramInt = paramab.cLl().likeCount;
      AppMethodBeat.o(167815);
      return paramInt;
    }
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (paramab.cLl().likeFlag == 1)
    {
      bool1 = true;
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cJa().value()).intValue() == 1) {
        break label187;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (com.tencent.mm.plugin.finder.storage.b.cIj() != 1) {
        break label187;
      }
      localObject = (ConcurrentHashMap)this.sVs.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label180;
      }
      localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramab.cLl().commentId, 1));
      if (localObject == null) {
        break label180;
      }
      bool2 = ((i)localObject).sVp;
    }
    for (;;)
    {
      if ((!bool1) || (bool1 == bool2)) {
        break label256;
      }
      paramInt = paramab.cLl().likeCount;
      AppMethodBeat.o(167815);
      return paramInt - 1;
      bool1 = false;
      break;
      label180:
      bool2 = bool1;
      continue;
      label187:
      localObject = (ConcurrentHashMap)this.sVs.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramab.cLl().commentId, paramInt));
        if (localObject != null)
        {
          bool2 = ((i)localObject).sVp;
          continue;
        }
      }
      bool2 = bool1;
    }
    label256:
    if ((!bool1) && (bool1 != bool2))
    {
      paramInt = paramab.cLl().likeCount;
      AppMethodBeat.o(167815);
      return paramInt + 1;
    }
    paramInt = paramab.cLl().likeCount;
    AppMethodBeat.o(167815);
    return paramInt;
  }
  
  public final void cNf()
  {
    AppMethodBeat.i(167818);
    e locale;
    boolean bool;
    do
    {
      if (this.sVc.size() <= 0)
      {
        AppMethodBeat.o(167818);
        return;
      }
      locale = (e)this.sVc.poll();
      bool = locale.isValid();
      ae.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.sVc.size());
    } while (!bool);
    d.g.b.p.g(locale, "action");
    a(locale);
    AppMethodBeat.o(167818);
  }
  
  public final d.o<Boolean, Boolean> k(FinderObject paramFinderObject)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(204993);
    d.g.b.p.h(paramFinderObject, "feed");
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
        paramFinderObject = new d.o(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
        AppMethodBeat.o(204993);
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
      localObject = (f)this.sVd.get(Long.valueOf(paramFinderObject.id));
      if (localObject != null)
      {
        bool1 = ((f)localObject).sVp;
        bool2 = ((f)localObject).sVq;
      }
      if (j.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
        localObject = (f)this.sVd.get(Long.valueOf(paramFinderObject.id));
        if (localObject == null) {
          break label276;
        }
      }
    }
    label271:
    label276:
    for (Object localObject = Boolean.valueOf(((f)localObject).sVp);; localObject = null)
    {
      ae.i(str, localObject + " likeFlag:" + paramFinderObject.likeFlag + " result:" + bool1);
      paramFinderObject = new d.o(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      AppMethodBeat.o(204993);
      return paramFinderObject;
      bool1 = false;
      break;
      bool2 = false;
      break label98;
    }
  }
  
  public final int l(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167813);
    d.g.b.p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.likeCount;
      AppMethodBeat.o(167813);
      return i;
    }
    boolean bool1;
    f localf;
    if (paramFinderObject.likeFlag != 0)
    {
      bool1 = true;
      localf = (f)this.sVd.get(Long.valueOf(paramFinderObject.id));
      if (localf == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool2 = localf.sVp;; bool2 = bool1)
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
  
  public final int m(FinderObject paramFinderObject)
  {
    int j = 1;
    AppMethodBeat.i(204994);
    d.g.b.p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(204994);
      return i;
    }
    if (paramFinderObject.likeFlag == 1)
    {
      i = 1;
      f localf = (f)this.sVd.get(Long.valueOf(paramFinderObject.id));
      if (localf == null) {
        break label121;
      }
      if ((!localf.sVp) || (localf.sVq)) {
        break label116;
      }
    }
    for (;;)
    {
      if ((i == 0) || (i == j)) {
        break label126;
      }
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(204994);
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
      AppMethodBeat.o(204994);
      return i + 1;
    }
    int i = paramFinderObject.friendLikeCount;
    AppMethodBeat.o(204994);
    return i;
  }
  
  public final LinkedList<FinderCommentInfo> n(FinderObject paramFinderObject)
  {
    int j = 1;
    AppMethodBeat.i(204995);
    d.g.b.p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      paramFinderObject = paramFinderObject.likeList;
      d.g.b.p.g(paramFinderObject, "feed.likeList");
      AppMethodBeat.o(204995);
      return paramFinderObject;
    }
    int i;
    if (paramFinderObject.likeFlag == 1)
    {
      i = 1;
      f localf = (f)this.sVd.get(Long.valueOf(paramFinderObject.id));
      if (localf == null) {
        break label138;
      }
      if ((!localf.sVp) || (localf.sVq)) {
        break label133;
      }
    }
    for (;;)
    {
      if ((i == 0) || (i == j)) {
        break label143;
      }
      paramFinderObject = paramFinderObject.likeList;
      d.g.b.p.g(paramFinderObject, "feed.likeList");
      paramFinderObject = am(paramFinderObject);
      AppMethodBeat.o(204995);
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
      d.g.b.p.g(paramFinderObject, "feed.likeList");
      paramFinderObject = ak(paramFinderObject);
      AppMethodBeat.o(204995);
      return paramFinderObject;
    }
    paramFinderObject = paramFinderObject.likeList;
    d.g.b.p.g(paramFinderObject, "feed.likeList");
    AppMethodBeat.o(204995);
    return paramFinderObject;
  }
  
  public final d.o<Boolean, Boolean> xD(long paramLong)
  {
    AppMethodBeat.i(205002);
    boolean bool2 = this.sVt.containsKey(Long.valueOf(paramLong));
    Object localObject = (com.tencent.mm.plugin.finder.storage.o)this.sVt.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (boolean bool1 = ((com.tencent.mm.plugin.finder.storage.o)localObject).field_isPrivate;; bool1 = false)
    {
      ae.i(TAG, "isLocalFeedLike " + paramLong + ", " + bool2);
      localObject = new d.o(Boolean.valueOf(bool2), Boolean.valueOf(bool1));
      AppMethodBeat.o(205002);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "", "onLikeFail", "", "errType", "", "errCode", "errMsg", "", "plugin-finder_release"})
  public static abstract interface b {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "", "id", "", "scene", "", "(JI)V", "getId", "()J", "getScene", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/upload/action/LikeActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<h>
  {
    d(e parame) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<FinderCommentInfo, Boolean>
  {
    public static final e sVx;
    
    static
    {
      AppMethodBeat.i(204992);
      sVx = new e();
      AppMethodBeat.o(204992);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(167811);
      this.sVw.cNf();
      AppMethodBeat.o(167811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.g
 * JD-Core Version:    0.7.0.1
 */
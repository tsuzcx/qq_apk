package com.tencent.mm.plugin.finder.upload.action;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "feedCommentLikeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "feedMap", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "localFeedLikeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "Lkotlin/collections/HashMap;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "addSelf", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "likeList", "addSelfInto", "", "newList", "commentLikeCount", "", "feedId", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "scene", "doLike", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "isPrivate", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doLikeComment", "objectNonceId", "", "comment", "isPoster", "doLikeLocalFeed", "localId", "doPost", "action", "friendLikeCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "friendLikeList", "isCommentLike", "isLike", "Lkotlin/Pair;", "isLocalFeedLike", "isWxScene", "likeCount", "likeLocalFeed", "likeAction", "showTips", "removeLikeCache", "removeLikeCommentCache", "removeLocalLikeFeed", "removeSelf", "removeSelfFrom", "removeUnuseAction", "restoreLocalLikeFeed", "saveLocalLikeFeed", "tryNext", "Companion", "ILikeActionCallback", "KeyData", "plugin-finder_release"})
public final class g
{
  public static final String TAG = "Finder.FinderLikeActionMgr";
  private static final g sKh;
  public static final a sKi;
  private com.tencent.mm.loader.g.d<h> sIA;
  private final Runnable sIB;
  private final ConcurrentLinkedQueue<e> sJP;
  private final ConcurrentHashMap<Long, f> sJQ;
  private final ConcurrentHashMap<Long, ConcurrentHashMap<c, i>> sKf;
  public final HashMap<Long, com.tencent.mm.plugin.finder.storage.o> sKg;
  
  static
  {
    AppMethodBeat.i(167823);
    sKi = new a((byte)0);
    TAG = "Finder.FinderLikeActionMgr";
    sKh = new g();
    AppMethodBeat.o(167823);
  }
  
  public g()
  {
    AppMethodBeat.i(167822);
    this.sIA = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finder_action_like_post_quene"));
    cKU();
    this.sJP = new ConcurrentLinkedQueue();
    this.sJQ = new ConcurrentHashMap();
    this.sKf = new ConcurrentHashMap();
    this.sKg = new HashMap();
    this.sIB = ((Runnable)new f(this));
    AppMethodBeat.o(167822);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(167821);
    this.sIA.a((com.tencent.mm.loader.g.c)new h(parame), (com.tencent.mm.loader.g.f)new d(this, parame));
    AppMethodBeat.o(167821);
  }
  
  private static LinkedList<FinderCommentInfo> ak(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(204378);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    al(localLinkedList);
    AppMethodBeat.o(204378);
    return localLinkedList;
  }
  
  public static void al(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(204379);
    d.g.b.p.h(paramLinkedList, "newList");
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!d.g.b.p.i(((FinderCommentInfo)localObject).username, u.aAm()));
    for (;;)
    {
      if ((FinderCommentInfo)localObject == null)
      {
        localObject = new FinderCommentInfo();
        ((FinderCommentInfo)localObject).username = u.aAm();
        ((FinderCommentInfo)localObject).nickname = u.aAo();
        ((FinderCommentInfo)localObject).headUrl = "";
        paramLinkedList.add(0, localObject);
      }
      AppMethodBeat.o(204379);
      return;
      localObject = null;
    }
  }
  
  private static LinkedList<FinderCommentInfo> am(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(204380);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    an(localLinkedList);
    AppMethodBeat.o(204380);
    return localLinkedList;
  }
  
  public static void an(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(204381);
    d.g.b.p.h(paramLinkedList, "newList");
    com.tencent.mm.ad.c.a(paramLinkedList, (d.g.a.b)e.sKk);
    AppMethodBeat.o(204381);
  }
  
  private final void cKU()
  {
    AppMethodBeat.i(204386);
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
      ad.printErrStackTrace(TAG, localThrowable, "restoreLocalLikeFeed", new Object[0]);
      AppMethodBeat.o(204386);
      return;
    }
    ad.i(com.tencent.mm.plugin.finder.storage.p.TAG, "getAllData size:" + localThrowable.size());
    Iterator localIterator = ((Iterable)localThrowable).iterator();
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.mm.plugin.finder.storage.o)localIterator.next();
      ((Map)this.sKg).put(Long.valueOf(((com.tencent.mm.plugin.finder.storage.o)localObject).field_localId), localObject);
    }
    AppMethodBeat.o(204386);
  }
  
  /* Error */
  public final void a(long paramLong, com.tencent.mm.protocal.protobuf.aqy paramaqy, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 508
    //   5: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_3
    //   9: ldc 228
    //   11: invokestatic 226	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: getstatic 136	com/tencent/mm/plugin/finder/upload/action/g:TAG	Ljava/lang/String;
    //   17: new 230	java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w 510
    //   24: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: lload_1
    //   28: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   31: ldc_w 512
    //   34: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 4
    //   39: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: ldc_w 514
    //   45: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 6
    //   50: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 516
    //   56: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sKg	Ljava/util/HashMap;
    //   63: lload_1
    //   64: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: invokevirtual 519	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   70: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   73: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 266	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iload 4
    //   81: ifeq +192 -> 273
    //   84: aload_0
    //   85: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sKg	Ljava/util/HashMap;
    //   88: lload_1
    //   89: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 519	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   95: ifeq +34 -> 129
    //   98: aload_0
    //   99: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sKg	Ljava/util/HashMap;
    //   102: lload_1
    //   103: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: invokevirtual 520	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 480	com/tencent/mm/plugin/finder/storage/o
    //   112: astore 8
    //   114: aload 8
    //   116: ifnull +13 -> 129
    //   119: aload 8
    //   121: getfield 524	com/tencent/mm/plugin/finder/storage/o:field_isPrivate	Z
    //   124: iload 6
    //   126: if_icmpeq +87 -> 213
    //   129: new 480	com/tencent/mm/plugin/finder/storage/o
    //   132: dup
    //   133: invokespecial 481	com/tencent/mm/plugin/finder/storage/o:<init>	()V
    //   136: astore 8
    //   138: aload 8
    //   140: lload_1
    //   141: putfield 504	com/tencent/mm/plugin/finder/storage/o:field_localId	J
    //   144: aload 8
    //   146: aload_3
    //   147: putfield 528	com/tencent/mm/plugin/finder/storage/o:field_contextObj	Lcom/tencent/mm/protocal/protobuf/aqy;
    //   150: aload 8
    //   152: iconst_1
    //   153: putfield 532	com/tencent/mm/plugin/finder/storage/o:field_likeAction	I
    //   156: aload 8
    //   158: iconst_2
    //   159: putfield 535	com/tencent/mm/plugin/finder/storage/o:field_scene	I
    //   162: aload 8
    //   164: iload 5
    //   166: putfield 538	com/tencent/mm/plugin/finder/storage/o:field_showTips	Z
    //   169: aload 8
    //   171: iload 6
    //   173: putfield 524	com/tencent/mm/plugin/finder/storage/o:field_isPrivate	Z
    //   176: aload_0
    //   177: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sKg	Ljava/util/HashMap;
    //   180: checkcast 294	java/util/Map
    //   183: lload_1
    //   184: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   187: aload 8
    //   189: invokeinterface 306 3 0
    //   194: pop
    //   195: ldc_w 449
    //   198: invokestatic 455	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   201: checkcast 449	com/tencent/mm/plugin/finder/PluginFinder
    //   204: invokevirtual 459	com/tencent/mm/plugin/finder/PluginFinder:getLocalLikeFeedStorage	()Lcom/tencent/mm/plugin/finder/storage/p;
    //   207: aload 8
    //   209: invokevirtual 541	com/tencent/mm/plugin/finder/storage/p:a	(Lcom/tencent/mm/plugin/finder/storage/o;)Z
    //   212: pop
    //   213: getstatic 136	com/tencent/mm/plugin/finder/upload/action/g:TAG	Ljava/lang/String;
    //   216: new 230	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 543
    //   223: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: lload_1
    //   227: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   230: ldc_w 512
    //   233: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: iload 4
    //   238: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   241: ldc_w 514
    //   244: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: iload 6
    //   249: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   252: ldc_w 545
    //   255: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 266	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: ldc_w 508
    //   267: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_0
    //   271: monitorexit
    //   272: return
    //   273: aload_0
    //   274: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sKg	Ljava/util/HashMap;
    //   277: lload_1
    //   278: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   281: invokevirtual 519	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   284: ifeq -71 -> 213
    //   287: aload_0
    //   288: getfield 193	com/tencent/mm/plugin/finder/upload/action/g:sKg	Ljava/util/HashMap;
    //   291: lload_1
    //   292: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   295: invokevirtual 547	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   298: pop
    //   299: ldc_w 449
    //   302: invokestatic 455	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   305: checkcast 449	com/tencent/mm/plugin/finder/PluginFinder
    //   308: invokevirtual 459	com/tencent/mm/plugin/finder/PluginFinder:getLocalLikeFeedStorage	()Lcom/tencent/mm/plugin/finder/storage/p;
    //   311: astore_3
    //   312: aload_3
    //   313: getfield 465	com/tencent/mm/plugin/finder/storage/p:db	Lcom/tencent/mm/sdk/e/e;
    //   316: aload_3
    //   317: invokevirtual 550	com/tencent/mm/plugin/finder/storage/p:getTableName	()Ljava/lang/String;
    //   320: ldc_w 552
    //   323: iconst_1
    //   324: anewarray 554	java/lang/String
    //   327: dup
    //   328: iconst_0
    //   329: lload_1
    //   330: invokestatic 557	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   333: aastore
    //   334: invokeinterface 561 4 0
    //   339: istore 7
    //   341: getstatic 495	com/tencent/mm/plugin/finder/storage/p:TAG	Ljava/lang/String;
    //   344: new 230	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 563
    //   351: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: lload_1
    //   355: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   358: ldc_w 565
    //   361: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 7
    //   366: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 266	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	383	3	paramaqy	com.tencent.mm.protocal.protobuf.aqy
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
    f localf = (f)this.sJQ.get(Long.valueOf(paramf.dtq));
    if (localf != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (com.tencent.mm.sdk.platformtools.i.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramf).append(" result ");
        if (paramf.sKa < localf.sKa) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        ad.i(str, bool);
        if (paramf.sKa >= localf.sKa) {
          this.sJQ.remove(Long.valueOf(paramf.dtq));
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
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.sKf.get(Long.valueOf(parami.dtq));
    if (localConcurrentHashMap != null)
    {
      c localc = new c(parami.sKn.cIG(), parami.scene);
      i locali = (i)localConcurrentHashMap.get(localc);
      if (locali != null)
      {
        String str;
        StringBuilder localStringBuilder;
        if (com.tencent.mm.sdk.platformtools.i.DEBUG)
        {
          str = TAG;
          localStringBuilder = new StringBuilder("removeLikeCommentCache ").append(parami).append(" result ");
          if (parami.sKa < locali.sKa) {
            break label160;
          }
        }
        label160:
        for (boolean bool = true;; bool = false)
        {
          ad.i(str, bool);
          if (parami.sKa >= locali.sKa) {
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
      if (paramab.getLikeFlag() == 1)
      {
        AppMethodBeat.o(167814);
        return true;
      }
      AppMethodBeat.o(167814);
      return false;
    }
    boolean bool;
    Object localObject;
    if (paramab.getLikeFlag() == 1)
    {
      bool = true;
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHb().value()).intValue() == 1) {
        break label287;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cGm() != 1) {
        break label287;
      }
      localObject = (ConcurrentHashMap)this.sKf.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label279;
      }
      localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramab.cIG(), 1));
      if (localObject == null) {
        break label279;
      }
      bool = ((i)localObject).sKc;
      localObject = "" + " get from cache " + ((i)localObject).sKc + ' ';
    }
    for (;;)
    {
      if (com.tencent.mm.sdk.platformtools.i.DEBUG) {
        ad.i(TAG, "isCommentLike test " + paramLong + " commentObj:" + paramab + " cache:" + (String)localObject + " likeFlag:" + paramab.getLikeFlag() + " scene:" + paramInt + " result:" + bool);
      }
      AppMethodBeat.o(167814);
      return bool;
      bool = false;
      break;
      label279:
      localObject = "";
      continue;
      label287:
      localObject = (ConcurrentHashMap)this.sKf.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramab.cIG(), paramInt));
        if (localObject != null)
        {
          bool = ((i)localObject).sKc;
          localObject = "" + " get from cache " + ((i)localObject).sKc + ' ';
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
      paramInt = paramab.getLikeCount();
      AppMethodBeat.o(167815);
      return paramInt;
    }
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (paramab.getLikeFlag() == 1)
    {
      bool1 = true;
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHb().value()).intValue() == 1) {
        break label175;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cGm() != 1) {
        break label175;
      }
      localObject = (ConcurrentHashMap)this.sKf.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label168;
      }
      localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramab.cIG(), 1));
      if (localObject == null) {
        break label168;
      }
      bool2 = ((i)localObject).sKc;
    }
    for (;;)
    {
      if ((!bool1) || (bool1 == bool2)) {
        break label241;
      }
      paramInt = paramab.getLikeCount();
      AppMethodBeat.o(167815);
      return paramInt - 1;
      bool1 = false;
      break;
      label168:
      bool2 = bool1;
      continue;
      label175:
      localObject = (ConcurrentHashMap)this.sKf.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramab.cIG(), paramInt));
        if (localObject != null)
        {
          bool2 = ((i)localObject).sKc;
          continue;
        }
      }
      bool2 = bool1;
    }
    label241:
    if ((!bool1) && (bool1 != bool2))
    {
      paramInt = paramab.getLikeCount();
      AppMethodBeat.o(167815);
      return paramInt + 1;
    }
    paramInt = paramab.getLikeCount();
    AppMethodBeat.o(167815);
    return paramInt;
  }
  
  public final void cKB()
  {
    AppMethodBeat.i(167818);
    e locale;
    boolean bool;
    do
    {
      if (this.sJP.size() <= 0)
      {
        AppMethodBeat.o(167818);
        return;
      }
      locale = (e)this.sJP.poll();
      bool = locale.isValid();
      ad.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.sJP.size());
    } while (!bool);
    d.g.b.p.g(locale, "action");
    a(locale);
    AppMethodBeat.o(167818);
  }
  
  public final d.o<Boolean, Boolean> k(FinderObject paramFinderObject)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(204375);
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
        AppMethodBeat.o(204375);
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
      localObject = (f)this.sJQ.get(Long.valueOf(paramFinderObject.id));
      if (localObject != null)
      {
        bool1 = ((f)localObject).sKc;
        bool2 = ((f)localObject).sKd;
      }
      if (com.tencent.mm.sdk.platformtools.i.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
        localObject = (f)this.sJQ.get(Long.valueOf(paramFinderObject.id));
        if (localObject == null) {
          break label276;
        }
      }
    }
    label271:
    label276:
    for (Object localObject = Boolean.valueOf(((f)localObject).sKc);; localObject = null)
    {
      ad.i(str, localObject + " likeFlag:" + paramFinderObject.likeFlag + " result:" + bool1);
      paramFinderObject = new d.o(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      AppMethodBeat.o(204375);
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
      localf = (f)this.sJQ.get(Long.valueOf(paramFinderObject.id));
      if (localf == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool2 = localf.sKc;; bool2 = bool1)
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
    AppMethodBeat.i(204376);
    d.g.b.p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(204376);
      return i;
    }
    if (paramFinderObject.likeFlag == 1)
    {
      i = 1;
      f localf = (f)this.sJQ.get(Long.valueOf(paramFinderObject.id));
      if (localf == null) {
        break label121;
      }
      if ((!localf.sKc) || (localf.sKd)) {
        break label116;
      }
    }
    for (;;)
    {
      if ((i == 0) || (i == j)) {
        break label126;
      }
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(204376);
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
      AppMethodBeat.o(204376);
      return i + 1;
    }
    int i = paramFinderObject.friendLikeCount;
    AppMethodBeat.o(204376);
    return i;
  }
  
  public final LinkedList<FinderCommentInfo> n(FinderObject paramFinderObject)
  {
    int j = 1;
    AppMethodBeat.i(204377);
    d.g.b.p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      paramFinderObject = paramFinderObject.likeList;
      d.g.b.p.g(paramFinderObject, "feed.likeList");
      AppMethodBeat.o(204377);
      return paramFinderObject;
    }
    int i;
    if (paramFinderObject.likeFlag == 1)
    {
      i = 1;
      f localf = (f)this.sJQ.get(Long.valueOf(paramFinderObject.id));
      if (localf == null) {
        break label138;
      }
      if ((!localf.sKc) || (localf.sKd)) {
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
      AppMethodBeat.o(204377);
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
      AppMethodBeat.o(204377);
      return paramFinderObject;
    }
    paramFinderObject = paramFinderObject.likeList;
    d.g.b.p.g(paramFinderObject, "feed.likeList");
    AppMethodBeat.o(204377);
    return paramFinderObject;
  }
  
  public final d.o<Boolean, Boolean> xm(long paramLong)
  {
    AppMethodBeat.i(204384);
    boolean bool2 = this.sKg.containsKey(Long.valueOf(paramLong));
    Object localObject = (com.tencent.mm.plugin.finder.storage.o)this.sKg.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (boolean bool1 = ((com.tencent.mm.plugin.finder.storage.o)localObject).field_isPrivate;; bool1 = false)
    {
      ad.i(TAG, "isLocalFeedLike " + paramLong + ", " + bool2);
      localObject = new d.o(Boolean.valueOf(bool2), Boolean.valueOf(bool1));
      AppMethodBeat.o(204384);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "", "onLikeFail", "", "errType", "", "errCode", "errMsg", "", "plugin-finder_release"})
  public static abstract interface b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "", "id", "", "scene", "", "(JI)V", "getId", "()J", "getScene", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/upload/action/LikeActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<h>
  {
    d(e parame) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<FinderCommentInfo, Boolean>
  {
    public static final e sKk;
    
    static
    {
      AppMethodBeat.i(204374);
      sKk = new e();
      AppMethodBeat.o(204374);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(167811);
      this.sKj.cKB();
      AppMethodBeat.o(167811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.g
 * JD-Core Version:    0.7.0.1
 */
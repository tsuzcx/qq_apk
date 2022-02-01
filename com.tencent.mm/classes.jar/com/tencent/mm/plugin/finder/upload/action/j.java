package com.tencent.mm.plugin.finder.upload.action;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.storage.v;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "feedCommentLikeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "feedMap", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "localFeedLikeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "Lkotlin/collections/HashMap;", "megaVideoMap", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "addSelf", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "likeList", "addSelfInto", "", "newList", "commentLikeCount", "", "feedId", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "scene", "doLike", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "isPrivate", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "doLikeComment", "objectNonceId", "", "comment", "isPoster", "doLikeLocalFeed", "localId", "doPost", "action", "friendLikeCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "friendLikeList", "isCommentLike", "isLike", "Lkotlin/Pair;", "isLocalFeedLike", "isMegaVideoLike", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "isWxScene", "likeCount", "likeLocalFeed", "likeAction", "showTips", "likeMegaVideoCount", "removeLikeCache", "removeLikeCommentCache", "removeLocalLikeFeed", "removeLongVideoLikeCache", "removeSelf", "removeSelfFrom", "removeUnuseAction", "restoreLocalLikeFeed", "saveLocalLikeFeed", "tryNext", "Companion", "ILikeActionCallback", "KeyData", "plugin-finder_release"})
public final class j
{
  public static final String TAG = "Finder.FinderLikeActionMgr";
  private static final j vUv;
  public static final a vUw;
  private com.tencent.mm.loader.g.d<k> vRJ;
  private final Runnable vRK;
  private final ConcurrentLinkedQueue<e> vTW;
  private final ConcurrentHashMap<Long, i> vTX;
  private final ConcurrentHashMap<Long, i> vTY;
  private final ConcurrentHashMap<Long, ConcurrentHashMap<c, l>> vUt;
  public final HashMap<Long, u> vUu;
  
  static
  {
    AppMethodBeat.i(167823);
    vUw = new a((byte)0);
    TAG = "Finder.FinderLikeActionMgr";
    vUv = new j();
    AppMethodBeat.o(167823);
  }
  
  public j()
  {
    AppMethodBeat.i(167822);
    this.vRJ = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finder_action_like_post_quene"));
    dBs();
    this.vTW = new ConcurrentLinkedQueue();
    this.vTX = new ConcurrentHashMap();
    this.vTY = new ConcurrentHashMap();
    this.vUt = new ConcurrentHashMap();
    this.vUu = new HashMap();
    this.vRK = ((Runnable)new f(this));
    AppMethodBeat.o(167822);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(167821);
    this.vRJ.a((com.tencent.mm.loader.g.c)new k(parame), (com.tencent.mm.loader.g.f)new d(this, parame));
    AppMethodBeat.o(167821);
  }
  
  private static LinkedList<FinderCommentInfo> aF(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(253224);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    aG(localLinkedList);
    AppMethodBeat.o(253224);
    return localLinkedList;
  }
  
  public static void aG(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(253225);
    p.h(paramLinkedList, "newList");
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.j(((FinderCommentInfo)localObject).username, z.aTY()));
    for (;;)
    {
      if ((FinderCommentInfo)localObject == null)
      {
        localObject = new FinderCommentInfo();
        ((FinderCommentInfo)localObject).username = z.aTY();
        ((FinderCommentInfo)localObject).nickname = z.aUa();
        ((FinderCommentInfo)localObject).headUrl = "";
        paramLinkedList.add(0, localObject);
      }
      AppMethodBeat.o(253225);
      return;
      localObject = null;
    }
  }
  
  private static LinkedList<FinderCommentInfo> aH(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(253226);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    aI(localLinkedList);
    AppMethodBeat.o(253226);
    return localLinkedList;
  }
  
  public static void aI(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(253227);
    p.h(paramLinkedList, "newList");
    com.tencent.mm.ac.d.a(paramLinkedList, (kotlin.g.a.b)e.vUy);
    AppMethodBeat.o(253227);
  }
  
  private final void dBs()
  {
    AppMethodBeat.i(253233);
    Object localObject;
    try
    {
      localObject = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getLocalLikeFeedStorage();
      ArrayList localArrayList = new ArrayList();
      localObject = ((v)localObject).db.rawQuery("select * from FinderLocalOperation", null);
      if (localObject != null)
      {
        while (((Cursor)localObject).moveToNext())
        {
          u localu = new u();
          localu.convertFrom((Cursor)localObject);
          localArrayList.add(localu);
        }
        ((Cursor)localObject).close();
      }
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace(TAG, localThrowable, "restoreLocalLikeFeed", new Object[0]);
      AppMethodBeat.o(253233);
      return;
    }
    Log.i(v.TAG, "getAllData size:" + localThrowable.size());
    Iterator localIterator = ((Iterable)localThrowable).iterator();
    while (localIterator.hasNext())
    {
      localObject = (u)localIterator.next();
      ((Map)this.vUu).put(Long.valueOf(((u)localObject).field_localId), localObject);
    }
    AppMethodBeat.o(253233);
  }
  
  public final o<Boolean, Boolean> Ga(long paramLong)
  {
    AppMethodBeat.i(253231);
    boolean bool2 = this.vUu.containsKey(Long.valueOf(paramLong));
    Object localObject = (u)this.vUu.get(Long.valueOf(paramLong));
    if (localObject != null) {}
    for (boolean bool1 = ((u)localObject).field_isPrivate;; bool1 = false)
    {
      Log.i(TAG, "isLocalFeedLike " + paramLong + ", " + bool2);
      localObject = new o(Boolean.valueOf(bool2), Boolean.valueOf(bool1));
      AppMethodBeat.o(253231);
      return localObject;
    }
  }
  
  /* Error */
  public final void a(long paramLong, com.tencent.mm.protocal.protobuf.bbn parambbn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 551
    //   5: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_3
    //   9: ldc 238
    //   11: invokestatic 236	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: getstatic 144	com/tencent/mm/plugin/finder/upload/action/j:TAG	Ljava/lang/String;
    //   17: new 240	java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w 553
    //   24: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: lload_1
    //   28: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   31: ldc_w 555
    //   34: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 4
    //   39: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: ldc_w 557
    //   45: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 6
    //   50: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 559
    //   56: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 203	com/tencent/mm/plugin/finder/upload/action/j:vUu	Ljava/util/HashMap;
    //   63: lload_1
    //   64: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: invokevirtual 529	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   70: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   73: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 276	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iload 4
    //   81: ifeq +192 -> 273
    //   84: aload_0
    //   85: getfield 203	com/tencent/mm/plugin/finder/upload/action/j:vUu	Ljava/util/HashMap;
    //   88: lload_1
    //   89: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 529	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   95: ifeq +34 -> 129
    //   98: aload_0
    //   99: getfield 203	com/tencent/mm/plugin/finder/upload/action/j:vUu	Ljava/util/HashMap;
    //   102: lload_1
    //   103: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   106: invokevirtual 530	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 497	com/tencent/mm/plugin/finder/storage/u
    //   112: astore 8
    //   114: aload 8
    //   116: ifnull +13 -> 129
    //   119: aload 8
    //   121: getfield 534	com/tencent/mm/plugin/finder/storage/u:field_isPrivate	Z
    //   124: iload 6
    //   126: if_icmpeq +87 -> 213
    //   129: new 497	com/tencent/mm/plugin/finder/storage/u
    //   132: dup
    //   133: invokespecial 498	com/tencent/mm/plugin/finder/storage/u:<init>	()V
    //   136: astore 8
    //   138: aload 8
    //   140: lload_1
    //   141: putfield 521	com/tencent/mm/plugin/finder/storage/u:field_localId	J
    //   144: aload 8
    //   146: aload_3
    //   147: putfield 563	com/tencent/mm/plugin/finder/storage/u:field_contextObj	Lcom/tencent/mm/protocal/protobuf/bbn;
    //   150: aload 8
    //   152: iconst_1
    //   153: putfield 567	com/tencent/mm/plugin/finder/storage/u:field_likeAction	I
    //   156: aload 8
    //   158: iconst_2
    //   159: putfield 570	com/tencent/mm/plugin/finder/storage/u:field_scene	I
    //   162: aload 8
    //   164: iload 5
    //   166: putfield 573	com/tencent/mm/plugin/finder/storage/u:field_showTips	Z
    //   169: aload 8
    //   171: iload 6
    //   173: putfield 534	com/tencent/mm/plugin/finder/storage/u:field_isPrivate	Z
    //   176: aload_0
    //   177: getfield 203	com/tencent/mm/plugin/finder/upload/action/j:vUu	Ljava/util/HashMap;
    //   180: checkcast 304	java/util/Map
    //   183: lload_1
    //   184: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   187: aload 8
    //   189: invokeinterface 322 3 0
    //   194: pop
    //   195: ldc_w 466
    //   198: invokestatic 472	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   201: checkcast 466	com/tencent/mm/plugin/finder/PluginFinder
    //   204: invokevirtual 476	com/tencent/mm/plugin/finder/PluginFinder:getLocalLikeFeedStorage	()Lcom/tencent/mm/plugin/finder/storage/v;
    //   207: aload 8
    //   209: invokevirtual 576	com/tencent/mm/plugin/finder/storage/v:a	(Lcom/tencent/mm/plugin/finder/storage/u;)Z
    //   212: pop
    //   213: getstatic 144	com/tencent/mm/plugin/finder/upload/action/j:TAG	Ljava/lang/String;
    //   216: new 240	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 578
    //   223: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: lload_1
    //   227: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   230: ldc_w 555
    //   233: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: iload 4
    //   238: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   241: ldc_w 557
    //   244: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: iload 6
    //   249: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   252: ldc_w 580
    //   255: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 276	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: ldc_w 551
    //   267: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_0
    //   271: monitorexit
    //   272: return
    //   273: aload_0
    //   274: getfield 203	com/tencent/mm/plugin/finder/upload/action/j:vUu	Ljava/util/HashMap;
    //   277: lload_1
    //   278: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   281: invokevirtual 529	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   284: ifeq -71 -> 213
    //   287: aload_0
    //   288: getfield 203	com/tencent/mm/plugin/finder/upload/action/j:vUu	Ljava/util/HashMap;
    //   291: lload_1
    //   292: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   295: invokevirtual 582	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   298: pop
    //   299: ldc_w 466
    //   302: invokestatic 472	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   305: checkcast 466	com/tencent/mm/plugin/finder/PluginFinder
    //   308: invokevirtual 476	com/tencent/mm/plugin/finder/PluginFinder:getLocalLikeFeedStorage	()Lcom/tencent/mm/plugin/finder/storage/v;
    //   311: astore_3
    //   312: aload_3
    //   313: getfield 482	com/tencent/mm/plugin/finder/storage/v:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   316: aload_3
    //   317: invokevirtual 585	com/tencent/mm/plugin/finder/storage/v:getTableName	()Ljava/lang/String;
    //   320: ldc_w 587
    //   323: iconst_1
    //   324: anewarray 589	java/lang/String
    //   327: dup
    //   328: iconst_0
    //   329: lload_1
    //   330: invokestatic 592	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   333: aastore
    //   334: invokeinterface 596 4 0
    //   339: istore 7
    //   341: getstatic 512	com/tencent/mm/plugin/finder/storage/v:TAG	Ljava/lang/String;
    //   344: new 240	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 598
    //   351: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: lload_1
    //   355: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   358: ldc_w 600
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
    //   0	383	0	this	j
    //   0	383	1	paramLong	long
    //   0	383	3	parambbn	com.tencent.mm.protocal.protobuf.bbn
    //   0	383	4	paramBoolean1	boolean
    //   0	383	5	paramBoolean2	boolean
    //   0	383	6	paramBoolean3	boolean
    //   339	26	7	i	int
    //   112	96	8	localu	u
    // Exception table:
    //   from	to	target	type
    //   2	79	378	finally
    //   84	114	378	finally
    //   119	129	378	finally
    //   129	213	378	finally
    //   213	270	378	finally
    //   273	375	378	finally
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(167816);
    p.h(parami, "action");
    i locali = (i)this.vTX.get(Long.valueOf(parami.feedId));
    if (locali != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(parami).append(" result ");
        if (parami.vUi < locali.vUi) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if (parami.vUi >= locali.vUi) {
          this.vTX.remove(Long.valueOf(parami.feedId));
        }
        AppMethodBeat.o(167816);
        return;
      }
    }
    AppMethodBeat.o(167816);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(167817);
    p.h(paraml, "action");
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.vUt.get(Long.valueOf(paraml.feedId));
    if (localConcurrentHashMap != null)
    {
      c localc = new c(paraml.vUB.dyb().commentId, paraml.scene);
      l locall = (l)localConcurrentHashMap.get(localc);
      if (locall != null)
      {
        String str;
        StringBuilder localStringBuilder;
        if (BuildInfo.DEBUG)
        {
          str = TAG;
          localStringBuilder = new StringBuilder("removeLikeCommentCache ").append(paraml).append(" result ");
          if (paraml.vUi < locall.vUi) {
            break label163;
          }
        }
        label163:
        for (boolean bool = true;; bool = false)
        {
          Log.i(str, bool);
          if (paraml.vUi >= locall.vUi) {
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
  
  public final boolean a(long paramLong, an paraman, int paramInt)
  {
    AppMethodBeat.i(167814);
    p.h(paraman, "commentObj");
    if (paramLong == 0L)
    {
      if (paraman.dyb().likeFlag == 1)
      {
        AppMethodBeat.o(167814);
        return true;
      }
      AppMethodBeat.o(167814);
      return false;
    }
    boolean bool;
    Object localObject;
    if (paraman.dyb().likeFlag == 1)
    {
      bool = true;
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsP().value()).intValue() == 1) {
        break label299;
      }
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (com.tencent.mm.plugin.finder.storage.c.drT() != 1) {
        break label299;
      }
      localObject = (ConcurrentHashMap)this.vUt.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label291;
      }
      localObject = (l)((ConcurrentHashMap)localObject).get(new c(paraman.dyb().commentId, 1));
      if (localObject == null) {
        break label291;
      }
      bool = ((l)localObject).vUr;
      localObject = "" + " get from cache " + ((l)localObject).vUr + ' ';
    }
    for (;;)
    {
      if (BuildInfo.DEBUG) {
        Log.i(TAG, "isCommentLike test " + paramLong + " commentObj:" + paraman + " cache:" + (String)localObject + " likeFlag:" + paraman.dyb().likeFlag + " scene:" + paramInt + " result:" + bool);
      }
      AppMethodBeat.o(167814);
      return bool;
      bool = false;
      break;
      label291:
      localObject = "";
      continue;
      label299:
      localObject = (ConcurrentHashMap)this.vUt.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (l)((ConcurrentHashMap)localObject).get(new c(paraman.dyb().commentId, paramInt));
        if (localObject != null)
        {
          bool = ((l)localObject).vUr;
          localObject = "" + " get from cache " + ((l)localObject).vUr + ' ';
          continue;
        }
      }
      localObject = "";
    }
  }
  
  public final int b(long paramLong, an paraman, int paramInt)
  {
    AppMethodBeat.i(167815);
    p.h(paraman, "commentObj");
    if (paramLong == 0L)
    {
      paramInt = paraman.dyb().likeCount;
      AppMethodBeat.o(167815);
      return paramInt;
    }
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (paraman.dyb().likeFlag == 1)
    {
      bool1 = true;
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsP().value()).intValue() == 1) {
        break label187;
      }
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (com.tencent.mm.plugin.finder.storage.c.drT() != 1) {
        break label187;
      }
      localObject = (ConcurrentHashMap)this.vUt.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label180;
      }
      localObject = (l)((ConcurrentHashMap)localObject).get(new c(paraman.dyb().commentId, 1));
      if (localObject == null) {
        break label180;
      }
      bool2 = ((l)localObject).vUr;
    }
    for (;;)
    {
      if ((!bool1) || (bool1 == bool2)) {
        break label256;
      }
      paramInt = paraman.dyb().likeCount;
      AppMethodBeat.o(167815);
      return paramInt - 1;
      bool1 = false;
      break;
      label180:
      bool2 = bool1;
      continue;
      label187:
      localObject = (ConcurrentHashMap)this.vUt.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (l)((ConcurrentHashMap)localObject).get(new c(paraman.dyb().commentId, paramInt));
        if (localObject != null)
        {
          bool2 = ((l)localObject).vUr;
          continue;
        }
      }
      bool2 = bool1;
    }
    label256:
    if ((!bool1) && (bool1 != bool2))
    {
      paramInt = paraman.dyb().likeCount;
      AppMethodBeat.o(167815);
      return paramInt + 1;
    }
    paramInt = paraman.dyb().likeCount;
    AppMethodBeat.o(167815);
    return paramInt;
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(253228);
    p.h(parami, "action");
    i locali = (i)this.vTY.get(Long.valueOf(parami.feedId));
    if (locali != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(parami).append(" result ");
        if (parami.vUi < locali.vUi) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        Log.i(str, bool);
        if (parami.vUi >= locali.vUi) {
          this.vTY.remove(Long.valueOf(parami.feedId));
        }
        AppMethodBeat.o(253228);
        return;
      }
    }
    AppMethodBeat.o(253228);
  }
  
  public final void dAP()
  {
    AppMethodBeat.i(167818);
    e locale;
    boolean bool;
    do
    {
      if (this.vTW.size() <= 0)
      {
        AppMethodBeat.o(167818);
        return;
      }
      locale = (e)this.vTW.poll();
      bool = locale.isValid();
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.vTW.size());
    } while (!bool);
    p.g(locale, "action");
    a(locale);
    AppMethodBeat.o(167818);
  }
  
  public final o<Boolean, Boolean> m(FinderObject paramFinderObject)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(253221);
    p.h(paramFinderObject, "feed");
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
        AppMethodBeat.o(253221);
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
      localObject = (i)this.vTX.get(Long.valueOf(paramFinderObject.id));
      if (localObject != null)
      {
        bool1 = ((i)localObject).vUr;
        bool2 = ((i)localObject).vUk;
      }
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
        localObject = (i)this.vTX.get(Long.valueOf(paramFinderObject.id));
        if (localObject == null) {
          break label276;
        }
      }
    }
    label271:
    label276:
    for (Object localObject = Boolean.valueOf(((i)localObject).vUr);; localObject = null)
    {
      Log.i(str, localObject + " likeFlag:" + paramFinderObject.likeFlag + " result:" + bool1);
      paramFinderObject = new o(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      AppMethodBeat.o(253221);
      return paramFinderObject;
      bool1 = false;
      break;
      bool2 = false;
      break label98;
    }
  }
  
  public final int n(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167813);
    p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.likeCount;
      AppMethodBeat.o(167813);
      return i;
    }
    boolean bool1;
    i locali;
    if (paramFinderObject.likeFlag != 0)
    {
      bool1 = true;
      locali = (i)this.vTX.get(Long.valueOf(paramFinderObject.id));
      if (locali == null) {
        break label105;
      }
    }
    label105:
    for (boolean bool2 = locali.vUr;; bool2 = bool1)
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
  
  public final int o(FinderObject paramFinderObject)
  {
    int j = 1;
    AppMethodBeat.i(253222);
    p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(253222);
      return i;
    }
    if (paramFinderObject.likeFlag == 1)
    {
      i = 1;
      i locali = (i)this.vTX.get(Long.valueOf(paramFinderObject.id));
      if (locali == null) {
        break label121;
      }
      if ((!locali.vUr) || (locali.vUk)) {
        break label116;
      }
    }
    for (;;)
    {
      if ((i == 0) || (i == j)) {
        break label126;
      }
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(253222);
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
      AppMethodBeat.o(253222);
      return i + 1;
    }
    int i = paramFinderObject.friendLikeCount;
    AppMethodBeat.o(253222);
    return i;
  }
  
  public final LinkedList<FinderCommentInfo> p(FinderObject paramFinderObject)
  {
    int j = 1;
    AppMethodBeat.i(253223);
    p.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      paramFinderObject = paramFinderObject.likeList;
      p.g(paramFinderObject, "feed.likeList");
      AppMethodBeat.o(253223);
      return paramFinderObject;
    }
    int i;
    if (paramFinderObject.likeFlag == 1)
    {
      i = 1;
      i locali = (i)this.vTX.get(Long.valueOf(paramFinderObject.id));
      if (locali == null) {
        break label138;
      }
      if ((!locali.vUr) || (locali.vUk)) {
        break label133;
      }
    }
    for (;;)
    {
      if ((i == 0) || (i == j)) {
        break label143;
      }
      paramFinderObject = paramFinderObject.likeList;
      p.g(paramFinderObject, "feed.likeList");
      paramFinderObject = aH(paramFinderObject);
      AppMethodBeat.o(253223);
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
      p.g(paramFinderObject, "feed.likeList");
      paramFinderObject = aF(paramFinderObject);
      AppMethodBeat.o(253223);
      return paramFinderObject;
    }
    paramFinderObject = paramFinderObject.likeList;
    p.g(paramFinderObject, "feed.likeList");
    AppMethodBeat.o(253223);
    return paramFinderObject;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "", "onLikeFail", "", "errType", "", "errCode", "errMsg", "", "plugin-finder_release"})
  public static abstract interface b {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "", "id", "", "scene", "", "(JI)V", "getId", "()J", "getScene", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"})
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/action/LikeActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<k>
  {
    d(e parame) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<FinderCommentInfo, Boolean>
  {
    public static final e vUy;
    
    static
    {
      AppMethodBeat.i(253220);
      vUy = new e();
      AppMethodBeat.o(253220);
    }
    
    e()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(167811);
      this.vUx.dAP();
      AppMethodBeat.o(167811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.j
 * JD-Core Version:    0.7.0.1
 */
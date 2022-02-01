package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.f.a.a;
import com.tencent.mm.loader.f.a.f;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "feedCommentLikeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "feedMap", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "localFeedLikeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "Lkotlin/collections/HashMap;", "megaVideoMap", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "addSelf", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "likeList", "addSelfInto", "", "newList", "commentLikeCount", "", "feedId", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "scene", "doLike", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "isPrivate", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLongVideo", "doLikeComment", "objectNonceId", "", "comment", "isPoster", "doLikeLocalFeed", "localId", "doPost", "action", "friendLikeCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "friendLikeList", "isCommentLike", "isLike", "Lkotlin/Pair;", "isLocalFeedLike", "isMegaVideoLike", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "isWxScene", "likeCount", "likeLocalFeed", "likeAction", "showTips", "likeMegaVideoCount", "removeLikeCache", "removeLikeCommentCache", "removeLocalLikeFeed", "removeLongVideoLikeCache", "removeSelf", "removeSelfFrom", "removeUnuseAction", "restoreLocalLikeFeed", "saveLocalLikeFeed", "tryNext", "Companion", "ILikeActionCallback", "KeyData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final a Gdj;
  private static final l Gdk;
  public static final String TAG;
  private com.tencent.mm.loader.f.d<m> Gag;
  private final Runnable Gai;
  private final ConcurrentLinkedQueue<e> Gap;
  private final ConcurrentHashMap<Long, ConcurrentHashMap<c, n>> Gaq;
  public final HashMap<Long, com.tencent.mm.plugin.finder.storage.s> Gar;
  private final ConcurrentHashMap<Long, k> GcI;
  private final ConcurrentHashMap<Long, k> GcJ;
  
  static
  {
    AppMethodBeat.i(167823);
    Gdj = new a((byte)0);
    TAG = "Finder.FinderLikeActionMgr";
    Gdk = new l();
    AppMethodBeat.o(167823);
  }
  
  public l()
  {
    AppMethodBeat.i(167822);
    this.Gag = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new f((com.tencent.mm.loader.f.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_like_post_quene"));
    fdA();
    this.Gap = new ConcurrentLinkedQueue();
    this.GcI = new ConcurrentHashMap();
    this.GcJ = new ConcurrentHashMap();
    this.Gaq = new ConcurrentHashMap();
    this.Gar = new HashMap();
    this.Gai = new l..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(167822);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(167821);
    this.Gag.a((com.tencent.mm.loader.f.c)new m(parame), (com.tencent.mm.loader.f.e)new d(this, parame));
    AppMethodBeat.o(167821);
  }
  
  private static final void a(l paraml)
  {
    AppMethodBeat.i(343441);
    kotlin.g.b.s.u(paraml, "this$0");
    paraml.fdz();
    AppMethodBeat.o(343441);
  }
  
  private static LinkedList<FinderCommentInfo> bc(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(343380);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    bd(localLinkedList);
    AppMethodBeat.o(343380);
    return localLinkedList;
  }
  
  /* Error */
  public static void bd(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    // Byte code:
    //   0: ldc_w 424
    //   3: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 425
    //   10: invokestatic 238	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: checkcast 365	java/lang/Iterable
    //   19: invokeinterface 374 1 0
    //   24: astore_2
    //   25: aload_2
    //   26: invokeinterface 380 1 0
    //   31: ifeq +85 -> 116
    //   34: aload_2
    //   35: invokeinterface 384 1 0
    //   40: astore_1
    //   41: aload_1
    //   42: checkcast 320	com/tencent/mm/protocal/protobuf/FinderCommentInfo
    //   45: getfield 428	com/tencent/mm/protocal/protobuf/FinderCommentInfo:username	Ljava/lang/String;
    //   48: invokestatic 433	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
    //   51: invokestatic 437	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   54: ifeq -29 -> 25
    //   57: aload_1
    //   58: checkcast 320	com/tencent/mm/protocal/protobuf/FinderCommentInfo
    //   61: ifnonnull +42 -> 103
    //   64: new 320	com/tencent/mm/protocal/protobuf/FinderCommentInfo
    //   67: dup
    //   68: invokespecial 438	com/tencent/mm/protocal/protobuf/FinderCommentInfo:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: invokestatic 433	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
    //   76: putfield 428	com/tencent/mm/protocal/protobuf/FinderCommentInfo:username	Ljava/lang/String;
    //   79: aload_1
    //   80: invokestatic 441	com/tencent/mm/model/z:bAO	()Ljava/lang/String;
    //   83: putfield 444	com/tencent/mm/protocal/protobuf/FinderCommentInfo:nickname	Ljava/lang/String;
    //   86: aload_1
    //   87: ldc_w 445
    //   90: putfield 448	com/tencent/mm/protocal/protobuf/FinderCommentInfo:headUrl	Ljava/lang/String;
    //   93: getstatic 454	kotlin/ah:aiuX	Lkotlin/ah;
    //   96: astore_2
    //   97: aload_0
    //   98: iconst_0
    //   99: aload_1
    //   100: invokevirtual 457	java/util/LinkedList:add	(ILjava/lang/Object;)V
    //   103: getstatic 454	kotlin/ah:aiuX	Lkotlin/ah;
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: ldc_w 424
    //   112: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    //   116: aconst_null
    //   117: astore_1
    //   118: goto -61 -> 57
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: ldc_w 424
    //   127: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramLinkedList	LinkedList<FinderCommentInfo>
    //   40	78	1	localObject1	Object
    //   121	10	1	localObject2	Object
    //   24	73	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	25	121	finally
    //   25	57	121	finally
    //   57	103	121	finally
    //   103	107	121	finally
  }
  
  private static LinkedList<FinderCommentInfo> be(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(343396);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    bf(localLinkedList);
    AppMethodBeat.o(343396);
    return localLinkedList;
  }
  
  public static void bf(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(343400);
    kotlin.g.b.s.u(paramLinkedList, "newList");
    com.tencent.mm.ae.d.a(paramLinkedList, (kotlin.g.a.b)l.e.Gdm);
    AppMethodBeat.o(343400);
  }
  
  private final void fdA()
  {
    AppMethodBeat.i(343435);
    try
    {
      Iterator localIterator = ((Iterable)((PluginFinder)h.az(PluginFinder.class)).getLocalLikeFeedStorage().eZt()).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.finder.storage.s locals = (com.tencent.mm.plugin.finder.storage.s)localIterator.next();
        ((Map)this.Gar).put(Long.valueOf(locals.field_localId), locals);
      }
      AppMethodBeat.o(343435);
    }
    finally
    {
      Log.printErrStackTrace(TAG, localThrowable, "restoreLocalLikeFeed", new Object[0]);
      AppMethodBeat.o(343435);
      return;
    }
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(167816);
    kotlin.g.b.s.u(paramk, "action");
    k localk = (k)this.GcI.get(Long.valueOf(paramk.feedId));
    String str;
    StringBuilder localStringBuilder;
    if (localk != null) {
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramk).append(" result ");
        if (paramk.Gae < localk.Gae) {
          break label130;
        }
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      if (paramk.Gae >= localk.Gae) {
        this.GcI.remove(Long.valueOf(paramk.feedId));
      }
      AppMethodBeat.o(167816);
      return;
    }
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(167817);
    kotlin.g.b.s.u(paramn, "action");
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.Gaq.get(Long.valueOf(paramn.feedId));
    c localc;
    n localn;
    String str;
    StringBuilder localStringBuilder;
    if (localConcurrentHashMap != null)
    {
      localc = new c(paramn.Gdp.eZI().commentId, paramn.scene);
      localn = (n)localConcurrentHashMap.get(localc);
      if (localn != null) {
        if (BuildInfo.DEBUG)
        {
          str = TAG;
          localStringBuilder = new StringBuilder("removeLikeCommentCache ").append(paramn).append(" result ");
          if (paramn.Gae < localn.Gae) {
            break label163;
          }
        }
      }
    }
    label163:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      if (paramn.Gae >= localn.Gae) {
        localConcurrentHashMap.remove(localc);
      }
      AppMethodBeat.o(167817);
      return;
    }
  }
  
  public final boolean a(long paramLong, au paramau, int paramInt)
  {
    AppMethodBeat.i(167814);
    kotlin.g.b.s.u(paramau, "commentObj");
    if (paramLong == 0L)
    {
      if (paramau.eZI().likeFlag == 1)
      {
        AppMethodBeat.o(167814);
        return true;
      }
      AppMethodBeat.o(167814);
      return false;
    }
    boolean bool;
    Object localObject;
    if (paramau.eZI().likeFlag == 1)
    {
      bool = true;
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSA().bmg()).intValue() == 1) {
        break label291;
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (com.tencent.mm.plugin.finder.storage.d.eRy() != 1) {
        break label291;
      }
      localObject = (ConcurrentHashMap)this.Gaq.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label390;
      }
      localObject = (n)((ConcurrentHashMap)localObject).get(new c(paramau.eZI().commentId, 1));
      if (localObject == null) {
        break label390;
      }
      bool = ((n)localObject).GaB;
      localObject = "" + " get from cache " + ((n)localObject).GaB + ' ';
    }
    for (;;)
    {
      if (BuildInfo.DEBUG) {
        Log.i(TAG, "isCommentLike test " + paramLong + " commentObj:" + paramau + " cache:" + (String)localObject + " likeFlag:" + paramau.eZI().likeFlag + " scene:" + paramInt + " result:" + bool);
      }
      AppMethodBeat.o(167814);
      return bool;
      bool = false;
      break;
      label291:
      localObject = (ConcurrentHashMap)this.Gaq.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (n)((ConcurrentHashMap)localObject).get(new c(paramau.eZI().commentId, paramInt));
        if (localObject != null)
        {
          bool = ((n)localObject).GaB;
          localObject = "" + " get from cache " + ((n)localObject).GaB + ' ';
          continue;
        }
      }
      label390:
      localObject = "";
    }
  }
  
  public final int b(long paramLong, au paramau, int paramInt)
  {
    AppMethodBeat.i(167815);
    kotlin.g.b.s.u(paramau, "commentObj");
    if (paramLong == 0L)
    {
      paramInt = paramau.eZI().likeCount;
      AppMethodBeat.o(167815);
      return paramInt;
    }
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (paramau.eZI().likeFlag == 1)
    {
      bool1 = true;
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSA().bmg()).intValue() == 1) {
        break label180;
      }
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (com.tencent.mm.plugin.finder.storage.d.eRy() != 1) {
        break label180;
      }
      localObject = (ConcurrentHashMap)this.Gaq.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label292;
      }
      localObject = (n)((ConcurrentHashMap)localObject).get(new c(paramau.eZI().commentId, 1));
      if (localObject == null) {
        break label292;
      }
      bool2 = ((n)localObject).GaB;
    }
    for (;;)
    {
      if ((bool1) && (bool1 != bool2))
      {
        paramInt = paramau.eZI().likeCount;
        AppMethodBeat.o(167815);
        return paramInt - 1;
        bool1 = false;
        break;
        label180:
        localObject = (ConcurrentHashMap)this.Gaq.get(Long.valueOf(paramLong));
        if (localObject == null) {
          break label292;
        }
        localObject = (n)((ConcurrentHashMap)localObject).get(new c(paramau.eZI().commentId, paramInt));
        if (localObject == null) {
          break label292;
        }
        bool2 = ((n)localObject).GaB;
        continue;
      }
      if ((!bool1) && (bool1 != bool2))
      {
        paramInt = paramau.eZI().likeCount;
        AppMethodBeat.o(167815);
        return paramInt + 1;
      }
      paramInt = paramau.eZI().likeCount;
      AppMethodBeat.o(167815);
      return paramInt;
      label292:
      bool2 = bool1;
    }
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(343517);
    kotlin.g.b.s.u(paramk, "action");
    k localk = (k)this.GcJ.get(Long.valueOf(paramk.feedId));
    String str;
    StringBuilder localStringBuilder;
    if (localk != null) {
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramk).append(" result ");
        if (paramk.Gae < localk.Gae) {
          break label130;
        }
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      if (paramk.Gae >= localk.Gae) {
        this.GcJ.remove(Long.valueOf(paramk.feedId));
      }
      AppMethodBeat.o(343517);
      return;
    }
  }
  
  public final void fdz()
  {
    AppMethodBeat.i(167818);
    e locale;
    boolean bool;
    do
    {
      if (this.Gap.size() <= 0)
      {
        AppMethodBeat.o(167818);
        return;
      }
      locale = (e)this.Gap.poll();
      bool = locale.isValid();
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.Gap.size());
    } while (!bool);
    kotlin.g.b.s.s(locale, "action");
    a(locale);
    AppMethodBeat.o(167818);
  }
  
  public final r<Boolean, Boolean> u(FinderObject paramFinderObject)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(343470);
    kotlin.g.b.s.u(paramFinderObject, "feed");
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
        paramFinderObject = new r(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
        AppMethodBeat.o(343470);
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
        break label264;
      }
      bool2 = bool3;
      localObject = (k)this.GcI.get(Long.valueOf(paramFinderObject.id));
      if (localObject != null)
      {
        bool1 = ((k)localObject).GaB;
        bool2 = ((k)localObject).Gdb;
      }
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
        localObject = (k)this.GcI.get(Long.valueOf(paramFinderObject.id));
        if (localObject != null) {
          break label269;
        }
      }
    }
    label264:
    label269:
    for (Object localObject = null;; localObject = Boolean.valueOf(((k)localObject).GaB))
    {
      Log.i(str, localObject + " likeFlag:" + paramFinderObject.likeFlag + " result:" + bool1);
      paramFinderObject = new r(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      AppMethodBeat.o(343470);
      return paramFinderObject;
      bool1 = false;
      break;
      bool2 = false;
      break label98;
    }
  }
  
  public final int v(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167813);
    kotlin.g.b.s.u(paramFinderObject, "feed");
    int i;
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
      localk = (k)this.GcI.get(Long.valueOf(paramFinderObject.id));
      if (localk == null) {
        break label142;
      }
    }
    label142:
    for (boolean bool2 = localk.GaB;; bool2 = bool1)
    {
      if ((bool1) && (true != bool2))
      {
        i = paramFinderObject.likeCount;
        AppMethodBeat.o(167813);
        return i - 1;
        bool1 = false;
        break;
      }
      if ((!bool1) && (bool2))
      {
        i = paramFinderObject.likeCount;
        AppMethodBeat.o(167813);
        return i + 1;
      }
      i = paramFinderObject.likeCount;
      AppMethodBeat.o(167813);
      return i;
    }
  }
  
  public final int w(FinderObject paramFinderObject)
  {
    int j = 1;
    AppMethodBeat.i(343480);
    kotlin.g.b.s.u(paramFinderObject, "feed");
    int i;
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(343480);
      return i;
    }
    if (paramFinderObject.likeFlag == 1)
    {
      i = 1;
      k localk = (k)this.GcI.get(Long.valueOf(paramFinderObject.id));
      if (localk == null) {
        break label158;
      }
      if ((!localk.GaB) || (localk.Gdb)) {
        break label116;
      }
    }
    for (;;)
    {
      if ((i != 0) && (i != j))
      {
        i = paramFinderObject.friendLikeCount;
        AppMethodBeat.o(343480);
        return i - 1;
        i = 0;
        break;
        label116:
        j = 0;
        continue;
      }
      if ((i == 0) && (i != j))
      {
        i = paramFinderObject.friendLikeCount;
        AppMethodBeat.o(343480);
        return i + 1;
      }
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(343480);
      return i;
      label158:
      j = i;
    }
  }
  
  public final LinkedList<FinderCommentInfo> x(FinderObject paramFinderObject)
  {
    int j = 1;
    AppMethodBeat.i(343487);
    kotlin.g.b.s.u(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      paramFinderObject = paramFinderObject.likeList;
      kotlin.g.b.s.s(paramFinderObject, "feed.likeList");
      AppMethodBeat.o(343487);
      return paramFinderObject;
    }
    int i;
    if (paramFinderObject.likeFlag == 1)
    {
      i = 1;
      k localk = (k)this.GcI.get(Long.valueOf(paramFinderObject.id));
      if (localk == null) {
        break label192;
      }
      if ((!localk.GaB) || (localk.Gdb)) {
        break label133;
      }
    }
    for (;;)
    {
      if ((i != 0) && (i != j))
      {
        paramFinderObject = paramFinderObject.likeList;
        kotlin.g.b.s.s(paramFinderObject, "feed.likeList");
        paramFinderObject = be(paramFinderObject);
        AppMethodBeat.o(343487);
        return paramFinderObject;
        i = 0;
        break;
        label133:
        j = 0;
        continue;
      }
      if ((i == 0) && (i != j))
      {
        paramFinderObject = paramFinderObject.likeList;
        kotlin.g.b.s.s(paramFinderObject, "feed.likeList");
        paramFinderObject = bc(paramFinderObject);
        AppMethodBeat.o(343487);
        return paramFinderObject;
      }
      paramFinderObject = paramFinderObject.likeList;
      kotlin.g.b.s.s(paramFinderObject, "feed.likeList");
      AppMethodBeat.o(343487);
      return paramFinderObject;
      label192:
      j = i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "", "onLikeFail", "", "errType", "", "errCode", "errMsg", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "", "id", "", "scene", "", "(JI)V", "getId", "()J", "getScene", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if (paramObject != null) {
          break label23;
        }
      }
      label23:
      while ((paramObject.id != this.id) || (paramObject.scene != this.scene))
      {
        return false;
        paramObject = null;
        break;
      }
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(167809);
      int i = (this.id + '_' + this.scene).hashCode();
      AppMethodBeat.o(167809);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/action/LikeActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.loader.f.e<m>
  {
    d(l paraml, e parame) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.l
 * JD-Core Version:    0.7.0.1
 */
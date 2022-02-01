package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "feedCommentLikeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "feedMap", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "addSelf", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "likeList", "addSelfInto", "", "newList", "commentLikeCount", "", "feedId", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "scene", "doLike", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doLikeComment", "objectNonceId", "", "comment", "isPoster", "doPost", "action", "friendLikeCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "friendLikeList", "isCommentLike", "isLike", "isWxScene", "likeCount", "removeLikeCache", "removeLikeCommentCache", "removeSelf", "removeSelfFrom", "removeUnuseAction", "tryNext", "Companion", "ILikeActionCallback", "KeyData", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "Finder.FinderLikeActionMgr";
  private static final d qRQ;
  public static final a qRR;
  private com.tencent.mm.loader.g.d<e> qQA;
  private final Runnable qQB;
  private final ConcurrentLinkedQueue<b> qRN;
  private final ConcurrentHashMap<Long, c> qRO;
  private final ConcurrentHashMap<Long, ConcurrentHashMap<c, f>> qRP;
  
  static
  {
    AppMethodBeat.i(167823);
    qRR = new a((byte)0);
    TAG = "Finder.FinderLikeActionMgr";
    qRQ = new d();
    AppMethodBeat.o(167823);
  }
  
  public d()
  {
    AppMethodBeat.i(167822);
    this.qQA = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_like_post_quene"));
    this.qRN = new ConcurrentLinkedQueue();
    this.qRO = new ConcurrentHashMap();
    this.qRP = new ConcurrentHashMap();
    this.qQB = ((Runnable)new e(this));
    AppMethodBeat.o(167822);
  }
  
  private final void a(final b paramb)
  {
    AppMethodBeat.i(167821);
    this.qQA.a((com.tencent.mm.loader.g.c)new e(paramb), (com.tencent.mm.loader.g.f)new d(this, paramb));
    AppMethodBeat.o(167821);
  }
  
  private static LinkedList<FinderCommentInfo> bo(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(199562);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    bp(localLinkedList);
    AppMethodBeat.o(199562);
    return localLinkedList;
  }
  
  public static void bp(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(199563);
    d.g.b.k.h(paramLinkedList, "newList");
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!d.g.b.k.g(((FinderCommentInfo)localObject).username, u.aqG()));
    for (;;)
    {
      if ((FinderCommentInfo)localObject == null)
      {
        localObject = new FinderCommentInfo();
        ((FinderCommentInfo)localObject).username = u.aqG();
        ((FinderCommentInfo)localObject).nickname = u.aqI();
        ((FinderCommentInfo)localObject).headUrl = "";
        paramLinkedList.add(localObject);
      }
      AppMethodBeat.o(199563);
      return;
      localObject = null;
    }
  }
  
  private static LinkedList<FinderCommentInfo> bq(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(199564);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    br(localLinkedList);
    AppMethodBeat.o(199564);
    return localLinkedList;
  }
  
  public static void br(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(199565);
    d.g.b.k.h(paramLinkedList, "newList");
    com.tencent.mm.ad.c.a(paramLinkedList, (d.g.a.b)f.Lar);
    AppMethodBeat.o(199565);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(167816);
    d.g.b.k.h(paramc, "action");
    c localc = (c)this.qRO.get(Long.valueOf(paramc.feedId));
    if (localc != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (h.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramc).append(" result ");
        if (paramc.qRH < localc.qRH) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        ad.i(str, bool);
        if (paramc.qRH >= localc.qRH) {
          this.qRO.remove(Long.valueOf(paramc.feedId));
        }
        AppMethodBeat.o(167816);
        return;
      }
    }
    AppMethodBeat.o(167816);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(167817);
    d.g.b.k.h(paramf, "action");
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.qRP.get(Long.valueOf(paramf.feedId));
    if (localConcurrentHashMap != null)
    {
      c localc = new c(paramf.qRY.cqr(), paramf.scene);
      f localf = (f)localConcurrentHashMap.get(localc);
      if (localf != null)
      {
        String str;
        StringBuilder localStringBuilder;
        if (h.DEBUG)
        {
          str = TAG;
          localStringBuilder = new StringBuilder("removeLikeCommentCache ").append(paramf).append(" result ");
          if (paramf.qRH < localf.qRH) {
            break label160;
          }
        }
        label160:
        for (boolean bool = true;; bool = false)
        {
          ad.i(str, bool);
          if (paramf.qRH >= localf.qRH) {
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
  
  public final boolean a(long paramLong, com.tencent.mm.plugin.finder.storage.k paramk, int paramInt)
  {
    AppMethodBeat.i(167814);
    d.g.b.k.h(paramk, "commentObj");
    if (paramLong == 0L)
    {
      if (paramk.getLikeFlag() == 1)
      {
        AppMethodBeat.o(167814);
        return true;
      }
      AppMethodBeat.o(167814);
      return false;
    }
    boolean bool;
    Object localObject;
    if (paramk.getLikeFlag() == 1)
    {
      bool = true;
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.cqa()) {
        break label277;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUn() != 1) {
        break label277;
      }
      localObject = (ConcurrentHashMap)this.qRP.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label269;
      }
      localObject = (f)((ConcurrentHashMap)localObject).get(new c(paramk.cqr(), 1));
      if (localObject == null) {
        break label269;
      }
      bool = ((f)localObject).qRK;
      localObject = "" + " get from cache " + ((f)localObject).qRK + ' ';
    }
    for (;;)
    {
      if (h.DEBUG) {
        ad.i(TAG, "isCommentLike test " + paramLong + " commentObj:" + paramk + " cache:" + (String)localObject + " likeFlag:" + paramk.getLikeFlag() + " scene:" + paramInt + " result:" + bool);
      }
      AppMethodBeat.o(167814);
      return bool;
      bool = false;
      break;
      label269:
      localObject = "";
      continue;
      label277:
      localObject = (ConcurrentHashMap)this.qRP.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (f)((ConcurrentHashMap)localObject).get(new c(paramk.cqr(), paramInt));
        if (localObject != null)
        {
          bool = ((f)localObject).qRK;
          localObject = "" + " get from cache " + ((f)localObject).qRK + ' ';
          continue;
        }
      }
      localObject = "";
    }
  }
  
  public final int b(long paramLong, com.tencent.mm.plugin.finder.storage.k paramk, int paramInt)
  {
    AppMethodBeat.i(167815);
    d.g.b.k.h(paramk, "commentObj");
    if (paramLong == 0L)
    {
      paramInt = paramk.getLikeCount();
      AppMethodBeat.o(167815);
      return paramInt;
    }
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (paramk.getLikeFlag() == 1)
    {
      bool1 = true;
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.cqa()) {
        break label165;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.fUn() != 1) {
        break label165;
      }
      localObject = (ConcurrentHashMap)this.qRP.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label158;
      }
      localObject = (f)((ConcurrentHashMap)localObject).get(new c(paramk.cqr(), 1));
      if (localObject == null) {
        break label158;
      }
      bool2 = ((f)localObject).qRK;
    }
    for (;;)
    {
      if ((!bool1) || (bool1 == bool2)) {
        break label231;
      }
      paramInt = paramk.getLikeCount();
      AppMethodBeat.o(167815);
      return paramInt - 1;
      bool1 = false;
      break;
      label158:
      bool2 = bool1;
      continue;
      label165:
      localObject = (ConcurrentHashMap)this.qRP.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (f)((ConcurrentHashMap)localObject).get(new c(paramk.cqr(), paramInt));
        if (localObject != null)
        {
          bool2 = ((f)localObject).qRK;
          continue;
        }
      }
      bool2 = bool1;
    }
    label231:
    if ((!bool1) && (bool1 != bool2))
    {
      paramInt = paramk.getLikeCount();
      AppMethodBeat.o(167815);
      return paramInt + 1;
    }
    paramInt = paramk.getLikeCount();
    AppMethodBeat.o(167815);
    return paramInt;
  }
  
  public final void crw()
  {
    AppMethodBeat.i(167818);
    b localb;
    boolean bool;
    do
    {
      if (this.qRN.size() <= 0)
      {
        AppMethodBeat.o(167818);
        return;
      }
      localb = (b)this.qRN.poll();
      bool = localb.isValid();
      ad.i(TAG, "tryNext isValid:" + bool + " action:" + localb + " size:" + this.qRN.size());
    } while (!bool);
    d.g.b.k.g(localb, "action");
    a(localb);
    AppMethodBeat.o(167818);
  }
  
  public final boolean d(FinderObject paramFinderObject)
  {
    boolean bool = false;
    AppMethodBeat.i(167812);
    d.g.b.k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      if (paramFinderObject.likeFlag == 1)
      {
        AppMethodBeat.o(167812);
        return true;
      }
      AppMethodBeat.o(167812);
      return false;
    }
    if (paramFinderObject.likeFlag == 1) {
      bool = true;
    }
    Object localObject = (c)this.qRO.get(Long.valueOf(paramFinderObject.id));
    if (localObject != null) {
      bool = ((c)localObject).qRK;
    }
    String str;
    StringBuilder localStringBuilder;
    if (h.DEBUG)
    {
      str = TAG;
      localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
      localObject = (c)this.qRO.get(Long.valueOf(paramFinderObject.id));
      if (localObject == null) {
        break label196;
      }
    }
    label196:
    for (localObject = Boolean.valueOf(((c)localObject).qRK);; localObject = null)
    {
      ad.i(str, localObject + " likeFlag:" + paramFinderObject.likeFlag + " result:" + bool);
      AppMethodBeat.o(167812);
      return bool;
    }
  }
  
  public final int e(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167813);
    d.g.b.k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.likeCount;
      AppMethodBeat.o(167813);
      return i;
    }
    boolean bool1;
    c localc;
    if (paramFinderObject.likeFlag == 1)
    {
      bool1 = true;
      localc = (c)this.qRO.get(Long.valueOf(paramFinderObject.id));
      if (localc == null) {
        break label106;
      }
    }
    label106:
    for (boolean bool2 = localc.qRK;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label112;
      }
      i = paramFinderObject.likeCount;
      AppMethodBeat.o(167813);
      return i - 1;
      bool1 = false;
      break;
    }
    label112:
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
  
  public final int n(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(199560);
    d.g.b.k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(199560);
      return i;
    }
    boolean bool1;
    c localc;
    if (paramFinderObject.likeFlag == 1)
    {
      bool1 = true;
      localc = (c)this.qRO.get(Long.valueOf(paramFinderObject.id));
      if (localc == null) {
        break label106;
      }
    }
    label106:
    for (boolean bool2 = localc.qRK;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label112;
      }
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(199560);
      return i - 1;
      bool1 = false;
      break;
    }
    label112:
    if ((!bool1) && (bool2))
    {
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(199560);
      return i + 1;
    }
    int i = paramFinderObject.friendLikeCount;
    AppMethodBeat.o(199560);
    return i;
  }
  
  public final LinkedList<FinderCommentInfo> o(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(199561);
    d.g.b.k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      paramFinderObject = paramFinderObject.likeList;
      d.g.b.k.g(paramFinderObject, "feed.likeList");
      AppMethodBeat.o(199561);
      return paramFinderObject;
    }
    boolean bool1;
    c localc;
    if (paramFinderObject.likeFlag == 1)
    {
      bool1 = true;
      localc = (c)this.qRO.get(Long.valueOf(paramFinderObject.id));
      if (localc == null) {
        break label121;
      }
    }
    label121:
    for (boolean bool2 = localc.qRK;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label126;
      }
      paramFinderObject = paramFinderObject.likeList;
      d.g.b.k.g(paramFinderObject, "feed.likeList");
      paramFinderObject = bq(paramFinderObject);
      AppMethodBeat.o(199561);
      return paramFinderObject;
      bool1 = false;
      break;
    }
    label126:
    if ((!bool1) && (bool2))
    {
      paramFinderObject = paramFinderObject.likeList;
      d.g.b.k.g(paramFinderObject, "feed.likeList");
      paramFinderObject = bo(paramFinderObject);
      AppMethodBeat.o(199561);
      return paramFinderObject;
    }
    paramFinderObject = paramFinderObject.likeList;
    d.g.b.k.g(paramFinderObject, "feed.likeList");
    AppMethodBeat.o(199561);
    return paramFinderObject;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "", "onLikeFail", "", "errType", "", "errCode", "errMsg", "", "plugin-finder_release"})
  public static abstract interface b {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "", "id", "", "scene", "", "(JI)V", "getId", "()J", "getScene", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/upload/action/LikeActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<e>
  {
    d(b paramb) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(167811);
      this.qRS.crw();
      AppMethodBeat.o(167811);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<FinderCommentInfo, Boolean>
  {
    public static final f Lar;
    
    static
    {
      AppMethodBeat.i(199559);
      Lar = new f();
      AppMethodBeat.o(199559);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.d
 * JD-Core Version:    0.7.0.1
 */
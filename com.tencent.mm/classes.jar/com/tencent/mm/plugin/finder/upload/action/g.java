package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "feedCommentLikeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "feedMap", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "addSelf", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "likeList", "addSelfInto", "", "newList", "commentLikeCount", "", "feedId", "commentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "scene", "doLike", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "like", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "doLikeComment", "objectNonceId", "", "comment", "isPoster", "doPost", "action", "friendLikeCount", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "friendLikeList", "isCommentLike", "isLike", "isWxScene", "likeCount", "removeLikeCache", "removeLikeCommentCache", "removeSelf", "removeSelfFrom", "removeUnuseAction", "tryNext", "Companion", "ILikeActionCallback", "KeyData", "plugin-finder_release"})
public final class g
{
  private static final String TAG = "Finder.FinderLikeActionMgr";
  private static final g rOa;
  public static final g.a rOb;
  private com.tencent.mm.loader.g.d<h> rMy;
  private final Runnable rMz;
  private final ConcurrentLinkedQueue<e> rNK;
  private final ConcurrentHashMap<Long, f> rNL;
  private final ConcurrentHashMap<Long, ConcurrentHashMap<c, i>> rNZ;
  
  static
  {
    AppMethodBeat.i(167823);
    rOb = new g.a((byte)0);
    TAG = "Finder.FinderLikeActionMgr";
    rOa = new g();
    AppMethodBeat.o(167823);
  }
  
  public g()
  {
    AppMethodBeat.i(167822);
    this.rMy = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "finder_action_like_post_quene"));
    this.rNK = new ConcurrentLinkedQueue();
    this.rNL = new ConcurrentHashMap();
    this.rNZ = new ConcurrentHashMap();
    this.rMz = ((Runnable)new g.f(this));
    AppMethodBeat.o(167822);
  }
  
  private final void a(final e parame)
  {
    AppMethodBeat.i(167821);
    this.rMy.a((com.tencent.mm.loader.g.c)new h(parame), (com.tencent.mm.loader.g.f)new d(this, parame));
    AppMethodBeat.o(167821);
  }
  
  private static LinkedList<FinderCommentInfo> ai(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(203538);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    aj(localLinkedList);
    AppMethodBeat.o(203538);
    return localLinkedList;
  }
  
  public static void aj(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(203539);
    k.h(paramLinkedList, "newList");
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!k.g(((FinderCommentInfo)localObject).username, u.axw()));
    for (;;)
    {
      if ((FinderCommentInfo)localObject == null)
      {
        localObject = new FinderCommentInfo();
        ((FinderCommentInfo)localObject).username = u.axw();
        ((FinderCommentInfo)localObject).nickname = u.axy();
        ((FinderCommentInfo)localObject).headUrl = "";
        paramLinkedList.add(localObject);
      }
      AppMethodBeat.o(203539);
      return;
      localObject = null;
    }
  }
  
  private static LinkedList<FinderCommentInfo> ak(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(203540);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll((Collection)paramLinkedList);
    al(localLinkedList);
    AppMethodBeat.o(203540);
    return localLinkedList;
  }
  
  public static void al(LinkedList<FinderCommentInfo> paramLinkedList)
  {
    AppMethodBeat.i(203541);
    k.h(paramLinkedList, "newList");
    com.tencent.mm.ac.c.a(paramLinkedList, (d.g.a.b)e.rOd);
    AppMethodBeat.o(203541);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(167816);
    k.h(paramf, "action");
    f localf = (f)this.rNL.get(Long.valueOf(paramf.dig));
    if (localf != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (com.tencent.mm.sdk.platformtools.h.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramf).append(" result ");
        if (paramf.rNV < localf.rNV) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        ac.i(str, bool);
        if (paramf.rNV >= localf.rNV) {
          this.rNL.remove(Long.valueOf(paramf.dig));
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
    k.h(parami, "action");
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.rNZ.get(Long.valueOf(parami.dig));
    if (localConcurrentHashMap != null)
    {
      c localc = new c(parami.rOg.cAK(), parami.scene);
      i locali = (i)localConcurrentHashMap.get(localc);
      if (locali != null)
      {
        String str;
        StringBuilder localStringBuilder;
        if (com.tencent.mm.sdk.platformtools.h.DEBUG)
        {
          str = TAG;
          localStringBuilder = new StringBuilder("removeLikeCommentCache ").append(parami).append(" result ");
          if (parami.rNV < locali.rNV) {
            break label160;
          }
        }
        label160:
        for (boolean bool = true;; bool = false)
        {
          ac.i(str, bool);
          if (parami.rNV >= locali.rNV) {
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
  
  public final boolean a(long paramLong, t paramt, int paramInt)
  {
    AppMethodBeat.i(167814);
    k.h(paramt, "commentObj");
    if (paramLong == 0L)
    {
      if (paramt.getLikeFlag() == 1)
      {
        AppMethodBeat.o(167814);
        return true;
      }
      AppMethodBeat.o(167814);
      return false;
    }
    boolean bool;
    Object localObject;
    if (paramt.getLikeFlag() == 1)
    {
      bool = true;
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czB()) {
        break label277;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czC() != 1) {
        break label277;
      }
      localObject = (ConcurrentHashMap)this.rNZ.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label269;
      }
      localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramt.cAK(), 1));
      if (localObject == null) {
        break label269;
      }
      bool = ((i)localObject).rNX;
      localObject = "" + " get from cache " + ((i)localObject).rNX + ' ';
    }
    for (;;)
    {
      if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
        ac.i(TAG, "isCommentLike test " + paramLong + " commentObj:" + paramt + " cache:" + (String)localObject + " likeFlag:" + paramt.getLikeFlag() + " scene:" + paramInt + " result:" + bool);
      }
      AppMethodBeat.o(167814);
      return bool;
      bool = false;
      break;
      label269:
      localObject = "";
      continue;
      label277:
      localObject = (ConcurrentHashMap)this.rNZ.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramt.cAK(), paramInt));
        if (localObject != null)
        {
          bool = ((i)localObject).rNX;
          localObject = "" + " get from cache " + ((i)localObject).rNX + ' ';
          continue;
        }
      }
      localObject = "";
    }
  }
  
  public final int b(long paramLong, t paramt, int paramInt)
  {
    AppMethodBeat.i(167815);
    k.h(paramt, "commentObj");
    if (paramLong == 0L)
    {
      paramInt = paramt.getLikeCount();
      AppMethodBeat.o(167815);
      return paramInt;
    }
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (paramt.getLikeFlag() == 1)
    {
      bool1 = true;
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czB()) {
        break label165;
      }
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czC() != 1) {
        break label165;
      }
      localObject = (ConcurrentHashMap)this.rNZ.get(Long.valueOf(paramLong));
      if (localObject == null) {
        break label158;
      }
      localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramt.cAK(), 1));
      if (localObject == null) {
        break label158;
      }
      bool2 = ((i)localObject).rNX;
    }
    for (;;)
    {
      if ((!bool1) || (bool1 == bool2)) {
        break label231;
      }
      paramInt = paramt.getLikeCount();
      AppMethodBeat.o(167815);
      return paramInt - 1;
      bool1 = false;
      break;
      label158:
      bool2 = bool1;
      continue;
      label165:
      localObject = (ConcurrentHashMap)this.rNZ.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (i)((ConcurrentHashMap)localObject).get(new c(paramt.cAK(), paramInt));
        if (localObject != null)
        {
          bool2 = ((i)localObject).rNX;
          continue;
        }
      }
      bool2 = bool1;
    }
    label231:
    if ((!bool1) && (bool1 != bool2))
    {
      paramInt = paramt.getLikeCount();
      AppMethodBeat.o(167815);
      return paramInt + 1;
    }
    paramInt = paramt.getLikeCount();
    AppMethodBeat.o(167815);
    return paramInt;
  }
  
  public final void cCq()
  {
    AppMethodBeat.i(167818);
    e locale;
    boolean bool;
    do
    {
      if (this.rNK.size() <= 0)
      {
        AppMethodBeat.o(167818);
        return;
      }
      locale = (e)this.rNK.poll();
      bool = locale.isValid();
      ac.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.rNK.size());
    } while (!bool);
    k.g(locale, "action");
    a(locale);
    AppMethodBeat.o(167818);
  }
  
  public final boolean j(FinderObject paramFinderObject)
  {
    boolean bool = false;
    AppMethodBeat.i(167812);
    k.h(paramFinderObject, "feed");
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
    Object localObject = (f)this.rNL.get(Long.valueOf(paramFinderObject.id));
    if (localObject != null) {
      bool = ((f)localObject).rNX;
    }
    String str;
    StringBuilder localStringBuilder;
    if (com.tencent.mm.sdk.platformtools.h.DEBUG)
    {
      str = TAG;
      localStringBuilder = new StringBuilder("isLike test ").append(paramFinderObject.id).append(" isLike:");
      localObject = (f)this.rNL.get(Long.valueOf(paramFinderObject.id));
      if (localObject == null) {
        break label196;
      }
    }
    label196:
    for (localObject = Boolean.valueOf(((f)localObject).rNX);; localObject = null)
    {
      ac.i(str, localObject + " likeFlag:" + paramFinderObject.likeFlag + " result:" + bool);
      AppMethodBeat.o(167812);
      return bool;
    }
  }
  
  public final int k(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167813);
    k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.likeCount;
      AppMethodBeat.o(167813);
      return i;
    }
    boolean bool1;
    f localf;
    if (paramFinderObject.likeFlag == 1)
    {
      bool1 = true;
      localf = (f)this.rNL.get(Long.valueOf(paramFinderObject.id));
      if (localf == null) {
        break label106;
      }
    }
    label106:
    for (boolean bool2 = localf.rNX;; bool2 = bool1)
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
  
  public final int l(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(203536);
    k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(203536);
      return i;
    }
    boolean bool1;
    f localf;
    if (paramFinderObject.likeFlag == 1)
    {
      bool1 = true;
      localf = (f)this.rNL.get(Long.valueOf(paramFinderObject.id));
      if (localf == null) {
        break label106;
      }
    }
    label106:
    for (boolean bool2 = localf.rNX;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label112;
      }
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(203536);
      return i - 1;
      bool1 = false;
      break;
    }
    label112:
    if ((!bool1) && (bool2))
    {
      i = paramFinderObject.friendLikeCount;
      AppMethodBeat.o(203536);
      return i + 1;
    }
    int i = paramFinderObject.friendLikeCount;
    AppMethodBeat.o(203536);
    return i;
  }
  
  public final LinkedList<FinderCommentInfo> m(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(203537);
    k.h(paramFinderObject, "feed");
    if (paramFinderObject.id == 0L)
    {
      paramFinderObject = paramFinderObject.likeList;
      k.g(paramFinderObject, "feed.likeList");
      AppMethodBeat.o(203537);
      return paramFinderObject;
    }
    boolean bool1;
    f localf;
    if (paramFinderObject.likeFlag == 1)
    {
      bool1 = true;
      localf = (f)this.rNL.get(Long.valueOf(paramFinderObject.id));
      if (localf == null) {
        break label121;
      }
    }
    label121:
    for (boolean bool2 = localf.rNX;; bool2 = bool1)
    {
      if ((!bool1) || (true == bool2)) {
        break label126;
      }
      paramFinderObject = paramFinderObject.likeList;
      k.g(paramFinderObject, "feed.likeList");
      paramFinderObject = ak(paramFinderObject);
      AppMethodBeat.o(203537);
      return paramFinderObject;
      bool1 = false;
      break;
    }
    label126:
    if ((!bool1) && (bool2))
    {
      paramFinderObject = paramFinderObject.likeList;
      k.g(paramFinderObject, "feed.likeList");
      paramFinderObject = ai(paramFinderObject);
      AppMethodBeat.o(203537);
      return paramFinderObject;
    }
    paramFinderObject = paramFinderObject.likeList;
    k.g(paramFinderObject, "feed.likeList");
    AppMethodBeat.o(203537);
    return paramFinderObject;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$ILikeActionCallback;", "", "onLikeFail", "", "errType", "", "errCode", "errMsg", "", "plugin-finder_release"})
  public static abstract interface b {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/action/LikeActionMgr$KeyData;", "", "id", "", "scene", "", "(JI)V", "getId", "()J", "getScene", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/upload/action/LikeActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.loader.g.f<h>
  {
    d(e parame) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<FinderCommentInfo, Boolean>
  {
    public static final e rOd;
    
    static
    {
      AppMethodBeat.i(203535);
      rOd = new e();
      AppMethodBeat.o(203535);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.g
 * JD-Core Version:    0.7.0.1
 */
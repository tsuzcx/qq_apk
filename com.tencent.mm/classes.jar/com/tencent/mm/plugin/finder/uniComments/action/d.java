package com.tencent.mm.plugin.finder.uniComments.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.upload.action.a.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionTask;", "feedCommentLikeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr$KeyData;", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeCommentAction;", "localFeedLikeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/storage/FinderLocalOperation;", "Lkotlin/collections/HashMap;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniAction;", "tryTask", "Ljava/lang/Runnable;", "addSelf", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "likeList", "addSelfInto", "", "newList", "commentLikeCount", "", "feedId", "commentObj", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "scene", "doLikeComment", "feedItem", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "comment", "like", "", "InteractionIdentityType", "doLikeLocalFeed", "localId", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isPrivate", "doPost", "action", "isCommentLike", "isLocalFeedLike", "Lkotlin/Pair;", "isWxScene", "likeLocalFeed", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "likeAction", "isLike", "showTips", "removeLikeCommentCache", "removeLocalLikeFeed", "removeSelf", "removeSelfFrom", "removeUnuseAction", "restoreLocalLikeFeed", "saveLocalLikeFeed", "tryNext", "Companion", "ILikeActionCallback", "KeyData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a Gao;
  private static final d Gas;
  private static final String TAG;
  private com.tencent.mm.loader.f.d<e> Gag;
  private final Runnable Gai;
  private final ConcurrentLinkedQueue<a> Gap;
  public final ConcurrentHashMap<Long, ConcurrentHashMap<c, f>> Gaq;
  private final HashMap<Long, com.tencent.mm.plugin.finder.storage.s> Gar;
  
  static
  {
    AppMethodBeat.i(341664);
    Gao = new a((byte)0);
    TAG = "MicroMsg.MusicUni.FinderLikeActionMgr";
    Gas = new d();
    AppMethodBeat.o(341664);
  }
  
  public d()
  {
    AppMethodBeat.i(341625);
    this.Gag = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new g(1, (byte)0), 1, "uni_action_like_post_quene"));
    fdA();
    this.Gap = new ConcurrentLinkedQueue();
    this.Gaq = new ConcurrentHashMap();
    this.Gar = new HashMap();
    this.Gai = new d..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(341625);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(341635);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.fdz();
    AppMethodBeat.o(341635);
  }
  
  private final void fdA()
  {
    AppMethodBeat.i(341628);
    try
    {
      Iterator localIterator = ((Iterable)((PluginFinder)h.az(PluginFinder.class)).getLocalLikeFeedStorage().eZt()).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.finder.storage.s locals = (com.tencent.mm.plugin.finder.storage.s)localIterator.next();
        ((Map)this.Gar).put(Long.valueOf(locals.field_localId), locals);
      }
      AppMethodBeat.o(341628);
    }
    finally
    {
      Log.printErrStackTrace(TAG, localThrowable, "restoreLocalLikeFeed", new Object[0]);
      AppMethodBeat.o(341628);
      return;
    }
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(341700);
    this.Gag.a((com.tencent.mm.loader.f.c)new e(parama), (com.tencent.mm.loader.f.e)new d(this, parama));
    AppMethodBeat.o(341700);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(341689);
    kotlin.g.b.s.u(paramf, "action");
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.Gaq.get(Long.valueOf(paramf.feedId));
    c localc;
    f localf;
    String str;
    StringBuilder localStringBuilder;
    if (localConcurrentHashMap != null)
    {
      localc = new c(paramf.GaA.eZI().commentId, paramf.scene);
      localf = (f)localConcurrentHashMap.get(localc);
      if (localf != null) {
        if (BuildInfo.DEBUG)
        {
          str = TAG;
          localStringBuilder = new StringBuilder("removeLikeCommentCache ").append(paramf).append(" result ");
          if (paramf.Gae < localf.Gae) {
            break label163;
          }
        }
      }
    }
    label163:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      if (paramf.Gae >= localf.Gae) {
        localConcurrentHashMap.remove(localc);
      }
      AppMethodBeat.o(341689);
      return;
    }
  }
  
  public final boolean a(long paramLong, com.tencent.mm.plugin.finder.uniComments.storge.b paramb, int paramInt)
  {
    AppMethodBeat.i(341677);
    kotlin.g.b.s.u(paramb, "commentObj");
    if (paramLong == 0L)
    {
      if (paramb.eZI().likeFlag == 1)
      {
        AppMethodBeat.o(341677);
        return true;
      }
      AppMethodBeat.o(341677);
      return false;
    }
    boolean bool;
    Object localObject;
    if (paramb.eZI().likeFlag == 1)
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
      localObject = (f)((ConcurrentHashMap)localObject).get(new c(paramb.eZI().commentId, 1));
      if (localObject == null) {
        break label390;
      }
      bool = ((f)localObject).GaB;
      localObject = "" + " get from cache " + ((f)localObject).GaB + ' ';
    }
    for (;;)
    {
      if (BuildInfo.DEBUG) {
        Log.i(TAG, "isCommentLike test " + paramLong + " commentObj:" + paramb + " cache:" + (String)localObject + " likeFlag:" + paramb.eZI().likeFlag + " scene:" + paramInt + " result:" + bool);
      }
      AppMethodBeat.o(341677);
      return bool;
      bool = false;
      break;
      label291:
      localObject = (ConcurrentHashMap)this.Gaq.get(Long.valueOf(paramLong));
      if (localObject != null)
      {
        localObject = (f)((ConcurrentHashMap)localObject).get(new c(paramb.eZI().commentId, paramInt));
        if (localObject != null)
        {
          bool = ((f)localObject).GaB;
          localObject = "" + " get from cache " + ((f)localObject).GaB + ' ';
          continue;
        }
      }
      label390:
      localObject = "";
    }
  }
  
  public final int b(long paramLong, com.tencent.mm.plugin.finder.uniComments.storge.b paramb, int paramInt)
  {
    AppMethodBeat.i(341685);
    kotlin.g.b.s.u(paramb, "commentObj");
    if (paramLong == 0L)
    {
      paramInt = paramb.eZI().likeCount;
      AppMethodBeat.o(341685);
      return paramInt;
    }
    boolean bool1;
    Object localObject;
    boolean bool2;
    if (paramb.eZI().likeFlag == 1)
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
      localObject = (f)((ConcurrentHashMap)localObject).get(new c(paramb.eZI().commentId, 1));
      if (localObject == null) {
        break label292;
      }
      bool2 = ((f)localObject).GaB;
    }
    for (;;)
    {
      if ((bool1) && (bool1 != bool2))
      {
        paramInt = paramb.eZI().likeCount;
        AppMethodBeat.o(341685);
        return paramInt - 1;
        bool1 = false;
        break;
        label180:
        localObject = (ConcurrentHashMap)this.Gaq.get(Long.valueOf(paramLong));
        if (localObject == null) {
          break label292;
        }
        localObject = (f)((ConcurrentHashMap)localObject).get(new c(paramb.eZI().commentId, paramInt));
        if (localObject == null) {
          break label292;
        }
        bool2 = ((f)localObject).GaB;
        continue;
      }
      if ((!bool1) && (bool1 != bool2))
      {
        paramInt = paramb.eZI().likeCount;
        AppMethodBeat.o(341685);
        return paramInt + 1;
      }
      paramInt = paramb.eZI().likeCount;
      AppMethodBeat.o(341685);
      return paramInt;
      label292:
      bool2 = bool1;
    }
  }
  
  public final void fdz()
  {
    AppMethodBeat.i(341693);
    if (this.Gap.size() <= 0)
    {
      AppMethodBeat.o(341693);
      return;
    }
    a locala = (a)this.Gap.poll();
    long l1 = cn.bDu();
    long l2 = locala.Gae;
    int i = locala.Gad;
    a.a locala1 = com.tencent.mm.plugin.finder.upload.action.a.GcD;
    if (i < com.tencent.mm.plugin.finder.upload.action.a.feb())
    {
      locala1 = com.tencent.mm.plugin.finder.upload.action.a.GcD;
      if (l1 - l2 <= com.tencent.mm.plugin.finder.upload.action.a.fea()) {
        break label161;
      }
    }
    label161:
    for (boolean bool = false;; bool = true)
    {
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locala + " size:" + this.Gap.size());
      if (!bool) {
        break;
      }
      kotlin.g.b.s.s(locala, "action");
      a(locala);
      AppMethodBeat.o(341693);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr$KeyData;", "", "id", "", "scene", "", "(JI)V", "getId", "()J", "getScene", "()I", "equals", "", "other", "hashCode", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      AppMethodBeat.i(341600);
      int i = (this.id + '_' + this.scene).hashCode();
      AppMethodBeat.o(341600);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/action/UniLikeActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/uniComments/action/UniLikeActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.loader.f.e<e>
  {
    d(d paramd, a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.action.d
 * JD-Core Version:    0.7.0.1
 */
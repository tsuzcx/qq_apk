package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.autogen.a.if.a;
import com.tencent.mm.loader.f.a.a;
import com.tencent.mm.loader.f.a.f;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.plugin.finder.feed.model.n;
import com.tencent.mm.plugin.finder.view.FinderWordingLayout.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/WordingActionMgr;", "", "()V", "actionQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/finder/upload/action/WordingActionTask;", "deleteMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/upload/action/WordingActionMgr$KeyData;", "", "hasEditMap", "", "modeMap", "Lcom/tencent/mm/plugin/finder/view/FinderWordingLayout$Mode;", "onlyLikeModeMap", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "tryTask", "Ljava/lang/Runnable;", "wordingMap", "Lcom/tencent/mm/plugin/finder/upload/action/WordingLikeAction;", "doDeleteWording", "", "wordingItem", "Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;", "doLikeWording", "like", "doPost", "action", "getCurrentMode", "feedId", "isDelete", "isEdit", "isLike", "isOnlyLikeMode", "key", "likeCount", "listAfterDelete", "Lkotlin/Pair;", "", "", "list", "onlyLikeMode", "removeDeleteCache", "Lcom/tencent/mm/plugin/finder/upload/action/WordingOpAction;", "removeLikeCache", "removeUnuseAction", "setEdit", "hasEdit", "setMode", "mode", "tryNext", "Companion", "KeyData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final a Gds;
  private static final o Gdy;
  private static final String TAG;
  private com.tencent.mm.loader.f.d<p> Gag;
  private final Runnable Gai;
  private final ConcurrentLinkedQueue<e> Gap;
  public final ConcurrentHashMap<b, q> Gdt;
  private final ConcurrentHashMap<Long, Boolean> Gdu;
  private final ConcurrentHashMap<Long, Boolean> Gdv;
  public final ConcurrentHashMap<Long, FinderWordingLayout.b> Gdw;
  public final ConcurrentHashMap<b, Boolean> Gdx;
  
  static
  {
    AppMethodBeat.i(343455);
    Gds = new a((byte)0);
    TAG = "Finder.WordingActionMgr";
    Gdy = new o();
    AppMethodBeat.o(343455);
  }
  
  public o()
  {
    AppMethodBeat.i(343410);
    this.Gag = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new f((com.tencent.mm.loader.f.a.c)new a(100), new g(1, (byte)0), 1, "finder_action_wording_like_post_quene"));
    this.Gap = new ConcurrentLinkedQueue();
    this.Gdt = new ConcurrentHashMap();
    this.Gdu = new ConcurrentHashMap();
    this.Gdv = new ConcurrentHashMap();
    this.Gdw = new ConcurrentHashMap();
    this.Gdx = new ConcurrentHashMap();
    this.Gai = new o..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(343410);
  }
  
  private static final void a(o paramo)
  {
    AppMethodBeat.i(343427);
    s.u(paramo, "this$0");
    paramo.fdz();
    AppMethodBeat.o(343427);
  }
  
  public static b b(n paramn)
  {
    AppMethodBeat.i(343417);
    paramn = new b(paramn.feedId, paramn.YZe);
    AppMethodBeat.o(343417);
    return paramn;
  }
  
  public final void a(long paramLong, FinderWordingLayout.b paramb)
  {
    AppMethodBeat.i(343509);
    s.u(paramb, "mode");
    ((Map)this.Gdw).put(Long.valueOf(paramLong), paramb);
    AppMethodBeat.o(343509);
  }
  
  public final void a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(343498);
    s.u(paramn, "wordingItem");
    Log.i(TAG, "doLikeWording feedId = " + paramn.feedId + " buzzwordId = " + paramn.YZe + " buzzword = " + paramn.wording + " like = " + paramBoolean);
    Object localObject = new q(paramn, paramBoolean);
    ((Map)this.Gdt).put(b(paramn), localObject);
    a((e)localObject);
    localObject = new if();
    ((if)localObject).hJB.id = paramn.feedId;
    if.a locala = ((if)localObject).hJB;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locala.hJE = i;
      ((if)localObject).hJB.hJI = paramn.YZe;
      ((if)localObject).hJB.type = 25;
      ((if)localObject).publish();
      AppMethodBeat.o(343498);
      return;
    }
  }
  
  public final void a(final e parame)
  {
    AppMethodBeat.i(343503);
    this.Gag.a((com.tencent.mm.loader.f.c)new p(parame), (com.tencent.mm.loader.f.e)new c(this, parame));
    AppMethodBeat.o(343503);
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(343479);
    s.u(paramq, "action");
    b localb = b(paramq.GdD);
    q localq = (q)this.Gdt.get(localb);
    String str;
    StringBuilder localStringBuilder;
    if (localq != null) {
      if (BuildInfo.DEBUG)
      {
        str = TAG;
        localStringBuilder = new StringBuilder("removeLikeCache ").append(paramq).append(" result ");
        if (paramq.Gae < localq.Gae) {
          break label130;
        }
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      if (paramq.Gae >= localq.Gae) {
        this.Gdt.remove(localb);
      }
      AppMethodBeat.o(343479);
      return;
    }
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(343485);
    s.u(paramr, "action");
    b localb = b(paramr.GdD);
    if ((Boolean)this.Gdx.get(localb) != null)
    {
      if (BuildInfo.DEBUG) {
        Log.i(TAG, "removeLikeCache " + paramr + " result true");
      }
      this.Gdx.remove(localb);
    }
    AppMethodBeat.o(343485);
  }
  
  public final boolean a(n paramn)
  {
    boolean bool = false;
    AppMethodBeat.i(343471);
    s.u(paramn, "wordingItem");
    if (paramn.YZe == 0L)
    {
      if (paramn.hJr == 1)
      {
        AppMethodBeat.o(343471);
        return true;
      }
      AppMethodBeat.o(343471);
      return false;
    }
    if (paramn.hJr == 1) {
      bool = true;
    }
    paramn = (q)this.Gdt.get(b(paramn));
    if (paramn != null) {
      bool = paramn.GaB;
    }
    AppMethodBeat.o(343471);
    return bool;
  }
  
  public final void fdz()
  {
    AppMethodBeat.i(343489);
    e locale;
    boolean bool;
    do
    {
      if (this.Gap.size() <= 0)
      {
        AppMethodBeat.o(343489);
        return;
      }
      locale = (e)this.Gap.poll();
      bool = locale.isValid();
      Log.i(TAG, "tryNext isValid:" + bool + " action:" + locale + " size:" + this.Gap.size());
    } while (!bool);
    s.s(locale, "action");
    a(locale);
    AppMethodBeat.o(343489);
  }
  
  public final boolean qC(long paramLong)
  {
    AppMethodBeat.i(343465);
    Boolean localBoolean = (Boolean)this.Gdv.get(Long.valueOf(paramLong));
    if (localBoolean == null)
    {
      AppMethodBeat.o(343465);
      return false;
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(343465);
    return bool;
  }
  
  public final void qD(long paramLong)
  {
    AppMethodBeat.i(343468);
    ((Map)this.Gdv).put(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(343468);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/WordingActionMgr$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/finder/upload/action/WordingActionMgr;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/upload/action/WordingActionMgr;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/WordingActionMgr$KeyData;", "", "feedId", "", "buzzwordId", "(JJ)V", "getBuzzwordId", "()J", "getFeedId", "equals", "", "other", "hashCode", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private final long feedId;
    private final long hJI;
    
    public b(long paramLong1, long paramLong2)
    {
      this.feedId = paramLong1;
      this.hJI = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (paramObject != null) {
          break label23;
        }
      }
      label23:
      while ((paramObject.feedId != this.feedId) || (paramObject.hJI != this.hJI))
      {
        return false;
        paramObject = null;
        break;
      }
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(343451);
      int i = (this.feedId + '_' + this.hJI).hashCode();
      AppMethodBeat.o(343451);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/upload/action/WordingActionMgr$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/action/WordingActionTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.loader.f.e<p>
  {
    c(o paramo, e parame) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.o
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.h;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.a.v;
import d.g.b.v.e;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "getData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visiblePosition", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadingList", "Ljava/util/Vector;", "", "scene", "expandTopLevel2Comment", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "respList", "feedId", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "keep", "", "p0", "mergeLocalLevel2Comments", "localLevel2Comments", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "onDetach", "onEventHappen", "ev", "preloadFirstPageComment", "objectNonceId", "oldVersion", "feedUsername", "plugin-finder_release"})
public final class e
  extends com.tencent.mm.plugin.finder.event.base.f
  implements com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  final String TAG;
  private final MMActivity activity;
  private int qqE;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> quc;
  Vector<Long> qyA;
  private d.g.a.b<? super Integer, ? extends BaseFinderFeed> qyz;
  private int scene;
  
  public e(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(198141);
    this.activity = paramMMActivity;
    this.TAG = "Finder.FinderCommentPreloader";
    this.quc = new CopyOnWriteArraySet();
    this.scene = 2;
    this.qyA = new Vector();
    AppMethodBeat.o(198141);
  }
  
  public final void a(int paramInt1, int paramInt2, d.g.a.b<? super Integer, ? extends BaseFinderFeed> paramb)
  {
    this.qyz = paramb;
    this.scene = paramInt1;
    this.qqE = paramInt2;
  }
  
  public final void a(final long paramLong, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(198140);
    d.g.b.k.h(paramString2, "feedUsername");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (!com.tencent.mm.plugin.finder.storage.b.cpT())
    {
      ad.i(this.TAG, "***preloadFirstPageComment disable");
      AppMethodBeat.o(198140);
      return;
    }
    if (paramLong == 0L)
    {
      ad.i(this.TAG, "***preloadFirstPageComment feedId is 0");
      AppMethodBeat.o(198140);
      return;
    }
    if (!bt.gL(com.tencent.mm.plugin.finder.storage.data.c.qKo.R(paramLong, 0L)))
    {
      ad.i(this.TAG, "***preloadFirstPageComment has cache");
      AppMethodBeat.o(198140);
      return;
    }
    if (this.qyA.contains(Long.valueOf(paramLong)))
    {
      ad.i(this.TAG, "***preloadFirstPageComment is loading");
      AppMethodBeat.o(198140);
      return;
    }
    final v.e locale1 = new v.e();
    locale1.Jhw = ((List)v.Jgl);
    v.e locale2 = new v.e();
    locale2.Jhw = ((List)v.Jgl);
    locale1.Jhw = ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().qu(paramLong);
    if (!paramBoolean)
    {
      Object localObject2 = (Iterable)locale1.Jhw;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      label287:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((com.tencent.mm.plugin.finder.storage.k)localObject3).field_actionInfo.qoB != 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label287;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      locale2.Jhw = ((List)localObject1);
      localObject2 = (Iterable)locale1.Jhw;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label393:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((com.tencent.mm.plugin.finder.storage.k)localObject3).field_actionInfo.qoB == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label393;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      locale1.Jhw = ((List)localObject1);
    }
    this.qyA.add(Long.valueOf(paramLong));
    int i = this.scene;
    localObject1 = FinderReporterUIC.Ljl;
    localObject1 = FinderReporterUIC.a.lB((Context)this.activity);
    if (localObject1 != null) {}
    for (localObject1 = ((FinderReporterUIC)localObject1).fXs();; localObject1 = null)
    {
      new h(paramLong, paramString1, paramInt, i, paramString2, false, null, null, 0L, null, false, false, null, (dzp)localObject1, 8160).auK().h((com.tencent.mm.vending.c.a)new a(this, paramLong, locale2, locale1)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(198140);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(166034);
    d.g.b.k.h(paramc, "ev");
    if ((paramc instanceof i))
    {
      int i = ((i)paramc).qsi;
      int j = ((i)paramc).qsj;
      if (i > j)
      {
        AppMethodBeat.o(166034);
        return;
      }
      if (i <= j) {
        for (;;)
        {
          paramc = this.qyz;
          if (paramc != null)
          {
            paramc = (BaseFinderFeed)paramc.aA(Integer.valueOf(i));
            if (paramc != null) {
              a(paramc.feedObject.getId(), paramc.feedObject.getObjectNonceId(), this.qqE, paramc.feedObject.isOldVersion(), paramc.feedObject.getUserName());
            }
          }
          if (i == j) {
            break;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(166034);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.finder.event.base.c paramc)
  {
    AppMethodBeat.i(166035);
    d.g.b.k.h(paramd, "dispatcher");
    d.g.b.k.h(paramc, "event");
    if ((paramc instanceof i))
    {
      if ((((i)paramc).type == 0) || (((i)paramc).type == 5) || (((i)paramc).type == 4))
      {
        AppMethodBeat.o(166035);
        return true;
      }
      AppMethodBeat.o(166035);
      return false;
    }
    AppMethodBeat.o(166035);
    return false;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(166036);
    this.quc.add(parama);
    AppMethodBeat.o(166036);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166033);
    Iterator localIterator = ((Iterable)this.quc).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.vending.e.a)localIterator.next()).dead();
    }
    this.quc.clear();
    this.qyA.clear();
    AppMethodBeat.o(166033);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(e parame, long paramLong, v.e parame1, v.e parame2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.e
 * JD-Core Version:    0.7.0.1
 */
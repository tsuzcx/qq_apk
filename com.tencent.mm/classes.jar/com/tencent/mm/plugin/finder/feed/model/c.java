package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import d.a.v;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "getData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visiblePosition", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadingList", "Ljava/util/Vector;", "", "scene", "expandTopLevel2Comment", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "respList", "feedId", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "keep", "", "p0", "mergeLocalLevel2Comments", "localLevel2Comments", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "onDetach", "onEventHappen", "ev", "preloadFirstPageComment", "objectNonceId", "oldVersion", "feedUsername", "plugin-finder_release"})
public final class c
  extends d
  implements com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  final String TAG;
  private final MMActivity activity;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rfP;
  private int rfR;
  private d.g.a.b<? super Integer, ? extends BaseFinderFeed> rmB;
  Vector<Long> rmC;
  private int scene;
  
  public c(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(202050);
    this.activity = paramMMActivity;
    this.TAG = "Finder.FinderCommentPreloader";
    this.rfP = new CopyOnWriteArraySet();
    this.scene = 2;
    this.rmC = new Vector();
    AppMethodBeat.o(202050);
  }
  
  public final void a(int paramInt1, int paramInt2, d.g.a.b<? super Integer, ? extends BaseFinderFeed> paramb)
  {
    this.rmB = paramb;
    this.scene = paramInt1;
    this.rfR = paramInt2;
  }
  
  public final void a(final long paramLong, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(202049);
    k.h(paramString2, "feedUsername");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (!com.tencent.mm.plugin.finder.storage.b.czv())
    {
      ac.i(this.TAG, "***preloadFirstPageComment disable");
      AppMethodBeat.o(202049);
      return;
    }
    if (paramLong == 0L)
    {
      ac.i(this.TAG, "***preloadFirstPageComment feedId is 0");
      AppMethodBeat.o(202049);
      return;
    }
    if (!bs.gY(e.rEI.O(paramLong, 0L)))
    {
      ac.i(this.TAG, "***preloadFirstPageComment has cache");
      AppMethodBeat.o(202049);
      return;
    }
    if (this.rmC.contains(Long.valueOf(paramLong)))
    {
      ac.i(this.TAG, "***preloadFirstPageComment is loading");
      AppMethodBeat.o(202049);
      return;
    }
    final v.f localf1 = new v.f();
    localf1.KUQ = ((List)v.KTF);
    v.f localf2 = new v.f();
    localf2.KUQ = ((List)v.KTF);
    localf1.KUQ = ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().uK(paramLong);
    if (!paramBoolean)
    {
      Object localObject2 = (Iterable)localf1.KUQ;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      label287:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((t)localObject3).field_actionInfo.qXu != 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label287;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf2.KUQ = ((List)localObject1);
      localObject2 = (Iterable)localf1.KUQ;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label393:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((t)localObject3).field_actionInfo.qXu == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label393;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf1.KUQ = ((List)localObject1);
    }
    this.rmC.add(Long.valueOf(paramLong));
    int i = this.scene;
    localObject1 = FinderReporterUIC.seQ;
    localObject1 = FinderReporterUIC.a.eV((Context)this.activity);
    if (localObject1 != null) {}
    for (localObject1 = ((FinderReporterUIC)localObject1).cGb();; localObject1 = null)
    {
      new m(paramLong, paramString1, paramInt, i, paramString2, false, null, null, 0L, null, false, false, null, (anm)localObject1, 8160).aBB().h((com.tencent.mm.vending.c.a)new a(this, paramLong, localf2, localf1)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(202049);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(166034);
    k.h(paramb, "ev");
    if ((paramb instanceof h))
    {
      int i = ((h)paramb).rdH;
      int j = ((h)paramb).rdJ;
      if (i > j)
      {
        AppMethodBeat.o(166034);
        return;
      }
      if (i <= j) {
        for (;;)
        {
          paramb = this.rmB;
          if (paramb != null)
          {
            paramb = (BaseFinderFeed)paramb.ay(Integer.valueOf(i));
            if (paramb != null) {
              a(paramb.feedObject.getId(), paramb.feedObject.getObjectNonceId(), this.rfR, paramb.feedObject.isOldVersion(), paramb.feedObject.getUserName());
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
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(166035);
    k.h(paramc, "dispatcher");
    k.h(paramb, "event");
    if ((paramb instanceof h))
    {
      if ((((h)paramb).type == 0) || (((h)paramb).type == 5) || (((h)paramb).type == 4))
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
    this.rfP.add(parama);
    AppMethodBeat.o(166036);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166033);
    Iterator localIterator = ((Iterable)this.rfP).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.vending.e.a)localIterator.next()).dead();
    }
    this.rfP.clear();
    this.rmC.clear();
    AppMethodBeat.o(166033);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(c paramc, long paramLong, v.f paramf1, v.f paramf2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.c
 * JD-Core Version:    0.7.0.1
 */
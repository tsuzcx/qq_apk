package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.q;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.a.v;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "getData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visiblePosition", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadingList", "Ljava/util/Vector;", "", "scene", "cacheLevel2FirstAuthorComment", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "barrageCommentInfo", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "feedId", "expandTopLevel2Comment", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "respList", "filterComment", "data", "itemList", "", "getFeedByPosToLoad", "", "pos", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "keep", "p0", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "onDetach", "onEventHappen", "ev", "preloadComment", "objectNonceId", "oldVersion", "feedUsername", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullScene", "preloadFirstPageComment", "preloadNextPageComment", "lastBuf", "plugin-finder_release"})
public final class d
  extends com.tencent.mm.plugin.finder.event.base.d
  implements com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  final String TAG;
  private final MMActivity activity;
  private int scene;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> scf;
  private int sch;
  private d.g.a.b<? super Integer, ? extends BaseFinderFeed> sjW;
  Vector<Long> sjX;
  
  public d(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(202789);
    this.activity = paramMMActivity;
    this.TAG = "Finder.FinderCommentPreloader";
    this.scf = new CopyOnWriteArraySet();
    this.scene = 2;
    this.sjX = new Vector();
    AppMethodBeat.o(202789);
  }
  
  private final void EP(int paramInt)
  {
    AppMethodBeat.i(202786);
    Object localObject = this.sjW;
    if (localObject != null)
    {
      localObject = (BaseFinderFeed)((d.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        a(((BaseFinderFeed)localObject).feedObject.getId(), ((BaseFinderFeed)localObject).feedObject.getObjectNonceId(), this.sch, ((BaseFinderFeed)localObject).feedObject.isOldVersion(), ((BaseFinderFeed)localObject).feedObject.getUserName());
        AppMethodBeat.o(202786);
        return;
      }
    }
    AppMethodBeat.o(202786);
  }
  
  public final void a(int paramInt1, int paramInt2, d.g.a.b<? super Integer, ? extends BaseFinderFeed> paramb)
  {
    AppMethodBeat.i(202785);
    ae.i(this.TAG, "onAttach");
    this.sjW = paramb;
    this.scene = paramInt1;
    this.sch = paramInt2;
    AppMethodBeat.o(202785);
  }
  
  public final void a(final long paramLong, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(202787);
    p.h(paramString2, "feedUsername");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (!com.tencent.mm.plugin.finder.storage.b.cIf())
    {
      ae.i(this.TAG, "***preloadFirstPageComment disable");
      AppMethodBeat.o(202787);
      return;
    }
    if (paramLong == 0L)
    {
      ae.i(this.TAG, "***preloadFirstPageComment feedId is 0");
      AppMethodBeat.o(202787);
      return;
    }
    if ((!bu.ht(e.sKJ.O(paramLong, 0L))) && (!bu.ht(e.sKJ.xm(paramLong))))
    {
      ae.i(this.TAG, "***preloadFirstPageComment has cache");
      AppMethodBeat.o(202787);
      return;
    }
    if (this.sjX.contains(Long.valueOf(paramLong)))
    {
      ae.i(this.TAG, "***preloadFirstPageComment is loading");
      AppMethodBeat.o(202787);
      return;
    }
    final y.f localf1 = new y.f();
    localf1.NiY = ((List)v.NhH);
    y.f localf2 = new y.f();
    localf2.NiY = ((List)v.NhH);
    localf1.NiY = ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().xc(paramLong);
    if (!paramBoolean)
    {
      Object localObject2 = (Iterable)localf1.NiY;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      label300:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((ab)localObject3).field_actionInfo.rQN != 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label300;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf2.NiY = ((List)localObject1);
      localObject2 = (Iterable)localf1.NiY;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label406:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((ab)localObject3).field_actionInfo.rQN == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label406;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf1.NiY = ((List)localObject1);
    }
    this.sjX.add(Long.valueOf(paramLong));
    int i = this.scene;
    localObject1 = FinderReporterUIC.tnG;
    localObject1 = FinderReporterUIC.a.fc((Context)this.activity);
    if (localObject1 != null) {}
    for (localObject1 = ((FinderReporterUIC)localObject1).cQZ();; localObject1 = null)
    {
      new q(paramLong, paramString1, paramInt, i, paramString2, false, null, null, 0L, null, false, false, null, (arn)localObject1, 3, 8160).aET().h((com.tencent.mm.vending.c.a)new a(this, paramLong, localf2, localf1)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(202787);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(166034);
    p.h(paramb, "ev");
    if ((paramb instanceof h))
    {
      int k = ((h)paramb).rZF;
      int m = ((h)paramb).rZH;
      if (k > m)
      {
        AppMethodBeat.o(166034);
        return;
      }
      int j = ((h)paramb).rZM;
      if (j <= m)
      {
        i = j;
        for (;;)
        {
          EP(i);
          if (i == m) {
            break;
          }
          i += 1;
        }
      }
      int i = j - 1;
      if (i >= k) {
        for (;;)
        {
          EP(i);
          if (i == k) {
            break;
          }
          i -= 1;
        }
      }
    }
    AppMethodBeat.o(166034);
  }
  
  public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(166035);
    p.h(paramc, "dispatcher");
    p.h(paramb, "event");
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
  
  final ha b(LinkedList<FinderCommentInfo> arg1, long paramLong)
  {
    AppMethodBeat.i(202788);
    List localList = (List)new ArrayList();
    Object localObject2 = (Iterable)???;
    ??? = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderCommentInfo)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.sLo;
      ???.add(com.tencent.mm.plugin.finder.storage.logic.a.b((FinderCommentInfo)localObject3, paramLong));
    }
    localList.addAll((Collection)???);
    ??? = (List)new ArrayList();
    localObject2 = (Iterable)localList;
    int i = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        j.gkd();
      }
      localObject3 = (n)localObject3;
      ???.add(localObject3);
      if ((((n)localObject3).ste.field_actionInfo.rQN == 0L) && (((n)localObject3).ste.cLl().levelTwoComment.size() > 0) && ((i >= localList.size() - 1) || (((n)localList.get(i + 1)).ste.field_actionInfo.rQN == 0L)))
      {
        int k = ((n)localObject3).ste.cLl().levelTwoComment.size();
        i = 0;
        for (;;)
        {
          if (i >= k) {
            break label382;
          }
          localObject4 = (FinderCommentInfo)((n)localObject3).ste.cLl().levelTwoComment.remove();
          com.tencent.mm.plugin.finder.storage.logic.a locala = com.tencent.mm.plugin.finder.storage.logic.a.sLo;
          p.g(localObject4, "level2CommentInfo");
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.b((FinderCommentInfo)localObject4, paramLong, ((n)localObject3).ste.cLl().commentId);
          if (((n)localObject4).ste.cLt())
          {
            ((n)localObject4).std = true;
            ???.add(localObject4);
            i = j;
            break;
          }
          i += 1;
        }
      }
      label382:
      i = j;
    }
    Object localObject3 = new ha();
    ((ha)localObject3).duv.duw = paramLong;
    if (!bu.ht(???))
    {
      localObject2 = e.sKJ;
      localObject4 = (Iterable)???;
      ??? = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ???.add(((n)((Iterator)localObject4).next()).ste);
      }
      localObject4 = (List)???;
      p.h(localObject4, "comments");
    }
    for (;;)
    {
      try
      {
        synchronized (e.sKJ)
        {
          e.sKI.remove(new e.a(paramLong, 0L));
          e.sKI.put(new e.a(paramLong, 0L), localObject4);
          ae.i(this.TAG, "add bullet subtitle cache succ, feedId: " + paramLong + ", size:" + localList.size());
          ((ha)localObject3).duv.dux = false;
          AppMethodBeat.o(202788);
          return localObject3;
        }
        ((ha)localObject3).duv.dux = true;
      }
      finally
      {
        AppMethodBeat.o(202788);
      }
    }
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(166036);
    this.scf.add(parama);
    AppMethodBeat.o(166036);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166033);
    ae.i(this.TAG, "onDetach");
    this.sjW = null;
    Iterator localIterator = ((Iterable)this.scf).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.vending.e.a)localIterator.next()).dead();
    }
    this.scf.clear();
    this.sjX.clear();
    AppMethodBeat.o(166033);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(d paramd, long paramLong, y.f paramf1, y.f paramf2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.q;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "getData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visiblePosition", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadingList", "Ljava/util/Vector;", "", "scene", "cacheLevel2FirstAuthorComment", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "barrageCommentInfo", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "feedId", "expandTopLevel2Comment", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "respList", "filterComment", "data", "itemList", "", "getFeedByPosToLoad", "", "pos", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "keep", "p0", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "onDetach", "onEventHappen", "ev", "preloadComment", "objectNonceId", "oldVersion", "feedUsername", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullScene", "preloadFirstPageComment", "preloadNextPageComment", "lastBuf", "plugin-finder_release"})
public final class d
  extends com.tencent.mm.plugin.finder.event.base.d
  implements com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  final String TAG;
  private final MMActivity activity;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rTB;
  private int rTD;
  private d.g.a.b<? super Integer, ? extends BaseFinderFeed> sbh;
  Vector<Long> sbi;
  private int scene;
  
  public d(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(202323);
    this.activity = paramMMActivity;
    this.TAG = "Finder.FinderCommentPreloader";
    this.rTB = new CopyOnWriteArraySet();
    this.scene = 2;
    this.sbi = new Vector();
    AppMethodBeat.o(202323);
  }
  
  private final void EC(int paramInt)
  {
    AppMethodBeat.i(202320);
    Object localObject = this.sbh;
    if (localObject != null)
    {
      localObject = (BaseFinderFeed)((d.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        a(((BaseFinderFeed)localObject).feedObject.getId(), ((BaseFinderFeed)localObject).feedObject.getObjectNonceId(), this.rTD, ((BaseFinderFeed)localObject).feedObject.isOldVersion(), ((BaseFinderFeed)localObject).feedObject.getUserName());
        AppMethodBeat.o(202320);
        return;
      }
    }
    AppMethodBeat.o(202320);
  }
  
  public final void a(int paramInt1, int paramInt2, d.g.a.b<? super Integer, ? extends BaseFinderFeed> paramb)
  {
    AppMethodBeat.i(202319);
    ad.i(this.TAG, "onAttach");
    this.sbh = paramb;
    this.scene = paramInt1;
    this.rTD = paramInt2;
    AppMethodBeat.o(202319);
  }
  
  public final void a(final long paramLong, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(202321);
    p.h(paramString2, "feedUsername");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (!com.tencent.mm.plugin.finder.storage.b.cGi())
    {
      ad.i(this.TAG, "***preloadFirstPageComment disable");
      AppMethodBeat.o(202321);
      return;
    }
    if (paramLong == 0L)
    {
      ad.i(this.TAG, "***preloadFirstPageComment feedId is 0");
      AppMethodBeat.o(202321);
      return;
    }
    if ((!bt.hj(e.szM.P(paramLong, 0L))) && (!bt.hj(e.szM.wV(paramLong))))
    {
      ad.i(this.TAG, "***preloadFirstPageComment has cache");
      AppMethodBeat.o(202321);
      return;
    }
    if (this.sbi.contains(Long.valueOf(paramLong)))
    {
      ad.i(this.TAG, "***preloadFirstPageComment is loading");
      AppMethodBeat.o(202321);
      return;
    }
    final y.f localf1 = new y.f();
    localf1.MLV = ((List)v.MKE);
    y.f localf2 = new y.f();
    localf2.MLV = ((List)v.MKE);
    localf1.MLV = ((PluginFinder)g.ad(PluginFinder.class)).getFinderActionStorage().wL(paramLong);
    if (!paramBoolean)
    {
      Object localObject2 = (Iterable)localf1.MLV;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      label300:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((ab)localObject3).field_actionInfo.rID != 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label300;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf2.MLV = ((List)localObject1);
      localObject2 = (Iterable)localf1.MLV;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label406:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((ab)localObject3).field_actionInfo.rID == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label406;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf1.MLV = ((List)localObject1);
    }
    this.sbi.add(Long.valueOf(paramLong));
    int i = this.scene;
    localObject1 = FinderReporterUIC.tcM;
    localObject1 = FinderReporterUIC.a.eY((Context)this.activity);
    if (localObject1 != null) {}
    for (localObject1 = ((FinderReporterUIC)localObject1).cOu();; localObject1 = null)
    {
      new q(paramLong, paramString1, paramInt, i, paramString2, false, null, null, 0L, null, false, false, null, (aqy)localObject1, 3, 8160).aED().h((com.tencent.mm.vending.c.a)new a(this, paramLong, localf2, localf1)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(202321);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(166034);
    p.h(paramb, "ev");
    if ((paramb instanceof h))
    {
      int k = ((h)paramb).rRd;
      int m = ((h)paramb).rRf;
      if (k > m)
      {
        AppMethodBeat.o(166034);
        return;
      }
      int j = ((h)paramb).rRk;
      if (j <= m)
      {
        i = j;
        for (;;)
        {
          EC(i);
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
          EC(i);
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
  
  final gz b(LinkedList<FinderCommentInfo> arg1, long paramLong)
  {
    AppMethodBeat.i(202322);
    List localList = (List)new ArrayList();
    Object localObject2 = (Iterable)???;
    ??? = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderCommentInfo)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.sAq;
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
        j.gfB();
      }
      localObject3 = (m)localObject3;
      ???.add(localObject3);
      if ((((m)localObject3).skh.field_actionInfo.rID == 0L) && (((m)localObject3).skh.field_actionInfo.Gla.levelTwoComment.size() > 0) && ((i >= localList.size() - 1) || (((m)localList.get(i + 1)).skh.field_actionInfo.rID == 0L)))
      {
        int k = ((m)localObject3).skh.field_actionInfo.Gla.levelTwoComment.size();
        i = 0;
        for (;;)
        {
          if (i >= k) {
            break label394;
          }
          localObject4 = (FinderCommentInfo)((m)localObject3).skh.field_actionInfo.Gla.levelTwoComment.remove();
          com.tencent.mm.plugin.finder.storage.logic.a locala = com.tencent.mm.plugin.finder.storage.logic.a.sAq;
          p.g(localObject4, "level2CommentInfo");
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.b((FinderCommentInfo)localObject4, paramLong, ((m)localObject3).skh.field_actionInfo.Gla.commentId);
          if (((m)localObject4).skh.cIR())
          {
            ((m)localObject4).skg = true;
            ???.add(localObject4);
            i = j;
            break;
          }
          i += 1;
        }
      }
      label394:
      i = j;
    }
    Object localObject3 = new gz();
    ((gz)localObject3).dtp.dtq = paramLong;
    if (!bt.hj(???))
    {
      localObject2 = e.szM;
      localObject4 = (Iterable)???;
      ??? = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ???.add(((m)((Iterator)localObject4).next()).skh);
      }
      localObject4 = (List)???;
      p.h(localObject4, "comments");
    }
    for (;;)
    {
      try
      {
        synchronized (e.szM)
        {
          e.szL.remove(new e.a(paramLong, 0L));
          e.szL.put(new e.a(paramLong, 0L), localObject4);
          ad.i(this.TAG, "add bullet subtitle cache succ, feedId: " + paramLong + ", size:" + localList.size());
          ((gz)localObject3).dtp.dtr = false;
          AppMethodBeat.o(202322);
          return localObject3;
        }
        ((gz)localObject3).dtp.dtr = true;
      }
      finally
      {
        AppMethodBeat.o(202322);
      }
    }
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(166036);
    this.rTB.add(parama);
    AppMethodBeat.o(166036);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166033);
    ad.i(this.TAG, "onDetach");
    this.sbh = null;
    Iterator localIterator = ((Iterable)this.rTB).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.vending.e.a)localIterator.next()).dead();
    }
    this.rTB.clear();
    this.sbi.clear();
    AppMethodBeat.o(166033);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(d paramd, long paramLong, y.f paramf1, y.f paramf2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.d
 * JD-Core Version:    0.7.0.1
 */
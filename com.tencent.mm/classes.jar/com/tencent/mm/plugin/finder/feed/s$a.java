package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "tabType", "(Lcom/tencent/mm/ui/MMActivity;II)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getScene", "()I", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "requestRefresh", "plugin-finder_release"})
public final class s$a
  extends v.a
{
  private final int scene;
  private final com.tencent.mm.plugin.finder.feed.model.d tLy;
  private final f tLz;
  
  private s$a(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(243920);
    this.scene = paramInt;
    this.dLS = 0;
    a locala = a.PRN;
    this.tLy = ((FinderCommentPreloaderUIC)a.b((AppCompatActivity)paramMMActivity).get(FinderCommentPreloaderUIC.class)).tLy;
    locala = a.PRN;
    this.tLz = ((FinderLiveNoticePreLoadUIC)a.b((AppCompatActivity)paramMMActivity).get(FinderLiveNoticePreLoadUIC.class)).wyi;
    AppMethodBeat.o(243920);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, v.b paramb)
  {
    AppMethodBeat.i(243917);
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.tLy.a(this.scene, this.tCE, (b)new a(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.wzC;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.fH((Context)this.gte);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
      }
    }
    this.tLz.e((kotlin.g.a.m)new b(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.wzC;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.fH((Context)this.gte);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
        AppMethodBeat.o(243917);
        return;
      }
    }
    AppMethodBeat.o(243917);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.m paramm)
  {
    AppMethodBeat.i(243919);
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramm, "menu");
    y localy = y.vXH;
    if (!y.h(paramBaseFinderFeed)) {
      paramm.b(this.tLD, (CharSequence)this.gte.getString(2131763162), 2131690233);
    }
    super.a(paramBaseFinderFeed, paramm);
    AppMethodBeat.o(243919);
  }
  
  public final void a(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(243916);
    p.h(paramc, "reason");
    h.a(h.veu, 2, false, null, 12);
    AppMethodBeat.o(243916);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(243914);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(243914);
      return;
    }
    AppMethodBeat.o(243914);
  }
  
  public final void dcd()
  {
    AppMethodBeat.i(243915);
    Object localObject = h.veu;
    a locala = a.PRN;
    h.a((h)localObject, 2, false, ((FinderReporterUIC)a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).dIx(), 8);
    localObject = k.vkd;
    k.b(null, s.p.voA, "16", com.tencent.mm.plugin.finder.report.live.c.vjh);
    AppMethodBeat.o(243915);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(243918);
    this.tLy.onDetach();
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.gte);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
      }
    }
    this.tLz.onDetach();
    localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.gte);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
      }
    }
    localObject = h.veu;
    localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.gte);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      h.e(2, (bbn)localObject);
      super.onDetach();
      AppMethodBeat.o(243918);
      return;
    }
  }
  
  public final void requestRefresh() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, bo>
  {
    a(s.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.m<Integer, Integer, LinkedList<bo>>
  {
    b(s.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.s.a
 * JD-Core Version:    0.7.0.1
 */
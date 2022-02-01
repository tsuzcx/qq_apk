package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.f;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class q$a
  extends v.a
{
  private final int scene;
  private final com.tencent.mm.plugin.finder.feed.model.d tLy;
  private final f tLz;
  
  public q$a(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(243882);
    this.scene = paramInt;
    a locala = a.PRN;
    this.tLy = ((FinderCommentPreloaderUIC)a.b((AppCompatActivity)paramMMActivity).get(FinderCommentPreloaderUIC.class)).tLy;
    locala = a.PRN;
    this.tLz = ((FinderLiveNoticePreLoadUIC)a.b((AppCompatActivity)paramMMActivity).get(FinderLiveNoticePreLoadUIC.class)).wyi;
    AppMethodBeat.o(243882);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, v.b paramb)
  {
    AppMethodBeat.i(243880);
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
    this.tLz.e((m)new b(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.wzC;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.fH((Context)this.gte);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
        AppMethodBeat.o(243880);
        return;
      }
    }
    AppMethodBeat.o(243880);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(243879);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(243879);
      return;
    }
    AppMethodBeat.o(243879);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(243881);
    this.tLy.onDetach();
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.gte);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
      }
    }
    this.tLz.onDetach();
    localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.gte);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
      }
    }
    super.onDetach();
    AppMethodBeat.o(243881);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(243878);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(243878);
      return;
    }
    AppMethodBeat.o(243878);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, bo>
  {
    a(q.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, LinkedList<bo>>
  {
    b(q.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.q.a
 * JD-Core Version:    0.7.0.1
 */
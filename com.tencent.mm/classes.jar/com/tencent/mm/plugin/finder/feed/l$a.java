package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.j.a;
import com.tencent.mm.plugin.findersdk.a.ar;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;JI)V", "cacheVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTimelineRefCacheVM;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getFeedId", "()J", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$a
  extends ae.a
{
  private final com.tencent.mm.plugin.finder.viewmodel.j AVj;
  private final i Aye;
  private final com.tencent.mm.plugin.findersdk.a.as Ayf;
  private final long feedId;
  private final int scene;
  
  public l$a(MMActivity paramMMActivity, long paramLong, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(363107);
    this.feedId = paramLong;
    this.scene = paramInt;
    k localk = k.aeZF;
    this.Aye = ((com.tencent.mm.plugin.finder.viewmodel.component.j)k.d((AppCompatActivity)paramMMActivity).q(com.tencent.mm.plugin.finder.viewmodel.component.j.class)).Aye;
    localk = k.aeZF;
    this.Ayf = ((ar)k.d((AppCompatActivity)paramMMActivity).cq(ar.class)).eiJ();
    paramMMActivity = k.aeZF;
    paramMMActivity = k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.j.class);
    s.s(paramMMActivity, "UICProvider.of(PluginFin…neRefCacheVM::class.java)");
    this.AVj = ((com.tencent.mm.plugin.finder.viewmodel.j)paramMMActivity);
    AppMethodBeat.o(363107);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, ae.b paramb)
  {
    AppMethodBeat.i(363138);
    s.u(paramBaseFinderFeedLoader, "model");
    s.u(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.Aye.a(this.scene, this.AJo, (b)new a(this));
    paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
      }
    }
    paramb = this.Ayf;
    m localm = (m)new b(this);
    paramBaseFinderFeedLoader = this.ATo;
    if (paramBaseFinderFeedLoader == null) {}
    for (paramBaseFinderFeedLoader = null;; paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.ATx.getRecyclerView())
    {
      paramb.a(localm, paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
        if (paramBaseFinderFeedLoader != null) {
          paramBaseFinderFeedLoader.a(this.Ayf.edV());
        }
      }
      AppMethodBeat.o(363138);
      return;
    }
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(363123);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localBaseFinderFeedLoader, false, 1, null);
    }
    AppMethodBeat.o(363123);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(363147);
    this.Aye.onDetach();
    Object localObject2 = this.AVj;
    String str = String.valueOf(this.feedId);
    Object localObject1 = this.ALH;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label300;
      }
    }
    label300:
    for (localObject1 = new ArrayList();; localObject1 = (ArrayList)localObject1)
    {
      s.u(str, "key");
      s.u(localObject1, "lastDataList");
      Log.i("Finder.TimelineCacheVM", "[store] key=" + str + " lastExitPosition=0 lastExitFromTopPx=0 lastDataList size=" + ((ArrayList)localObject1).size() + " current=" + f.formatTime("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis() / 1000L));
      localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.j)localObject2).GLu;
      j.a locala = new j.a(str);
      locala.GKx = 0;
      locala.GKy = 0;
      localObject1 = (List)localObject1;
      s.u(localObject1, "<set-?>");
      locala.GLv = ((List)localObject1);
      locala.GKz = System.currentTimeMillis();
      localObject1 = ah.aiuX;
      ((com.tencent.mm.loader.g.d)localObject2).put(str, locala);
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = as.a.hu((Context)this.lzt);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
        }
      }
      this.Ayf.onDetach();
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = as.a.hu((Context)this.lzt);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((c)localObject1).b(this.Ayf.edV());
        }
      }
      super.onDetach();
      AppMethodBeat.o(363147);
      return;
      localObject1 = ((BaseFinderFeedLoader)localObject1).getDataListJustForAdapter();
      break;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(363114);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      localBaseFinderFeedLoader.requestRefresh();
    }
    AppMethodBeat.o(363114);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Integer, cc>
  {
    a(l.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Integer, Integer, LinkedList<cc>>
  {
    b(l.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.l.a
 * JD-Core Version:    0.7.0.1
 */
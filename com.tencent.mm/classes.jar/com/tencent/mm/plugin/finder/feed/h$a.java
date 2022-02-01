package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.ab;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ar;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "observerForExposeReport", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "getScene", "()I", "createFirstMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "from", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onRefreshEnd", "reportFav", "action", "", "isClick", "", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h$a
  extends ae.a
{
  private com.tencent.mm.plugin.finder.event.base.d AUT;
  private final com.tencent.mm.plugin.finder.feed.model.i Aye;
  private final com.tencent.mm.plugin.findersdk.a.as Ayf;
  private final int scene;
  
  public h$a(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(363179);
    this.scene = paramInt;
    k localk = k.aeZF;
    this.Aye = ((com.tencent.mm.plugin.finder.viewmodel.component.j)k.d((AppCompatActivity)paramMMActivity).q(com.tencent.mm.plugin.finder.viewmodel.component.j.class)).Aye;
    localk = k.aeZF;
    this.Ayf = ((ar)k.d((AppCompatActivity)paramMMActivity).cq(ar.class)).eiJ();
    AppMethodBeat.o(363179);
  }
  
  private final void g(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(363188);
    Object localObject = k.aeZF;
    bui localbui = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
    if (paramInt == 1) {}
    for (localObject = "forward";; localObject = "tridot")
    {
      locali.m("ref_eid", localObject);
      localObject = bb.FuK;
      bb.a(localbui, paramString, paramBoolean, (JSONObject)locali);
      AppMethodBeat.o(363188);
      return;
    }
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, ae.b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(363215);
    kotlin.g.b.s.u(paramBaseFinderFeedLoader, "model");
    kotlin.g.b.s.u(paramb, "callback");
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
    paramBaseFinderFeedLoader = k.aeZF;
    this.AUT = new ab(((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou()).AUT;
    paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
    if (paramBaseFinderFeedLoader != null)
    {
      localObject2 = ((bn)paramBaseFinderFeedLoader).Vm(-1);
      if (localObject2 != null)
      {
        paramb = this.AUT;
        paramBaseFinderFeedLoader = paramb;
        if (paramb == null)
        {
          kotlin.g.b.s.bIx("observerForExposeReport");
          paramBaseFinderFeedLoader = null;
        }
        ((com.tencent.mm.plugin.finder.event.base.c)localObject2).a(paramBaseFinderFeedLoader);
      }
    }
    paramb = this.Ayf;
    Object localObject2 = (m)new b(this);
    paramBaseFinderFeedLoader = this.ATo;
    if (paramBaseFinderFeedLoader == null) {}
    for (paramBaseFinderFeedLoader = localObject1;; paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.ATx.getRecyclerView())
    {
      paramb.a((m)localObject2, paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
        if (paramBaseFinderFeedLoader != null) {
          paramBaseFinderFeedLoader.a(this.Ayf.edV());
        }
      }
      AppMethodBeat.o(363215);
      return;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(363245);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    kotlin.g.b.s.u(paramj, "holder");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, paramj);
    paramInt1 = paramMenuItem.getItemId();
    if (paramInt1 == ebq())
    {
      g("fav", true, paramInt2);
      AppMethodBeat.o(363245);
      return;
    }
    if (paramInt1 == ebr()) {
      g("unfav", true, paramInt2);
    }
    AppMethodBeat.o(363245);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params, int paramInt)
  {
    AppMethodBeat.i(363238);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(params, "menu");
    super.a(paramBaseFinderFeed, params, paramInt);
    params = av.GiL;
    int i;
    if (av.D(paramBaseFinderFeed.feedObject.getFeedObject()))
    {
      params = com.tencent.mm.plugin.finder.upload.action.c.GcH;
      if (!com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramBaseFinderFeed.feedObject.getFeedObject()))
      {
        i = 1;
        if (i == 0) {
          break label148;
        }
        g("fav", false, paramInt);
      }
    }
    else
    {
      label81:
      paramBaseFinderFeed = k.aeZF;
      params = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
      paramBaseFinderFeed = bb.FuK;
      if (paramInt != 1) {
        break label160;
      }
    }
    label148:
    label160:
    for (paramBaseFinderFeed = "forward";; paramBaseFinderFeed = "tridot")
    {
      bb.a(params, paramBaseFinderFeed, true, (JSONObject)new com.tencent.mm.ad.i());
      AppMethodBeat.o(363238);
      return;
      i = 0;
      break;
      g("unfav", false, paramInt);
      break label81;
    }
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(363204);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localBaseFinderFeedLoader, false, 1, null);
    }
    AppMethodBeat.o(363204);
  }
  
  public final void eby()
  {
    AppMethodBeat.i(363229);
    super.eby();
    ce localce = (ce)h.ax(ce.class);
    Object localObject = this.ATo;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((b.b)localObject).ATx.getRecyclerView())
    {
      localce.b((RecyclerView)localObject, q.w.DwQ, "21", com.tencent.mm.plugin.finder.live.report.d.Dnh);
      AppMethodBeat.o(363229);
      return;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(363221);
    this.Aye.onDetach();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
      }
    }
    this.Ayf.onDetach();
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b(this.Ayf.edV());
      }
    }
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.event.base.c localc = ((bn)localObject).Vm(-1);
      if (localc != null)
      {
        com.tencent.mm.plugin.finder.event.base.d locald = this.AUT;
        localObject = locald;
        if (locald == null)
        {
          kotlin.g.b.s.bIx("observerForExposeReport");
          localObject = null;
        }
        localc.b((com.tencent.mm.plugin.finder.event.base.d)localObject);
      }
    }
    super.onDetach();
    AppMethodBeat.o(363221);
  }
  
  public final void requestRefresh() {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Integer, cc>
  {
    a(h.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Integer, Integer, LinkedList<cc>>
  {
    b(h.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.h.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.live.component.y;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.q;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "observerForExposeReport", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "getScene", "()I", "createFirstMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "from", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onRefreshEnd", "reportFav", "action", "", "isClick", "", "requestRefresh", "plugin-finder_release"})
public final class h$a
  extends aa.a
{
  private final int scene;
  private final com.tencent.mm.plugin.finder.feed.model.i xve;
  private final com.tencent.mm.plugin.finder.feed.model.k xvf;
  private d xxI;
  
  public h$a(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity);
    AppMethodBeat.i(286492);
    this.scene = paramInt;
    g localg = g.Xox;
    this.xve = ((com.tencent.mm.plugin.finder.viewmodel.component.l)g.b((AppCompatActivity)paramMMActivity).i(com.tencent.mm.plugin.finder.viewmodel.component.l.class)).xve;
    localg = g.Xox;
    this.xvf = ((y)g.b((AppCompatActivity)paramMMActivity).i(y.class)).yci;
    AppMethodBeat.o(286492);
  }
  
  private final void h(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(286491);
    Object localObject = g.Xox;
    bid localbid = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
    if (paramInt == 1) {}
    for (localObject = "forward";; localObject = "tridot")
    {
      locali.g("ref_eid", localObject);
      localObject = am.zZN;
      am.a(localbid, paramString, paramBoolean, (JSONObject)locali);
      AppMethodBeat.o(286491);
      return;
    }
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, aa.b paramb)
  {
    AppMethodBeat.i(286486);
    kotlin.g.b.p.k(paramBaseFinderFeedLoader, "model");
    kotlin.g.b.p.k(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.xve.a(this.scene, this.xkX, (b)new a(this));
    paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((d)this.xve);
      }
    }
    paramBaseFinderFeedLoader = g.Xox;
    this.xxI = new com.tencent.mm.plugin.finder.report.p(((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY()).xxI;
    paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramb = this.xxI;
        if (paramb == null) {
          kotlin.g.b.p.bGy("observerForExposeReport");
        }
        paramBaseFinderFeedLoader.a(paramb);
      }
    }
    paramb = this.xvf;
    m localm = (m)new b(this);
    paramBaseFinderFeedLoader = this.xvC;
    if (paramBaseFinderFeedLoader != null) {}
    for (paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.xvJ.getRecyclerView();; paramBaseFinderFeedLoader = null)
    {
      paramb.a(localm, paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
      if (paramBaseFinderFeedLoader == null) {
        break;
      }
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader == null) {
        break;
      }
      paramBaseFinderFeedLoader.a((d)this.xvf);
      AppMethodBeat.o(286486);
      return;
    }
    AppMethodBeat.o(286486);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(286490);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    kotlin.g.b.p.k(paramMenuItem, "menuItem");
    kotlin.g.b.p.k(parami, "holder");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, parami);
    paramInt1 = paramMenuItem.getItemId();
    if (paramInt1 == this.xvr)
    {
      h("fav", true, paramInt2);
      AppMethodBeat.o(286490);
      return;
    }
    if (paramInt1 == this.xvs) {
      h("unfav", true, paramInt2);
    }
    AppMethodBeat.o(286490);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, o paramo, int paramInt)
  {
    AppMethodBeat.i(286489);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    kotlin.g.b.p.k(paramo, "menu");
    super.a(paramBaseFinderFeed, paramo, paramInt);
    paramo = com.tencent.mm.plugin.finder.utils.aj.AGc;
    int i;
    if (com.tencent.mm.plugin.finder.utils.aj.z(paramBaseFinderFeed.feedObject.getFeedObject()))
    {
      paramo = com.tencent.mm.plugin.finder.upload.action.c.ABD;
      if (!com.tencent.mm.plugin.finder.upload.action.c.ecy().p(paramBaseFinderFeed.feedObject.getFeedObject()))
      {
        i = 1;
        if (i == 0) {
          break label147;
        }
        h("fav", false, paramInt);
      }
    }
    else
    {
      label80:
      paramBaseFinderFeed = g.Xox;
      paramo = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
      paramBaseFinderFeed = am.zZN;
      if (paramInt != 1) {
        break label159;
      }
    }
    label147:
    label159:
    for (paramBaseFinderFeed = "forward";; paramBaseFinderFeed = "tridot")
    {
      am.a(paramo, paramBaseFinderFeed, true, (JSONObject)new com.tencent.mm.ad.i());
      AppMethodBeat.o(286489);
      return;
      i = 0;
      break;
      h("unfav", false, paramInt);
      break label80;
    }
  }
  
  public final void byN()
  {
    AppMethodBeat.i(286485);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(286485);
      return;
    }
    AppMethodBeat.o(286485);
  }
  
  public final void dst()
  {
    AppMethodBeat.i(286488);
    super.dst();
    Object localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
    localObject = this.xvC;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).xvJ.getRecyclerView();; localObject = null)
    {
      com.tencent.mm.plugin.finder.live.report.k.b((RecyclerView)localObject, s.t.yGO, "21", com.tencent.mm.plugin.finder.live.report.c.yAk);
      AppMethodBeat.o(286488);
      return;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(286487);
    this.xve.onDetach();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((d)this.xve);
      }
    }
    this.xvf.onDetach();
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((d)this.xvf);
      }
    }
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
      if (localObject != null)
      {
        d locald = this.xxI;
        if (locald == null) {
          kotlin.g.b.p.bGy("observerForExposeReport");
        }
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b(locald);
      }
    }
    super.onDetach();
    AppMethodBeat.o(286487);
  }
  
  public final void requestRefresh() {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, bu>
  {
    a(h.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, LinkedList<bu>>
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
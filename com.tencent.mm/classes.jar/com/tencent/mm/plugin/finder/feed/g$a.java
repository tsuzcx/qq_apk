package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.profile.b;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "setCacheId", "(J)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"})
public final class g$a
  extends c.a
{
  public g$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(280387);
    AppMethodBeat.o(280387);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(280383);
    p.k(paramb, "callback");
    super.a(paramb);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    paramb = localBaseFinderFeedLoader;
    if (!(localBaseFinderFeedLoader instanceof FinderFavFeedLoader)) {
      paramb = null;
    }
    paramb = (FinderFavFeedLoader)paramb;
    if (paramb != null)
    {
      paramb.onFilterDataChanged = ((a)new a(this));
      AppMethodBeat.o(280383);
      return;
    }
    AppMethodBeat.o(280383);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(280381);
    this.xnX.requestLoadMore();
    AppMethodBeat.o(280381);
  }
  
  public final void dsF()
  {
    AppMethodBeat.i(280382);
    BaseFeedLoader.requestInit$default(this.xnX, false, 1, null);
    AppMethodBeat.o(280382);
  }
  
  public final void dsr()
  {
    Object localObject2 = null;
    AppMethodBeat.i(280379);
    Object localObject1 = this.xvU;
    if (localObject1 != null) {
      ((c.b)localObject1).ab((ArrayList)this.xnX.getDataListJustForAdapter());
    }
    Object localObject3 = this.xnX;
    localObject1 = localObject3;
    if (!(localObject3 instanceof FinderFavFeedLoader)) {
      localObject1 = null;
    }
    localObject3 = (FinderFavFeedLoader)localObject1;
    if (localObject3 != null)
    {
      localObject1 = this.xvU;
      if ((localObject1 instanceof g.b)) {
        break label210;
      }
      localObject1 = localObject2;
    }
    label210:
    for (;;)
    {
      localObject1 = (g.b)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((FinderFavFeedLoader)localObject3).xGu;
        p.k(localObject2, "topics");
        localObject3 = (Activity)((c.b)localObject1).iXq;
        String str = z.bdh();
        p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
        ((g.b)localObject1).xxF = new b((Activity)localObject3, (ArrayList)localObject2, str, 2);
        localObject2 = ((g.b)localObject1).xxF;
        if (localObject2 == null) {
          p.bGy("filterContract");
        }
        localObject2 = (ViewGroup)b.a((b)localObject2);
        HeadFooterLayout.a(((c.b)localObject1).xvJ, (View)localObject2);
        ((g.b)localObject1).xxE = ((ViewGroup)localObject2);
        localObject2 = ((g.b)localObject1).xxF;
        if (localObject2 == null) {
          p.bGy("filterContract");
        }
        ((b)localObject2).zPI = ((m)new g.b.b((g.b)localObject1));
        AppMethodBeat.o(280379);
        return;
      }
      AppMethodBeat.o(280379);
      return;
      AppMethodBeat.o(280379);
      return;
    }
  }
  
  public final f dsu()
  {
    AppMethodBeat.i(280385);
    Object localObject = this.xvU;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dsI();; localObject = null)
    {
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((ak)localObject).dtg();
      AppMethodBeat.o(280385);
      return localObject;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280386);
    super.onDetach();
    AppMethodBeat.o(280386);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(280380);
    this.xnX.requestRefresh();
    AppMethodBeat.o(280380);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(g.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.a
 * JD-Core Version:    0.7.0.1
 */
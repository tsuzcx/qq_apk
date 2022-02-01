package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.profile.e;
import com.tencent.mm.plugin.finder.storage.as;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "cacheId", "", "getCacheId", "()J", "setCacheId", "(J)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$a
  extends c.a
{
  public g$a(MMActivity paramMMActivity, int paramInt, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramInt, paramBaseFinderFeedLoader);
    AppMethodBeat.i(362423);
    AppMethodBeat.o(362423);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(362453);
    s.u(paramb, "callback");
    super.a(paramb);
    paramb = this.ALH;
    if ((paramb instanceof FinderFavFeedLoader)) {}
    for (paramb = (FinderFavFeedLoader)paramb;; paramb = null)
    {
      if (paramb != null) {
        paramb.onFilterDataChanged = ((a)new a(this));
      }
      AppMethodBeat.o(362453);
      return;
    }
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(362441);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(362441);
  }
  
  public final g dUK()
  {
    AppMethodBeat.i(362459);
    Object localObject = this.ATE;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c.b)localObject).dUN())
    {
      s.checkNotNull(localObject);
      localObject = ((as)localObject).ech();
      AppMethodBeat.o(362459);
      return localObject;
    }
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(362446);
    BaseFeedLoader.requestInit$default((BaseFeedLoader)this.ALH, false, 1, null);
    AppMethodBeat.o(362446);
  }
  
  public final void dUM()
  {
    Object localObject3 = null;
    AppMethodBeat.i(362430);
    Object localObject1 = this.ATE;
    if (localObject1 != null) {
      ((c.b)localObject1).ae((ArrayList)this.ALH.getDataListJustForAdapter());
    }
    localObject1 = this.ALH;
    Object localObject2;
    if ((localObject1 instanceof FinderFavFeedLoader))
    {
      localObject2 = (FinderFavFeedLoader)localObject1;
      if (localObject2 != null)
      {
        localObject1 = this.ATE;
        if (!(localObject1 instanceof g.b)) {
          break label232;
        }
        localObject1 = (g.b)localObject1;
        label68:
        if (localObject1 != null)
        {
          localObject2 = ((FinderFavFeedLoader)localObject2).BfB;
          s.u(localObject2, "topics");
          Object localObject4 = (Activity)((c.b)localObject1).lzt;
          String str = z.bAW();
          s.s(str, "getMyFinderUsername()");
          ((g.b)localObject1).AUR = new e((Activity)localObject4, (ArrayList)localObject2, str, 2);
          localObject4 = ((g.b)localObject1).AUR;
          localObject2 = localObject4;
          if (localObject4 == null)
          {
            s.bIx("filterContract");
            localObject2 = null;
          }
          localObject2 = (ViewGroup)e.a((e)localObject2);
          if (!((bw)h.ax(bw.class)).aBu()) {
            HeadFooterLayout.a((HeadFooterLayout)((c.b)localObject1).ATx, (View)localObject2);
          }
          localObject4 = ah.aiuX;
          ((g.b)localObject1).AUQ = ((ViewGroup)localObject2);
          localObject2 = ((g.b)localObject1).AUR;
          if (localObject2 != null) {
            break label237;
          }
          s.bIx("filterContract");
          localObject2 = localObject3;
        }
      }
    }
    label232:
    label237:
    for (;;)
    {
      ((e)localObject2).FaF = ((m)new g.b.a((g.b)localObject1));
      AppMethodBeat.o(362430);
      return;
      localObject2 = null;
      break;
      localObject1 = null;
      break label68;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(362465);
    super.onDetach();
    AppMethodBeat.o(362465);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(362434);
    this.ALH.requestRefresh();
    AppMethodBeat.o(362434);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
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
package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class y$b
  extends c.b
{
  private final String TAG;
  
  private y$b(MMActivity paramMMActivity, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, paramInt1, paramInt2, false);
    AppMethodBeat.i(220695);
    this.TAG = "Finder.FinderLikeFeedUIContract.LikeFeedViewCallback";
    AppMethodBeat.o(220695);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(220687);
    p.k(parama, "adapter");
    p.k(paramView, "view");
    paramInt -= ((h)parama).YSk.size();
    if ((paramInt >= 0) && (paramInt < dsG().xnX.getSize()))
    {
      parama = (bu)dsG().xnX.getDataListJustForAdapter().get(paramInt);
      if ((parama instanceof BaseFinderFeed))
      {
        Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
        parama = new Intent();
        BaseFeedLoader.saveCache$default(dsH().xnX, parama, paramInt, null, 4, null);
        Object localObject = aj.Bnu;
        aj.a.a((Context)this.iXq, parama, 0L, 0, false, 124);
        localObject = a.ACH;
        paramView = paramView.getContext();
        p.j(paramView, "view.context");
        a.U(paramView, parama);
      }
    }
    AppMethodBeat.o(220687);
  }
  
  public final void dsL()
  {
    AppMethodBeat.i(220677);
    if (dsH().xnX.getSize() <= ku() * 3)
    {
      localObject = dsH().xnX;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader");
        AppMethodBeat.o(220677);
        throw ((Throwable)localObject);
      }
      if (((FinderLikedFeedLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.c(this.xvJ);
      }
    }
    Object localObject = dsH().xnX;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader");
      AppMethodBeat.o(220677);
      throw ((Throwable)localObject);
    }
    localObject = (FinderLikedFeedLoader)localObject;
    ((FinderLikedFeedLoader)localObject).jlf -= 1;
    int i = ((FinderLikedFeedLoader)localObject).jlf;
    localObject = this.xwc;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(b.f.desc);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)this.iXq.getResources().getString(b.j.finder_fav_list_desc, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(220677);
        return;
      }
    }
    AppMethodBeat.o(220677);
  }
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(220680);
    p.k(paramContext, "context");
    paramContext = dsI().eW(paramContext);
    AppMethodBeat.o(220680);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(220690);
    p.k(paramc, "reason");
    AppMethodBeat.o(220690);
    return null;
  }
  
  public final String g(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(220691);
    p.k(paramc, "reason");
    AppMethodBeat.o(220691);
    return null;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(220678);
    View localView = this.iXq.findViewById(b.f.empty_view);
    AppMethodBeat.o(220678);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(220669);
    RecyclerView.h localh = dsI().getItemDecoration();
    AppMethodBeat.o(220669);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.y.b
 * JD-Core Version:    0.7.0.1
 */
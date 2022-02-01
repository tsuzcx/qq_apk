package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class t$b
  extends b.b
{
  private final String TAG;
  
  private t$b(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, paramInt, 35, false);
    AppMethodBeat.i(201962);
    this.TAG = "Finder.FinderLikeFeedUIContract.LikeFeedViewCallback";
    AppMethodBeat.o(201962);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201959);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).Lvi.size();
    if ((paramInt >= 0) && (paramInt < cAP().rTS.getSize()))
    {
      parama = (al)cAP().rTS.getDataListJustForAdapter().get(paramInt);
      if ((parama instanceof BaseFinderFeed))
      {
        ad.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
        parama = new Intent();
        BaseFinderFeedLoader.saveCache$default(cAQ().rTS, parama, paramInt, null, 4, null);
        Object localObject = FinderReporterUIC.tcM;
        FinderReporterUIC.a.a((Context)this.fLP, parama, 0L, 0, false, 124);
        localObject = a.sKD;
        paramView = paramView.getContext();
        p.g(paramView, "view.context");
        a.P(paramView, parama);
      }
    }
    AppMethodBeat.o(201959);
  }
  
  public final void cAT()
  {
    AppMethodBeat.i(201956);
    if (cAQ().rTS.getSize() <= this.atv * 3)
    {
      localObject = cAQ().rTS;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader");
        AppMethodBeat.o(201956);
        throw ((Throwable)localObject);
      }
      if (((FinderLikedFeedLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.d(this.rTF);
      }
    }
    Object localObject = cAQ().rTS;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader");
      AppMethodBeat.o(201956);
      throw ((Throwable)localObject);
    }
    localObject = (FinderLikedFeedLoader)localObject;
    ((FinderLikedFeedLoader)localObject).fTM -= 1;
    int i = ((FinderLikedFeedLoader)localObject).fTM;
    localObject = this.rTZ;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131298996);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)this.fLP.getResources().getString(2131766387, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(201956);
        return;
      }
    }
    AppMethodBeat.o(201956);
  }
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201960);
    p.h(paramc, "reason");
    AppMethodBeat.o(201960);
    return null;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201958);
    p.h(paramContext, "context");
    paramContext = cAR().eL(paramContext);
    AppMethodBeat.o(201958);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201961);
    p.h(paramc, "reason");
    AppMethodBeat.o(201961);
    return null;
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(201957);
    View localView = this.fLP.findViewById(2131299478);
    AppMethodBeat.o(201957);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(201955);
    RecyclerView.h localh = cAR().getItemDecoration();
    AppMethodBeat.o(201955);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.t.b
 * JD-Core Version:    0.7.0.1
 */
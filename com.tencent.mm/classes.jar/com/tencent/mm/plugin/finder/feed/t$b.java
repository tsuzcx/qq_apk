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
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class t$b
  extends b.b
{
  private final String TAG;
  
  private t$b(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, paramInt, 35, false);
    AppMethodBeat.i(202426);
    this.TAG = "Finder.FinderLikeFeedUIContract.LikeFeedViewCallback";
    AppMethodBeat.o(202426);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(202423);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).LRV.size();
    if ((paramInt >= 0) && (paramInt < cCB().scw.getSize()))
    {
      parama = (am)cCB().scw.getDataListJustForAdapter().get(paramInt);
      if ((parama instanceof BaseFinderFeed))
      {
        ae.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
        parama = new Intent();
        BaseFinderFeedLoader.saveCache$default(cCC().scw, parama, paramInt, null, 4, null);
        Object localObject = FinderReporterUIC.tnG;
        FinderReporterUIC.a.a((Context)this.fNT, parama, 0L, 0, false, 124);
        localObject = a.sVQ;
        paramView = paramView.getContext();
        p.g(paramView, "view.context");
        a.P(paramView, parama);
      }
    }
    AppMethodBeat.o(202423);
  }
  
  public final void cCF()
  {
    AppMethodBeat.i(202420);
    if (cCC().scw.getSize() <= this.atv * 3)
    {
      localObject = cCC().scw;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader");
        AppMethodBeat.o(202420);
        throw ((Throwable)localObject);
      }
      if (((FinderLikedFeedLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.d(this.scj);
      }
    }
    Object localObject = cCC().scw;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader");
      AppMethodBeat.o(202420);
      throw ((Throwable)localObject);
    }
    localObject = (FinderLikedFeedLoader)localObject;
    ((FinderLikedFeedLoader)localObject).fVS -= 1;
    int i = ((FinderLikedFeedLoader)localObject).fVS;
    localObject = this.scD;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131298996);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)this.fNT.getResources().getString(2131766387, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(202420);
        return;
      }
    }
    AppMethodBeat.o(202420);
  }
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202424);
    p.h(paramc, "reason");
    AppMethodBeat.o(202424);
    return null;
  }
  
  public final RecyclerView.i eP(Context paramContext)
  {
    AppMethodBeat.i(202422);
    p.h(paramContext, "context");
    paramContext = cCD().eP(paramContext);
    AppMethodBeat.o(202422);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202425);
    p.h(paramc, "reason");
    AppMethodBeat.o(202425);
    return null;
  }
  
  public final MMActivity getActivity()
  {
    return this.fNT;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(202421);
    View localView = this.fNT.findViewById(2131299478);
    AppMethodBeat.o(202421);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202419);
    RecyclerView.h localh = cCD().getItemDecoration();
    AppMethodBeat.o(202419);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.t.b
 * JD-Core Version:    0.7.0.1
 */
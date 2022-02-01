package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class u$b
  extends c.b
{
  private final String TAG;
  
  private u$b(MMActivity paramMMActivity, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, paramInt1, paramInt2, false);
    AppMethodBeat.i(243983);
    this.TAG = "Finder.FinderLikeFeedUIContract.LikeFeedViewCallback";
    AppMethodBeat.o(243983);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(243980);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((g)parama).RqM.size();
    if ((paramInt >= 0) && (paramInt < dcq().tFM.getSize()))
    {
      parama = (bo)dcq().tFM.getDataListJustForAdapter().get(paramInt);
      if ((parama instanceof BaseFinderFeed))
      {
        Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
        parama = new Intent();
        BaseFeedLoader.saveCache$default(dcr().tFM, parama, paramInt, null, 4, null);
        Object localObject = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a((Context)this.gte, parama, 0L, 0, false, 124);
        localObject = a.vUU;
        paramView = paramView.getContext();
        p.g(paramView, "view.context");
        a.U(paramView, parama);
      }
    }
    AppMethodBeat.o(243980);
  }
  
  public final String b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(243981);
    p.h(paramc, "reason");
    AppMethodBeat.o(243981);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(243982);
    p.h(paramc, "reason");
    AppMethodBeat.o(243982);
    return null;
  }
  
  public final void dcv()
  {
    AppMethodBeat.i(243977);
    if (dcr().tFM.getSize() <= this.att * 3)
    {
      localObject = dcr().tFM;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader");
        AppMethodBeat.o(243977);
        throw ((Throwable)localObject);
      }
      if (((FinderLikedFeedLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.c(this.tLS);
      }
    }
    Object localObject = dcr().tFM;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader");
      AppMethodBeat.o(243977);
      throw ((Throwable)localObject);
    }
    localObject = (FinderLikedFeedLoader)localObject;
    ((FinderLikedFeedLoader)localObject).gAZ -= 1;
    int i = ((FinderLikedFeedLoader)localObject).gAZ;
    localObject = this.tMl;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131299495);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)this.gte.getResources().getString(2131759708, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(243977);
        return;
      }
    }
    AppMethodBeat.o(243977);
  }
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(243979);
    p.h(paramContext, "context");
    paramContext = dcs().eS(paramContext);
    AppMethodBeat.o(243979);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(243978);
    View localView = this.gte.findViewById(2131300111);
    AppMethodBeat.o(243978);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(243976);
    RecyclerView.h localh = dcs().getItemDecoration();
    AppMethodBeat.o(243976);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.u.b
 * JD-Core Version:    0.7.0.1
 */
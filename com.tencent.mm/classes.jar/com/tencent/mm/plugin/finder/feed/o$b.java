package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.j;
import com.tencent.mm.plugin.finder.feed.model.j.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILjava/lang/String;)V", "TAG", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
public final class o$b
  extends c.b
{
  private final String TAG;
  private final String title;
  
  public o$b(MMActivity paramMMActivity, int paramInt, String paramString)
  {
    super(paramMMActivity, paramInt, 16);
    AppMethodBeat.i(201691);
    this.title = paramString;
    this.TAG = "Finder.LbsStreamFeedUIContract.LbsStreamFeedViewCallback";
    AppMethodBeat.o(201691);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201688);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    paramInt -= ((com.tencent.mm.view.recyclerview.d)parama).JCb.size();
    if ((paramInt >= 0) && (paramInt < cuC().rgh.getSize()))
    {
      parama = ((BaseFinderFeed)cuC().rgh.getDataListJustForAdapter().get(paramInt)).feedObject;
      ac.i(this.TAG, "onClick " + paramInt + " id:" + parama.getId() + ", pos:" + paramInt);
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("KEY_CLICK_FEED_POSITION", paramInt);
      long l = System.currentTimeMillis();
      Object localObject2 = j.rmZ;
      localObject2 = (List)cuC().rgh.getDataListJustForAdapter();
      BaseFinderFeedLoader localBaseFinderFeedLoader = cuC().rgh;
      if (localBaseFinderFeedLoader == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader");
        AppMethodBeat.o(201688);
        throw parama;
      }
      j.a.a(l, (List)localObject2, ((j)localBaseFinderFeedLoader).lastBuffer);
      ((Intent)localObject1).putExtra("KEY_CACHE_ID", l);
      ((Intent)localObject1).putExtra("KEY_UI_TITLE", this.title);
      localObject2 = FinderReporterUIC.seQ;
      localObject2 = paramView.getContext();
      k.g(localObject2, "view.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, false, 124);
      localObject2 = a.rOv;
      localObject2 = paramView.getContext();
      k.g(localObject2, "view.context");
      a.M((Context)localObject2, (Intent)localObject1);
      localObject1 = FinderReporterUIC.seQ;
      paramView = paramView.getContext();
      k.g(paramView, "view.context");
      paramView = FinderReporterUIC.a.eV(paramView);
      if (paramView != null)
      {
        paramView = paramView.cGb();
        if (paramView != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
          com.tencent.mm.plugin.finder.report.d.a(paramView, parama.getId(), this.rfT.getRecyclerView());
          AppMethodBeat.o(201688);
          return;
        }
      }
    }
    AppMethodBeat.o(201688);
  }
  
  public final boolean cuG()
  {
    return false;
  }
  
  public final void cuH() {}
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201689);
    k.h(paramc, "reason");
    AppMethodBeat.o(201689);
    return null;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201687);
    k.h(paramContext, "context");
    paramContext = cuF().eL(paramContext);
    AppMethodBeat.o(201687);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201690);
    k.h(paramc, "reason");
    AppMethodBeat.o(201690);
    return null;
  }
  
  public final MMActivity getActivity()
  {
    return this.iMV;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(201686);
    View localView = this.iMV.findViewById(2131299478);
    AppMethodBeat.o(201686);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(201685);
    RecyclerView.h localh = cuF().getItemDecoration();
    AppMethodBeat.o(201685);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.o.b
 * JD-Core Version:    0.7.0.1
 */
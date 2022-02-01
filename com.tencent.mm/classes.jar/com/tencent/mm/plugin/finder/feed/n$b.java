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
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class n$b
  extends b.b
{
  private final String TAG;
  
  public n$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity, 0, 0, true);
    AppMethodBeat.i(201843);
    this.TAG = "Finder.FinderFriendLikeFeedUIContract.ViewCallback";
    AppMethodBeat.o(201843);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201840);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).Lvi.size();
    if ((paramInt >= 0) && (paramInt < cAP().rTS.getSize()))
    {
      parama = (al)cAP().rTS.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(201840);
        return;
      }
      ad.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFinderFeedLoader.saveCache$default(cAP().rTS, parama, paramInt, null, 4, null);
      a locala = a.sKD;
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      a.O(paramView, parama);
    }
    AppMethodBeat.o(201840);
  }
  
  public final void cAT() {}
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201841);
    p.h(paramc, "reason");
    AppMethodBeat.o(201841);
    return "";
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201839);
    p.h(paramContext, "context");
    paramContext = cAR().eL(paramContext);
    AppMethodBeat.o(201839);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201842);
    p.h(paramc, "reason");
    AppMethodBeat.o(201842);
    return "";
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(201838);
    View localView = this.fLP.findViewById(2131299478);
    AppMethodBeat.o(201838);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(201837);
    RecyclerView.h localh = cAR().getItemDecoration();
    AppMethodBeat.o(201837);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.n.b
 * JD-Core Version:    0.7.0.1
 */
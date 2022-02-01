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
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class n$b
  extends b.b
{
  private final String TAG;
  
  public n$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity, 0, 0, true);
    AppMethodBeat.i(202303);
    this.TAG = "Finder.FinderFriendLikeFeedUIContract.ViewCallback";
    AppMethodBeat.o(202303);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(202300);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).LRV.size();
    if ((paramInt >= 0) && (paramInt < cCB().scw.getSize()))
    {
      parama = (am)cCB().scw.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(202300);
        return;
      }
      ae.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFinderFeedLoader.saveCache$default(cCB().scw, parama, paramInt, null, 4, null);
      a locala = a.sVQ;
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      a.O(paramView, parama);
    }
    AppMethodBeat.o(202300);
  }
  
  public final void cCF() {}
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202301);
    p.h(paramc, "reason");
    AppMethodBeat.o(202301);
    return "";
  }
  
  public final RecyclerView.i eP(Context paramContext)
  {
    AppMethodBeat.i(202299);
    p.h(paramContext, "context");
    paramContext = cCD().eP(paramContext);
    AppMethodBeat.o(202299);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202302);
    p.h(paramc, "reason");
    AppMethodBeat.o(202302);
    return "";
  }
  
  public final MMActivity getActivity()
  {
    return this.fNT;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(202298);
    View localView = this.fNT.findViewById(2131299478);
    AppMethodBeat.o(202298);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202297);
    RecyclerView.h localh = cCD().getItemDecoration();
    AppMethodBeat.o(202297);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.n.b
 * JD-Core Version:    0.7.0.1
 */
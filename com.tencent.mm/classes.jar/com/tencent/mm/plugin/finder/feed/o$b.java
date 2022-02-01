package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class o$b
  extends c.b
{
  private final String TAG;
  
  public o$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity, 0, 0, true);
    AppMethodBeat.i(243855);
    this.TAG = "Finder.FinderFriendLikeFeedUIContract.ViewCallback";
    AppMethodBeat.o(243855);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(243852);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((g)parama).RqM.size();
    if ((paramInt >= 0) && (paramInt < dcq().tFM.getSize()))
    {
      parama = (bo)dcq().tFM.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(243852);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFeedLoader.saveCache$default(dcq().tFM, parama, paramInt, null, 4, null);
      a locala = a.vUU;
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      a.T(paramView, parama);
    }
    AppMethodBeat.o(243852);
  }
  
  public final String b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(243853);
    p.h(paramc, "reason");
    AppMethodBeat.o(243853);
    return "";
  }
  
  public final String c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(243854);
    p.h(paramc, "reason");
    AppMethodBeat.o(243854);
    return "";
  }
  
  public final void dcv() {}
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(243851);
    p.h(paramContext, "context");
    paramContext = dcs().eS(paramContext);
    AppMethodBeat.o(243851);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(243850);
    View localView = this.gte.findViewById(2131300111);
    AppMethodBeat.o(243850);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(243849);
    RecyclerView.h localh = dcs().getItemDecoration();
    AppMethodBeat.o(243849);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.o.b
 * JD-Core Version:    0.7.0.1
 */
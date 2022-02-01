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
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z$b
  extends c.b
{
  private final String TAG;
  
  private z$b(MMActivity paramMMActivity, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, paramInt1, paramInt2, false);
    AppMethodBeat.i(362375);
    this.TAG = "Finder.FinderLikeFeedUIContract.LikeFeedViewCallback";
    AppMethodBeat.o(362375);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(362413);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    Object localObject = d.Pmb;
    d.asyncReportFinderSecurityInfoThroughCgi(540999705);
    paramInt -= ((i)parama).agOb.size();
    if ((paramInt >= 0) && (paramInt < ebL().ALH.getSize()))
    {
      parama = (cc)ebL().ALH.getDataListJustForAdapter().get(paramInt);
      if ((parama instanceof BaseFinderFeed))
      {
        Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
        parama = new Intent();
        BaseFeedLoader.saveCache$default((BaseFeedLoader)ebL().ALH, parama, paramInt, null, 4, null);
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        as.a.a((Context)this.lzt, parama, 0L, 0, false, 124);
        localObject = a.GfO;
        paramView = paramView.getContext();
        s.s(paramView, "view.context");
        a.am(paramView, parama);
      }
    }
    AppMethodBeat.o(362413);
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362422);
    s.u(paramd, "reason");
    AppMethodBeat.o(362422);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362427);
    s.u(paramd, "reason");
    AppMethodBeat.o(362427);
    return null;
  }
  
  public final void dUO()
  {
    AppMethodBeat.i(362394);
    if ((ebL().ALH.getSize() <= ebK() * 3) && (((FinderLikedFeedLoader)ebL().ALH).hasMore)) {
      ebO();
    }
    Object localObject = (FinderLikedFeedLoader)ebL().ALH;
    ((FinderLikedFeedLoader)localObject).lNX -= 1;
    int i = ((FinderLikedFeedLoader)localObject).lNX;
    localObject = this.ATL;
    if (localObject == null) {}
    for (localObject = null;; localObject = (TextView)((View)localObject).findViewById(e.e.desc))
    {
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)this.lzt.getResources().getString(e.h.finder_fav_list_desc, new Object[] { Integer.valueOf(i) }));
      }
      AppMethodBeat.o(362394);
      return;
    }
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(362403);
    s.u(paramContext, "context");
    paramContext = dUN().fT(paramContext);
    AppMethodBeat.o(362403);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(362398);
    View localView = this.lzt.findViewById(e.e.empty_view);
    AppMethodBeat.o(362398);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(362386);
    RecyclerView.h localh = dUN().getItemDecoration();
    AppMethodBeat.o(362386);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.z.b
 * JD-Core Version:    0.7.0.1
 */
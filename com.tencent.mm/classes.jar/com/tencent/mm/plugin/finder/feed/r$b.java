package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.as;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r$b
  extends c.b
{
  private final String TAG;
  
  public r$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity, 0, 0, true);
    AppMethodBeat.i(362601);
    this.TAG = "Finder.FinderFriendLikeFeedUIContract.ViewCallback";
    AppMethodBeat.o(362601);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(362637);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    paramInt -= ((i)parama).agOb.size();
    if ((paramInt >= 0) && (paramInt < ebL().ALH.getSize()))
    {
      parama = (cc)ebL().ALH.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(362637);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFeedLoader.saveCache$default((BaseFeedLoader)ebL().ALH, parama, paramInt, null, 4, null);
      a locala = a.GfO;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      a.al(paramView, parama);
    }
    AppMethodBeat.o(362637);
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362645);
    s.u(paramd, "reason");
    AppMethodBeat.o(362645);
    return "";
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362651);
    s.u(paramd, "reason");
    AppMethodBeat.o(362651);
    return "";
  }
  
  public final void dUO() {}
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(362625);
    s.u(paramContext, "context");
    paramContext = dUN().fT(paramContext);
    AppMethodBeat.o(362625);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(362617);
    View localView = this.lzt.findViewById(e.e.empty_view);
    AppMethodBeat.o(362617);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(362607);
    RecyclerView.h localh = dUN().getItemDecoration();
    AppMethodBeat.o(362607);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.r.b
 * JD-Core Version:    0.7.0.1
 */
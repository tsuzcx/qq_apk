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
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILjava/lang/String;)V", "TAG", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w$b
  extends c.b
{
  private final String TAG;
  private final String title;
  
  public w$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString)
  {
    super(paramMMActivity, paramInt1, paramInt2);
    AppMethodBeat.i(363631);
    this.title = paramString;
    this.TAG = "Finder.LbsStreamFeedUIContract.LbsStreamFeedViewCallback";
    AppMethodBeat.o(363631);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(363678);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    paramInt -= ((i)parama).agOb.size();
    if ((paramInt >= 0) && (paramInt < ebL().ALH.getSize()))
    {
      parama = (cc)ebL().ALH.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(363678);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      Object localObject1 = new Intent();
      BaseFeedLoader.saveCache$default((BaseFeedLoader)ebL().ALH, (Intent)localObject1, paramInt, null, 4, null);
      ((Intent)localObject1).putExtra("KEY_UI_TITLE", this.title);
      Object localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject2 = paramView.getContext();
      s.s(localObject2, "view.context");
      as.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, false, 124);
      localObject2 = a.GfO;
      localObject2 = paramView.getContext();
      s.s(localObject2, "view.context");
      a.ai((Context)localObject2, (Intent)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      paramView = as.a.hu(paramView);
      if (paramView != null)
      {
        paramView = paramView.fou();
        if (paramView != null)
        {
          localObject1 = z.FrZ;
          z.a(paramView, ((BaseFinderFeed)parama).feedObject.getId(), this.ATx.getRecyclerView(), 0, null, 24);
        }
      }
    }
    AppMethodBeat.o(363678);
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(363690);
    s.u(paramd, "reason");
    AppMethodBeat.o(363690);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(363699);
    s.u(paramd, "reason");
    AppMethodBeat.o(363699);
    return null;
  }
  
  public final void dUO() {}
  
  public final boolean ebM()
  {
    return false;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(363664);
    s.u(paramContext, "context");
    paramContext = dUN().fT(paramContext);
    AppMethodBeat.o(363664);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(363656);
    View localView = this.lzt.findViewById(e.e.empty_view);
    AppMethodBeat.o(363656);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(363645);
    RecyclerView.h localh = dUN().getItemDecoration();
    AppMethodBeat.o(363645);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.w.b
 * JD-Core Version:    0.7.0.1
 */
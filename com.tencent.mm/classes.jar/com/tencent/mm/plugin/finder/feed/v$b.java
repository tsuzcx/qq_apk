package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILjava/lang/String;)V", "TAG", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
public final class v$b
  extends c.b
{
  private final String TAG;
  private final String title;
  
  public v$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString)
  {
    super(paramMMActivity, paramInt1, paramInt2);
    AppMethodBeat.i(289524);
    this.title = paramString;
    this.TAG = "Finder.LbsStreamFeedUIContract.LbsStreamFeedViewCallback";
    AppMethodBeat.o(289524);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(289521);
    p.k(parama, "adapter");
    p.k(paramView, "view");
    paramInt -= ((h)parama).YSk.size();
    if ((paramInt >= 0) && (paramInt < dsG().xnX.getSize()))
    {
      parama = (bu)dsG().xnX.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(289521);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      Object localObject1 = new Intent();
      BaseFeedLoader.saveCache$default(dsG().xnX, (Intent)localObject1, paramInt, null, 4, null);
      ((Intent)localObject1).putExtra("KEY_UI_TITLE", this.title);
      Object localObject2 = aj.Bnu;
      localObject2 = paramView.getContext();
      p.j(localObject2, "view.context");
      aj.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, false, 124);
      localObject2 = a.ACH;
      localObject2 = paramView.getContext();
      p.j(localObject2, "view.context");
      a.Q((Context)localObject2, (Intent)localObject1);
      localObject1 = aj.Bnu;
      paramView = paramView.getContext();
      p.j(paramView, "view.context");
      paramView = aj.a.fZ(paramView);
      if (paramView != null)
      {
        paramView = paramView.ekY();
        if (paramView != null)
        {
          localObject1 = n.zWF;
          n.a(paramView, ((BaseFinderFeed)parama).feedObject.getId(), this.xvJ.getRecyclerView());
          AppMethodBeat.o(289521);
          return;
        }
      }
    }
    AppMethodBeat.o(289521);
  }
  
  public final boolean dsJ()
  {
    return false;
  }
  
  public final void dsL() {}
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(289520);
    p.k(paramContext, "context");
    paramContext = dsI().eW(paramContext);
    AppMethodBeat.o(289520);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(289522);
    p.k(paramc, "reason");
    AppMethodBeat.o(289522);
    return null;
  }
  
  public final String g(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(289523);
    p.k(paramc, "reason");
    AppMethodBeat.o(289523);
    return null;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(289519);
    View localView = this.iXq.findViewById(b.f.empty_view);
    AppMethodBeat.o(289519);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(289518);
    RecyclerView.h localh = dsI().getItemDecoration();
    AppMethodBeat.o(289518);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.v.b
 * JD-Core Version:    0.7.0.1
 */
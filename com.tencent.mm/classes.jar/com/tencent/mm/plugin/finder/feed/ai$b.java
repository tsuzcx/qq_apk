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
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Ljava/lang/String;)V", "TAG", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
public final class ai$b
  extends c.b
{
  private final String TAG;
  private final String title;
  private final avr xAX;
  private ak xwa;
  
  public ai$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, avr paramavr, String paramString)
  {
    super(paramMMActivity, paramInt1, paramInt2);
    AppMethodBeat.i(266634);
    this.xAX = paramavr;
    this.title = paramString;
    this.TAG = "Finder.FinderRelatedFeedUIContract.FavFeedViewCallback";
    this.xwa = ((ak)new q(paramMMActivity));
    AppMethodBeat.o(266634);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(266627);
    p.k(parama, "adapter");
    p.k(paramView, "view");
    paramInt -= ((h)parama).YSk.size();
    if ((paramInt >= 0) && (paramInt < dsG().xnX.getSize()))
    {
      parama = (bu)dsG().xnX.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(266627);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFeedLoader.saveCache$default(dsG().xnX, parama, paramInt, null, 4, null);
      parama.putExtra("KEY_TITLE", this.title);
      parama.putExtra("KEY_REQUEST_PB", this.xAX.toByteArray());
      parama.putExtra("KEY_MORE_ACTION_TYPE", this.iXq.getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0));
      aj.a locala = aj.Bnu;
      paramView = paramView.getContext();
      p.j(paramView, "view.context");
      aj.a.a(paramView, parama, 0L, 0, false, 124);
      paramView = a.ACH;
      a.S((Context)this.iXq, parama);
    }
    AppMethodBeat.o(266627);
  }
  
  public final ak dsI()
  {
    return this.xwa;
  }
  
  public final boolean dsJ()
  {
    return false;
  }
  
  public final void dsL() {}
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(266624);
    p.k(paramContext, "context");
    paramContext = this.xwa.eW(paramContext);
    AppMethodBeat.o(266624);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(266629);
    p.k(paramc, "reason");
    AppMethodBeat.o(266629);
    return "";
  }
  
  public final String g(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(266631);
    p.k(paramc, "reason");
    AppMethodBeat.o(266631);
    return "";
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(266623);
    View localView = this.iXq.findViewById(b.f.empty_view);
    AppMethodBeat.o(266623);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(266621);
    RecyclerView.h localh = this.xwa.getItemDecoration();
    AppMethodBeat.o(266621);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ai.b
 * JD-Core Version:    0.7.0.1
 */
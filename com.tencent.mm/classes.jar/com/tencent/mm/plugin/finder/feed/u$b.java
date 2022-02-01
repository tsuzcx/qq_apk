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
import com.tencent.mm.plugin.finder.feed.model.l.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.v;
import java.util.ArrayList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Ljava/lang/String;)V", "TAG", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
public final class u$b
  extends c.b
{
  private final String TAG;
  private r rgm;
  private final ale rjx;
  private final String title;
  
  public u$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, ale paramale, String paramString)
  {
    super(paramMMActivity, paramInt1, paramInt2);
    AppMethodBeat.i(201789);
    this.rjx = paramale;
    this.title = paramString;
    this.TAG = "Finder.FinderRelatedFeedUIContract.FavFeedViewCallback";
    this.rgm = ((r)new com.tencent.mm.plugin.finder.storage.k());
    AppMethodBeat.o(201789);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201786);
    d.g.b.k.h(parama, "adapter");
    d.g.b.k.h(paramView, "view");
    paramInt -= ((d)parama).JCb.size();
    if ((paramInt >= 0) && (paramInt < cuC().rgh.getSize()))
    {
      parama = ((BaseFinderFeed)cuC().rgh.getDataListJustForAdapter().get(paramInt)).feedObject;
      ac.i(this.TAG, "onClick " + paramInt + " id:" + parama.getId() + ", pos:" + paramInt);
      parama = new Intent();
      parama.putExtra("KEY_CLICK_FEED_POSITION", paramInt);
      long l = System.currentTimeMillis();
      Object localObject = com.tencent.mm.plugin.finder.feed.model.l.rng;
      localObject = (List)cuC().rgh.getDataListJustForAdapter();
      BaseFinderFeedLoader localBaseFinderFeedLoader = cuC().rgh;
      if (localBaseFinderFeedLoader == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader");
        AppMethodBeat.o(201786);
        throw parama;
      }
      l.a.a(l, (List)localObject, ((com.tencent.mm.plugin.finder.feed.model.l)localBaseFinderFeedLoader).lastBuffer);
      parama.putExtra("KEY_CACHE_ID", l);
      parama.putExtra("KEY_TITLE", this.title);
      parama.putExtra("KEY_REQUEST_PB", this.rjx.toByteArray());
      parama.putExtra("KEY_MORE_ACTION_TYPE", this.iMV.getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0));
      localObject = FinderReporterUIC.seQ;
      localObject = paramView.getContext();
      d.g.b.k.g(localObject, "view.context");
      FinderReporterUIC.a.a((Context)localObject, parama, 0L, 0, false, 124);
      localObject = a.rOv;
      paramView = paramView.getContext();
      d.g.b.k.g(paramView, "view.context");
      a.O(paramView, parama);
    }
    AppMethodBeat.o(201786);
  }
  
  public final r cuF()
  {
    return this.rgm;
  }
  
  public final boolean cuG()
  {
    return false;
  }
  
  public final void cuH() {}
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201787);
    d.g.b.k.h(paramc, "reason");
    AppMethodBeat.o(201787);
    return "";
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201785);
    d.g.b.k.h(paramContext, "context");
    paramContext = this.rgm.eL(paramContext);
    AppMethodBeat.o(201785);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201788);
    d.g.b.k.h(paramc, "reason");
    AppMethodBeat.o(201788);
    return "";
  }
  
  public final MMActivity getActivity()
  {
    return this.iMV;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(201784);
    View localView = this.iMV.findViewById(2131299478);
    AppMethodBeat.o(201784);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(201783);
    RecyclerView.h localh = this.rgm.getItemDecoration();
    AppMethodBeat.o(201783);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.u.b
 * JD-Core Version:    0.7.0.1
 */
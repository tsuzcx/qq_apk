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
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Ljava/lang/String;)V", "TAG", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
public final class ac$b
  extends c.b
{
  private final String TAG;
  private al tMj;
  private final ato tQh;
  private final String title;
  
  public ac$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, ato paramato, String paramString)
  {
    super(paramMMActivity, paramInt1, paramInt2);
    AppMethodBeat.i(244102);
    this.tQh = paramato;
    this.title = paramString;
    this.TAG = "Finder.FinderRelatedFeedUIContract.FavFeedViewCallback";
    this.tMj = ((al)new com.tencent.mm.plugin.finder.storage.p(paramMMActivity));
    AppMethodBeat.o(244102);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(244099);
    kotlin.g.b.p.h(parama, "adapter");
    kotlin.g.b.p.h(paramView, "view");
    paramInt -= ((g)parama).RqM.size();
    if ((paramInt >= 0) && (paramInt < dcq().tFM.getSize()))
    {
      parama = (bo)dcq().tFM.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(244099);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFeedLoader.saveCache$default(dcq().tFM, parama, paramInt, null, 4, null);
      parama.putExtra("KEY_TITLE", this.title);
      parama.putExtra("KEY_REQUEST_PB", this.tQh.toByteArray());
      parama.putExtra("KEY_MORE_ACTION_TYPE", this.gte.getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0));
      FinderReporterUIC.a locala = FinderReporterUIC.wzC;
      paramView = paramView.getContext();
      kotlin.g.b.p.g(paramView, "view.context");
      FinderReporterUIC.a.a(paramView, parama, 0L, 0, false, 124);
      paramView = a.vUU;
      a.S((Context)this.gte, parama);
    }
    AppMethodBeat.o(244099);
  }
  
  public final String b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244100);
    kotlin.g.b.p.h(paramc, "reason");
    AppMethodBeat.o(244100);
    return "";
  }
  
  public final String c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244101);
    kotlin.g.b.p.h(paramc, "reason");
    AppMethodBeat.o(244101);
    return "";
  }
  
  public final al dcs()
  {
    return this.tMj;
  }
  
  public final boolean dct()
  {
    return false;
  }
  
  public final void dcv() {}
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(244098);
    kotlin.g.b.p.h(paramContext, "context");
    paramContext = this.tMj.eS(paramContext);
    AppMethodBeat.o(244098);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(244097);
    View localView = this.gte.findViewById(2131300111);
    AppMethodBeat.o(244097);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(244096);
    RecyclerView.h localh = this.tMj.getItemDecoration();
    AppMethodBeat.o(244096);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ac.b
 * JD-Core Version:    0.7.0.1
 */
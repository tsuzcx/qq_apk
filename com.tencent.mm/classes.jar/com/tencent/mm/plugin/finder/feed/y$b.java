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
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Ljava/lang/String;)V", "TAG", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
public final class y$b
  extends b.b
{
  private final String TAG;
  private z rTX;
  private final aoj rXP;
  private final String title;
  
  public y$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, aoj paramaoj, String paramString)
  {
    super(paramMMActivity, paramInt1, paramInt2);
    AppMethodBeat.i(202014);
    this.rXP = paramaoj;
    this.title = paramString;
    this.TAG = "Finder.FinderRelatedFeedUIContract.FavFeedViewCallback";
    this.rTX = ((z)new n());
    AppMethodBeat.o(202014);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(202011);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).Lvi.size();
    if ((paramInt >= 0) && (paramInt < cAP().rTS.getSize()))
    {
      parama = (al)cAP().rTS.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(202011);
        return;
      }
      ad.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFinderFeedLoader.saveCache$default(cAP().rTS, parama, paramInt, null, 4, null);
      parama.putExtra("KEY_TITLE", this.title);
      parama.putExtra("KEY_REQUEST_PB", this.rXP.toByteArray());
      parama.putExtra("KEY_MORE_ACTION_TYPE", this.fLP.getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0));
      FinderReporterUIC.a locala = FinderReporterUIC.tcM;
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      FinderReporterUIC.a.a(paramView, parama, 0L, 0, false, 124);
      paramView = a.sKD;
      a.N((Context)this.fLP, parama);
    }
    AppMethodBeat.o(202011);
  }
  
  public final z cAR()
  {
    return this.rTX;
  }
  
  public final boolean cAS()
  {
    return false;
  }
  
  public final void cAT() {}
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202012);
    p.h(paramc, "reason");
    AppMethodBeat.o(202012);
    return "";
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(202010);
    p.h(paramContext, "context");
    paramContext = this.rTX.eL(paramContext);
    AppMethodBeat.o(202010);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202013);
    p.h(paramc, "reason");
    AppMethodBeat.o(202013);
    return "";
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(202009);
    View localView = this.fLP.findViewById(2131299478);
    AppMethodBeat.o(202009);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202008);
    RecyclerView.h localh = this.rTX.getItemDecoration();
    AppMethodBeat.o(202008);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.y.b
 * JD-Core Version:    0.7.0.1
 */
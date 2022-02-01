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
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILjava/lang/String;)V", "TAG", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
public final class q$b
  extends b.b
{
  private final String TAG;
  private final String title;
  
  public q$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString)
  {
    super(paramMMActivity, paramInt1, paramInt2);
    AppMethodBeat.i(202355);
    this.title = paramString;
    this.TAG = "Finder.LbsStreamFeedUIContract.LbsStreamFeedViewCallback";
    AppMethodBeat.o(202355);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(202352);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).LRV.size();
    if ((paramInt >= 0) && (paramInt < cCB().scw.getSize()))
    {
      parama = (am)cCB().scw.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(202352);
        return;
      }
      ae.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      Object localObject1 = new Intent();
      BaseFinderFeedLoader.saveCache$default(cCB().scw, (Intent)localObject1, paramInt, null, 4, null);
      ((Intent)localObject1).putExtra("KEY_UI_TITLE", this.title);
      Object localObject2 = FinderReporterUIC.tnG;
      localObject2 = paramView.getContext();
      p.g(localObject2, "view.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, false, 124);
      localObject2 = a.sVQ;
      localObject2 = paramView.getContext();
      p.g(localObject2, "view.context");
      a.L((Context)localObject2, (Intent)localObject1);
      localObject1 = FinderReporterUIC.tnG;
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      paramView = FinderReporterUIC.a.fc(paramView);
      if (paramView != null)
      {
        paramView = paramView.cQZ();
        if (paramView != null)
        {
          localObject1 = i.syT;
          i.a(paramView, ((BaseFinderFeed)parama).feedObject.getId(), this.scj.getRecyclerView());
          AppMethodBeat.o(202352);
          return;
        }
      }
    }
    AppMethodBeat.o(202352);
  }
  
  public final boolean cCE()
  {
    return false;
  }
  
  public final void cCF() {}
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202353);
    p.h(paramc, "reason");
    AppMethodBeat.o(202353);
    return null;
  }
  
  public final RecyclerView.i eP(Context paramContext)
  {
    AppMethodBeat.i(202351);
    p.h(paramContext, "context");
    paramContext = cCD().eP(paramContext);
    AppMethodBeat.o(202351);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202354);
    p.h(paramc, "reason");
    AppMethodBeat.o(202354);
    return null;
  }
  
  public final MMActivity getActivity()
  {
    return this.fNT;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(202350);
    View localView = this.fNT.findViewById(2131299478);
    AppMethodBeat.o(202350);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202349);
    RecyclerView.h localh = cCD().getItemDecoration();
    AppMethodBeat.o(202349);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.q.b
 * JD-Core Version:    0.7.0.1
 */
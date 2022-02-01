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
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILjava/lang/String;)V", "TAG", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
public final class q$b
  extends b.b
{
  private final String TAG;
  private final String title;
  
  public q$b(MMActivity paramMMActivity, int paramInt, String paramString)
  {
    super(paramMMActivity, paramInt, 16);
    AppMethodBeat.i(201895);
    this.title = paramString;
    this.TAG = "Finder.LbsStreamFeedUIContract.LbsStreamFeedViewCallback";
    AppMethodBeat.o(201895);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201892);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).Lvi.size();
    if ((paramInt >= 0) && (paramInt < cAP().rTS.getSize()))
    {
      parama = (al)cAP().rTS.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(201892);
        return;
      }
      ad.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      Object localObject1 = new Intent();
      BaseFinderFeedLoader.saveCache$default(cAP().rTS, (Intent)localObject1, paramInt, null, 4, null);
      ((Intent)localObject1).putExtra("KEY_UI_TITLE", this.title);
      Object localObject2 = FinderReporterUIC.tcM;
      localObject2 = paramView.getContext();
      p.g(localObject2, "view.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, false, 124);
      localObject2 = a.sKD;
      localObject2 = paramView.getContext();
      p.g(localObject2, "view.context");
      a.L((Context)localObject2, (Intent)localObject1);
      localObject1 = FinderReporterUIC.tcM;
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      paramView = FinderReporterUIC.a.eY(paramView);
      if (paramView != null)
      {
        paramView = paramView.cOu();
        if (paramView != null)
        {
          localObject1 = h.soM;
          h.a(paramView, ((BaseFinderFeed)parama).feedObject.getId(), this.rTF.getRecyclerView());
          AppMethodBeat.o(201892);
          return;
        }
      }
    }
    AppMethodBeat.o(201892);
  }
  
  public final boolean cAS()
  {
    return false;
  }
  
  public final void cAT() {}
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201893);
    p.h(paramc, "reason");
    AppMethodBeat.o(201893);
    return null;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201891);
    p.h(paramContext, "context");
    paramContext = cAR().eL(paramContext);
    AppMethodBeat.o(201891);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201894);
    p.h(paramc, "reason");
    AppMethodBeat.o(201894);
    return null;
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(201890);
    View localView = this.fLP.findViewById(2131299478);
    AppMethodBeat.o(201890);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(201889);
    RecyclerView.h localh = cAR().getItemDecoration();
    AppMethodBeat.o(201889);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.q.b
 * JD-Core Version:    0.7.0.1
 */
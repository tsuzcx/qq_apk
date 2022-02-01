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
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILjava/lang/String;)V", "TAG", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
public final class r$b
  extends c.b
{
  private final String TAG;
  private final String title;
  
  public r$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString)
  {
    super(paramMMActivity, paramInt1, paramInt2);
    AppMethodBeat.i(243910);
    this.title = paramString;
    this.TAG = "Finder.LbsStreamFeedUIContract.LbsStreamFeedViewCallback";
    AppMethodBeat.o(243910);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(243907);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((g)parama).RqM.size();
    if ((paramInt >= 0) && (paramInt < dcq().tFM.getSize()))
    {
      parama = (bo)dcq().tFM.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(243907);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      Object localObject1 = new Intent();
      BaseFeedLoader.saveCache$default(dcq().tFM, (Intent)localObject1, paramInt, null, 4, null);
      ((Intent)localObject1).putExtra("KEY_UI_TITLE", this.title);
      Object localObject2 = FinderReporterUIC.wzC;
      localObject2 = paramView.getContext();
      p.g(localObject2, "view.context");
      FinderReporterUIC.a.a((Context)localObject2, (Intent)localObject1, 0L, 0, false, 124);
      localObject2 = a.vUU;
      localObject2 = paramView.getContext();
      p.g(localObject2, "view.context");
      a.Q((Context)localObject2, (Intent)localObject1);
      localObject1 = FinderReporterUIC.wzC;
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      paramView = FinderReporterUIC.a.fH(paramView);
      if (paramView != null)
      {
        paramView = paramView.dIx();
        if (paramView != null)
        {
          localObject1 = k.vfA;
          k.a(paramView, ((BaseFinderFeed)parama).feedObject.getId(), this.tLS.getRecyclerView());
          AppMethodBeat.o(243907);
          return;
        }
      }
    }
    AppMethodBeat.o(243907);
  }
  
  public final String b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(243908);
    p.h(paramc, "reason");
    AppMethodBeat.o(243908);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(243909);
    p.h(paramc, "reason");
    AppMethodBeat.o(243909);
    return null;
  }
  
  public final boolean dct()
  {
    return false;
  }
  
  public final void dcv() {}
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(243906);
    p.h(paramContext, "context");
    paramContext = dcs().eS(paramContext);
    AppMethodBeat.o(243906);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(243905);
    View localView = this.gte.findViewById(2131300111);
    AppMethodBeat.o(243905);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(243904);
    RecyclerView.h localh = dcs().getItemDecoration();
    AppMethodBeat.o(243904);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.r.b
 * JD-Core Version:    0.7.0.1
 */
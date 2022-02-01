package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public class g$b
  extends c.b
{
  private final String TAG;
  
  private g$b(MMActivity paramMMActivity, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, paramInt1, paramInt2, false);
    AppMethodBeat.i(243771);
    this.TAG = "Finder.FinderFavFeedUIContract.FavFeedViewCallback";
    AppMethodBeat.o(243771);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(243768);
    b localb = new b();
    localb.bm(parama);
    localb.bm(paramView);
    localb.pH(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, localb.axR());
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((g)parama).RqM.size();
    if ((paramInt >= 0) && (paramInt < dcq().tFM.getSize()))
    {
      parama = (bo)dcq().tFM.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(243768);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFeedLoader.saveCache$default(dcq().tFM, parama, paramInt, null, 4, null);
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.b((Activity)this.gte, parama);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
    AppMethodBeat.o(243768);
  }
  
  public final String b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(243769);
    p.h(paramc, "reason");
    paramc = this.gte.getResources().getString(2131759709);
    AppMethodBeat.o(243769);
    return paramc;
  }
  
  public final String c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(243770);
    p.h(paramc, "reason");
    if (paramc.iMa == null)
    {
      AppMethodBeat.o(243770);
      return null;
    }
    if ((paramc.iMa instanceof Integer))
    {
      Resources localResources = this.gte.getResources();
      paramc = paramc.iMa;
      if (paramc == null)
      {
        paramc = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(243770);
        throw paramc;
      }
      paramc = localResources.getString(2131759708, new Object[] { (Integer)paramc });
      AppMethodBeat.o(243770);
      return paramc;
    }
    AppMethodBeat.o(243770);
    return null;
  }
  
  public final void dcv()
  {
    AppMethodBeat.i(243765);
    if (dcr().tFM.getSize() <= this.att * 3)
    {
      localObject = dcr().tFM;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
        AppMethodBeat.o(243765);
        throw ((Throwable)localObject);
      }
      if (((FinderFavFeedLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.c(this.tLS);
      }
    }
    Object localObject = dcr().tFM;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(243765);
      throw ((Throwable)localObject);
    }
    localObject = (FinderFavFeedLoader)localObject;
    ((FinderFavFeedLoader)localObject).gAZ -= 1;
    int i = ((FinderFavFeedLoader)localObject).gAZ;
    localObject = this.tMl;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131299495);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)this.gte.getResources().getString(2131759708, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(243765);
        return;
      }
    }
    AppMethodBeat.o(243765);
  }
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(243767);
    p.h(paramContext, "context");
    paramContext = dcs().eS(paramContext);
    AppMethodBeat.o(243767);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(243766);
    View localView2 = findViewById(2131300111);
    View localView1 = localView2;
    if (!(localView2 instanceof View)) {
      localView1 = null;
    }
    AppMethodBeat.o(243766);
    return localView1;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(243764);
    RecyclerView.h localh = dcs().getItemDecoration();
    AppMethodBeat.o(243764);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class f$b
  extends b.b
{
  private final String TAG;
  
  private f$b(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, paramInt, 24, false);
    AppMethodBeat.i(201767);
    this.TAG = "Finder.FinderFavFeedUIContract.FavFeedViewCallback";
    AppMethodBeat.o(201767);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201764);
    b localb = new b();
    localb.bd(parama);
    localb.bd(paramView);
    localb.mr(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, localb.ahq());
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).Lvi.size();
    if ((paramInt >= 0) && (paramInt < cAP().rTS.getSize()))
    {
      parama = (al)cAP().rTS.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(201764);
        return;
      }
      ad.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFinderFeedLoader.saveCache$default(cAP().rTS, parama, paramInt, null, 4, null);
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      com.tencent.mm.plugin.finder.utils.a.b((Activity)this.fLP, parama);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
    AppMethodBeat.o(201764);
  }
  
  public final void cAT()
  {
    AppMethodBeat.i(201761);
    if (cAQ().rTS.getSize() <= this.atv * 3)
    {
      localObject = cAQ().rTS;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
        AppMethodBeat.o(201761);
        throw ((Throwable)localObject);
      }
      if (((FinderFavFeedLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.d(this.rTF);
      }
    }
    Object localObject = cAQ().rTS;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(201761);
      throw ((Throwable)localObject);
    }
    localObject = (FinderFavFeedLoader)localObject;
    ((FinderFavFeedLoader)localObject).fTM -= 1;
    int i = ((FinderFavFeedLoader)localObject).fTM;
    localObject = this.rTZ;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131298996);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)this.fLP.getResources().getString(2131766387, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(201761);
        return;
      }
    }
    AppMethodBeat.o(201761);
  }
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201765);
    p.h(paramc, "reason");
    paramc = this.fLP.getResources().getString(2131766394);
    AppMethodBeat.o(201765);
    return paramc;
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201763);
    p.h(paramContext, "context");
    paramContext = cAR().eL(paramContext);
    AppMethodBeat.o(201763);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201766);
    p.h(paramc, "reason");
    if (paramc.hNZ == null)
    {
      AppMethodBeat.o(201766);
      return null;
    }
    if ((paramc.hNZ instanceof Integer))
    {
      Resources localResources = this.fLP.getResources();
      paramc = paramc.hNZ;
      if (paramc == null)
      {
        paramc = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(201766);
        throw paramc;
      }
      paramc = localResources.getString(2131766387, new Object[] { (Integer)paramc });
      AppMethodBeat.o(201766);
      return paramc;
    }
    AppMethodBeat.o(201766);
    return null;
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(201762);
    View localView = this.fLP.findViewById(2131299478);
    AppMethodBeat.o(201762);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(201760);
    RecyclerView.h localh = cAR().getItemDecoration();
    AppMethodBeat.o(201760);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.f.b
 * JD-Core Version:    0.7.0.1
 */
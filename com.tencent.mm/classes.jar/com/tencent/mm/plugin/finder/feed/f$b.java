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
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class f$b
  extends b.b
{
  private final String TAG;
  
  private f$b(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, paramInt, 24, false);
    AppMethodBeat.i(202226);
    this.TAG = "Finder.FinderFavFeedUIContract.FavFeedViewCallback";
    AppMethodBeat.o(202226);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(202223);
    b localb = new b();
    localb.bd(parama);
    localb.bd(paramView);
    localb.mu(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, localb.ahF());
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((d)parama).LRV.size();
    if ((paramInt >= 0) && (paramInt < cCB().scw.getSize()))
    {
      parama = (am)cCB().scw.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(202223);
        return;
      }
      ae.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFinderFeedLoader.saveCache$default(cCB().scw, parama, paramInt, null, 4, null);
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.b((Activity)this.fNT, parama);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
    AppMethodBeat.o(202223);
  }
  
  public final void cCF()
  {
    AppMethodBeat.i(202220);
    if (cCC().scw.getSize() <= this.atv * 3)
    {
      localObject = cCC().scw;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
        AppMethodBeat.o(202220);
        throw ((Throwable)localObject);
      }
      if (((FinderFavFeedLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.d(this.scj);
      }
    }
    Object localObject = cCC().scw;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(202220);
      throw ((Throwable)localObject);
    }
    localObject = (FinderFavFeedLoader)localObject;
    ((FinderFavFeedLoader)localObject).fVS -= 1;
    int i = ((FinderFavFeedLoader)localObject).fVS;
    localObject = this.scD;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131298996);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)this.fNT.getResources().getString(2131766387, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(202220);
        return;
      }
    }
    AppMethodBeat.o(202220);
  }
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202224);
    p.h(paramc, "reason");
    paramc = this.fNT.getResources().getString(2131766394);
    AppMethodBeat.o(202224);
    return paramc;
  }
  
  public final RecyclerView.i eP(Context paramContext)
  {
    AppMethodBeat.i(202222);
    p.h(paramContext, "context");
    paramContext = cCD().eP(paramContext);
    AppMethodBeat.o(202222);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(202225);
    p.h(paramc, "reason");
    if (paramc.hQS == null)
    {
      AppMethodBeat.o(202225);
      return null;
    }
    if ((paramc.hQS instanceof Integer))
    {
      Resources localResources = this.fNT.getResources();
      paramc = paramc.hQS;
      if (paramc == null)
      {
        paramc = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(202225);
        throw paramc;
      }
      paramc = localResources.getString(2131766387, new Object[] { (Integer)paramc });
      AppMethodBeat.o(202225);
      return paramc;
    }
    AppMethodBeat.o(202225);
    return null;
  }
  
  public final MMActivity getActivity()
  {
    return this.fNT;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(202221);
    View localView = this.fNT.findViewById(2131299478);
    AppMethodBeat.o(202221);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202219);
    RecyclerView.h localh = cCD().getItemDecoration();
    AppMethodBeat.o(202219);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.f.b
 * JD-Core Version:    0.7.0.1
 */
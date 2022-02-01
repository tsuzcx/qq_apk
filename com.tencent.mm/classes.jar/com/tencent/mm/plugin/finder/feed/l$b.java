package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.h.a.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"})
public final class l$b
  extends c.b
{
  private final String TAG;
  
  public l$b(MMActivity paramMMActivity)
  {
    super(paramMMActivity, 0, 0, true);
    AppMethodBeat.i(201640);
    this.TAG = "Finder.FinderFriendLikeFeedUIContract.ViewCallback";
    AppMethodBeat.o(201640);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(201637);
    k.h(parama, "adapter");
    k.h(paramView, "view");
    paramInt -= ((d)parama).JCb.size();
    if ((paramInt >= 0) && (paramInt < cuC().rgh.getSize()))
    {
      parama = ((BaseFinderFeed)cuC().rgh.getDataListJustForAdapter().get(paramInt)).feedObject;
      ac.i(this.TAG, "onClick " + paramInt + " id:" + parama.getId() + ", pos:" + paramInt);
      parama = new Intent();
      parama.putExtra("KEY_CLICK_FEED_POSITION", paramInt);
      long l = System.currentTimeMillis();
      Object localObject1 = h.rmQ;
      localObject1 = (List)cuC().rgh.getDataListJustForAdapter();
      Object localObject2 = cuC().rgh;
      if (localObject2 == null)
      {
        parama = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFriendLikeLoader");
        AppMethodBeat.o(201637);
        throw parama;
      }
      localObject2 = ((h)localObject2).lastBuffer;
      k.h(localObject1, "dataList");
      ac.i(h.access$getTAG$cp(), "putCache " + l + ", list size:" + ((List)localObject1).size());
      List localList = (List)new ArrayList();
      localList.addAll((Collection)localObject1);
      h.cvC().put(Long.valueOf(l), new h.a.a(localList, (b)localObject2));
      parama.putExtra("KEY_CACHE_ID", l);
      localObject1 = a.rOv;
      paramView = paramView.getContext();
      k.g(paramView, "view.context");
      a.P(paramView, parama);
    }
    AppMethodBeat.o(201637);
  }
  
  public final void cuH() {}
  
  public final String e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201638);
    k.h(paramc, "reason");
    AppMethodBeat.o(201638);
    return "";
  }
  
  public final RecyclerView.i eL(Context paramContext)
  {
    AppMethodBeat.i(201636);
    k.h(paramContext, "context");
    paramContext = cuF().eL(paramContext);
    AppMethodBeat.o(201636);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(201639);
    k.h(paramc, "reason");
    AppMethodBeat.o(201639);
    return "";
  }
  
  public final MMActivity getActivity()
  {
    return this.iMV;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(201635);
    View localView = this.iMV.findViewById(2131299478);
    AppMethodBeat.o(201635);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(201634);
    RecyclerView.h localh = cuF().getItemDecoration();
    AppMethodBeat.o(201634);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.l.b
 * JD-Core Version:    0.7.0.1
 */
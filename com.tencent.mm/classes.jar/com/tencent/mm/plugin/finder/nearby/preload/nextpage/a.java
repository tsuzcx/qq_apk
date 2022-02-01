package com.tencent.mm.plugin.finder.nearby.preload.nextpage;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "commentScene", "", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;I)V", "PRELOAD_OPEN", "", "PRELOAD_THRESHLOD_COUNT", "TAG", "", "getCommentScene", "()I", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "hasInitDone", "hasMore", "isPreloading", "isRefreshing", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "startPreloadTimeStamp", "", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "checkFocusItemChange", "", "newState", "dy", "finishPreload", "initDone", "onRefreshEnd", "startPreload", "startRefresh", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final int AJo;
  private final BaseFinderFeedLoader ALH;
  private final bnn EIq;
  private final boolean EQl;
  private final int EQm;
  public boolean EQn;
  private long EQo;
  private final String TAG;
  private boolean hasMore;
  public boolean isRefreshing;
  private final RecyclerView mkw;
  public boolean uSA;
  
  public a(RecyclerView paramRecyclerView, BaseFinderFeedLoader paramBaseFinderFeedLoader, bnn parambnn, int paramInt)
  {
    AppMethodBeat.i(340018);
    this.mkw = paramRecyclerView;
    this.ALH = paramBaseFinderFeedLoader;
    this.EIq = parambnn;
    this.AJo = paramInt;
    this.TAG = "FeedStreamPreload";
    paramRecyclerView = d.FAy;
    if (((Number)d.eWi().bmg()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.EQl = bool;
      paramRecyclerView = d.FAy;
      this.EQm = ((Number)d.eWj().bmg()).intValue();
      this.hasMore = true;
      this.mkw.a((RecyclerView.l)new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(340026);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(340026);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(340019);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt1);
          localb.sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
          s.u(paramAnonymousRecyclerView, "recyclerView");
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          a.a(this.EQp, paramAnonymousRecyclerView, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(340019);
        }
      });
      AppMethodBeat.o(340018);
      return;
    }
  }
  
  public final void sR(boolean paramBoolean)
  {
    AppMethodBeat.i(340040);
    Log.i(this.TAG, "finishPreload hasMore:" + paramBoolean + " preloadTime:" + (System.currentTimeMillis() - this.EQo));
    this.uSA = false;
    this.hasMore = paramBoolean;
    AppMethodBeat.o(340040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.nextpage.a
 * JD-Core Version:    0.7.0.1
 */
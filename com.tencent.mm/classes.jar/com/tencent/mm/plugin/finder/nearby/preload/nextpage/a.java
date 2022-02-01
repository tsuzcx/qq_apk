package com.tencent.mm.plugin.finder.nearby.preload.nextpage;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "commentScene", "", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;I)V", "PRELOAD_OPEN", "", "PRELOAD_THRESHLOD_COUNT", "TAG", "", "getCommentScene", "()I", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "hasInitDone", "hasMore", "isPreloading", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "startPreloadTimeStamp", "", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "checkFocusItemChange", "", "newState", "dy", "finishPreload", "initDone", "startPreload", "plugin-finder-nearby_release"})
public final class a
{
  private final String TAG;
  private boolean hasMore;
  private final RecyclerView jLl;
  public boolean rHi;
  private final int xkX;
  private final bcz zDU;
  private final boolean zIS;
  private final int zIT;
  public boolean zIU;
  private long zIV;
  private final BaseFeedLoader<bu> zIW;
  
  public a(RecyclerView paramRecyclerView, BaseFeedLoader<bu> paramBaseFeedLoader, bcz parambcz, int paramInt)
  {
    AppMethodBeat.i(202371);
    this.jLl = paramRecyclerView;
    this.zIW = paramBaseFeedLoader;
    this.zDU = parambcz;
    this.xkX = paramInt;
    this.TAG = "FeedStreamPreload";
    paramRecyclerView = d.AjH;
    if (((Number)d.dXs().aSr()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.zIS = bool;
      paramRecyclerView = d.AjH;
      this.zIT = ((Number)d.dXt().aSr()).intValue();
      this.hasMore = true;
      this.jLl.a((RecyclerView.l)new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(203220);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(203220);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(203216);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousRecyclerView);
          localb.sg(paramAnonymousInt1);
          localb.sg(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
          p.k(paramAnonymousRecyclerView, "recyclerView");
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          a.a(this.zIX, paramAnonymousRecyclerView, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(203216);
        }
      });
      AppMethodBeat.o(202371);
      return;
    }
  }
  
  public final void pT(boolean paramBoolean)
  {
    AppMethodBeat.i(202362);
    Log.i(this.TAG, "finishPreload hasMore:" + paramBoolean + " preloadTime:" + (System.currentTimeMillis() - this.zIV));
    this.rHi = false;
    this.hasMore = paramBoolean;
    AppMethodBeat.o(202362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.nextpage.a
 * JD-Core Version:    0.7.0.1
 */
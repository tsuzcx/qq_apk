package com.tencent.mm.plugin.finder.feed.component;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FinderNewTwoFlowPreloadListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "tag", "", "rlLayout", "Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "(Ljava/lang/String;Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends RecyclerView.l
{
  private final WxRefreshLayout Bcu;
  private final String tag;
  
  public g(String paramString, WxRefreshLayout paramWxRefreshLayout)
  {
    AppMethodBeat.i(364052);
    this.tag = paramString;
    this.Bcu = paramWxRefreshLayout;
    AppMethodBeat.o(364052);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(364068);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
    a.c("com/tencent/mm/plugin/finder/feed/component/FinderNewTwoFlowPreloadListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    s.u(paramRecyclerView, "recyclerView");
    switch (paramInt)
    {
    case 1: 
    default: 
      a.a(this, "com/tencent/mm/plugin/finder/feed/component/FinderNewTwoFlowPreloadListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(364068);
      return;
    }
    localObject = paramRecyclerView.getLayoutManager();
    if ((localObject instanceof FinderStaggeredGridLayoutManager)) {}
    for (localObject = (FinderStaggeredGridLayoutManager)localObject; localObject == null; localObject = null)
    {
      a.a(this, "com/tencent/mm/plugin/finder/feed/component/FinderNewTwoFlowPreloadListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(364068);
      return;
    }
    paramRecyclerView = paramRecyclerView.getAdapter();
    int i;
    label155:
    int j;
    int k;
    boolean bool1;
    if (paramRecyclerView == null)
    {
      i = 0;
      paramRecyclerView = new int[2];
      int[] arrayOfInt = new int[2];
      ((FinderStaggeredGridLayoutManager)localObject).n(paramRecyclerView);
      ((FinderStaggeredGridLayoutManager)localObject).o(arrayOfInt);
      j = arrayOfInt[1];
      localObject = d.FAy;
      k = ((Number)d.eWj().bmg()).intValue();
      if ((j == -1) || (i - j > k) || (i <= 0)) {
        break label335;
      }
      bool1 = true;
      label226:
      if (!bool1) {
        break label341;
      }
      this.Bcu.jNu();
    }
    label335:
    label341:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i(this.tag, "checkPreload: preloadSuccess = " + bool2 + ", enablePreload = " + bool1 + ", newState = " + paramInt + ", firstPos = " + paramRecyclerView[0] + ", endPos = " + j + ", preloadThreshold = " + k + ", itemCount = " + i);
      break;
      i = paramRecyclerView.getItemCount();
      break label155;
      bool1 = false;
      break label226;
    }
  }
  
  public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(364075);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    a.c("com/tencent/mm/plugin/finder/feed/component/FinderNewTwoFlowPreloadListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/finder/feed/component/FinderNewTwoFlowPreloadListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
    AppMethodBeat.o(364075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.g
 * JD-Core Version:    0.7.0.1
 */
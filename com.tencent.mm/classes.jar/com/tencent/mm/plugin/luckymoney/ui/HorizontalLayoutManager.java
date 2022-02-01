package com.tencent.mm.plugin.luckymoney.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/luckymoney/ui/HorizontalLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "canScrollHorizontal", "getCanScrollHorizontal", "()Z", "setCanScrollHorizontal", "(Z)V", "extraLayoutSpace", "scrollState", "scroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "canScrollHorizontally", "canScrollVertically", "getExtraLayoutSpace", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setExtraLayoutSpace", "setScrollVerticallyEnable", "enable", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HorizontalLayoutManager
  extends LinearLayoutManager
{
  public static final HorizontalLayoutManager.a KyW;
  private boolean KyX;
  private int dyP;
  public int xwJ;
  
  static
  {
    AppMethodBeat.i(163899);
    KyW = new HorizontalLayoutManager.a((byte)0);
    AppMethodBeat.o(163899);
  }
  
  public HorizontalLayoutManager()
  {
    AppMethodBeat.i(163898);
    setOrientation(0);
    setItemPrefetchEnabled(true);
    this.bXK = 4;
    this.KyX = true;
    AppMethodBeat.o(163898);
  }
  
  public final int b(RecyclerView.s params)
  {
    AppMethodBeat.i(284474);
    s.u(params, "state");
    if (this.xwJ > 0)
    {
      i = this.xwJ;
      AppMethodBeat.o(284474);
      return i;
    }
    int i = super.b(params);
    AppMethodBeat.o(284474);
    return i;
  }
  
  public final void bo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163891);
    super.bo(paramInt1, paramInt2);
    AppMethodBeat.o(163891);
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(163896);
    if (this.KyX)
    {
      AppMethodBeat.o(163896);
      return true;
    }
    boolean bool = super.canScrollHorizontally();
    AppMethodBeat.o(163896);
    return bool;
  }
  
  public final boolean canScrollVertically()
  {
    return false;
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(284457);
    super.onLayoutChildren(paramn, params);
    AppMethodBeat.o(284457);
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(163894);
    super.onScrollStateChanged(paramInt);
    this.dyP = paramInt;
    AppMethodBeat.o(163894);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(284453);
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    AppMethodBeat.o(284453);
    return paramInt;
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(163890);
    super.scrollToPosition(paramInt);
    AppMethodBeat.o(163890);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(284463);
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    AppMethodBeat.o(284463);
    return paramInt;
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager
 * JD-Core Version:    0.7.0.1
 */
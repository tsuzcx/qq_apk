package com.tencent.mm.plugin.luckymoney.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/luckymoney/ui/HorizontalLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "canScrollHorizontal", "getCanScrollHorizontal", "()Z", "setCanScrollHorizontal", "(Z)V", "extraLayoutSpace", "scrollState", "scroller", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "canScrollHorizontally", "canScrollVertically", "getExtraLayoutSpace", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setExtraLayoutSpace", "setScrollVerticallyEnable", "enable", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-wxpay_release"})
public final class HorizontalLayoutManager
  extends LinearLayoutManager
{
  public static final a EFO;
  private boolean EFN;
  private int bFP;
  public int uqm;
  
  static
  {
    AppMethodBeat.i(163899);
    EFO = new a((byte)0);
    AppMethodBeat.o(163899);
  }
  
  public HorizontalLayoutManager()
  {
    AppMethodBeat.i(163898);
    setOrientation(0);
    setItemPrefetchEnabled(true);
    cC(4);
    this.EFN = true;
    AppMethodBeat.o(163898);
  }
  
  public final void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163891);
    super.au(paramInt1, paramInt2);
    AppMethodBeat.o(163891);
  }
  
  public final int b(RecyclerView.s params)
  {
    AppMethodBeat.i(270259);
    p.k(params, "state");
    if (this.uqm > 0)
    {
      i = this.uqm;
      AppMethodBeat.o(270259);
      return i;
    }
    int i = super.b(params);
    AppMethodBeat.o(270259);
    return i;
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(163896);
    if (this.EFN)
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
    AppMethodBeat.i(270256);
    super.onLayoutChildren(paramn, params);
    AppMethodBeat.o(270256);
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(163894);
    super.onScrollStateChanged(paramInt);
    this.bFP = paramInt;
    AppMethodBeat.o(163894);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(270255);
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    AppMethodBeat.o(270255);
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
    AppMethodBeat.i(270257);
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    AppMethodBeat.o(270257);
    return paramInt;
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/luckymoney/ui/HorizontalLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager
 * JD-Core Version:    0.7.0.1
 */
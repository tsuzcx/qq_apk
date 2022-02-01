package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/luckymoney/ui/HorizontalLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "canScrollHorizontal", "getCanScrollHorizontal", "()Z", "setCanScrollHorizontal", "(Z)V", "extraLayoutSpace", "scrollState", "scroller", "Landroid/support/v7/widget/LinearSmoothScroller;", "canScrollHorizontally", "canScrollVertically", "getExtraLayoutSpace", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setExtraLayoutSpace", "setScrollVerticallyEnable", "enable", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-wxpay_release"})
public final class HorizontalLayoutManager
  extends LinearLayoutManager
{
  public static final a zbr;
  public int qOi;
  private int vp;
  private boolean zbq;
  
  static
  {
    AppMethodBeat.i(163899);
    zbr = new a((byte)0);
    AppMethodBeat.o(163899);
  }
  
  public HorizontalLayoutManager()
  {
    AppMethodBeat.i(163898);
    setOrientation(0);
    setItemPrefetchEnabled(true);
    ca(4);
    this.zbq = true;
    AppMethodBeat.o(163898);
  }
  
  public final void ah(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163891);
    super.ah(paramInt1, paramInt2);
    AppMethodBeat.o(163891);
  }
  
  public final int b(RecyclerView.s params)
  {
    AppMethodBeat.i(163897);
    p.h(params, "state");
    if (this.qOi > 0)
    {
      i = this.qOi;
      AppMethodBeat.o(163897);
      return i;
    }
    int i = super.b(params);
    AppMethodBeat.o(163897);
    return i;
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(163896);
    if (this.zbq)
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
    AppMethodBeat.i(163893);
    super.onLayoutChildren(paramn, params);
    AppMethodBeat.o(163893);
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(163894);
    super.onScrollStateChanged(paramInt);
    this.vp = paramInt;
    AppMethodBeat.o(163894);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(163892);
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    AppMethodBeat.o(163892);
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
    AppMethodBeat.i(163895);
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    AppMethodBeat.o(163895);
    return paramInt;
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/luckymoney/ui/HorizontalLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager
 * JD-Core Version:    0.7.0.1
 */
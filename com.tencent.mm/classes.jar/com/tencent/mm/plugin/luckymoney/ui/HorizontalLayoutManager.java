package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luckymoney/ui/HorizontalLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "canScrollHorizontal", "getCanScrollHorizontal", "()Z", "setCanScrollHorizontal", "(Z)V", "extraLayoutSpace", "scrollState", "scroller", "Landroid/support/v7/widget/LinearSmoothScroller;", "canScrollHorizontally", "canScrollVertically", "getExtraLayoutSpace", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setExtraLayoutSpace", "setScrollVerticallyEnable", "enable", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-wxpay_release"})
public final class HorizontalLayoutManager
  extends LinearLayoutManager
{
  public static final HorizontalLayoutManager.a vGs;
  public int pyR;
  private boolean vGr;
  private int vi;
  
  static
  {
    AppMethodBeat.i(163899);
    vGs = new HorizontalLayoutManager.a((byte)0);
    AppMethodBeat.o(163899);
  }
  
  public HorizontalLayoutManager()
  {
    AppMethodBeat.i(163898);
    setOrientation(0);
    aw(true);
    cb(4);
    this.vGr = true;
    AppMethodBeat.o(163898);
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(163892);
    paramInt = super.a(paramInt, paramo, paramt);
    AppMethodBeat.o(163892);
    return paramInt;
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt) {}
  
  public final void ag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(163891);
    super.ag(paramInt1, paramInt2);
    AppMethodBeat.o(163891);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(163895);
    paramInt = super.b(paramInt, paramo, paramt);
    AppMethodBeat.o(163895);
    return paramInt;
  }
  
  public final int c(RecyclerView.t paramt)
  {
    AppMethodBeat.i(163897);
    p.h(paramt, "state");
    if (this.pyR > 0)
    {
      i = this.pyR;
      AppMethodBeat.o(163897);
      return i;
    }
    int i = super.c(paramt);
    AppMethodBeat.o(163897);
    return i;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(163893);
    super.c(paramo, paramt);
    AppMethodBeat.o(163893);
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(163890);
    super.ca(paramInt);
    AppMethodBeat.o(163890);
  }
  
  public final void cp(int paramInt)
  {
    AppMethodBeat.i(163894);
    super.cp(paramInt);
    this.vi = paramInt;
    AppMethodBeat.o(163894);
  }
  
  public final boolean kc()
  {
    AppMethodBeat.i(163896);
    if (this.vGr)
    {
      AppMethodBeat.o(163896);
      return true;
    }
    boolean bool = super.kc();
    AppMethodBeat.o(163896);
    return bool;
  }
  
  public final boolean kd()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager
 * JD-Core Version:    0.7.0.1
 */
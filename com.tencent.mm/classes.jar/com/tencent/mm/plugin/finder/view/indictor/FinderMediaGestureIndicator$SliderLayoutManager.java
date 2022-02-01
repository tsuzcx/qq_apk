package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.support.v7.widget.af;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;", "setCallback", "(Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$OnItemSelectedListener;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "smoothScrollerSpeed", "", "getSmoothScrollerSpeed", "()F", "setSmoothScrollerSpeed", "(F)V", "getRecyclerViewCenterX", "", "onAttachedToWindow", "", "view", "onLayoutChildren", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onScrollStateChanged", "scaleDownView", "scrollHorizontallyBy", "dx", "smoothScrollToPosition", "position", "OnItemSelectedListener", "plugin-finder_release"})
public final class FinderMediaGestureIndicator$SliderLayoutManager
  extends LinearLayoutManager
{
  private RecyclerView hak;
  float wsx;
  
  public FinderMediaGestureIndicator$SliderLayoutManager(Context paramContext)
  {
    AppMethodBeat.i(255237);
    setOrientation(0);
    this.wsx = 50.0F;
    AppMethodBeat.o(255237);
  }
  
  private final void dHy()
  {
    AppMethodBeat.i(255235);
    float f1 = getWidth() / 2.0F;
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView == null) {
        p.hyc();
      }
      p.g(localView, "getChildAt(i)!!");
      float f2 = 1.0F - (float)Math.sqrt(Math.abs(f1 - (getDecoratedLeft(localView) + getDecoratedRight(localView)) / 2.0F) / getWidth()) * 0.66F;
      localView.setScaleX(f2);
      localView.setScaleY(f2);
      i += 1;
    }
    AppMethodBeat.o(255235);
  }
  
  public final void onAttachedToWindow(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(255231);
    super.onAttachedToWindow(paramRecyclerView);
    if (paramRecyclerView == null) {
      p.hyc();
    }
    this.hak = paramRecyclerView;
    paramRecyclerView = new af();
    RecyclerView localRecyclerView = this.hak;
    if (localRecyclerView == null) {
      p.btv("recyclerView");
    }
    paramRecyclerView.f(localRecyclerView);
    AppMethodBeat.o(255231);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(255232);
    p.h(params, "state");
    super.onLayoutChildren(paramn, params);
    dHy();
    AppMethodBeat.o(255232);
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(255236);
    super.onScrollStateChanged(paramInt);
    int i;
    if (paramInt == 0)
    {
      Object localObject = this.hak;
      if (localObject == null) {
        p.btv("recyclerView");
      }
      paramInt = ((RecyclerView)localObject).getRight();
      localObject = this.hak;
      if (localObject == null) {
        p.btv("recyclerView");
      }
      int k = (paramInt - ((RecyclerView)localObject).getLeft()) / 2;
      localObject = this.hak;
      if (localObject == null) {
        p.btv("recyclerView");
      }
      int m = ((RecyclerView)localObject).getLeft();
      paramInt = 2147483647;
      localObject = this.hak;
      if (localObject == null) {
        p.btv("recyclerView");
      }
      int n = ((RecyclerView)localObject).getChildCount();
      i = 0;
      if (i < n)
      {
        localObject = this.hak;
        if (localObject == null) {
          p.btv("recyclerView");
        }
        localObject = ((RecyclerView)localObject).getChildAt(i);
        int j = Math.abs(getDecoratedLeft((View)localObject) + (getDecoratedRight((View)localObject) - getDecoratedLeft((View)localObject)) / 2 - (k + m));
        if (j >= paramInt) {
          break label214;
        }
        if (this.hak == null) {
          p.btv("recyclerView");
        }
        RecyclerView.bx((View)localObject);
        paramInt = j;
      }
    }
    label214:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(255236);
      return;
    }
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(255234);
    if (getOrientation() == 0)
    {
      paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
      dHy();
      AppMethodBeat.o(255234);
      return paramInt;
    }
    AppMethodBeat.o(255234);
    return 0;
  }
  
  public final void smoothScrollToPosition(final RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(255233);
    p.h(paramRecyclerView, "recyclerView");
    paramRecyclerView = new a(this, paramRecyclerView, paramRecyclerView.getContext());
    paramRecyclerView.ct(paramInt);
    startSmoothScroll((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(255233);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/indictor/FinderMediaGestureIndicator$SliderLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder_release"})
  public static final class a
    extends ae
  {
    a(RecyclerView paramRecyclerView, Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(255230);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = this.wsy.wsx / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(255230);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator.SliderLayoutManager
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.support.v7.widget.af;
import android.support.v7.widget.aj;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper;", "Landroid/support/v7/widget/LinearSnapHelper;", "()V", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "onPageSelectedListener", "Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "verticalHelper", "attachToRecyclerView", "", "createScroller", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "findCenterView", "Landroid/view/View;", "helper", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "getHorizontalHelper", "getVerticalHelper", "OnPageSelectedListener", "plugin-emojicapture_release"})
public final class c
  extends af
{
  RecyclerView hak;
  private aj hbL;
  private aj hbM;
  public a rwT;
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(893);
    paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
    paramLayoutManager = this.rwT;
    if (paramLayoutManager != null) {
      paramLayoutManager.onPageSelected(paramInt1);
    }
    AppMethodBeat.o(893);
    return paramInt1;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(894);
    if (paramLayoutManager == null)
    {
      AppMethodBeat.o(894);
      return null;
    }
    Object localObject1;
    Object localObject2;
    int i1;
    if (paramLayoutManager.canScrollHorizontally())
    {
      if (this.hbM != null)
      {
        localObject1 = this.hbM;
        if (localObject1 == null) {
          break label164;
        }
        localObject1 = ((aj)localObject1).getLayoutManager();
        if (localObject1 == paramLayoutManager) {}
      }
      else
      {
        this.hbM = aj.d(paramLayoutManager);
      }
      localObject2 = this.hbM;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        p.hyc();
        localObject1 = localObject2;
      }
      i1 = paramLayoutManager.getChildCount();
      if (i1 != 0) {
        break label240;
      }
      localObject1 = null;
      label100:
      if (localObject1 == null) {
        break label397;
      }
      paramLayoutManager = ((View)localObject1).getLayoutParams();
      label111:
      localObject2 = paramLayoutManager;
      if (!(paramLayoutManager instanceof RecyclerView.LayoutParams)) {
        localObject2 = null;
      }
      paramLayoutManager = (RecyclerView.LayoutParams)localObject2;
      if (paramLayoutManager == null) {
        break label402;
      }
    }
    label394:
    label397:
    label402:
    for (int i = paramLayoutManager.lG();; i = -1)
    {
      paramLayoutManager = this.rwT;
      if (paramLayoutManager != null) {
        paramLayoutManager.onPageSelected(i);
      }
      AppMethodBeat.o(894);
      return localObject1;
      label164:
      localObject1 = null;
      break;
      if (this.hbL != null)
      {
        localObject1 = this.hbL;
        if (localObject1 == null) {
          break label234;
        }
      }
      label234:
      for (localObject1 = ((aj)localObject1).getLayoutManager();; localObject1 = null)
      {
        if (localObject1 != paramLayoutManager) {
          this.hbL = aj.e(paramLayoutManager);
        }
        localObject2 = this.hbL;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        p.hyc();
        localObject1 = localObject2;
        break;
      }
      label240:
      if (paramLayoutManager.getClipToPadding()) {
        i = ((aj)localObject1).kH();
      }
      int k;
      for (i = ((aj)localObject1).kJ() / 2 + i;; i = ((aj)localObject1).getEnd() / 2)
      {
        k = 2147483647;
        int j = 0;
        localObject1 = null;
        for (;;)
        {
          if (j >= i1) {
            break label394;
          }
          localObject2 = paramLayoutManager.getChildAt(j);
          if (localObject2 != null) {
            break;
          }
          m = k;
          j += 1;
          k = m;
        }
      }
      p.g(localObject2, "layoutManager.getChildAt(i) ?: continue");
      if (paramLayoutManager.canScrollHorizontally()) {}
      for (int m = ((View)localObject2).getLeft() + ((View)localObject2).getMeasuredWidth() / 2;; m = ((View)localObject2).getTop() + ((View)localObject2).getMeasuredHeight() / 2)
      {
        int n = Math.abs(m - i);
        m = k;
        if (n >= k) {
          break;
        }
        m = n;
        localObject1 = localObject2;
        break;
      }
      break label100;
      paramLayoutManager = null;
      break label111;
    }
  }
  
  public final void f(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(891);
    super.f(paramRecyclerView);
    this.hak = paramRecyclerView;
    AppMethodBeat.o(891);
  }
  
  public final RecyclerView.r g(RecyclerView.LayoutManager paramLayoutManager)
  {
    Object localObject = null;
    AppMethodBeat.i(892);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(892);
      return null;
    }
    RecyclerView localRecyclerView = this.hak;
    paramLayoutManager = localObject;
    if (localRecyclerView != null) {
      paramLayoutManager = localRecyclerView.getContext();
    }
    paramLayoutManager = (RecyclerView.r)new b(this, paramLayoutManager);
    AppMethodBeat.o(892);
    return paramLayoutManager;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-emojicapture_release"})
  public static abstract interface a
  {
    public abstract void onPageSelected(int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$createScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "action", "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-emojicapture_release"})
  public static final class b
    extends ae
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(890);
      p.h(paramView, "targetView");
      p.h(params, "state");
      p.h(parama, "action");
      if (this.rwU.hak != null)
      {
        c localc = this.rwU;
        params = this.rwU.hak;
        if (params != null) {}
        int i;
        int j;
        for (params = params.getLayoutManager();; params = null)
        {
          if (params == null) {
            p.hyc();
          }
          paramView = localc.a(params, paramView);
          if (paramView == null) {
            p.hyc();
          }
          i = paramView[0];
          j = paramView[1];
          int k = cc(Math.max(Math.abs(i), Math.abs(j)));
          if (k <= 0) {
            break;
          }
          parama.a(i, j, k, (Interpolator)this.VQ);
          AppMethodBeat.o(890);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.VQ);
      }
      AppMethodBeat.o(890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.c
 * JD-Core Version:    0.7.0.1
 */
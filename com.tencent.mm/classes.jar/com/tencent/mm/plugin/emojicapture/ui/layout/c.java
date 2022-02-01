package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.r.b;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.q;
import androidx.recyclerview.widget.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "()V", "horizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "onPageSelectedListener", "Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "verticalHelper", "attachToRecyclerView", "", "createScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findCenterView", "Landroid/view/View;", "helper", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "getHorizontalHelper", "getVerticalHelper", "OnPageSelectedListener", "plugin-emojicapture_release"})
public final class c
  extends q
{
  private RecyclerView jLl;
  private u jMV;
  private u jMW;
  public a vcz;
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201549);
    paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
    paramLayoutManager = this.vcz;
    if (paramLayoutManager != null) {
      paramLayoutManager.onPageSelected(paramInt1);
    }
    AppMethodBeat.o(201549);
    return paramInt1;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(201562);
    if (paramLayoutManager == null)
    {
      AppMethodBeat.o(201562);
      return null;
    }
    Object localObject1;
    Object localObject2;
    int i1;
    if (paramLayoutManager.canScrollHorizontally())
    {
      if (this.jMW != null)
      {
        localObject1 = this.jMW;
        if (localObject1 == null) {
          break label161;
        }
        localObject1 = ((u)localObject1).getLayoutManager();
        if (localObject1 == paramLayoutManager) {}
      }
      else
      {
        this.jMW = u.d(paramLayoutManager);
      }
      localObject2 = this.jMW;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.p.iCn();
        localObject1 = localObject2;
      }
      i1 = paramLayoutManager.getChildCount();
      if (i1 != 0) {
        break label237;
      }
      localObject1 = null;
      label98:
      if (localObject1 == null) {
        break label394;
      }
      paramLayoutManager = ((View)localObject1).getLayoutParams();
      label109:
      localObject2 = paramLayoutManager;
      if (!(paramLayoutManager instanceof RecyclerView.LayoutParams)) {
        localObject2 = null;
      }
      paramLayoutManager = (RecyclerView.LayoutParams)localObject2;
      if (paramLayoutManager == null) {
        break label399;
      }
    }
    label391:
    label394:
    label399:
    for (int i = paramLayoutManager.lS();; i = -1)
    {
      paramLayoutManager = this.vcz;
      if (paramLayoutManager != null) {
        paramLayoutManager.onPageSelected(i);
      }
      AppMethodBeat.o(201562);
      return localObject1;
      label161:
      localObject1 = null;
      break;
      if (this.jMV != null)
      {
        localObject1 = this.jMV;
        if (localObject1 == null) {
          break label231;
        }
      }
      label231:
      for (localObject1 = ((u)localObject1).getLayoutManager();; localObject1 = null)
      {
        if (localObject1 != paramLayoutManager) {
          this.jMV = u.e(paramLayoutManager);
        }
        localObject2 = this.jMV;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        kotlin.g.b.p.iCn();
        localObject1 = localObject2;
        break;
      }
      label237:
      if (paramLayoutManager.getClipToPadding()) {
        i = ((u)localObject1).kT();
      }
      int k;
      for (i = ((u)localObject1).kV() / 2 + i;; i = ((u)localObject1).getEnd() / 2)
      {
        k = 2147483647;
        int j = 0;
        localObject1 = null;
        for (;;)
        {
          if (j >= i1) {
            break label391;
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
      kotlin.g.b.p.j(localObject2, "layoutManager.getChildAt(i) ?: continue");
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
      break label98;
      paramLayoutManager = null;
      break label109;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(201541);
    super.a(paramRecyclerView);
    this.jLl = paramRecyclerView;
    AppMethodBeat.o(201541);
  }
  
  public final RecyclerView.r g(RecyclerView.LayoutManager paramLayoutManager)
  {
    Object localObject = null;
    AppMethodBeat.i(201546);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(201546);
      return null;
    }
    RecyclerView localRecyclerView = this.jLl;
    paramLayoutManager = localObject;
    if (localRecyclerView != null) {
      paramLayoutManager = localRecyclerView.getContext();
    }
    paramLayoutManager = (RecyclerView.r)new b(this, paramLayoutManager);
    AppMethodBeat.o(201546);
    return paramLayoutManager;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-emojicapture_release"})
  public static abstract interface a
  {
    public abstract void onPageSelected(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$createScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-emojicapture_release"})
  public static final class b
    extends androidx.recyclerview.widget.p
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(202605);
      kotlin.g.b.p.k(paramView, "targetView");
      kotlin.g.b.p.k(params, "state");
      kotlin.g.b.p.k(parama, "action");
      if (c.a(this.vcA) != null)
      {
        c localc = this.vcA;
        params = c.a(this.vcA);
        if (params != null) {}
        int i;
        int j;
        for (params = params.getLayoutManager();; params = null)
        {
          if (params == null) {
            kotlin.g.b.p.iCn();
          }
          paramView = localc.a(params, paramView);
          if (paramView == null) {
            kotlin.g.b.p.iCn();
          }
          i = paramView[0];
          j = paramView[1];
          int k = cE(Math.max(Math.abs(i), Math.abs(j)));
          if (k <= 0) {
            break;
          }
          parama.a(i, j, k, (Interpolator)this.aju);
          AppMethodBeat.o(202605);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.aju);
      }
      AppMethodBeat.o(202605);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.c
 * JD-Core Version:    0.7.0.1
 */
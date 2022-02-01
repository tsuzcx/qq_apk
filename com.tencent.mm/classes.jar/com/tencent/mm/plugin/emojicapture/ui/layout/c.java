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
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "()V", "horizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "onPageSelectedListener", "Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "verticalHelper", "attachToRecyclerView", "", "createScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findCenterView", "Landroid/view/View;", "helper", "findSnapView", "findTargetSnapPosition", "", "velocityX", "velocityY", "getHorizontalHelper", "getVerticalHelper", "OnPageSelectedListener", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
{
  private RecyclerView mkw;
  private androidx.recyclerview.widget.s mlU;
  private androidx.recyclerview.widget.s mlV;
  public a yos;
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(269459);
    paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
    paramLayoutManager = this.yos;
    if (paramLayoutManager != null) {
      paramLayoutManager.onPageSelected(paramInt1);
    }
    AppMethodBeat.o(269459);
    return paramInt1;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(269468);
    if (paramLayoutManager == null)
    {
      AppMethodBeat.o(269468);
      return null;
    }
    int i1;
    label89:
    label104:
    int i;
    if (paramLayoutManager.canScrollHorizontally())
    {
      if (this.mlV != null)
      {
        localObject1 = this.mlV;
        if (localObject1 != null) {
          break label137;
        }
      }
      label137:
      for (localObject1 = null;; localObject1 = ((androidx.recyclerview.widget.s)localObject1).getLayoutManager())
      {
        if (localObject1 != paramLayoutManager) {
          this.mlV = androidx.recyclerview.widget.s.d(paramLayoutManager);
        }
        localObject1 = this.mlV;
        kotlin.g.b.s.checkNotNull(localObject1);
        i1 = paramLayoutManager.getChildCount();
        if (i1 != 0) {
          break;
        }
        paramLayoutManager = null;
        if (paramLayoutManager != null) {
          break label363;
        }
        localObject1 = null;
        if (!(localObject1 instanceof RecyclerView.LayoutParams)) {
          break label372;
        }
        localObject1 = (RecyclerView.LayoutParams)localObject1;
        if (localObject1 != null) {
          break label378;
        }
        i = -1;
        label111:
        localObject1 = this.yos;
        if (localObject1 != null) {
          ((a)localObject1).onPageSelected(i);
        }
        AppMethodBeat.o(269468);
        return paramLayoutManager;
      }
    }
    if (this.mlU != null)
    {
      localObject1 = this.mlU;
      if (localObject1 != null) {
        break label196;
      }
    }
    label196:
    for (Object localObject1 = null;; localObject1 = ((androidx.recyclerview.widget.s)localObject1).getLayoutManager())
    {
      if (localObject1 != paramLayoutManager) {
        this.mlU = androidx.recyclerview.widget.s.e(paramLayoutManager);
      }
      localObject1 = this.mlU;
      kotlin.g.b.s.checkNotNull(localObject1);
      break;
    }
    label229:
    int m;
    int j;
    Object localObject2;
    label243:
    int n;
    View localView;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      i = ((androidx.recyclerview.widget.s)localObject1).JE();
      i = ((androidx.recyclerview.widget.s)localObject1).JG() / 2 + i;
      m = 0;
      if (i1 <= 0) {
        break label404;
      }
      j = 2147483647;
      localObject2 = null;
      n = m + 1;
      localView = paramLayoutManager.getChildAt(m);
      k = j;
      localObject1 = localObject2;
      if (localView != null)
      {
        if (!paramLayoutManager.canScrollHorizontally()) {
          break label345;
        }
        k = localView.getLeft() + localView.getMeasuredWidth() / 2;
        label291:
        m = Math.abs(k - i);
        k = j;
        localObject1 = localObject2;
        if (m < j)
        {
          k = m;
          localObject1 = localView;
        }
      }
      if (n < i1) {
        break label390;
      }
    }
    for (;;)
    {
      paramLayoutManager = (RecyclerView.LayoutManager)localObject1;
      break;
      i = ((androidx.recyclerview.widget.s)localObject1).getEnd() / 2;
      break label229;
      label345:
      k = localView.getTop() + localView.getMeasuredHeight() / 2;
      break label291;
      label363:
      localObject1 = paramLayoutManager.getLayoutParams();
      break label89;
      label372:
      localObject1 = null;
      break label104;
      label378:
      i = ((RecyclerView.LayoutParams)localObject1).bXh.KJ();
      break label111;
      label390:
      m = n;
      j = k;
      localObject2 = localObject1;
      break label243;
      label404:
      localObject1 = null;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(269452);
    super.a(paramRecyclerView);
    this.mkw = paramRecyclerView;
    AppMethodBeat.o(269452);
  }
  
  public final RecyclerView.r g(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(269455);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(269455);
      return null;
    }
    paramLayoutManager = this.mkw;
    if (paramLayoutManager == null) {}
    for (paramLayoutManager = null;; paramLayoutManager = paramLayoutManager.getContext())
    {
      paramLayoutManager = (RecyclerView.r)new b(this, paramLayoutManager);
      AppMethodBeat.o(269455);
      return paramLayoutManager;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onPageSelected(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$createScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends o
  {
    b(c paramc, Context paramContext)
    {
      super();
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(269446);
      kotlin.g.b.s.u(paramView, "targetView");
      kotlin.g.b.s.u(params, "state");
      kotlin.g.b.s.u(parama, "action");
      if (c.a(this.yot) != null)
      {
        c localc = this.yot;
        params = c.a(this.yot);
        if (params == null) {}
        int i;
        int j;
        for (params = null;; params = params.getLayoutManager())
        {
          kotlin.g.b.s.checkNotNull(params);
          paramView = localc.a(params, paramView);
          kotlin.g.b.s.checkNotNull(paramView);
          i = paramView[0];
          j = paramView[1];
          int k = fO(Math.max(Math.abs(i), Math.abs(j)));
          if (k <= 0) {
            break;
          }
          parama.a(i, j, k, (Interpolator)this.bXY);
          AppMethodBeat.o(269446);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.bXY);
      }
      AppMethodBeat.o(269446);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.c
 * JD-Core Version:    0.7.0.1
 */
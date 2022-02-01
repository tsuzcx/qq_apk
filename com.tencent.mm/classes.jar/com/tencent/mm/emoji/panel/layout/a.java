package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "dataObserver", "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1;", "horizontalHelper", "Landroid/support/v7/widget/OrientationHelper;", "getHorizontalHelper", "()Landroid/support/v7/widget/OrientationHelper;", "setHorizontalHelper", "(Landroid/support/v7/widget/OrientationHelper;)V", "isDragging", "", "()Z", "setDragging", "(Z)V", "onPageSelectedListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;)V", "onPageSettledListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "getOnPageSettledListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "setOnPageSettledListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;)V", "onPageStartChangeListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "getOnPageStartChangeListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "setOnPageStartChangeListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "scrollListener", "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1;", "<set-?>", "", "snapPosition", "getSnapPosition", "()I", "verticalHelper", "getVerticalHelper", "setVerticalHelper", "attachToRecyclerView", "", "checkSettle", "createScroller", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "findCenterView", "Landroid/view/View;", "helper", "findSnapView", "findTargetSnapPosition", "velocityX", "velocityY", "Companion", "OnPageSelectedListener", "OnPageSettledListener", "OnPageStartChangeListener", "plugin-emojisdk_release"})
public final class a
  extends ak
{
  public static final a.a hbU;
  private RecyclerView hak;
  private aj hbL;
  private aj hbM;
  public boolean hbN;
  private final a.g hbO;
  private final f hbP;
  public int hbQ;
  public a.b hbR;
  public a.c hbS;
  public a.d hbT;
  
  static
  {
    AppMethodBeat.i(199997);
    hbU = new a.a((byte)0);
    AppMethodBeat.o(199997);
  }
  
  public a()
  {
    AppMethodBeat.i(199996);
    this.hbO = new a.g(this);
    this.hbP = new f(this);
    this.hbQ = -1;
    AppMethodBeat.o(199996);
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199993);
    p.h(paramLayoutManager, "layoutManager");
    int n = paramLayoutManager.getItemCount();
    if (n == 0)
    {
      AppMethodBeat.o(199993);
      return -1;
    }
    Object localObject1;
    Object localObject2;
    int i1;
    Object localObject3;
    if (paramLayoutManager.canScrollVertically())
    {
      if (this.hbL != null)
      {
        localObject1 = this.hbL;
        if (localObject1 == null) {
          p.hyc();
        }
        if (((aj)localObject1).getLayoutManager() == paramLayoutManager) {}
      }
      else
      {
        this.hbL = aj.e(paramLayoutManager);
      }
      localObject1 = this.hbL;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        p.hyc();
        localObject2 = localObject1;
      }
      i1 = paramLayoutManager.getChildCount();
      if (i1 != 0) {
        break label185;
      }
      localObject3 = null;
    }
    label185:
    int j;
    int i;
    int k;
    for (;;)
    {
      if (localObject3 == null)
      {
        AppMethodBeat.o(199993);
        return -1;
        if (this.hbM != null)
        {
          localObject1 = this.hbM;
          if (localObject1 == null) {
            p.hyc();
          }
          if (((aj)localObject1).getLayoutManager() == paramLayoutManager) {}
        }
        else
        {
          this.hbM = aj.d(paramLayoutManager);
        }
        localObject1 = this.hbM;
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        p.hyc();
        localObject2 = localObject1;
        break;
        localObject1 = null;
        if (paramLayoutManager.getClipToPadding())
        {
          j = localObject2.kH() + localObject2.kJ() / 2;
          i = 2147483647;
          k = 0;
          label217:
          localObject3 = localObject1;
          if (k >= i1) {
            continue;
          }
          localObject3 = paramLayoutManager.getChildAt(k);
          int m = Math.abs(localObject2.bo((View)localObject3) + localObject2.bs((View)localObject3) / 2 - j);
          if (m >= i) {
            break label539;
          }
          localObject1 = localObject3;
          i = m;
        }
      }
    }
    label518:
    label523:
    label533:
    label539:
    for (;;)
    {
      k += 1;
      break label217;
      j = localObject2.getEnd() / 2;
      break;
      k = paramLayoutManager.getPosition((View)localObject3);
      if (localObject2.bo((View)localObject3) < localObject2.kH())
      {
        i = k + 1;
        j = k;
      }
      while (k == -1)
      {
        AppMethodBeat.o(199993);
        return -1;
        j = k - 1;
        i = k;
      }
      if (paramLayoutManager.canScrollHorizontally()) {
        if (paramInt1 > 0)
        {
          paramInt1 = 1;
          k = 0;
          paramInt2 = k;
          if ((paramLayoutManager instanceof RecyclerView.r.b))
          {
            paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).bZ(n - 1);
            paramInt2 = k;
            if (paramLayoutManager != null)
            {
              if ((paramLayoutManager.x >= 0.0F) && (paramLayoutManager.y >= 0.0F)) {
                break label518;
              }
              paramInt2 = 1;
            }
          }
          label423:
          if (paramInt2 == 0) {
            break label523;
          }
          if (paramInt1 != 0) {
            break label533;
          }
          paramInt1 = i;
        }
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
          paramInt2 = 0;
        }
        paramInt1 = paramInt2;
        if (paramInt2 >= n) {
          paramInt1 = n - 1;
        }
        if (paramInt1 != this.hbQ)
        {
          this.hbQ = paramInt1;
          paramLayoutManager = this.hbR;
          if (paramLayoutManager != null) {
            paramLayoutManager.onPageSelected(this.hbQ);
          }
        }
        paramInt1 = this.hbQ;
        AppMethodBeat.o(199993);
        return paramInt1;
        paramInt1 = 0;
        break;
        if (paramInt2 > 0)
        {
          paramInt1 = 1;
          break;
        }
        paramInt1 = 0;
        break;
        paramInt2 = 0;
        break label423;
        if (paramInt1 != 0) {
          paramInt1 = i;
        } else {
          paramInt1 = j;
        }
      }
    }
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(199994);
    View localView = super.a(paramLayoutManager);
    if (localView != null)
    {
      paramLayoutManager = localView.getLayoutParams();
      RecyclerView.LayoutManager localLayoutManager = paramLayoutManager;
      if (!(paramLayoutManager instanceof RecyclerView.LayoutParams)) {
        localLayoutManager = null;
      }
      paramLayoutManager = (RecyclerView.LayoutParams)localLayoutManager;
      if (paramLayoutManager == null) {
        break label93;
      }
    }
    label93:
    for (int i = paramLayoutManager.lG();; i = -1)
    {
      if (this.hbQ != i)
      {
        this.hbQ = i;
        paramLayoutManager = this.hbR;
        if (paramLayoutManager != null) {
          paramLayoutManager.onPageSelected(this.hbQ);
        }
      }
      AppMethodBeat.o(199994);
      return localView;
      paramLayoutManager = null;
      break;
    }
  }
  
  public final void avW()
  {
    AppMethodBeat.i(199995);
    if (this.hbS == null)
    {
      AppMethodBeat.o(199995);
      return;
    }
    Object localObject = this.hak;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getLayoutManager();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(199995);
      return;
    }
    p.g(localObject, "recyclerView?.layoutManager ?: return");
    View localView = a((RecyclerView.LayoutManager)localObject);
    if (localView == null)
    {
      AppMethodBeat.o(199995);
      return;
    }
    localObject = a((RecyclerView.LayoutManager)localObject, localView);
    if (localObject == null)
    {
      AppMethodBeat.o(199995);
      return;
    }
    if ((localObject[0] == 0) || (localObject[1] == 0))
    {
      localObject = this.hbS;
      if (localObject != null)
      {
        ((a.c)localObject).pq(this.hbQ);
        AppMethodBeat.o(199995);
        return;
      }
    }
    AppMethodBeat.o(199995);
  }
  
  public final void f(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(199991);
    super.f(paramRecyclerView);
    Object localObject = this.hak;
    if (localObject != null) {
      ((RecyclerView)localObject).b((RecyclerView.l)this.hbO);
    }
    localObject = this.hak;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).b((RecyclerView.c)this.hbP);
      }
    }
    this.hak = paramRecyclerView;
    paramRecyclerView = this.hak;
    if (paramRecyclerView != null) {
      paramRecyclerView.a((RecyclerView.l)this.hbO);
    }
    paramRecyclerView = this.hak;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView != null) {
        paramRecyclerView.a((RecyclerView.c)this.hbP);
      }
    }
    avW();
    AppMethodBeat.o(199991);
  }
  
  public final RecyclerView.r g(final RecyclerView.LayoutManager paramLayoutManager)
  {
    Context localContext = null;
    AppMethodBeat.i(199992);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(199992);
      return null;
    }
    RecyclerView localRecyclerView = this.hak;
    if (localRecyclerView != null) {
      localContext = localRecyclerView.getContext();
    }
    paramLayoutManager = (RecyclerView.r)new e(this, paramLayoutManager, localContext);
    AppMethodBeat.o(199992);
    return paramLayoutManager;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$createScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "action", "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-emojisdk_release"})
  public static final class e
    extends ae
  {
    e(RecyclerView.LayoutManager paramLayoutManager, Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(199984);
      p.h(paramDisplayMetrics, "displayMetrics");
      float f = 50.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(199984);
      return f;
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(199983);
      p.h(paramView, "targetView");
      p.h(params, "state");
      p.h(parama, "action");
      if (a.a(this.hbV) != null)
      {
        paramView = this.hbV.a(paramLayoutManager, paramView);
        if (paramView == null) {
          p.hyc();
        }
        int i = paramView[0];
        int j = paramView[1];
        int k = cc(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0)
        {
          parama.a(i, j, k, (Interpolator)this.VQ);
          AppMethodBeat.o(199983);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.VQ);
      }
      AppMethodBeat.o(199983);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "plugin-emojisdk_release"})
  public static final class f
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(199987);
      super.onChanged();
      if (this.hbV.hbQ == -1)
      {
        RecyclerView localRecyclerView = a.a(this.hbV);
        if (localRecyclerView != null)
        {
          localRecyclerView.post((Runnable)new a(this));
          AppMethodBeat.o(199987);
          return;
        }
      }
      AppMethodBeat.o(199987);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199988);
      super.onItemRangeInserted(paramInt1, paramInt2);
      if (this.hbV.hbQ == -1)
      {
        RecyclerView localRecyclerView = a.a(this.hbV);
        if (localRecyclerView != null)
        {
          localRecyclerView.post((Runnable)new b(this));
          AppMethodBeat.o(199988);
          return;
        }
      }
      AppMethodBeat.o(199988);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(199985);
        this.hbW.hbV.avW();
        AppMethodBeat.o(199985);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(199986);
        this.hbW.hbV.avW();
        AppMethodBeat.o(199986);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.r.b;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "dataObserver", "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1;", "horizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "getHorizontalHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "setHorizontalHelper", "(Landroidx/recyclerview/widget/OrientationHelper;)V", "isDragging", "", "()Z", "setDragging", "(Z)V", "onPageSelectedListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;)V", "onPageSettledListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "getOnPageSettledListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "setOnPageSettledListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;)V", "onPageStartChangeListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "getOnPageStartChangeListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "setOnPageStartChangeListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scrollListener", "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1;", "<set-?>", "", "snapPosition", "getSnapPosition", "()I", "verticalHelper", "getVerticalHelper", "setVerticalHelper", "attachToRecyclerView", "", "checkSettle", "createScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findCenterView", "Landroid/view/View;", "helper", "findSnapView", "findTargetSnapPosition", "velocityX", "velocityY", "Companion", "OnPageSelectedListener", "OnPageSettledListener", "OnPageStartChangeListener", "plugin-emojisdk_release"})
public final class a
  extends v
{
  public static final a jNe;
  private RecyclerView jLl;
  private u jMV;
  private u jMW;
  public boolean jMX;
  private final g jMY;
  private final f jMZ;
  public int jNa;
  public b jNb;
  public c jNc;
  public d jNd;
  
  static
  {
    AppMethodBeat.i(224170);
    jNe = new a((byte)0);
    AppMethodBeat.o(224170);
  }
  
  public a()
  {
    AppMethodBeat.i(224168);
    this.jMY = new g(this);
    this.jMZ = new f(this);
    this.jNa = -1;
    AppMethodBeat.o(224168);
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224147);
    kotlin.g.b.p.k(paramLayoutManager, "layoutManager");
    int n = paramLayoutManager.getItemCount();
    if (n == 0)
    {
      AppMethodBeat.o(224147);
      return -1;
    }
    Object localObject1;
    Object localObject2;
    int i1;
    Object localObject3;
    if (paramLayoutManager.canScrollVertically())
    {
      if (this.jMV != null)
      {
        localObject1 = this.jMV;
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        if (((u)localObject1).getLayoutManager() == paramLayoutManager) {}
      }
      else
      {
        this.jMV = u.e(paramLayoutManager);
      }
      localObject1 = this.jMV;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.p.iCn();
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
        AppMethodBeat.o(224147);
        return -1;
        if (this.jMW != null)
        {
          localObject1 = this.jMW;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          if (((u)localObject1).getLayoutManager() == paramLayoutManager) {}
        }
        else
        {
          this.jMW = u.d(paramLayoutManager);
        }
        localObject1 = this.jMW;
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        kotlin.g.b.p.iCn();
        localObject2 = localObject1;
        break;
        localObject1 = null;
        if (paramLayoutManager.getClipToPadding())
        {
          j = localObject2.kT() + localObject2.kV() / 2;
          i = 2147483647;
          k = 0;
          label217:
          localObject3 = localObject1;
          if (k >= i1) {
            continue;
          }
          localObject3 = paramLayoutManager.getChildAt(k);
          int m = Math.abs(localObject2.aZ((View)localObject3) + localObject2.bd((View)localObject3) / 2 - j);
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
      if (localObject2.aZ((View)localObject3) < localObject2.kT())
      {
        i = k + 1;
        j = k;
      }
      while (k == -1)
      {
        AppMethodBeat.o(224147);
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
            paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).cB(n - 1);
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
        if (paramInt1 != this.jNa)
        {
          this.jNa = paramInt1;
          paramLayoutManager = this.jNb;
          if (paramLayoutManager != null) {
            paramLayoutManager.onPageSelected(this.jNa);
          }
        }
        paramInt1 = this.jNa;
        AppMethodBeat.o(224147);
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
    AppMethodBeat.i(224155);
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
    for (int i = paramLayoutManager.lS();; i = -1)
    {
      if (this.jNa != i)
      {
        this.jNa = i;
        paramLayoutManager = this.jNb;
        if (paramLayoutManager != null) {
          paramLayoutManager.onPageSelected(this.jNa);
        }
      }
      AppMethodBeat.o(224155);
      return localView;
      paramLayoutManager = null;
      break;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(224124);
    super.a(paramRecyclerView);
    Object localObject = this.jLl;
    if (localObject != null) {
      ((RecyclerView)localObject).b((RecyclerView.l)this.jMY);
    }
    localObject = this.jLl;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).b((RecyclerView.c)this.jMZ);
      }
    }
    this.jLl = paramRecyclerView;
    paramRecyclerView = this.jLl;
    if (paramRecyclerView != null) {
      paramRecyclerView.a((RecyclerView.l)this.jMY);
    }
    paramRecyclerView = this.jLl;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView != null) {
        paramRecyclerView.a((RecyclerView.c)this.jMZ);
      }
    }
    aCV();
    AppMethodBeat.o(224124);
  }
  
  public final void aCV()
  {
    AppMethodBeat.i(224163);
    if (this.jNc == null)
    {
      AppMethodBeat.o(224163);
      return;
    }
    Object localObject = this.jLl;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getLayoutManager();
      if (localObject != null) {}
    }
    else
    {
      AppMethodBeat.o(224163);
      return;
    }
    kotlin.g.b.p.j(localObject, "recyclerView?.layoutManager ?: return");
    View localView = a((RecyclerView.LayoutManager)localObject);
    if (localView == null)
    {
      AppMethodBeat.o(224163);
      return;
    }
    localObject = a((RecyclerView.LayoutManager)localObject, localView);
    if (localObject == null)
    {
      AppMethodBeat.o(224163);
      return;
    }
    if ((localObject[0] == 0) || (localObject[1] == 0))
    {
      localObject = this.jNc;
      if (localObject != null)
      {
        ((c)localObject).rJ(this.jNa);
        AppMethodBeat.o(224163);
        return;
      }
    }
    AppMethodBeat.o(224163);
  }
  
  public final RecyclerView.r g(final RecyclerView.LayoutManager paramLayoutManager)
  {
    Context localContext = null;
    AppMethodBeat.i(224126);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(224126);
      return null;
    }
    RecyclerView localRecyclerView = this.jLl;
    if (localRecyclerView != null) {
      localContext = localRecyclerView.getContext();
    }
    paramLayoutManager = (RecyclerView.r)new e(this, paramLayoutManager, localContext);
    AppMethodBeat.o(224126);
    return paramLayoutManager;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void onPageSelected(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "", "onPageSettle", "", "position", "", "plugin-emojisdk_release"})
  public static abstract interface c
  {
    public abstract void rJ(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "", "onPageStartChange", "", "position", "", "plugin-emojisdk_release"})
  public static abstract interface d
  {
    public abstract void rK(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$createScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-emojisdk_release"})
  public static final class e
    extends androidx.recyclerview.widget.p
  {
    e(RecyclerView.LayoutManager paramLayoutManager, Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(226598);
      kotlin.g.b.p.k(paramDisplayMetrics, "displayMetrics");
      float f = 50.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(226598);
      return f;
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(226596);
      kotlin.g.b.p.k(paramView, "targetView");
      kotlin.g.b.p.k(params, "state");
      kotlin.g.b.p.k(parama, "action");
      if (a.a(this.jNf) != null)
      {
        paramView = this.jNf.a(paramLayoutManager, paramView);
        if (paramView == null) {
          kotlin.g.b.p.iCn();
        }
        int i = paramView[0];
        int j = paramView[1];
        int k = cE(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0)
        {
          parama.a(i, j, k, (Interpolator)this.aju);
          AppMethodBeat.o(226596);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.aju);
      }
      AppMethodBeat.o(226596);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "plugin-emojisdk_release"})
  public static final class f
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(223511);
      super.onChanged();
      if (this.jNf.jNa == -1)
      {
        RecyclerView localRecyclerView = a.a(this.jNf);
        if (localRecyclerView != null)
        {
          localRecyclerView.post((Runnable)new a(this));
          AppMethodBeat.o(223511);
          return;
        }
      }
      AppMethodBeat.o(223511);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(223512);
      super.onItemRangeInserted(paramInt1, paramInt2);
      if (this.jNf.jNa == -1)
      {
        RecyclerView localRecyclerView = a.a(this.jNf);
        if (localRecyclerView != null)
        {
          localRecyclerView.post((Runnable)new b(this));
          AppMethodBeat.o(223512);
          return;
        }
      }
      AppMethodBeat.o(223512);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(235487);
        this.jNg.jNf.aCV();
        AppMethodBeat.o(235487);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(a.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(239727);
        this.jNg.jNf.aCV();
        AppMethodBeat.o(239727);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"})
  public static final class g
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(230418);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      Log.i("MicroMsg.CenterPagerSnapHelper", "onScrollStateChanged:" + paramInt + ", snapPosition:" + this.jNf.jNa);
      if (paramInt == 0)
      {
        this.jNf.jMX = false;
        this.jNf.aCV();
      }
      if (paramInt == 1)
      {
        this.jNf.jMX = true;
        paramRecyclerView = this.jNf.jNd;
        if (paramRecyclerView != null) {
          paramRecyclerView.rK(this.jNf.jNa);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(230418);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(230422);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(230422);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.a
 * JD-Core Version:    0.7.0.1
 */
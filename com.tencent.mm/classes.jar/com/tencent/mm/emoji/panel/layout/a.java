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
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "dataObserver", "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1;", "horizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "getHorizontalHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "setHorizontalHelper", "(Landroidx/recyclerview/widget/OrientationHelper;)V", "isDragging", "", "()Z", "setDragging", "(Z)V", "milliSecondsPerInch", "", "getMilliSecondsPerInch", "()F", "setMilliSecondsPerInch", "(F)V", "onPageSelectedListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;)V", "onPageSettledListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "getOnPageSettledListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "setOnPageSettledListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;)V", "onPageStartChangeListener", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "getOnPageStartChangeListener", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "setOnPageStartChangeListener", "(Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "scrollListener", "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1;", "<set-?>", "", "snapPosition", "getSnapPosition", "()I", "verticalHelper", "getVerticalHelper", "setVerticalHelper", "attachToRecyclerView", "", "checkSettle", "createScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findCenterView", "Landroid/view/View;", "helper", "findSnapView", "findSnapViewInner", "findTargetSnapPosition", "velocityX", "velocityY", "interceptFindClosedChild", "child", "Companion", "OnPageSelectedListener", "OnPageSettledListener", "OnPageStartChangeListener", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends t
{
  public static final a.a mlT;
  protected RecyclerView mkw;
  private androidx.recyclerview.widget.s mlU;
  private androidx.recyclerview.widget.s mlV;
  public float mlW;
  public boolean mlX;
  private final g mlY;
  private final f mlZ;
  public int mma;
  public b mmb;
  public c mmc;
  public d mmd;
  
  static
  {
    AppMethodBeat.i(242403);
    mlT = new a.a((byte)0);
    AppMethodBeat.o(242403);
  }
  
  public a()
  {
    AppMethodBeat.i(242396);
    this.mlW = 50.0F;
    this.mlY = new g(this);
    this.mlZ = new f(this);
    this.mma = -1;
    AppMethodBeat.o(242396);
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int m = 1;
    AppMethodBeat.i(242429);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    int n = paramLayoutManager.getItemCount();
    if (n == 0)
    {
      AppMethodBeat.o(242429);
      return -1;
    }
    if (paramLayoutManager.canScrollVertically()) {}
    View localView;
    for (androidx.recyclerview.widget.s locals = b(paramLayoutManager);; locals = c(paramLayoutManager))
    {
      localView = a(paramLayoutManager, locals);
      if (localView != null) {
        break;
      }
      AppMethodBeat.o(242429);
      return -1;
    }
    int k = paramLayoutManager.getPosition(localView);
    int i;
    int j;
    if (locals.bs(localView) < locals.JE())
    {
      i = k + 1;
      j = k;
    }
    while (k == -1)
    {
      AppMethodBeat.o(242429);
      return -1;
      j = k - 1;
      i = k;
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      if (paramInt1 > 0)
      {
        paramInt1 = 1;
        if (!(paramLayoutManager instanceof RecyclerView.r.b)) {
          break label314;
        }
        paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).fM(n - 1);
        if (paramLayoutManager == null) {
          break label314;
        }
        paramInt2 = m;
        if (paramLayoutManager.x >= 0.0F)
        {
          if (paramLayoutManager.y >= 0.0F) {
            break label293;
          }
          paramInt2 = m;
        }
      }
    }
    for (;;)
    {
      label198:
      if (paramInt2 != 0)
      {
        if (paramInt1 != 0) {
          break label308;
        }
        paramInt1 = i;
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
        if (paramInt1 != this.mma)
        {
          this.mma = paramInt1;
          paramLayoutManager = this.mmb;
          if (paramLayoutManager != null) {
            paramLayoutManager.onPageSelected(this.mma);
          }
        }
        paramInt1 = this.mma;
        AppMethodBeat.o(242429);
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
        label293:
        paramInt2 = 0;
        break label198;
        if (paramInt1 != 0) {
          paramInt1 = i;
        } else {
          label308:
          paramInt1 = j;
        }
      }
      label314:
      paramInt2 = 0;
    }
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(242434);
    View localView = h(paramLayoutManager);
    if (localView == null)
    {
      paramLayoutManager = null;
      if (!(paramLayoutManager instanceof RecyclerView.LayoutParams)) {
        break label82;
      }
      paramLayoutManager = (RecyclerView.LayoutParams)paramLayoutManager;
      label29:
      if (paramLayoutManager != null) {
        break label87;
      }
    }
    label82:
    label87:
    for (int i = -1;; i = paramLayoutManager.bXh.KJ())
    {
      if (this.mma != i)
      {
        this.mma = i;
        paramLayoutManager = this.mmb;
        if (paramLayoutManager != null) {
          paramLayoutManager.onPageSelected(this.mma);
        }
      }
      AppMethodBeat.o(242434);
      return localView;
      paramLayoutManager = localView.getLayoutParams();
      break;
      paramLayoutManager = null;
      break label29;
    }
  }
  
  protected final View a(RecyclerView.LayoutManager paramLayoutManager, androidx.recyclerview.widget.s params)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(242447);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    kotlin.g.b.s.u(params, "helper");
    int i1 = paramLayoutManager.getChildCount();
    if (i1 == 0)
    {
      AppMethodBeat.o(242447);
      return null;
    }
    int i;
    int m;
    if (paramLayoutManager.getClipToPadding())
    {
      i = params.JE() + params.JG() / 2;
      m = 0;
      if (i1 <= 0) {}
    }
    int k;
    for (int j = 2147483647;; j = k)
    {
      int n = m + 1;
      localObject1 = paramLayoutManager.getChildAt(m);
      m = Math.abs(params.bs((View)localObject1) + params.bw((View)localObject1) / 2 - i);
      if (a((View)localObject1, paramLayoutManager, params)) {}
      do
      {
        AppMethodBeat.o(242447);
        return localObject1;
        i = params.getEnd() / 2;
        break;
        k = j;
        if (m < j)
        {
          k = m;
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
      } while (n >= i1);
      m = n;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(242412);
    super.a(paramRecyclerView);
    Object localObject = this.mkw;
    if (localObject != null) {
      ((RecyclerView)localObject).b((RecyclerView.l)this.mlY);
    }
    localObject = this.mkw;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).b((RecyclerView.c)this.mlZ);
      }
    }
    this.mkw = paramRecyclerView;
    paramRecyclerView = this.mkw;
    if (paramRecyclerView != null) {
      paramRecyclerView.a((RecyclerView.l)this.mlY);
    }
    paramRecyclerView = this.mkw;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView != null) {
        paramRecyclerView.a((RecyclerView.c)this.mlZ);
      }
    }
    aVV();
    AppMethodBeat.o(242412);
  }
  
  protected boolean a(View paramView, RecyclerView.LayoutManager paramLayoutManager, androidx.recyclerview.widget.s params)
  {
    AppMethodBeat.i(242456);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    kotlin.g.b.s.u(params, "helper");
    AppMethodBeat.o(242456);
    return false;
  }
  
  public final void aVV()
  {
    AppMethodBeat.i(242460);
    if (this.mmc == null)
    {
      AppMethodBeat.o(242460);
      return;
    }
    Object localObject = this.mkw;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((RecyclerView)localObject).getLayoutManager())
    {
      AppMethodBeat.o(242460);
      return;
    }
    View localView = a((RecyclerView.LayoutManager)localObject);
    if (localView == null)
    {
      AppMethodBeat.o(242460);
      return;
    }
    localObject = a((RecyclerView.LayoutManager)localObject, localView);
    if (localObject == null)
    {
      AppMethodBeat.o(242460);
      return;
    }
    if ((localObject[0] == 0) || (localObject[1] == 0))
    {
      localObject = this.mmc;
      if (localObject != null) {
        ((c)localObject).rL(this.mma);
      }
    }
    AppMethodBeat.o(242460);
  }
  
  protected final androidx.recyclerview.widget.s b(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(242468);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    if (this.mlU != null)
    {
      androidx.recyclerview.widget.s locals = this.mlU;
      kotlin.g.b.s.checkNotNull(locals);
      if (locals.getLayoutManager() == paramLayoutManager) {}
    }
    else
    {
      this.mlU = androidx.recyclerview.widget.s.e(paramLayoutManager);
    }
    paramLayoutManager = this.mlU;
    kotlin.g.b.s.checkNotNull(paramLayoutManager);
    AppMethodBeat.o(242468);
    return paramLayoutManager;
  }
  
  protected final androidx.recyclerview.widget.s c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(242472);
    kotlin.g.b.s.u(paramLayoutManager, "layoutManager");
    if (this.mlV != null)
    {
      androidx.recyclerview.widget.s locals = this.mlV;
      kotlin.g.b.s.checkNotNull(locals);
      if (locals.getLayoutManager() == paramLayoutManager) {}
    }
    else
    {
      this.mlV = androidx.recyclerview.widget.s.d(paramLayoutManager);
    }
    paramLayoutManager = this.mlV;
    kotlin.g.b.s.checkNotNull(paramLayoutManager);
    AppMethodBeat.o(242472);
    return paramLayoutManager;
  }
  
  public final RecyclerView.r g(final RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(242419);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(242419);
      return null;
    }
    Object localObject = this.mkw;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((RecyclerView)localObject).getContext())
    {
      paramLayoutManager = (RecyclerView.r)new e(this, paramLayoutManager, (Context)localObject);
      AppMethodBeat.o(242419);
      return paramLayoutManager;
    }
  }
  
  protected View h(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(242436);
    paramLayoutManager = super.a(paramLayoutManager);
    AppMethodBeat.o(242436);
    return paramLayoutManager;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void onPageSelected(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "", "onPageSettle", "", "position", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void rL(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "", "onPageStartChange", "", "position", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void rM(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$createScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends o
  {
    e(a parama, RecyclerView.LayoutManager paramLayoutManager, Context paramContext)
    {
      super();
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(242379);
      kotlin.g.b.s.u(paramView, "targetView");
      kotlin.g.b.s.u(params, "state");
      kotlin.g.b.s.u(parama, "action");
      if (this.mme.mkw != null)
      {
        paramView = this.mme.a(paramLayoutManager, paramView);
        kotlin.g.b.s.checkNotNull(paramView);
        int i = paramView[0];
        int j = paramView[1];
        int k = fO(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0)
        {
          parama.a(i, j, k, (Interpolator)this.bXY);
          AppMethodBeat.o(242379);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.bXY);
      }
      AppMethodBeat.o(242379);
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(242387);
      kotlin.g.b.s.u(paramDisplayMetrics, "displayMetrics");
      float f = this.mme.mlW / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(242387);
      return f;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$dataObserver$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RecyclerView.c
  {
    f(a parama) {}
    
    private static final void a(a parama)
    {
      AppMethodBeat.i(242372);
      kotlin.g.b.s.u(parama, "this$0");
      parama.aVV();
      AppMethodBeat.o(242372);
    }
    
    private static final void b(a parama)
    {
      AppMethodBeat.i(242377);
      kotlin.g.b.s.u(parama, "this$0");
      parama.aVV();
      AppMethodBeat.o(242377);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(242393);
      super.onChanged();
      if (this.mme.mma == -1)
      {
        RecyclerView localRecyclerView = this.mme.mkw;
        if (localRecyclerView != null) {
          localRecyclerView.post(new a.f..ExternalSyntheticLambda0(this.mme));
        }
      }
      AppMethodBeat.o(242393);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242398);
      super.onItemRangeInserted(paramInt1, paramInt2);
      if (this.mme.mma == -1)
      {
        RecyclerView localRecyclerView = this.mme.mkw;
        if (localRecyclerView != null) {
          localRecyclerView.post(new a.f..ExternalSyntheticLambda1(this.mme));
        }
      }
      AppMethodBeat.o(242398);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends RecyclerView.l
  {
    g(a parama) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(242381);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      Log.i("MicroMsg.CenterPagerSnapHelper", "onScrollStateChanged:" + paramInt + ", snapPosition:" + this.mme.mma);
      if (paramInt == 0)
      {
        this.mme.mlX = false;
        this.mme.aVV();
      }
      if (paramInt == 1)
      {
        this.mme.mlX = true;
        paramRecyclerView = this.mme.mmd;
        if (paramRecyclerView != null) {
          paramRecyclerView.rM(this.mme.mma);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(242381);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242388);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(242388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.a
 * JD-Core Version:    0.7.0.1
 */
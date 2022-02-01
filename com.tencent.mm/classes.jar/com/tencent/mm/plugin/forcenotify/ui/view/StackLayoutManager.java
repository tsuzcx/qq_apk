package com.tencent.mm.plugin.forcenotify.ui.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "visibleCount", "", "itemOffset", "baselinePercent", "", "isLimitScrollMode", "", "itemChangeListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "from", "to", "", "(IIFZLkotlin/jvm/functions/Function2;)V", "animatorList", "", "Lcom/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$LayoutAnimator;", "currPosition", "fixScrolling", "flingTargetOffset", "isDragging", "isFling", "onFlingListener", "Landroidx/recyclerview/widget/RecyclerView$OnFlingListener;", "onScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scrollOffset", "startDragOffset", "addLayoutAnimator", "animator", "calTargetOffset", "position", "calculateAndScrollToTarget", "view", "Landroidx/recyclerview/widget/RecyclerView;", "direction", "Lcom/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$Direction;", "canScrollVertically", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getCurrPosition", "layoutChild", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "fromScroll", "onAttachedToWindow", "onDetachedFromWindow", "onItemsAdded", "recyclerView", "positionStart", "itemCount", "onItemsMoved", "onItemsRemoved", "onLayoutChildren", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "realLayout", "Landroid/view/View;", "index", "removeLayoutAnimator", "resetViewAnimateProperty", "scrollProgress", "scrollToCenter", "targetPos", "isNeedAnimation", "fromFling", "scrollToPosition", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "validOffset", "offset", "Companion", "Direction", "LayoutAnimator", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StackLayoutManager
  extends RecyclerView.LayoutManager
{
  public static final StackLayoutManager.a Hpr;
  private boolean EKW;
  private final List<StackLayoutManager.c> HpA;
  private RecyclerView.j HpB;
  private final int Hpq;
  private final int Hps;
  private final float Hpt;
  private final boolean Hpu;
  private final m<Integer, Integer, ah> Hpv;
  private int Hpw;
  private boolean Hpx;
  private int Hpy;
  private int Hpz;
  private int afC;
  private RecyclerView.l lBe;
  private boolean mlX;
  
  static
  {
    AppMethodBeat.i(275120);
    Hpr = new StackLayoutManager.a((byte)0);
    AppMethodBeat.o(275120);
  }
  
  public StackLayoutManager(int paramInt, m<? super Integer, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(275017);
    this.Hpq = 2;
    this.Hps = paramInt;
    this.Hpt = 0.1F;
    this.Hpu = true;
    this.Hpv = paramm;
    this.Hpy = 2147483647;
    this.HpA = ((List)new ArrayList());
    a((StackLayoutManager.c)new a(this.Hpq));
    AppMethodBeat.o(275017);
  }
  
  private final int Wb(int paramInt)
  {
    AppMethodBeat.i(275083);
    paramInt = Math.max(Math.min(paramInt, getHeight() * (getItemCount() - 1)), 0);
    AppMethodBeat.o(275083);
    return paramInt;
  }
  
  private final void a(int paramInt, RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    AppMethodBeat.i(275068);
    paramInt = getHeight() * paramInt;
    int i = paramInt - this.afC;
    if ((paramBoolean) && (Math.abs(i) > 0)) {
      this.Hpz = paramInt;
    }
    for (;;)
    {
      paramRecyclerView.br(0, i);
      AppMethodBeat.o(275068);
      return;
      if (paramBoolean)
      {
        this.EKW = false;
        if (!this.mlX) {
          this.Hpy = 2147483647;
        }
      }
    }
  }
  
  private final void aw(View paramView, int paramInt)
  {
    AppMethodBeat.i(275076);
    if (paramView == null)
    {
      AppMethodBeat.o(275076);
      return;
    }
    int i = (getWidth() - getDecoratedMeasuredWidth(paramView)) / 2;
    if (paramInt == 0) {}
    for (paramInt = -this.afC % getHeight();; paramInt = (int)(this.Hps * (paramInt - fxa())))
    {
      layoutDecorated(paramView, i, paramInt, i + getDecoratedMeasuredWidth(paramView), paramInt + getDecoratedMeasuredHeight(paramView));
      AppMethodBeat.o(275076);
      return;
    }
  }
  
  private final void b(RecyclerView.n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(275057);
    if (paramn == null)
    {
      AppMethodBeat.o(275057);
      return;
    }
    int k = fxb();
    int i = Math.min(this.Hpq + k, getItemCount() - 1);
    int j;
    Object localObject;
    List localList;
    if (this.afC % getHeight() == 0)
    {
      j = 1;
      if ((paramBoolean) && (j != 0) && (k != this.Hpw))
      {
        localObject = this.Hpv;
        if (localObject != null) {
          ((m)localObject).invoke(Integer.valueOf(this.Hpw), Integer.valueOf(k));
        }
        this.Hpw = k;
      }
      localList = (List)new ArrayList();
      if (k <= i) {
        j = k;
      }
    }
    for (;;)
    {
      localObject = paramn.gb(j);
      s.s(localObject, "recycler.getViewForPosition(position)");
      localList.add(localObject);
      if (j == i)
      {
        if (k <= i) {
          j = i;
        }
        for (;;)
        {
          localObject = (View)localList.get(j - k);
          addView((View)localObject);
          measureChild((View)localObject, 0, 0);
          if (j == k)
          {
            if (k <= i) {
              j = i;
            }
            for (;;)
            {
              int m = j - k;
              View localView = (View)localList.get(m);
              if (m <= 0) {}
              for (localObject = null;; localObject = (View)localList.get(m - 1))
              {
                if (m < p.oE(localList)) {
                  localList.get(m + 1);
                }
                aw(localView, m);
                Iterator localIterator = ((Iterable)this.HpA).iterator();
                while (localIterator.hasNext()) {
                  ((StackLayoutManager.c)localIterator.next()).a(localView, j, k, fxa(), (View)localObject);
                }
                j = 0;
                break;
              }
              if (j == k)
              {
                if (k - 1 >= 0)
                {
                  localObject = paramn.gb(k - 1);
                  s.s(localObject, "recycler.getViewForPosition(currPos - 1)");
                  hs((View)localObject);
                  removeAndRecycleView((View)localObject, paramn);
                }
                if (i + 1 < getItemCount())
                {
                  localObject = paramn.gb(i + 1);
                  s.s(localObject, "recycler.getViewForPosition(lastVisiblePos + 1)");
                  hs((View)localObject);
                  removeAndRecycleView((View)localObject, paramn);
                }
                AppMethodBeat.o(275057);
                return;
              }
              j -= 1;
            }
          }
          j -= 1;
        }
      }
      j += 1;
    }
  }
  
  private final float fxa()
  {
    AppMethodBeat.i(275079);
    if ((getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(275079);
      return 0.0F;
    }
    float f = this.afC % getHeight() * 1.0F / getHeight();
    AppMethodBeat.o(275079);
    return f;
  }
  
  private final void hs(View paramView)
  {
    AppMethodBeat.i(275062);
    Iterator localIterator = ((Iterable)this.HpA).iterator();
    while (localIterator.hasNext()) {
      ((StackLayoutManager.c)localIterator.next()).hs(paramView);
    }
    AppMethodBeat.o(275062);
  }
  
  public final void a(StackLayoutManager.c paramc)
  {
    AppMethodBeat.i(275123);
    s.u(paramc, "animator");
    if (!this.HpA.contains(paramc)) {
      this.HpA.add(paramc);
    }
    AppMethodBeat.o(275123);
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(275136);
    if (getItemCount() != 0)
    {
      AppMethodBeat.o(275136);
      return true;
    }
    AppMethodBeat.o(275136);
    return false;
  }
  
  public final int fxb()
  {
    AppMethodBeat.i(275151);
    if ((getWidth() == 0) || (getHeight() == 0))
    {
      AppMethodBeat.o(275151);
      return 0;
    }
    int i = this.afC / getHeight();
    AppMethodBeat.o(275151);
    return i;
  }
  
  public final RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(275125);
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    AppMethodBeat.o(275125);
    return localLayoutParams;
  }
  
  public final void onAttachedToWindow(final RecyclerView paramRecyclerView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(275132);
    super.onAttachedToWindow(paramRecyclerView);
    this.HpB = ((RecyclerView.j)new d(this, paramRecyclerView));
    Object localObject1;
    if (paramRecyclerView != null)
    {
      RecyclerView.j localj = this.HpB;
      localObject1 = localj;
      if (localj == null)
      {
        s.bIx("onFlingListener");
        localObject1 = null;
      }
      paramRecyclerView.setOnFlingListener((RecyclerView.j)localObject1);
    }
    this.lBe = ((RecyclerView.l)new e(this, paramRecyclerView));
    if (paramRecyclerView != null)
    {
      localObject1 = this.lBe;
      if (localObject1 != null) {
        break label109;
      }
      s.bIx("onScrollListener");
      localObject1 = localObject2;
    }
    label109:
    for (;;)
    {
      paramRecyclerView.a((RecyclerView.l)localObject1);
      AppMethodBeat.o(275132);
      return;
    }
  }
  
  public final void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.n paramn)
  {
    Object localObject = null;
    AppMethodBeat.i(275134);
    super.onDetachedFromWindow(paramRecyclerView, paramn);
    if (paramRecyclerView == null)
    {
      paramn = null;
      RecyclerView.j localj2 = this.HpB;
      RecyclerView.j localj1 = localj2;
      if (localj2 == null)
      {
        s.bIx("onFlingListener");
        localj1 = null;
      }
      if (s.p(paramn, localj1)) {
        paramRecyclerView.setOnFlingListener(null);
      }
      if (paramRecyclerView != null)
      {
        paramn = this.lBe;
        if (paramn != null) {
          break label98;
        }
        s.bIx("onScrollListener");
        paramn = localObject;
      }
    }
    label98:
    for (;;)
    {
      paramRecyclerView.b(paramn);
      AppMethodBeat.o(275134);
      return;
      paramn = paramRecyclerView.getOnFlingListener();
      break;
    }
  }
  
  public final void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275143);
    s.u(paramRecyclerView, "recyclerView");
    Log.i("MsgWindow", "onItemsAdded positionStart = " + paramInt1 + ", itemCount = " + paramInt2);
    if (paramInt1 <= fxb()) {}
    for (;;)
    {
      this.afC += getHeight() * paramInt2;
      this.Hpw += paramInt2;
      if (this.mlX) {
        this.Hpy += getHeight() * paramInt2;
      }
      this.afC = Math.max(this.afC, 0);
      this.Hpw = Math.max(this.Hpw, 0);
      AppMethodBeat.o(275143);
      return;
      paramInt2 = 0;
    }
  }
  
  public final void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(275140);
    s.u(paramRecyclerView, "recyclerView");
    Log.i("MsgWindow", "onItemsMoved from = " + paramInt1 + ", to = " + paramInt2 + ", itemCount = " + paramInt3);
    if (paramInt3 != 1)
    {
      AppMethodBeat.o(275140);
      return;
    }
    paramInt3 = fxb();
    if (paramInt1 != paramInt3) {
      if (paramInt1 < paramInt3)
      {
        paramInt1 = 1;
        if (paramInt2 > paramInt3) {
          break label179;
        }
        paramInt2 = i;
        label102:
        paramInt1 = paramInt2 - paramInt1;
        this.afC += getHeight() * paramInt1;
        this.Hpw += paramInt1;
        if (this.mlX)
        {
          paramInt2 = this.Hpy;
          this.Hpy = (paramInt1 * getHeight() + paramInt2);
        }
      }
    }
    for (;;)
    {
      this.afC = Wb(this.afC);
      AppMethodBeat.o(275140);
      return;
      paramInt1 = 0;
      break;
      label179:
      paramInt2 = 0;
      break label102;
      this.afC = (this.afC % getHeight() + getHeight() * paramInt2);
      this.Hpw = paramInt2;
      if (this.mlX) {
        this.Hpy = (getHeight() * paramInt2);
      }
    }
  }
  
  public final void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275146);
    s.u(paramRecyclerView, "recyclerView");
    Log.i("MsgWindow", "onItemsRemoved positionStart = " + paramInt1 + ", itemCount = " + paramInt2);
    paramInt1 = Math.max(Math.min(paramInt1 + paramInt2 - 1, fxb() - 1) - paramInt1 + 1, 0);
    this.afC -= getHeight() * paramInt1;
    this.Hpw -= paramInt1;
    if (this.mlX) {
      this.Hpy -= paramInt1 * getHeight();
    }
    this.afC = Math.max(this.afC, 0);
    this.Hpw = Math.max(this.Hpw, 0);
    AppMethodBeat.o(275146);
  }
  
  public final void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(275128);
    super.onLayoutChildren(paramn, params);
    if (paramn == null)
    {
      AppMethodBeat.o(275128);
      return;
    }
    detachAndScrapAttachedViews(paramn);
    if (getItemCount() <= 0)
    {
      AppMethodBeat.o(275128);
      return;
    }
    this.afC = Wb(this.afC);
    b(paramn, false);
    AppMethodBeat.o(275128);
  }
  
  public final void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(275149);
    this.afC = (getHeight() * paramInt);
    this.Hpw = paramInt;
    requestLayout();
    AppMethodBeat.o(275149);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(275137);
    if (paramn == null)
    {
      AppMethodBeat.o(275137);
      return 0;
    }
    int i = this.afC + paramInt;
    if (i > this.Hpy)
    {
      params = b.HpC;
      if ((!this.Hpu) || ((!this.mlX) && (!this.EKW)) || (this.Hpy == 2147483647) || (Math.abs(i - this.Hpy) <= getHeight())) {
        break label212;
      }
      if (params != b.HpC) {
        break label179;
      }
      i = this.Hpy + getHeight();
    }
    label179:
    label212:
    for (;;)
    {
      this.afC = Wb(i);
      if ((this.EKW) && (this.afC == this.Hpz))
      {
        this.EKW = false;
        if (!this.mlX) {
          this.Hpy = 2147483647;
        }
      }
      paramInt = this.afC - i + paramInt;
      if (paramInt == 0)
      {
        AppMethodBeat.o(275137);
        return 0;
        params = b.HpD;
        break;
        i = this.Hpy - getHeight();
        continue;
      }
      detachAndScrapAttachedViews(paramn);
      b(paramn, true);
      AppMethodBeat.o(275137);
      return paramInt;
    }
  }
  
  public final void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(275148);
    if (paramRecyclerView != null) {
      a(paramInt, paramRecyclerView, false);
    }
    AppMethodBeat.o(275148);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$Direction;", "", "(Ljava/lang/String;I)V", "UP", "DOWN", "NONE", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(275028);
      HpC = new b("UP", 0);
      HpD = new b("DOWN", 1);
      HpE = new b("NONE", 2);
      HpF = new b[] { HpC, HpD, HpE };
      AppMethodBeat.o(275028);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$onAttachedToWindow$1", "Landroidx/recyclerview/widget/RecyclerView$OnFlingListener;", "onFling", "", "velocityX", "", "velocityY", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.j
  {
    d(StackLayoutManager paramStackLayoutManager, RecyclerView paramRecyclerView) {}
    
    public final boolean bC(int paramInt1, int paramInt2)
    {
      int i = 0;
      AppMethodBeat.i(275008);
      if (paramInt2 < 0) {}
      for (StackLayoutManager.b localb = StackLayoutManager.b.HpD;; localb = StackLayoutManager.b.HpC)
      {
        paramInt2 = this.HpG.getHeight();
        int j = this.HpG.getItemCount();
        int k = StackLayoutManager.a(this.HpG);
        paramInt1 = i;
        if (k > 0)
        {
          paramInt1 = i;
          if (k < paramInt2 * (j - 1)) {
            paramInt1 = 1;
          }
        }
        if (paramInt1 != 0) {
          StackLayoutManager.a(this.HpG, true);
        }
        StackLayoutManager.a(this.HpG, paramRecyclerView, localb);
        AppMethodBeat.o(275008);
        return true;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$onAttachedToWindow$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    e(StackLayoutManager paramStackLayoutManager, RecyclerView paramRecyclerView) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(275024);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$onAttachedToWindow$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      switch (paramInt)
      {
      default: 
        if (paramInt == 1) {
          if (!StackLayoutManager.c(this.HpG))
          {
            StackLayoutManager.b(this.HpG, true);
            StackLayoutManager.a(this.HpG, StackLayoutManager.b(this.HpG, StackLayoutManager.a(this.HpG) / this.HpG.getHeight()));
          }
        }
        break;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$onAttachedToWindow$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(275024);
        return;
        if (!StackLayoutManager.b(this.HpG))
        {
          StackLayoutManager.a(this.HpG, true);
          StackLayoutManager.a(this.HpG, paramRecyclerView, StackLayoutManager.b.HpE);
          break;
        }
        StackLayoutManager.a(this.HpG, false);
        break;
        StackLayoutManager.a(this.HpG, false);
        break;
        StackLayoutManager.b(this.HpG, false);
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(275030);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$onAttachedToWindow$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/forcenotify/ui/view/StackLayoutManager$onAttachedToWindow$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(275030);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.view.StackLayoutManager
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.nearby.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.g.n;
import androidx.core.g.r;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/base/view/RefreshLoadMoreNestedScrollingChild2Layout;", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "Landroidx/core/view/NestedScrollingChild2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isDebug", "", "nestedScrollingChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "parentOffsetInWindow", "", "parentScrollConsumed", "canScrollVertically", "direction", "dispatchNestedPreScroll", "dx", "dy", "consumed", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "getNestedScrollAxes", "hasNestedScrollingParent", "isNestedScrollingEnabled", "log", "", "msg", "", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "onNestedPreFling", "onNestedPreScroll", "onNestedScroll", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "setNestedScrollingEnabled", "enabled", "startNestedScroll", "stopNestedScroll", "plugin-finder-nearby-api_release"})
public final class RefreshLoadMoreNestedScrollingChild2Layout
  extends RefreshLoadMoreLayout
  implements androidx.core.g.l
{
  private final boolean dal;
  private final int[] zDw;
  private final int[] zDx;
  private final r zDy;
  private final n zDz;
  
  public RefreshLoadMoreNestedScrollingChild2Layout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(189020);
    this.zDw = new int[2];
    this.zDx = new int[2];
    this.zDy = new r();
    this.zDz = new n((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(189020);
  }
  
  public RefreshLoadMoreNestedScrollingChild2Layout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(189023);
    this.zDw = new int[2];
    this.zDx = new int[2];
    this.zDy = new r();
    this.zDz = new n((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(189023);
  }
  
  private final void log(String paramString)
  {
    AppMethodBeat.i(189017);
    if (this.dal) {
      Log.i("RefreshLoadMoreNestedScrollingChild2Layout", paramString);
    }
    AppMethodBeat.o(189017);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(188999);
    p.k(paramView, "target");
    log("dispatchNestedScroll ret:".concat(String.valueOf(this.zDz.a(paramInt1, paramInt2, paramInt3, paramInt4, null, paramInt5))));
    super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(188999);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(188997);
    p.k(paramView, "target");
    p.k(paramArrayOfInt, "consumed");
    log("before onNestedPreScroll, dx:" + paramInt1 + " dy:" + paramInt2 + " consumed[0]:" + paramArrayOfInt[0] + " consumed[1]:" + paramArrayOfInt[1] + " type:" + paramInt3);
    boolean bool = this.zDz.a(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
    StringBuilder localStringBuilder = new StringBuilder("dispatchNestedPreScroll, ret:").append(bool).append(" dx:").append(paramInt1).append(" dy:").append(paramInt2).append(" consumed[0]:");
    if (paramArrayOfInt != null) {}
    for (Object localObject1 = Integer.valueOf(paramArrayOfInt[0]);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(" consumed[1]:");
      localObject1 = localObject2;
      if (paramArrayOfInt != null) {
        localObject1 = Integer.valueOf(paramArrayOfInt[1]);
      }
      log(localObject1 + " type:" + paramInt3);
      localObject1 = this.zDw;
      localObject1[0] = 0;
      localObject1[1] = 0;
      super.a(paramView, paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], (int[])localObject1, paramInt3);
      paramArrayOfInt[0] += localObject1[0];
      paramArrayOfInt[1] += localObject1[1];
      log("after onNestedPreScroll, dx:" + paramInt1 + " dy:" + paramInt2 + " consumed[0]:" + paramArrayOfInt[0] + " consumed[1]:" + paramArrayOfInt[1] + " type:" + paramInt3);
      AppMethodBeat.o(188997);
      return;
    }
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188992);
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    AppMethodBeat.o(188992);
    return true;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188995);
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    this.zDy.F(paramInt1, paramInt2);
    log("startNestedScroll ret:".concat(String.valueOf(this.zDz.E(paramInt1, paramInt2))));
    super.b(paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(188995);
  }
  
  public final void bw(int paramInt)
  {
    AppMethodBeat.i(189016);
    log("stopNestedScroll");
    this.zDz.bw(paramInt);
    AppMethodBeat.o(189016);
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(188989);
    boolean bool = getRecyclerView().canScrollVertically(paramInt);
    AppMethodBeat.o(188989);
    return bool;
  }
  
  public final int getNestedScrollAxes()
  {
    AppMethodBeat.i(189009);
    this.zDy.getNestedScrollAxes();
    int i = super.getNestedScrollAxes();
    AppMethodBeat.o(189009);
    return i;
  }
  
  public final boolean isNestedScrollingEnabled()
  {
    AppMethodBeat.i(189014);
    boolean bool = this.zDz.isNestedScrollingEnabled();
    AppMethodBeat.o(189014);
    return bool;
  }
  
  public final void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(189004);
    p.k(paramView, "target");
    this.zDy.bz(paramInt);
    super.l(paramView, paramInt);
    bw(paramInt);
    AppMethodBeat.o(189004);
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(189006);
    p.k(paramView, "target");
    paramBoolean = this.zDz.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(189006);
    return paramBoolean;
  }
  
  public final boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(189002);
    p.k(paramView, "target");
    boolean bool = this.zDz.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(189002);
    return bool;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(189013);
    this.zDz.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(189013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.view.RefreshLoadMoreNestedScrollingChild2Layout
 * JD-Core Version:    0.7.0.1
 */
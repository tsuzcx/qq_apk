package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.support.v4.view.k;
import android.support.v4.view.o;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/RefreshLoadMoreNestedScrollingChild2Layout;", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "Landroid/support/v4/view/NestedScrollingChild2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isDebug", "", "nestedScrollingChildHelper", "Landroid/support/v4/view/NestedScrollingChildHelper;", "nestedScrollingParentHelper", "Landroid/support/v4/view/NestedScrollingParentHelper;", "parentOffsetInWindow", "", "parentScrollConsumed", "canScrollVertically", "direction", "dispatchNestedPreScroll", "dx", "dy", "consumed", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "getNestedScrollAxes", "hasNestedScrollingParent", "isNestedScrollingEnabled", "log", "", "msg", "", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "onNestedPreFling", "onNestedPreScroll", "onNestedScroll", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "setNestedScrollingEnabled", "enabled", "startNestedScroll", "stopNestedScroll", "plugin-finder_release"})
public final class RefreshLoadMoreNestedScrollingChild2Layout
  extends RefreshLoadMoreLayout
  implements k
{
  private final boolean cWq;
  private final int[] wqE;
  private final int[] wqF;
  private final android.support.v4.view.l wqG;
  private final o wqs;
  
  public RefreshLoadMoreNestedScrollingChild2Layout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(255087);
    this.wqE = new int[2];
    this.wqF = new int[2];
    this.wqs = new o((ViewGroup)this);
    this.wqG = new android.support.v4.view.l((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(255087);
  }
  
  public RefreshLoadMoreNestedScrollingChild2Layout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255088);
    this.wqE = new int[2];
    this.wqF = new int[2];
    this.wqs = new o((ViewGroup)this);
    this.wqG = new android.support.v4.view.l((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(255088);
  }
  
  private final void log(String paramString)
  {
    AppMethodBeat.i(255086);
    if (this.cWq) {
      Log.i("RefreshLoadMoreNestedScrollingChild2Layout", paramString);
    }
    AppMethodBeat.o(255086);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(255078);
    p.h(paramView, "target");
    log("dispatchNestedScroll ret:".concat(String.valueOf(this.wqG.a(paramInt1, paramInt2, paramInt3, paramInt4, null, paramInt5))));
    super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(255078);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(255077);
    p.h(paramView, "target");
    p.h(paramArrayOfInt, "consumed");
    log("before onNestedPreScroll, dx:" + paramInt1 + " dy:" + paramInt2 + " consumed[0]:" + paramArrayOfInt[0] + " consumed[1]:" + paramArrayOfInt[1] + " type:" + paramInt3);
    boolean bool = this.wqG.a(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
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
      localObject1 = this.wqE;
      localObject1[0] = 0;
      localObject1[1] = 0;
      super.a(paramView, paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], (int[])localObject1, paramInt3);
      paramArrayOfInt[0] += localObject1[0];
      paramArrayOfInt[1] += localObject1[1];
      log("after onNestedPreScroll, dx:" + paramInt1 + " dy:" + paramInt2 + " consumed[0]:" + paramArrayOfInt[0] + " consumed[1]:" + paramArrayOfInt[1] + " type:" + paramInt3);
      AppMethodBeat.o(255077);
      return;
    }
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255075);
    p.h(paramView1, "child");
    p.h(paramView2, "target");
    AppMethodBeat.o(255075);
    return true;
  }
  
  public final void aM(int paramInt)
  {
    AppMethodBeat.i(255085);
    log("stopNestedScroll");
    this.wqG.aM(paramInt);
    AppMethodBeat.o(255085);
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255076);
    p.h(paramView1, "child");
    p.h(paramView2, "target");
    this.wqs.aP(paramInt1);
    log("startNestedScroll ret:".concat(String.valueOf(this.wqG.A(paramInt1, paramInt2))));
    super.b(paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(255076);
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(255074);
    boolean bool = getRecyclerView().canScrollVertically(paramInt);
    AppMethodBeat.o(255074);
    return bool;
  }
  
  public final int getNestedScrollAxes()
  {
    AppMethodBeat.i(255082);
    int i = super.getNestedScrollAxes();
    AppMethodBeat.o(255082);
    return i;
  }
  
  public final boolean isNestedScrollingEnabled()
  {
    AppMethodBeat.i(255084);
    boolean bool = this.wqG.isNestedScrollingEnabled();
    AppMethodBeat.o(255084);
    return bool;
  }
  
  public final void k(View paramView, int paramInt)
  {
    AppMethodBeat.i(255080);
    p.h(paramView, "target");
    this.wqs.fC();
    super.k(paramView, paramInt);
    aM(paramInt);
    AppMethodBeat.o(255080);
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(255081);
    p.h(paramView, "target");
    paramBoolean = this.wqG.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(255081);
    return paramBoolean;
  }
  
  public final boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(255079);
    p.h(paramView, "target");
    boolean bool = this.wqG.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(255079);
    return bool;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(255083);
    this.wqG.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(255083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.RefreshLoadMoreNestedScrollingChild2Layout
 * JD-Core Version:    0.7.0.1
 */
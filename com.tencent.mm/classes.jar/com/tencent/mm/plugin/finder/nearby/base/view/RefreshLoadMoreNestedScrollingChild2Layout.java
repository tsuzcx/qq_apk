package com.tencent.mm.plugin.finder.nearby.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.g.l;
import androidx.core.g.n;
import androidx.core.g.r;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/base/view/RefreshLoadMoreNestedScrollingChild2Layout;", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "Landroidx/core/view/NestedScrollingChild2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isDebug", "", "nestedScrollingChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "parentOffsetInWindow", "", "parentScrollConsumed", "canScrollVertically", "direction", "dispatchNestedPreScroll", "dx", "dy", "consumed", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "getNestedScrollAxes", "hasNestedScrollingParent", "isNestedScrollingEnabled", "log", "", "msg", "", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "onNestedPreFling", "onNestedPreScroll", "onNestedScroll", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "setNestedScrollingEnabled", "enabled", "startNestedScroll", "stopNestedScroll", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RefreshLoadMoreNestedScrollingChild2Layout
  extends RefreshLoadMoreLayout
  implements l
{
  private final int[] EHD;
  private final int[] EHE;
  private final r EHF;
  private final n EHG;
  private final boolean eYL;
  
  public RefreshLoadMoreNestedScrollingChild2Layout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(339697);
    this.EHD = new int[2];
    this.EHE = new int[2];
    this.EHF = new r();
    this.EHG = new n((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(339697);
  }
  
  public RefreshLoadMoreNestedScrollingChild2Layout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(339704);
    this.EHD = new int[2];
    this.EHE = new int[2];
    this.EHF = new r();
    this.EHG = new n((View)this);
    setNestedScrollingEnabled(true);
    AppMethodBeat.o(339704);
  }
  
  private final void log(String paramString)
  {
    AppMethodBeat.i(339710);
    if (this.eYL) {
      Log.i("RefreshLoadMoreNestedScrollingChild2Layout", paramString);
    }
    AppMethodBeat.o(339710);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(339753);
    s.u(paramView, "target");
    log(s.X("dispatchNestedScroll ret:", Boolean.valueOf(this.EHG.a(paramInt1, paramInt2, paramInt3, paramInt4, null, paramInt5))));
    super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(339753);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(339745);
    s.u(paramView, "target");
    s.u(paramArrayOfInt, "consumed");
    log("before onNestedPreScroll, dx:" + paramInt1 + " dy:" + paramInt2 + " consumed[0]:" + paramArrayOfInt[0] + " consumed[1]:" + paramArrayOfInt[1] + " type:" + paramInt3);
    boolean bool = this.EHG.a(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
    StringBuilder localStringBuilder = new StringBuilder("dispatchNestedPreScroll, ret:").append(bool).append(" dx:").append(paramInt1).append(" dy:").append(paramInt2).append(" consumed[0]:");
    if (paramArrayOfInt == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" consumed[1]:");
      if (paramArrayOfInt != null) {
        break label338;
      }
    }
    label338:
    for (Object localObject1 = localObject2;; localObject1 = Integer.valueOf(paramArrayOfInt[1]))
    {
      log(localObject1 + " type:" + paramInt3);
      localObject1 = this.EHD;
      localObject1[0] = 0;
      localObject1[1] = 0;
      super.a(paramView, paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], (int[])localObject1, paramInt3);
      paramArrayOfInt[0] += localObject1[0];
      paramArrayOfInt[1] += localObject1[1];
      log("after onNestedPreScroll, dx:" + paramInt1 + " dy:" + paramInt2 + " consumed[0]:" + paramArrayOfInt[0] + " consumed[1]:" + paramArrayOfInt[1] + " type:" + paramInt3);
      AppMethodBeat.o(339745);
      return;
      localObject1 = Integer.valueOf(paramArrayOfInt[0]);
      break;
    }
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(339725);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    AppMethodBeat.o(339725);
    return true;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(339735);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    this.EHF.aA(paramInt1, paramInt2);
    log(s.X("startNestedScroll ret:", Boolean.valueOf(this.EHG.az(paramInt1, paramInt2))));
    super.b(paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(339735);
  }
  
  public final boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(339717);
    boolean bool = getRecyclerView().canScrollVertically(paramInt);
    AppMethodBeat.o(339717);
    return bool;
  }
  
  public final void em(int paramInt)
  {
    AppMethodBeat.i(339802);
    log("stopNestedScroll");
    this.EHG.em(paramInt);
    AppMethodBeat.o(339802);
  }
  
  public final int getNestedScrollAxes()
  {
    AppMethodBeat.i(339782);
    this.EHF.getNestedScrollAxes();
    int i = super.getNestedScrollAxes();
    AppMethodBeat.o(339782);
    return i;
  }
  
  public final boolean isNestedScrollingEnabled()
  {
    return this.EHG.bts;
  }
  
  public final void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(339771);
    s.u(paramView, "target");
    this.EHF.eq(paramInt);
    super.l(paramView, paramInt);
    em(paramInt);
    AppMethodBeat.o(339771);
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(339775);
    s.u(paramView, "target");
    paramBoolean = this.EHG.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(339775);
    return paramBoolean;
  }
  
  public final boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(339762);
    s.u(paramView, "target");
    boolean bool = this.EHG.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(339762);
    return bool;
  }
  
  public final void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(339790);
    this.EHG.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(339790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.view.RefreshLoadMoreNestedScrollingChild2Layout
 * JD-Core Version:    0.7.0.1
 */
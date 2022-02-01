package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/LiveFriendsNestedScrollingParent2Layout;", "Landroid/widget/LinearLayout;", "Landroid/support/v4/view/NestedScrollingParent2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clLayout", "Landroid/view/View;", "headLayout", "headLayoutHeight", "isDebug", "", "nestedScrollingParentHelper", "Landroid/support/v4/view/NestedScrollingParentHelper;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getNestedScrollAxes", "log", "", "msg", "", "onFinishInflate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "target", "velocityX", "", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onSizeChanged", "w", "h", "oldw", "oldh", "onStartNestedScroll", "onStopNestedScroll", "Companion", "plugin-finder_release"})
public final class LiveFriendsNestedScrollingParent2Layout
  extends LinearLayout
  implements n
{
  public static final a wqw;
  private final boolean cWq;
  private RefreshLoadMoreLayout tLS;
  private final o wqs;
  private View wqt;
  private View wqu;
  private int wqv;
  
  static
  {
    AppMethodBeat.i(255060);
    wqw = new a((byte)0);
    AppMethodBeat.o(255060);
  }
  
  public LiveFriendsNestedScrollingParent2Layout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(255058);
    setOrientation(1);
    Log.i("LiveFriendsNestedScrollingParent2Layout", "init, orientation:" + getOrientation());
    this.wqs = new o((ViewGroup)this);
    AppMethodBeat.o(255058);
  }
  
  public LiveFriendsNestedScrollingParent2Layout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255059);
    setOrientation(1);
    Log.i("LiveFriendsNestedScrollingParent2Layout", "init, orientation:" + getOrientation());
    this.wqs = new o((ViewGroup)this);
    AppMethodBeat.o(255059);
  }
  
  private final void log(String paramString)
  {
    AppMethodBeat.i(255057);
    if (this.cWq) {
      Log.i("LiveFriendsNestedScrollingParent2Layout", paramString);
    }
    AppMethodBeat.o(255057);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(255049);
    p.h(paramView, "target");
    log("onNestedScroll dyUnconsumed:".concat(String.valueOf(paramInt4)));
    if (paramInt4 < 0)
    {
      paramInt1 = paramInt4;
      if (getScrollY() + paramInt4 < 0) {
        paramInt1 = -getScrollY();
      }
      scrollBy(0, paramInt1);
    }
    AppMethodBeat.o(255049);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(255048);
    p.h(paramView, "target");
    p.h(paramArrayOfInt, "consumed");
    log("before onNestedPreScroll, headLayoutHeight:" + this.wqv + " dx:" + paramInt1 + " dy:" + paramInt2 + " consumed[0]:" + paramArrayOfInt[0] + " consumed[1]:" + paramArrayOfInt[1] + " type:" + paramInt3);
    boolean bool1;
    if ((paramInt2 > 0) && (getScrollY() < this.wqv))
    {
      bool1 = true;
      if ((paramInt2 >= 0) || (getScrollY() < 0) || (paramView.canScrollVertically(-1))) {
        break label332;
      }
    }
    label332:
    for (boolean bool2 = true;; bool2 = false)
    {
      int i;
      if (!bool1)
      {
        i = paramInt2;
        if (!bool2) {}
      }
      else
      {
        paramArrayOfInt[1] = paramInt2;
        i = paramInt2;
        if (getScrollY() + paramInt2 > this.wqv)
        {
          i = this.wqv - getScrollY();
          paramArrayOfInt[1] = (this.wqv - getScrollY());
        }
        paramInt2 = i;
        if (getScrollY() + i < 0)
        {
          paramInt2 = -getScrollY();
          paramArrayOfInt[1] = 0;
        }
        scrollBy(0, paramInt2);
        i = paramInt2;
      }
      log("after onNestedPreScroll, headLayoutHeight:" + this.wqv + " hideTop:" + bool1 + " showTop:" + bool2 + "  dx:" + paramInt1 + " dy:" + i + " consumed[0]:" + paramArrayOfInt[0] + " consumed[1]:" + paramArrayOfInt[1] + " type:" + paramInt3);
      AppMethodBeat.o(255048);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255046);
    p.h(paramView1, "child");
    p.h(paramView2, "target");
    log("onStartNestedScroll");
    if ((paramInt1 & 0x2) != 0)
    {
      AppMethodBeat.o(255046);
      return true;
    }
    AppMethodBeat.o(255046);
    return false;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255047);
    p.h(paramView1, "child");
    p.h(paramView2, "target");
    log("onNestedScrollAccepted");
    this.wqs.aP(paramInt1);
    AppMethodBeat.o(255047);
  }
  
  public final int getNestedScrollAxes()
  {
    AppMethodBeat.i(255053);
    int i = this.wqs.getNestedScrollAxes();
    AppMethodBeat.o(255053);
    return i;
  }
  
  public final void k(View paramView, int paramInt)
  {
    AppMethodBeat.i(255051);
    p.h(paramView, "target");
    this.wqs.fC();
    AppMethodBeat.o(255051);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(255056);
    super.onFinishInflate();
    this.wqu = findViewById(2131298733);
    this.tLS = ((RefreshLoadMoreLayout)findViewById(2131307118));
    AppMethodBeat.o(255056);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255054);
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = this.wqu;
    int j;
    View localView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getLayoutParams();
      if (localObject != null)
      {
        j = getMeasuredHeight();
        localView = this.wqt;
        if (localView == null) {
          break label102;
        }
      }
    }
    label102:
    for (int i = localView.getMeasuredHeight();; i = 0)
    {
      ((ViewGroup.LayoutParams)localObject).height = (i + j);
      localView = this.wqu;
      if (localView != null) {
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(255054);
      return;
      localObject = null;
      break;
    }
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(255052);
    p.h(paramView, "target");
    log("onNestedFling, velocityX:" + paramFloat1 + " velocityY:" + paramFloat2 + " consumed:" + paramBoolean);
    AppMethodBeat.o(255052);
    return false;
  }
  
  public final boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(255050);
    p.h(paramView, "target");
    log("onNestedPreFling, velocityX:" + paramFloat1 + " velocityY:" + paramFloat2);
    AppMethodBeat.o(255050);
    return false;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(255055);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.wqt;
    if (localObject != null) {}
    for (paramInt1 = ((View)localObject).getMeasuredHeight();; paramInt1 = 0)
    {
      this.wqv = paramInt1;
      localObject = this.tLS;
      if (localObject == null) {
        break;
      }
      ((RefreshLoadMoreLayout)localObject).setExtraOverScrollFooterDx(this.wqv);
      AppMethodBeat.o(255055);
      return;
    }
    AppMethodBeat.o(255055);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/LiveFriendsNestedScrollingParent2Layout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.LiveFriendsNestedScrollingParent2Layout
 * JD-Core Version:    0.7.0.1
 */
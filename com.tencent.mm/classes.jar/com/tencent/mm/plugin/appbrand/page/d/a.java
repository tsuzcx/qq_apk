package com.tencent.mm.plugin.appbrand.page.d;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.ui.ay;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/view/AppBrandWebViewFixedSizeWrapper;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "enableFixSize", "", "getEnableFixSize", "()Z", "setEnableFixSize", "(Z)V", "addView", "", "child", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "", "measureChild", "parentWidthMeasureSpec", "parentHeightMeasureSpec", "measureChildWithMargins", "widthUsed", "heightUsed", "onLayout", "changed", "left", "top", "right", "bottom", "setDescendantFocusability", "focusability", "setFocusable", "focusable", "setFocusableInTouchMode", "focusableInTouchMode", "Companion", "luggage-wxa-app_release"})
public final class a
  extends FrameLayout
{
  public static final a qyf;
  private boolean qye;
  
  static
  {
    AppMethodBeat.i(243436);
    qyf = new a((byte)0);
    AppMethodBeat.o(243436);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(243435);
    super.setDescendantFocusability(262144);
    AppMethodBeat.o(243435);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(243428);
    if (getChildCount() <= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramView = (Throwable)new IllegalStateException("can host only one child".toString());
      AppMethodBeat.o(243428);
      throw paramView;
    }
    super.addView(paramView);
    AppMethodBeat.o(243428);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(243429);
    if (getChildCount() <= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramView = (Throwable)new IllegalStateException("can host only one  child".toString());
      AppMethodBeat.o(243429);
      throw paramView;
    }
    super.addView(paramView, paramInt);
    AppMethodBeat.o(243429);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(243431);
    if (getChildCount() <= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramView = (Throwable)new IllegalStateException("can host only one child".toString());
      AppMethodBeat.o(243431);
      throw paramView;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(243431);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(243430);
    if (getChildCount() <= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramView = (Throwable)new IllegalStateException("can host only one child".toString());
      AppMethodBeat.o(243430);
      throw paramView;
    }
    super.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(243430);
  }
  
  public final boolean getEnableFixSize()
  {
    return this.qye;
  }
  
  protected final void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(243423);
    if (!this.qye)
    {
      super.measureChild(paramView, paramInt1, paramInt2);
      AppMethodBeat.o(243423);
      return;
    }
    if (paramView == null) {
      p.iCn();
    }
    Object localObject = paramView.getLayoutParams();
    paramInt1 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    localObject = ay.au(getContext());
    paramView.measure(paramInt1, ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), getPaddingTop() + getPaddingBottom(), ((Point)localObject).y));
    AppMethodBeat.o(243423);
  }
  
  protected final void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(243425);
    if (!this.qye)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(243425);
      return;
    }
    if (paramView == null) {
      p.iCn();
    }
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(243425);
      throw paramView;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    paramInt1 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2, ((ViewGroup.MarginLayoutParams)localObject).width);
    paramInt2 = getPaddingTop();
    paramInt3 = getPaddingBottom();
    int i = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
    int j = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    localObject = ay.au(getContext());
    paramView.measure(paramInt1, ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), j + (paramInt2 + paramInt3 + i) + paramInt4, ((Point)localObject).y));
    AppMethodBeat.o(243425);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(243426);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.qye)
    {
      AppMethodBeat.o(243426);
      return;
    }
    if ((getChildAt(0) instanceof bd))
    {
      Object localObject = getChildAt(0);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.page.IAppBrandWebView");
        AppMethodBeat.o(243426);
        throw ((Throwable)localObject);
      }
      ((bd)localObject).cl(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    AppMethodBeat.o(243426);
  }
  
  public final void setDescendantFocusability(int paramInt)
  {
    AppMethodBeat.i(243432);
    if ((getChildAt(0) instanceof ViewGroup))
    {
      Object localObject = getChildAt(0);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(243432);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localObject).setDescendantFocusability(paramInt);
    }
    AppMethodBeat.o(243432);
  }
  
  public final void setEnableFixSize(boolean paramBoolean)
  {
    this.qye = paramBoolean;
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(243434);
    if ((getChildAt(0) instanceof ViewGroup))
    {
      Object localObject = getChildAt(0);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(243434);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localObject).setFocusable(paramBoolean);
    }
    AppMethodBeat.o(243434);
  }
  
  public final void setFocusableInTouchMode(boolean paramBoolean)
  {
    AppMethodBeat.i(243433);
    if ((getChildAt(0) instanceof ViewGroup))
    {
      Object localObject = getChildAt(0);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(243433);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localObject).setFocusableInTouchMode(paramBoolean);
    }
    AppMethodBeat.o(243433);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/view/AppBrandWebViewFixedSizeWrapper$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.a
 * JD-Core Version:    0.7.0.1
 */
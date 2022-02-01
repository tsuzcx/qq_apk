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
import com.tencent.mm.ui.bg;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/view/AppBrandWebViewFixedSizeWrapper;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "enableFixSize", "", "getEnableFixSize", "()Z", "setEnableFixSize", "(Z)V", "addView", "", "child", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "", "measureChild", "parentWidthMeasureSpec", "parentHeightMeasureSpec", "measureChildWithMargins", "widthUsed", "heightUsed", "onLayout", "changed", "left", "top", "right", "bottom", "setDescendantFocusability", "focusability", "setFocusable", "focusable", "setFocusableInTouchMode", "focusableInTouchMode", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends FrameLayout
{
  public static final a.a tDe;
  private boolean tDf;
  
  static
  {
    AppMethodBeat.i(325130);
    tDe = new a.a((byte)0);
    AppMethodBeat.o(325130);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(325128);
    super.setDescendantFocusability(262144);
    AppMethodBeat.o(325128);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(325149);
    if (getChildCount() <= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramView = (Throwable)new IllegalStateException("can host only one child".toString());
      AppMethodBeat.o(325149);
      throw paramView;
    }
    super.addView(paramView);
    AppMethodBeat.o(325149);
  }
  
  public final void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(325154);
    if (getChildCount() <= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramView = (Throwable)new IllegalStateException("can host only one  child".toString());
      AppMethodBeat.o(325154);
      throw paramView;
    }
    super.addView(paramView, paramInt);
    AppMethodBeat.o(325154);
  }
  
  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(325160);
    if (getChildCount() <= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramView = (Throwable)new IllegalStateException("can host only one child".toString());
      AppMethodBeat.o(325160);
      throw paramView;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(325160);
  }
  
  public final void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(325158);
    if (getChildCount() <= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramView = (Throwable)new IllegalStateException("can host only one child".toString());
      AppMethodBeat.o(325158);
      throw paramView;
    }
    super.addView(paramView, paramLayoutParams);
    AppMethodBeat.o(325158);
  }
  
  public final boolean getEnableFixSize()
  {
    return this.tDf;
  }
  
  protected final void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(325140);
    if (!this.tDf)
    {
      super.measureChild(paramView, paramInt1, paramInt2);
      AppMethodBeat.o(325140);
      return;
    }
    s.checkNotNull(paramView);
    Object localObject = paramView.getLayoutParams();
    paramInt1 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    localObject = bg.bf(getContext());
    paramView.measure(paramInt1, ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), getPaddingTop() + getPaddingBottom(), ((Point)localObject).y));
    AppMethodBeat.o(325140);
  }
  
  protected final void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(325143);
    if (!this.tDf)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(325143);
      return;
    }
    s.checkNotNull(paramView);
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(325143);
      throw paramView;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    paramInt1 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2, ((ViewGroup.MarginLayoutParams)localObject).width);
    paramInt2 = getPaddingTop();
    paramInt3 = getPaddingBottom();
    int i = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
    int j = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    localObject = bg.bf(getContext());
    paramView.measure(paramInt1, ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), j + (paramInt2 + paramInt3 + i) + paramInt4, ((Point)localObject).y));
    AppMethodBeat.o(325143);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(325146);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.tDf)
    {
      AppMethodBeat.o(325146);
      return;
    }
    if ((getChildAt(0) instanceof bd))
    {
      Object localObject = getChildAt(0);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.page.IAppBrandWebView");
        AppMethodBeat.o(325146);
        throw ((Throwable)localObject);
      }
      ((bd)localObject).cZ(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
    AppMethodBeat.o(325146);
  }
  
  public final void setDescendantFocusability(int paramInt)
  {
    AppMethodBeat.i(325162);
    if ((getChildAt(0) instanceof ViewGroup))
    {
      Object localObject = getChildAt(0);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(325162);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localObject).setDescendantFocusability(paramInt);
    }
    AppMethodBeat.o(325162);
  }
  
  public final void setEnableFixSize(boolean paramBoolean)
  {
    this.tDf = paramBoolean;
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(325167);
    if ((getChildAt(0) instanceof ViewGroup))
    {
      Object localObject = getChildAt(0);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(325167);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localObject).setFocusable(paramBoolean);
    }
    AppMethodBeat.o(325167);
  }
  
  public final void setFocusableInTouchMode(boolean paramBoolean)
  {
    AppMethodBeat.i(325165);
    if ((getChildAt(0) instanceof ViewGroup))
    {
      Object localObject = getChildAt(0);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(325165);
        throw ((Throwable)localObject);
      }
      ((ViewGroup)localObject).setFocusableInTouchMode(paramBoolean);
    }
    AppMethodBeat.o(325165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.a
 * JD-Core Version:    0.7.0.1
 */
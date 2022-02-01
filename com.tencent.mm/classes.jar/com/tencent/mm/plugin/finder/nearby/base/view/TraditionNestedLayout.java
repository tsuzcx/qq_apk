package com.tencent.mm.plugin.finder.nearby.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/base/view/TraditionNestedLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "headLayout", "Landroid/view/View;", "headLayoutHeight", "isHeadHide", "", "lastY", "rlLayout", "onFinishInflate", "", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "scrollTo", "x", "y", "Companion", "plugin-finder-nearby-api_release"})
public final class TraditionNestedLayout
  extends LinearLayout
{
  public static final a zDF;
  private View zDA;
  private View zDB;
  private int zDC;
  private boolean zDD;
  private int zDE;
  
  static
  {
    AppMethodBeat.i(189084);
    zDF = new a((byte)0);
    AppMethodBeat.o(189084);
  }
  
  public TraditionNestedLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(189070);
    AppMethodBeat.o(189070);
  }
  
  public TraditionNestedLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(189083);
    AppMethodBeat.o(189083);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(189069);
    super.onFinishInflate();
    AppMethodBeat.o(189069);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(189051);
    p.k(paramMotionEvent, "event");
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    switch (i & 0xFF)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
          AppMethodBeat.o(189051);
          return bool;
          this.zDE = j;
        }
        i = this.zDE - j;
      } while (Math.abs(i) <= ViewConfiguration.getTouchSlop());
      if ((i > 0) && (!this.zDD))
      {
        Log.d("LiveFriendsTraditionNestedLayout", "onInterceptTouchEvent: 开始向上拦截");
        AppMethodBeat.o(189051);
        return true;
      }
    } while ((i >= 0) || (!this.zDD));
    Log.d("LiveFriendsTraditionNestedLayout", "onInterceptTouchEvent: 开始向下拦截");
    AppMethodBeat.o(189051);
    return true;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189060);
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = this.zDB;
    int j;
    View localView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getLayoutParams();
      if (localObject != null)
      {
        j = getMeasuredHeight();
        localView = this.zDA;
        if (localView == null) {
          break label102;
        }
      }
    }
    label102:
    for (int i = localView.getMeasuredHeight();; i = 0)
    {
      ((ViewGroup.LayoutParams)localObject).height = (i + j);
      localView = this.zDB;
      if (localView != null) {
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(189060);
      return;
      localObject = null;
      break;
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(189068);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.zDA;
    if (localView != null) {}
    for (paramInt1 = localView.getMeasuredHeight();; paramInt1 = 0)
    {
      this.zDC = paramInt1;
      AppMethodBeat.o(189068);
      return;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(189057);
    p.k(paramMotionEvent, "event");
    int j = paramMotionEvent.getAction();
    int i = (int)paramMotionEvent.getY();
    switch (j & 0xFF)
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(189057);
      return bool;
      this.zDE = i;
      continue;
      j = this.zDE - i;
      if (Math.abs(j) > ViewConfiguration.getTouchSlop()) {
        scrollBy(0, j);
      }
      this.zDE = i;
    }
  }
  
  public final void scrollTo(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(189066);
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    paramInt2 = i;
    if (i > this.zDC) {
      paramInt2 = this.zDC;
    }
    super.scrollTo(paramInt1, paramInt2);
    if (getScrollY() == this.zDC) {
      bool = true;
    }
    this.zDD = bool;
    AppMethodBeat.o(189066);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/base/view/TraditionNestedLayout$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby-api_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.view.TraditionNestedLayout
 * JD-Core Version:    0.7.0.1
 */
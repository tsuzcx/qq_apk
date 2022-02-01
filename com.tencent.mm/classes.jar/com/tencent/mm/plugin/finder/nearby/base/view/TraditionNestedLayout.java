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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/base/view/TraditionNestedLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "headLayout", "Landroid/view/View;", "headLayoutHeight", "isHeadHide", "", "lastY", "rlLayout", "onFinishInflate", "", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "scrollTo", "x", "y", "Companion", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TraditionNestedLayout
  extends LinearLayout
{
  public static final a EHH;
  private View EHI;
  private View EHJ;
  private int EHK;
  private boolean EHL;
  private int EHM;
  
  static
  {
    AppMethodBeat.i(339706);
    EHH = new a((byte)0);
    AppMethodBeat.o(339706);
  }
  
  public TraditionNestedLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(339693);
    AppMethodBeat.o(339693);
  }
  
  public TraditionNestedLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(339700);
    AppMethodBeat.o(339700);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(339755);
    super.onFinishInflate();
    AppMethodBeat.o(339755);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339713);
    s.u(paramMotionEvent, "event");
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
          AppMethodBeat.o(339713);
          return bool;
          this.EHM = j;
        }
        i = this.EHM - j;
      } while (Math.abs(i) <= ViewConfiguration.getTouchSlop());
      if ((i > 0) && (!this.EHL))
      {
        Log.d("LiveFriendsTraditionNestedLayout", "onInterceptTouchEvent: 开始向上拦截");
        AppMethodBeat.o(339713);
        return true;
      }
    } while ((i >= 0) || (!this.EHL));
    Log.d("LiveFriendsTraditionNestedLayout", "onInterceptTouchEvent: 开始向下拦截");
    AppMethodBeat.o(339713);
    return true;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(339734);
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = this.EHJ;
    int j;
    View localView;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null)
      {
        j = getMeasuredHeight();
        localView = this.EHI;
        if (localView != null) {
          break label98;
        }
      }
    }
    label98:
    for (int i = 0;; i = localView.getMeasuredHeight())
    {
      ((ViewGroup.LayoutParams)localObject).height = (i + j);
      localView = this.EHJ;
      if (localView != null) {
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(339734);
      return;
      localObject = ((View)localObject).getLayoutParams();
      break;
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(339747);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.EHI;
    if (localView == null) {}
    for (paramInt1 = 0;; paramInt1 = localView.getMeasuredHeight())
    {
      this.EHK = paramInt1;
      AppMethodBeat.o(339747);
      return;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(339723);
    s.u(paramMotionEvent, "event");
    int j = paramMotionEvent.getAction();
    int i = (int)paramMotionEvent.getY();
    switch (j & 0xFF)
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(339723);
      return bool;
      this.EHM = i;
      continue;
      j = this.EHM - i;
      if (Math.abs(j) > ViewConfiguration.getTouchSlop()) {
        scrollBy(0, j);
      }
      this.EHM = i;
    }
  }
  
  public final void scrollTo(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(339741);
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    paramInt2 = i;
    if (i > this.EHK) {
      paramInt2 = this.EHK;
    }
    super.scrollTo(paramInt1, paramInt2);
    if (getScrollY() == this.EHK) {
      bool = true;
    }
    this.EHL = bool;
    AppMethodBeat.o(339741);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/base/view/TraditionNestedLayout$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.view.TraditionNestedLayout
 * JD-Core Version:    0.7.0.1
 */
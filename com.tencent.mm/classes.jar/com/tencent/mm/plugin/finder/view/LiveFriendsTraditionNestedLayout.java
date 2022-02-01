package com.tencent.mm.plugin.finder.view;

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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/LiveFriendsTraditionNestedLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "headLayout", "Landroid/view/View;", "headLayoutHeight", "isHeadHide", "", "lastY", "rlLayout", "onFinishInflate", "", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "scrollTo", "x", "y", "Companion", "plugin-finder_release"})
public final class LiveFriendsTraditionNestedLayout
  extends LinearLayout
{
  public static final a wqA;
  private View wqt;
  private int wqv;
  private View wqx;
  private boolean wqy;
  private int wqz;
  
  static
  {
    AppMethodBeat.i(255069);
    wqA = new a((byte)0);
    AppMethodBeat.o(255069);
  }
  
  public LiveFriendsTraditionNestedLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(255067);
    AppMethodBeat.o(255067);
  }
  
  public LiveFriendsTraditionNestedLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255068);
    AppMethodBeat.o(255068);
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(255066);
    super.onFinishInflate();
    this.wqx = findViewById(2131307118);
    AppMethodBeat.o(255066);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(255061);
    p.h(paramMotionEvent, "event");
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
          AppMethodBeat.o(255061);
          return bool;
          this.wqz = j;
        }
        i = this.wqz - j;
      } while (Math.abs(i) <= ViewConfiguration.getTouchSlop());
      if ((i > 0) && (!this.wqy))
      {
        Log.d("LiveFriendsTraditionNestedLayout", "onInterceptTouchEvent: 开始向上拦截");
        AppMethodBeat.o(255061);
        return true;
      }
    } while ((i >= 0) || (!this.wqy));
    Log.d("LiveFriendsTraditionNestedLayout", "onInterceptTouchEvent: 开始向下拦截");
    AppMethodBeat.o(255061);
    return true;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255063);
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = this.wqx;
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
      localView = this.wqx;
      if (localView != null) {
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(255063);
      return;
      localObject = null;
      break;
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(255065);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.wqt;
    if (localView != null) {}
    for (paramInt1 = localView.getMeasuredHeight();; paramInt1 = 0)
    {
      this.wqv = paramInt1;
      AppMethodBeat.o(255065);
      return;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(255062);
    p.h(paramMotionEvent, "event");
    int j = paramMotionEvent.getAction();
    int i = (int)paramMotionEvent.getY();
    switch (j & 0xFF)
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(255062);
      return bool;
      this.wqz = i;
      continue;
      j = this.wqz - i;
      if (Math.abs(j) > ViewConfiguration.getTouchSlop()) {
        scrollBy(0, j);
      }
      this.wqz = i;
    }
  }
  
  public final void scrollTo(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(255064);
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    paramInt2 = i;
    if (i > this.wqv) {
      paramInt2 = this.wqv;
    }
    super.scrollTo(paramInt1, paramInt2);
    if (getScrollY() == this.wqv) {
      bool = true;
    }
    this.wqy = bool;
    AppMethodBeat.o(255064);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/LiveFriendsTraditionNestedLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.LiveFriendsTraditionNestedLayout
 * JD-Core Version:    0.7.0.1
 */
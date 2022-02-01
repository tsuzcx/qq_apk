package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderMaxSizeLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "disallowInterceptTouch", "", "getDisallowInterceptTouch", "()Z", "setDisallowInterceptTouch", "(Z)V", "forbidHorizontalScroll", "getForbidHorizontalScroll", "setForbidHorizontalScroll", "maxHeight", "maxWidth", "startX", "startY", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getMaxHeight", "getMaxWidth", "initAttribute", "", "onMeasure", "widthSpec", "heightSpec", "setMaxHeight", "setMaxWidth", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMaxSizeLayout
  extends FrameLayout
{
  private int SwV;
  private final String TAG;
  private boolean akfF;
  private boolean akfG;
  private int maxHeight;
  private int maxWidth;
  private int yEA;
  
  public FinderMaxSizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(359155);
    this.TAG = "Finder.FinderMaxSizeLayout";
    b(paramAttributeSet, 0);
    AppMethodBeat.o(359155);
  }
  
  public FinderMaxSizeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(359162);
    this.TAG = "Finder.FinderMaxSizeLayout";
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(359162);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(359170);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, p.j.haf, paramInt, 0);
      s.s(paramAttributeSet, "context.obtainStyledAttr…xSizeLayout, defStyle, 0)");
      this.maxHeight = ((int)paramAttributeSet.getDimension(p.j.CuH, 0.0F));
      this.maxWidth = ((int)paramAttributeSet.getDimension(p.j.CuI, 0.0F));
      paramAttributeSet.recycle();
      Log.i(this.TAG, "[initAttribute],maxHeight:" + this.maxHeight + ", maxWidth:" + this.maxWidth);
    }
    AppMethodBeat.o(359170);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(371557);
    requestDisallowInterceptTouchEvent(this.akfF);
    Integer localInteger;
    if (this.akfG)
    {
      if (paramMotionEvent != null) {
        break label52;
      }
      localInteger = null;
      if (localInteger != null) {
        break label64;
      }
      label32:
      if (localInteger != null) {
        break label103;
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(371557);
      return bool;
      label52:
      localInteger = Integer.valueOf(paramMotionEvent.getAction());
      break;
      label64:
      if (localInteger.intValue() != 0) {
        break label32;
      }
      this.SwV = ((int)paramMotionEvent.getX());
      this.yEA = ((int)paramMotionEvent.getY());
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      label103:
      if (localInteger.intValue() == 2)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        if (Math.abs(i - this.SwV) > Math.abs(j - this.yEA))
        {
          Log.i(this.TAG, s.X(" canScrollHorizontally: ", Boolean.valueOf(canScrollHorizontally(this.SwV - i))));
          getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(this.SwV - i));
        }
      }
    }
  }
  
  public final boolean getDisallowInterceptTouch()
  {
    return this.akfF;
  }
  
  public final boolean getForbidHorizontalScroll()
  {
    return this.akfG;
  }
  
  public final int getMaxHeight()
  {
    return this.maxHeight;
  }
  
  public final int getMaxWidth()
  {
    return this.maxWidth;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(359200);
    if (this.maxHeight > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, -2147483648);
    }
    if (this.maxWidth > 0) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(359200);
  }
  
  public final void setDisallowInterceptTouch(boolean paramBoolean)
  {
    this.akfF = paramBoolean;
  }
  
  public final void setForbidHorizontalScroll(boolean paramBoolean)
  {
    this.akfG = paramBoolean;
  }
  
  public final void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(359177);
    this.maxHeight = paramInt;
    Log.i(this.TAG, "[setMaxHeight],maxHeight:" + paramInt + ", maxWidth:" + this.maxWidth);
    AppMethodBeat.o(359177);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(359182);
    this.maxWidth = paramInt;
    Log.i(this.TAG, "[setMaxWidth],maxHeight:" + this.maxHeight + ", maxWidth:" + paramInt);
    AppMethodBeat.o(359182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderMaxSizeLayout
 * JD-Core Version:    0.7.0.1
 */
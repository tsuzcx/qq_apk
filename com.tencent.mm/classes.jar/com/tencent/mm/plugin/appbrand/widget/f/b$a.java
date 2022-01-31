package com.tencent.mm.plugin.appbrand.widget.f;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.b.a;

public final class b$a
  extends FrameLayout
{
  private final Rect juk;
  private final int[] jul;
  
  public b$a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(141724);
    this.juk = new Rect();
    this.jul = new int[2];
    setWillNotDraw(true);
    AppMethodBeat.o(141724);
  }
  
  protected final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(141725);
    paramLayoutParams = (FrameLayout.LayoutParams)super.generateLayoutParams(paramLayoutParams);
    if (-1 == paramLayoutParams.gravity) {
      paramLayoutParams.gravity = 17;
    }
    AppMethodBeat.o(141725);
    return paramLayoutParams;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141728);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!t.aw(this))
    {
      AppMethodBeat.o(141728);
      return;
    }
    getWindowVisibleDisplayFrame(this.juk);
    getLocationInWindow(this.jul);
    if (d.getLogLevel() <= 1) {
      d.d("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", new Object[] { this.juk, a.toString(this.jul) });
    }
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      View localView = getChildAt(paramInt1);
      paramInt2 = this.jul[1] + localView.getTop() + localView.getHeight() - this.juk.bottom;
      if (paramInt2 > 0)
      {
        paramInt2 = Math.max(0, localView.getTop() - paramInt2);
        localView.layout(localView.getLeft(), paramInt2, localView.getRight(), localView.getHeight() + paramInt2);
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(141728);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(141726);
    super.onViewAdded(paramView);
    bringToFront();
    bringChildToFront(paramView);
    AppMethodBeat.o(141726);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(141727);
    super.onViewRemoved(paramView);
    if (getChildCount() == 0)
    {
      setVisibility(8);
      if ((getParent() instanceof ViewGroup)) {
        ((ViewGroup)getParent()).removeView(this);
      }
    }
    AppMethodBeat.o(141727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.b.a
 * JD-Core Version:    0.7.0.1
 */
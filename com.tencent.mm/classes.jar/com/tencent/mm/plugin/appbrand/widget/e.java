package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

public final class e
  extends FrameLayout
{
  public e(Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    if (willNotDraw()) {
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e
 * JD-Core Version:    0.7.0.1
 */
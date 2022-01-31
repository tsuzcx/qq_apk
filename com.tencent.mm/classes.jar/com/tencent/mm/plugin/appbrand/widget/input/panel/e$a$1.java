package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;

final class e$a$1
  extends View
{
  e$a$1(e.a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.hyc.mInLayout = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.hyc.mInLayout = false;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.hyc.htS > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.hyc.htS, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.e.a.1
 * JD-Core Version:    0.7.0.1
 */
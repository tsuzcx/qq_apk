package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bz;

public final class AppBrandCapsuleBarPlaceHolderView
  extends View
  implements bz
{
  private int nvv = -1;
  
  public AppBrandCapsuleBarPlaceHolderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandCapsuleBarPlaceHolderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppBrandCapsuleBarPlaceHolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public AppBrandCapsuleBarPlaceHolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    return true;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219485);
    if (getVisibility() == 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max(this.nvv, 0), 1073741824), paramInt2);
      AppMethodBeat.o(219485);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(219485);
  }
  
  public final void setFixedWidth(int paramInt)
  {
    AppMethodBeat.i(219484);
    paramInt = Math.max(paramInt, 0);
    if (paramInt != this.nvv)
    {
      this.nvv = paramInt;
      if (this.nvv != getMeasuredWidth()) {
        requestLayout();
      }
    }
    AppMethodBeat.o(219484);
  }
  
  public final void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(219486);
    if (getLayoutParams() == null) {}
    for (int i = 1;; i = 0)
    {
      super.setLayoutParams(paramLayoutParams);
      if (i != 0)
      {
        this.nvv = paramLayoutParams.width;
        this.nvv = Math.max(0, this.nvv);
      }
      AppMethodBeat.o(219486);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandCapsuleBarPlaceHolderView
  extends View
{
  private int mkX = -1;
  
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
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207883);
    if (getVisibility() == 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max(this.mkX, 0), 1073741824), paramInt2);
      AppMethodBeat.o(207883);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(207883);
  }
  
  public final void setFixedWidth(int paramInt)
  {
    AppMethodBeat.i(207882);
    paramInt = Math.max(paramInt, 0);
    if (paramInt != this.mkX)
    {
      this.mkX = paramInt;
      if (this.mkX != getMeasuredWidth()) {
        requestLayout();
      }
    }
    AppMethodBeat.o(207882);
  }
  
  public final void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(207884);
    if (getLayoutParams() == null) {}
    for (int i = 1;; i = 0)
    {
      super.setLayoutParams(paramLayoutParams);
      if (i != 0)
      {
        this.mkX = paramLayoutParams.width;
        this.mkX = Math.max(0, this.mkX);
      }
      AppMethodBeat.o(207884);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.cg;

public final class AppBrandCapsuleBarPlaceHolderView
  extends View
  implements cg
{
  private int tCp = -1;
  
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
  
  public AppBrandCapsuleBarPlaceHolderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final boolean g(Canvas paramCanvas)
  {
    return true;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(325342);
    if (getVisibility() == 0)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max(this.tCp, 0), 1073741824), paramInt2);
      AppMethodBeat.o(325342);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(325342);
  }
  
  public final void setFixedWidth(int paramInt)
  {
    AppMethodBeat.i(325336);
    paramInt = Math.max(paramInt, 0);
    if (paramInt != this.tCp)
    {
      this.tCp = paramInt;
      if (this.tCp != getMeasuredWidth()) {
        requestLayout();
      }
    }
    AppMethodBeat.o(325336);
  }
  
  public final void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(325346);
    if (getLayoutParams() == null) {}
    for (int i = 1;; i = 0)
    {
      super.setLayoutParams(paramLayoutParams);
      if (i != 0)
      {
        this.tCp = paramLayoutParams.width;
        this.tCp = Math.max(0, this.tCp);
      }
      AppMethodBeat.o(325346);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView
 * JD-Core Version:    0.7.0.1
 */
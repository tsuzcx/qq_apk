package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MaxHeightRecyclerView
  extends RecyclerView
{
  private int mMaxHeight;
  
  public MaxHeightRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MaxHeightRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getMaxHeight()
  {
    return this.mMaxHeight;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147711);
    if (this.mMaxHeight > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(147711);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(147710);
    this.mMaxHeight = paramInt;
    invalidate();
    requestLayout();
    AppMethodBeat.o(147710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView
 * JD-Core Version:    0.7.0.1
 */
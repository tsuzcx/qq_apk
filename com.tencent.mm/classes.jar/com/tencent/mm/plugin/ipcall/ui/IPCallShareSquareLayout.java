package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCallShareSquareLayout
  extends RelativeLayout
{
  public IPCallShareSquareLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public IPCallShareSquareLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25978);
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824));
    AppMethodBeat.o(25978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareSquareLayout
 * JD-Core Version:    0.7.0.1
 */
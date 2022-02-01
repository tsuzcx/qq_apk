package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PreviewFrameLayout
  extends RelativeLayout
{
  private double rzH = 1.333333333333333D;
  
  public PreviewFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public double getmAspectRatio()
  {
    return this.rzH;
  }
  
  public void setAspectRatio(double paramDouble)
  {
    AppMethodBeat.i(104329);
    if (paramDouble <= 0.0D)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(104329);
      throw localIllegalArgumentException;
    }
    if (this.rzH != paramDouble)
    {
      this.rzH = paramDouble;
      requestLayout();
    }
    AppMethodBeat.o(104329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.PreviewFrameLayout
 * JD-Core Version:    0.7.0.1
 */
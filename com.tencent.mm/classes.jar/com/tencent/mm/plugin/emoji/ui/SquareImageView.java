package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SquareImageView
  extends ImageView
{
  public SquareImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109087);
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    super.onMeasure(paramInt1, paramInt1);
    AppMethodBeat.o(109087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.SquareImageView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.live.core.core.trtc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MultiLineRadioGroup$LayoutParams
  extends LinearLayout.LayoutParams
{
  public MultiLineRadioGroup$LayoutParams()
  {
    super(-2, -2);
  }
  
  public MultiLineRadioGroup$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209065);
    if (paramTypedArray.hasValue(paramInt1)) {}
    for (this.width = paramTypedArray.getLayoutDimension(paramInt1, "layout_width"); paramTypedArray.hasValue(paramInt2); this.width = -2)
    {
      this.height = paramTypedArray.getLayoutDimension(paramInt2, "layout_height");
      AppMethodBeat.o(209065);
      return;
    }
    this.height = -2;
    AppMethodBeat.o(209065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.MultiLineRadioGroup.LayoutParams
 * JD-Core Version:    0.7.0.1
 */
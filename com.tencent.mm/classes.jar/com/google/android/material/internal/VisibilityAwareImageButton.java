package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VisibilityAwareImageButton
  extends ImageButton
{
  private int bDf;
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(238368);
    this.bDf = getVisibility();
    AppMethodBeat.o(238368);
  }
  
  public final int getUserSetVisibility()
  {
    return this.bDf;
  }
  
  public final void s(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(238370);
    super.setVisibility(paramInt);
    if (paramBoolean) {
      this.bDf = paramInt;
    }
    AppMethodBeat.o(238370);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(238369);
    s(paramInt, true);
    AppMethodBeat.o(238369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.VisibilityAwareImageButton
 * JD-Core Version:    0.7.0.1
 */
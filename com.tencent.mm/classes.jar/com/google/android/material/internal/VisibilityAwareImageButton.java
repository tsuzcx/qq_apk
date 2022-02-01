package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VisibilityAwareImageButton
  extends ImageButton
{
  private int dwg;
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209415);
    this.dwg = getVisibility();
    AppMethodBeat.o(209415);
  }
  
  public final void G(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(209437);
    super.setVisibility(paramInt);
    if (paramBoolean) {
      this.dwg = paramInt;
    }
    AppMethodBeat.o(209437);
  }
  
  public final int getUserSetVisibility()
  {
    return this.dwg;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(209426);
    G(paramInt, true);
    AppMethodBeat.o(209426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.VisibilityAwareImageButton
 * JD-Core Version:    0.7.0.1
 */
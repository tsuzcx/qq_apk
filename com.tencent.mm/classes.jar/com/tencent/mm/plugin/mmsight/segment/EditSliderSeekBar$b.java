package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EditSliderSeekBar$b
  extends Drawable
{
  private Drawable Fdp;
  private Drawable Fdq;
  boolean isPressed = false;
  
  public EditSliderSeekBar$b(EditSliderSeekBar paramEditSliderSeekBar, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.Fdp = paramDrawable1;
    this.Fdq = paramDrawable2;
    this.isPressed = false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(249252);
    if (this.isPressed) {}
    for (Drawable localDrawable = this.Fdp;; localDrawable = this.Fdq)
    {
      if (!getBounds().equals(localDrawable.getBounds())) {
        localDrawable.setBounds(getBounds());
      }
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(249252);
      return;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(249253);
    this.Fdp.setAlpha(paramInt);
    this.Fdq.setAlpha(paramInt);
    AppMethodBeat.o(249253);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(249254);
    this.Fdp.setColorFilter(paramColorFilter);
    this.Fdq.setColorFilter(paramColorFilter);
    AppMethodBeat.o(249254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SliderSeekBar$b
  extends Drawable
{
  private Drawable Fdp;
  private Drawable Fdq;
  boolean isPressed = false;
  
  public SliderSeekBar$b(SliderSeekBar paramSliderSeekBar, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.Fdp = paramDrawable1;
    this.Fdq = paramDrawable2;
    this.isPressed = false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94446);
    if (this.isPressed) {}
    for (Drawable localDrawable = this.Fdp;; localDrawable = this.Fdq)
    {
      if (!getBounds().equals(localDrawable.getBounds())) {
        localDrawable.setBounds(getBounds());
      }
      localDrawable.draw(paramCanvas);
      AppMethodBeat.o(94446);
      return;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(94447);
    this.Fdp.setAlpha(paramInt);
    this.Fdq.setAlpha(paramInt);
    AppMethodBeat.o(94447);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(94448);
    this.Fdp.setColorFilter(paramColorFilter);
    this.Fdq.setColorFilter(paramColorFilter);
    AppMethodBeat.o(94448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.b
 * JD-Core Version:    0.7.0.1
 */
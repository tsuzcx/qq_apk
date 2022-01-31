package com.tencent.kinda.framework.widget.base;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMKButton$BackgroundColorDrawable
  extends Drawable
{
  private int color;
  
  MMKButton$BackgroundColorDrawable(int paramInt)
  {
    this.color = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(144842);
    paramCanvas.drawColor(this.color);
    AppMethodBeat.o(144842);
  }
  
  public int getOpacity()
  {
    AppMethodBeat.i(144843);
    if (this.color == 0)
    {
      AppMethodBeat.o(144843);
      return -2;
    }
    if (Color.alpha(this.color) > 0)
    {
      AppMethodBeat.o(144843);
      return -3;
    }
    AppMethodBeat.o(144843);
    return -1;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKButton.BackgroundColorDrawable
 * JD-Core Version:    0.7.0.1
 */
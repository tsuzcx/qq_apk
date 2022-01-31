package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

final class b
  extends Drawable
{
  final ActionBarContainer Xw;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    this.Xw = paramActionBarContainer;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.Xw.XD) {
      if (this.Xw.XC != null) {
        this.Xw.XC.draw(paramCanvas);
      }
    }
    do
    {
      return;
      if (this.Xw.VW != null) {
        this.Xw.VW.draw(paramCanvas);
      }
    } while ((this.Xw.XB == null) || (!this.Xw.XE));
    this.Xw.XB.draw(paramCanvas);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    if (this.Xw.XD) {
      if (this.Xw.XC != null) {
        this.Xw.XC.getOutline(paramOutline);
      }
    }
    while (this.Xw.VW == null) {
      return;
    }
    this.Xw.VW.getOutline(paramOutline);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.b
 * JD-Core Version:    0.7.0.1
 */
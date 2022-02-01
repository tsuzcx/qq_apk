package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

final class b
  extends Drawable
{
  final ActionBarContainer ahz;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    this.ahz = paramActionBarContainer;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.ahz.ahG) {
      if (this.ahz.ahF != null) {
        this.ahz.ahF.draw(paramCanvas);
      }
    }
    do
    {
      return;
      if (this.ahz.afZ != null) {
        this.ahz.afZ.draw(paramCanvas);
      }
    } while ((this.ahz.ahE == null) || (!this.ahz.ahH));
    this.ahz.ahE.draw(paramCanvas);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    if (this.ahz.ahG) {
      if (this.ahz.ahF != null) {
        this.ahz.ahF.getOutline(paramOutline);
      }
    }
    while (this.ahz.afZ == null) {
      return;
    }
    this.ahz.afZ.getOutline(paramOutline);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.b
 * JD-Core Version:    0.7.0.1
 */
package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

final class b
  extends Drawable
{
  final ActionBarContainer afv;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    this.afv = paramActionBarContainer;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.afv.afC) {
      if (this.afv.afB != null) {
        this.afv.afB.draw(paramCanvas);
      }
    }
    do
    {
      return;
      if (this.afv.adV != null) {
        this.afv.adV.draw(paramCanvas);
      }
    } while ((this.afv.afA == null) || (!this.afv.afD));
    this.afv.afA.draw(paramCanvas);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    if (this.afv.afC) {
      if (this.afv.afB != null) {
        this.afv.afB.getOutline(paramOutline);
      }
    }
    while (this.afv.adV == null) {
      return;
    }
    this.afv.adV.getOutline(paramOutline);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.b
 * JD-Core Version:    0.7.0.1
 */
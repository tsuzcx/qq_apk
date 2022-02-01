package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

final class b
  extends Drawable
{
  final ActionBarContainer ahm;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    this.ahm = paramActionBarContainer;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.ahm.aht) {
      if (this.ahm.ahs != null) {
        this.ahm.ahs.draw(paramCanvas);
      }
    }
    do
    {
      return;
      if (this.ahm.afM != null) {
        this.ahm.afM.draw(paramCanvas);
      }
    } while ((this.ahm.ahr == null) || (!this.ahm.ahu));
    this.ahm.ahr.draw(paramCanvas);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    if (this.ahm.aht) {
      if (this.ahm.ahs != null) {
        this.ahm.ahs.getOutline(paramOutline);
      }
    }
    while (this.ahm.afM == null) {
      return;
    }
    this.ahm.afM.getOutline(paramOutline);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.b
 * JD-Core Version:    0.7.0.1
 */
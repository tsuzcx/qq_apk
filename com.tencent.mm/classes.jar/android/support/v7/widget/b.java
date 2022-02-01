package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

final class b
  extends Drawable
{
  final ActionBarContainer aeB;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    this.aeB = paramActionBarContainer;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.aeB.aeI) {
      if (this.aeB.aeH != null) {
        this.aeB.aeH.draw(paramCanvas);
      }
    }
    do
    {
      return;
      if (this.aeB.adb != null) {
        this.aeB.adb.draw(paramCanvas);
      }
    } while ((this.aeB.aeG == null) || (!this.aeB.aeJ));
    this.aeB.aeG.draw(paramCanvas);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void getOutline(Outline paramOutline)
  {
    if (this.aeB.aeI) {
      if (this.aeB.aeH != null) {
        this.aeB.aeH.getOutline(paramOutline);
      }
    }
    while (this.aeB.adb == null) {
      return;
    }
    this.aeB.adb.getOutline(paramOutline);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.b
 * JD-Core Version:    0.7.0.1
 */
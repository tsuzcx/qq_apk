package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class b
  extends Drawable
{
  final ActionBarContainer WJ;
  
  public b(ActionBarContainer paramActionBarContainer)
  {
    this.WJ = paramActionBarContainer;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.WJ.WQ) {
      if (this.WJ.WP != null) {
        this.WJ.WP.draw(paramCanvas);
      }
    }
    do
    {
      return;
      if (this.WJ.Vh != null) {
        this.WJ.Vh.draw(paramCanvas);
      }
    } while ((this.WJ.WO == null) || (!this.WJ.WR));
    this.WJ.WO.draw(paramCanvas);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.b
 * JD-Core Version:    0.7.0.1
 */
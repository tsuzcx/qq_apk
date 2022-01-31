package android.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

final class c
  extends b
{
  public c(ActionBarContainer paramActionBarContainer)
  {
    super(paramActionBarContainer);
  }
  
  public final void getOutline(Outline paramOutline)
  {
    if (this.WJ.WQ) {
      if (this.WJ.WP != null) {
        this.WJ.WP.getOutline(paramOutline);
      }
    }
    while (this.WJ.Vh == null) {
      return;
    }
    this.WJ.Vh.getOutline(paramOutline);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.c
 * JD-Core Version:    0.7.0.1
 */
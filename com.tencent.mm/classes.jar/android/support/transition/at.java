package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

final class at
  implements au
{
  private final ViewOverlay tq;
  
  at(View paramView)
  {
    this.tq = paramView.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.tq.add(paramDrawable);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.tq.remove(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.at
 * JD-Core Version:    0.7.0.1
 */
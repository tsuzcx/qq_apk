package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

final class as
  implements at
{
  private final ViewOverlay uu;
  
  as(View paramView)
  {
    this.uu = paramView.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.uu.add(paramDrawable);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.uu.remove(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.as
 * JD-Core Version:    0.7.0.1
 */
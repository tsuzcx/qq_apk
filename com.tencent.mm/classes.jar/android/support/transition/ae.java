package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

final class ae
  implements af
{
  private final ViewOverlay Dy;
  
  ae(View paramView)
  {
    this.Dy = paramView.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.Dy.add(paramDrawable);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.Dy.remove(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ae
 * JD-Core Version:    0.7.0.1
 */
package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

final class af
  implements ag
{
  private final ViewOverlay DH;
  
  af(View paramView)
  {
    this.DH = paramView.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.DH.add(paramDrawable);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.DH.remove(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.af
 * JD-Core Version:    0.7.0.1
 */
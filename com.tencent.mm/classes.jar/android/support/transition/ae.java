package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

final class ae
  implements af
{
  private final ViewOverlay BG;
  
  ae(View paramView)
  {
    this.BG = paramView.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.BG.add(paramDrawable);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.BG.remove(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ae
 * JD-Core Version:    0.7.0.1
 */
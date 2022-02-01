package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

final class ae
  implements af
{
  private final ViewOverlay AI;
  
  ae(View paramView)
  {
    this.AI = paramView.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.AI.add(paramDrawable);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.AI.remove(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.ae
 * JD-Core Version:    0.7.0.1
 */
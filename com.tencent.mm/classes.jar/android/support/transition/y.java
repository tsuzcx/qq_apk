package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class y
  implements z
{
  private final ViewGroupOverlay Dk;
  
  y(ViewGroup paramViewGroup)
  {
    this.Dk = paramViewGroup.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.Dk.add(paramDrawable);
  }
  
  public final void add(View paramView)
  {
    this.Dk.add(paramView);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.Dk.remove(paramDrawable);
  }
  
  public final void remove(View paramView)
  {
    this.Dk.remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.y
 * JD-Core Version:    0.7.0.1
 */
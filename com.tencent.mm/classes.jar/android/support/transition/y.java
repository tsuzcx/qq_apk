package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class y
  implements z
{
  private final ViewGroupOverlay Bs;
  
  y(ViewGroup paramViewGroup)
  {
    this.Bs = paramViewGroup.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.Bs.add(paramDrawable);
  }
  
  public final void add(View paramView)
  {
    this.Bs.add(paramView);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.Bs.remove(paramDrawable);
  }
  
  public final void remove(View paramView)
  {
    this.Bs.remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.y
 * JD-Core Version:    0.7.0.1
 */
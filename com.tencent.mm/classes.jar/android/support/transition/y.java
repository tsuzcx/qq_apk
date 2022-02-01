package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class y
  implements z
{
  private final ViewGroupOverlay Au;
  
  y(ViewGroup paramViewGroup)
  {
    this.Au = paramViewGroup.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.Au.add(paramDrawable);
  }
  
  public final void add(View paramView)
  {
    this.Au.add(paramView);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.Au.remove(paramDrawable);
  }
  
  public final void remove(View paramView)
  {
    this.Au.remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.y
 * JD-Core Version:    0.7.0.1
 */
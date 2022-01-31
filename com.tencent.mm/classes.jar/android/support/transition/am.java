package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class am
  implements an
{
  private final ViewGroupOverlay ta;
  
  am(ViewGroup paramViewGroup)
  {
    this.ta = paramViewGroup.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.ta.add(paramDrawable);
  }
  
  public final void add(View paramView)
  {
    this.ta.add(paramView);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.ta.remove(paramDrawable);
  }
  
  public final void remove(View paramView)
  {
    this.ta.remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.am
 * JD-Core Version:    0.7.0.1
 */
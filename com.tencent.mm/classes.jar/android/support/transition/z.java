package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class z
  implements aa
{
  private final ViewGroupOverlay Dt;
  
  z(ViewGroup paramViewGroup)
  {
    this.Dt = paramViewGroup.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.Dt.add(paramDrawable);
  }
  
  public final void add(View paramView)
  {
    this.Dt.add(paramView);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.Dt.remove(paramDrawable);
  }
  
  public final void remove(View paramView)
  {
    this.Dt.remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.z
 * JD-Core Version:    0.7.0.1
 */
package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class al
  implements am
{
  private final ViewGroupOverlay uc;
  
  al(ViewGroup paramViewGroup)
  {
    this.uc = paramViewGroup.getOverlay();
  }
  
  public final void add(Drawable paramDrawable)
  {
    this.uc.add(paramDrawable);
  }
  
  public final void add(View paramView)
  {
    this.uc.add(paramView);
  }
  
  public final void remove(Drawable paramDrawable)
  {
    this.uc.remove(paramDrawable);
  }
  
  public final void remove(View paramView)
  {
    this.uc.remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.al
 * JD-Core Version:    0.7.0.1
 */
package android.support.transition;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

class ar
  implements at
{
  protected ar.a un = new ar.a(paramContext, paramViewGroup, paramView, this);
  
  ar(Context paramContext, ViewGroup paramViewGroup, View paramView) {}
  
  private static ViewGroup H(View paramView)
  {
    while (paramView != null)
    {
      if ((paramView.getId() == 16908290) && ((paramView instanceof ViewGroup))) {
        return (ViewGroup)paramView;
      }
      if ((paramView.getParent() instanceof ViewGroup)) {
        paramView = (ViewGroup)paramView.getParent();
      }
    }
    return null;
  }
  
  static ar I(View paramView)
  {
    ViewGroup localViewGroup = H(paramView);
    if (localViewGroup != null)
    {
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView instanceof ar.a)) {
          return ((ar.a)localView).ut;
        }
        i += 1;
      }
      return new ak(localViewGroup.getContext(), localViewGroup, paramView);
    }
    return null;
  }
  
  public final void add(Drawable paramDrawable)
  {
    ar.a locala = this.un;
    if (locala.ur == null) {
      locala.ur = new ArrayList();
    }
    if (!locala.ur.contains(paramDrawable))
    {
      locala.ur.add(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(locala);
    }
  }
  
  public final void remove(Drawable paramDrawable)
  {
    ar.a locala = this.un;
    if (locala.ur != null)
    {
      locala.ur.remove(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.ar
 * JD-Core Version:    0.7.0.1
 */
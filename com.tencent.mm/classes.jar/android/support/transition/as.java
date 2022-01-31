package android.support.transition;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

class as
  implements au
{
  protected as.a tk = new as.a(paramContext, paramViewGroup, paramView, this);
  
  as(Context paramContext, ViewGroup paramViewGroup, View paramView) {}
  
  static as E(View paramView)
  {
    Object localObject = paramView;
    label27:
    int j;
    int i;
    if (localObject != null) {
      if ((((View)localObject).getId() == 16908290) && ((localObject instanceof ViewGroup)))
      {
        localObject = (ViewGroup)localObject;
        if (localObject == null) {
          break label114;
        }
        j = ((ViewGroup)localObject).getChildCount();
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j) {
        break label100;
      }
      View localView = ((ViewGroup)localObject).getChildAt(i);
      if ((localView instanceof as.a))
      {
        return ((as.a)localView).tp;
        if (!(((View)localObject).getParent() instanceof ViewGroup)) {
          break;
        }
        localObject = (ViewGroup)((View)localObject).getParent();
        break;
        localObject = null;
        break label27;
      }
      i += 1;
    }
    label100:
    return new al(((ViewGroup)localObject).getContext(), (ViewGroup)localObject, paramView);
    label114:
    return null;
  }
  
  public final void add(Drawable paramDrawable)
  {
    as.a locala = this.tk;
    if (locala.to == null) {
      locala.to = new ArrayList();
    }
    if (!locala.to.contains(paramDrawable))
    {
      locala.to.add(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(locala);
    }
  }
  
  public final void remove(Drawable paramDrawable)
  {
    as.a locala = this.tk;
    if (locala.to != null)
    {
      locala.to.remove(paramDrawable);
      locala.invalidate(paramDrawable.getBounds());
      paramDrawable.setCallback(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.as
 * JD-Core Version:    0.7.0.1
 */
package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class h$a
  implements j.a
{
  public final void A(View paramView)
  {
    paramView = h.z(paramView);
    if (paramView != null)
    {
      paramView.rL -= 1;
      if (paramView.rL <= 0)
      {
        Object localObject = paramView.getParent();
        if ((localObject instanceof ViewGroup))
        {
          localObject = (ViewGroup)localObject;
          ((ViewGroup)localObject).endViewTransition(paramView);
          ((ViewGroup)localObject).removeView(paramView);
        }
      }
    }
  }
  
  public final j a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    h localh = h.z(paramView);
    paramMatrix = localh;
    if (localh == null)
    {
      if (!(paramViewGroup instanceof FrameLayout))
      {
        paramViewGroup = paramViewGroup.getParent();
        if ((paramViewGroup instanceof ViewGroup)) {}
      }
      for (paramViewGroup = null;; paramViewGroup = (FrameLayout)paramViewGroup)
      {
        if (paramViewGroup != null) {
          break label57;
        }
        return null;
        paramViewGroup = (ViewGroup)paramViewGroup;
        break;
      }
      label57:
      paramMatrix = new h(paramView);
      paramViewGroup.addView(paramMatrix);
    }
    paramMatrix.rL += 1;
    return paramMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.transition.h.a
 * JD-Core Version:    0.7.0.1
 */
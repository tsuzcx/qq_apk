package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeClipBounds
  extends Transition
{
  private static final String[] zP = { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(v paramv)
  {
    Object localObject = paramv.view;
    if (((View)localObject).getVisibility() == 8) {}
    Rect localRect;
    do
    {
      return;
      localRect = u.aC((View)localObject);
      paramv.values.put("android:clipBounds:clip", localRect);
    } while (localRect != null);
    localObject = new Rect(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
    paramv.values.put("android:clipBounds:bounds", localObject);
  }
  
  public final Animator a(ViewGroup paramViewGroup, v paramv1, v paramv2)
  {
    if ((paramv1 == null) || (paramv2 == null) || (!paramv1.values.containsKey("android:clipBounds:clip")) || (!paramv2.values.containsKey("android:clipBounds:clip"))) {
      paramViewGroup = null;
    }
    int i;
    do
    {
      return paramViewGroup;
      Object localObject = (Rect)paramv1.values.get("android:clipBounds:clip");
      Rect localRect = (Rect)paramv2.values.get("android:clipBounds:clip");
      if (localRect == null) {}
      for (i = 1; (localObject == null) && (localRect == null); i = 0) {
        return null;
      }
      if (localObject == null)
      {
        paramViewGroup = (Rect)paramv1.values.get("android:clipBounds:bounds");
        paramv1 = localRect;
      }
      while (paramViewGroup.equals(paramv1))
      {
        return null;
        paramViewGroup = (ViewGroup)localObject;
        paramv1 = localRect;
        if (localRect == null)
        {
          paramv1 = (Rect)paramv2.values.get("android:clipBounds:bounds");
          paramViewGroup = (ViewGroup)localObject;
        }
      }
      u.b(paramv2.view, paramViewGroup);
      localObject = new m(new Rect());
      paramv1 = ObjectAnimator.ofObject(paramv2.view, ah.DM, (TypeEvaluator)localObject, new Rect[] { paramViewGroup, paramv1 });
      paramViewGroup = paramv1;
    } while (i == 0);
    paramv1.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        u.b(this.Ar, null);
      }
    });
    return paramv1;
  }
  
  public final void a(v paramv)
  {
    c(paramv);
  }
  
  public final void b(v paramv)
  {
    c(paramv);
  }
  
  public final String[] getTransitionProperties()
  {
    return zP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ChangeClipBounds
 * JD-Core Version:    0.7.0.1
 */
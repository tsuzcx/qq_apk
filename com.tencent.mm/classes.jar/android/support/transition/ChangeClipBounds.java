package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeClipBounds
  extends Transition
{
  private static final String[] zJ = { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(u paramu)
  {
    Object localObject = paramu.view;
    if (((View)localObject).getVisibility() == 8) {}
    Rect localRect;
    do
    {
      return;
      localRect = t.aB((View)localObject);
      paramu.values.put("android:clipBounds:clip", localRect);
    } while (localRect != null);
    localObject = new Rect(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
    paramu.values.put("android:clipBounds:bounds", localObject);
  }
  
  public final Animator a(ViewGroup paramViewGroup, u paramu1, u paramu2)
  {
    if ((paramu1 == null) || (paramu2 == null) || (!paramu1.values.containsKey("android:clipBounds:clip")) || (!paramu2.values.containsKey("android:clipBounds:clip"))) {
      paramViewGroup = null;
    }
    int i;
    do
    {
      return paramViewGroup;
      Object localObject = (Rect)paramu1.values.get("android:clipBounds:clip");
      Rect localRect = (Rect)paramu2.values.get("android:clipBounds:clip");
      if (localRect == null) {}
      for (i = 1; (localObject == null) && (localRect == null); i = 0) {
        return null;
      }
      if (localObject == null)
      {
        paramViewGroup = (Rect)paramu1.values.get("android:clipBounds:bounds");
        paramu1 = localRect;
      }
      while (paramViewGroup.equals(paramu1))
      {
        return null;
        paramViewGroup = (ViewGroup)localObject;
        paramu1 = localRect;
        if (localRect == null)
        {
          paramu1 = (Rect)paramu2.values.get("android:clipBounds:bounds");
          paramViewGroup = (ViewGroup)localObject;
        }
      }
      t.b(paramu2.view, paramViewGroup);
      localObject = new m(new Rect());
      paramu1 = ObjectAnimator.ofObject(paramu2.view, ag.DD, (TypeEvaluator)localObject, new Rect[] { paramViewGroup, paramu1 });
      paramViewGroup = paramu1;
    } while (i == 0);
    paramu1.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        t.b(this.Al, null);
      }
    });
    return paramu1;
  }
  
  public final void a(u paramu)
  {
    c(paramu);
  }
  
  public final void b(u paramu)
  {
    c(paramu);
  }
  
  public final String[] getTransitionProperties()
  {
    return zJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ChangeClipBounds
 * JD-Core Version:    0.7.0.1
 */
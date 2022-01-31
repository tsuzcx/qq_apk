package android.support.transition;

import android.animation.Animator;
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
  private static final String[] qo = { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(ah paramah)
  {
    Object localObject = paramah.view;
    if (((View)localObject).getVisibility() == 8) {}
    Rect localRect;
    do
    {
      return;
      localRect = t.av((View)localObject);
      paramah.values.put("android:clipBounds:clip", localRect);
    } while (localRect != null);
    localObject = new Rect(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
    paramah.values.put("android:clipBounds:bounds", localObject);
  }
  
  public final Animator a(ViewGroup paramViewGroup, ah paramah1, ah paramah2)
  {
    if ((paramah1 == null) || (paramah2 == null) || (!paramah1.values.containsKey("android:clipBounds:clip")) || (!paramah2.values.containsKey("android:clipBounds:clip"))) {
      paramViewGroup = null;
    }
    int i;
    do
    {
      return paramViewGroup;
      Object localObject = (Rect)paramah1.values.get("android:clipBounds:clip");
      Rect localRect = (Rect)paramah2.values.get("android:clipBounds:clip");
      if (localRect == null) {}
      for (i = 1; (localObject == null) && (localRect == null); i = 0) {
        return null;
      }
      if (localObject == null)
      {
        paramViewGroup = (Rect)paramah1.values.get("android:clipBounds:bounds");
        paramah1 = localRect;
      }
      while (paramViewGroup.equals(paramah1))
      {
        return null;
        paramViewGroup = (ViewGroup)localObject;
        paramah1 = localRect;
        if (localRect == null)
        {
          paramah1 = (Rect)paramah2.values.get("android:clipBounds:bounds");
          paramViewGroup = (ViewGroup)localObject;
        }
      }
      t.c(paramah2.view, paramViewGroup);
      localObject = new z(new Rect());
      paramah1 = ObjectAnimator.ofObject(paramah2.view, au.uz, (TypeEvaluator)localObject, new Rect[] { paramViewGroup, paramah1 });
      paramViewGroup = paramah1;
    } while (i == 0);
    paramah1.addListener(new ChangeClipBounds.1(this, paramah2.view));
    return paramah1;
  }
  
  public final void a(ah paramah)
  {
    c(paramah);
  }
  
  public final void b(ah paramah)
  {
    c(paramah);
  }
  
  public final String[] getTransitionProperties()
  {
    return qo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.ChangeClipBounds
 * JD-Core Version:    0.7.0.1
 */
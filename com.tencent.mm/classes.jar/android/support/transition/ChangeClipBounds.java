package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeClipBounds
  extends Transition
{
  private static final String[] ps = { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(ai paramai)
  {
    Object localObject = paramai.view;
    if (((View)localObject).getVisibility() == 8) {}
    Rect localRect;
    do
    {
      return;
      localRect = q.an((View)localObject);
      paramai.values.put("android:clipBounds:clip", localRect);
    } while (localRect != null);
    localObject = new Rect(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
    paramai.values.put("android:clipBounds:bounds", localObject);
  }
  
  public final Animator a(ViewGroup paramViewGroup, ai paramai1, ai paramai2)
  {
    if ((paramai1 == null) || (paramai2 == null) || (!paramai1.values.containsKey("android:clipBounds:clip")) || (!paramai2.values.containsKey("android:clipBounds:clip"))) {
      paramViewGroup = null;
    }
    int i;
    do
    {
      return paramViewGroup;
      Object localObject = (Rect)paramai1.values.get("android:clipBounds:clip");
      Rect localRect = (Rect)paramai2.values.get("android:clipBounds:clip");
      if (localRect == null) {}
      for (i = 1; (localObject == null) && (localRect == null); i = 0) {
        return null;
      }
      if (localObject == null)
      {
        paramViewGroup = (Rect)paramai1.values.get("android:clipBounds:bounds");
        paramai1 = localRect;
      }
      while (paramViewGroup.equals(paramai1))
      {
        return null;
        paramViewGroup = (ViewGroup)localObject;
        paramai1 = localRect;
        if (localRect == null)
        {
          paramai1 = (Rect)paramai2.values.get("android:clipBounds:bounds");
          paramViewGroup = (ViewGroup)localObject;
        }
      }
      q.c(paramai2.view, paramViewGroup);
      localObject = new aa(new Rect());
      paramai1 = ObjectAnimator.ofObject(paramai2.view, av.tw, (TypeEvaluator)localObject, new Rect[] { paramViewGroup, paramai1 });
      paramViewGroup = paramai1;
    } while (i == 0);
    paramai1.addListener(new ChangeClipBounds.1(this, paramai2.view));
    return paramai1;
  }
  
  public final void a(ai paramai)
  {
    c(paramai);
  }
  
  public final void b(ai paramai)
  {
    c(paramai);
  }
  
  public final String[] getTransitionProperties()
  {
    return ps;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.ChangeClipBounds
 * JD-Core Version:    0.7.0.1
 */
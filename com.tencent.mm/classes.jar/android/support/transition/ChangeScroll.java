package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeScroll
  extends Transition
{
  private static final String[] Aw = { "android:changeScroll:x", "android:changeScroll:y" };
  
  public ChangeScroll() {}
  
  public ChangeScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(v paramv)
  {
    paramv.values.put("android:changeScroll:x", Integer.valueOf(paramv.view.getScrollX()));
    paramv.values.put("android:changeScroll:y", Integer.valueOf(paramv.view.getScrollY()));
  }
  
  public final Animator a(ViewGroup paramViewGroup, v paramv1, v paramv2)
  {
    if ((paramv1 == null) || (paramv2 == null)) {
      return null;
    }
    View localView = paramv2.view;
    int i = ((Integer)paramv1.values.get("android:changeScroll:x")).intValue();
    int j = ((Integer)paramv2.values.get("android:changeScroll:x")).intValue();
    int k = ((Integer)paramv1.values.get("android:changeScroll:y")).intValue();
    int m = ((Integer)paramv2.values.get("android:changeScroll:y")).intValue();
    if (i != j) {
      localView.setScrollX(i);
    }
    for (paramViewGroup = ObjectAnimator.ofInt(localView, "scrollX", new int[] { i, j });; paramViewGroup = null)
    {
      if (k != m) {
        localView.setScrollY(k);
      }
      for (paramv1 = ObjectAnimator.ofInt(localView, "scrollY", new int[] { k, m });; paramv1 = null) {
        return u.a(paramViewGroup, paramv1);
      }
    }
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
    return Aw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ChangeScroll
 * JD-Core Version:    0.7.0.1
 */
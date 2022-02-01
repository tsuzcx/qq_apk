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
  private static final String[] Aq = { "android:changeScroll:x", "android:changeScroll:y" };
  
  public ChangeScroll() {}
  
  public ChangeScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(u paramu)
  {
    paramu.values.put("android:changeScroll:x", Integer.valueOf(paramu.view.getScrollX()));
    paramu.values.put("android:changeScroll:y", Integer.valueOf(paramu.view.getScrollY()));
  }
  
  public final Animator a(ViewGroup paramViewGroup, u paramu1, u paramu2)
  {
    if ((paramu1 == null) || (paramu2 == null)) {
      return null;
    }
    View localView = paramu2.view;
    int i = ((Integer)paramu1.values.get("android:changeScroll:x")).intValue();
    int j = ((Integer)paramu2.values.get("android:changeScroll:x")).intValue();
    int k = ((Integer)paramu1.values.get("android:changeScroll:y")).intValue();
    int m = ((Integer)paramu2.values.get("android:changeScroll:y")).intValue();
    if (i != j) {
      localView.setScrollX(i);
    }
    for (paramViewGroup = ObjectAnimator.ofInt(localView, "scrollX", new int[] { i, j });; paramViewGroup = null)
    {
      if (k != m) {
        localView.setScrollY(k);
      }
      for (paramu1 = ObjectAnimator.ofInt(localView, "scrollY", new int[] { k, m });; paramu1 = null) {
        return t.a(paramViewGroup, paramu1);
      }
    }
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
    return Aq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ChangeScroll
 * JD-Core Version:    0.7.0.1
 */
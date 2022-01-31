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
  private static final String[] qc = { "android:changeScroll:x", "android:changeScroll:y" };
  
  public ChangeScroll() {}
  
  public ChangeScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(ai paramai)
  {
    paramai.values.put("android:changeScroll:x", Integer.valueOf(paramai.view.getScrollX()));
    paramai.values.put("android:changeScroll:y", Integer.valueOf(paramai.view.getScrollY()));
  }
  
  public final Animator a(ViewGroup paramViewGroup, ai paramai1, ai paramai2)
  {
    if ((paramai1 == null) || (paramai2 == null)) {
      return null;
    }
    View localView = paramai2.view;
    int i = ((Integer)paramai1.values.get("android:changeScroll:x")).intValue();
    int j = ((Integer)paramai2.values.get("android:changeScroll:x")).intValue();
    int k = ((Integer)paramai1.values.get("android:changeScroll:y")).intValue();
    int m = ((Integer)paramai2.values.get("android:changeScroll:y")).intValue();
    if (i != j) {
      localView.setScrollX(i);
    }
    for (paramViewGroup = ObjectAnimator.ofInt(localView, "scrollX", new int[] { i, j });; paramViewGroup = null)
    {
      if (k != m) {
        localView.setScrollY(k);
      }
      for (paramai1 = ObjectAnimator.ofInt(localView, "scrollY", new int[] { k, m });; paramai1 = null) {
        return ah.a(paramViewGroup, paramai1);
      }
    }
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
    return qc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.ChangeScroll
 * JD-Core Version:    0.7.0.1
 */
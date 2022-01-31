package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.transition.Transition;
import android.support.transition.ai;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

public final class e
  extends Transition
{
  private static void c(ai paramai)
  {
    if ((paramai.view instanceof TextView))
    {
      TextView localTextView = (TextView)paramai.view;
      paramai.values.put("android:textscale:scale", Float.valueOf(localTextView.getScaleX()));
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, ai paramai1, ai paramai2)
  {
    float f2 = 1.0F;
    if ((paramai1 == null) || (paramai2 == null) || (!(paramai1.view instanceof TextView)) || (!(paramai2.view instanceof TextView))) {
      return null;
    }
    paramViewGroup = (TextView)paramai2.view;
    paramai1 = paramai1.values;
    paramai2 = paramai2.values;
    if (paramai1.get("android:textscale:scale") != null) {}
    for (float f1 = ((Float)paramai1.get("android:textscale:scale")).floatValue();; f1 = 1.0F)
    {
      if (paramai2.get("android:textscale:scale") != null) {
        f2 = ((Float)paramai2.get("android:textscale:scale")).floatValue();
      }
      if (f1 != f2) {
        break;
      }
      return null;
    }
    paramai1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
    paramai1.addUpdateListener(new e.1(this, paramViewGroup));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.internal.e
 * JD-Core Version:    0.7.0.1
 */
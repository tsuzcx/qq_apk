package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class o
{
  final ArrayList<a> tH = new ArrayList();
  a tI = null;
  ValueAnimator tJ = null;
  private final Animator.AnimatorListener tK = new AnimatorListenerAdapter()
  {
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      if (o.this.tJ == paramAnonymousAnimator) {
        o.this.tJ = null;
      }
    }
  };
  
  public final void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new a(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.tK);
    this.tH.add(paramArrayOfInt);
  }
  
  static final class a
  {
    final ValueAnimator animator;
    final int[] tM;
    
    a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      this.tM = paramArrayOfInt;
      this.animator = paramValueAnimator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.o
 * JD-Core Version:    0.7.0.1
 */
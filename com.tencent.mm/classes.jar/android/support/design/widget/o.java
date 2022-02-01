package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class o
{
  final ArrayList<a> tO = new ArrayList();
  a tP = null;
  ValueAnimator tQ = null;
  private final Animator.AnimatorListener tR = new AnimatorListenerAdapter()
  {
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      if (o.this.tQ == paramAnonymousAnimator) {
        o.this.tQ = null;
      }
    }
  };
  
  public final void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new a(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.tR);
    this.tO.add(paramArrayOfInt);
  }
  
  static final class a
  {
    final ValueAnimator animator;
    final int[] tT;
    
    a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      this.tT = paramArrayOfInt;
      this.animator = paramValueAnimator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.o
 * JD-Core Version:    0.7.0.1
 */
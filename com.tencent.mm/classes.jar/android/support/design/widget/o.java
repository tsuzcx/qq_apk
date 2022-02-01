package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class o
{
  final ArrayList<a> rN = new ArrayList();
  a rO = null;
  ValueAnimator rP = null;
  private final Animator.AnimatorListener rQ = new AnimatorListenerAdapter()
  {
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      if (o.this.rP == paramAnonymousAnimator) {
        o.this.rP = null;
      }
    }
  };
  
  public final void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new a(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.rQ);
    this.rN.add(paramArrayOfInt);
  }
  
  static final class a
  {
    final int[] rS;
    final ValueAnimator rT;
    
    a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      this.rS = paramArrayOfInt;
      this.rT = paramValueAnimator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.o
 * JD-Core Version:    0.7.0.1
 */
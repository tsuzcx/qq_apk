package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class o
{
  final ArrayList<a> qN = new ArrayList();
  a qO = null;
  ValueAnimator qP = null;
  private final Animator.AnimatorListener qQ = new AnimatorListenerAdapter()
  {
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      if (o.this.qP == paramAnonymousAnimator) {
        o.this.qP = null;
      }
    }
  };
  
  public final void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new a(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.qQ);
    this.qN.add(paramArrayOfInt);
  }
  
  static final class a
  {
    final int[] qS;
    final ValueAnimator qT;
    
    a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      this.qS = paramArrayOfInt;
      this.qT = paramValueAnimator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.o
 * JD-Core Version:    0.7.0.1
 */
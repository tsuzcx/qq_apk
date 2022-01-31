package android.support.design.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import java.util.ArrayList;

final class m
{
  final ArrayList<m.a> jK = new ArrayList();
  m.a jL = null;
  ValueAnimator jM = null;
  private final Animator.AnimatorListener jN = new m.1(this);
  
  public final void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new m.a(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.jN);
    this.jK.add(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.m
 * JD-Core Version:    0.7.0.1
 */
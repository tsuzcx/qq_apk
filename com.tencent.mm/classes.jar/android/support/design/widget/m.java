package android.support.design.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import java.util.ArrayList;

final class m
{
  final ArrayList<m.a> kI = new ArrayList();
  m.a kJ = null;
  ValueAnimator kK = null;
  private final Animator.AnimatorListener kL = new m.1(this);
  
  public final void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new m.a(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.kL);
    this.kI.add(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.m
 * JD-Core Version:    0.7.0.1
 */
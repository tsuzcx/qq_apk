package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class i
{
  public final ArrayList<a> dvW;
  public a dvX;
  public ValueAnimator dvY;
  private final Animator.AnimatorListener dvZ;
  
  public i()
  {
    AppMethodBeat.i(209267);
    this.dvW = new ArrayList();
    this.dvX = null;
    this.dvY = null;
    this.dvZ = new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (i.this.dvY == paramAnonymousAnimator) {
          i.this.dvY = null;
        }
      }
    };
    AppMethodBeat.o(209267);
  }
  
  public final void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(209276);
    paramArrayOfInt = new a(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.dvZ);
    this.dvW.add(paramArrayOfInt);
    AppMethodBeat.o(209276);
  }
  
  public static final class a
  {
    public final ValueAnimator animator;
    public final int[] dwb;
    
    a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      this.dwb = paramArrayOfInt;
      this.animator = paramValueAnimator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.i
 * JD-Core Version:    0.7.0.1
 */
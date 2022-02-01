package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class i
{
  public final ArrayList<a> bCV;
  public a bCW;
  public ValueAnimator bCX;
  private final Animator.AnimatorListener bCY;
  
  public i()
  {
    AppMethodBeat.i(238190);
    this.bCV = new ArrayList();
    this.bCW = null;
    this.bCX = null;
    this.bCY = new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (i.this.bCX == paramAnonymousAnimator) {
          i.this.bCX = null;
        }
      }
    };
    AppMethodBeat.o(238190);
  }
  
  public final void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(238191);
    paramArrayOfInt = new a(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.bCY);
    this.bCV.add(paramArrayOfInt);
    AppMethodBeat.o(238191);
  }
  
  public static final class a
  {
    public final ValueAnimator animator;
    public final int[] bDa;
    
    a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      this.bDa = paramArrayOfInt;
      this.animator = paramValueAnimator;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.i
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import com.google.android.material.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class HideBottomViewOnScrollBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private int currentState = 2;
  private ViewPropertyAnimator dpb;
  private int height = 0;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(V paramV, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    AppMethodBeat.i(209914);
    this.dpb = paramV.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(209918);
        HideBottomViewOnScrollBehavior.a(HideBottomViewOnScrollBehavior.this);
        AppMethodBeat.o(209918);
      }
    });
    AppMethodBeat.o(209914);
  }
  
  public final boolean C(int paramInt)
  {
    return paramInt == 2;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    AppMethodBeat.i(209929);
    this.height = paramV.getMeasuredHeight();
    boolean bool = super.a(paramCoordinatorLayout, paramV, paramInt);
    AppMethodBeat.o(209929);
    return bool;
  }
  
  protected void cA(V paramV)
  {
    AppMethodBeat.i(209956);
    if (this.dpb != null)
    {
      this.dpb.cancel();
      paramV.clearAnimation();
    }
    this.currentState = 1;
    a(paramV, this.height, 175L, a.dns);
    AppMethodBeat.o(209956);
  }
  
  protected void cz(V paramV)
  {
    AppMethodBeat.i(209949);
    if (this.dpb != null)
    {
      this.dpb.cancel();
      paramV.clearAnimation();
    }
    this.currentState = 2;
    a(paramV, 0, 225L, a.dnt);
    AppMethodBeat.o(209949);
  }
  
  public final void m(V paramV, int paramInt)
  {
    AppMethodBeat.i(209942);
    if ((this.currentState != 1) && (paramInt > 0))
    {
      cA(paramV);
      AppMethodBeat.o(209942);
      return;
    }
    if ((this.currentState != 2) && (paramInt < 0)) {
      cz(paramV);
    }
    AppMethodBeat.o(209942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.behavior.HideBottomViewOnScrollBehavior
 * JD-Core Version:    0.7.0.1
 */
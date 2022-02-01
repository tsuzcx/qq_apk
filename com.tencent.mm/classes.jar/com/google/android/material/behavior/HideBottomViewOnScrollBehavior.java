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
  private ViewPropertyAnimator bvY;
  private int currentState = 2;
  private int height = 0;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(V paramV, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    AppMethodBeat.i(234853);
    this.bvY = paramV.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(234828);
        HideBottomViewOnScrollBehavior.a(HideBottomViewOnScrollBehavior.this);
        AppMethodBeat.o(234828);
      }
    });
    AppMethodBeat.o(234853);
  }
  
  public final boolean C(int paramInt)
  {
    return paramInt == 2;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    AppMethodBeat.i(234843);
    this.height = paramV.getMeasuredHeight();
    boolean bool = super.a(paramCoordinatorLayout, paramV, paramInt);
    AppMethodBeat.o(234843);
    return bool;
  }
  
  protected void cd(V paramV)
  {
    AppMethodBeat.i(234848);
    if (this.bvY != null)
    {
      this.bvY.cancel();
      paramV.clearAnimation();
    }
    this.currentState = 2;
    a(paramV, 0, 225L, a.bup);
    AppMethodBeat.o(234848);
  }
  
  protected void ce(V paramV)
  {
    AppMethodBeat.i(234850);
    if (this.bvY != null)
    {
      this.bvY.cancel();
      paramV.clearAnimation();
    }
    this.currentState = 1;
    a(paramV, this.height, 175L, a.buo);
    AppMethodBeat.o(234850);
  }
  
  public final void m(V paramV, int paramInt)
  {
    AppMethodBeat.i(234847);
    if ((this.currentState != 1) && (paramInt > 0))
    {
      ce(paramV);
      AppMethodBeat.o(234847);
      return;
    }
    if ((this.currentState != 2) && (paramInt < 0)) {
      cd(paramV);
    }
    AppMethodBeat.o(234847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.behavior.HideBottomViewOnScrollBehavior
 * JD-Core Version:    0.7.0.1
 */
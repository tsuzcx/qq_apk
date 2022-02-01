package android.support.design.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.design.a.a;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class HideBottomViewOnScrollBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private int currentState = 2;
  private ViewPropertyAnimator eh;
  private int height = 0;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(V paramV, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    this.eh = paramV.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        HideBottomViewOnScrollBehavior.a(HideBottomViewOnScrollBehavior.this);
      }
    });
  }
  
  public final boolean B(int paramInt)
  {
    return paramInt == 2;
  }
  
  public final void a(V paramV, int paramInt)
  {
    if ((this.currentState != 1) && (paramInt > 0)) {
      c(paramV);
    }
    while ((this.currentState == 2) || (paramInt >= 0)) {
      return;
    }
    b(paramV);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    this.height = paramV.getMeasuredHeight();
    return super.a(paramCoordinatorLayout, paramV, paramInt);
  }
  
  protected void b(V paramV)
  {
    if (this.eh != null)
    {
      this.eh.cancel();
      paramV.clearAnimation();
    }
    this.currentState = 2;
    a(paramV, 0, 225L, a.dS);
  }
  
  protected void c(V paramV)
  {
    if (this.eh != null)
    {
      this.eh.cancel();
      paramV.clearAnimation();
    }
    this.currentState = 1;
    a(paramV, this.height, 175L, a.dR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.behavior.HideBottomViewOnScrollBehavior
 * JD-Core Version:    0.7.0.1
 */
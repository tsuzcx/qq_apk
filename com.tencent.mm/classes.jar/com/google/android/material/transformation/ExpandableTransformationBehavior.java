package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class ExpandableTransformationBehavior
  extends ExpandableBehavior
{
  private AnimatorSet dAu;
  
  public ExpandableTransformationBehavior() {}
  
  public ExpandableTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.dAu != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.dAu.cancel();
      }
      this.dAu = b(paramView1, paramView2, paramBoolean1, bool);
      this.dAu.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(209932);
          ExpandableTransformationBehavior.a(ExpandableTransformationBehavior.this);
          AppMethodBeat.o(209932);
        }
      });
      this.dAu.start();
      if (!paramBoolean2) {
        this.dAu.end();
      }
      return true;
    }
  }
  
  protected abstract AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.transformation.ExpandableTransformationBehavior
 * JD-Core Version:    0.7.0.1
 */
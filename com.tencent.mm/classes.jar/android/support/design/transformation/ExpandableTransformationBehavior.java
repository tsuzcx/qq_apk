package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public abstract class ExpandableTransformationBehavior
  extends ExpandableBehavior
{
  private AnimatorSet my;
  
  public ExpandableTransformationBehavior() {}
  
  public ExpandableTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.my != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.my.cancel();
      }
      this.my = b(paramView1, paramView2, paramBoolean1, bool);
      this.my.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          ExpandableTransformationBehavior.a(ExpandableTransformationBehavior.this);
        }
      });
      this.my.start();
      if (!paramBoolean2) {
        this.my.end();
      }
      return true;
    }
  }
  
  protected abstract AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.transformation.ExpandableTransformationBehavior
 * JD-Core Version:    0.7.0.1
 */
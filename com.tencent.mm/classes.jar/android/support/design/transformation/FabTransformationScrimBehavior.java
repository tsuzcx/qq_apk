package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.a.b;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FabTransformationScrimBehavior
  extends ExpandableTransformationBehavior
{
  private final i mM = new i(75L);
  private final i mN = new i(0L);
  
  public FabTransformationScrimBehavior() {}
  
  public FabTransformationScrimBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramCoordinatorLayout, paramView, paramMotionEvent);
  }
  
  public final boolean a(View paramView1, View paramView2)
  {
    return paramView2 instanceof FloatingActionButton;
  }
  
  protected final AnimatorSet b(View paramView1, final View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    new ArrayList();
    if (paramBoolean1)
    {
      paramView1 = this.mM;
      if (!paramBoolean1) {
        break label110;
      }
      if (!paramBoolean2) {
        paramView2.setAlpha(0.0F);
      }
    }
    label110:
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView2, View.ALPHA, new float[] { 1.0F });; localObjectAnimator = ObjectAnimator.ofFloat(paramView2, View.ALPHA, new float[] { 0.0F }))
    {
      paramView1.a(localObjectAnimator);
      localArrayList.add(localObjectAnimator);
      paramView1 = new AnimatorSet();
      b.a(paramView1, localArrayList);
      paramView1.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (!paramBoolean1) {
            paramView2.setVisibility(4);
          }
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          if (paramBoolean1) {
            paramView2.setVisibility(0);
          }
        }
      });
      return paramView1;
      paramView1 = this.mN;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.transformation.FabTransformationScrimBehavior
 * JD-Core Version:    0.7.0.1
 */
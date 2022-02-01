package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

final class x
{
  static Animator a(View paramView, v paramv, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, TimeInterpolator paramTimeInterpolator)
  {
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    Object localObject = (int[])paramv.view.getTag(2131309398);
    if (localObject != null)
    {
      paramFloat1 = localObject[0] - paramInt1 + f1;
      paramFloat2 = localObject[1] - paramInt2 + f2;
    }
    int i = Math.round(paramFloat1 - f1);
    int j = Math.round(paramFloat2 - f2);
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    if ((paramFloat1 == paramFloat3) && (paramFloat2 == paramFloat4)) {
      return null;
    }
    localObject = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[] { paramFloat1, paramFloat3 }), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { paramFloat2, paramFloat4 }) });
    paramView = new a(paramView, paramv.view, paramInt1 + i, paramInt2 + j, f1, f2);
    ((ObjectAnimator)localObject).addListener(paramView);
    a.a((Animator)localObject, paramView);
    ((ObjectAnimator)localObject).setInterpolator(paramTimeInterpolator);
    return localObject;
  }
  
  static final class a
    extends AnimatorListenerAdapter
  {
    private final View Dk;
    private final View Dl;
    private final int Dm;
    private final int Dn;
    private int[] Do;
    private float Dp;
    private float Dq;
    private final float Dr;
    private final float Ds;
    
    a(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      this.Dl = paramView1;
      this.Dk = paramView2;
      this.Dm = (paramInt1 - Math.round(this.Dl.getTranslationX()));
      this.Dn = (paramInt2 - Math.round(this.Dl.getTranslationY()));
      this.Dr = paramFloat1;
      this.Ds = paramFloat2;
      this.Do = ((int[])this.Dk.getTag(2131309398));
      if (this.Do != null) {
        this.Dk.setTag(2131309398, null);
      }
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      if (this.Do == null) {
        this.Do = new int[2];
      }
      this.Do[0] = Math.round(this.Dm + this.Dl.getTranslationX());
      this.Do[1] = Math.round(this.Dn + this.Dl.getTranslationY());
      this.Dk.setTag(2131309398, this.Do);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      this.Dl.setTranslationX(this.Dr);
      this.Dl.setTranslationY(this.Ds);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      this.Dp = this.Dl.getTranslationX();
      this.Dq = this.Dl.getTranslationY();
      this.Dl.setTranslationX(this.Dr);
      this.Dl.setTranslationY(this.Ds);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      this.Dl.setTranslationX(this.Dp);
      this.Dl.setTranslationY(this.Dq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.x
 * JD-Core Version:    0.7.0.1
 */
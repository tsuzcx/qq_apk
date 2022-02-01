package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y
{
  static Animator a(View paramView, w paramw, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, TimeInterpolator paramTimeInterpolator)
  {
    AppMethodBeat.i(193085);
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    Object localObject = (int[])paramw.view.getTag(m.a.transition_position);
    if (localObject != null)
    {
      paramFloat1 = localObject[0] - paramInt1 + f1;
      paramFloat2 = localObject[1] - paramInt2 + f2;
    }
    int i = Math.round(paramFloat1 - f1);
    int j = Math.round(paramFloat2 - f2);
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    if ((paramFloat1 == paramFloat3) && (paramFloat2 == paramFloat4))
    {
      AppMethodBeat.o(193085);
      return null;
    }
    localObject = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[] { paramFloat1, paramFloat3 }), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { paramFloat2, paramFloat4 }) });
    paramView = new a(paramView, paramw.view, paramInt1 + i, paramInt2 + j, f1, f2);
    ((ObjectAnimator)localObject).addListener(paramView);
    a.a((Animator)localObject, paramView);
    ((ObjectAnimator)localObject).setInterpolator(paramTimeInterpolator);
    AppMethodBeat.o(193085);
    return localObject;
  }
  
  static final class a
    extends AnimatorListenerAdapter
  {
    private final View asC;
    private final View asD;
    private final int asE;
    private final int asF;
    private int[] asG;
    private float asH;
    private float asI;
    private final float asJ;
    private final float asK;
    
    a(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(193068);
      this.asD = paramView1;
      this.asC = paramView2;
      this.asE = (paramInt1 - Math.round(this.asD.getTranslationX()));
      this.asF = (paramInt2 - Math.round(this.asD.getTranslationY()));
      this.asJ = paramFloat1;
      this.asK = paramFloat2;
      this.asG = ((int[])this.asC.getTag(m.a.transition_position));
      if (this.asG != null) {
        this.asC.setTag(m.a.transition_position, null);
      }
      AppMethodBeat.o(193068);
    }
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(193071);
      if (this.asG == null) {
        this.asG = new int[2];
      }
      this.asG[0] = Math.round(this.asE + this.asD.getTranslationX());
      this.asG[1] = Math.round(this.asF + this.asD.getTranslationY());
      this.asC.setTag(m.a.transition_position, this.asG);
      AppMethodBeat.o(193071);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(193073);
      this.asD.setTranslationX(this.asJ);
      this.asD.setTranslationY(this.asK);
      AppMethodBeat.o(193073);
    }
    
    public final void onAnimationPause(Animator paramAnimator)
    {
      AppMethodBeat.i(193075);
      this.asH = this.asD.getTranslationX();
      this.asI = this.asD.getTranslationY();
      this.asD.setTranslationX(this.asJ);
      this.asD.setTranslationY(this.asK);
      AppMethodBeat.o(193075);
    }
    
    public final void onAnimationResume(Animator paramAnimator)
    {
      AppMethodBeat.i(193077);
      this.asD.setTranslationX(this.asH);
      this.asD.setTranslationY(this.asI);
      AppMethodBeat.o(193077);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.transition.y
 * JD-Core Version:    0.7.0.1
 */
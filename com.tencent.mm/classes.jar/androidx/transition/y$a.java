package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y$a
  extends AnimatorListenerAdapter
{
  private final View chl;
  private final View chm;
  private final int chn;
  private final int cho;
  private int[] chp;
  private float chq;
  private float chr;
  private final float chs;
  private final float cht;
  
  y$a(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(201502);
    this.chm = paramView1;
    this.chl = paramView2;
    this.chn = (paramInt1 - Math.round(this.chm.getTranslationX()));
    this.cho = (paramInt2 - Math.round(this.chm.getTranslationY()));
    this.chs = paramFloat1;
    this.cht = paramFloat2;
    this.chp = ((int[])this.chl.getTag(m.a.transition_position));
    if (this.chp != null) {
      this.chl.setTag(m.a.transition_position, null);
    }
    AppMethodBeat.o(201502);
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(201511);
    if (this.chp == null) {
      this.chp = new int[2];
    }
    this.chp[0] = Math.round(this.chn + this.chm.getTranslationX());
    this.chp[1] = Math.round(this.cho + this.chm.getTranslationY());
    this.chl.setTag(m.a.transition_position, this.chp);
    AppMethodBeat.o(201511);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(201519);
    this.chm.setTranslationX(this.chs);
    this.chm.setTranslationY(this.cht);
    AppMethodBeat.o(201519);
  }
  
  public final void onAnimationPause(Animator paramAnimator)
  {
    AppMethodBeat.i(201529);
    this.chq = this.chm.getTranslationX();
    this.chr = this.chm.getTranslationY();
    this.chm.setTranslationX(this.chs);
    this.chm.setTranslationY(this.cht);
    AppMethodBeat.o(201529);
  }
  
  public final void onAnimationResume(Animator paramAnimator)
  {
    AppMethodBeat.i(201536);
    this.chm.setTranslationX(this.chq);
    this.chm.setTranslationY(this.chr);
    AppMethodBeat.o(201536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.transition.y.a
 * JD-Core Version:    0.7.0.1
 */
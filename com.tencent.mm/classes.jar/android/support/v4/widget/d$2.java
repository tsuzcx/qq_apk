package android.support.v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class d$2
  implements Animator.AnimatorListener
{
  d$2(d paramd, d.a parama) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator) {}
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    this.IT.a(1.0F, this.IS, true);
    this.IS.dS();
    d.a locala = this.IS;
    locala.aD(locala.dQ());
    if (this.IT.IR)
    {
      this.IT.IR = false;
      paramAnimator.cancel();
      paramAnimator.setDuration(1332L);
      paramAnimator.start();
      this.IS.I(false);
      return;
    }
    this.IT.IQ += 1.0F;
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    this.IT.IQ = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.widget.d.2
 * JD-Core Version:    0.7.0.1
 */
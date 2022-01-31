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
    d.a(this.Jk, 1.0F, this.Jj, true);
    this.Jj.dB();
    d.a locala = this.Jj;
    locala.aG(locala.dz());
    if (d.a(this.Jk))
    {
      d.b(this.Jk);
      paramAnimator.cancel();
      paramAnimator.setDuration(1332L);
      paramAnimator.start();
      this.Jj.J(false);
      return;
    }
    d.a(this.Jk, d.c(this.Jk) + 1.0F);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    d.a(this.Jk, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.widget.d.2
 * JD-Core Version:    0.7.0.1
 */
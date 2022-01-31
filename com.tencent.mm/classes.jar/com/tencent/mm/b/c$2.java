package com.tencent.mm.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c$2
  implements Animator.AnimatorListener
{
  public c$2(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    this.bVJ.bVC = true;
    this.bVJ.bVH = 0.0F;
    this.bVJ.bVI = 0.0F;
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    this.bVJ.bVC = true;
    this.bVJ.bVH = 0.0F;
    this.bVJ.bVI = 0.0F;
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(116142);
    this.bVJ.bVC = false;
    this.bVJ.bVH = 0.0F;
    this.bVJ.bVI = 0.0F;
    ab.d("MicroMsg.StickBackAnim", "onAnimationStart");
    AppMethodBeat.o(116142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.b.c.2
 * JD-Core Version:    0.7.0.1
 */
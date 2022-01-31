package com.tencent.mm.e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c$9
  implements Animator.AnimatorListener
{
  public c$9(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(116165);
    ab.i("MicroMsg.CropArtist", "onAnimationEnd");
    c.f(this.cdH);
    if (c.g(this.cdH) == 0)
    {
      c.b(this.cdH, false);
      paramAnimator = new RectF();
      paramAnimator.set(c.d(this.cdH));
      c.e(this.cdH).mapRect(paramAnimator);
      c.e(this.cdH).reset();
      c.d(this.cdH).set((int)paramAnimator.left, (int)paramAnimator.top, (int)paramAnimator.right, (int)paramAnimator.bottom);
      this.cdH.CL();
    }
    c.a(this.cdH, 200L, false, true);
    AppMethodBeat.o(116165);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(116164);
    c.a(this.cdH, false);
    this.cdH.cdv = true;
    c.b(this.cdH, true);
    AppMethodBeat.o(116164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.c.9
 * JD-Core Version:    0.7.0.1
 */
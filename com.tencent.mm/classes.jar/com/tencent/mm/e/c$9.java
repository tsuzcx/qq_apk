package com.tencent.mm.e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mm.sdk.platformtools.y;

public final class c$9
  implements Animator.AnimatorListener
{
  public c$9(c paramc) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.i("MicroMsg.CropArtist", "onAnimationEnd");
    c.f(this.bAK);
    if (c.g(this.bAK) == 0)
    {
      c.b(this.bAK, false);
      paramAnimator = new RectF();
      paramAnimator.set(c.d(this.bAK));
      c.e(this.bAK).mapRect(paramAnimator);
      c.e(this.bAK).reset();
      c.d(this.bAK).set((int)paramAnimator.left, (int)paramAnimator.top, (int)paramAnimator.right, (int)paramAnimator.bottom);
      this.bAK.tT();
    }
    c.a(this.bAK, 200L, false, true);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    c.a(this.bAK, false);
    this.bAK.bAy = true;
    c.b(this.bAK, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.c.9
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.sdk.platformtools.y;

final class a$9
  implements Animator.AnimatorListener
{
  a$9(a parama, b.m paramm) {}
  
  public final void onAnimationCancel(Animator paramAnimator) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    y.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator end");
    if (this.gue != null) {
      this.gue.df(true);
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    y.d("MicroMsg.DefaultTencentMapView", "MarkerAnimator start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.9
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.nearby.guide;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/guide/TabLayoutScrollGuideHelper;", "Landroid/animation/Animator$AnimatorListener;", "()V", "animationSet", "Landroid/animation/AnimatorSet;", "first", "Landroid/animation/ValueAnimator;", "lastActionX", "", "lastActionY", "repeatCount", "second", "targetView", "Landroid/view/View;", "targetViewPos", "", "cancel", "", "createTouchEvent", "Landroid/view/MotionEvent;", "x", "", "y", "actionType", "onAnimationCancel", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onMoveAction", "", "setTargetView", "start", "delayMs", "", "Companion", "plugin-finder_release"})
public final class a
  implements Animator.AnimatorListener
{
  public static final a uQB;
  private final int repeatCount;
  public View targetView;
  public ValueAnimator uQA;
  public int[] uQv;
  private int uQw;
  private int uQx;
  public AnimatorSet uQy;
  public ValueAnimator uQz;
  
  static
  {
    AppMethodBeat.i(249024);
    uQB = new a((byte)0);
    AppMethodBeat.o(249024);
  }
  
  public a()
  {
    AppMethodBeat.i(249023);
    this.uQv = new int[2];
    this.repeatCount = 1;
    AppMethodBeat.o(249023);
  }
  
  private static MotionEvent d(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(249022);
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), paramInt, paramFloat1, paramFloat2, 0);
    p.g(localMotionEvent, "MotionEvent.obtain(Syste…     actionType, x, y, 0)");
    AppMethodBeat.o(249022);
    return localMotionEvent;
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(249020);
    paramAnimator = this.targetView;
    if (paramAnimator != null) {
      paramAnimator.onTouchEvent(d(this.uQw, this.uQx, 1));
    }
    Log.i("TabLayoutScrollGuideHelper", "onAnimationCancel");
    AppMethodBeat.o(249020);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(249019);
    paramAnimator = this.targetView;
    if (paramAnimator != null) {
      paramAnimator.onTouchEvent(d(this.uQw, this.uQx, 1));
    }
    Log.i("TabLayoutScrollGuideHelper", "onAnimationEnd");
    AppMethodBeat.o(249019);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(249021);
    Log.i("TabLayoutScrollGuideHelper", "onAnimationRepeat");
    AppMethodBeat.o(249021);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(249018);
    Log.i("TabLayoutScrollGuideHelper", "onAnimationStart");
    this.uQw = this.uQv[0];
    this.uQx = this.uQv[1];
    paramAnimator = this.targetView;
    if (paramAnimator != null)
    {
      paramAnimator.onTouchEvent(d(this.uQw, this.uQx, 0));
      AppMethodBeat.o(249018);
      return;
    }
    AppMethodBeat.o(249018);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/guide/TabLayoutScrollGuideHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "onAnimationUpdate"})
  public static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    public b(a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(249016);
      if (paramValueAnimator != null)
      {
        a locala = this.uQC;
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        p.g(paramValueAnimator, "it.animatedValue");
        a.a(locala, paramValueAnimator, Float.valueOf(0.0F));
        AppMethodBeat.o(249016);
        return;
      }
      AppMethodBeat.o(249016);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "onAnimationUpdate"})
  public static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    public c(a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(249017);
      if (paramValueAnimator != null)
      {
        a locala = this.uQC;
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        p.g(paramValueAnimator, "it.animatedValue");
        a.a(locala, paramValueAnimator, Float.valueOf(0.0F));
        AppMethodBeat.o(249017);
        return;
      }
      AppMethodBeat.o(249017);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.guide.a
 * JD-Core Version:    0.7.0.1
 */
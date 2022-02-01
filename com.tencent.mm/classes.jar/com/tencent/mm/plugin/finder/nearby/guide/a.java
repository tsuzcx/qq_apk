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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/guide/TabLayoutScrollGuideHelper;", "Landroid/animation/Animator$AnimatorListener;", "()V", "animationSet", "Landroid/animation/AnimatorSet;", "first", "Landroid/animation/ValueAnimator;", "lastActionX", "", "lastActionY", "repeatCount", "second", "targetView", "Landroid/view/View;", "targetViewPos", "", "cancel", "", "createTouchEvent", "Landroid/view/MotionEvent;", "x", "", "y", "actionType", "onAnimationCancel", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onMoveAction", "", "setTargetView", "start", "delayMs", "", "Companion", "plugin-finder-nearby_release"})
public final class a
  implements Animator.AnimatorListener
{
  public static final a zDM;
  private final int buA;
  public View kJL;
  public int[] zDG;
  private int zDH;
  private int zDI;
  public AnimatorSet zDJ;
  public ValueAnimator zDK;
  public ValueAnimator zDL;
  
  static
  {
    AppMethodBeat.i(200904);
    zDM = new a((byte)0);
    AppMethodBeat.o(200904);
  }
  
  public a()
  {
    AppMethodBeat.i(200903);
    this.zDG = new int[2];
    this.buA = 1;
    AppMethodBeat.o(200903);
  }
  
  private static MotionEvent e(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(200901);
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), paramInt, paramFloat1, paramFloat2, 0);
    p.j(localMotionEvent, "MotionEvent.obtain(Syste…     actionType, x, y, 0)");
    AppMethodBeat.o(200901);
    return localMotionEvent;
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(200897);
    paramAnimator = this.kJL;
    if (paramAnimator != null) {
      paramAnimator.onTouchEvent(e(this.zDH, this.zDI, 1));
    }
    Log.i("TabLayoutScrollGuideHelper", "onAnimationCancel");
    AppMethodBeat.o(200897);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(200894);
    paramAnimator = this.kJL;
    if (paramAnimator != null) {
      paramAnimator.onTouchEvent(e(this.zDH, this.zDI, 1));
    }
    Log.i("TabLayoutScrollGuideHelper", "onAnimationEnd");
    AppMethodBeat.o(200894);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    AppMethodBeat.i(200899);
    Log.i("TabLayoutScrollGuideHelper", "onAnimationRepeat");
    AppMethodBeat.o(200899);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(200892);
    Log.i("TabLayoutScrollGuideHelper", "onAnimationStart");
    this.zDH = this.zDG[0];
    this.zDI = this.zDG[1];
    paramAnimator = this.kJL;
    if (paramAnimator != null)
    {
      paramAnimator.onTouchEvent(e(this.zDH, this.zDI, 0));
      AppMethodBeat.o(200892);
      return;
    }
    AppMethodBeat.o(200892);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/guide/TabLayoutScrollGuideHelper$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "onAnimationUpdate"})
  public static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    public b(a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(202206);
      if (paramValueAnimator != null)
      {
        a locala = this.zDN;
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        p.j(paramValueAnimator, "it.animatedValue");
        a.a(locala, paramValueAnimator, Float.valueOf(0.0F));
        AppMethodBeat.o(202206);
        return;
      }
      AppMethodBeat.o(202206);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "onAnimationUpdate"})
  public static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    public c(a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(199849);
      if (paramValueAnimator != null)
      {
        a locala = this.zDN;
        paramValueAnimator = paramValueAnimator.getAnimatedValue();
        p.j(paramValueAnimator, "it.animatedValue");
        a.a(locala, paramValueAnimator, Float.valueOf(0.0F));
        AppMethodBeat.o(199849);
        return;
      }
      AppMethodBeat.o(199849);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.guide.a
 * JD-Core Version:    0.7.0.1
 */
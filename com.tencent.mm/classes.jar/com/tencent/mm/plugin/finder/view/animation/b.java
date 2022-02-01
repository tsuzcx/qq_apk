package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/animation/FavAnimationHelper;", "", "()V", "animRunnable", "Ljava/lang/Runnable;", "animatorAlpha", "Landroid/animation/ValueAnimator;", "reset", "", "view", "Landroid/view/View;", "start", "plugin-finder_release"})
public final class b
{
  private static final Runnable sXs;
  public static ValueAnimator sXt;
  public static final b sXu;
  
  static
  {
    AppMethodBeat.i(205318);
    sXu = new b();
    sXs = (Runnable)a.sXv;
    AppMethodBeat.o(205318);
  }
  
  public static void ei(View paramView)
  {
    AppMethodBeat.i(205317);
    paramView.setVisibility(8);
    paramView.removeCallbacks(sXs);
    paramView = sXt;
    if (paramView != null)
    {
      paramView.cancel();
      AppMethodBeat.o(205317);
      return;
    }
    AppMethodBeat.o(205317);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a sXv;
    
    static
    {
      AppMethodBeat.i(205313);
      sXv = new a();
      AppMethodBeat.o(205313);
    }
    
    public final void run()
    {
      AppMethodBeat.i(205312);
      Object localObject = b.sXu;
      localObject = b.cNH();
      if (localObject != null)
      {
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(205312);
        return;
      }
      AppMethodBeat.o(205312);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$2$1"})
  public static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    public b(View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(205314);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("alpha");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(205314);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      ad.d("LikeIconAnimationHelper", "alpha=".concat(String.valueOf(f)));
      this.sXw.setAlpha(f);
      if (f == 0.0F)
      {
        this.sXw.setVisibility(8);
        this.sXw.clearAnimation();
        this.sXw.setAlpha(1.0F);
      }
      AppMethodBeat.o(205314);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public c(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205315);
      paramAnimator = this.kAn;
      b localb = b.sXu;
      paramAnimator.postDelayed(b.cNG(), 1000L);
      AppMethodBeat.o(205315);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(205316);
      this.kAn.setVisibility(0);
      this.kAn.setAlpha(1.0F);
      AppMethodBeat.o(205316);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.b
 * JD-Core Version:    0.7.0.1
 */
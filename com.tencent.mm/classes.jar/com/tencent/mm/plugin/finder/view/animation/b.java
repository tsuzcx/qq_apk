package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/animation/FavAnimationHelper;", "", "()V", "animRunnable", "Ljava/lang/Runnable;", "animatorAlpha", "Landroid/animation/ValueAnimator;", "reset", "", "view", "Landroid/view/View;", "start", "plugin-finder_release"})
public final class b
{
  private static final Runnable tiG;
  public static ValueAnimator tiH;
  public static final b tiI;
  
  static
  {
    AppMethodBeat.i(205960);
    tiI = new b();
    tiG = (Runnable)a.tiJ;
    AppMethodBeat.o(205960);
  }
  
  public static void ei(View paramView)
  {
    AppMethodBeat.i(205959);
    paramView.setVisibility(8);
    paramView.removeCallbacks(tiG);
    paramView = tiH;
    if (paramView != null)
    {
      paramView.cancel();
      AppMethodBeat.o(205959);
      return;
    }
    AppMethodBeat.o(205959);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a tiJ;
    
    static
    {
      AppMethodBeat.i(205955);
      tiJ = new a();
      AppMethodBeat.o(205955);
    }
    
    public final void run()
    {
      AppMethodBeat.i(205954);
      Object localObject = b.tiI;
      localObject = b.cQr();
      if (localObject != null)
      {
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(205954);
        return;
      }
      AppMethodBeat.o(205954);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$2$1"})
  public static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    public b(View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(205956);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("alpha");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(205956);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      ae.d("LikeIconAnimationHelper", "alpha=".concat(String.valueOf(f)));
      this.tiK.setAlpha(f);
      if (f == 0.0F)
      {
        this.tiK.setVisibility(8);
        this.tiK.clearAnimation();
        this.tiK.setAlpha(1.0F);
      }
      AppMethodBeat.o(205956);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public c(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205957);
      paramAnimator = this.kDC;
      b localb = b.tiI;
      paramAnimator.postDelayed(b.cQq(), 1000L);
      AppMethodBeat.o(205957);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(205958);
      this.kDC.setVisibility(0);
      this.kDC.setAlpha(1.0F);
      AppMethodBeat.o(205958);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.b
 * JD-Core Version:    0.7.0.1
 */
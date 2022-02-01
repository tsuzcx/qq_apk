package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/animation/FavAnimationHelper;", "", "()V", "animRunnable", "Ljava/lang/Runnable;", "animatorAlpha", "Landroid/animation/ValueAnimator;", "reset", "", "view", "Landroid/view/View;", "start", "plugin-finder_release"})
public final class b
{
  private static final Runnable BdA;
  private static ValueAnimator BdB;
  public static final b BdC;
  
  static
  {
    AppMethodBeat.i(275159);
    BdC = new b();
    BdA = (Runnable)a.BdD;
    AppMethodBeat.o(275159);
  }
  
  public static void eT(View paramView)
  {
    AppMethodBeat.i(275157);
    p.k(paramView, "view");
    paramView.setVisibility(8);
    paramView.removeCallbacks(BdA);
    Object localObject1 = BdB;
    if (localObject1 != null) {
      ((ValueAnimator)localObject1).cancel();
    }
    localObject1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { a.fromDPToPix(paramView.getContext(), 32), 0.0F });
    p.j(localObject1, "animatorY");
    ((ObjectAnimator)localObject1).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    ((ObjectAnimator)localObject1).setDuration(300L);
    if (BdB == null)
    {
      BdB = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 1.0F, 0.0F }) });
      localObject2 = x.aazN;
    }
    Object localObject2 = BdB;
    if (localObject2 != null) {
      ((ValueAnimator)localObject2).setDuration(300L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(paramView));
    }
    ((ObjectAnimator)localObject1).addListener((Animator.AnimatorListener)new c(paramView));
    ((ObjectAnimator)localObject1).start();
    AppMethodBeat.o(275157);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a BdD;
    
    static
    {
      AppMethodBeat.i(287302);
      BdD = new a();
      AppMethodBeat.o(287302);
    }
    
    public final void run()
    {
      AppMethodBeat.i(287301);
      Object localObject = b.BdC;
      localObject = b.ejB();
      if (localObject != null)
      {
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(287301);
        return;
      }
      AppMethodBeat.o(287301);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$2$1"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(259100);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("alpha");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(259100);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      Log.d("LikeIconAnimationHelper", "alpha=".concat(String.valueOf(f)));
      this.xkM.setAlpha(f);
      if (f == 0.0F)
      {
        this.xkM.setVisibility(8);
        this.xkM.clearAnimation();
        this.xkM.setAlpha(1.0F);
      }
      AppMethodBeat.o(259100);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    c(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(287160);
      paramAnimator = this.kqJ;
      b localb = b.BdC;
      paramAnimator.postDelayed(b.ejA(), 1000L);
      AppMethodBeat.o(287160);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(287161);
      this.kqJ.setVisibility(0);
      this.kqJ.setAlpha(1.0F);
      AppMethodBeat.o(287161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.b
 * JD-Core Version:    0.7.0.1
 */
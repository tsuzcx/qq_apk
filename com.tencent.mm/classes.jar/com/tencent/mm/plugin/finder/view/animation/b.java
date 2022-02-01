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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/animation/FavAnimationHelper;", "", "()V", "animRunnable", "Ljava/lang/Runnable;", "animatorAlpha", "Landroid/animation/ValueAnimator;", "reset", "", "view", "Landroid/view/View;", "start", "plugin-finder_release"})
public final class b
{
  private static final Runnable wrw;
  private static ValueAnimator wrx;
  public static final b wry;
  
  static
  {
    AppMethodBeat.i(255163);
    wry = new b();
    wrw = (Runnable)a.wrz;
    AppMethodBeat.o(255163);
  }
  
  public static void ei(View paramView)
  {
    AppMethodBeat.i(255162);
    p.h(paramView, "view");
    paramView.setVisibility(8);
    paramView.removeCallbacks(wrw);
    Object localObject1 = wrx;
    if (localObject1 != null) {
      ((ValueAnimator)localObject1).cancel();
    }
    localObject1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { a.fromDPToPix(paramView.getContext(), 32), 0.0F });
    p.g(localObject1, "animatorY");
    ((ObjectAnimator)localObject1).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    ((ObjectAnimator)localObject1).setDuration(300L);
    if (wrx == null)
    {
      wrx = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 1.0F, 0.0F }) });
      localObject2 = x.SXb;
    }
    Object localObject2 = wrx;
    if (localObject2 != null) {
      ((ValueAnimator)localObject2).setDuration(300L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(paramView));
    }
    ((ObjectAnimator)localObject1).addListener((Animator.AnimatorListener)new c(paramView));
    ((ObjectAnimator)localObject1).start();
    AppMethodBeat.o(255162);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a wrz;
    
    static
    {
      AppMethodBeat.i(255158);
      wrz = new a();
      AppMethodBeat.o(255158);
    }
    
    public final void run()
    {
      AppMethodBeat.i(255157);
      Object localObject = b.wry;
      localObject = b.dHq();
      if (localObject != null)
      {
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(255157);
        return;
      }
      AppMethodBeat.o(255157);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$2$1"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(255159);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("alpha");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(255159);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      Log.d("LikeIconAnimationHelper", "alpha=".concat(String.valueOf(f)));
      this.tBN.setAlpha(f);
      if (f == 0.0F)
      {
        this.tBN.setVisibility(8);
        this.tBN.clearAnimation();
        this.tBN.setAlpha(1.0F);
      }
      AppMethodBeat.o(255159);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    c(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(255160);
      paramAnimator = this.hCI;
      b localb = b.wry;
      paramAnimator.postDelayed(b.dHp(), 1000L);
      AppMethodBeat.o(255160);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(255161);
      this.hCI.setVisibility(0);
      this.hCI.setAlpha(1.0F);
      AppMethodBeat.o(255161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.b
 * JD-Core Version:    0.7.0.1
 */
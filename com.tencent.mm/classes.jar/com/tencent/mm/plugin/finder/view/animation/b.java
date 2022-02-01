package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/animation/FavAnimationHelper;", "", "()V", "animRunnable", "Ljava/lang/Runnable;", "animatorAlpha", "Landroid/animation/ValueAnimator;", "reset", "", "view", "Landroid/view/View;", "start", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b GGl;
  private static final Runnable GGm;
  private static ValueAnimator GGn;
  
  static
  {
    AppMethodBeat.i(346003);
    GGl = new b();
    GGm = b..ExternalSyntheticLambda1.INSTANCE;
    AppMethodBeat.o(346003);
  }
  
  private static final void b(View paramView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(345985);
    s.u(paramView, "$view");
    paramValueAnimator = paramValueAnimator.getAnimatedValue("alpha");
    if (paramValueAnimator == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(345985);
      throw paramView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    Log.d("LikeIconAnimationHelper", s.X("alpha=", Float.valueOf(f)));
    paramView.setAlpha(f);
    if (f == 0.0F) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramView.setVisibility(8);
        paramView.clearAnimation();
        paramView.setAlpha(1.0F);
      }
      AppMethodBeat.o(345985);
      return;
    }
  }
  
  private static final void flN()
  {
    AppMethodBeat.i(345973);
    ValueAnimator localValueAnimator = GGn;
    if (localValueAnimator != null) {
      localValueAnimator.start();
    }
    AppMethodBeat.o(345973);
  }
  
  public static void hd(View paramView)
  {
    AppMethodBeat.i(345954);
    s.u(paramView, "view");
    paramView.setVisibility(8);
    paramView.removeCallbacks(GGm);
    Object localObject = GGn;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    localObject = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { a.fromDPToPix(paramView.getContext(), 32), 0.0F });
    ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    ((ObjectAnimator)localObject).setDuration(300L);
    if (GGn == null) {
      GGn = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("alpha", new float[] { 1.0F, 0.0F }) });
    }
    ValueAnimator localValueAnimator = GGn;
    if (localValueAnimator != null) {
      localValueAnimator.setDuration(300L).addUpdateListener(new b..ExternalSyntheticLambda0(paramView));
    }
    ((ObjectAnimator)localObject).addListener((Animator.AnimatorListener)new a(paramView));
    ((ObjectAnimator)localObject).start();
    AppMethodBeat.o(345954);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/animation/FavAnimationHelper$start$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Animator.AnimatorListener
  {
    a(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(345957);
      this.$view.postDelayed(b.flO(), 1000L);
      AppMethodBeat.o(345957);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(345967);
      this.$view.setVisibility(0);
      this.$view.setAlpha(1.0F);
      AppMethodBeat.o(345967);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.b
 * JD-Core Version:    0.7.0.1
 */
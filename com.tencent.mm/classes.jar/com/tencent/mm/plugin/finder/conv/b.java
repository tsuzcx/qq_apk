package com.tencent.mm.plugin.finder.conv;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/conv/FinderConversation;)V", "getConv", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getView", "()Landroid/view/View;", "run", "", "plugin-finder_release"})
public final class b
  implements Runnable
{
  final c rLj;
  final View view;
  
  public b(View paramView, c paramc)
  {
    AppMethodBeat.i(201259);
    this.view = paramView;
    this.rLj = paramc;
    AppMethodBeat.o(201259);
  }
  
  public final void run()
  {
    AppMethodBeat.i(201258);
    this.view.setSelected(false);
    final Drawable localDrawable = this.view.getContext().getDrawable(2131100551);
    if (localDrawable == null) {
      p.gfZ();
    }
    this.view.setBackground(localDrawable);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 240 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this, localDrawable));
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener((Animator.AnimatorListener)new b(this, localDrawable));
    localValueAnimator.start();
    AppMethodBeat.o(201258);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim$run$animator$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(b paramb, Drawable paramDrawable) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(201255);
      Drawable localDrawable = localDrawable;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(201255);
        throw paramValueAnimator;
      }
      localDrawable.setAlpha(255 - ((Integer)paramValueAnimator).intValue());
      AppMethodBeat.o(201255);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim$run$animator$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    b(b paramb, Drawable paramDrawable) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(201257);
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(201257);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(201256);
      localDrawable.setAlpha(255);
      paramAnimator = this.rLk.view;
      if (this.rLk.rLj.cyT()) {}
      for (int i = 2131232872;; i = 2131231818)
      {
        paramAnimator.setBackgroundResource(i);
        AppMethodBeat.o(201256);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.b
 * JD-Core Version:    0.7.0.1
 */
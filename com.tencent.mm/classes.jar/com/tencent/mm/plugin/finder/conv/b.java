package com.tencent.mm.plugin.finder.conv;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/conv/FinderConversation;)V", "getConv", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getView", "()Landroid/view/View;", "run", "", "plugin-finder_release"})
public final class b
  implements Runnable
{
  final c tyo;
  final View view;
  
  public b(View paramView, c paramc)
  {
    AppMethodBeat.i(242699);
    this.view = paramView;
    this.tyo = paramc;
    AppMethodBeat.o(242699);
  }
  
  public final void run()
  {
    AppMethodBeat.i(242698);
    this.view.setSelected(false);
    final Drawable localDrawable = this.view.getContext().getDrawable(2131100690);
    if (localDrawable == null) {
      p.hyc();
    }
    p.g(localDrawable, "view.context.getDrawable…lor.list_devider_color)!!");
    this.view.setBackground(localDrawable);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 240 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this, localDrawable));
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener((Animator.AnimatorListener)new b(this, localDrawable));
    localValueAnimator.start();
    AppMethodBeat.o(242698);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim$run$animator$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(b paramb, Drawable paramDrawable) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(242695);
      Drawable localDrawable = localDrawable;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(242695);
        throw paramValueAnimator;
      }
      localDrawable.setAlpha(255 - ((Integer)paramValueAnimator).intValue());
      AppMethodBeat.o(242695);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim$run$animator$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    b(b paramb, Drawable paramDrawable) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(242697);
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(242697);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(242696);
      localDrawable.setAlpha(255);
      paramAnimator = this.typ.view;
      if (this.typ.tyo.cZw()) {}
      for (int i = 2131233332;; i = 2131231898)
      {
        paramAnimator.setBackgroundResource(i);
        AppMethodBeat.o(242696);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.b
 * JD-Core Version:    0.7.0.1
 */
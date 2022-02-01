package com.tencent.mm.plugin.finder.conv;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "conv", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/conv/FinderConversation;)V", "getConv", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getView", "()Landroid/view/View;", "run", "", "plugin-finder_release"})
public final class b
  implements Runnable
{
  final View view;
  final d xfV;
  
  public b(View paramView, d paramd)
  {
    AppMethodBeat.i(291360);
    this.view = paramView;
    this.xfV = paramd;
    AppMethodBeat.o(291360);
  }
  
  public final void run()
  {
    AppMethodBeat.i(291359);
    this.view.setSelected(false);
    final Drawable localDrawable = this.view.getContext().getDrawable(b.c.list_devider_color);
    if (localDrawable == null) {
      p.iCn();
    }
    p.j(localDrawable, "view.context.getDrawable…lor.list_devider_color)!!");
    this.view.setBackground(localDrawable);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 240 });
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(this, localDrawable));
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener((Animator.AnimatorListener)new b(this, localDrawable));
    localValueAnimator.start();
    AppMethodBeat.o(291359);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim$run$animator$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(b paramb, Drawable paramDrawable) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(286102);
      Drawable localDrawable = localDrawable;
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(286102);
        throw paramValueAnimator;
      }
      localDrawable.setAlpha(255 - ((Integer)paramValueAnimator).intValue());
      AppMethodBeat.o(286102);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim$run$animator$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    b(b paramb, Drawable paramDrawable) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(291062);
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(291062);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(291061);
      localDrawable.setAlpha(255);
      paramAnimator = this.xfW.view;
      if (this.xfW.xfV.dpm()) {}
      for (int i = b.e.list_item_top_selector;; i = b.e.comm_list_item_selector)
      {
        paramAnimator.setBackgroundResource(i);
        AppMethodBeat.o(291061);
        return;
      }
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.b
 * JD-Core Version:    0.7.0.1
 */
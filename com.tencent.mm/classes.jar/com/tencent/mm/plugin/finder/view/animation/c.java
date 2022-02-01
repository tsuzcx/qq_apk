package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation;", "Lcom/tencent/mm/plugin/finder/view/animation/DefaultItemAnimator;", "()V", "animateAdd", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "animateAddImpl", "", "animateRemove", "animateRemoveImpl", "getAddDelay", "", "getAddDuration", "getRemoveDelay", "getRemoveDuration", "Companion", "plugin-finder_release"})
public final class c
  extends a
{
  public static final a qYx;
  
  static
  {
    AppMethodBeat.i(168472);
    qYx = new a((byte)0);
    AppMethodBeat.o(168472);
  }
  
  protected final void V(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(168469);
    if (paramv == null) {
      k.fvU();
    }
    final View localView = paramv.arI;
    k.g(localView, "holder!!.itemView");
    localView.setAlpha(0.3F);
    final ViewPropertyAnimator localViewPropertyAnimator1 = localView.animate();
    this.ajw.add(paramv);
    ViewPropertyAnimator localViewPropertyAnimator2 = localViewPropertyAnimator1.setDuration(200L).alpha(0.0F);
    Object localObject = paramv.arI;
    k.g(localObject, "holder.itemView");
    localObject = ((View)localObject).getContext();
    k.g(localObject, "holder.itemView.context");
    localViewPropertyAnimator2.translationY(((Context)localObject).getResources().getDimension(2131165298)).setStartDelay(0L).setListener((Animator.AnimatorListener)new c(this, paramv, localView, localViewPropertyAnimator1)).start();
    AppMethodBeat.o(168469);
  }
  
  protected final void W(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(168471);
    if (paramv == null) {
      k.fvU();
    }
    final View localView = paramv.arI;
    k.g(localView, "holder!!.itemView");
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.aju.add(paramv);
    localViewPropertyAnimator.alpha(1.0F).translationY(0.0F).setStartDelay(0L).setDuration(260L).setListener((Animator.AnimatorListener)new b(this, paramv, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(168471);
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(168468);
    k.h(paramv, "holder");
    e(paramv);
    this.ajn.add(paramv);
    AppMethodBeat.o(168468);
    return true;
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(168470);
    k.h(paramv, "holder");
    e(paramv);
    if (paramv.lp() != -3)
    {
      View localView = paramv.arI;
      k.g(localView, "holder.itemView");
      localView.setAlpha(0.56F);
      localView = paramv.arI;
      k.g(localView, "holder.itemView");
      Object localObject = paramv.arI;
      k.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getContext();
      k.g(localObject, "holder.itemView.context");
      localView.setTranslationY(-((Context)localObject).getResources().getDimension(2131165298));
      this.ajo.add(paramv);
    }
    AppMethodBeat.o(168470);
    return true;
  }
  
  protected final long csU()
  {
    return 0L;
  }
  
  public final long kP()
  {
    return 260L;
  }
  
  public final long kQ()
  {
    return 200L;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(168463);
      k.h(paramAnimator, "animator");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(168463);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168464);
      k.h(paramAnimator, "animator");
      d.dW(localView);
      localViewPropertyAnimator.setListener(null);
      this.qYy.y(paramv);
      this.qYy.aju.remove(paramv);
      this.qYy.iX();
      AppMethodBeat.o(168464);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(168462);
      k.h(paramAnimator, "animator");
      AppMethodBeat.o(168462);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "animator", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(168466);
      k.h(paramAnimator, "animation");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(168466);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168467);
      k.h(paramAnimator, "animator");
      d.dW(localView);
      localViewPropertyAnimator1.setListener(null);
      this.qYy.w(paramv);
      this.qYy.ajw.remove(paramv);
      this.qYy.iX();
      AppMethodBeat.o(168467);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(168465);
      k.h(paramAnimator, "animator");
      this.qYy.z(paramv);
      AppMethodBeat.o(168465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.c
 * JD-Core Version:    0.7.0.1
 */
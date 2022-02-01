package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation;", "Lcom/tencent/mm/plugin/finder/view/animation/DefaultItemAnimator;", "()V", "animateAdd", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "animateAddImpl", "", "animateRemove", "animateRemoveImpl", "getAddDelay", "", "getAddDuration", "getRemoveDelay", "getRemoveDuration", "Companion", "plugin-finder_release"})
public final class c
  extends a
{
  public static final c.a sam;
  
  static
  {
    AppMethodBeat.i(168472);
    sam = new c.a((byte)0);
    AppMethodBeat.o(168472);
  }
  
  protected final void V(final RecyclerView.w paramw)
  {
    AppMethodBeat.i(168469);
    if (paramw == null) {
      k.fOy();
    }
    final View localView = paramw.asD;
    k.g(localView, "holder!!.itemView");
    localView.setAlpha(0.3F);
    final ViewPropertyAnimator localViewPropertyAnimator1 = localView.animate();
    this.akq.add(paramw);
    ViewPropertyAnimator localViewPropertyAnimator2 = localViewPropertyAnimator1.setDuration(200L).alpha(0.0F);
    Object localObject = paramw.asD;
    k.g(localObject, "holder.itemView");
    localObject = ((View)localObject).getContext();
    k.g(localObject, "holder.itemView.context");
    localViewPropertyAnimator2.translationY(((Context)localObject).getResources().getDimension(2131165298)).setStartDelay(0L).setListener((Animator.AnimatorListener)new c(this, paramw, localView, localViewPropertyAnimator1)).start();
    AppMethodBeat.o(168469);
  }
  
  protected final void W(final RecyclerView.w paramw)
  {
    AppMethodBeat.i(168471);
    if (paramw == null) {
      k.fOy();
    }
    final View localView = paramw.asD;
    k.g(localView, "holder!!.itemView");
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.ako.add(paramw);
    localViewPropertyAnimator.alpha(1.0F).translationY(0.0F).setStartDelay(0L).setDuration(260L).setListener((Animator.AnimatorListener)new b(this, paramw, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(168471);
  }
  
  public final boolean b(RecyclerView.w paramw)
  {
    AppMethodBeat.i(168468);
    k.h(paramw, "holder");
    e(paramw);
    this.akh.add(paramw);
    AppMethodBeat.o(168468);
    return true;
  }
  
  public final boolean c(RecyclerView.w paramw)
  {
    AppMethodBeat.i(168470);
    k.h(paramw, "holder");
    e(paramw);
    if (paramw.ly() != -3)
    {
      View localView = paramw.asD;
      k.g(localView, "holder.itemView");
      localView.setAlpha(0.56F);
      localView = paramw.asD;
      k.g(localView, "holder.itemView");
      Object localObject = paramw.asD;
      k.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getContext();
      k.g(localObject, "holder.itemView.context");
      localView.setTranslationY(-((Context)localObject).getResources().getDimension(2131165298));
      this.aki.add(paramw);
    }
    AppMethodBeat.o(168470);
    return true;
  }
  
  protected final long cFl()
  {
    return 0L;
  }
  
  public final long kX()
  {
    return 260L;
  }
  
  public final long kY()
  {
    return 200L;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(RecyclerView.w paramw, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
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
      d.ed(localView);
      localViewPropertyAnimator.setListener(null);
      this.san.y(paramw);
      this.san.ako.remove(paramw);
      this.san.jf();
      AppMethodBeat.o(168464);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(168462);
      k.h(paramAnimator, "animator");
      AppMethodBeat.o(168462);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "animator", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(RecyclerView.w paramw, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
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
      d.ed(localView);
      localViewPropertyAnimator1.setListener(null);
      this.san.w(paramw);
      this.san.akq.remove(paramw);
      this.san.jf();
      AppMethodBeat.o(168467);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(168465);
      k.h(paramAnimator, "animator");
      this.san.z(paramw);
      AppMethodBeat.o(168465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.c
 * JD-Core Version:    0.7.0.1
 */
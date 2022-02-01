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
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation;", "Lcom/tencent/mm/plugin/finder/view/animation/DefaultItemAnimator;", "()V", "animateAdd", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "animateAddImpl", "", "animateRemove", "animateRemoveImpl", "getAddDelay", "", "getAddDuration", "getRemoveDelay", "getRemoveDuration", "Companion", "plugin-finder_release"})
public final class d
  extends a
{
  public static final a wrL;
  
  static
  {
    AppMethodBeat.i(255188);
    wrL = new a((byte)0);
    AppMethodBeat.o(255188);
  }
  
  protected final void aa(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(255185);
    if (paramv == null) {
      p.hyc();
    }
    final View localView = paramv.aus;
    p.g(localView, "holder!!.itemView");
    localView.setAlpha(0.3F);
    final ViewPropertyAnimator localViewPropertyAnimator1 = localView.animate();
    this.amu.add(paramv);
    ViewPropertyAnimator localViewPropertyAnimator2 = localViewPropertyAnimator1.setDuration(200L).alpha(0.0F);
    Object localObject = paramv.aus;
    p.g(localObject, "holder.itemView");
    localObject = ((View)localObject).getContext();
    p.g(localObject, "holder.itemView.context");
    localViewPropertyAnimator2.translationY(((Context)localObject).getResources().getDimension(2131165308)).setStartDelay(0L).setListener((Animator.AnimatorListener)new c(this, paramv, localView, localViewPropertyAnimator1)).start();
    AppMethodBeat.o(255185);
  }
  
  protected final void ab(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(255187);
    if (paramv == null) {
      p.hyc();
    }
    final View localView = paramv.aus;
    p.g(localView, "holder!!.itemView");
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.ams.add(paramv);
    localViewPropertyAnimator.alpha(1.0F).setStartDelay(0L).setDuration(260L).setListener((Animator.AnimatorListener)new b(this, paramv, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(255187);
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(255184);
    p.h(paramv, "holder");
    e(paramv);
    this.aml.add(paramv);
    AppMethodBeat.o(255184);
    return true;
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(255186);
    p.h(paramv, "holder");
    e(paramv);
    if (paramv.lU() != -3)
    {
      View localView = paramv.aus;
      p.g(localView, "holder.itemView");
      localView.setAlpha(0.0F);
      this.amm.add(paramv);
    }
    AppMethodBeat.o(255186);
    return true;
  }
  
  protected final long dHo()
  {
    return 0L;
  }
  
  public final long lx()
  {
    return 260L;
  }
  
  public final long ly()
  {
    return 200L;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(255179);
      p.h(paramAnimator, "animator");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(255179);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(255180);
      p.h(paramAnimator, "animator");
      f.ej(localView);
      localViewPropertyAnimator.setListener(null);
      this.wrM.y(paramv);
      this.wrM.ams.remove(paramv);
      this.wrM.jE();
      AppMethodBeat.o(255180);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(255178);
      p.h(paramAnimator, "animator");
      AppMethodBeat.o(255178);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "animator", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(255182);
      p.h(paramAnimator, "animation");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(255182);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(255183);
      p.h(paramAnimator, "animator");
      f.ej(localView);
      localViewPropertyAnimator1.setListener(null);
      this.wrM.w(paramv);
      this.wrM.amu.remove(paramv);
      this.wrM.jE();
      AppMethodBeat.o(255183);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(255181);
      p.h(paramAnimator, "animator");
      this.wrM.A(paramv);
      AppMethodBeat.o(255181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation;", "Lcom/tencent/mm/plugin/finder/view/animation/DefaultItemAnimator;", "()V", "animateAdd", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "animateAddImpl", "", "animateRemove", "animateRemoveImpl", "getAddDelay", "", "getAddDuration", "getRemoveDelay", "getRemoveDuration", "Companion", "plugin-finder_release"})
public final class d
  extends a
{
  public static final a BdP;
  
  static
  {
    AppMethodBeat.i(286435);
    BdP = new a((byte)0);
    AppMethodBeat.o(286435);
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(286431);
    p.k(paramv, "holder");
    d(paramv);
    this.afZ.add(paramv);
    AppMethodBeat.o(286431);
    return true;
  }
  
  protected final void ab(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(286432);
    if (paramv == null) {
      p.iCn();
    }
    final View localView = paramv.amk;
    p.j(localView, "holder!!.itemView");
    localView.setAlpha(0.3F);
    final ViewPropertyAnimator localViewPropertyAnimator1 = localView.animate();
    this.agi.add(paramv);
    ViewPropertyAnimator localViewPropertyAnimator2 = localViewPropertyAnimator1.setDuration(200L).alpha(0.0F);
    Object localObject = paramv.amk;
    p.j(localObject, "holder.itemView");
    localObject = ((View)localObject).getContext();
    p.j(localObject, "holder.itemView.context");
    localViewPropertyAnimator2.translationY(((Context)localObject).getResources().getDimension(b.d.Edge_6A)).setStartDelay(0L).setListener((Animator.AnimatorListener)new c(this, paramv, localView, localViewPropertyAnimator1)).start();
    AppMethodBeat.o(286432);
  }
  
  protected final void ac(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(286434);
    if (paramv == null) {
      p.iCn();
    }
    final View localView = paramv.amk;
    p.j(localView, "holder!!.itemView");
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.agg.add(paramv);
    localViewPropertyAnimator.alpha(1.0F).setStartDelay(0L).setDuration(260L).setListener((Animator.AnimatorListener)new b(this, paramv, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(286434);
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(286433);
    p.k(paramv, "holder");
    d(paramv);
    if (paramv.mg() != -3)
    {
      View localView = paramv.amk;
      p.j(localView, "holder.itemView");
      localView.setAlpha(0.0F);
      this.aga.add(paramv);
    }
    AppMethodBeat.o(286433);
    return true;
  }
  
  protected final long ejz()
  {
    return 0L;
  }
  
  public final long lJ()
  {
    return 260L;
  }
  
  public final long lK()
  {
    return 200L;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(222729);
      p.k(paramAnimator, "animator");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(222729);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(222732);
      p.k(paramAnimator, "animator");
      f.eU(localView);
      localViewPropertyAnimator.setListener(null);
      this.BdQ.B(paramv);
      this.BdQ.agg.remove(paramv);
      this.BdQ.km();
      AppMethodBeat.o(222732);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(222727);
      p.k(paramAnimator, "animator");
      AppMethodBeat.o(222727);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "animator", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(272001);
      p.k(paramAnimator, "animation");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(272001);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(272003);
      p.k(paramAnimator, "animator");
      f.eU(localView);
      localViewPropertyAnimator1.setListener(null);
      this.BdQ.z(paramv);
      this.BdQ.agi.remove(paramv);
      this.BdQ.km();
      AppMethodBeat.o(272003);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(272000);
      p.k(paramAnimator, "animator");
      this.BdQ.D(paramv);
      AppMethodBeat.o(272000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.d
 * JD-Core Version:    0.7.0.1
 */
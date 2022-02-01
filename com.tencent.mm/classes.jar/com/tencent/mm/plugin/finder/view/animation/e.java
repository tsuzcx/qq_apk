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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation;", "Lcom/tencent/mm/plugin/finder/view/animation/DefaultItemAnimator;", "()V", "animateAdd", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "animateAddImpl", "", "animateRemove", "animateRemoveImpl", "getAddDelay", "", "getAddDuration", "getRemoveDelay", "getRemoveDuration", "Companion", "plugin-finder_release"})
public final class e
  extends a
{
  public static final a BdT;
  
  static
  {
    AppMethodBeat.i(168472);
    BdT = new a((byte)0);
    AppMethodBeat.o(168472);
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(273688);
    p.k(paramv, "holder");
    d(paramv);
    this.afZ.add(paramv);
    AppMethodBeat.o(273688);
    return true;
  }
  
  protected final void ab(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(273689);
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
    AppMethodBeat.o(273689);
  }
  
  protected final void ac(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(273691);
    if (paramv == null) {
      p.iCn();
    }
    final View localView = paramv.amk;
    p.j(localView, "holder!!.itemView");
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.agg.add(paramv);
    localViewPropertyAnimator.alpha(1.0F).translationY(0.0F).setStartDelay(0L).setDuration(260L).setListener((Animator.AnimatorListener)new b(this, paramv, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(273691);
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(273690);
    p.k(paramv, "holder");
    d(paramv);
    if (paramv.mg() != -3)
    {
      View localView = paramv.amk;
      p.j(localView, "holder.itemView");
      localView.setAlpha(0.56F);
      localView = paramv.amk;
      p.j(localView, "holder.itemView");
      Object localObject = paramv.amk;
      p.j(localObject, "holder.itemView");
      localObject = ((View)localObject).getContext();
      p.j(localObject, "holder.itemView.context");
      localView.setTranslationY(-((Context)localObject).getResources().getDimension(b.d.Edge_6A));
      this.aga.add(paramv);
    }
    AppMethodBeat.o(273690);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(168463);
      p.k(paramAnimator, "animator");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(168463);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168464);
      p.k(paramAnimator, "animator");
      f.eU(localView);
      localViewPropertyAnimator.setListener(null);
      this.BdU.B(paramv);
      this.BdU.agg.remove(paramv);
      this.BdU.km();
      AppMethodBeat.o(168464);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(168462);
      p.k(paramAnimator, "animator");
      AppMethodBeat.o(168462);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "animator", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(168466);
      p.k(paramAnimator, "animation");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(168466);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168467);
      p.k(paramAnimator, "animator");
      f.eU(localView);
      localViewPropertyAnimator1.setListener(null);
      this.BdU.z(paramv);
      this.BdU.agi.remove(paramv);
      this.BdU.km();
      AppMethodBeat.o(168467);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(168465);
      p.k(paramAnimator, "animator");
      this.BdU.D(paramv);
      AppMethodBeat.o(168465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.e
 * JD-Core Version:    0.7.0.1
 */
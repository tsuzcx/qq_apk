package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation;", "Lcom/tencent/mm/plugin/finder/view/animation/DefaultItemAnimator;", "()V", "animateAdd", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "animateAddImpl", "", "animateRemove", "animateRemoveImpl", "getAddDelay", "", "getAddDuration", "getRemoveDelay", "getRemoveDuration", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  public static final a GGu;
  
  static
  {
    AppMethodBeat.i(168472);
    GGu = new a((byte)0);
    AppMethodBeat.o(168472);
  }
  
  public final long Kt()
  {
    return 260L;
  }
  
  public final long Ku()
  {
    return 200L;
  }
  
  protected final void W(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(345961);
    s.checkNotNull(paramv);
    final View localView = paramv.caK;
    s.s(localView, "holder!!.itemView");
    localView.setAlpha(0.3F);
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.bUO.add(paramv);
    localViewPropertyAnimator.setDuration(200L).alpha(0.0F).translationY(paramv.caK.getContext().getResources().getDimension(com.tencent.mm.plugin.finder.e.c.Edge_6A)).setStartDelay(0L).setListener((Animator.AnimatorListener)new c(this, paramv, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(345961);
  }
  
  protected final void X(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(345979);
    s.checkNotNull(paramv);
    final View localView = paramv.caK;
    s.s(localView, "holder!!.itemView");
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.bUM.add(paramv);
    localViewPropertyAnimator.alpha(1.0F).translationY(0.0F).setStartDelay(0L).setDuration(260L).setListener((Animator.AnimatorListener)new b(this, paramv, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(345979);
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(345948);
    s.u(paramv, "holder");
    d(paramv);
    this.bUF.add(paramv);
    AppMethodBeat.o(345948);
    return true;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(345974);
    s.u(paramv, "holder");
    d(paramv);
    if (paramv.caO != -3)
    {
      paramv.caK.setAlpha(0.56F);
      paramv.caK.setTranslationY(-paramv.caK.getContext().getResources().getDimension(com.tencent.mm.plugin.finder.e.c.Edge_6A));
      this.bUG.add(paramv);
    }
    AppMethodBeat.o(345974);
    return true;
  }
  
  protected final long flM()
  {
    return 0L;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(e parame, RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(168463);
      s.u(paramAnimator, "animator");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(168463);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168464);
      s.u(paramAnimator, "animator");
      f.hf(localView);
      localViewPropertyAnimator.setListener(null);
      this.GGv.r(paramv);
      this.GGv.bUM.remove(paramv);
      this.GGv.IX();
      AppMethodBeat.o(168464);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(168462);
      s.u(paramAnimator, "animator");
      AppMethodBeat.o(168462);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/animation/RefreshItemAnimation$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "animator", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(e parame, RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(168466);
      s.u(paramAnimator, "animation");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(168466);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168467);
      s.u(paramAnimator, "animator");
      f.hf(localView);
      localViewPropertyAnimator.setListener(null);
      this.GGv.A(paramv);
      this.GGv.bUO.remove(paramv);
      this.GGv.IX();
      AppMethodBeat.o(168467);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(168465);
      s.u(paramAnimator, "animator");
      this.GGv.C(paramv);
      AppMethodBeat.o(168465);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.e
 * JD-Core Version:    0.7.0.1
 */
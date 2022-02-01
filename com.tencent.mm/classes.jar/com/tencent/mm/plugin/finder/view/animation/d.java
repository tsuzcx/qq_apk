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
import com.tencent.mm.plugin.finder.e.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation;", "Lcom/tencent/mm/plugin/finder/view/animation/DefaultItemAnimator;", "()V", "animateAdd", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "animateAddImpl", "", "animateRemove", "animateRemoveImpl", "getAddDelay", "", "getAddDuration", "getRemoveDelay", "getRemoveDuration", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public static final a GGr;
  
  static
  {
    AppMethodBeat.i(345951);
    GGr = new a((byte)0);
    AppMethodBeat.o(345951);
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
    AppMethodBeat.i(345976);
    s.checkNotNull(paramv);
    final View localView = paramv.caK;
    s.s(localView, "holder!!.itemView");
    localView.setAlpha(0.3F);
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.bUO.add(paramv);
    localViewPropertyAnimator.setDuration(200L).alpha(0.0F).translationY(paramv.caK.getContext().getResources().getDimension(e.c.Edge_6A)).setStartDelay(0L).setListener((Animator.AnimatorListener)new c(this, paramv, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(345976);
  }
  
  protected final void X(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(345987);
    s.checkNotNull(paramv);
    final View localView = paramv.caK;
    s.s(localView, "holder!!.itemView");
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.bUM.add(paramv);
    localViewPropertyAnimator.alpha(1.0F).setStartDelay(0L).setDuration(260L).setListener((Animator.AnimatorListener)new b(this, paramv, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(345987);
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(345960);
    s.u(paramv, "holder");
    d(paramv);
    this.bUF.add(paramv);
    AppMethodBeat.o(345960);
    return true;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(345982);
    s.u(paramv, "holder");
    d(paramv);
    if (paramv.caO != -3)
    {
      paramv.caK.setAlpha(0.0F);
      this.bUG.add(paramv);
    }
    AppMethodBeat.o(345982);
    return true;
  }
  
  protected final long flM()
  {
    return 0L;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$animateAddImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(d paramd, RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(345943);
      s.u(paramAnimator, "animator");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(345943);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(345955);
      s.u(paramAnimator, "animator");
      f.hf(localView);
      localViewPropertyAnimator.setListener(null);
      this.GGs.r(paramv);
      this.GGs.bUM.remove(paramv);
      this.GGs.IX();
      AppMethodBeat.o(345955);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(345933);
      s.u(paramAnimator, "animator");
      AppMethodBeat.o(345933);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/animation/RefreshFadeInAnimation$animateRemoveImpl$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "animator", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(d paramd, RecyclerView.v paramv, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(345925);
      s.u(paramAnimator, "animation");
      onAnimationEnd(paramAnimator);
      AppMethodBeat.o(345925);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(345932);
      s.u(paramAnimator, "animator");
      f.hf(localView);
      localViewPropertyAnimator.setListener(null);
      this.GGs.A(paramv);
      this.GGs.bUO.remove(paramv);
      this.GGs.IX();
      AppMethodBeat.o(345932);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(345918);
      s.u(paramAnimator, "animator");
      this.GGs.C(paramv);
      AppMethodBeat.o(345918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.d
 * JD-Core Version:    0.7.0.1
 */
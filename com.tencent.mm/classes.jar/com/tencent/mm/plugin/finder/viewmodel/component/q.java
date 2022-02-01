package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.animation.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.findersdk.a.af;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedDescriptionUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderDescPanelItem;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderFeedDescriptionUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "animateDescriptionHide", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "fromUser", "", "animateDescriptionShow", "getContentView", "Landroid/view/View;", "hide", "isNeedShow", "onFocusFeed", "isFirstTime", "lastFeedId", "", "newFeedId", "show", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends bh
  implements af
{
  public static final a GPc;
  
  static
  {
    AppMethodBeat.i(337702);
    GPc = new a((byte)0);
    AppMethodBeat.o(337702);
  }
  
  public q(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337682);
    AppMethodBeat.o(337682);
  }
  
  private static final void a(ViewGroup paramViewGroup, final q paramq, final j paramj)
  {
    AppMethodBeat.i(337692);
    s.u(paramViewGroup, "$feedInfoLayout");
    s.u(paramq, "this$0");
    s.u(paramj, "$holder");
    paramViewGroup.setVisibility(0);
    paramViewGroup.setAlpha(0.0F);
    paramViewGroup.animate().alpha(1.0F).setDuration(250L).setListener((Animator.AnimatorListener)new c(paramViewGroup, paramq, paramj)).start();
    AppMethodBeat.o(337692);
  }
  
  public final boolean R(j paramj)
  {
    AppMethodBeat.i(337731);
    s.u(paramj, "holder");
    AppMethodBeat.o(337731);
    return true;
  }
  
  public final View S(j paramj)
  {
    AppMethodBeat.i(337747);
    s.u(paramj, "holder");
    paramj = paramj.UH(e.e.finder_feed_full_footer_feed_info_layout);
    AppMethodBeat.o(337747);
    return paramj;
  }
  
  public final void b(j paramj, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(337741);
    s.u(paramj, "holder");
    super.b(paramj, paramBoolean, paramLong1, paramLong2);
    AppMethodBeat.o(337741);
  }
  
  public final void d(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(337716);
    s.u(paramj, "holder");
    if (paramBoolean) {}
    for (long l = 0L;; l = 150L)
    {
      ViewGroup localViewGroup = (ViewGroup)paramj.UH(e.e.finder_feed_full_footer_feed_info_layout);
      if (localViewGroup != null) {
        h.ahAA.o(new q..ExternalSyntheticLambda0(localViewGroup, this, paramj), l);
      }
      AppMethodBeat.o(337716);
      return;
    }
  }
  
  public final void e(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(337724);
    s.u(paramj, "holder");
    paramj = (ViewGroup)paramj.UH(e.e.finder_feed_full_footer_feed_info_layout);
    if (paramj != null)
    {
      paramj.setAlpha(1.0F);
      paramj.animate().alpha(0.0F).setDuration(250L).setListener((Animator.AnimatorListener)new b(paramj)).start();
    }
    AppMethodBeat.o(337724);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedDescriptionUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedDescriptionUIC$animateDescriptionHide$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends a
  {
    b(ViewGroup paramViewGroup) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(338761);
      this.GPd.setAlpha(1.0F);
      this.GPd.setVisibility(8);
      AppMethodBeat.o(338761);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedDescriptionUIC$animateDescriptionShow$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends a
  {
    c(ViewGroup paramViewGroup, q paramq, j paramj) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(338768);
      this.GPd.setAlpha(1.0F);
      paramq.ab(paramj);
      AppMethodBeat.o(338768);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.q
 * JD-Core Version:    0.7.0.1
 */
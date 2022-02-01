package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.widget.ay;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMoreOptionPanelPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "hideCallback", "Lkotlin/Function0;", "", "panelLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "promoteBtn", "Landroid/view/View;", "screenShareBtn", "screenShareWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveScreenShareEntranceWidget;", "hideMoreOptionPanel", "onBackPress", "", "showMoreOptionPanel", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends b
{
  private final ay CTV;
  public final LinearLayout CWd;
  private final View CWe;
  private final View CWf;
  public kotlin.g.a.a<ah> CWg;
  private final com.tencent.mm.live.b.b nfT;
  
  public s(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(353828);
    this.nfT = paramb;
    this.CWd = ((LinearLayout)paramViewGroup.findViewById(p.e.BGa));
    this.CWe = paramViewGroup.findViewById(p.e.BGd);
    this.CWf = paramViewGroup.findViewById(p.e.BGc);
    paramb = this.CWe;
    if (paramb == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(353828);
      throw paramViewGroup;
    }
    this.CTV = new ay((ViewGroup)paramb, this.nfT, (b)this);
    if (!isLandscape()) {
      paramViewGroup.post(new s..ExternalSyntheticLambda3(paramViewGroup));
    }
    this.CWd.setTranslationY(bf.bf(paramViewGroup.getContext()).y);
    paramViewGroup.setOnClickListener(new s..ExternalSyntheticLambda0(this));
    this.CWe.setOnClickListener(new s..ExternalSyntheticLambda2(this));
    this.CWf.setOnClickListener(new s..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(353828);
  }
  
  private static final void a(s params, View paramView)
  {
    AppMethodBeat.i(353851);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(params);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMoreOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(params, "this$0");
    params.epq();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMoreOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353851);
  }
  
  private static final void b(s params, View paramView)
  {
    AppMethodBeat.i(353857);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(params);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMoreOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(params, "this$0");
    paramView = j.Dob;
    localObject1 = q.s.Dvf;
    localObject2 = j.Dob;
    paramView.a((q.s)localObject1, j.a(q.r.Duf));
    params.CTV.eBy();
    params.epq();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMoreOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353857);
  }
  
  private static final void c(s params, View paramView)
  {
    AppMethodBeat.i(353868);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(params);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMoreOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(params, "this$0");
    paramView = params.nfT;
    if (paramView != null) {
      b.b.a(paramView, b.c.ndJ);
    }
    params.epq();
    params = params.getBuContext();
    if (params != null)
    {
      paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
      com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(params, 2, 0, null, 12);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMoreOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353868);
  }
  
  private final void epq()
  {
    AppMethodBeat.i(353836);
    this.CWd.animate().translationY(bf.bf(this.mJe.getContext()).y).setDuration(200L).setListener((Animator.AnimatorListener)new a(this)).start();
    AppMethodBeat.o(353836);
  }
  
  private static final void x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(353845);
    kotlin.g.b.s.u(paramViewGroup, "$root");
    Object localObject = paramViewGroup.getLayoutParams();
    if (localObject == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(353845);
      throw paramViewGroup;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += bf.bk(paramViewGroup.getContext());
    AppMethodBeat.o(353845);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(353907);
    if (this.mJe.getVisibility() == 0)
    {
      epq();
      AppMethodBeat.o(353907);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(353907);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMoreOptionPanelPlugin$hideMoreOptionPanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(s params) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(354041);
      this.CWh.mJe.setVisibility(8);
      paramAnimator = s.a(this.CWh);
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(354041);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(354034);
      this.CWh.mJe.setVisibility(8);
      paramAnimator = s.a(this.CWh);
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(354034);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.s
 * JD-Core Version:    0.7.0.1
 */
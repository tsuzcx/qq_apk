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
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.widget.i;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "hideCallback", "Lkotlin/Function0;", "", "lotteryBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "lotteryLuckyPanel", "Landroid/widget/LinearLayout;", "luckyBtn", "hideLotteryLuckyPanel", "onBackPress", "", "showLotteryLuckyPanel", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bp
  extends b
{
  kotlin.g.a.a<ah> CWg;
  final LinearLayout DhA;
  private final View DhB;
  private final View DhC;
  private final com.tencent.mm.live.b.b nfT;
  
  public bp(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355417);
    this.nfT = paramb;
    this.DhA = ((LinearLayout)paramViewGroup.findViewById(p.e.BNw));
    this.DhB = paramViewGroup.findViewById(p.e.BNx);
    this.DhC = paramViewGroup.findViewById(p.e.BNy);
    if (!isLandscape()) {
      paramViewGroup.post(new bp..ExternalSyntheticLambda3(paramViewGroup));
    }
    this.DhA.setTranslationY(bf.bf(paramViewGroup.getContext()).y);
    paramViewGroup.setOnClickListener(new bp..ExternalSyntheticLambda1(this));
    this.DhB.setOnClickListener(new bp..ExternalSyntheticLambda2(this));
    this.DhC.setOnClickListener(new bp..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(355417);
  }
  
  private static final void a(bp parambp, View paramView)
  {
    AppMethodBeat.i(355453);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambp);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambp, "this$0");
    parambp.erw();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355453);
  }
  
  private static final void b(bp parambp, View paramView)
  {
    AppMethodBeat.i(355467);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambp);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(parambp, "this$0");
    paramView = j.Dob;
    localObject1 = q.s.DuV;
    localObject2 = j.Dob;
    paramView.a((q.s)localObject1, j.a(q.r.Duf));
    parambp = (h)parambp.getPlugin(h.class);
    if (parambp != null) {
      parambp.CTR.ezV();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355467);
  }
  
  private static final void c(bp parambp, View paramView)
  {
    AppMethodBeat.i(355478);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambp);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(parambp, "this$0");
    paramView = j.Dob;
    localObject1 = q.s.DuU;
    localObject2 = j.Dob;
    paramView.a((q.s)localObject1, j.a(q.r.Duf));
    parambp = (h)parambp.getPlugin(h.class);
    if (parambp != null) {
      parambp.eoU();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355478);
  }
  
  private final void erw()
  {
    AppMethodBeat.i(355431);
    this.DhA.animate().translationY(bf.bf(this.mJe.getContext()).y).setDuration(200L).setListener((Animator.AnimatorListener)new a(this)).start();
    AppMethodBeat.o(355431);
  }
  
  private static final void x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(355439);
    s.u(paramViewGroup, "$root");
    Object localObject = paramViewGroup.getLayoutParams();
    if (localObject == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(355439);
      throw paramViewGroup;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += bf.bk(paramViewGroup.getContext());
    AppMethodBeat.o(355439);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(355522);
    if (this.mJe.getVisibility() == 0)
    {
      erw();
      AppMethodBeat.o(355522);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(355522);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin$hideLotteryLuckyPanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(bp parambp) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(355683);
      this.DhD.mJe.setVisibility(8);
      paramAnimator = bp.a(this.DhD);
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(355683);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(355675);
      this.DhD.mJe.setVisibility(8);
      paramAnimator = bp.a(this.DhD);
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(355675);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bp
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.widget.e;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "hideCallback", "Lkotlin/Function0;", "", "lotteryBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "lotteryLuckyPanel", "Landroid/widget/LinearLayout;", "luckyBtn", "hideLotteryLuckyPanel", "onBackPress", "", "showLotteryLuckyPanel", "plugin-finder_release"})
public final class cc
  extends d
{
  private final com.tencent.mm.live.c.b kCL;
  final LinearLayout ywB;
  private final View ywC;
  private final View ywD;
  kotlin.g.a.a<x> ywE;
  
  public cc(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(266879);
    this.kCL = paramb;
    this.ywB = ((LinearLayout)paramViewGroup.findViewById(b.f.finder_live_lottery_lucky_panel));
    this.ywC = paramViewGroup.findViewById(b.f.finder_live_lottery_lucky_panel_lottery);
    this.ywD = paramViewGroup.findViewById(b.f.finder_live_lottery_lucky_panel_lucky);
    if (!isLandscape()) {
      paramViewGroup.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(287319);
          Object localObject = this.kCW.getLayoutParams();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(287319);
            throw ((Throwable)localObject);
          }
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += ax.aB(this.kCW.getContext());
          AppMethodBeat.o(287319);
        }
      });
    }
    paramb = this.ywB;
    p.j(paramb, "lotteryLuckyPanel");
    paramb.setTranslationY(ax.au(paramViewGroup.getContext()).y);
    paramViewGroup.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(277757);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        cc.b(this.ywF);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(277757);
      }
    });
    this.ywC.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(267813);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = (h)this.ywF.getPlugin(h.class);
        if (paramAnonymousView != null) {
          paramAnonymousView.ylw.dHJ();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(267813);
      }
    });
    this.ywD.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(223275);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = (h)this.ywF.getPlugin(h.class);
        if (paramAnonymousView != null) {
          paramAnonymousView.dAv();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(223275);
      }
    });
    AppMethodBeat.o(266879);
  }
  
  private final void dCo()
  {
    AppMethodBeat.i(266877);
    this.ywB.animate().translationY(ax.au(this.kiF.getContext()).y).setDuration(200L).setListener((Animator.AnimatorListener)new a(this)).start();
    AppMethodBeat.o(266877);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(266878);
    if (this.kiF.getVisibility() == 0)
    {
      dCo();
      AppMethodBeat.o(266878);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(266878);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveOptionPanelPlugin$hideLotteryLuckyPanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(280364);
      this.ywF.kiF.setVisibility(8);
      paramAnimator = cc.a(this.ywF);
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(280364);
        return;
      }
      AppMethodBeat.o(280364);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(280363);
      this.ywF.kiF.setVisibility(8);
      paramAnimator = cc.a(this.ywF);
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(280363);
        return;
      }
      AppMethodBeat.o(280363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cc
 * JD-Core Version:    0.7.0.1
 */
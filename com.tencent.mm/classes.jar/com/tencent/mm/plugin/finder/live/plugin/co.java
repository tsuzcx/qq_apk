package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveSwitchModePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN", "", "COUNT_DOWN_END", "countDownTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "curCountDown", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "hideSwitchModeTip", "", "resetCountDown", "showSwitchModeTip", "updateCountDown", "plugin-finder_release"})
public final class co
  extends d
{
  private final b kCL;
  private final int kGM;
  private final TextView kGO;
  private int kGP;
  public final MTimerHandler timer;
  private final int yxL;
  
  public co(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(268559);
    this.kCL = paramb;
    this.yxL = 3;
    this.kGP = this.yxL;
    this.kGO = ((TextView)paramViewGroup.findViewById(b.f.finder_live_switch_mode_count_down_tv));
    this.timer = new MTimerHandler("FinderLiveSwitchModeTimer", (MTimerHandler.CallBack)new c(this), true);
    AppMethodBeat.o(268559);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveSwitchModePlugin$hideSwitchModeTip$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(286692);
      this.yxM.tU(8);
      paramAnimator = co.a(this.yxM);
      p.j(paramAnimator, "countDownTv");
      paramAnimator.setText((CharSequence)String.valueOf(co.e(this.yxM)));
      this.yxM.kiF.setAlpha(1.0F);
      AppMethodBeat.o(286692);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(286691);
      this.yxM.tU(8);
      co.a(this.yxM, co.e(this.yxM));
      paramAnimator = co.a(this.yxM);
      p.j(paramAnimator, "countDownTv");
      paramAnimator.setText((CharSequence)String.valueOf(co.e(this.yxM)));
      this.yxM.kiF.setAlpha(1.0F);
      AppMethodBeat.o(286691);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(co paramco)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class c
    implements MTimerHandler.CallBack
  {
    c(co paramco) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(286740);
      if (co.b(this.yxM) > co.f(this.yxM))
      {
        co localco = this.yxM;
        co.a(localco, co.b(localco) - 1);
        co.g(this.yxM);
        AppMethodBeat.o(286740);
        return true;
      }
      co.h(this.yxM);
      AppMethodBeat.o(286740);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(co paramco)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.co
 * JD-Core Version:    0.7.0.1
 */
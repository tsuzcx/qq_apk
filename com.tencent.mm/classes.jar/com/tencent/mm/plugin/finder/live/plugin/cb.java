package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveSwitchModePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN", "", "COUNT_DOWN_END", "countDownTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "curCountDown", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "hideSwitchModeTip", "", "resetCountDown", "showSwitchModeTip", "updateCountDown", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cb
  extends b
{
  private final int Dkh;
  private final com.tencent.mm.live.b.b nfT;
  private final int njH;
  private final TextView njJ;
  private int njK;
  public final MTimerHandler timer;
  
  public cb(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354194);
    this.nfT = paramb;
    this.Dkh = 3;
    this.njK = this.Dkh;
    this.njJ = ((TextView)paramViewGroup.findViewById(p.e.BST));
    this.timer = new MTimerHandler("FinderLiveSwitchModeTimer", new cb..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(354194);
  }
  
  private static final boolean a(cb paramcb)
  {
    AppMethodBeat.i(354200);
    s.u(paramcb, "this$0");
    if (paramcb.njK > paramcb.njH)
    {
      paramcb.njK -= 1;
      d.uiThread((kotlin.g.a.a)new c(paramcb));
      AppMethodBeat.o(354200);
      return true;
    }
    d.uiThread((kotlin.g.a.a)new b(paramcb));
    AppMethodBeat.o(354200);
    return false;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveSwitchModePlugin$hideSwitchModeTip$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(cb paramcb) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(353531);
      this.Dki.tO(8);
      cb.b(this.Dki).setText((CharSequence)String.valueOf(cb.f(this.Dki)));
      this.Dki.mJe.setAlpha(1.0F);
      AppMethodBeat.o(353531);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(353521);
      this.Dki.tO(8);
      cb.a(this.Dki, cb.f(this.Dki));
      cb.b(this.Dki).setText((CharSequence)String.valueOf(cb.f(this.Dki)));
      this.Dki.mJe.setAlpha(1.0F);
      AppMethodBeat.o(353521);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(cb paramcb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(cb paramcb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cb
 * JD-Core Version:    0.7.0.1
 */
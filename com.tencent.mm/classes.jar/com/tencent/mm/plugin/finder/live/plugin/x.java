package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.r.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.component.a.a;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.w;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "ERR_STATE_THRESHOLD", "", "TAG", "", "errStateCount", "livePauseTimeTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "livePauseTipsTv", "pauseTime", "", "resetLiveTv", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimerThread", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timerThread$delegate", "Lkotlin/Lazy;", "checkAnchorPauseLive", "", "checkPauseState", "hide", "onTimerUpdate", "resumeLive", "resumeLiveLogic", "showRecoveryView", "", "showLivePauseView", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-finder_release"})
public final class x
  extends d
{
  public static final a ynG;
  public final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final TextView ynA;
  private final TextView ynB;
  private int ynC;
  private long ynD;
  private long ynE;
  private final f ynF;
  private final TextView ynz;
  
  static
  {
    AppMethodBeat.i(286879);
    ynG = new a((byte)0);
    AppMethodBeat.o(286879);
  }
  
  public x(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(286878);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveAnchorPausePlugin";
    this.ynz = ((TextView)paramViewGroup.findViewById(b.f.pause_time_tips_tv));
    this.ynA = ((TextView)paramViewGroup.findViewById(b.f.pause_time_tv));
    this.ynB = ((TextView)paramViewGroup.findViewById(b.f.resume_live_tv));
    this.ynE = 10L;
    paramViewGroup.setOnClickListener((View.OnClickListener)x.1.ynH);
    this.ynB.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(271033);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = aj.AGc;
        if (aj.isFastClick())
        {
          Log.i(x.b(this.ynI), "reset pause click too fast!");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(271033);
          return;
        }
        x.d(this.ynI);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(271033);
      }
    });
    paramViewGroup = this.ynz;
    p.j(paramViewGroup, "livePauseTipsTv");
    ar.a((Paint)paramViewGroup.getPaint(), 0.8F);
    paramViewGroup = this.ynA;
    p.j(paramViewGroup, "livePauseTimeTv");
    ar.a((Paint)paramViewGroup.getPaint(), 0.8F);
    paramViewGroup = this.ynB;
    p.j(paramViewGroup, "resetLiveTv");
    ar.a((Paint)paramViewGroup.getPaint(), 0.8F);
    this.ynF = g.ar((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(286878);
  }
  
  private final MTimerHandler dAK()
  {
    AppMethodBeat.i(286872);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.ynF.getValue();
    AppMethodBeat.o(286872);
    return localMTimerHandler;
  }
  
  private final void dAN()
  {
    AppMethodBeat.i(286876);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgt;
    if (1L > l2) {}
    for (int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgu;; i = (int)((l1 - ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgt) / 1000L))
    {
      this.ynC = i;
      Log.printInfoStack(this.TAG, "showLivePauseView curTime:" + l1 + ", anchorPauseStartTime:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgt + ", anchorPauseTimeCount:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgu + ", remainTime:" + this.ynC, new Object[0]);
      if (this.ynC >= 0) {
        break label262;
      }
      tU(8);
      localObject1 = this.kiF.getContext();
      localObject2 = this.kiF.getContext();
      p.j(localObject2, "root.context");
      w.makeText((Context)localObject1, (CharSequence)((Context)localObject2).getResources().getString(b.j.finder_live_pause_fail_tips), 0).show();
      Log.e(this.TAG, "show pause live error,remain time:" + this.ynC + " illegal!");
      AppMethodBeat.o(286876);
      return;
      if (l1 <= l2) {
        break;
      }
    }
    label262:
    Object localObject1 = this.ynA;
    p.j(localObject1, "livePauseTimeTv");
    Object localObject2 = r.kvH;
    ((TextView)localObject1).setText((CharSequence)r.a.H(this.ynC, ":"));
    dAn().fillBlurBg(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, true);
    dAn().showBlurBg();
    tU(0);
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.dxN();
    if (localObject1 != null)
    {
      localObject2 = (u)getPlugin(u.class);
      if (localObject2 != null)
      {
        localObject2 = ((u)localObject2).xYU;
        if (localObject2 != null) {
          ((a.a)localObject2).b((aq)localObject1, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgj.fFw);
        }
      }
    }
    localObject1 = ah.yhC;
    localObject1 = ah.dzB();
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.a.b)localObject1).aLE();
    }
    dAK().stopTimer();
    dAK().startTimer(1000L);
    AppMethodBeat.o(286876);
  }
  
  public final void dAL()
  {
    AppMethodBeat.i(286873);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(286873);
  }
  
  public final void dAM()
  {
    AppMethodBeat.i(286875);
    if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) && (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, 524288)) && (!com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, 32))) {
      dAN();
    }
    AppMethodBeat.o(286875);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(286874);
    p.k(paramc, "status");
    switch (y.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(286874);
      return;
      if (paramBundle != null) {}
      for (boolean bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_ANCHOR_PAUSE_RECOVERY", false);; bool = false)
      {
        Log.printInfoStack(this.TAG, "resumeLiveLogic showRecoveryView:".concat(String.valueOf(bool)), new Object[0]);
        tU(8);
        dAK().stopTimer();
        com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default(dAn(), false, 1, null);
        if (bool) {
          break label150;
        }
        paramc = ah.yhC;
        paramc = ah.dzB();
        if (paramc == null) {
          break;
        }
        paramc.aLF();
        AppMethodBeat.o(286874);
        return;
      }
      AppMethodBeat.o(286874);
      return;
      label150:
      b.b.a(this.kCL, b.c.kBx);
      AppMethodBeat.o(286874);
      return;
      dAM();
      AppMethodBeat.o(286874);
      return;
      if (this.kiF.getVisibility() == 0)
      {
        Log.i(this.TAG, "anchor verification start, hide pause plugin");
        tU(8);
        dAK().stopTimer();
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(286877);
    dAK().stopTimer();
    AppMethodBeat.o(286877);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin$Companion;", "", "()V", "PAUSE_TIME_MAX_ERROR_VALUE", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    b(x paramx)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<MTimerHandler>
  {
    c(x paramx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.x
 * JD-Core Version:    0.7.0.1
 */
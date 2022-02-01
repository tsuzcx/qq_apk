package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.model.r;
import com.tencent.mm.live.model.r.a;
import com.tencent.mm.plugin.finder.live.component.j.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.live.model.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "ERR_STATE_THRESHOLD", "", "TAG", "", "errStateCount", "livePauseTimeTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "livePauseTipsTv", "pauseTime", "", "resetLiveTv", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimerThread", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timerThread$delegate", "Lkotlin/Lazy;", "checkAnchorPauseLive", "", "checkPauseState", "hide", "onTimerUpdate", "resumeLive", "resumeLiveLogic", "showRecoveryView", "", "showLivePauseView", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends b
{
  public static final w.a CWr;
  private final TextView CWs;
  private final TextView CWt;
  private final TextView CWu;
  private int CWv;
  private long CWw;
  private long CWx;
  private final kotlin.j CWy;
  public final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(353987);
    CWr = new w.a((byte)0);
    AppMethodBeat.o(353987);
  }
  
  public w(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(353891);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveAnchorPausePlugin";
    this.CWs = ((TextView)paramViewGroup.findViewById(p.e.BZf));
    this.CWt = ((TextView)paramViewGroup.findViewById(p.e.BZg));
    this.CWu = ((TextView)paramViewGroup.findViewById(p.e.Cas));
    this.CWx = 10L;
    paramViewGroup.setOnClickListener(w..ExternalSyntheticLambda1.INSTANCE);
    this.CWu.setOnClickListener(new w..ExternalSyntheticLambda0(this));
    com.tencent.mm.ui.aw.a((Paint)this.CWs.getPaint(), 0.8F);
    com.tencent.mm.ui.aw.a((Paint)this.CWt.getPaint(), 0.8F);
    com.tencent.mm.ui.aw.a((Paint)this.CWu.getPaint(), 0.8F);
    this.CWy = k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(353891);
  }
  
  private static final void a(w paramw, View paramView)
  {
    AppMethodBeat.i(353950);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramw);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramw, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.isFastClick())
    {
      Log.i(paramw.TAG, "reset pause click too fast!");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(353950);
      return;
    }
    paramView = paramw.nfT;
    localObject1 = b.c.neX;
    localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("PARAM_FINDER_LIVE_ANCHOR_PAUSE_RECOVERY", true);
    ah localah = ah.aiuX;
    paramView.statusChange((b.c)localObject1, (Bundle)localObject2);
    com.tencent.mm.plugin.finder.live.report.j.Dob.hJ(2, paramw.CWv);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353950);
  }
  
  private static final void dg(View paramView)
  {
    AppMethodBeat.i(353935);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPausePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353935);
  }
  
  private final MTimerHandler ept()
  {
    AppMethodBeat.i(353902);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.CWy.getValue();
    AppMethodBeat.o(353902);
    return localMTimerHandler;
  }
  
  private final void epw()
  {
    AppMethodBeat.i(353927);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = ((e)business(e.class)).Een;
    if (1L <= l2) {
      if (l2 < l1)
      {
        i = 1;
        if (i == 0) {
          break label252;
        }
      }
    }
    label252:
    for (int i = (int)((l1 - ((e)business(e.class)).Een) / 1000L);; i = ((e)business(e.class)).Eeo)
    {
      this.CWv = i;
      Log.printInfoStack(this.TAG, "showLivePauseView curTime:" + l1 + ", anchorPauseStartTime:" + ((e)business(e.class)).Een + ", anchorPauseTimeCount:" + ((e)business(e.class)).Eeo + ", remainTime:" + this.CWv, new Object[0]);
      if (this.CWv >= 0) {
        break label269;
      }
      tO(8);
      aa.makeText(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getResources().getString(p.h.Cqo), 0).show();
      Log.e(this.TAG, "show pause live error,remain time:" + this.CWv + " illegal!");
      AppMethodBeat.o(353927);
      return;
      i = 0;
      break;
      i = 0;
      break;
    }
    label269:
    Object localObject1 = this.CWt;
    Object localObject2 = r.mZi;
    ((TextView)localObject1).setText((CharSequence)r.a.I(this.CWv, ":"));
    eoH().fillBlurBg(((e)business(e.class)).mIC, true);
    eoH().showBlurBg();
    tO(0);
    localObject1 = ((e)business(e.class)).Eee.ekc();
    if (localObject1 != null)
    {
      localObject2 = (u)getPlugin(u.class);
      if (localObject2 != null)
      {
        localObject2 = ((u)localObject2).CwN;
        if (localObject2 != null) {
          ((j.a)localObject2).b((at)localObject1, ((e)business(e.class)).Eee.hKr);
        }
      }
    }
    localObject1 = aj.CGT;
    localObject1 = aj.elM();
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.a.b)localObject1).bfe();
    }
    ept().stopTimer();
    ept().startTimer(1000L);
    AppMethodBeat.o(353927);
  }
  
  public final void epu()
  {
    AppMethodBeat.i(354007);
    d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(354007);
  }
  
  public final void epv()
  {
    AppMethodBeat.i(354022);
    if ((((e)business(e.class)).isLiveStarted()) && (d.ee(((e)business(e.class)).EcS, 524288)) && (!d.ee(((e)business(e.class)).EcS, 32))) {
      epw();
    }
    AppMethodBeat.o(354022);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354014);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354014);
      return;
      if (paramBundle == null) {}
      for (boolean bool = false;; bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_ANCHOR_PAUSE_RECOVERY", false))
      {
        Log.printInfoStack(this.TAG, s.X("resumeLiveLogic showRecoveryView:", Boolean.valueOf(bool)), new Object[0]);
        tO(8);
        ept().stopTimer();
        com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default(eoH(), false, 1, null);
        if (bool) {
          break;
        }
        paramc = aj.CGT;
        paramc = aj.elM();
        if (paramc == null) {
          break label154;
        }
        paramc.bff();
        AppMethodBeat.o(354014);
        return;
      }
      b.b.a(this.nfT, b.c.neY);
      label154:
      AppMethodBeat.o(354014);
      return;
      epv();
      AppMethodBeat.o(354014);
      return;
      if (this.mJe.getVisibility() == 0)
      {
        Log.i(this.TAG, "anchor verification start, hide pause plugin");
        tO(8);
        ept().stopTimer();
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354031);
    ept().stopTimer();
    AppMethodBeat.o(354031);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(w paramw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<MTimerHandler>
  {
    d(w paramw)
    {
      super();
    }
    
    private static final boolean e(w paramw)
    {
      AppMethodBeat.i(353667);
      s.u(paramw, "this$0");
      d.uiThread((kotlin.g.a.a)new a(paramw));
      AppMethodBeat.o(353667);
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(w paramw)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.w
 * JD-Core Version:    0.7.0.1
 */
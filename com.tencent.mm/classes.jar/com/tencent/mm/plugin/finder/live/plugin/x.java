package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.cgi.al.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPauseRecoveryPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "countdownTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "onlyShowView", "", "recoveryTips", "remainTime", "", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimerThread", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timerThread$delegate", "Lkotlin/Lazy;", "handleResumeLiveResp", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "onTimerUpdate", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends b
{
  private final TextView CWA;
  private final TextView CWB;
  private int CWC;
  private boolean CWD;
  private final j CWy;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public x(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(353909);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveAnchorPauseRecoveryPlugin";
    this.CWA = ((TextView)paramViewGroup.findViewById(p.e.BCx));
    this.CWB = ((TextView)paramViewGroup.findViewById(p.e.Cai));
    this.CWC = 3;
    paramViewGroup.setOnClickListener(x..ExternalSyntheticLambda0.INSTANCE);
    aw.a((Paint)this.CWA.getPaint(), 0.8F);
    aw.a((Paint)this.CWB.getPaint(), 0.8F);
    this.CWy = k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(353909);
  }
  
  private static final void dg(View paramView)
  {
    AppMethodBeat.i(353932);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPauseRecoveryPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPauseRecoveryPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353932);
  }
  
  private final MTimerHandler ept()
  {
    AppMethodBeat.i(353917);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.CWy.getValue();
    AppMethodBeat.o(353917);
    return localMTimerHandler;
  }
  
  private final void show()
  {
    AppMethodBeat.i(353925);
    this.CWC = 3;
    this.CWA.setText((CharSequence)String.valueOf(this.CWC));
    ept().stopTimer();
    ept().startTimer(1000L);
    com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default(eoH(), false, 1, null);
    tO(0);
    AppMethodBeat.o(353925);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(353971);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(353971);
      return;
      this.CWD = false;
      show();
      AppMethodBeat.o(353971);
      return;
      this.CWD = true;
      show();
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(353979);
    ept().stopTimer();
    AppMethodBeat.o(353979);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(int paramInt1, int paramInt2, x paramx)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPauseRecoveryPlugin$onTimerUpdate$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements al.a
  {
    c(x paramx) {}
    
    public final void a(int paramInt1, int paramInt2, bse parambse)
    {
      AppMethodBeat.i(355708);
      s.u(parambse, "resp");
      x.a(this.CWE, paramInt1, paramInt2);
      AppMethodBeat.o(355708);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MTimerHandler>
  {
    d(x paramx)
    {
      super();
    }
    
    private static final boolean d(x paramx)
    {
      AppMethodBeat.i(355679);
      s.u(paramx, "this$0");
      d.uiThread((kotlin.g.a.a)new a(paramx));
      AppMethodBeat.o(355679);
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(x paramx)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.x
 * JD-Core Version:    0.7.0.1
 */
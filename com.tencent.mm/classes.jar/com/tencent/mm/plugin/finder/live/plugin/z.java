package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.ar;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPauseRecoveryPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "countdownTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "onlyShowView", "", "recoveryTips", "remainTime", "", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimerThread", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timerThread$delegate", "Lkotlin/Lazy;", "handleResumeLiveResp", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "onTimerUpdate", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-finder_release"})
public final class z
  extends d
{
  private final String TAG;
  private final b kCL;
  private final f ynF;
  private final TextView ynL;
  private final TextView ynM;
  private int ynN;
  private boolean ynO;
  
  public z(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(266152);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveAnchorPauseRecoveryPlugin";
    this.ynL = ((TextView)paramViewGroup.findViewById(b.f.countdown_tv));
    this.ynM = ((TextView)paramViewGroup.findViewById(b.f.recovery_tips));
    this.ynN = 3;
    paramViewGroup.setOnClickListener((View.OnClickListener)z.1.ynP);
    paramViewGroup = this.ynL;
    p.j(paramViewGroup, "countdownTv");
    ar.a((Paint)paramViewGroup.getPaint(), 0.8F);
    paramViewGroup = this.ynM;
    p.j(paramViewGroup, "recoveryTips");
    ar.a((Paint)paramViewGroup.getPaint(), 0.8F);
    this.ynF = g.ar((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(266152);
  }
  
  private final MTimerHandler dAK()
  {
    AppMethodBeat.i(266148);
    MTimerHandler localMTimerHandler = (MTimerHandler)this.ynF.getValue();
    AppMethodBeat.o(266148);
    return localMTimerHandler;
  }
  
  private final void show()
  {
    AppMethodBeat.i(266150);
    this.ynN = 3;
    TextView localTextView = this.ynL;
    p.j(localTextView, "countdownTv");
    localTextView.setText((CharSequence)String.valueOf(this.ynN));
    dAK().stopTimer();
    dAK().startTimer(1000L);
    com.tencent.mm.plugin.finder.live.view.a.hideLoadingLayer$default(dAn(), false, 1, null);
    tU(0);
    AppMethodBeat.o(266150);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(266149);
    p.k(paramc, "status");
    switch (aa.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(266149);
      return;
      this.ynO = false;
      show();
      AppMethodBeat.o(266149);
      return;
      this.ynO = true;
      show();
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(266151);
    dAK().stopTimer();
    AppMethodBeat.o(266151);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(z paramz, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorPauseRecoveryPlugin$onTimerUpdate$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "plugin-finder_release"})
  public static final class b
    implements ad.a
  {
    public final void a(int paramInt1, int paramInt2, bgo parambgo)
    {
      AppMethodBeat.i(288161);
      p.k(parambgo, "resp");
      z.a(this.ynQ, paramInt1, paramInt2);
      AppMethodBeat.o(288161);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<MTimerHandler>
  {
    c(z paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.z
 * JD-Core Version:    0.7.0.1
 */
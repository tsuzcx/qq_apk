package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.v;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.utils.ba;
import com.tencent.mm.plugin.finder.utils.bb;
import com.tencent.mm.plugin.finder.utils.bb.a;
import com.tencent.mm.plugin.finder.utils.bb.c;
import com.tencent.mm.plugin.findersdk.b.b.a;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "TAG", "", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "cancelLive", "", "onBackPress", "", "reset", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bt
  extends b
{
  private com.tencent.mm.plugin.findersdk.b.b DiB;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private final int njG;
  private final int njH;
  private final Button njI;
  private final TextView njJ;
  private int njK;
  private final MTimerHandler timerHandler;
  
  public bt(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354102);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveReadyPlugin";
    this.njG = 3;
    this.njI = ((Button)paramViewGroup.findViewById(p.e.BRR));
    this.njJ = ((TextView)paramViewGroup.findViewById(p.e.BRS));
    paramViewGroup = (ProgressBar)paramViewGroup.findViewById(p.e.BNo);
    if (paramViewGroup == null) {}
    for (paramViewGroup = null;; paramViewGroup = b.a.a(paramViewGroup))
    {
      this.DiB = paramViewGroup;
      this.njK = this.njG;
      this.timerHandler = new MTimerHandler(new bt..ExternalSyntheticLambda1(this), true);
      this.njI.setOnClickListener(new bt..ExternalSyntheticLambda0(this));
      paramViewGroup = this.DiB;
      if (paramViewGroup != null) {
        paramViewGroup.end();
      }
      AppMethodBeat.o(354102);
      return;
      paramb = com.tencent.mm.plugin.findersdk.b.b.HcE;
    }
  }
  
  private static final void a(bt parambt, View paramView)
  {
    AppMethodBeat.i(354129);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambt, "this$0");
    Log.i(parambt.TAG, "cancel live by click btn.");
    parambt.erH();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354129);
  }
  
  private static final boolean a(bt parambt)
  {
    AppMethodBeat.i(354122);
    kotlin.g.b.s.u(parambt, "this$0");
    if (parambt.njK > parambt.njH)
    {
      parambt.njK -= 1;
      parambt.bjs();
      AppMethodBeat.o(354122);
      return true;
    }
    Object localObject = ba.Gjt;
    bb.a locala = bb.GjM;
    ba.a((ba)localObject, bb.fhw().name, null, false, false, 14);
    b.b.a(parambt.nfT, b.c.ndh);
    localObject = parambt.DiB;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.b.b)localObject).begin();
    }
    parambt.njJ.setVisibility(8);
    parambt.njI.setVisibility(8);
    AppMethodBeat.o(354122);
    return false;
  }
  
  private final void bjs()
  {
    AppMethodBeat.i(354117);
    this.njJ.setVisibility(0);
    this.njJ.setText((CharSequence)String.valueOf(this.njK));
    AppMethodBeat.o(354117);
  }
  
  private final void erH()
  {
    AppMethodBeat.i(354111);
    this.timerHandler.stopTimer();
    reset();
    b.b.a(this.nfT, b.c.nch);
    b.b.a(this.nfT, b.c.nde);
    Object localObject = ba.Gjt;
    bb.a locala = bb.GjM;
    ba.a((ba)localObject, bb.fhC().name, null, false, true, 6);
    ((f)business(f.class)).setLiveInfo(new bip());
    if (this.nfT.getLiveRole() == 1)
    {
      j.Dob.C(q.a.DqN.mwI, "1");
      localObject = j.Dob;
      j.b(q.v.DwL);
    }
    AppMethodBeat.o(354111);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(354188);
    if (this.mJe.getVisibility() == 0)
    {
      Log.i(this.TAG, "cancel live by click back.");
      erH();
      AppMethodBeat.o(354188);
      return true;
    }
    AppMethodBeat.o(354188);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(354156);
    this.njJ.setScaleX(1.0F);
    this.njJ.setScaleY(1.0F);
    this.njK = this.njG;
    com.tencent.mm.plugin.findersdk.b.b localb = this.DiB;
    if (localb != null) {
      localb.end();
    }
    AppMethodBeat.o(354156);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354171);
    kotlin.g.b.s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354171);
      return;
      Log.printInfoStack(this.TAG, "ILiveStatusLiveStatusREADY", new Object[0]);
      tO(0);
      this.njI.setVisibility(0);
      bjs();
      this.timerHandler.startTimer(1000L, 1000L);
      paramc = this.DiB;
      if (paramc != null) {
        paramc.end();
      }
      AppMethodBeat.o(354171);
      return;
      tO(8);
      AppMethodBeat.o(354171);
      return;
      paramc = aj.CGT;
      paramc = aj.getFinderLiveAssistant();
      if (paramc != null) {
        ap.a.a(paramc, (kotlin.g.a.s)new bt.b(this));
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354164);
    super.tO(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354164);
      return;
      this.timerHandler.stopTimer();
      reset();
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354179);
    super.unMount();
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(354179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bt
 * JD-Core Version:    0.7.0.1
 */
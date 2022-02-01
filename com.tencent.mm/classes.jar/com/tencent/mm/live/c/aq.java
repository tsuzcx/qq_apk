package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.u;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-logic_release"})
public final class aq
  extends a
{
  private final b kCL;
  private final int kGL;
  private final int kGM;
  private final Button kGN;
  private final TextView kGO;
  private int kGP;
  private final MTimerHandler timerHandler;
  
  public aq(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(197683);
    this.kCL = paramb;
    this.kGL = 3;
    this.kGN = ((Button)paramViewGroup.findViewById(b.e.live_ready_cancel_btn));
    this.kGO = ((TextView)paramViewGroup.findViewById(b.e.live_ready_count_down_tv));
    this.kGP = this.kGL;
    this.timerHandler = new MTimerHandler((MTimerHandler.CallBack)new a(this), true);
    this.kGN.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192708);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        aq.e(this.kGQ).stopTimer();
        aq.f(this.kGQ);
        paramAnonymousView = u.kwz;
        u.a(new crq());
        b.b.a(aq.g(this.kGQ), b.c.kyS);
        b.b.a(aq.g(this.kGQ), b.c.kzO);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192708);
      }
    });
    AppMethodBeat.o(197683);
  }
  
  private final void aPE()
  {
    AppMethodBeat.i(197659);
    TextView localTextView = this.kGO;
    p.j(localTextView, "countDownTv");
    localTextView.setText((CharSequence)String.valueOf(this.kGP));
    localTextView = this.kGO;
    p.j(localTextView, "countDownTv");
    localTextView.setScaleX(1.5F);
    localTextView = this.kGO;
    p.j(localTextView, "countDownTv");
    localTextView.setScaleY(1.5F);
    this.kGO.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).start();
    AppMethodBeat.o(197659);
  }
  
  private final void reset()
  {
    AppMethodBeat.i(197655);
    TextView localTextView = this.kGO;
    p.j(localTextView, "countDownTv");
    localTextView.setScaleX(1.0F);
    localTextView = this.kGO;
    p.j(localTextView, "countDownTv");
    localTextView.setScaleY(1.0F);
    this.kGP = this.kGL;
    AppMethodBeat.o(197655);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(197676);
    if (this.kiF.getVisibility() == 0)
    {
      this.timerHandler.stopTimer();
      reset();
      u localu = u.kwz;
      u.a(new crq());
      b.b.a(this.kCL, b.c.kyS);
      AppMethodBeat.o(197676);
      return true;
    }
    AppMethodBeat.o(197676);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(197666);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ar.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(197666);
      return;
      tU(0);
      aPE();
      this.timerHandler.startTimer(1000L, 1000L);
      AppMethodBeat.o(197666);
      return;
      tU(8);
      AppMethodBeat.o(197666);
      return;
      paramc = u.kwz;
      u.fr(true);
      com.tencent.mm.live.d.a.aPV();
    }
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(197661);
    super.tU(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      this.timerHandler.stopTimer();
      reset();
    }
    AppMethodBeat.o(197661);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(197670);
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(197670);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    a(aq paramaq) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(191386);
      if (aq.a(this.kGQ) > aq.b(this.kGQ))
      {
        aq localaq = this.kGQ;
        aq.a(localaq, aq.a(localaq) - 1);
        aq.c(this.kGQ);
        AppMethodBeat.o(191386);
        return true;
      }
      aq.d(this.kGQ);
      AppMethodBeat.o(191386);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.aq
 * JD-Core Version:    0.7.0.1
 */
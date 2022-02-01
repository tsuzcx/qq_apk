package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.x;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-logic_release"})
public final class aq
  extends a
{
  final b hOp;
  private final int hSo;
  final int hSp;
  private final Button hSq;
  private final TextView hSr;
  int hSs;
  final MTimerHandler timerHandler;
  
  public aq(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208151);
    this.hOp = paramb;
    this.hSo = 3;
    this.hSq = ((Button)paramViewGroup.findViewById(2131303508));
    this.hSr = ((TextView)paramViewGroup.findViewById(2131303510));
    this.hSs = this.hSo;
    this.timerHandler = new MTimerHandler((MTimerHandler.CallBack)new a(this), true);
    this.hSq.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208142);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.hSt.timerHandler.stopTimer();
        this.hSt.reset();
        paramAnonymousView = x.hJf;
        x.a(new civ());
        b.b.a(this.hSt.hOp, b.c.hLy);
        b.b.a(this.hSt.hOp, b.c.hMt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208142);
      }
    });
    AppMethodBeat.o(208151);
  }
  
  final void aHG()
  {
    AppMethodBeat.i(208146);
    TextView localTextView = this.hSr;
    p.g(localTextView, "countDownTv");
    localTextView.setText((CharSequence)String.valueOf(this.hSs));
    localTextView = this.hSr;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleX(1.5F);
    localTextView = this.hSr;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleY(1.5F);
    this.hSr.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).start();
    AppMethodBeat.o(208146);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(208150);
    if (this.hwr.getVisibility() == 0)
    {
      this.timerHandler.stopTimer();
      reset();
      x localx = x.hJf;
      x.a(new civ());
      b.b.a(this.hOp, b.c.hLy);
      AppMethodBeat.o(208150);
      return true;
    }
    AppMethodBeat.o(208150);
    return false;
  }
  
  final void reset()
  {
    AppMethodBeat.i(208145);
    TextView localTextView = this.hSr;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleX(1.0F);
    localTextView = this.hSr;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleY(1.0F);
    this.hSs = this.hSo;
    AppMethodBeat.o(208145);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(208147);
    super.rg(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      this.timerHandler.stopTimer();
      reset();
    }
    AppMethodBeat.o(208147);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208148);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ar.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208148);
      return;
      rg(0);
      aHG();
      this.timerHandler.startTimer(1000L, 1000L);
      AppMethodBeat.o(208148);
      return;
      rg(8);
      AppMethodBeat.o(208148);
      return;
      paramc = x.hJf;
      x.eL(true);
      com.tencent.mm.live.d.a.aHX();
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(208149);
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(208149);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    a(aq paramaq) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(208144);
      if (this.hSt.hSs > this.hSt.hSp)
      {
        aq localaq = this.hSt;
        localaq.hSs -= 1;
        this.hSt.aHG();
        AppMethodBeat.o(208144);
        return true;
      }
      b.b.a(this.hSt.hOp, b.c.hMw);
      AppMethodBeat.o(208144);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.aq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-logic_release"})
public final class aq
  extends a
{
  final b gSM;
  private final int gWG;
  final int gWH;
  private final Button gWI;
  private final TextView gWJ;
  int gWK;
  final av timerHandler;
  
  public aq(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212563);
    this.gSM = paramb;
    this.gWG = 3;
    this.gWI = ((Button)paramViewGroup.findViewById(2131307722));
    this.gWJ = ((TextView)paramViewGroup.findViewById(2131307724));
    this.gWK = this.gWG;
    this.timerHandler = new av((av.a)new a(this), true);
    this.gWI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212554);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.gWL.timerHandler.stopTimer();
        this.gWL.reset();
        paramAnonymousView = g.gOr;
        g.a(new buq());
        b.b.a(this.gWL.gSM, b.c.gRr);
        b.b.a(this.gWL.gSM, b.c.gSl);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212554);
      }
    });
    AppMethodBeat.o(212563);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212560);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ar.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212560);
      return;
      nI(0);
      aoS();
      this.timerHandler.az(1000L, 1000L);
      AppMethodBeat.o(212560);
      return;
      nI(8);
      AppMethodBeat.o(212560);
      return;
      paramc = g.gOr;
      g.dO(true);
      com.tencent.mm.live.d.a.apk();
    }
  }
  
  public final void aoA()
  {
    AppMethodBeat.i(212561);
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(212561);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(212562);
    if (this.gGK.getVisibility() == 0)
    {
      this.timerHandler.stopTimer();
      reset();
      g localg = g.gOr;
      g.a(new buq());
      b.b.a(this.gSM, b.c.gRr);
      AppMethodBeat.o(212562);
      return true;
    }
    AppMethodBeat.o(212562);
    return false;
  }
  
  final void aoS()
  {
    AppMethodBeat.i(212558);
    TextView localTextView = this.gWJ;
    p.g(localTextView, "countDownTv");
    localTextView.setText((CharSequence)String.valueOf(this.gWK));
    localTextView = this.gWJ;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleX(1.5F);
    localTextView = this.gWJ;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleY(1.5F);
    this.gWJ.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).start();
    AppMethodBeat.o(212558);
  }
  
  public final void nI(int paramInt)
  {
    AppMethodBeat.i(212559);
    super.nI(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      this.timerHandler.stopTimer();
      reset();
    }
    AppMethodBeat.o(212559);
  }
  
  final void reset()
  {
    AppMethodBeat.i(212557);
    TextView localTextView = this.gWJ;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleX(1.0F);
    localTextView = this.gWJ;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleY(1.0F);
    this.gWK = this.gWG;
    AppMethodBeat.o(212557);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements av.a
  {
    a(aq paramaq) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(212556);
      if (this.gWL.gWK > this.gWL.gWH)
      {
        aq localaq = this.gWL;
        localaq.gWK -= 1;
        this.gWL.aoS();
        AppMethodBeat.o(212556);
        return true;
      }
      b.b.a(this.gWL.gSM, b.c.gSo);
      AppMethodBeat.o(212556);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.aq
 * JD-Core Version:    0.7.0.1
 */
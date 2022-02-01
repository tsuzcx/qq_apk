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
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-logic_release"})
public final class aq
  extends a
{
  final b gVv;
  private final int gZt;
  final int gZu;
  private final Button gZv;
  private final TextView gZw;
  int gZx;
  final aw timerHandler;
  
  public aq(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216189);
    this.gVv = paramb;
    this.gZt = 3;
    this.gZv = ((Button)paramViewGroup.findViewById(2131307722));
    this.gZw = ((TextView)paramViewGroup.findViewById(2131307724));
    this.gZx = this.gZt;
    this.timerHandler = new aw((aw.a)new a(this), true);
    this.gZv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216180);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        this.gZy.timerHandler.stopTimer();
        this.gZy.reset();
        paramAnonymousView = g.gQZ;
        g.a(new bvk());
        b.b.a(this.gZy.gVv, b.c.gTZ);
        b.b.a(this.gZy.gVv, b.c.gUT);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216180);
      }
    });
    AppMethodBeat.o(216189);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216186);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ar.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216186);
      return;
      nL(0);
      apg();
      this.timerHandler.ay(1000L, 1000L);
      AppMethodBeat.o(216186);
      return;
      nL(8);
      AppMethodBeat.o(216186);
      return;
      paramc = g.gQZ;
      g.dP(true);
      com.tencent.mm.live.d.a.apy();
    }
  }
  
  public final void aoP()
  {
    AppMethodBeat.i(216187);
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(216187);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(216188);
    if (this.gJt.getVisibility() == 0)
    {
      this.timerHandler.stopTimer();
      reset();
      g localg = g.gQZ;
      g.a(new bvk());
      b.b.a(this.gVv, b.c.gTZ);
      AppMethodBeat.o(216188);
      return true;
    }
    AppMethodBeat.o(216188);
    return false;
  }
  
  final void apg()
  {
    AppMethodBeat.i(216184);
    TextView localTextView = this.gZw;
    p.g(localTextView, "countDownTv");
    localTextView.setText((CharSequence)String.valueOf(this.gZx));
    localTextView = this.gZw;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleX(1.5F);
    localTextView = this.gZw;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleY(1.5F);
    this.gZw.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).start();
    AppMethodBeat.o(216184);
  }
  
  public final void nL(int paramInt)
  {
    AppMethodBeat.i(216185);
    super.nL(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      this.timerHandler.stopTimer();
      reset();
    }
    AppMethodBeat.o(216185);
  }
  
  final void reset()
  {
    AppMethodBeat.i(216183);
    TextView localTextView = this.gZw;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleX(1.0F);
    localTextView = this.gZw;
    p.g(localTextView, "countDownTv");
    localTextView.setScaleY(1.0F);
    this.gZx = this.gZt;
    AppMethodBeat.o(216183);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements aw.a
  {
    a(aq paramaq) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(216182);
      if (this.gZy.gZx > this.gZy.gZu)
      {
        aq localaq = this.gZy;
        localaq.gZx -= 1;
        this.gZy.apg();
        AppMethodBeat.o(216182);
        return true;
      }
      b.b.a(this.gZy.gVv, b.c.gUW);
      AppMethodBeat.o(216182);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.aq
 * JD-Core Version:    0.7.0.1
 */
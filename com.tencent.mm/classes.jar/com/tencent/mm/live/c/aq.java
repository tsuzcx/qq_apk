package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.f;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-logic_release"})
public final class aq
  extends a
{
  final b IIs;
  private final int KwH;
  final int KwI;
  private final TextView KwJ;
  int KwK;
  private final Button hJg;
  final av timerHandler;
  
  public aq(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(203039);
    this.IIs = paramb;
    this.KwH = 3;
    this.hJg = ((Button)paramViewGroup.findViewById(2131307639));
    this.KwJ = ((TextView)paramViewGroup.findViewById(2131307641));
    this.KwK = this.KwH;
    this.timerHandler = new av((av.a)new a(this), true);
    this.hJg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203030);
        this.KwL.timerHandler.stopTimer();
        this.KwL.reset();
        paramAnonymousView = f.rGw;
        f.a(new eas());
        b.b.a(this.KwL.IIs, b.c.FAS);
        b.b.a(this.KwL.IIs, b.c.HRP);
        AppMethodBeat.o(203030);
      }
    });
    AppMethodBeat.o(203039);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(203036);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ar.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203036);
      return;
      agK(0);
      fOX();
      this.timerHandler.av(1000L, 1000L);
      AppMethodBeat.o(203036);
      return;
      agK(8);
      AppMethodBeat.o(203036);
      return;
      paramc = f.rGw;
      f.la(true);
      com.tencent.mm.live.d.a.fPl();
    }
  }
  
  public final void agK(int paramInt)
  {
    AppMethodBeat.i(203035);
    super.agK(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      this.timerHandler.stopTimer();
      reset();
    }
    AppMethodBeat.o(203035);
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(203038);
    if (this.pTc.getVisibility() == 0)
    {
      this.timerHandler.stopTimer();
      reset();
      f localf = f.rGw;
      f.a(new eas());
      b.b.a(this.IIs, b.c.FAS);
      AppMethodBeat.o(203038);
      return true;
    }
    AppMethodBeat.o(203038);
    return false;
  }
  
  public final void fON()
  {
    AppMethodBeat.i(203037);
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(203037);
  }
  
  final void fOX()
  {
    AppMethodBeat.i(203034);
    TextView localTextView = this.KwJ;
    k.g(localTextView, "countDownTv");
    localTextView.setText((CharSequence)String.valueOf(this.KwK));
    localTextView = this.KwJ;
    k.g(localTextView, "countDownTv");
    localTextView.setScaleX(1.5F);
    localTextView = this.KwJ;
    k.g(localTextView, "countDownTv");
    localTextView.setScaleY(1.5F);
    this.KwJ.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).start();
    AppMethodBeat.o(203034);
  }
  
  final void reset()
  {
    AppMethodBeat.i(203033);
    TextView localTextView = this.KwJ;
    k.g(localTextView, "countDownTv");
    localTextView.setScaleX(1.0F);
    localTextView = this.KwJ;
    k.g(localTextView, "countDownTv");
    localTextView.setScaleY(1.0F);
    this.KwK = this.KwH;
    AppMethodBeat.o(203033);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements av.a
  {
    a(aq paramaq) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(203032);
      if (this.KwL.KwK > this.KwL.KwI)
      {
        aq localaq = this.KwL;
        localaq.KwK -= 1;
        this.KwL.fOX();
        AppMethodBeat.o(203032);
        return true;
      }
      b.b.a(this.KwL.IIs, b.c.HRS);
      AppMethodBeat.o(203032);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.aq
 * JD-Core Version:    0.7.0.1
 */
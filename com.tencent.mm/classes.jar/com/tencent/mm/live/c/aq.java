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
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-logic_release"})
public final class aq
  extends a
{
  private final int gCW;
  final int gCX;
  private final Button gCY;
  private final TextView gCZ;
  int gDa;
  final b gzb;
  final au timerHandler;
  
  public aq(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190273);
    this.gzb = paramb;
    this.gCW = 3;
    this.gCY = ((Button)paramViewGroup.findViewById(2131307722));
    this.gCZ = ((TextView)paramViewGroup.findViewById(2131307724));
    this.gDa = this.gCW;
    this.timerHandler = new au((au.a)new a(this), true);
    this.gCY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190264);
        this.gDb.timerHandler.stopTimer();
        this.gDb.reset();
        paramAnonymousView = g.guG;
        g.a(new bqd());
        b.b.a(this.gDb.gzb, b.c.gxG);
        b.b.a(this.gDb.gzb, b.c.gyA);
        AppMethodBeat.o(190264);
      }
    });
    AppMethodBeat.o(190273);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190270);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ar.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190270);
      return;
      nj(0);
      amf();
      this.timerHandler.au(1000L, 1000L);
      AppMethodBeat.o(190270);
      return;
      nj(8);
      AppMethodBeat.o(190270);
      return;
      paramc = g.guG;
      g.dM(true);
      com.tencent.mm.live.d.a.amx();
    }
  }
  
  public final void alN()
  {
    AppMethodBeat.i(190271);
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(190271);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(190272);
    if (this.gnb.getVisibility() == 0)
    {
      this.timerHandler.stopTimer();
      reset();
      g localg = g.guG;
      g.a(new bqd());
      b.b.a(this.gzb, b.c.gxG);
      AppMethodBeat.o(190272);
      return true;
    }
    AppMethodBeat.o(190272);
    return false;
  }
  
  final void amf()
  {
    AppMethodBeat.i(190268);
    TextView localTextView = this.gCZ;
    k.g(localTextView, "countDownTv");
    localTextView.setText((CharSequence)String.valueOf(this.gDa));
    localTextView = this.gCZ;
    k.g(localTextView, "countDownTv");
    localTextView.setScaleX(1.5F);
    localTextView = this.gCZ;
    k.g(localTextView, "countDownTv");
    localTextView.setScaleY(1.5F);
    this.gCZ.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).start();
    AppMethodBeat.o(190268);
  }
  
  public final void nj(int paramInt)
  {
    AppMethodBeat.i(190269);
    super.nj(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      this.timerHandler.stopTimer();
      reset();
    }
    AppMethodBeat.o(190269);
  }
  
  final void reset()
  {
    AppMethodBeat.i(190267);
    TextView localTextView = this.gCZ;
    k.g(localTextView, "countDownTv");
    localTextView.setScaleX(1.0F);
    localTextView = this.gCZ;
    k.g(localTextView, "countDownTv");
    localTextView.setScaleY(1.0F);
    this.gDa = this.gCW;
    AppMethodBeat.o(190267);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements au.a
  {
    a(aq paramaq) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(190266);
      if (this.gDb.gDa > this.gDb.gCX)
      {
        aq localaq = this.gDb;
        localaq.gDa -= 1;
        this.gDb.amf();
        AppMethodBeat.o(190266);
        return true;
      }
      b.b.a(this.gDb.gzb, b.c.gyD);
      AppMethodBeat.o(190266);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.aq
 * JD-Core Version:    0.7.0.1
 */
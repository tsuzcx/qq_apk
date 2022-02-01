package com.tencent.mm.live.b;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.model.u;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveReadyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends a
{
  private final b nfT;
  private final int njG;
  private final int njH;
  private final Button njI;
  private final TextView njJ;
  private int njK;
  private final MTimerHandler timerHandler;
  
  public x(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247221);
    this.nfT = paramb;
    this.njG = 3;
    this.njI = ((Button)paramViewGroup.findViewById(b.e.live_ready_cancel_btn));
    this.njJ = ((TextView)paramViewGroup.findViewById(b.e.live_ready_count_down_tv));
    this.njK = this.njG;
    this.timerHandler = new MTimerHandler(new x..ExternalSyntheticLambda1(this), true);
    this.njI.setOnClickListener(new x..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(247221);
  }
  
  private static final void a(x paramx, View paramView)
  {
    AppMethodBeat.i(247261);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramx);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveReadyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramx, "this$0");
    paramx.timerHandler.stopTimer();
    paramx.reset();
    paramView = u.mZl;
    u.a(new dio());
    b.b.a(paramx.nfT, b.c.nch);
    b.b.a(paramx.nfT, b.c.nde);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveReadyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247261);
  }
  
  private static final boolean a(x paramx)
  {
    AppMethodBeat.i(247251);
    s.u(paramx, "this$0");
    if (paramx.njK > paramx.njH)
    {
      paramx.njK -= 1;
      paramx.bjs();
      AppMethodBeat.o(247251);
      return true;
    }
    b.b.a(paramx.nfT, b.c.ndh);
    AppMethodBeat.o(247251);
    return false;
  }
  
  private final void bjs()
  {
    AppMethodBeat.i(247241);
    this.njJ.setText((CharSequence)String.valueOf(this.njK));
    this.njJ.setScaleX(1.5F);
    this.njJ.setScaleY(1.5F);
    this.njJ.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).start();
    AppMethodBeat.o(247241);
  }
  
  private final void reset()
  {
    AppMethodBeat.i(247230);
    this.njJ.setScaleX(1.0F);
    this.njJ.setScaleY(1.0F);
    this.njK = this.njG;
    AppMethodBeat.o(247230);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(247300);
    if (this.mJe.getVisibility() == 0)
    {
      this.timerHandler.stopTimer();
      reset();
      u localu = u.mZl;
      u.a(new dio());
      b.b.a(this.nfT, b.c.nch);
      AppMethodBeat.o(247300);
      return true;
    }
    AppMethodBeat.o(247300);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247288);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (x.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247288);
      return;
      tO(0);
      bjs();
      this.timerHandler.startTimer(1000L, 1000L);
      AppMethodBeat.o(247288);
      return;
      tO(8);
      AppMethodBeat.o(247288);
      return;
      paramc = u.mZl;
      u.fY(true);
      com.tencent.mm.live.c.a.bjI();
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(247281);
    super.tO(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247281);
      return;
      this.timerHandler.stopTimer();
      reset();
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(247293);
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(247293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.x
 * JD-Core Version:    0.7.0.1
 */
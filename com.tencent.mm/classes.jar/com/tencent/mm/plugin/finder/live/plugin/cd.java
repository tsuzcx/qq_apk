package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an.a;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.a;
import com.tencent.mm.plugin.finder.live.report.s.s;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.utils.ao;
import com.tencent.mm.plugin.finder.utils.ap;
import com.tencent.mm.plugin.finder.utils.ap.a;
import com.tencent.mm.plugin.finder.utils.ap.c;
import com.tencent.mm.plugin.findersdk.b.b.a;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "TAG", "", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-finder_release"})
public final class cd
  extends d
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final int kGL;
  private final int kGM;
  private final Button kGN;
  private final TextView kGO;
  private int kGP;
  private final MTimerHandler timerHandler;
  private com.tencent.mm.plugin.findersdk.b.b ywG;
  
  public cd(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(281063);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveReadyPlugin";
    this.kGL = 3;
    this.kGN = ((Button)paramViewGroup.findViewById(b.f.finder_live_ready_cancel_btn));
    this.kGO = ((TextView)paramViewGroup.findViewById(b.f.finder_live_ready_count_down_tv));
    paramViewGroup = (ProgressBar)paramViewGroup.findViewById(b.f.finder_live_loading_bar);
    if (paramViewGroup != null) {
      paramb = com.tencent.mm.plugin.findersdk.b.b.Bvw;
    }
    for (paramViewGroup = b.a.a(paramViewGroup);; paramViewGroup = null)
    {
      this.ywG = paramViewGroup;
      this.kGP = this.kGL;
      this.timerHandler = new MTimerHandler((MTimerHandler.CallBack)new b(this), true);
      this.kGN.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(286422);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          cd.f(this.ywH).stopTimer();
          this.ywH.reset();
          b.b.a(cd.g(this.ywH), b.c.kyS);
          b.b.a(cd.g(this.ywH), b.c.kzO);
          paramAnonymousView = ao.AGX;
          localObject = ap.AIh;
          ao.a(paramAnonymousView, ap.efF().name, null, false, true, 6);
          if (cd.g(this.ywH).getLiveRole() == 1)
          {
            paramAnonymousView = k.yBj;
            k.t(s.a.yDT.jWO, "1");
            paramAnonymousView = k.yBj;
            k.b(s.s.yGJ);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(286422);
        }
      });
      paramViewGroup = this.ywG;
      if (paramViewGroup == null) {
        break;
      }
      paramViewGroup.end();
      AppMethodBeat.o(281063);
      return;
    }
    AppMethodBeat.o(281063);
  }
  
  private final void aPE()
  {
    AppMethodBeat.i(281056);
    TextView localTextView = this.kGO;
    p.j(localTextView, "countDownTv");
    localTextView.setVisibility(0);
    localTextView = this.kGO;
    p.j(localTextView, "countDownTv");
    localTextView.setText((CharSequence)String.valueOf(this.kGP));
    AppMethodBeat.o(281056);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(281062);
    if (this.kiF.getVisibility() == 0)
    {
      this.timerHandler.stopTimer();
      ((c)business(c.class)).setLiveInfo(new bac());
      reset();
      b.b.a(this.kCL, b.c.kyS);
      Object localObject = ao.AGX;
      ap.a locala = ap.AIh;
      ao.a((ao)localObject, ap.efF().name, null, false, true, 6);
      if (this.kCL.getLiveRole() == 1)
      {
        localObject = k.yBj;
        k.t(s.a.yDT.jWO, "1");
        localObject = k.yBj;
        k.b(s.s.yGJ);
      }
      AppMethodBeat.o(281062);
      return true;
    }
    AppMethodBeat.o(281062);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(281055);
    Object localObject = this.kGO;
    p.j(localObject, "countDownTv");
    ((TextView)localObject).setScaleX(1.0F);
    localObject = this.kGO;
    p.j(localObject, "countDownTv");
    ((TextView)localObject).setScaleY(1.0F);
    this.kGP = this.kGL;
    localObject = this.ywG;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.findersdk.b.b)localObject).end();
      AppMethodBeat.o(281055);
      return;
    }
    AppMethodBeat.o(281055);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(281060);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (ce.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(281060);
      return;
      Log.printInfoStack(this.TAG, "ILiveStatusLiveStatusREADY", new Object[0]);
      tU(0);
      paramc = this.kGN;
      p.j(paramc, "cancelBtn");
      paramc.setVisibility(0);
      aPE();
      this.timerHandler.startTimer(1000L, 1000L);
      paramc = this.ywG;
      if (paramc != null)
      {
        paramc.end();
        AppMethodBeat.o(281060);
        return;
      }
      AppMethodBeat.o(281060);
      return;
      tU(8);
      AppMethodBeat.o(281060);
      return;
      paramc = ah.yhC;
      paramc = ah.getFinderLiveAssistant();
    } while (paramc == null);
    an.a.a(paramc, (s)new a(this));
    AppMethodBeat.o(281060);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(281059);
    super.tU(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      this.timerHandler.stopTimer();
      reset();
    }
    AppMethodBeat.o(281059);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(281061);
    super.unMount();
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(281061);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "invoke"})
  static final class a
    extends q
    implements s<Boolean, Integer, Integer, String, aqs, x>
  {
    a(cd paramcd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements MTimerHandler.CallBack
  {
    b(cd paramcd) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(272573);
      if (cd.b(this.ywH) > cd.c(this.ywH))
      {
        cd localcd = this.ywH;
        cd.a(localcd, cd.b(localcd) - 1);
        cd.d(this.ywH);
        AppMethodBeat.o(272573);
        return true;
      }
      cd.e(this.ywH);
      AppMethodBeat.o(272573);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cd
 * JD-Core Version:    0.7.0.1
 */
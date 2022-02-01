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
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.o;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.ad.a;
import com.tencent.mm.plugin.finder.utils.ad.c;
import com.tencent.mm.plugin.finder.utils.ah;
import com.tencent.mm.plugin.finder.utils.ai;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "TAG", "", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "countDownTv", "Landroid/widget/TextView;", "curCountDown", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onBackPress", "", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stopCountDown", "unMount", "plugin-finder_release"})
public final class ay
  extends d
{
  final String TAG;
  final com.tencent.mm.live.c.b hOp;
  private final int hSo;
  final int hSp;
  final Button hSq;
  final TextView hSr;
  int hSs;
  final MTimerHandler timerHandler;
  com.tencent.mm.plugin.finder.utils.b tux;
  
  public ay(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246956);
    this.hOp = paramb;
    this.TAG = "Finder.FinderLiveReadyPlugin";
    this.hSo = 3;
    this.hSq = ((Button)paramViewGroup.findViewById(2131301249));
    this.hSr = ((TextView)paramViewGroup.findViewById(2131301250));
    paramb = (ProgressBar)paramViewGroup.findViewById(2131301137);
    if (paramb != null)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.utils.b.vVa;
      p.h(paramb, "progressBar");
      paramViewGroup = new com.tencent.mm.plugin.finder.utils.b();
      paramViewGroup.gY = 1000L;
      ah localah = new ah();
      localah.uuU = paramb;
      paramViewGroup.vUZ = ((ai)localah);
    }
    for (;;)
    {
      this.tux = paramViewGroup;
      this.hSs = this.hSo;
      this.timerHandler = new MTimerHandler((MTimerHandler.CallBack)new b(this), true);
      this.hSq.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(246946);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          this.utv.timerHandler.stopTimer();
          this.utv.reset();
          this.utv.getLiveData().setLiveInfo(new awe());
          b.b.a(this.utv.hOp, b.c.hLy);
          b.b.a(this.utv.hOp, b.c.hMt);
          paramAnonymousView = ac.vYp;
          localObject = ad.vZu;
          ac.a(paramAnonymousView, ad.dDW().name, null, false, true, 6);
          if (this.utv.hOp.getLiveRole() == 1)
          {
            paramAnonymousView = k.vkd;
            k.q(com.tencent.mm.plugin.finder.report.live.s.a.vmE.hlf, "1");
            paramAnonymousView = k.vkd;
            k.b(s.o.vow);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveReadyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(246946);
        }
      });
      paramViewGroup = this.tux;
      if (paramViewGroup == null) {
        break;
      }
      paramViewGroup.end();
      AppMethodBeat.o(246956);
      return;
      paramViewGroup = null;
    }
    AppMethodBeat.o(246956);
  }
  
  final void aHG()
  {
    AppMethodBeat.i(246951);
    TextView localTextView = this.hSr;
    p.g(localTextView, "countDownTv");
    localTextView.setVisibility(0);
    localTextView = this.hSr;
    p.g(localTextView, "countDownTv");
    localTextView.setText((CharSequence)String.valueOf(this.hSs));
    AppMethodBeat.o(246951);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(246955);
    if (this.hwr.getVisibility() == 0)
    {
      this.timerHandler.stopTimer();
      getLiveData().setLiveInfo(new awe());
      reset();
      b.b.a(this.hOp, b.c.hLy);
      Object localObject = ac.vYp;
      ad.a locala = ad.vZu;
      ac.a((ac)localObject, ad.dDW().name, null, false, true, 6);
      if (this.hOp.getLiveRole() == 1)
      {
        localObject = k.vkd;
        k.q(com.tencent.mm.plugin.finder.report.live.s.a.vmE.hlf, "1");
        localObject = k.vkd;
        k.b(s.o.vow);
      }
      AppMethodBeat.o(246955);
      return true;
    }
    AppMethodBeat.o(246955);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(246950);
    Object localObject = this.hSr;
    p.g(localObject, "countDownTv");
    ((TextView)localObject).setScaleX(1.0F);
    localObject = this.hSr;
    p.g(localObject, "countDownTv");
    ((TextView)localObject).setScaleY(1.0F);
    this.hSs = this.hSo;
    localObject = this.tux;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.utils.b)localObject).end();
      AppMethodBeat.o(246950);
      return;
    }
    AppMethodBeat.o(246950);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(246952);
    super.rg(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      this.timerHandler.stopTimer();
      reset();
    }
    AppMethodBeat.o(246952);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(246953);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (az.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(246953);
      return;
      Log.printInfoStack(this.TAG, "ILiveStatusLiveStatusREADY", new Object[0]);
      rg(0);
      paramc = this.hSq;
      p.g(paramc, "cancelBtn");
      paramc.setVisibility(0);
      aHG();
      this.timerHandler.startTimer(1000L, 1000L);
      paramc = this.tux;
      if (paramc != null)
      {
        paramc.end();
        AppMethodBeat.o(246953);
        return;
      }
      AppMethodBeat.o(246953);
      return;
      rg(8);
      AppMethodBeat.o(246953);
      return;
      paramc = o.ujN;
      paramc = o.getFinderLiveAssistant();
    } while (paramc == null);
    com.tencent.mm.plugin.finder.live.model.s.a.a(paramc, (s)new a(this));
    AppMethodBeat.o(246953);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246954);
    super.unMount();
    this.timerHandler.stopTimer();
    reset();
    AppMethodBeat.o(246954);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "errCode", "", "errType", "errMsg", "", "errresp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "invoke"})
  static final class a
    extends q
    implements s<Boolean, Integer, Integer, String, ape, x>
  {
    a(ay paramay)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements MTimerHandler.CallBack
  {
    b(ay paramay) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(246949);
      if (this.utv.hSs > this.utv.hSp)
      {
        localObject1 = this.utv;
        ((ay)localObject1).hSs -= 1;
        this.utv.aHG();
        AppMethodBeat.o(246949);
        return true;
      }
      Object localObject1 = this.utv;
      Object localObject2 = ac.vYp;
      ad.a locala = ad.vZu;
      ac.a((ac)localObject2, ad.dDQ().name, null, false, false, 14);
      b.b.a(((ay)localObject1).hOp, b.c.hMw);
      localObject2 = ((ay)localObject1).tux;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.utils.b)localObject2).begin();
      }
      localObject2 = ((ay)localObject1).hSr;
      p.g(localObject2, "countDownTv");
      ((TextView)localObject2).setVisibility(8);
      localObject1 = ((ay)localObject1).hSq;
      p.g(localObject1, "cancelBtn");
      ((Button)localObject1).setVisibility(8);
      AppMethodBeat.o(246949);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ay
 * JD-Core Version:    0.7.0.1
 */
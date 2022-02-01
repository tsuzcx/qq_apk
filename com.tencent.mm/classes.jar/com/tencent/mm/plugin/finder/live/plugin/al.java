package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.component.a.a;
import com.tencent.mm.plugin.finder.live.component.a.b;
import com.tencent.mm.plugin.finder.live.component.c;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.plugin.finder.report.live.s.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "cacheVisible", "", "getCacheVisible", "()Z", "setCacheVisible", "(Z)V", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;)V", "canClearScreen", "printLotteryInfo", "", "action", "resumeLottery", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateLottery", "plugin-finder_release"})
public final class al
  extends d
{
  final String TAG;
  private final com.tencent.mm.live.c.b hOp;
  a.a ugA;
  private a.b ugh;
  private volatile boolean urL;
  
  public al(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246840);
    this.hOp = paramb;
    this.TAG = "FinderLiveLotteryBubblePlugin";
    this.ugA = ((a.a)new com.tencent.mm.plugin.finder.live.component.b(getLiveData(), this.hOp));
    paramb = (View)paramViewGroup;
    paramViewGroup = paramViewGroup.getContext();
    if (paramViewGroup == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(246840);
      throw paramViewGroup;
    }
    this.ugh = ((a.b)new c(paramb, (MMActivity)paramViewGroup, this.ugA));
    paramViewGroup = this.ugA;
    if (paramViewGroup != null)
    {
      paramb = this.ugh;
      if (paramb == null) {
        p.hyc();
      }
      paramViewGroup.onAttach(paramb);
    }
    paramViewGroup = com.tencent.mm.plugin.finder.utils.m.vVH;
    com.tencent.mm.plugin.finder.utils.m.a((d)this, true);
    Log.i(this.TAG, "enable :" + getLiveData().uEe + ",useUpdateStrategy:" + getLiveData().uFd);
    AppMethodBeat.o(246840);
  }
  
  private final void atM(String paramString)
  {
    AppMethodBeat.i(246839);
    Object localObject = getLiveData().uEa;
    if (localObject != null) {}
    for (localObject = ((i)localObject).tWe;; localObject = null)
    {
      if (localObject == null) {
        Log.i(this.TAG, paramString + " lotteryInfo is empty!");
      }
      AppMethodBeat.o(246839);
      return;
    }
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void dht()
  {
    AppMethodBeat.i(246837);
    com.tencent.mm.ac.d.h((a)new b(this));
    AppMethodBeat.o(246837);
  }
  
  public final void dhu()
  {
    AppMethodBeat.i(246838);
    com.tencent.mm.ac.d.h((a)new a(this));
    AppMethodBeat.o(246838);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(246836);
    p.h(paramc, "status");
    switch (am.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label110:
    label246:
    do
    {
      AppMethodBeat.o(246836);
      return;
      atM("FINDER_LIVE_CREATE_LOTTERY_SUCCESS");
      dht();
      AppMethodBeat.o(246836);
      return;
      atM("FINDER_LIVE_CANCEL_LOTTERY_SUCCESS");
      dht();
      AppMethodBeat.o(246836);
      return;
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", false);
        this.urL = bool;
        Log.i(this.TAG, "FINDER_LIVE_LOTTERY_BUBBLE_SHOW cacheVisibility:" + this.urL + ",screenclear:" + getLiveData().uDR);
        atM("FINDER_LIVE_LOTTERY_BUBBLE_SHOW cacheVisibility:" + this.urL);
        if (!this.urL) {
          break label246;
        }
        if (!getLiveData().uDR)
        {
          this.ulW = 65535;
          rg(this.ulV);
        }
      }
      while (this.hOp.getLiveRole() == 0)
      {
        paramc = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(s.ay.vsH, "");
        AppMethodBeat.o(246836);
        return;
        bool = false;
        break label110;
        rg(0);
      }
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", false);
      }
      this.urL = bool;
      Log.i(this.TAG, "FINDER_LIVE_LOTTERY_BUBBLE_HIDE cacheVisibility:" + this.urL + ",screenclear:" + getLiveData().uDR);
      atM("FINDER_LIVE_LOTTERY_BUBBLE_HIDE cacheVisibility:" + this.urL);
      if (this.urL)
      {
        this.ulW = 8;
        rg(this.ulV);
        AppMethodBeat.o(246836);
        return;
      }
      rg(8);
      AppMethodBeat.o(246836);
      return;
      atM("FINDER_LIVE_LOTTERY_UPDATE");
      dht();
      AppMethodBeat.o(246836);
      return;
      paramc = this.ugA;
    } while (paramc == null);
    paramc.onDetach();
    AppMethodBeat.o(246836);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(246835);
    super.unMount();
    a.a locala = this.ugA;
    if (locala != null)
    {
      locala.onDetach();
      AppMethodBeat.o(246835);
      return;
    }
    AppMethodBeat.o(246835);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(al paramal)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(al paramal)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.al
 * JD-Core Version:    0.7.0.1
 */
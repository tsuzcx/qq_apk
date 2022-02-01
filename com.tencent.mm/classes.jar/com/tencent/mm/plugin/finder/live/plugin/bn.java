package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicReserveGuidePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "canReserved", "", "getCanReserved", "()Z", "setCanReserved", "(Z)V", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "noticeId", "", "getNoticeId", "()Ljava/lang/String;", "setNoticeId", "(Ljava/lang/String;)V", "closeLive", "", "mount", "showGuide", "followClick", "Lkotlin/Function0;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateForNormalMode", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bn
  extends b
{
  private static final bn.a Dhp;
  private c<com.tencent.mm.vending.e.a> AAh;
  private boolean Dhq;
  String hAR;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(355257);
    Dhp = new bn.a((byte)0);
    AppMethodBeat.o(355257);
  }
  
  private bn(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb, null);
    AppMethodBeat.i(355198);
    this.nfT = paramb;
    this.AAh = new c();
    AppMethodBeat.o(355198);
  }
  
  private static final ah a(bn parambn, b.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(355215);
    s.u(parambn, "this$0");
    Object localObject1;
    int i;
    if ((parama.errCode == 0) && (parama.errType == 0))
    {
      Log.i("Finder.FinderLiveOlympicReserveGuidePlugin", "FinderLiveOlympicReserveGuidePlugin Load startTime&noticeId succ");
      localObject1 = ((FinderUserPageResponse)parama.ott).liveNoticeInfo;
      if ((localObject1 == null) || (((bkk)localObject1).status != 1)) {
        break label214;
      }
      i = 1;
      label139:
      if (i != 0)
      {
        parambn.Dhq = true;
        localObject1 = ((FinderUserPageResponse)parama.ott).liveNoticeInfo;
        if (localObject1 != null) {
          break label219;
        }
        localObject1 = null;
        label86:
        if (localObject1 != null)
        {
          TextView localTextView = (TextView)parambn.mJe.findViewById(p.e.BWk);
          Resources localResources = parambn.mJe.getResources();
          i = p.h.finder_live_olympics_reserve_hint;
          localObject1 = aw.Gjk;
          localObject1 = ((FinderUserPageResponse)parama.ott).liveNoticeInfo;
          if (localObject1 != null) {
            break label230;
          }
          localObject1 = null;
          s.checkNotNull(localObject1);
          localTextView.setText((CharSequence)localResources.getString(i, new Object[] { aw.a(((Integer)localObject1).intValue() * 1000L, null, false, 6) }));
          parama = ((FinderUserPageResponse)parama.ott).liveNoticeInfo;
          if (parama != null) {
            break label241;
          }
        }
      }
    }
    label214:
    label219:
    label230:
    label241:
    for (parama = localObject2;; parama = parama.hAR)
    {
      parambn.hAR = parama;
      parambn = ah.aiuX;
      AppMethodBeat.o(355215);
      return parambn;
      i = 0;
      break;
      localObject1 = Integer.valueOf(((bkk)localObject1).startTime);
      break label86;
      localObject1 = Integer.valueOf(((bkk)localObject1).startTime);
      break label139;
    }
  }
  
  private static final void g(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(355222);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicReserveGuidePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$followClick");
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicReserveGuidePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355222);
  }
  
  private static final void h(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(355230);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicReserveGuidePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$closeLive");
    parama.invoke();
    ce.a.a((ce)j.Dob, q.s.Duk);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveOlympicReserveGuidePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355230);
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355283);
    super.mount();
    this.AAh = new c();
    AppMethodBeat.o(355283);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355297);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355297);
      return;
      paramc = d.AwY;
      paramc = d.a.auT(getData().Ebr.mIC);
      if (paramc == null) {
        paramc = "";
      }
      for (;;)
      {
        new com.tencent.mm.plugin.finder.live.olympic.a(paramc).bFJ().a((com.tencent.mm.vending.e.b)this.AAh).g(new bn..ExternalSyntheticLambda2(this));
        AppMethodBeat.o(355297);
        return;
        paramBundle = paramc.getUsername();
        paramc = paramBundle;
        if (paramBundle == null) {
          paramc = "";
        }
      }
      paramc = d.AwY;
      paramc = d.a.auT(getData().Ebr.mIC);
      if (this.Dhq)
      {
        paramc = (kotlin.g.a.a)new d(paramc, this);
        paramBundle = (kotlin.g.a.a)new c(this);
        if (isLandscape()) {
          this.mJe.findViewById(p.e.BWg).getLayoutParams().width = this.mJe.getContext().getResources().getDimensionPixelSize(p.c.finder_40_A);
        }
        ((TextView)this.mJe.findViewById(p.e.BWh)).setOnClickListener(new bn..ExternalSyntheticLambda0(paramc));
        this.mJe.findViewById(p.e.BWj).setOnClickListener(new bn..ExternalSyntheticLambda1(paramBundle));
        tO(0);
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355310);
    this.AAh.dead();
    super.unMount();
    this.Dhq = true;
    this.hAR = "";
    AppMethodBeat.o(355310);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(bn parambn)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(m paramm, bn parambn)
    {
      super();
    }
    
    private static final ah f(b.a parama)
    {
      AppMethodBeat.i(355620);
      if ((parama.errType == 0) && (parama.errCode == 0)) {
        Log.i("Finder.FinderLiveOlympicReserveGuidePlugin", "FinderLiveOlympicReserveGuidePlugin reserve cgi succ");
      }
      for (;;)
      {
        parama = ah.aiuX;
        AppMethodBeat.o(355620);
        return parama;
        Log.i("Finder.FinderLiveOlympicReserveGuidePlugin", "FinderLiveOlympicReserveGuidePlugin reserve cgi failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bn
 * JD-Core Version:    0.7.0.1
 */
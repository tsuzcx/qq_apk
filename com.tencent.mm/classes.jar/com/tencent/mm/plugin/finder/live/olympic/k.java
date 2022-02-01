package com.tencent.mm.plugin.finder.live.olympic;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.plugin.br;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsCertBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "bubbleLayout", "Landroid/widget/RelativeLayout;", "bubbleRootLayout", "Landroid/widget/FrameLayout;", "hideRunnable", "Ljava/lang/Runnable;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "initBubbleLocation", "", "params", "Landroid/os/Bundle;", "isNeedShowPacket", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stop", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  public static final k.a COs;
  private final FrameLayout COt;
  private final RelativeLayout COu;
  private final Runnable COv;
  private final MMActivity activity;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(360463);
    COs = new k.a((byte)0);
    AppMethodBeat.o(360463);
  }
  
  public k(MMActivity paramMMActivity, ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(360441);
    this.activity = paramMMActivity;
    this.nfT = paramb;
    paramMMActivity = paramViewGroup.findViewById(p.e.BPW);
    s.s(paramMMActivity, "root.findViewById(R.id.f…olympic_cert_bubble_root)");
    this.COt = ((FrameLayout)paramMMActivity);
    paramMMActivity = paramViewGroup.findViewById(p.e.BPV);
    s.s(paramMMActivity, "root.findViewById(R.id.f…ympic_cert_bubble_layout)");
    this.COu = ((RelativeLayout)paramMMActivity);
    this.COt.setVisibility(8);
    paramMMActivity = this.COu.getLayoutParams();
    if (paramMMActivity == null)
    {
      paramMMActivity = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(360441);
      throw paramMMActivity;
    }
    paramMMActivity = (ViewGroup.MarginLayoutParams)paramMMActivity;
    paramMMActivity.width = com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.getContext(), 227);
    paramMMActivity.height = com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.getContext(), 48);
    paramViewGroup.setOnTouchListener(new k..ExternalSyntheticLambda0(this));
    this.COv = new k..ExternalSyntheticLambda1(this);
    AppMethodBeat.o(360441);
  }
  
  private static final void a(k paramk)
  {
    AppMethodBeat.i(360457);
    s.u(paramk, "this$0");
    Log.i("OlympicsCertBubblePlugin", "handle hideRunnable");
    paramk.COt.setVisibility(8);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.b(paramk.getBuContext(), paramk.nfT);
    AppMethodBeat.o(360457);
  }
  
  private static final boolean a(k paramk, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(360447);
    s.u(paramk, "this$0");
    paramk.COt.setVisibility(8);
    AppMethodBeat.o(360447);
    return false;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(360496);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(360496);
      return;
      paramc = (br)getPlugin(br.class);
      if (paramc != null)
      {
        paramc.tO(8);
        AppMethodBeat.o(360496);
        return;
        if (paramBundle == null)
        {
          this.COt.setVisibility(8);
          AppMethodBeat.o(360496);
          return;
        }
        if (this.COt.getVisibility() != 0)
        {
          int i = paramBundle.getInt("bubbleX");
          int j = paramBundle.getInt("bubbleY");
          paramc = this.COu.getLayoutParams();
          if (paramc == null)
          {
            paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(360496);
            throw paramc;
          }
          paramc = (ViewGroup.MarginLayoutParams)paramc;
          paramc.topMargin = (j - paramc.height - com.tencent.mm.cd.a.fromDPToPix(this.mJe.getContext(), 8));
          paramc.leftMargin = (i - paramc.width / 2);
          paramc = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
          boolean bool = com.tencent.mm.plugin.finder.live.olympic.util.a.eor();
          Log.i("OlympicsCertBubblePlugin", s.X("initBubbleLocation isNeedShow: ", Boolean.valueOf(bool)));
          if (bool)
          {
            paramc = (br)getPlugin(br.class);
            if ((paramc != null) && (paramc.mJe.getVisibility() == 0)) {}
            for (i = 1; i != 0; i = 0)
            {
              Log.i("OlympicsCertBubblePlugin", "initBubbleLocation PromoteBubblePlugin is visible");
              this.COt.setVisibility(8);
              AppMethodBeat.o(360496);
              return;
            }
            paramc = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
            com.tencent.mm.plugin.finder.live.olympic.util.a.eos();
            this.COt.setVisibility(0);
            if (((q)getBuContext().business(q.class)).Eie != null) {}
            for (i = 1; i != 0; i = 0)
            {
              d.a(5000L, this.COv);
              AppMethodBeat.o(360496);
              return;
            }
            d.a(10000L, this.COv);
            AppMethodBeat.o(360496);
            return;
          }
          this.COt.setVisibility(8);
          paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          com.tencent.mm.plugin.finder.live.utils.a.b(getBuContext(), this.nfT);
        }
        AppMethodBeat.o(360496);
        return;
        this.COt.setVisibility(8);
        paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (!com.tencent.mm.plugin.finder.live.utils.a.r(getBuContext()))
        {
          paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          com.tencent.mm.plugin.finder.live.utils.a.b(getBuContext(), this.nfT);
          AppMethodBeat.o(360496);
          return;
        }
        Log.i("OlympicsCertBubblePlugin", "redpacket got ,no notify");
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(360502);
    super.stop();
    d.H(this.COv);
    AppMethodBeat.o(360502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.k
 * JD-Core Version:    0.7.0.1
 */
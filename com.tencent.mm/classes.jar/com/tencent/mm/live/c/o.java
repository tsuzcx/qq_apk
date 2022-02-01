package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.k;
import com.tencent.mm.live.b.k.a;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.d.f;
import com.tencent.mm.model.ch;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curNetStatus", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "Landroid/widget/TextView;", "isAnchor", "", "likeGroup", "likeTv", "membersGroup", "membersIcon", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkDuration", "", "checkNetwork", "getNetStatusIcon", "resId", "refreshViews", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "start", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public final class o
  extends a
{
  private final String TAG;
  boolean dzz;
  final b gVv;
  final TextView gWK;
  final TextView gWL;
  final TextView gWM;
  private final View gWN;
  private final View gWO;
  private final View gWP;
  final ImageView gWQ;
  private final ImageView gWR;
  final Drawable gWS;
  final Drawable gWT;
  final Drawable gWU;
  int gWV;
  String gWW;
  private aw gWX;
  
  public o(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216030);
    this.gVv = paramb;
    this.TAG = "MicroMsg.LiveCommonInfoPlugin";
    paramb = paramViewGroup.findViewById(2131307616);
    p.g(paramb, "root.findViewById(R.id.l…e_common_info_members_tv)");
    this.gWK = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307610);
    p.g(paramb, "root.findViewById(R.id.l…_common_info_duration_tv)");
    this.gWL = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307613);
    p.g(paramb, "root.findViewById(R.id.live_common_info_like_tv)");
    this.gWM = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307614);
    p.g(paramb, "root.findViewById(R.id.l…ommon_info_members_group)");
    this.gWN = paramb;
    paramb = paramViewGroup.findViewById(2131307608);
    p.g(paramb, "root.findViewById(R.id.l…mmon_info_duration_group)");
    this.gWO = paramb;
    paramb = paramViewGroup.findViewById(2131307611);
    p.g(paramb, "root.findViewById(R.id.l…e_common_info_like_group)");
    this.gWP = paramb;
    paramb = paramViewGroup.findViewById(2131307609);
    p.g(paramb, "root.findViewById(R.id.l…ommon_info_duration_icon)");
    this.gWQ = ((ImageView)paramb);
    paramViewGroup = paramViewGroup.findViewById(2131307607);
    p.g(paramViewGroup, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
    this.gWR = ((ImageView)paramViewGroup);
    this.gWS = nM(2131691546);
    this.gWT = nM(2131691547);
    this.gWU = nM(2131691545);
    paramViewGroup = c.c.gJR;
    this.gWV = c.c.alJ();
    this.gWW = "00:00:00";
    this.gWX = new aw("LiveCommonInfoPlugin::Timer", (aw.a)new b(this), true);
    this.gWN.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216018);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (this.gWY.gVv.getLiveRole() == 0) {
          f.aqp();
        }
        for (;;)
        {
          b.b.a(this.gWY.gVv, b.c.gUp);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216018);
          return;
          com.tencent.mm.live.d.a.apD();
        }
      }
    });
    AppMethodBeat.o(216030);
  }
  
  private void aoH()
  {
    AppMethodBeat.i(216023);
    if (this.gJt.getVisibility() == 0)
    {
      this.gWX.stopTimer();
      this.gWX.Dv(1000L);
    }
    AppMethodBeat.o(216023);
  }
  
  private final Drawable nM(int paramInt)
  {
    AppMethodBeat.i(216022);
    Object localObject = this.gJt.getContext();
    p.g(localObject, "root.context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt);
    p.g(localObject, "root.context.resources.getDrawable(resId)");
    AppMethodBeat.o(216022);
    return localObject;
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(216024);
    if ((paramLiveConfig != null) && (paramLiveConfig.alj() == LiveConfig.gJa)) {}
    for (boolean bool = true;; bool = false)
    {
      this.dzz = bool;
      if ((paramLiveConfig == null) || (paramLiveConfig.alj() != LiveConfig.gJa)) {
        break;
      }
      this.gWN.setVisibility(0);
      this.gWO.setVisibility(0);
      this.gWP.setVisibility(0);
      AppMethodBeat.o(216024);
      return;
    }
    this.gWN.setVisibility(0);
    this.gWO.setVisibility(8);
    this.gWP.setVisibility(8);
    AppMethodBeat.o(216024);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216029);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (p.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216029);
      return;
      nL(0);
      aoH();
      AppMethodBeat.o(216029);
      return;
      nL(8);
      AppMethodBeat.o(216029);
      return;
      if (this.gVv.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nL(4);
          AppMethodBeat.o(216029);
          return;
        }
        nL(0);
      }
    }
  }
  
  public final void aoP()
  {
    AppMethodBeat.i(216028);
    this.gWX.stopTimer();
    AppMethodBeat.o(216028);
  }
  
  public final void nL(int paramInt)
  {
    AppMethodBeat.i(216025);
    super.nL(paramInt);
    if (paramInt != 0)
    {
      this.gWX.stopTimer();
      AppMethodBeat.o(216025);
      return;
    }
    this.gWX.Dv(1000L);
    AppMethodBeat.o(216025);
  }
  
  public final void start()
  {
    AppMethodBeat.i(216027);
    aoH();
    AppMethodBeat.o(216027);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(216026);
    this.gWX.stopTimer();
    AppMethodBeat.o(216026);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(o paramo) {}
    
    public final void run()
    {
      AppMethodBeat.i(216020);
      int i = this.gWY.gWV;
      Object localObject1 = c.c.gJR;
      if (i == c.c.alJ()) {
        this.gWY.gWQ.setImageDrawable(this.gWY.gWS);
      }
      for (;;)
      {
        localObject1 = this.gWY.gWK;
        Object localObject2 = ad.Njc;
        localObject2 = this.gWY.gJt.getContext().getString(2131766638);
        p.g(localObject2, "root.context.getString(R.string.live_members_tip)");
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.live.b.g.anH().GTv) }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)String.valueOf(localObject2));
        this.gWY.gWL.setText((CharSequence)String.valueOf(this.gWY.gWW));
        localObject1 = this.gWY.gWM;
        localObject2 = com.tencent.mm.live.b.g.gQZ;
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.live.b.g.aou());
        AppMethodBeat.o(216020);
        return;
        localObject1 = c.c.gJR;
        if (i == c.c.alK())
        {
          this.gWY.gWQ.setImageDrawable(this.gWY.gWT);
        }
        else
        {
          localObject1 = c.c.gJR;
          if (i == c.c.alL()) {
            this.gWY.gWQ.setImageDrawable(this.gWY.gWU);
          }
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements aw.a
  {
    b(o paramo) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(216021);
      o localo = this.gWY;
      Object localObject;
      if (com.tencent.mm.kernel.g.ajP().aiZ())
      {
        i = ch.aDd();
        localObject = k.gRU;
        localObject = com.tencent.mm.live.b.g.gQZ;
        localo.gWW = k.a.a(i - com.tencent.mm.live.b.g.anH().FZN, ":", false, false, false, 28);
      }
      localo = this.gWY;
      if (localo.dzz)
      {
        localObject = com.tencent.mm.live.core.core.a.b.gJU;
        localObject = localo.gJt.getContext();
        p.g(localObject, "root.context");
      }
      for (int i = com.tencent.mm.live.core.core.a.b.a.cs((Context)localObject).gLc.gKA;; i = com.tencent.mm.live.core.core.c.b.a.ct((Context)localObject).gLc.gKA)
      {
        localo.gWV = i;
        localo = this.gWY;
        localo.gJt.post((Runnable)new o.a(localo));
        AppMethodBeat.o(216021);
        return true;
        localObject = com.tencent.mm.live.core.core.c.b.gMM;
        localObject = localo.gJt.getContext();
        p.g(localObject, "root.context");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.o
 * JD-Core Version:    0.7.0.1
 */
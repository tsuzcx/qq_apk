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
import com.tencent.mm.live.b.k.a;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.d.f;
import com.tencent.mm.model.ce;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curNetStatus", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "Landroid/widget/TextView;", "isAnchor", "", "likeGroup", "likeTv", "membersGroup", "membersIcon", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkDuration", "", "checkNetwork", "getNetStatusIcon", "resId", "refreshViews", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "start", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public final class o
  extends a
{
  private final String TAG;
  boolean dmG;
  final Drawable gAA;
  final Drawable gAB;
  int gAC;
  String gAD;
  private au gAE;
  final TextView gAr;
  final TextView gAs;
  final TextView gAt;
  private final View gAu;
  private final View gAv;
  private final View gAw;
  final ImageView gAx;
  private final ImageView gAy;
  final Drawable gAz;
  final b gzb;
  
  public o(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190122);
    this.gzb = paramb;
    this.TAG = "MicroMsg.LiveCommonInfoPlugin";
    paramb = paramViewGroup.findViewById(2131307616);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…e_common_info_members_tv)");
    this.gAr = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307610);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…_common_info_duration_tv)");
    this.gAs = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307613);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_common_info_like_tv)");
    this.gAt = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307614);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…ommon_info_members_group)");
    this.gAu = paramb;
    paramb = paramViewGroup.findViewById(2131307608);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…mmon_info_duration_group)");
    this.gAv = paramb;
    paramb = paramViewGroup.findViewById(2131307611);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…e_common_info_like_group)");
    this.gAw = paramb;
    paramb = paramViewGroup.findViewById(2131307609);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…ommon_info_duration_icon)");
    this.gAx = ((ImageView)paramb);
    paramViewGroup = paramViewGroup.findViewById(2131307607);
    d.g.b.k.g(paramViewGroup, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
    this.gAy = ((ImageView)paramViewGroup);
    this.gAz = nk(2131691546);
    this.gAA = nk(2131691547);
    this.gAB = nk(2131691545);
    paramViewGroup = c.c.gnz;
    this.gAC = c.c.aiI();
    this.gAD = "00:00:00";
    this.gAE = new au("LiveCommonInfoPlugin::Timer", (au.a)new b(this), true);
    this.gAu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190110);
        if (this.gAF.gzb.getLiveRole() == 0) {
          f.ann();
        }
        for (;;)
        {
          b.b.a(this.gAF.gzb, b.c.gxW);
          AppMethodBeat.o(190110);
          return;
          com.tencent.mm.live.d.a.amC();
        }
      }
    });
    AppMethodBeat.o(190122);
  }
  
  private void alF()
  {
    AppMethodBeat.i(190115);
    if (this.gnb.getVisibility() == 0)
    {
      this.gAE.stopTimer();
      this.gAE.Ah(1000L);
    }
    AppMethodBeat.o(190115);
  }
  
  private final Drawable nk(int paramInt)
  {
    AppMethodBeat.i(190114);
    Object localObject = this.gnb.getContext();
    d.g.b.k.g(localObject, "root.context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt);
    d.g.b.k.g(localObject, "root.context.resources.getDrawable(resId)");
    AppMethodBeat.o(190114);
    return localObject;
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(190116);
    if ((paramLiveConfig != null) && (paramLiveConfig.aii() == LiveConfig.gmI)) {}
    for (boolean bool = true;; bool = false)
    {
      this.dmG = bool;
      if ((paramLiveConfig == null) || (paramLiveConfig.aii() != LiveConfig.gmI)) {
        break;
      }
      this.gAu.setVisibility(0);
      this.gAv.setVisibility(0);
      this.gAw.setVisibility(0);
      AppMethodBeat.o(190116);
      return;
    }
    this.gAu.setVisibility(0);
    this.gAv.setVisibility(8);
    this.gAw.setVisibility(8);
    AppMethodBeat.o(190116);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190121);
    d.g.b.k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (p.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190121);
      return;
      nj(0);
      alF();
      AppMethodBeat.o(190121);
      return;
      nj(8);
      AppMethodBeat.o(190121);
      return;
      if (this.gzb.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nj(4);
          AppMethodBeat.o(190121);
          return;
        }
        nj(0);
      }
    }
  }
  
  public final void alN()
  {
    AppMethodBeat.i(190120);
    this.gAE.stopTimer();
    AppMethodBeat.o(190120);
  }
  
  public final void nj(int paramInt)
  {
    AppMethodBeat.i(190117);
    super.nj(paramInt);
    if (paramInt != 0)
    {
      this.gAE.stopTimer();
      AppMethodBeat.o(190117);
      return;
    }
    this.gAE.Ah(1000L);
    AppMethodBeat.o(190117);
  }
  
  public final void start()
  {
    AppMethodBeat.i(190119);
    alF();
    AppMethodBeat.o(190119);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(190118);
    this.gAE.stopTimer();
    AppMethodBeat.o(190118);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(o paramo) {}
    
    public final void run()
    {
      AppMethodBeat.i(190112);
      int i = this.gAF.gAC;
      Object localObject1 = c.c.gnz;
      if (i == c.c.aiI()) {
        this.gAF.gAx.setImageDrawable(this.gAF.gAz);
      }
      for (;;)
      {
        localObject1 = this.gAF.gAr;
        Object localObject2 = z.KUT;
        localObject2 = this.gAF.gnb.getContext().getString(2131766638);
        d.g.b.k.g(localObject2, "root.context.getString(R.string.live_members_tip)");
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.live.b.g.akF().EQE) }, 1));
        d.g.b.k.g(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)String.valueOf(localObject2));
        this.gAF.gAs.setText((CharSequence)String.valueOf(this.gAF.gAD));
        localObject1 = this.gAF.gAt;
        localObject2 = com.tencent.mm.live.b.g.guG;
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.live.b.g.als());
        AppMethodBeat.o(190112);
        return;
        localObject1 = c.c.gnz;
        if (i == c.c.aiJ())
        {
          this.gAF.gAx.setImageDrawable(this.gAF.gAA);
        }
        else
        {
          localObject1 = c.c.gnz;
          if (i == c.c.aiK()) {
            this.gAF.gAx.setImageDrawable(this.gAF.gAB);
          }
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements au.a
  {
    b(o paramo) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(190113);
      o localo = this.gAF;
      Object localObject;
      if (com.tencent.mm.kernel.g.agP().afY())
      {
        i = ce.azK();
        localObject = com.tencent.mm.live.b.k.gvB;
        localObject = com.tencent.mm.live.b.g.guG;
        localo.gAD = k.a.a(i - com.tencent.mm.live.b.g.akF().EbF, ":", false, false, false, 28);
      }
      localo = this.gAF;
      if (localo.dmG)
      {
        localObject = com.tencent.mm.live.core.core.a.b.gnC;
        localObject = localo.gnb.getContext();
        d.g.b.k.g(localObject, "root.context");
      }
      for (int i = com.tencent.mm.live.core.core.a.b.a.ct((Context)localObject).goL.goi;; i = com.tencent.mm.live.core.core.c.b.a.cu((Context)localObject).goL.goi)
      {
        localo.gAC = i;
        localo = this.gAF;
        localo.gnb.post((Runnable)new o.a(localo));
        AppMethodBeat.o(190113);
        return true;
        localObject = com.tencent.mm.live.core.core.c.b.gqt;
        localObject = localo.gnb.getContext();
        d.g.b.k.g(localObject, "root.context");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.o
 * JD-Core Version:    0.7.0.1
 */
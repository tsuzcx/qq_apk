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
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curNetStatus", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "Landroid/widget/TextView;", "isAnchor", "", "likeGroup", "likeTv", "membersGroup", "membersIcon", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkDuration", "", "checkNetwork", "getNetStatusIcon", "resId", "refreshViews", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "start", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public final class o
  extends a
{
  private final String TAG;
  boolean dyu;
  final b gSM;
  final TextView gUb;
  final TextView gUc;
  final TextView gUd;
  private final View gUe;
  private final View gUf;
  private final View gUg;
  final ImageView gUh;
  private final ImageView gUi;
  final Drawable gUj;
  final Drawable gUk;
  final Drawable gUl;
  int gUm;
  String gUn;
  private av gUo;
  
  public o(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212410);
    this.gSM = paramb;
    this.TAG = "MicroMsg.LiveCommonInfoPlugin";
    paramb = paramViewGroup.findViewById(2131307616);
    p.g(paramb, "root.findViewById(R.id.l…e_common_info_members_tv)");
    this.gUb = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307610);
    p.g(paramb, "root.findViewById(R.id.l…_common_info_duration_tv)");
    this.gUc = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307613);
    p.g(paramb, "root.findViewById(R.id.live_common_info_like_tv)");
    this.gUd = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307614);
    p.g(paramb, "root.findViewById(R.id.l…ommon_info_members_group)");
    this.gUe = paramb;
    paramb = paramViewGroup.findViewById(2131307608);
    p.g(paramb, "root.findViewById(R.id.l…mmon_info_duration_group)");
    this.gUf = paramb;
    paramb = paramViewGroup.findViewById(2131307611);
    p.g(paramb, "root.findViewById(R.id.l…e_common_info_like_group)");
    this.gUg = paramb;
    paramb = paramViewGroup.findViewById(2131307609);
    p.g(paramb, "root.findViewById(R.id.l…ommon_info_duration_icon)");
    this.gUh = ((ImageView)paramb);
    paramViewGroup = paramViewGroup.findViewById(2131307607);
    p.g(paramViewGroup, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
    this.gUi = ((ImageView)paramViewGroup);
    this.gUj = nJ(2131691546);
    this.gUk = nJ(2131691547);
    this.gUl = nJ(2131691545);
    paramViewGroup = c.c.gHi;
    this.gUm = c.c.alu();
    this.gUn = "00:00:00";
    this.gUo = new av("LiveCommonInfoPlugin::Timer", (av.a)new b(this), true);
    this.gUe.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212398);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (this.gUp.gSM.getLiveRole() == 0) {
          f.aqa();
        }
        for (;;)
        {
          b.b.a(this.gUp.gSM, b.c.gRH);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212398);
          return;
          com.tencent.mm.live.d.a.app();
        }
      }
    });
    AppMethodBeat.o(212410);
  }
  
  private void aos()
  {
    AppMethodBeat.i(212403);
    if (this.gGK.getVisibility() == 0)
    {
      this.gUo.stopTimer();
      this.gUo.CX(1000L);
    }
    AppMethodBeat.o(212403);
  }
  
  private final Drawable nJ(int paramInt)
  {
    AppMethodBeat.i(212402);
    Object localObject = this.gGK.getContext();
    p.g(localObject, "root.context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt);
    p.g(localObject, "root.context.resources.getDrawable(resId)");
    AppMethodBeat.o(212402);
    return localObject;
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212404);
    if ((paramLiveConfig != null) && (paramLiveConfig.akU() == LiveConfig.gGr)) {}
    for (boolean bool = true;; bool = false)
    {
      this.dyu = bool;
      if ((paramLiveConfig == null) || (paramLiveConfig.akU() != LiveConfig.gGr)) {
        break;
      }
      this.gUe.setVisibility(0);
      this.gUf.setVisibility(0);
      this.gUg.setVisibility(0);
      AppMethodBeat.o(212404);
      return;
    }
    this.gUe.setVisibility(0);
    this.gUf.setVisibility(8);
    this.gUg.setVisibility(8);
    AppMethodBeat.o(212404);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212409);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (p.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212409);
      return;
      nI(0);
      aos();
      AppMethodBeat.o(212409);
      return;
      nI(8);
      AppMethodBeat.o(212409);
      return;
      if (this.gSM.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nI(4);
          AppMethodBeat.o(212409);
          return;
        }
        nI(0);
      }
    }
  }
  
  public final void aoA()
  {
    AppMethodBeat.i(212408);
    this.gUo.stopTimer();
    AppMethodBeat.o(212408);
  }
  
  public final void nI(int paramInt)
  {
    AppMethodBeat.i(212405);
    super.nI(paramInt);
    if (paramInt != 0)
    {
      this.gUo.stopTimer();
      AppMethodBeat.o(212405);
      return;
    }
    this.gUo.CX(1000L);
    AppMethodBeat.o(212405);
  }
  
  public final void start()
  {
    AppMethodBeat.i(212407);
    aos();
    AppMethodBeat.o(212407);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(212406);
    this.gUo.stopTimer();
    AppMethodBeat.o(212406);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(o paramo) {}
    
    public final void run()
    {
      AppMethodBeat.i(212400);
      int i = this.gUp.gUm;
      Object localObject1 = c.c.gHi;
      if (i == c.c.alu()) {
        this.gUp.gUh.setImageDrawable(this.gUp.gUj);
      }
      for (;;)
      {
        localObject1 = this.gUp.gUb;
        Object localObject2 = ad.MLZ;
        localObject2 = this.gUp.gGK.getContext().getString(2131766638);
        p.g(localObject2, "root.context.getString(R.string.live_members_tip)");
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.live.b.g.ans().GzV) }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)String.valueOf(localObject2));
        this.gUp.gUc.setText((CharSequence)String.valueOf(this.gUp.gUn));
        localObject1 = this.gUp.gUd;
        localObject2 = com.tencent.mm.live.b.g.gOr;
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.live.b.g.aof());
        AppMethodBeat.o(212400);
        return;
        localObject1 = c.c.gHi;
        if (i == c.c.alv())
        {
          this.gUp.gUh.setImageDrawable(this.gUp.gUk);
        }
        else
        {
          localObject1 = c.c.gHi;
          if (i == c.c.alw()) {
            this.gUp.gUh.setImageDrawable(this.gUp.gUl);
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements av.a
  {
    b(o paramo) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(212401);
      o localo = this.gUp;
      Object localObject;
      if (com.tencent.mm.kernel.g.ajA().aiK())
      {
        i = cf.aCN();
        localObject = k.gPm;
        localObject = com.tencent.mm.live.b.g.gOr;
        localo.gUn = k.a.a(i - com.tencent.mm.live.b.g.ans().FHr, ":", false, false, false, 28);
      }
      localo = this.gUp;
      if (localo.dyu)
      {
        localObject = com.tencent.mm.live.core.core.a.b.gHl;
        localObject = localo.gGK.getContext();
        p.g(localObject, "root.context");
      }
      for (int i = com.tencent.mm.live.core.core.a.b.a.cq((Context)localObject).gIt.gHR;; i = com.tencent.mm.live.core.core.c.b.a.cr((Context)localObject).gIt.gHR)
      {
        localo.gUm = i;
        localo = this.gUp;
        localo.gGK.post((Runnable)new o.a(localo));
        AppMethodBeat.o(212401);
        return true;
        localObject = com.tencent.mm.live.core.core.c.b.gKd;
        localObject = localo.gGK.getContext();
        p.g(localObject, "root.context");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.o
 * JD-Core Version:    0.7.0.1
 */
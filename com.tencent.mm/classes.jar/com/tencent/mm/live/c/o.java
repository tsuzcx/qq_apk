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
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.j.a;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.model.ce;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curNetStatus", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "Landroid/widget/TextView;", "isAnchor", "", "likeGroup", "likeTv", "membersGroup", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkDuration", "", "checkNetwork", "getNetStatusIcon", "resId", "refreshViews", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "start", "startLive", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public final class o
  extends a
{
  final b IIs;
  final TextView KuI;
  private final View KuJ;
  private final View KuK;
  private final View KuL;
  final ImageView KuM;
  final Drawable KuN;
  final Drawable KuO;
  final Drawable KuP;
  int KuQ;
  String KuR;
  private av KuS;
  private final String TAG;
  boolean aWl;
  final TextView kuO;
  final TextView qWT;
  
  public o(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202909);
    this.IIs = paramb;
    this.TAG = "MicroMsg.LiveCommonInfoPlugin";
    paramb = paramViewGroup.findViewById(2131307535);
    k.g(paramb, "root.findViewById(R.id.l…e_common_info_members_tv)");
    this.KuI = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307529);
    k.g(paramb, "root.findViewById(R.id.l…_common_info_duration_tv)");
    this.kuO = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307532);
    k.g(paramb, "root.findViewById(R.id.live_common_info_like_tv)");
    this.qWT = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307533);
    k.g(paramb, "root.findViewById(R.id.l…ommon_info_members_group)");
    this.KuJ = paramb;
    paramb = paramViewGroup.findViewById(2131307527);
    k.g(paramb, "root.findViewById(R.id.l…mmon_info_duration_group)");
    this.KuK = paramb;
    paramb = paramViewGroup.findViewById(2131307530);
    k.g(paramb, "root.findViewById(R.id.l…e_common_info_like_group)");
    this.KuL = paramb;
    paramViewGroup = paramViewGroup.findViewById(2131307528);
    k.g(paramViewGroup, "root.findViewById(R.id.l…ommon_info_duration_icon)");
    this.KuM = ((ImageView)paramViewGroup);
    this.KuN = agL(2131691531);
    this.KuO = agL(2131691532);
    this.KuP = agL(2131691530);
    paramViewGroup = c.c.qyj;
    this.KuQ = c.c.cmA();
    this.KuR = "00:00:00";
    this.KuS = new av("LiveCommonInfoPlugin::Timer", (av.a)new b(this), true);
    this.KuI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202897);
        if (this.KuT.IIs.getLiveRole() == 0) {
          com.tencent.mm.live.d.f.fQb();
        }
        for (;;)
        {
          b.b.a(this.KuT.IIs, b.c.FBi);
          AppMethodBeat.o(202897);
          return;
          com.tencent.mm.live.d.a.fPq();
        }
      }
    });
    AppMethodBeat.o(202909);
  }
  
  private final Drawable agL(int paramInt)
  {
    AppMethodBeat.i(202901);
    Object localObject = this.pTc.getContext();
    k.g(localObject, "root.context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt);
    k.g(localObject, "root.context.resources.getDrawable(resId)");
    AppMethodBeat.o(202901);
    return localObject;
  }
  
  private void fOI()
  {
    AppMethodBeat.i(202902);
    if (this.pTc.getVisibility() == 0)
    {
      this.KuS.stopTimer();
      this.KuS.vE(1000L);
    }
    AppMethodBeat.o(202902);
  }
  
  public final void a(LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202903);
    if ((paramLiveConfig != null) && (paramLiveConfig.ckz() == LiveConfig.qsH)) {}
    for (boolean bool = true;; bool = false)
    {
      this.aWl = bool;
      if ((paramLiveConfig == null) || (paramLiveConfig.ckz() != LiveConfig.qsH)) {
        break;
      }
      this.KuJ.setVisibility(0);
      this.KuK.setVisibility(0);
      this.KuL.setVisibility(0);
      AppMethodBeat.o(202903);
      return;
    }
    this.KuJ.setVisibility(0);
    this.KuK.setVisibility(8);
    this.KuL.setVisibility(8);
    AppMethodBeat.o(202903);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(202908);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (p.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(202908);
      return;
      agK(0);
      fOI();
      AppMethodBeat.o(202908);
      return;
      agK(8);
      AppMethodBeat.o(202908);
      return;
      if (this.IIs.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          agK(4);
          AppMethodBeat.o(202908);
          return;
        }
        agK(0);
      }
    }
  }
  
  public final void agK(int paramInt)
  {
    AppMethodBeat.i(202904);
    super.agK(paramInt);
    if (paramInt != 0) {
      this.KuS.stopTimer();
    }
    AppMethodBeat.o(202904);
  }
  
  public final void fON()
  {
    AppMethodBeat.i(202907);
    this.KuS.stopTimer();
    AppMethodBeat.o(202907);
  }
  
  public final void start()
  {
    AppMethodBeat.i(202906);
    fOI();
    AppMethodBeat.o(202906);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(202905);
    this.KuS.stopTimer();
    AppMethodBeat.o(202905);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(o paramo) {}
    
    public final void run()
    {
      AppMethodBeat.i(202899);
      int i = this.KuT.KuQ;
      Object localObject1 = c.c.qyj;
      if (i == c.c.cmA()) {
        this.KuT.KuM.setImageDrawable(this.KuT.KuN);
      }
      for (;;)
      {
        localObject1 = this.KuT.KuI;
        StringBuilder localStringBuilder = new StringBuilder(" ");
        Object localObject2 = z.Jhz;
        localObject2 = this.KuT.pTc.getContext().getString(2131766605);
        k.g(localObject2, "root.context.getString(R.string.live_members_tip)");
        com.tencent.mm.live.b.f localf = com.tencent.mm.live.b.f.rGw;
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.live.b.f.eNG().LyP) }, 1));
        k.g(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)((String)localObject2 + ' '));
        this.KuT.kuO.setText((CharSequence)(" " + this.KuT.KuR));
        localObject1 = this.KuT.qWT;
        localStringBuilder = new StringBuilder(" ");
        localObject2 = com.tencent.mm.live.b.f.rGw;
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.live.b.f.eNG().LyR);
        AppMethodBeat.o(202899);
        return;
        localObject1 = c.c.qyj;
        if (i == c.c.cmG())
        {
          this.KuT.KuM.setImageDrawable(this.KuT.KuO);
        }
        else
        {
          localObject1 = c.c.qyj;
          if (i == c.c.cnl()) {
            this.KuT.KuM.setImageDrawable(this.KuT.KuP);
          }
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements av.a
  {
    b(o paramo) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(202900);
      o localo = this.KuT;
      Object localObject;
      if (g.afz().aeI())
      {
        i = ce.asT();
        localObject = j.zaQ;
        localObject = com.tencent.mm.live.b.f.rGw;
        localo.KuR = j.a.aT(i - com.tencent.mm.live.b.f.eNG().CJd, ":");
      }
      localo = this.KuT;
      if (localo.aWl)
      {
        localObject = com.tencent.mm.live.core.core.a.b.qym;
        localObject = localo.pTc.getContext();
        k.g(localObject, "root.context");
      }
      for (int i = com.tencent.mm.live.core.core.a.b.a.eG((Context)localObject).qEd.zCj;; i = com.tencent.mm.live.core.core.c.b.a.eH((Context)localObject).qEd.zCj)
      {
        localo.KuQ = i;
        localo = this.KuT;
        localo.pTc.post((Runnable)new o.a(localo));
        AppMethodBeat.o(202900);
        return true;
        localObject = com.tencent.mm.live.core.core.c.b.qOk;
        localObject = localo.pTc.getContext();
        k.g(localObject, "root.context");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.o
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.core.core.e.m;
import com.tencent.mm.live.d.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curNetStatus", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "Landroid/widget/TextView;", "isAnchor", "", "likeGroup", "likeTv", "membersGroup", "membersIcon", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "checkDuration", "", "createTime", "checkNetwork", "getNetStatusIcon", "resId", "refreshViews", "onlineCnt", "likeCnt", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public final class o
  extends a
{
  private final String TAG;
  public boolean fFE;
  private final b kCL;
  private final TextView kEa;
  private final TextView kEb;
  private final TextView kEc;
  private final View kEd;
  private final View kEe;
  private final View kEf;
  private final ImageView kEg;
  private final ImageView kEh;
  private final Drawable kEi;
  private final Drawable kEj;
  private final Drawable kEk;
  public int kEl;
  public String kEm;
  
  public o(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(195648);
    this.kCL = paramb;
    this.TAG = "MicroMsg.LiveCommonInfoPlugin";
    paramb = paramViewGroup.findViewById(b.e.live_common_info_members_tv);
    p.j(paramb, "root.findViewById(R.id.l…e_common_info_members_tv)");
    this.kEa = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_common_info_duration_tv);
    p.j(paramb, "root.findViewById(R.id.l…_common_info_duration_tv)");
    this.kEb = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_common_info_like_tv);
    p.j(paramb, "root.findViewById(R.id.live_common_info_like_tv)");
    this.kEc = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_common_info_members_group);
    p.j(paramb, "root.findViewById(R.id.l…ommon_info_members_group)");
    this.kEd = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_common_info_duration_group);
    p.j(paramb, "root.findViewById(R.id.l…mmon_info_duration_group)");
    this.kEe = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_common_info_like_group);
    p.j(paramb, "root.findViewById(R.id.l…e_common_info_like_group)");
    this.kEf = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_common_info_duration_icon);
    p.j(paramb, "root.findViewById(R.id.l…ommon_info_duration_icon)");
    this.kEg = ((ImageView)paramb);
    paramViewGroup = paramViewGroup.findViewById(b.e.live_common_info_arrow_icon);
    p.j(paramViewGroup, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
    this.kEh = ((ImageView)paramViewGroup);
    this.kEi = tV(b.g.live_net_good_icon);
    this.kEj = tV(b.g.live_net_normal_icon);
    this.kEk = tV(b.g.live_net_bad_icon);
    paramViewGroup = e.m.kkI;
    this.kEl = e.m.aKG();
    this.kEm = "00:00:00";
    this.kEd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191069);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (o.j(this.kEn).getLiveRole() == 0) {
          f.aQL();
        }
        for (;;)
        {
          b.b.a(o.j(this.kEn), b.c.kzg);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveCommonInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(191069);
          return;
          com.tencent.mm.live.d.a.aQa();
        }
      }
    });
    AppMethodBeat.o(195648);
  }
  
  private final Drawable tV(int paramInt)
  {
    AppMethodBeat.i(195640);
    Object localObject = this.kiF.getContext();
    p.j(localObject, "root.context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt);
    p.j(localObject, "root.context.resources.getDrawable(resId)");
    AppMethodBeat.o(195640);
    return localObject;
  }
  
  public final void aPy()
  {
    AppMethodBeat.i(195641);
    com.tencent.mm.live.core.core.a.b.b localb = com.tencent.mm.live.core.core.a.b.klq;
    this.fFE = com.tencent.mm.live.core.core.a.b.b.aLi();
    if (this.fFE)
    {
      this.kEd.setVisibility(0);
      this.kEe.setVisibility(0);
      this.kEf.setVisibility(0);
      AppMethodBeat.o(195641);
      return;
    }
    this.kEd.setVisibility(0);
    this.kEe.setVisibility(8);
    this.kEf.setVisibility(8);
    AppMethodBeat.o(195641);
  }
  
  public final void dx(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(195637);
    this.kiF.post((Runnable)new a(this, paramInt1, paramInt2));
    AppMethodBeat.o(195637);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(195645);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (p.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195645);
      return;
      super.tU(0);
      AppMethodBeat.o(195645);
      return;
      super.tU(8);
      AppMethodBeat.o(195645);
      return;
      if (this.kCL.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          super.tU(4);
          AppMethodBeat.o(195645);
          return;
        }
        super.tU(0);
      }
    }
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(195643);
    super.tU(paramInt);
    AppMethodBeat.o(195643);
  }
  
  public final void unMount() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(o paramo, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(195268);
      int i = o.a(this.kEn);
      Object localObject1 = e.m.kkI;
      Object localObject2;
      if (i == e.m.aKG())
      {
        o.b(this.kEn).setImageDrawable(o.c(this.kEn));
        localObject1 = o.f(this.kEn);
        localObject2 = af.aaBG;
        localObject2 = this.kEn.kiF.getContext().getString(b.h.live_members_tip);
        p.j(localObject2, "root.context.getString(R.string.live_members_tip)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1) }, 1));
        p.j(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)String.valueOf(localObject2));
        o.g(this.kEn).setText((CharSequence)String.valueOf(o.h(this.kEn)));
        localObject2 = o.i(this.kEn);
        localObject1 = r.kvH;
        i = paramInt2;
        if (i > 0) {
          break label239;
        }
        localObject1 = "0";
      }
      for (;;)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        AppMethodBeat.o(195268);
        return;
        localObject1 = e.m.kkI;
        if (i == e.m.aKH())
        {
          o.b(this.kEn).setImageDrawable(o.d(this.kEn));
          break;
        }
        localObject1 = e.m.kkI;
        if (i != e.m.aKI()) {
          break;
        }
        o.b(this.kEn).setImageDrawable(o.e(this.kEn));
        break;
        label239:
        if (i < 10000)
        {
          localObject1 = String.valueOf(i);
        }
        else if (i % 10000 >= 1000)
        {
          localObject1 = af.aaBG;
          localObject1 = MMApplicationContext.getContext();
          p.j(localObject1, "MMApplicationContext.getContext()");
          localObject1 = ((Context)localObject1).getResources().getString(b.h.live_like_count_format);
          p.j(localObject1, "MMApplicationContext.get…g.live_like_count_format)");
          localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Float.valueOf(i / 10000.0F) }, 1));
          p.j(localObject1, "java.lang.String.format(format, *args)");
        }
        else
        {
          localObject1 = af.aaBG;
          localObject1 = MMApplicationContext.getContext();
          p.j(localObject1, "MMApplicationContext.getContext()");
          localObject1 = ((Context)localObject1).getResources().getString(b.h.live_like_count_int_format);
          p.j(localObject1, "MMApplicationContext.get…ve_like_count_int_format)");
          localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i / 10000) }, 1));
          p.j(localObject1, "java.lang.String.format(format, *args)");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.o
 * JD-Core Version:    0.7.0.1
 */
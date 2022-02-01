package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.c.f;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.e.o;
import com.tencent.mm.live.model.r;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveCommonInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curNetStatus", "", "durationGroup", "Landroid/view/View;", "durationIcon", "Landroid/widget/ImageView;", "durationText", "durationTv", "Landroid/widget/TextView;", "isAnchor", "", "likeGroup", "likeTv", "membersGroup", "membersIcon", "membersTv", "netBadIcon", "Landroid/graphics/drawable/Drawable;", "netGoodIcon", "netNormalIcon", "checkDuration", "", "createTime", "checkNetwork", "getNetStatusIcon", "resId", "refreshViews", "onlineCnt", "likeCnt", "setVisible", "visible", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends a
{
  private final String TAG;
  public boolean hKC;
  private final b nfT;
  public String nhA;
  private final TextView nho;
  private final TextView nhp;
  private final TextView nhq;
  private final View nhr;
  private final View nhs;
  private final View nht;
  private final ImageView nhu;
  private final ImageView nhv;
  private final Drawable nhw;
  private final Drawable nhx;
  private final Drawable nhy;
  public int nhz;
  
  public i(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247037);
    this.nfT = paramb;
    this.TAG = "MicroMsg.LiveCommonInfoPlugin";
    paramb = paramViewGroup.findViewById(b.e.live_common_info_members_tv);
    s.s(paramb, "root.findViewById(R.id.l…e_common_info_members_tv)");
    this.nho = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_common_info_duration_tv);
    s.s(paramb, "root.findViewById(R.id.l…_common_info_duration_tv)");
    this.nhp = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_common_info_like_tv);
    s.s(paramb, "root.findViewById(R.id.live_common_info_like_tv)");
    this.nhq = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_common_info_members_group);
    s.s(paramb, "root.findViewById(R.id.l…ommon_info_members_group)");
    this.nhr = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_common_info_duration_group);
    s.s(paramb, "root.findViewById(R.id.l…mmon_info_duration_group)");
    this.nhs = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_common_info_like_group);
    s.s(paramb, "root.findViewById(R.id.l…e_common_info_like_group)");
    this.nht = paramb;
    paramb = paramViewGroup.findViewById(b.e.live_common_info_duration_icon);
    s.s(paramb, "root.findViewById(R.id.l…ommon_info_duration_icon)");
    this.nhu = ((ImageView)paramb);
    paramViewGroup = paramViewGroup.findViewById(b.e.live_common_info_arrow_icon);
    s.s(paramViewGroup, "root.findViewById(R.id.l…e_common_info_arrow_icon)");
    this.nhv = ((ImageView)paramViewGroup);
    this.nhw = tP(b.g.live_net_good_icon);
    this.nhx = tP(b.g.live_net_normal_icon);
    this.nhy = tP(b.g.live_net_bad_icon);
    paramViewGroup = e.o.mLz;
    this.nhz = e.o.bdC();
    this.nhA = "00:00:00";
    this.nhr.setOnClickListener(new i..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(247037);
  }
  
  private static final void a(i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247071);
    s.u(parami, "this$0");
    int i = parami.nhz;
    Object localObject1 = e.o.mLz;
    if (i == e.o.bdC())
    {
      parami.nhu.setImageDrawable(parami.nhw);
      localObject1 = parami.nho;
      Object localObject2 = am.aixg;
      localObject2 = parami.mJe.getContext().getString(b.h.live_members_tip);
      s.s(localObject2, "root.context.getString(R.string.live_members_tip)");
      localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt1) }, 1));
      s.s(localObject2, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)String.valueOf(localObject2));
      parami.nhp.setText((CharSequence)String.valueOf(parami.nhA));
      localObject1 = parami.nhq;
      parami = r.mZi;
      if (paramInt2 > 0) {
        break label218;
      }
      parami = "0";
    }
    for (;;)
    {
      ((TextView)localObject1).setText((CharSequence)parami);
      AppMethodBeat.o(247071);
      return;
      localObject1 = e.o.mLz;
      if (i == e.o.bdD())
      {
        parami.nhu.setImageDrawable(parami.nhx);
        break;
      }
      localObject1 = e.o.mLz;
      if (i != e.o.bdE()) {
        break;
      }
      parami.nhu.setImageDrawable(parami.nhy);
      break;
      label218:
      if (paramInt2 < 10000)
      {
        parami = String.valueOf(paramInt2);
      }
      else if (paramInt2 % 10000 >= 1000)
      {
        parami = am.aixg;
        parami = MMApplicationContext.getContext().getResources().getString(b.h.live_like_count_format);
        s.s(parami, "getContext().resources.g…g.live_like_count_format)");
        parami = String.format(parami, Arrays.copyOf(new Object[] { Float.valueOf(paramInt2 / 10000.0F) }, 1));
        s.s(parami, "java.lang.String.format(format, *args)");
      }
      else
      {
        parami = am.aixg;
        parami = MMApplicationContext.getContext().getResources().getString(b.h.live_like_count_int_format);
        s.s(parami, "getContext().resources.g…ve_like_count_int_format)");
        parami = String.format(parami, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt2 / 10000) }, 1));
        s.s(parami, "java.lang.String.format(format, *args)");
      }
    }
  }
  
  private static final void a(i parami, View paramView)
  {
    AppMethodBeat.i(247055);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveCommonInfoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    if (parami.nfT.getLiveRole() == 0) {
      f.bky();
    }
    for (;;)
    {
      b.b.a(parami.nfT, b.c.ncv);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveCommonInfoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247055);
      return;
      com.tencent.mm.live.c.a.bjN();
    }
  }
  
  private final Drawable tP(int paramInt)
  {
    AppMethodBeat.i(247047);
    Drawable localDrawable = this.mJe.getContext().getResources().getDrawable(paramInt);
    s.s(localDrawable, "root.context.resources.getDrawable(resId)");
    AppMethodBeat.o(247047);
    return localDrawable;
  }
  
  public final void bjl()
  {
    AppMethodBeat.i(247108);
    b.a locala = com.tencent.mm.live.core.core.a.b.mMo;
    this.hKC = b.a.bek();
    if (this.hKC)
    {
      this.nhr.setVisibility(0);
      this.nhs.setVisibility(0);
      this.nht.setVisibility(0);
      AppMethodBeat.o(247108);
      return;
    }
    this.nhr.setVisibility(0);
    this.nhs.setVisibility(8);
    this.nht.setVisibility(8);
    AppMethodBeat.o(247108);
  }
  
  public final void eo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247100);
    this.mJe.post(new i..ExternalSyntheticLambda1(this, paramInt1, paramInt2));
    AppMethodBeat.o(247100);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(247145);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (i.a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247145);
      return;
      super.tO(0);
      AppMethodBeat.o(247145);
      return;
      super.tO(8);
      AppMethodBeat.o(247145);
      return;
      if (this.nfT.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true)) {}
        while (i != 0)
        {
          super.tO(4);
          AppMethodBeat.o(247145);
          return;
          i = 0;
        }
        super.tO(0);
      }
    }
  }
  
  public final void stop() {}
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(247114);
    super.tO(paramInt);
    AppMethodBeat.o(247114);
  }
  
  public final void unMount() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.i
 * JD-Core Version:    0.7.0.1
 */
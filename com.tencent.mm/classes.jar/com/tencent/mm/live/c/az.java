package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.d.e;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "acatarIcon", "Lcom/tencent/mm/ui/widget/RoundCornerImageView;", "anchorUsername", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "nameTv", "Landroid/widget/TextView;", "titleTv", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateLiveTitle", "title", "", "username", "plugin-logic_release"})
public final class az
  extends a
{
  final b IIs;
  private final RoundCornerImageView KwU;
  private Context context;
  private final TextView ftj;
  String quk;
  private final TextView titleTv;
  
  public az(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(203070);
    this.IIs = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307723);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
    this.KwU = ((RoundCornerImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307725);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_title_info_name_tv)");
    this.ftj = ((TextView)paramb);
    paramViewGroup = paramViewGroup.findViewById(2131307726);
    d.g.b.k.g(paramViewGroup, "root.findViewById(R.id.live_title_info_title_tv)");
    this.titleTv = ((TextView)paramViewGroup);
    this.KwU.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203066);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("PARAM_MEMBERS_PROFILE_USERNAME", this.KwV.quk);
        this.KwV.IIs.a(b.c.HRH, paramAnonymousView);
        if (this.KwV.IIs.getLiveRole() == 0)
        {
          paramAnonymousView = com.tencent.mm.live.b.f.rGw;
          paramAnonymousView = com.tencent.mm.live.b.f.eNB();
          com.tencent.mm.live.b.f localf = com.tencent.mm.live.b.f.rGw;
          long l = com.tencent.mm.live.b.f.eNG().LwA;
          localf = com.tencent.mm.live.b.f.rGw;
          e.a(paramAnonymousView, l, com.tencent.mm.live.b.f.eNI(), 8, 1);
          com.tencent.mm.live.d.f.fQc();
        }
        AppMethodBeat.o(203066);
      }
    });
    AppMethodBeat.o(203070);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(203069);
    d.g.b.k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (ba.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(203069);
      return;
      agK(4);
      AppMethodBeat.o(203069);
      return;
      if (this.IIs.getLiveRole() == 1)
      {
        paramc = com.tencent.mm.live.b.f.rGw;
        paramc = com.tencent.mm.live.b.f.eNG().LwZ;
        d.g.b.k.g(paramc, "LiveDataManager.liveInfo.live_name");
        paramc = (CharSequence)paramc;
        paramBundle = com.tencent.mm.live.b.f.rGw;
        g(paramc, com.tencent.mm.live.b.f.eNI());
        AppMethodBeat.o(203069);
        return;
      }
      agK(4);
      AppMethodBeat.o(203069);
      return;
      agK(0);
      AppMethodBeat.o(203069);
      return;
      if (this.IIs.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          agK(4);
          AppMethodBeat.o(203069);
          return;
        }
        agK(0);
      }
    }
  }
  
  public final void g(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(203068);
    d.g.b.k.h(paramCharSequence, "title");
    d.g.b.k.h(paramString, "username");
    this.quk = paramString;
    a.b.c((ImageView)this.KwU, paramString);
    this.titleTv.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramCharSequence, this.titleTv.getTextSize()));
    this.ftj.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(this.pTc.getContext(), (CharSequence)v.sh(paramString), this.titleTv.getTextSize()));
    AppMethodBeat.o(203068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.az
 * JD-Core Version:    0.7.0.1
 */
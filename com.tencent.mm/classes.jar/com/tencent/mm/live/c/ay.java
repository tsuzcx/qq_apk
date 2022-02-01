package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "acatarIcon", "Lcom/tencent/mm/ui/widget/RoundCornerImageView;", "anchorUsername", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "Landroid/widget/TextView;", "titleTv", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateLiveTitle", "title", "", "username", "plugin-logic_release"})
public final class ay
  extends a
{
  private Context context;
  private final TextView fwQ;
  private final RoundCornerImageView gDp;
  String gmT;
  final b gzb;
  private int gzi;
  private final TextView titleTv;
  
  public ay(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190306);
    this.gzb = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307804);
    d.g.b.k.g(paramb, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
    this.gDp = ((RoundCornerImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307806);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_title_info_name_tv)");
    this.fwQ = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307807);
    d.g.b.k.g(paramb, "root.findViewById(R.id.live_title_info_title_tv)");
    this.titleTv = ((TextView)paramb);
    this.gzi = ap.ej(paramViewGroup.getContext());
    this.gDp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190301);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("PARAM_MEMBERS_PROFILE_USERNAME", this.gDq.gmT);
        this.gDq.gzb.a(b.c.gys, paramAnonymousView);
        if (this.gDq.gzb.getLiveRole() == 0)
        {
          paramAnonymousView = g.guG;
          paramAnonymousView = g.akA();
          g localg = g.guG;
          long l = g.akF().DMV;
          localg = g.guG;
          e.a(paramAnonymousView, l, g.akH(), 8, 1);
          f.ano();
        }
        AppMethodBeat.o(190301);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (aly())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(190306);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190306);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(ap.ej(paramViewGroup.getContext()));
      AppMethodBeat.o(190306);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190306);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(ao.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190305);
    d.g.b.k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (az.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190305);
      return;
      nj(4);
      AppMethodBeat.o(190305);
      return;
      if (this.gzb.getLiveRole() == 1)
      {
        paramc = g.guG;
        paramc = g.akF().Eud;
        d.g.b.k.g(paramc, "LiveDataManager.liveInfo.live_name");
        paramc = (CharSequence)paramc;
        paramBundle = g.guG;
        a(paramc, g.akH());
        AppMethodBeat.o(190305);
        return;
      }
      nj(4);
      AppMethodBeat.o(190305);
      return;
      nj(0);
      AppMethodBeat.o(190305);
      return;
      if (this.gzb.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nj(4);
          AppMethodBeat.o(190305);
          return;
        }
        nj(0);
        AppMethodBeat.o(190305);
        return;
        if ((this.gnb.getLayoutParams() != null) && ((this.gnb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.gnb.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(190305);
              throw paramc;
            }
          case 3: 
            paramc = this.gnb.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(190305);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(this.gzi);
            this.gnb.requestLayout();
            AppMethodBeat.o(190305);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(ao.fromDPToPix(this.gnb.getContext(), 16));
            this.gnb.requestLayout();
          }
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(190304);
    d.g.b.k.h(paramCharSequence, "title");
    d.g.b.k.h(paramString, "username");
    this.gmT = paramString;
    a.b.c((ImageView)this.gDp, paramString);
    this.titleTv.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramCharSequence, this.titleTv.getTextSize()));
    TextView localTextView = this.fwQ;
    Context localContext = this.gnb.getContext();
    g localg = g.guG;
    localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, (CharSequence)g.uT(paramString), this.titleTv.getTextSize()));
    if (bs.aj(paramCharSequence))
    {
      this.titleTv.setVisibility(8);
      this.fwQ.requestLayout();
      AppMethodBeat.o(190304);
      return;
    }
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(190304);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(190303);
    super.resume();
    int j = ap.ej(this.gnb.getContext());
    int i = j;
    if (j == 0) {
      i = ao.fromDPToPix(this.gnb.getContext(), 16);
    }
    this.gzi = i;
    AppMethodBeat.o(190303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ay
 * JD-Core Version:    0.7.0.1
 */
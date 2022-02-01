package com.tencent.mm.live.b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.c.e;
import com.tencent.mm.live.c.f;
import com.tencent.mm.live.model.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "acatarIcon", "Landroid/widget/ImageView;", "anchorUsername", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "Landroid/widget/TextView;", "titleTv", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateLiveTitle", "title", "", "username", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends a
{
  private Context context;
  private final TextView lDF;
  private String mIC;
  private final b nfT;
  private int ngo;
  private final ImageView njV;
  private final TextView titleTv;
  
  public ab(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247372);
    this.nfT = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(b.e.live_title_info_avatar_icon);
    s.s(paramb, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
    this.njV = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_title_info_name_tv);
    s.s(paramb, "root.findViewById(R.id.live_title_info_name_tv)");
    this.lDF = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_title_info_title_tv);
    s.s(paramb, "root.findViewById(R.id.live_title_info_title_tv)");
    this.titleTv = ((TextView)paramb);
    this.ngo = bf.bk(paramViewGroup.getContext());
    this.njV.setOnClickListener(new ab..ExternalSyntheticLambda0(this));
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (isLandscape())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(247372);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247372);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(bf.bk(paramViewGroup.getContext()));
      AppMethodBeat.o(247372);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247372);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(bd.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  private static final void a(ab paramab, View paramView)
  {
    AppMethodBeat.i(247383);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramab);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveTitleInfoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramab, "this$0");
    paramView = new Bundle();
    paramView.putString("PARAM_MEMBERS_PROFILE_USERNAME", paramab.mIC);
    paramab.nfT.statusChange(b.c.ncV, paramView);
    if (paramab.nfT.getLiveRole() == 0)
    {
      paramab = u.mZl;
      paramab = u.bhZ();
      paramView = u.mZl;
      long l = u.bie().mMJ;
      paramView = u.mZl;
      paramView = u.big();
      localObject = u.mZl;
      e.a(paramab, l, paramView, 8, 1, u.bie().ZWw);
      f.bkz();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveTitleInfoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(247383);
  }
  
  public final void a(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(247432);
    s.u(paramCharSequence, "title");
    s.u(paramString, "username");
    this.mIC = paramString;
    a.b.g(this.njV, paramString);
    this.titleTv.setText((CharSequence)p.b(this.context, paramCharSequence, this.titleTv.getTextSize()));
    TextView localTextView = this.lDF;
    Context localContext = this.mJe.getContext();
    u localu = u.mZl;
    localTextView.setText((CharSequence)p.b(localContext, (CharSequence)u.Gt(paramString), this.titleTv.getTextSize()));
    if (Util.isNullOrNil(paramCharSequence))
    {
      this.titleTv.setVisibility(8);
      this.lDF.requestLayout();
      AppMethodBeat.o(247432);
      return;
    }
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(247432);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(247397);
    super.resume();
    int j = bf.bk(this.mJe.getContext());
    int i = j;
    if (j == 0) {
      i = bd.fromDPToPix(this.mJe.getContext(), 16);
    }
    this.ngo = i;
    AppMethodBeat.o(247397);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(247447);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247447);
      return;
      tO(4);
      AppMethodBeat.o(247447);
      return;
      tO(0);
      AppMethodBeat.o(247447);
      return;
      if (this.nfT.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true)) {}
        while (i != 0)
        {
          tO(4);
          AppMethodBeat.o(247447);
          return;
          i = 0;
        }
        tO(0);
        AppMethodBeat.o(247447);
        return;
        if ((this.mJe.getLayoutParams() != null) && ((this.mJe.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.mJe.getLayoutParams();
            if (paramc == null)
            {
              paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(247447);
              throw paramc;
            }
          case 3: 
            paramc = this.mJe.getLayoutParams();
            if (paramc == null)
            {
              paramc = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(247447);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(this.ngo);
            this.mJe.requestLayout();
            AppMethodBeat.o(247447);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(bd.fromDPToPix(this.mJe.getContext(), 16));
            this.mJe.requestLayout();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.ab
 * JD-Core Version:    0.7.0.1
 */
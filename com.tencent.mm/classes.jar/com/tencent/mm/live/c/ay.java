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
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "acatarIcon", "Landroid/widget/ImageView;", "anchorUsername", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "Landroid/widget/TextView;", "titleTv", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateLiveTitle", "title", "", "username", "plugin-logic_release"})
public final class ay
  extends a
{
  private Context context;
  private final TextView jbF;
  private final b kCL;
  private int kCS;
  private final ImageView kHc;
  private String kig;
  private final TextView titleTv;
  
  public ay(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(196921);
    this.kCL = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(b.e.live_title_info_avatar_icon);
    p.j(paramb, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
    this.kHc = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_title_info_name_tv);
    p.j(paramb, "root.findViewById(R.id.live_title_info_name_tv)");
    this.jbF = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(b.e.live_title_info_title_tv);
    p.j(paramb, "root.findViewById(R.id.live_title_info_title_tv)");
    this.titleTv = ((TextView)paramb);
    this.kCS = ax.aB(paramViewGroup.getContext());
    this.kHc.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(195683);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveTitleInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("PARAM_MEMBERS_PROFILE_USERNAME", ay.a(this.kHd));
        ay.b(this.kHd).statusChange(b.c.kzF, paramAnonymousView);
        if (ay.b(this.kHd).getLiveRole() == 0)
        {
          paramAnonymousView = u.kwz;
          paramAnonymousView = u.aOm();
          localObject = u.kwz;
          long l = u.aOr().klE;
          localObject = u.kwz;
          localObject = u.aOt();
          u localu = u.kwz;
          e.a(paramAnonymousView, l, (String)localObject, 8, 1, u.aOr().SOs);
          f.aQM();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveTitleInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195683);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (isLandscape())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(196921);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(196921);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(ax.aB(paramViewGroup.getContext()));
      AppMethodBeat.o(196921);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(196921);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(aw.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(196902);
    p.k(paramCharSequence, "title");
    p.k(paramString, "username");
    this.kig = paramString;
    a.b.c(this.kHc, paramString);
    this.titleTv.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(this.context, paramCharSequence, this.titleTv.getTextSize()));
    TextView localTextView = this.jbF;
    Context localContext = this.kiF.getContext();
    u localu = u.kwz;
    localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, (CharSequence)u.Og(paramString), this.titleTv.getTextSize()));
    if (Util.isNullOrNil(paramCharSequence))
    {
      this.titleTv.setVisibility(8);
      this.jbF.requestLayout();
      AppMethodBeat.o(196902);
      return;
    }
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(196902);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(196900);
    super.resume();
    int j = ax.aB(this.kiF.getContext());
    int i = j;
    if (j == 0) {
      i = aw.fromDPToPix(this.kiF.getContext(), 16);
    }
    this.kCS = i;
    AppMethodBeat.o(196900);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(196906);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (az.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196906);
      return;
      tU(4);
      AppMethodBeat.o(196906);
      return;
      tU(0);
      AppMethodBeat.o(196906);
      return;
      if (this.kCL.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          tU(4);
          AppMethodBeat.o(196906);
          return;
        }
        tU(0);
        AppMethodBeat.o(196906);
        return;
        if ((this.kiF.getLayoutParams() != null) && ((this.kiF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.kiF.getLayoutParams();
            if (paramc == null)
            {
              paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(196906);
              throw paramc;
            }
          case 3: 
            paramc = this.kiF.getLayoutParams();
            if (paramc == null)
            {
              paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(196906);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(this.kCS);
            this.kiF.requestLayout();
            AppMethodBeat.o(196906);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(aw.fromDPToPix(this.kiF.getContext(), 16));
            this.kiF.requestLayout();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ay
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.d.e;
import com.tencent.mm.live.d.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "acatarIcon", "Landroid/widget/ImageView;", "anchorUsername", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "Landroid/widget/TextView;", "titleTv", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateLiveTitle", "title", "", "username", "plugin-logic_release"})
public final class ay
  extends a
{
  private Context context;
  private final TextView gxs;
  final b hOp;
  private int hOw;
  private final ImageView hSF;
  String hwd;
  private final TextView titleTv;
  
  public ay(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208183);
    this.hOp = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131303591);
    p.g(paramb, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
    this.hSF = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131303593);
    p.g(paramb, "root.findViewById(R.id.live_title_info_name_tv)");
    this.gxs = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131303595);
    p.g(paramb, "root.findViewById(R.id.live_title_info_title_tv)");
    this.titleTv = ((TextView)paramb);
    this.hOw = au.aD(paramViewGroup.getContext());
    this.hSF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208178);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveTitleInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("PARAM_MEMBERS_PROFILE_USERNAME", this.hSG.hwd);
        this.hSG.hOp.statusChange(b.c.hMk, paramAnonymousView);
        if (this.hSG.hOp.getLiveRole() == 0)
        {
          paramAnonymousView = x.hJf;
          paramAnonymousView = x.aGm();
          localObject = x.hJf;
          long l = x.aGr().hyH;
          localObject = x.hJf;
          localObject = x.aGt();
          x localx = x.hJf;
          e.a(paramAnonymousView, l, (String)localObject, 8, 1, x.aGr().LIa);
          f.aIO();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveTitleInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208178);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (isLandscape())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(208183);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(208183);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(au.aD(paramViewGroup.getContext()));
      AppMethodBeat.o(208183);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(208183);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(at.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(208181);
    p.h(paramCharSequence, "title");
    p.h(paramString, "username");
    this.hwd = paramString;
    a.b.c(this.hSF, paramString);
    this.titleTv.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(this.context, paramCharSequence, this.titleTv.getTextSize()));
    TextView localTextView = this.gxs;
    Context localContext = this.hwr.getContext();
    x localx = x.hJf;
    localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, (CharSequence)x.GV(paramString), this.titleTv.getTextSize()));
    if (Util.isNullOrNil(paramCharSequence))
    {
      this.titleTv.setVisibility(8);
      this.gxs.requestLayout();
      AppMethodBeat.o(208181);
      return;
    }
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(208181);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(208180);
    super.resume();
    int j = au.aD(this.hwr.getContext());
    int i = j;
    if (j == 0) {
      i = at.fromDPToPix(this.hwr.getContext(), 16);
    }
    this.hOw = i;
    AppMethodBeat.o(208180);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208182);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (az.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208182);
      return;
      rg(4);
      AppMethodBeat.o(208182);
      return;
      rg(0);
      AppMethodBeat.o(208182);
      return;
      if (this.hOp.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          rg(4);
          AppMethodBeat.o(208182);
          return;
        }
        rg(0);
        AppMethodBeat.o(208182);
        return;
        if ((this.hwr.getLayoutParams() != null) && ((this.hwr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.hwr.getLayoutParams();
            if (paramc == null)
            {
              paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(208182);
              throw paramc;
            }
          case 3: 
            paramc = this.hwr.getLayoutParams();
            if (paramc == null)
            {
              paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(208182);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(this.hOw);
            this.hwr.requestLayout();
            AppMethodBeat.o(208182);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(at.fromDPToPix(this.hwr.getContext(), 16));
            this.hwr.requestLayout();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.ay
 * JD-Core Version:    0.7.0.1
 */
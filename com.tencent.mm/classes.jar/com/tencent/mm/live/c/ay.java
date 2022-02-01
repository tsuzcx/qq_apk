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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "acatarIcon", "Lcom/tencent/mm/ui/widget/RoundCornerImageView;", "anchorUsername", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "Landroid/widget/TextView;", "titleTv", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateLiveTitle", "title", "", "username", "plugin-logic_release"})
public final class ay
  extends a
{
  private Context context;
  private final TextView fQd;
  String gGC;
  final b gSM;
  private int gST;
  private final RoundCornerImageView gWZ;
  private final TextView titleTv;
  
  public ay(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212596);
    this.gSM = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307804);
    p.g(paramb, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
    this.gWZ = ((RoundCornerImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307806);
    p.g(paramb, "root.findViewById(R.id.live_title_info_name_tv)");
    this.fQd = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307807);
    p.g(paramb, "root.findViewById(R.id.live_title_info_title_tv)");
    this.titleTv = ((TextView)paramb);
    this.gST = ar.ej(paramViewGroup.getContext());
    this.gWZ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212591);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveTitleInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("PARAM_MEMBERS_PROFILE_USERNAME", this.gXa.gGC);
        this.gXa.gSM.a(b.c.gSd, paramAnonymousView);
        if (this.gXa.gSM.getLiveRole() == 0)
        {
          paramAnonymousView = g.gOr;
          paramAnonymousView = g.anm();
          localObject = g.gOr;
          long l = g.ans().Fsa;
          localObject = g.gOr;
          e.a(paramAnonymousView, l, g.anu(), 8, 1);
          f.aqb();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveTitleInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212591);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (aol())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(212596);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(212596);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(ar.ej(paramViewGroup.getContext()));
      AppMethodBeat.o(212596);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(212596);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(aq.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212595);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (az.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212595);
      return;
      nI(4);
      AppMethodBeat.o(212595);
      return;
      if (this.gSM.getLiveRole() == 1)
      {
        paramc = g.gOr;
        paramc = g.ans().Gbw;
        p.g(paramc, "LiveDataManager.liveInfo.live_name");
        paramc = (CharSequence)paramc;
        paramBundle = g.gOr;
        a(paramc, g.anu());
        AppMethodBeat.o(212595);
        return;
      }
      nI(4);
      AppMethodBeat.o(212595);
      return;
      nI(0);
      AppMethodBeat.o(212595);
      return;
      if (this.gSM.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nI(4);
          AppMethodBeat.o(212595);
          return;
        }
        nI(0);
        AppMethodBeat.o(212595);
        return;
        if ((this.gGK.getLayoutParams() != null) && ((this.gGK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.gGK.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(212595);
              throw paramc;
            }
          case 3: 
            paramc = this.gGK.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(212595);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(this.gST);
            this.gGK.requestLayout();
            AppMethodBeat.o(212595);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(aq.fromDPToPix(this.gGK.getContext(), 16));
            this.gGK.requestLayout();
          }
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(212594);
    p.h(paramCharSequence, "title");
    p.h(paramString, "username");
    this.gGC = paramString;
    a.b.c((ImageView)this.gWZ, paramString);
    this.titleTv.setText((CharSequence)k.b(this.context, paramCharSequence, this.titleTv.getTextSize()));
    TextView localTextView = this.fQd;
    Context localContext = this.gGK.getContext();
    g localg = g.gOr;
    localTextView.setText((CharSequence)k.b(localContext, (CharSequence)g.xJ(paramString), this.titleTv.getTextSize()));
    if (bt.ai(paramCharSequence))
    {
      this.titleTv.setVisibility(8);
      this.fQd.requestLayout();
      AppMethodBeat.o(212594);
      return;
    }
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(212594);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(212593);
    super.resume();
    int j = ar.ej(this.gGK.getContext());
    int i = j;
    if (j == 0) {
      i = aq.fromDPToPix(this.gGK.getContext(), 16);
    }
    this.gST = i;
    AppMethodBeat.o(212593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ay
 * JD-Core Version:    0.7.0.1
 */
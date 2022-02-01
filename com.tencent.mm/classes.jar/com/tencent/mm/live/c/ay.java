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
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveTitleInfoPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "acatarIcon", "Lcom/tencent/mm/ui/widget/RoundCornerImageView;", "anchorUsername", "", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "Landroid/widget/TextView;", "titleTv", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateLiveTitle", "title", "", "username", "plugin-logic_release"})
public final class ay
  extends a
{
  private Context context;
  private final TextView fSj;
  String gJl;
  private int gVC;
  final b gVv;
  private final RoundCornerImageView gZM;
  private final TextView titleTv;
  
  public ay(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216222);
    this.gVv = paramb;
    this.context = paramViewGroup.getContext();
    paramb = paramViewGroup.findViewById(2131307804);
    p.g(paramb, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
    this.gZM = ((RoundCornerImageView)paramb);
    paramb = paramViewGroup.findViewById(2131307806);
    p.g(paramb, "root.findViewById(R.id.live_title_info_name_tv)");
    this.fSj = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(2131307807);
    p.g(paramb, "root.findViewById(R.id.live_title_info_title_tv)");
    this.titleTv = ((TextView)paramb);
    this.gVC = ar.en(paramViewGroup.getContext());
    this.gZM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216217);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveTitleInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putString("PARAM_MEMBERS_PROFILE_USERNAME", this.gZN.gJl);
        this.gZN.gVv.a(b.c.gUL, paramAnonymousView);
        if (this.gZN.gVv.getLiveRole() == 0)
        {
          paramAnonymousView = g.gQZ;
          paramAnonymousView = g.anC();
          localObject = g.gQZ;
          long l = g.anH().FKy;
          localObject = g.gQZ;
          localObject = g.anJ();
          g localg = g.gQZ;
          e.a(paramAnonymousView, l, (String)localObject, 8, 1, g.anH().GTv);
          f.aqq();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveTitleInfoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216217);
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (aoA())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(216222);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(216222);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(ar.en(paramViewGroup.getContext()));
      AppMethodBeat.o(216222);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(216222);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginStart(aq.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216221);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (az.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216221);
      return;
      nL(4);
      AppMethodBeat.o(216221);
      return;
      if (this.gVv.getLiveRole() == 1)
      {
        paramc = g.gQZ;
        paramc = g.anH().Gud;
        p.g(paramc, "LiveDataManager.liveInfo.live_name");
        paramc = (CharSequence)paramc;
        paramBundle = g.gQZ;
        a(paramc, g.anJ());
        AppMethodBeat.o(216221);
        return;
      }
      nL(4);
      AppMethodBeat.o(216221);
      return;
      nL(0);
      AppMethodBeat.o(216221);
      return;
      if (this.gVv.getLiveRole() == 0)
      {
        if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
        {
          nL(4);
          AppMethodBeat.o(216221);
          return;
        }
        nL(0);
        AppMethodBeat.o(216221);
        return;
        if ((this.gJt.getLayoutParams() != null) && ((this.gJt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
          switch (getCurrentOrientation())
          {
          case 2: 
          default: 
            break;
          case 1: 
            paramc = this.gJt.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(216221);
              throw paramc;
            }
          case 3: 
            paramc = this.gJt.getLayoutParams();
            if (paramc == null)
            {
              paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
              AppMethodBeat.o(216221);
              throw paramc;
            }
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(this.gVC);
            this.gJt.requestLayout();
            AppMethodBeat.o(216221);
            return;
            ((ViewGroup.MarginLayoutParams)paramc).setMarginStart(aq.fromDPToPix(this.gJt.getContext(), 16));
            this.gJt.requestLayout();
          }
        }
      }
    }
  }
  
  public final void a(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(216220);
    p.h(paramCharSequence, "title");
    p.h(paramString, "username");
    this.gJl = paramString;
    a.b.c((ImageView)this.gZM, paramString);
    this.titleTv.setText((CharSequence)k.b(this.context, paramCharSequence, this.titleTv.getTextSize()));
    TextView localTextView = this.fSj;
    Context localContext = this.gJt.getContext();
    g localg = g.gQZ;
    localTextView.setText((CharSequence)k.b(localContext, (CharSequence)g.ys(paramString), this.titleTv.getTextSize()));
    if (bu.ah(paramCharSequence))
    {
      this.titleTv.setVisibility(8);
      this.fSj.requestLayout();
      AppMethodBeat.o(216220);
      return;
    }
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(216220);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(216219);
    super.resume();
    int j = ar.en(this.gJt.getContext());
    int i = j;
    if (j == 0) {
      i = aq.fromDPToPix(this.gJt.getContext(), 16);
    }
    this.gVC = i;
    AppMethodBeat.o(216219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.ay
 * JD-Core Version:    0.7.0.1
 */
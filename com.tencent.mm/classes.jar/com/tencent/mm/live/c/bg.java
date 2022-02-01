package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.b.g;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.t;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentCallback", "Lkotlin/Function1;", "", "", "inputHintDescTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "inputHintTv", "Landroid/view/View;", "inputImg", "Landroid/widget/ImageView;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "udpateBanCommentState", "plugin-logic_release"})
public final class bg
  extends a
{
  private final d.g.a.b<String, y> gAg;
  private final ImageView gDE;
  private final View gDF;
  private final TextView gDG;
  final b gzk;
  
  public bg(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190341);
    this.gzk = paramb;
    this.gDE = ((ImageView)paramViewGroup.findViewById(2131307639));
    this.gDF = paramViewGroup.findViewById(2131307638);
    this.gDG = ((TextView)paramViewGroup.findViewById(2131307636));
    this.gAg = ((d.g.a.b)new a(this));
    amm();
    this.gDF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190335);
        paramAnonymousView = g.guG;
        if (g.akF().DVV)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
          this.gDH.gzk.a(b.c.gyl, paramAnonymousView);
          AppMethodBeat.o(190335);
          return;
        }
        t.makeText(paramViewGroup.getContext(), (CharSequence)com.tencent.mm.cc.a.aw(paramViewGroup.getContext(), 2131766726), 0).show();
        AppMethodBeat.o(190335);
      }
    });
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -2);
      paramb.bottomMargin = ap.ej(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      k.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup = c.gtd;
    c.a(name(), this.gAg);
    AppMethodBeat.o(190341);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190340);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (bh.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190340);
      return;
      nj(8);
      AppMethodBeat.o(190340);
      return;
      nj(0);
      AppMethodBeat.o(190340);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
      {
        nj(8);
        AppMethodBeat.o(190340);
        return;
      }
      nj(0);
    }
  }
  
  public final void amm()
  {
    AppMethodBeat.i(190339);
    Object localObject = g.guG;
    if (g.akF().DVV)
    {
      localObject = this.gDG;
      k.g(localObject, "inputHintDescTv");
      localContext = this.gnb.getContext();
      k.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766612));
      localObject = this.gDE;
      localContext = this.gnb.getContext();
      k.g(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(am.e(localContext.getResources().getDrawable(2131691513), -1));
      AppMethodBeat.o(190339);
      return;
    }
    localObject = this.gDG;
    k.g(localObject, "inputHintDescTv");
    Context localContext = this.gnb.getContext();
    k.g(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766612));
    localObject = this.gDE;
    localContext = this.gnb.getContext();
    k.g(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(am.e(localContext.getResources().getDrawable(2131691512), -1));
    AppMethodBeat.o(190339);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    a(bg parambg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bg
 * JD-Core Version:    0.7.0.1
 */
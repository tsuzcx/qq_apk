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
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentCallback", "Lkotlin/Function1;", "", "", "inputHintDescTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "inputHintTv", "Landroid/view/View;", "inputImg", "Landroid/widget/ImageView;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "udpateBanCommentState", "plugin-logic_release"})
public final class bg
  extends a
{
  final b gVE;
  private final d.g.a.b<String, z> gWB;
  private final ImageView haa;
  private final View hab;
  private final TextView hac;
  
  public bg(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216257);
    this.gVE = paramb;
    this.haa = ((ImageView)paramViewGroup.findViewById(2131307639));
    this.hab = paramViewGroup.findViewById(2131307638);
    this.hac = ((TextView)paramViewGroup.findViewById(2131307636));
    this.gWB = ((d.g.a.b)new a(this));
    apn();
    this.hab.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216251);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = g.gQZ;
        if (g.anH().FTM)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
          this.had.gVE.a(b.c.gUE, paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216251);
          return;
          t.makeText(paramViewGroup.getContext(), (CharSequence)com.tencent.mm.cb.a.az(paramViewGroup.getContext(), 2131766726), 0).show();
        }
      }
    });
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -2);
      paramb.bottomMargin = ar.en(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      p.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup = c.gPx;
    c.a(name(), this.gWB);
    AppMethodBeat.o(216257);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216256);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (bh.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216256);
      return;
      nL(8);
      AppMethodBeat.o(216256);
      return;
      nL(0);
      AppMethodBeat.o(216256);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
      {
        nL(8);
        AppMethodBeat.o(216256);
        return;
      }
      nL(0);
    }
  }
  
  public final void apn()
  {
    AppMethodBeat.i(216255);
    Object localObject = g.gQZ;
    if (g.anH().FTM)
    {
      localObject = this.hac;
      p.g(localObject, "inputHintDescTv");
      localContext = this.gJt.getContext();
      p.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766612));
      localObject = this.haa;
      localContext = this.gJt.getContext();
      p.g(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691513), -1));
      AppMethodBeat.o(216255);
      return;
    }
    localObject = this.hac;
    p.g(localObject, "inputHintDescTv");
    Context localContext = this.gJt.getContext();
    p.g(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766612));
    localObject = this.haa;
    localContext = this.gJt.getContext();
    p.g(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691512), -1));
    AppMethodBeat.o(216255);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<String, z>
  {
    a(bg parambg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.bg
 * JD-Core Version:    0.7.0.1
 */
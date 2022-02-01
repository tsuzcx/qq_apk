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
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentCallback", "Lkotlin/Function1;", "", "", "inputHintDescTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "inputHintTv", "Landroid/view/View;", "inputImg", "Landroid/widget/ImageView;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "udpateBanCommentState", "plugin-logic_release"})
public final class bg
  extends a
{
  final b gSV;
  private final d.g.a.b<String, z> gTR;
  private final ImageView gXo;
  private final View gXp;
  private final TextView gXq;
  
  public bg(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212631);
    this.gSV = paramb;
    this.gXo = ((ImageView)paramViewGroup.findViewById(2131307639));
    this.gXp = paramViewGroup.findViewById(2131307638);
    this.gXq = ((TextView)paramViewGroup.findViewById(2131307636));
    this.gTR = ((d.g.a.b)new a(this));
    aoZ();
    this.gXp.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212625);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = g.gOr;
        if (g.ans().FBr)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
          this.gXr.gSV.a(b.c.gRW, paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212625);
          return;
          t.makeText(paramViewGroup.getContext(), (CharSequence)com.tencent.mm.cc.a.az(paramViewGroup.getContext(), 2131766726), 0).show();
        }
      }
    });
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -2);
      paramb.bottomMargin = ar.ej(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      p.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup = c.gMO;
    c.a(name(), this.gTR);
    AppMethodBeat.o(212631);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212630);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (bh.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212630);
      return;
      nI(8);
      AppMethodBeat.o(212630);
      return;
      nI(0);
      AppMethodBeat.o(212630);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
      {
        nI(8);
        AppMethodBeat.o(212630);
        return;
      }
      nI(0);
    }
  }
  
  public final void aoZ()
  {
    AppMethodBeat.i(212629);
    Object localObject = g.gOr;
    if (g.ans().FBr)
    {
      localObject = this.gXq;
      p.g(localObject, "inputHintDescTv");
      localContext = this.gGK.getContext();
      p.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766612));
      localObject = this.gXo;
      localContext = this.gGK.getContext();
      p.g(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691513), -1));
      AppMethodBeat.o(212629);
      return;
    }
    localObject = this.gXq;
    p.g(localObject, "inputHintDescTv");
    Context localContext = this.gGK.getContext();
    p.g(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766612));
    localObject = this.gXo;
    localContext = this.gGK.getContext();
    p.g(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(ao.e(localContext.getResources().getDrawable(2131691512), -1));
    AppMethodBeat.o(212629);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bg
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.live.b.f;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.t;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentCallback", "Lkotlin/Function1;", "", "", "inputHintDescTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "inputHintTv", "Landroid/view/View;", "inputImg", "Landroid/widget/ImageView;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "udpateBanCommentState", "plugin-logic_release"})
public final class bh
  extends a
{
  final b IIz;
  private final d.g.a.b<String, y> Kuz;
  private final ImageView Kxi;
  private final View Kxj;
  private final TextView Kxk;
  
  public bh(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(203102);
    this.IIz = paramb;
    this.Kxi = ((ImageView)paramViewGroup.findViewById(2131307555));
    this.Kxj = paramViewGroup.findViewById(2131307554);
    this.Kxk = ((TextView)paramViewGroup.findViewById(2131307552));
    this.Kuz = ((d.g.a.b)new a(this));
    fPb();
    this.Kxj.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203096);
        paramAnonymousView = f.rGw;
        if (f.eNG().LwF)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putString("mode", "input");
          this.Kxl.IIz.a(b.c.IId, paramAnonymousView);
          AppMethodBeat.o(203096);
          return;
        }
        t.makeText(paramViewGroup.getContext(), (CharSequence)com.tencent.mm.cd.a.aq(paramViewGroup.getContext(), 2131766691), 0).show();
        AppMethodBeat.o(203096);
      }
    });
    if (paramViewGroup.findViewById(2131298772) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-1, -1);
      paramb.bottomMargin = ap.eb(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131298772);
      k.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup = c.qYi;
    c.E(this.Kuz);
    AppMethodBeat.o(203102);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(203101);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (bi.ciE[paramc.ordinal()])
    {
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(203101);
        return;
        agK(8);
        AppMethodBeat.o(203101);
        return;
        agK(0);
        AppMethodBeat.o(203101);
        return;
        if (paramBundle != null) {}
        for (paramc = paramBundle.getString("mode"); paramc == null; paramc = null)
        {
          AppMethodBeat.o(203101);
          return;
        }
        switch (paramc.hashCode())
        {
        default: 
          break;
        case -318184504: 
          if (paramc.equals("preview"))
          {
            paramc = this.Kxj;
            k.g(paramc, "inputHintTv");
            paramc.setVisibility(0);
          }
          break;
        }
      }
    } while (!paramc.equals("input"));
    paramc = this.Kxj;
    k.g(paramc, "inputHintTv");
    paramc.setVisibility(4);
    AppMethodBeat.o(203101);
  }
  
  public final void fPb()
  {
    AppMethodBeat.i(203100);
    Object localObject = f.rGw;
    if (f.eNG().LwF)
    {
      localObject = this.Kxk;
      k.g(localObject, "inputHintDescTv");
      localContext = this.pTc.getContext();
      k.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766582));
      localObject = this.Kxi;
      localContext = this.pTc.getContext();
      k.g(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(am.e(localContext.getResources().getDrawable(2131691502), -1));
      AppMethodBeat.o(203100);
      return;
    }
    localObject = this.Kxk;
    k.g(localObject, "inputHintDescTv");
    Context localContext = this.pTc.getContext();
    k.g(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131766582));
    localObject = this.Kxi;
    localContext = this.pTc.getContext();
    k.g(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(am.e(localContext.getResources().getDrawable(2131691501), -1));
    AppMethodBeat.o(203100);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    a(bh parambh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.bh
 * JD-Core Version:    0.7.0.1
 */